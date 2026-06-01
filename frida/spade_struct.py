# -*- coding: utf-8 -*-
import base64
samples = {
 "ep3":  ("6a1978c1f8818b00477f5c0e0002ebeb", "oLwu8WK3KPBWix3bZKc03nuWA9h+ojTsZaQs9Va9B8Z6jDKPjw=="),
 "hit1": ("6a1165c8f8818be2b9fb87020002ebeb", "orws9lSPKMRWgi3PYYQw1GKoJfhfsRLKQrIN/V+EEM9ehBajow=="),
 "hit3": ("6a1165c8f8818b04e11464d90002ebeb", "obwvxGK+GMdQgBfJR4MKykGED8l1gjr7cLIg+2+rP9R0ozyurg=="),
}
def h(b): return b.hex()
decoded={}
for name,(kid,spade) in samples.items():
    k=bytes.fromhex(kid); s=base64.b64decode(spade)
    decoded[name]=(k,s)
    print(f"== {name} ==")
    print(f"  kid({len(k)}B)    {h(k)}")
    print(f"  spade({len(s)}B)  {h(s)}")
    # spade 分段试探: 前16/中16/尾
    print(f"    spade[0:16]  {h(s[0:16])}")
    print(f"    spade[16:32] {h(s[16:32])}")
    print(f"    spade[32:]   {h(s[32:])}")
    # XOR kid
    x=bytes(a^b for a,b in zip(s[:16],k))
    print(f"    spade[0:16]^kid     {h(x)}")
    x2=bytes(a^b for a,b in zip(s[16:32],k))
    print(f"    spade[16:32]^kid    {h(x2)}")
print("\n== 跨样本对比(找固定段) ==")
ss=[decoded[n][1] for n in samples]
for i in range(37):
    col=set(s[i] for s in ss)
    mark = " <-常量" if len(col)==1 else ""
    print(f"  byte[{i:2d}] " + " ".join("%02x"%s[i] for s in ss) + mark)
