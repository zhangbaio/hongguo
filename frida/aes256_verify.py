# -*- coding: utf-8 -*-
"""扫 eg.bin 找 AES-256 密钥扩展(240字节), counter-diff 验证 against seq_ks(blkA/blkB)。
若内容密钥是AES-256, aeskeyfind-128漏掉了它 -> 这里补上。"""
import json, os, numpy as np
from Crypto.Cipher import AES

ks=json.load(open("capture/seq_ks.json"))
blkA=bytes.fromhex(ks["blkA"]); blkB=bytes.fromhex(ks["blkB"])
print(f"blkA={blkA.hex()} blkB={blkB.hex()} blkA_idx={ks['blkA_idx']}")

SBOX=bytes.fromhex("637c777bf26b6fc53001672bfed7ab76ca82c97dfa5947f0add4a2af9ca472c0b7fd9326363ff7cc34a5e5f171d8311504c723c31896059a071280e2eb27b275"+"09832c1a1b6e5aa0523bd6b329e32f8453d100ed20fcb15b6acbbe394a4c58cfd0efaafb434d338545f9027f503c9fa851a3408f929d38f5bcb6da2110fff3d2"+"cd0c13ec5f974417c4a77e3d645d197360814fdc222a908846eeb814de5e0bdbe0323a0a4906245cc2d3ac629195e479e7c8376d8dd54ea96c56f4ea657aae08"+"ba78252e1ca6b4c6e8dd741f4bbd8b8a703eb5664803f60e613557b986c11d9ee1f8981169d98e949b1e87e9ce5528df8ca1890dbfe6426841992d0fb054bb16")
SB=np.frombuffer(SBOX,np.uint8); RCON=[0,1,2,4,8,16,32,64,128,27,54]

def expand256(key):
    w=list(key)  # 32 bytes = 8 words
    for i in range(8,60):
        t=w[4*(i-1):4*i]
        if i%8==0: t=[SBOX[t[1]]^RCON[i//8],SBOX[t[2]],SBOX[t[3]],SBOX[t[0]]]
        elif i%8==4: t=[SBOX[t[0]],SBOX[t[1]],SBOX[t[2]],SBOX[t[3]]]
        w+=[w[4*(i-8)+k]^t[k] for k in range(4)]
    return bytes(w)

def C(B,i,M): return B[i:i+M]
def lin(B,i,M):  # w[i]=w[i-8]^w[i-1]
    ok=np.ones(M,bool)
    for k in range(4): ok&=(C(B,4*i+k,M)==(C(B,4*(i-8)+k,M)^C(B,4*(i-1)+k,M)))
    return ok
def sbox0(B,i,M):  # i%8==0
    rc=RCON[i//8]; p=4*(i-1); q=4*(i-8)
    return (C(B,4*i,M)==(C(B,q,M)^SB[C(B,p+1,M)]^np.uint8(rc)))&(C(B,4*i+1,M)==(C(B,q+1,M)^SB[C(B,p+2,M)]))&(C(B,4*i+2,M)==(C(B,q+2,M)^SB[C(B,p+3,M)]))&(C(B,4*i+3,M)==(C(B,q+3,M)^SB[C(B,p,M)]))
def sbox4(B,i,M):  # i%8==4
    p=4*(i-1); q=4*(i-8)
    return (C(B,4*i,M)==(C(B,q,M)^SB[C(B,p,M)]))&(C(B,4*i+1,M)==(C(B,q+1,M)^SB[C(B,p+1,M)]))&(C(B,4*i+2,M)==(C(B,q+2,M)^SB[C(B,p+2,M)]))&(C(B,4*i+3,M)==(C(B,q+3,M)^SB[C(B,p+3,M)]))

def scan256(buf):
    B=np.frombuffer(buf,np.uint8); M=len(B)-240
    if M<=0: return []
    # 预筛: 用 i=9,10,11(linear) + i=8(sbox0) + i=12(sbox4) + i=13,14,15(linear)
    c=lin(B,9,M)
    c&=lin(B,10,M); c&=lin(B,11,M)
    if not c.any(): return []
    c&=sbox0(B,8,M)
    if not c.any(): return []
    c&=sbox4(B,12,M); c&=lin(B,13,M); c&=lin(B,14,M); c&=lin(B,15,M)
    if not c.any(): return []
    out=[]
    for o in np.nonzero(c)[0]:
        key=bytes(B[o:o+32])
        if expand256(key)==bytes(B[o:o+240]): out.append(key)
    return out

def dec(K,b): return AES.new(K,AES.MODE_ECB).decrypt(b)

path="capture/eg.bin"
if not os.path.exists(path): print("eg.bin not found"); raise SystemExit
sz=os.path.getsize(path); print(f"scanning {sz//1048576}MB for AES-256 schedules...")
keys=set(); CH=256<<20
with open(path,"rb") as f:
    base=0
    while base<sz:
        f.seek(base); buf=f.read(CH+240)
        if len(buf)<=240: break
        for k in scan256(buf): keys.add(k)
        base+=CH
        print(f"  {min(base,sz)//1048576}/{sz//1048576}MB aes256_keys={len(keys)}",flush=True)
keys=list(keys)
print(f"AES-256 keys found: {len(keys)}")
json.dump([k.hex() for k in keys],open("capture/eg_keys256.json","w"))

found=None
for K in keys:
    if (int.from_bytes(dec(K,blkB),"big")-int.from_bytes(dec(K,blkA),"big"))%(1<<128)==1:
        cA=int.from_bytes(dec(K,blkA),"big"); found=(K,cA)
        iv=(cA-ks["blkA_idx"])%(1<<128)
        print(f"\n*** AES-256 CONTENT KEY FOUND! key={K.hex()}")
        print(f"    IV={iv:032x}")
        json.dump({"key":K.hex(),"bits":256,"iv":f"{iv:032x}","blkA_idx":ks['blkA_idx'],"url":ks.get("url")},
                  open("capture/CONTENT_KEY.json","w"),indent=2)
        print("saved capture/CONTENT_KEY.json !!!"); break
if not found:
    print(f"no AES-256 key matches counter-diff either (keys={len(keys)})")
    print("=> 内容密钥既不是dump里的AES-128也不是AES-256标准轮密钥布局")
    print("=> 强烈指向: 硬件AES(ARM crypto, 无软件轮密钥) 或 自定义实现")
