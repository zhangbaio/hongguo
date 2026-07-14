# -*- coding: utf-8 -*-
"""自动触发播放 + MC 捕获:
1. adb input tap 点击屏幕中央触发播放
2. 立刻附加 MC hook
3. 捕获 500KB+ 后停止
"""
import frida, subprocess, time, os, threading

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*args):
    return subprocess.run([ADB,"-s",DEV]+list(args),capture_output=True,text=True).stdout.strip()

def get_pid():
    out=adb("shell","pidof",PKG); return int(out.split()[0]) if out else None

def reset_files():
    adb("shell","su","-c","rm -f /data/local/tmp/auto2_v.h265; touch /data/local/tmp/auto2_v.h265; chmod 777 /data/local/tmp/auto2_v.h265")

# 触发播放: 点击屏幕中央 + 下滑等
def trigger_taps():
    time.sleep(1)
    for attempt in range(5):
        # 点击屏幕中央 (540x960 for 1080x1920 half)
        adb("shell","input","tap","540","960")
        time.sleep(0.5)
        # 如果是暂停状态, 再点一次
        adb("shell","input","tap","540","960")
        time.sleep(1)
        # 尝试下滑到下一集
        adb("shell","input","swipe","540","1200","540","400","500")
        time.sleep(2)
        print(f"  tap attempt {attempt+1}")

# MC hook JS (no size limit, stop when 500KB)
JS="""
'use strict';
var fv=null, vBytes=0;
Java.perform(function(){
  try{var FOS=Java.use('java.io.FileOutputStream'); fv=FOS.$new('/data/local/tmp/auto2_v.h265',false);}catch(e){}
  var MC=Java.use('android.media.MediaCodec');
  MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
    if(size>4){
      try{
        var name=this.getName().toLowerCase();
        if(/hevc|bytevc|h265|avc|h264/.test(name)){
          var bb=this.getInputBuffer(idx); bb.position(off);
          var a=Java.array('byte',new Array(size).fill(0)); bb.get(a);
          if(fv){fv.write(a,0,size); vBytes+=size;}
          send({t:'frame',name:name,size:size,flags:flags,vBytes:vBytes});
        }
      }catch(e){}
    }
    return this.queueInputBuffer(idx,off,size,pts,flags);
  };
  MC.configure.overload('android.media.MediaFormat','android.view.Surface','android.media.MediaCrypto','int').implementation=function(fmt,surf,crypto,flags){
    send({t:'configure',name:this.getName(),fmt:fmt.toString().substr(0,80)});
    return this.configure(fmt,surf,crypto,flags);
  };
  send({t:'hooked'});
});
setInterval(function(){send({t:'tick',vBytes:vBytes});},3000);
"""

reset_files()
pid=get_pid(); print(f"pid={pid}")
dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
script=session.create_script(JS)

state={"vb":0,"done":False}
def on_msg(m,data):
    if m["type"]=="send":
        p=m["payload"]; t=p.get("t","")
        if t=="hooked": print("[HOOKED] MC hook installed")
        elif t=="configure": print(f"[CONFIGURE] {p['name']} fmt={p['fmt']}")
        elif t=="frame":
            if state["vb"]==0: print(f"[FIRST FRAME!] {p['name']} size={p['size']} flags={p['flags']}")
            state["vb"]=p["vBytes"]
            if state["vb"]>500000: state["done"]=True
        elif t=="tick":
            if p["vBytes"]>0: print(f"[CAPTURING] {p['vBytes']} bytes")
            else: print(f"[waiting...]")
    else: print("[ERR]",m)
script.on("message",on_msg)
script.load()
print("[hook loaded] triggering taps...")

# 后台线程持续 tap
t=threading.Thread(target=trigger_taps,daemon=True); t.start()

t0=time.time()
while time.time()-t0<120 and not state["done"]:
    time.sleep(0.5)

if state["done"]:
    print(f"[DONE] captured {state['vb']} bytes")
else:
    print(f"[timeout] vBytes={state['vb']}")

# 拉取
out=subprocess.run([ADB,"-s",DEV,"exec-out","su -c 'cat /data/local/tmp/auto2_v.h265'"],capture_output=True)
open("capture/auto2_plain.h265","wb").write(out.stdout)
print(f"saved {len(out.stdout)} bytes → capture/auto2_plain.h265")
