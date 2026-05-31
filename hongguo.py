# -*- coding: utf-8 -*-
"""红果短剧下载器 (命令行)
依赖: Frida 签名预言机(模拟器后台运行红果 + frida-server)。

用法:
  python hongguo.py search "极品皇太子"          # 搜索,列出剧
  python hongguo.py episodes <series_id>          # 列出某剧全部剧集
  python hongguo.py rank [recommend|hot|new] [数量]  # 漫剧榜单(推荐/热播/新剧)
  python hongguo.py latest [short_play|comic_series|ai_series] [--all]  # 今日上新(--all=最新上架全部)
  python hongguo.py download <series_id> [集号范围]  # 下载,如 1-10 或 all(默认all)

例: python hongguo.py download 7638207474180312089 1-3
"""
import sys, os, json, time, hashlib, re, subprocess, threading
import urllib3
import requests
try:
    import frida  # 仅本地进程内签名(CLI模式)需要; 设了 SIGN_SERVER 走HTTP时可无
except Exception:
    frida = None
import safeguards as SG
from safeguards import RiskControlError, AuthExpiredError
import downloader as DL

urllib3.disable_warnings()
HERE = os.path.dirname(os.path.abspath(__file__))
CFG = json.load(open(os.path.join(HERE, "config.json"), encoding="utf-8"))
# ADB 路径与设备可用环境变量覆盖(容器/Linux部署用); 默认本机 MuMu
ADB = os.environ.get("ADB", r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe")
DEV = os.environ.get("ADB_DEVICE", "127.0.0.1:16384")
FRIDA_HOST = os.environ.get("FRIDA_HOST", "127.0.0.1:27042")
HOST = CFG["api_host"]
OUT_DIR = os.path.join(HERE, "downloads")

# 详情接口 biz_param 里的图片缩放常量(抓包里的固定值)
IMAGE_SHRINK = ("W3siaW1hZ2VfdHlwZSI6MywiaW1hZ2Vfd2lkdGgiOjkwMCwic2hyaW5rX3R5cGUiOjN9LHsiaW1h\n"
                "Z2VfdHlwZSI6NCwiaW1hZ2Vfd2lkdGgiOjU0LCJzaHJpbmtfdHlwZSI6NH1d\n")


class Oracle:
    """Frida 签名预言机"""
    def __init__(self):
        pid = int(subprocess.run([ADB, "-s", DEV, "shell", "pidof", "com.phoenix.read"],
                                 capture_output=True, text=True).stdout.split()[0])
        dev = frida.get_device_manager().add_remote_device(FRIDA_HOST)
        self.session = dev.attach(pid)
        self.script = self.session.create_script(
            open(os.path.join(HERE, "frida", "oracle.js"), encoding="utf-8").read())
        self.script.load()

    def sign(self, url, headers):
        return self.script.exports_sync.sign(url, headers)


_oracle = None
_oracle_lock = threading.Lock()
def oracle():
    global _oracle
    if _oracle is None:
        with _oracle_lock:
            if _oracle is None:
                _oracle = Oracle()
    return _oracle


# 签名后端: SIGN_SERVER 可逗号分隔多个(多设备池),轮询+故障转移以分摊负载降风控。
# 如 "http://127.0.0.1:8001,http://127.0.0.1:8002"。为空则进程内Frida(CLI模式)。
SIGN_SERVERS = [s.strip() for s in (os.environ.get("SIGN_SERVER") or "").split(",") if s.strip()]
_sign_rr = [0]
_sign_rr_lock = threading.Lock()


def _next_sign_server():
    with _sign_rr_lock:
        i = _sign_rr[0] % len(SIGN_SERVERS)
        _sign_rr[0] = (_sign_rr[0] + 1) % max(1, len(SIGN_SERVERS))
        return SIGN_SERVERS[i]


def sign(url, headers):
    """签名。多签名服务轮询+故障转移; 无配置则进程内Frida。"""
    if SIGN_SERVERS:
        errs = []
        for _ in range(len(SIGN_SERVERS)):
            base = _next_sign_server()
            try:
                r = requests.post(base.rstrip("/") + "/sign",
                                  json={"url": url, "headers": headers}, timeout=40)
                r.raise_for_status()
                j = r.json()
                if "error" in j:
                    raise RuntimeError(j["error"])
                return j
            except Exception as e:
                errs.append(f"{base}: {e}")
        raise RuntimeError("所有签名服务失败: " + "; ".join(errs))
    with _oracle_lock:
        return oracle().sign(url, headers)


_refresh_lock = threading.Lock()
_last_refresh = 0


def refresh_session():
    """登录态过期时,从签名服务 /grab 抓取 app 当前的新鲜 token/设备参数,更新 CFG。"""
    global _last_refresh
    with _refresh_lock:
        if time.time() - _last_refresh < 20:  # 防抖,避免并发重复刷新
            return
        if not SIGN_SERVERS:
            return
        try:
            r = requests.get(SIGN_SERVERS[0].rstrip("/") + "/grab", timeout=60)
            data = r.json()
            if "error" in data:
                print("[refresh] grab失败:", data["error"]); return
            from urllib.parse import urlparse, parse_qsl
            q = dict(parse_qsl(urlparse(data["url"]).query))
            DEVICE_KEYS = set(CFG["base_query"].keys()) | {
                "iid", "device_id", "cdid", "klink_egdi", "channel", "update_version_code"}
            for k in DEVICE_KEYS:
                if k in q and q[k]:
                    CFG["base_query"][k] = q[k]
            for k, v in (data.get("headers") or {}).items():
                kl = k.lower()
                if kl in ("cookie", "x-tt-token", "x-tt-store-region", "x-tt-store-region-src") and v:
                    CFG["session_headers"][kl] = v.strip("[]")
            _last_refresh = time.time()
            # 落盘
            try:
                json.dump(CFG, open(os.path.join(HERE, "config.json"), "w", encoding="utf-8"),
                          ensure_ascii=False, indent=2)
            except Exception:
                pass
            print("[refresh] 登录态已刷新, token长度=%d" % len(CFG["session_headers"].get("x-tt-token", "")))
        except Exception as e:
            print("[refresh] 异常:", e)


def build_url(path, extra=None):
    q = dict(CFG["base_query"])
    if extra:
        q.update(extra)
    q["_rticket"] = str(int(time.time() * 1000))
    qs = "&".join(f"{k}={requests.utils.quote(str(v), safe='')}" for k, v in q.items())
    return f"https://{HOST}{path}?{qs}"


def _api_once(method, path, body, extra_query):
    url = build_url(path, extra_query)
    headers = dict(CFG["session_headers"])
    headers["content-type"] = "application/json; charset=utf-8"
    data = None
    if body is not None:
        data = json.dumps(body, ensure_ascii=False, separators=(",", ":")).encode("utf-8")
        headers["x-ss-stub"] = hashlib.md5(data).hexdigest().upper()
    sec = sign(url, headers)              # 预言机生成新鲜签名
    headers.update(sec)
    headers.pop("accept-encoding", None)
    SG.throttle.wait()                    # 节流
    r = requests.request(method, url, data=data, headers=headers, verify=False, timeout=30)
    j = r.json()
    SG.check_response(j)                  # 风控/登录态识别
    return j


def api(method, path, body=None, extra_query=None, max_retries=3):
    """带签名的 API 调用,含重试退避 + 登录态自动刷新。"""
    last = None
    for attempt in range(max_retries):
        try:
            return _api_once(method, path, body, extra_query)
        except AuthExpiredError as e:
            last = e
            print(f"[api] 登录态失效,刷新后重试 ({path})")
            refresh_session()
            time.sleep(1)
        except RiskControlError as e:
            last = e
            wait = 2 ** attempt + 1
            print(f"[api] 风控/异常,退避{wait}s重试 ({path}): {e}")
            time.sleep(wait)
        except (requests.RequestException, ValueError) as e:  # 网络/JSON错误
            last = e
            time.sleep(1.5 * (attempt + 1))
    raise last if last else RuntimeError("api 失败")


def search(query):
    ck = SG.cache_key("search", query)
    cached = SG.cache_get(ck)
    if cached is not None:
        return cached
    j = api("GET", "/reading/bookapi/search/tab/v",
            extra_query={"query": query, "tab_name": "feed", "search_source": "1",
                         "offset": "0", "count": "0", "use_correct": "true"})
    results = []
    for tab in j.get("search_tabs", []):
        for cell in tab.get("data", []):
            sid = cell.get("book_id") or cell.get("search_result_id")
            if not sid:
                continue
            vd = cell.get("video_detail") or {}
            # video_data 可能是数组或对象
            vdata = cell.get("video_data")
            if isinstance(vdata, list) and vdata:
                vdata = vdata[0]
            elif not isinstance(vdata, dict):
                vdata = {}
            inner = vdata.get("video_detail") or {}  # video_data[0].video_detail
            ep = vd.get("episode_cnt") or vdata.get("episode_cnt") or inner.get("episode_cnt") or 0
            if not ep:
                continue  # 只要短剧(有集数的)
            hl = cell.get("search_high_light", {}).get("title", {}).get("text")
            title = re.sub("<[^>]+>", "", hl or vd.get("series_title") or vdata.get("title") or inner.get("series_title") or "")
            results.append({
                "series_id": sid,
                "title": title,
                "episode_cnt": ep,
                "score": vdata.get("score") or inner.get("score") or "",
                "play_cnt": vdata.get("play_cnt") or inner.get("series_play_cnt") or 0,
                "hot": vdata.get("rec_text") or "",
                "copyright": vdata.get("copyright") or "",
                "cover": vdata.get("cover") or inner.get("series_cover") or "",
                "intro": (inner.get("series_intro") or vd.get("series_intro") or "")[:60],
            })
        break  # 只看综合tab
    # 去重
    seen, uniq = set(), []
    for r in results:
        if r["series_id"] in seen:
            continue
        seen.add(r["series_id"]); uniq.append(r)
    SG.cache_set(ck, uniq, ttl=600)  # 搜索结果缓存10分钟
    return uniq


def get_episodes(series_id):
    body = {"biz_param": {"detail_page_version": 0, "disable_digg_stat": False,
                          "disable_video_relate_book": False, "image_shrink_datas_str": IMAGE_SHRINK,
                          "need_all_video_definition": False, "need_mp4_align": False,
                          "screen_width_px": "900", "source": 7, "use_os_player": False,
                          "use_server_dns": False},
            "series_id": str(series_id)}
    ck = SG.cache_key("episodes", str(series_id))
    cached = SG.cache_get(ck)
    if cached is not None:
        return cached
    j = api("POST", "/novel/player/multi_video_detail/v1/", body=body)
    data = j.get("data", {})
    sid = str(series_id)
    vd = data.get(sid, {}).get("video_data", {})
    eps = []
    for e in vd.get("video_list", []):
        eps.append({"index": e.get("vid_index"), "vid": e.get("vid"),
                    "title": e.get("title", "")[:30], "duration": e.get("duration"),
                    "cover": e.get("episode_cover") or e.get("cover") or "",
                    "comment_count": e.get("comment_count", 0),
                    "digged_count": e.get("digged_count", 0)})
    eps.sort(key=lambda x: x["index"] or 0)
    # 整剧元数据
    celebs = [{"演员": c.get("nickname"), "角色": c.get("role_name"),
               "头像": c.get("avatar"), "简介": (c.get("intro") or "")[:80]}
              for c in vd.get("celebrities", [])]
    meta = {
        "series_id": sid,
        "title": vd.get("series_title", sid),
        "intro": vd.get("series_intro", ""),
        "episode_cnt": vd.get("episode_cnt", len(eps)),
        "status": "完结" if vd.get("series_status") == 1 else "连载中",
        "play_cnt": vd.get("series_play_cnt", 0),
        "followed_cnt": vd.get("followed_cnt", 0),
        "create_time": vd.get("create_time", 0),
        "cover": vd.get("series_cover", ""),
        "category": re.findall(r'"name":"([^"]+)"', vd.get("category_schema", "")),
        "celebrities": celebs,
    }
    SG.cache_set(ck, (meta, eps), ttl=21600)  # 剧集列表缓存6小时
    return meta, eps


def get_video_urls(vids, force=False):
    """批量取视频直链。返回 {vid: {"url":, "size":, "definition":}}
    每个vid的直链缓存5小时(url_expire约6h),命中则不重复调video_model,大幅降低风控。
    force=True 跳过缓存强制重取(续传时直链过期用)。"""
    out = {}
    todo = []
    for v in vids:
        c = None if force else SG.cache_get(SG.cache_key("vmodel", str(v)))
        if c is not None:
            out[str(v)] = c
        else:
            todo.append(v)
    # 只对未缓存的分批请求,每批5个(贴近app真实批量大小)
    for i in range(0, len(todo), 5):
        batch = [str(v) for v in todo[i:i+5]]
        body = {"biz_param": {"detail_page_version": 0, "device_level": 3,
                              "disable_digg_stat": False, "disable_video_relate_book": False,
                              "need_all_video_definition": True, "need_mp4_align": False,
                              "use_os_player": False, "use_server_dns": False, "video_platform": 1024},
                "mixed_video_id_map": {"1": batch}}
        j = api("POST", "/novel/player/multi_video_model/v1/", body=body)
        for vid, v in (j.get("data") or {}).items():
            vm = v.get("video_model")
            if not vm:
                continue
            vmj = json.loads(vm)
            best = None
            for item in vmj.get("video_list", []):
                meta = item.get("video_meta", {})
                size = meta.get("size", 0)
                if best is None or size > best["size"]:
                    best = {"url": item.get("main_url"), "backup": item.get("backup_url"),
                            "size": size, "definition": meta.get("definition", "?")}
            if best:
                out[vid] = best
                SG.cache_set(SG.cache_key("vmodel", vid), best, ttl=18000)  # 直链缓存5小时
    return out


import uuid, datetime


def _is_today_ts(ts):
    """unix秒是否为今天(中国时区UTC+8)"""
    if not ts:
        return False
    d = (datetime.datetime.utcfromtimestamp(ts) + datetime.timedelta(hours=8)).date()
    now = (datetime.datetime.utcnow() + datetime.timedelta(hours=8)).date()
    return d == now


# 漫剧榜单(tab_type=26). 三个榜单靠 sub_selected_items 区分
COMIC_RANK_CELL = "7470092475068071998"
RANK_BOARDS = {
    "recommend": "comic_series_hot_rank",   # 推荐榜(匹配app截图内容)
    "hot": "comic_series_hot_play",         # 热播榜
    "new": "comic_series_new_rank",         # 新剧榜
}
RANK_NAMES = {"recommend": "漫剧推荐榜", "hot": "漫剧热播榜", "new": "漫剧新剧榜"}


def rank(board="recommend", limit=30):
    """获取漫剧榜单。board: recommend/hot/new。返回排名列表。"""
    ck = SG.cache_key("rank", board, limit)
    cached = SG.cache_get(ck)
    if cached is not None:
        return cached
    sub = RANK_BOARDS.get(board, board)
    results, offset, sess = [], 0, str(uuid.uuid4())
    while len(results) < limit:
        q = {"cell_id": COMIC_RANK_CELL, "tab_type": "26", "client_req_type": "2",
             "client_template": "2", "screen_width_px": "1350",
             "selected_items": "comic_series_rank", "sub_selected_items": sub,
             "session_uuid": sess}
        if offset:
            q["offset"] = str(offset)
        j = api("GET", "/reading/bookapi/bookmall/cell/change/v", extra_query=q)
        cv = j.get("data", {}).get("cell_view", {})
        cells = cv.get("cell_data", [])
        if not cells:
            break
        for item in cells:
            v = item.get("video_data")
            if isinstance(v, list):
                v = v[0] if v else {}
            sid = v.get("series_id") or v.get("book_id")
            if not sid:
                continue
            results.append({
                "rank": len(results) + 1,
                "series_id": str(sid),
                "title": v.get("title", ""),
                "episode_cnt": v.get("episode_cnt", 0),
                "score": v.get("score", ""),
                "play_cnt": v.get("play_cnt", 0),
                "hot": v.get("rec_text") or "",
                "copyright": v.get("copyright", ""),
                "cover": v.get("cover", ""),
                "intro": (v.get("video_desc") or "")[:50],
            })
        if not cv.get("has_more"):
            break
        offset = cv.get("next_offset", offset + len(cells))
    results = results[:limit]
    SG.cache_set(ck, results, ttl=1800)  # 榜单缓存30分钟
    return results


# 体裁 -> (req_scene, genre)
GENRES = {
    "short_play": ("default", "short_play"),      # 短剧
    "comic_series": ("comic_series", "comic_series"),  # 漫剧
    "ai_series": ("ai_series", "ai_series"),       # AI短剧
}
GENRE_NAMES = {"short_play": "短剧", "comic_series": "漫剧", "ai_series": "AI短剧"}


def latest(genre="short_play", only_today=True, max_items=120):
    """最新上架。
    - 短剧(short_play): 官方有'今日上新'标签。only_today=True 精确返回今日上新(扫描多页,
      整页无今日才停,处理交错); False 返回最新上架全部。
    - 漫剧/AI(comic_series/ai_series): 官方无'今日'粒度(最细7天)且不暴露上线时间,
      统一返回'7天内上新·最新上架'(days_7筛选+上线时间降序,顶部最新)。only_today 不影响结果,
      item.today 字段对这两类恒为 False(无法判定)。
    """
    if genre not in GENRES:
        raise ValueError(f"genre必须是 {list(GENRES)}")
    ck = SG.cache_key("latest", genre, only_today, max_items)
    cached = SG.cache_get(ck)
    if cached is not None:
        return cached
    scene, g = GENRES[genre]
    tag_today = (genre == "short_play")             # 仅短剧有'今日上新'标签
    online_time = [] if tag_today else ["days_7"]   # 漫剧/AI 用官方最细7天筛选
    want_today = tag_today and only_today
    out, shown, offset, pages = [], [], 0, 0
    while len(out) < max_items and pages < 20:
        body = {"filter_ids": ",".join(shown), "req_scene": scene, "offset": offset,
                "need_selector_panel": False, "limit": 18,
                "select_items": {"category_dim_epoch": [], "online_time": online_time, "gender": [],
                                 "category_dim_role": [], "genre": [g], "sort": ["online_time"],
                                 "category_dim_theme": []},
                "session_id": "", "req_type": "only_content", "client_req_type": 3}
        j = api("POST", "/reading/distribution/category/landpage/v", body=body)
        items = j.get("data", {}).get("video_data", [])
        if not items:
            break
        page_today = 0
        for it in items:
            sid = str(it.get("series_id"))
            shown.append(sid)
            subs = [s.get("content") for s in (it.get("sub_title_list") or [])]
            is_today = "今日上新" in subs
            if is_today:
                page_today += 1
            cat = next((s for s in subs if s and s != "今日上新" and not re.match(r"^[\d.]+万", s)), "")
            if want_today and not is_today:
                continue  # 短剧今日模式: 跳过非今日(仍扫完本页)
            out.append({"series_id": sid, "title": it.get("title", ""),
                        "episode_cnt": it.get("episode_cnt", 0), "score": it.get("score", ""),
                        "play_cnt": it.get("play_cnt", 0), "cover": it.get("cover", ""),
                        "category": cat, "today": is_today,
                        "premiere": (it.get("tag_info") or {}).get("text", ""),
                        "intro": (it.get("video_desc") or "")[:50]})
            if len(out) >= max_items:
                break
        pages += 1
        if want_today and page_today == 0:   # 短剧今日: 整页无今日 => 已过今日簇,停
            break
        if not j.get("data", {}).get("has_more", True):
            break
        offset += len(items)
    SG.cache_set(ck, out, ttl=1800)  # 缓存30分钟
    return out


def sanitize(name):
    return re.sub(r'[\\/:*?"<>|]', "_", name).strip()[:60]


def img_ext(url):
    """从图片URL推断扩展名"""
    path = url.split("?")[0].lower()
    for e in (".heic", ".jpeg", ".jpg", ".webp", ".png"):
        if path.endswith(e):
            return e
    return ".jpg"


def download_image(url, path):
    try:
        r = requests.get(url, verify=False, timeout=30)
        r.raise_for_status()
        with open(path, "wb") as f:
            f.write(r.content)
        return True
    except Exception as ex:
        print(f"    封面下载失败: {ex}")
        return False


def download_file(url, path):
    tmp = path + ".part"
    with requests.get(url, stream=True, verify=False, timeout=60) as r:
        r.raise_for_status()
        total = int(r.headers.get("content-length", 0))
        done = 0
        last_pct = -1
        with open(tmp, "wb") as f:
            for chunk in r.iter_content(262144):
                f.write(chunk)
                done += len(chunk)
                if total:
                    pct = done * 100 // total
                    if pct != last_pct and pct % 10 == 0:  # 每10%打一次
                        print(f"    {pct}% ({done//1024}/{total//1024} KB)")
                        last_pct = pct
    os.replace(tmp, path)


_dm = None
def manager(concurrency=3):
    global _dm
    if _dm is None:
        _dm = DL.DownloadManager(get_episodes, get_video_urls, OUT_DIR, concurrency=concurrency)
    return _dm


def cmd_download(series_id, rng="all", ep_covers=False):
    """命令行下载: 用下载管理器(并发+断点续传),轮询进度。"""
    dm = manager()
    tid = dm.submit(series_id, rng, ep_covers)
    last = ""
    while True:
        t = dm.status(tid)
        st = t.get("state", "")
        line = f"[{st}] {t.get('done',0)}/{t.get('total',0)} 完成, 失败{t.get('failed',0)}"
        if line != last:
            print(line); last = line
        if st.startswith("完成") or st.startswith("错误"):
            break
        time.sleep(1.5)
    print("->", t.get("folder", ""))


def cmd_download_old(series_id, rng="all", ep_covers=False):
    meta, eps = get_episodes(series_id)
    title = sanitize(meta["title"])
    print(f"《{title}》共 {len(eps)} 集 | {meta['status']} | {meta['play_cnt']}播放 | 标签:{'/'.join(meta['category'])}")
    folder = os.path.join(OUT_DIR, title)
    os.makedirs(folder, exist_ok=True)
    # 保存元数据
    with open(os.path.join(folder, "info.json"), "w", encoding="utf-8") as f:
        json.dump({**meta, "episodes": eps}, f, ensure_ascii=False, indent=2)
    # 下载剧封面
    if meta.get("cover"):
        cov = os.path.join(folder, f"cover{img_ext(meta['cover'])}")
        if not os.path.exists(cov):
            print("  下载封面...")
            download_image(meta["cover"], cov)
    # 解析集号范围
    if rng != "all":
        m = re.match(r"(\d+)-(\d+)", rng)
        if m:
            lo, hi = int(m.group(1)), int(m.group(2))
            eps = [e for e in eps if lo <= (e["index"] or 0) <= hi]
        elif rng.isdigit():
            eps = [e for e in eps if (e["index"] or 0) == int(rng)]
    vids = [e["vid"] for e in eps]
    print(f"获取 {len(vids)} 集的视频直链...")
    urls = get_video_urls(vids)
    for e in eps:
        # 每集封面(可选)
        if ep_covers and e.get("cover"):
            ec = os.path.join(folder, f"{title}_第{e['index']:03d}集{img_ext(e['cover'])}")
            if not os.path.exists(ec):
                download_image(e["cover"], ec)
        info = urls.get(e["vid"])
        if not info or not info["url"]:
            print(f"  第{e['index']}集: 无直链,跳过")
            continue
        fn = os.path.join(folder, f"{title}_第{e['index']:03d}集.mp4")
        if os.path.exists(fn) and os.path.getsize(fn) > 0:
            print(f"  第{e['index']}集: 已存在,跳过")
            continue
        print(f"  第{e['index']}集 [{info['definition']}, {info['size']//1024}KB] -> {os.path.basename(fn)}")
        try:
            download_file(info["url"], fn)
        except Exception as ex:
            print(f"    下载失败: {ex}")
    print(f"完成 -> {folder}")


def main():
    if len(sys.argv) < 2:
        print(__doc__); return
    cmd = sys.argv[1]
    if cmd == "search":
        for r in search(sys.argv[2]):
            hot = f" {r['hot']}" if r['hot'] else f" {r['play_cnt']}播放"
            score = f" ★{r['score']}" if r['score'] else ""
            print(f"  {r['series_id']}  [{r['episode_cnt']}集]{score}{hot}  {r['title']}")
            if r['intro']:
                print(f"      {r['intro']}  | 出品:{r['copyright']}")
    elif cmd == "episodes":
        meta, eps = get_episodes(sys.argv[2])
        print(f"《{meta['title']}》{meta['episode_cnt']}集 | {meta['status']} | {meta['play_cnt']}播放 | 标签:{'/'.join(meta['category'])}")
        if meta["celebrities"]:
            print("  主演: " + "、".join(f"{c['演员']}({c['角色']})" for c in meta["celebrities"][:6]))
        print(f"  简介: {meta['intro'][:80]}")
        for e in eps[:200]:
            print(f"  {e['index']:>3}  vid={e['vid']}  {e['duration']}s  赞{e['digged_count']}  {e['title']}")
    elif cmd == "latest":
        genre = sys.argv[2] if len(sys.argv) > 2 else "short_play"
        only_today = "--all" not in sys.argv
        items = latest(genre, only_today=only_today, max_items=300)
        if genre == "short_play":
            tag = "今日上新" if only_today else "最新上架"
        else:
            tag = "7天内上新·最新上架"
        print(f"=== {GENRE_NAMES.get(genre, genre)} · {tag} ({len(items)}部) ===")
        for it in items:
            print(f"  [{it['episode_cnt']}集] ★{it['score']} {it['play_cnt']}播放 [{it['category']}] {it['title']}  (id={it['series_id']})")
    elif cmd == "rank":
        board = sys.argv[2] if len(sys.argv) > 2 else "recommend"
        limit = int(sys.argv[3]) if len(sys.argv) > 3 else 30
        print(f"=== {RANK_NAMES.get(board, board)} ===")
        for r in rank(board, limit):
            hot = r['hot'] or f"{r['play_cnt']}播放"
            score = f" ★{r['score']}" if r['score'] else ""
            print(f"  {r['rank']:>2}. [{r['episode_cnt']}集]{score} {hot}  {r['title']}  (id={r['series_id']})")
    elif cmd == "download":
        rng = "all"
        ep_covers = "--ep-covers" in sys.argv
        for a in sys.argv[3:]:
            if not a.startswith("--"):
                rng = a; break
        cmd_download(sys.argv[2], rng, ep_covers)
    else:
        print(__doc__)


if __name__ == "__main__":
    main()
