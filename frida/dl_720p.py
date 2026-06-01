# -*- coding: utf-8 -*-
"""下载 720p 密文 + 对齐 510KB 明文 + 计算 keystream"""
import sqlite3, re, struct, json, urllib.request, os
from Crypto.Cipher import AES

TARGET_KID="6960e8ebf8818bad6286db200002ebeb"
SPADE_A="lbwbxGKzGMhigyXMbbEU/VqHIv9qryfTW4MK+Vq2CvhEtAyJiQ=="

conn=sqlite3.connect("capture/series_download_db.sqlite")
rows=conn.execute("SELECT video_id,video_model FROM t_series_video_model").fetchall()
conn.close()

urls={}
for vid,vm_str in rows:
    if not vm_str or TARGET_KID not in vm_str: continue
    for m in re.finditer(r'"main_url"\s*:\s*"(https://[^"]+)"', vm_str):
        url=m.group(1)
        bt_m=re.search(r'bt=(\d+)',url); ds_m=re.search(r'ds=(\d+)',url)
        if bt_m and ds_m:
            bt=int(bt_m.group(1)); ds=int(ds_m.group(1))
            urls[(bt,ds)]=url
    break

print("Available URLs:")
for (bt,ds),url in sorted(urls.items()):
    print(f"  bt={bt} ds={ds}: {url[:80]}")

# 下载 720p (bt=460, ds=4)
best=max(urls.keys(), key=lambda x: x[0])
url=urls[best]; tag=f"bt{best[0]}_ds{best[1]}"
path=f"capture/ct/auto_{tag}.mp4"
if not os.path.exists(path):
    print(f"downloading {tag}...")
    try:
        req=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"})
        data=urllib.request.urlopen(req,timeout=60).read()
        open(path,"wb").write(data); print(f"  saved {len(data)} bytes")
    except Exception as e:
        print(f"  FAILED: {e}")
        path=None
else:
    print(f"exists: {path} {os.path.getsize(path)} bytes")

if not path: exit(1)

# 解析密文
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

ct=open(path,"rb").read()
mds=find(ct,[b"mdat"])[0]
vt=[t for t in traks(ct) if hdlr(ct,t)==b"vide"][0]
off0,sz0=samp0(ct,vt)
mo=off0-mds
print(f"cipher: mdat={mds} off0={off0} mdatoff={mo} sample0_size={sz0}")

# 解析明文 NALs
NALT={32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",19:"IDR_W",20:"IDR_N",21:"CRA",1:"TRAIL_R",0:"TRAIL_N"}
plain=open("capture/auto2_plain.h265","rb").read()
nals=[]; i=0
while i+4<len(plain) and len(nals)<50:
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4)
        sz=j-i-4 if j>0 else len(plain)-i-4
        nt=(plain[i+4]>>1)&0x3f
        nals.append({"off":i+4,"size":sz,"type":nt,"name":NALT.get(nt,str(nt))})
        i=j if j>0 else len(plain)
    else: i+=1
print(f"plain: {len(plain)} bytes, {len(nals)} NALs")
print(f"first 5: {[(n['name'],n['size']) for n in nals[:5]]}")

# 找最接近 cipher sample0 的 NAL
target=sz0-4
match=min(nals,key=lambda n: abs(n["size"]-target))
diff=abs(match["size"]-target)
print(f"best match: [{match['name']}] size={match['size']} vs target={target} diff={diff}")

if diff<1000:
    print("\n=== COMPUTING KEYSTREAM ===")
    N=min(15000,match["size"],sz0-4)
    ks=bytes(c^p for c,p in zip(ct[off0+4:off0+4+N], plain[match["off"]:match["off"]+N]))
    rb=(mo+4)%16; blk0=(mo+4)//16
    if rb>0 and len(ks)>=16-rb+16:
        full_blk=ks[16-rb:16-rb+16]; blk_idx=blk0+1
    else:
        full_blk=ks[0:16]; blk_idx=blk0
    print(f"keystream[0:32]: {ks[:32].hex()}")
    print(f"full AES block {blk_idx}: {full_blk.hex()}")
    KID=bytes.fromhex(TARGET_KID)
    cands=[bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]
    print(f"testing {len(cands)} candidate keys...")
    for ki,K in enumerate(cands):
        for ivn,iv0 in [("0",0),("kid_be",int.from_bytes(KID,"big")),("kid_le",int.from_bytes(KID,"little"))]:
            if AES.new(K,AES.MODE_ECB).encrypt(((iv0+blk_idx)%(1<<128)).to_bytes(16,"big"))==full_blk:
                print(f"*** KEY FOUND! key#{ki}={K.hex()} IV={ivn}")
    json.dump({"ks32":ks[:32].hex(),"full_blk":full_blk.hex(),"blk_idx":blk_idx,"kid":TARGET_KID},
              open("capture/ks_auto.json","w"))
    print("saved capture/ks_auto.json")
else:
    print("sizes don't match")
