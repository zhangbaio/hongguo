# -*- coding: utf-8 -*-
"""端到端: 抓明文(用户播放) -> 按IDR精确匹配密文 -> 恢复keystream -> 同步dump -> counter-diff验证密钥+IV"""
import frida, subprocess, time, struct, json, os, re, gzip, shutil, ssl, urllib.request
import numpy as np
from Crypto.Cipher import AES

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*a): return subprocess.run([ADB,"-s",DEV]+list(a),capture_output=True,text=True).stdout
def adb1(cmd): return subprocess.run([ADB,"-s",DEV,"shell",cmd],capture_output=True,text=True).stdout
def get_pid(): out=adb("shell","pidof",PKG).strip(); return int(out.split()[0]) if out else None
ctx=ssl.create_default_context(); ctx.check_hostname=False; ctx.verify_mode=ssl.CERT_NONE
adb1("su -c 'rm -f /data/local/tmp/eg.h265; touch /data/local/tmp/eg.h265; chmod 777 /data/local/tmp/eg.h265'")

JS=r"""
'use strict';
var fv=null,vBytes=0;
Java.perform(function(){
  try{var FOS=Java.use('java.io.FileOutputStream'); fv=FOS.$new('/data/local/tmp/eg.h265',false);}catch(e){}
  var MC=Java.use('android.media.MediaCodec');
  MC.flush.implementation=function(){
    try{var FOS=Java.use('java.io.FileOutputStream'); if(fv){fv.flush();fv.close();} fv=FOS.$new('/data/local/tmp/eg.h265',false);}catch(e){}
    vBytes=0; send({t:'flush'}); setTimeout(scan,150); return this.flush();
  };
  MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
    if(size>4){try{var n=this.getName().toLowerCase();
      if(/hevc|bytevc|h265/.test(n)){var bb=this.getInputBuffer(idx);bb.position(off);
        var a=Java.array('byte',new Array(size).fill(0));bb.get(a);
        if(fv){fv.write(a,0,size);vBytes+=size;}
        if(size>5000)send({t:'big',size:size,vBytes:vBytes});}}catch(e){}}
    return this.queueInputBuffer(idx,off,size,pts,flags);
  };
  send({t:'hooked'});
});
function scan(){var S={};var P='76 69 64 65 6f 2f 74 6f 73';
  Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
    try{Memory.scan(r.base,r.size,P,{onMatch:function(addr){try{
      var s=String.fromCharCode.apply(null,new Uint8Array(addr.sub(400).readByteArray(1800)));
      var hi=s.lastIndexOf('https://',400);if(hi>=0){var e=s.indexOf('"',hi+8);if(e<0)e=s.indexOf('\\',hi+8);if(e<0)e=hi+700;
        var u=s.substr(hi,e-hi).replace(/\\/g,'');if(u.length>40&&!S[u.substr(0,70)]){S[u.substr(0,70)]=1;send({t:'url',url:u});}}
    }catch(e){}},onError:function(){},onComplete:function(){}});}catch(e){}});
  send({t:'scandone'});}
setTimeout(scan,1500);
"""
pid=get_pid(); print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid); script=session.create_script(JS)
st={"urls":set(),"firstbig":None,"vb":0}
def on_msg(m,d):
    if m["type"]=="send":
        p=m["payload"];t=p.get("t","")
        if t=="hooked": print("[hooked] >>> 现在手动播放一集(进度条要动) <<<")
        elif t=="flush": print("[flush]")
        elif t=="big":
            st["vb"]=p["vBytes"]
            if st["firstbig"] is None: st["firstbig"]=p["size"]; print(f"[FIRST BIG {p['size']}] capturing...")
        elif t=="url": st["urls"].add(p["url"])
        elif t=="scandone": print(f"[scan {len(st['urls'])} urls]")
script.on("message",on_msg); script.load()
print("waiting 45s for playback...")
t0=time.time()
while time.time()-t0<45:
    time.sleep(1)
    if st["firstbig"] and st["vb"]>200000 and time.time()-t0>10: break

plain=subprocess.run([ADB,"-s",DEV,"exec-out","su -c 'cat /data/local/tmp/eg.h265'"],capture_output=True).stdout
open("capture/eg_plain.h265","wb").write(plain)
print(f"plaintext {len(plain)}B, urls={len(st['urls'])}")
# 解析: 第一个 IDR (type 19/20/21)
idr=None; i=0
while i+5<len(plain):
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4); sz=(j-i-4) if j>0 else len(plain)-i-4
        nt=(plain[i+4]>>1)&0x3f
        if nt in (19,20,21): idr=(i+4,sz); break
        i=j if j>0 else len(plain)
    else: i+=1
if not idr: print("NO IDR captured (视频没解码或非MediaCodec路径)"); json.dump(list(st["urls"]),open("capture/eg_urls.json","w")); raise SystemExit
print(f"plain IDR: off={idr[0]} size={idr[1]}")

# mp4 helpers
def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0];t=d[o+4:o+8];hs=8
        if sz==1: sz=struct.unpack(">Q",d[o+8:o+16])[0];hs=16
        elif sz==0: sz=e-o
        yield t,o,sz,hs;o+=sz
