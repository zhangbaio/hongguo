# -*- coding: utf-8 -*-
"""红果全自动纯离线下载器: 搜索/榜单 → 选集 → API 取 spade+直链 → 本地 unwrap → 下载 → 解密。
支持整剧批量 + 多线程并发 + 断点续传(进度持久化) + 失败集自动重试。

链路: hongguo API(签名) 取 video_model(main_url + encrypt_info.spade_a)
      → unwrap_spade 纯算法出 content key(无 KEK) → 下载 CDN 密文 → senc 读 base_iv
      → AES-128-CTR 解密 → 明文 mp4。解密纯离线; 仅取 spade/直链需签名。

进度持久化: downloads/.state/series_<id>.json (每集完成即保存; 重跑自动续传只补未完成)。

用法:
  python offline_dl.py search "剧名"
  python offline_dl.py rank [recommend|hot|new]
  python offline_dl.py series <series_id> [范围 1-5/3/all] [-c 并发] [-r 重试轮数]
  python offline_dl.py resume <series_id> [-c 并发] [-r 重试轮数]   # 只补未完成/失败集
  python offline_dl.py vid <vid> [输出文件名]
  python offline_dl.py batch <id1> <id2> ... [-c 并发] [-r 重试轮数]
  python offline_dl.py status <series_id>                          # 看进度
  # 并发默认4; 重试默认2轮。
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
STATE_DIR = os.path.join(OUT, ".state")
_plock = threading.Lock()
_state_lock = threading.Lock()
def log(msg):
    with _plock:
        print(msg, flush=True)


# ---------- 进度持久化 ----------
def _state_path(sid):
    return os.path.join(STATE_DIR, f"series_{sid}.json")

def _load_state(sid):
    p = _state_path(sid)
    if os.path.exists(p):
        try:
            return json.load(open(p, encoding="utf-8"))
        except Exception:
            pass
    return {"series_id": str(sid), "title": "", "episodes": {}}  # episodes[idx]={vid,status,file,error,attempts,ts}

def _save_state(sid, st):
    os.makedirs(STATE_DIR, exist_ok=True)
    with _state_lock:
        tmp = _state_path(sid) + ".tmp"
        json.dump(st, open(tmp, "w", encoding="utf-8"), ensure_ascii=False, indent=1)
        os.replace(tmp, _state_path(sid))

def _is_done(st, idx):
    """状态 done 且输出文件仍在(>0) 才算完成(支持文件被删后重下)。"""
    e = st["episodes"].get(str(idx))
    if not e or e.get("status") != "done":
        return False
    f = e.get("file")
    return bool(f) and os.path.exists(f) and os.path.getsize(f) > 0


# ---------- API + 下载解密 ----------
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
    """下载+解密单集; 返回输出路径或 None。各集独立文件, 线程安全。"""
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
            vm = _video_model(vid)
            if not vm: last = "无video_model"; continue
            tr = _best_track(vm)
            if not tr: last = "无video_list"; continue
            enc = tr.get("encrypt_info") or {}
            meta = tr.get("video_meta") or {}
            if not quiet:
                log(f"[*] {name}  [{meta.get('definition')}, {(meta.get('size') or 0)//1024}KB]")
            if not enc.get("encrypt"):
                H.download_file(tr["main_url"], out); return out
            H.download_file(tr["main_url"], ct)
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
    dl_vid.last_error = last
    return None


# ---------- 整剧(续传+重试) ----------
def dl_series(series_id, rng="all", concurrency=4, retry_rounds=2, only_unfinished=False):
    meta, eps = H.get_episodes(series_id)
    title = H.sanitize(meta["title"])
    st = _load_state(series_id); st["title"] = title; st["series_id"] = str(series_id)
    # 范围过滤
    if rng != "all":
        m = re.match(r"(\d+)-(\d+)", rng)
        if m:
            lo, hi = int(m.group(1)), int(m.group(2))
            eps = [e for e in eps if lo <= (e["index"] or 0) <= hi]
        elif rng.isdigit():
            eps = [e for e in eps if (e["index"] or 0) == int(rng)]
    # 续传: 跳过已完成
    pending = [e for e in eps if not _is_done(st, e["index"])]
    skipped = len(eps) - len(pending)
    log(f"《{title}》共 {meta.get('episode_cnt','?')} 集 | {meta['status']} | 目标 {len(eps)} 集 | "
        f"已完成跳过 {skipped} | 待下 {len(pending)} | 并发 {concurrency}")
    if not pending:
        log(f"《{title}》全部已完成 ✓ -> {OUT}"); return {"ok": skipped, "fail": 0, "total": len(eps)}

    dlock = threading.Lock(); done = {"ok": 0, "fail": 0}
    def work(e):
        idx = e["index"]
        path = dl_vid(e["vid"], f"{title}_第{(idx or 0):03d}集", retries=2)
        with dlock:
            ent = st["episodes"].setdefault(str(idx), {"vid": e["vid"], "attempts": 0})
            ent["vid"] = e["vid"]; ent["attempts"] = ent.get("attempts", 0) + 1; ent["ts"] = int(time.time())
            if path:
                ent["status"] = "done"; ent["file"] = path; ent.pop("error", None); done["ok"] += 1
            else:
                ent["status"] = "failed"; ent["error"] = getattr(dl_vid, "last_error", "?"); done["fail"] += 1
            _save_state(series_id, st)  # 增量保存: 每集完成即落盘(中断不丢)
            n = done["ok"] + done["fail"]
            log(f"    进度 {n}/{len(pending)}  (成功{done['ok']} 失败{done['fail']})")

    t0 = time.time()
    todo = pending
    rnd = 0
    while todo:
        with ThreadPoolExecutor(max_workers=concurrency) as ex:
            list(as_completed([ex.submit(work, e) for e in todo]))
        # 本轮后收集仍失败的集, 自动重试
        failed = [e for e in todo if not _is_done(st, e["index"])]
        if not failed or rnd >= retry_rounds:
            todo = failed if False else []  # 退出
            break
        rnd += 1
        log(f"\n[重试 {rnd}/{retry_rounds}] 失败 {len(failed)} 集: {sorted(e['index'] for e in failed)}, 退避后重试...")
        time.sleep(3 * rnd)
        with dlock: done["ok"] = done["ok"]; done["fail"] = 0  # 重置失败计数(重试轮)
        todo = failed

    final_fail = sorted(int(i) for i, e in st["episodes"].items()
                        if e.get("status") != "done" and any((ep["index"] or 0) == int(i) for ep in eps))
    okn = sum(1 for e in eps if _is_done(st, e["index"]))
    dt = int(time.time() - t0)
    log(f"\n《{title}》完成 {okn}/{len(eps)} 集" + (f", 仍失败: {final_fail}" if final_fail else " ✓")
        + f" ({dt}s) -> {OUT}")
    if final_fail:
        log(f"    可重跑补齐: python offline_dl.py resume {series_id}")
    return {"ok": okn, "fail": len(final_fail), "total": len(eps)}


def show_status(series_id):
    st = _load_state(series_id)
    eps = st.get("episodes", {})
    done = [int(i) for i, e in eps.items() if e.get("status") == "done"]
    fail = [int(i) for i, e in eps.items() if e.get("status") != "done"]
    log(f"《{st.get('title') or series_id}》 已完成 {len(done)} 集" + (f", 失败/未完成: {sorted(fail)}" if fail else " (无失败)"))
    for i in sorted(fail):
        log(f"    第{i:03d}集 failed: {eps[str(i)].get('error','?')} (试过{eps[str(i)].get('attempts',0)}次)")


def _pop_opts(args):
    """取出 -c N / -r N; 返回(剩余, 并发, 重试轮)。"""
    c, r, rest, i = 4, 2, [], 0
    while i < len(args):
        if args[i] in ("-c", "--concurrency") and i+1 < len(args): c = max(1, int(args[i+1])); i += 2
        elif args[i] in ("-r", "--retry") and i+1 < len(args): r = max(0, int(args[i+1])); i += 2
        else: rest.append(args[i]); i += 1
    return rest, c, r


def main():
    if len(sys.argv) < 2:
        print(__doc__); return
    cmd = sys.argv[1]
    rest, conc, rr = _pop_opts(sys.argv[2:])
    if cmd == "search":
        for x in H.search(rest[0]):
            print(f"  {x['series_id']}  [{x['episode_cnt']}集] ★{x.get('score','')}  {x['title']}")
    elif cmd == "rank":
        for x in H.rank(rest[0] if rest else "recommend"):
            print(f"  {x['rank']:>2}. {x['series_id']}  [{x['episode_cnt']}集]  {x['title']}")
    elif cmd == "series":
        dl_series(rest[0], rest[1] if len(rest) > 1 else "all", concurrency=conc, retry_rounds=rr)
    elif cmd == "resume":
        dl_series(rest[0], "all", concurrency=conc, retry_rounds=rr)  # _is_done 自动跳已完成, 只补失败/缺失
    elif cmd == "status":
        show_status(rest[0])
    elif cmd == "vid":
        dl_vid(rest[0], rest[1] if len(rest) > 1 else None)
    elif cmd == "batch":
        tot = {"ok": 0, "all": 0}
        for sid in rest:
            d = dl_series(sid, "all", concurrency=conc, retry_rounds=rr)
            tot["ok"] += d["ok"]; tot["all"] += d["total"]
        log(f"\n=== 批量完成: {tot['ok']}/{tot['all']} 集, {len(rest)} 部剧 ===")
    else:
        print(__doc__)


if __name__ == "__main__":
    main()
