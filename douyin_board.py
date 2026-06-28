# -*- coding: utf-8 -*-
"""抖音榜单抓取(Web 路线, 第一阶段: 抖音热榜).

背景: 抖音 app 内容接口走 cronet 原生 pinning(自带 CA 包), MuMu x86 下无法原生脱壳;
改走 web 接口。抖音热榜(热搜词榜)有清爽的 iesdouyin billboard 接口, 拿到 ttwid cookie 后
直接 GET 即可, 无需 a_bogus 签名。其余垂类榜(直播/团购/品牌/游戏/音乐/种草/影视/短剧/趋势)
需走新版 www.douyin.com/aweme/v1/web/hot/search/list/(需 a_bogus+msToken, 第二阶段接入)。

用法:
  python douyin_board.py hot [数量]      # 抖音热榜(默认全部)
  程序内: hot_board(limit=None) -> [{rank,word,hot_value,hot_label,label,sentence_id,...}]
"""
import sys, time, requests
import safeguards as SG

UA = ("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
      "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")

# 抖音热榜(热搜词榜): 老 iesdouyin billboard, 仅需 ttwid cookie, 无需签名
HOT_WORD_URL = "https://www.iesdouyin.com/web/api/v2/hotsearch/billboard/word/"
HOME_URL = "https://www.douyin.com/"

# 新版 PC web 接口: 需 a_bogus+msToken 签名。用 playwright 让页面自己算签名, 直接抓响应,
# 无需逆 a_bogus。detail_list=1 的响应里含 word_list(热榜) + trending_list(趋势榜)。
HOT_PAGE = "https://www.douyin.com/hot"
WEB_LIST_PATH = "/aweme/v1/web/hot/search/list/"

# 实测(2026-06-28): 其余 8 榜(直播/团购/品牌/游戏/音乐/种草/影视/短剧)PC web 不渲染、
# 老 iesdouyin 同族端点已废(空/Url doesn't match), 只能走 app 内接口; 但 app 内容走 cronet
# 原生 pinning(自带CA), MuMu x86 下无法原生脱壳, 故这 8 榜暂不可达(需 arm64 redroid 脱壳)。
APP_ONLY_BOARDS = ["直播榜", "团购榜", "品牌榜", "游戏榜", "音乐榜", "种草榜", "影视榜", "短剧榜"]

_session = None
_warmed = 0.0


def _new_session():
    s = requests.Session()
    s.headers.update({
        "User-Agent": UA,
        "Accept-Language": "zh-CN,zh;q=0.9",
    })
    return s


def _warmup(force=False):
    """访问抖音主页拿 ttwid 等 cookie。ttwid 有效期长, 缓存 30min 不重复预热。"""
    global _session, _warmed
    if _session is None:
        _session = _new_session()
    if force or not _session.cookies.get("ttwid") or (time.time() - _warmed) > 1800:
        SG.throttle.wait()
        try:
            _session.get(HOME_URL, timeout=15)
            _warmed = time.time()
        except requests.RequestException as e:
            raise RuntimeError(f"预热抖音主页失败: {e}")
    return _session


def hot_board(limit=None, refresh=False):
    """抖音热榜(热搜词榜)。返回 [{rank, word, hot_value, hot_label, label, sentence_id, group_id}]。
    label/hot_label: 抖音的角标(0=无, 1=新, 3=热, 5=荐 等); hot_value 是热度值。"""
    ck = SG.cache_key("dy_hot")
    if not refresh:
        cached = SG.cache_get(ck)
        if cached is not None:
            return cached[:limit] if limit else cached

    s = _warmup()
    SG.throttle.wait()
    r = s.get(HOT_WORD_URL, headers={"Accept": "application/json", "Referer": "https://www.douyin.com/hot"},
              timeout=15)
    # 被 WAF 拦(444 / Access Denied / X-TT-System-Error)时重预热再试一次
    if r.status_code != 200 or "Access Denied" in r.text[:200]:
        _warmup(force=True)
        SG.throttle.wait()
        r = s.get(HOT_WORD_URL, headers={"Accept": "application/json", "Referer": "https://www.douyin.com/hot"},
                  timeout=15)
    r.raise_for_status()
    j = r.json()
    if j.get("status_code") not in (0, None):
        raise RuntimeError(f"接口异常 status_code={j.get('status_code')}")

    out = []
    for i, w in enumerate(j.get("word_list", []), 1):
        out.append({
            "rank": i,
            "word": w.get("word", ""),
            "hot_value": w.get("hot_value", 0),
            "label": w.get("label", 0),
            "hot_label": w.get("hotlist_param") or "",
            "sentence_id": w.get("sentence_id") or w.get("word_cover", {}).get("uri", ""),
            "group_id": w.get("group_id") or "",
        })
    SG.cache_set(ck, out, ttl=600)  # 热榜更新慢, 缓存 10min
    return out[:limit] if limit else out


