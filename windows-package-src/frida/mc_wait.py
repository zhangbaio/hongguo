# -*- coding: utf-8 -*-
"""持续等待 MediaCodec 帧, 直到抓到足够数据(>500KB)才停止。
请你在 app 里播放任意在线短剧(非下载版)。"""
import frida, subprocess, time, os

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def get_pid():
    out=subprocess.run([ADB,"-s",DEV,"shell","pidof",PKG],capture_output=True,text=True).stdout.strip()
    return int(out.split()[0]) if out else None

pid=get_pid(); print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
js=open("frida/mc_all.js",encoding="utf-8").read()
# 增加超时到 300 秒(5分钟等待)
js=js.replace("if (tick >= 20)", "if (tick >= 60)")
script=session.create_script(js)

state={"vb":0,"done":False}
def on_msg(m,data):
    if m["type"]=="send":
        p=m["payload"]; t=p.get("t","")
        if t=="tick":
            vb=p["vBytes"]; state["vb"]=vb
            if vb>0: print(f"[CAPTURING] vBytes={vb} aBytes={p['aBytes']}")
            else: print(f"[waiting...] tick={p['tick']}")
        elif t=="done": print(f"[DONE] vBytes={p['vBytes']}"); state["done"]=True
        elif t in ("files_ok","java_hook","native_hook"): print(f"[setup] {p}")
        elif t=="v_frame": print(f"[FIRST FRAME] size={p['size']} flags={p['flags']}")
    else: print("[ERR]",m)
script.on("message",on_msg)
script.load()
print("\n=== HOOK READY ===")
print("请在 app 里播放任意在线短剧（首页刷到的，不是下载列表里的）")
print("Hook 会自动捕获，最多等5分钟...")
t0=time.time()
while time.time()-t0<300 and not state["done"]:
    time.sleep(0.5)
    if state["vb"]>500000:
        print(f"Got {state['vb']} bytes, enough! Stopping...")
        break

# 拉取文件
print("pulling output file...")
out=subprocess.run([ADB,"-s",DEV,"exec-out","su -c 'cat /data/local/tmp/live_video.h265'"],capture_output=True)
open("capture/mc_wait_plain.h265","wb").write(out.stdout)
print(f"saved capture/mc_wait_plain.h265: {len(out.stdout)} bytes")
