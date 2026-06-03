# -*- coding: utf-8 -*-
"""红果在线短剧 全自动下载器: (正在播放的视频 或 --vid) -> 解密 mp4。

原理: app 播放【在线流】时, 一次内存 dump 同时含:
  - video_model: mVideoId(vid) / mMainUrl(CDN密文直链) / mKid
  - 密钥盒: kid -> content key(16B) + base_iv 候选
流程: dump -> 提取(vid,kid,main_url) -> keybox 取 key -> 下载 CDN 密文 ->
      key×base_iv 试解(NAL自证)选出正确组合 -> AES-128-CTR 全解 -> 输出 mp4。

用法:
  # 1) app 里播放目标【在线流】视频(画面在动=解码中)
  python frida/downloader.py                 # 自动下载"正在解码"的视频
  python frida/downloader.py --vid <vid>     # dump里有多个时指定 vid
  python frida/downloader.py --reuse <dump>  # 用已有dump(调试; main_url可能已过期)
  python frida/downloader.py --list          # 只列出dump里可下载的候选, 不下载
"""
import argparse, os, re, sys, struct, mmap, urllib.request, time
try:
    sys.stdout.reconfigure(encoding="utf-8")
except Exception:
    pass
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from pathlib import Path
from collections import Counter
from Crypto.Cipher import AES
from Crypto.Util import Counter as CTRCounter
import oracle  # do_dump / get_pid / parse_video_samples / verify_key_iv / _nal_ok / ADB / DEV
from extract_keybox_pairs import build_report, iter_keybox_entries


def extract_video_records(dump_path):
    """从 dump 抽取 {kid: {vid, main_urls:[...]}}; main_url 取自 mMainUrl/mBackupUrl1。"""
    data = open(dump_path, "rb").read()
    recs = {}  # kid_hex -> dict
    # 干净 CDN URL: 无\x00(排除被释放/截断的std::string), 长(token多~1KB), 到闭引号
    for m in re.finditer(rb'"mMainUrl":"(https://[^"\x00]{40,1500})"', data):
        url = m.group(1).decode("ascii", "ignore").replace("\\u003d", "=").replace("\\/", "/")
        win = data[max(0, m.start() - 4000): m.start() + 200]
        kids = re.findall(rb'"mKid":"([0-9a-f]{32})"', win)
        vids = re.findall(rb'"mVideoId":"([0-9A-Za-z]{8,40})"', win)
        if not kids:
            continue
        kid = kids[-1].decode()
        vid = vids[-1].decode() if vids else "?"
        r = recs.setdefault(kid, {"vid": vid, "urls": []})
        if r["vid"] == "?" and vid != "?":
            r["vid"] = vid
        if url not in r["urls"]:
            r["urls"].append(url)
    return recs


def all_iv8(dump_path):
    ivs = set()
    with open(dump_path, "rb") as f:
        mm = mmap.mmap(f.fileno(), 0, access=mmap.ACCESS_READ)
        for e in iter_keybox_entries(mm):
            if e["kind"] == "iv":
                ivs.add(e["value"][:8].hex())
    return sorted(ivs)


def download(url, out):
    print(f"  下载 {url[:90]} ...", flush=True)
    req = urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0"})
    t0 = time.time()
    with urllib.request.urlopen(req, timeout=60) as r, open(out, "wb") as f:
        f.write(r.read())
    print(f"  -> {out} ({os.path.getsize(out)//1024}KB, {time.time()-t0:.1f}s)")


