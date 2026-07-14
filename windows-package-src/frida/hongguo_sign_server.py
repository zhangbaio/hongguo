#!/usr/bin/env python3
"""红果 aid-8662 原生签名 HTTP 服务(设备后端, frida 调 libmetasec 0x27d288)。
协议同 FqTrace: POST /sign {"url":..,"headers":{k:v}} -> {"X-Argus":..,"X-Gorgon":..,...}
hongguo.py 设 SIGN_SERVER=http://127.0.0.1:<port> 即用红果自身签名(含 device_register 能力)。
依赖: frida-server 在设备/模拟器运行 + 红果 app(com.phoenix.read)在前台已初始化。
"""
import frida, subprocess, json, threading, sys, os
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer

PKG="com.phoenix.read"
SCRIPT=os.path.join(os.path.dirname(__file__),"sign_service.js")
_lock=threading.Lock()
_script=None

def _pid():
    return int(subprocess.check_output(["adb","shell","pgrep","-f",PKG]).split()[0])

def attach():
    global _script
    dev=frida.get_usb_device()
    sess=dev.attach(_pid())
    s=sess.create_script(open(SCRIPT).read()); s.load()
    _script=s
    print("[*] 已附加红果签名服务")
    return s

def sign(url, headers):
    # headers dict -> "k\r\nv\r\n..." 完整对(0x27d288 要求非空+完整对)
    hb=""
    for k,v in (headers or {}).items():
        hb+=f"{k}\r\n{v}\r\n"
    if not hb: hb="content-type\r\napplication/json; charset=utf-8\r\n"
    with _lock:
        try:
            sig=_script.exports_sync.sign(url, hb)
        except Exception:
            attach(); sig=_script.exports_sync.sign(url, hb)  # app重启后重连
    out={}
    if sig:
        lines=sig.replace("\r\n","\n").strip().split("\n")
        for i in range(0,len(lines)-1,2):
            if lines[i].startswith("X-"): out[lines[i]]=lines[i+1]
    return out

class H(BaseHTTPRequestHandler):
    def log_message(self,*a): pass
    def do_POST(self):
        if self.path!="/sign": self.send_response(404); self.end_headers(); return
        n=int(self.headers.get("content-length",0))
        req=json.loads(self.rfile.read(n) or b"{}")
        try:
            res=sign(req.get("url",""), req.get("headers",{}))
            body=json.dumps(res).encode()
        except Exception as e:
            body=json.dumps({"error":str(e)}).encode()
        self.send_response(200); self.send_header("Content-Type","application/json")
        self.send_header("Content-Length",str(len(body))); self.end_headers(); self.wfile.write(body)

if __name__=="__main__":
    port=int(sys.argv[1]) if len(sys.argv)>1 else 9101
    host=os.environ.get("BIND_HOST","127.0.0.1")
    attach()
    srv=ThreadingHTTPServer((host,port),H)
    print(f"[*] 红果原生签名服务: {host}:{port}/sign")
    srv.serve_forever()
