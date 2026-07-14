# -*- coding: utf-8 -*-
"""广扫 IV/counter 方案 x 28候选key, 无假设合法性检验(解密头: 0<L<=size-4 且合法NAL头)。"""
import struct, json
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
def valid(pt,sz):
    L=struct.unpack(">I",pt[0:4])[0]; nh=pt[4]
    return 0<L<=sz-4 and (nh>>7)&1==0 and ((nh>>1)&0x3f)<=40

keys=[bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]
KIDS={"hit1":"6a1165c8f8818be2b9fb87020002ebeb","hit3":"6a1165c8f8818b04e11464d90002ebeb"}

def ecb(K,n): return AES.new(K,AES.MODE_ECB).encrypt((n%(1<<128)).to_bytes(16,"big"))

for tag in ["hit3","hit1"]:
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mds=find(d,[b"mdat"])[0]
    vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    sizes,offs=samp(d,vt)
    kid=int.from_bytes(bytes.fromhex(KIDS[tag]),"big")
    N=min(150,len(sizes))
    print("="*60,tag,"samples",N)
    # 方案: 给定 key, 返回某样本i头5字节明文
    schemes={}
    # per-sample: counter = f(i,O); 样本头在 block 起点(r=0)
    schemes["ps_iv0"]      = lambda K,i,O: ecb(K,0)
    schemes["ps_iv_i"]     = lambda K,i,O: ecb(K,i)
    schemes["ps_iv_O"]     = lambda K,i,O: ecb(K,O)
    schemes["ps_iv_O//16"] = lambda K,i,O: ecb(K,O//16)
    schemes["ps_kid+i"]    = lambda K,i,O: ecb(K,kid+i)
    schemes["ps_kid+O//16"]= lambda K,i,O: ecb(K,kid+O//16)
    schemes["ps_kid^i"]    = lambda K,i,O: ecb(K,kid ^ i)
    best=("",0,-1)
    for ki,K in enumerate(keys):
        for sn,fn in schemes.items():
            hits=0;tot=0
            for i in range(1,N):
                O=offs[i]-mds; sz=sizes[i]
                ks=fn(K,i,O)  # 样本头按 block 起点取(per-sample CTR, r=0)
                pt=bytes(a^b for a,b in zip(d[offs[i]:offs[i]+5],ks[0:5]))
                tot+=1
                if valid(pt,sz): hits+=1
            if hits>=5:
                print(f"  *** key#{ki}={K.hex()} scheme={sn} hits={hits}/{tot}")
            if hits>best[1]: best=(f"key#{ki}/{sn}",hits,ki)
    print("  best:",best[0],"hits",best[1])
