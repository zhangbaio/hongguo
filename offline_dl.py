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
  python offline_dl.py quals <vid>                                 # 列某集可选清晰度
  python offline_dl.py series <series_id> [范围 1-5/3/all] [-c 并发] [-r 重试轮] [-q 清晰度]
  python offline_dl.py resume <series_id> [-c 并发] [-r 重试轮] [-q 清晰度]   # 只补未完成/失败集
  python offline_dl.py vid <vid> [输出文件名] [-q 清晰度]
  python offline_dl.py batch <id1> <id2> ... [-c 并发] [-r 重试轮] [-q 清晰度]   # 多剧并行(全局并发上限)
  python offline_dl.py status <series_id>                          # 看进度
  # -c: 全局并发上限(跨剧共享, 总同时下载+解密任务数 ≤ -c, 默认4); -r: 失败重试轮数(默认2)。
  # -q: best(默认)/worst/1080p/720p/540p/480p/360p(或纯数字); 不存在则取<=请求的最高档。
  # ⚠同一集不同清晰度文件名相同会跳过, 换清晰度需先删旧文件或用不同 vid 名。
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

def _defn(t):
    return ((t.get("video_meta") or {}).get("definition") or "").lower()
def _sz(t):
    return (t.get("video_meta") or {}).get("size", 0) or 0
def _dnum(t):
    return int(re.sub(r"\D", "", _defn(t)) or 0)

def list_quals(vm):
    """返回 [(definition, size, wxh, codec, encrypt)] 按分辨率升序。"""
    out = []
    for t in vm.get("video_list", []):
        m = t.get("video_meta") or {}
        out.append((_defn(t) or "?", _sz(t), f"{m.get('vwidth')}x{m.get('vheight')}",
                    m.get("codec_type") or t.get("codec_type"), (t.get("encrypt_info") or {}).get("encrypt")))
    return sorted(out, key=lambda x: int(re.sub(r"\D", "", x[0]) or 0))

def _pick_track(tracks, quality="best"):
    """按清晰度选轨。tracks: video_list 轨道列表。quality: best(默认)/worst/1080p/720p/540p/480p/360p(或纯数字)。
    指定清晰度不存在时取 <=请求 的最高一档(没有则最低)。返回 (track, 实际definition, 是否回退)。"""
    tracks = tracks or []
    if not tracks:
        return None, None, False
    q = str(quality or "best").lower().strip()
    if q in ("best", "max", "high", "highest"):
        t = max(tracks, key=_sz); return t, _defn(t), False
    if q in ("worst", "min", "low", "lowest"):
        t = min(tracks, key=_sz); return t, _defn(t), False
    qnum = re.sub(r"\D", "", q)
    exact = [t for t in tracks if _defn(t) == q or (qnum and re.sub(r"\D", "", _defn(t)) == qnum)]
    if exact:
        t = max(exact, key=_sz); return t, _defn(t), False
    # 回退: <=请求 的最高一档; 否则最低
    avail = sorted(tracks, key=_dnum)
    le = [t for t in avail if qnum and _dnum(t) <= int(qnum)]
    t = le[-1] if le else avail[0]
    return t, _defn(t), True

def dl_vid(vid, name=None, retries=2, quiet=False, quality="best", tracks=None):
    """下载+解密单集; 返回输出路径或 None。各集独立文件, 线程安全。quality 见 _pick_track。
    tracks: 预取的 video_list 轨道(批量签名得到); None 则自取。
    首次用预取轨道(不再签名); 重试时强制重取直链(force, 处理 URL 过期)——仅失败集才重签。"""
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
            tk = tracks if (tracks and attempt == 0) else H.get_video_tracks([vid], force=(attempt > 0)).get(str(vid))
            if not tk: last = "无video_model"; continue
            tr, gotdef, fallback = _pick_track(tk, quality)
            if not tr: last = "无video_list"; continue
            enc = tr.get("encrypt_info") or {}
            meta = tr.get("video_meta") or {}
            if not quiet:
                fb = f" (无{quality}, 回退)" if fallback else ""
                log(f"[*] {name}  [{meta.get('definition')}{fb}, {(meta.get('size') or 0)//1024}KB]")
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


# ---------- 整剧/多剧(全局并发池 + 续传 + 重试) ----------
class SeriesCtx:
    """一部剧的下载上下文: 状态/标题/集列表/清晰度 + 各自的状态锁。"""
    def __init__(self, sid, title, state, eps, quality):
        self.sid = sid; self.title = title; self.state = state; self.eps = eps
        self.quality = quality; self.lock = threading.Lock(); self.tracks = {}  # vid(str)->[track]


