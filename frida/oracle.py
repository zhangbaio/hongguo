# -*- coding: utf-8 -*-
"""运行时密钥盒预言机(一键)。
前提: 红果 app 正在【在线流】播放/解码目标视频(缓存/离线视频不行)。
流程: pidof -> 拉 smaps -> 选 rw 驻留 native 段 -> 设备端 dd+gzip dump -> 拉回 ->
      extract_keybox_pairs 提 kid->key->base_iv -> 打印表。
用法:
  python frida/oracle.py                 # dump 当前内存并提取
  python frida/oracle.py --reuse <dump>  # 跳过 dump, 直接分析已有 dump
"""
import argparse, os, re, subprocess, sys, time, gzip, shutil, struct
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from extract_keybox_pairs import build_report
from pathlib import Path

# ---- mp4 视频样本解析 + NAL 校验 (用于 --verify 自动选出正确 key/base_iv) ----
def _ib(d, s, e):
    o = s
    while o + 8 <= e:
        sz = struct.unpack(">I", d[o:o+4])[0]; t = d[o+4:o+8]; hs = 8
        if sz == 1: sz = struct.unpack(">Q", d[o+8:o+16])[0]; hs = 16
        elif sz == 0: sz = e - o
        yield t, o, sz, hs; o += sz
def _find(d, p, s=0, e=None):
    if e is None: e = len(d)
    for t, o, sz, hs in _ib(d, s, e):
        if t == p[0]: return (o+hs, o+sz) if len(p) == 1 else _find(d, p[1:], o+hs, o+sz)
def _u32(d, o): return struct.unpack(">I", d[o:o+4])[0]
def parse_track_samples(d, handler=b"vide"):
    """解析指定 handler 轨(vide/soun)的样本 (sizes, offs)。无此轨返回 ([], [])。
    stsz/stco|co64/stsc → 文件内每样本字节偏移; 视频音频通用。"""
    mv = _find(d, [b"moov"])
    if not mv: return [], []
    traks = [(o+hs, o+sz) for t, o, sz, hs in _ib(d, *mv) if t == b"trak"]
    def hdlr(tr): h = _find(d, [b"mdia", b"hdlr"], *tr); return d[h[0]+8:h[0]+12] if h else None
    want = [t for t in traks if hdlr(t) == handler]
    if not want: return [], []
    s, e = _find(d, [b"mdia", b"minf", b"stbl"], *want[0])
    stsz = _find(d, [b"stsz"], s, e); stco = _find(d, [b"stco"], s, e); co64 = _find(d, [b"co64"], s, e); stsc = _find(d, [b"stsc"], s, e)
    ss = _u32(d, stsz[0]+4); cnt = _u32(d, stsz[0]+8)
    sizes = [ss]*cnt if ss else [_u32(d, stsz[0]+12+4*i) for i in range(cnt)]
    if stco: n = _u32(d, stco[0]+4); ch = [_u32(d, stco[0]+8+4*i) for i in range(n)]
    else: n = _u32(d, co64[0]+4); ch = [struct.unpack(">Q", d[co64[0]+8+8*i:co64[0]+16+8*i])[0] for i in range(n)]
    ne = _u32(d, stsc[0]+4); runs = [(_u32(d, stsc[0]+8+12*i), _u32(d, stsc[0]+12+12*i), _u32(d, stsc[0]+16+12*i)) for i in range(ne)]; spc = [0]*len(ch)
    for i, (fc, sp, sd) in enumerate(runs):
        last = runs[i+1][0]-1 if i+1 < len(runs) else len(ch)
        for c in range(fc, last+1):
            if 1 <= c <= len(ch): spc[c-1] = sp
    offs = []; si = 0
    for c in range(len(ch)):
        off = ch[c]
        for _ in range(spc[c]):
            if si >= cnt: break
            offs.append(off); off += sizes[si]; si += 1
    return sizes, offs
def parse_video_samples(path):
    d = open(path, "rb").read()
    sizes, offs = parse_track_samples(d, b"vide")
    return d, sizes, offs
def _nal_ok(pt, sz):
    p = 0
    while p + 4 <= sz:
        ln = struct.unpack(">I", pt[p:p+4])[0]
        if ln == 0 or p+4+ln > sz: return False
        p += 4 + ln
    return p == sz
