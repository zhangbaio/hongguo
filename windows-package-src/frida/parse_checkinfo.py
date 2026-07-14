# -*- coding: utf-8 -*-
import re, glob, os
for fn in sorted(glob.glob("capture/mem_hit_1.txt"))+sorted(glob.glob("capture/mem_hit_3.txt")):
    t = open(fn, encoding="utf-8").read()
    print("="*72); print(os.path.basename(fn))
    # check_info 完整(到下一个平衡或截断)
    i = t.find('"check_info"')
    if i>=0:
        print("check_info ctx:", t[i:i+400].replace(".",""))
    # 找任何含 iv / pssh / sample / fragment / nonce / counter 的键
    for kw in ["iv","pssh","nonce","counter","fmp4","fragment","init_range","index_range","cipher","aes"]:
        for m in re.finditer(r'"([a-zA-Z0-9_]*%s[a-zA-Z0-9_]*)"\s*:\s*("?[^",}\]]{0,120})' % kw, t):
            print(f"  field {m.group(1)} = {m.group(2)}")
