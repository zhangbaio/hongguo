# -*- coding: utf-8 -*-
"""搜索"北派寻宝笔记", 拿到第1集的 video_model(含 kid/spade_a/main_url)"""
import sys; sys.path.insert(0, '.')
import hongguo, json

print("searching...")
results = hongguo.search("北派寻宝笔记")
if not results:
    print("no results"); exit(1)

for r in results[:3]:
    sid = r.get("series_id") or r.get("id")
    title = r.get("title","")
    print(f"  series_id={sid} title={title[:40]}")

# 拿第一个结果的剧集
sid = results[0].get("series_id") or results[0].get("id")
print(f"\ngetting episodes for {sid}...")
eps = hongguo.get_episodes(sid)
if not eps:
    print("no episodes"); exit(1)

ep1 = eps[0]
vid = ep1.get("video_id") or ep1.get("id")
print(f"ep1 video_id={vid}")

print(f"\ngetting video_model for {vid}...")
vm = hongguo.get_video_urls(vid, series_id=sid)
if vm:
    vl = vm.get("video_list", [])
    for v in vl[:3]:
        ei = v.get("encrypt_info",{})
        print(f"  definition={v.get('definition')} codec={v.get('codec_type')}")
        print(f"    kid={ei.get('kid')}")
        print(f"    spade_a={ei.get('spade_a')}")
        print(f"    main_url={v.get('main_url','')[:80]}")
        print(f"    size={v.get('size')}")
    json.dump({"vid":vid, "series_id":sid, "video_list": vl}, open("capture/bpxb_ep1.json","w"), indent=2)
    print("saved capture/bpxb_ep1.json")
