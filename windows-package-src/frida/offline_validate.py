# -*- coding: utf-8 -*-
"""离线验证: 用已存的 oracle_<kid>.json (真实候选key/iv + sample0), 试多种配对/IV解释找key。"""
import json, struct, glob, sys
from Crypto.Cipher import AES
from Crypto.Util import Counter

f=sys.argv[1] if len(sys.argv)>1 else sorted(glob.glob("capture/oracle_*.json"))[-1]
d=json.load(open(f)); print(f"using {f}")
sz0=d["sz0"]; full=bytes.fromhex(d["full_sample0"]); cipher=full[:16]
groups=d["groups"]; allivs=d["allivs"]
keys=list({g[0] for g in groups})
print(f"sz0={sz0} keys={len(keys)} allivs={len(allivs)}")

def walk_ok(pt):
    p=0;n=0
    while p+4<=len(pt):
        L=struct.unpack(">I",pt[p:p+4])[0]
        if L==0 or p+4+L>sz0: return False
        nh=pt[p+4]
        if (nh>>7)&1 or ((nh>>1)&0x3f)>40: return False
        p+=4+L;n+=1
    return p==sz0 and n>=1

# 多种 IV 解释: ① iv8<<64 (高8=counter,低8=0)  ② iv8 (低8=counter,高8=0)  ③ 候选key邻近的16字节当整IV
def try_all(label, iv_ints):
    cnt=0;strong=0
    for kh in keys:
        K=bytes.fromhex(kh); ec=AES.new(K,AES.MODE_ECB)
        for ivint in iv_ints:
            cnt+=1
            ks0=ec.encrypt((ivint%(1<<128)).to_bytes(16,"big"))
            L=struct.unpack(">I",bytes(a^b for a,b in zip(cipher[:4],ks0[:4])))[0]
            nh=cipher[4]^ks0[4]
            if not(0<L<=sz0-4 and (nh>>7)&1==0 and ((nh>>1)&0x3f)<=40): continue
            strong+=1
            pt=AES.new(K,AES.MODE_CTR,counter=Counter.new(128,initial_value=ivint)).decrypt(full)
            if walk_ok(pt):
                print(f"  *** [{label}] KEY={kh} IV={ivint:032x} ***")
                json.dump({"key":kh,"iv":f"{ivint:032x}","scheme":label},open("capture/oracle_key.json","w"),indent=2)
                return True
    print(f"  [{label}] {cnt}组合, {strong}过弱筛, 无匹配")
    return False

iv8s=[int.from_bytes(bytes.fromhex(h),"big") for h in allivs]
# ① 高8 counter
if try_all("iv8<<64", [v<<64 for v in iv8s]): sys.exit()
# ② 低8 (高8=0)
if try_all("iv8(low)", iv8s): sys.exit()
print("两种IV解释均无匹配 -> 真key/iv不在已采候选中(需扩大采集:不截断kid命中, 或key非高熵过滤所致)")
