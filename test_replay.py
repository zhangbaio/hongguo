# -*- coding: utf-8 -*-
"""测试: 能否从独立脚本调用 multi_video_model 接口?
从 full.flow 取一条真实请求,分别用[带签名头]和[去签名头]重放,看服务器是否接受。
这决定下载脚本是否需要破解X-Argus签名。
"""
import os, json, urllib3
from mitmproxy import io, http
urllib3.disable_warnings()
import requests

FLOW = os.path.join(os.path.dirname(os.path.abspath(__file__)), "capture", "out", "full.flow")

# 取一条 multi_video_model 请求
target = None
with open(FLOW, "rb") as fp:
    for f in io.FlowReader(fp).stream():
        if isinstance(f, http.HTTPFlow) and "multi_video_model" in f.request.path:
            target = f
            break

if not target:
    print("没找到 multi_video_model 请求")
    raise SystemExit

url = target.request.pretty_url
body = target.request.get_text()
hdrs = dict(target.request.headers)
print("URL:", url[:120], "...")
print("Body:", body[:200])
print("原签名头: x-argus=%s x-gorgon=%s x-khronos=%s" % (
    hdrs.get("x-argus"), hdrs.get("x-gorgon", "")[:20], hdrs.get("x-khronos")))
print("=" * 70)

def show(tag, resp):
    print(f"[{tag}] HTTP {resp.status_code}, {len(resp.content)}B")
    try:
        j = resp.json()
        code = j.get("code")
        msg = j.get("message") or j.get("BaseResp", {}).get("StatusMessage")
        print(f"     code={code} message={msg}")
        # 看是否真的返回了视频URL
        data = j.get("data") or {}
        for vid, v in (data.items() if isinstance(data, dict) else []):
            vm = v.get("video_model")
            if vm and "main_url" in vm:
                print(f"     ✓ 返回了视频直链! vid={vid}")
                break
    except Exception as e:
        print("     非JSON响应:", resp.text[:150])

# 1) 带完整原始头重放
h1 = {k: v for k, v in hdrs.items() if k.lower() not in ("content-length", "host", "accept-encoding")}
try:
    r = requests.post(url, data=body.encode(), headers=h1, verify=False, timeout=15)
    show("带原签名头", r)
except Exception as e:
    print("[带原签名头] 失败:", e)

# 2) 去掉所有签名头重放
h2 = {k: v for k, v in h1.items() if k.lower() not in ("x-argus", "x-gorgon", "x-ladon", "x-khronos", "x-medusa", "x-ss-stub")}
try:
    r = requests.post(url, data=body.encode(), headers=h2, verify=False, timeout=15)
    show("去签名头", r)
except Exception as e:
    print("[去签名头] 失败:", e)
