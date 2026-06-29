# 抖音短剧榜逆向复现手册

> 目标:拿到抖音 App「短剧榜」(热播/漫剧/新剧/互动/必看 + 分类)的数据接口,并验证能否脱离 App 直接调用。
> 结论速览:**接口完全公开,可直接 HTTP GET,无需 App / 签名 / cookie / 设备参数。**
> 本文给出从零到拿到接口的完整环境、版本、命令、脚本,供其他 AI/人复现。

---

## 0. 最终成果(可直接用,跳过逆向也行)

```bash
# 榜单数据(billboard_type 选大榜,sub_billboard_type 选分类)
curl "https://api.amemv.com/aweme/v1/series/billboard/?billboard_type=1&sub_billboard_type=1&use_new_billboard=1"
# 榜单结构(各子榜/分类的 type)
curl "https://api.amemv.com/aweme/v1/series/billboard/tab/?use_new_billboard=1"
```

- **方法**:GET。无需任何鉴权(连 User-Agent 都不用),HTTP 200。
- **`billboard_type`**(大榜):`1`热播 `2`漫剧 `3`新剧 `4`互动 `8`必看。
- **`sub_billboard_type`**(分类):`1`总榜、`101`都市逆袭、`102`神医传奇…(完整值见 `/tab/` 返回)。
- **分页**:`&offset=15&count=10`(每页默认 ~15)。
- **响应字段**:`series_infos[]` 每项:
  - `series_id`(剧id)、`series_name`(剧名)
  - `cover_url.url_list[0]`(封面)
  - `stats.play_vv`(播放量)、`stats.collect_vv`(收藏)、`stats.total_episode`(总集数)、`stats.current_episode`
  - `desc`(简介)、`author.nickname`、`hot_value`
  - `has_more` / `offset`(分页)

> 注:这是抖音私有 API,无契约保证,可能随时加风控/改参/限频。生产用请加重试、限速、失败兜底。

---

## 1. 环境与版本(实测可用)

| 组件 | 版本 | 备注 |
|---|---|---|
| 主机 | macOS 26.3.1 / Apple Silicon (arm64) | M 芯片关键:跑原生 arm64 Android 镜像,无 Houdini 翻译层 |
| Android 模拟器 | `emulator` 36.6.11.0 | Android Studio 自带 |
| AVD 镜像 | `system-images;android-33;google_apis;arm64-v8a` | **必须 google_apis(可 adb root)+ arm64-v8a(原生)** |
| Android 版本 | 13 (API 33),abi=arm64-v8a | |
| adb | 1.0.41 | |
| Python | python.org 3.10.0 框架版 `/Library/Frameworks/Python.framework/Versions/3.10` | frida/friTap 装在这里 |
| frida(主机) | 17.9.6 | `pip install frida-tools` |
| frida-server(设备) | 17.9.6 (android-arm64) | **必须与主机 frida 同版本** |
| friTap | 2.2.3 | `pip install friTap`,做 TLS 明文 pcap |
| 抖音 APK | `com.ss.android.ugc.aweme` 36.4.0 | |

### 1.1 安装依赖

```bash
brew install --cask android-studio        # 含 SDK/emulator
brew install android-platform-tools        # adb(或用 SDK 自带)
# Python 3.10(python.org 版,避免 Homebrew PEP668);frida 装进去:
/Library/Frameworks/Python.framework/Versions/3.10/bin/pip3 install frida-tools friTap
# 校验
frida --version          # 17.9.6
fritap --version         # friTap v2.2.3
```

### 1.2 创建并启动 AVD

```bash
export ANDROID_HOME="$HOME/Library/Android/sdk"
export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/emulator:$ANDROID_HOME/cmdline-tools/latest/bin:$PATH"
sdkmanager "platform-tools" "emulator" "platforms;android-33" "system-images;android-33;google_apis;arm64-v8a"
avdmanager create avd -n hgarm -k "system-images;android-33;google_apis;arm64-v8a" -d pixel_5
# -gpu host 在 M 芯片上渲染又快又稳(swiftshader_indirect 容易窗口变灰)
emulator -avd hgarm -gpu host &
adb wait-for-device && adb root
adb shell getprop ro.product.cpu.abi   # 必须 arm64-v8a
```

> **磁盘坑**:默认 data 分区偏小,装多个大 App 会 `not enough space`。扩容(qcow2 已 12G 时)或清理。
> 字节系 App 的埋点库 `ss_app_log.db` 会膨胀到 GB 级,可安全删(app 会重建):
> `adb shell 'su 0 rm -f /data/data/<pkg>/databases/ss_app_log.db*'`

