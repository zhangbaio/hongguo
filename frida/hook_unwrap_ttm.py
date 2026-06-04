# -*- coding: utf-8 -*-
"""直接 hook libttmplayer.so 的 unwrap 函数 FUN_00271a50, dump 一整组真值:
   (spade_base64, KEK材料字符串, iv12, 输出content key)。
算法(静态已确认): content_key = AES-GCM-256-decrypt(
    key   = f(MD5(KEK材料)),
    iv    = 固定12B (DAT_003412d4 ‖ 0x4f404ca),
    ct    = base64_decode(spade))
本脚本拿到真值后即可纯 Python 复现验证(§9 纯离线)。

FUN_00271a50 签名: (param_1, char* spade_b64, char* kek_material, void* iv, int iv_len=0xc, char* out)
frida 偏移 = Ghidra 0x271a50 - 0x100000(基址) = 0x171a50
"""
import frida, sys, json, os, time, subprocess

OFF = 0x171a50
OUT = "capture/unwrap_samples.json"

JS = r'''
'use strict';
function hx(p,n){ try{ return Array.prototype.map.call(new Uint8Array(p.readByteArray(n)), function(x){return ('0'+x.toString(16)).slice(-2);}).join(''); }catch(e){ return '<err>'; } }
function cs(p){ try{ return (p && !p.isNull()) ? p.readCString() : null; }catch(e){ return null; } }
// 重写 DNS: 所有 *.qznovelvod.com 解析劫持到一个能用的电信 CDN IP(Host 路由,一劳永逸)
var keepAlive = [];
var CDN_FALLBACK = "v95-aw-reading-video.qznovelvod.com"; // hosts 里映射到 61.164.240.181
try {
  var libc=null;
  Process.enumerateModules().forEach(function(m){ if(m.name==="libc.so") libc=m; });
  if(libc){
    var gai = libc.getExportByName("getaddrinfo");
    Interceptor.attach(gai, { onEnter:function(a){
      try{
        var h=a[0].readCString();
        if(h && h.indexOf("qznovelvod.com")>=0 && h!==CDN_FALLBACK){
          var p=Memory.allocUtf8String(CDN_FALLBACK); keepAlive.push(p); a[0]=p;
          send({t:'DNSREWRITE', from:h});
        } else if(h && /toutiao|byte|pstatp|douyin|vod|amemv|ixigua|snssdk/.test(h)){
          send({t:'DNS', host:h});
        }
      }catch(e){}
    }});
    send({t:'dnshook'});
  }
} catch(e){ send({t:'dnserr', e:''+e}); }

// 对比 hook: av_dict_set("decryption_key") —— 看 content key 是否在产生(解密是否进行)
try {
  Process.enumerateModules().forEach(function(m){
    try { var ad=m.getExportByName("av_dict_set");
      if(ad){ Interceptor.attach(ad,{onEnter:function(a){
        try{ var k=a[1].readCString(); if(k==="decryption_key"){ var v=a[2].readCString(); if(v&&/^[0-9a-f]{32}$/i.test(v)) send({t:'AVDICT', key:v.toLowerCase()}); } }catch(e){}
      }}); send({t:'avdicthook', mod:m.name}); }
    } catch(e){}
  });
} catch(e){}

var base = null;
Process.enumerateModules().forEach(function(m){ if(m.name==="libttmplayer.so") base=m.base; });
if(!base){ send({t:'err', m:'libttmplayer.so not loaded'}); }
else {
  // FUN_001c4550(byte* spade_decoded /*x0*/, int len /*x1*/, long* outkey /*x2*/, long* outtype /*x3*/, int flag /*x4*/)
  var fn = base.add(0xc4550);
  send({t:'hooked', fn: fn.toString(), base: base.toString()});
  Interceptor.attach(fn, {
    onEnter:function(a){
      this.len = a[1].toInt32();
      this.spade_in = (this.len>0 && this.len<512) ? hx(a[0], this.len) : ('<len='+this.len+'>');
      this.outkey = a[2];
      this.flag = a[4].toInt32();
    },
    onLeave:function(r){
      var keyhex='<?>';
      try{ var kp=this.outkey.readPointer(); if(!kp.isNull()) keyhex=cs(kp); }catch(e){ keyhex='<err '+e+'>'; }
      send({t:'UNWRAP1', spade_in:this.spade_in, len:this.len, flag:this.flag, key_out:keyhex});
    }
  });
}
'''.replace("OFF_PLACEHOLDER", hex(OFF))


def load():
    if os.path.exists(OUT):
        try:
            return json.load(open(OUT))
        except Exception:
            return []
    return []


def main():
    os.makedirs("capture", exist_ok=True)
    samples = load()

    def on_message(msg, data):
        if msg.get("type") != "send":
            if msg.get("type") == "error":
                print("[JS error]", msg.get("description"))
            return
        p = msg["payload"]
        t = p.get("t")
        if t == "AVDICT":
            print(f"[av_dict] content key 已产生(解密在进行): {p['key']}  ← 但若无UNWRAP则说明走了缓存/别路径")
        elif t == "DNSREWRITE":
            pass  # 太多, 不打印
        elif t == "DNS":
            print(f"[DNS] app 解析域名: {p['host']}")
        elif t == "hooked":
            print(f"[*] hooked FUN_00271a50 @ {p['fn']} (base={p['base']}); 播放在线视频")
        elif t == "err":
            print(f"[!] {p['m']}")
        elif t == "UNWRAP1":
            rec = {"spade_decoded_hex": p["spade_in"], "len": p["len"],
                   "flag": p["flag"], "content_key": p["key_out"]}
            samples.append(rec)
            json.dump(samples, open(OUT, "w"), indent=2, ensure_ascii=False)
            print(f"\n[★] UNWRAP1(FUN_001c4550) #{len(samples)}")
            print(f"    输入 spade(decoded, {rec['len']}B) = {rec['spade_decoded_hex']}")
            print(f"    flag(opt0x97)               = {rec['flag']}")
            print(f"    输出 content key             = {rec['content_key']}")
            print(f"    -> {OUT}")

    dev = frida.get_usb_device(timeout=10)
    out = subprocess.run(["adb", "shell", "pidof", "com.phoenix.read"],
                         capture_output=True, text=True).stdout.strip()
    if not out:
        print("[!] app 未运行"); sys.exit(1)
    pid = int(out.split()[0])
    session = dev.attach(pid)
    print(f"[*] attached pid={pid}")
    script = session.create_script(JS)
    script.on("message", on_message)
    script.load()
    print(f"[*] 等待 unwrap 触发(播放在线视频); Ctrl-C 结束 (已有 {len(samples)} 组)")
    try:
        import threading
        threading.Event().wait()
    except KeyboardInterrupt:
        pass


if __name__ == "__main__":
    main()
