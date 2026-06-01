# -*- coding: utf-8 -*-
import urllib.request, struct

URL="https://v95-hzyy-thr-daily-reading-videocdn.qznovelvod.com/6bcd71f0e1c6a0321a714925867dbc3e/6a1dac05/video/tos/cn/tos-cn-v-6fcc8e/o81PH9IQhsBisiFnDHe61CvMplBXAALEYQ2awc/?a=8662&ch=0&cr=7&dr=0&er=1&lr=default&cd=0%7C0%7C0%7C1&cv=1&bt=983&cs=4&ds=4&ft=BGyBnH7vh..NOlMY7QjVQ9tSdZLJ9E5im4m_GuOCnz6QkZnUxRyqkZ&mime_type=video_mp4&qs=0&rc=PGk6NzM8ZzhnM2c0NjNnNEBpM3R3Nm85cndwMzMzNGhoM0AzYDMuYzUzXjQxYC0xMmNhYSNqZS5sMmRrX2RhLS1kXy9zcw%3D%3D&ult=1332&btag=80000e00028000&cdn_type=2&dy_q=1780307781&feature_id=da00c32a9fd407faa2a4401e464088a9&l=202606011756217D5706ED9C9261E2AB7F&n80=1&n80_dm=bjk4LXYtcmVhZGluZ3ZpZGVvLnF6bm92ZWx2b2QuY29t&n80_tk=7e08e6671dd63e3da75fd46c292ef825&pwid=294&req_cdn_type=r"

print("downloading 1080p ciphertext (kid=682165f6)...")
req=urllib.request.Request(URL, headers={"User-Agent":"Mozilla/5.0"})
data=urllib.request.urlopen(req,timeout=60).read()
open("capture/ct/bpxb_1080p.mp4","wb").write(data)
print(f"downloaded: {len(data)} bytes")

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
def samp(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
    ss=u32(d,stsz[0]+4); cnt=u32(d,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(min(cnt,10))]
    n=u32(d,stco[0]+4); chunks=[u32(d,stco[0]+8+4*i) for i in range(min(n,3))]
    return sizes, chunks[0]
mds=find(data,[b"mdat"])[0]
vt=[t for t in traks(data) if hdlr(data,t)==b"vide"][0]
sizes,off0=samp(data,vt)
mo=off0-mds
print(f"mdat={mds} off0={off0} mdatoff={mo} sample0_size={sizes[0]}")
print(f"first 5 sample sizes: {sizes[:5]}")
print(f"cipher s0[0:8]: {data[off0:off0+8].hex()}")
# 计算最大样本(IDR候选)
print(f"max sample size: {max(sizes[:10])}")
