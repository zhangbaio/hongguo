# -*- coding: utf-8 -*-
"""列出 API 主域名上的所有请求(含完整路径参数)"""
import json, os
from urllib.parse import unquote
FLOWS = os.path.join(os.path.dirname(os.path.abspath(__file__)), "capture", "out", "flows.jsonl")
rows = [json.loads(l) for l in open(FLOWS, encoding="utf-8") if l.strip()]

# API主域名 + 所有 snssdk/zijieapi 业务域名
API_HOSTS = ("snssdk.com", "zijieapi.com")
for r in rows:
    if not any(h in r["host"] for h in API_HOSTS):
        continue
    p = unquote(r["path"])
    # 路径截断显示，但保留前150字符看参数
    print(f'{r["time"][11:19]} {r["method"]} {r["host"]}{p[:150]}')
