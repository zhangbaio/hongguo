# -*- coding: utf-8 -*-
"""红果短剧 API 服务
部署在服务器,客户端连接后可搜索/看榜单/取剧集/拿视频直链。
签名由后端(Frida预言机/未来redroid/unidbg)提供,客户端无需签名。

启动: python server.py   (或 uvicorn server:app --host 0.0.0.0 --port 8000)

接口:
  GET /search?q=剧名
  GET /rank?board=recommend|hot|new&limit=30
  GET /filters?genre=comic_series         取某体裁全部筛选条件(实时)
  GET /browse?genre=ai_series&theme=玄幻&sort=hot_score&days=7   按筛选浏览(多选逗号分隔)
  GET /episodes?series_id=xxx
  GET /play?series_id=xxx&ep=1            取剧集信息(encrypted_url密文直链 + stream_url可播)
  GET /stream?series_id=xxx&ep=1          ★服务端【纯离线解密】后串流, 客户端拿到可播mp4
  GET /stream?vid=xxx&quality=1080p       也可直接按 vid + 清晰度; 支持 Range 拖动; <video>用?api_key=
"""
import re, os, io, time, threading, sys
from fastapi import FastAPI, HTTPException, Query, Depends, Request, Body
from fastapi.responses import StreamingResponse, JSONResponse, Response, FileResponse
import requests, urllib3
import hongguo as H

# 离线解密(纯算法, 无app): spade_a → content key → AES-128-CTR 解密
sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), "frida"))
import offline_decrypt as OD
import offline_dl as ODL

STREAM_CACHE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "downloads", ".stream_cache")
_dec_locks = {}; _dec_guard = threading.Lock()
def _dec_lock(key):
    with _dec_guard:
        return _dec_locks.setdefault(key, threading.Lock())

def _vm_track(vid, quality="best"):
    """取该集指定清晰度的 (main_url, spade_a, encrypt, definition, size)。"""
    vm = ODL._video_model(vid)
    if not vm:
        return None
    tracks = vm.get("video_list") if isinstance(vm, dict) else vm
    tr, defn, _ = ODL._pick_track(tracks, quality)
    if not tr:
        return None
    enc = tr.get("encrypt_info") or {}
    meta = tr.get("video_meta") or {}
    return {"url": tr.get("main_url"), "spade_a": enc.get("spade_a"),
            "encrypt": bool(enc.get("encrypt")),
            "definition": meta.get("definition") or defn, "size": meta.get("size", 0)}

def _ensure_decrypted(vid, quality="best"):
    """下载 CDN 密文 + 纯离线解密, 返回缓存的明文 mp4 路径(已缓存则直接返回)。"""
    os.makedirs(STREAM_CACHE, exist_ok=True)
    safe_q = re.sub(r"[^\w]", "", str(quality)) or "best"
    out = os.path.join(STREAM_CACHE, f"{vid}_{safe_q}.mp4")
    if os.path.exists(out) and os.path.getsize(out) > 0:
        return out
    with _dec_lock(f"{vid}_{safe_q}"):                  # 同集并发请求只解一次
        if os.path.exists(out) and os.path.getsize(out) > 0:
            return out
        t = _vm_track(vid, quality)
        if not t or not t["url"]:
            raise HTTPException(404, "无直链/video_model")
        if not t["encrypt"]:
            H.download_file(t["url"], out)
            return out
        ct = out + ".enc"
        H.download_file(t["url"], ct)
        r = OD.offline_decrypt(t["spade_a"], ct, out)
        try:
            os.remove(ct)
        except OSError:
            pass
        if not (r and os.path.exists(out) and os.path.getsize(out) > 0):
            raise HTTPException(500, "解密失败(spade 异常或 ver2 视频?)")
        return out

urllib3.disable_warnings()
app = FastAPI(title="红果短剧 API", version="1.0")

# 图片转换(HEIC->JPEG, 浏览器不支持HEIC)
try:
    from PIL import Image
    import pillow_heif
    pillow_heif.register_heif_opener()
    _IMG_OK = True
except Exception:
    _IMG_OK = False
_img_cache = {}
_IMG_HOSTS = ("fqnovelpic.com", "byteimg.com", "qznovelvod.com", "douyinpic.com", "pstatp.com")

