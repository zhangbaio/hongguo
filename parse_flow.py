# -*- coding: utf-8 -*-
"""用 mitmproxy 官方 FlowReader 解析 full.flow，提取红果核心接口。
用法:
  python parse_flow.py list                # 列出所有内容接口(去重)
  python parse_flow.py dump <关键词>        # 导出匹配接口的完整请求+响应
"""
import sys, os, json
from mitmproxy import io, http
from urllib.parse import unquote

FLOW = os.path.join(os.path.dirname(os.path.abspath(__file__)), "capture", "out", "full.flow")

NOISE = ("applog", "rtlog", "/monitor", "/log/", "bsync", "beacon", "btrace",
         "netease", "mumu", "163.com", "/service/2/app_log", "dig.bdurl",
         "gecko", ".heic", ".css", ".js", "/settings/", "mssdk", "/ri/report")

CONTENT = ("fqnovel.com", "snssdk.com", "qznovelvod", "novelvod")


def host_of(f):
    return f.request.host_header or f.request.host


def iter_flows():
    with open(FLOW, "rb") as fp:
        for f in io.FlowReader(fp).stream():
            if isinstance(f, http.HTTPFlow):
                yield f


def is_interesting(f):
    url = f.request.pretty_url.lower()
    h = host_of(f).lower()
    if any(n in url or n in h for n in NOISE):
        return False
    return any(c in h for c in CONTENT) or "/reading/" in url or "/novel/player/" in url


def body_text(msg):
    if not msg or not msg.content:
        return None
    try:
        return msg.get_text(strict=False)
    except Exception:
        return f"<binary {len(msg.content)}B>"


def cmd_list():
    seen = {}
    for f in iter_flows():
        if not is_interesting(f):
            continue
        p = f.request.path.split("?")[0]
        key = f"{f.request.method} {p}"
        d = seen.setdefault(key, {"n": 0, "status": None, "ct": "", "host": host_of(f)})
        d["n"] += 1
        if f.response:
            d["status"] = f.response.status_code
            d["ct"] = f.response.headers.get("content-type", "")
    for k in sorted(seen, key=lambda x: -seen[x]["n"]):
        d = seen[k]
        print(f'[{d["status"]}] {d["n"]:2}x {k}  ({d["ct"].split(";")[0]})  @{d["host"]}')


def cmd_dump(kw):
    n = 0
    for f in iter_flows():
        if not is_interesting(f):
            continue
        if kw.lower() not in f.request.pretty_url.lower():
            # 也匹配响应体
            rb = body_text(f.response) or ""
            if kw.lower() not in rb.lower():
                continue
        n += 1
        print("=" * 90)
        print(f"{f.request.method} {f.request.pretty_url}")
        print(f"Host: {host_of(f)}")
        # 关键请求头
        for hk in ("content-type", "x-argus", "x-gorgon", "x-khronos", "x-ladon", "cookie", "user-agent"):
            v = f.request.headers.get(hk)
            if v:
                print(f"  {hk}: {v[:120]}")
        rqb = body_text(f.request)
        if rqb:
            print(f"--- 请求体 ({len(rqb)}B) ---\n{rqb[:1500]}")
        if f.response:
            print(f"--- 响应 {f.response.status_code} ({f.response.headers.get('content-type','')}) ---")
            rb = body_text(f.response)
            if rb:
                try:
                    j = json.loads(rb)
                    print(json.dumps(j, ensure_ascii=False, indent=1)[:4000])
                except Exception:
                    print(rb[:2000])
        if n >= 6:
            print(f"\n...(只显示前6条匹配)")
            break
    print(f"\n共匹配 {n} 条")


if __name__ == "__main__":
    if len(sys.argv) >= 2 and sys.argv[1] == "list":
        cmd_list()
    elif len(sys.argv) >= 3 and sys.argv[1] == "dump":
        cmd_dump(sys.argv[2])
    else:
        print(__doc__)
