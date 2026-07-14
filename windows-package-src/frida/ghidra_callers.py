# -*- coding: utf-8 -*-
"""Ghidra headless: 找指定地址的调用者并反编译。argv: <so> <addr1> [addr2..]"""
import subprocess, os, sys, time
HEADLESS=r"D:\code\hongguo\tools\ghidra_12.1_PUBLIC\support\analyzeHeadless.bat"
JAVA_HOME=r"D:\code\hongguo\tools\jdk21\jdk-21.0.11+10"
PROJ=r"D:\code\hongguo\tools\ghidra_proj"; SCRIPTS=r"D:\code\hongguo\tools\ghidra_scripts"
so=sys.argv[1]; addrs=sys.argv[2:]
sopath=os.path.abspath(f"capture/so/{so}"); out=os.path.abspath(f"capture/callers_{so}.c")
env=dict(os.environ); env["JAVA_HOME"]=JAVA_HOME
cmd=[HEADLESS,PROJ,"pc_"+so.replace(".","_"),"-import",sopath,"-scriptPath",SCRIPTS,
     "-postScript","FindCallers.java",out]+addrs+["-deleteProject"]
print("running...",addrs); t0=time.time()
r=subprocess.run(cmd,env=env,capture_output=True,text=True,timeout=1200)
print("elapsed",int(time.time()-t0),"s")
for line in (r.stdout+r.stderr).splitlines():
    if any(k in line for k in ["CALLERS_DONE","callers","ERROR REPORT","Exception in"]):
        print(" ",line[:160])
print("out:",os.path.exists(out),os.path.getsize(out) if os.path.exists(out) else 0)
