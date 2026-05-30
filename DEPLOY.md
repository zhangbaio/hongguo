# 红果短剧 API 服务 — 部署说明

## 架构(三层,签名后端可插拔)

```
                    ┌─────────────────────────────────────┐
  客户端(浏览器/    │  API服务器  server.py  (FastAPI :8000) │
  app/脚本) ──HTTP─→│  /search /rank /episodes /play /stream│
                    └───────────────┬─────────────────────┘
                                    │ HTTP(取签名)
                    ┌───────────────▼─────────────────────┐
                    │  签名服务  sign_server.py  (:8001)    │  ← 可替换
                    │  持有签名预言机                        │
                    └───────────────┬─────────────────────┘
                                    │ 签名后端(选一种)
                    ┌───────────────▼─────────────────────┐
                    │  A) Windows: MuMu12 + Frida (当前)    │
                    │  B) Linux服务器: redroid(Docker安卓)  │  ← 推荐上线用
                    │     + frida-server                    │
                    └──────────────────────────────────────┘

视频字节流: 客户端拿到 main_url 后【直连字节CDN】下载, 不经过服务器(省带宽)。
           (若客户端无法直连CDN, 用 /stream 让服务器代理)
```

## 本地运行(当前 Windows + MuMu)

```powershell
# 1. 起签名后端环境(MuMu+frida+app)
.\start_oracle.ps1

# 2. 起签名服务
python sign_server.py            # :8001

# 3. 起API服务器(指向签名服务)
$env:SIGN_SERVER="http://127.0.0.1:8001"
python server.py                 # :8000

# 客户端测试
curl "http://127.0.0.1:8000/rank?board=recommend&limit=10"
curl "http://127.0.0.1:8000/search?q=极品皇太子"
curl "http://127.0.0.1:8000/play?series_id=7638207474180312089&ep=1-5"
```

## 客户端接口

| 接口 | 说明 |
|------|------|
| `GET /search?q=剧名` | 搜索,返回剧列表(series_id/标题/集数/评分/封面) |
| `GET /rank?board=recommend\|hot\|new&limit=30` | 漫剧榜单 |
| `GET /latest?genre=short_play\|comic_series\|ai_series&only_today=true` | 今日上新/最新上架(短剧/漫剧/AI短剧) |
| `GET /episodes?series_id=xxx` | 某剧全部剧集+元数据(演员表等) |
| `GET /play?series_id=xxx&ep=1-10` | 取真实视频直链(客户端直连CDN下载) |
| `GET /stream?series_id=xxx&ep=1` | 服务器代理串流(客户端不便直连CDN时) |

## 上线到 Linux 服务器(推荐方案: redroid)

签名后端从 MuMu 换成 **redroid**(Android in Docker, 专为服务器设计):

```bash
# 1. 宿主机需 Linux + 内核binder模块(redroid要求)
docker run -itd --privileged --name redroid \
  -v ~/redroid-data:/data -p 5555:5555 \
  redroid/redroid:12.0.0-latest

# 2. adb 连接, 装红果apk + frida-server(x86_64), 同当前流程
adb connect localhost:5555
adb install base.apk
# push frida-server, 启动, adb forward 27042

# 3. 改 sign_server.py / hongguo.py 里的 ADB 路径和 DEV 为 localhost:5555
# 4. 起 sign_server.py + server.py
# 5. API服务器可独立扩容(无状态), 签名服务按需多开
```

注意: redroid 需要宿主机内核有 binder/ashmem 模块(主流云厂商裸金属或特定内核支持)。
普通 KVM 云主机可能要装内核模块。备选: 物理机/安卓云手机服务商。

## 凭证

`config.json` 的 cookie/x-tt-token 是某个登录账号的会话态。多客户端共享这一份即可
(都用服务器这个账号的态)。过期则在签名后端的设备上重登录并重抓 config(extract_config.py)。

## 风控与优化(safeguards.py)

**风险集中点**: 所有请求共用同一 device_id + 账号(x-tt-token) + 服务器IP。
**好消息**: /play 让客户端直连CDN下视频, 下载IP分散在各客户端, 不集中在服务器;
真正暴露的只有服务器发的API调用(搜索/榜单/video_model)。

已内置防护(safeguards.py, 自动生效):
- **缓存**: 搜索10min / 榜单30min / 剧集列表6h / 视频直链5h(url_expire约6h)。
  实测二次请求 0.57s→0.012s 且**不再向字节发请求**, 砍掉绝大多数请求量。
- **节流**: 令牌桶+最小间隔+随机抖动, 控制对字节QPS, 模仿人类节奏(safeguards.Throttle)。
- **风控识别**: check_response 检测限流/验证码码与关键词, 命中抛 RiskControlError 供上层退避。

**上规模(多用户)还需**:
- 多账号/多设备池: 多个 redroid 实例(各自 device_id+token), 轮换分摊, 每个待在阈值下。
  签名服务可做成池, server.py 轮询多个 SIGN_SERVER。
- 别瞬间拉整部剧的 video_model: 已按5集/批; 大批量下载建议加间隔、错峰。
- CDN下载若同IP量大被限: 客户端直连已天然分散; 服务器代理(/stream)模式才需IP池。
- 触发验证码时: 在签名后端设备上人工过一次验证/重登, 刷新 config。

## 注意/局限
- 签名后端(模拟器/redroid + app)必须常驻运行。
- 签名服务有全局锁串行化, QPS 受单设备签名速度限制(约每秒数十次)。高并发可多开签名后端做池。
- 视频直链 url_expire 约6小时, 但都是请求时实时取, 不存储, 不受影响。
