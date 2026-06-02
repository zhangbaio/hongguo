# -*- coding: utf-8 -*-
"""聚焦暴力: 只用正确对齐 i0=12, 扫 e4.bin 找 raw key (AES-128 then 256, counter-diff)。
比 endgame4 的 4 偏移快 4 倍。"""
import json, os, time, struct
from Crypto.Cipher import AES

ks=json.load(open("capture/e4_ks.json"))
ksb=bytes.fromhex(ks["ks"])
I0=12  # 由 check_align2 确定: 长度前缀加密, 原点=样本起点, body在+4 -> 块边界 i0=12
blkA=ksb[I0:I0+16]; blkB=ksb[I0+16:I0+32]
print(f"i0={I0} blkA={blkA.hex()} blkB={blkB.hex()}")
dsz=os.path.getsize("capture/e4.bin"); print(f"e4.bin {dsz//1048576}MB")

def brute(bits):
    klen=bits//8; t0=time.time(); tested=0
    with open("capture/e4.bin","rb") as f:
        carry=b""; gpos=0
        while True:
            chunk=f.read(64<<20)
            if not chunk: break
            buf=carry+chunk; lim=len(buf)-klen
            start=(-gpos)%16
            for o in range(start,lim+1,16):
                K=buf[o:o+klen]
                try:
                    c=AES.new(K,AES.MODE_ECB)
                    if (int.from_bytes(c.decrypt(blkB),"big")-int.from_bytes(c.decrypt(blkA),"big"))%(1<<128)==1:
                        print(f"\n*** RAW KEY FOUND! AES-{bits} key={K.hex()} (i0={I0})")
                        # IV 恢复需 blkA 的样本内块号; 先存key
                        json.dump({"key":K.hex(),"bits":bits,"i0":I0,"source":"focused_brute"},open("capture/CONTENT_KEY.json","w"),indent=2)
                        return True
                except: pass
                tested+=1
            carry=buf[-16:]; gpos+=len(chunk)
            print(f"  AES{bits} {gpos//1048576}/{dsz//1048576}MB {time.time()-t0:.0f}s tested={tested//1000000}M",flush=True)
    print(f"AES-{bits} done: nothing ({tested} windows, {time.time()-t0:.0f}s)")
    return False

if not brute(128):
    if not brute(256):
        print("i0=12 16-aligned: 128+256 both nothing. 下一步: 试其他字节对齐 或 key不在dump")
print("focused done")
