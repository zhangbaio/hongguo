# 抖音榜单逆向 — 进度 & Mac ARM 后续方案

> 目标:抓取抖音 app「热点榜」那一排 10 个榜的数据
> (抖音热榜 / 直播榜 / 团购榜 / 品牌榜 / 游戏榜 / 音乐榜 / 种草榜 / 影视榜 / 短剧榜 / 趋势榜)。
> 本文档记录已完成的侦察结论 + 在 **Mac ARM(Apple Silicon)** 上继续逆向的完整思路。
> 最后更新:2026-06-28。配套记忆:`memory/douyin-board.md`。

---

## 0. 一句话现状

- **2 个榜已用 web 路线拿到**(热榜、趋势榜),代码见 `douyin_board.py`,不依赖模拟器、不用逆签名。
- **其余 8 个榜是 app 专属**,数据走 cronet 原生 TLS(自带 CA + pinning),**在 x86 模拟器(MuMu)上够不着**
  ——因为抖音原生库只有 arm64,在 x86 上跑翻译层,Frida 看不到也 hook 不了。
- **换到 Mac ARM 后**,arm64 库原生执行,Frida 原生 hook 可用 → 8 个榜可解。本文档就是这条路的施工图。

---

## 1. 关键事实(已实测,Mac 上别重复踩)

### 1.1 目标 app
- 包名:`com.ss.android.ugc.aweme`
- 版本:**36.4.0**(versionCode 360401),aid=**1128**,minSdk 23 / targetSdk 34
- **APK 已提取**(单 base.apk,无 split):仓库内 `capture/apk/douyin/douyin-36.4.0.apk`(327MB)
  - 原生 ABI:**仅 `arm64-v8a`**
  - 关键 so:`lib/arm64-v8a/` 下 `libsscronet.so`(cronet 网络栈)、`libttboringssl.so`(自带 boringssl,做 TLS+pinning)、`libmetasec_ml.so`(X-Argus/X-Gorgon/X-Ladon 签名)
- 抓到的真实设备态(aid=1128):`device_id=1905883313126195`、`iid=1905883312573251`、`version_code=360400`

### 1.2 为什么红果那套预言机不能照搬
- 抖音**重度混淆**(方法名全是 `LIZ`/`LJIIJ`/`LJIILJJIL`),红果是明文。
- 红果 oracle 依赖的 `com.bytedance.frameworks.baselib.network.http.NetworkParams.tryAddSecurityFactor(url, Map)→Map`
  在抖音里**不存在**;签名被重构进请求管线 `LJIILJJIL(Request, int, BaseHttpRequestInfo, List, Map, boolean, boolean)`。
- **更关键**:抖音内容接口**走 cronet 原生**,不走 Java 网络层。hook 那个 Java 管线方法 16 秒只触发 1 次,
  且只是 `log.snssdk.com/app_log` 埋点。所以 Java 层既签不了名也抓不到内容。

### 1.3 pinning 的位置(决定了打法)
- WG mitmproxy 抓抖音:隧道通、系统证书对红果/部分埋点有效,但**抖音内容接口 TLS 握手全部失败**
  (`client does not trust proxy cert / certificate unknown`)。
- 原因:cronet 用**自己内置的 CA 包**,不读 Android 系统证书库 → 装系统证书没用,Java 层 unpinning 也没用。
- `libsscronet.so` / `libttboringssl.so` 的**导出符号全 stripped**(只有没人用的系统 `libssl.so` 有 `SSL_set_custom_verify`)。
- **结论**:必须在 **native 层**对 cronet 自带的 boringssl 动手(unpinning 或直接 dump 明文)。
  这在 x86 翻译层下做不了,到 arm64 才行。

### 1.4 已解决的 web 路线(2 个榜)
- 不用逆 `a_bogus`:本机 playwright 无头加载 `https://www.douyin.com/hot`,**让页面自己算 a_bogus+msToken**,
  监听 response 抓 `/aweme/v1/web/hot/search/list/?detail_list=1` 原文。
- 该响应 `data` 只含两块:`word_list`(~51,抖音热榜,带 view_count/discuss_video_count/word_type;
  注意 rank1 常是 word_type=14 的运营广告位)+ `trending_list`(5,趋势榜)。
