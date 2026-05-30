# -*- coding: utf-8 -*-
"""下载管理器: 并发 + 断点续传 + 失败重试 + 直链过期自动重取 + 元数据。"""
import os, re, json, time, threading, uuid
from concurrent.futures import ThreadPoolExecutor
import requests, urllib3
urllib3.disable_warnings()


def sanitize(name):
    return re.sub(r'[\\/:*?"<>|\n\r\t]', "_", str(name)).strip()[:80]


def _img_ext(url):
    p = url.split("?")[0].lower()
    for e in (".heic", ".jpeg", ".jpg", ".webp", ".png"):
        if p.endswith(e):
            return e
    return ".jpg"


def download_one(url, path, expected_size=None, refetch=None, retries=5, on_progress=None):
    """单文件下载: 断点续传(.part) + 重试 + 过期重取。
    refetch(): 返回新的url(直链过期时调用)。on_progress(done,total)。"""
    tmp = path + ".part"
    for attempt in range(retries):
        done = os.path.getsize(tmp) if os.path.exists(tmp) else 0
        headers = {"Range": f"bytes={done}-"} if done else {}
        try:
            with requests.get(url, stream=True, headers=headers, verify=False, timeout=60) as r:
                if r.status_code == 416:  # range超出=已完整
                    break
                if done and r.status_code == 200:
                    # 服务器不支持range,从头来
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
            # 完整性: 有期望大小则校验
            final = os.path.getsize(tmp)
            if expected_size and final < expected_size * 0.98:
                raise IOError(f"大小不足 {final}/{expected_size}")
            os.replace(tmp, path)
            return True
        except Exception as e:
            wait = min(2 ** attempt, 15)
            print(f"    下载重试{attempt+1}/{retries} ({e}), {wait}s后...")
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
    def __init__(self, get_episodes, get_video_urls, out_dir, concurrency=3):
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
