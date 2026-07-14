# -*- coding: utf-8 -*-
"""attach 到 media.codec 进程, 从 OMX 层抓明文帧。
请在脚本运行后立刻在 app 里播放视频。"""
import frida, subprocess, time, os

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"

def get_pid(name):
    out=subprocess.run([ADB,"-s",DEV,"shell","su","-c",f"pidof {name}"],
                       capture_output=True,text=True).stdout.strip()
    return int(out.split()[0]) if out.strip() else None

# media.codec 可能叫不同名
TARGETS=["media.codec","mediacodec","media.swcodec"]
pid=None
for t in TARGETS:
    pid=get_pid(t)
    if pid: print(f"found {t} pid={pid}"); break

if not pid:
    print("media.codec not found, trying by PID 8259 (from ps output)")
    pid=8259

dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
try:
    session=dev.attach(pid)
    print(f"attached to pid={pid}")
except Exception as e:
    print(f"failed to attach to {pid}: {e}")
    print("falling back to app process...")
    pid2=get_pid("com.phoenix.read")
    session=dev.attach(pid2)
    print(f"attached to app pid={pid2}")

JS=r"""
'use strict';
// 在 media.codec 进程里, 列出模块, 找 OMX/AMediaCodec 函数
var mods = Process.enumerateModules().map(m => m.name).join(',');
send({t:'mods', count: Process.enumerateModules().length, names: mods.substr(0,500)});

// 尝试 hook AMediaCodec_queueInputBuffer
var nfn = Module.findExportByName(null,'AMediaCodec_queueInputBuffer');
send({t:'qib_fn', fn: nfn ? nfn.toString() : 'null'});
if (nfn) {
  Interceptor.attach(nfn, {
    onEnter: function(a){this.sz=parseInt(a[3]); this.off=parseInt(a[2]);},
    onLeave: function(){
      if(this.sz>4) send({t:'frame', sz:this.sz});
    }
  });
}
"""

script=session.create_script(JS)
def on_msg(m,data):
    if m["type"]=="send": print(m["payload"])
    else: print("[E]",m)
script.on("message",on_msg)
script.load()
print("monitoring 30s... PLAY VIDEO NOW in app")
time.sleep(30)
print("done")
