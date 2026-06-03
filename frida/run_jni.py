import frida,sys,subprocess,time,json
try: sys.stdout.reconfigure(encoding="utf-8")
except: pass
ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe";DEV="127.0.0.1:16384"
pid=int(subprocess.run([ADB,"-s",DEV,"shell","pidof","com.phoenix.read"],capture_output=True,text=True).stdout.split()[0])
print("attach",pid,flush=True); recs=[]
def om(m,d):
    if m.get("type")=="send":
        p=m["payload"]
        if p.get("t")=="SPADE_STR":
            print(f"\n  *** SPADE 经JNI传入: {p['s']}",flush=True)
            for f in p["bt"]: print(f"      {f}",flush=True)
            recs.append(p)
        else: print("  ",p,flush=True)
    elif m.get("type")=="error": print("  ERR",m.get("description"),flush=True)
s=frida.get_usb_device(timeout=5).attach(pid)
sc=s.create_script(open("frida/hook_jnistr.js",encoding="utf-8").read());sc.on("message",om);sc.load()
time.sleep(int(sys.argv[1]) if len(sys.argv)>1 else 100);sc.unload();s.detach()
json.dump(recs,open("capture/jni_spade.json","w"));print(f"done {len(recs)}",flush=True)