- 备用更轻的免签接口(仅热搜词榜):先 GET `https://www.douyin.com/`(拿 ttwid cookie)→
  GET `https://www.iesdouyin.com/web/api/v2/hotsearch/billboard/word/`。无 cookie 第二次会被 WAF 拦(444 / X-TT-System-Error:3)。
- **web 端只有这 2 个榜**:PC web `/hot` 只渲染 1 个 tab;老 iesdouyin 同族 `/billboard/{aweme,music}/` 返回空、
  `/{discipline,sport,movie}/` 报 "Url doesn't match"。其余 8 榜 web 端确实没有。

---

## 2. 已交付代码 `douyin_board.py`
- `hot_board(limit=None)` → 抖音热榜(老接口,免签,最干净)。CLI:`python douyin_board.py hot [N]`
- `web_boards()` → `{hot_board:[...], trending:[...]}`(playwright 自动签名)。CLI:`python douyin_board.py web`
- 复用 `safeguards` 的缓存(10min)+ 节流;被 WAF 拦会自动重预热重试。
- `APP_ONLY_BOARDS` 常量列出那 8 个待解榜。

---

## 3. Mac ARM 上的施工方案

### 3.1 为什么 Mac ARM 是对的
Apple Silicon = arm64。跑 arm64 的 Android(模拟器或真机),抖音的 `libsscronet/libttboringssl/libmetasec_ml`
**原生执行**,Frida-server(arm64)能正常 `enumerateModules` / `Interceptor.attach` / 扫内存。
这正是 MuMu(x86,翻译层)做不到、卡住 8 个榜的根因。

### 3.2 环境(三选一,按推荐度排序)

**A. Android Studio AVD + arm64 系统镜像(推荐,纯软件)**
- Android Studio → Device Manager → 建 AVD,System Image 选 **arm64-v8a**、用 **"Google APIs"(非 Google Play)** 或 AOSP 镜像
  (这类是 userdebug,可 `adb root`,方便起 frida-server)。M 芯片下走 HVF 原生加速。
- 装 APK:`adb install capture/apk/douyin/douyin-36.4.0.apk`(把这文件拷到 Mac)。
- 风控提示:模拟器+root 可能被抖音风控标记。能登录、能加载榜单即可,不行就上方案 B。

**B. arm64 真机(保真度最高)**
- 一台 root 过的 arm 安卓机(Magisk)。USB 连 Mac,`adb` 直连。最不容易被风控,native hook 最稳。

**C. Corellium(云 arm 设备,付费)**:省心但要钱,一般用不到。

> 注意:**redroid 不适合 Mac**。redroid 要 Linux 宿主 + binder 内核模块,macOS 给不了;红果那套 redroid-arm64
> 是给 Linux arm 服务器(Oracle Ampere)的。Mac 上就用 AVD-arm64 或真机。

### 3.3 工具链
```
pip install frida-tools friTap mitmproxy
# frida-server arm64 版本要和本地 frida 版本号一致, push 到 /data/local/tmp 并 chmod +x 后台跑
adb push frida-server-XX.X.X-android-arm64 /data/local/tmp/frida-server
adb shell "su -c '/data/local/tmp/frida-server &'"
```

### 3.4 抓那 8 个榜 —— 两条 native 打法

#### 打法 ① friTap 直接 dump 明文(首选,绕过 pinning)
思路:**不跟 pinning 斗**,直接在进程内 hook boringssl 的 `SSL_read`/`SSL_write`,读 TLS 解密后的明文 HTTP。
friTap 专门支持 cronet/boringssl 这种静态链接 + stripped 的情况(内部用模式匹配定位 SSL_read/SSL_write)。
```
friTap -m --pcap douyin.pcap -f com.ss.android.ugc.aweme        # spawn 抖音并 dump
# 或 attach:
friTap -m --pcap douyin.pcap <pid>
```
然后在 app 里**从左到右点那 10 个榜 tab**,friTap 把每个榜接口的请求/响应明文落进 pcap(或 keylog 给 Wireshark)。
用 Wireshark/脚本过滤 host 含 `aweme/snssdk/amemv` 的请求,提取各榜端点 + `board_type`/`board_sub_type` 等区分参数。
- 优点:不用找 verify 函数、不用装证书、不用 MITM。最快见数据。
- 若 friTap 的内置特征对这版 boringssl 不命中,转打法 ②。

