# -*- coding: utf-8 -*-
import struct

NALT={32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",19:"IDR_W",20:"IDR_N",21:"CRA",1:"TRAIL_R",0:"TRAIL_N"}

plain = open("capture/live_video_raw.h265","rb").read()
print(f"ES size: {len(plain)} bytes")

# 解析前10个 Annex-B NAL
i=0; count=0
while i+4<len(plain) and count<10:
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        nh=plain[i+4]; nt=(nh>>1)&0x3f
        j=plain.find(b"\x00\x00\x00\x01",i+4)
        sz=j-i-4 if j>0 else len(plain)-i-4
        print(f"  NAL[{count}] @{i}: type={nt}({NALT.get(nt,'?')}) size={sz}")
        count+=1; i=j if j>0 else len(plain)
    else: i+=1

print()

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
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(min(cnt,20))]
    n=u32(d,stco[0]+4); chunks=[u32(d,stco[0]+8+4*i) for i in range(min(n,5))]
    return sizes, chunks[0]

for tag in ["hit1_live","hit3_live"]:
    path = f"capture/ct/{tag}.mp4"
    try: ct=open(path,"rb").read()
    except: print(f"{tag}: not found"); continue
    mds=find(ct,[b"mdat"])[0]
    vt=[t for t in traks(ct) if hdlr(ct,t)==b"vide"][0]
    sizes,off0=samp(ct,vt)
    mo=off0-mds
    print(f"=== {tag}: mdat={mds} s0_off={off0} mdatoff={mo} s0_size={sizes[0]} ===")
    print(f"  cipher s0[0:8]: {ct[off0:off0+8].hex()}")
    # 如果对齐: plain[0:4]=00000001, 那么 ks[0:4] = cipher[off0:off0+4] XOR 00000001
    ks04 = bytes(a^b for a,b in zip(ct[off0:off0+4],b"\x00\x00\x00\x01"))
    print(f"  ks[0:4] if aligned (Annex-B): {ks04.hex()} -> uint32={struct.unpack('>I',ks04)[0]}")
    # 如果是 hvc1 length-prefix 对齐: plain[0:4] = size-4
    expected_len = (sizes[0]-4).to_bytes(4,"big")
    ks04_hvc1 = bytes(a^b for a,b in zip(ct[off0:off0+4],expected_len))
    print(f"  ks[0:4] if hvc1-aligned: {ks04_hvc1.hex()} (plain was size-4={sizes[0]-4})")
    print(f"  first sample sizes[:5]: {sizes[:5]}")
