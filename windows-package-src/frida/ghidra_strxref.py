# -*- coding: utf-8 -*-
"""Ghidra headless: 对 .so 跑 FindStrXref, 找引用锚字符串的函数+调用者并反编译"""
import subprocess, os, sys, time

HEADLESS=r"D:\code\hongguo\tools\ghidra_12.1_PUBLIC\support\analyzeHeadless.bat"
JAVA_HOME=r"D:\code\hongguo\tools\jdk21\jdk-21.0.11+10"
PROJ=r"D:\code\hongguo\tools\ghidra_proj"
SCRIPTS=r"D:\code\hongguo\tools\ghidra_scripts"
os.makedirs(PROJ,exist_ok=True)

so=sys.argv[1]
anchors=sys.argv[2:]
sopath=os.path.abspath(f"capture/so/{so}")
out=os.path.abspath(f"capture/strxref_{so}.c")
projname="px_"+so.replace(".","_")

env=dict(os.environ); env["JAVA_HOME"]=JAVA_HOME
cmd=[HEADLESS,PROJ,projname,"-import",sopath,"-scriptPath",SCRIPTS,
     "-postScript","FindStrXref.java",out]+anchors+["-deleteProject"]
print("anchors:",anchors)
t0=time.time()
r=subprocess.run(cmd,env=env,capture_output=True,text=True,timeout=1200)
print("elapsed",int(time.time()-t0),"s")
for line in (r.stdout+r.stderr).splitlines():
    if any(k in line for k in ["STR ","STRXREF_DONE","NOTFOUND","xref=","ERROR","Exception"]):
        print(" ",line[:160])
print("out:",os.path.exists(out), os.path.getsize(out) if os.path.exists(out) else 0)
