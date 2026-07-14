# -*- coding: utf-8 -*-
"""确定正确的 keystream 对齐: 读密文 sample 的 4字节长度前缀是否明文, 定加密原点 -> i0。"""
import json, struct
ks=json.load(open("capture/e4_ks.json"))
co=ks["co"]; mo=ks["mo"]; ci=ks["ci"]
data=open("capture/e4_match.mp4","rb").read()
# mdat 起点
def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0];t=d[o+4:o+8];hs=8
        if sz==1:sz=struct.unpack(">Q",d[o+8:o+16])[0];hs=16
        elif sz==0:sz=e-o
        yield t,o,sz,hs;o+=sz
def find(d,p,s=0,e=None):
    if e is None:e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]:return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
mds=find(data,[b"mdat"])[0]
print(f"mds={mds} co={co} mo={mo} (co should=mds+mo-4={mds+mo-4})")
# sample ci 的 4字节长度前缀(在 co 处)
lenpfx=struct.unpack(">I",data[co:co+4])[0]
print(f"in-mdat 4-byte length prefix @co: {data[co:co+4].hex()} = {lenpfx}")
# 这个 sample 的真实大小(从前面 seqmatch: csz). NAL body = ks 对应. body在 co+4
# 若 lenpfx 是合理的NAL长度(=sample_size-4), 则长度前缀是明文 -> 加密原点=co+4 -> i0=0
print(f"若 lenpfx 看起来像合理长度(几千~几万) => 长度前缀明文 => 加密从body(co+4)起 => i0=0")
print(f"若 lenpfx 是乱码大数 => 长度前缀也被加密 => 原点=co => body在+4 => i0=12")
# 全局CTR假设的 i0
print(f"全局mdat-CTR 假设: i0=(16-(mo%16))%16 = {(16-(mo%16))%16}")
print(f"\nks前64字节(各对齐取首块):")
ksb=bytes.fromhex(ks["ks"])
for i0 in range(16):
    print(f"  i0={i0:2d}: blkA={ksb[i0:i0+16].hex()}")