def find(d,p,s=0,e=None):
    if e is None:e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]: return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
def traks(d):
    mv=find(d,[b"moov"]);return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"] if mv else []
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr);return d[h[0]+8:h[0]+12]
def samp0(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr);stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e)
    if not stsz or not stco: return None
    ss=u32(d,stsz[0]+4);sz0=ss if ss else u32(d,stsz[0]+12);return u32(d,stco[0]+8),sz0

# 匹配: cipher sample0 NAL body (sz0-4) == plain IDR size
print(f"downloading {len(st['urls'])} candidates, matching IDR={idr[1]}...")
matched=None; allsizes=[]; saved=[]
os.makedirs("capture/ct/eg",exist_ok=True)
for ui,url in enumerate(list(st["urls"])):
    try:
        req=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0","Range":"bytes=0-900000"})
        data=urllib.request.urlopen(req,timeout=15,context=ctx).read()
        if data[4:8]!=b'ftyp': continue
        md=find(data,[b"mdat"]);
        if not md: continue
        mds=md[0]; vt=[t for t in traks(data) if hdlr(data,t)==b"vide"]
        if not vt: continue
        r=samp0(data,vt[0])
        if not r: continue
        off0,sz0=r
        allsizes.append((sz0,abs((sz0-4)-idr[1]),url))
        if abs((sz0-4)-idr[1])<8 and off0+idr[1]<=len(data):
            print(f"  *** IDR MATCH sample0={sz0} (body {sz0-4}) vs plain {idr[1]}")
            matched=(data,off0,sz0,mds)
            open("capture/ct/eg/match.mp4","wb").write(data); break
    except: pass
if not matched:
    allsizes.sort(key=lambda x:x[1])
    print(f"no exact match. plain IDR={idr[1]}. closest cipher sample0 bodies:")
    for sz0,df,url in allsizes[:10]: print(f"   sample0={sz0} body={sz0-4} diff={df}")
    json.dump({"plain_idr":idr[1],"plain_idr_off":idr[0],"closest":[(s,d) for s,d,u in allsizes[:20]],
               "urls":list(st["urls"])},open("capture/eg_diag.json","w"),indent=2)
    print("saved capture/eg_plain.h265 + eg_diag.json for offline matching")
    # 仍继续 dump 取密钥(不浪费这次播放)
    matched=None

