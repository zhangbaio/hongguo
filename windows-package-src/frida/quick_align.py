# -*- coding: utf-8 -*-
"""快速对齐检查: 扫明文 NALs, 找与密文 sample0 大小最接近的 IDR/大NAL"""
import struct, json
from Crypto.Cipher import AES

NALT={32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",19:"IDR_W",20:"IDR_N",
      21:"CRA",1:"TRAIL_R",0:"TRAIL_N",16:"BLA_W",17:"BLA_W_RADL",18:"BLA_N",
      22:"RSV_IRAP"}

def parse_annexb_all(data):
    nals=[]; i=0; seen=0
    while i+4<len(data):
        if data[i:i+4]==b"\x00\x00\x00\x01":
            j=data.find(b"\x00\x00\x00\x01",i+4)
            sz=j-i-4 if j>0 else len(data)-i-4
            nh=data[i+4] if i+4<len(data) else 0
            nt=(nh>>1)&0x3f
            nals.append({"off":i+4,"size":sz,"type":nt,"name":NALT.get(nt,str(nt))})
            i=j if j>0 else len(data)
        else: i+=1
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
    n=u32(d,stco[0]+4); ch=[u32(d,stco[0]+8+4*i) for i in range(n)]
    return sizes, ch[0]

import sys
plain_file = sys.argv[1] if len(sys.argv)>1 else "capture/bpxb_plain2.h265"
plain = open(plain_file,"rb").read()
nals = parse_annexb_all(plain)
ct   = open("capture/ct/bpxb_1080p.mp4","rb").read()
mds=find(ct,[b"mdat"])[0]
vt=[t for t in traks(ct) if hdlr(ct,t)==b"vide"][0]
sizes,off0=all_samps(ct,vt)
mo=off0-mds; target=sizes[0]-4

print(f"plain {len(plain)//1024}KB, {len(nals)} NALs")
print(f"cipher sample0: {sizes[0]} bytes (NAL body {target})")

# 找所有大 NAL (>10KB)
big = [(i,n) for i,n in enumerate(nals) if n["size"]>10000]
print(f"big NALs (>10KB): {len(big)}")
for i,n in big[:10]:
    diff=abs(n["size"]-target)
    print(f"  NAL[{i:4d}] [{n['name']:8s}] size={n['size']:6d} diff={diff} off={n['off']}")

if big:
    # 最匹配的大 NAL
    best_i, best_n = min(big, key=lambda x: abs(x[1]["size"]-target))
    diff = abs(best_n["size"]-target)
    print(f"\nbest match: NAL[{best_i}] size={best_n['size']} diff={diff}")
    if diff < 500:
        print("=== COMPUTING KEYSTREAM ===")
        N = min(15000, best_n["size"], target)
        cipher_nal = ct[off0+4:off0+4+N]
        plain_nal  = plain[best_n["off"]:best_n["off"]+N]
        ks = bytes(c^p for c,p in zip(cipher_nal, plain_nal))
        rb=(mo+4)%16; blk0=(mo+4)//16
        if rb>0 and len(ks)>=16-rb+16:
            full_blk=ks[16-rb:16-rb+16]; blk_idx=blk0+1
        else:
            full_blk=ks[0:16]; blk_idx=blk0
        print(f"keystream[0:48]: {ks[:48].hex()}")
        print(f"AES block {blk_idx}: {full_blk.hex()}")
        # 验证候选密钥
        KID=bytes.fromhex("682165f6f8818b5c0c3d8eac0002ebeb")
        cands=[bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]
        for ki,K in enumerate(cands):
            for ivn,iv0 in [("0",0),("kid_be",int.from_bytes(KID,"big")),("kid_le",int.from_bytes(KID,"little"))]:
                if AES.new(K,AES.MODE_ECB).encrypt(((iv0+blk_idx)%(1<<128)).to_bytes(16,"big"))==full_blk:
                    print(f"*** KEY FOUND! {K.hex()} IV={ivn} blk={blk_idx}")
        json.dump({"full_blk":full_blk.hex(),"blk_idx":blk_idx,
                   "ks32":ks[:32].hex(),"kid":KID.hex()},
                  open("capture/ks_aligned.json","w"))
        print("saved ks_aligned.json")
    else:
        print(f"still mismatched (diff={diff})")
        # 显示分布
        sizes_plain = sorted([n["size"] for n in nals], reverse=True)[:5]
        print(f"top 5 plain NAL sizes: {sizes_plain}")
        print(f"cipher sample sizes[:5]: {sizes[:5]}")