# ---- 鉴权(强制) + 限流 + 密钥管理 ----
# 数据接口强制要求有效密钥(来自 apikeys.json, 经 /admin 管理); 客户端不带有效密钥=401。
# ADMIN_TOKEN: 进入 /admin 管理页/接口的口令(与普通密钥分离)。
from apikeys import KeyStore
_keys = KeyStore()
ADMIN_TOKEN = os.environ.get("ADMIN_TOKEN", "")
if not ADMIN_TOKEN:
    import secrets as _sec
    ADMIN_TOKEN = _sec.token_hex(8)
    print(f"[server] 未设 ADMIN_TOKEN, 临时生成: {ADMIN_TOKEN} (建议在 start_all.ps1 固定)")
RATE_PER_MIN = int(os.environ.get("RATE_PER_MIN", "120"))
_rl = {}
_rl_lock = threading.Lock()

# 免鉴权路径: 首页/网页/封面图/文档/管理页(管理页自己用 ADMIN_TOKEN 校验)
_EXEMPT = ("/", "/ui", "/img", "/docs", "/openapi.json", "/redoc", "/favicon.ico")
_ADMIN_PREFIX = "/admin"


def _check_admin(request: Request) -> bool:
    tok = request.headers.get("x-admin-token") or request.query_params.get("admin_token") or ""
    return bool(tok) and tok == ADMIN_TOKEN


@app.middleware("http")
async def auth_mw(request: Request, call_next):
    path = request.url.path
    if path == "/stats" or path.startswith(_ADMIN_PREFIX):
        # 管理/统计: 由各自处理器用 ADMIN_TOKEN 校验
        pass
    elif path not in _EXEMPT:
        key = request.headers.get("x-api-key") or request.query_params.get("api_key") or ""
        if not _keys.is_valid(key):            # 强制: 必须有效密钥
            _stats["auth_fail"] += 1
            return JSONResponse({"detail": "缺少或无效的 api_key(请在客户端配置本地链路密钥)"}, status_code=401)
        now = time.time()
        with _rl_lock:
            bucket = _rl.setdefault(key, [])
            while bucket and bucket[0] < now - 60:
                bucket.pop(0)
            if len(bucket) >= RATE_PER_MIN:
                return JSONResponse({"detail": f"超过限流 {RATE_PER_MIN}/分钟"}, status_code=429)
            bucket.append(now)
        _stats["requests"] += 1
    resp = await call_next(request)
    if resp.status_code >= 500:
        _stats["errors"] += 1
    return resp


def parse_range(ep, total):
    """'1' / '1-10' / 'all' -> 集号列表"""
    if not ep or ep == "all":
        return list(range(1, total + 1))
    m = re.match(r"(\d+)-(\d+)$", ep)
    if m:
        return list(range(int(m.group(1)), int(m.group(2)) + 1))
    if ep.isdigit():
        return [int(ep)]
    return []


_stats = {"start": time.time(), "requests": 0, "errors": 0, "risk": 0, "auth_fail": 0}


@app.get("/")
def index():
    return {"service": "红果短剧API", "ui": "/ui", "endpoints": [
        "/search?q=", "/rank?board=recommend|hot|new&limit=",
        "/latest?genre=short_play|comic_series|ai_series&only_today=true",
        "/filters?genre=comic_series", "/browse?genre=ai_series&theme=玄幻&sort=hot_score&days=7",
        "/episodes?series_id=", "/play?series_id=&ep=1-10",
        "/download?series_id=&ep=1-10", "/download/status?task_id=",
        "/stream?series_id=&ep=1 (解密可播)", "/stream?vid=&quality=1080p", "/stats"]}


@app.get("/stats")
def stats(request: Request):
    if not _check_admin(request):
        raise HTTPException(401, "需要 admin_token")
    import safeguards as SG
    up = int(time.time() - _stats["start"])
    # 签名后端健康
    backends = []
    for b in H.SIGN_SERVERS:
        try:
            rr = requests.get(b.rstrip("/") + "/", timeout=5).json()
            backends.append({"url": b, "ready": rr.get("ready"), "pid": rr.get("pid")})
        except Exception as e:
            backends.append({"url": b, "ready": False, "error": str(e)})
    return {"uptime_s": up, **{k: _stats[k] for k in ("requests", "errors", "risk", "auth_fail")},
            "cache_backend": "redis" if SG._redis else "memory",
            "sign_backends": backends,
            "download_tasks": len(H.manager().status())}


@app.get("/ui")
def ui():
    from fastapi.responses import FileResponse
    return FileResponse(os.path.join(os.path.dirname(os.path.abspath(__file__)), "web", "index.html"))


