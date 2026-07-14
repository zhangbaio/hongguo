# -*- coding: utf-8 -*-
"""endgame4: 抓明文+dump+序列匹配(存完整ks+密文) + 多对齐(ks偏移0/4/8/12) raw key 暴力(AES128/256, counter-diff)。"""
import frida, subprocess, time, struct, json, os, re, gzip, shutil, ssl, urllib.request
from Crypto.Cipher import AES
ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*a): return subprocess.run([ADB,"-s",DEV]+list(a),capture_output=True,text=True).stdout
def adb1(c): return subprocess.run([ADB,"-s",DEV,"shell",c],capture_output=True,text=True).stdout
def gp(): o=adb("shell","pidof",PKG).strip(); return int(o.split()[0]) if o else None
ctx=ssl.create_default_context();ctx.check_hostname=False;ctx.verify_mode=ssl.CERT_NONE
adb1("su -c 'rm -f /data/local/tmp/e4.h265;touch /data/local/tmp/e4.h265;chmod 777 /data/local/tmp/e4.h265'")
JS=r"""
'use strict';
var fv=null,vBytes=0;
Java.perform(function(){
  try{var F=Java.use('java.io.FileOutputStream');fv=F.$new('/data/local/tmp/e4.h265',false);}catch(e){}
  var MC=Java.use('android.media.MediaCodec');
  MC.flush.implementation=function(){try{var F=Java.use('java.io.FileOutputStream');if(fv){fv.flush();fv.close();}fv=F.$new('/data/local/tmp/e4.h265',false);}catch(e){}vBytes=0;send({t:'flush'});setTimeout(scan,150);return this.flush();};
  MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){if(size>4){try{var n=this.getName().toLowerCase();if(/hevc|bytevc|h265/.test(n)){var bb=this.getInputBuffer(idx);bb.position(off);var a=Java.array('byte',new Array(size).fill(0));bb.get(a);if(fv){fv.write(a,0,size);vBytes+=size;}}}catch(e){}}return this.queueInputBuffer(idx,off,size,pts,flags);};
  send({t:'mc'});});
function scan(){var S={};var P='76 69 64 65 6f 2f 74 6f 73';Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){try{Memory.scan(r.base,r.size,P,{onMatch:function(addr){try{var s=String.fromCharCode.apply(null,new Uint8Array(addr.sub(400).readByteArray(1800)));var hi=s.lastIndexOf('https://',400);if(hi>=0){var e=s.indexOf('"',hi+8);if(e<0)e=s.indexOf('\\',hi+8);if(e<0)e=hi+700;var u=s.substr(hi,e-hi).replace(/\\/g,'');if(u.length>40&&!S[u.substr(0,70)]){S[u.substr(0,70)]=1;send({t:'url',url:u});}}}catch(e){}},onError:function(){},onComplete:function(){}});}catch(e){}});}
setTimeout(scan,1500);
"""
pid=gp();print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
sc=dev.attach(pid).create_script(JS); st={"urls":set()}
def om(m,d):
    if m["type"]=="send":
        p=m["payload"];t=p.get("t","")
        if t=="mc":print("[mc hooked] >>> 保持/上滑播放在线视频 <<<")
        elif t=="flush":print("[flush]")
        elif t=="url":st["urls"].add(p["url"])
sc.on("message",om);sc.load()
print("capturing 30s...");time.sleep(30);print(f"urls={len(st['urls'])}")
# dump
smaps=adb1(f"su -c 'cat /proc/{pid}/smaps'");regs=[];cur=None
EXCL=["dalvik",".art]",".vdex","gralloc","Ashmem","ashmem","jit-cache","boot-","framework","/dev/","mali","kgsl","dmabuf",".jar",".apk","[stack","linker","[vdso","[vvar"]
for line in smaps.split("\n"):
    m=re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$",line)
    if m:cur={"s":int(m.group(1),16),"e":int(m.group(2),16),"perm":m.group(3),"path":m.group(4).strip(),"rss":0};regs.append(cur)
    else:
        mm=re.match(r"^Rss:\s+(\d+)\s*kB",line)
        if mm and cur:cur["rss"]=int(mm.group(1))
rw=[r for r in regs if r["perm"][:2]=="rw" and r["rss"]>0 and not any(x in r["path"] for x in EXCL)]
dl="\n".join(f"{r['s']//4096} {(r['e']-r['s'])//4096}" for r in rw if (r['e']-r['s'])//4096>0)
open("capture/e4_dl.txt","w",newline="\n").write(dl)
subprocess.run([ADB,"-s",DEV,"push","capture/e4_dl.txt","/data/local/tmp/e4_dl.txt"])
open("capture/e4.sh","w",newline="\n").write("#!/system/bin/sh\nPID="+str(pid)+"\nwhile read s c;do dd if=/proc/$PID/mem bs=4096 skip=$s count=$c conv=noerror,sync 2>/dev/null;done</data/local/tmp/e4_dl.txt|gzip -1>/data/local/tmp/e4.gz\necho DONE\n")
subprocess.run([ADB,"-s",DEV,"push","capture/e4.sh","/data/local/tmp/e4.sh"])
subprocess.run([ADB,"-s",DEV,"shell","su -c 'sh /data/local/tmp/e4.sh'"],timeout=120)
subprocess.run([ADB,"-s",DEV,"pull","/data/local/tmp/e4.gz","capture/e4.gz"])
with gzip.open("capture/e4.gz","rb") as f,open("capture/e4.bin","wb") as g:shutil.copyfileobj(f,g,1<<20)
dsz=os.path.getsize("capture/e4.bin");print(f"dump {dsz//1048576}MB")
# plain + seqmatch
plain=subprocess.run([ADB,"-s",DEV,"exec-out","su -c 'cat /data/local/tmp/e4.h265'"],capture_output=True).stdout
open("capture/e4_plain.h265","wb").write(plain)
pnals=[];i=0
while i+5<len(plain):
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4);sz=(j-i-4) if j>0 else len(plain)-i-4;nt=(plain[i+4]>>1)&0x3f
        if nt<22:pnals.append((i+4,sz,nt))
        i=j if j>0 else len(plain)
    else:i+=1
