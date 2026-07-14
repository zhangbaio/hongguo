# -*- coding: utf-8 -*-
"""从设备拉 libEncryptor.so / libdragon_crypt.so / libavmdlv2.so 用于静态分析。"""
import subprocess, os
ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; D="127.0.0.1:16384"
def adb(*a): return subprocess.run([ADB,"-s",D]+list(a),capture_output=True,text=True).stdout.strip()
def adb_b(*a): return subprocess.run([ADB,"-s",D]+list(a),capture_output=True).stdout

TARGETS=["libEncryptor.so","libdragon_crypt.so","libttcrypto.so"]
os.makedirs("capture/so", exist_ok=True)
for so in TARGETS:
    path=adb("shell","su -c 'find /data/app -name "+so+" 2>/dev/null | head -1'").strip()
    if not path:
        path=adb("shell","su -c 'find /system -name "+so+" 2>/dev/null | head -1'").strip()
    print(f"{so}: {path}")
    if path:
        data=subprocess.run([ADB,"-s",D,"exec-out","su -c 'cat "+path+"'"],capture_output=True).stdout
        out=f"capture/so/{so}"
        open(out,"wb").write(data)
        print(f"  -> {out} {len(data)} bytes")
    else:
        print("  not found")
