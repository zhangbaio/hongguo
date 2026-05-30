# -*- coding: utf-8 -*-
"""端到端验证: 用 Frida 预言机给 multi_video_model 生成新签名并重发。
成功标志: 返回 code=0 且含 main_url 视频直链。
"""
import frida, subprocess, hashlib, time, json, urllib3
from mitmproxy import io, http
import requests
urllib3.disable_warnings()

ADB = r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"
DEV = "127.0.0.1:16384"
FLOW = r"D:\code\hongguo\capture\out\full.flow"

# 1) 取一条真实 multi_video_model 请求
src = None
with open(FLOW, "rb") as fp:
    for f in io.FlowReader(fp).stream():
        if isinstance(f, http.HTTPFlow) and "multi_video_model" in f.request.path:
            src = f; break
url = src.request.pretty_url
body = src.request.get_text()
cap_headers = dict(src.request.headers)
print("URL:", url[:100], "...")
print("body:", body[:120])

# 2) 连 Frida 预言机
pid = int(subprocess.run([ADB,"-s",DEV,"shell","pidof","com.phoenix.read"],
                         capture_output=True,text=True).stdout.split()[0])
dev = frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session = dev.attach(pid)
script = session.create_script(open(r"D:\code\hongguo\frida\oracle.js",encoding="utf-8").read())
script.load()

# 3) 构造基础头(复制非签名头, 刷新时间戳和stub)
stub = hashlib.md5(body.encode()).hexdigest().upper()
base = {
    "x-ss-stub": stub,
    "content-type": cap_headers.get("content-type","application/json; charset=utf-8"),
    "user-agent": cap_headers.get("user-agent"),
    "x-tt-token": cap_headers.get("x-tt-token",""),
    "cookie": cap_headers.get("cookie",""),
    "passport-sdk-version": cap_headers.get("passport-sdk-version","5051452"),
    "sdk-version": cap_headers.get("sdk-version","2"),
}
base = {k:v for k,v in base.items() if v}

# 4) 调预言机生成新鲜签名
sec = script.exports_sync.sign(url, base)
print("=== 预言机返回的新签名头 ===")
for k,v in sec.items(): print(f"  {k}: {str(v)[:40]}")

# 5) 合并并发请求
send_headers = dict(base)
send_headers.update(sec)
send_headers.pop("accept-encoding", None)
r = requests.post(url, data=body.encode(), headers=send_headers, verify=False, timeout=20)
print("=== 重发结果 HTTP", r.status_code, "===")
txt = r.text
try:
    j = r.json()
    print("code:", j.get("code"), "msg:", j.get("message") or j.get("BaseResp",{}).get("StatusMessage"))
    data = j.get("data") or {}
    for vid,v in (data.items() if isinstance(data,dict) else []):
        vm = v.get("video_model","")
        if "main_url" in vm:
            import re
            mu = re.search(r'"main_url":"([^"]+)"', vm)
            print(f"  ✓✓✓ 成功拿到视频直链! vid={vid}")
            print("     ", mu.group(1)[:120] if mu else "")
            break
except Exception as e:
    print("非JSON:", txt[:200])
