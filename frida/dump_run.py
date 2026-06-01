# -*- coding: utf-8 -*-
"""运行 dump_videomodel.js, 把每个命中文本存到 capture/mem_hit_N.txt"""
import frida, sys, time, subprocess, os

ADB = r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"
DEV = "127.0.0.1:16384"
PKG = "com.phoenix.read"
OUT = os.path.join(os.path.dirname(__file__), "..", "capture")

def get_pid():
    out = subprocess.run([ADB, "-s", DEV, "shell", "pidof", PKG],
                         capture_output=True, text=True).stdout.strip()
    return int(out.split()[0]) if out else None

def main():
    js = os.path.join(os.path.dirname(__file__), "dump_videomodel.js")
    dur = float(sys.argv[1]) if len(sys.argv) > 1 else 120
    pid = get_pid()
    if not pid:
        print("红果没运行"); return
    print(f"attach pid={pid}")
    dev = frida.get_device_manager().add_remote_device("127.0.0.1:27042")
    session = dev.attach(pid)
    script = session.create_script(open(js, encoding="utf-8").read())
    state = {"fin": False}
    def on_msg(m, data):
        if m["type"] == "send":
            p = m["payload"]
            t = p.get("t")
            if t == "hit":
                fn = os.path.join(OUT, f"mem_hit_{p['n']}.txt")
                open(fn, "w", encoding="utf-8").write(p["text"])
                print(f"[hit {p['n']}] addr={p['addr']} -> {fn} ({len(p['text'])}B)")
            elif t == "fin":
                print(f"[fin] hits={p['hits']}")
                state["fin"] = True
            else:
                print("[msg]", p)
        else:
            print("[ERR]", m.get("description") or m)
    script.on("message", on_msg)
    script.load()
    t0 = time.time()
    while time.time() - t0 < dur and not state["fin"]:
        time.sleep(0.5)
    print("done")

if __name__ == "__main__":
    main()
