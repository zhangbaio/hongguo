# -*- coding: utf-8 -*-
"""从数据库提取 720p URL 和 file_id (bt≈500-1000, ds=4 or cs=4)"""
import sqlite3, re, json

conn=sqlite3.connect("capture/series_download_db.sqlite")
rows=conn.execute("SELECT video_id, video_model FROM t_series_video_model").fetchall()
conn.close()

TARGET_KID="6960e8ebf8818bad6286db200002ebeb"
for vid, vm_str in rows:
    if not vm_str or TARGET_KID not in vm_str: continue
    # 找所有 codec_type/quality/main_url 条目
    print(f"video_id={vid}")
    for m in re.finditer(r'"main_url"\s*:\s*"([^"]+)"[^}]*?"file_id"\s*:\s*"([^"]+)"[^}]*?"size"\s*:\s*(\d+)[^}]*?"codec_type"\s*:\s*"([^"]+)"', vm_str):
        url,fid,size,codec = m.groups()
        print(f"  file_id={fid} size={size} codec={codec} url={url[:80]}")
    # 备用: 找 bt= 参数
    for m in re.finditer(r'"main_url"\s*:\s*"(https://[^"]+)"', vm_str):
        url=m.group(1)
        bt_m=re.search(r'bt=(\d+)',url)
        ds_m=re.search(r'ds=(\d+)',url)
        fid_m=re.search(r'"file_id"\s*:\s*"([a-f0-9]+)"', vm_str[max(0,m.start()-200):m.start()+200])
        sz_m=re.search(r'"size"\s*:\s*(\d+)', vm_str[max(0,m.start()-200):m.start()+200])
        bt=bt_m.group(1) if bt_m else '?'
        ds=ds_m.group(1) if ds_m else '?'
        fid=fid_m.group(1) if fid_m else '?'
        sz=sz_m.group(1) if sz_m else '?'
        print(f"  bt={bt} ds={ds} sz={sz} fid={fid[:8]} url={url[:80]}")
