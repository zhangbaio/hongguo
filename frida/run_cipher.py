import frida,sys,subprocess,time
try: sys.stdout.reconfigure(encoding="utf-8")
except: pass
ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe";DEV="127.0.0.1:16384"
pid=int(subprocess.run([ADB,"-s",DEV,"shell","pidof","com.phoenix.read"],capture_output=True,text=True).stdout.split()[0])
print("attach",pid,flush=True)
recs=[]
def om(m,d):
    if m.get("type")=="send":
        p=m["payload"]
        if p.get("t")=="DOFINAL": print(f"  [DOFINAL] alg={p['alg']} inlen={p['inlen']} in={p['in']} -> outlen={p['outlen']} out={p['out']}",flush=True); recs.append(p)
        elif p.get("t")=="CINIT": print(f"  [CINIT] alg={p['alg']} mode={p['mode']} key={p['key']} iv={p['iv']}",flush=True); recs.append(p)
        else: print("  ",p,flush=True)
    elif m.get("type")=="error": print("  ERR",m.get("description"),flush=True)
s=frida.get_usb_device(timeout=5).attach(pid)
sc=s.create_script(open("frida/hook_cipher.js",encoding="utf-8").read());sc.on("message",om);sc.load()
secs=int(sys.argv[1]) if len(sys.argv)>1 else 90
time.sleep(secs);sc.unload();s.detach()
import json;json.dump(recs,open("capture/cipher_capture.json","w"))
print(f"done, {len(recs)} crypto事件",flush=True)
