# -*- coding: utf-8 -*-
"""Frida 运行器: python run.py <js文件> [秒数]
附加到 com.phoenix.read(按PID),加载js,打印send消息。
"""
import frida, sys, time, subprocess, os

ADB = r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"
DEV = "127.0.0.1:16384"
PKG = "com.phoenix.read"

def get_pid():
    out = subprocess.run([ADB, "-s", DEV, "shell", "pidof", PKG],
                         capture_output=True, text=True).stdout.strip()
    return int(out.split()[0]) if out else None

def main():
    js = sys.argv[1]
    dur = float(sys.argv[2]) if len(sys.argv) > 2 else 3
    pid = get_pid()
    if not pid:
        print("红果没运行"); return
    print(f"attach pid={pid}")
    dev = frida.get_device_manager().add_remote_device("127.0.0.1:27042")
    session = dev.attach(pid)
    script = session.create_script(open(js, encoding="utf-8").read())
    def on_msg(m, data):
        if m["type"] == "send":
            print(m["payload"])
        else:
            print("[ERR]", m.get("description") or m)
    script.on("message", on_msg)
    script.load()
    time.sleep(dur)

if __name__ == "__main__":
    main()
