# 红果视频解密 逆向进度与后续思路

> 状态：**视频解密已攻破（思路 D：MediaCodec 明文捕获法，已端到端验证出可播画面）**，
> 但该法**实时(1x, ~1集/分钟)**。提速探索见「§8」：所有"快过实时/离线破解"路线在当前环境均被堵死
> （AES + OLLVM 无符号 + 无 S-box + 模拟器 5.7GB 内存 + 播放时钟限速），**能落地的提速只有并行化 MediaCodec 抓取**。
> 详见文末「§7 突破」「§8 吞吐探索」。下方 §1~§6 为攻破前的探查记录，保留作背景。
>
> 最后更新：2026-06-01

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

### 操作安全须知(接力必看)
- **不要在跑签名的 frida agent 里做重型同步操作**(会阻塞 JS 线程→签名挂)；必须 `setTimeout` 分块让出，
  或用独立手段(原生工具/离线 dump)。踩坑恢复法：`pkill frida-server` 重启, sign_server 看门狗自动重连。
