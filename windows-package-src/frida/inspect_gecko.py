# -*- coding: utf-8 -*-
import re, struct

def elf_sections(data):
    if len(data)<64 or data[0:4]!=b'\x7fELF': return []
    e_shoff=struct.unpack_from("<Q",data,40)[0]; e_shentsize=struct.unpack_from("<H",data,58)[0]
    e_shnum=struct.unpack_from("<H",data,60)[0]; e_shstrndx=struct.unpack_from("<H",data,62)[0]
    def sh(i):
        o=e_shoff+i*e_shentsize
        if o+e_shentsize>len(data): return b'\x00'*e_shentsize
        return data[o:o+e_shentsize]
    def u(d,o,sz): return struct.unpack_from({2:"<H",4:"<I",8:"<Q"}[sz],d,o)[0]
    sn=sh(e_shstrndx); so=u(sn,24,8); ss=u(sn,32,8)
    strtab=data[so:so+ss] if so+ss<=len(data) else b'\x00'*16
    def name(i):
        if i>=len(strtab): return "?"
        end=strtab.index(b'\x00',i) if b'\x00' in strtab[i:] else len(strtab)
        return strtab[i:end].decode("ascii","replace")
    out=[]
    for i in range(e_shnum):
        s=sh(i); t=u(s,4,4); nm=name(u(s,0,4)); off=u(s,24,8); sz=u(s,32,8)
        out.append((nm,t,off,sz))
    return out

for so in ["libgecko_encrypt.so","libdragoncore.so","libEncryptor.so"]:
    data=open(f"capture/so/{so}","rb").read()
    secs=elf_sections(data)
    strs=[s.decode("ascii","replace") for s in re.findall(b"[ -~]{5,}", data)]
    print(f"\n=== {so} ({len(data)}B) ===")
    for nm,t,off,sz in secs:
        if sz>0: print(f"  {nm:20s} type={t} off={off:#x} size={sz}")
    print("  strings:", strs[:40])
    # 找16字节对齐的非零常量在 rodata
    for nm,t,off,sz in secs:
        if nm in (".rodata",".data") and sz>0:
            sd=data[off:off+sz]
            blks=set()
            for i in range(0,len(sd)-15,16):
                b=bytes(sd[i:i+16])
                if b!=b'\x00'*16 and b!=b'\xff'*16: blks.add(b)
            print(f"  {nm}: {sz}B, {len(blks)} 16B-aligned non-zero blocks")
            for b in list(blks)[:10]: print(f"    {b.hex()}  {repr(b)}")
