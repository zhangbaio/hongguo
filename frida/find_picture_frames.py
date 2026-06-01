# -*- coding: utf-8 -*-
"""分析 auto2_plain.h265 的 NAL 结构，找第一个图像帧"""
import re, urllib.request, struct, os, json
from Crypto.Cipher import AES

NALT={32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",40:"SEI_S",
      19:"IDR_W",20:"IDR_N",21:"CRA",1:"TRAIL_R",0:"TRAIL_N",
      2:"TSA_N",3:"TSA_R",4:"STSA_N",5:"STSA_R",6:"RADL_N",7:"RADL_R",
      8:"RASL_N",9:"RASL_R"}
PICTURE_TYPES=set(range(0,22))  # slice types (0-21)
PARAM_TYPES={32,33,34,35,39,40}  # VPS,SPS,PPS,AUD,SEI

plain=open("capture/auto2_plain.h265","rb").read()
nals=[]; i=0
while i+4<len(plain):
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4)
        sz=j-i-4 if j>0 else len(plain)-i-4
        nt=(plain[i+4]>>1)&0x3f
        nals.append({"off":i+4,"size":sz,"type":nt,"name":NALT.get(nt,str(nt))})
        i=j if j>0 else len(plain)
    else: i+=1

print(f"Total NALs: {len(nals)}")
pic_nals=[n for n in nals if n["type"] in PICTURE_TYPES]
param_nals=[n for n in nals if n["type"] in PARAM_TYPES]
print(f"Picture NALs: {len(pic_nals)}, Param NALs: {len(param_nals)}")
if pic_nals:
    first_pic=pic_nals[0]
    print(f"First picture NAL: [{first_pic['name']}] off={first_pic['off']} size={first_pic['size']}")
    print(f"First 5 picture: {[(n['name'],n['size']) for n in pic_nals[:5]]}")

# 尝试下载 fresh URL
FRESH_URLS=[
    # 从 scan_all_urls 的输出（非 IP 版本）
    "https://v5-bd-daily-reading-video.qznovelvod.com/db2b95b34abd8e85610661a6a0266325/6a1de778/video/tos/cn/tos-cn-v-6fcc8e/eaf70f4dc48749789980a153d0bbb685/?a=8662&ch=0&cr=7&dr=0&er=1&lr=default&cd=0%7C0%7C0%7C1&cv=1&bt=227&cs=4&ds=6&ft=BGyBnH7vh..NOlMY7QjVQ9tSdZLJ9E5ij4LMOuOCnz6QkZnUxRyqkZ&mime_type=video_mp4&qs=0",
    # v5-bd-daily 系列 (6a1da557)
    "https://v5-bd-daily-reading-video.qznovelvod.com/7c27e187f9446a4dee1b1d7562b12417/6a1da557/video/tos/cn/tos-cn-v-6fcc8e/oQwqJBfYDDWxQ5kqgIiwFkCBwfUZIdYiArB0VE/?a=8662&ch=0&cr=7&dr=0&er=1&lr=default&cd=0%7C0%7C0%7C1&cv=1",
    "https://v5-bd-daily-reading-video.qznovelvod.com/22a2222c204949f26f0222a974df3e03/6a1da557/video/tos/cn/tos-cn-v-6fcc8e/oseDABWffjIDEOWWCAMOifVOmCoAREBvdjQB8j/?a=8662",
    # 6a1dac0b
    "https://v6-daily-reading-videocdn.qznovelvod.com/c201c0e7d0a7f94d3e4ecd99acc6f375/6a1dac0b/video/tos/cn/tos-cn-v-6fcc8e/owQr4FouWBFnAyD6IfIAxDggEtLQiIiVVOFD5f/?a=8662",
    "https://v6-daily-reading-videocdn.qznovelvod.com/fa220cc303cfb0ba9f5652338ed294b2/6a1dac0b/video/tos/cn/tos-cn-v-6fcc8e/oMyIEADFVQei35gguNrInFIWWiGVDfHBDAXoQc/?a=8662",
]

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

os.makedirs("capture/ct/fresh",exist_ok=True)
print("\n=== Trying fresh URLs ===")
for i,url in enumerate(FRESH_URLS):
    try:
        req=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"})
        data=urllib.request.urlopen(req,timeout=30).read()
        path=f"capture/ct/fresh/f{i}.mp4"
        open(path,"wb").write(data)
        mds=find(data,[b"mdat"])[0]
        vt=[t for t in traks(data) if hdlr(data,t)==b"vide"][0]
        off0,sz0=samp0(data,vt)
        mo=off0-mds
        target=sz0-4
        if pic_nals:
            best=min(pic_nals,key=lambda n: abs(n["size"]-target))
            diff=abs(best["size"]-target)
            print(f"  URL[{i}]: {len(data)}B sample0={sz0} first_pic={pic_nals[0]['size']} diff={diff}")
            if diff<1000: print(f"  *** POTENTIAL MATCH diff={diff}")
        else:
            print(f"  URL[{i}]: {len(data)}B sample0={sz0}")
    except Exception as e:
        print(f"  URL[{i}]: FAIL {str(e)[:80]}")