def verify_key_iv(ct_path, keys, iv8s):
    """对密文逐 (key×base_iv) 试解, NAL自证选真值。
    先用首块(16B)的首NAL长度快筛, 再全样本校验。keys 应传"全部key候选"(让密文定真伪)。"""
    from Crypto.Cipher import AES
    from Crypto.Util import Counter
    d, sizes, offs = parse_video_samples(ct_path)
    if not sizes:
        return None, None
    co0, sz0 = offs[0], sizes[0]
    blk0 = d[co0:co0+16]
    print(f"  密文视频样本={len(sizes)}; 试 {len(keys)} key × {len(iv8s)} base_iv (首块快筛) ...", flush=True)
    for kh in keys:
        K = bytes.fromhex(kh)
        if len(K) != 16: continue
        ec = {}  # 缓存 AES 对象无意义(每次IV不同), 直接算
        for ivh in iv8s:
            biv = int(ivh, 16)
            # 快筛: 解首16字节, 首NAL长度须 0<L<sample_size
            pt0 = AES.new(K, AES.MODE_CTR, counter=Counter.new(128, initial_value=(biv << 64))).decrypt(blk0)
            L = struct.unpack(">I", pt0[:4])[0]
            if not (0 < L < sz0):
                continue
            # 全验证首2样本 NAL 链
            ok = 0
            for idx in range(min(2, len(sizes))):
                co, sz = offs[idx], sizes[idx]; iv = ((biv+idx) << 64)
                pt = AES.new(K, AES.MODE_CTR, counter=Counter.new(128, initial_value=iv)).decrypt(d[co:co+sz])
                if _nal_ok(pt, sz): ok += 1
                else: break
            if ok >= 2:
                return kh, ivh
    return None, None


def all_key_candidates(dump_path):
    """dump 里全部 distinct "key"-分类的16字节值(高熵, 让密文定真伪, 避免投票假阳)。"""
    import mmap
    from extract_keybox_pairs import iter_keybox_entries
    keys = []
    seen = set()
    with open(dump_path, "rb") as f:
        mm = mmap.mmap(f.fileno(), 0, access=mmap.ACCESS_READ)
        for e in iter_keybox_entries(mm):
            if e["kind"] == "key":
                h = e["value"].hex()
                if h not in seen:
                    seen.add(h); keys.append(h)
    return keys

ADB = r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"
DEV = "127.0.0.1:16384"
EXCL = ["dalvik", ".art]", ".vdex", ".oat", ".odex", "gralloc", "Ashmem", "ashmem",
        "jit-cache", "boot-", "framework", "/dev/", "mali", "kgsl", "dmabuf",
        ".jar", ".apk", "[stack", "linker", "[vdso", "[vvar"]

def adb(*args, capture=True, timeout=600):
    cmd = [ADB, "-s", DEV] + list(args)
    return subprocess.run(cmd, capture_output=capture, text=False, timeout=timeout)

def adb_su(cmd, **kw):
    # su -c 必须是单字符串(与设备工作形式一致); cmd 内勿含单引号
    return adb("shell", "su -c '" + cmd + "'", **kw)

def get_pid():
    r = adb_su("pidof com.phoenix.read")
    pid = r.stdout.decode(errors="ignore").strip().split()
    return pid[0] if pid else None

def build_dumplist(smaps_text):
    regions = []; cur = None
    for line in smaps_text.splitlines():
        m = re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$", line)
        if m:
            cur = {"s": int(m.group(1), 16), "e": int(m.group(2), 16),
                   "perm": m.group(3), "path": m.group(4).strip(), "rss": 0}
            regions.append(cur)
        else:
            mm = re.match(r"^Rss:\s+(\d+)\s*kB", line)
            if mm and cur: cur["rss"] = int(mm.group(1))
    rw = [r for r in regions if r["perm"][0] == "r" and r["perm"][1] == "w"
          and r["rss"] > 0 and not any(x in r["path"] for x in EXCL)]
    tot = sum(r["rss"] for r in rw)
    lines = []
    for r in rw:
        sz = (r["e"] - r["s"]) // 4096
        if sz > 0: lines.append(f"{r['s']//4096} {sz}")
    return "\n".join(lines) + "\n", tot, len(rw)