@app.get("/img")
def api_img(url: str):
    """图片代理。红果封面常返回 HEIC，浏览器不支持时转成 JPEG。"""
    from urllib.parse import urlparse
    try:
        raw = (url or "").strip()
        u = urlparse(raw)
        host = (u.hostname or "").lower()
        allowed = u.scheme in ("http", "https") and any(host == h or host.endswith("." + h) for h in _IMG_HOSTS)
        if not allowed:
            raise HTTPException(400, "图片域名不允许")
        cached = _img_cache.get(raw)
        if cached is not None:
            return Response(cached, media_type="image/jpeg", headers={"Cache-Control": "max-age=86400"})
        r = requests.get(raw, timeout=30, verify=False, headers={"User-Agent": "Mozilla/5.0"})
        r.raise_for_status()
        content_type = (r.headers.get("content-type") or "").lower()
        data = r.content
        if _IMG_OK and ("heic" in content_type or u.path.lower().endswith(".heic")):
            img = Image.open(io.BytesIO(data))
            if img.mode not in ("RGB", "L"):
                img = img.convert("RGB")
            out = io.BytesIO()
            img.save(out, format="JPEG", quality=88, optimize=True)
            data = out.getvalue()
            _img_cache[raw] = data
            return Response(data, media_type="image/jpeg", headers={"Cache-Control": "max-age=86400"})
        return Response(data, media_type=content_type or "image/jpeg", headers={"Cache-Control": "max-age=86400"})
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(404, f"图片读取失败: {e}")


# ---------------- 密钥管理(需 ADMIN_TOKEN) ----------------
def _mask(k: str) -> str:
    return (k[:6] + "****" + k[-4:]) if len(k) > 12 else "****"


@app.get("/admin")
def admin_page():
    from fastapi.responses import FileResponse
    return FileResponse(os.path.join(os.path.dirname(os.path.abspath(__file__)), "web", "admin.html"))


@app.get("/admin/keys")
def admin_list_keys(request: Request):
    if not _check_admin(request):
        raise HTTPException(401, "admin_token 无效")
    return {"keys": _keys.list(), "enabled_count": _keys.count_enabled()}


@app.post("/admin/keys")
def admin_gen_key(request: Request, note: str = ""):
    if not _check_admin(request):
        raise HTTPException(401, "admin_token 无效")
    key = _keys.generate(note)
    return {"ok": True, "key": key, "note": note}


@app.post("/admin/keys/revoke")
def admin_revoke_key(request: Request, key: str, enable: bool = False):
    if not _check_admin(request):
        raise HTTPException(401, "admin_token 无效")
    return {"ok": _keys.revoke(key, enabled=enable)}


@app.delete("/admin/keys")
def admin_delete_key(request: Request, key: str):
    if not _check_admin(request):
        raise HTTPException(401, "admin_token 无效")
    return {"ok": _keys.delete(key)}


@app.get("/img")
def img(url: str):
    """封面图代理: 拉取并把HEIC转JPEG(浏览器不支持HEIC)。仅限字节图片域名。"""
    from urllib.parse import urlparse
    host = urlparse(url).hostname or ""
    if not any(host.endswith(h) for h in _IMG_HOSTS):
        raise HTTPException(400, "host not allowed")
    if url in _img_cache:
        return Response(_img_cache[url], media_type="image/jpeg",
                        headers={"Cache-Control": "max-age=86400"})
    try:
        raw = requests.get(url, timeout=20, verify=False).content
        if _IMG_OK:
            im = Image.open(io.BytesIO(raw)).convert("RGB")
            buf = io.BytesIO(); im.save(buf, "JPEG", quality=82); raw = buf.getvalue()
        if len(_img_cache) < 1000:
            _img_cache[url] = raw
        return Response(raw, media_type="image/jpeg", headers={"Cache-Control": "max-age=86400"})
    except Exception as e:
        raise HTTPException(404, str(e))


@app.get("/search")
def api_search(q: str = Query(..., description="剧名"),
              limit: int = Query(None, ge=1, le=40, description="结果上限(越小越快; 默认走 HG_SEARCH_MAX_ITEMS=20)")):
    try:
        return {"query": q, "results": H.search(q, max_items=limit)}
    except Exception as e:
        raise HTTPException(500, f"search失败: {e}")


@app.get("/rank")
def api_rank(board: str = "recommend", limit: int = 30):
    if board not in H.RANK_BOARDS:
        raise HTTPException(400, f"board必须是 {list(H.RANK_BOARDS)}")
    try:
        return {"board": board, "name": H.RANK_NAMES.get(board), "items": H.rank(board, limit)}
    except Exception as e:
        raise HTTPException(500, f"rank失败: {e}")


