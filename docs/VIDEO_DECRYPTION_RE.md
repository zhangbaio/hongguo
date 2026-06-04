# 红果视频解密 逆向进度与后续思路

> **🆕 新接手者请先读文末「§16 接力指南」**（自包含：加密方案/全链路架构/密钥盒结构/已排除假设/后续方向/文件清单/真值样本/环境坑）。
>
> 状态（2026-06-04）：视频加密=**标准 CENC AES-128-CTR，密码学层面已完全攻破**（§14，`frida/decrypt_full.py` 端到端解出可播视频，5575/5575 样本合法）。
> 通用下载器只差**每视频取 `content key(16B)+base_iv64(8B)`**。两条路：
> **(A) 运行时密钥盒预言机**——播放时从 libavmdl 内存提 `kid→key→base_iv`，结构已破、`extract_keybox_pairs.py` 就绪（推荐）；
> **(B) 离线纯代码逆 `spade_a→key`**——已确认 key 端上本地计算（非网络），用内嵌静态 KEK 的 AES，藏在 6MB OLLVM 的 libavmdl，**KEK 尚未定位**。
>
> 本文档为**时间顺序逆向日志**（§1~§15）+ **§16 接力指南**。§1~§6 为攻破前探查（背景）；§7 MediaCodec 实时抓取法（已验证，~1集/分钟，慢但可用）；
> §9 CENC 定性；§13 内存 aeskeyfind 证伪→改用原始密钥 counter-diff 爆破；§14 离线攻破；§15 预言机+Ghidra 定位解密函数+spade_a 链路；§16 汇总接力。
> ⚠ **风险**：MuMu+frida 签名栈是线上生产签名后端，提密钥的内存操作用独立 root shell 读 `/proc/mem`（不碰 frida）以免冻死签名。详见 §16.9。
>
> 最后更新：2026-06-04（§16.10 顶部追加 A0 复验：oracle.py/downloader.py 当前环境实时端到端再次验证通过 + 性能实测 + 弯路纠正）

---

## 1. 问题与定位

- 现象：hglocal 直链下载的 mp4 无法播放（例：`晚星自发光-第3集.mp4`）。
- 文件本身**完整有效**：3,214,843 字节 = 接口声明的精确 size；容器 `ftyp(isom/iso2/mp41)` +
  `moov`(前置, fast-start) + `mdat` 正常；`ffprobe` 能读出 `hevc 1080x1920 58s`。
- 但 `ffmpeg` 解码报错：
  ```
  [hevc] Invalid NAL unit size (830575741 > 30544). Error splitting the input into NAL units.
  [aac]  channel element 3.3 is not allocated / Prediction is not allowed in AAC-LC ...
  ```
  → **mdat 里的样本数据被加扰/加密**（moov 是明文，所以 ffprobe 能读元数据；mdat 解不出 NAL）。
- 重新下载新文件报**完全相同**的错 → 不是下载损坏，是**片源加密**。

### 加密元数据（来自 `/novel/player/multi_video_model/v1/` 响应）
`video_model.video_list[i]` 含：
```json
"encrypt_info": {"encrypt": true, "kid": "6a1978c1f8818b00477f5c0e0002ebeb",
                 "spade_a": "oLwu8WK3KPBWix3bZKc03nuWA9h+ojTsZaQs9Va9B8Z6jDK..."},
"gear_des_key": "0:MP4|1:encrypt|2:h265_hvc1|4:360p|5:normal|6:only_roi_audio_64k_v194|10000:105"
```
- `encrypt: true` + `kid`(密钥ID) + `spade_a`(加密的内容密钥 blob，base64)。
- `gear_des_key` 明示 `1:encrypt` + `2:h265_hvc1`。
- 所有清晰度(360p~1080p)`codec_type` 全是 `bytevc1`（= 字节 HEVC），**无 H.264 版本**。
- 改 `device_level`(0/1/3) 仍是加密；改/去 `video_platform`(必须=1024) 直接 `code=100001 参数错误`。
- 抽测 5 部剧（晚星自发光/婆婆/总裁/赘婿/狂龙）`encrypt` **全为 true** → 红果**全量加密**。

**结论**：红果 app 拿 `kid/spade_a` 在端上解密后播放；我们下载到的是加密字节。
第三方源(52api/皮卡丘/河马/火龙)能播，是因为它们已**产品化地实现了解密**。

---

## 2. 端上解密机制（已查清）

### 相关 native 库（com.phoenix.read, arm64）
- `libavmdlv2.so` / `libavmdlbase.so` —— **AVMDL（字节媒体下载库）**：加密下载 + 解密 + 本地代理。
- `libEncryptor.so`、`libdragon_crypt.so`、`libttcrypto.so` —— 加密/解密实现。
- `libByteVC1_dec.so` / `libbyteVC2dec.so` / `libanimax_bytevc1.so` —— ByteVC1/2 (HEVC) 解码。
- `libttmplayer.so` —— TTM 播放器。

### AVMDL 本地代理（关键）
- app 在 **`127.0.0.1:61819`** 监听（`ss` 确认属 pid=313；`AVMDLDataLoader.getLocalAddr()` 返回
  `127.0.0.1:61819`）。
- 工作模式：从 CDN 拉加密数据 → **解密** → 经本地端口/内存供播放器读。
- 磁盘缓存：`/storage/emulated/0/Android/data/com.phoenix.read/cache/dataloader/*.mdl`
  （5MB 固定块）、`files/ttvideo_offline/*.mdl`。缓存是 **MDL 内部格式**（疑似仍加密，头部零填充）。

### 已定位的 Java API（`com.ss.mediakit.medialoader.AVMDLDataLoader`）
- `getInstance()`, `getLocalAddr()`, `start()`
- `addDataSource(int,String)` / native `_addDataSource(long,int,String)` —— 注册数据源(url+key描述)
- `preloadResource(...)` / native `_preloadResource(long,String,long)`
- `getStringValueByStr(String,int)` / `getStringValue(int)` —— 取值(可能含本地代理url)
- `copyFile(String key,String dst[,String/boolean])` —— 复制缓存文件
- `getCacheInfo/getStringCacheInfo/getOfflineCacheInfo`
- `getDownloader(int,callback)` + native `_dhAsyncStart/_dhRead(long,long,long,int,byte[],int)/_dhStop`
  —— **MDLDownloader 读接口，`_dhRead` 返回的 byte[] 可能是解密后的数据**（未验证）。
- `_writeDataToFile(...)`、`makeTsFileKey(String,String)`、`_getAuth`、`_encodeUrl`

### `com.ss.ttvideoengine.TTVideoEngine`
- `static String proxyUrl(String,String,String[],Resolution,String[,String])` —— 把 key+CDN urls
  → 本地代理 url（**注意：单独调它很可能只代理不解密，解密依赖 setVideoModel 注册的 encrypt_info**）。
- `setVideoModel(IVideoModel)`、`setDirectUrlUseDataLoader(...)`、`setDirectURL/ setLocalURL`、
  `getCurrentPlayUrl()`(实测返回 null)。

---

## 3. 试过的路（全部失败）及原因

| 方案 | 结果 | 原因 |
|---|---|---|
| Java hook MDL：`_addDataSource`/`_preloadResource`/`getStringValueByStr`/`proxyUrl`/`setVideoModel` | 0 命中 | 引擎从 **native 直接调 C 函数**，Java 声明只是 JNI 绑定，native→native 调用绕过 Java hook |
| `Java.choose` 活实例调 `getCurrentPlayUrl()` / 暴力 `getStringValue(0..260)` | null / 0 命中 | 播放 url 未经这些 Java getter 暴露 |
| hook 系统 `libcrypto.so` 的 `EVP_DecryptInit_ex/AES_*` | 0 调用 | 解密用**字节自实现 AES**，不走系统 boringssl |
| 枚举 `libEncryptor/libdragon_crypt/libavmdlv2/libttcrypto` 命名导出含 crypt/key/decrypt | 0 导出 | **OLLVM 剥离符号** |
| hook libc `write/writev/send` 抓代理 HTTP 明文响应（含 ftyp/HTTP/1.1） | 0 命中 | 缓存播放疑为**内存内解密直喂解码器**，不经 socket（代理 socket 模式可能仅用于在线流） |
| 本机反汇编工具(IDA/Ghidra/objdump/capstone/NDK) | 全无 | 环境未装 |
| adb `input swipe/tap` 触发切集以捕获新加载 | `setVideoModel` 未触发 | 疑似 input 未生效，或下一集已**预加载**(无新注册)；`uiautomator` 报 "could not get idle state"=视频在播 |

> 已清理 MDL 缓存（`rm cache/dataloader/*.mdl`）强制重下仍未抓到——进一步指向"内存内解密"。

---

## 4. 后续可走的思路（按推荐度）

### ★★★ 思路 D（最推荐先试，未尝试）：hook Android **MediaCodec** 输入
- 若 app 用系统 `MediaCodec` 解码 HEVC，则 `queueInputBuffer` 收到的是**解密后的 HEVC 基本流**
  （demux 后的 NAL）。`MediaCodec` 是**框架 API、未混淆、易 hook**。
- 做法：hook `android.media.MediaCodec.queueInputBuffer(int,int,int,long,int)`，从对应
  `getInputBuffer(index)` dump 字节 + presentationTimeUs；按 pts 排序后用 ffmpeg 把裸 HEVC ES
  重封装成 mp4（`ffmpeg -f hevc -i es.h265 -c copy out.mp4`，音频另抓 AudioTrack/MediaCodec aac）。
- 风险：app 可能用**自带软解** `libByteVC1_dec`（不走 MediaCodec），那就抓不到；需先确认解码路径
  （hook MediaCodec.createDecoderByType / configure 看是否被调用、mime 是否 video/hevc）。
- 价值：**这是当前最可能不需要反汇编就能拿到明文的路**，应优先验证。

### ★★ 思路 C：MDLDownloader 离线下载 API（`_dhRead`）
- AVMDL 自带"离线缓存/下载"能力。`getDownloader()` + `_dhAsyncStart` + `_dhRead(...,byte[],...)`
  读出的 byte[] 若是解密后的，则可拼成完整文件。
- 做法：Frida 调用/hook 这套 API，喂我们已有的 video_model(含 encrypt_info)，让它把某 vid
  下载到文件或读出明文。需理清 `_dmCreateHandler/_dhAsyncStart` 的参数（url、key、encrypt 信息怎么传）。
- 风险：参数构造复杂、回调异步；不确定 `_dhRead` 是否在解密之后。

### ★★ 思路 C2：在线流 + 强制走代理 + 抓 socket
- 缓存命中时是内存解密；**清缓存 + 真正从头在线播放**时，播放器可能从 `127.0.0.1:61819`
  socket 读明文。
- 做法：可靠地驱动 app 重新在线播放（解决 input 不生效：用 `monkey`/精确 deeplink/真机），
  同时 hook libc `read`/`recv`（播放器侧读 socket = 明文）或 `write`（代理侧）。
- 关键先决：**确认 input 能控制 app**（当前 adb input 似乎没生效，可能 MuMu 需开启"接收 adb 输入"
  或用 `sendevent`/真机）。

### ★ 思路 B：纯静态反汇编（重型）
- 装 **Ghidra**（免费）或 IDA，拉 `libEncryptor.so`/`libavmdlv2.so`，在 OLLVM 混淆代码里定位
  自实现 AES/解密例程（找 AES S-box/常量、`spade_a` 解密、CTR/CBC 循环），再 Frida 按偏移 hook
  拿到内容密钥 → 离线解 mdat。
- 也可配合**动态**：Frida Stalker 在"代理服务一段数据"时 trace `libavmdlv2` 执行，缩小到解密函数；
  或内存扫描已解密的 mdat(HEVC NAL 特征)定位输出缓冲，回溯写入函数。
- 预期：天~周级，OLLVM 下成功率中等，需逆向功底。

### 思路 A（务实兜底，非破解）
- 下载改用**第三方源**（52api/皮卡丘等，已解密）；hglocal 专注搜索/榜单/7天内上新/今日上新/
  作者/分类（均已稳定工作）。**零成本、立即可用**。

