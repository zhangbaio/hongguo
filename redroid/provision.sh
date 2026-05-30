#!/usr/bin/env bash
# 在 redroid 里装红果APK、推送并启动 frida-server、拉起app。redroid 默认 root。
set -e
ADB=${ADB:-adb}
DEV=${ADB_DEVICE:-redroid:5555}
PKG=com.phoenix.read

echo "[provision] 安装红果 APK..."
$ADB -s "$DEV" install -r base.apk || echo "[provision] APK 可能已安装,继续"

echo "[provision] 推送 frida-server(arm64)..."
$ADB -s "$DEV" push frida-server-arm64 /data/local/tmp/frida-server
$ADB -s "$DEV" shell "chmod 755 /data/local/tmp/frida-server"
$ADB -s "$DEV" shell "pkill frida-server 2>/dev/null || true"
sleep 1
$ADB -s "$DEV" shell "(nohup /data/local/tmp/frida-server >/dev/null 2>&1 &)"
sleep 3

echo "[provision] 转发 frida 端口 27042..."
$ADB -s "$DEV" forward tcp:27042 tcp:27042

echo "[provision] 启动红果 app..."
$ADB -s "$DEV" shell "monkey -p $PKG -c android.intent.category.LAUNCHER 1" >/dev/null 2>&1
sleep 6
echo "[provision] 完成"
