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
  // 2) 扫 kid(binary 16B), 收集附近±4KB所有16B候选key + 8B候选iv(高8非零低8零)
  keybox:function(kidhex){
    var kid=[];for(var i=0;i<32;i+=2)kid.push(parseInt(kidhex.substr(i,2),16));
    var pat=kid.map(function(b){return(b<16?'0':'')+b.toString(16)}).join(' ');
    var keys={};var ivs={};var hits=0;
    var rs=Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;});
    for(var ri=0;ri<rs.length;ri++){
      var ms;try{ms=Memory.scanSync(rs[ri].base,rs[ri].size,pat);}catch(e){continue;}
      for(var mi=0;mi<ms.length;mi++){hits++;
        try{var w=new Uint8Array(ms[mi].address.sub(4096).readByteArray(8192));
          for(var o=0;o+16<=w.length;o+=4){
            var nz=0,distinct={};for(var k=0;k<16;k++){if(w[o+k])nz++;distinct[w[o+k]]=1;}
            var h='';for(var k=0;k<16;k++)h+=(w[o+k]<16?'0':'')+w[o+k].toString(16);
            if(nz>=12&&Object.keys(distinct).length>=10)keys[h]=1;
            var lo0=true;for(var k=8;k<16;k++)if(w[o+k]){lo0=false;break;}
            var hinz=false;for(var k=0;k<8;k++)if(w[o+k]){hinz=true;break;}
            if(lo0&&hinz){var iv='';for(var k=0;k<8;k++)iv+=(w[o+k]<16?'0':'')+w[o+k].toString(16);ivs[iv]=1;}
          }
        }catch(e){}
      }
    }
    return {hits:hits,keys:Object.keys(keys),ivs:Object.keys(ivs)};
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

# 对每个 model 试预言机
for m in models[:6]:
    kid=m["kid"];url=m["url"]
    print(f"\n=== oracle for kid={kid} ===")
    # 下 sample0
    try:
        data=urllib.request.urlopen(urllib.request.Request(url,headers={"User-Agent":"Mozilla/5.0","Range":"bytes=0-900000"}),timeout=15,context=ctx).read()
        if data[4:8]!=b'ftyp': print("  非mp4,跳过");continue
        mds=find(data,[b"mdat"])[0];vt=[t for t in traks(data) if hdlr(data,t)==b"vide"]
        if not vt:continue
        r=samp0(data,vt[0]);off0,sz0=r;mo=off0-mds
        cipher=data[off0:off0+16]
    except Exception as e: print(f"  下载失败{e}");continue
    tk=time.time()
    kb=api.keybox(kid)
    print(f"  [{time.time()-tk:.1f}s] kid命中{kb['hits']}次, 候选key={len(kb['keys'])} 候选iv={len(kb['ivs'])}")
    # 存盘所有候选+密文, 供离线反复验证(避免重复抓取)
    json.dump({"kid":kid,"url":url,"sz0":sz0,"mo":mo,"off0":off0,
               "cipher64":data[off0:off0+64].hex(),"full_sample0":data[off0:off0+sz0].hex(),
               "keys":kb["keys"],"ivs":kb["ivs"]},open("capture/oracle_data.json","w"))
    print(f"  已存 capture/oracle_data.json (供离线验证)")
    # 验证: (key,iv) 使 解密sample0 头4字节=NAL长度合理 且 NAL头合法
    # sample0 是首样本(IDR), 全样本加密含4字节长度前缀; CTR原点=样本起点co; iv=(iv8<<64)
    tv=time.time();found=None
    # 过滤假密钥候选: 去掉含堆指针碎片(4字节对齐处出现 0x79xx/0x00007 高位)或零字节过多的
    def looks_ptr(b):
        z=b.count(0)
        if z>=4: return True
        for k in range(0,16,4):
            v=struct.unpack("<I",b[k:k+4])[0]
            if 0x79000000<=v<0x80000000 or 0x70000000<=v<0x80000000: return True  # arm64堆ptr低32
            hi=struct.unpack(">H",b[k+2:k+4])[0] if k+4<=16 else 0
        return False
    keys=[bytes.fromhex(h) for h in kb["keys"] if not looks_ptr(bytes.fromhex(h))]
    ivs=[bytes.fromhex(h) for h in kb["ivs"]]
    print(f"  过滤后候选key={len(keys)} (原{len(kb['keys'])}), iv={len(ivs)}")
    # 整段sample0密文(用于强验证NAL链)
    full=data[off0:off0+sz0]
    def walk_ok(pt):  # NAL链是否精确填满sz0且头合法
        p=0;n=0
        while p+4<=len(pt):
            L=struct.unpack(">I",pt[p:p+4])[0]
            if L==0 or p+4+L>sz0: return False
            nh=pt[p+4]
            if (nh>>7)&1 or ((nh>>1)&0x3f)>40: return False
            p+=4+L;n+=1
        return p==sz0 and n>=1
    import itertools
    cnt=0
    for K in keys:
        ec=AES.new(K,AES.MODE_ECB)
        for iv8 in ivs:
            cnt+=1
            ks0=ec.encrypt((int.from_bytes(iv8,"big")<<64).to_bytes(16,"big"))
            L=struct.unpack(">I",bytes(a^b for a,b in zip(cipher[0:4],ks0[0:4])))[0]
            if L!=sz0-4: continue  # 强约束: 单NAL精确长度
            # 确认: 解密整样本走NAL链
            ctr=Counter.new(128,initial_value=(int.from_bytes(iv8,"big")<<64))
            pt=AES.new(K,AES.MODE_CTR,counter=ctr).decrypt(full)
            if walk_ok(pt): found=(K,iv8);break
        if found:break
    if found:
        print(f"  [{time.time()-tv:.1f}s验证, {cnt}组合] *** KEY={found[0].hex()} base_iv={found[1].hex()} ***")
        print(f"  >>> 密钥预言机成功! 取key+iv总耗时(扣除找model) {time.time()-tk:.1f}s")
        json.dump({"kid":kid,"key":found[0].hex(),"base_iv":found[1].hex()},open("capture/oracle_key.json","w"),indent=2)
    else:
        print(f"  [{time.time()-tv:.1f}s] {cnt}组合 无匹配(key不在内存/未prepare/sample0非单NAL)")