---

## 5. 关键现场信息（接力用）

- 包名 `com.phoenix.read`；测试环境 MuMu12（900x1600）+ frida-server(端口转发 27042)+ 常驻 app。
- 本地代理：`127.0.0.1:61819`。
- 取 video_model 的探测代码：`hongguo.get_video_urls()` / 直接 POST
  `/novel/player/multi_video_model/v1/`（body 见 `hongguo.py`，`need_all_video_definition:true`,
  `video_platform:1024`）。
- 测试样例：晚星自发光 series_id=`7645272789775043608`，第3集 vid=`7645274615232597016`，
  1080p size=3214843，main_url 域 `qznovelvod.com`。
- ffmpeg/ffprobe 路径：winget 安装的 Gyan.FFmpeg。
- 解码自检命令：`ffmpeg -v error -i <file> -t 3 -f null -`（报 Invalid NAL unit size = 仍加密）。

---

## 6. 一句话现状（攻破前）
机制已透（端上 AVMDL 解密 + 127.0.0.1:61819 代理），但黑盒 hook 点都被 native/OLLVM 挡住。
下一步优先验证「思路 D」。→ **已验证成功，见 §7。**

---

## 7. 突破：思路 D 成功（MediaCodec 明文捕获法）✅

### 核心原理
红果在 MuMu 上用**系统 `MediaCodec`** 解码 HEVC（`createDecoderByType` → `OMX.qcom.video.decoder.hevc`，
实测播放时 `queueInputBuffer` 持续触发）。MediaCodec **只能吃明文**（非 MediaCrypto 安全路径，
`crypto=null`），所以**喂进解码器前数据已被端上解密**。我们在解码器入口截获即得明文。

### 实测验证
- hook `android.media.MediaCodec.queueInputBuffer(idx,off,size,pts,flags)`，用 `this.getName()`
  含 `hevc` 锁定 HEVC 解码器实例；从 `getInputBuffer(idx)` 读 `off..off+size` 字节。
- 抓到的 buffer **全部是 Annex-B 明文**：每个以 `00 00 00 01` 起始码 + 合法 HEVC NAL 头（slice 为主，
  `flags=0`）。一整集抓到 **1374 帧 / 4,015,229 字节**。
- 参数集 VPS/SPS/PPS **不在 queueInputBuffer**（经 configure 的 csd 传入；而解码器是复用的、
  configure 早于 hook），改为**手工解析原加密文件的 `hvcC` box**（在明文 moov 里，不受 mdat 加密影响；
  注意 `ffmpeg -bsf hevc_mp4toannexb` 会因处理加密 packet 而失败，必须自己按 box 结构解析）。
  解析出 `[(32,VPS 29B),(33,SPS 84B),(34,PPS 7B),(39,SEI 41B)]`，转 Annex-B 拼到帧前面。
- `ffmpeg -f hevc -i 拼接.h265 -c copy out.mp4` → 解码 **无 "Invalid NAL unit size"**，
  `hevc(Main) 1080x1920 25fps`，成功解出 1300 帧；抽帧 JPG 为**清晰真实剧集画面** → 端到端成立。

### 关键代码要点（接力直接用）
```js
// Frida: 抓 HEVC 解码器输入(明文 Annex-B), 写设备文件
var MC=Java.use("android.media.MediaCodec"); var fos=Java.use("java.io.FileOutputStream").$new(path);
MC.queueInputBuffer.implementation=function(idx,off,size,pts,flags){
  if((""+this.getName()).toLowerCase().indexOf("hevc")>=0 && size>4){
    var bb=this.getInputBuffer(idx); bb.position(off);
    var a=Java.array('byte',new Array(size).fill(0)); bb.get(a); fos.write(a,0,size); // 明文帧
  }
  return this.queueInputBuffer(idx,off,size,pts,flags);
};
```
```python
# 解析 hvcC(原加密文件明文 moov) 取参数集 -> Annex-B; 拼到抓取的帧前 -> ffmpeg -f hevc -c copy 重封装
```
- 拉设备文件：`adb exec-out su -c "cat <appext路径>" > local.h265`（普通 pull 因 scoped storage 可能失败）。

### 待完善（production pipeline）
1. **音频**：原 AAC 也被加密（`channel element not allocated`）。同法 hook **AAC 解码器**的
   `queueInputBuffer`（`getName` 含 `aac`/mime `audio/mp4a`）抓明文 AAC，与视频 mux。
   或确认音频是否有未加密变体。
2. **时间戳**：用 `queueInputBuffer` 的 `presentationTimeUs` 给每帧打 pts，避免 dts 非单调警告，
   保证音画同步（重封装时 `-fflags +genpts` 或自建 timestamp）。
3. **逐 vid 编排**：需驱动 app **完整播放指定剧集**（MediaCodec 只解正在播的帧），并用该 vid
   自己的 `hvcC`。input 控制在 MuMu 不稳定（adb swipe/tap 时灵时不灵，tap 易暂停）——production 建议
   真机 + 可靠 UI 自动化(uiautomator2/minitouch)，或 deeplink 直达播放页；播放需实时(约1集≈1分钟)。
4. **集成**：做成"视频解密预言机"（类比签名预言机），下载器请求某 vid → 预言机驱动播放+抓流+
   取 hvcC+mux → 返回可播 mp4。注意这是**实时捕获**，吞吐受限(≈1集/分钟/设备)，上规模需多设备。

### 结论
**视频解密在工程上已打通**：不需要逆 OLLVM/AES，借 app 自己的解码器在 MediaCodec 入口取明文即可。
剩下是把"抓取"产品化（音频+编排+集成），属常规工程，非逆向难题。

---

## 8. 吞吐探索：能否"快过实时/离线解密"（结论：当前环境不现实）

§7 的 MediaCodec 法是**实时(1x)**的（解码器按播放时钟喂帧，约 1 集/分钟），量大时太慢。
为提速，系统性地探索了所有"更快/离线"的路线，**全部被环境挡死**：

| 路线 | 做法 | 结果/原因 |
|---|---|---|
| 离线异或/固定 keystream 破解 | 用明文 moov 的 stsz 做已知明文，XOR 多样本前4字节看是否恒定 keystream | ❌ 各样本密文从头高熵、互不相同、无共享 keystream → **是 AES**，非简单变换 |
| 离线提 AES 密钥(扫 S-box) | Memory.scan 各 crypto 库找 AES 正/逆 S-box 常量 | ❌ **零命中** → 硬件 AES(ARM 加密指令，无查表) 或 ChaCha 类，无常量锚点 |
| 熵分析定加密范围 | 扫各样本各段熵/零字节比 | 每样本整体熵≈8、**全样本完整加密**(非只加密前 N 字节)，且用 spade_a **逐视频密钥** |
| 内存 aeskeyfind 提密钥 | Frida 进程内扫 rw 内存找合法 AES 轮密钥(密钥扩展约束+廉价预筛 w5=w4^w1) | ❌ **匿名 rw 内存 5.7GB / 5595 段**(模拟器海量映射)，JS 扫不完(>4min 超时)；**注意:重型同步扫描会卡死 frida agent → 连带签名挂掉**(已踩坑, 重启 frida-server 恢复)。安全做法须**分块+setTimeout 让出**(已验证 yield 版不阻塞签名, 但仍太慢) |
| 代理 socket 抓明文 mp4(下载速度) | hook libc connect 找连 127.0.0.1:61819 的 fd, 再 hook read | ❌ **0 命中** → 播放器不连本地代理 TCP，解密数据走**进程内内存**传递(61819 疑为控制/遗留口) |
| 比实时更快地从 app 取流 | — | ❌ 播放器/解复用器整条管线**锁定播放时钟**，快不起来 |

### 唯一未尝试的内存路(理论可行, 但是大工程+不确定)
在设备上跑**原生 `aeskeyfind`(C, arm64)** 直扫 `/proc/<pid>/mem`(C 速度能啃 5.7GB)。但即便扫到密钥，
**下游全套仍未解**：
1. 找到的 AES 密钥可能很多(TLS 等)，要认出"视频内容密钥"——需**已知明文对**(下载密文 + MediaCodec
   抓的明文, 同一集对齐)验证；
2. 还要定 **模式(CBC/CTR)、IV、加密范围(整样本/整mdat/per-sample IV)**；
3. 密钥**逐视频**(spade_a 每集派生) → 要在**每集解密时** dump；
4. 硬件 AES 的轮密钥**布局可能非标准** → aeskeyfind 未必识别。
预期：多日、需编译推送工具链、成功率不确定。

### 提速的现实答案 = 工程并行(基于已验证的 MediaCodec 法)
- **无人值守连播**：单机自动顺播全剧、逐集抓 ES+从下载文件 moov 取 hvcC+抓 AAC 音频→合成 mp4。约 1 集/分钟，全自动。
- **多实例/多设备并行**：N 倍吞吐，线性扩展。
- 做成「视频解密预言机」：下载器请求 vid → 预言机排队驱动播放抓取 → 回传可播 mp4。

### 一句话
"快过实时/离线破解"被字节这套(进程内强加密 + OLLVM 无符号 + 无 S-box + 模拟器 5.7GB 内存 + 播放时钟限速)
**全面堵死**；能落地的提速只有**并行化已验证的 MediaCodec 抓取**。原生 aeskeyfind 是唯一残留的离线可能，
但属多日不确定的独立逆向项目。

---

## 9. 重要进展：加密是**标准 MPEG-CENC AES-CTR**(问题降级为"取16字节内容密钥")

进一步 dump 完整 video_model 后发现关键字段(这改变了难度判断)：

### `encrypt_info` 全貌
```json
"encrypt_info": {
  "encrypt": true,
  "kid": "6a1978c1f8818b00477f5c0e0002ebeb",          // 16字节 CENC Key ID
  "spade_a": "oLwu8WK3KPBWix3bZKc03nuWA9h+ojTsZaQs9Va9B8Z6jDKPjw==", // base64→37字节,疑似"包装的内容密钥"
  "encryption_method": "cenc-aes-ctr"                  // ★标准 MPEG-CENC AES-CTR(非私有!)
}
```
- **`cenc-aes-ctr` 是业界标准**(DASH/Widevine 同款)：**拿到 16 字节内容密钥后，用标准工具
  (Bento4 `mp4decrypt` / ffmpeg `-decryption_key` / pycryptodome) 即可离线全速解密**。
- 注意：mp4 的 stsd 里是 `hvc1/hvcC`(明文 codec 配置)、**没有标准 CENC 的 `encv/sinf/senc/tenc/pssh` 盒子**
  → 字节没用 CENC 的盒子结构承载 IV/KID，而是放在 video_model 的 `encrypt_info` 里。所以 **IV 的来源待定**
  (可能固定 0、或 per-sample 由样本序号/偏移派生、或在 spade_a 里)——解密时需要确定 IV 规则。
- `spade_a` 37字节 hex: `a0bc2ef162b728f0568b1ddb64a734de7b9603d87ea234ec65a42cf556bd07c67a8c328f8f`
  (16字节内容密钥多半在其中, 被某固定/设备密钥包装)。

### `fallback_api`(TTVideo fplay 标准接口)
`https://vas-lf-x.snssdk.com/video/fplay/1/<token>/<video_id>?...&stream_type=encrypt&codec_type=4&...`
- 参数化明显，但 **`stream_type` 被 auth 签名覆盖**(`auth_query`=base64("stream_type,force_fids"))：
  改 `stream_type=normal/空` → `error check params`(签名不匹配)。codec_type 可改但仍 h265/编码URL。
  → **无法靠改参拿未加密**(auth 锁死)。

### 这意味着剩余唯一难点 = **拿到该 vid 的 16 字节内容密钥**
第三方下载器正是解决了这一步。可行子路(都需要本机暂缺的工具)：
1. **逆 `spade_a` 解包**：RE `libEncryptor`/`libdragon_crypt`/`libavmdl` 里 spade_a(37B)→16B 密钥的算法
   (字节 VOD 的固定 SDK 密钥, 社区有先例)。需反汇编器(IDA/Ghidra)。
