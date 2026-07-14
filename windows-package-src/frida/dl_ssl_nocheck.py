# -*- coding: utf-8 -*-
"""下载 CDN URL, 不验证 SSL (用于 IP 地址形式的 URL)"""
import ssl, urllib.request, struct, json, os

ctx=ssl.create_default_context()
ctx.check_hostname=False; ctx.verify_mode=ssl.CERT_NONE

URLS=[
    # bt=227 ds=6 (IP CDN)
    "https://111.32.228.129:8889/v5-reading-videocdn302.qznovelvod.com/db2b95b34abd8e85610661a6a0266325/6a1de778/video/tos/cn/tos-cn-v-6fcc8e/eaf70f4dc48749789980a153d0bbb685/?a=8662&bdcdn_rkey=vt80_tjhxcm66_acdn&br=227&bt=227&btag=80000e00028000&cd=0%7C0%7C0%7C1&cdn_type=2&ch=0&cr=7&cs=4&cts=0&cv=1&dr=0&ds=6&dy_q=1780323028&eid=59904&er=1&f41b4855=1&feature_id=da00c32a9fd407faa2a4401e464088a9&ft=BGyBnH7vh..NOlMY7QjVQ9tSdZLJ9E5ij4LMOuOCnz6QkZnUxRyqkZ&l=20260601221027973F5E7F53DC75BB8836&lr=default&mime_type=video_mp4&n80=1&n80_dm=bjk4LXYtcmVhZGluZ3ZpZGVvLnF6bm92ZWx2b2QuY29t&n80_tk=4d8188d7f344be245",
    # v81-reading-videocdn 的同路径
    "https://v81-reading-videocdn.qznovelvod.com/db2b95b34abd8e85610661a6a0266325/6a1de778/video/tos/cn/tos-cn-v-6fcc8e/eaf70f4dc48749789980a153d0bbb685/?a=8662&br=227&bt=227&ch=0&cr=7&cv=1",
    # v5-reading-videocdn302 (standard)
    "https://v5-reading-videocdn302.qznovelvod.com/db2b95b34abd8e85610661a6a0266325/6a1de778/video/tos/cn/tos-cn-v-6fcc8e/eaf70f4dc48749789980a153d0bbb685/?a=8662&bt=227&ch=0&cr=7",
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

os.makedirs("capture/ct/fresh2",exist_ok=True)
for i,url in enumerate(URLS):
    try:
        req=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"})
        data=urllib.request.urlopen(req,timeout=30,context=ctx).read()
        path=f"capture/ct/fresh2/u{i}.mp4"
        open(path,"wb").write(data)
        mds=find(data,[b"mdat"])[0]
        vt=[t for t in traks(data) if hdlr(data,t)==b"vide"][0]
        off0,sz0=samp0(data,vt)
        print(f"URL[{i}]: {len(data)}B s0={sz0}")
        # first IDR in plain
        plain=open("capture/auto2_plain.h265","rb").read()
        # check plain NAL sizes against s0
        j=0; pic_nals=[]
        while j+4<len(plain):
            if plain[j:j+4]==b"\x00\x00\x00\x01":
                k=plain.find(b"\x00\x00\x00\x01",j+4)
                sz=k-j-4 if k>0 else len(plain)-j-4
                nt=(plain[j+4]>>1)&0x3f
                if nt<22: pic_nals.append((j+4,sz,nt))
                j=k if k>0 else len(plain)
            else: j+=1
        if pic_nals:
            best=min(pic_nals,key=lambda n:abs(n[1]-(sz0-4)))
            diff=abs(best[1]-(sz0-4))
            print(f"  best plain: type={best[2]} size={best[1]} diff={diff}")
    except Exception as e:
        print(f"URL[{i}]: {str(e)[:80]}")
