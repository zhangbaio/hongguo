# -*- coding: utf-8 -*-
"""Ghidra headless: 对 .so 跑 FindAESXref, 找引用AES S-box的函数并反编译。"""
import subprocess, os, sys, time
HEADLESS=r"D:\code\hongguo\tools\ghidra_12.1_PUBLIC\support\analyzeHeadless.bat"
JAVA_HOME=r"D:\code\hongguo\tools\jdk21\jdk-21.0.11+10"
PROJ=r"D:\code\hongguo\tools\ghidra_proj"; SCRIPTS=r"D:\code\hongguo\tools\ghidra_scripts"
so=sys.argv[1] if len(sys.argv)>1 else "libavmdlv2.so"
sopath=os.path.abspath(f"capture/so/{so}"); out=os.path.abspath(f"capture/aesxref_{so}.c")
env=dict(os.environ); env["JAVA_HOME"]=JAVA_HOME
cmd=[HEADLESS,PROJ,"px_"+so.replace(".","_"),"-import",sopath,"-scriptPath",SCRIPTS,
     "-postScript","FindAESXref.java",out,"-deleteProject"]
print("running headless on",so,"...")
t0=time.time()
r=subprocess.run(cmd,env=env,capture_output=True,text=True,timeout=1200)
print("elapsed",int(time.time()-t0),"s")
for line in (r.stdout+r.stderr).splitlines():
    if any(k in line for k in ["SBOX","AESXREF_DONE","ref funcs","ERROR","Exception","NOT_FOUND"]):
        print(" ",line[:160])
print("out:",os.path.exists(out),os.path.getsize(out) if os.path.exists(out) else 0)