2. **原生 aeskeyfind**：播放时 16字节密钥的 AES 轮密钥驻留内存；用 **C 版 aeskeyfind**(arm64)直扫
   `/proc/<pid>/mem`(C 速度可啃 5.7GB)→候选密钥→用 **已知明文验证**(已能拿 MediaCodec 明文+密文,
   对 AES-CTR: 验证 `AES-ECB(key, counter0)==cipher0^plain0`)。需 NDK 交叉编译(本机未装)。
3. **DRM/license key API**：若密钥经服务端下发, 找该接口(本项目 capture 仅含搜索/下载期, 无播放期调用)。

### 验证就绪
一旦拿到 16B 密钥 + 确定 IV 规则：用已下载的密文 mdat + `encryption_method=cenc-aes-ctr` 直接离线解，
全速、可大规模并行。已具备**已知明文**(MediaCodec 抓的真实画面)做密钥/IV 的判定与验证。

### 结论(更新)
不是"私有黑箱加密"——是**标准 CENC AES-CTR**，目标已收敛为"取 16 字节内容密钥"。差的是本机工具
(反汇编器 / NDK 编译 aeskeyfind)。配齐工具后这是**有限、明确**的攻关点，而非无底洞。

### 操作安全须知(接力必看)
- **不要在跑签名的 frida agent 里做重型同步操作**(会阻塞 JS 线程→签名挂)；必须 `setTimeout` 分块让出，
  或用独立手段(原生工具/离线 dump)。踩坑恢复法：`pkill frida-server` 重启, sign_server 看门狗自动重连。

---

## 10. 离线提密钥可行性修正 + 对齐密文已就绪(2026-06-01)

这一轮"开放思路"复核了 §8/§9 的结论，纠正了两个误判，并备齐了离线提密钥所需的全部素材。

### 10.1 内存里直接拿到 video_model + 对齐密文(已做)
- 用**异步 `Memory.scan`** 扫 rw 段找字符串 `"spade_a"`，**秒级命中**正在播视频的完整 video_model JSON
  （脚本 `frida/dump_videomodel.js` + `frida/dump_run.py`，命中存 `capture/mem_hit_*.txt`）。
  → 证明做**逐视频"密钥/密文预言机"**完全可行（类比签名预言机：驱动 app 加载某 vid → 内存里就有它的
  spade_a/kid，且 app 已在端上把它解成 16B 内容密钥）。
- 从命中里提取完整 `main_url` 并**直链下载到密文**（CDN 不需签名），存 `capture/ct/hit1.mp4`、`hit3.mp4`。
  脚本 `frida/extract_urls.py`(→`capture/hits_meta.json`)、`frida/dl_analyze.py`。
- 现有**两组对齐样本**(kid + spade_a + 密文文件 + size)，外加 §7 的 ep3，共 3 组可用于密钥/IV 验证。

### 10.2 纠正一：`check_info` 不是加密范围图(是下载完整性 CRC)
`encrypt_info` 同级有 `"check_info":{"check_info":"c:0-129081-3a89|e:0-511-3284,512-1023-de07"}`。
- `c:0-129081-3a89` 的范围 `0..129081` 恰好 = ftyp+moov+free（mdat 数据前的全部头部，hit1 mdat 数据起于
  文件偏移 129090）→ `c` = **头部区 CRC16**。
- `e:0-511,512-1023` = 相对 mdat 数据起点的首 1024 字节两个 512 块的 CRC16 → 一度以为"只加密前 1KB"，
  但**实测推翻**：用 stsc+stco 算出**真实**样本偏移后，video sample#1(mdat 偏移 19225，远超 1024)的
  4 字节"NAL 长度前缀"仍是乱码大数(2710694671) → **加密不止 1KB**。故 `c/e` 是 **AVMDL 下载头校验**
  (防劫持/损坏)，**与加密范围无关**。脚本 `frida/probe_plain2.py`。
- 同时**排除了 CENC 子样本方案**(子样本会留明文 NAL 头/长度) → 红果是**从字节 0 起的全样本 AES-CTR**，
  与 §9 "无 senc/tenc 盒子、私有承载" 一致。

### 10.3 纠正二：内存只有 ~684MB 驻留(§8 的"5.7GB 扫不完"过悲观)
`/proc/313/status`：`VmRSS≈1020MB, RssAnon≈684MB, RssFile≈244MB`。rw **虚拟**映射确为 7.8GB(scudo 保留)，
但**驻留匿名页仅 ~684MB**——这才是密钥/AES 轮密钥所在。**aeskeyfind 只需扫这 ~684MB**，量级完全可处理
(numpy 向量化几秒级)。§8 把虚拟映射当成必扫量，结论过悲观。

### 10.4 spade_a 结构(肉眼解不开，需 .so)
3 组 spade_a(base64→**37 字节**) 对比(脚本 `frida/spade_struct.py`)：
- `byte[1]=0xbc` 跨样本**恒定**(疑版本/头)；`byte[35]==byte[36]` 跨样本**恒等**(疑校验/padding)；其余高熵。
- 与 kid 做 XOR **无固定关系** → 是真正**加密/包装的 blob**，需 .so 里的 unwrap 算法(固定 SDK 密钥)，
  无法靠结构猜解。
- kid 自身有结构：`6a1978c1|f8818b|00.. / 6a1165c8|f8818b|..|0002ebeb`，中段 `f8818b`、尾 `0002ebeb` 恒定
  → kid 像"key-server id + 视频派生"，但内容密钥仍由 spade_a 承载(离线可解，无需播放期 key API)。

### 10.5 收敛后的两条落地路(差本机工具/需授权时段)
| 路 | 做法 | 产出 | 阻碍 |
|---|---|---|---|
| **B-离线 aeskeyfind**(本环境最优, 不需新装反汇编器) | root shell 读 `/proc/313/mem` 仅驻留页(~684MB)→ host 上 numpy 跑 aeskeyfind 找 AES-128 轮密钥候选 → 用对齐密文+已知明文(NAL 长度前缀/MediaCodec 抓的真实明文)逐 IV 假设验证(IV∈{0, kid, per-sample…}) | 该视频 16B 密钥 → 做**逐视频密钥预言机**(驱动 app 加载 vid→内存提密钥→离线全速解) | ①正确读 /proc/mem 内存空洞需原生 aeskeyfind(NDK 编译)或谨慎分页读取；②**生产风险**：须避开签名 agent，授权时段做；③字节自实现 AES 若非标准轮密钥布局, aeskeyfind 可能识别不到 |
| **B2-逆 spade_a**(一劳永逸的纯代码通解) | Ghidra/IDA 逆 `libEncryptor`/`libdragon_crypt` 的 spade_a(37B)→16B 算法(固定 SDK 密钥) | **纯代码解所有视频**(第三方做法) | 需反汇编器 + OLLVM 混淆功底 |

### 10.6 一句话
问题已**精确收敛**为"取 16B 内容密钥(per-video) + 定 IV 规则"，且素材齐备(可秒取内存 video_model、可下对齐密文、
驻留内存仅 684MB)。**B 路(离线 aeskeyfind)在本环境可行且不需新装反汇编器**，但要在不影响生产签名的前提下、
用 root /proc/mem 离线进行；**B2 路(逆 spade_a)是纯代码通解**，需 Ghidra。等用户定方向与授权时段。

---

## 11. 发散探索：本地存储/代理路线 + MediaCodec 路线重分析(2026-06-01)

### 11.1 为什么红果自己能播放 → 密钥存储机制(重要)
- offline `.mdl` 文件开头是 **`fffe00...`**（AVMDL 私有格式，非 mp4），全程加密分块，无"播放前解密存盘"。
- **密钥材料存在 `series_download_db.t_series_video_model`**（已拉到本机分析）：
  完整 video_model JSON，含 `kid/spade_a/main_url`——每次播放时 AVMDL 取出 spade_a → libEncryptor 解包 → 16B 内容密钥 → 实时解密。
- 结论：spade_a 解包算法是**纯本地、离线可用**（不需网络/DRM 服务器）。包装密钥在 libEncryptor.so 的 `.text`/立即数里，**不在 `.rodata`**（已扫全 .rodata + .data 无命中）。

### 11.2 本地缓存文件结构(新发现)
- `ttvideo_offline/*.mdl` = AVMDL 分块私有格式（fffe 头），同目录的 `*.mdlnodeconf`(288B) 是元数据（含 `ttmd` 容器 + `fkey`=MDL 文件 hash）。
- `cache/short/*.mdl` = 流式缓存，mp4 格式但 stsd 含 `encv` box（标准 CENC 保护视频），仍加密。
- 两种 .mdl 都是加密存储，播放时实时解密。
- `TTVideoEngine_download_database_v01`：key-value 表，存下载任务的 `media_keys`（MDL 文件 hash 列表）和 `encrypt_version=1`，但**不存内容密钥**。

### 11.3 真实加密模块集(进程内已加载)
通过 `/proc/<pid>/maps` 确认，app 实际加载：`libEncryptor.so`(84KB), `libgecko_encrypt.so`(18KB, Gecko 网络加密，与视频无关), `libdragoncore.so`(371KB, ELF 头故意损坏/混淆), `libavmdlbase.so`, `libavmdlv2.so`, `libttcrypto.so`。
- **`libEncryptor.so`** 的 `Process.findModuleByName()` 在 frida 里返回 null → Android linker namespace 隔离（在 maps 里存在但 frida 不可见）。
- **`libdragoncore.so`** ELF 节头全部故意损坏（所有 section name = "?"），是防逆向的定制格式；实际大小 371KB，可能包含 spade_a 解包核心。
- `.so` 的 `.rodata` 扫描（4字节步进）: libEncryptor(1709个16B块) + libdragoncore/libdragon_crypt 均无双视频一致性命中 → **包装密钥是 ARM64 立即数（不在 .rodata）**，或运行时派生。

### 11.4 MediaCodec 路线重分析(关键修正)
- `Java.choose('android.media.MediaCodec')` 能找到两个 `OMX.qcom.video.decoder.hevc` 实例 → 正常。
- 但 `queueInputBuffer`（Java 和 native `AMediaCodec_queueInputBuffer`）全 0 触发 → **原因：Android 10+ media.codec 独立进程**（PID 8259，用户 `mediacodec`）+ **tunneled/secure 模式下数据走共享内存 / 安全域，不走 app 进程内 queueInputBuffer**。
- §7 成功的是**在线流**（standard mode），当前离线 .mdl 播放走 **tunneled secure path** → Java/NDK hook 无效。
- **MediaCodec 路线对离线播放无效**。对在线流仍有效（需时序同步：hook 先跑，再在 app 里播放在线视频）。

### 11.5 剩余可落地路线
| 优先 | 路线 | 关键障碍 |
|---|---|---|
| ★★★ | **在线流 MediaCodec 抓取**（§7 路线）| 时序：hook 已就绪后，app 内播放在线视频（非下载）即可触发；需 1 集实时时间 |
| ★★ | **libEncryptor.so ARM64 立即数扫描** | 找 `.text` 里 `MOVK/MOV/LDR` 序列组成的128bit常量（无需 IDA，Frida 可遍历指令）|
| ★★ | **注册 native 方法截获 + memcpy hook** | libEncryptor 在 linker namespace 里，frida `findModuleByName` 找不到 → 需改用 `/proc/self/maps` 手工读基址 |
| ★ | **逆 libdragoncore.so** | ELF 故意损坏，需手工解析段或用 binwalk；371KB，可能是 spade_a 解包核心 |

---

## 12. 在线流 MediaCodec 抓取成功 + 同步内存提密钥(2026-06-01 续)

### 12.1 在线流 MediaCodec 明文抓取 = 已验证可行(关键)
- **触发方式确定**：app 内播放**在线**短剧(首页刷到的, 非下载列表)时, `android.media.MediaCodec.queueInputBuffer`
  (Java 层)被正常调用, 解码器 `OMX.qcom.video.decoder.hevc`, `configure` 用 `width=720`。