@app.get("/latest")
def api_latest(genre: str = "short_play", only_today: bool = True, limit: int = 120, refresh: bool = False, no_cache: bool = False):
    """最新上架/今日上新。genre: short_play(短剧)|comic_series(漫剧)|ai_series(AI短剧)。
    短剧支持精确'今日上新'(官方标签); 漫剧/AI官方无今日粒度,返回'7天内上新·最新上架'。"""
    if genre not in H.GENRES:
        raise HTTPException(400, f"genre必须是 {list(H.GENRES)}")
    try:
        items = H.latest(genre, only_today=only_today, max_items=limit, refresh=refresh or no_cache)
        # 诚实标注模式
        if genre == "short_play":
            mode = "今日上新" if only_today else "最新上架"
        else:
            mode = "7天内上新·最新上架"
        return {"genre": genre, "name": H.GENRE_NAMES.get(genre), "mode": mode,
                "only_today": only_today, "count": len(items), "items": items}
    except Exception as e:
        raise HTTPException(500, f"latest失败: {e}")


@app.get("/filters")
def api_filters(genre: str = "short_play"):
    """取某体裁的全部筛选条件(实时面板)。genre: short_play|comic_series|ai_series。
    返回各维度(type=select_items键) + 选项(id/name)。漫剧多一维 creation_status(状态)。"""
    if genre not in H.GENRES:
        raise HTTPException(400, f"genre必须是 {list(H.GENRES)}")
    try:
        return {"genre": genre, "name": H.GENRE_NAMES.get(genre), "rows": H.filters(genre)}
    except Exception as e:
        raise HTTPException(500, f"filters失败: {e}")


@app.get("/browse")
def api_browse(genre: str = "ai_series", theme: str = None, setting: str = None,
               background: str = None, sort: str = "online_time", gender: str = None,
               days: str = None, status: str = None, limit: int = 60):
    """按筛选条件浏览。各维度传中文名或id; 多选用逗号分隔(如 theme=玄幻,科幻)。可选项见 /filters。
    theme主题 setting设定 background背景 sort排序 gender受众 days时间(7/14/30/90) status状态(仅漫剧:已完结/连载中)。"""
    if genre not in H.GENRES:
        raise HTTPException(400, f"genre必须是 {list(H.GENRES)}")
    def _csv(v):
        return [x.strip() for x in v.split(",") if x.strip()] if v else None
    try:
        items = H.browse(genre, theme=_csv(theme), setting=_csv(setting), background=_csv(background),
                         sort=sort, gender=gender, days=days, status=status, max_items=limit)
        for it in items:                                  # 补服务端可播/取集链接(剧级→播第1集)
            sid = it["series_id"]
            vid = it.get("vid")
            # 有 vid(7.2.5.32 列表项自带)→ 直接 /stream?vid= 省服务端一次 get_episodes
            it["stream_url"] = f"/stream?vid={vid}" if vid else f"/stream?series_id={sid}&ep=1"
            it["episodes_url"] = f"/episodes?series_id={sid}"     # 列全集(拿各集再 /stream?...&ep=N)
        return {"genre": genre, "name": H.GENRE_NAMES.get(genre), "count": len(items),
                "note": "stream_url=播第1集; 其它集用 episodes_url 取集号后 /stream?series_id=&ep=N", "items": items}
    except Exception as e:
        raise HTTPException(500, f"browse失败: {e}")


@app.get("/episodes")
def api_episodes(series_id: str):
    try:
        meta, eps = H.get_episodes(series_id)
        return {"meta": meta, "episodes": eps}
    except Exception as e:
        raise HTTPException(500, f"episodes失败: {e}")


@app.post("/metrics/batch")
def api_metrics_batch(payload: dict = Body(...)):
    """批量补齐指标和封面。series_ids 每批最多20个拼接调用真实 multi_video_detail。"""
    raw_ids = payload.get("series_ids") or payload.get("series_id") or []
    if isinstance(raw_ids, str):
        series_ids = [x.strip() for x in raw_ids.split(",") if x.strip()]
    else:
        series_ids = [str(x).strip() for x in raw_ids if str(x).strip()]
    if not series_ids:
        raise HTTPException(400, "series_ids不能为空")
    if len(series_ids) > 200:
        raise HTTPException(400, "series_ids最多200个")
    batch_size = int(payload.get("batch_size") or 20)
    try:
        items, failed = H.get_episodes_batch(series_ids, batch_size=batch_size)
        rows = [items[sid] for sid in series_ids if sid in items]
        return {"count": len(rows), "items": rows, "failed": failed, "batch_size": max(1, min(batch_size, 20))}
    except Exception as e:
        raise HTTPException(500, f"metrics batch失败: {e}")


