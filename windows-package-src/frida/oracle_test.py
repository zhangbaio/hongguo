# -*- coding: utf-8 -*-
"""最小密钥预言机(验证式): 对当前加载的视频, 扫kid->收集候选key/iv->下sample0->验证. 计时."""
import frida, subprocess, time, struct, json, ssl, urllib.request
from Crypto.Cipher import AES
from Crypto.Util import Counter
ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def gp(): o=subprocess.run([ADB,"-s",DEV,"shell","pidof",PKG],capture_output=True,text=True).stdout.strip();return int(o.split()[0]) if o else None
ctx=ssl.create_default_context();ctx.check_hostname=False;ctx.verify_mode=ssl.CERT_NONE

JS=r"""
'use strict';
rpc.exports={
  // 1) 找当前 video_model: 返回 [{kid, url}]
  models:function(){
    var out=[];var seen={};var PAT='73 70 61 64 65 5f 61';var raw=0;
    var rs=Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;});
    for(var ri=0;ri<rs.length;ri++){
      var ms;try{ms=Memory.scanSync(rs[ri].base,rs[ri].size,PAT);}catch(e){continue;}
      raw+=ms.length;
      for(var mi=0;mi<ms.length&&out.length<6;mi++){try{
        var st=ms[mi].address.sub(2048);
        var s=String.fromCharCode.apply(null,new Uint8Array(st.readByteArray(8192)));
        var km=s.match(/kid[\\":\s]*([0-9a-f]{32})/);var um=s.match(/main_url[\\":\s]*(https:\/\/[^"\\\s]+)/);
        if(km&&um&&!seen[km[1]]){seen[km[1]]=1;out.push({kid:km[1],url:um[1]});}
      }catch(e){}}
    }
    return {raw:raw,models:out};
  },
  // 2) 扫 kid(binary 16B); 对每个高熵16B候选key, 收集其±256字节内的8B候选iv(就近配对, 减组合)
  keybox:function(kidhex){
    var kid=[];for(var i=0;i<32;i+=2)kid.push(parseInt(kidhex.substr(i,2),16));
    var pat=kid.map(function(b){return(b<16?'0':'')+b.toString(16)}).join(' ');
    var groups={};var hits=0;var WIN=4096;var NEAR=256;
    function hx(w,o,n){var h='';for(var k=0;k<n;k++)h+=(w[o+k]<16?'0':'')+w[o+k].toString(16);return h;}
    var rs=Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;});
    for(var ri=0;ri<rs.length;ri++){
      var ms;try{ms=Memory.scanSync(rs[ri].base,rs[ri].size,pat);}catch(e){continue;}
      for(var mi=0;mi<ms.length;mi++){hits++;
        if(hits>40)break; // 同struct重复多, 取前若干个kid命中即可
        try{var w=new Uint8Array(ms[mi].address.sub(WIN).readByteArray(WIN*2));
          // 先找窗口内所有候选key位置 + 所有iv
          var keypos=[];var ivlist=[];
          for(var o=0;o+16<=w.length;o+=4){
            var nz=0,dd={};for(var k=0;k<16;k++){if(w[o+k])nz++;dd[w[o+k]]=1;}
            if(nz>=12&&Object.keys(dd).length>=10) keypos.push(o);
            var lo0=true;for(var k=8;k<16;k++)if(w[o+k]){lo0=false;break;}
            var hinz=false;for(var k=0;k<8;k++)if(w[o+k]){hinz=true;break;}
            if(lo0&&hinz) ivlist.push([o,hx(w,o,8)]);
          }
          // 每个key配其±NEAR内的iv
          for(var ki=0;ki<keypos.length;ki++){
            var ko=keypos[ki];var kh=hx(w,ko,16);
            if(!groups[kh])groups[kh]={};
            for(var ii=0;ii<ivlist.length;ii++){
              if(Math.abs(ivlist[ii][0]-ko)<=NEAR) groups[kh][ivlist[ii][1]]=1;
            }
          }
        }catch(e){}
      }
      if(hits>40)break;
    }
    var out=[];var allivs={};
    for(var kh in groups){var ivs=Object.keys(groups[kh]);out.push([kh,ivs]);for(var x=0;x<ivs.length;x++)allivs[ivs[x]]=1;}
    return {hits:hits,groups:out,allivs:Object.keys(allivs)};
  }
};
"""
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
def attach():
    pid=gp();
    if not pid: return None,None
    try:
        sc=dev.attach(pid).create_script(JS);sc.load();return sc,pid
    except Exception as e:
        return None,pid

