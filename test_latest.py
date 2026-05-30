# -*- coding: utf-8 -*-
"""测试筛选/最新上架接口 landpage,探索响应结构(找上架日期字段)"""
import os
os.environ.pop("SIGN_SERVER", None)  # 强制本地frida(当前app pid)
import json
import hongguo as H

GENRE = {"短剧": ("default", "short_play"), "漫剧": ("comic_series", "comic_series"),
         "AI短剧": ("ai_series", "ai_series")}

name = "短剧"
scene, genre = GENRE[name]
body = {"filter_ids": "", "req_scene": scene, "offset": 0, "need_selector_panel": False,
        "limit": 18, "select_items": {"category_dim_epoch": [], "online_time": [], "gender": [],
        "category_dim_role": [], "genre": [genre], "sort": ["online_time"], "category_dim_theme": []},
        "session_id": "", "req_type": "only_content", "client_req_type": 3}

j = H.api("POST", "/reading/distribution/category/landpage/v", body=body)
print("code:", j.get("code"), j.get("message"))
data = j.get("data", {})
print("data keys:", list(data.keys()) if isinstance(data, dict) else type(data))
# 找列表
import json as J
txt = J.dumps(data, ensure_ascii=False)
open("capture/landpage_sample.json", "w", encoding="utf-8").write(J.dumps(j, ensure_ascii=False, indent=1))
# 探索结构
def walk(d, path=""):
    if isinstance(d, dict):
        for k, v in d.items():
            if isinstance(v, list) and v and isinstance(v[0], dict):
                print(f"数组 {path}.{k}: {len(v)}个, 元素keys: {list(v[0].keys())[:25]}")
                # 找时间/标题字段
                samp = v[0]
                tf = {kk: samp[kk] for kk in samp if any(t in kk.lower() for t in ('time', 'title', 'name', 'id', 'date'))}
                print("   样本时间/标题字段:", tf)
                return
            walk(v, path + "." + k)
walk(data)
