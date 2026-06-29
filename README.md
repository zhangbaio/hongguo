# 红果短剧下载器（全自动 · 纯离线解密）

逆向红果短剧（com.phoenix.read，字节系）实现的命令行下载器：**搜索/榜单 → 选清晰度 → 整剧批量 → 多线程并发 → 断点续传 → 纯离线解密 → 可播 mp4**。

两个核心难点都已攻破：
1. **接口签名** X-Argus/X-Gorgon（native、几分钟过期）→ **Frida 签名预言机**（模拟器里 app 自己算签名，Python 调用）。
2. **视频加密** 标准 CENC **AES-128-CTR**，每集密钥由 `spade_a` 经 **`libttmplayer.so` 内纯字节变换**算出（**无 KEK、无 AES**）→ 已 100% 纯 Python 复现，**解密全程离线**（无需 app/播放/frida）。

> 逆向全过程见 `docs/VIDEO_DECRYPTION_RE.md`（§16 接力指南）与 `docs/逆向复盘-spade解密-20260604.md`。

---

## 完整链路

```
search/tab/v ─→ series_id
  │
multi_video_detail ─→ 各集 vid
  │
multi_video_model ─→ video_model           ← 需要签名(Frida预言机)
  │   ├─ video_list[].main_url              (CDN 密文直链)
  │   ├─ video_list[].encrypt_info.spade_a  (★ 包装的内容密钥)
  │   └─ video_list[].video_meta.definition (清晰度)
  │
  ├─ unwrap_spade(spade_a) ──→ content key(16B)   [纯算法, 无KEK, 无app]
  ├─ GET main_url ───────────→ 下载 CDN 密文 mp4
  ├─ 密文 senc 盒 ───────────→ base_iv64(8B)
  └─ AES-128-CTR(key, IV=((base_iv+样本序号)<<64)) 逐样本解密 ─→ 明文 mp4
```

**只有"调 API 取 spade+直链"这一步需要签名（模拟器+app）；下载与解密完全离线纯 Python。**

---

## 快速开始

```powershell
# 0) 启动签名环境(MuMu + frida-server + 红果 app 运行)
.\start_oracle.ps1

# 1) 搜索
python offline_dl.py search "皇后"
#   7607003595136846872  [81集] ★8.1  皇后她自带江山

# 2) 下载整剧(自动下载+解密, 默认1080p, 4线程, 断点续传)
python offline_dl.py series 7607003595136846872

# 3) 看进度 / 断点续跑
python offline_dl.py status 7607003595136846872
python offline_dl.py resume 7607003595136846872
```
输出到 `downloads/<剧名>_第NNN集.mp4`（可播 mp4）。

---

## 命令速查（`offline_dl.py`）

| 命令 | 说明 |
|---|---|
| `search "剧名"` | 搜索短剧 → series_id/集数/评分/剧名 |
| `rank [recommend\|hot\|new]` | 榜单 |
| `quals <vid>` | 列某集全部可选清晰度（分辨率/大小/编码） |
| `series <series_id> [范围] [选项]` | 下载整剧/范围（`1-5` / `3` / `all`默认） |
| `resume <series_id> [选项]` | 只补未完成/失败集（断点续传） |
| `status <series_id>` | 看进度（已完成/失败集+错误） |
| `vid <vid> [文件名] [-q]` | 下载单集 |
| `batch <id1> <id2> ... [选项]` | **多剧并行**（所有剧待下集汇入同一全局池） |

**通用选项**：

| 选项 | 含义 | 默认 |
|---|---|---|
| `-c N` `--concurrency` | **全局并发上限**（跨剧共享，总同时下载+解密任务 ≤ N） | 4 |
| `-r N` `--retry` | 失败集自动重试轮数 | 2 |
| `-q Q` `--quality` | 清晰度：`best`/`worst`/`1080p`/`720p`/`540p`/`480p`/`360p`（或纯数字）；指定档不存在则取 ≤ 请求的最高档 | best |

