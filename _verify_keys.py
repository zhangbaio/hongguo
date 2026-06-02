import json, struct, os
from Crypto.Cipher import AES
from Crypto.Util import Counter

d=open("_play_cipher.mp4","rb").read()
OFF0=242760; SIZE0=25528; IV0=bytes.fromhex("23963a1817833f2c")
sample=d[OFF0:OFF0+min(SIZE0,64)]

def aes_ctr(key, iv8, ct):
    # CENC AES-CTR: 16B counter = iv8(high) || 0 (low 8 bytes block index)
    init=int.from_bytes(iv8 + b"\x00"*8, "big")
    ctr=Counter.new(128, initial_value=init)
    return AES.new(key, AES.MODE_CTR, counter=ctr).decrypt(ct)

def looks_hevc(p):
    if len(p)<6: return False
    L=struct.unpack(">I",p[:4])[0]
    if not (0 < L <= SIZE0): return False
    nh=p[4]
    if nh & 0x80: return False          # forbidden_zero_bit
    t=(nh>>1)&0x3f
    return 0<=t<=40                      # valid HEVC NAL type

def main():
    keys=json.load(open("_allkeys.json")) if os.path.exists("_allkeys.json") else []
    print("候选密钥:", len(keys))
    hits=[]
    for k in keys:
        bits,hx=k.split(":")
        kb=bytes.fromhex(hx)
        if len(kb)!=16: continue          # CENC content key=128bit
        pt=aes_ctr(kb, IV0, sample)
        if looks_hevc(pt):
            hits.append((hx, pt[:16].hex()))
            print("★ 命中 key=",hx," 明文头=",pt[:16].hex(),"NAL_type=",(pt[4]>>1)&0x3f)
    if not hits:
        print("无匹配。前几个候选解密结果(参考):")
        for k in keys[:5]:
            bits,hx=k.split(":")
            kb=bytes.fromhex(hx)
            if len(kb)==16:
                print("  ",hx,"->",aes_ctr(kb,IV0,sample)[:16].hex())
    else:
        open("_FOUND_KEY.json","w").write(json.dumps([h[0] for h in hits]))
        print("已存 _FOUND_KEY.json")

if __name__=="__main__":
    main()
