# -*- coding: utf-8 -*-
"""无需明文: 用136个密钥解密每个密文的sample0, 检查是否产生合法HEVC NAL。
对 whole-mdat CTR: counter = IV + (mdatoff+blockoffset)//16
测试 IV in {0, kid, kid_le}, 覆盖前几个块处理 rb 偏移。"""
import json, struct, glob, os
from Crypto.Cipher import AES

keys=[bytes.fromhex(k["key"]) for k in json.load(open("capture/sync_keys.json"))]
print(f"{len(keys)} candidate keys")

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
    mv=find(d,[b"moov"])
    if not mv: return []
    return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"]
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
def samps(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
    ss=u32(d,stsz[0]+4); cnt=u32(d,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(min(cnt,5))]
    return sizes, u32(d,stco[0]+8)

def ecb_block(K, ctr_int):
    return AES.new(K,AES.MODE_ECB).encrypt((ctr_int%(1<<128)).to_bytes(16,"big"))

def ctr_keystream(K, iv_int, start_block, nblocks):
    return b"".join(ecb_block(K, iv_int+start_block+i) for i in range(nblocks))

def valid_nal(pt, sample_size):
    if len(pt)<5: return False
    L=struct.unpack(">I",pt[0:4])[0]
    nh=pt[4]
    return 0<L<=sample_size-4 and (nh>>7)&1==0 and ((nh>>1)&0x3f)<=40

# kid map for each ciphertext
KIDS={
    "live_current":"682165e3f8818b2123d6d8790003ebeb",
    "hit1_live":"682165f6f8818b5c0c3d8eac0002ebeb",
    "hit3_live":"6821663cf8818be54f9edf280003ebeb",
    "bpxb_1080p":"682165f6f8818b5c0c3d8eac0002ebeb",
}

cipher_files=glob.glob("capture/ct/*.mp4")+glob.glob("capture/ct/fresh/*.mp4")+glob.glob("capture/ct/fresh2/*.mp4")+glob.glob("capture/ct/scan/*.mp4")

for cf in cipher_files:
    try:
        ct=open(cf,"rb").read()
        mdat=find(ct,[b"mdat"])
        if not mdat: continue
        mds=mdat[0]
        vts=[t for t in traks(ct) if hdlr(ct,t)==b"vide"]
        if not vts: continue
        sizes,off0=samps(ct,vts[0])
        sz0=sizes[0]; mo=off0-mds
        tag=os.path.basename(cf).replace(".mp4","")
        kid_hex=KIDS.get(tag)
        ivs=[("0",0)]
        if kid_hex:
            k=bytes.fromhex(kid_hex)
            ivs+=[("kid_be",int.from_bytes(k,"big")),("kid_le",int.from_bytes(k,"little"))]
        hit=False
        for ki,K in enumerate(keys):
            for ivn,iv0 in ivs:
                # whole-mdat CTR: sample0 starts at mdat offset mo
                rb=mo%16; blk=mo//16
                ks=ctr_keystream(K,iv0,blk,3)
                pt=bytes(a^b for a,b in zip(ct[off0:off0+16], ks[rb:rb+16]))
                if valid_nal(pt,sz0):
                    print(f"*** HIT {tag} key#{ki}={K.hex()} IV={ivn} L={struct.unpack('>I',pt[0:4])[0]} pt={pt[:8].hex()}")
                    hit=True
        if not hit:
            print(f"  {tag}: s0={sz0} mo={mo} - no hit ({len(keys)}k x {len(ivs)}iv)")
    except Exception as e:
        print(f"  {cf}: {e}")
print("done")
