# 把 mitmproxy CA 装成 Android 系统证书 (需要 root 的模拟器)
# 用法: 模拟器开 root 后，adb 能连上，再运行本脚本。
# 自动探测 adb：优先用 PATH 里的，找不到就用雷电/MuMu 常见路径。
$ErrorActionPreference = "Stop"
$here  = Split-Path -Parent $MyInvocation.MyCommand.Path
$cert  = Join-Path (Split-Path -Parent $here) "certs\c8750f0d.0"

# --- 找 adb ---
$adb = (Get-Command adb -ErrorAction SilentlyContinue).Source
if (-not $adb) {
  $cands = @(
    "C:\LDPlayer\LDPlayer9\adb.exe",
    "C:\ChangZhi\dnplayer2\adb.exe",
    "C:\Program Files\MuMu Player 12\shell\adb.exe",
    "C:\Program Files\Netease\MuMu Player 12\shell\adb.exe",
    "D:\Program Files\Tencent\Androws\Application\5.10.6000.5944\adb.exe"
  )
  $adb = $cands | Where-Object { Test-Path $_ } | Select-Object -First 1
}
if (-not $adb) { throw "找不到 adb.exe，请把模拟器的 adb 加到 PATH，或改本脚本里的路径" }
Write-Host "adb: $adb" -ForegroundColor Cyan

& $adb devices
& $adb root
Start-Sleep -Seconds 2
& $adb remount

# 安卓10+ 系统分区只读，用临时挂载法写 cacerts
& $adb shell "mount -o rw,remount /system" 2>$null
& $adb push $cert /sdcard/c8750f0d.0
& $adb shell "su -c 'cp /sdcard/c8750f0d.0 /system/etc/security/cacerts/c8750f0d.0 && chmod 644 /system/etc/security/cacerts/c8750f0d.0'"
# 新版安卓 (14+) 证书在 APEX，用下面的临时覆盖法
& $adb shell "su -c 'cp /sdcard/c8750f0d.0 /apex/com.android.conscrypt/cacerts/c8750f0d.0 2>/dev/null; chmod 644 /apex/com.android.conscrypt/cacerts/c8750f0d.0 2>/dev/null'"
Write-Host "证书已尝试安装。在 设置>安全>加密与凭据>受信任的凭据>系统 里应能看到 mitmproxy。" -ForegroundColor Green
Write-Host "若没看到，重启模拟器后再试。" -ForegroundColor Yellow
