# -*- coding: utf-8 -*-
"""列出所有业务接口（排除网易/MuMu噪音和纯图片视频CDN）"""
import json, os
FLOWS = os.path.join(os.path.dirname(os.path.abspath(__file__)), "capture", "out", "flows.jsonl")
rows = [json.loads(l) for l in open(FLOWS, encoding="utf-8") if l.strip()]

NOISE_HOST = ("netease", "mumu", "163.com", "gtimg", "baidu")
CDN = ("fqnovelpic", "byteimg", "bytetos", ".click", "dahhx", ".css")

seen = {}
for r in rows:
    h = r["host"]
    if any(n in h for n in NOISE_HOST):
        continue
    path = r["path"].split("?")[0]
    if any(x in h or x in path for x in CDN):
        continue
    key = f'{r["method"]} {h}{path}'
    d = seen.setdefault(key, {"n": 0, "ct": r.get("resp_ctype", "")})
    d["n"] += 1
    if r.get("resp_ctype"):
        d["ct"] = r["resp_ctype"]

for k in sorted(seen, key=lambda x: -seen[x]["n"]):
    print(f'{seen[k]["n"]:3}x {k}   [{seen[k]["ct"].split(";")[0]}]')
