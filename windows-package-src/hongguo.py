# -*- coding: utf-8 -*-
"""红果短剧下载器 (命令行)
依赖: Frida 签名预言机(模拟器后台运行红果 + frida-server)。

用法:
  python hongguo.py search "极品皇太子"          # 搜索,列出剧
  python hongguo.py episodes <series_id>          # 列出某剧全部剧集
  python hongguo.py rank [recommend|hot|new] [数量]  # 漫剧榜单(推荐/热播/新剧)
  python hongguo.py latest [short_play|comic_series|ai_series] [--all]  # 今日上新(--all=最新上架全部)
  python hongguo.py filters [short_play|comic_series|ai_series]   # 列出该体裁全部筛选条件(及参数id)
  python hongguo.py browse <体裁> [--theme 主题][--setting 设定][--bg 背景][--sort 排序][--gender 受众][--status 状态(仅漫剧)][--days 7][--n 60]
  python hongguo.py download <series_id> [集号范围]  # 下载,如 1-10 或 all(默认all)

例: python hongguo.py download 7638207474180312089 1-3
例: python hongguo.py browse ai_series --theme 玄幻 --setting 逆袭 --sort hot_score --days 7
程序内: filters(genre) / browse(genre, theme=, setting=, background=, sort=, gender=, days=, max_items=)
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
import devicepool

# ---------------- HTTP 层: 可选 curl_cffi 指纹伪装(JA3)+ 代理 ----------------
# 仅作用于"对红果API / 字节CDN"的外部请求; 对本机签名服务(sign/grab)不伪装不走代理。
#   IMPERSONATE   : curl_cffi impersonate 目标(如 chrome / chrome120 / chrome131_android)。
#                   空字符串 = 禁用伪装, 退回原生 requests。
#   HONGGUO_PROXY : 外部请求代理(http://host:port 或 socks5://user:pass@host:port)。空 = 直连。
IMPERSONATE = os.environ.get("IMPERSONATE", "chrome")
HONGGUO_PROXY = os.environ.get("HONGGUO_PROXY", "").strip()
try:
    from curl_cffi import requests as _cffi          # 指纹伪装(可选依赖)
    _HAS_CFFI = True
except Exception:
    _cffi = None
    _HAS_CFFI = False


def _ext_proxies():
    return {"http": HONGGUO_PROXY, "https": HONGGUO_PROXY} if HONGGUO_PROXY else None


# 连接复用: 线程本地持久 Session(keep-alive+连接池)。requests/curl_cffi 的 Session 非跨线程安全,
# 故每线程一个(适配 FastAPI 线程池 + 下载 ThreadPoolExecutor)。消除每请求 TCP+TLS 握手。
import threading as _th
_tls = _th.local()


def _ext_session():
    s = getattr(_tls, "ext", None)
    if s is None:
        if _HAS_CFFI and IMPERSONATE:
            s = _cffi.Session()
        else:
            s = requests.Session()
            ad = requests.adapters.HTTPAdapter(pool_connections=16, pool_maxsize=32, max_retries=0)
            s.mount("https://", ad)
            s.mount("http://", ad)
        _tls.ext = s
    return s


def http_request(method, url, **kw):
    """对外部(红果/CDN)发请求: 线程本地 Session 复用连接 + verify=False + 代理 + curl_cffi 指纹伪装。
    curl_cffi 未安装或 IMPERSONATE 为空 → 透明退回原生 requests(行为不变)。"""
    kw.setdefault("verify", False)
    if HONGGUO_PROXY:
        kw.setdefault("proxies", _ext_proxies())
    s = _ext_session()
    if _HAS_CFFI and IMPERSONATE:
        kw.setdefault("impersonate", IMPERSONATE)
    return s.request(method, url, **kw)

urllib3.disable_warnings()
HERE = os.path.dirname(os.path.abspath(__file__))
CFG = json.load(open(os.path.join(HERE, "config.json"), encoding="utf-8"))
# ADB 路径与设备可用环境变量覆盖(容器/Linux部署用); 默认本机 MuMu
ADB = os.environ.get("ADB", r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe")
DEV = os.environ.get("ADB_DEVICE", "127.0.0.1:16384")
FRIDA_HOST = os.environ.get("FRIDA_HOST", "127.0.0.1:27042")
HOST = CFG["api_host"]
OUT_DIR = os.path.join(HERE, "downloads")
_pool = devicepool.load_pool(CFG["base_query"])   # 设备指纹池(DEVICE_POOL_SIZE>0 启用; 否则 None=单设备)


def rotate_device():
    """主动换下一台池设备(无池时无操作)。可在每部剧/每会话开始调用以分散身份。"""
    if _pool:
        return _pool.rotate()
    return None

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
_oracle_lock = threading.RLock()  # RLock: sign()持锁内调oracle()会重入,Lock会死锁(Mac复盘②)
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

# 列表类接口(landpage 筛选/最新上架 + bookmall/cell 榜单)经实测红果不校验 X-Argus 签名,
# 游客态、并发均返回 code=0。默认对这些接口免签,把高频轮询(latest/rank/filters/browse)
# 从签名后端(unidbg)彻底卸载,避免其被打爆/OOM。若红果日后收紧,设 HG_SIGN_LIST=1 恢复签名。
SIGN_LIST = (os.environ.get("HG_SIGN_LIST") or "").strip().lower() in ("1", "true", "yes", "on")
_sign_rr = [0]
_sign_rr_lock = threading.Lock()


def _next_sign_server():
    with _sign_rr_lock:
        i = _sign_rr[0] % len(SIGN_SERVERS)
        _sign_rr[0] = (_sign_rr[0] + 1) % max(1, len(SIGN_SERVERS))
        return SIGN_SERVERS[i]


def _sign_session():
    """对本机签名服务的线程本地 Session(keep-alive, 省每签名一次握手/TIME_WAIT)。"""
    s = getattr(_tls, "sign", None)
    if s is None:
        s = requests.Session()
        s.mount("http://", requests.adapters.HTTPAdapter(pool_connections=8, pool_maxsize=16, max_retries=0))
        _tls.sign = s
    return s


def sign(url, headers):
    """签名。多签名服务轮询+故障转移; 无配置则进程内Frida。"""
    if SIGN_SERVERS:
        errs = []
        sess = _sign_session()
        for _ in range(len(SIGN_SERVERS)):
            base = _next_sign_server()
            try:
                r = sess.post(base.rstrip("/") + "/sign",
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
    if _pool:                              # 设备池: 覆盖身份字段(device_id/iid/cdid/机型...)
        q.update(_pool.current()["query"])
    if extra:
        q.update(extra)
    q["_rticket"] = str(int(time.time() * 1000))
    qs = "&".join(f"{k}={requests.utils.quote(str(v), safe='')}" for k, v in q.items())
    return f"https://{HOST}{path}?{qs}"


def _api_once(method, path, body, extra_query, signed=True):
    url = build_url(path, extra_query)
    headers = dict(CFG["session_headers"])
    if _pool:                             # 池设备走游客: 用自洽 UA, 不带原账号 token/cookie
        _ua = _pool.current().get("user_agent")
        if _ua:
            headers["user-agent"] = _ua
        headers.pop("x-tt-token", None)
        headers.pop("cookie", None)
    headers["content-type"] = "application/json; charset=utf-8"
    data = None
    if body is not None:
        data = json.dumps(body, ensure_ascii=False, separators=(",", ":")).encode("utf-8")
        headers["x-ss-stub"] = hashlib.md5(data).hexdigest().upper()
    if signed:                            # 列表类接口 signed=False: 免签, 不触碰签名后端
        headers.update(sign(url, headers))   # 预言机生成新鲜签名
    headers.pop("accept-encoding", None)
    SG.throttle.wait()                    # 节流
    r = http_request(method, url, data=data, headers=headers, timeout=30)
    j = r.json()
    SG.check_response(j)                  # 风控/登录态识别
    return j


def api(method, path, body=None, extra_query=None, max_retries=3, signed=True):
    """带签名的 API 调用,含重试退避 + 登录态自动刷新。
    signed=False: 免签(列表/榜单/筛选类接口红果不校验签名, 不占用签名后端)。"""
    last = None
    for attempt in range(max_retries):
        try:
            return _api_once(method, path, body, extra_query, signed=signed)
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


def _cover_tags(d):
    """提取封面角标(爆剧/新剧/独播…)。cover_tag_info_list 结构不定, 容错取文本。"""
    out = []
    for t in (d.get("cover_tag_info_list") or []):
        if isinstance(t, dict):
            v = t.get("text") or t.get("content") or t.get("name") or t.get("tag_text") or t.get("title")
            if v:
                out.append(re.sub("<[^>]+>", "", str(v)))
        elif isinstance(t, str) and t:
            out.append(t)
    return out


def _parse_search_cell(cell):
    """从综合tab的一个cell解析短剧条目; 非短剧(无集数)或无id返回 None。"""
    sid = cell.get("book_id") or cell.get("search_result_id")
    if not sid:
        return None
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
        return None  # 只要短剧(有集数的)
    hl = cell.get("search_high_light", {}).get("title", {}).get("text")
    title = re.sub("<[^>]+>", "", hl or vd.get("series_title") or vdata.get("title") or inner.get("series_title") or "")
    return {
        "series_id": sid,
        "title": title,
        "episode_cnt": ep,
        "score": vdata.get("score") or inner.get("score") or "",
        "play_cnt": vdata.get("play_cnt") or inner.get("series_play_cnt") or 0,
        "hot": vdata.get("rec_text") or "",
        "copyright": vdata.get("copyright") or "",
        "cover": vdata.get("cover") or inner.get("series_cover") or "",
        "intro": (inner.get("series_intro") or vd.get("series_intro") or "")[:60],
        # 7.2.5.32 接入: 列表项可用字段
        "vid": vdata.get("vid") or "",                       # 第1集 vid, 可直接播放免再查 episodes
        "duration": vdata.get("duration") or 0,              # 时长(秒)
        "horiz_cover": vdata.get("horiz_cover") or "",       # 横版封面
        "cover_tags": _cover_tags(vdata),                    # 角标: 爆剧/新剧/独播
    }


def search(query, max_items=None):
    """搜索短剧。原生接口按综合tab分页(next_offset+passback+search_id),
    这里循环翻页累计短剧结果, 直到 has_more=False 或达 max_items / 翻页上限。
    max_items 越小翻页越少越快(单 IP 顺序翻页是单次延迟主因); 默认走 HG_SEARCH_MAX_ITEMS(20)。
    """
    if max_items is None:
        max_items = int(os.environ.get("HG_SEARCH_MAX_ITEMS", "20"))
    max_items = max(1, min(max_items, 40))  # 上限40(=原生页满量), 防客户端要过多触发12页
    ck = SG.cache_key("search", query, max_items)
    cached = SG.cache_get(ck)
    if cached is not None:
        return cached
    results, seen = [], set()
    offset, passback, search_id = 0, "", ""
    for _ in range(12):  # 安全上限: 最多翻12页
        q = {"query": query, "tab_name": "feed", "search_source": "1",
             "offset": str(offset), "count": "0", "use_correct": "true"}
        if passback:
            q["passback"] = passback
        if search_id:
            q["search_id"] = search_id
        j = api("GET", "/reading/bookapi/search/tab/v", extra_query=q)
        tabs = j.get("search_tabs") or []
        if not tabs:
            break
        tab = tabs[0]  # 综合tab
        data = tab.get("data") or []
        for cell in data:
            item = _parse_search_cell(cell)
            if not item or item["series_id"] in seen:
                continue
            seen.add(item["series_id"])
            results.append(item)
        nxt = tab.get("next_offset")
        offset = nxt if nxt is not None else offset
        passback = tab.get("passback") or passback
        search_id = tab.get("search_id") or search_id
        if not tab.get("has_more") or not data or len(results) >= max_items:
            break
    results = results[:max_items]
    SG.cache_set(ck, results, ttl=600)  # 搜索结果缓存10分钟
    return results


def _episodes_body(series_id):
    return {"biz_param": {"detail_page_version": 0, "disable_digg_stat": False,
                           "disable_video_relate_book": False, "image_shrink_datas_str": IMAGE_SHRINK,
                           "need_all_video_definition": False, "need_mp4_align": False,
                           "screen_width_px": "900", "source": 7, "use_os_player": False,
                           "use_server_dns": False},
            "series_id": series_id}


def _parse_episode_detail(sid, vd):
    eps = []
    for e in (vd or {}).get("video_list", []):
        eps.append({"index": e.get("vid_index"), "vid": e.get("vid"),
                    "title": e.get("title", "")[:30], "duration": e.get("duration"),
                    "cover": e.get("episode_cover") or e.get("cover") or "",
                    "comment_count": e.get("comment_count", 0),
                    "digged_count": e.get("digged_count", 0)})
    eps.sort(key=lambda x: x["index"] or 0)
    first_ep_cover = next((e.get("cover") for e in eps if e.get("cover")), "")
    # 整剧元数据
    celebs = [{"演员": c.get("nickname"), "角色": c.get("role_name"),
               "头像": c.get("avatar"), "简介": (c.get("intro") or "")[:80]}
              for c in (vd or {}).get("celebrities", [])]
    meta = {
        "series_id": sid,
        "title": (vd or {}).get("series_title", sid),
        "intro": (vd or {}).get("series_intro", ""),
        "episode_cnt": (vd or {}).get("episode_cnt", len(eps)),
        "status": "完结" if (vd or {}).get("series_status") == 1 else "连载中",
        "play_cnt": (vd or {}).get("series_play_cnt", 0),
        "followed_cnt": (vd or {}).get("followed_cnt", 0),
        "create_time": (vd or {}).get("create_time", 0),
        "cover": (vd or {}).get("series_cover") or first_ep_cover,
        "category": re.findall(r'"name":"([^"]+)"', (vd or {}).get("category_schema", "")),
        "celebrities": celebs,
    }
    return meta, eps


def get_episodes(series_id):
    sid = str(series_id)
    ck = SG.cache_key("episodes", sid)
    cached = SG.cache_get(ck)
    if cached is not None:
        return cached
    j = api("POST", "/novel/player/multi_video_detail/v1/", body=_episodes_body(sid))
    data = j.get("data", {})
    meta, eps = _parse_episode_detail(sid, data.get(sid, {}).get("video_data", {}))
    SG.cache_set(ck, (meta, eps), ttl=21600)  # 剧集列表缓存6小时
    return meta, eps


def get_episodes_batch(series_ids, batch_size=20):
    """批量取剧集元数据。multi_video_detail 支持 series_id 用逗号拼接；实测 20 个/批稳定，30 个会参数错误。"""
    ids, seen = [], set()
    for sid in series_ids or []:
        sid = str(sid).strip()
        if sid and sid not in seen:
            seen.add(sid)
            ids.append(sid)
    batch_size = max(1, min(int(batch_size or 20), 20))
    out, failed = {}, []
    todo = []
    for sid in ids:
        cached = SG.cache_get(SG.cache_key("episodes", sid))
        if cached is not None:
            out[sid] = cached[0]
        else:
            todo.append(sid)
    for i in range(0, len(todo), batch_size):
        batch = todo[i:i+batch_size]
        try:
            j = api("POST", "/novel/player/multi_video_detail/v1/", body=_episodes_body(",".join(batch)))
            data = j.get("data", {}) or {}
            for sid in batch:
                vd = (data.get(sid) or {}).get("video_data") or {}
                if not vd:
                    failed.append({"series_id": sid, "error": "empty detail"})
                    continue
                meta, eps = _parse_episode_detail(sid, vd)
                SG.cache_set(SG.cache_key("episodes", sid), (meta, eps), ttl=21600)
                out[sid] = meta
        except Exception as e:
            failed.extend({"series_id": sid, "error": str(e)} for sid in batch)
    return out, failed


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


def get_video_tracks(vids, force=False, batch_size=5):
    """批量取每个vid的完整 video_list 轨道(含 main_url/backup_url/video_meta/encrypt_info.spade_a)。
    与 get_video_urls 不同: 保留 spade_a(离线解密必需) 和全部清晰度轨道(供选清晰度)。
    一次 5 个 vid(app 真实批量大小)→ 5 集只签 1 次, 大幅降签名/节流/风控压力。
    按 vid 缓存 5h(main_url url_expire 约6h); force=True 跳过缓存(URL过期续传用)。
    返回 {vid(str): [track,...]}; 未返回的 vid 不在结果里(调用方自行回退)。"""
    out, todo, seen = {}, [], set()
    for v in vids:
        v = str(v)
        if v in seen:
            continue
        seen.add(v)
        c = None if force else SG.cache_get(SG.cache_key("vmtracks", v))
        if c is not None:
            out[v] = c
        else:
            todo.append(v)
    bs = max(1, min(int(batch_size or 5), 5))
    for i in range(0, len(todo), bs):
        batch = todo[i:i+bs]
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
            tracks = (json.loads(vm).get("video_list") or [])
            if tracks:
                out[str(vid)] = tracks
                SG.cache_set(SG.cache_key("vmtracks", str(vid)), tracks, ttl=18000)
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
        j = api("GET", "/reading/bookapi/bookmall/cell/change/v", extra_query=q, signed=SIGN_LIST)
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


def latest(genre="short_play", only_today=True, max_items=120, stop_ids=None, refresh=False):
    """最新上架。
    - 短剧(short_play): 官方有'今日上新'标签。only_today=True 精确返回今日上新(扫描多页,
      整页无今日才停,处理交错); False 返回最新上架全部。
    - 漫剧/AI(comic_series/ai_series): 官方无'今日'粒度(最细7天)且不暴露上线时间,
      统一返回'7天内上新·最新上架'(days_7筛选+上线时间降序,顶部最新)。only_today 不影响结果,
      item.today 字段对这两类恒为 False(无法判定)。
    """
    if genre not in GENRES:
        raise ValueError(f"genre必须是 {list(GENRES)}")
    scene, g = GENRES[genre]
    tag_today = (genre == "short_play")             # 仅短剧有'今日上新'标签
    online_time = [] if tag_today else ["days_7"]   # 漫剧/AI 用官方最细7天筛选
    want_today = tag_today and only_today
    out, shown, offset, pages, done = [], [], 0, 0, False
    while len(out) < max_items and pages < 20:
        body = {"filter_ids": ",".join(shown), "req_scene": scene, "offset": offset,
                "need_selector_panel": False, "limit": 18,
                "select_items": {"category_dim_epoch": [], "online_time": online_time, "gender": [],
                                 "category_dim_role": [], "genre": [g], "sort": ["online_time"],
                                 "category_dim_theme": []},
                "session_id": "", "req_type": "only_content", "client_req_type": 3}
        j = api("POST", "/reading/distribution/category/landpage/v", body=body, signed=SIGN_LIST)
        items = j.get("data", {}).get("video_data", [])
        if not items:
            break
        page_today = 0
        for it in items:
            sid = str(it.get("series_id"))
            if stop_ids and sid in stop_ids:
                done = True  # 命中上次已监控的剧: 列表按上线时间倒序, 后面均为更早的已存数据
                break
            shown.append(sid)
            subs = [s.get("content") for s in (it.get("sub_title_list") or [])]
            is_today = "今日上新" in subs
            if is_today:
                page_today += 1
            # 分类: 源数据 category_schema 含多个(如 玄幻/逆袭/异界); sub_title_list 只有一个, 作兜底
            cats = []
            for nm in re.findall(r'"name":"([^"]+)"', it.get("category_schema", "")):
                if nm and nm not in cats:
                    cats.append(nm)
            if not cats:
                for s in subs:
                    if (not s or s == "今日上新" or re.match(r"^[\d.]+万", s)
                            or "播放" in s or re.match(r"^\d+集$", s)):
                        continue
                    if s not in cats:
                        cats.append(s)
            if want_today and not is_today:
                continue  # 短剧今日模式: 跳过非今日(仍扫完本页)
            out.append({"series_id": sid, "title": it.get("title", ""),
                        "episode_cnt": it.get("episode_cnt", 0), "score": it.get("score", ""),
                        "play_cnt": it.get("play_cnt", 0), "cover": it.get("cover", ""),
                        "category": " / ".join(cats), "today": is_today,
                        "copyright": it.get("copyright", ""),  # 作者/出品方(或"短剧版权<ID>")
                        "premiere": (it.get("tag_info") or {}).get("text", ""),
                        "intro": (it.get("video_desc") or "")[:50]})
            if len(out) >= max_items:
                break
        pages += 1
        if done:   # 增量模式: 命中已监控剧, 停止翻页(省下后续签名请求)
            break
        if want_today and page_today == 0:   # 短剧今日: 整页无今日 => 已过今日簇,停
            break
        if not j.get("data", {}).get("has_more", True):
            break
        offset += len(items)
    return out


# ---- 分类筛选(landpage selector) ----
# 维度 -> select_items 键: 主题=category_dim_theme 设定=category_dim_role 背景=category_dim_epoch
# 主题/设定/背景共用 cate_ 命名空间(名->id); 排序/受众/时间各自独立。原始 id(cate_/days_/数字)直接透传。
FILTER_CATE = {
    # 主题
    "脑洞": "cate_755", "奇幻": "cate_6", "剧情": "cate_316", "玄幻": "cate_7",
    "末世": "cate_68", "豪门": "cate_936", "科幻": "cate_1092", "冒险": "cate_1182",
    # 设定
    "重生": "cate_36", "穿越": "cate_37", "逆袭": "cate_739", "异能": "cate_598",
    "系统": "cate_19", "反转": "cate_756", "娱乐圈": "cate_43", "总裁": "cate_29",
    # 背景
    "架空": "cate_452", "都市": "cate_1", "古代": "cate_758", "异界": "cate_599",
    "校园": "cate_4", "职场": "cate_127", "年代": "cate_79", "乡村": "cate_11", "民国": "cate_390",
}
FILTER_SORT = {"最新上架": "online_time", "最新": "online_time", "最高热度": "hot_score",
               "热度": "hot_score", "hot": "hot_score", "最高收藏": "hot_collect", "收藏": "hot_collect"}
FILTER_GENDER = {"男频": "1", "男": "1", "女频": "0", "女": "0"}
FILTER_DAYS = {"7": "days_7", "14": "days_14", "30": "days_30", "90": "days_90",
               "7天内上新": "days_7", "14天内上新": "days_14", "30天内上新": "days_30", "90天内上新": "days_90"}
# 状态(仅漫剧 comic_series 有此维度): type=creation_status
FILTER_STATUS = {"已完结": "creation_status_0", "完结": "creation_status_0",
                 "连载中": "creation_status_1", "连载": "creation_status_1"}


def _ids(val, mapping):
    """单值或列表 -> id 列表; 名称按 mapping 映射, 已是 id/未知则原样透传。"""
    if val is None or val == "":
        return []
    vals = val if isinstance(val, (list, tuple)) else [val]
    out = []
    for v in vals:
        v = str(v).strip()
        if v:
            out.append(mapping.get(v, v))
    return out


def filters(genre="short_play"):
    """取某体裁的实时筛选面板。返回 [{type,row_name,selection_type,items:[{id,name}]}]。
    type 即 select_items 的键(genre/category_dim_theme/category_dim_role/category_dim_epoch/sort/gender/online_time)。"""
    scene, g = GENRES.get(genre, ("default", "short_play"))
    body = {"filter_ids": "", "req_scene": scene, "offset": 0, "limit": 1,
            "need_selector_panel": True, "req_type": "default", "client_req_type": 3,
            "select_items": {"category_dim_epoch": [], "online_time": [], "gender": [],
                             "category_dim_role": [], "genre": [g], "sort": [], "category_dim_theme": []},
            "session_id": ""}
    rows = api("POST", "/reading/distribution/category/landpage/v", body=body, signed=SIGN_LIST).get("data", {}).get("selector_rows", [])
    return [{"type": r.get("type"), "row_name": r.get("row_name"), "selection_type": r.get("selection_type"),
             "items": [{"id": it.get("selector_item_id"), "name": it.get("show_name")} for it in r.get("items", [])]}
            for r in rows]


def browse(genre="short_play", theme=None, setting=None, background=None,
           sort="online_time", gender=None, days=None, status=None, max_items=120):
    """按筛选条件浏览短剧/漫剧/AI短剧。各维度可传中文名或 id(cate_xxx)，单值或列表(多选)。
    - genre   体裁: short_play/comic_series/ai_series
    - theme   主题: 脑洞/奇幻/剧情/玄幻/末世/豪门/科幻/冒险 ...
    - setting 设定: 重生/穿越/逆袭/异能/系统/反转/娱乐圈/总裁 ...
    - background 背景: 架空/都市/古代/异界/校园/职场/年代/乡村/民国 ...
    - sort    排序: 最新上架(online_time)/最高热度(hot_score)/最高收藏(hot_collect)
    - gender  受众: 男频(1)/女频(0)
    - days    时间: 7/14/30/90 (天内上新)
    - status  状态(仅漫剧): 已完结/连载中
    全部可选项见 filters(genre)。返回 [{series_id,title,episode_cnt,score,play_cnt,cover,category,intro}]。"""
    if genre not in GENRES:
        raise ValueError(f"genre 必须是 {list(GENRES)}")
    scene, g = GENRES[genre]
    sel = {"genre": [g],
           "category_dim_theme": _ids(theme, FILTER_CATE),
           "category_dim_role": _ids(setting, FILTER_CATE),
           "category_dim_epoch": _ids(background, FILTER_CATE),
           "sort": _ids(sort, FILTER_SORT) or ["online_time"],
           "gender": _ids(gender, FILTER_GENDER),
           "creation_status": _ids(status, FILTER_STATUS),
           "online_time": _ids(days, FILTER_DAYS)}
    out, shown, offset, pages = [], [], 0, 0
    while len(out) < max_items and pages < 20:
        body = {"filter_ids": ",".join(shown), "req_scene": scene, "offset": offset,
                "need_selector_panel": False, "limit": 18, "select_items": sel,
                "session_id": "", "req_type": "only_content", "client_req_type": 3}
        j = api("POST", "/reading/distribution/category/landpage/v", body=body, signed=SIGN_LIST)
        items = j.get("data", {}).get("video_data", [])
        if not items:
            break
        for it in items:
            sid = str(it.get("series_id"))
            shown.append(sid)
            cats = []
            for nm in re.findall(r'"name":"([^"]+)"', it.get("category_schema", "")):
                if nm and nm not in cats:
                    cats.append(nm)
            out.append({"series_id": sid, "title": it.get("title", ""),
                        "episode_cnt": it.get("episode_cnt", 0), "score": it.get("score", ""),
                        "play_cnt": it.get("play_cnt", 0), "cover": it.get("cover", ""),
                        "copyright": it.get("copyright", ""),
                        "category": " / ".join(cats), "intro": (it.get("video_desc") or "")[:50],
                        # 7.2.5.32 接入: 列表项可用字段
                        "vid": it.get("vid") or "",                  # 第1集 vid, 可直接播放
                        "comment_count": it.get("comment_count", 0), # 评论数
                        "duration": it.get("duration") or 0,         # 时长(秒)
                        "horiz_cover": it.get("horiz_cover") or "",  # 横版封面
                        "cover_tags": _cover_tags(it)})              # 角标
            if len(out) >= max_items:
                break
        pages += 1
        if not j.get("data", {}).get("has_more", True):
            break
        offset += len(items)
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
        r = http_request("GET", url, timeout=30)
        r.raise_for_status()
        with open(path, "wb") as f:
            f.write(r.content)
        return True
    except Exception as ex:
        print(f"    封面下载失败: {ex}")
        return False


def download_file(url, path):
    tmp = path + ".part"
    r = http_request("GET", url, stream=True, timeout=60)
    try:
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
    finally:
        try: r.close()
        except Exception: pass
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
    try:
        sys.stdout.reconfigure(encoding="utf-8")
    except Exception:
        pass
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
    elif cmd == "filters":
        genre = sys.argv[2] if len(sys.argv) > 2 else "short_play"
        print(f"=== {GENRE_NAMES.get(genre, genre)} 筛选面板 ===")
        for row in filters(genre):
            opts = "  ".join(f"{it['name']}={it['id']}" for it in row["items"])
            print(f"【{row['row_name']}】(type={row['type']}, 多选={row['selection_type']==2})\n  {opts}")
    elif cmd == "browse":
        # browse <genre> [--theme 玄幻] [--setting 逆袭] [--bg 古代] [--sort hot_score] [--gender 男频] [--days 7] [--n 60]
        genre = sys.argv[2] if len(sys.argv) > 2 and not sys.argv[2].startswith("--") else "ai_series"
        def _opt(name):
            return sys.argv[sys.argv.index(name) + 1] if name in sys.argv and sys.argv.index(name) + 1 < len(sys.argv) else None
        items = browse(genre, theme=_opt("--theme"), setting=_opt("--setting"), background=_opt("--bg"),
                       sort=_opt("--sort") or "online_time", gender=_opt("--gender"), days=_opt("--days"),
                       status=_opt("--status"), max_items=int(_opt("--n") or 60))
        print(f"=== {GENRE_NAMES.get(genre, genre)} 筛选结果 ({len(items)}部) ===")
        for it in items:
            print(f"  [{it['episode_cnt']}集] ★{it['score']} {it['play_cnt']}播放 [{it['category']}] {it['title']}  (id={it['series_id']})")
    else:
        print(__doc__)


if __name__ == "__main__":
    main()
