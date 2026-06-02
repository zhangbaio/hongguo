# -*- coding: utf-8 -*-
import frida, os, time, re, json, threading, urllib.request, ssl
SBOX=[0x63,0x7c,0x77,0x7b,0xf2,0x6b,0x6f,0xc5,0x30,0x01,0x67,0x2b,0xfe,0xd7,0xab,0x76,0xca,0x82,0xc9,0x7d,0xfa,0x59,0x47,0xf0,0xad,0xd4,0xa2,0xaf,0x9c,0xa4,0x72,0xc0,0xb7,0xfd,0x93,0x26,0x36,0x3f,0xf7,0xcc,0x34,0xa5,0xe5,0xf1,0x71,0xd8,0x31,0x15,0x04,0xc7,0x23,0xc3,0x18,0x96,0x05,0x9a,0x07,0x12,0x80,0xe2,0xeb,0x27,0xb2,0x75,0x09,0x83,0x2c,0x1a,0x1b,0x6e,0x5a,0xa0,0x52,0x3b,0xd6,0xb3,0x29,0xe3,0x2f,0x84,0x53,0xd1,0x00,0xed,0x20,0xfc,0xb1,0x5b,0x6a,0xcb,0xbe,0x39,0x4a,0x4c,0x58,0xcf,0xd0,0xef,0xaa,0xfb,0x43,0x4d,0x33,0x85,0x45,0xf9,0x02,0x7f,0x50,0x3c,0x9f,0xa8,0x51,0xa3,0x40,0x8f,0x92,0x9d,0x38,0xf5,0xbc,0xb6,0xda,0x21,0x10,0xff,0xf3,0xd2,0xcd,0x0c,0x13,0xec,0x5f,0x97,0x44,0x17,0xc4,0xa7,0x7e,0x3d,0x64,0x5d,0x19,0x73,0x60,0x81,0x4f,0xdc,0x22,0x2a,0x90,0x88,0x46,0xee,0xb8,0x14,0xde,0x5e,0x0b,0xdb,0xe0,0x32,0x3a,0x0a,0x49,0x06,0x24,0x5c,0xc2,0xd3,0xac,0x62,0x91,0x95,0xe4,0x79,0xe7,0xc8,0x37,0x6d,0x8d,0xd5,0x4e,0xa9,0x6c,0x56,0xf4,0xea,0x65,0x7a,0xae,0x08,0xba,0x78,0x25,0x2e,0x1c,0xa6,0xb4,0xc6,0xe8,0xdd,0x74,0x1f,0x4b,0xbd,0x8b,0x8a,0x70,0x3e,0xb5,0x66,0x48,0x03,0xf6,0x0e,0x61,0x35,0x57,0xb9,0x86,0xc1,0x1d,0x9e,0xe1,0xf8,0x98,0x11,0x69,0xd9,0x8e,0x94,0x9b,0x1e,0x87,0xe9,0xce,0x55,0x28,0xdf,0x8c,0xa1,0x89,0x0d,0xbf,0xe6,0x42,0x68,0x41,0x99,0x2d,0x0f,0xb0,0x54,0xbb,0x16]
JS=("var SBOX=["+",".join(str(x) for x in SBOX)+"];")+r'''
var RC=[0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80,0x1b,0x36];
function Wd(a,i){return ((a[i]<<24)|(a[i+1]<<16)|(a[i+2]<<8)|a[i+3])>>>0;}
function sw(x){return ((SBOX[(x>>>24)&255]<<24)|(SBOX[(x>>>16)&255]<<16)|(SBOX[(x>>>8)&255]<<8)|SBOX[x&255])>>>0;}
function rw(x){return (((x<<8)|(x>>>24)))>>>0;}
function f128(a,o){var w=[];for(var i=0;i<44;i++)w[i]=Wd(a,o+i*4);for(var i=4;i<44;i++){var t=w[i-1];if(i%4===0)t=(sw(rw(t))^((RC[(i/4)-1])<<24))>>>0;if(((w[i-4]^t)>>>0)!==w[i])return false;}return true;}
function hx(a,o,n){var s="";for(var k=0;k<n;k++)s+=('0'+a[o+k].toString(16)).slice(-2);return s;}
function asc(p,n){try{var b=new Uint8Array(p.readByteArray(n));var s="";for(var i=0;i<n;i++){var c=b[i];s+=(c>=32&&c<127)?String.fromCharCode(c):" ";}return s;}catch(e){return "";}}
var rs=[],ri=0,found=[],done2=0,phase=0,svdHits=0;
function extractStep(){
  if(ri>=rs.length||svdHits>=4){ri=0;phase=1;send({t:"vmdone"});setTimeout(scanStep,0);return;}
  var rg=rs[ri++];
  try{var res=Memory.scanSync(rg.base,rg.size,"73 70 61 64 65 5f 61");
    for(var k=0;k<res.length&&svdHits<4;k++){send({t:"ctx",ctx:asc(res[k].address.sub(5000),5800)});svdHits++;}
  }catch(e){}
  setTimeout(extractStep,0);
}
function scanStep(){
  if(ri>=rs.length){send({t:"done",found:found,mb:Math.floor(done2/1048576)});return;}
  var rg=rs[ri++];
  try{
    var ab=rg.base.readByteArray(rg.size); done2+=rg.size;
    var a=new Uint8Array(ab);
    var u=new Uint32Array(ab, 0, (rg.size>>2));
    var lim=u.length-60;
    for(var j=0;j<=lim;j++){
      if(u[j+5]===((u[j+4]^u[j+1])>>>0)){
        var o=j*4;
        if(f128(a,o)) found.push("128:"+hx(a,o,16));
      }
    }
  }catch(e){}
  if(ri%300===0) send({t:"prog",mb:Math.floor(done2/1048576),f:found.length});
  setTimeout(scanStep,0);
}
rpc.exports={go:function(){var all=Process.enumerateRanges('rw-');for(var i=0;i<all.length;i++){var r=all[i];if(!r.file&&r.size>=256&&r.size<=600*1024*1024)rs.push(r);}send({t:"start",n:rs.length});setTimeout(extractStep,0);}};
'''

