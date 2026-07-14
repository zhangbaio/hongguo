# -*- coding: utf-8 -*-
"""查询下载数据库, 找 spade_a/kid/video_model 等关键字段"""
import sqlite3, json, re

print("=== TTVideoEngine_download_database_v01 ===")
conn = sqlite3.connect("capture/TTVideoEngine_dl.sqlite")
for row in conn.execute("SELECT key, value FROM TTVideoEngine_download_database_v01 LIMIT 5"):
    k = row[0]; v = row[1]
    try:
        d = json.loads(v)
        print(f"key={k}")
        # 递归搜索 spade_a/kid/encrypt
        def find_keys(obj, path=""):
            if isinstance(obj, dict):
                for kk, vv in obj.items():
                    if any(x in kk.lower() for x in ["spade","kid","encrypt","key","secret"]):
                        print(f"  {path}.{kk} = {str(vv)[:100]}")
                    find_keys(vv, path+"."+kk)
            elif isinstance(obj, list):
                for i,vv in enumerate(obj[:3]):
                    find_keys(vv, path+f"[{i}]")
            elif isinstance(obj, str) and len(obj)>20:
                if any(x in path.lower() for x in ["spade","kid","key","secret","crypt"]):
                    print(f"  {path} = {obj[:120]}")
        find_keys(d)
    except: print(f"  key={k} val={v[:80]}")

print("\n=== series_download_db: t_series_video_model ===")
conn2 = sqlite3.connect("capture/series_download_db.sqlite")
for row in conn2.execute("SELECT video_id, series_id, video_model FROM t_series_video_model LIMIT 3"):
    vid, sid, vm_str = row
    print(f"\nvideo_id={vid} series_id={sid}")
    if vm_str:
        try:
            vm = json.loads(vm_str)
            def show(obj, depth=0, path=""):
                if depth>6: return
                if isinstance(obj, dict):
                    for kk,vv in obj.items():
                        np=path+"."+kk
                        if any(x in kk.lower() for x in ["spade","kid","encrypt","key","crypt","secret"]):
                            print(f"  {'  '*depth}{kk}: {str(vv)[:150]}")
                        show(vv, depth+1, np)
                elif isinstance(obj, list):
                    for i,vv in enumerate(obj[:5]): show(vv, depth+1, path+f"[{i}]")
            show(vm)
        except Exception as e:
            # 可能是双重编码
            try:
                vm2 = json.loads(json.loads(vm_str))
                print("  double-encoded JSON")
            except:
                print(f"  vm_str: {vm_str[:200]}")
            # 正则搜索
            for pat in ["spade_a","kid","encryption_method","encrypt_info"]:
                m = re.search(f'"{pat}"\\s*:\\s*"?([^",}}\\]{{]{{0,150}})', vm_str)
                if m: print(f"  regex {pat} = {m.group(1)[:120]}")
