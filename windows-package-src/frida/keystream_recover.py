# -*- coding: utf-8 -*-
"""用明文(MediaCodec抓取的 Annex-B ES) 和密文(CDN下载的mp4) 恢复 keystream。
明文 ES 是 Annex-B (00 00 00 01 NAL...), 密文是 hvc1 (4字节大端长度 + NAL)。
对齐后 XOR -> keystream -> 分析加密模式(CTR/CBC)和 IV。"""
import struct, json, base64
from Crypto.Cipher import AES

def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0]; t=d[o+4:o+8]; hs=8
        if sz==1: sz=struct.unpack(">Q",d[o+8:o+16])[0]; hs=16
        elif sz==0: sz=e-o
        yield t,o,sz,hs; o+=sz
def find(d,p,s=0,e=None):
    if e is None: e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]: return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
def traks(d):
    mv=find(d,[b"moov"]); return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"]
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
def samp(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e)
    ss=u32(d,stsz[0]+4);cnt=u32(d,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    n=u32(d,stco[0]+4);chunks=[u32(d,stco[0]+8+4*i) for i in range(n)]
    return sizes, chunks[0]

# 加载明文 ES (Annex-B)
plain_es = open("capture/live_video_raw.h265","rb").read()
print(f"plaintext ES: {len(plain_es)} bytes")
print(f"ES start: {plain_es[:16].hex()}")

# 加载密文
meta = json.load(open("capture/hits_meta.json"))
for fn, m in meta.items():
    tag = "hit1" if "1" in fn else "hit3"
    path = f"capture/ct/{tag}_live.mp4"
    try:
        ct = open(path,"rb").read()
    except:
        continue
    mds = find(ct,[b"mdat"])[0]
    vt = [t for t in traks(ct) if hdlr(ct,t)==b"vide"][0]
    sizes, off0 = samp(ct, vt)
    mo = off0 - mds
    print(f"\n=== {tag} mdat_offset={mds} video_s0_off={off0} mdatoff={mo} size={sizes[0]} ===")
    print(f"cipher s0 start: {ct[off0:off0+16].hex()}")
    print(f"cipher s0 bytes 4-8: {ct[off0+4:off0+8].hex()} (NAL header if plaintext)")

    # 明文 ES 的第一个 Annex-B NAL:
    # Annex-B: 00 00 00 01 [NAL header] [NAL data]
    # hvc1:    [4B big-endian length] [NAL header] [NAL data]
    # 对应关系: plain[4:] 对应 cipher[off0+4:]  (NAL content, 跳过起始码/长度)
    # 密文第0字节对应什么?
    # hvc1 format: cipher[off0:off0+4] = 大端长度 = sizes[0]-4 (若单NAL) 或第一个NAL的长度
    # 明文 Annex-B: plain[0:4] = 00 00 00 01 (start code), plain[4] = NAL header
    # 密文 hvc1: cipher[off0:off0+4] = 加密的长度字段, cipher[off0+4] = 加密的 NAL header

    # 已知明文: plain[0:4] 的 Annex-B 起始码 = 00 00 00 01
    # 但这对应的是 hvc1 的4字节长度字段... 不完全对应
    # 正确对应: hvc1 样本 = [4B len][NAL...] (没有起始码)
    # Annex-B  = [00 00 00 01][NAL...]
    # 所以 NAL 内容(从 NAL header 开始) 完全一致
    # cipher[off0+4 .. off0+4+N] XOR plain[4 .. 4+N] = keystream[r+4 .. r+4+N]
    # 其中 r = mo % 16 (样本起点在 AES 块内的偏移)

    N = min(512, sizes[0]-4, len(plain_es)-4)
    # 对齐: hvc1 NAL body 从 off0+4 开始; Annex-B NAL body 从 plain[4] 开始
    cipher_nal = ct[off0+4:off0+4+N]
    plain_nal  = plain_es[4:4+N]
    ks = bytes(c^p for c,p in zip(cipher_nal, plain_nal))
    print(f"keystream[0:32]: {ks[:32].hex()}")
    print(f"keystream[16:32]: {ks[16:32].hex()}")

    # 检查 CTR 模式特征: 连续块之间的关系
    # AES-CTR: ks[i*16:(i+1)*16] = AES_ECB(key, IV+i) or AES_ECB(key, counter_at_block_i)
    # 如果是连续 CTR, ks[0:16] XOR ks[16:32] 应该有特定模式

    # 更重要: 用已知明文验证 aeskeyfind 的28个候选密钥是否能产生这段 keystream
    print("\n  -- 用 aeskeyfind 28个候选密钥验证 keystream --")
    cands = [bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]
    # keystream[r:r+16] = AES_ECB(key, counter) where counter 取决于 IV scheme
    r = mo % 16  # 样本起点在 AES 块内的偏移
    # 样本 NAL body 从 off0+4 开始, 对应 keystream 位置 = mo+4 (bytes from mdat start)
    # AES 块 index for first byte of NAL body = (mo+4)//16 = blk
    blk = (mo+4)//16; rb = (mo+4)%16
    ks_blk0 = ks[0:16]  # keystream 开头的 16 字节 (可能不是 AES 块对齐)
    # 实际上 ks 的第 rb 字节开始才是 AES 块 blk 的第 rb 字节
    # 找完整的 AES 块: 从 ks[16-rb:16-rb+16] 开始是块 blk+1 的完整 keystream
    if rb > 0 and len(ks) >= 16-rb+16:
        full_blk = ks[16-rb:16-rb+16]
        print(f"  first FULL AES block (blk_idx={blk+1}): {full_blk.hex()}")
        for ki, K in enumerate(cands):
            # 尝试 IV=0, 块索引 = blk+1
            ks_try = AES.new(K,AES.MODE_ECB).encrypt(((blk+1)%(1<<128)).to_bytes(16,"big"))
            if ks_try == full_blk:
                print(f"  *** KEY FOUND! key#{ki}={K.hex()} IV=0 blk={blk+1}")
            # 也试 IV = kid_be
            kid_be = int.from_bytes(bytes.fromhex(m["kid"]),"big")
            ks_try2 = AES.new(K,AES.MODE_ECB).encrypt(((kid_be+blk+1)%(1<<128)).to_bytes(16,"big"))
            if ks_try2 == full_blk:
                print(f"  *** KEY FOUND! key#{ki}={K.hex()} IV=kid_be blk={blk+1}")
    print(f"  (rb={rb}, blk={blk}, scanned {len(cands)} keys)")
    break  # 只分析第一个
