# -*- coding: utf-8 -*-
import re, json, glob, os
res = {}
for fn in ["capture/mem_hit_1.txt","capture/mem_hit_3.txt"]:
    t = open(fn, encoding="utf-8").read()
    # 完整 main_url(到下一个引号)
    m = re.search(r'"main_url"\s*:\s*"([^"]+)"', t)
    url = m.group(1) if m else None
    kid = re.search(r'"kid"\s*:\s*"([0-9a-f]+)"', t)
    spade = re.search(r'"spade_a"\s*:\s*"([^"]+)"', t)
    size = re.search(r'"size"\s*:\s*(\d+)', t)
    ck = re.search(r'"check_info"\s*:\s*"([^"]+)"', t)
    res[fn] = {"main_url": url, "kid": kid.group(1) if kid else None,
               "spade_a": spade.group(1) if spade else None,
               "size": int(size.group(1)) if size else None,
               "check_info": ck.group(1) if ck else None}
    print(os.path.basename(fn))
    print("  kid    ", res[fn]["kid"])
    print("  spade_a", res[fn]["spade_a"])
    print("  size   ", res[fn]["size"])
    print("  check  ", res[fn]["check_info"])
    print("  url len", len(url) if url else 0)
json.dump(res, open("capture/hits_meta.json","w"), indent=2)
print("saved capture/hits_meta.json")
