# -*- coding: utf-8 -*-
"""分析 capture/out/flows.jsonl，提取红果接口。
用法:
  python analyze.py            # 概览：API 接口路径汇总
  python analyze.py <关键词>   # 查看匹配关键词的完整请求/响应
"""
import json
import sys
import os

FLOWS = os.path.join(os.path.dirname(os.path.abspath(__file__)), "capture", "out", "flows.jsonl")

# 只关心红果业务域名，过滤掉 MuMu/netease 噪音
BIZ = ("snssdk.com", "bytedance", "byteimg", "fqnovel", "pstatp", "amemv",
       "reading", "novel", "ixigua", "vod", "volces")


def load():
    rows = []
    with open(FLOWS, encoding="utf-8") as f:
        for line in f:
            line = line.strip()
            if not line:
                continue
            try:
                rows.append(json.loads(line))
            except Exception:
                continue
    return rows


def is_biz(r):
    return any(b in r.get("host", "") for b in BIZ)


def overview(rows):
    biz = [r for r in rows if is_biz(r)]
    print(f"总流 {len(rows)}，红果业务流 {len(biz)}\n")
    # 按 host+path(去query) 聚合
    seen = {}
    for r in biz:
        path = r["path"].split("?")[0]
        key = f'{r["method"]:4} {r["host"]}{path}'
        d = seen.setdefault(key, {"n": 0, "ctype": r.get("resp_ctype", ""), "tag": r.get("tag", "")})
        d["n"] += 1
        if r.get("tag"):
            d["tag"] = r["tag"]
    for k in sorted(seen, key=lambda x: -seen[x]["n"]):
        d = seen[k]
        tag = f'  <<<{d["tag"]}' if d["tag"] else ""
        print(f'{d["n"]:3}x  {k}   [{d["ctype"].split(";")[0]}]{tag}')


def detail(rows, kw):
    biz = [r for r in rows if kw.lower() in (r["url"] + (r.get("resp_body") or "")).lower()]
    print(f"匹配 '{kw}' 的流: {len(biz)}\n")
    for i, r in enumerate(biz[:8]):
        print("=" * 80)
        print(f'[{i}] {r["method"]} {r["url"]}')
        print(f'  状态:{r["status"]}  类型:{r.get("resp_ctype")}  大小:{r.get("resp_size")}')
        if r.get("req_body"):
            print(f'  请求体: {r["req_body"][:500]}')
        body = r.get("resp_body")
        if body:
            try:
                j = json.loads(body)
                print("  响应(JSON结构):")
                print("    " + json.dumps(j, ensure_ascii=False, indent=2)[:2500])
            except Exception:
                print(f'  响应(文本): {body[:800]}')


if __name__ == "__main__":
    rows = load()
    if len(sys.argv) > 1:
        detail(rows, sys.argv[1])
    else:
        overview(rows)
