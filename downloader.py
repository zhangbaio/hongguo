# -*- coding: utf-8 -*-
"""下载管理器: 并发 + 分段多连接 + 断点续传 + 失败重试 + 直链过期自动重取 + 元数据。"""
import os, re, json, time, threading, uuid
from concurrent.futures import ThreadPoolExecutor
import requests, urllib3
urllib3.disable_warnings()

# 下载调优(环境变量可调):
#   HG_DL_SEGMENTS : 单文件分段并发连接数(默认8); 1=禁用分段走单流
#   HG_DL_SEG_MIN  : 启用分段的最小文件字节(默认 3MB); 小文件不值得分段
#   HG_DL_CONCURRENCY : 同时下载的文件数(默认4)
DL_SEGMENTS = max(1, int(os.environ.get("HG_DL_SEGMENTS", "8")))
DL_SEG_MIN = int(os.environ.get("HG_DL_SEG_MIN", str(3 * 1024 * 1024)))
DL_CONCURRENCY = max(1, int(os.environ.get("HG_DL_CONCURRENCY", "3")))

# 连接复用: 线程本地 requests.Session(keep-alive + 连接池), 省每次握手
_dltls = threading.local()


def _dl_session():
    s = getattr(_dltls, "s", None)
    if s is None:
        s = requests.Session()
        ad = requests.adapters.HTTPAdapter(pool_connections=DL_SEGMENTS * 2,
                                           pool_maxsize=DL_SEGMENTS * 4, max_retries=0)
        s.mount("https://", ad)
        s.mount("http://", ad)
        _dltls.s = s
    return s


def sanitize(name):
    return re.sub(r'[\\/:*?"<>|\n\r\t]', "_", str(name)).strip()[:80]


def _img_ext(url):
    p = url.split("?")[0].lower()
    for e in (".heic", ".jpeg", ".jpg", ".webp", ".png"):
        if p.endswith(e):
            return e
    return ".jpg"


def _probe(url):
    """探测总大小 + 是否支持 Range(206)。返回 (total, range_ok)。失败返回 (0, False)。"""
    try:
        with _dl_session().get(url, headers={"Range": "bytes=0-0"}, stream=True,
                               verify=False, timeout=30) as r:
            if r.status_code == 206:
                cr = r.headers.get("content-range", "")  # bytes 0-0/12345
                total = int(cr.split("/")[-1]) if "/" in cr else 0
                return total, total > 0
            if r.status_code == 200:
                return int(r.headers.get("content-length", 0)), False
    except Exception:
        pass
    return 0, False


def _download_segmented(url, tmp, total, nseg, on_progress):
    """分段并发下载到预分配的 tmp(各段 seek 写入)。任一段失败则抛异常(外层重试整体)。"""
    seg = total // nseg
    ranges = [(i * seg, (total - 1 if i == nseg - 1 else (i + 1) * seg - 1)) for i in range(nseg)]
    with open(tmp, "wb") as f:
        f.truncate(total)
    prog = [0] * nseg
    lock = threading.Lock()
    errs = []

    def dl(i, lo, hi):
        try:
            s = _dl_session()
            with s.get(url, headers={"Range": f"bytes={lo}-{hi}"}, stream=True,
                       verify=False, timeout=60) as r:
                if r.status_code not in (206, 200):
                    raise requests.RequestException(f"HTTP {r.status_code}")
                with open(tmp, "r+b") as f:
                    f.seek(lo)
                    for chunk in r.iter_content(262144):
                        f.write(chunk)
                        with lock:
                            prog[i] += len(chunk)
                            if on_progress:
                                on_progress(sum(prog), total)
        except Exception as e:
            errs.append(e)

    with ThreadPoolExecutor(max_workers=nseg) as ex:
        list(ex.map(lambda a: dl(*a), [(i, lo, hi) for i, (lo, hi) in enumerate(ranges)]))
    if errs:
        raise errs[0]
    if os.path.getsize(tmp) != total:
        raise IOError(f"分段大小不符 {os.path.getsize(tmp)}/{total}")


