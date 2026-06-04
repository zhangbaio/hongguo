# -*- coding: utf-8 -*-
"""红果全自动纯离线下载器: 搜索/榜单 → 选集 → API 取 spade+直链 → 本地 unwrap → 下载 → 解密。
支持整剧批量 + 多线程并发(下载I/O重叠 + AES解密GIL释放; 签名API经RLock串行,控风控)。

链路: hongguo API(签名) 取 video_model(main_url + encrypt_info.spade_a)
      → unwrap_spade 纯算法出 content key(无 KEK)
      → 下载 CDN 密文 → senc 读 base_iv → AES-128-CTR 解密 → 明文 mp4。
解密本身纯离线(无 app/frida); 仅"调 API 取 spade+直链"需签名。

用法:
  python offline_dl.py search "剧名"
  python offline_dl.py rank [recommend|hot|new]
  python offline_dl.py series <series_id> [集号范围: 1-5 / 3 / all(默认)] [-c 并发数]
  python offline_dl.py vid <vid> [输出文件名]
  python offline_dl.py batch <id1> <id2> ...        # 批量整剧 [-c 并发数]
  # 并发默认 4; 调大更快但更易触发风控, 调小更稳。
"""
import sys, os, json, re, threading, time
from concurrent.futures import ThreadPoolExecutor, as_completed
try:
    sys.stdout.reconfigure(encoding="utf-8")
except Exception:
    pass

ROOT = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, os.path.join(ROOT, "frida"))
import hongguo as H
import offline_decrypt as OD

OUT = os.path.join(ROOT, "downloads")
_plock = threading.Lock()          # 串行化打印
def log(msg):
    with _plock:
        print(msg, flush=True)


def _video_model(vid):
    body = {"biz_param": {"detail_page_version": 0, "device_level": 3, "disable_digg_stat": False,
                          "disable_video_relate_book": False, "need_all_video_definition": True,
                          "need_mp4_align": False, "use_os_player": False, "use_server_dns": False,
                          "video_platform": 1024},
            "mixed_video_id_map": {"1": [str(vid)]}}
    d = H.api("POST", "/novel/player/multi_video_model/v1/", body=body).get("data", {})
    v = d.get(str(vid)) or (list(d.values())[0] if d else None)
    if not v or not v.get("video_model"):
        return None
    return json.loads(v["video_model"])


def _best_track(vm):
    best = None
    for it in vm.get("video_list", []):
        sz = (it.get("video_meta") or {}).get("size", 0) or 0
        if best is None or sz > best[0]:
            best = (sz, it)
    return best[1] if best else None


def dl_vid(vid, name=None, retries=2, quiet=False):
    """下载+解密单集; 返回输出路径或 None。线程安全(各集独立文件)。"""
    os.makedirs(OUT, exist_ok=True)
    name = H.sanitize(name or str(vid))
    out = os.path.join(OUT, name + ".mp4")
    if os.path.exists(out) and os.path.getsize(out) > 0:
        if not quiet: log(f"[=] 跳过(已存在): {name}")
        return out
    ct = os.path.join(OUT, name + ".enc.mp4")
    last = None
    for attempt in range(retries):
        try:
            vm = _video_model(vid)                       # 签名API(RLock串行)
            if not vm: last = "无video_model"; continue
            tr = _best_track(vm)
            if not tr: last = "无video_list"; continue
            enc = tr.get("encrypt_info") or {}
            meta = tr.get("video_meta") or {}
            if not quiet:
                log(f"[*] {name}  [{meta.get('definition')}, {(meta.get('size') or 0)//1024}KB]")
            if not enc.get("encrypt"):
                H.download_file(tr["main_url"], out); return out
            H.download_file(tr["main_url"], ct)          # CDN直链, 无需签名
            r = OD.offline_decrypt(enc.get("spade_a"), ct, out)
            if r and os.path.exists(out) and os.path.getsize(out) > 0:
                try: os.remove(ct)
                except OSError: pass
                return out
            last = "解密失败"
        except Exception as ex:
            last = str(ex)
            if attempt + 1 < retries:
                if not quiet: log(f"    {name} 第{attempt+1}次失败({last}), 重试...")
                time.sleep(1.5)
    log(f"[X] {name} 失败: {last}")
    try:
        if os.path.exists(ct): os.remove(ct)
    except OSError: pass
    return None


def dl_series(series_id, rng="all", concurrency=4):
    meta, eps = H.get_episodes(series_id)
    title = H.sanitize(meta["title"])
    if rng != "all":
        m = re.match(r"(\d+)-(\d+)", rng)
        if m:
            lo, hi = int(m.group(1)), int(m.group(2))
            eps = [e for e in eps if lo <= (e["index"] or 0) <= hi]
        elif rng.isdigit():
            eps = [e for e in eps if (e["index"] or 0) == int(rng)]
    log(f"《{title}》共 {meta.get('episode_cnt','?')} 集 | {meta['status']} | 本次 {len(eps)} 集 | 并发 {concurrency}")
    done = {"ok": 0, "fail": 0}; dlock = threading.Lock(); fails = []
    t0 = time.time()
    def work(e):
        r = dl_vid(e["vid"], f"{title}_第{(e['index'] or 0):03d}集")
        with dlock:
            if r: done["ok"] += 1
            else: done["fail"] += 1; fails.append(e["index"])
            n = done["ok"] + done["fail"]
            log(f"    进度 {n}/{len(eps)}  (成功{done['ok']} 失败{done['fail']})")
    with ThreadPoolExecutor(max_workers=concurrency) as ex:
        list(as_completed([ex.submit(work, e) for e in eps]))
    dt = int(time.time() - t0)
    log(f"\n《{title}》完成 {done['ok']}/{len(eps)} 集, 失败集: {sorted(f for f in fails if f)} ({dt}s) -> {OUT}")
    return done


def _pop_concurrency(args, default=4):
    """从 argv 列表里取出 -c N / --concurrency N, 返回(剩余args, 并发数)。"""
    c = default; rest = []
    i = 0
    while i < len(args):
        if args[i] in ("-c", "--concurrency") and i + 1 < len(args):
            c = max(1, int(args[i+1])); i += 2
        else:
            rest.append(args[i]); i += 1
    return rest, c


def main():
    if len(sys.argv) < 2:
        print(__doc__); return
    cmd = sys.argv[1]
    rest, conc = _pop_concurrency(sys.argv[2:])
    if cmd == "search":
        for r in H.search(rest[0]):
            print(f"  {r['series_id']}  [{r['episode_cnt']}集] ★{r.get('score','')}  {r['title']}")
    elif cmd == "rank":
        for r in H.rank(rest[0] if rest else "recommend"):
            print(f"  {r['rank']:>2}. {r['series_id']}  [{r['episode_cnt']}集]  {r['title']}")
    elif cmd == "series":
        dl_series(rest[0], rest[1] if len(rest) > 1 else "all", concurrency=conc)
    elif cmd == "vid":
        dl_vid(rest[0], rest[1] if len(rest) > 1 else None)
    elif cmd == "batch":
        tot = {"ok": 0, "all": 0}
        for sid in rest:
            d = dl_series(sid, "all", concurrency=conc)
            tot["ok"] += d["ok"]; tot["all"] += d["ok"] + d["fail"]
        log(f"\n=== 批量完成: {tot['ok']}/{tot['all']} 集, {len(rest)} 部剧 ===")
    else:
        print(__doc__)


if __name__ == "__main__":
    main()
