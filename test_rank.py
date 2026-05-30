# -*- coding: utf-8 -*-
"""测试漫剧榜单接口 bookmall/cell/change"""
import uuid, json
import hongguo as H

SUBS = {
    "推荐榜": "comic_series_hot_play",
    "热播榜": "comic_series_hot_rank",
    "新剧榜": "comic_series_new_rank",
}

for name, sub in SUBS.items():
    q = {
        "cell_id": "7470092475068071998",
        "tab_type": "26",
        "client_req_type": "2",
        "client_template": "2",
        "screen_width_px": "1350",
        "selected_items": "comic_series_rank",
        "sub_selected_items": sub,
        "session_uuid": str(uuid.uuid4()),
    }
    try:
        j = H.api("GET", "/reading/bookapi/bookmall/cell/change/v", extra_query=q)
    except Exception as e:
        print(f"[{name}] 调用失败: {e}"); continue
    print("=" * 60)
    print(f"【{name}】 code={j.get('code')} msg={j.get('message')}")
    # 探索结构: 找剧集列表
    data = j.get("data", {})
    print("data keys:", list(data.keys()) if isinstance(data, dict) else type(data))
    # 常见: data.cell_view.book_list / data.book_data
    txt = json.dumps(j, ensure_ascii=False)
    # 找剧名样本
    import re
    titles = re.findall(r'"book_name":"([^"]+)"', txt) or re.findall(r'"title":"([^"]+)"', txt) or re.findall(r'"series_title":"([^"]+)"', txt)
    print("剧名样本(前8):", titles[:8])
    # 保存一份完整响应供分析
    open(f"capture/rank_{sub}.json","w",encoding="utf-8").write(json.dumps(j,ensure_ascii=False,indent=1))
