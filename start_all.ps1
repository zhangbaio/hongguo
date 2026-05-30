# 一键启动本地全栈: frida环境 + 签名服务 + API服务 + 公网隧道
# 前提: MuMu 开着且红果已装
$ErrorActionPreference = "Continue"
$root = "D:\code\hongguo"
Set-Location $root
$env:PYTHONUTF8 = "1"
$env:SIGN_SERVER = "http://127.0.0.1:8001"

function Running($match) {
  return [bool](Get-CimInstance Win32_Process -Filter "name='python.exe'" | Where-Object { $_.CommandLine -like $match })
}

Write-Host "1) frida 环境(frida-server + app + 端口转发)" -ForegroundColor Cyan
& "$root\start_oracle.ps1"

Write-Host "2) 签名服务 sign_server :8001" -ForegroundColor Cyan
if (Running "*sign_server.py*") { Write-Host "   已在运行" -ForegroundColor Green } else {
  Start-Process python -ArgumentList "sign_server.py" -WindowStyle Hidden -RedirectStandardOutput "capture\sign.log" -RedirectStandardError "capture\sign_err.log"
  Start-Sleep 8; Write-Host "   已启动" -ForegroundColor Green
}

Write-Host "3) API 服务 server :8000" -ForegroundColor Cyan
if (Running "* server.py*") { Write-Host "   已在运行" -ForegroundColor Green } else {
  Start-Process python -ArgumentList "server.py" -WindowStyle Hidden -RedirectStandardOutput "capture\server.log" -RedirectStandardError "capture\server_err.log"
  Start-Sleep 5; Write-Host "   已启动" -ForegroundColor Green
}

Write-Host "4) 公网隧道 -> 云 39001" -ForegroundColor Cyan
if (Running "*tunnel.py*") { Write-Host "   已在运行" -ForegroundColor Green } else {
  Start-Process python -ArgumentList "deploy\tunnel.py" -WindowStyle Hidden -RedirectStandardOutput "deploy\tunnel.log" -RedirectStandardError "deploy\tunnel_err.log"
  Start-Sleep 6; Write-Host "   已启动" -ForegroundColor Green
}

Write-Host "`n全栈就绪:" -ForegroundColor Yellow
Write-Host "  本地: http://127.0.0.1:8000/ui"
Write-Host "  公网(开安全组39001后): http://8.131.149.195:39001/ui"
Write-Host "  公网(加DNS后): http://hongguo.momotools.top/ui"
