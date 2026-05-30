# -*- coding: utf-8 -*-
"""本地: 下载 frpc + 写配置 + 启动隧道。把本地 server.py:8000 暴露到 云:39001。
环境: FRP_TOKEN  (与服务器 frps 一致)
"""
import os, io, sys, zipfile, urllib.request, subprocess

TOKEN = os.environ["FRP_TOKEN"].strip()
CLOUD = os.environ.get("CLOUD_HOST", "<SERVER_IP>")
HERE = os.path.dirname(os.path.abspath(__file__))
FRPC_EXE = os.path.join(HERE, "frpc.exe")
FRPC_TOML = os.path.join(HERE, "frpc.toml")
URL = "https://github.com/fatedier/frp/releases/download/v0.61.1/frp_0.61.1_windows_amd64.zip"

if not os.path.exists(FRPC_EXE):
    print("下载 frpc...")
    z = zipfile.ZipFile(io.BytesIO(urllib.request.urlopen(URL, timeout=120).read()))
    name = [n for n in z.namelist() if n.endswith("frpc.exe")][0]
    open(FRPC_EXE, "wb").write(z.read(name))
    print(f"  frpc.exe {os.path.getsize(FRPC_EXE)} bytes")

cfg = f"""serverAddr = "{CLOUD}"
serverPort = 39000
auth.method = "token"
auth.token = "{TOKEN}"
loginFailExit = false

[[proxies]]
name = "hongguo-api"
type = "tcp"
localIP = "127.0.0.1"
localPort = 8000
remotePort = 39001
"""
open(FRPC_TOML, "w", encoding="utf-8").write(cfg)
print("已写 frpc.toml")

# 后台启动
p = subprocess.Popen([FRPC_EXE, "-c", FRPC_TOML],
                     stdout=open(os.path.join(HERE, "frpc.log"), "w"),
                     stderr=subprocess.STDOUT,
                     creationflags=getattr(subprocess, "CREATE_NEW_PROCESS_GROUP", 0))
print(f"frpc 已启动 pid={p.pid}, 公网入口: http://{CLOUD}:39001/ui")
