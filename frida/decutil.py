# -*- coding: utf-8 -*-
"""纯文件/纯算法解密工具(从 Mac 逆向成果整合): senc base_iv 读取 + AES-128-CTR 全解。
不依赖 app/frida/keybox。配合 unwrap_spade 实现纯离线解密。"""
import os, re, sys, shutil, subprocess
from Crypto.Cipher import AES
from Crypto.Util import Counter as CTRCounter
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import oracle  # parse_track_samples / parse_video_samples / _nal_ok

def senc_iv8(ct_path):
    """密文 mp4 的 senc 盒首样本 IV 高8字节 = base_iv 候选(各 track 不同, 全作候选)。"""
    d = open(ct_path, "rb").read()
    ivs = []
    for m in re.finditer(b"senc", d):
        o = m.start() + 8 + 4  # 'senc' + version/flags(4) + sample_count(4)
        if o + 8 > len(d): continue
        h = d[o:o+8].hex()
        if h not in ivs: ivs.append(h)
    return ivs

def tenc_kid(ct_path):
    """密文 tenc 盒 default_KID(核对用)。"""
    d = open(ct_path, "rb").read()
    m = re.search(b"tenc", d)
    if not m: return None
    o = m.start() + 8
    return d[o+4:o+20].hex() if o + 20 <= len(d) else None

def decrypt_full(ct_path, key_hex, base_iv64, out_path):
    K = bytes.fromhex(key_hex); biv = int(base_iv64, 16)
    data, sizes, offs = oracle.parse_video_samples(ct_path)
    data = bytearray(data); ok = 0
    for idx, (co, sz) in enumerate(zip(offs, sizes)):
        iv = ((biv + idx) << 64)
        pt = AES.new(K, AES.MODE_CTR, counter=CTRCounter.new(128, initial_value=iv)).decrypt(bytes(data[co:co+sz]))
        if oracle._nal_ok(pt, sz): ok += 1
        data[co:co+sz] = pt
    open(out_path, "wb").write(data)
    print(f"  解密完成: {out_path}  (视频样本 NAL合法 {ok}/{len(sizes)})")
    return ok, len(sizes)

def _trak_senc_iv8(d, lo, hi):
    """在 trak 字节范围 [lo,hi) 内找 senc 盒, 返回首样本 base_iv 高8字节hex(无则 None)。"""
    for m in re.finditer(b"senc", d):
        if lo <= m.start() < hi:
            o = m.start() + 8 + 4
            if o + 8 <= len(d): return d[o:o+8].hex()
    return None

def _decrypt_track(buf, K, base_iv64, sizes, offs):
    biv = int(base_iv64, 16)
    for idx, (co, sz) in enumerate(zip(offs, sizes)):
        iv = ((biv + idx) << 64)
        buf[co:co+sz] = AES.new(K, AES.MODE_CTR, counter=CTRCounter.new(128, initial_value=iv)).decrypt(bytes(buf[co:co+sz]))

def decrypt_av(ct_path, key_hex, out_path):
    """解密 mp4 全部加密轨(视频+音频): 每轨用自身 senc base_iv, 同一 content key, AES-128-CTR。
    返回 {'vide': (ok,total), 'soun': (None,total)}。视频按 NAL 自证统计, 音频无 NAL 不统计 ok。"""
    d = open(ct_path, "rb").read(); buf = bytearray(d); K = bytes.fromhex(key_hex)
    mv = oracle._find(d, [b"moov"])
    if not mv: raise RuntimeError("无 moov")
    stats = {}
    for t, o, sz, hs in oracle._ib(d, *mv):
        if t != b"trak": continue
        h = oracle._find(d, [b"mdia", b"hdlr"], o+hs, o+sz)
        handler = d[h[0]+8:h[0]+12] if h else None
        if handler not in (b"vide", b"soun"): continue
        iv8 = _trak_senc_iv8(d, o, o+sz)
        if not iv8: continue  # 该轨未加密
        sizes, offs = oracle.parse_track_samples(d, handler)
        if not sizes: continue
        _decrypt_track(buf, K, iv8, sizes, offs)
        if handler == b"vide":
            ok = sum(1 for co, s in zip(offs, sizes)
                     if oracle._nal_ok(bytes(buf[co:co+s]), s))
            stats["vide"] = (ok, len(sizes))
        else:
            stats["soun"] = (None, len(sizes))
    open(out_path, "wb").write(buf)
    v = stats.get("vide"); a = stats.get("soun")
    msg = []
    if v: msg.append(f"视频 NAL合法 {v[0]}/{v[1]}")
    if a: msg.append(f"音频 {a[1]} 样本")
    print(f"  全轨解密: {out_path}  ({'; '.join(msg)})")
    return stats

def remux_playable(in_path, out_path):
    """重封装剥离 CENC 信令(encv→hvc1 / enca→mp4a, 删 senc/sinf/saiz/saio), 使严格播放器可播。
    依赖 ffmpeg(-c copy 不重编码)。无 ffmpeg 时返回 None。"""
    ff = shutil.which("ffmpeg")
    if not ff:
        print("  [!] 未找到 ffmpeg, 跳过重封装(文件残留 encv 盒, 仅宽松播放器可播)")
        return None
    r = subprocess.run([ff, "-y", "-loglevel", "error", "-i", in_path,
                        "-c", "copy", "-tag:v", "hvc1", out_path],
                       capture_output=True, text=True)
    if r.returncode != 0 or not os.path.exists(out_path):
        print(f"  [!] ffmpeg 重封装失败: {r.stderr[:200]}")
        return None
    return out_path
