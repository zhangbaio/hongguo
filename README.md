# 红果短剧下载器

通过逆向红果短剧(com.phoenix.read, 字节系)的接口实现的命令行下载器。
核心难点是字节的 X-Argus/X-Gorgon 签名(native层、几分钟过期),
方案是用 **Frida 签名预言机**——让模拟器里的 app 自己算签名,Python 调用。

## 架构

```
搜索 search/tab/v ─→ series_id
   │
multi_video_detail ─→ 全部剧集的 vid
   │
multi_video_model ──→ video_model.main_url (真实MP4直链)   ← 需要签名
   │                         ↑
   │              Frida预言机(app内NetworkParams.tryAddSecurityFactor)
   │
GET main_url ───────→ 下载 mp4
```

## 运行环境(一次性配好,已完成)

- **MuMu12 模拟器**(安卓12, 已root), adb 端口 127.0.0.1:16384
- 红果 App 已安装(com.phoenix.read 7.2.2.32)
- **frida-server** x86_64 16.7.19 在 /data/local/tmp/frida-server
- 宿主机: Python + frida + requests + mitmproxy(仅解析抓包用)
- `config.json`: 设备参数+会话凭证(从抓包提取, 见 extract_config.py)

> 注意: 下载器**不需要** WireGuard/mitmproxy 代理。那套是当初抓包发现接口用的。
> 现在 API 请求从宿主机直连字节服务器,签名由 Frida 预言机(运行中的app)提供。

## 用法

**每次先启动预言机环境:**
```powershell
.\start_oracle.ps1
```
(确保 MuMu 开着 + frida-server 跑着 + 红果 app 在前台/后台运行)

**然后用下载器:**
```powershell
# 搜索短剧
python hongguo.py search "极品皇太子"
#   7638207474180312089  [81集] 极品皇太子  - 站在你面前的...

# 列出某剧全部剧集
python hongguo.py episodes 7638207474180312089

# 漫剧榜单(推荐榜/热播榜/新剧榜), 可指定数量
python hongguo.py rank recommend 30   # 推荐榜
python hongguo.py rank hot            # 热播榜
python hongguo.py rank new            # 新剧榜
#   → 列出排名/剧名/集数/评分/播放量/series_id, id可直接喂download

# 今日上新(按体裁), 加 --all 则为最新上架全部
python hongguo.py latest short_play     # 短剧今日上新
python hongguo.py latest comic_series   # 漫剧今日上新
python hongguo.py latest ai_series      # AI短剧今日上新
python hongguo.py latest short_play --all  # 短剧最新上架(不限今日)

# 下载(集号范围 / 单集 / 全部)
python hongguo.py download 7638207474180312089 1-10
python hongguo.py download 7638207474180312089 5
python hongguo.py download 7638207474180312089        # 全部81集
python hongguo.py download 7638207474180312089 1-10 --ep-covers  # 同时下每集封面
```

下载到 `downloads/<剧名>/`，包含:
- `<剧名>_第NNN集.mp4` —— 视频 (1080p)
- `cover.heic` —— 整剧封面
- `info.json` —— 完整元数据(简介/演员表/分类/状态/播放量/全集清单)
- `<剧名>_第NNN集.jpg` —— 每集封面(加 `--ep-covers` 才下)

### 能获取的信息
- **搜索**: series_id、剧名、集数、评分、热度/播放量、出品方、简介、封面
- **详情(episodes / info.json)**: 上述 + 演员表(演员/角色/头像/简介)、完结状态、
  上线时间、追剧数、分类标签，以及每集的(标题/时长/封面/评论数/点赞数)

## 访问控制(API 密钥)
服务端(server.py)**强制鉴权**: 所有数据接口必须带有效 `api_key`(请求头 `X-API-Key` 或 `?api_key=`)，否则 401。
- 密钥存于 `apikeys.json`(不进仓库)，在管理页 **`/admin`** 一键生成/吊销/删除(需 `ADMIN_TOKEN`)。
- `ADMIN_TOKEN` 等放 `.env.ps1`(不进仓库，模板 `.env.ps1.example`)，`start_all.ps1` 自动加载。
- 客户端(如 weixin 工具的"本地链路密钥"、网页 `/ui` 的 api_key 框)填生成的密钥即可。
- `/`、`/ui`、`/img` 免鉴权(页面/封面)；`/admin`、`/stats` 需 `ADMIN_TOKEN`。

## 关键文件

| 文件 | 作用 |
|------|------|
| `hongguo.py` | **主下载器**(search/episodes/download) |
| `frida/oracle.js` | Frida 签名预言机(rpc.exports.sign) |
| `config.json` | 设备参数+会话凭证 |
| `start_oracle.ps1` | 一键启动预言机环境 |
| `extract_config.py` | 从抓包重新提取 config |
| `parse_flow.py` | 解析 capture/out/full.flow(抓包分析) |

## 凭证失效时

`config.json` 里的 `x-tt-token`/cookie 是登录态,长期有效但可能过期。
失效后重新抓一次包(WireGuard模式, 见 git 历史/capture 目录), 跑 `extract_config.py` 更新。

## 局限

- 依赖模拟器当签名机(app 必须运行)。app 大版本更新后签名入口类名可能变,需重新定位。
- 视频直链(main_url)约6小时过期,但下载器是实时获取的,不受影响。
