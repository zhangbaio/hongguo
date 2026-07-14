# -*- coding: utf-8 -*-
"""用 136 个同步 dump 密钥验证所有可用的 plain+cipher 对"""
import json, struct, base64
from Crypto.Cipher import AES

keys=[bytes.fromhex(k["key"]) for k in json.load(open("capture/sync_keys.json"))]
print(f"Testing {len(keys)} keys")

NALT={32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",19:"IDR_W",20:"IDR_N",21:"CRA",1:"TRAIL_R",0:"TRAIL_N"}

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
def samp0(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
    ss=u32(d,stsz[0]+4); sz0=ss if ss else u32(d,stsz[0]+12)
    return u32(d,stco[0]+8),sz0

def parse_annexb(data,maxn=20):
    nals=[]; i=0
    while i+4<len(data) and len(nals)<maxn:
        if data[i:i+4]==b"\x00\x00\x00\x01":
            j=data.find(b"\x00\x00\x00\x01",i+4)
            sz=j-i-4 if j>0 else len(data)-i-4
            nt=(data[i+4]>>1)&0x3f
            nals.append({"off":i+4,"size":sz,"type":nt,"name":NALT.get(nt,str(nt))})
            i=j if j>0 else len(data)
        else: i+=1
    return nals

def ecb(K,n): return AES.new(K,AES.MODE_ECB).encrypt((n%(1<<128)).to_bytes(16,"big"))

def try_all_keys(cipher_path, plain_nals, kid_hex=None):
    """对给定密文文件，试所有 key × IV × alignment"""
    ct=open(cipher_path,"rb").read()
    mds=find(ct,[b"mdat"])[0]
    vt=[t for t in traks(ct) if hdlr(ct,t)==b"vide"][0]
    off0,sz0=samp0(ct,vt)
    mo=off0-mds; target=sz0-4
    # 找最匹配的 plain NAL
    pic_nals=[n for n in plain_nals if n["type"] in range(0,22)]
    if not pic_nals: return None
    match=min(pic_nals,key=lambda n: abs(n["size"]-target))
    diff=abs(match["size"]-target)
    print(f"  cipher={cipher_path.split('/')[-1]} s0={sz0} plain_match={match['name']}({match['size']}) diff={diff}")
    if diff>2000: return None  # 不对齐
    N=min(10000,match["size"],target)
    ks=bytes(c^p for c,p in zip(ct[off0+4:off0+4+N], open("capture/auto2_plain.h265","rb").read()[match["off"]:match["off"]+N]))
    rb=(mo+4)%16; blk0=(mo+4)//16
    full_blk=ks[16-rb:16-rb+16] if rb>0 and len(ks)>=16-rb+16 else ks[0:16]
    blk_idx=blk0+(1 if rb>0 else 0)
    kid=bytes.fromhex(kid_hex) if kid_hex else None
    for ki,K in enumerate(keys):
        for ivn,iv0 in [("0",0)]+([("kid_be",int.from_bytes(kid,"big")),("kid_le",int.from_bytes(kid,"little"))] if kid else []):
            if ecb(K,iv0+blk_idx)==full_blk:
                return {"key":K.hex(),"IV":ivn,"blk_idx":blk_idx,"kid":kid_hex,"cipher":cipher_path}
    return None

# 读 plain
plain=open("capture/auto2_plain.h265","rb").read()
plain_nals=parse_annexb(plain,maxn=100)
pic=[n for n in plain_nals if n["type"] in range(0,22)]
print(f"plain: {len(plain)} bytes, {len(pic)} pic NALs, first={pic[0]['name'] if pic else '?'} size={pic[0]['size'] if pic else '?'}")

# 试所有密文文件
import os, glob
cipher_files=(glob.glob("capture/ct/*.mp4")+glob.glob("capture/ct/fresh/*.mp4")+
              glob.glob("capture/ct/scan/*.mp4"))

KIDS={
    "live_current":"682165e3f8818b2123d6d8790003ebeb",
    "hit1_live":"682165f6f8818b5c0c3d8eac0002ebeb",
    "hit3_live":"6821663cf8818be54f9edf280003ebeb",
    "bpxb_1080p":"682165f6f8818b5c0c3d8eac0002ebeb",
}

for cf in cipher_files:
    try:
        tag=os.path.basename(cf).replace(".mp4","")
        kid=KIDS.get(tag)
        r=try_all_keys(cf,plain_nals,kid)
        if r:
            print(f"*** KEY FOUND! {r}")
            json.dump(r,open("capture/CONTENT_KEY.json","w"),indent=2)
    except Exception as e:
        print(f"  {cf}: err {e}")
print("done")
