# -*- coding: utf-8 -*-
"""下载+解压 Ghidra 到 D:\\code\\hongguo\\tools\\ghidra。"""
import urllib.request, json, os, zipfile, ssl, time

ctx=ssl.create_default_context()
TOOLS=r"D:\code\hongguo\tools"; os.makedirs(TOOLS,exist_ok=True)

# 1) 直链(已由release页确认) — 避开API限流
name="ghidra_12.1_PUBLIC_20260513.zip"
url="https://github.com/NationalSecurityAgency/ghidra/releases/download/Ghidra_12.1_build/"+name
size=542*1024*1024  # 约542MB
print(f"asset: {name} (~542MB)\n  {url}")

dst=os.path.join(TOOLS,name)
if os.path.exists(dst) and os.path.getsize(dst)==size:
    print("已下载")
else:
    print("downloading...")
    t0=time.time(); last=0
    req2=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"})
    with urllib.request.urlopen(req2,timeout=120,context=ctx) as r, open(dst,"wb") as f:
        done=0
        while True:
            chunk=r.read(1024*1024)
            if not chunk: break
            f.write(chunk); done+=len(chunk)
            if done-last>20*1024*1024:
                last=done; print(f"  {done//(1024*1024)}/{size//(1024*1024)}MB {time.time()-t0:.0f}s",flush=True)
    print(f"downloaded {os.path.getsize(dst)//(1024*1024)}MB in {time.time()-t0:.0f}s")

# 2) 解压
print("extracting...")
with zipfile.ZipFile(dst) as z:
    z.extractall(TOOLS)
# 找 ghidraRun.bat / analyzeHeadless.bat
import glob
runbat=glob.glob(TOOLS+r"\**\ghidraRun.bat",recursive=True)
headless=glob.glob(TOOLS+r"\**\analyzeHeadless.bat",recursive=True)
print("ghidraRun:",runbat[:2])
print("analyzeHeadless:",headless[:2])
