# 本地签名 + 云转发 部署(已完成)

## 架构

```
公网客户端
   │  http://hongguo.momotools.top/ui   (或 http://<SERVER_IP>:39001/ui)
   ▼
[云 <SERVER_IP>]  nginx:80 ──反代──> 127.0.0.1:39001
                                          │ (SSH反向隧道, GatewayPorts)
   ════════════════════════════════════════│════ 公网
                                          ▼
[你本地 Windows]  deploy/tunnel.py ──> server.py:8000 ──> sign_server:8001 ──> MuMu(红果签名)
                                         (鉴权/限流/缓存)   (看门狗/自动重连)
```

视频下载: 客户端拿到 main_url 后【直连字节CDN】, 不经过隧道/服务器。

## 已完成(本会话)

云端(<SERVER_IP>, 宝塔nginx):
- SSH GatewayPorts 已开; frps 已停用(改用SSH隧道,避免frp被Defender拦)
- nginx 反代 vhost: `hongguo.momotools.top` -> 127.0.0.1:39001 (已 reload, 实测通)
- SSH 公钥已装(deploy/id_hongguo), 隧道免密码

本地:
- deploy/tunnel.py: 纯Python SSH反向隧道(密钥认证, 自动重连), 把云39001->本地8000
- start_all.ps1: 一键拉起 frida环境+sign_server+server+tunnel

## ✅ 已全部完成(含HTTPS)

- DNS: hongguo.momotools.top -> <SERVER_IP> (已加A记录,权威已生效)
- HTTPS: Let's Encrypt 证书(EC-256, acme.sh webroot签发, 装到BaoTa证书目录,
  自动续期已配 reloadcmd, 下次约2026-07-29)。nginx 80->443跳转 + 443反代。
- 实测: HTTP->301跳转, HTTPS->200证书校验通过, /rank返回真实数据。

**公网访问: https://hongguo.momotools.top/ui**

(deploy/issue_cert.py 是签发脚本; 续期由 acme.sh cron 自动处理)

## 日常使用

本地开机后(MuMu开着):
```powershell
cd D:\code\hongguo
.\start_all.ps1        # 拉起全栈(frida/sign/api/tunnel)
```

验证:
```powershell
# 本地
curl http://127.0.0.1:8000/stats
# 公网(DNS或安全组就绪后)
curl http://hongguo.momotools.top/rank?board=hot&limit=5
```

## 开机自启(可选, 持久化)

把 start_all.ps1 注册为登录启动任务:
```powershell
schtasks /create /tn HongguoStack /tr "powershell -WindowStyle Hidden -File D:\code\hongguo\start_all.ps1" /sc onlogon /rl highest
```

## 安全

- 服务器密码建议改掉(对话里发过明文), 已配SSH密钥可关闭密码登录。
- 公开服务建议给 server 设 API_KEYS(环境变量)启用鉴权, 见 server.py / DEPLOY.md。
- 隧道私钥 deploy/id_hongguo 妥善保管。
