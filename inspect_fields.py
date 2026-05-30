# -*- coding: utf-8 -*-
"""提取搜索/详情响应里所有可用字段"""
import json
from mitmproxy import io, http
FLOW = r"D:\code\hongguo\capture\out\full.flow"

def find(substr, need_code0=True):
    with open(FLOW, "rb") as fp:
        for f in io.FlowReader(fp).stream():
            if isinstance(f, http.HTTPFlow) and substr in f.request.path and f.response:
                try:
                    j = json.loads(f.response.get_text())
                    if not need_code0 or j.get("code") == 0:
                        return j
                except Exception:
                    pass
    return None

def show(d, prefix="", depth=0, maxd=2):
    """打印字段名:值类型/示例"""
    if depth > maxd:
        return
    for k, v in d.items():
        if isinstance(v, dict):
            print(f"{prefix}{k}: (对象)")
            show(v, prefix + "  ", depth + 1, maxd)
        elif isinstance(v, list):
            t = type(v[0]).__name__ if v else "空"
            print(f"{prefix}{k}: [数组x{len(v)} of {t}]")
        else:
            sv = str(v)
            if len(sv) > 60:
                sv = sv[:60] + "..."
            print(f"{prefix}{k}: {sv}")

print("=" * 70)
print("【搜索 search/tab/v —— 每个结果(cell)的字段】")
print("=" * 70)
j = find("/reading/bookapi/search/tab/v")
cell = j["search_tabs"][0]["data"][0]
show(cell, maxd=1)
print("\n  -- video_detail 子字段 --")
if "video_detail" in cell:
    show(cell["video_detail"], "  ", maxd=0)

print("\n" + "=" * 70)
print("【详情 multi_video_detail —— video_data 字段】")
print("=" * 70)
j2 = find("/novel/player/multi_video_detail/v1/")
sid = list(j2["data"].keys())[0]
vd = j2["data"][sid]["video_data"]
show(vd, maxd=0)
print("\n  -- 每集 video_list[] 字段 --")
if vd.get("video_list"):
    show(vd["video_list"][0], "  ", maxd=0)
