# -*- coding: utf-8 -*-
"""用找到的密钥验证: 解密匹配样本应与明文一致; 恢复各样本IV, 找IV规律。"""
import json, struct
from Crypto.Cipher import AES
from Crypto.Util import Counter

K=bytes.fromhex("e65f045ea495e9cb439fa87fed02d756")
ksj=json.load(open("capture/e4_ks.json"))
pi0=ksj["pi"]; ci0=ksj["ci"]  # plain#pi0 <-> sample#ci0
plain=open("capture/e4_plain.h265","rb").read()
data=open("capture/e4_match.mp4","rb").read()

def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0];t=d[o+4:o+8];hs=8
        if sz==1:sz=struct.unpack(">Q",d[o+8:o+16])[0];hs=16
        elif sz==0:sz=e-o
        yield t,o,sz,hs;o+=sz
def find(d,p,s=0,e=None):
    if e is None:e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]:return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
def traks(d):
    mv=find(d,[b"moov"]);return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"] if mv else []
def u32(d,o):return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr):h=find(d,[b"mdia",b"hdlr"],*tr);return d[h[0]+8:h[0]+12]
def vs(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr);stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e);co64=find(d,[b"co64"],s,e);stsc=find(d,[b"stsc"],s,e)
    ss=u32(d,stsz[0]+4);cnt=u32(d,stsz[0]+8);sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    if stco:n=u32(d,stco[0]+4);ch=[u32(d,stco[0]+8+4*i) for i in range(n)]
    elif co64:n=u32(d,co64[0]+4);ch=[struct.unpack(">Q",d[co64[0]+8+8*i:co64[0]+16+8*i])[0] for i in range(n)]
    ne=u32(d,stsc[0]+4);runs=[(u32(d,stsc[0]+8+12*i),u32(d,stsc[0]+12+12*i),u32(d,stsc[0]+16+12*i)) for i in range(ne)];spc=[0]*len(ch)
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

mds=find(data,[b"mdat"])[0]
vt=[t for t in traks(data) if hdlr(data,t)==b"vide"][0]
sizes,offs=vs(data,vt)
# 明文 picture NAL 列表
pnals=[];i=0
while i+5<len(plain):
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4);sz=(j-i-4) if j>0 else len(plain)-i-4;nt=(plain[i+4]>>1)&0x3f
        if nt<22:pnals.append((i+4,sz,nt))
        i=j if j>0 else len(plain)
    else:i+=1

def ecb_dec(blk): return AES.new(K,AES.MODE_ECB).decrypt(blk)

print(f"key={K.hex()}  对齐: plain#{pi0}<->sample#{ci0}")
print("\n=== 恢复各样本 IV (counter@block0 = IV_sample) ===")
ivs=[]
for k in range(0,8):
    ci=ci0+k; pi=pi0+k
    if ci>=len(offs) or pi>=len(pnals): break
    co=offs[ci]; csz=sizes[ci]; po,psz,pt=pnals[pi]
    # keystream body
    n=min(64,csz-4,psz)
    ks=bytes(a^b for a,b in zip(data[co+4:co+4+n],plain[po:po+n]))
    # 样本原点=co; body在 co+4; block1 边界在 ks[12:28] (counter=IV+1)
    blk1=ks[12:28]
    ctr1=int.from_bytes(ecb_dec(blk1),"big")
    iv=(ctr1-1)%(1<<128)
    ivs.append((ci,co,csz,iv))
    print(f"  sample#{ci} co={co} mdatoff={co-mds} size={csz} IV={iv:032x}")

print("\n=== 验证: 用 K+IV 解密样本, 比对明文 ===")
ci,co,csz,iv=ivs[0]
po,psz,pt=pnals[pi0]
# AES-CTR 解密整个样本(从co起, 含4字节长度前缀)
ct=data[co:co+csz]
ctr=Counter.new(128,initial_value=iv)
dec=AES.new(K,AES.MODE_CTR,counter=ctr).decrypt(ct)
declen=struct.unpack(">I",dec[0:4])[0]
print(f"  解密样本#{ci}: 头4字节(NAL长度)={dec[0:4].hex()}={declen}, 期望={csz-4}")
print(f"  解密NAL头: {dec[4:6].hex()} (明文NAL头={plain[po:po+2].hex()})")
# 比对 body 与明文
match=dec[4:4+min(psz,csz-4)]==plain[po:po+min(psz,csz-4)]
print(f"  解密body == 抓取明文body? {match}")
if declen==csz-4 and match:
    print("  *** 完全验证通过! 密钥正确, IV方案正确 ***")

print("\n=== IV 规律分析 ===")
if len(ivs)>=2:
    for a,b in zip(ivs,ivs[1:]):
        diff=(b[3]-a[3])%(1<<128)
        print(f"  IV(s{b[0]})-IV(s{a[0]}) = {diff}  (=0x{diff:x}); 样本大小s{a[0]}={a[2]}")
json.dump({"key":K.hex(),"ivs":[(c,f"{v:032x}") for c,co,sz,v in ivs]},open("capture/key_ivs.json","w"),indent=2)
print("saved capture/key_ivs.json")
