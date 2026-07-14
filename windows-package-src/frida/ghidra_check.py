# -*- coding: utf-8 -*-
"""检查 Ghidra 前提: Java/JDK, 已装的Ghidra, 磁盘空间。"""
import subprocess, os, glob, shutil

def run(cmd):
    try: return subprocess.run(cmd,capture_output=True,text=True,timeout=20,shell=isinstance(cmd,str))
    except Exception as e: return None

# 1) java
for jcmd in ["java","javaw"]:
    r=run([jcmd,"-version"])
    if r and (r.stderr or r.stdout):
        print(f"[{jcmd}] {(r.stderr or r.stdout).splitlines()[0] if (r.stderr or r.stdout) else ''}")
        break
else:
    print("java not on PATH")

print("JAVA_HOME=", os.environ.get("JAVA_HOME"))

# 2) 找已装 JDK
cands=[]
for base in [r"C:\Program Files\Java",r"C:\Program Files\Eclipse Adoptium",
             r"C:\Program Files\Microsoft", os.path.expanduser(r"~\.jdks"),
             r"C:\Program Files\Android\Android Studio\jbr", r"D:\code\hongguo\unidbg"]:
    if os.path.isdir(base):
        for d in glob.glob(base+r"\*"):
            if os.path.isdir(d): cands.append(d)
print("可能的JDK目录:", cands[:15])
# 找 java.exe
javas=[]
for base in [r"C:\Program Files\Java",r"C:\Program Files\Eclipse Adoptium",r"C:\Program Files\Microsoft",
             os.path.expanduser(r"~\.jdks"),r"C:\Program Files\Android\Android Studio\jbr"]:
    javas+=glob.glob(base+r"\**\bin\java.exe",recursive=True)
print("找到的 java.exe:")
for j in javas[:15]:
    r=run([j,"-version"])
    ver=(r.stderr or r.stdout).splitlines()[0] if r and (r.stderr or r.stdout) else "?"
    print(f"   {j}  =>  {ver}")

# 3) 已装 Ghidra?
gh=glob.glob(r"C:\**\ghidraRun.bat",recursive=False)+glob.glob(r"D:\**\ghidraRun.bat")+glob.glob(os.path.expanduser(r"~\**\ghidra*\ghidraRun.bat"))
print("已装Ghidra:", gh[:5] if gh else "无")

# 4) 磁盘空间
for drv in ["D:\\","C:\\"]:
    try:
        t,u,f=shutil.disk_usage(drv); print(f"{drv} free {f//(1024**3)}GB")
    except: pass
