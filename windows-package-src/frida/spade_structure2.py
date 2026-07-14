# -*- coding: utf-8 -*-
"""深度分析 spade_a 字节结构, 尝试用28个候选密钥作为包装密钥解包。"""
import base64, json, struct
from Crypto.Cipher import AES

samples = {
    "ep3":  ("6a1978c1f8818b00477f5c0e0002ebeb", "oLwu8WK3KPBWix3bZKc03nuWA9h+ojTsZaQs9Va9B8Z6jDKPjw=="),
    "hit1": ("6a1165c8f8818be2b9fb87020002ebeb", "orws9lSPKMRWgi3PYYQw1GKoJfhfsRLKQrIN/V+EEM9ehBajow=="),
    "hit3": ("6a1165c8f8818b04e11464d90002ebeb", "obwvxGK+GMdQgBfJR4MKykGED8l1gjr7cLIg+2+rP9R0ozyurg=="),
}
decoded = {n: (bytes.fromhex(k), base64.b64decode(s)) for n,(k,s) in samples.items()}

print("=== spade_a 精细结构(37字节) ===")
print("offset 按 ep3/hit1/hit3:")
for i in range(37):
    vals = [decoded[n][1][i] for n in ["ep3","hit1","hit3"]]
    same = " <-常量" if len(set(vals))==1 else ""
    note = ""
    if i==0: note=" [version?]"
    if i==1: note=" [magic=0xbc, 恒定!]"
    if i==33: note=" [tail start]"
    if i==35 or i==36: note=" [byte35==byte36]"
    print(f"  [{i:2d}]  {' '.join('%02x'%v for v in vals)}{same}{note}")

# 布局假设: [1B version][1B 0xbc][16B encrypted_key][16B encrypted_iv_or_tag][3B trailer]
print("\n=== 布局假设: ver(1)+magic(1)+enc_key(16)+enc_iv(16)+tail(3) ===")
for n,(kid,sp) in decoded.items():
    ver=sp[0]; magic=sp[1]; enc_k=sp[2:18]; enc_iv=sp[18:34]; tail=sp[34:37]
    print(f"  {n}: ver={ver:02x} magic={magic:02x} enc_key={enc_k.hex()} enc_iv={enc_iv.hex()} tail={tail.hex()}")

# 用28个候选AES密钥尝试解包 enc_key(偏移2..18) 和 enc_key(偏移1..17)
cands = [bytes.fromhex(k["key"]) for k in json.load(open("capture/aes_keys.json"))]

def valid_content_key(ck):
    """候选内容密钥是否像AES-128密钥? 任意16字节都合法, 只能靠与密文交叉验证。"""
    return ck  # 直接返回, 后面用密文验证

def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0]; t=d[o+4:o+8]; hs=8
        if sz==1: sz=struct.unpack(">Q",d[o+8:o+16])[0]; hs=16
        elif sz==0: sz=e-o
        yield t,o,sz,hs
        if sz<=0: break
        o+=sz
def find(d,p,s=0,e=None):
    if e is None: e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]: return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
def traks(d):
    mv=find(d,[b"moov"]); return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"]
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
def samp0(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
    ss=u32(d,stsz[0]+4); sz0=ss if ss else u32(d,stsz[0]+12)
    off0=u32(d,stco[0]+8)
    return off0, sz0

def ecb_dec(K, block): return AES.new(K, AES.MODE_ECB).decrypt(block)
def valid_hevc(pt, sz):
    if len(pt) < 5: return False
    L=struct.unpack(">I",pt[0:4])[0]; nh=pt[4]
    return 0<L<=sz-4 and (nh>>7)&1==0 and ((nh>>1)&0x3f)<=40

def ctr_ks(K, iv_int, counter_offset, n_blocks=4):
    ks=b""
    for i in range(n_blocks):
        ctr=((iv_int+counter_offset+i)%(1<<128)).to_bytes(16,"big")
        ks+=AES.new(K,AES.MODE_ECB).encrypt(ctr)
    return ks

print("\n=== 用28候选密钥解包spade_a, 再用解出的内容密钥验证密文 ===")
ct_files={"hit1":"6a1165c8f8818be2b9fb87020002ebeb","hit3":"6a1165c8f8818b04e11464d90002ebeb"}
cipher_s0={}
for tag,kid_hex in ct_files.items():
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mds=find(d,[b"mdat"])[0]
    vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    off0,sz0=samp0(d,vt)
    cipher_s0[tag]=(d[off0:off0+64], sz0, mds, off0, kid_hex)

IVS=["zero","kid_be","kid_le","enc_iv"]

best_hits=0
for ki, K in enumerate(cands):
    for sp_name, (kid, sp) in decoded.items():
        kid_be = int.from_bytes(kid,"big"); kid_le=int.from_bytes(kid,"little")
        enc_k_at2 = sp[2:18]
        enc_k_at1 = sp[1:17]
        enc_iv    = sp[18:34]
        for slot,enc_block in [("sp[2:18]",enc_k_at2),("sp[1:17]",enc_k_at1)]:
            ck = ecb_dec(K, enc_block)
            # 检验 ck 作为内容密钥
            for tag,(cipher,sz0,mds,off0,kid_hex) in cipher_s0.items():
                if sp_name not in tag and sp_name!="ep3":
                    pass  # ep3 没有对应密文, 跳过, 只用 hit1/hit3 的 kid
                k2=bytes.fromhex(kid_hex); iv_be=int.from_bytes(k2,"big"); iv_le=int.from_bytes(k2,"little")
                for ivn, iv0 in [("zero",0),("kid_be",iv_be),("kid_le",iv_le),
                                  ("enc_iv",int.from_bytes(ecb_dec(K,enc_iv),"big"))]:
                    # whole-mdat CTR, sample0在 mdat_off=off0-mds
                    mo = off0-mds; blk_idx = mo//16; r=mo%16
                    if r>11: continue
                    ks=ctr_ks(ck, iv0, blk_idx, 4)
                    pt=bytes(a^b for a,b in zip(cipher,ks[r:r+len(cipher)]))
                    if valid_hevc(pt,sz0):
                        print(f"  *** HIT wrap_key#{ki}={K.hex()} spade={sp_name} slot={slot} iv={ivn} -> HEVC valid! pt={pt[:8].hex()} NALlen={struct.unpack('>I',pt[0:4])[0]} naltype={(pt[4]>>1)&0x3f}")
                        best_hits+=1
if best_hits==0:
    print("  no hit - 内容密钥不是28候选密钥直接ECB解包spade_a的结果")
