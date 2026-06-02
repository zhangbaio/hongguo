# -*- coding: utf-8 -*-
"""用恢复的 key+IV方案 解密整个视频track, 重写mp4, ffmpeg验证可播。"""
import json, struct, subprocess
from Crypto.Cipher import AES
from Crypto.Util import Counter

K=bytes.fromhex("e65f045ea495e9cb439fa87fed02d756")
data=bytearray(open("capture/e4_match.mp4","rb").read())

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

dd=bytes(data)
vt=[t for t in traks(dd) if hdlr(dd,t)==b"vide"][0]
sizes,offs=vs(dd,vt)
BASE_V=0x8a3366122cfe6f54  # sample#0 的 IV 高64位 (= sample#1高位 - 1)
print(f"video samples={len(sizes)}, base_iv64={BASE_V:016x}")

def dec_sample(buf, idx):
    iv=((BASE_V+idx)<<64)  # 高64=base+序号, 低64=块计数器0
    ctr=Counter.new(128,initial_value=iv)
    return AES.new(K,AES.MODE_CTR,counter=ctr).decrypt(buf)

# 解密所有视频样本, 写回
okcnt=0
for idx,(co,sz) in enumerate(zip(offs,sizes)):
    pt=dec_sample(data[co:co+sz],idx)
    # 校验: 头4字节=NAL长度链应等于 sz (单或多NAL)
    p=0; valid=True
    while p+4<=sz:
        ln=struct.unpack(">I",pt[p:p+4])[0]
        if ln==0 or p+4+ln>sz: valid=False; break
        p+=4+ln
    if p==sz: okcnt+=1
    data[co:co+sz]=pt
print(f"video samples decrypted, NAL-structure valid: {okcnt}/{len(sizes)}")

open("capture/decrypted_video.mp4","wb").write(data)
print("wrote capture/decrypted_video.mp4")

# ffmpeg 验证视频解码(只看video track, 音频未解密会报错正常)
r=subprocess.run(["ffmpeg","-v","error","-i","capture/decrypted_video.mp4","-map","0:v:0","-t","5","-f","null","-"],
                 capture_output=True,text=True)
print("--- ffmpeg video decode stderr (空=完美) ---")
print(r.stderr[:800] if r.stderr else "(无错误, 视频完整解码!)")
# 抽一帧存图
subprocess.run(["ffmpeg","-y","-v","error","-i","capture/decrypted_video.mp4","-map","0:v:0","-frames:v","1","capture/decrypted_frame.jpg"],capture_output=True)
import os
if os.path.exists("capture/decrypted_frame.jpg"):
    print(f"抽帧成功: capture/decrypted_frame.jpg ({os.path.getsize('capture/decrypted_frame.jpg')} bytes)")