def _prepare(series_id, rng, quality):
    """取剧集+范围过滤+加载状态, 返回 (ctx, pending待下集, skipped已完成数)。"""
    meta, eps = H.get_episodes(series_id)
    title = H.sanitize(meta["title"])
    st = _load_state(series_id); st["title"] = title; st["series_id"] = str(series_id); st["quality"] = quality
    if rng != "all":
        m = re.match(r"(\d+)-(\d+)", rng)
        if m:
            lo, hi = int(m.group(1)), int(m.group(2))
            eps = [e for e in eps if lo <= (e["index"] or 0) <= hi]
        elif rng.isdigit():
            eps = [e for e in eps if (e["index"] or 0) == int(rng)]
    ctx = SeriesCtx(series_id, title, st, eps, quality)
    pending = [e for e in eps if not _is_done(st, e["index"])]
    log(f"《{title}》共 {meta.get('episode_cnt','?')} 集 | {meta['status']} | 目标 {len(eps)} | "
        f"跳过已完成 {len(eps)-len(pending)} | 待下 {len(pending)} | 清晰度 {quality}")
    if pending:  # 批量预取直链(5集/签名, 保留spade_a)→ 之后并发池只做下载+解密(无签名)
        try:
            ctx.tracks = H.get_video_tracks([e["vid"] for e in pending])
            log(f"  预取直链 {len(ctx.tracks)}/{len(pending)} 集 (批量签名~{(len(pending)+4)//5}次, 替代逐集{len(pending)}次)")
        except Exception as ex:
            log(f"  预取直链失败, 将逐集回退取流: {ex}")
    return ctx, pending, len(eps) - len(pending)


def _episode_task(ctx, e):
    """下载+解密一集并更新该剧状态(线程安全, 增量落盘)。返回 bool 成功。"""
    idx = e["index"]
    path = dl_vid(e["vid"], f"{ctx.title}_第{(idx or 0):03d}集", retries=2, quality=ctx.quality,
                  tracks=ctx.tracks.get(str(e["vid"])))
    with ctx.lock:
        ent = ctx.state["episodes"].setdefault(str(idx), {"vid": e["vid"], "attempts": 0})
        ent["vid"] = e["vid"]; ent["attempts"] = ent.get("attempts", 0) + 1; ent["ts"] = int(time.time())
        if path:
            ent["status"] = "done"; ent["file"] = path; ent.pop("error", None)
        else:
            ent["status"] = "failed"; ent["error"] = getattr(dl_vid, "last_error", "?")
        _save_state(ctx.sid, ctx.state)
    return bool(path)


def run_jobs(jobs, cap, retry_rounds):
    """全局并发池跑所有 (ctx, episode) 任务; cap=全局并发上限(跨剧共享); 失败自动多轮重试。"""
    if not jobs:
        return
    cnt = {"ok": 0, "fail": 0}; clock = threading.Lock()
    t0 = time.time(); todo = jobs; rnd = 0
    while todo:
        total = len(todo); cnt["ok"] = cnt["fail"] = 0
        def work(ctx, e):
            ok = _episode_task(ctx, e)
            with clock:
                cnt["ok" if ok else "fail"] += 1
                n = cnt["ok"] + cnt["fail"]
                log(f"    进度 {n}/{total}  (成功{cnt['ok']} 失败{cnt['fail']})")
        with ThreadPoolExecutor(max_workers=cap) as ex:
            list(as_completed([ex.submit(work, ctx, e) for ctx, e in todo]))
        failed = [(ctx, e) for ctx, e in todo if not _is_done(ctx.state, e["index"])]
        if not failed or rnd >= retry_rounds:
            break
        rnd += 1
        log(f"\n[全局重试 {rnd}/{retry_rounds}] 失败 {len(failed)} 集, 退避后重试...")
        time.sleep(3 * rnd); todo = failed
    log(f"  (本批 {len(jobs)} 任务用时 {int(time.time()-t0)}s)")


def _summary(ctx):
    okn = sum(1 for e in ctx.eps if _is_done(ctx.state, e["index"]))
    fail = sorted(int(i) for i, e in ctx.state["episodes"].items()
                  if e.get("status") != "done" and any((ep["index"] or 0) == int(i) for ep in ctx.eps))
    log(f"《{ctx.title}》完成 {okn}/{len(ctx.eps)} 集" + (f", 仍失败: {fail}" if fail else " ✓"))
    if fail:
        log(f"    可重跑补齐: python offline_dl.py resume {ctx.sid}")
    return {"ok": okn, "fail": len(fail), "total": len(ctx.eps)}


