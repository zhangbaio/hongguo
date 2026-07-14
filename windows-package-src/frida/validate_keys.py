# -*- coding: utf-8 -*-
"""用对齐密文验证 aeskeyfind 找到的 28 个密钥 + 推断 IV。
对 video 样本: 解密后 [0:4]=大端 NAL 长度(应<样本size), [4]=合法 HEVC NAL 头。"""
import json, struct, base64
try:
    from Crypto.Cipher import AES
except ImportError:
    import sys, subprocess; subprocess.run([sys.executable,"-m","pip","install","pycryptodome","-q"]); from Crypto.Cipher import AES

def iter_boxes(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0]; t=d[o+4:o+8]; hs=8
        if sz==1: sz=struct.unpack(">Q",d[o+8:o+16])[0]; hs=16
        elif sz==0: sz=e-o
        yield t,o,sz,hs
        if sz<=0: break
        o+=sz
def find(d,path,s=0,e=None):
    if e is None: e=len(d)
    for t,o,sz,hs in iter_boxes(d,s,e):
        if t==path[0]: return (o+hs,o+sz) if len(path)==1 else find(d,path[1:],o+hs,o+sz)
    return None
def traks(d):
    mv=find(d,[b"moov"]); return [(o+hs,o+sz) for t,o,sz,hs in iter_boxes(d,*mv) if t==b"trak"]
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr):
    h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
def first_sample(d,tr):
    stbl=find(d,[b"mdia",b"minf",b"stbl"],*tr); s,e=stbl
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e); co64=find(d,[b"co64"],s,e)
    ss=u32(d,stsz[0]+4); cnt=u32(d,stsz[0]+8)
    size0 = ss if ss else u32(d,stsz[0]+12)
    if stco: off0=u32(d,stco[0]+8)
    else: off0=struct.unpack(">Q",d[co64[0]+8:co64[0]+16])[0]
    return off0,size0,cnt

NALOK=set(range(0,41))
def plausible_video(pt, size):
    L=struct.unpack(">I",pt[0:4])[0]
    if not (0<L<=size-4): return False
    nh=pt[4]; fzb=(nh>>7)&1; nt=(nh>>1)&0x3f
    return fzb==0 and nt in NALOK, L, nt

meta=json.load(open("capture/hits_meta.json"))
keys=[bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]
print(f"{len(keys)} candidate keys loaded")

def ivset(kid_hex, spade_b64):
    kid=bytes.fromhex(kid_hex); sp=base64.b64decode(spade_b64)
    ivs={"zero":b"\x00"*16, "kid":kid, "kid_rev":kid[::-1],
         "spade0_16":sp[0:16], "spade16_32":sp[16:32], "kid_lo8":kid[8:16]+b"\x00"*8,
         "kid_hi8":kid[0:8]+b"\x00"*8}
    return ivs

for fn,m in meta.items():
    tag="hit1" if "1" in fn else "hit3"
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mdat=find(d,[b"mdat"])[0]
    print("="*60,tag,"kid=",m["kid"])
    # 拿 video trak 的首样本密文
    vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    voff,vsize,vcnt=first_sample(d,vt)
    cipher=d[voff:voff+32]
    print(f"  video s0 fileoff={voff} mdatoff={voff-mdat} size={vsize} cipher0={cipher[:16].hex()}")
    ivs=ivset(m["kid"], m["spade_a"])
    hit=False
    for ki,K in enumerate(keys):
        for ivn,iv in ivs.items():
            ks=AES.new(K,AES.MODE_ECB).encrypt(iv)  # block0 keystream
            pt=bytes(c^k for c,k in zip(cipher[:16],ks))
            r=plausible_video(pt,vsize)
            if r and r[0]:
                print(f"  >>> HIT key#{ki}={K.hex()} IV={ivn}({iv.hex()}) -> NALlen={r[1]} naltype={r[2]} pt={pt.hex()}")
                hit=True
    if not hit:
        print("  no first-block hit on video s0 with tested IVs")