**示例**：
```powershell
python offline_dl.py series 7607003595136846872 1-20 -c 6 -q 1080p
python offline_dl.py vid 7607005789365996568 -q 720p
python offline_dl.py batch 7607003595136846872 7632308004930456638 -c 6
python offline_dl.py quals 7607005789365996568
```

---

## 纯离线解密（无需 app / 网络 / frida）

已有 `spade_a`(base64) + 密文 mp4 时，直接本地解密：

```powershell
python frida/offline_decrypt.py "<spade_a_base64>" <密文.mp4> [输出.mp4]
# 自动: unwrap出key + senc读base_iv + key×base_iv试解(NAL自证) + AES-CTR全解
```

只算密钥（验证算法）：
```powershell
python frida/unwrap_spade.py                 # 跑内置真值自测(5/5 passed)
python frida/unwrap_spade.py <spade_a_base64> # 输出 content key(32 hex)
```
> 依赖仅 `pycryptodome`（解密用）；`unwrap_spade` 纯标准库。

---

## 对外服务（`server.py`）

FastAPI 服务，`/stream` 端点**服务端纯离线解密后**串流可播 mp4（首次下载+解密并缓存到 `downloads/.stream_cache/`，之后秒回；支持 HTTP Range 拖动）。

```bash
python server.py            # 或 uvicorn server:app --host 0.0.0.0 --port 8000
# 取流(可播, 非密文):
#   /stream?series_id=<id>&ep=1&api_key=<key>
#   /stream?vid=<vid>&quality=1080p&api_key=<key>
# <video> 标签无法带请求头, 用 ?api_key= 传密钥
```
- `/play` 返回每集的 `encrypted_url`(CDN 密文直链) + `stream_url`(服务端解密的可播端点)。
- 数据接口强制 `api_key`（`X-API-Key` 头或 `?api_key=`）；`/admin` 用 `ADMIN_TOKEN` 管理密钥。

**分类筛选接口**：
```bash
GET /filters?genre=comic_series                                  # 某体裁全部筛选条件(实时)
GET /browse?genre=ai_series&theme=玄幻&setting=逆袭&sort=hot_score&days=7&status=已完结&limit=60
#   各维度传中文名或id(cate_xxx); 多选用逗号(theme=玄幻,科幻); 中文需URL编码
#   维度: theme主题 setting设定 background背景 sort排序 gender受众 days时间 status状态(仅漫剧)
#   每个结果项含 stream_url(直接播第1集) + episodes_url(列全集, 再 /stream?series_id=&ep=N 播其它集)
```
对应 `hongguo.py` 的 `H.filters(genre)` / `H.browse(genre, theme=, setting=, background=, sort=, gender=, days=, status=)`。
全部维度与选项 ID 见 `capture/{ai_series,comic_series}_filters.json`。

## 清晰度与编码（重要）

| 清晰度 | 编码 | 播放 |
|---|---|---|
| **1080p** | bytevc1 = **HEVC** | ✅ 通用，任意播放器 |
| 720p / 540p / 480p / 360p | **bytevc2**（bvc2，字节自研） | 解密正确，但需**支持 ByteVC2 的播放器**（ffmpeg 内置不解 bvc2） |

日常建议默认 **1080p（HEVC，通用可播）**。低清晰度省空间，但播放需兼容解码器。
> ⚠ 同一集换清晰度因文件名相同会被"已存在"跳过——换清晰度需先删旧文件或用 `vid` 自定义名。

---

## 断点续传与状态

- 每集完成**即时落盘** `downloads/.state/series_<id>.json`（记 `vid/status/file/error/attempts`）。
- 重跑自动**跳过已完成**（校验文件仍在，删了会重下），只补未完成/失败集 → 中断后 `resume`/重跑即续传。
- 单次运行内失败集**自动多轮重试**（`-r`，带退避）；`dl_vid` 内层另有 2 次重试（url 过期自动重取 video_model）。
- `status` 查看进度与失败原因。

