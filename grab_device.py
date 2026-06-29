# -*- coding: utf-8 -*-
"""grab→devices.json: 抓运行中红果 app 的当前真实设备身份, 追加进设备池 devices.json。

用途: 设备池需要"服务端认可的合法设备"(随机/离线注册都受 aid-8662 签名墙阻)。
最省力的合法来源 = 让真 app 注册一台, 用本工具 grab 它的设备参数入池。
每注册一台新设备(清数据/多开实例)就跑一次本工具, 池子逐步攒大。

前置: 模拟器/设备已装红果并运行(已过隐私同意), frida-server 在跑。
用法:
  python grab_device.py                 # attach 运行中的红果, 抓一台 → 追加 devices.json
  python grab_device.py --out /path/devices.json
依赖: frida CLI(自带 Java 桥, 勿用 raw create_script), adb。
"""
import sys, os, re, json, time, uuid, base64, tempfile, subprocess, argparse
from urllib.parse import urlparse, parse_qsl

HERE = os.path.dirname(os.path.abspath(__file__))
ADB = os.environ.get("ADB", "adb")
FRIDA = os.environ.get("FRIDA", "frida")
PKG = "com.phoenix.read"
JS = os.path.join(HERE, "frida", "grab_device.js")
# 设备身份需要的字段(query 里) —— 与 devicepool 覆盖字段一致 + 设备绑定字段
ID_FIELDS = ["device_id", "iid", "cdid", "klink_egdi", "device_brand", "device_type",
             "resolution", "os_version", "os_api", "rom_version", "host_abi", "channel",
             "update_version_code", "cdid"]


def _pid():
    out = subprocess.run([ADB, "shell", "pidof", PKG], capture_output=True, text=True, timeout=15).stdout.strip()
    return out.split()[0] if out else None


def grab(timeout=30):
    pid = _pid()
    if not pid:
        print("[!] 红果未运行, 请先启动 app(并过隐私同意)"); return None
    print(f"[*] attach pid={pid}, 等待一条 API 请求(最多 {timeout}s)...")
    # Popen: stdin=PIPE 保持 REPL 不退; 轮询输出文件, 抓到 ###DEVICE### 即 kill
    logf = tempfile.NamedTemporaryFile(mode="w+", suffix=".log", delete=False)
    proc = subprocess.Popen(f'{FRIDA} -U -p {pid} -l "{JS}"', shell=True,
                            stdin=subprocess.PIPE, stdout=logf, stderr=subprocess.STDOUT)
    out = ""
    t0 = time.time()
    while time.time() - t0 < timeout:
        time.sleep(1)
        out = open(logf.name, encoding="utf-8", errors="ignore").read()
        if out.count("###REQ###") >= 4:
            break
    try: proc.terminate()
    except Exception: pass
    try: os.unlink(logf.name)
    except Exception: pass
    blobs = re.findall(r"###REQ###([A-Za-z0-9+/=]+)###END###", out)
    reqs = []
    for b in blobs:
        try: reqs.append(json.loads(base64.b64decode(b)))
        except Exception: pass
    if not reqs:
        print("[!] 未抓到请求(app 空闲?滑动/点进剧再试)。frida 输出尾:")
        print("   ", out.strip().splitlines()[-3:] if out.strip() else "(空)")
        return None
    # 合并所有请求的 query + headers(不同请求带不同字段, 取并集); 设备字段优先 query 再 header
    merged, ua = {}, ""
    for rq in reqs:
        for k, v in parse_qsl(urlparse(rq.get("url", "")).query):
            if v: merged.setdefault(k, v)
        for k, v in (rq.get("headers") or {}).items():
            kl = k.lower()
            if v: merged.setdefault(kl, v)
            if kl == "user-agent" and v and not ua: ua = v
    query = {k: merged[k] for k in ID_FIELDS if k in merged and merged[k]}
    if "device_id" not in query:
        print("[!] 请求里没 device_id"); return None
    # UA: retrofit $init 阶段常无 user-agent → 用设备字段构造自洽 UA
    if not ua and query.get("device_type"):
        build = str(query.get("rom_version", "")).split()[0] or "Build"
        ua = (f"com.phoenix.read/{merged.get('version_code', query.get('update_version_code','72232'))} "
              f"(Linux; U; Android {query.get('os_version','13')}; zh_CN; "
              f"{query['device_type']}; Build/{build};tt-ok/3.12.13.20)")
    print(f"[i] 合并 {len(reqs)} 条请求, 设备字段: {sorted(query)}")
    return {"query": query, "user_agent": ua}


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--out", default=os.path.join(HERE, "devices.json"))
    ap.add_argument("--timeout", type=int, default=30)
    args = ap.parse_args()

    dev = grab(args.timeout)
    if not dev:
        sys.exit(1)
    did = dev["query"]["device_id"]
    pool = []
    if os.path.exists(args.out):
        try: pool = json.load(open(args.out, encoding="utf-8"))
        except Exception: pool = []
    # 去重(按 device_id)
    if any(d.get("query", {}).get("device_id") == did for d in pool):
        print(f"[=] device_id={did} 已在池中, 跳过")
    else:
        pool.append(dev)
        json.dump(pool, open(args.out, "w", encoding="utf-8"), ensure_ascii=False, indent=2)
        print(f"[✓] 入池 device_id={did} 机型={dev['query'].get('device_type')} → 池现有 {len(pool)} 台")
    print(f"    {args.out}")


if __name__ == "__main__":
    main()
