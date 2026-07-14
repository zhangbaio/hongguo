# -*- coding: utf-8 -*-
"""纯采集匹配版(用户手动播放):
- 挂 MC hook 抓明文(写文件) + flush 边界 + 扫 URL
- 等 35s(用户手动播一集)
- 抓到明文后扫所有 main_url, 下载, 按首IDR大小匹配同集
- 恢复 keystream, 用 sync_keys 验证
"""
import frida, subprocess, time, struct, json, os, ssl, urllib.request
from Crypto.Cipher import AES

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*a): return subprocess.run([ADB,"-s",DEV]+list(a),capture_output=True,text=True).stdout.strip()
def get_pid(): out=adb("shell","pidof",PKG); return int(out.split()[0]) if out else None
ctx=ssl.create_default_context(); ctx.check_hostname=False; ctx.verify_mode=ssl.CERT_NONE
adb("shell","su","-c","rm -f /data/local/tmp/atom.h265; touch /data/local/tmp/atom.h265; chmod 777 /data/local/tmp/atom.h265")

JS=r"""
'use strict';
var fv=null, vBytes=0;
Java.perform(function(){
  try{var FOS=Java.use('java.io.FileOutputStream'); fv=FOS.$new('/data/local/tmp/atom.h265',false);}catch(e){}
  var MC=Java.use('android.media.MediaCodec');
  MC.flush.implementation=function(){
    try{var FOS=Java.use('java.io.FileOutputStream'); if(fv){fv.flush();fv.close();} fv=FOS.$new('/data/local/tmp/atom.h265',false);}catch(e){}
    vBytes=0; send({t:'flush'}); setTimeout(scanUrls,150);
    return this.flush();
  };
  MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
    if(size>4){
      try{
        var name=this.getName().toLowerCase();
        if(/hevc|bytevc|h265/.test(name)){
          var bb=this.getInputBuffer(idx); bb.position(off);
          var a=Java.array('byte',new Array(size).fill(0)); bb.get(a);
          if(fv){fv.write(a,0,size); vBytes+=size;}
          if(size>5000) send({t:'bigframe',size:size,vBytes:vBytes});
        }
      }catch(e){}
    }
    return this.queueInputBuffer(idx,off,size,pts,flags);
  };
  send({t:'hooked'});
});
function scanUrls(){
  var SEEN={};
  var PAT='71 7a 6e 6f 76 65 6c 76 6f 64';
  Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
    try{Memory.scan(r.base,r.size,PAT,{
      onMatch:function(addr){
        try{
          var s=String.fromCharCode.apply(null,new Uint8Array(addr.sub(300).readByteArray(900)));
          var hi=s.lastIndexOf('https://',300);
          if(hi>=0){var e2=s.indexOf('"',hi+8); if(e2<0)e2=s.indexOf('\\',hi+8); if(e2<0)e2=hi+500;
            var url=s.substr(hi,e2-hi).replace(/\\/g,'');
            if(url.length>40&&!SEEN[url.substr(0,70)]){SEEN[url.substr(0,70)]=1; send({t:'url',url:url});}}
        }catch(e){}
      },onError:function(){},onComplete:function(){}
    });}catch(e){}
  });
  send({t:'scandone'});
}
setTimeout(scanUrls,1500);
"""

pid=get_pid(); print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
script=session.create_script(JS)
state={"urls":set(),"firstbig":None,"vbytes":0}
def on_msg(m,data):
    if m["type"]=="send":
        p=m["payload"]; t=p.get("t","")
        if t=="hooked": print("[hooked] >>> 现在请在 app 里手动播放一集视频 <<<")
        elif t=="flush": print("[FLUSH new video]")
        elif t=="bigframe":
            state["vbytes"]=p["vBytes"]
            if state["firstbig"] is None:
                state["firstbig"]=p["size"]; print(f"[FIRST BIG FRAME] {p['size']} bytes - capturing!")
        elif t=="url": state["urls"].add(p["url"])
        elif t=="scandone": print(f"[scan] {len(state['urls'])} urls")
script.on("message",on_msg)
script.load()

print("waiting up to 40s for you to play a video...")
t0=time.time()
while time.time()-t0<40:
    time.sleep(1)
    if state["firstbig"] and state["vbytes"]>300000 and time.time()-t0>12:
        break

