# 登录自启引导: 启动 MuMu -> 等安卓启动完成 -> 启动红果app -> 跑全栈(start_all.ps1)
# 由计划任务在用户登录时调用(见 deploy\install_autostart.ps1)。
$ErrorActionPreference = "Continue"
$root = "D:\code\hongguo"
$mgr  = "D:\Program Files\Netease\MuMu Player 12\nx_main\MuMuManager.exe"
$vm   = "0"
$pkg  = "com.phoenix.read"
$log  = "$root\capture\autostart.log"
New-Item -ItemType Directory -Force -Path "$root\capture" | Out-Null
function Log($m) { "$([DateTime]::Now.ToString('HH:mm:ss')) $m" | Tee-Object -FilePath $log -Append }

function Get-MuMuInfo {
  try { (& $mgr info -v $vm 2>$null | Out-String | ConvertFrom-Json) } catch { $null }
}

Log "=== autostart 开始 ==="

# 0) 登录后初始延时, 等桌面/网络就绪(经启动文件夹触发时无计划任务的 /DELAY)
Start-Sleep -Seconds 25

# 1) 确保 MuMu 安卓已启动
$info = Get-MuMuInfo
if (-not ($info -and $info.is_android_started -eq $true)) {
  Log "MuMu 未启动, 执行 launch..."
  & $mgr control -v $vm launch 2>$null | Out-Null
}

# 2) 轮询等待安卓 boot 完成(最多 ~240s)
$ready = $false
for ($i = 0; $i -lt 80; $i++) {
  Start-Sleep -Seconds 3
  $info = Get-MuMuInfo
  if ($info -and $info.is_android_started -eq $true -and $info.player_state -eq "start_finished") {
    Log "MuMu 就绪 (adb_port=$($info.adb_port), state=$($info.player_state))"
    $ready = $true; break
  }
}
if (-not $ready) { Log "⚠ 等待 MuMu 超时, 仍尝试继续(adb 可能可用)" }

# 3) 启动红果 app(签名预言机宿主)
Log "启动红果 app..."
& $mgr control -v $vm app launch -pkg $pkg 2>$null | Out-Null
Start-Sleep -Seconds 5

# 4) 跑本地全栈(frida环境 + sign_server + server + 两条隧道)
Log "调用 start_all.ps1 ..."
& powershell -NoProfile -ExecutionPolicy Bypass -File "$root\start_all.ps1" *>> $log

Log "=== autostart 结束 ==="
