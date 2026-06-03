# -*- coding: utf-8 -*-
"""Ghidra headless 反编译指定.so, 导出C到 capture/decomp_<so>.c"""
import subprocess, os, sys

HEADLESS=r"D:\code\hongguo\tools\ghidra_12.1_PUBLIC\support\analyzeHeadless.bat"
JAVA_HOME=r"D:\code\hongguo\tools\jdk21\jdk-21.0.11+10"
PROJ=r"D:\code\hongguo\tools\ghidra_proj"
SCRIPTS=r"D:\code\hongguo\tools\ghidra_scripts"
os.makedirs(PROJ,exist_ok=True)

so=sys.argv[1] if len(sys.argv)>1 else "libEncryptor.so"
sopath=os.path.abspath(f"capture/so/{so}")
out=os.path.abspath(f"capture/decomp_{so}.c")
projname="p_"+so.replace(".","_")

env=dict(os.environ); env["JAVA_HOME"]=JAVA_HOME
cmd=[HEADLESS,PROJ,projname,"-import",sopath,"-scriptPath",SCRIPTS,
     "-postScript","DecompAll.java",out,"-deleteProject"]
print("running:"," ".join(cmd))
import time;t0=time.time()
r=subprocess.run(cmd,env=env,capture_output=True,text=True,timeout=900)
print("elapsed",int(time.time()-t0),"s")
# 打印关键日志行
for line in (r.stdout+r.stderr).splitlines():
    if any(k in line for k in ["DECOMP_DONE","ERROR","Exception","analysis","Import","Function","cannot","not found"]):
        print(" ",line[:160])
print("out exists:",os.path.exists(out), os.path.getsize(out) if os.path.exists(out) else 0,"bytes")
