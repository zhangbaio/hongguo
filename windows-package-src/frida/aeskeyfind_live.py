# -*- coding: utf-8 -*-
"""aeskeyfind 扫 live dump, 用已知 keystream 立刻验证每个候选密钥。
keystream_block_1 = b04aa5e0679760f38839b3472ab09c12 (来自明文/密文对)
对应 counter: mdat偏移16-31字节 -> AES block 1 (counter=1, IV=0)"""
import numpy as np, json, struct, os
from Crypto.Cipher import AES

# 已知 keystream 块
KS_BLOCK1 = bytes.fromhex("b04aa5e0679760f38839b3472ab09c12")
KS_BLOCK2_RAW = "c3cc38a6"  # ks[28:32] - 部分第2块
KID = bytes.fromhex("682165f6f8818b5c0c3d8eac0002ebeb")

SBOX = bytes.fromhex(
 "637c777bf26b6fc53001672bfed7ab76ca82c97dfa5947f0add4a2af9ca472c0"
 "b7fd9326363ff7cc34a5e5f171d8311504c723c31896059a071280e2eb27b275"
 "09832c1a1b6e5aa0523bd6b329e32f8453d100ed20fcb15b6acbbe394a4c58cf"
 "d0efaafb434d338545f9027f503c9fa851a3408f929d38f5bcb6da2110fff3d2"
 "cd0c13ec5f974417c4a77e3d645d197360814fdc222a908846eeb814de5e0bdb"
 "e0323a0a4906245cc2d3ac629195e479e7c8376d8dd54ea96c56f4ea657aae08"
 "ba78252e1ca6b4c6e8dd741f4bbd8b8a703eb5664803f60e613557b986c11d9e"
 "e1f8981169d98e949b1e87e9ce5528df8ca1890dbfe6426841992d0fb054bb16")
SB = np.frombuffer(SBOX, dtype=np.uint8)
RCON=[0x00,0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80,0x1b,0x36]

def expand_key(key16):
    w=list(key16)
    for i in range(4,44):
        t=w[4*(i-1):4*i]
        if i%4==0: t=[SBOX[t[1]]^RCON[i//4],SBOX[t[2]],SBOX[t[3]],SBOX[t[0]]]
        w+=[w[4*(i-4)+k]^t[k] for k in range(4)]
    return bytes(w)

def col(B,i,M): return B[i:i+M]
def linear_rel(B,i,M):
    ok=np.ones(M,dtype=bool)
    for k in range(4): ok&=(col(B,4*i+k,M)==(col(B,4*(i-4)+k,M)^col(B,4*(i-1)+k,M)))
    return ok
def sbox_rel(B,i,M):
    rc=RCON[i//4]; p=4*(i-1); q=4*(i-4)
    e0=col(B,q+0,M)^SB[col(B,p+1,M)]^np.uint8(rc)
    e1=col(B,q+1,M)^SB[col(B,p+2,M)]
    e2=col(B,q+2,M)^SB[col(B,p+3,M)]
    e3=col(B,q+3,M)^SB[col(B,p+0,M)]
    return (col(B,4*i+0,M)==e0)&(col(B,4*i+1,M)==e1)&(col(B,4*i+2,M)==e2)&(col(B,4*i+3,M)==e3)

def verify_key(K, ks_block1):
    """验证: AES_ECB(K, counter=1) == ks_block1 (IV=0) 或 AES_ECB(K, kid+1) == ks_block1"""
    ecb = AES.new(K, AES.MODE_ECB)
    # counter=1 (IV=0)
    if ecb.encrypt((1).to_bytes(16,"big")) == ks_block1:
        return "IV=0 ctr=1"
    # counter = kid+1
    kid_int = int.from_bytes(KID,"big")
    ecb2 = AES.new(K, AES.MODE_ECB)
    if ecb2.encrypt(((kid_int+1)%(1<<128)).to_bytes(16,"big")) == ks_block1:
        return "IV=kid"
    # counter = kid_le+1
    kid_le = int.from_bytes(KID,"little")
    ecb3 = AES.new(K, AES.MODE_ECB)
    if ecb3.encrypt(((kid_le+1)%(1<<128)).to_bytes(16,"big")) == ks_block1:
        return "IV=kid_le"
    # blk_idx=0 (mdat bytes 0-15 是 block 0)
    ecb4 = AES.new(K, AES.MODE_ECB)
    if ecb4.encrypt((0).to_bytes(16,"big")) == ks_block1:
        return "IV=0 ctr=0??"
    return None

def scan_chunk(buf):
    B = np.frombuffer(buf, dtype=np.uint8)
    M = len(B) - 176
    if M <= 0: return []
    cand = sbox_rel(B,4,M)
    for i in (5,6,7): cand &= linear_rel(B,i,M)
    if not cand.any(): return []
    cand &= sbox_rel(B,8,M)
    for i in (9,10,11): cand &= linear_rel(B,i,M)
    if not cand.any(): return []
    offs = np.nonzero(cand)[0]
    out = []
    for o in offs:
        key = bytes(B[o:o+16])
        if expand_key(key) == bytes(B[o:o+176]):
            out.append((int(o), key))
    return out

path = "capture/dump_live.bin"
sz = os.path.getsize(path)
CHUNK = 256*1024*1024; OVER = 176
found=[]; verified=[]

print(f"Scanning {sz/1048576:.0f}MB live dump, verifying against keystream...")
with open(path,"rb") as f:
    base=0
    while base < sz:
        f.seek(base)
        buf = f.read(CHUNK+OVER)
        if len(buf) <= OVER: break
        res = scan_chunk(buf)
        for o, key in res:
            g = base+o
            v = verify_key(key, KS_BLOCK1)
            status = f"VERIFIED! IV_scheme={v}" if v else "AES-key(not video)"
            found.append((g, key, v))
            if v: verified.append((g,key,v))
            print(f"  offset={g:#010x} key={key.hex()} -> {status}")
        base += CHUNK
        print(f"  scanned {min(base,sz)/1048576:.0f}/{sz/1048576:.0f}MB keys={len(found)} verified={len(verified)}", flush=True)

print(f"\n=== RESULT: {len(verified)} VERIFIED content keys ===")
for g,K,v in verified:
    print(f"  key={K.hex()} @ offset {g:#x} IV_scheme={v}")
if verified:
    json.dump([{"offset":g,"key":K.hex(),"iv_scheme":v} for g,K,v in verified],
              open("capture/content_key.json","w"), indent=2)
    print("saved capture/content_key.json")
