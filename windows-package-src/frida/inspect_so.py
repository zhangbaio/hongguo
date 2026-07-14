# -*- coding: utf-8 -*-
"""详细查看 libEncryptor.so 的字符串、段布局、16字节常量, 并用更严格的双视频一致性过滤跑 scan_so_keys。"""
import struct, re, os, json, base64
from Crypto.Cipher import AES

def elf_sections(data):
    if data[0:4] != b'\x7fELF': return []
    e_shoff=struct.unpack_from("<Q",data,40)[0]; e_shentsize=struct.unpack_from("<H",data,58)[0]
    e_shnum=struct.unpack_from("<H",data,60)[0]; e_shstrndx=struct.unpack_from("<H",data,62)[0]
    def sh(i): return data[e_shoff+i*e_shentsize:e_shoff+(i+1)*e_shentsize]
    def u(d,o,sz): return struct.unpack_from({2:"<H",4:"<I",8:"<Q"}[sz],d,o)[0]
    sn=sh(e_shstrndx); sh_off=u(sn,24,8); sh_size=u(sn,32,8)
    strtab=data[sh_off:sh_off+sh_size]
    def name(i): end=strtab.index(b'\x00',i); return strtab[i:end].decode('ascii','replace')
    secs=[]
    for i in range(e_shnum):
        s=sh(i); t=u(s,4,4); nm=name(u(s,0,4)); off=u(s,24,8); size=u(s,32,8)
        secs.append((nm,t,off,size))
    return secs

for soname in ["libEncryptor.so","libdragon_crypt.so"]:
    data=open(f"capture/so/{soname}","rb").read()
    secs=elf_sections(data)
    print(f"\n=== {soname} ({len(data)}B) sections ===")
    for nm,t,off,size in secs:
        print(f"  {nm:20s} type={t} off={off:#08x} size={size}")
    strs=[s.decode("ascii","replace") for s in re.findall(b"[ -~]{4,}", data)]
    print(f"  strings(4+)={len(strs)}")
    for s in strs[:60]: print(f"    {s}")

# --- 更严的双视频一致性扫描 ---
print("\n\n=== 严格双视频一致性扫描(同一 wrap_key+slot+IV 必须同时命中 hit1 AND hit3) ===")
samples={"ep3": ("6a1978c1f8818b00477f5c0e0002ebeb","oLwu8WK3KPBWix3bZKc03nuWA9h+ojTsZaQs9Va9B8Z6jDKPjw=="),
         "hit1":("6a1165c8f8818be2b9fb87020002ebeb","orws9lSPKMRWgi3PYYQw1GKoJfhfsRLKQrIN/V+EEM9ehBajow=="),
         "hit3":("6a1165c8f8818b04e11464d90002ebeb","obwvxGK+GMdQgBfJR4MKykGED8l1gjr7cLIg+2+rP9R0ozyurg==")}
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
    return u32(d,stco[0]+8), sz0
KIDMAP={"hit1":"6a1165c8f8818be2b9fb87020002ebeb","hit3":"6a1165c8f8818b04e11464d90002ebeb"}
ct={}
for tag in ["hit1","hit3"]:
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mds=find(d,[b"mdat"])[0]
    vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    off0,sz0=samp0(d,vt); mo=off0-mds
    ct[tag]=(d[off0:off0+128], sz0, mo, bytes.fromhex(KIDMAP[tag]))

def valid_strong(pt, sz):
    """更严: 首NAL有效 + 第二个NAL头也合法(双NAL验证)"""
    if len(pt)<10: return False
    L=struct.unpack(">I",pt[0:4])[0]; nh=pt[4]
    if not (0<L<=sz-4 and (nh>>7)==0 and ((nh>>1)&0x3f)<=40 and L>8): return False
    # 第二NAL头(若在前32字节内)
    if 4+L+5 <= len(pt):
        L2=struct.unpack(">I",pt[4+L:4+L+4])[0]; nh2=pt[4+L+4]
        if not (0<L2<=sz-4-L-4 and (nh2>>7)==0 and ((nh2>>1)&0x3f)<=40): return False
    return True

def try_formula(wrap_k, slot_off, sp, tag, cbc_iv=None):
    enc_block = sp[slot_off:slot_off+16]
    if cbc_iv is None:
        ck = AES.new(wrap_k, AES.MODE_ECB).decrypt(enc_block)
    else:
        ck = AES.new(wrap_k, AES.MODE_CBC, iv=cbc_iv).decrypt(enc_block)
    (cipher, sz0, mo, kid) = ct[tag]
    for ivn, iv0 in [("zero",0),("kid_be",int.from_bytes(kid,"big")),
                     ("kid_le",int.from_bytes(kid,"little"))]:
        blk0 = mo//16; r = mo%16
        ks=b"".join(AES.new(ck,AES.MODE_ECB).encrypt(((iv0+blk0+i)%(1<<128)).to_bytes(16,"big")) for i in range(9))
        pt=bytes(a^b for a,b in zip(cipher,ks[r:r+len(cipher)]))
        if valid_strong(pt, sz0):
            return True, ivn, ck
    return False, None, None

# 只扫 libEncryptor.so 和 libdragon_crypt.so (小文件, 低误报)
for soname in ["libEncryptor.so","libdragon_crypt.so"]:
    data=open(f"capture/so/{soname}","rb").read()
    secs=elf_sections(data)
    blocks=set()
    for nm,t,off,size in secs:
        if nm in ('.rodata','.data','.data.rel.ro') and size>0:
            sd=data[off:off+size]
            for i in range(0,len(sd)-15,4):
                b=bytes(sd[i:i+16])
                if b!=b'\x00'*16 and b!=b'\xff'*16: blocks.add(b)
    print(f"\n{soname}: scanning {len(blocks)} blocks from rodata/data")
    for wrap_k in blocks:
        for slot_off in [0,1,2]:
            for sp_name,(_,sp_b64) in samples.items():
                sp=base64.b64decode(sp_b64)
                # 双视频必须同时命中
                ok1,ivn1,ck1=try_formula(wrap_k,slot_off,sp,"hit1")
                if not ok1: continue
                ok3,ivn3,ck3=try_formula(wrap_k,slot_off,sp,"hit3")
                if ok3 and ivn1==ivn3:
                    print(f"  *** STRONG HIT! wrap={wrap_k.hex()} slot={slot_off} spade={sp_name} iv={ivn1}")
                    print(f"      hit1_ck={ck1.hex()} hit3_ck={ck3.hex()}")
    # 也试CBC(iv=0)
    for wrap_k in blocks:
        for slot_off in [0,1,2]:
            for sp_name,(_,sp_b64) in samples.items():
                sp=base64.b64decode(sp_b64)
                ok1,ivn1,ck1=try_formula(wrap_k,slot_off,sp,"hit1",cbc_iv=b'\x00'*16)
                if not ok1: continue
                ok3,ivn3,ck3=try_formula(wrap_k,slot_off,sp,"hit3",cbc_iv=b'\x00'*16)
                if ok3 and ivn1==ivn3:
                    print(f"  *** STRONG HIT(CBC)! wrap={wrap_k.hex()} slot={slot_off} spade={sp_name} iv={ivn1}")
                    print(f"      hit1_ck={ck1.hex()} hit3_ck={ck3.hex()}")
