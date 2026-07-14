# -*- coding: utf-8 -*-
"""注入 hook_ctrinit.js 到运行中的红果, 收集 FUN_0053d890 的所有 key+iv。
目的: 抓 spade 解包的 KEK(CBC, 跨视频恒定) 与内容密钥(CTR, 每视频变)。
用法: 先让 app 在播放在线视频, 再运行本脚本(它会持续收集; 期间换几集让 KEK 复现)。
       python frida/run_keyiv.py [秒数, 默认90]
"""
import frida, sys, subprocess, time, json
ADB = r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV = "127.0.0.1:16384"; PKG = "com.phoenix.read"
try: sys.stdout.reconfigure(encoding="utf-8")
except Exception: pass

def get_pid():
    out = subprocess.run([ADB, "-s", DEV, "shell", "pidof", PKG], capture_output=True, text=True).stdout.strip()
    return int(out.split()[0]) if out else None

secs = int(sys.argv[1]) if len(sys.argv) > 1 else 90
pid = get_pid()
if not pid:
    print("✗ app 未运行"); sys.exit(1)
print(f"[*] attach pid={pid}; 收集 {secs}s; 期间请播放/切换在线短剧让 KEK 复现")

JSFILE = "frida/hook_unwrap.js"
records = []; cbcs = []
def on_message(msg, data):
    if msg.get("type") == "send":
        p = msg["payload"]
        t = p.get("t")
        if t in ("KEYIV", "KEYEXP"):
            records.append(p)
            print(f"  [{t}] src={p.get('src','')} method={p.get('method','')} key={p.get('key')} iv={p.get('iv','')}")
        elif t == "CBC":
            cbcs.append(p)
            print(f"  [CBC] len={p.get('len')} ivchain={p.get('ivchain')} ct={p.get('ct')}")
        elif t == "DECBLK":
            cbcs.append(p)
            print(f"  [DECBLK] ct={p.get('ct')} sched0(≈KEK)={p.get('sched0')}")
        elif t == "CTR_RUN":
            print(f"  [CTR_RUN] len={p.get('len')} data0={p.get('data0')}")
        elif t == "DECBLK_OUT":
            print(f"  [DECBLK_OUT] pt={p.get('pt')}")
        elif t in ("hooked", "base", "ready", "hookfail", "tick"):
            if t != "tick": print(f"  ({t}) {p}")

dev = frida.get_device(DEV) if False else frida.get_usb_device(timeout=5)
session = dev.attach(pid)
js = open(JSFILE, "r", encoding="utf-8").read()
script = session.create_script(js)
script.on("message", on_message)
script.load()

t0 = time.time()
try:
    while time.time() - t0 < secs:
        time.sleep(1)
except KeyboardInterrupt:
    pass
script.unload(); session.detach()

# 汇总: 按 key 去重, 统计
keys = {}
for r in records:
    k = r.get("key")
    if not k: continue
    keys.setdefault(k, {"ivs": set(), "t": r.get("t")})
    if r.get("iv"): keys[k]["ivs"].add(r["iv"])
print(f"\n[*] 收集到 {len(keys)} 个不同 key:")
for k, v in keys.items():
    print(f"  key={k}  ivs={sorted(v['ivs'])}")
json.dump([{"key": k, "ivs": sorted(v["ivs"]), "t": v["t"]} for k, v in keys.items()],
          open("capture/keyiv_capture.json", "w"), indent=2)
print("写入 capture/keyiv_capture.json")
print("\n提示: 内容密钥每视频不同(CTR); KEK 跨视频恒定(CBC解包)。换几集后复现的那个=KEK。")