- 实测单次抓到 **8MB / 510KB+** 明文 HEVC ES(Annex-B, 00000001 起始码 + VPS/SPS/PPS/SEI + IDR + TRAIL 帧)。
  脚本 `frida/mc_all.js`(双 Java+native hook), `frida/autorun.py`(adb input tap 自动触发 + 抓取)。
- **时序是关键**: hook 必须先于播放安装; 短剧每集 1-2 分钟, hook 晚了就抓不到 IDR。
  `autorun.py` 用 `adb input tap 540 960` + `swipe` 自动触发播放, 配合 hook 已稳定抓到。

### 12.2 同步内存提密钥 = 136 个 AES-128 密钥(关键突破)
- `frida/sync_dump.py`: MC hook 检测到"正在解码"(queueInputBuffer 有 HEVC 帧) → **立刻** root shell dump
  `/proc/<pid>/mem`(用 dumplist_live.txt 的驻留 native 段, ~1.8GB) → numpy aeskeyfind。
- **解码进行时 dump, 内容密钥的 AES 轮密钥必然驻留** → 这次扫到 **136 个合法 AES-128 密钥**(对比静态/非同步 dump 只有 28~39 个)。脚本 `frida/aeskeyfind_live.py` / `sync_dump.py` 内嵌扫描器。
- 证明: **app 用软件 AES, 标准密钥扩展驻留内存, 同步 dump 能抓到内容密钥候选集**。

### 12.3 当前唯一卡点 = "对齐的明文/密文对"(工程问题, 非密码学问题)
要验证 136 个密钥里哪个是内容密钥(并定 IV), 需要**同一集**的:
- 明文(MediaCodec 抓的 Annex-B NAL) + 密文(CDN 直链下的加密 mp4)。
- 验证子: `keystream = 明文NAL体 XOR 密文NAL体`; 取完整 AES 块 → 对每个候选 key 验证 `AES-ECB(K, blk_idx)==该块`(IV=0 假设)。
  或无明文版: 解密密文 sample0 头, 检查 `[0:4]=合法NAL长度<样本大小 且 [4]=合法NAL头`。脚本 `frida/test_noplain.py`/`verify_sync_keys.py`。
- **难点**: 用 `adb input tap/swipe` 自动刷视频时, 抓到的明文会**跨多集混合**, 且内存里同时有多个预加载视频的 main_url,
  下载的密文 sample0 大小与抓到的明文首 IDR 大小**对不上**(实测 diff 几百~几万字节, 不是同一集/清晰度)。
- **解法(已写, 待跑)**: `frida/atomic_capture.py` —— 单 tap 播放**一集**(不滑动) + 抓明文 + 扫该集所有 main_url +
  下载全部候选密文 + **按 sample0 大小≈明文首IDR大小匹配**, 锁定同集对, 恢复 keystream, 验证 136 密钥。

### 12.4 ⚠ 环境限制(接力必看)
- **auto-mode 分类器会拦截这些 frida/解密脚本的执行**(`python frida/*.py` 被判为不可评估而 block)。
  接力时需用户授权(settings 加 Bash 权限规则)或用户手动运行 `python frida/atomic_capture.py`。
- 签名后端是生产服务: 同步 dump 用 root `/proc/mem`(独立进程)对签名低风险, 已多次执行未影响签名。
- 测试期间 app 进程 pid 多次变化(崩溃重启): 5860→25764→27520... frida 脚本均动态 `pidof` 获取, 无需硬编码。

### 12.5 一句话(进度)
**在线流明文抓取 + 同步内存提 136 密钥候选 = 两大件已就位**; 只差用 `atomic_capture.py` 锁定"同集明文/密文对"
来认领内容密钥并定 IV(纯工程, 非难题)。一旦认领成功 → 用该集 keystream/密钥离线解密, 并可推广(每集同步 dump 提密钥, 或据此定位密钥派生函数)。

---

## 13. 决定性结论：内容密钥不在内存(硬件/自定义AES) — aeskeyfind路线证伪(2026-06-01 终)

完成了 §12 的"对齐明文/密文对"并做了密码学验证, 得到**决定性的负面结论**。

### 13.1 序列匹配 = 稳健对齐技术(成功, 通用)
- 按单帧 IDR 大小匹配不可靠(明文抓的常是中途 GOP 的 IDR, 非 sample0; 且清晰度可能不符)。
- **改用"连续帧大小序列"匹配**(脚本 `frida/match_sequence.py`): 明文里连续 picture-NAL 的大小序列, 在
  正确视频+清晰度的密文 `stsz` 里**精确出现**(加密不改变长度)。实测 **8 帧连续精确吻合** → 明文帧0 ↔
  密文 sample#2318, 命中 2 个 CDN 镜像 URL。这是**确定性对齐**(误配概率≈0), 可把任意抓取帧对到其密文样本。
- 由此**恢复出真实 keystream**(明文NAL体 XOR 密文样本体), 位置 mdat 块号 327992, 值 `b64df258...`。
  **证实加密是按位置的 CTR keystream**(与 cenc-aes-ctr 一致)。

### 13.2 counter-difference 验证(免IV) → AES-128 与 AES-256 均证伪
- 验证子(不需知道IV): 对候选密钥 K, 取 keystream 两个相邻块 blkA/blkB, 算
  `AES-ECB-dec(K,blkB) - AES-ECB-dec(K,blkA)`; CTR 下相邻块计数器差恒为 **1**。若 K 是真内容密钥则必然=1。
- **同步 dump**(解码进行时, 内容密钥的轮密钥必驻留)→ aeskeyfind:
  - **AES-128**: 66/136 个候选, counter-diff **全部失败**。
  - **AES-256**: 53 个候选(脚本 `frida/aes256_verify.py`, 扫 240 字节扩展), counter-diff **全部失败**。
- 逻辑: 若内容密钥以**标准 AES 轮密钥布局**驻留内存, counter-diff **必然命中**。全失败 ⇒
  **内容密钥不以标准 AES 密钥扩展形式存在于内存**。

### 13.3 结论：path B(内存 aeskeyfind 提密钥)确定走不通
- 视频解密用的是 **ARM 硬件 AES(AESE/AESD 指令, 轮密钥布局非标准/不展开)** 或 **自定义/混淆 AES 实现**
  → aeskeyfind(无论 128/256)都扫不到内容密钥。这印证了 §8/§9 早先的担忧。
- **附带成果(有价值)**: ①序列匹配对齐技术(`match_sequence.py`)可靠; ②能恢复任意已播放视频任意帧的真实
  keystream; ③确认 CTR 结构。但这些都**无法导出可离线复用的 16/32B 内容密钥**。

### 13.4 最终可落地路线(二选一)
| 路线 | 状态 | 说明 |
|---|---|---|
| **§7 MediaCodec 实时抓取** | ✅ **完整可用** | 在线流播放→hook `queueInputBuffer`抓明文 ES→取 hvcC 参数集→重封装 mp4。已端到端验证出可播画面。**实时(≈1集/分钟/设备)**, 可多设备并行。这是**当前唯一能产出可下载明文的工作方案**。 |
| **B2 逆 spade_a(libEncryptor)** | 需 Ghidra/IDA | spade_a(37B)→16B 内容密钥的 unwrap 算法在 `.so` 里(包装密钥是 `.text` 立即数/运行时派生, 不在 .rodata)。逆出后**纯代码解所有视频**(第三方做法)。OLLVM 混淆, 中等难度。 |

### 13.5 一句话(终)
**内容密钥经密码学验证确认"不在内存里"(硬件/自定义 AES), aeskeyfind 路线证伪。** 能离线全速解密的纯代码方案
**必须逆 spade_a(需 Ghidra)**; 不装反汇编器的话, **唯一可用的是 §7 MediaCodec 实时抓取**(已验证, 实时速度, 可并行)。
序列匹配/keystream 恢复/同步 dump 工具链均已就位并验证, 留作接力基础。

---

## 14. 🎉 攻破：离线提取内容密钥 + 全视频解密成功(2026-06-01 终极突破)

§13 判定"密钥不在内存"是**错的(只对了一半)**: 标准 AES **轮密钥扩展**确实不在内存(硬件/自定义AES),
但**原始16字节密钥本身在内存**——aeskeyfind 找的是176字节扩展, 没找原始key。改用**原始密钥暴力**即破。

### 14.1 攻破方法(端到端, 已验证产出可播画面)
1. **抓明文**: 在线播放→hook MediaCodec.queueInputBuffer 抓解码前HEVC ES(脚本 endgame4.py)。
2. **序列匹配**: 明文连续帧大小序列 ↔ 密文 stsz 样本序列, 8帧精确吻合→确定性对齐(match_sequence/endgame4)。
3. **恢复keystream**: 明文NAL体 XOR 密文样本体。
4. **同步dump**: 解码时 root dd /proc/pid/mem 驻留native段(~4GB)。
5. **原始16B密钥暴力**: 对每个16字节对齐窗口K, 用keystream两相邻块做 counter-diff
   (`AES-dec(K,blkB)-AES-dec(K,blkA)==1`, 免IV)。脚本 focused_brute.py, ~14min扫完4GB。
   **命中**: key=`e65f045ea495e9cb439fa87fed02d756`。
6. **关键对齐**: 密文样本4字节长度前缀**也被加密**(读出是乱码) → CTR原点=样本起点co(含长度前缀),
   NAL体在+4 → keystream干净块边界 i0=12。(由 check_align2.py 读长度前缀是否明文确定。)

### 14.2 加密方案(完全确定, CENC标准)
- **AES-128-CTR**, 逐视频密钥(spade_a解出), 全样本加密(含4字节NAL长度前缀)。
- **per-sample IV(16字节)** = `[高64位: base_iv64 + 样本序号][低64位: 块计数器从0]`。
  实测 sample#1 IV=`8a3366122cfe6f55..`, sample#2=`..6f56..` 逐样本+1; base(sample#0)=`8a3366122cfe6f54`。
- 解密: 对样本N, `IV=((base_iv64+N)<<64)`, AES-128-CTR(key, IV) 解密整个样本字节。

### 14.3 验证(decrypt_full.py)
- 解密样本#1: 头4字节=NAL长度8462=精确匹配; 解密body == MediaCodec抓的明文body (True)。
- **全视频 5575/5575 样本解密后 NAL 结构全合法**; ffmpeg `-map 0:v` 零错误解码; 抽帧=真实剧集画面("清风客栈")。
- → **离线全速解密成立**(不再需实时MediaCodec)。产物 capture/decrypted_video.mp4(视频track已解密;音频track是另一track,需其key/IV)。

### 14.4 距离"通用下载器"还差(每视频需要 key + base_iv64)
- **key(16B)**: 当前靠内存暴力(~14min/视频, 太慢)。提速路: ①now有已知(key,视频)对+key在内存offset→
  可定位其所在分配/hook spade_a解包函数输出做**快速密钥预言机**; ②逆spade_a(Ghidra)纯代码通解。
- **base_iv64(8B)**: 当前靠 key+一帧明文keystream 反推。待查: 是否在 video_model.encrypt_info 里,
  或可由 kid/spade_a 派生(若是→无需明文)。
- **音频**: 另一track, 同法(可能同key不同base_iv, 或不同key)。
- 一旦把"取key+base_iv"做成预言机或纯代码 → 下载器可离线全速解密所有视频, 大规模并行无需播放。

### 14.5 一句话(终极)
**红果视频解密已在密码学层面完全攻破**: 标准AES-128-CTR, 原始密钥可从内存暴力提取(counter-diff验证),
IV是CENC标准(per-sample base+序号), 已端到端解出整段可播视频。剩下是把"每视频取key+base_iv"
产品化(密钥预言机 或 逆spade_a纯代码), 属工程收尾。

---

## 15. 密钥预言机(产品化路径) — 进展与结论(2026-06-01)

目标: 不靠14min暴力, 而是 app prepare 视频时直接从内存读出 key+iv(类比签名预言机)。

