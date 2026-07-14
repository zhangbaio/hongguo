# -*- coding: utf-8 -*-
"""运行 intercept_key.js 并传入密文参数, 监听 memcpy/RegisterNatives 输出。"""
import frida, sys, time, subprocess, json, struct

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"

def get_pid():
    out=subprocess.run([ADB,"-s",DEV,"shell","pidof",PKG],capture_output=True,text=True).stdout.strip()
    return int(out.split()[0]) if out else None

def get_cipher_info(tag):
    import re
    def ib(d,s,e):
        o=s
        while o+8<=e:
            sz=struct.unpack(">I",d[o:o+4])[0]; t=d[o+4:o+8]; hs=8
            if sz==1: sz=struct.unpack(">Q",d[o+8:o+16])[0]; hs=16
            elif sz==0: sz=e-o
            yield t,o,sz,hs; o+=sz
    def find(d,p,s=0,e=None):
        if e is None: e=len(d)
        for t,o,sz,hs in ib(d,s,e):
            if t==p[0]: return (o+hs,o+sz) if len(p)==1 else find(d,p[1:],o+hs,o+sz)
    def traks(d):
        mv=find(d,[b"moov"]); return [(o+hs,o+sz) for t,o,sz,hs in ib(d,*mv) if t==b"trak"]
    def u32(d,o): return struct.unpack(">I",d[o:o+4])[0]
    def hdlr(d,tr): h=find(d,[b"mdia",b"hdlr"],*tr); return d[h[0]+8:h[0]+12]
    def samp0(d,tr):
        s,e=find(d,[b"mdia",b"minf",b"stbl"],*tr)
        stsz=find(d,[b"stsz"],s,e); stco=find(d,[b"stco"],s,e)
        ss=u32(d,stsz[0]+4); sz0=ss if ss else u32(d,stsz[0]+12)
        return u32(d,stco[0]+8), sz0
    KIDMAP={"hit1":"6a1165c8f8818be2b9fb87020002ebeb","hit3":"6a1165c8f8818b04e11464d90002ebeb"}
    d=open(f"capture/ct/{tag}.mp4","rb").read()
    mds=find(d,[b"mdat"])[0]
    vt=[t for t in traks(d) if hdlr(d,t)==b"vide"][0]
    off0,sz0=samp0(d,vt); mo=off0-mds
    cipher_bytes=d[off0:off0+64]
    return cipher_bytes.hex(), sz0, mo, KIDMAP[tag]

def main():
    pid=get_pid()
    if not pid: print("红果没运行"); return
    print(f"attach pid={pid}")
    dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
    session=dev.attach(pid)
    js=open("frida/intercept_key.js",encoding="utf-8").read()
    script=session.create_script(js)
    def on_msg(m,data):
        if m["type"]=="send":
            p=m["payload"]; t=p.get("t","")
            if t in ("CONTENT_KEY_VIA_MEMCPY",): print("[!!!]", json.dumps(p))
            elif t=="memcpy16": print("[memcpy16]",p)
            elif t=="native_method": print("[native]",p)
            elif t in ("mods","info","jni_onload","regnat_err"): print("[info]",p)
        else: print("[ERR]",m.get("description")or m)
    script.on("message",on_msg)
    script.load()
    # 注入密文信息
    for tag in ["hit1","hit3"]:
        cHex,sz,mo,kid=get_cipher_info(tag)
        script.exports_sync.setCipher(tag,cHex,sz,mo,kid) if hasattr(script,"exports_sync") else None
    print("monitoring (60s)... play the video or navigate to trigger decryption")
    time.sleep(60)
    print("done")

if __name__=="__main__":
    main()
