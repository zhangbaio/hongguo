# -*- coding: utf-8 -*-
"""hook_enc.js 的运行器: 动态获取当前 pid"""
import frida, subprocess, time, json

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def get_pid():
    out=subprocess.run([ADB,"-s",DEV,"shell","pidof",PKG],capture_output=True,text=True).stdout.strip()
    return int(out.split()[0]) if out else None

pid=get_pid(); print(f"pid={pid}")
if not pid: exit(1)
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
js=open("frida/hook_enc.js",encoding="utf-8").read()
script=session.create_script(js)
all_msgs=[]; fn_calls=set()
def on_msg(m,data):
    if m["type"]=="send":
        p=m["payload"]; t=p.get("t","")
        if t in ("mods","info","fn_scan"): print("[i]",p)
        elif t=="native_method": print("[NATIVE]",p)
        elif t=="memcpy_enc":
            k=p["bytes"][:32]; msg=f"[memcpy sz={p['sz']}] {k}"
            if k not in fn_calls: print(msg); fn_calls.add(k)
            all_msgs.append(p)
        elif t=="fn_call":
            k=f"{p['fn']}-{p['out']}"; msg=f"[fn#{p['idx']}@{p['fn']}] out={p['out']} ret={p['ret']}"
            if k not in fn_calls: print(msg); fn_calls.add(k)
        elif t in ("err","err2"): print("[ERR]",p)
    else: print("[ERR2]",m.get("description")or m)
script.on("message",on_msg)
script.load()
print("monitoring 60s... browse/play videos")
time.sleep(60)
if all_msgs:
    json.dump(all_msgs, open("capture/hook_enc_memcpy.json","w"), indent=2)
    print(f"saved {len(all_msgs)} memcpy events")
