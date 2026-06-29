# 全栈上云部署(unidbg 离线签名)

把「签名 + 搜索/取直链 + 下载 + 解密 + 重封装」整条流水线**全部跑在 Linux x86_64 云主机**上。

> **这份取代什么**:旧方案 [`deploy/README.md`](README.md)(「本地签名 + 云转发」)因为签名离不开本地 MuMu+红果 app+frida,
> 只能把签名留在本地、用 SSH 隧道转发上云。现在 **unidbg 离线签名**(纯 JVM 模拟 ARM64,无需安卓/模拟器)
> 让签名可直接在云主机生成,于是 **本地 Windows / MuMu / frida / SSH 隧道全部不再需要**,云主机自给自足。
> 云端 nginx 反代(`hongguo.momotools.top` + HTTPS)那套照旧可用,只是后端从「隧道→本地」改为「本地回环→云上 API」。

## 架构(新)

```
公网客户端 ──HTTPS──> [云主机] nginx:443 ──反代──> 127.0.0.1:8000  server.py(流水线API)
                                                        │ SIGN_SERVER=127.0.0.1:9099
                                                        ▼
                                              FqTrace serve :9099 (unidbg 签名, 仅本机)
                                                        │
                              offline_decrypt(视频+音频全解 + ffmpeg 重封装)
视频下载:客户端拿到 main_url 后直连字节 CDN,不过服务器。
```

## ⚠ 两个必读约束

1. **签名器必须用本机预编译的 fat jar**。工程依赖**本地打补丁**的 unidbg(`DalvikVM64._GetSuperclass→return 0`,未发布到 Maven 仓),云主机**不能现场 `mvn build`**。开发机 `cd unidbg-sign && mvn -DskipTests package` 产出 25M 自包含 jar 上传。
2. **token 需手动续期**。跨 app 签名可永久脱机,但 API 仍需红果有效 `x-tt-token`(`config.json`)。云主机无 app 无法自动刷;过期后更新 `config.json` 再 `systemctl restart hongguo-api`。(旧方案靠本地 app `/grab` 自动刷,这是上云后唯一退步,可接受。)

## 需上传的密文/二进制(均 gitignore)

| 路径 | 来源 |
|------|------|
| `unidbg-sign/target/unidbg-sign-1.0-jar-with-dependencies.jar` | 开发机 `mvn package` |
| `capture/fq_oversea/{libmetasec_ml.so, libc++_shared.so, ms_16777218.bin}` | 番茄海外(`zero199901/fqnovel-unidbg`) |
| `config.json` | 红果设备参数 + token |

---

## 方式一:systemd(裸云主机,推荐)

```bash
# ① 开发机打包签名器
cd unidbg-sign && mvn -DskipTests package

# ② 云主机装运行时
sudo apt update
sudo apt install -y openjdk-17-jre-headless python3 python3-venv python3-pip ffmpeg git

# ③ 部署代码 + 上传密文
sudo git clone <repo> /opt/hongguo && cd /opt/hongguo
#   scp unidbg-sign/target/unidbg-sign-1.0-jar-with-dependencies.jar  server:/opt/hongguo/unidbg-sign/target/
#   scp -r capture/fq_oversea                                          server:/opt/hongguo/capture/
#   scp config.json                                                    server:/opt/hongguo/
python3 -m venv venv && venv/bin/pip install -r deploy/requirements-server.txt
cp deploy/.env.example deploy/.env && vi deploy/.env     # 填 API_KEYS / ADMIN_TOKEN

# ④ 装服务(先签名后API)
sudo cp deploy/systemd/hongguo-sign.service deploy/systemd/hongguo-api.service /etc/systemd/system/
sudo systemctl daemon-reload
sudo systemctl enable --now hongguo-sign
sudo systemctl enable --now hongguo-api

# ⑤ 自检
curl -s -XPOST http://127.0.0.1:9099/sign -H 'content-type: application/json' \
  -d '{"url":"https://x.fqnovel.com/y?aid=8662","headers":{"content-type":"application/json"}}'
curl -s "http://127.0.0.1:8000/search?q=亮亮就业&api_key=<API_KEYS>"
journalctl -u hongguo-sign -u hongguo-api -f
```

`server.py` 监听 `0.0.0.0:8000`;沿用现有 nginx 反代时,把 vhost 后端从隧道端口(39001)改回 `127.0.0.1:8000` 即可。

## 方式二:Docker Compose

```bash
# 仓库根放 .dockerignore 防密文入镜像层
cat > .dockerignore <<'EOF'
capture/
config.json
apikeys.json
*.jar
downloads/
base.apk
EOF
cd deploy   # 改 docker-compose.yml 的 API_KEYS/ADMIN_TOKEN
docker compose up -d --build
curl -s "http://127.0.0.1:8000/search?q=亮亮就业&api_key=changeme-client-key"
```

## 运维

| 场景 | 操作 |
|------|------|
| token 过期(登录态失效) | 改 `/opt/hongguo/config.json` 的 `x-tt-token` → `systemctl restart hongguo-api` |
| 升级代码 | `git pull` → `systemctl restart hongguo-api`(改了 .java 才需重打 jar + 重启 sign) |
| 签名吞吐不够 | 多开 `FqTrace serve 9099/9100/..`,`SIGN_SERVER` 填逗号分隔多地址(`hongguo.py` 自动轮询) |
| 客户端密钥 | `POST /admin/keys`(带 `x-admin-token`)生成,或 `API_KEYS` 逗号分隔 |

## 风控对抗(已内置,按需开启)

`safeguards.py` 已有:令牌桶节流(含抖动)+ 多级缓存 + 风控码/关键词识别退避。
`hongguo.py` 的外部请求层(对红果 API / 字节 CDN)额外支持两个环境变量(仅作用于外部请求,**不影响本机签名服务**):

| 变量 | 作用 | 说明 |
|------|------|------|
| `IMPERSONATE` | TLS/JA3 指纹伪装 | 用 `curl_cffi` 把请求伪装成真 Chrome(贴近 app 的 cronet 网络栈),默认 `chrome`;空=退回原生 `requests`(指纹=Python/OpenSSL,易被识别);某些 curl_cffi 版本需写具体如 `chrome120` |
| `HONGGUO_PROXY` | 外部请求走代理 | `http://host:port` 或 `socks5://user:pass@host:port`;不填=直连机房 IP。**机房 IP 是上云后最大破绽**,上量时建议配住宅/移动代理,且身份↔IP 保持稳定绑定 |

> 提醒:这些只降低被识别概率,非隐身。**单设备/单 token 在机房 IP 上集中跑量**仍是最高风险;
> 真要上量需「多 token+设备指纹池轮换 + 代理绑定」(本仓库暂未内置多账号池,需自行扩展 `config.json` 为多份轮换)。
> CDN 视频下载经代理会吃代理带宽,按需评估。

## 安全 / 合规

- 签名端口 9099 **绝不对外**,仅本机 API 调用;对外只暴露 443(nginx)。
- API 强制 `api_key` + 按 key 限流;关闭服务器密码登录、保管好隧道私钥(若仍保留旧通道)。
- 仅限授权的安全研究 / 个人备份;公网大规模抓取涉及第三方 ToS 与法律风险,自行评估。
