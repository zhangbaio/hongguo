# -*- coding: utf-8 -*-
"""路B content-key 采集器: hook ffmpeg av_dict_set("decryption_key") -> capture/avdict_keys.json

原理(已坐实): libavmdlv2 内部 unwrap(spade_a, kid) 得到 16B content key 后,
经 av_dict_set("decryption_key", <16B hex>) 喂给 ffmpeg CENC 解码器。在此处 hook
即可拿到最终 content key, 无需解析脆弱的内存密钥盒。

用法:
  1) 模拟器里红果已运行(emulator-5554), frida-server 已起
  2) python frida/grab_avdict_keys.py        # 开始采集
  3) 在 app 里逐个播放要下的在线视频(每个播 2~3 秒, key 自动落盘)
  4) Ctrl-C 结束; 之后 downloader.py 会自动把这些 key 作为候选(密文自证选真)
"""
import frida, sys, json, os, time

JS = r'''
'use strict';
function cstr(p){ try{ return (p && !p.isNull()) ? p.readCString() : null; }catch(e){ return null; } }
function modOf(addr){
  var r = Process.findRangeByAddress(addr);
  return (r && r.file) ? r.file.path.split('/').pop() + '+0x' + addr.sub(r.base).toString(16) : addr.toString();
}
function hookExport(name){
  var addr = null, host = null;
  Process.enumerateModules().some(function(m){
    try{ m.enumerateExports().some(function(e){ if(e.name===name){ addr=e.address; host=m.name; return true; } return false; }); }catch(e){}
    return addr !== null;
  });
  if(!addr){ send({t:'no_export', name:name}); return; }
  Interceptor.attach(addr, { onEnter:function(a){
    var k = cstr(a[1]); if(k !== 'decryption_key') return;
    var v = cstr(a[2]); if(v && /^[0-9a-fA-F]{32}$/.test(v)){
      var bt = Thread.backtrace(this.context, Backtracer.ACCURATE).slice(0,16).map(modOf);
      send({t:'key', key:v.toLowerCase(), bt:bt});
    }
  }});
  send({t:'hooked', name:name, host:host, addr:addr.toString()});
}
hookExport('av_dict_set');
send({t:'ready'});
'''

OUT = "capture/avdict_keys.json"


def load():
    if os.path.exists(OUT):
        try:
            return json.load(open(OUT)).get("keys", [])
        except Exception:
            return []
    return []


def main():
    os.makedirs("capture", exist_ok=True)
    keys = load()

    def save():
        json.dump({"keys": keys, "ts": time.time()}, open(OUT, "w"), indent=2)

    def on_message(msg, data):
        if msg.get("type") != "send":
            if msg.get("type") == "error":
                print("[JS error]", msg.get("description"))
            return
        p = msg["payload"]
        t = p.get("t")
        if t == "key":
            k = p["key"]
            if k not in keys:
                keys.append(k); save()
            print(f"[+] content key: {k}  ({len(keys)} 累计)")
            bt = p.get("bt") or []
            if bt:
                print("    backtrace(unwrap 在 av_dict_set 上方几帧):")
                for f in bt:
                    print("      " + f)
        elif t == "hooked":
            print(f"[*] hooked {p['name']} @ host={p.get('host')} addr={p.get('addr')}; 播放在线视频, key+backtrace 自动打印")
        elif t == "no_export":
            print(f"[!] 未找到导出 {p['name']} (ffmpeg 可能静态链接/strip; 需改用偏移 hook)")
        elif t == "ready":
            print("[*] hook ready")

    dev = frida.get_usb_device(timeout=10)
    pid = None
    try:
        import subprocess
        out = subprocess.run(["adb", "shell", "pidof", "com.phoenix.read"],
                             capture_output=True, text=True).stdout.strip()
        if out:
            pid = int(out.split()[0])
    except Exception:
        pass
    if pid:
        session = dev.attach(pid)
        print(f"[*] attached 当前运行的 app pid={pid}")
    else:
        print("[*] app 未运行, spawn 启动 ...")
        pid = dev.spawn(["com.phoenix.read"]); dev.resume(pid); time.sleep(3)
        session = dev.attach(pid)
    script = session.create_script(JS)
    script.on("message", on_message)
    script.load()
    print(f"[*] 采集中(已有 {len(keys)} key); 播放在线视频; Ctrl-C 结束")
    try:
        import threading
        threading.Event().wait()   # 常驻等待(前台 Ctrl-C / 后台均可), 不依赖 stdin
    except KeyboardInterrupt:
        pass
    print(f"\n[*] 共 {len(keys)} 个 content key -> {OUT}")


if __name__ == "__main__":
    main()
