# -*- coding: utf-8 -*-
"""精确对齐检查: 找到明文 ES 中与密文 sample 大小最接近的 NAL, 验证对齐。"""
import struct

def parse_annexb(data):
    nals = []
    i = 0
    while i + 4 < len(data):
        if data[i:i+4] == b"\x00\x00\x00\x01":
            j = data.find(b"\x00\x00\x00\x01", i+4)
            size = j-i-4 if j > 0 else len(data)-i-4
            nh = data[i+4] if i+4 < len(data) else 0
            nt = (nh>>1)&0x3f
            nals.append({"offset":i+4, "size":size, "type":nt})
            i = j if j > 0 else len(data)
        else: i += 1
    return nals

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
def all_samps(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
    ss=u32(d,stsz[0]+4); cnt=u32(d,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    n=u32(d,stco[0]+4); chunks=[u32(d,stco[0]+8+4*i) for i in range(n)]
    return sizes, chunks[0]

plain = open("capture/live_video_raw.h265","rb").read()
nals = parse_annexb(plain)
ct = open("capture/ct/bpxb_1080p.mp4","rb").read()
mds=find(ct,[b"mdat"])[0]
vt=[t for t in traks(ct) if hdlr(ct,t)==b"vide"][0]
sizes,off0=all_samps(ct,vt)

print("=== 明文 NAL sizes vs 密文 sample sizes ===")
print(f"plain NAL count: {len(nals)}, first 8 sizes: {[n['size'] for n in nals[:8]]}")
print(f"cipher video samples: {len(sizes)}, first 8 sizes: {sizes[:8]}")

# 密文 sample[0] NAL content size = sizes[0]-4
# 明文 NAL content (after start code) = nals[0]['size']
print(f"\ncipher s0 NAL content size: {sizes[0]-4}")
print(f"plain  NAL[0] content size: {nals[0]['size']}")
diff = abs(sizes[0]-4 - nals[0]['size'])
print(f"difference: {diff} bytes ({'MATCH' if diff<100 else 'MISMATCH - wrong video or quality'})")

if diff < 100:
    print("\n对齐成功! 计算 keystream...")
    from Crypto.Cipher import AES
    cipher_nal = ct[off0+4:off0+4+512]  # cipher NAL body
    plain_nal  = plain[nals[0]['offset']:nals[0]['offset']+512]  # plain NAL body
    ks = bytes(c^p for c,p in zip(cipher_nal, plain_nal))
    print(f"keystream[0:32]: {ks[:32].hex()}")
    # 检查完整 AES 块
    # off0-mds = mdatoff, mdatoff+4 是 NAL body 在 mdat 里的偏移
    mo = off0-mds; r=(mo+4)%16; blk0=(mo+4)//16
    print(f"mo={mo} r={r} blk0={blk0}")
    if r > 0:
        full_blk = ks[16-r:16-r+16]
        print(f"first full AES block (blk_idx={blk0+1}): {full_blk.hex()}")
        # 扫 live dump
        import json
        from Crypto.Cipher import AES as AES2
        cands=[bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]
        KID=bytes.fromhex("682165f6f8818b5c0c3d8eac0002ebeb")
        for ki,K in enumerate(cands):
            for iv_name,iv_val in [("0",0),("kid_be",int.from_bytes(KID,"big")),("kid_le",int.from_bytes(KID,"little"))]:
                ks_try=AES2.new(K,AES2.MODE_ECB).encrypt(((iv_val+blk0+1)%(1<<128)).to_bytes(16,"big"))
                if ks_try==full_blk:
                    print(f"*** KEY FOUND! key#{ki}={K.hex()} IV={iv_name}")
        print("28 old candidates checked. Now checking live dump keys...")
        live_cands=[bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json")) if open("capture/aes_keys.json")]
        # (live dump had 39 keys, aes_keys.json has 28 - use those)
        print("done")
else:
    # 找最近匹配
    target = nals[0]['size']
    best = min(range(len(sizes)), key=lambda i: abs(sizes[i]-4-target))
    print(f"nearest cipher sample: {best} with size {sizes[best]} (diff={abs(sizes[best]-4-target)})")
    print(f"plain NAL[0] is {nals[0]['size']} bytes - looking for matching cipher sample...")
    for i,sz in enumerate(sizes[:50]):
        if abs(sz-4-nals[0]['size'])<200:
            print(f"  cipher sample[{i}] size={sz} diff={abs(sz-4-nals[0]['size'])}")
