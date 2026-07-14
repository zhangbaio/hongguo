# -*- coding: utf-8 -*-
"""从扫描到的 URL 里下载几个，找与 plain 的 sample0 大小最接近的"""
import urllib.request, struct, os

# 从 scan_all_urls 输出提取的 URL
URLS=[
    # bt=227, ds=6
    "https://111.32.228.129:8889/v5-reading-videocdn302.qznovelvod.com/db2b95b34abd8e85610661a6a0266325/6a1de778/video/tos/cn/tos-cn-v-6fcc8e/eaf70f4dc48749789980a153d0bbb685/?a=8662&bdcdn_rkey=vt80_tjhxcm66_acdn&br=227&bt=227&btag=80000e00028000&cd=0%7C0%7C0%7C1&cdn_type=2&ch=0&cr=7&cs=4&cts=0&cv=1&dr=0&ds=6&dy_q=1780323028&eid=59904&er=1&f41b4855=1&feature_id=da00c32a9fd407faa2a4401e464088a9&ft=BGyBnH7vh..NOlMY7QjVQ9tSdZLJ9E5ij4LMOuOCnz6QkZnUxRyqkZ&l=20260601221027973F5E7F53DC75BB8836&lr=default&mime_type=video_mp4&n80=1&n80_dm=bjk4LXYtcmVhZGluZ3ZpZGVvLnF6bm92ZWx2b2QuY29t&n80_tk=4d8188d7f344be245",
    # v5-bd-daily-reading-video 几个 URL (连续剧集)
    "https://v5-bd-daily-reading-video.qznovelvod.com/db2b95b34abd8e85610661a6a0266325/6a1de778/video/tos/cn/tos-cn-v-6fcc8e/eaf70f4dc48749789980a153d0bbb685/?a=8662&ch=0&cr=7&dr=0&er=1&lr=default&cd=0%7C0%7C0%7C1&cv=1&bt=227&cs=4&ds=6&ft=BGyBnH7vh..NOlMY7QjVQ9tSdZLJ9E5ij4LMOuOCnz6QkZnUxRyqkZ&mime_type=video_mp4&qs=0",
]
# 还有其他 URL - 先用 simple 格式
# From memory scan output, let me construct a few clean URLs
import re, json

# 读 plain NAL 结构
NALT={32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",19:"IDR_W",20:"IDR_N",21:"CRA",1:"TRAIL_R",0:"TRAIL_N"}
plain=open("capture/auto2_plain.h265","rb").read()
nals=[]; i=0
while i+4<len(plain) and len(nals)<15:
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4)
        sz=j-i-4 if j>0 else len(plain)-i-4
        nt=(plain[i+4]>>1)&0x3f
        nals.append({"off":i+4,"size":sz,"type":nt,"name":NALT.get(nt,str(nt))})
        i=j if j>0 else len(plain)
    else: i+=1
print(f"plain: {len(plain)} bytes, first 5 NALs: {[(n['name'],n['size']) for n in nals[:5]]}")

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

os.makedirs("capture/ct/scan",exist_ok=True)
for i,url in enumerate(URLS):
    path=f"capture/ct/scan/scan_{i}.mp4"
    try:
        req=urllib.request.Request(url.strip(),headers={"User-Agent":"Mozilla/5.0"})
        data=urllib.request.urlopen(req,timeout=30).read()
        open(path,"wb").write(data)
        ct=data; mds=find(ct,[b"mdat"])[0]
        vt=[t for t in traks(ct) if hdlr(ct,t)==b"vide"][0]
        off0,sz0=samp0(ct,vt)
        best=min(nals,key=lambda n: abs(n["size"]-(sz0-4)))
        diff=abs(best["size"]-(sz0-4))
        print(f"URL[{i}]: {len(data)}B sample0={sz0} best_plain={best['name']}({best['size']}) diff={diff}")
        if diff<500: print(f"  *** MATCH! diff={diff}")
    except Exception as e:
        print(f"URL[{i}]: FAIL {e}")
