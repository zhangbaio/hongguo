# -*- coding: utf-8 -*-
import subprocess, socket
ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; D="127.0.0.1:16384"
def sh(c): return subprocess.run([ADB,"-s",D,"shell",c],capture_output=True,text=True).stdout.strip()
print("devices:", subprocess.run([ADB,"devices"],capture_output=True,text=True).stdout.strip())
print("app pid:", repr(sh("pidof com.phoenix.read")))
print("frida-server pid:", repr(sh("su -c 'pidof frida-server'")))
print("top:", sh("dumpsys activity activities | grep -i topResumed")[:200])
s=socket.socket(); s.settimeout(2)
try: s.connect(("127.0.0.1",27042)); print("frida 27042: OPEN")
except Exception as e: print("frida 27042:", e)
s.close()
