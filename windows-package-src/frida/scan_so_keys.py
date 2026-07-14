# -*- coding: utf-8 -*-
"""扫 .so 的 .rodata/.data 区里所有16字节对齐常量, 尝试作为 spade_a 包装密钥。
思路: spade_a = ver(1)+magic(1)+AES_ECB_enc(wrap_key, content_key)(16)+...
所以 AES_ECB_dec(wrap_key, sp[2:18]) = content_key。
再用 content_key + 各种IV 验证密文样本的首块。"""
import struct, json, base64, os
from Crypto.Cipher import AES

# 解析 ELF64 .so, 提取 .rodata/.data/.bss(不含bss) 段里的16字节对齐数据
def parse_elf_sections(data):
    """返回 [(section_name, section_data, file_offset)]"""
    if data[0:4] != b'\x7fELF': return []
    e_shoff=struct.unpack_from("<Q",data,40)[0]; e_shentsize=struct.unpack_from("<H",data,58)[0]
    e_shnum=struct.unpack_from("<H",data,60)[0]; e_shstrndx=struct.unpack_from("<H",data,62)[0]
    def sh(i): return data[e_shoff+i*e_shentsize:e_shoff+(i+1)*e_shentsize]
    def u(d,o,sz): return struct.unpack_from({2:"<H",4:"<I",8:"<Q"}[sz],d,o)[0]
    # 字符串表
    sn=sh(e_shstrndx); sh_name_off=u(sn,16,4); sh_size=u(sn,32,8); sh_off=u(sn,24,8)
    strtab=data[sh_off:sh_off+sh_size]
    def name(i): end=strtab.index(b'\x00',i); return strtab[i:end].decode('ascii','replace')
    secs=[]
    for i in range(e_shnum):
        s=sh(i); t=u(s,4,4); nm=name(u(s,0,4)); off=u(s,24,8); size=u(s,32,8)
        if t in (1,2) and size>0 and nm in ('.rodata','.data','.data.rel.ro','.got','.got.plt'):
            secs.append((nm, data[off:off+size], off))
    return secs

# spade_a 样本
samples={"ep3":("6a1978c1f8818b00477f5c0e0002ebeb","oLwu8WK3KPBWix3bZKc03nuWA9h+ojTsZaQs9Va9B8Z6jDKPjw=="),
         "hit1":("6a1165c8f8818be2b9fb87020002ebeb","orws9lSPKMRWgi3PYYQw1GKoJfhfsRLKQrIN/V+EEM9ehBajow=="),
         "hit3":("6a1165c8f8818b04e11464d90002ebeb","obwvxGK+GMdQgBfJR4MKykGED8l1gjr7cLIg+2+rP9R0ozyurg==")}
decoded={(n,k,base64.b64decode(s)) for n,(k,s) in samples.items()}

# 密文头块
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
cipher_info={}
for tag in ["hit1","hit3"]:
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mds=find(d,[b"mdat"])[0]
    vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    off0,sz0=samp0(d,vt); mo=off0-mds
    cipher_info[tag]=(d[off0:off0+64], sz0, mo, bytes.fromhex(KIDMAP[tag]))

def valid_hevc(pt,sz):
    if len(pt)<5: return False
    L=struct.unpack(">I",pt[0:4])[0]; nh=pt[4]
    return 0<L<=sz-4 and (nh>>7)&1==0 and ((nh>>1)&0x3f)<=40

def try_key(wrap_k, sp_bytes, tag, dbg=False):
    """用 wrap_k 解包 spade_a 里的 enc_key 块, 再验证密文。返回 True 若命中。"""
    for slot, enc_block in [("sp[2:18]",sp_bytes[2:18]),("sp[1:17]",sp_bytes[1:17]),("sp[0:16]",sp_bytes[0:16])]:
        ck = AES.new(wrap_k, AES.MODE_ECB).decrypt(enc_block)
        enc_iv = sp_bytes[18:34]
        try:
            iv_val = int.from_bytes(AES.new(wrap_k, AES.MODE_ECB).decrypt(enc_iv), "big")
        except: iv_val=0
        (cipher, sz0, mo, kid) = cipher_info[tag]
        for ivn, iv0 in [("zero",0),("kid_be",int.from_bytes(kid,"big")),
                         ("kid_le",int.from_bytes(kid,"little")), ("dec_iv",iv_val),
                         ("ck_int",int.from_bytes(ck,"big")), ("mo//16",mo//16)]:
            blk0=(mo//16)+iv0; r=mo%16
            ks=b"".join(AES.new(ck,AES.MODE_ECB).encrypt(((blk0+i)%(1<<128)).to_bytes(16,"big")) for i in range(5))
            pt=bytes(a^b for a,b in zip(cipher,ks[r:r+len(cipher)]))
            if valid_hevc(pt,sz0):
                if dbg: print(f"      slot={slot} iv={ivn} -> HEVC valid! ck={ck.hex()} pt0={pt[:8].hex()}")
                return True
    return False

hit_count=0
for sofile in os.listdir("capture/so"):
    path=f"capture/so/{sofile}"; data=open(path,"rb").read()
    secs=parse_elf_sections(data)
    if not secs:
        print(f"{sofile}: ELF parse failed"); continue
    # 收集所有16字节对齐非零不重复块
    blocks=set()
    for nm,sd,foff in secs:
        for i in range(0,len(sd)-15,4):  # 每4字节步进, 不只16对齐(防错位)
            b=sd[i:i+16]
            if b!=b'\x00'*16 and b!=b'\xff'*16: blocks.add(b)
    print(f"{sofile}: {len(secs)} sections, {len(blocks)} candidate 16B blocks")
    for wrap_k in blocks:
        for sp_name,(kid_hex,sp_b64) in samples.items():
            sp=base64.b64decode(sp_b64)
            for tag in ["hit1","hit3"]:
                if try_key(wrap_k, sp, tag):
                    print(f"  *** HIT! {sofile} wrap_key={wrap_k.hex()} spade={sp_name}")
                    # 详细输出
                    try_key(wrap_k, sp, tag, dbg=True)
                    hit_count+=1
if hit_count==0:
    print("\nno hit in .so rodata/data")
