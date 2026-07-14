# -*- coding: utf-8 -*-
"""扫 .so: AES S-box存在?(自带软件AES铁证) + 导出crypt/aes函数 + 导入(UND)的AES符号。"""
import struct
SBOX=bytes.fromhex("637c777bf26b6fc53001672bfed7ab76")  # AES forward S-box前16字节
INVSBOX=bytes.fromhex("52096ad53036a538bf40a39e81f3d7fb")
TE0=bytes.fromhex("c66363a5f87c7c84")  # Te0表前几字节(常见AES T-table)

def syms(data):
    e_shoff=struct.unpack_from("<Q",data,40)[0]; e_shent=struct.unpack_from("<H",data,58)[0]
    e_shnum=struct.unpack_from("<H",data,60)[0]; e_shstr=struct.unpack_from("<H",data,62)[0]
    def sh(i): return data[e_shoff+i*e_shent:e_shoff+(i+1)*e_shent]
    def u(d,o,sz): return struct.unpack_from({2:"<H",4:"<I",8:"<Q"}[sz],d,o)[0]
    sn=sh(e_shstr); shstr=data[u(sn,24,8):u(sn,24,8)+u(sn,32,8)]
    secs={}
    for i in range(e_shnum):
        s=sh(i); secs[shstr[u(s,0,4):shstr.index(b'\x00',u(s,0,4))].decode()]=(u(s,24,8),u(s,32,8))
    exp=[];imp=[]
    if ".dynsym" in secs and ".dynstr" in secs:
        so,ssz=secs[".dynsym"]; stro,strsz=secs[".dynstr"]; strt=data[stro:stro+strsz]
        for off in range(so,so+ssz,24):
            nm=struct.unpack_from("<I",data,off)[0]; info=data[off+4]; shndx=struct.unpack_from("<H",data,off+6)[0]; val=struct.unpack_from("<Q",data,off+8)[0]
            if nm>=len(strt): continue
            name=strt[nm:strt.index(b'\x00',nm)].decode('latin1')
            if not name: continue
            if (info&0xf)==2:  # FUNC
                if shndx==0: imp.append(name)       # UND = 导入
                else: exp.append((name,val))         # 导出
    return exp,imp

for so in ["libavmdlv2.so","libavmdlbase.so","libdragoncore.so","libEncryptor.so"]:
    try: data=open(f"capture/so/{so}","rb").read()
    except: print(f"{so}: missing"); continue
    print(f"\n===== {so} ({len(data)//1024}KB) =====")
    print(f"  AES S-box: {'YES @'+hex(data.find(SBOX)) if SBOX in data else 'no'}; "
          f"InvSbox: {'YES' if INVSBOX in data else 'no'}; Te0table: {'YES' if TE0 in data else 'no'}")
    try:
        exp,imp=syms(data)
        cexp=[(n,hex(v)) for n,v in exp if any(k in n.lower() for k in ['aes','crypt','decrypt','cipher','ctr','key','spade','unwrap','evp'])]
        cimp=[n for n in imp if any(k in n.lower() for k in ['aes','crypt','decrypt','cipher','ctr','evp','unwrap'])]
        print(f"  导出crypt函数({len(cexp)}): {cexp[:25]}")
        print(f"  导入(UND)crypt符号({len(cimp)}): {cimp[:30]}")
    except Exception as e: print(f"  sym parse err: {e}")
