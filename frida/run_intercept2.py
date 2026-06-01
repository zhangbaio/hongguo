# -*- coding: utf-8 -*-
"""把密文信息嵌进 JS 再跑, 监听 RegisterNatives + memcpy 16B 来自 crypto lib"""
import frida, time, subprocess, json, struct, os, sys

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def get_pid():
    out=subprocess.run([ADB,"-s",DEV,"shell","pidof",PKG],capture_output=True,text=True).stdout.strip()
    return int(out.split()[0]) if out else None

def get_cipher_info(tag):
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
        mv=find(d,[b"moov"]); return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"]
    def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
    def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
    def samp0(d,tr):
        s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
        stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
        ss=u32(d,stsz[0]+4); sz0=ss if ss else u32(d,stsz[0]+12)
        return u32(d,stco[0]+8), sz0
    KIDMAP={"hit1":"6a1165c8f8818be2b9fb87020002ebeb","hit3":"6a1165c8f8818b04e11464d90002ebeb"}
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mds=find(d,[b"mdat"])[0]; vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    off0,sz0=samp0(d,vt); mo=off0-mds
    return d[off0:off0+64].hex(), sz0, mo, KIDMAP[tag]

# 构建 JS
cipher_js = "var CIPHERS={};\n"
for tag in ["hit1","hit3"]:
    ch, sz, mo, kid = get_cipher_info(tag)
    cipher_js += f'CIPHERS["{tag}"]={{c:"{ch}",sz:{sz},mo:{mo},k:"{kid}"}};\n'

JS = cipher_js + r"""
'use strict';
function h2b(h){var b=[];for(var i=0;i<h.length;i+=2)b.push(parseInt(h.substr(i,2),16));return b;}
function b2h(b){return Array.from(b).map(x=>(x<16?'0':'')+x.toString(16)).join('');}
for(var t in CIPHERS){var r=CIPHERS[t];r.cb=h2b(r.c);r.kb=h2b(r.k);}

var encMod=null,dragMod=null;
Process.enumerateModules().forEach(function(m){
  if(m.name==='libEncryptor.so') encMod=m;
  if(m.name==='libdragon_crypt.so') dragMod=m;
});
send({t:'mods', enc:encMod?encMod.base.toString():'null', enc_size:encMod?encMod.size:0,
      drag:dragMod?dragMod.base.toString():'null', drag_size:dragMod?dragMod.size:0});

// hook JNIEnv->RegisterNatives
Java.perform(function(){
  var envHandle=Java.vm.getEnv().handle;
  var fnTable=envHandle.readPointer();
  var regNat=fnTable.add(215*Process.pointerSize).readPointer();
  Interceptor.attach(regNat,{
    onEnter:function(a){
      try{
        var n=parseInt(a[3]);
        var methods=a[2];
        var cls=Java.vm.getEnv().getClassName(a[1]);
        for(var i=0;i<n&&i<20;i++){
          var nm=methods.add(i*24).readPointer().readCString();
          var sig=methods.add(i*24+8).readPointer().readCString();
          var fn=methods.add(i*24+16).readPointer();
          var inE=encMod&&fn.compare(encMod.base)>=0&&fn.compare(encMod.base.add(encMod.size))<0;
          var inD=dragMod&&fn.compare(dragMod.base)>=0&&fn.compare(dragMod.base.add(dragMod.size))<0;
          if(inE||inD) send({t:'native_method',cls:cls,name:nm,sig:sig,fn:fn.toString(),lib:inE?'Enc':'drag'});
        }
      }catch(e){}
    }
  });
  send({t:'info',msg:'RegisterNatives hooked'});

  // hook memcpy(libc), 过滤16字节来自 libEncryptor/libdragon
  var memcpy=Module.findExportByName('libc.so','memcpy');
  if(memcpy){
    Interceptor.attach(memcpy,{
      onEnter:function(a){this.dst=a[0];this.src=a[1];this.sz=parseInt(a[2]);},
      onLeave:function(){
        var inE=encMod&&this.src.compare(encMod.base)>=0&&this.src.compare(encMod.base.add(encMod.size))<0;
        var inD=dragMod&&this.src.compare(dragMod.base)>=0&&this.src.compare(dragMod.base.add(dragMod.size))<0;
        if((inE||inD)&&this.sz>=12&&this.sz<=32){
          try{
            var bytes=Array.from(this.dst.readByteArray(this.sz));
            send({t:'memcpy_from_crypto',lib:inE?'Enc':'drag',sz:this.sz,bytes:b2h(bytes.slice(0,this.sz))});
          }catch(e){}
        }
      }
    });
    send({t:'info',msg:'memcpy hooked'});
  }

  // hook malloc 来自 crypto lib (看分配大小 = 可能的 key 缓冲)
  // 另: 扫内存里 spade_a 当前位置
  setTimeout(function(){
    var PAT='73 70 61 64 65 5f 61';
    Process.enumerateRanges('rw-').filter(function(r){return r.size<32*1024*1024;}).forEach(function(r){
      Memory.scan(r.base,r.size,PAT,{
        onMatch:function(addr){
          try{
            // spade_a 所在区域的 addr 前后一定有 kid 字段, 检查是否是 JSON context
            var ctx=Memory.readByteArray(addr.sub(64),200);
            var str=String.fromCharCode.apply(null,new Uint8Array(ctx));
            if(str.indexOf('encrypt')>=0||str.indexOf('cenc')>=0){
              send({t:'spade_in_mem',addr:addr.toString(),ctx:str.replace(/[^\x20-\x7e]/g,'.')});
            }
          }catch(e){}
        },
        onError:function(){},onComplete:function(){}
      });
    });
  },1000);
});
"""

pid=get_pid()
if not pid: print("红果没运行"); sys.exit(1)
print(f"attach pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
script=session.create_script(JS)
all_memcpy=[]
def on_msg(m,data):
    if m["type"]=="send":
        p=m["payload"]; t=p.get("t","")
        if t=="native_method": print("[NATIVE METHOD]",p)
        elif t=="memcpy_from_crypto":
            all_memcpy.append(p)
            print(f"[memcpy {p['lib']} sz={p['sz']}] {p['bytes']}")
        elif t=="spade_in_mem": print("[SPADE@MEM]",p.get("addr"),p.get("ctx","")[:120])
        elif t in ("mods","info"): print("[info]",p)
    else: print("[ERR]",m.get("description")or m)
script.on("message",on_msg)
script.load()
print("monitoring 60s...")
time.sleep(60)
print(f"total memcpy_from_crypto: {len(all_memcpy)}")
if all_memcpy:
    json.dump(all_memcpy, open("capture/memcpy_crypto.json","w"), indent=2)
    print("saved capture/memcpy_crypto.json")
