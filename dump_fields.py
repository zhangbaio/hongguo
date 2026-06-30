#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""dump 搜索/筛选/浏览接口原始字段, 对比 hongguo.py 已解析字段, 找新增/未用字段。"""
import json, hongguo as H

SEARCH_PARSED = {"book_id","copyright","cover","episode_cnt","play_cnt","rec_text","score",
    "search_high_light","search_result_id","series_cover","series_intro","series_play_cnt",
    "series_title","text","title","video_data","video_detail"}
BROWSE_PARSED = {"series_id","title","episode_cnt","score","play_cnt","cover","copyright",
    "category_schema","video_desc"}
FILTER_ROW_PARSED = {"type","row_name","selection_type","items"}
FILTER_ITEM_PARSED = {"selector_item_id","show_name"}

def mark(keys, parsed):
    return {"已解析": sorted(k for k in keys if k in parsed),
            "★未解析(新增候选)": sorted(k for k in keys if k not in parsed)}

print("="*70)
print("【1】搜索 /reading/bookapi/search/tab/v")
j = H.api("GET", "/reading/bookapi/search/tab/v",
          extra_query={"query":"修仙","tab_name":"feed","search_source":"1","offset":"0","count":"0","use_correct":"true"})
print("  顶层 keys:", sorted(j.keys()))
tab = (j.get("search_tabs") or [{}])[0]
print("  tab keys:", sorted(tab.keys()))
cells = tab.get("data") or []
if cells:
    c = cells[0]
    print("  cell 字段对比:", json.dumps(mark(c.keys(), SEARCH_PARSED), ensure_ascii=False))
    vd = c.get("video_detail") or {}
    if vd: print("  cell.video_detail keys:", sorted(vd.keys()))
    vdata = c.get("video_data"); vdata = vdata[0] if isinstance(vdata,list) and vdata else (vdata or {})
    if isinstance(vdata,dict) and vdata: print("  cell.video_data[0] keys:", sorted(vdata.keys()))

print("="*70)
print("【2】筛选 /reading/distribution/category/landpage/v (漫剧 selector_panel)")
body = {"filter_ids":"","req_scene":"comic_series","offset":0,"limit":1,"need_selector_panel":True,
        "req_type":"default","client_req_type":3,"select_items":{"category_dim_epoch":[],"online_time":[],
        "gender":[],"category_dim_theme":[],"category_dim_role":[],"sort":[],"creation_status":[]}}
jf = H.api("POST","/reading/distribution/category/landpage/v", body=body)
print("  data keys:", sorted((jf.get("data") or {}).keys()))
rows = (jf.get("data") or {}).get("selector_rows") or []
if rows:
    print("  row 字段对比:", json.dumps(mark(rows[0].keys(), FILTER_ROW_PARSED), ensure_ascii=False))
    its = rows[0].get("items") or []
    if its: print("  row.item 字段对比:", json.dumps(mark(its[0].keys(), FILTER_ITEM_PARSED), ensure_ascii=False))

print("="*70)
print("【3】浏览 /reading/distribution/category/landpage/v (漫剧 内容)")
bodyb = {"filter_ids":"","req_scene":"comic_series","offset":0,"need_selector_panel":False,"limit":6,
         "select_items":{"sort":["online_time"]},"session_id":"","req_type":"only_content","client_req_type":3}
jb = H.api("POST","/reading/distribution/category/landpage/v", body=bodyb)
print("  data keys:", sorted((jb.get("data") or {}).keys()))
items = (jb.get("data") or {}).get("video_data") or []
if items:
    print("  item 字段对比:", json.dumps(mark(items[0].keys(), BROWSE_PARSED), ensure_ascii=False))
