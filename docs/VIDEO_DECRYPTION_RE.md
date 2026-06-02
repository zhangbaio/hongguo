# 红果视频解密 逆向进度与后续思路

> 状态：**视频解密已攻破（思路 D：MediaCodec 明文捕获法，已端到端验证出可播画面）**，
> 但该法**实时(1x, ~1集/分钟)**。提速探索见「§8」：所有"快过实时/离线破解"路线在当前环境均被堵死
> （AES + OLLVM 无符号 + 无 S-box + 模拟器 5.7GB 内存 + 播放时钟限速），**能落地的提速只有并行化 MediaCodec 抓取**。
> 详见文末「§7 突破」「§8 吞吐探索」「§9 标准CENC定性」「§10 离线提密钥可行性修正」。下方 §1~§6 为攻破前的探查记录，保留作背景。
>
> **§10 关键修正(2026-06-01)**：①§8 "5.7GB 内存扫不完" 判断有误——进程 **RssAnon 仅 ~684MB**（驻留），
> 5.7GB 是虚拟映射，aeskeyfind 实际只需扫驻留堆，**离线提密钥可行性大幅提升**；②video_model（含
> spade_a/kid/main_url）**可在内存中快速 Memory.scan 命中**，且 CDN 密文可直链下载 → 已具备"对齐的密文+
> 元数据"；③`check_info` 的 `c:`/`e:` 是 **AVMDL 下载完整性 CRC**（头部+首1KB），**不是加密范围图**，
> 实测确认仍是**全样本 AES-CTR**（逐视频密钥）。
> ⚠ **风险**：本机 MuMu+frida 签名栈是线上生产签名后端，提密钥的内存操作须用 root shell 读
> `/proc/mem`（独立进程，不碰 frida）以免冻死签名，且建议在低峰授权时段进行。
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
