# -*- coding: utf-8 -*-
"""从 full.flow 提取设备参数和会话凭证 → config.json (下载器用)"""
import json
from urllib.parse import urlparse, parse_qsl
from mitmproxy import io, http
FLOW = r"D:\code\hongguo\capture\out\full.flow"

# 设备/会话相关的 query 参数(稳定,跨请求不变)
DEVICE_KEYS = {
    "iid", "device_id", "ac", "channel", "aid", "app_name", "version_code",
    "version_name", "device_platform", "os", "ssmix", "device_type", "device_brand",
    "language", "os_api", "os_version", "manifest_version_code", "resolution", "dpi",
    "update_version_code", "host_abi", "dragon_device_type", "pv_player",
    "compliance_status", "need_personal_recommend", "player_so_load",
    "is_android_pad_screen", "rom_version", "cdid", "klink_egdi",
}
SESSION_HEADERS = ("cookie", "x-tt-token", "user-agent", "passport-sdk-version",
                   "sdk-version", "x-tt-store-region", "x-tt-store-region-src")

base_query = {}
sess = {}
with open(FLOW, "rb") as fp:
    for f in io.FlowReader(fp).stream():
        if not isinstance(f, http.HTTPFlow):
            continue
        if "fqnovel.com" not in (f.request.host_header or f.request.host):
            continue
        q = dict(parse_qsl(urlparse(f.request.pretty_url).query))
        for k in DEVICE_KEYS:
            if k in q and q[k]:
                base_query[k] = q[k]
        for h in SESSION_HEADERS:
            v = f.request.headers.get(h)
            if v:
                sess[h] = v

cfg = {"base_query": base_query, "session_headers": sess,
       "api_host": "api5-normal-sinfonlinea.fqnovel.com"}
with open(r"D:\code\hongguo\config.json", "w", encoding="utf-8") as fp:
    json.dump(cfg, fp, ensure_ascii=False, indent=2)
print("已写 config.json")
print("device_id:", base_query.get("device_id"), "iid:", base_query.get("iid"))
print("base_query 参数数:", len(base_query))
print("session headers:", list(sess.keys()))
print("x-tt-token长度:", len(sess.get("x-tt-token", "")))
