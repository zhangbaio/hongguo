# -*- coding: utf-8 -*-
"""dump 密钥盒struct(第一处key周围±1.5KB), 定位 kid/key/base_iv 的精确偏移与IV表结构。"""
import struct
KEY=bytes.fromhex("e65f045ea495e9cb439fa87fed02d756")
BASE_IV8=bytes.fromhex("8a3366122cfe6f54")   # sample#0 高64
KID_TAIL=bytes.fromhex("000debeb")            # 这个视频kid尾部
data=open("capture/e4.bin","rb").read()
o=data.find(KEY); print(f"key@{hex(o)}")
W=1536; base=o-W//2
seg=data[base:base+W]
# 标注关键偏移
def rel(x): return x-o
print(f"窗口 [{hex(base)} .. {hex(base+W)}], key在相对0")
# 找该窗口内所有 kid(以000debeb结尾的16字节)、base_iv族(8a3366122cfe**)、key
for i in range(len(seg)-16):
    b=seg[i:i+16]
    abs_off=base+i
    if b==KEY: print(f"  KEY        @rel{rel(abs_off):+5d} ({hex(abs_off)})")
    if b[12:16]==KID_TAIL and b[6:9]==bytes.fromhex("818b65"): # kid样式
        print(f"  KID        @rel{rel(abs_off):+5d}  {b.hex()}")
    if b[0:7]==bytes.fromhex("8a3366122cfe"[:14]): # base_iv族 8a3366122cfe**
        print(f"  IV(8a3366) @rel{rel(abs_off):+5d}  {b[:8].hex()}  ({struct.unpack('>Q',b[:8])[0]:016x})")
print("\n--- 完整 hexdump (rel offset) ---")
for r in range(0,W,16):
    chunk=seg[r:r+16]
    ro=base+r-o
    hexs=" ".join(f"{x:02x}" for x in chunk)
    asc="".join(chr(x) if 32<=x<127 else "." for x in chunk)
    tag=""
    if chunk==KEY: tag=" <<<KEY"
    print(f"  {ro:+6d}: {hexs}  {asc}{tag}")
