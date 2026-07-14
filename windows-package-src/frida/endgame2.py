# -*- coding: utf-8 -*-
"""运行时密钥预言机: 视频加载时 hook libEncryptor 全部函数, 抓流经的16B候选密钥;
同时抓明文+序列匹配恢复该视频keystream; 用keystream对候选做counter-diff验证 -> 内容密钥。"""
import frida, subprocess, time, struct, json, os, ssl, urllib.request
from Crypto.Cipher import AES

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*a): return subprocess.run([ADB,"-s",DEV]+list(a),capture_output=True,text=True).stdout
def adb1(c): return subprocess.run([ADB,"-s",DEV,"shell",c],capture_output=True,text=True).stdout
def get_pid(): out=adb("shell","pidof",PKG).strip(); return int(out.split()[0]) if out else None
ctx=ssl.create_default_context(); ctx.check_hostname=False; ctx.verify_mode=ssl.CERT_NONE
adb1("su -c 'rm -f /data/local/tmp/e2.h265; touch /data/local/tmp/e2.h265; chmod 777 /data/local/tmp/e2.h265'")

# libEncryptor .text 函数入口(文件偏移) — 来自 enc_exports.py
ENC_FN_OFFS=[0xc3c,0xc44,0xd94,0xdac,0x2a70,0x2a78,0x2bdc,0x2be4,0x2d2c,0x2d44,0x4b04,0x4b0c,
             0x4c84,0x4c9c,0x66d8,0x675c,0x6844,0x684c,0x6c48,0x6dac,0x7d8c]  # +.mytext

JS=r"""
'use strict';
var fv=null,vBytes=0,CANDS={};
function findEnc(){var b=null;['r-x','r--'].forEach(function(p){if(b)return;
  Process.enumerateRanges(p).forEach(function(r){if(b)return;
    if(r.file&&r.file.path&&r.file.path.indexOf('libEncryptor.so')>=0&&!r.file.offset)b=r.base;});});return b;}
var encBase=findEnc();
send({t:'encbase',v:encBase?encBase.toString():'null'});
var OFFS=__OFFS__;
function collect(ptr,tag){ // 读16字节, 去重收集
  try{var b=ptr.readByteArray(16); if(!b)return; var u=new Uint8Array(b);
    var h=Array.from(u).map(function(x){return(x<16?'0':'')+x.toString(16)}).join('');
    if(h!=='00000000000000000000000000000000'&&!CANDS[h]){CANDS[h]=1;send({t:'cand',hex:h,tag:tag});}
  }catch(e){}
}
if(encBase){
  OFFS.forEach(function(off){
    try{
      var addr=encBase.add(off);
      Interceptor.attach(addr,{
        onEnter:function(a){this.a=[a[0],a[1],a[2],a[3]];},
        onLeave:function(ret){
          // 出口: 读 x0..x3 指向的16字节 + 返回值指向
          for(var i=0;i<4;i++){try{if(!this.a[i].isNull())collect(this.a[i],'fn'+off.toString(16)+'_x'+i);}catch(e){}}
          try{if(!ret.isNull())collect(ret,'fn'+off.toString(16)+'_ret');}catch(e){}
        }
      });
    }catch(e){}
  });
  send({t:'enc_hooked',n:OFFS.length});
}
// 也 hook memcpy: 16字节且 dst/src 在 enc 范围
var mc=Module.findExportByName('libc.so','memcpy');
if(mc&&encBase){
  Interceptor.attach(mc,{onEnter:function(a){this.d=a[0];this.s=a[1];this.n=parseInt(a[2]);},
    onLeave:function(){if(this.n===16||this.n===32){
      var ie=encBase&&((this.s.compare(encBase)>=0&&this.s.compare(encBase.add(0x15000))<0)||(this.d.compare(encBase)>=0&&this.d.compare(encBase.add(0x15000))<0));
      if(ie){collect(this.d,'memcpy_d');collect(this.s,'memcpy_s');}
    }}});
}
// MediaCodec 抓明文
Java.perform(function(){
  try{var FOS=Java.use('java.io.FileOutputStream'); fv=FOS.$new('/data/local/tmp/e2.h265',false);}catch(e){}
  var MC=Java.use('android.media.MediaCodec');
  MC.flush.implementation=function(){
    try{var FOS=Java.use('java.io.FileOutputStream'); if(fv){fv.flush();fv.close();} fv=FOS.$new('/data/local/tmp/e2.h265',false);}catch(e){}
    vBytes=0; send({t:'flush'}); setTimeout(scan,150); return this.flush();};
  MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
    if(size>4){try{var n=this.getName().toLowerCase();
      if(/hevc|bytevc|h265/.test(n)){var bb=this.getInputBuffer(idx);bb.position(off);
        var a=Java.array('byte',new Array(size).fill(0));bb.get(a);if(fv){fv.write(a,0,size);vBytes+=size;}
        if(size>5000)send({t:'big',size:size,vBytes:vBytes});}}catch(e){}}
    return this.queueInputBuffer(idx,off,size,pts,flags);};
  send({t:'mc_hooked'});
});
function scan(){var S={};var P='76 69 64 65 6f 2f 74 6f 73';
  Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
    try{Memory.scan(r.base,r.size,P,{onMatch:function(addr){try{
      var s=String.fromCharCode.apply(null,new Uint8Array(addr.sub(400).readByteArray(1800)));
      var hi=s.lastIndexOf('https://',400);if(hi>=0){var e=s.indexOf('"',hi+8);if(e<0)e=s.indexOf('\\',hi+8);if(e<0)e=hi+700;
        var u=s.substr(hi,e-hi).replace(/\\/g,'');if(u.length>40&&!S[u.substr(0,70)]){S[u.substr(0,70)]=1;send({t:'url',url:u});}}
    }catch(e){}},onError:function(){},onComplete:function(){}});}catch(e){}});
}
setTimeout(scan,1500);
""".replace("__OFFS__", json.dumps(ENC_FN_OFFS))

