# 一键启动本地签名栈: frida环境 + 签名服务 + 签名隧道(供云端 short-vedio-manage 签名)
# 前提: MuMu 开着且红果已装
# 注: 旧的独立版 API(server.py:8000)+数据隧道(39001)+域名 hongguo.momotools.top 已下线,
#     功能并入 short-vedio-manage(weixinshortdrama.momotools.top)。如需本地调试可手动跑 server.py。
$ErrorActionPreference = "Continue"
$root = "D:\code\hongguo"
Set-Location $root
$env:PYTHONUTF8 = "1"
$env:SIGN_SERVER = "http://127.0.0.1:8001"
# 密钥/口令从 .env.ps1 读取(该文件在 .gitignore 中, 不进仓库)。模板见 .env.ps1.example。
#   ADMIN_TOKEN: 进入 /admin 密钥管理页的口令
#   API_KEYS:    仅首次迁移旧密钥到 apikeys.json 用(之后在 /admin 管理)
if (Test-Path "$root\.env.ps1") { . "$root\.env.ps1" }
if (-not $env:ADMIN_TOKEN) {
  $env:ADMIN_TOKEN = "CHANGE_ME"
  Write-Host "⚠ 未配置 ADMIN_TOKEN, 请复制 .env.ps1.example 为 .env.ps1 并填写" -ForegroundColor Yellow
}

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

Write-Host "3) 签名隧道 -> 云 39002 (本地 sign_server:8001, 供云端 short-vedio-manage 签名)" -ForegroundColor Cyan
if (Running "*tunnel.py 39002*") { Write-Host "   已在运行" -ForegroundColor Green } else {
  Start-Process python -ArgumentList "deploy\tunnel.py 39002 8001" -WindowStyle Hidden -RedirectStandardOutput "deploy\tunnel8001.log" -RedirectStandardError "deploy\tunnel8001_err.log"
  Start-Sleep 6; Write-Host "   已启动" -ForegroundColor Green
}

Write-Host "`n签名栈就绪:" -ForegroundColor Yellow
Write-Host "  本地签名服务: http://127.0.0.1:8001"
Write-Host "  云端签名: weixinshortdrama.momotools.top 经隧道 39002 -> 本地 sign_server"
