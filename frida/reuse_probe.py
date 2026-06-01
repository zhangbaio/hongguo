# -*- coding: utf-8 -*-
"""判别加密模式: 对单NAL视频样本, 算 cipher[0:4] XOR (size-4)。
若跨样本常量 -> 逐样本CTR+固定IV(keystream复用)。也看样本起点相对 mdat 的 16 对齐分布。"""
import struct
from collections import Counter
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
def samp_offsets(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e);co64=find(d,[b"co64"],s,e);stsc=find(d,[b"stsc"],s,e)
    ss=u32(d,stsz[0]+4);cnt=u32(d,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    if stco: n=u32(d,stco[0]+4);ch=[u32(d,stco[0]+8+4*i) for i in range(n)]
    else: n=u32(d,co64[0]+4);ch=[struct.unpack(">Q",d[co64[0]+8+8*i:co64[0]+16+8*i])[0] for i in range(n)]
    ne=u32(d,stsc[0]+4);runs=[(u32(d,stsc[0]+8+12*i),u32(d,stsc[0]+12+12*i),u32(d,stsc[0]+16+12*i)) for i in range(ne)]
    spc=[0]*len(ch)
    for i,(fc,sp,sd) in enumerate(runs):
        last=runs[i+1][0]-1 if i+1<len(runs) else len(ch)
        for c in range(fc,last+1):
            if 1<=c<=len(ch): spc[c-1]=sp
    offs=[];si=0
    for c in range(len(ch)):
        off=ch[c]
        for _ in range(spc[c]):
            if si>=cnt:break
            offs.append(off);off+=sizes[si];si+=1
    return sizes,offs

for tag in ["hit1","hit3"]:
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mds=find(d,[b"mdat"])[0]
    vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    sizes,offs=samp_offsets(d,vt)
    print("="*60,tag,"video samples",len(sizes))
    # 对齐分布
    align=Counter((o-mds)%16 for o in offs)
    print("  样本起点 mod16 分布(前5):", align.most_common(5))
    # cipher[0:4] XOR (size-4) for samples 1..30
    print("  样本[i] mdatoff size  cipher0:4  xor(size-4)")
    xors=[]
    for i in range(1,31):
        o=offs[i]; sz=sizes[i]; c4=d[o:o+4]
        x=bytes(a^b for a,b in zip(c4,struct.pack(">I",sz-4)))
        xors.append(x)
        if i<=12:
            print(f"    s{i:<3d} {o-mds:<8d} {sz:<6d} {c4.hex()}  {x.hex()}")
    uniq=Counter(xors)
    print("  XOR(size-4) 去重数:", len(uniq), " 最常见:", [(x.hex(),n) for x,n in uniq.most_common(3)])
