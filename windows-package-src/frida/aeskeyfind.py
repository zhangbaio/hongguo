# -*- coding: utf-8 -*-
"""numpy 向量化 AES-128 轮密钥查找器。扫 dump.bin, 找内存里残留的 AES-128 密钥扩展(176字节),
输出候选 16 字节密钥(+全局偏移->通过 dumpindex.json 映射到内存地址)。"""
import numpy as np, json, sys, os

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
RCON = [0x00,0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80,0x1b,0x36]

def expand_key(key16):
    """标准 AES-128 密钥扩展, 返回 176 字节。"""
    w = list(key16)
    for i in range(4, 44):
        t = w[4*(i-1):4*i]
        if i % 4 == 0:
            t = [SBOX[t[1]]^RCON[i//4], SBOX[t[2]], SBOX[t[3]], SBOX[t[0]]]
        w += [w[4*(i-4)+k]^t[k] for k in range(4)]
    return bytes(w)

def col(B, byte_index, M):
    """返回 B[byte_index : byte_index+M] 视图(用于按偏移 o 取某固定字节位置)。"""
    return B[byte_index:byte_index+M]

def linear_rel(B, i, M):
    """w[i]==w[i-4]^w[i-1] 的逐字节布尔(len M), 4字节都满足才True。"""
    ok = np.ones(M, dtype=bool)
    for k in range(4):
        ok &= (col(B,4*i+k,M) == (col(B,4*(i-4)+k,M) ^ col(B,4*(i-1)+k,M)))
    return ok

def sbox_rel(B, i, M):
    """w[i]==w[i-4]^SubWord(RotWord(w[i-1]))^Rcon (i%4==0)。"""
    rc = RCON[i//4]
    p = 4*(i-1)  # w[i-1] 起始
    q = 4*(i-4)  # w[i-4] 起始
    e0 = col(B,q+0,M) ^ SB[col(B,p+1,M)] ^ np.uint8(rc)
    e1 = col(B,q+1,M) ^ SB[col(B,p+2,M)]
    e2 = col(B,q+2,M) ^ SB[col(B,p+3,M)]
    e3 = col(B,q+3,M) ^ SB[col(B,p+0,M)]
    return (col(B,4*i+0,M)==e0)&(col(B,4*i+1,M)==e1)&(col(B,4*i+2,M)==e2)&(col(B,4*i+3,M)==e3)

def scan_chunk(buf):
    B = np.frombuffer(buf, dtype=np.uint8)
    M = len(B) - 176
    if M <= 0: return []
    # 预筛: sbox(i=4) 杀零页 + 线性(5,6,7) + sbox(8) + 线性(9,10,11)
    cand = sbox_rel(B,4,M)
    for i in (5,6,7):
        cand &= linear_rel(B,i,M)
        if not cand.any(): return []
    cand &= sbox_rel(B,8,M)
    for i in (9,10,11):
        cand &= linear_rel(B,i,M)
        if not cand.any(): return []
    offs = np.nonzero(cand)[0]
    out=[]
    for o in offs:
        key = bytes(B[o:o+16])
        if expand_key(key) == bytes(B[o:o+176]):
            out.append((int(o), key))
    return out

def main():
    path = sys.argv[1] if len(sys.argv)>1 else "capture/dump.bin"
    idx = json.load(open("capture/dumpindex.json"))
    sz = os.path.getsize(path)
    CHUNK = 256*1024*1024
    OVER = 176
    found=[]
    with open(path,"rb") as f:
        base=0
        while base < sz:
            f.seek(base)
            buf = f.read(CHUNK+OVER)
            if len(buf) <= OVER: break
            res = scan_chunk(buf)
            for o,key in res:
                g = base+o
                found.append((g,key))
            base += CHUNK
            print(f"  scanned {base/1048576:.0f}/{sz/1048576:.0f} MB, cands so far={len(found)}", flush=True)
    # 去重 + 映射地址
    seen=set(); uniq=[]
    for g,key in found:
        if key in seen: continue
        seen.add(key); uniq.append((g,key))
    def addr_of(g):
        for r in idx:
            if r["foff"]<=g<r["foff"]+r["size"]:
                return r["addr"]+(g-r["foff"]), r["path"]
        return None,None
    print(f"\n=== {len(uniq)} unique AES-128 keys found ===")
    out=[]
    for g,key in uniq:
        a,p = addr_of(g)
        rec={"foff":g,"addr":hex(a) if a else None,"path":p,"key":key.hex()}
        out.append(rec)
        print(f"  key={key.hex()}  @{hex(a) if a else '?'}  {p}")
    json.dump(out, open("capture/aes_keys.json","w"), indent=2)
    print("saved capture/aes_keys.json")

if __name__=="__main__":
    main()
