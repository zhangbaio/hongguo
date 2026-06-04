# -*- coding: utf-8 -*-
"""纯文件/纯算法解密工具(从 Mac 逆向成果整合): senc base_iv 读取 + AES-128-CTR 全解。
不依赖 app/frida/keybox。配合 unwrap_spade 实现纯离线解密。"""
import os, re, sys
from Crypto.Cipher import AES
from Crypto.Util import Counter as CTRCounter
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import oracle  # parse_video_samples / _nal_ok

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
