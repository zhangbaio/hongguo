# -*- coding: utf-8 -*-
"""从 libavmdlv2 内存 dump 提取密钥盒 (kid->key->base_iv) 并与 spade_a 配对。
密钥盒条目结构(每32字节): [01 0d 01 00 00 00][2B tag][8B 00][16B value]
  value 三类: kid(末2字节 eb eb) / key(后8字节非0且非kid) / IV(后8-10字节为0,高位=base_iv)
用法: python frida/keybox_extract.py capture/e4.bin
"""
import re, sys, base64, collections

HDR = bytes.fromhex("010d01000000")

def is_kid(v): return v[-2:] == b"\xeb\xeb"
def is_iv(v):  return v[8:16] == b"\x00"*8 and any(v[:8])
def is_key(v): return any(v[8:16]) and not is_kid(v) and not is_iv(v)

def extract(path):
    data = open(path, "rb").read()
    ent = []
    i = 0
    while True:
        j = data.find(HDR, i)
        if j < 0: break
        v = data[j+16:j+32]
        if len(v) == 16: ent.append((j, v))
        i = j + 1
    # 簇内配对: 每个 kid 条目, ±240B 内找 key
    kid2key = collections.defaultdict(collections.Counter)
    for idx, (pos, v) in enumerate(ent):
        if is_kid(v):
            for jdx in range(max(0, idx-6), min(len(ent), idx+7)):
                p2, v2 = ent[jdx]
                if abs(p2-pos) <= 240 and is_key(v2):
                    kid2key[v.hex()][v2.hex()] += 1/(abs(p2-pos)+1)
    # kid -> spade (JSON mSpadea, 同对象内最近 mKid)
    kid2spade = {}
    for m in re.finditer(rb'"mSpadea":"([A-Za-z0-9+/=]{40,60})', data):
        sp = m.group(1).decode()
        back = data[max(0, m.start()-4000):m.start()]
        k = re.findall(rb'"mKid":"([0-9a-f]{32})"', back)
        if k:
            full = sp + "="*((4-len(sp)%4)%4)
            try:
                if len(base64.b64decode(full)) == 37:
                    kid2spade.setdefault(k[-1].decode(), set()).add(full)
            except Exception:
                pass
    return ent, kid2key, kid2spade

if __name__ == "__main__":
    path = sys.argv[1] if len(sys.argv) > 1 else "capture/e4.bin"
    ent, kid2key, kid2spade = extract(path)
    print(f"{path}: keybox条目={len(ent)}  有key的kid={len(kid2key)}  有spade的kid={len(kid2spade)}")
    both = set(kid2key) & set(kid2spade)
    print(f"\n=== (key, kid, spade) 真值配对: {len(both)} 组 ===")
    for kid in both:
        key = kid2key[kid].most_common(1)[0][0]
        for sp in kid2spade[kid]:
            print(f"key  ={key}\nkid  ={kid}\nspade={base64.b64decode(sp+'='*((4-len(sp)%4)%4)).hex()}\n")
