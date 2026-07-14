# -*- coding: utf-8 -*-
"""运行 scan_pairs.js 存 (kid,url) 对到 capture/pairs.json"""
import frida, subprocess, json
ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def get_pid():
    out=subprocess.run([ADB,"-s",DEV,"shell","pidof",PKG],capture_output=True,text=True).stdout.strip()
    return int(out.split()[0]) if out else None
pid=get_pid(); print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
script=session.create_script(open("frida/scan_pairs.js",encoding="utf-8").read())
pairs=[]
import threading
done=threading.Event()
def on_msg(m,data):
    if m["type"]=="send":
        p=m["payload"]
        if p.get("t")=="pair": pairs.append({"kid":p["kid"],"url":p["url"]})
        elif p.get("t")=="done": print(f"[done] {p['n']} pairs"); done.set()
script.on("message",on_msg)
script.load()
done.wait(timeout=60)
json.dump(pairs,open("capture/pairs.json","w"),indent=2)
# 统计
kids=set(p["kid"] for p in pairs)
print(f"saved {len(pairs)} (kid,url) pairs, {len(kids)} distinct kids")
for p in pairs[:5]: print(f"  kid={p['kid']} url={p['url'][:70]}")
