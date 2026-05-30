# -*- coding: utf-8 -*-
"""提取 fqnovel.com 内容API的所有接口路径"""
import json, os
from urllib.parse import unquote
FLOWS = os.path.join(os.path.dirname(os.path.abspath(__file__)), "capture", "out", "flows.jsonl")
rows = [json.loads(l) for l in open(FLOWS, encoding="utf-8") if l.strip()]

def rh(r):
    return r.get("req_headers", {}).get("Host") or r.get("req_headers", {}).get("host") or r["host"]

seen = {}
for r in rows:
    host = rh(r)
    if "fqnovel.com" not in host and "qznovelvod" not in host and "reading" not in host:
        continue
    # 跳过纯日志埋点
    if any(x in host for x in ("applog", "rtlog", "log3", "log5", "mon")):
        continue
    p = r["path"].split("?")[0]
    key = f"{r['method']} {host}{p}"
    d = seen.setdefault(key, {"n": 0, "ct": "", "status": r["status"], "size": 0})
    d["n"] += 1
    d["ct"] = r.get("resp_ctype", "")
    d["status"] = r["status"]
    d["size"] = r.get("resp_size", 0)

for k in sorted(seen, key=lambda x: -seen[x]["n"]):
    d = seen[k]
    print(f'[{d["status"]}] {d["n"]:2}x {k}  ({d["ct"].split(";")[0]}, {d["size"]}B)')