def _fetch_web_list(timeout_ms=12000):
    """用 playwright 加载抖音热点页, 让页面自己签名(a_bogus/msToken), 抓 detail_list 响应原文。
    返回该接口的 data 部分(含 word_list / trending_list)。需已 pip install playwright + 安装浏览器。"""
    from playwright.sync_api import sync_playwright
    box = {}

    def on_response(resp):
        if WEB_LIST_PATH in resp.url and "detail_list=1" in resp.url and "body" not in box:
            try:
                if "json" in resp.headers.get("content-type", ""):
                    box["body"] = resp.json()
            except Exception:
                pass

    with sync_playwright() as p:
        br = p.chromium.launch(headless=True, args=["--disable-blink-features=AutomationControlled"])
        ctx = br.new_context(user_agent=UA, locale="zh-CN", viewport={"width": 1366, "height": 900})
        pg = ctx.new_page()
        pg.on("response", on_response)
        try:
            pg.goto(HOT_PAGE, wait_until="domcontentloaded", timeout=30000)
        except Exception:
            pass
        # 轮询等待目标响应到手
        waited = 0
        while "body" not in box and waited < timeout_ms:
            pg.wait_for_timeout(500)
            waited += 500
        br.close()
    if "body" not in box:
        raise RuntimeError("未捕获到热点榜接口响应(页面可能被风控/改版)")
    j = box["body"]
    if j.get("status_code") not in (0, None):
        raise RuntimeError(f"接口异常 status_code={j.get('status_code')}")
    return j.get("data", {})


def web_boards(refresh=False):
    """PC web 热点页可拿到的榜(热榜更丰富 + 趋势榜)。返回 {"hot_board":[...], "trending":[...]}。
    其余 8 个 app 专属榜见 APP_ONLY_BOARDS(当前不可达)。"""
    ck = SG.cache_key("dy_web_boards")
    if not refresh:
        cached = SG.cache_get(ck)
        if cached is not None:
            return cached
    data = _fetch_web_list()
    hot = [{
        "rank": i,
        "word": w.get("word", ""),
        "hot_value": w.get("hot_value", 0),
        "view_count": w.get("view_count", 0),
        "discuss_video_count": w.get("discuss_video_count", 0),
        "label": w.get("label", 0),
        "word_type": w.get("word_type", 0),
        "sentence_id": w.get("sentence_id", ""),
        "hotlist_param": w.get("hotlist_param", ""),
    } for i, w in enumerate(data.get("word_list", []), 1)]
    trending = [{
        "rank": i,
        "word": w.get("word", ""),
        "hot_value": w.get("hot_value", 0),
        "video_count": w.get("video_count", 0),
        "event_time": w.get("event_time", 0),
        "label": w.get("label", 0),
        "group_id": w.get("group_id", ""),
        "sentence_id": w.get("sentence_id", ""),
    } for i, w in enumerate(data.get("trending_list", []), 1)]
    out = {"hot_board": hot, "trending": trending}
    SG.cache_set(ck, out, ttl=600)
    return out


_LABEL = {0: "", 1: "新", 2: "荐", 3: "热", 5: "首发", 8: "独家"}


def main():
    cmd = sys.argv[1] if len(sys.argv) > 1 else "hot"
    if cmd == "hot":
        limit = int(sys.argv[2]) if len(sys.argv) > 2 and sys.argv[2].isdigit() else None
        items = hot_board(limit=limit)
        print(f"=== 抖音热榜 ({len(items)}条) ===")
        for it in items:
            tag = _LABEL.get(it["label"], f"[{it['label']}]") if it["label"] else ""
            tag = f" 〔{tag}〕" if tag else ""
            print(f"  {it['rank']:2}. {it['word']:<28} {it['hot_value']/10000:>7.1f}万{tag}")
    elif cmd == "web":
        b = web_boards()
        print(f"=== 抖音热榜·PC web ({len(b['hot_board'])}条) ===")
        for it in b["hot_board"]:
            tag = _LABEL.get(it["label"], "")
            tag = f" 〔{tag}〕" if tag else ""
            vc = f"  {it['view_count']/100000000:.1f}亿播放" if it.get("view_count") else ""
            print(f"  {it['rank']:2}. {it['word']:<26} {it['hot_value']/10000:>7.1f}万{vc}{tag}")
        print(f"\n=== 趋势榜 ({len(b['trending'])}条) ===")
        for it in b["trending"]:
            print(f"  {it['rank']:2}. {it['word']:<26} {it['hot_value']/10000:>7.1f}万")
        print(f"\n[注] 其余 8 榜为 app 专属(cronet pinning, 当前不可达): {' '.join(APP_ONLY_BOARDS)}")
    else:
        print(__doc__)


if __name__ == "__main__":
    main()
