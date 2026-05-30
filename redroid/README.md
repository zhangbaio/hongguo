# redroid 上线部署

把签名后端从 Windows+MuMu 换成 **redroid(Docker 安卓)**，跑在 Linux 服务器上。

## ⚠️ 前置硬性要求

1. **ARM64 主机**。红果 APK 只有 `arm64-v8a` 原生库(含签名库 libmetasec_ml.so)，
   x86_64 服务器需 ARM 翻译，对 native 签名库不可靠。
   推荐: **Oracle Cloud Ampere(免费4核24G)** / AWS Graviton / 任意 ARM 云主机/物理机。
2. **宿主机内核支持 binder**(redroid 必需)。多数现代内核可加载:
   ```bash
   sudo modprobe binder_linux devices="binder,hwbinder,vndbinder"
   sudo modprobe ashmem_linux 2>/dev/null || true   # 新内核用 memfd, 可省
   # 确认:
   ls /dev/binder*  ||  ls /dev/binderfs
   ```
   云厂商裸金属/特定内核支持较好; 普通 KVM 小鸡可能需换内核或选支持的镜像。
3. 已装 docker + docker compose。

## 准备文件(放到项目根目录 D:\code\hongguo 对应位置)

- `base.apk` —— 红果安装包(已在 unidbg/base.apk, 复制到根目录或改 Dockerfile 路径)
- `config.json` —— 兜底配置(容器会用 grab_config 重新生成与设备匹配的版本)
- 代码: hongguo.py / sign_server.py / server.py / safeguards.py / frida/oracle.js

```bash
cp unidbg/base.apk ./base.apk     # 确保根目录有 base.apk
```

## 一键启动

```bash
docker compose -f redroid/docker-compose.yml up -d --build
docker logs -f hongguo-api        # 看 provision/grab_config/服务启动日志
```

启动流程(entrypoint 自动完成):
1. 等 redroid 安卓启动完成
2. provision: 装红果APK + 推送启动 frida-server(arm64) + 拉起app
3. grab_config: 从 redroid 内 app 实例抓真实请求 → 生成设备匹配的 config.json
4. 起 sign_server(:8001 签名) + server(:8000 API)

## 验证

```bash
curl "http://<服务器IP>:8000/rank?board=recommend&limit=5"
curl "http://<服务器IP>:8000/latest?genre=short_play&only_today=true"
curl "http://<服务器IP>:8000/search?q=极品皇太子"
```

## 关于登录态(重要)

红果多数浏览/搜索/免费短剧播放在**游客态**即可，grab_config 会抓到游客 token。
若某些接口(如 video_model)需要登录:
- 用 scrcpy 连上 redroid 手动登录一次:
  ```bash
  adb connect <服务器IP>:5555 && scrcpy -s <服务器IP>:5555
  ```
- 登录态存在 `redroid-data` 卷里, 持久化; 重启 grab_config 会抓到登录后的 token。

## 扩容 / 多设备池(降风控)

- API 无状态, 可多副本 + 负载均衡。
- 签名后端按需多开: 起多个 redroid(redroid2/redroid3...) + 对应 sign_server,
  server.py 改成轮询多个 SIGN_SERVER(目前单个; 需要的话可加池逻辑)。
- 每个 redroid = 独立 device_id, 分摊请求, 各自待在风控阈值下。

## 常见问题

- 容器起不来/binder报错 → 宿主机内核不支持 binder, 见前置要求2。
- grab_config 失败沿用打包 config → 多为app未登录或网络; 看 `docker logs`。
- frida attach 失败 → redroid 内 frida-server 没起或版本不符(须 arm64 16.7.19)。
- app 闪退 → 该 redroid 镜像安卓版本与app不兼容, 换 redroid:11/13 试。