def decrypt_full(ct_path, key_hex, base_iv64, out_path):
    K = bytes.fromhex(key_hex)
    biv = int(base_iv64, 16)
    data, sizes, offs = oracle.parse_video_samples(ct_path)
    data = bytearray(data)
    ok = 0
    for idx, (co, sz) in enumerate(zip(offs, sizes)):
        iv = ((biv + idx) << 64)
        pt = AES.new(K, AES.MODE_CTR, counter=CTRCounter.new(128, initial_value=iv)).decrypt(bytes(data[co:co+sz]))
        if oracle._nal_ok(pt, sz):
            ok += 1
        data[co:co+sz] = pt
    open(out_path, "wb").write(data)
    print(f"  解密完成: {out_path}  (视频样本 NAL合法 {ok}/{len(sizes)})")
    return ok, len(sizes)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--vid", help="指定要下载的 vid (dump 里有多个正在播放的视频时)")
    ap.add_argument("--reuse", help="用已有 dump 文件(调试用; main_url 可能已过期)")
    ap.add_argument("--out", default=None, help="输出 mp4 路径")
    ap.add_argument("--list", action="store_true", help="只列出候选, 不下载")
    args = ap.parse_args()

    # 1) 取得 dump
    if args.reuse:
        dump = args.reuse
    else:
        import subprocess
        subprocess.run([oracle.ADB, "connect", oracle.DEV], capture_output=True)
        pid = oracle.get_pid()
        if not pid:
            print("✗ app 未运行。先启动红果并播放在线视频。"); sys.exit(1)
        dump = oracle.do_dump(pid)

    # 2) 提取 video 记录 + 定位"正在解码"的 kid(其簇内有 key 条目) + 全部 key 候选
    print("[*] 提取 video_model(vid/main_url/kid) + 定位正在解码的视频 ...", flush=True)
    recs = extract_video_records(dump)
    rep = build_report(Path(dump), lookahead_bytes=256, iv_window=512)
    # "kid 簇内有 key 条目" = 正在解码的视频(可靠); key 真值不靠投票, 交给密文 verify
    playing_kids = [it["kid"] for it in rep["joined"] if it["keys"]]

    cands = []
    for kid in playing_kids:
        if kid in recs and recs[kid]["urls"]:
            cands.append((kid, recs[kid]["vid"], recs[kid]["urls"]))
    print(f"[*] 正在解码且有 main_url 的视频: {len(cands)}")
    for kid, vid, urls in cands:
        print(f"    vid={vid} kid={kid[:16]}.. urls={len(urls)}")
    if args.list or not cands:
        if not cands:
            print("  [!] 无候选。确认: 正在【在线流】播放且解码中(画面在动); main_url 与 key 都需在内存。")
        return

    # 3) 选目标 + 收集全部 key 候选(让密文定真伪, 避免投票假阳)
    if args.vid:
        cands = [c for c in cands if c[1] == args.vid]
        if not cands:
            print(f"[X] dump 里没有正在解码的 vid={args.vid}"); sys.exit(1)
    kid, vid, urls = cands[0]
    key_cands = oracle.all_key_candidates(dump)
    print(f"\n[*] 目标 vid={vid} kid={kid}; key候选={len(key_cands)} (由密文试解定真伪)")

    ivs = all_iv8(dump)
    os.makedirs("capture/dl", exist_ok=True)
    ct = f"capture/dl/{vid}.enc.mp4"
    out = args.out or f"capture/dl/{vid}.dec.mp4"

    # 4) 逐 main_url 尝试下载 + 验证 + 解密
    for url in urls:
        try:
            download(url, ct)
        except Exception as e:
            print(f"  下载失败({e}); 试下一个 url"); continue
        kh, ivh = oracle.verify_key_iv(ct, key_cands, ivs)
        if not kh:
            print("  该清晰度没找到匹配 key/base_iv(其iv可能不在内存); 试下一个 url"); continue
        print(f"  [OK] key={kh} base_iv64={ivh}")
        ok, tot = decrypt_full(ct, kh, ivh, out)
        if ok == tot:
            print(f"\n✅ 全自动下载完成: {out}  (vid={vid}, {tot}样本全部合法)")
        else:
            print(f"\n⚠ 完成但 {tot-ok} 个样本 NAL 不合法(可能音频track或部分清晰度差异): {out}")
        return
    print("✗ 所有 main_url 都未能下载+解密成功(url过期? 或iv不在内存)")


if __name__ == "__main__":
    main()