### 1.3 装抖音 + 起 frida-server

```bash
adb install -r douyin-36.4.0.apk
# frida-server(版本=主机 frida)
FV=17.9.6
wget https://github.com/frida/frida/releases/download/$FV/frida-server-$FV-android-arm64.xz
unxz frida-server-$FV-android-arm64.xz
adb push frida-server-$FV-android-arm64 /data/local/tmp/frida-server
adb shell 'su 0 chmod 755 /data/local/tmp/frida-server'
adb shell 'su 0 sh -c "/data/local/tmp/frida-server -D"' &
frida-ps -U | head    # 能列进程=连通
```

---

## 2. 逆向过程(踩坑 + 制胜路线)

### 2.1 关于"抖音在模拟器上闪退(SIGABRT/SI_QUEUE)"——别误判
实测抖音 36.4.0 **不硬反模拟器**:人手正常导航能进短剧榜;只有**快速自动化点击**会触发滑块验证码。
若出现 `Fatal signal 6 (SIGABRT) code SI_QUEUE` 全家崩,**优先怀疑 `/data_mirror` 被搞空了**(常因手动 `stop`+`umount /data` 折腾导致),`adb reboot` 即可修复,不要误判成反篡改。

### 2.2 抓包:为什么 friTap 默认抓不到榜单
- 起 friTap:`fritap -m -p out.pcap -k out.keys -f com.ss.android.ugc.aweme`,在 App 里点开短剧榜。
- friTap 默认只 hook `libssl.so` + `libmonochrome`(Chromium QUICHE),**抓不到榜单 JSON**。原因:
  1. 抖音内容/榜单 API 走**自研 QUIC(`libttquic.so`)** 或 **cronet 的 `libttboringssl.so`**,不走系统 libssl。
  2. 走 QUIC(UDP 443)时 friTap 的 QUICHE hook 也对不上(字节自研 QUIC 非 Google QUICHE)。

### 2.3 制胜两步:封 QUIC + hook libttboringssl
**关键发现:`libttboringssl.so` 导出了 `SSL_read`/`SSL_write` 符号**(`nm -D` 可见),可直接按名 hook。

1. **封 UDP 443/80,逼 QUIC 降级到 TCP/TLS**(走 boringssl):
```bash
adb shell 'su 0 sh -c "
iptables  -I OUTPUT -p udp --dport 443 -j REJECT
iptables  -I OUTPUT -p udp --dport 80  -j REJECT
ip6tables -I OUTPUT -p udp --dport 443 -j REJECT
ip6tables -I OUTPUT -p udp --dport 80  -j REJECT"'
```
2. **frida hook `libttboringssl.so` 的 SSL_read/SSL_write**,dump 明文(脚本见 §4.1)。在 App 里**手动**进短剧榜详情页(人速,别触发验证码)。

### 2.4 从明文里定位接口
- 抓到的明文里有 **Lynx 页面的 prefetch 配置** `playlet_lynx_rl3_douyin/pages/ranking_list/prefetch.json`,其中**声明了数据 API**:
  ```
  https://api.amemv.com/aweme/v1/series/billboard/
  https://api.amemv.com/aweme/v1/series/billboard/tab/
  ```
- 响应是 `Content-Encoding: br`(Brotli),HTTP/2(HPACK 头),所以直接 grep 中文搜不到——但 prefetch.json 是明文 h1.1,直接给出了端点。

### 2.5 验证:直接可调(本案最终结论)
```bash
curl -s "https://api.amemv.com/aweme/v1/series/billboard/?billboard_type=1&sub_billboard_type=1&use_new_billboard=1" | head -c 300
# → {"series_infos":[{"series_id":"...","series_name":"我是天尊...",...   HTTP 200
```
**无需 App、无需签名**。逆向到此完成——后续直接调接口即可。

---

## 3. 复现 Checklist

- [ ] M 芯片 Mac + Android Studio,创建 `google_apis;arm64-v8a` AVD,`-gpu host` 启动,`adb root`,确认 abi=arm64-v8a。
- [ ] frida-tools 17.9.6 + friTap 2.2.3(python.org 3.10);frida-server 17.9.6 推到 `/data/local/tmp` 并运行。
- [ ] 装抖音 36.4.0,起 App 进首页。
- [ ] `iptables` 封 UDP 443/80。
- [ ] frida 注入 §4.1 脚本 hook `libttboringssl`;手动进短剧榜详情页。
- [ ] 在 dump 里搜 `series/billboard`,拿到端点。
- [ ] `curl` 直接验证端点公开可用。
- [ ] (可选)用 §4.2 脚本直采落库。

