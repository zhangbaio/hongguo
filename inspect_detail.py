# -*- coding: utf-8 -*-
"""分析 multi_video_detail 响应结构,找剧集vid列表所在字段"""
import json
from mitmproxy import io, http
FLOW = r"D:\code\hongguo\capture\out\full.flow"

resp = None
for_req = None
with open(FLOW, "rb") as fp:
    for f in io.FlowReader(fp).stream():
        if isinstance(f, http.HTTPFlow) and "multi_video_detail" in f.request.path and f.response:
            try:
                j = json.loads(f.response.get_text())
                if j.get("code") == 0:
                    resp = j; for_req = f.request.get_text(); break
            except Exception:
                pass

print("请求体:", for_req)
data = resp["data"]
sid = list(data.keys())[0]
vd = data[sid].get("video_data", {})
print("series_id:", sid)
print("video_data 顶层keys:", list(vd.keys()))

# 找数组类型字段(剧集列表通常是数组)
for k, v in vd.items():
    if isinstance(v, list) and v and isinstance(v[0], dict):
        print(f"\n>>> 数组字段 '{k}' 长度={len(v)}, 元素keys: {list(v[0].keys())[:25]}")
        # 看是否含 vid
        if any("vid" in str(kk).lower() or kk == "item_id" for kk in v[0].keys()):
            print(f"    第1集示例: ", {kk: v[0][kk] for kk in v[0] if kk in ('vid','item_id','title','episode_index','episode_title','order','duration')})
            print(f"    末集示例: ", {kk: v[-1][kk] for kk in v[-1] if kk in ('vid','item_id','title','episode_index','episode_title','order','duration')})
