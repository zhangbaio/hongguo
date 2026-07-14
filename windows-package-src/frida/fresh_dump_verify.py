# -*- coding: utf-8 -*-
"""新鲜同步dump + counter-difference 验证(不需假设IV):
1. 当前pid的smaps生成dumplist(ASLR每次不同, 必须重新生成)
2. dump /proc/mem 驻留native段
3. aeskeyfind
4. 对每个密钥K: 解密两个相邻keystream块 -> 若counter差正好1 -> 命中(确认key+IV+匹配)
keystream块来自 MATCHED.json: mdat块1=48f7ce85..., mdat块2=5041e974...(IV未知)"""
import frida, subprocess, time, struct, json, os, re, gzip, shutil
import numpy as np
from Crypto.Cipher import AES

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*a,**k): return subprocess.run([ADB,"-s",DEV]+list(a),capture_output=True,text=True,**k).stdout
def adb_b(*a,**k): return subprocess.run([ADB,"-s",DEV]+list(a),capture_output=True,**k).stdout
def get_pid(): out=adb("shell","pidof",PKG).strip(); return int(out.split()[0]) if out else None

# === keystream 两个相邻块(来自匹配对) ===
mj=json.load(open("capture/MATCHED.json"))
ks=bytes.fromhex(mj["ks48"]); mo=mj.get("mo",0)
# mdat block index for NAL body start = (mo+4); ks[i] = keystream at mdat offset (mo+4)+i
base_mdat=mo+4
# 第一个完整AES块: mdat offset 对齐到16
first_full = ((base_mdat+15)//16)*16   # 第一个 >= base_mdat 的16倍数
i0 = first_full - base_mdat
blkA = ks[i0:i0+16]; blkB = ks[i0+16:i0+32]
blkA_idx = first_full//16; blkB_idx = blkA_idx+1
print(f"mo={mo} base_mdat={base_mdat} first_full_mdat_off={first_full} blkA_idx={blkA_idx}")
print(f"blkA={blkA.hex()}  blkB={blkB.hex()}")

# === 1. smaps -> dumplist (当前pid) ===
pid=get_pid(); print(f"pid={pid}")
smaps=adb("shell","su","-c",f"cat /proc/{pid}/smaps")
regions=[]; cur=None
EXCL=["dalvik",".art]",".vdex","gralloc","Ashmem","ashmem","jit-cache","boot-","framework","/dev/","mali","kgsl","dmabuf",".jar",".apk","[stack","linker","[vdso","[vvar"]
for line in smaps.split("\n"):
    m=re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$",line)
    if m: cur={"s":int(m.group(1),16),"e":int(m.group(2),16),"perm":m.group(3),"path":m.group(4).strip(),"rss":0}; regions.append(cur)
    else:
        mm=re.match(r"^Rss:\s+(\d+)\s*kB",line)
        if mm and cur: cur["rss"]=int(mm.group(1))
rw=[r for r in regions if r["perm"][:2]=="rw" and r["rss"]>0 and not any(x in r["path"] for x in EXCL)]
dl="\n".join(f"{r['s']//4096} {(r['e']-r['s'])//4096}" for r in rw if (r['e']-r['s'])//4096>0)
print(f"smaps: {len(regions)} regions, {len(rw)} native rw resident, dumplist lines={len(dl.splitlines())}")
open("capture/fdv_dl.txt","w",newline="\n").write(dl)
adb("shell","push") # noop guard
subprocess.run([ADB,"-s",DEV,"push","capture/fdv_dl.txt","/data/local/tmp/fdv_dl.txt"])

# === 2. dump ===
sh="#!/system/bin/sh\nPID="+str(pid)+"\nwhile read s c; do dd if=/proc/$PID/mem bs=4096 skip=$s count=$c conv=noerror,sync 2>/dev/null; done < /data/local/tmp/fdv_dl.txt | gzip -1 > /data/local/tmp/fdv.gz\necho DONE\n"
open("capture/fdv.sh","w",newline="\n").write(sh)
subprocess.run([ADB,"-s",DEV,"push","capture/fdv.sh","/data/local/tmp/fdv.sh"])
t0=time.time()
subprocess.run([ADB,"-s",DEV,"shell","su -c 'sh /data/local/tmp/fdv.sh'"],timeout=120)
print(f"dump done {time.time()-t0:.1f}s, pulling...")
subprocess.run([ADB,"-s",DEV,"pull","/data/local/tmp/fdv.gz","capture/fdv.gz"])
with gzip.open("capture/fdv.gz","rb") as f, open("capture/fdv.bin","wb") as g: shutil.copyfileobj(f,g,1<<20)
sz=os.path.getsize("capture/fdv.bin"); print(f"decompressed {sz//1048576}MB")

# === 3. aeskeyfind ===
SBOX=bytes.fromhex("637c777bf26b6fc53001672bfed7ab76ca82c97dfa5947f0add4a2af9ca472c0b7fd9326363ff7cc34a5e5f171d8311504c723c31896059a071280e2eb27b275"+"09832c1a1b6e5aa0523bd6b329e32f8453d100ed20fcb15b6acbbe394a4c58cfd0efaafb434d338545f9027f503c9fa851a3408f929d38f5bcb6da2110fff3d2"+"cd0c13ec5f974417c4a77e3d645d197360814fdc222a908846eeb814de5e0bdbe0323a0a4906245cc2d3ac629195e479e7c8376d8dd54ea96c56f4ea657aae08"+"ba78252e1ca6b4c6e8dd741f4bbd8b8a703eb5664803f60e613557b986c11d9ee1f8981169d98e949b1e87e9ce5528df8ca1890dbfe6426841992d0fb054bb16")
SB=np.frombuffer(SBOX,dtype=np.uint8); RCON=[0,1,2,4,8,16,32,64,128,27,54]
def expand(k):
    w=list(k)
    for i in range(4,44):
        t=w[4*(i-1):4*i]
        if i%4==0: t=[SBOX[t[1]]^RCON[i//4],SBOX[t[2]],SBOX[t[3]],SBOX[t[0]]]
        w+=[w[4*(i-4)+j]^t[j] for j in range(4)]
    return bytes(w)
def C(B,i,M): return B[i:i+M]
def lin(B,i,M):
    ok=np.ones(M,bool)
    for k in range(4): ok&=(C(B,4*i+k,M)==(C(B,4*(i-4)+k,M)^C(B,4*(i-1)+k,M)))
    return ok
def sb(B,i,M):
    rc=RCON[i//4]; p=4*(i-1); q=4*(i-4)
    return (C(B,4*i+0,M)==(C(B,q+0,M)^SB[C(B,p+1,M)]^np.uint8(rc)))&(C(B,4*i+1,M)==(C(B,q+1,M)^SB[C(B,p+2,M)]))&(C(B,4*i+2,M)==(C(B,q+2,M)^SB[C(B,p+3,M)]))&(C(B,4*i+3,M)==(C(B,q+3,M)^SB[C(B,p+0,M)]))
def scan(buf):
    B=np.frombuffer(buf,np.uint8); M=len(B)-176
    if M<=0: return []
    c=sb(B,4,M)
    for i in (5,6,7): c&=lin(B,i,M)
    if not c.any(): return []
    c&=sb(B,8,M)
    for i in (9,10,11): c&=lin(B,i,M)
    if not c.any(): return []
    return [bytes(B[o:o+16]) for o in np.nonzero(c)[0] if expand(bytes(B[o:o+16]))==bytes(B[o:o+176])]

keys=set(); CH=256<<20
with open("capture/fdv.bin","rb") as f:
    base=0
    while base<sz:
        f.seek(base); buf=f.read(CH+176)
        if len(buf)<=176: break
        for k in scan(buf): keys.add(k)
        base+=CH
keys=list(keys)
print(f"aeskeyfind: {len(keys)} unique AES-128 keys")
json.dump([k.hex() for k in keys],open("capture/fdv_keys.json","w"))

# === 4. counter-difference 验证 (不需IV假设) ===
print("verifying via counter-difference (AES-dec(blkA), AES-dec(blkB) 差应为1)...")
def dec(K,blk): return AES.new(K,AES.MODE_ECB).decrypt(blk)
found=None
for K in keys:
    cA=int.from_bytes(dec(K,blkA),"big"); cB=int.from_bytes(dec(K,blkB),"big")
    if (cB-cA)%(1<<128)==1:
        found=(K,cA); print(f"*** CONTENT KEY FOUND! key={K.hex()}")
        print(f"    counterA(=IV+{blkA_idx})={cA:032x}  -> IV={(cA-blkA_idx)%(1<<128):032x}")
        break
# 也试 IV=0 直接验证(AES(K,idx)==blkA)
if not found:
    for K in keys:
        if AES.new(K,AES.MODE_ECB).encrypt(blkA_idx.to_bytes(16,"big"))==blkA:
            found=(K,blkA_idx); print(f"*** KEY (IV=0)! key={K.hex()}"); break
if found:
    json.dump({"key":found[0].hex(),"counterA":found[1],"blkA_idx":blkA_idx,
               "iv":((found[1]-blkA_idx)%(1<<128)).to_bytes(16,"big").hex()},
              open("capture/CONTENT_KEY.json","w"),indent=2)
    print("saved capture/CONTENT_KEY.json -- 密钥+IV 确认!")
else:
    print(f"no key satisfies counter-diff. 可能: 匹配对是误配(diff=33)/或加密非简单CTR. keys={len(keys)}")
