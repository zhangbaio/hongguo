# -*- coding: utf-8 -*-
"""全自动触发测试: am start deeplink让app自己打开视频(无人工点击), 看内存是否出现video_model。
用已下载的series(离线可prepare, 绕开网络)。"""
import subprocess, time, sqlite3, frida
ADB=r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"; D="127.0.0.1:16384"; PKG="com.phoenix.read"
def adb(*a): return subprocess.run([ADB,"-s",D]+list(a),capture_output=True,text=True).stdout
def gp(): o=adb("shell","pidof",PKG).strip(); return int(o.split()[0]) if o else None

# 取已下载的 series/video id
conn=sqlite3.connect("capture/series_download_db.sqlite")
rows=conn.execute("SELECT series_id,video_id FROM t_series_download_task LIMIT 3").fetchall()
conn.close()
print("下载的 series/video:", rows)
sid,vid=rows[0]

JS="""
rpc.exports={spades:function(){var c=0;var PAT='73 70 61 64 65 5f 61';
  var rs=Process.enumerateRanges('rw-').filter(function(r){return r.size<64*1024*1024;});
  for(var i=0;i<rs.length;i++){try{c+=Memory.scanSync(rs[i].base,rs[i].size,PAT).length;}catch(e){}}
  return c;}};
"""
def scan_spades():
    pid=gp()
    if not pid: return None,None
    try:
        s=frida.get_device_manager().add_remote_device("127.0.0.1:27042").attach(pid).create_script(JS)
        s.load(); n=s.exports_sync.spades(); s.unload(); return n,pid
    except Exception as e: return f"err:{e}",pid

print("基线(触发前) spade_a:", scan_spades())

# 尝试多种 deeplink 格式让 app 自动打开
deeplinks=[
    f"dragon8662://short_series?series_id={sid}&video_id={vid}",
    f"dragon8662://short_series?series_id={sid}",
    f"dragon8662://main?tab=bookshelf",
    f"dragon8662://reading?book_id={sid}&video_id={vid}",
    f"dragon8662://video?series_id={sid}&video_id={vid}&index=0",
]
for dl in deeplinks:
    print(f"\n>>> am start: {dl}")
    out=adb("shell","am","start","-a","android.intent.action.VIEW","-d",dl)
    print("  ", out.strip()[:120].replace("\n"," "))
    time.sleep(6)
    n,pid=scan_spades()
    print(f"   spade_a count={n} (pid={pid})")
    if isinstance(n,int) and n>0:
        print(f"   *** 自动触发成功! deeplink让app加载了video_model(无人工点击) ***")
        break
print("\n结论: 若上面有 spade_a>0 → 全自动触发可行(无需手动播放)")
