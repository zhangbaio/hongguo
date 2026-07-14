# -*- coding: utf-8 -*-
"""在 e4.bin 里定位已知密钥, dump周围字节找锚点(base_iv/kid/spade_a/字符串/指针)。
并通过 e4_dl.txt 把文件偏移映射回内存地址, 判断在哪个段。"""
import json, struct, re

KEY=bytes.fromhex("e65f045ea495e9cb439fa87fed02d756")
BASE_IV=bytes.fromhex("8a3366122cfe6f54")  # 高64位 base
data=open("capture/e4.bin","rb").read()
print(f"e4.bin {len(data)} bytes, searching key...")

# 找所有出现位置
offs=[]
i=data.find(KEY)
while i>=0:
    offs.append(i); i=data.find(KEY,i+1)
print(f"key出现 {len(offs)} 次, offsets: {[hex(o) for o in offs]}")

# e4_dl.txt: 每行 'startPage countPages' -> 文件偏移映射回内存地址
plan=[]
foff=0
for line in open("capture/e4_dl.txt"):
    p=line.split()
    if len(p)<2: continue
    sp=int(p[0]); cnt=int(p[1])
    addr=sp*4096; size=cnt*4096
    plan.append((foff,addr,size))
    foff+=size
def map_addr(fo):
    for f0,addr,size in plan:
        if f0<=fo<f0+size: return addr+(fo-f0)
    return None

for o in offs:
    a=map_addr(o)
    print(f"\n=== key @ file_off {hex(o)} -> mem_addr {hex(a) if a else '?'} ===")
    ctx=data[max(0,o-128):o+144]
    # hexdump 周围
    base=max(0,o-128)
    for r in range(0,len(ctx),16):
        chunk=ctx[r:r+16]
        mark=""
        if base+r<=o<base+r+16: mark="  <<< KEY HERE"
        hexs=" ".join(f"{b:02x}" for b in chunk)
        asc="".join(chr(b) if 32<=b<127 else "." for b in chunk)
        print(f"  {base+r:08x}: {hexs}  {asc}{mark}")
    # 在周围 4KB 找 base_iv / 可打印字符串 / kid样式(32 hex chars末尾0002ebeb等)
    wide=data[max(0,o-2048):o+2048]
    if BASE_IV in wide:
        rel=wide.find(BASE_IV)-(o-max(0,o-2048))
        print(f"  *** base_iv 在附近! 相对key偏移 {rel}")
    # 找附近的 spade_a(37字节blob)难; 找可打印ASCII串
    strs=re.findall(rb"[ -~]{6,}",wide)
    if strs: print(f"  附近字符串: {[s.decode()[:40] for s in strs[:8]]}")
    # 找 kid 样式: ...0002ebeb / 0003ebeb (hex字符串)
    for m in re.finditer(rb"[0-9a-f]{24}000[23]ebeb",wide):
        print(f"  *** 附近有kid样式(hex字符串): {m.group(0).decode()}")
    # 二进制 kid? 找 ...0002ebeb 的二进制
    for pat in [bytes.fromhex("0002ebeb"),bytes.fromhex("0003ebeb")]:
        if pat in wide:
            rel=wide.find(pat)-(o-max(0,o-2048))
            print(f"  *** 二进制 {pat.hex()} 在附近! 相对key偏移 {rel}")
