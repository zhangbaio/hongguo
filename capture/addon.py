# -*- coding: utf-8 -*-
"""
红果短剧抓包 addon —— 配合 mitmdump 使用
  mitmdump -s addon.py --listen-port 8080

功能:
  1. 实时在控制台打印每条请求 (方法/主机/路径/状态/类型/大小)，并高亮可能的
     搜索 / 详情 / 视频 接口。
  2. 全量请求+响应落盘到 flows.jsonl (每行一条 JSON，便于后续脚本分析)。
  3. 命中 视频 (mp4/m3u8/video) 的流，URL 单独记到 video_urls.txt。
"""
import json
import os
import time
from datetime import datetime

OUT_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)), "out")
os.makedirs(OUT_DIR, exist_ok=True)
FLOWS = os.path.join(OUT_DIR, "flows.jsonl")
VIDEOS = os.path.join(OUT_DIR, "video_urls.txt")

# 噪音域名（统计/监控/日志），不打印不存档，避免刷屏
NOISE = (
    "beacon.", "btrace.", "/monitor", "/log/", "log.snssdk", "mon.snssdk",
    "applog", "/service/2/", "compliance", "/teen/", "frontier", "mssdk",
    "/settings/", "geckox", "gecko.", "libra", "/log_settings", "/device_register",
)

# 关键词 -> 接口分类高亮
HINTS = {
    "搜索 SEARCH": ("search", "/query", "suggest", "discover"),
    "详情 DETAIL": ("detail", "/info", "episode", "video_detail", "book_info",
                    "play_info", "playinfo", "videoinfo", "item_info", "/series"),
    "视频 VIDEO":  (".mp4", ".m3u8", "/play/", "videoplay", "vod", "media"),
    "列表 FEED":   ("feed", "/list", "category", "rank", "recommend", "channel"),
}

VIDEO_MARKERS = (".mp4", ".m3u8", ".ts?", "video/")


def _is_noise(url: str) -> bool:
    u = url.lower()
    return any(n in u for n in NOISE)


def _classify(url: str, ctype: str) -> str:
    u = url.lower()
    tags = []
    for label, kws in HINTS.items():
        if any(k in u for k in kws):
            tags.append(label)
    if "video/" in ctype.lower():
        if "视频 VIDEO" not in tags:
            tags.append("视频 VIDEO")
    return ",".join(tags)


def response(flow):
    try:
        req = flow.request
        resp = flow.response
        url = req.pretty_url
        if _is_noise(url):
            return

        ctype = resp.headers.get("content-type", "")
        tag = _classify(url, ctype)

        # 控制台实时输出
        ts = datetime.now().strftime("%H:%M:%S")
        size = len(resp.content) if resp.content else 0
        flag = f"  <<< {tag}" if tag else ""
        print(f"[{ts}] {req.method:4} {resp.status_code} {req.host}{req.path[:80]} "
              f"({ctype.split(';')[0]}, {size}B){flag}")

        # 视频直链单独记
        low = url.lower()
        if any(m in low for m in VIDEO_MARKERS) or "video/" in ctype.lower():
            with open(VIDEOS, "a", encoding="utf-8") as f:
                f.write(f"{datetime.now().isoformat()}\t{req.method}\t{url}\n")

        # 全量落盘 (视频/图片/字体只记URL不记体；其余都记，二进制用base64)
        import base64
        body_text = None
        body_b64 = None
        skip = ("video/" in ctype.lower() or "image/" in ctype.lower() or "font" in ctype.lower())
        if size and size < 3_000_000 and not skip:
            try:
                body_text = resp.get_text(strict=True)  # 严格解码,失败则二进制
            except Exception:
                body_text = None
            if body_text is None:
                try:
                    body_b64 = base64.b64encode(resp.content).decode()  # protobuf等二进制
                except Exception:
                    body_b64 = None

        rec = {
            "time": datetime.now().isoformat(),
            "method": req.method,
            "url": url,
            "host": req.host,
            "path": req.path,
            "status": resp.status_code,
            "req_headers": dict(req.headers),
            "req_body": req.get_text(strict=False) if req.content and len(req.content) < 100_000 else None,
            "resp_ctype": ctype,
            "resp_size": size,
            "resp_body": body_text,
            "resp_body_b64": body_b64,
            "tag": tag,
        }
        with open(FLOWS, "a", encoding="utf-8") as f:
            f.write(json.dumps(rec, ensure_ascii=False) + "\n")
    except Exception as e:
        print(f"[addon error] {e}")


TLSLOG = os.path.join(OUT_DIR, "tls.log")


def _tlslog(msg):
    line = f"{datetime.now().strftime('%H:%M:%S')} {msg}"
    print(line)
    with open(TLSLOG, "a", encoding="utf-8") as f:
        f.write(line + "\n")


def tls_clienthello(data):
    # 每个TLS连接的目标域名(SNI) —— 解密与否都会触发
    try:
        sni = data.client_hello.sni
        addr = data.context.server.address
        _tlslog(f"[TLS-Hello] SNI={sni} server={addr}")
    except Exception as e:
        _tlslog(f"[TLS-Hello err] {e}")


def tls_failed_client(data):
    # 客户端拒绝我们的证书 = SSL Pinning 嫌疑
    try:
        sni = getattr(data.client_hello, "sni", None) if hasattr(data, "client_hello") else None
        addr = data.context.server.address
        _tlslog(f"[TLS-FAILED/可能pinning] SNI={sni} server={addr}")
    except Exception as e:
        _tlslog(f"[TLS-FAILED err] {e}")


def request(flow):
    # 请求一进来(已解密)就记，证明解密成功
    try:
        _tlslog(f"[REQ] {flow.request.method} {flow.request.host}{flow.request.path[:70]}")
    except Exception:
        pass


def load(loader):
    print("=" * 70)
    print(" 红果短剧抓包已启动。请在模拟器里操作 App，这里会实时打印接口。")
    print(f" 全量存档: {FLOWS}")
    print(f" 视频直链: {VIDEOS}")
    print("=" * 70)