def dl_series(series_id, rng="all", concurrency=4, retry_rounds=2, quality="best"):
    ctx, pending, _ = _prepare(series_id, rng, quality)
    if not pending:
        log(f"《{ctx.title}》全部已完成 ✓ -> {OUT}"); return _summary(ctx)
    log(f"  全局并发 {concurrency}")
    run_jobs([(ctx, e) for e in pending], concurrency, retry_rounds)
    return _summary(ctx)


def dl_batch(series_ids, concurrency=4, retry_rounds=2, quality="best"):
    """多剧并行: 所有剧的待下集汇入同一全局池(cap=concurrency, 跨剧共享)。"""
    ctxs, jobs = [], []
    for sid in series_ids:
        try:
            ctx, pending, _ = _prepare(sid, "all", quality)
            ctxs.append(ctx)
            jobs += [(ctx, e) for e in pending]
        except Exception as ex:
            log(f"[X] 剧 {sid} 准备失败: {ex}")
    log(f"\n=== 多剧并行: {len(ctxs)} 部剧, 共 {len(jobs)} 集待下, 全局并发上限 {concurrency} ===")
    run_jobs(jobs, concurrency, retry_rounds)
    tot = {"ok": 0, "all": 0}
    for ctx in ctxs:
        d = _summary(ctx); tot["ok"] += d["ok"]; tot["all"] += d["total"]
    log(f"\n=== 批量完成: {tot['ok']}/{tot['all']} 集, {len(ctxs)} 部剧 -> {OUT} ===")


def show_status(series_id):
    st = _load_state(series_id)
    eps = st.get("episodes", {})
    done = [int(i) for i, e in eps.items() if e.get("status") == "done"]
    fail = [int(i) for i, e in eps.items() if e.get("status") != "done"]
    log(f"《{st.get('title') or series_id}》 已完成 {len(done)} 集" + (f", 失败/未完成: {sorted(fail)}" if fail else " (无失败)"))
    for i in sorted(fail):
        log(f"    第{i:03d}集 failed: {eps[str(i)].get('error','?')} (试过{eps[str(i)].get('attempts',0)}次)")


def _pop_opts(args):
    """取出 -c N / -r N / -q 清晰度; 返回(剩余, 并发, 重试轮, 清晰度)。"""
    c, r, q, rest, i = 4, 2, "best", [], 0
    while i < len(args):
        if args[i] in ("-c", "--concurrency") and i+1 < len(args): c = max(1, int(args[i+1])); i += 2
        elif args[i] in ("-r", "--retry") and i+1 < len(args): r = max(0, int(args[i+1])); i += 2
        elif args[i] in ("-q", "--quality") and i+1 < len(args): q = args[i+1]; i += 2
        else: rest.append(args[i]); i += 1
    return rest, c, r, q


def main():
    if len(sys.argv) < 2:
        print(__doc__); return
    cmd = sys.argv[1]
    rest, conc, rr, q = _pop_opts(sys.argv[2:])
    if cmd == "search":
        for x in H.search(rest[0]):
            print(f"  {x['series_id']}  [{x['episode_cnt']}集] ★{x.get('score','')}  {x['title']}")
    elif cmd == "rank":
        for x in H.rank(rest[0] if rest else "recommend"):
            print(f"  {x['rank']:>2}. {x['series_id']}  [{x['episode_cnt']}集]  {x['title']}")
    elif cmd == "quals":   # 列某集可选清晰度
        vm = _video_model(rest[0])
        if not vm: print("无 video_model"); return
        print(f"vid {rest[0]} 可选清晰度:")
        for d, sz, wh, codec, enc in list_quals(vm):
            print(f"  {d:>7}  {sz//1024:>7}KB  {wh:>10}  codec={codec}  encrypt={enc}")
    elif cmd == "series":
        dl_series(rest[0], rest[1] if len(rest) > 1 else "all", concurrency=conc, retry_rounds=rr, quality=q)
    elif cmd == "resume":
        dl_series(rest[0], "all", concurrency=conc, retry_rounds=rr, quality=q)
    elif cmd == "status":
        show_status(rest[0])
    elif cmd == "vid":
        dl_vid(rest[0], rest[1] if len(rest) > 1 else None, quality=q)
    elif cmd == "batch":
        dl_batch(rest, concurrency=conc, retry_rounds=rr, quality=q)  # 跨剧并行, conc=全局并发上限
    else:
        print(__doc__)


if __name__ == "__main__":
    main()