pid=get_pid(); print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid); script=session.create_script(JS)
st={"urls":set(),"cands":set()}
def on_msg(m,d):
    if m["type"]=="send":
        p=m["payload"];t=p.get("t","")
        if t=="encbase": print(f"[encbase {p['v']}]")
        elif t=="enc_hooked": print(f"[libEncryptor {p['n']} fns hooked]")
        elif t=="mc_hooked": print("[mc hooked] >>> 现在上滑切到新一集(全新加载) <<<")
        elif t=="flush": print("[flush - fresh load!]")
        elif t=="big": pass
        elif t=="cand": st["cands"].add(p["hex"])
        elif t=="url": st["urls"].add(p["url"])
script.on("message",on_msg); script.load()
print("waiting 45s — 请上滑切新一集...")
time.sleep(45)
print(f"collected {len(st['cands'])} candidate 16B keys, {len(st['urls'])} urls")
json.dump(list(st["cands"]),open("capture/e2_cands.json","w"))

# 取明文 + 序列匹配恢复keystream
plain=subprocess.run([ADB,"-s",DEV,"exec-out","su -c 'cat /data/local/tmp/e2.h265'"],capture_output=True).stdout
open("capture/e2_plain.h265","wb").write(plain)
pnals=[];i=0
while i+5<len(plain):
    if plain[i:i+4]==b"\x00\x00\x00\x01":
        j=plain.find(b"\x00\x00\x00\x01",i+4);sz=(j-i-4) if j>0 else len(plain)-i-4
        nt=(plain[i+4]>>1)&0x3f
        if nt<22: pnals.append((i+4,sz,nt))
        i=j if j>0 else len(plain)
    else: i+=1
pseq=[s for o,s,t in pnals]
print(f"plain {len(plain)}B, {len(pnals)} pic NALs")

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
def vsamples(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr);stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e);co64=find(d,[b"co64"],s,e);stsc=find(d,[b"stsc"],s,e)
    if not stsz:return None
    ss=u32(d,stsz[0]+4);cnt=u32(d,stsz[0]+8);sizes=[ss]*cnt if ss else [u32(d,stsz[0]+12+4*i) for i in range(cnt)]
    if stco:n=u32(d,stco[0]+4);ch=[u32(d,stco[0]+8+4*i) for i in range(n)]
    elif co64:n=u32(d,co64[0]+4);ch=[struct.unpack(">Q",d[co64[0]+8+8*i:co64[0]+16+8*i])[0] for i in range(n)]
    else:return None
    ne=u32(d,stsc[0]+4);runs=[(u32(d,stsc[0]+8+12*i),u32(d,stsc[0]+12+12*i),u32(d,stsc[0]+16+12*i)) for i in range(ne)]
    spc=[0]*len(ch)
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

cands=[bytes.fromhex(h) for h in st["cands"]]
def dec(K,b): return AES.new(K,AES.MODE_ECB).decrypt(b)
WIN=8; got=False
for url in list(st["urls"]):
    if got: break
    try:
        data=urllib.request.urlopen(urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0"}),timeout=25,context=ctx).read()
        if data[4:8]!=b'ftyp':continue
        mds=find(data,[b"mdat"])[0];vt=[t for t in traks(data) if hdlr(data,t)==b"vide"]
        if not vt:continue
        r=vsamples(data,vt[0])
        if not r:continue
        sizes,offs=r;cbody=[s-4 for s in sizes]
        cset={}
        for ci in range(len(cbody)):cset.setdefault(cbody[ci],[]).append(ci)
        align=None
        for pi in range(len(pseq)-WIN):
            for ci in cset.get(pseq[pi],[]):
                if ci+WIN<=len(cbody) and all(pseq[pi+w]==cbody[ci+w] for w in range(WIN)):align=(pi,ci);break
            if align:break
        if not align: continue
        pi,ci=align
        po,psz,pt=pnals[pi];co=offs[ci];csz=sizes[ci]
        n=min(4096,psz,csz-4)
        ks=bytes(a^b for a,b in zip(data[co+4:co+4+n],plain[po:po+n]))
        mo=(co+4)-mds;ff=((mo+15)//16)*16;i0=ff-mo
        blkA=ks[i0:i0+16];blkB=ks[i0+16:i0+32];blkA_idx=ff//16
        print(f"[seqmatch] url plain#{pi}<->sample#{ci}, keystream blkA={blkA.hex()}")
        # 用候选密钥验证
        for K in cands:
            if (int.from_bytes(dec(K,blkB),"big")-int.from_bytes(dec(K,blkA),"big"))%(1<<128)==1:
                iv=(int.from_bytes(dec(K,blkA),"big")-blkA_idx)%(1<<128)
                print(f"\n*** CONTENT KEY (from libEncryptor hook)! key={K.hex()}")
                print(f"    IV={iv:032x}  blkA_idx={blkA_idx}")
                json.dump({"key":K.hex(),"iv":f"{iv:032x}","blkA_idx":blkA_idx,"source":"libEncryptor_hook"},open("capture/CONTENT_KEY.json","w"),indent=2)
                got=True; break
        if not got:
            print(f"  {len(cands)} candidates none match counter-diff for this video")
        got=True  # 已找到对齐, 不再试其他url
    except Exception as e: pass
if not got: print("no sequence match (重试: 确保新一集在线播放)")
print(f"done. candidates={len(cands)}")
