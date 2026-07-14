# -*- coding: utf-8 -*-
"""列出 libEncryptor.so 的动态导出符号 + .text 函数入口数量, 确定 hook 点。"""
import struct
data=open("capture/so/libEncryptor.so","rb").read()

def elf_sections(d):
    e_shoff=struct.unpack_from("<Q",d,40)[0]; e_shentsize=struct.unpack_from("<H",d,58)[0]
    e_shnum=struct.unpack_from("<H",d,60)[0]; e_shstrndx=struct.unpack_from("<H",d,62)[0]
    def sh(i): return d[e_shoff+i*e_shentsize:e_shoff+(i+1)*e_shentsize]
    def u(b,o,sz): return struct.unpack_from({2:"<H",4:"<I",8:"<Q"}[sz],b,o)[0]
    sn=sh(e_shstrndx); strt=d[u(sn,24,8):u(sn,24,8)+u(sn,32,8)]
    def nm(i): return strt[i:strt.index(b'\x00',i)].decode('ascii','replace')
    secs={}
    for i in range(e_shnum):
        s=sh(i); secs[nm(u(s,0,4))]=(u(s,4,4),u(s,24,8),u(s,32,8),u(s,40,8))  # type,off,size,link/entsize
    return secs, u, sh, e_shnum

secs,u,sh,shn=elf_sections(data)
print("sections:", {k:(hex(v[1]),v[2]) for k,v in secs.items() if v[2]>0})

# .dynsym + .dynstr 导出函数
def parse_syms(symsec, strsec):
    so,ssz=secs[symsec][1],secs[symsec][2]
    stro,strsz=secs[strsec][1],secs[strsec][2]
    strt=data[stro:stro+strsz]
    out=[]
    for off in range(so,so+ssz,24):
        st_name=struct.unpack_from("<I",data,off)[0]
        st_info=data[off+4]; st_value=struct.unpack_from("<Q",data,off+8)[0]
        if st_name<len(strt):
            name=strt[st_name:strt.index(b'\x00',st_name)].decode('ascii','replace')
            typ=st_info&0xf  # 2=FUNC
            if name and typ==2: out.append((name,st_value))
    return out

if ".dynsym" in secs and ".dynstr" in secs:
    syms=parse_syms(".dynsym",".dynstr")
    print(f"\n动态导出函数 ({len(syms)}):")
    for n,v in syms: print(f"  {n}  @ {hex(v)}")

# .text 函数入口数(SUB SP prologue)
if ".text" in secs:
    to,tsz=secs[".text"][1],secs[".text"][2]
    code=data[to:to+tsz]; cnt=0; addrs=[]
    for i in range(0,tsz-4,4):
        w=struct.unpack_from("<I",code,i)[0]
        if (w&0xFFC003FF)==0xD10003FF or (w&0xFFC07FFF)==0xA9007BFD:  # SUB SP,SP,#n or STP x29,x30
            cnt+=1; addrs.append(to+i)  # 文件内偏移; 内存=base+off(text通常off=vaddr)
    print(f"\n.text @ {hex(to)} size={tsz}, ~{cnt} function entries")
    print("first 20 entry file-offsets:", [hex(a) for a in addrs[:20]])
print("\n.mytext:", (hex(secs['.mytext'][1]),secs['.mytext'][2]) if '.mytext' in secs else 'none')