def download_one(url, path, expected_size=None, refetch=None, retries=5, on_progress=None):
    """单文件下载: 分段多连接(支持Range时) / 单流断点续传 + 重试 + 过期重取。
    refetch(): 返回新的url(直链过期时调用)。on_progress(done,total)。"""
    tmp = path + ".part"
    use_seg = DL_SEGMENTS > 1
    for attempt in range(retries):
        seg_used = False
        try:
            # 优先分段: 仅当(已知大小够大 或 大小未知)才探测, 避免小文件白白多一次往返
            if use_seg and not os.path.exists(tmp) and (expected_size is None or expected_size >= DL_SEG_MIN):
                total, range_ok = _probe(url)
                if range_ok and total >= DL_SEG_MIN:
                    nseg = min(DL_SEGMENTS, max(1, total // (1024 * 1024)))  # 每段≥~1MB
                    seg_used = True
                    _download_segmented(url, tmp, total, nseg, on_progress)
                    if expected_size and os.path.getsize(tmp) < expected_size * 0.98:
                        raise IOError(f"大小不足 {os.path.getsize(tmp)}/{expected_size}")
                    os.replace(tmp, path)
                    return True
            # 单流(断点续传): 不支持Range/文件小/已有.part续传
            done = os.path.getsize(tmp) if os.path.exists(tmp) else 0
            headers = {"Range": f"bytes={done}-"} if done else {}
            with _dl_session().get(url, stream=True, headers=headers, verify=False, timeout=60) as r:
                if r.status_code == 416:  # range超出=已完整
                    break
                if done and r.status_code == 200:
                    done = 0
                    open(tmp, "wb").close()
                elif r.status_code not in (200, 206):
                    raise requests.RequestException(f"HTTP {r.status_code}")
                total = int(r.headers.get("content-length", 0)) + done
                mode = "ab" if done else "wb"
                with open(tmp, mode) as f:
                    for chunk in r.iter_content(262144):
                        f.write(chunk)
                        done += len(chunk)
                        if on_progress and total:
                            on_progress(done, total)
            final = os.path.getsize(tmp)
            if expected_size and final < expected_size * 0.98:
                raise IOError(f"大小不足 {final}/{expected_size}")
            os.replace(tmp, path)
            return True
        except Exception as e:
            wait = min(2 ** attempt, 15)
            print(f"    下载重试{attempt+1}/{retries} ({e}), {wait}s后...")
            if seg_used:  # 分段失败: tmp是预分配整块不可续传→清掉, 且退回单流避免反复失败
                use_seg = False
                if os.path.exists(tmp):
                    try: os.remove(tmp)
                    except Exception: pass
            # 单流失败: 保留 .part 供下次续传
            time.sleep(wait)
            if refetch:  # 直链可能过期,重取
                try:
                    nu = refetch()
                    if nu:
                        url = nu
                except Exception:
                    pass
    return False


def write_metadata(folder, meta, eps):
    """写 info.json + tvshow.nfo(给Jellyfin/Emby/Kodi)"""
    json.dump({**meta, "episodes": eps},
              open(os.path.join(folder, "info.json"), "w", encoding="utf-8"),
              ensure_ascii=False, indent=2)
    # Kodi/Jellyfin tvshow.nfo
    genres = "".join(f"<genre>{g}</genre>" for g in (meta.get("category") or []))
    actors = "".join(
        f"<actor><name>{c.get('演员','')}</name><role>{c.get('角色','')}</role></actor>"
        for c in (meta.get("celebrities") or [])[:15])
    nfo = (f'<?xml version="1.0" encoding="UTF-8"?>\n<tvshow>\n'
           f'  <title>{meta.get("title","")}</title>\n'
           f'  <plot>{meta.get("intro","")}</plot>\n'
           f'  <premiered>{time.strftime("%Y-%m-%d", time.localtime(meta.get("create_time") or 0))}</premiered>\n'
           f'  <status>{meta.get("status","")}</status>\n  {genres}\n  {actors}\n</tvshow>\n')
    open(os.path.join(folder, "tvshow.nfo"), "w", encoding="utf-8").write(nfo)


class DownloadManager:
    def __init__(self, get_episodes, get_video_urls, out_dir, concurrency=DL_CONCURRENCY):
        self.get_episodes = get_episodes
        self.get_video_urls = get_video_urls
        self.out_dir = out_dir
        self.pool = ThreadPoolExecutor(max_workers=concurrency)
        self.tasks = {}          # task_id -> {状态}
        self.lock = threading.Lock()

    def submit(self, series_id, rng="all", ep_covers=False):
        task_id = uuid.uuid4().hex[:8]
        self.tasks[task_id] = {"task_id": task_id, "series_id": series_id, "state": "准备中",
                               "total": 0, "done": 0, "failed": 0, "episodes": {}}
        self.pool.submit(self._run_series, task_id, series_id, rng, ep_covers)
        return task_id

    def status(self, task_id=None):
        if task_id:
            return self.tasks.get(task_id, {"error": "无此任务"})
        return list(self.tasks.values())

    def _run_series(self, task_id, series_id, rng, ep_covers):
        t = self.tasks[task_id]
        try:
            meta, eps = self.get_episodes(series_id)
            title = sanitize(meta["title"])
            folder = os.path.join(self.out_dir, title)
            os.makedirs(folder, exist_ok=True)
            write_metadata(folder, meta, eps)
            if meta.get("cover"):
                download_one(meta["cover"], os.path.join(folder, "poster" + _img_ext(meta["cover"])))
            # 选集
            sel = eps
            if rng != "all":
                m = re.match(r"(\d+)-(\d+)$", str(rng))
                if m:
                    lo, hi = int(m.group(1)), int(m.group(2))
                    sel = [e for e in eps if lo <= (e["index"] or 0) <= hi]
                elif str(rng).isdigit():
                    sel = [e for e in eps if (e["index"] or 0) == int(rng)]
            t["total"] = len(sel)
            t["state"] = "下载中"
            urls = self.get_video_urls([e["vid"] for e in sel])
            futs = []
            for e in sel:
                futs.append(self.pool.submit(self._dl_episode, task_id, folder, title, e, urls.get(e["vid"]), ep_covers))
            for f in futs:
                f.result()
            t["state"] = "完成" if t["failed"] == 0 else f"完成(失败{t['failed']})"
            t["folder"] = folder
        except Exception as e:
            t["state"] = f"错误: {e}"

    def _dl_episode(self, task_id, folder, title, e, info, ep_covers):
        t = self.tasks[task_id]
        idx = e["index"]
        ep = t["episodes"].setdefault(idx, {})
        fn = os.path.join(folder, f"{title}_第{idx:03d}集.mp4")
        if os.path.exists(fn) and os.path.getsize(fn) > 0:
            ep["state"] = "已存在"; t["done"] += 1; return
        if not info or not info.get("url"):
            ep["state"] = "无直链"; t["failed"] += 1; return
        if ep_covers and e.get("cover"):
            download_one(e["cover"], os.path.join(folder, f"{title}_第{idx:03d}集{_img_ext(e['cover'])}"))
        ep["state"] = "下载中"; ep["definition"] = info.get("definition")

        def progress(done, total):
            ep["pct"] = done * 100 // total if total else 0

        def refetch():
            u = self.get_video_urls([e["vid"]], force=True).get(e["vid"], {})
            return u.get("url")

        ok = download_one(info["url"], fn, expected_size=info.get("size"),
                          refetch=refetch, on_progress=progress)
        if ok:
            ep["state"] = "完成"; ep["pct"] = 100; t["done"] += 1
        else:
            ep["state"] = "失败"; t["failed"] += 1