blkA=blkB=None; blkA_idx=None
if matched:
    data,off0,sz0,mds=matched
    mo=off0-mds
    N=min(12000,idr[1],sz0-4)
    ks=bytes(c^p for c,p in zip(data[off0+4:off0+4+N], plain[idr[0]:idr[0]+N]))
    base=mo+4; ff=((base+15)//16)*16; i0=ff-base
    blkA=ks[i0:i0+16]; blkB=ks[i0+16:i0+32]; blkA_idx=ff//16
    print(f"keystream blkA(idx{blkA_idx})={blkA.hex()} blkB={blkB.hex()}")
    json.dump({"ks":ks[:64].hex(),"blkA":blkA.hex(),"blkB":blkB.hex(),"blkA_idx":blkA_idx,"mo":mo},
              open("capture/eg_ks.json","w"),indent=2)

# 同步 dump (key resident) — 修正 smaps 取法(单字符串)
print("dumping memory (key should be resident)...")
smaps=adb1(f"su -c 'cat /proc/{pid}/smaps'")
regs=[];cur=None
EXCL=["dalvik",".art]",".vdex","gralloc","Ashmem","ashmem","jit-cache","boot-","framework","/dev/","mali","kgsl","dmabuf",".jar",".apk","[stack","linker","[vdso","[vvar"]
for line in smaps.split("\n"):
    m=re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$",line)
    if m: cur={"s":int(m.group(1),16),"e":int(m.group(2),16),"perm":m.group(3),"path":m.group(4).strip(),"rss":0};regs.append(cur)
    else:
        mm=re.match(r"^Rss:\s+(\d+)\s*kB",line)
        if mm and cur: cur["rss"]=int(mm.group(1))
rw=[r for r in regs if r["perm"][:2]=="rw" and r["rss"]>0 and not any(x in r["path"] for x in EXCL)]
dl="\n".join(f"{r['s']//4096} {(r['e']-r['s'])//4096}" for r in rw if (r['e']-r['s'])//4096>0)
print(f"smaps {len(regs)} regions, {len(rw)} native rw, dl lines={len(dl.splitlines())}")
open("capture/eg_dl.txt","w",newline="\n").write(dl)
subprocess.run([ADB,"-s",DEV,"push","capture/eg_dl.txt","/data/local/tmp/eg_dl.txt"])
sh="#!/system/bin/sh\nPID="+str(pid)+"\nwhile read s c;do dd if=/proc/$PID/mem bs=4096 skip=$s count=$c conv=noerror,sync 2>/dev/null;done</data/local/tmp/eg_dl.txt|gzip -1>/data/local/tmp/eg.gz\necho DONE\n"
open("capture/eg.sh","w",newline="\n").write(sh)
subprocess.run([ADB,"-s",DEV,"push","capture/eg.sh","/data/local/tmp/eg.sh"])
subprocess.run([ADB,"-s",DEV,"shell","su -c 'sh /data/local/tmp/eg.sh'"],timeout=120)
subprocess.run([ADB,"-s",DEV,"pull","/data/local/tmp/eg.gz","capture/eg.gz"])
with gzip.open("capture/eg.gz","rb") as f,open("capture/eg.bin","wb") as g: shutil.copyfileobj(f,g,1<<20)
sz=os.path.getsize("capture/eg.bin"); print(f"dump {sz//1048576}MB")

# aeskeyfind
SBOX=bytes.fromhex("637c777bf26b6fc53001672bfed7ab76ca82c97dfa5947f0add4a2af9ca472c0b7fd9326363ff7cc34a5e5f171d8311504c723c31896059a071280e2eb27b275"+"09832c1a1b6e5aa0523bd6b329e32f8453d100ed20fcb15b6acbbe394a4c58cfd0efaafb434d338545f9027f503c9fa851a3408f929d38f5bcb6da2110fff3d2"+"cd0c13ec5f974417c4a77e3d645d197360814fdc222a908846eeb814de5e0bdbe0323a0a4906245cc2d3ac629195e479e7c8376d8dd54ea96c56f4ea657aae08"+"ba78252e1ca6b4c6e8dd741f4bbd8b8a703eb5664803f60e613557b986c11d9ee1f8981169d98e949b1e87e9ce5528df8ca1890dbfe6426841992d0fb054bb16")
SB=np.frombuffer(SBOX,np.uint8);RCON=[0,1,2,4,8,16,32,64,128,27,54]
def expand(k):
    w=list(k)
    for i in range(4,44):
        t=w[4*(i-1):4*i]
        if i%4==0:t=[SBOX[t[1]]^RCON[i//4],SBOX[t[2]],SBOX[t[3]],SBOX[t[0]]]
        w+=[w[4*(i-4)+j]^t[j] for j in range(4)]
    return bytes(w)
def C(B,i,M):return B[i:i+M]
def lin(B,i,M):
    ok=np.ones(M,bool)
    for k in range(4):ok&=(C(B,4*i+k,M)==(C(B,4*(i-4)+k,M)^C(B,4*(i-1)+k,M)))
    return ok
def sbx(B,i,M):
    rc=RCON[i//4];p=4*(i-1);q=4*(i-4)
    return (C(B,4*i,M)==(C(B,q,M)^SB[C(B,p+1,M)]^np.uint8(rc)))&(C(B,4*i+1,M)==(C(B,q+1,M)^SB[C(B,p+2,M)]))&(C(B,4*i+2,M)==(C(B,q+2,M)^SB[C(B,p+3,M)]))&(C(B,4*i+3,M)==(C(B,q+3,M)^SB[C(B,p,M)]))
def scn(buf):
    B=np.frombuffer(buf,np.uint8);M=len(B)-176
    if M<=0:return []
    c=sbx(B,4,M)
    for i in(5,6,7):c&=lin(B,i,M)
    if not c.any():return []
    c&=sbx(B,8,M)
    for i in(9,10,11):c&=lin(B,i,M)
    if not c.any():return []
    return [bytes(B[o:o+16]) for o in np.nonzero(c)[0] if expand(bytes(B[o:o+16]))==bytes(B[o:o+176])]
keys=set()
with open("capture/eg.bin","rb") as f:
    b=0
    while b<sz:
        f.seek(b);buf=f.read((256<<20)+176)
        if len(buf)<=176:break
        for k in scn(buf):keys.add(k)
        b+=256<<20
keys=list(keys); print(f"aeskeyfind: {len(keys)} keys")
json.dump([k.hex() for k in keys],open("capture/eg_keys.json","w"))

# counter-diff 验证
if blkA is None:
    print("no keystream (match failed) — keys saved to eg_keys.json, plain to eg_plain.h265 for offline match")
    raise SystemExit
def dec(K,b): return AES.new(K,AES.MODE_ECB).decrypt(b)
found=None
for K in keys:
    if (int.from_bytes(dec(K,blkB),"big")-int.from_bytes(dec(K,blkA),"big"))%(1<<128)==1:
        ctrA=int.from_bytes(dec(K,blkA),"big")
        found=(K,ctrA); print(f"\n*** CONTENT KEY FOUND! key={K.hex()}")
        print(f"    IV={((ctrA-blkA_idx)%(1<<128)):032x}  (counter@blk{blkA_idx}={ctrA:032x})")
        break
if found:
    json.dump({"key":found[0].hex(),"iv":((found[1]-blkA_idx)%(1<<128)).to_bytes(16,"big").hex(),
               "blkA_idx":blkA_idx,"counterA":found[1]},open("capture/CONTENT_KEY.json","w"),indent=2)
    print("saved capture/CONTENT_KEY.json — 密钥+IV确认!!!")
else:
    print(f"no key matches counter-diff (keys={len(keys)}). 若keys>0则IDR匹配/CTR模型还需调; 若keys=0则dump没抓到")
