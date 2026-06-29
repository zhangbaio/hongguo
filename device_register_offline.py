# -*- coding: utf-8 -*-
"""红果 device_register 离线注册(实验, 未结)。

链路: 拼标准 applog 注册体(明文 JSON) → unidbg 加密(EncryptRun, libEncryptor.ttEncrypt)
      → tt_data=a POST → 离线签名(FqTrace) → 解析 device_id_str/install_id_str。

前置: 先起两个 unidbg 服务(在 unidbg-sign/ 下):
  java ... com.hongguo.sign.FqTrace   serve 9099   # 签名
  java ... com.hongguo.sign.EncryptRun serve 9100   # 加密(ttEncrypt)

现状: 加密 oracle 已验证(密文 magic 74 63 与真机一致), 但服务端返回 device_id=0。
      高度怀疑是"新设备速率墙"(同 IP 灌太多新设备被临时限铸)。
      → 换干净 IP / 挂代理 / 冷却后重跑本脚本验证注册体是否正确。
用法: python device_register_offline.py   (读同目录 config.json 的设备字段)
"""
import json, time, hashlib, uuid, random, os, requests, urllib3
urllib3.disable_warnings()
HERE = os.path.dirname(os.path.abspath(__file__))
CFG = json.load(open(os.path.join(HERE, "config.json"), encoding="utf-8"))
Q = CFG["base_query"]
SIGN = os.environ.get("SIGN_SERVER", "http://127.0.0.1:9099") + "/sign"
ENC = os.environ.get("ENC_SERVER", "http://127.0.0.1:9100") + "/encrypt"
SIG_HASH = "56a962410c494bbaf0b58dba20cae56f"  # base.apk 证书 DER 的 MD5


def _hex(n):
    return "".join(random.choice("0123456789abcdef") for _ in range(n))


def register(device=None):
    """注册一台设备。device 可传 {device_brand,device_type,resolution,os_version,os_api,rom_version}
    覆盖机型; 不传则用 config 默认。返回 (device_id_str, install_id_str, raw_response)。"""
    d = dict(Q)
    if device:
        d.update(device)
    cdid = str(uuid.uuid4())
    body = {"magic_tag": "ss_app_log", "header": {
        "display_name": "红果免费短剧", "update_version_code": int(d["update_version_code"]),
        "manifest_version_code": int(d["manifest_version_code"]), "app_version": d["version_name"],
        "version_code": int(d["version_code"]), "app_version_minor": "", "aid": int(d["aid"]),
        "channel": d["channel"], "package": "com.phoenix.read", "app_name": d["app_name"],
        "sdk_version": "3.9.6", "sdk_target_version": 29, "git_hash": "", "os": "Android",
        "os_version": d["os_version"], "os_api": int(d["os_api"]), "device_model": d["device_type"],
        "device_brand": d["device_brand"], "device_manufacturer": d["device_brand"],
        "cpu_abi": d.get("host_abi", "arm64-v8a"), "release_build": d["rom_version"], "density_dpi": 320,
        "display_density": "xhdpi", "resolution": d["resolution"], "language": d["language"], "timezone": 8,
        "access": "wifi", "not_request_sender": 0, "rom": str(d["rom_version"]).split()[0],
        "rom_version": d["rom_version"], "cdid": cdid, "sig_hash": SIG_HASH, "gaid_limited": 0,
        "device_platform": "android", "openudid": _hex(16), "clientudid": str(uuid.uuid4()),
        "tz_name": "Asia/Shanghai", "tz_offset": 28800, "region": "CN", "sim_region": "cn",
        "device_id": 0, "install_id": 0,
    }, "_gen_time": int(time.time() * 1000)}
    plain = json.dumps(body, ensure_ascii=False, separators=(",", ":")).encode()
    cipher = requests.post(ENC, data=plain, timeout=60).content
    assert cipher[:2] == b"\x74\x63", "加密失败 magic=%s" % cipher[:4].hex()
    stub = hashlib.md5(cipher).hexdigest().upper()
    qd = {"aid": d["aid"], "device_platform": "android", "channel": d["channel"],
          "version_code": d["version_code"], "version_name": d["version_name"], "app_name": d["app_name"],
          "ac": "wifi", "os": "android", "os_version": d["os_version"], "device_type": d["device_type"],
          "device_brand": d["device_brand"], "language": "zh", "resolution": d["resolution"],
          "update_version_code": d["update_version_code"], "manifest_version_code": d["manifest_version_code"],
          "cdid": cdid, "sdk_version": "3.9.6", "tt_data": "a", "req_id": str(uuid.uuid4()),
          "_rticket": str(int(time.time() * 1000))}
    qs = "&".join(f"{k}={requests.utils.quote(str(v), safe='')}" for k, v in qd.items())
    url = f"https://log.snssdk.com/service/2/device_register/?{qs}"
    h = {"content-type": "application/octet-stream;tt-data=a", "x-ss-stub": stub}
    h.update(requests.post(SIGN, json={"url": url, "headers": h}, timeout=60).json())
    h.pop("accept-encoding", None)
    r = requests.post(url, data=cipher, headers=h, verify=False, timeout=25)
    j = r.json()
    return j.get("device_id_str", "0"), j.get("install_id_str", "0"), r.text


if __name__ == "__main__":
    did, iid, raw = register()
    print("响应:", raw[:250])
    if did and did != "0":
        print(f"✅ 注册成功 device_id={did} install_id={iid}")
    else:
        print("⚠ device_id=0 —— 注册体可能不全, 或当前 IP 撞新设备速率墙(换干净IP/代理重试)")
