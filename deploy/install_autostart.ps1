# 注册"登录自启"(用户启动文件夹方案, 免管理员/免密码):
# 在 Startup 目录放一个 VBS, 登录后隐藏启动 autostart.ps1
#   (autostart.ps1: 启 MuMu -> 等就绪 -> 启红果app -> sign_server/server/两条隧道)
# 卸载: 删除 Startup 目录下的 HongguoSignStack.vbs
$ErrorActionPreference = "Stop"
$psScript = "D:\code\hongguo\autostart.ps1"
$startup  = [Environment]::GetFolderPath('Startup')
$vbsPath  = Join-Path $startup "HongguoSignStack.vbs"

$vbs = @"
' 红果签名栈 登录自启(隐藏窗口) - 由 deploy\install_autostart.ps1 生成
Set sh = CreateObject("WScript.Shell")
sh.Run "powershell.exe -NoProfile -ExecutionPolicy Bypass -WindowStyle Hidden -File ""$psScript""", 0, False
"@

Set-Content -Path $vbsPath -Value $vbs -Encoding ASCII
Write-Host "已安装登录自启: $vbsPath" -ForegroundColor Green
Write-Host "下次登录后约 25s 自动拉起 MuMu + 全栈。" -ForegroundColor Green
Write-Host "立即测试可运行(手动跑一次): $psScript" -ForegroundColor Yellow
