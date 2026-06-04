# -*- coding: utf-8 -*-
"""红果全自动纯离线下载器: 搜索/榜单 → 选集 → API 取 spade+直链 → 本地 unwrap → 下载 → 解密。

链路: hongguo API(签名) 取 video_model(main_url + encrypt_info.spade_a)
      → unwrap_spade 纯算法出 content key(无 KEK)
      → 下载 CDN 密文 → senc 读 base_iv → AES-128-CTR 解密 → 明文 mp4。

解密本身纯离线(无 app/frida); 仅"调 API 取 spade+直链"一步需签名(SIGN_SERVER 或 frida oracle)。

用法:
  python offline_dl.py search "剧名"
  python offline_dl.py rank [recommend|hot|new]
  python offline_dl.py series <series_id> [集号范围: 1-5 / 3 / all(默认)]
  python offline_dl.py vid <vid> [输出文件名]
"""
import sys, os, json, re
try:
    sys.stdout.reconfigure(encoding="utf-8")
except Exception:
    pass

ROOT = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, os.path.join(ROOT, "frida"))  # offline_decrypt/unwrap_spade/oracle/decutil
import hongguo as H                                # Windows 根目录的 API 客户端
from offline_decrypt import offline_decrypt

OUT = os.path.join(ROOT, "downloads")


def _video_model(vid):
    """取单个 vid 的完整 video_model(含 encrypt_info.spade_a, 各清晰度 main_url)。"""
    body = {"biz_param": {"detail_page_version": 0, "device_level": 3, "disable_digg_stat": False,
                          "disable_video_relate_book": False, "need_all_video_definition": True,
                          "need_mp4_align": False, "use_os_player": False, "use_server_dns": False,
                          "video_platform": 1024},
            "mixed_video_id_map": {"1": [str(vid)]}}
    d = H.api("POST", "/novel/player/multi_video_model/v1/", body=body).get("data", {})
    v = d.get(str(vid)) or (list(d.values())[0] if d else None)
    if not v or not v.get("video_model"):
        return None
    return json.loads(v["video_model"])


def _best_track(vm):
    """选码率最高(size 最大)的清晰度。"""
    best = None
    for it in vm.get("video_list", []):
        sz = (it.get("video_meta") or {}).get("size", 0) or 0
        if best is None or sz > best[0]:
            best = (sz, it)
    return best[1] if best else None


def dl_vid(vid, name=None):
    os.makedirs(OUT, exist_ok=True)
    vm = _video_model(vid)
    if not vm:
        print(f"[X] {vid}: 无 video_model"); return None
    tr = _best_track(vm)
    if not tr:
        print(f"[X] {vid}: 无 video_list"); return None
    url = tr["main_url"]
    enc = tr.get("encrypt_info") or {}
    meta = tr.get("video_meta") or {}
    name = H.sanitize(name or str(vid))
    out = os.path.join(OUT, name + ".mp4")
    if os.path.exists(out) and os.path.getsize(out) > 0:
        print(f"[=] 已存在, 跳过: {out}"); return out
    print(f"[*] {name}  [{meta.get('definition')}, {(meta.get('size') or 0)//1024}KB]")
    if not enc.get("encrypt"):
        print("    未加密, 直接下载"); H.download_file(url, out); return out
    ct = os.path.join(OUT, name + ".enc.mp4")
    print("    下载密文 ...")
    H.download_file(url, ct)
    r = offline_decrypt(enc.get("spade_a"), ct, out)
    if r and os.path.exists(out) and os.path.getsize(out) > 0:
        try: os.remove(ct)
        except OSError: pass
    return r


def dl_series(series_id, rng="all"):
    meta, eps = H.get_episodes(series_id)
    title = H.sanitize(meta["title"])
    print(f"《{title}》共 {len(eps)} 集 | {meta['status']}")
    if rng != "all":
        m = re.match(r"(\d+)-(\d+)", rng)
        if m:
            lo, hi = int(m.group(1)), int(m.group(2))
            eps = [e for e in eps if lo <= (e["index"] or 0) <= hi]
        elif rng.isdigit():
            eps = [e for e in eps if (e["index"] or 0) == int(rng)]
    ok = 0
    for e in eps:
        try:
            if dl_vid(e["vid"], f"{title}_第{(e['index'] or 0):03d}集"):
                ok += 1
        except Exception as ex:
            print(f"  第{e['index']}集 失败: {ex}")
    print(f"\n完成 {ok}/{len(eps)} 集 -> {OUT}")


def main():
    if len(sys.argv) < 2:
        print(__doc__); return
    cmd = sys.argv[1]
    if cmd == "search":
        for r in H.search(sys.argv[2]):
            print(f"  {r['series_id']}  [{r['episode_cnt']}集] ★{r.get('score','')}  {r['title']}")
    elif cmd == "rank":
        board = sys.argv[2] if len(sys.argv) > 2 else "recommend"
        for r in H.rank(board):
            print(f"  {r['rank']:>2}. {r['series_id']}  [{r['episode_cnt']}集]  {r['title']}")
    elif cmd == "series":
        dl_series(sys.argv[2], sys.argv[3] if len(sys.argv) > 3 else "all")
    elif cmd == "vid":
        dl_vid(sys.argv[2], sys.argv[3] if len(sys.argv) > 3 else None)
    else:
        print(__doc__)


if __name__ == "__main__":
    main()
