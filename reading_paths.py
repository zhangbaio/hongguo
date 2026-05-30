# -*- coding: utf-8 -*-
"""列出红果 reading API 服务器上的所有接口路径(按真实Host归类)"""
import json, os
from urllib.parse import unquote
FLOWS = os.path.join(os.path.dirname(os.path.abspath(__file__)), "capture", "out", "flows.jsonl")
rows = [json.loads(l) for l in open(FLOWS, encoding="utf-8") if l.strip()]

def real_host(r):
    return r.get("req_headers", {}).get("Host") or r.get("req_headers", {}).get("host") or r["host"]

# 业务接口：reading-lq.snssdk.com 或路径含 /reading/ 或 search/detail/video
seen = {}
for r in rows:
    rh = real_host(r)
    p = unquote(r["path"].split("?")[0])
    is_api = ("reading-lq.snssdk.com" in rh or "/reading/" in p
              or any(k in p.lower() for k in ("search", "detail", "video", "episode", "/page/", "/bookapi/", "/feed")))
    # 排除纯CDN图片/视频(单独看)
    if "videocdn" in rh or "fqnovelpic" in rh or "byteimg" in rh or ".heic" in p or ".css" in p:
        continue
    if not is_api:
        continue
    key = f"{r['method']} {rh}{p}"
    d = seen.setdefault(key, {"n": 0, "ct": "", "status": r["status"]})
    d["n"] += 1
    d["ct"] = r.get("resp_ctype", "")

for k in sorted(seen):
    print(f"[{seen[k]['status']}] {k}  ({seen[k]['ct'].split(';')[0]}) x{seen[k]['n']}")