#### 打法 ② cronet SSL unpinning + mitmproxy MITM(经典)
思路:hook 掉 cronet 自带 boringssl 的证书校验,让它接受 mitmproxy 的 CA,再正常 MITM。
- boringssl 的校验走自定义回调 `SSL_CTX_set_custom_verify(ctx, mode, cb)` / `SSL_set_custom_verify`,
  cronet 设的 cb 里做 pinning。**符号被 strip**,要先定位:
  - 用 **Ghidra/IDA 静态分析 `libttboringssl.so`(arm64)**:它就是标准 boringssl,按 boringssl 版本串、
    错误字符串(如 `"CERTIFICATE_VERIFY_FAILED"`)的 xref 找到 cert-chain 校验函数 / custom_verify 注册点,记下偏移。
  - Frida 里 `Module.findBaseAddress("libttboringssl.so").add(偏移)`,`Interceptor.replace` 让校验回调直接返回
    `ssl_verify_ok`(0)。
- 或直接找社区现成的 **"bytedance/cronet ssl unpinning" frida 脚本**(每个大版本偏移会变,多半要按本版微调)。
- 然后 mitmproxy(普通模式或 WG 模式)即可解密抖音内容接口,addon 落库(复用 `capture/addon.py`)。

> 经验:打法 ① 通常更省事(几分钟见明文),打法 ② 更通用且能持续 MITM。先 ①,不行再 ②。

### 3.5 拿到 8 个榜端点后
- 整理成 `board_type/sub` 枚举表(类似红果三榜用 `comic_series_*_rank` 区分),补进 `douyin_board.py`。
- **只读榜单数据 = 边跑 app 边抓即可**,不需要重放、不需要自己签名。
- 若想**脱离 app 无人值守刷榜**(纯脚本调 app 接口),才需要 metasec 签名预言机:在 arm64 上 hook
  `libmetasec_ml` 的签名 JNI 做 oracle(类似红果思路,但抖音混淆+native,难度高)。**建议先别做**,
  榜单更新慢,UI 自动化(`adb input tap`)定时点一遍 + friTap/MITM 落库,性价比最高。

---

## 4. 推荐执行顺序(到 Mac 后)
1. 起 AVD-arm64(或接真机),`adb install` 仓库里的 `douyin-36.4.0.apk`,登录抖音。
2. push 对应版本 frida-server-arm64,起来。
3. `friTap -m --pcap douyin.pcap -f com.ss.android.ugc.aweme`,在 app 里依次点 10 个榜。
4. 解析 pcap,定位 8 个 app 专属榜的端点 + 区分参数。
5. 把这 8 个榜接进 `douyin_board.py`(读取层),配 `adb input` 定时采集 + 落库。
6. (可选)需要纯脚本无人值守再考虑 metasec 签名 oracle。

---

## 5. 速查
| 项 | 值 |
|---|---|
| 包名 | `com.ss.android.ugc.aweme` |
| 版本 | 36.4.0 / 360401,aid=1128 |
| APK | `capture/apk/douyin/douyin-36.4.0.apk`(arm64-v8a only) |
| 关键 so | `libsscronet.so` / `libttboringssl.so` / `libmetasec_ml.so` |
| 已解决 | 热榜、趋势榜(`douyin_board.py`,web 路线) |
| 待解决 | 直播/团购/品牌/游戏/音乐/种草/影视/短剧 8 榜(app 专属,需 arm64 native) |
| 设备态样本 | device_id=1905883313126195 iid=1905883312573251 |
| web 接口(免签) | `iesdouyin.com/web/api/v2/hotsearch/billboard/word/`(需先拿 ttwid cookie) |
| web 接口(签名) | `douyin.com/aweme/v1/web/hot/search/list/?detail_list=1`(playwright 自动签) |
| pinning 位置 | cronet 自带 boringssl(libttboringssl),自带 CA,stripped |
| 首选破法 | friTap dump 明文(arm64);备选 Ghidra 定位 verify + Frida unpinning + mitmproxy |