dev_=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
sess=dev_.attach(int(os.environ["HGPID"]))
scr=sess.create_script(JS)
state={"vms":[],"keys":[],"done":False,"cipher":None}
sslc=ssl.create_default_context(); sslc.check_hostname=False; sslc.verify_mode=ssl.CERT_NONE

def dl(it):
    try:
        data=urllib.request.urlopen(urllib.request.Request(it["main_url"],headers={"User-Agent":"Mozilla/5.0"}),timeout=60,context=sslc).read()
        fn="_align_%s.mp4"%it["kid"][:12]
        open(fn,"wb").write(data)
        it["cipher_file"]=fn; it["cipher_len"]=len(data)
        print("  下载密文 kid=%s %d字节 -> %s"%(it["kid"][:12],len(data),fn),flush=True)
    except Exception as e:
        print("  下载失败:",str(e)[:100],flush=True)

def on(m,d):
    p=m.get("payload") if m.get("type")=="send" else m
    if not isinstance(p,dict): return
    t=p.get("t")
    if t=="start": print("ranges:",p["n"],flush=True)
    elif t=="ctx":
        c=p["ctx"]; mu=re.search(r'(https://[^"]*qznovelvod\.com[^"]*?)"',c); kid=re.search(r'"kid":"([0-9a-f]{32})"',c); sp=re.search(r'"spade_a":"([^"]+)"',c)
        if mu and kid and sp:
            it={"main_url":mu.group(1),"kid":kid.group(1),"spade_a":sp.group(1)}
            if it["kid"] not in [v["kid"] for v in state["vms"]]:
                state["vms"].append(it); print("vm kid=%s spade=%s.."%(it["kid"],it["spade_a"][:20]),flush=True)
                threading.Thread(target=dl,args=(it,),daemon=True).start()
    elif t=="vmdone": print("提取完成 %d 个vm, 开始扫描密钥..."%len(state["vms"]),flush=True)
    elif t=="prog": print("  扫描 %dMB f=%d"%(p["mb"],p["f"]),flush=True)
    elif t=="done":
        u=list(dict.fromkeys(p["found"])); state["keys"]=u; state["done"]=True
        print("扫描完成 %dMB 找到密钥 %d(去重%d)"%(p["mb"],len(p["found"]),len(u)),flush=True)
        json.dump(u,open("_allkeys.json","w"))
        json.dump(state["vms"],open("_play_vms.json","w"))

scr.on("message",on); scr.load(); scr.exports_sync.go()
t0=time.time()
while not state["done"] and time.time()-t0<340: time.sleep(1)
time.sleep(2)
print("END done=%s vms=%d keys=%d"%(state["done"],len(state["vms"]),len(state["keys"])),flush=True)
