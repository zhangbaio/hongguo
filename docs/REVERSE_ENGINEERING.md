# 红果短剧 接口逆向 — 思路与实现方案

> 仅供学习研究。红果短剧 = 字节跳动 `com.phoenix.read`（fqnovel 系，aid=8662）。
> 本文记录从零抓包逆向到可用下载服务的完整思路。

## 0. 目标与难点

目标：拿到红果短剧的 **搜索 / 榜单 / 今日上新 / 视频下载** 接口，做成可编程调用的服务。

字节系 App 的三道坎（逐一击破）：
1. **核心接口走 TTNet（自研网络库），绕过系统 HTTP 代理** → 普通抓包抓不到内容接口。
2. **SSL Pinning** → 即使解了 HTTPS，主接口域名也校验证书。
3. **签名墙 `X-Argus/X-Gorgon/X-Ladon`** → native 层（libmetasec_ml.so）实时计算、几分钟过期，离线无法复现。

## 1. 抓包环境

- **模拟器选型**：腾讯 Androws 自带 **ACE 反作弊**，阻断 adb/Frida → 弃用。改用 **MuMu12（安卓12，可一键 root）**。adb 端口 `127.0.0.1:16384`，`su` 可用。
- **系统证书**：安卓7+ 默认不信任用户证书。把 mitmproxy CA 按 hash 命名（`openssl x509 -subject_hash_old` → `c8750f0d.0`）装到 `/system/etc/security/cacerts/`（需 root remount）。
- 验证：模拟器浏览器访问 `mitm.it` 能出页面 = 代理+证书通。

## 2. 第一坎：TTNet 绕代理 → WireGuard 模式

现象：设了系统 HTTP 代理后，**图片/okhttp 杂务接口抓得到，但搜索/详情/播放等内容接口抓不到**——因为 TTNet 优先走 QUIC(UDP 443) 且无视系统代理直连。

解法：**mitmproxy WireGuard 模式**（`mitmdump --mode wireguard`）。模拟器装 WireGuard 客户端，把**整机流量用 VPN 隧道兜进 mitmproxy**，无视任何代理设置。配合系统证书即可解密 TTNet 的 TCP/TLS。
- 坑：每次重启 mitmdump 都会让 WG 会话失效，要在模拟器里 toggle 隧道重连。
- 用 `mitmdump -w full.flow` 原始存盘，再用官方 `FlowReader` 解析（不依赖 addon，最可靠）。

## 3. 第二坎：SSL Pinning → 自动降级域名

诊断：在 addon 里 hook `tls_clienthello` / `tls_failed_client` 打印每个连接的 SNI 和握手结果，发现：
- 主域名 `api5-normal-lq.fqnovel.com` → TLS 握手**全部失败**（pinning）。
- 但 App 自动降级到备用域名 **`api5-normal-sinfonlinea.fqnovel.com`** → 握手**成功、可解密**！

结论：**直接用不带 pinning 的备用域名** `api5-normal-sinfonlinea.fqnovel.com` 即可。

## 4. 第三坎：签名墙 → Frida 签名预言机（核心）

请求头带 `X-Argus / X-Gorgon / X-Ladon / X-Khronos`，由 `libmetasec_ml.so`(arm64, 4MB, OLLVM 混淆+VM 保护) 实时计算。
- 实验证明：抓到的旧签名重放 `POST` 视频接口 → `Code 110001`（时效校验失败）。**离线无法复现**。
- **Dump 内存 / 反编译 APK 都拿不到**：签名是纯函数实时算，算法在混淆的 native 机器码里，Java 层只是 JNI 声明。

**解法 — Frida 签名预言机**（不破解算法，让 App 自己算）：
1. MuMu 无 ACE，可跑 frida-server。但 MuMu 是 x86_64 + houdini 翻译 arm 库，**native 层 hook 不可靠** → 改在 **Java 层 hook**（绕开翻译）。
2. 枚举发现签名入口：
   `com.bytedance.frameworks.baselib.network.http.NetworkParams.tryAddSecurityFactor(String url, Map headers)`
   输入 url + 请求头(Map<String,List<String>>，含 `x-ss-stub`=body 的 MD5 大写)，
   输出新鲜 `X-Argus/X-Gorgon/X-Ladon/X-Khronos/X-Helios/X-Medusa`。
