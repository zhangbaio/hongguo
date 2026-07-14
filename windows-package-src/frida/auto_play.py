# -*- coding: utf-8 -*-
"""
自动触发视频播放 + MediaCodec 明文抓取:
1. 启动 Frida hook (mc_all.js)
2. 同时用 adb deeplink 触发特定视频播放
3. 收集明文帧
"""
import subprocess, time, frida, struct, json, os

ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; DEV="127.0.0.1:16384"; PKG="com.phoenix.read"

def adb(*args):
    return subprocess.run([ADB,"-s",DEV]+list(args),capture_output=True,text=True).stdout.strip()

def get_pid():
    out=adb("shell","pidof",PKG); return int(out.split()[0]) if out else None

# 从下载数据库取 series_id 和 video_id
def get_series_info():
    try:
        import sqlite3
        conn=sqlite3.connect("capture/series_download_db.sqlite")
        rows=conn.execute("SELECT series_id,video_id FROM t_series_video_model LIMIT 1").fetchall()
        conn.close()
        if rows: return rows[0]
    except: pass
    return ("7593365719165701145","7593367765310786622")

def trigger_playback(series_id, video_id):
    """尝试多种 deeplink 格式触发播放"""
    urls=[
        f"dragon8662://short_series?series_id={series_id}&index=0",
        f"dragon8662://series?series_id={series_id}&vid={video_id}",
        f"dragon8662://home/short_video?series_id={series_id}",
    ]
    for url in urls:
        print(f"  trying: {url[:80]}")
        r=adb("shell","am","start","-a","android.intent.action.VIEW","-d",url)
        print(f"  result: {r[:100]}")
        time.sleep(1)
        # 检查是否触发了 codec
        pid=get_pid()
        if pid:
            break

# 预创建输出文件
adb("shell","su","-c","rm -f /data/local/tmp/auto_video.h265; touch /data/local/tmp/auto_video.h265; chmod 777 /data/local/tmp/auto_video.h265")

pid=get_pid(); print(f"app pid={pid}")
if not pid: print("app not running"); exit(1)

# 修改 mc_all.js 的输出路径为 auto_video.h265
js=open("frida/mc_all.js",encoding="utf-8").read()
js=js.replace("/data/local/tmp/live_video.h265","/data/local/tmp/auto_video.h265")
js=js.replace("/data/local/tmp/live_audio.aac","/data/local/tmp/auto_audio.aac")

dev=frida.get_device_manager().add_remote_device("127.0.0.1:27042")
session=dev.attach(pid)
script=session.create_script(js)

vbytes=[0]; done=[False]
def on_msg(m,data):
    if m["type"]=="send":
        p=m["payload"]; t=p.get("t","")
        if t=="files_ok": print("[OK] output files opened")
        elif t in ("java_hook","native_hook","info"): print(f"[hook] {p}")
        elif t=="tick":
            vb=p["vBytes"]; vbytes[0]=vb
            print(f"[tick {p['tick']}] vBytes={vb} aBytes={p['aBytes']}")
            if vb>0 and p["tick"]>=2: done[0]=True
        elif t=="done": print(f"[done] vBytes={p['vBytes']}"); done[0]=True
    else: print("[ERR]",m)
script.on("message",on_msg)
script.load()
print("[hook loaded, waiting 2s then triggering playback]")
time.sleep(2)

# 触发播放
sid,vid=get_series_info()
print(f"triggering series_id={sid} video_id={vid}")
trigger_playback(sid,vid)

# 等待抓取
t0=time.time()
while time.time()-t0 < 80 and not done[0]:
    time.sleep(1)

# 拉取文件
print("pulling output...")
out=subprocess.run([ADB,"-s",DEV,"exec-out","su -c 'cat /data/local/tmp/auto_video.h265'"],
                   capture_output=True)
open("capture/auto_plain.h265","wb").write(out.stdout)
print(f"capture/auto_plain.h265: {len(out.stdout)} bytes, vbytes seen={vbytes[0]}")
