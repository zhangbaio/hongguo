# -*- coding: utf-8 -*-
"""红果短剧 API 服务
部署在服务器,客户端连接后可搜索/看榜单/取剧集/拿视频直链。
签名由后端(Frida预言机/未来redroid/unidbg)提供,客户端无需签名。

启动: python server.py   (或 uvicorn server:app --host 0.0.0.0 --port 8000)

接口:
  GET /search?q=剧名
  GET /rank?board=recommend|hot|new&limit=30
  GET /episodes?series_id=xxx
  GET /play?series_id=xxx&ep=1            取单集直链
  GET /play?series_id=xxx&ep=1-10         取多集直链
  GET /stream?series_id=xxx&ep=1          服务器代理串流(客户端直接播放/下载)
"""
import re, os, io, time, threading
from fastapi import FastAPI, HTTPException, Query, Depends, Request
from fastapi.responses import StreamingResponse, JSONResponse, Response
import requests, urllib3
import hongguo as H

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
        "/episodes?series_id=", "/play?series_id=&ep=1-10",
        "/download?series_id=&ep=1-10", "/download/status?task_id=",
        "/stream?series_id=&ep=1", "/stats"]}


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
def api_search(q: str = Query(..., description="剧名")):
    try:
        return {"query": q, "results": H.search(q)}
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
def api_latest(genre: str = "short_play", only_today: bool = True, limit: int = 120):
    """最新上架/今日上新。genre: short_play(短剧)|comic_series(漫剧)|ai_series(AI短剧)。
    短剧支持精确'今日上新'(官方标签); 漫剧/AI官方无今日粒度,返回'7天内上新·最新上架'。"""
    if genre not in H.GENRES:
        raise HTTPException(400, f"genre必须是 {list(H.GENRES)}")
    try:
        items = H.latest(genre, only_today=only_today, max_items=limit)
        # 诚实标注模式
        if genre == "short_play":
            mode = "今日上新" if only_today else "最新上架"
        else:
            mode = "7天内上新·最新上架"
        return {"genre": genre, "name": H.GENRE_NAMES.get(genre), "mode": mode,
                "only_today": only_today, "count": len(items), "items": items}
    except Exception as e:
        raise HTTPException(500, f"latest失败: {e}")


@app.get("/episodes")
def api_episodes(series_id: str):
    try:
        meta, eps = H.get_episodes(series_id)
        return {"meta": meta, "episodes": eps}
    except Exception as e:
        raise HTTPException(500, f"episodes失败: {e}")


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
                        "duration": e["duration"], "url": info.get("url"),
                        "backup": info.get("backup"), "size": info.get("size"),
                        "definition": info.get("definition")})
        return {"series_id": series_id, "title": meta["title"], "episodes": out}
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
def api_stream(series_id: str, ep: str = "1"):
    """服务器代理串流单集(客户端不便直连CDN时用)。支持边下边传。"""
    try:
        meta, eps = H.get_episodes(series_id)
        idx = int(ep) if ep.isdigit() else 1
        target = next((e for e in eps if (e["index"] or 0) == idx), None)
        if not target:
            raise HTTPException(404, "集号不存在")
        urls = H.get_video_urls([target["vid"]])
        info = urls.get(target["vid"])
        if not info or not info["url"]:
            raise HTTPException(404, "无直链")
        upstream = requests.get(info["url"], stream=True, verify=False, timeout=60)
        from urllib.parse import quote as _q
        fname = f"{H.sanitize(meta['title'])}_第{idx:03d}集.mp4"
        cd = f"attachment; filename=\"ep{idx:03d}.mp4\"; filename*=UTF-8''{_q(fname)}"
        return StreamingResponse(
            upstream.iter_content(262144),
            media_type="video/mp4",
            headers={"Content-Disposition": cd,
                     "Content-Length": upstream.headers.get("content-length", "")})
    except HTTPException:
        raise
    except Exception as e:
        raise HTTPException(500, f"stream失败: {e}")


if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)
