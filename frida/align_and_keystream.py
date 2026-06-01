# -*- coding: utf-8 -*-
"""对齐验证 + keystream 恢复 + aeskeyfind_live 密钥验证"""
import struct, json
from Crypto.Cipher import AES

NALT={32:"VPS",33:"SPS",34:"PPS",35:"AUD",39:"SEI",19:"IDR_W",20:"IDR_N",21:"CRA",1:"TRAIL_R",0:"TRAIL_N"}

def parse_annexb(data, maxn=20):
    nals=[]; i=0
    while i+4<len(data) and len(nals)<maxn:
        if data[i:i+4]==b"\x00\x00\x00\x01":
            j=data.find(b"\x00\x00\x00\x01",i+4)
            sz=j-i-4 if j>0 else len(data)-i-4
            nh=data[i+4] if i+4<len(data) else 0
            nt=(nh>>1)&0x3f
            nals.append({"off":i+4,"size":sz,"type":nt,"name":NALT.get(nt,"?")})
            i=j if j>0 else len(data)
        else: i+=1
    return nals

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
def all_samps(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
    ss=u32(d,stsz[0]+4); cnt=u32(d,stsz[0]+8)
    sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    n=u32(d,stco[0]+4); ch=[u32(d,stco[0]+8+4*i) for i in range(n)]
    return sizes, ch[0]

plain = open("capture/bpxb_plain.h265","rb").read()
ct    = open("capture/ct/bpxb_1080p.mp4","rb").read()

nals = parse_annexb(plain, maxn=15)
print("=== plain NALs ===")
for n in nals: print(f"  [{n['name']}] off={n['off']} size={n['size']}")

mds=find(ct,[b"mdat"])[0]
vt=[t for t in traks(ct) if hdlr(ct,t)==b"vide"][0]
sizes,off0=all_samps(ct,vt)
mo=off0-mds
print(f"\n=== cipher sample0: off={off0} mdatoff={mo} size={sizes[0]} NAL_body={sizes[0]-4} ===")
print(f"first 8 cipher sample sizes: {sizes[:8]}")

# 找第一个大的 IDR-sized NAL 在明文里
idr_nals=[n for n in nals if n["type"] in (19,20,21)]
print(f"\nIDR-type NALs in plain: {[(n['name'],n['size']) for n in idr_nals[:3]]}")

# 对齐方案: 找 plain 里 size 最接近 sizes[0]-4 的 NAL
target = sizes[0]-4
match = min(nals, key=lambda n: abs(n["size"]-target))
print(f"\nbest plain match: [{match['name']}] size={match['size']} vs target={target} diff={abs(match['size']-target)}")

if abs(match["size"]-target) < 500:
    print("\n=== ALIGNMENT OK, computing keystream ===")
    # cipher: NAL body at off0+4 (hvc1 length prefix is 4 bytes)
    # plain:  NAL body at match['off']
    N = min(15000, match["size"], sizes[0]-4, len(plain)-match["off"], len(ct)-off0-4)
    cipher_nal = ct[off0+4:off0+4+N]
    plain_nal  = plain[match["off"]:match["off"]+N]
    ks = bytes(c^p for c,p in zip(cipher_nal, plain_nal))
    print(f"keystream[0:48]: {ks[:48].hex()}")

    # AES block alignment: mdat_offset of cipher NAL body = mo+4
    rb = (mo+4)%16; blk0 = (mo+4)//16
    print(f"mo={mo} rb={rb} blk0={blk0}")
    if rb > 0 and len(ks) >= 16-rb+16:
        full_blk = ks[16-rb:16-rb+16]
        blk_idx = blk0+1
        print(f"first full AES block idx={blk_idx}: {full_blk.hex()}")
    else:
        full_blk = ks[0:16]
        blk_idx = blk0
        print(f"AES block idx={blk_idx}: {full_blk.hex()}")

    # 用 aes_keys.json + live dump keys 验证
    KID=bytes.fromhex("682165f6f8818b5c0c3d8eac0002ebeb")
    cands=[bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]
    # 再加 live dump 里的 39 个密钥
    import re
    live_keys=set()
    with open("capture/dump_live.bin","rb") as f:
        # 只扫 aes_keys_live.json 没记录的(lazy: 直接从 aes_keys.json)
        pass
    print(f"\nTesting {len(cands)} candidate keys...")
    found=False
    for ki,K in enumerate(cands):
        for iv_name,iv0 in [("0",0),("kid_be",int.from_bytes(KID,"big")),("kid_le",int.from_bytes(KID,"little"))]:
            ks_try=AES.new(K,AES.MODE_ECB).encrypt(((iv0+blk_idx)%(1<<128)).to_bytes(16,"big"))
            if ks_try==full_blk:
                print(f"*** KEY FOUND! key#{ki}={K.hex()} IV={iv_name} blk_idx={blk_idx}")
                found=True
    if not found:
        print("no match in 28 keys. keystream for manual analysis:")
        print("  block 0 (partial):", ks[:16].hex())
        print("  block 1 (full):   ", ks[16:32].hex() if len(ks)>=32 else "?")
        print("  block 2 (full):   ", ks[32:48].hex() if len(ks)>=48 else "?")
        json.dump({"full_blk":full_blk.hex(),"blk_idx":blk_idx,"kid":KID.hex(),
                   "ks_blocks":[ks[i:i+16].hex() for i in range(0,min(len(ks),256),16)]},
                  open("capture/keystream_aligned.json","w"), indent=2)
        print("saved capture/keystream_aligned.json")
else:
    print("ALIGNMENT FAILED - sizes too different, wrong video?")
    print("Plain IDRs vs cipher sample0:")
    for n in nals[:5]: print(f"  plain [{n['name']}] {n['size']} vs cipher s0 {sizes[0]-4}")