---

## 4. 脚本

### 4.1 frida hook libttboringssl(抓 cronet 明文)`ssl_dump.js`
```javascript
// 用法: frida -U -f com.ss.android.ugc.aweme -l ssl_dump.js  (或 -p <pid>)
'use strict';
const m = Process.getModuleByName('libttboringssl.so');   // frida 17: 用模块对象,不能用 Module.findExportByName 全局形式
const wr = m.findExportByName('SSL_write');
const rd = m.findExportByName('SSL_read');
const getfdp = m.findExportByName('SSL_get_fd');
const getfd = getfdp ? new NativeFunction(getfdp, 'int', ['pointer']) : null;
function fd(ssl){ try{ return getfd ? getfd(ssl) : -1; }catch(e){ return -1; } }
if (wr) Interceptor.attach(wr, {
  onEnter(a){ this.ssl=a[0]; this.buf=a[1]; this.n=a[2].toInt32(); },
  onLeave(){ if(this.n>0){ try{ send({dir:'W', fd:fd(this.ssl), len:this.n}, this.buf.readByteArray(Math.min(this.n,65536))); }catch(e){} } }
});
if (rd) Interceptor.attach(rd, {
  onEnter(a){ this.ssl=a[0]; this.buf=a[1]; },
  onLeave(r){ const n=r.toInt32(); if(n>0){ try{ send({dir:'R', fd:fd(this.ssl), len:n}, this.buf.readByteArray(Math.min(n,65536))); }catch(e){} } }
});
send({dir:'ready', wr:!!wr, rd:!!rd});
```
配套 Python driver(把 W/R 落盘并实时打印 HTTP 请求行):见仓库 `frida/ssl_driver.py`(核心:`session.create_script(open('ssl_dump.js').read())`,`on('message')` 里按 dir 写文件 + 正则提 `^(GET|POST) ` 行)。

> frida 17 注意:`Module.findExportByName(name, sym)` 全局形式已删,改用 `Process.getModuleByName(name).findExportByName(sym)`。

### 4.2 直采脚本 `fetch_shortplay_board.py`
```python
#!/usr/bin/env python3
import sys, requests
BASE = "https://api.amemv.com/aweme/v1/series/billboard/"
def tabs():
    d = requests.get(BASE+"tab/", params={"use_new_billboard":1}, timeout=15).json()
    for t in d["billboard_type_list"]:
        print(f"billboard_type={t['type']}  {t['name']}")
        for s in t["sub_billboard_list"][:8]:
            print(f"    sub_billboard_type={s['type']}  {s['name']}")
def board(bt=1, sbt=1, pages=2, count=15):
    out, offset = [], 0
    for _ in range(pages):
        d = requests.get(BASE, params={"billboard_type":bt,"sub_billboard_type":sbt,
            "use_new_billboard":1,"offset":offset,"count":count}, timeout=15).json()
        infos = d.get("series_infos") or []
        out += infos
        if not d.get("has_more") or not infos: break
        offset = d.get("offset", offset+len(infos))
    return out
if __name__ == "__main__":
    if len(sys.argv)>1 and sys.argv[1]=="tab": tabs(); sys.exit()
    bt = int(sys.argv[1]) if len(sys.argv)>1 else 1
    sbt = int(sys.argv[2]) if len(sys.argv)>2 else 1
    for i,s in enumerate(board(bt,sbt),1):
        st=s.get("stats",{})
        print(f"{i:2d}. {s['series_name']:18s} 播放{st.get('play_vv',0):>13,} {st.get('total_episode')}集 id={s['series_id']}")
```

---

## 5. 一句话总结
抖音短剧榜运气在于:**`series/billboard` 是公开无签名接口,且 `libttboringssl` 导出 SSL 符号**。
逆向路径 = 封 UDP 443 逼 TLS 降级 → hook libttboringssl 抓明文 → 在 Lynx 的 prefetch.json 里读到端点 → curl 验证公开。
对比快手见 `KUAISHOU_BOARD_RE.md`(快手三样全相反,走的是"拉 KRN bundle 读源码"的路)。