pseq=[s for o,s,t in pnals];print(f"plain {len(plain)}B {len(pnals)} nals")
def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0];t=d[o+4:o+8];hs=8
        if sz==1:sz=struct.unpack(">Q",d[o+8:o+16])[0];hs=16
        elif sz==0:sz=e-o
        yield t,o,sz,hs;o+=sz
def find(d,p,s=0,e=None):
    if e is None:e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]:return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
def traks(d):
    mv=find(d,[b"moov"]);return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"] if mv else []
def u32(d,o):return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr):h=find(d,[b"mdia",b"hdlr"],*tr);return d[h[0]+8:h[0]+12]
def vs(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr);stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e);co64=find(d,[b"co64"],s,e);stsc=find(d,[b"stsc"],s,e)
    if not stsz:return None
    ss=u32(d,stsz[0]+4);cnt=u32(d,stsz[0]+8);sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    if stco:n=u32(d,stco[0]+4);ch=[u32(d,stco[0]+8+4*i) for i in range(n)]
    elif co64:n=u32(d,co64[0]+4);ch=[struct.unpack(">Q",d[co64[0]+8+8*i:co64[0]+16+8*i])[0] for i in range(n)]
    else:return None
    ne=u32(d,stsc[0]+4);runs=[(u32(d,stsc[0]+8+12*i),u32(d,stsc[0]+12+12*i),u32(d,stsc[0]+16+12*i)) for i in range(ne)];spc=[0]*len(ch)
    for i,(fc,sp,sd) in enumerate(runs):
        last=runs[i+1][0]-1 if i+1<len(runs) else len(ch)
        for c in range(fc,last+1):
            if 1<=c<=len(ch):spc[c-1]=sp
    offs=[];si=0
    for c in range(len(ch)):
        off=ch[c]
        for _ in range(spc[c]):
            if si>=cnt:break
            offs.append(off);off+=sizes[si];si+=1
    return sizes,offs
WIN=8; ksfull=None; mo=None
for url in list(st["urls"]):
    if ksfull: break
    try:
        data=urllib.request.urlopen(urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"}),timeout=25,context=ctx).read()
        if data[4:8]!=b'ftyp':continue
        mds=find(data,[b"mdat"])[0];vt=[t for t in traks(data) if hdlr(data,t)==b"vide"]
        if not vt:continue
        r=vs(data,vt[0])
        if not r:continue
        sizes,offs=r;cbody=[s-4 for s in sizes];cset={}
        for ci in range(len(cbody)):cset.setdefault(cbody[ci],[]).append(ci)
        al=None
        for pi in range(len(pseq)-WIN):
            for ci in cset.get(pseq[pi],[]):
                if ci+WIN<=len(cbody) and all(pseq[pi+w]==cbody[ci+w] for w in range(WIN)):al=(pi,ci);break
            if al:break
        if not al:continue
        pi,ci=al;po,psz,pt=pnals[pi];co=offs[ci];csz=sizes[ci]
        n=min(8192,psz,csz-4)
        ksfull=bytes(a^b for a,b in zip(data[co+4:co+4+n],plain[po:po+n]));mo=(co+4)-mds
        open("capture/e4_match.mp4","wb").write(data)
        json.dump({"ks":ksfull[:80].hex(),"mo":mo,"co":co,"ci":ci,"pi":pi},open("capture/e4_ks.json","w"))
        print(f"[seqmatch] plain#{pi}<->sample#{ci} mo={mo} ks[0:32]={ksfull[:32].hex()}")
    except: pass
if not ksfull:print("no seqmatch");raise SystemExit
# 多对齐 raw key 暴力
def brute(bits):
    print(f"=== brute AES-{bits}, 16-aligned, 4 ks-offsets ===")
    klen=bits//8
    pairs=[]  # (blkA,blkB,label)
    for i0 in (0,4,8,12):
        if i0+32<=len(ksfull): pairs.append((ksfull[i0:i0+16],ksfull[i0+16:i0+32],i0))
    t0=time.time();tested=0
    with open("capture/e4.bin","rb") as f:
        carry=b"";gpos=0
        while True:
            chunk=f.read(64<<20)
            if not chunk:break
            buf=carry+chunk;lim=len(buf)-klen
            start=(-gpos)%16
            for o in range(start,lim+1,16):
                K=buf[o:o+klen]
                try:c=AES.new(K,AES.MODE_ECB)
                except:continue
                for blkA,blkB,i0 in pairs:
                    if (int.from_bytes(c.decrypt(blkB),"big")-int.from_bytes(c.decrypt(blkA),"big"))%(1<<128)==1:
                        print(f"\n*** RAW KEY FOUND! AES-{bits} key={K.hex()} ks_off={i0}")
                        json.dump({"key":K.hex(),"bits":bits,"ks_off":i0,"source":"raw_brute_multialign"},open("capture/CONTENT_KEY.json","w"),indent=2)
                        return True
                tested+=1
            carry=buf[-16:];gpos+=len(chunk)
            print(f"  AES{bits} {gpos//1048576}/{dsz//1048576}MB {time.time()-t0:.0f}s",flush=True)
    print(f"AES-{bits} brute: nothing ({tested} windows, {time.time()-t0:.0f}s)")
    return False
if not brute(128):
    brute(256)
print("done")
