# -*- coding: utf-8 -*-
"""下载+解压 Temurin JDK21 到 tools\\jdk21"""
import urllib.request, os, zipfile, ssl, time, glob
ctx=ssl.create_default_context()
TOOLS=r"D:\code\hongguo\tools"; os.makedirs(TOOLS,exist_ok=True)
url="https://api.adoptium.net/v3/binary/latest/21/ga/windows/x64/jdk/hotspot/normal/eclipse?project=jdk"
dst=os.path.join(TOOLS,"jdk21.zip")
if not (os.path.exists(dst) and os.path.getsize(dst)>50*1024*1024):
    print("downloading JDK21...")
    req=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"})
    t0=time.time();done=0;last=0
    with urllib.request.urlopen(req,timeout=120,context=ctx) as r,open(dst,"wb") as f:
        while True:
            c=r.read(1024*1024)
            if not c:break
            f.write(c);done+=len(c)
            if done-last>30*1024*1024:last=done;print(f"  {done//(1024*1024)}MB {time.time()-t0:.0f}s",flush=True)
    print(f"downloaded {os.path.getsize(dst)//(1024*1024)}MB")
print("extracting...")
with zipfile.ZipFile(dst) as z: z.extractall(os.path.join(TOOLS,"jdk21"))
javas=glob.glob(TOOLS+r"\jdk21\**\bin\java.exe",recursive=True)
print("java.exe:",javas[:3])
if javas:
    home=os.path.dirname(os.path.dirname(javas[0]))
    print("JDK21_HOME=",home)
    open(os.path.join(TOOLS,"jdk21_home.txt"),"w").write(home)