def do_dump(pid):
    os.makedirs("capture", exist_ok=True)
    print(f"[1/5] pid={pid} 拉 smaps ...", flush=True)
    smaps = adb_su(f"cat /proc/{pid}/smaps").stdout.decode(errors="ignore")
    dumplist, tot, n = build_dumplist(smaps)
    print(f"      native rw 驻留 {tot/1024:.0f}MB, {n} 段")
    open("capture/dumplist_live.txt", "w", newline="\n").write(dumplist)
    print("[2/5] 推送 dumplist ...", flush=True)
    adb("push", "capture/dumplist_live.txt", "/data/local/tmp/dumplist.txt")
    print("[3/5] 设备端 dd+gzip dump (耗时取决于驻留大小) ...", flush=True)
    t0 = time.time()
    adb_su(f"while read s c; do dd if=/proc/{pid}/mem bs=4096 skip=$s count=$c "
           f"conv=noerror,sync 2>/dev/null; done < /data/local/tmp/dumplist.txt "
           f"| gzip -1 > /data/local/tmp/oracle_dump.gz", timeout=900)
    print(f"      dump 完成 {time.time()-t0:.0f}s")
    print("[4/5] 拉回 + 解压 ...", flush=True)
    adb("pull", "/data/local/tmp/oracle_dump.gz", "capture/oracle_dump.gz")
    with gzip.open("capture/oracle_dump.gz", "rb") as fi, open("capture/oracle_dump.bin", "wb") as fo:
        shutil.copyfileobj(fi, fo)
    sz = os.path.getsize("capture/oracle_dump.bin")
    print(f"      capture/oracle_dump.bin {sz//1048576}MB")
    return "capture/oracle_dump.bin"

def report(dump):
    print("[5/5] 提取密钥盒 kid->key->base_iv ...", flush=True)
    rep = build_report(__import__("pathlib").Path(dump), lookahead_bytes=256, iv_window=512)
    print(f"\n entry_counts={rep['entry_counts']}  mspade_kids={rep['mspade_kids']} keybox_kids={rep['keybox_kids']}")
    print("\n===== 正在解码视频的 (kid, key, base_iv64) =====")
    found = 0
    for it in rep["joined"]:
        if not it["keys"]:
            continue
        key = it["keys"][0]["key"]
        ivs = it.get("iv8_candidates", [])
        base_iv = it.get("base_iv64")  # 主导前缀组最小iv8
        spade = it["spade_a"][0] if it["spade_a"] else "(无spade,可能离线)"
        print(f"  kid     = {it['kid']}")
        print(f"  key     = {key}  (votes={it['keys'][0]['votes']})")
        print(f"  base_iv = {base_iv}   (iv候选{len(ivs)}个)")
        print(f"  spade_a = {spade}\n")
        found += 1
    if not found:
        print("  ⚠ 未发现带 key 的 kid。确认: 正在【在线流】播放且画面在动(解码中)。")
        print("    缓存/下载视频走离线安全路径, 密钥盒里没有 key。")
    return rep

def collect_keys_ivs(rep, dump_path):
    import mmap
    from extract_keybox_pairs import iter_keybox_entries
    keys = []
    for it in rep["joined"]:
        for k in it["keys"]:
            keys.append(k["key"])
    seen = set(); keys = [k for k in keys if not (k in seen or seen.add(k))]
    # 全部 iv8 (dump 里所有 IV 条目的高8字节, 去重)
    iv8s = set()
    with open(dump_path, "rb") as f:
        mm = mmap.mmap(f.fileno(), 0, access=mmap.ACCESS_READ)
        for e in iter_keybox_entries(mm):
            if e["kind"] == "iv":
                iv8s.add(e["value"][:8].hex())
    return keys, sorted(iv8s)

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--reuse", help="跳过dump,直接分析已有dump文件")
    ap.add_argument("--verify", help="给定下载的密文mp4, 自动从dump的key×base_iv里试解出正确组合")
    args = ap.parse_args()
    if args.reuse:
        dump = args.reuse
    else:
        subprocess.run([ADB, "connect", DEV], capture_output=True)
        pid = get_pid()
        if not pid:
            print("✗ app 未运行 (com.phoenix.read)。先启动 app 并播放在线视频。")
            sys.exit(1)
        dump = do_dump(pid)
    rep = report(dump)
    if args.verify:
        print(f"\n===== 用密文 {args.verify} 自动验证 key/base_iv =====")
        keys, iv8s = collect_keys_ivs(rep, dump)
        kh, ivh = verify_key_iv(args.verify, keys, iv8s)
        if kh:
            print(f"  [OK] 验证通过! key={kh}  base_iv64={ivh}")
            print(f"  -> 解密: AES-128-CTR, IV=((0x{ivh}+sample_idx)<<64), 用 decrypt_full.py")
        else:
            print("  [X] 没有 key x base_iv 组合能解密该密文。可能: dump与密文非同一视频/清晰度, 或key未在内存。")

if __name__ == "__main__":
    main()