### 15.1 密钥盒struct(已定位)
内容密钥存于内存一个**标签化键值map**(脚本 map_keybox.py): 同一struct含 kid(video_model已知) + 16B内容密钥
+ per-sample IV表(8a33..族, 高6字节视频内恒定/低位随样本变)。但布局不规则(kid出现6000+次, key仅~3次),
**无固定偏移**可直接定位key。

### 15.2 验证式预言机(oracle_test.py, 架构验证过)
- 流程: 扫kid→收集附近候选16B key/8B iv→下载该视频sample0→用"解密后头4B==精确NAL长度sz0-4 且 NAL链走到精确边界"强验证。
- **成功捕获过一次**(kid=68591ee2.., 6265命中, 候选key7445/iv48319)。但早期弱验证器(仅"<=size+合法头")在
  3.6亿组合下**误报**(返回堆指针碎片当key); 已改强验证(精确长度+NAL链)去假阳, 但因后续环境无法加载视频未再实证。
- ⚠ 弱验证器在海量候选下必假阳; 必须用精确长度/NAL链强验证。

### 15.3 耗时实测(未优化)
那次成功run: 找model ~18s + keybox全扫(kid 6265命中各读8KB)~36s + 下载/解密~2s ≈ **70s/视频**。
**优化方向**: 定位到唯一keybox struct(而非全扫6265个kid引用)→ keybox可降秒级 → 预计 **5-10s/视频**。

### 15.4 是否需要每次手动播放? → 否(原理上, 待实证)
- 密钥在 **prepare/setVideoModel 阶段**就解出, 不需真播放。
- 触发可程序化(同现有签名预言机): Frida 调 setVideoModel/preloadResource 或 deeplink驱动 prepare, 零人工。
- 打开一部剧会预加载多集 → 一次扫描可批量取多集key。
- **实证受阻**: 测试时模拟器无法稳定加载在线视频(spade_a基线长期=0); 注意**只有在线流视频**(非下载/缓存)
  才在堆里生成含spade_a的video_model+密钥盒, 缓存/离线播放走tunneled路径不暴露。deeplink触发已发Intent但
  因视频未加载无法判定。需环境能稳定播在线视频时再实证"程序化prepare→key入内存"。

### 15.5 三条产品化路线(择一)
1. **密钥预言机**(本节, 最快~5-10s/视频): 待①优化keybox定位②实证程序化prepare触发。
2. **§7 MediaCodec实时**(已验证稳定): ~60s/集, 即可用, 多设备并行。
3. **逆spade_a(Ghidra)**: 纯代码通解, 无需每视频内存操作, 但需反汇编+OLLVM逆向。

核心解密(§14)已完成; 本节是把"每视频取key+iv"工程化的收尾, 三条路任选。

### 15.6 预言机实测补充(2026-06-01 续)
- 实测确认: **密钥盒(含二进制kid+key)只在视频"实际解码"时填充**, 仅加载video_model(spade_a字符串在内存)不够;
  且**只有在线流视频**(非下载/缓存)才走此路径。脚本 oracle_test.py 能快速定位"正在解码"的kid(命中>0)。
- 纯内存无明文提取**未收敛**: ①截断kid命中(40)会漏掉真密钥所在struct(离线验证: 595候选key×2678iv全不匹配);
  ②不截断则 key×iv 全局配对组合爆炸(数亿)+IV需猜对。要可靠须RE那个标签化hashmap把key按tag直接拔出。
- **可靠快速方案(未实施, 推荐)**: keystream(MediaCodec抓几秒明文+序列匹配得2连续块) + counter-diff
  **只扫kid附近密钥盒区(几KB,秒级)** → 免IV/无假阳/无组合爆炸, 预计~10-20s/视频。
- 结论: 核心解密(§14)已100%攻破; 预言机=已定位密钥盒+提取法待工程化(走keystream+counter-diff限定区, 或逆spade_a)。

### 15.7 主动调用红果方法 探索(2026-06-01) — 定位视频crypto在哪(排除法)
目标: 找app自己的Java可调解密方法直接调用(纯代码,无需内存/播放)。脚本 find_decrypt_methods/find_ttencrypt/
hook_ttcrypto/inspect_encryptorutil.js + enc_exports.py。
- **libttcrypto.so = BoringSSL**(导出AES_set_encrypt_key/AES_ctr128_encrypt/EVP_*等标准AES)。但hook这些
  (base+offset绕namespace, 5/6成功)播放视频时**全不触发** → BoringSSL是给TLS/网络用的, **视频不走它**。
  (注: 之前§3"hook AES 0命中"是hook了系统libcrypto, 库都错了)。
- **libEncryptor.so 的 `EncryptorUtil.ttEncrypt(byte[],int)`**(`com.bytedance.frameworks.encryptor.EncryptorUtil`,
  native `([BI)[B`): hook到实际调用, 但输入是 **gzip数据(1f8b08..)** → 是**通用网络/日志数据加密**, **非视频**。
- 结论: 视频内容密钥的AES-CTR**不在**libttcrypto标准AES, 也不在EncryptorUtil; 在 AVMDL(libavmdlv2)/libdragoncore
  内部 或 硬件AES路径。**线索**: `EVP_DecryptInit_ex` Frida报"unable to intercept"没hook上, 视频若走它则被漏掉(待换hook法重试)。
- ⚠ 重型 Java.enumerateLoadedClasses + 逐类Java.use 会**搞崩app**(已踩坑), 类名过滤要轻量。
- 可调方法发现法: 直接从.so的.rodata扫JNI签名(`([B...)[B`/`Ljava`)+方法名, 比运行时枚举快且不崩(enc_exports.py)。

**当前最优仍是**: 已验证的离线提密钥(raw key内存暴力+counter-diff, §14) 或 keystream+counter-diff限定密钥盒区(§15.6);
"主动调用纯代码"需先定位视频AES在哪个lib的哪个函数(libavmdl/dragoncore, 或换法hook EVP_DecryptInit_ex)。

### 15.8 决定性: 视频AES在libavmdl内部(自带S-box), 无导出函数可hook/调用(2026-06-01)
静态扫描(scan_avmdl_crypto.py)决定性结论:
- **libavmdlv2.so 自带 AES S-box(@0x4e081f)+InvSbox** → 内部有**自己的软件AES实现**。
- 它虽 import 了 libttcrypto 的 AES_set_encrypt_key/set_decrypt_key/AES_cbc_encrypt, 但 hook 这些(及AES_encrypt)
  播放时**全不触发** → 视频AES-CTR走的是**libavmdl内部AES(自带S-box)**, 不是libttcrypto导出函数。
- libavmdlv2 导出的非系统函数只有 registerIoCtrl* (无任何crypt/aes导出); libEncryptor 有InvSbox(自带AES解密表)
  但其Java可调ttEncrypt是gzip+网络加密(§15.7)。
- **结论**: 没有"可按名hook/主动调用"的视频解密导出函数。纯代码主动调用路**封闭**。要纯代码只能:
  ①Ghidra逆 libavmdlv2 内部AES(找S-box@0x4e081f的xref→AES/CTR函数→hook取key+counter); 或 ②逆spade_a。
- **可hook技巧已备**: base+offset 绕 linker namespace 隔离有效(libttcrypto验证); 找到内部AES函数偏移后可同法hook。

**全局最终结论**: 解密已攻破(§14, 离线全速解出可播视频)。产品化取key+iv三条路:
①已验证: 内存raw-key暴力+counter-diff(§14); ②设计待跑: keystream+counter-diff限定密钥盒区(§15.6, ~10-20s/视频);
③纯代码: Ghidra逆libavmdl内部AES或spade_a(§15.8/15.5)。"主动调用导出函数"已排除(§15.7/15.8)。

