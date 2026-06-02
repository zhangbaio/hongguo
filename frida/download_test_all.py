# -*- coding: utf-8 -*-
"""下载所有候选 URL 的前段(Range), 用 136 sync_keys 做无明文 NAL 合法性验证。
若 sync_dump 时正在解码的视频在这批 URL 里 -> 命中, 不需明文。"""
import json, struct, ssl, urllib.request, re
from Crypto.Cipher import AES

ctx=ssl.create_default_context(); ctx.check_hostname=False; ctx.verify_mode=ssl.CERT_NONE
urls=json.load(open("capture/atom_urls.json"))
keys=[bytes.fromhex(k["key"]) for k in json.load(open("capture/sync_keys.json"))]
print(f"{len(urls)} urls, {len(keys)} keys")

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
    mv=find(d,[b"moov"]); return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"] if mv else []
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
def samp0(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
    if not stsz or not stco: return None
    ss=u32(d,stsz[0]+4); sz0=ss if ss else u32(d,stsz[0]+12)
    return u32(d,stco[0]+8),sz0

def ecb(K,n): return AES.new(K,AES.MODE_ECB).encrypt((n%(1<<128)).to_bytes(16,"big"))
def valid(pt,sz):
    if len(pt)<5: return False
    L=struct.unpack(">I",pt[0:4])[0]; nh=pt[4]
    return 0<L<=sz-4 and (nh>>7)&1==0 and ((nh>>1)&0x3f)<=40

def get_kid(url, head):
    # kid 不在 mp4 里; 用 url 里没有. 只能 IV=0 / 或从内存. 这里 IV=0 + 简单候选
    return None

tested=0; hit=False
for idx,url in enumerate(urls):
    try:
        # 先拿前 600KB (覆盖 moov + sample0)
        req=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0","Range":"bytes=0-614399"})
        data=urllib.request.urlopen(req,timeout=15,context=ctx).read()
        if data[4:8]!=b'ftyp': continue
        mdat=find(data,[b"mdat"])
        if not mdat: continue
        mds=mdat[0]
        vt=[t for t in traks(data) if hdlr(data,t)==b"vide"]
        if not vt: continue
        r=samp0(data,vt[0])
        if not r: continue
        off0,sz0=r
        if off0+16>len(data): continue
        mo=off0-mds; rbb=mo%16; blk=mo//16
        cipher=data[off0:off0+16]
        tested+=1
        for ki,K in enumerate(keys):
            # IV=0 whole-mdat CTR
            ks=ecb(K,blk)
            # 处理 rb 偏移: 需要跨块, 简化 mo 多为0 -> rb=0
            if rbb==0:
                pt=bytes(a^b for a,b in zip(cipher,ks))
            else:
                ks2=ecb(K,blk)+ecb(K,blk+1)
                pt=bytes(a^b for a,b in zip(cipher,ks2[rbb:rbb+16]))
            if valid(pt,sz0):
                L=struct.unpack(">I",pt[0:4])[0]
                print(f"*** HIT url#{idx} key#{ki}={K.hex()} mo={mo} L={L} pt={pt[:8].hex()}")
                print(f"    url={url[:90]}")
                hit=True
        if tested%30==0: print(f"  tested {tested} ciphertexts, hit={hit}")
    except Exception as e:
        pass
print(f"done. tested={tested} hit={hit}")
