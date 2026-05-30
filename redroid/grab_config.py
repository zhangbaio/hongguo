# -*- coding: utf-8 -*-
"""容器内自动生成 config.json: hook tryAddSecurityFactor 抓一条真实业务请求,
从其 URL(device_id/iid/cdid...) 和 headers(x-tt-token/cookie) 提取设备+会话参数。
这样 config 与 redroid 内 app 实例的设备指纹一致(签名才有效)。
"""
import os, sys, json, time, subprocess
from urllib.parse import urlparse, parse_qsl
import frida

ADB = os.environ.get("ADB", "adb")
DEV = os.environ.get("ADB_DEVICE", "redroid:5555")
FRIDA_HOST = os.environ.get("FRIDA_HOST", "127.0.0.1:27042")
PKG = "com.phoenix.read"
OUT = os.path.join(os.path.dirname(os.path.abspath(__file__)), "config.json")

DEVICE_KEYS = {
    "iid", "device_id", "ac", "channel", "aid", "app_name", "version_code",
    "version_name", "device_platform", "os", "ssmix", "device_type", "device_brand",
    "language", "os_api", "os_version", "manifest_version_code", "resolution", "dpi",
    "update_version_code", "host_abi", "dragon_device_type", "pv_player",
    "compliance_status", "need_personal_recommend", "player_so_load",
    "is_android_pad_screen", "rom_version", "cdid", "klink_egdi",
}
SESSION_HEADERS = ("cookie", "x-tt-token", "user-agent", "passport-sdk-version",
                   "sdk-version", "x-tt-store-region", "x-tt-store-region-src")

HOOK = """
var NP = Java.use("com.bytedance.frameworks.baselib.network.http.NetworkParams");
NP.tryAddSecurityFactor.overload("java.lang.String","java.util.Map").implementation = function(url, h){
  try {
    var u = url.toString();
    if (u.indexOf("fqnovel.com")>=0 && u.indexOf("device_id=")>=0 && u.indexOf("/reading/")>=0){
      var obj={url:u, headers:{}};
      var it=h.keySet().iterator();
      while(it.hasNext()){var k=it.next(); var v=h.get(k); obj.headers[k.toString()]=v?v.toString():null;}
      send(obj);
    }
  } catch(e){}
  return this.tryAddSecurityFactor(url,h);
};
send({ready:true});
"""


def get_pid():
    out = subprocess.run([ADB, "-s", DEV, "shell", "pidof", PKG], capture_output=True, text=True).stdout
    return int(out.split()[0]) if out.strip() else None


def main():
    pid = get_pid()
    if not pid:
        print("[grab_config] app 未运行"); sys.exit(1)
    dev = frida.get_device_manager().add_remote_device(FRIDA_HOST)
    script = dev.attach(pid).create_script(HOOK)
    captured = {}

    def on_msg(m, d):
        if m["type"] != "send":
            return
        p = m["payload"]
        if isinstance(p, dict) and p.get("url") and not captured:
            captured.update(p)

    script.on("message", on_msg)
    script.load()

    # 触发请求: 重启app以产生 /reading/ 调用
    subprocess.run([ADB, "-s", DEV, "shell", "am", "force-stop", PKG])
    subprocess.run([ADB, "-s", DEV, "shell", "monkey", "-p", PKG, "-c",
                    "android.intent.category.LAUNCHER", "1"], capture_output=True)

    for _ in range(60):
        if captured:
            break
        time.sleep(1)

    if not captured:
        print("[grab_config] 60s 内未捕获业务请求, 沿用现有 config.json"); sys.exit(2)

    q = dict(parse_qsl(urlparse(captured["url"]).query))
    base_query = {k: q[k] for k in DEVICE_KEYS if k in q and q[k]}
    # headers 值形如 [v]
    hdr = {}
    for k, v in captured["headers"].items():
        kl = k.lower()
        if kl in SESSION_HEADERS and v:
            hdr[kl] = v.strip("[]")
    cfg = {"base_query": base_query, "session_headers": hdr,
           "api_host": "api5-normal-sinfonlinea.fqnovel.com"}
    json.dump(cfg, open(OUT, "w", encoding="utf-8"), ensure_ascii=False, indent=2)
    print(f"[grab_config] 已生成 config.json (device_id={base_query.get('device_id')}, "
          f"token长度={len(hdr.get('x-tt-token',''))})")


if __name__ == "__main__":
    main()
