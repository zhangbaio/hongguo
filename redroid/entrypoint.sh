#!/usr/bin/env bash
# 服务容器入口: 等redroid就绪 -> 配置 -> 自动生成config -> 起签名服务+API
set -e
ADB=${ADB:-adb}
DEV=${ADB_DEVICE:-redroid:5555}

echo "[entrypoint] 等待 redroid adb 就绪..."
for i in $(seq 1 80); do
  $ADB connect "$DEV" >/dev/null 2>&1 || true
  if $ADB -s "$DEV" shell getprop sys.boot_completed 2>/dev/null | grep -q 1; then
    echo "[entrypoint] redroid 启动完成"; break
  fi
  sleep 3
done

# 安装app、起frida、拉起app
./provision.sh

# 自动从 redroid 内 app 实例生成设备匹配的 config.json
echo "[entrypoint] 自动抓取 config..."
python grab_config.py || echo "[entrypoint] grab_config 失败,沿用打包的 config.json"

# 起签名服务(独立进程,持有Frida预言机)
echo "[entrypoint] 启动签名服务..."
python sign_server.py &
SIGN_PID=$!

# 等签名服务就绪
for i in $(seq 1 20); do
  if curl -sf http://127.0.0.1:8001/ >/dev/null 2>&1; then echo "[entrypoint] 签名服务就绪"; break; fi
  sleep 2
done

# 起 API 服务器(前台)
echo "[entrypoint] 启动 API 服务器 :8000"
export SIGN_SERVER=http://127.0.0.1:8001
exec python server.py
