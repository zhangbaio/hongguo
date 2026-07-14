# -*- coding: utf-8 -*-
"""whole-mdat AES-CTR 假设: counter(O)=IV_int + O//16, 明文样本头4字节=size-4(单NAL)。
对每个候选key × IV假设, 在视频样本长度前缀上数命中。真 key+IV 大量命中。"""
import struct, json, base64
from Crypto.Cipher import AES
def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0]; t=d[o+4:o+8]; hs=8
        if sz==1: sz=struct.unpack(">Q",d[o+8:o+16])[0]; hs=16
        elif sz==0: sz=e-o
        yield t,o,sz,hs
        if sz<=0:break
        o+=sz
def find(d,p,s=0,e=None):
    if e is None:e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]: return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
def traks(d):
    mv=find(d,[b"moov"]); return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"]
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
def samp(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e);co64=find(d,[b"co64"],s,e);stsc=find(d,[b"stsc"],s,e)
    ss=u32(d,stsz[0]+4);cnt=u32(d,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    if stco:n=u32(d,stco[0]+4);ch=[u32(d,stco[0]+8+4*i) for i in range(n)]
    else:n=u32(d,co64[0]+4);ch=[struct.unpack(">Q",d[co64[0]+8+8*i:co64[0]+16+8*i])[0] for i in range(n)]
    ne=u32(d,stsc[0]+4);runs=[(u32(d,stsc[0]+8+12*i),u32(d,stsc[0]+12+12*i),u32(d,stsc[0]+16+12*i)) for i in range(ne)]
    spc=[0]*len(ch)
    for i,(fc,sp,sd) in enumerate(runs):
        last=runs[i+1][0]-1 if i+1<len(runs) else len(ch)
        for c in range(fc,last+1):
            if 1<=c<=len(ch):spc[c-1]=sp
    offs=[];si=0
    for c in range(len(ch)):
        off=ch[c]
        for _ in range(spc[c]):
            if si>=cnt:break
            offs.append(off);off+=sizes[si];si+=1
    return sizes,offs

keys=[bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]
meta=json.load(open("capture/hits_meta.json"))
# kid/spade 从 escaped hit 文本里取
import re
def get_meta(tag):
    t=open(f"capture/mem_hit_{'1' if tag=='hit1' else '3'}.txt",encoding="utf-8").read()
    return None  # 用已知: hit1/hit3 的 kid 来自旧 hits, 直接给
KIDS={"hit1":"6a1165c8f8818be2b9fb87020002ebeb","hit3":"6a1165c8f8818b04e11464d90002ebeb"}

def ctr_block(K, iv_int, blk):
    ctr=((iv_int+blk) % (1<<128)).to_bytes(16,"big")
    return AES.new(K,AES.MODE_ECB).encrypt(ctr)

for tag in ["hit1","hit3"]:
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mds=find(d,[b"mdat"])[0]
    vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    sizes,offs=samp(d,vt)
    kid=bytes.fromhex(KIDS[tag])
    ivset={"zero":0,"kid_be":int.from_bytes(kid,"big"),"kid_le":int.from_bytes(kid,"little")}
    print("="*60,tag,"testing",len(keys),"keys x",len(ivset),"IVs on",min(200,len(sizes)),"samples")
    best=None
    for ki,K in enumerate(keys):
        for ivn,iv0 in ivset.items():
            hits=0; tot=0
            for i in range(1,min(200,len(sizes))):
                O=offs[i]-mds; sz=sizes[i]; r=O%16
                if r>11: continue
                tot+=1
                ks=ctr_block(K,iv0,O//16)
                pt=bytes(a^b for a,b in zip(d[offs[i]:offs[i]+5],ks[r:r+5]))
                L=struct.unpack(">I",pt[0:4])[0]; nh=pt[4]
                if 0<L<=sz-4 and (nh>>7)&1==0 and ((nh>>1)&0x3f)<=40: hits+=1
            if hits>=5:
                print(f"  *** key#{ki}={K.hex()} IV={ivn} hits={hits}/{tot}")
            if best is None or hits>best[0]: best=(hits,ki,ivn,tot)
    print(f"  best: hits={best[0]}/{best[3]} key#{best[1]} IV={best[2]}")