---

## 运行环境（签名所需；解密不需要）

- **MuMu12 模拟器**（安卓12，已 root），adb `127.0.0.1:16384`
- 红果 App 已安装运行（com.phoenix.read）
- **frida-server 16.x**（与宿主机 frida-python **同版本**；frida 17 移除内置 Java bridge → `oracle.js` 的 `Java.use` 报错）
- 宿主机 Python：`frida==16.x`、`pycryptodome`、`requests`
- `config.json`：设备参数 + 会话凭证（见 `extract_config.py`）
- 环境变量（默认即本机 MuMu，可覆盖）：`ADB` / `ADB_DEVICE` / `FRIDA_HOST`(默认 127.0.0.1:27042)
- 签名后端：默认进程内 Frida；也可设 `SIGN_SERVER=http://...`（HTTP 签名服务，多设备池轮询）

> 下载器**不需要** WireGuard/mitmproxy 代理（那是当初抓包发现接口用的）。

---

## 关键文件

| 文件 | 作用 |
|---|---|
| **`offline_dl.py`** | **全自动下载器**（搜索/榜单/选集/清晰度/并发/续传/重试/解密） |
| `frida/offline_decrypt.py` | 纯离线解密：`spade_a + 密文 → 明文 mp4` |
| `frida/unwrap_spade.py` | `spade_a → content key` 纯算法（含真值自测） |
| `frida/decutil.py` | senc 读 base_iv / tenc kid / AES-128-CTR 全解 |
| `hongguo.py` | API 客户端（search/rank/get_episodes/get_video_urls）+ 签名 |
| `frida/oracle.js` | Frida 签名预言机（hook NetworkParams.tryAddSecurityFactor） |
| `config.json` | 设备参数 + 会话凭证（不入库） |
| `start_oracle.ps1` | 一键启动签名环境 |
| `docs/VIDEO_DECRYPTION_RE.md` | 逆向主文档（§16 接力指南） |
| `docs/逆向复盘-spade解密-20260604.md` | spade 解密逆向完整复盘 |
| `docs/DOUYIN_BOARD_RE.md` | 抖音短剧榜接口逆向复现手册（公开接口直采） |
| `docs/KUAISHOU_BOARD_RE.md` | 快手短剧榜接口逆向复现手册（拉 KRN bundle 读源码） |

> 逆向/调试工具（非日常使用）：`frida/hook_unwrap_ttm.py`、`grab_avdict_keys.py`、`tools/ghidra_scripts/*`。

---

## 常见问题

- **search/API 卡死不返回**：旧版 `_oracle_lock` 死锁（已修为 `RLock`）。确认 `hongguo.py` 中是 `threading.RLock()`。
- **`'Java' is not defined`**：frida 17 移除内置 Java bridge → 降到 frida 16.x（server + python 同版本）。
- **下载的 mp4 打不开/花屏**：多半是 360–720p 的 **bytevc2** 需兼容解码器；改用默认 1080p（HEVC）。
- **main_url 过期**（约 6h）：实时取，正常不受影响；批量很久没动可 `resume` 重取。
- **凭证失效**：`config.json` 的 `x-tt-token`/cookie 过期，重抓包跑 `extract_config.py` 更新。
- **签名入口失效**：app 大版本更新后 hook 类名可能变，需重新定位 `oracle.js`。

---

## 局限

- 取 `spade_a`+直链需模拟器跑 app 提供签名（解密本身离线）。
- 低清晰度 bytevc2 播放需兼容解码器。
- `spade` 目前为 ver1（纯字节变换）；代码里另有 ver2（`app_v2`/`web_v2`，AES-GCM-256+MD5(KEK)）当前红果视频未用，如出现需补 `unwrap_spade` 的 ver2 分支。