print("轮询扫描中(最多60s)... 请把视频播起来并保持在播放画面")
s=None;api=None;models=[]
t0=time.time()
while time.time()-t0<60:
    if s is None:
        s,pid=attach()
        if s: api=s.exports_sync; print(f"  attached pid={pid}")
        else: time.sleep(2); continue
    try:
        res=api.models(); models=res["models"]
    except Exception:
        s=None; time.sleep(1); continue   # app重启,重连
    if models:
        print(f"[{time.time()-t0:.1f}s] spade_a命中={res['raw']}, video_models={len(models)}"); break
    print(f"  [{time.time()-t0:.0f}s] spade_a原始命中={res['raw']}, 解析出model={len(models)}")
    time.sleep(2)
if not models: print("60s内无video_model(视频没在播/app不稳)"); raise SystemExit
for m in models[:6]: print(f"   kid={m['kid']} url={m['url'][:60]}")

# mp4 sample0 解析
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
def samp0(d,tr):
    s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr);stsz=find(d,[b"stsz"],s,e);stco=find(d,[b"stco"],s,e)
    if not stsz or not stco:return None
    ss=u32(d,stsz[0]+4);sz0=ss if ss else u32(d,stsz[0]+12);return u32(d,stco[0]+8),sz0

def walk_ok(pt,sz0):
    p=0;n=0
    while p+4<=len(pt):
        L=struct.unpack(">I",pt[p:p+4])[0]
        if L==0 or p+4+L>sz0: return False
        nh=pt[p+4]
        if (nh>>7)&1 or ((nh>>1)&0x3f)>40: return False
        p+=4+L;n+=1
    return p==sz0 and n>=1

def get_sample0(url):
    data=urllib.request.urlopen(urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0","Range":"bytes=0-900000"}),timeout=15,context=ctx).read()
    if data[4:8]!=b'ftyp': return None
    mds=find(data,[b"mdat"])[0];vt=[t for t in traks(data) if hdlr(data,t)==b"vide"]
    if not vt: return None
    off0,sz0=samp0(data,vt[0])
    return data,off0,sz0

def validate(kb,data,off0,sz0):
    cipher=data[off0:off0+16]; full=data[off0:off0+sz0]
    cnt=0;strong=0
    for kh,ivhexs in kb["groups"]:
        K=bytes.fromhex(kh); ec=AES.new(K,AES.MODE_ECB)
        for ivh in ivhexs:
            iv8=int.from_bytes(bytes.fromhex(ivh),"big"); cnt+=1
            ks0=ec.encrypt((iv8<<64).to_bytes(16,"big"))
            L=struct.unpack(">I",bytes(a^b for a,b in zip(cipher[0:4],ks0[0:4])))[0]
            nh=cipher[4]^ks0[4]
            if not(0<L<=sz0-4 and (nh>>7)&1==0 and ((nh>>1)&0x3f)<=40): continue
            strong+=1
            pt=AES.new(K,AES.MODE_CTR,counter=Counter.new(128,initial_value=(iv8<<64))).decrypt(full)
            if walk_ok(pt,sz0): return K,bytes.fromhex(ivh),cnt,strong
    return None,None,cnt,strong

# 外层重试: 每轮扫models, 对每个kid快速查一次keybox, 只验证"正在解码"(命中>0)的那个
done=False
for rnd in range(1,7):
    if done: break
    res=api.models(); models=res["models"]
    print(f"\n[round{rnd}] models={len(models)}")
    for m in models:
        kid=m["kid"]
        kb=api.keybox(kid)
        if kb["hits"]==0:
            print(f"  kid={kid[:14]} 未解码(0命中)"); continue
        ng=len(kb["groups"]); niv=sum(len(g[1]) for g in kb["groups"])
        print(f"  kid={kid[:14]} *正在解码* 命中{kb['hits']} key组{ng} 就近iv{niv}")
        try: r=get_sample0(m["url"])
        except Exception as e: print(f"   下载失败{e}"); r=None
        if not r: print("   sample0取失败"); continue
        data,off0,sz0=r
        json.dump({"kid":kid,"url":m["url"],"sz0":sz0,"off0":off0,
                   "full_sample0":data[off0:off0+sz0].hex(),"groups":kb["groups"],"allivs":kb["allivs"]},
                  open(f"capture/oracle_{kid[:8]}.json","w"))
        tv=time.time()
        K,iv8,cnt,strong=validate(kb,data,off0,sz0)
        if K:
            print(f"   [{time.time()-tv:.1f}s,{cnt}组合/{strong}过弱筛] *** KEY={K.hex()} base_iv={iv8.hex()} ***")
            print(f"   >>> 密钥预言机成功!")
            json.dump({"kid":kid,"key":K.hex(),"base_iv":iv8.hex()},open("capture/oracle_key.json","w"),indent=2)
            done=True; break
        else:
            print(f"   [{time.time()-tv:.1f}s] {cnt}组合({strong}过弱筛) 无匹配 (已存oracle_{kid[:8]}.json供离线调)")
    if not done: time.sleep(3)
if not done: print("\n未成功: 没有正在解码的model命中, 或验证未匹配(保持单个在线视频持续播放再试)")