out=subprocess.run([ADB,"-s",DEV,"exec-out","su -c 'cat /data/local/tmp/atom.h265'"],capture_output=True)
plain=out.stdout
open("capture/atom_plain.h265","wb").write(plain)
print(f"plaintext: {len(plain)} bytes, firstbig={state['firstbig']}, urls={len(state['urls'])}")

# parse plain pic NALs
pic=[]; i=0
while i+4<len(plain) and len(pic)<40:
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4)
        sz=j-i-4 if j>0 else len(plain)-i-4
        nt=(plain[i+4]>>1)&0x3f
        if nt<22: pic.append((i+4,sz,nt))
        i=j if j>0 else len(plain)
    else: i+=1
pic_sizes=set(s for o,s,t in pic)
print(f"plain pic NALs: {[(s,t) for o,s,t in pic[:6]]}")

if not pic:
    print("NO PLAINTEXT - 视频没解码, 重试(确保视频在播)");
    json.dump(list(state["urls"]),open("capture/atom_urls.json","w")); raise SystemExit

# mp4 helpers
def ib(d,s,e):
    o=s
    while o+8<=e:
        sz=struct.unpack(">I",d[o:o+4])[0]; t=d[o+4:o+8]; hs=8
        if sz==1: sz=struct.unpack(">Q",d[o+8:o+16])[0]; hs=16
        elif sz==0: sz=e-o
        yield t,o,sz,hs; o+=sz
def find(d,p,s=0,e=None):
    if e is None: e=len(d)
    for t,o,sz,hs in ib(d,s,e):
        if t==p[0]: return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
def traks(d):
    mv=find(d,[b"moov"]); return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"] if mv else []
def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
def samp0(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
    stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
    ss=u32(d,stsz[0]+4); sz0=ss if ss else u32(d,stsz[0]+12)
    return u32(d,stco[0]+8),sz0

os.makedirs("capture/ct/atom",exist_ok=True)
matched=None
print(f"downloading {len(state['urls'])} candidates, matching by IDR size...")
for idx,url in enumerate(list(state["urls"])):
    try:
        req=urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"})
        data=urllib.request.urlopen(req,timeout=20,context=ctx).read()
        if data[4:8]!=b'ftyp': continue
        mds=find(data,[b"mdat"])[0]
        vt=[t for t in traks(data) if hdlr(data,t)==b"vide"]
        if not vt: continue
        off0,sz0=samp0(data,vt[0])
        best=min(pic_sizes,key=lambda s:abs(s-(sz0-4)))
        diff=abs(best-(sz0-4))
        if diff<50:
            print(f"  *** MATCH c{idx}: s0={sz0} plain={best} diff={diff}")
            open(f"capture/ct/atom/match.mp4","wb").write(data)
            matched=(data,off0,sz0,mds,best); break
    except: pass

if not matched:
    print("no exact match; saving urls for retry"); json.dump(list(state["urls"]),open("capture/atom_urls.json","w")); raise SystemExit

data,off0,sz0,mds,plainsz=matched
pnal=[(o,s,t) for o,s,t in pic if s==plainsz][0]
mo=off0-mds
N=min(12000,plainsz,sz0-4)
ks=bytes(c^p for c,p in zip(data[off0+4:off0+4+N], plain[pnal[0]:pnal[0]+N]))
print(f"\n=== KEYSTREAM RECOVERED ===\nks[0:48]: {ks[:48].hex()}")
rb=(mo+4)%16; blk0=(mo+4)//16
full_blk=ks[16-rb:16-rb+16] if rb>0 and len(ks)>=32 else ks[0:16]
blk_idx=blk0+(1 if rb>0 else 0)
print(f"full AES block idx={blk_idx}: {full_blk.hex()}")
keys=[bytes.fromhex(k["key"]) for k in json.load(open("capture/sync_keys.json"))]
found=False
for ki,K in enumerate(keys):
    if AES.new(K,AES.MODE_ECB).encrypt((blk_idx%(1<<128)).to_bytes(16,"big"))==full_blk:
        print(f"*** CONTENT KEY in sync dump! key#{ki}={K.hex()} IV=0")
        found=True
json.dump({"ks48":ks[:48].hex(),"full_blk":full_blk.hex(),"blk_idx":blk_idx,
           "cipher_s0":sz0,"plain_idr":plainsz,"key_in_dump":found,"mo":mo},
          open("capture/MATCHED.json","w"),indent=2)
print(f"saved capture/MATCHED.json (key_in_dump={found})")
if not found:
    print("keystream有了但密钥不在当前dump(需对该集做同步dump). keystream可直接解这一集.")