@app.get("/play")
def api_play(series_id: str, ep: str = "all"):
    """返回剧集的真实视频直链(客户端可直接下载/播放,无需签名)"""
    try:
        meta, eps = H.get_episodes(series_id)
        want = set(parse_range(ep, len(eps)))
        sel = [e for e in eps if (e["index"] or 0) in want]
        urls = H.get_video_urls([e["vid"] for e in sel])
        out = []
        for e in sel:
            info = urls.get(e["vid"], {})
            out.append({"index": e["index"], "vid": e["vid"], "title": e["title"],
                        "duration": e["duration"],
                        # url 是 CDN 密文直链(CENC加密, 直接播放是花屏); 要可播用 stream_url(服务端已解密)
                        "encrypted_url": info.get("url"), "backup": info.get("backup"),
                        "size": info.get("size"), "definition": info.get("definition"),
                        "stream_url": f"/stream?vid={e['vid']}"})
        return {"series_id": series_id, "title": meta["title"],
                "note": "encrypted_url 为CENC密文直链; 可播放用 stream_url(服务端纯离线解密)", "episodes": out}
    except Exception as e:
        raise HTTPException(500, f"play失败: {e}")


@app.get("/download")
def api_download(series_id: str, ep: str = "all", ep_covers: bool = False):
    """提交下载任务到服务器本地(并发+断点续传)。返回 task_id, 用 /download/status 查进度。"""
    try:
        tid = H.manager().submit(series_id, ep, ep_covers)
        return {"task_id": tid, "status_url": f"/download/status?task_id={tid}"}
    except Exception as e:
        raise HTTPException(500, f"download失败: {e}")


@app.get("/download/status")
def api_download_status(task_id: str = None):
    return H.manager().status(task_id)


@app.get("/video_url")
def api_video_url(vid: str):
    """按单个 vid 取真实视频直链(供外部源模块调用)。"""
    try:
        urls = H.get_video_urls([vid])
        info = urls.get(str(vid)) or {}
        if not info.get("url"):
            raise HTTPException(404, "无直链")
        return {"vid": vid, "url": info.get("url"), "backup": info.get("backup"),
                "size": info.get("size"), "definition": info.get("definition")}
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(500, f"video_url失败: {e}")


@app.get("/stream")
def api_stream(series_id: str = None, ep: str = "1", vid: str = None, quality: str = "best"):
    """服务器代理串流单集 —— 已做【纯离线解密】, 客户端拿到的是可播 mp4(非密文)。
    用法: /stream?series_id=xxx&ep=1  或  /stream?vid=xxx  [&quality=1080p&api_key=...]
    首次会下载+解密并缓存(downloads/.stream_cache), 之后秒回; FileResponse 支持 Range 拖动。
    注: <video> 标签无法带请求头, 用 ?api_key= 传密钥。"""
    try:
        fname = None
        if not vid:
            if not series_id:
                raise HTTPException(400, "需 series_id+ep 或 vid")
            meta, eps = H.get_episodes(series_id)
            idx = int(ep) if str(ep).isdigit() else 1
            target = next((e for e in eps if (e["index"] or 0) == idx), None)
            if not target:
                raise HTTPException(404, "集号不存在")
            vid = target["vid"]
            fname = f"{H.sanitize(meta['title'])}_第{idx:03d}集.mp4"
        path = _ensure_decrypted(vid, quality)   # 下载密文+离线解密+缓存
        fname = fname or f"{vid}.mp4"
        from urllib.parse import quote as _q
        cd = f"inline; filename=\"{vid}.mp4\"; filename*=UTF-8''{_q(fname)}"
        # FileResponse 自动处理 HTTP Range(206), 支持播放器 seek
        return FileResponse(path, media_type="video/mp4", headers={"Content-Disposition": cd})
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(500, f"stream失败: {e}")


if __name__ == "__main__":
    import uvicorn
    # 默认只绑本机(脱机直连由同机 xinge 走 127.0.0.1 调); 需对外可设 BIND_HOST=0.0.0.0
    uvicorn.run(app, host=os.environ.get("BIND_HOST", "127.0.0.1"), port=int(os.environ.get("PORT", "8000")))