### 15.9 🔑 Ghidra逆向: 精确定位视频解密函数(libavmdlv2内部AES) (2026-06-01)
装好 Ghidra 12.1 + JDK21(tools/), headless反编译流水线可用(frida/ghidra_decompile.py + ghidra_xref.py +
ghidra_callers.py; 脚本 tools/ghidra_scripts/*.java)。
- libEncryptor 反编译(71函数): JNI只有ttEncrypt, 核心是3个6476字节OLLVM平坦化函数, 是gzip+网络加密, **非视频**(印证§15.7)。
- **libavmdlv2.so 内部AES = 视频解密**, S-box@vaddr 0x5e081f(文件偏移0x4e081f), Rcon@0x5e091f。15个函数引用S-box。
- **精确函数地图(libavmdlv2 vaddr偏移, 运行时=base+偏移)**:
  - **FUN_0053d77c(out, key)** = AES-128密钥扩展(44字=11轮密钥). **param_2(x1)=原始16字节内容密钥**。
  - **FUN_0053d890(ctx, key, iv)** = AES-CTR初始化: 调0053d77c扩展key + 把IV存到ctx+0xb0/0xb8.
    **x1=内容密钥(16B), x2=IV(16B)** —— 一个hook同时拿key+iv, 最理想hook点。
  - FUN_0053e1a0(ctx, data, len) = CTR流解密(XOR keystream@ctx+0xb0, 每块调0053d8b8);
    FUN_0053d8b8 = AES块(keystream生成)。
- **Frida hook已就绪**(frida/hook_ctrinit.js, base+offset绕namespace, 验证地址有效可attach):
  hook FUN_0053d890 读 x1=key/x2=iv。**但实测75s+多轮都0触发** → 模拟器播放窗口内**无新流AES解密发生**
  (播的是缓存/离线tunneled, 不走libavmdl在线AES-CTR)。需真正的**全新在线streaming**解码才会调用。

### 15.10 现状与两条收尾路(2026-06-01)
- **活体hook取key+iv**(hook_ctrinit.js, FUN_0053d890): 技术就绪, 仅差"模拟器稳定地对全新在线视频做AES-CTR解密"
  的环境(反复实测无法稳定触发; 缓存/离线播放不走此路径)。环境配合时一击即得key+iv。
- **纯静态逆spade_a**(env无关): 追 FUN_0053d890 的 param_2(内容密钥) 上游调用链 → spade_a(37B)→16B 解包算法。
  深度OLLVM, 多轮静态分析。ghidra_callers.py 可逐层找调用者反编译。
- 已验证可用的离线解密(§14, raw-key内存暴力+counter-diff)仍是最稳妥的产品化基础。

### 15.11 静态逆 spade_a 调用链 — native解密链已完整, spade_a解包在Java侧(2026-06-01)
用 ghidra_callers.py 逐层上溯 FUN_0053d890, 完整映射 libavmdlv2 的 native 流解密链:
- **FUN_0053d890(ctx,key,iv)** [AES-CTR init] ← **FUN_00501b8c / FUN_00501c8c** [解密分发器: switch(*method) 0=无/
  1,3=轻量XOR(异或0x74链)/2=AES-CTR; key=ctx+8, iv=ctx+0x18] ← **FUN_0050424c(用ctx=*(parent+0xd8))** /
  **FUN_004b5f78(用ctx=*(parent+0x140))** ← (13+个调用者, 发散; 解密是通用流接口)。
- FUN_00501da0(ctx,method,data,len): 仅当 AES且data<16B 时用0x74补齐padding, 与密钥无关。
- **关键定论**: **libavmdlv2.so 内无 spade_a/encrypt_info/cenc 字符串** → spade_a 的JSON解析在**Java侧**;
  且内存"密钥盒"是 **Java 标签化map(二进制kid+16Bkey)** → **spade_a(37B)→16B内容密钥的解包发生在 Java 侧
  (或经JNI的native unwrap), 不在native AES解密链内**。native 只是从 ctx+8 取已备好的key做CTR。
- **继续逆 spade_a 的正确方向 = 分析 Java/APK 侧**: 用 jadx 反编译 base.apk, 找处理 encrypt_info.spade_a→
  填充密钥盒(kid->key byte[])的类/方法; 它可能纯Java实现, 或调某native(libEncryptor的非ttEncrypt函数?)。
  ctx+8 的key由Java经 AVMDLDataLoader 的 native API(addDataSource/setStringValue等)传入native。
- 务实对比: 逆spade_a跨Java↔native+OLLVM, 是多日工程; 而 hook FUN_0053d890 取key+iv(§15.9)只差解码环境。

### 15.12 keybox 离线自动提取脚本(2026-06-03)
新增脚本 `frida/extract_keybox_pairs.py`，把之前手工 hexdump 的 keybox 规则固化为可复用流程：

- 从内存 dump 自动抽 `mKid -> mSpadea`，兼容 `\u003d` 转义。
- 扫描 32B keybox 条目：`01 0d 01 00 00 00 | tag2 | 0000000000000000 | value16`。
- 分类规则：`value.endswith(ebeb)` 为二进制 kid；`value[8:16]==0` 为 IV；高熵 16B 值为内容 key 候选。
- 对 kid 后 256B 内的 key 候选投票，并输出 `capture/spade_key_pairs.auto.json`。

在 `capture/e4.bin` 上复现出干净真值对：

```text
kid   = 67d5371af8818b65b34888ad000debeb
spade = oLwu8GKMJcdovBD3Qbs86kCSC9hapSP1c4gO9Ee+Ou51oj2urg==
key   = e65f045ea495e9cb439fa87fed02d756
```

运行结果：

```text
entry_counts={'kid': 13583, 'iv': 13581, 'key': 2, 'other': 6}
mspade_kids=25 keybox_kids=1
kid=67d5371af8818b65b34888ad000debeb key=e65f045ea495e9cb439fa87fed02d756 votes=2 spade_count=1
```

意义：现在已经不只是单组手工配对，而是能从 dump 自动 join 出 `spade_a + content key`。下一步若要继续纯静态破解 `spade_a -> key`，这条真值对就是确定样本；若走工程化预言机，则此脚本可作为离线验证器和 keybox 结构回归测试。

继续批量跑现有 dump：

```text
python frida/extract_keybox_pairs.py capture/dump.bin      -o capture/spade_key_pairs.dump.json
python frida/extract_keybox_pairs.py capture/e3.bin        -o capture/spade_key_pairs.e3.json
python frida/extract_keybox_pairs.py capture/eg.bin        -o capture/spade_key_pairs.eg.json
python frida/extract_keybox_pairs.py capture/sync_dump.bin -o capture/spade_key_pairs.sync_dump.json
python frida/extract_keybox_pairs.py capture/dump_live.bin -o capture/spade_key_pairs.dump_live.json
python frida/analyze_spade_key_pairs.py
```

得到 5 组带 `spade_a + key` 的真值样本：

```text
67d5371af8818b65b34888ad000debeb -> e65f045ea495e9cb439fa87fed02d756
68216156f8818b3795bfd2050003ebeb -> 5ad820e74bc5bda386bc3c41cf0d099f
6a158fe8f8818b1740e098760002ebeb -> 5ad820e74bc5bda386bc3c41cf0d099f
69c75860f8818b5bd43a21e40002ebeb -> 77214d4b196a87cd520045fd20a51d67
6a1593a8f8818ba14ea950b50002ebeb -> b6509a236622f23ce3fc4c2f33164577
```

`frida/analyze_spade_key_pairs.py` 的低成本假设检验结果：

```text
pairs=5
subblock_hits=0
constant_xor_masks=0
byte_xor_candidates=0
same_key_groups=1
```

结论：`spade_a -> key` 不是直接子串、固定 16B XOR 掩码、或单字节固定 XOR 映射。两条不同 `kid/spade_a` 解出同一个 key，说明同一内容 key 可被不同包装 blob/track 引用；后续纯静态应继续定位 Java/native unwrap 函数，而不是再试简单线性规则。

---

## 16. 接力指南 / Handoff Guide（2026-06-04，本节面向新接手者，自包含）

> 目的：不读完 §1–§15 也能快速接力。本节汇总「加密方案 / 完整逆向流程与关键节点 / 当前卡点 / 后续方向 / 文件清单 / 环境坑」。**后续每有进展，请在 §16.10 进度日志追加，并同步更新对应小节。**

### 16.0 一句话现状
红果视频加密=**标准 CENC AES-128-CTR**，密码学层面**已完全攻破**（§14）。

**🎉🎉 2026-06-04 终极攻破：纯离线 `spade_a→content key` 已 100% 复现（无 KEK、无 AES、无 app/播放/frida）**
- `content key` 由 `spade_a` 经 **`libttmplayer.so FUN_001c4550` 的纯字节变换**算出（XOR + POPCOUNT + 位置相关 + 按首字节 hex 值切片）。**根本不是 AES、没有 KEK**——这正是 §16.6-B 里所有 AES-KEK 暴力全失败的原因（方向错在 libavmdl + 假设 AES）。在 Mac arm64(无 Houdini→backtrace 可用) 上 hook `av_dict_set("decryption_key")` 回溯定位到。
- `base_iv64` 直接从密文 mp4 的 **senc 盒**读（标准 CENC），不需要 keybox。
- 纯 Python：`frida/unwrap_spade.py`(spade→key 算法, 5组真值+独立验证的 e4 对全命中) + `frida/offline_decrypt.py`(`spadeA+密文mp4→明文mp4`)。**Windows 实证**：e4 仅用 spade(base64)+密文文件 → 5575/5575 样本合法、ffprobe 抽帧成功。
- 完整复盘见 **`docs/逆向复盘-spade解密-20260604.md`**。

⇒ 现在通用下载器**只有签名一环还需 app**(取 spade_a + main_url 直链)，**解密完全离线纯 Python**。
历史上的两条路（已被纯离线方案取代，保留作背景）：
- **(A)** 运行时密钥盒预言机 `frida/downloader.py`（播放时 dump 内存提 key，已实时打通）—— 现不必，留作不便取 spade 时的备用。
- **(B)** 曾假设 unwrap 是 libavmdl 内嵌静态 KEK 的 AES → **方向完全错**（实际在 libttmplayer 且是纯字节变换，无 AES）。见 §16.6-B 踩坑。

### 16.1 加密方案（完全确定）
- 算法：**AES-128-CTR**，**全样本加密**（含每样本开头 4 字节 NAL 长度前缀也加密；CTR 原点=样本起点）。
- per-sample IV(16B) = `((base_iv64 + 样本序号) << 64)`（高 64 位=base_iv64+idx，低 64 位=块计数器从 0）。
- 每个视频：`content key(16B)` 按 **kid** 唯一（同一视频多清晰度共享 kid/key）；`base_iv64` 按**清晰度/track**。
- 实测真值见 §16.8。

### 16.2 端到端解密流水线（已验证，`frida/decrypt_full.py`）
输入：CDN 密文 mp4（可直链下载，无需登录）+ `key` + `base_iv64`。
步骤：解析 moov/stsz/stco/stsc 得视频样本 (offset,size) → 逐样本 `AES-128-CTR(key, IV=((base_iv64+idx)<<64))` 解密整样本 →
校验：解密后头 4 字节=NAL 长度，链式走到样本尾即合法。e4 实测 5575/5575 样本合法，ffmpeg 零错误。

### 16.3 spade_a → 内容密钥 全链路架构（本次重大成果）
```
服务器 video_info JSON  (encrypt_info: {encrypt:true, kid, spade_a})
  │  spade_a = base64( 37 字节包装 blob )；kid = 16 字节 CENC Key ID
  ▼  [Java, base.apk, jadx 反编译于 capture/jadx_spade/]
VideoModelPb.EncryptInfo{encrypt,kid,spadeA}
  → VideoInfo.mSpadea / TTVideoEngineImpl.setEncodedKey()→mSpadea(只写不读)
  → (decryption_key 字段→setDecryptionKey→mDecryptionKey→拼进 _mdlUrl；spade_a 走另一路)
  ▼  [native, libuniplayer.so 主app arm64]
FUN_0010fc78@0x10fc78  JSON 解析器：encrypt→struct+0x300, kid→+0x308, spade_a→+0x320, decryption_key→+0x378（仅存储，不解包）
FUN_0010ed1c@0x10ed1c  struct→struct 搬运：spade→下游+0xd0, kid→+0x100（仅搬运）
  ▼  [native, libavmdlv2.so —— 解包 + 解密都在这]
??? 解包函数（未定位）：spade(37B) --内嵌静态 KEK 的 AES--> content key(16B)，写入「密钥盒」
密钥盒(kid→key→base_iv) ──> AES-CTR 解密链：
  FUN_00501b8c/FUN_00501c8c [分发器 switch(method): 2=AES-CTR, key=ctx+8, iv=ctx+0x18]
  → FUN_0053d890@0x53d890 [CTR init: x1=key16, x2=iv16]
  → FUN_0053d77c@0x53d77c [AES-128 密钥扩展, 自带 S-box@vaddr0x5e081f]
  → FUN_0053e1a0 [CTR 流解密]
```
关键事实：
- **libuniplayer 无任何 crypto 导入**，只解析/搬运 spade。
- **libavmdl 自带的自定义 AES（FUN_0053d77c）只服务视频解密**，**不参与** spade 解包（其唯一调用者是 FUN_0053d890）。
- mdl url 格式 `mdl://id34/?rk=<vid>&k=<file_hash>&p=<本地缓存路径>&u0=<CDN源URL>`——**`k=` 是 file_hash 不是密钥**（曾踩坑）。

### 16.4 内存密钥盒结构（已破解 —— 预言机的基础）
libavmdl 进程内存中，密钥盒是类型化条目数组，**每条 32 字节**：
```
[01 0d 01 00 00 00][2B tag][8B 00 00 00 00 00 00 00 00][16B value]
```
三类 value（同一视频的 kid/key/iv 聚在 ~256B 簇内，但**非固定 kid-then-key 顺序**，是 hashmap 桶）：
- **kid**：末 2 字节 = `eb eb`（红果 kid 形如 `<4B时间戳>f8818b<3B>00 0? eb eb`）。
- **key**：16 字节全高熵（0 字节少、后 8 字节非 0、不以 0000 结尾）。
- **IV**：高 6–8 字节 = base_iv（如 `8a3366122cfe..` / `a4d4ed0ed2fc..`），低 8–10 字节=0；低位 2 字节=per-sample 索引；其中**最小**的那条高 8 字节即 `base_iv64`（sample0）。
提取脚本 `frida/extract_keybox_pairs.py`（扫条目+分类+对 kid 邻域投票配 key）→ `capture/spade_key_pairs.*.json`。
⚠ 只有**正在解码**的视频其 key 才在密钥盒（e4.bin ✓）；只加载 video_model 不解码、或离线/缓存视频，密钥盒里没有该 key（e3.bin/dump_live.bin 提到的是指针/邻值，需 §16.6-A 校验）。

### 16.5 spade_a→key 已排除的假设（**勿重复**，全部实测否）
1. ❌ libavmdl 自带自定义 AES 参与解包（FUN_0053d77c 只被视频路径调用）。
2. ❌ Java 侧 javax.crypto/Cipher（ttvideoengine 无任何 crypto 调用；SDK 不在 Java 解包）。
3. ❌ 简单位置 XOR 静态 keystream：用 e4 的 `key‖base_iv` 反推 KS 套 live 密文解密，遍历偏移/布局/字节序全失败。
4. ❌ kid 作 KEK 的 AES-ECB/CBC/CTR；kid/key/base_iv 三者间任意 XOR。
5. ❌ 简单 hash 派生 `key=md5/sha1/sha256/sha512(spade[+kid/salt])[:16|-16]`、双重 md5。
6. ❌ key 为 spade 的子串 / 固定 16B XOR 掩码 / 单字节固定 XOR 映射（`analyze_spade_key_pairs.py`：subblock_hits=0, constant_xor_masks=0）。
7. ❌ 服务器下发：e4.bin 无 get_key/license/drm 取密钥 URL（0 命中）；key 不以 hex/base64 文本出现在任何字段 → **端上本地计算**。
spade 结构观察（标准 base64 解码后 37B）：跨视频 `byte[1]=0xbc` 恒定、`byte[0]` 高位 9/a、`byte[35]==byte[36]`；raw 37B 解码后**不留内存**（仅 base64 字符串 + 最终 key 共存）。

### 16.6 后续方向（三条，含怎么做）
**(A) 运行时密钥盒预言机【已实现并端到端验证 ✅，推荐】**
- 一键脚本 **`frida/oracle.py`** 已就绪：`pidof → 拉smaps → 选rw驻留native段 → 设备端 dd+gzip dump → 拉回 → extract_keybox_pairs 提取 → 打印 kid→key→base_iv`。
- **自动验证取代「猜」**：`python frida/oracle.py --verify <下载的密文.mp4>` —— 从 dump 收集所有 key + 所有 iv8(高8字节)，对密文逐 (key×base_iv) 试解首 2 个视频样本，**NAL 链合法者即真值**（免 IV 歧义、免 key 假阳）。
- **端到端实证(2026-06-04)**：`oracle.py --reuse capture/e4.bin --verify capture/e4_match.mp4` 自动选出 `key=e65f045ea495e9cb439fa87fed02d756, base_iv64=8a3366122cfe6f54`，与已验证真值完全一致。
- 完整下载流程：① app 播放目标【在线流】视频(画面在动=解码中) → ② 下载其 CDN 密文(main_url 在 API 响应/内存) → ③ `python frida/oracle.py --verify <密文>` 取 key+base_iv → ④ `decrypt_full.py` 解密。
- **全自动下载器 `frida/downloader.py`（✅ 已实时端到端打通）**：一次 dump 同时抽 `mVideoId(vid)/mMainUrl(CDN密文直链)/mKid` + 定位正在解码的 kid + 全部 key 候选 + 全部 `iv8`，下载 CDN 密文→`verify_key_iv`(全部key×iv8 试解首样本,NAL自证)→`decrypt_full`→输出 mp4。
  - 用法：`python frida/downloader.py`(自动下正在解码的) / `--vid <vid>` / `--list` / `--reuse <dump>`。
  - **2026-06-04 实时实证成功**：播放在线短剧→`downloader.py`→自动下载5清晰度密文→正在解码的那个(8448KB)试解出 `key=8dd3292893cb77f16dd101c82a31b125, base_iv=9992303cb5408974`→解密 **5244/5244 样本合法**→ffprobe: HEVC 1920×1080 / 174.8s / 抽帧成功=真实画面。
  - **关键修正(踩坑)**：①**不能靠"投票"选 key**——`77214d4b196a87cd520045fd20a51d67` 这种值在多个 kid 邻域反复出现(全局x4)、骗过熵过滤、是**假阳**；正解=收集全部 distinct "key"分类值(本 dump 仅5个)，**交给密文 `verify` 定真伪**(首块快筛 5key×40279iv 秒级)。②"正在解码的视频"靠"kid 簇内有 key 条目"识别(可靠)，但 key 真值必须密文自证。③只有**正在解码的那个清晰度**的 base_iv 在内存(app 只解一路)，故对每个下载的清晰度都试解、命中者即播放清晰度。
  - 音频 track(aac)也随容器解出可播(仅一个无害 AAC-LC 警告)；如需音频独立解密另议(可能同 key 不同 base_iv)。
- ⚠ 注意：①只对【在线流】有效(缓存/离线视频内存无 key/spade)；②base_iv 邻域关联不可靠(dump 多视频 IV 交织)，故**必须用 --verify 拿密文试解**而非取邻域 iv；③`oracle.py`(无参)的表格里 base_iv 仅供参考，以 --verify 结果为准。
- 待办：自动从 dump 提取 main_url 并直链下载(token 有期)；验证「程序化 prepare 触发 key 入内存」(不必真播)。

**(B) 离线纯代码逆 spade_a→key【纯静态通解，工作量大；2026-06-04 多轮排查后重大修正】**
- **静态密码分析已穷尽且全否**：对 e4 验证对，暴力遍历二进制每个16/32字节窗口当 KEK，测 AES-ECB(enc/dec)、CBC(相邻块链)、CTR(nonce=spade[:16]/0/kid)，覆盖 libavmdl/libttcrypto/libuniplayer/libEncryptor/libdragon_crypt → **全部无命中**。结论：**KEK 不是二进制里的明文常量**（被混淆/运行时组装/白盒）。也排除 hash 派生(md5/sha[+kid/salt])。
- **libavmdl 的 AES 是红鲱鱼（动态证实）**：libavmdl 同时有正向S-box@0x5e081f(CTR用)和**逆S-box@0x5e092a**，后者对应 AES-decrypt 链：`FUN_0053dc84`(AES-128-ECB-dec单块,逆S-box)←`FUN_0053e31c`(CBC-dec)←分发器`FUN_00501c8c`(method=2; key@ctx+8, iv@ctx+0x18)。**曾以为这是 spade 解包**。但 Frida hook 这些函数(及 CTR init `FUN_0053d890`、分发器)，**播放+12次切集全程零触发**(而 hook libc `open` 正常触发 25次/15s，证明 Frida 工作)。
- **⇒ 重大修正**：**spade→key 解包不在 libavmdl**；libavmdl 的 AES 在播放/prepare 期都不被调用，它只**持有/存储**密钥盒里已解好的 key；**真正解包在上游 Java 或 JNI native**，算出 key 后经 AVMDL API 塞进 libavmdl 密钥盒；播放解码走 MediaCodec 安全路径。
- **继续 B 的正确方向**：① 反编译 **base.apk 全部 26 个 dex**(目前只反编译了 classes6/16)，找消费 `spade_a`/`getSpadea()`→产出 key 的类(可能在 com.dragon.read app 层而非 ttvideoengine SDK)；② 或 hook **把 key 写入 libavmdl 密钥盒的那个 native setter**(AVMDLDataLoader.setStringValue / JNI)，捕获 key+backtrace 定位上游 Java 解包器；③ 或在 prepare 瞬间(attach 在先、打开**从未加载过**的全新剧)catch 上游 unwrap——注意普通切集/自动下一集是预加载/缓存,不触发新鲜 unwrap。
- cryptanalysis 需 ≥2 组**完全一致**的 `(spade, key, base_iv, 密文)` 配对（目前仅 e4 完整；downloader 的 verify 可为任意在播视频产出验证过的真值对，用于扩样本）。

**(C) 多配对辅助【为 B 提供样本】**
- `focused_brute.py`/`brute_e3.py`：对「解码瞬间」的内存 dump 做 counter-diff 爆破取 key（§14）。⚠ e3.bin 已试，AES-128 全扫**无果**（dump 时密钥已释放）——必须 dump「正在解码」的瞬间。
- 拿到第 2 组验证配对后重跑 `analyze_spade_key_pairs.py` 扩展假设（AES-ECB 静态 KEK 结构检验等）。

### 16.7 关键文件 / 脚本 / 数据清单
脚本（`frida/`）：
- **`downloader.py`** —— 全自动下载器（输入 vid/自动识别正在播放 → dump→提取 vid/main_url/kid/key/iv→下载 CDN 密文→试解验证→输出解密 mp4）。三段逻辑已验证，待实时实证。
- **`oracle.py`** —— 运行时密钥盒预言机一键工具（dump→提取→`--verify <密文>` 自动选出正确 key+base_iv）。✅ 已端到端验证。
- `decrypt_full.py` —— 给定 key+base_iv 端到端解密+校验（核心，已验证）。
- `extract_keybox_pairs.py`（被 oracle.py 复用）+ `analyze_spade_key_pairs.py` —— 从内存 dump 提 keybox 并 join spade，跑假设检验。
- `focused_brute.py` / `brute_e3.py` —— counter-diff 内存爆破 key（需「解码瞬间」dump）。
- `spade_struct.py` / `spade_structure2.py` —— spade 跨样本结构对比。
- `hook_ctrinit.js` —— Frida hook FUN_0053d890 取 key+iv（base+offset 绕 namespace；需在线流解码环境才触发）。
- `ghidra_decompile.py / ghidra_xref.py / ghidra_callers.py / ghidra_strxref.py` —— Ghidra headless 流水线（`JAVA_HOME=tools/jdk21`，脚本在 `tools/ghidra_scripts/*.java`：DecompAll/FindAESXref/FindCallers/**FindStrXref**）。
工具（`tools/`，已 gitignore，需本地保留）：`jadx/`（1.5.1）、`ghidra_12.1_PUBLIC/`、`jdk21/`。
反编译产物（gitignore）：`capture/jadx_spade/`（base.apk 全反编译）、`capture/decomp_libuniplayer.so.c`、`capture/strxref_libavmdlv2.so.c`、`capture/callers_libavmdlv2.so.c`。
.so（从设备拉取，`capture/so/`）：libavmdlv2 / libuniplayer / libttmplayer / libvcn / libttcrypto / libEncryptor / libdragon_crypt …
内存 dump（多 GB，`capture/*.bin`）：e4.bin（含已解码视频，keybox 有真 key）、e3.bin、dump.bin、dump_live.bin。
APK：本地 `base.apk`(131MB)；插件 `capture/apk/{player,awemevideo}.apk`。

### 16.8 真值样本（可复用做 cryptanalysis / 回归测试）
```
kid      = 67d5371af8818b65b34888ad000debeb
key(16B) = e65f045ea495e9cb439fa87fed02d756        # 与 e4_match.mp4 解密验证一致
base_iv64= 8a3366122cfe6f54                          # 注: base_iv 按清晰度, key 按 kid
spade_a  = oLwu8GKMJcdovBD3Qbs86kCSC9hapSP1c4gO9Ee+Ou51oj2urg==
spade(37B)= a0bc2ef0628c25c768bc10f741bb3cea40920bd85aa523f573880ef447be3aee75a23daeae
```
（`extract_keybox_pairs.py` 在各 dump 上还产出过 4 组「kid→key」候选，但仅 e4 经解密验证；其中两组共享同一 key 疑为启发式误配，使用前须校验。）

### 16.9 环境与坑（接力必看）
- MuMu12 + Frida；签名栈是**生产后端**，勿冻死。app pid 频繁变（动态 pidof）。
- **只有在线流视频（首页新刷、非下载/缓存）**才在堆生成含 spade_a 的 video_model + 填充密钥盒；离线/缓存走 tunneled 安全路径，内存无 spade，预言机/MediaCodec 都抓不到。**测试必须用全新在线视频**。
- 视频加载失败先查模拟器 WireGuard 是否误开（死隧道断网）。
- 重型 Frida 操作（枚举 10 万类）会搞崩 app。`dd /proc/pid/mem` 取 smaps 必须 `su -c '单字符串'`。
- auto-mode 分类器会拦 `python frida/*`、`git`，已在 `.claude/settings.local.json` 加 allow 规则（需用户手动加，我无法自编辑该文件）。
- ⚠ 仓库历史里有多 GB 的 `capture/*.bin` 被跟踪（历史遗留），新增大文件请确认 .gitignore。

### 16.10 进度日志（按时间倒序追加）
- **2026-06-04（全局并发上限+跨剧并行）**：重构编排层为全局线程池(SeriesCtx/_prepare/run_jobs/_episode_task)。`-c`改为**全局并发上限**(跨剧共享, 总同时下载+解密任务 ≤ -c); `batch` 把多剧待下集汇入**同一个池**→跨剧并行(而非逐剧串行)。每集仍更新各自剧状态(续传+增量落盘), 全局失败重试轮。实证: batch 两剧各2待下 -c4 → 4集(两剧)同池同时启动交错完成, 各剧独立汇总(81/81+23/23), 批量104/104。
- **2026-06-04（清晰度选择）**：offline_dl 加 `-q` 选清晰度(best/worst/1080p/720p/540p/480p/360p, 不存在取≤请求最高档) + `quals <vid>` 列可选清晰度。实测5档: 360/480/540/720p=**bytevc2(bvc2)**, 1080p=**bytevc1(HEVC,通用可播)**; `-q 720p` 正确下载720×1280解密5053/5053。注: bytevc2 解密正确但需兼容解码器播放, 1080p(HEVC)通用。同集不同清晰度文件名相同会跳过。
- **2026-06-04（完整一键工具打通）**：把 Mac 的 `offline_dl.py` 接到 Windows `hongguo.py`(API+签名)，做成 `搜索/榜单/选集→自动下载→纯离线解密→可播mp4`。修复 `hongguo.py` 死锁(Mac复盘②): `_oracle_lock` Lock→**RLock**(sign()持锁内调oracle()重入, 进程内frida签名必死锁; 之前search挂死167s即此)。**实证**: `python offline_dl.py series 7607003595136846872 1` → 全新剧《皇后她自带江山》第1集 → content key=e1ef2219.. (纯算法) + senc base_iv → 解密 5053/5053 → ffprobe HEVC 1080×1920/168s/抽帧成功。用法: `offline_dl.py search "剧名"` / `rank` / `series <id> [1-5]` / `vid <vid>`。签名仍需模拟器跑红果+frida16.x; 解密纯离线。
- **2026-06-04（终极攻破，纯离线 spade→key 复现）**：Mac arm64(无Houdini,backtrace可用)上逆出真正的 unwrap = **`libttmplayer.so FUN_001c4550`**(ver1路径), 纯字节变换(XOR+POPCOUNT+位置相关+按首字节切片), **无KEK无AES**。定位法: hook `av_dict_set("decryption_key")`(在libttffmpeg)回溯, 整条栈在libttmplayer; base_iv从密文senc盒读。纯Python复现 unwrap_spade.py(5真值+独立e4对全命中)+offline_decrypt.py。**Windows实证**: offline_decrypt 用e4 spadeA+e4_match.mp4 → 5575/5575合法、ffprobe抽帧成功, 全程无app/keybox/frida。⇒ §16.6-B "内嵌KEK的AES在libavmdl"方向被证伪(真在libttmplayer且非AES)。ver2(app_v2/web_v2)走AES-GCM-256+MD5(KEK)当前未用。整合: 新增 unwrap_spade.py/decutil.py/offline_decrypt.py/hook_unwrap_ttm.py/grab_avdict_keys.py; 复盘 docs/逆向复盘-spade解密-20260604.md。
- **2026-06-04（A0：现成工具在当前环境复验通过 + 性能实测 + 弯路纠正）**：
  - **目的**：接手后先验证 §14/§16 的解密工具链当前是否仍可用，再决定产品化。
  - **① 工具完好性（环境无关）**：`python frida/oracle.py --reuse capture/e4.bin --verify capture/e4_match.mp4`
    → 自动选出 `key=e65f045ea495e9cb439fa87fed02d756, base_iv64=8a3366122cfe6f54`，与 §16.8 真值**逐字节一致**。
    （注：报告表里 `base_iv=a4d4ed0e..` 是邻域启发式误值，以 `--verify` 结果为准——符合 §16.6-A 既述。）
  - **② 当前环境实时端到端**：`python frida/downloader.py`（全自动）再次跑通——播放在线短剧→实时 dump（417MB 驻留/56s）
    →自动识别正在解码 `vid=v02ebeg10000d8g31ovog65ilud8fa4g`(kid=`6a2030e3f8818b2af9a87a890002ebeb`)→下 5 清晰度密文逐一密文自证
    →命中 **key=`ecfe21991e52d78ce771ead1c2bd5341`, base_iv64=`135130ab6c057dc9`**→解密 **1580/1580 样本 NAL 合法**
    →ffprobe `HEVC 1080×1920 / 52.7s`、抽帧=真实剧集画面。**⇒ 解密工具链当前环境完好可用**。
  - **③ 性能实测（产品化估时依据）**：单视频 ≈ **5–8 min**，瓶颈是 dump——dd `conv=noerror,sync` 把 417MB 驻留
    **零填充膨胀到 ~12GB**，扫描慢。**最大优化杠杆 = 只 dump 真正驻留页**（预计单视频降到 ~1–3 min）。可多设备并行线性扩展。
  - **④ 方案 A（产品化解密预言机）工期评估**：A.1 程序化触发指定 vid 播放(deeplink/UI 自动化, **工期决定项+主风险**) 0.5–2 天
    + A.2 封装预言机接 hglocal 0.5–1 天 + A.3 健壮性 0.5–1 天 = **共 ~2–4 天**；硬约束：**仅在线流有效**（半实时，需 app 真播一下目标视频）。
  - **⚠ 弯路纠正（接手者勿重蹈）**：本轮一度重走 **aeskeyfind 找 AES 轮密钥扩展(176B)** —— 这是 **§13 已实测证伪**的死路
    （字节用硬件/自定义 AES，标准轮密钥扩展**不在内存**，只有原始 16B key 在）。扫到 17 个合法轮密钥候选但对密文全不匹配＝必然结果。
    **正解＝§16.4 的密钥盒 32B 条目提取**（`[01 0d 01 00 00 00][2B tag][8B 0][16B value]`，按 kid 尾 `ebeb`/高熵 key/低位零 iv 分类），已封装在 `oracle.py`/`downloader.py`。
- **2026-06-04（深夜4，JNI 抓到 spade 但 Houdini 挡住回溯）**：hook JNI `GetStringUTFChars`(JNIEnv vtable idx169, hook_jnistr.js)匹配 base64 spade 串+Thread.backtrace → **成功捕获多个 spade 经 JNI 传入 native**(证实解包确在 native)；但 **backtrace 全部指向 `libhoudini.so+0x3561a8`**。⇒ **MuMu 是 x86 模拟器, 用 Houdini 把 ARM 翻译成 x86 执行, Frida 的 native 调用栈被 Houdini 翻译层挡住, 无法回溯到真正的 ARM 调用者(=解包函数)**。这是**环境硬墙**: 在 Houdini 下定位 native 调用者不可行。**破法**: ①换**真 ARM 设备/纯 ARM 模拟器**(无 Houdini)→backtrace 可用→可直接定位 native 解包入口; ②纯静态 RE 混淆 native(无回溯辅助, 很难)。**有用副产物**: hook_jnistr.js 能可靠批量抓 spade(可配合 keybox 取 key 攒大量验证对做密码分析)。
- **2026-06-04（深夜3，Java crypto 也排除）**：hook 密钥盒 setter 反查上游——先在 **Java 层 hook `javax.crypto.Cipher.init/doFinal`**(hook_cipher.js, 最可靠), 清缓存+自动播放全新视频 → **0 个 crypto 事件**。⇒ **解包不在 Java javax.crypto**。结合前述(libavmdl AES 全零触发、无明文 KEK), **spade→key 解包在混淆 native 代码且不用标准 AES 原语**(无法按名/Java层 hook)。libavmdl 模块 `Process.findModuleByName` 返回 null(namespace 隔离), 枚举导出需用 enumerateRanges 取 base 手动解析。**剩余离线避头(均高成本/不确定)**: ①catch 密钥盒写入(硬件 watchpoint, Frida JS 不易); ②hook JNI 边界(GetStringUTFChars 匹配 spade 串)在新鲜 prepare 时反查 native 入口——受"新鲜 prepare 时机"制约(切集/自动下一集是预加载, 普通播放不触发新鲜 unwrap); ③深逆混淆 native(可能白盒)。**务实结论再确认**: 纯离线(API→key)是大工程且可能白盒不可解; **运行时密钥盒下载器 `downloader.py` 已验证可用, 是这类 App 离线下载的标准做法**。
- **2026-06-04（深夜2，libavmdl 彻底排除-定论）**：补 hook 逐块 CTR 解密 `FUN_0053e1a0`(视频解码热路径) + 清空 .mdl 缓存强制全新下载，自动点击/下滑播放全新视频 → **CTR_RUN 仍零触发**(连同 init/分发器/CBC/AES-dec)。**定论：libavmdl 完全不参与视频解密，只持有密钥盒**；视频解密走 **MediaCodec 安全路径**(key 交硬件/安全解码器)，spade→key 解包在**上游 Java/JNI**。⇒ 我在 libavmdl AES 上的逆向方向被彻底排除。**真正可行的离线方向**收敛为：①反编译全部 dex 找 Java 解包(但 classes16 的 Cipher/SecretKeySpec 经查是腾讯/银联/小米推送 SDK 的，非视频; Java 标准 crypto 不是解包器→解包很可能是 JNI native); ②hook 把 key 写入 libavmdl 密钥盒的 JNI setter, 反查上游解包 native 库(疑 libttmplayer/libvcn/一个未分析的 ByteDance security 库)。**务实结论**: 纯离线(API→key 无 app)仍未攻破; 已验证可用的是运行时密钥盒下载器(§16.6-A, 需 app 加载视频)。
- **2026-06-04（深夜，离线逆向重大修正）**：穷尽静态 KEK 暴力(全库×ECB/CBC/CTR×16/32B×nonce变体)→无明文 KEK(混淆/白盒)。Ghidra 经逆S-box@0x5e092a 定位到 libavmdl 的 AES-decrypt 链(dc84←e31c-CBC←分发器501c8c)，曾判定为 spade 解包；但 Frida 实测(hook_unwrap.js: 分发器/CTR init/CBC/AES-dec 块)播放+12次自动切集**全程零触发**，而 libc open 对照触发正常→**证实 libavmdl AES 与 spade 解包/视频解码无关，仅持有密钥盒**。**结论修正**：解包在上游 Java/JNI，libavmdl 只存 key。新增 hook_unwrap.js/run_keyiv.py/FindInvSbox.java。**下一步**：反编译全部 dex 找 Java 解包器，或 hook 密钥盒 setter 反查上游。
- **2026-06-04（晚，🎉 全自动下载器实时打通）**：`frida/downloader.py` 实时端到端成功——播放在线短剧→一键 dump→下载5清晰度密文→正在解码的(8448KB)密文试解出 `key=8dd3292893cb77f16dd101c82a31b125, base_iv=9992303cb5408974`→解密 5244/5244 合法→ffprobe HEVC1080p/174.8s/抽帧成功。**关键修复**：弃用"投票选 key"(假阳 `77214d4b…` 在多 kid 邻域反复出现 x4 骗过熵过滤)，改为"收集全部 distinct key 分类值(本 dump 仅5个)交密文 verify 定真伪"+首块快筛(5key×40279iv 秒级)；"正在解码视频"靠 kid 簇内有 key 条目识别。坑续：mMainUrl 多为释放截断 std::string，取无\x00+长+闭引号的干净 URL。音频另议。
- **2026-06-04（晚，全自动下载器初版）**：实现 `frida/downloader.py` 框架（dump→抽 vid/main_url/kid→keybox key→下载→verify→decrypt）。三段单测通过；首次实时跑暴露"投票选 key"假阳问题(见上条修复)。坑：内存里 mMainUrl 很多是被释放/截断的 std::string，需取干净 URL。
- **2026-06-04（晚，选定方向A）**：实现运行时密钥盒预言机一键工具 `frida/oracle.py`：自动 pidof→拉smaps→选rw驻留段→设备dd+gzip→拉回→提取 kid/key/base_iv；并加 `--verify <密文>` 模式（收集全部 key×iv8，对密文试解首2样本，NAL合法即真值，免猜）。**端到端验证通过**：`--reuse capture/e4.bin --verify capture/e4_match.mp4` 自动选出与真值一致的 `key=e65f045e…, base_iv64=8a3366122cfe6f54`。修正 `extract_keybox_pairs.py` 的 base_iv64 取值（主导前缀组最小iv8，但邻域法不可靠→实际以 --verify 为准）。**下一步**：自动提 main_url 直链下载做成完整一键下载器；或回到 §16.6-B 逆 KEK。
- **2026-06-04**：完成 spade_a 全链路定位（Java→libuniplayer→libavmdl）；破解内存密钥盒 32B 条目结构；确认 key 端上本地计算（无取密钥 URL）；排除 §16.5 全部假设；确证 e4 真值配对。结论：spade→key 用内嵌静态 KEK 的 AES（疑 BoringSSL 路径），KEK 未定位。`brute_e3.py` 对 e3.bin AES-128 全扫无果（dump 时密钥已释放）。新增 `FindStrXref.java`/`ghidra_strxref.py`。**下一步**：§16.6-A（预言机一键化）或 §16.6-B（在 libavmdl 定位 BoringSSL AES 的静态 KEK 调用点）。
