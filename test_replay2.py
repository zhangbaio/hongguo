# -*- coding: utf-8 -*-
import os, json, urllib3
from mitmproxy import io, http
urllib3.disable_warnings()
import requests
FLOW = os.path.join(os.path.dirname(os.path.abspath(__file__)), "capture", "out", "full.flow")

def get_flow(substr, method=None):
    with open(FLOW, "rb") as fp:
        for f in io.FlowReader(fp).stream():
            if isinstance(f, http.HTTPFlow) and substr in f.request.path:
                if method and f.request.method != method:
                    continue
                return f
    return None

# 1) 看 multi_video_model 完整错误响应
f = get_flow("multi_video_model")
url, body, hdrs = f.request.pretty_url, f.request.get_text(), dict(f.request.headers)
h = {k: v for k, v in hdrs.items() if k.lower() not in ("content-length","host","accept-encoding")}
r = requests.post(url, data=body.encode(), headers=h, verify=False, timeout=15)
print("=== multi_video_model 完整响应 ===")
print(repr(r.text))
print()

# 2) 测试 GET 搜索接口(带原签名头)
f2 = get_flow("/reading/bookapi/search/tab/v", method="GET")
if f2:
    url2, hdrs2 = f2.request.pretty_url, dict(f2.request.headers)
    h2 = {k: v for k, v in hdrs2.items() if k.lower() not in ("content-length","host","accept-encoding")}
    r2 = requests.get(url2, headers=h2, verify=False, timeout=15)
    print("=== 搜索接口(带原签名) HTTP", r2.status_code, "===")
    print(r2.text[:300])
    print()
    # 去签名
    h3 = {k:v for k,v in h2.items() if k.lower() not in ("x-argus","x-gorgon","x-ladon","x-khronos","x-medusa","x-ss-stub")}
    r3 = requests.get(url2, headers=h3, verify=False, timeout=15)
    print("=== 搜索接口(去签名) HTTP", r3.status_code, "===")
    print(r3.text[:300])
