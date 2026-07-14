# -*- coding: utf-8 -*-
"""同时触发播放和扫内存抓 URL，保证拿到新鲜 CDN URL"""
import frida, subprocess, time, threading, re, urllib.request, os, json

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*args): return subprocess.run([ADB,"-s",DEV]+list(args),capture_output=True,text=True).stdout.strip()
def get_pid(): out=adb("shell","pidof",PKG); return int(out.split()[0]) if out else None

TARGET_KID="6960e8ebf8818bad6286db200002ebeb"
found_urls={}

def trigger_taps():
    """持续点击触发不同集的播放"""
    for i in range(10):
        adb("shell","input","tap","540","960")
        time.sleep(0.3)
        adb("shell","input","swipe","540","1200","540","400","300")
        time.sleep(1.5)

JS=r"""
'use strict';
var KID='6960e8ebf8818bad6286db200002ebeb';
var PAT='36 39 36 30 65 38 65 62 66 38'; // "6960e8ebf8"
var scanned=false;
function doScan(){
  if(scanned)return; scanned=true;
  Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;}).forEach(function(r){
    Memory.scan(r.base,r.size,PAT,{
      onMatch:function(addr){
        try{
          var ctx=addr.sub(32768).readByteArray(131072);
          var s=String.fromCharCode.apply(null,new Uint8Array(ctx));
          if(s.indexOf('main_url')>=0){
            var idx=0;
            while(idx<s.length){
              var hi=s.indexOf('https://',idx);
              if(hi<0)break;
              var e2=s.indexOf('"',hi);
              if(e2>0&&e2-hi<600){
                var url=s.substr(hi,e2-hi);
                if(/qznovelvod|videocdn/.test(url)) send({t:'url',url:url});
              }
              idx=hi+8;
            }
          }
        }catch(e){}
      },
      onError:function(){},onComplete:function(){}
    });
  });
  send({t:'scan_done'});
}
// Hook MediaCodec configure - scan immediately when video starts loading
Java.perform(function(){
  var MC=Java.use('android.media.MediaCodec');
  MC.configure.overload('android.media.MediaFormat','android.view.Surface','android.media.MediaCrypto','int').implementation=function(fmt,surf,crypto,flags){
    send({t:'configure',name:this.getName()});
    setTimeout(doScan,100); // 立刻扫内存
    return this.configure(fmt,surf,crypto,flags);
  };
});
// 也立刻扫一次(当前加载的)
setTimeout(doScan,500);
"""

pid=get_pid(); print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
script=session.create_script(JS)
all_urls=set()
def on_msg(m,data):
    if m["type"]=="send":
        p=m["payload"]; t=p.get("t","")
        if t=="url":
            url=p["url"]
            if url not in all_urls:
                all_urls.add(url)
                bt=re.search(r'bt=(\d+)',url); ds=re.search(r'ds=(\d+)',url)
                print(f"[URL] bt={bt.group(1) if bt else '?'} ds={ds.group(1) if ds else '?'} {url[:80]}")
        elif t=="configure": print(f"[CONFIGURE] {p['name']}")
        elif t=="scan_done": print("[scan done]")
script.on("message",on_msg)
script.load()

# 后台 taps
t=threading.Thread(target=trigger_taps,daemon=True); t.start()
time.sleep(15)

# 尝试下载最高质量 URL
best_url=None; best_bt=0
for url in all_urls:
    bt=re.search(r'bt=(\d+)',url)
    if bt and int(bt.group(1))>best_bt:
        best_bt=int(bt.group(1)); best_url=url
if best_url:
    print(f"\nDownloading best URL (bt={best_bt})...")
    try:
        req=urllib.request.Request(best_url,headers={"User-Agent":"Mozilla/5.0"})
        data=urllib.request.urlopen(req,timeout=60).read()
        path=f"capture/ct/auto_fresh_{best_bt}.mp4"
        open(path,"wb").write(data)
        print(f"Saved {len(data)} bytes → {path}")
        # 保存 URL 列表
        json.dump(list(all_urls),open("capture/fresh_urls.json","w"),indent=2)
    except Exception as e:
        print(f"download failed: {e}")
else:
    print("no URLs found")
    json.dump(list(all_urls),open("capture/fresh_urls.json","w"),indent=2)
print(f"total URLs found: {len(all_urls)}")
