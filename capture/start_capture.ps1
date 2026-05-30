# 启动抓包。运行后保持窗口开着，去模拟器里操作 App。Ctrl+C 停止。
$ErrorActionPreference = "Stop"
$here = Split-Path -Parent $MyInvocation.MyCommand.Path
Write-Host "mitmproxy 监听 0.0.0.0:8080 —— 模拟器代理填 宿主机IP:8080" -ForegroundColor Cyan
Write-Host "宿主机局域网IP: 192.168.1.2" -ForegroundColor Yellow
mitmdump -s "$here\addon.py" --listen-host 0.0.0.0 --listen-port 8080 --set console_eventlog_verbosity=info
