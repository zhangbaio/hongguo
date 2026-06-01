# -*- coding: utf-8 -*-
"""同步: 触发视频播放(MC hook确认) + 立刻 dump 内存 + aeskeyfind
解决时序问题: 只要视频在 decode, key 就在内存里"""
import frida, subprocess, time, threading, struct, numpy as np, json, os
from Crypto.Cipher import AES

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*args): return subprocess.run([ADB,"-s",DEV]+list(args),capture_output=True,text=True).stdout.strip()
def get_pid(): out=adb("shell","pidof",PKG); return int(out.split()[0]) if out else None

state={"decoding":False,"vbytes":0,"pid":None}

# === Frida: MC hook ===
JS=r"""
'use strict';
Java.perform(function(){
  var MC=Java.use('android.media.MediaCodec');
  MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
    if(size>100){
      var name=this.getName().toLowerCase();
      if(/hevc|bytevc|h265/.test(name)){ send({t:'decode',size:size,name:name}); }
    }
    return this.queueInputBuffer(idx,off,size,pts,flags);
  };
  send({t:'hooked'});
});
"""

# === aeskeyfind (subset of full scan) ===
SBOX=bytes.fromhex("637c777bf26b6fc53001672bfed7ab76ca82c97dfa5947f0add4a2af9ca472c0b7fd9326363ff7cc34a5e5f171d8311504c723c31896059a071280e2eb27b275"+"09832c1a1b6e5aa0523bd6b329e32f8453d100ed20fcb15b6acbbe394a4c58cfd0efaafb434d338545f9027f503c9fa851a3408f929d38f5bcb6da2110fff3d2"+"cd0c13ec5f974417c4a77e3d645d197360814fdc222a908846eeb814de5e0bdbe0323a0a4906245cc2d3ac629195e479e7c8376d8dd54ea96c56f4ea657aae08"+"ba78252e1ca6b4c6e8dd741f4bbd8b8a703eb5664803f60e613557b986c11d9ee1f8981169d98e949b1e87e9ce5528df8ca1890dbfe6426841992d0fb054bb16")
SB=np.frombuffer(SBOX,dtype=np.uint8)
RCON=[0,1,2,4,8,16,32,64,128,27,54]
def expand_key(key16):
    w=list(key16)
    for i in range(4,44):
        t=w[4*(i-1):4*i]
        if i%4==0: t=[SBOX[t[1]]^RCON[i//4],SBOX[t[2]],SBOX[t[3]],SBOX[t[0]]]
        w+=[w[4*(i-4)+k]^t[k] for k in range(4)]
    return bytes(w)
def col(B,i,M): return B[i:i+M]
def linear_rel(B,i,M):
    ok=np.ones(M,dtype=bool)
    for k in range(4): ok&=(col(B,4*i+k,M)==(col(B,4*(i-4)+k,M)^col(B,4*(i-1)+k,M)))
    return ok
def sbox_rel(B,i,M):
    rc=RCON[i//4]; p=4*(i-1); q=4*(i-4)
    e0=col(B,q+0,M)^SB[col(B,p+1,M)]^np.uint8(rc)
    e1=col(B,q+1,M)^SB[col(B,p+2,M)]; e2=col(B,q+2,M)^SB[col(B,p+3,M)]; e3=col(B,q+3,M)^SB[col(B,p+0,M)]
    return (col(B,4*i+0,M)==e0)&(col(B,4*i+1,M)==e1)&(col(B,4*i+2,M)==e2)&(col(B,4*i+3,M)==e3)
def scan_chunk(buf):
    B=np.frombuffer(buf,dtype=np.uint8); M=len(B)-176
    if M<=0: return []
    cand=sbox_rel(B,4,M)
    for i in (5,6,7): cand&=linear_rel(B,i,M)
    if not cand.any(): return []
    cand&=sbox_rel(B,8,M)
    for i in (9,10,11): cand&=linear_rel(B,i,M)
    if not cand.any(): return []
    return [(int(o),bytes(B[o:o+16])) for o in np.nonzero(cand)[0] if expand_key(bytes(B[o:o+16]))==bytes(B[o:o+176])]

def run_dump_and_scan():
    pid=state["pid"]
    if not pid: return
    print("[DUMP] starting memory dump while video decodes...")
    # 生成 dumplist
    smaps=adb("shell","su","-c",f"cat /proc/{pid}/smaps")
    import re
    regions=[]; cur=None
    EXCL=["dalvik",".art]",".vdex","gralloc","Ashmem",".jar",".apk","[stack","linker","jit-cache","boot-","framework"]
    for line in smaps.split("\n"):
        m=re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$",line)
        if m:
            cur={"s":int(m.group(1),16),"e":int(m.group(2),16),"perm":m.group(3),"path":m.group(4).strip(),"rss":0}
            regions.append(cur)
        else:
            mm=re.match(r"^Rss:\s+(\d+)\s*kB",line)
            if mm and cur: cur["rss"]=int(mm.group(1))
    rw=[r for r in regions if r["perm"][0]=="r" and r["perm"][1]=="w" and r["rss"]>0 and not any(x in r["path"] for x in EXCL)]
    dl="\n".join(f"{r['s']//4096} {(r['e']-r['s'])//4096}" for r in rw if (r['e']-r['s'])//4096>0)
    if not dl:
        print("[DUMP] smaps parse failed, using dumplist_live.txt fallback")
        dl=open("capture/dumplist_live.txt").read() if os.path.exists("capture/dumplist_live.txt") else ""
    if not dl: print("[DUMP] no dumplist! abort"); return
    open("capture/sync_dl.txt","w",newline="\n").write(dl)
    subprocess.run([ADB,"-s",DEV,"push","capture/sync_dl.txt","/data/local/tmp/dumplist.txt"])
    # dump - 使用 run.py 风格的命令
    t0=time.time()
    # 单条命令字符串, 通过 adb shell "..." 传给 sh
    # 用之前测试过的 dump.sh 方法
    dump_sh="#!/system/bin/sh\nPID="+str(pid)+"\nwhile read s c; do\n  dd if=/proc/$PID/mem bs=4096 skip=$s count=$c conv=noerror,sync 2>/dev/null\ndone < /data/local/tmp/dumplist.txt | gzip -1 > /data/local/tmp/sync_dump.gz\necho DONE $(ls -la /data/local/tmp/sync_dump.gz 2>/dev/null)\n"
    open("capture/sync_run.sh","w",newline="\n").write(dump_sh)
    subprocess.run([ADB,"-s",DEV,"push","capture/sync_run.sh","/data/local/tmp/sync_run.sh"])
    result = subprocess.run([ADB,"-s",DEV,"shell","su -c 'sh /data/local/tmp/sync_run.sh'"],capture_output=True,text=True,timeout=90,shell=False)
    print(f"[DUMP] done in {time.time()-t0:.1f}s: {result.stdout[:100]} {result.stderr[:50]}")
    pull=subprocess.run([ADB,"-s",DEV,"pull","/data/local/tmp/sync_dump.gz","capture/sync_dump.gz"],capture_output=True,text=True)
    print(f"[PULL] {pull.stdout[:80]}")
    import gzip,shutil
    with gzip.open("capture/sync_dump.gz","rb") as f, open("capture/sync_dump.bin","wb") as g:
        shutil.copyfileobj(f,g,1024*1024)
    sz=os.path.getsize("capture/sync_dump.bin")
    print(f"[DUMP] {sz//1048576}MB decompressed")
    # scan
    print("[SCAN] running aeskeyfind on sync dump...")
    found=[]; seen=set()
    CHUNK=256*1024*1024; OVER=176
    with open("capture/sync_dump.bin","rb") as f:
        base=0
        while base<sz:
            f.seek(base); buf=f.read(CHUNK+OVER)
            if len(buf)<=OVER: break
            for o,key in scan_chunk(buf):
                if key not in seen:
                    seen.add(key); found.append({"offset":base+o,"key":key.hex()})
            base+=CHUNK
            print(f"  {min(base,sz)//1048576}/{sz//1048576}MB keys={len(found)}",flush=True)
    json.dump(found,open("capture/sync_keys.json","w"),indent=2)
    print(f"[SCAN DONE] {len(found)} unique AES-128 keys → capture/sync_keys.json")

pid=get_pid(); state["pid"]=pid; print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
script=session.create_script(JS)
dump_started=False
def on_msg(m,data):
    global dump_started
    if m["type"]=="send":
        p=m["payload"]; t=p.get("t","")
        if t=="hooked": print("[MC hook ready] tapping...")
        elif t=="decode":
            state["decoding"]=True; state["vbytes"]+=p["size"]
            if not dump_started:
                dump_started=True
                print(f"[DECODE DETECTED] {p['name']} size={p['size']} → starting dump thread")
                threading.Thread(target=run_dump_and_scan,daemon=True).start()
script.on("message",on_msg)
script.load()

# tap to trigger
print("tapping to trigger video...")
for i in range(8):
    adb("shell","input","tap","540","960")
    time.sleep(0.3)
    adb("shell","input","swipe","540","1200","540","400","200")
    time.sleep(1)

# wait
t0=time.time()
while time.time()-t0<150:
    time.sleep(1)
print(f"done. decoding={state['decoding']} vbytes={state['vbytes']}")