3. 用 `frida/oracle.js` 把它暴露成 `rpc.exports.sign(url, headers)`；Python 调它为任意请求签名。
4. 验证：用新签名重发 `multi_video_model` → `code=0`，拿到全新视频直链。**打通！**

详见 `frida/oracle.js`、`sign_server.py`、`test_oracle.py`。

## 5. 核心接口（主机 `api5-normal-sinfonlinea.fqnovel.com`，HTTPS+签名）

| 用途 | 接口 |
|------|------|
| 搜索 | `GET /reading/bookapi/search/tab/v?query=剧名` → `search_tabs[].data[]`(book_id/vid/集数...) |
| 剧集详情 | `POST /novel/player/multi_video_detail/v1/` body `{series_id}` → `video_data.video_list[]`(全集 vid) |
| 视频直链 | `POST /novel/player/multi_video_model/v1/` body `{mixed_video_id_map:{"1":[vid...]}}` → `video_model.video_list[].main_url`(CDN直链,~6h有效) |
| 漫剧榜单 | `POST /reading/distribution/category/landpage/v`(其实是榜单 cell) 或 `bookmall/cell/change/v`(cell_id=7470092475068071998,tab_type=26,sub_selected_items=comic_series_hot_rank/hot_play/new_rank) |
| 筛选/最新上架 | `POST /reading/distribution/category/landpage/v` body `select_items.genre=[short_play|comic_series|ai_series], sort=[online_time], online_time=[days_7]` |

视频文件直链：`v*-reading-video*.qznovelvod.com/.../video/tos/cn/...`（206 可分段，自包含签名，普通 GET 即可下，**不需要 X-Argus**）。

**今日上新判断**：短剧的列表项 `sub_title_list` 含 `"今日上新"` 文本(官方标签，精确)；漫剧/AI 官方无今日粒度(最细 days_7，且不暴露上线时间)，只能取「7天内·最新上架」。

## 6. 实现架构

```
[客户端] → server.py(FastAPI) → sign_server.py(Frida预言机,看门狗自重连) → MuMu红果App签名
                │  搜索/榜单/今日上新/取直链              │
                ▼                                         ▼
           safeguards: 缓存+节流+风控识别+重试      X-Argus等签名
视频字节流: 客户端直连字节CDN下载(不签名,不占服务器带宽)
```

- `hongguo.py`：API 客户端(search/rank/latest/episodes/get_video_urls) + 下载管理器调用 + CLI。
- `sign_server.py`：独立进程持有 Frida 预言机（**必须独立**，frida reactor 与 uvicorn 事件循环会死锁）；看门狗 15s 巡检，App/frida 掉了自动重连。
- `server.py`：REST 接口 `/search /rank /latest /episodes /play /video_url /download /stream /img /stats`，可选 API_KEYS 鉴权+限流。
- `downloader.py`：并发 + 断点续传(Range) + 直链过期自动重取 + 元数据(info.json/tvshow.nfo)。
- `safeguards.py`：TTL 缓存(可选 Redis)、令牌桶节流、风控/登录态识别。
- `web/index.html`：网页客户端(搜索/榜单/今日上新/下载，HEIC 封面经 /img 转 JPEG)。

## 7. 部署

- **本地**：`start_all.ps1`（MuMu + sign_server + server）。
- **公网**：本地签名 + 云服务器 frp 隧道 + nginx 反代 + Let's Encrypt HTTPS（见 `deploy/`、`DEPLOY.md`）。
- **纯云端(自给)**：需 ARM64 主机 + redroid(Docker 安卓) 跑 App 当签名后端（红果仅 arm64-v8a 库），见 `redroid/`。
- **彻底脱机签名(未做)**：unidbg 在桌面 JVM 跑 libmetasec_ml.so，但其反模拟器极难，数天且中等成功率。

## 局限
- 签名后端(真机/模拟器/redroid + App)必须常驻。
- `config.json` 的 token/cookie 是登录态，过期需重抓(`extract_config.py`)。
- 漫剧/AI 今日上新官方 API 做不到精确(无上线时间字段)。
