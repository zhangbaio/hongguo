# Start signature oracle env (run once before downloading)
# Ensures: MuMu running + frida-server + port forward + Hongguo app launched
$adb = "D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"
$dev = "127.0.0.1:16384"

Write-Host "1. adb connect..." -ForegroundColor Cyan
& $adb connect $dev | Out-Null

Write-Host "2. start frida-server..." -ForegroundColor Cyan
$running = & $adb -s $dev shell "su -c 'ps -A | grep frida-server'" 2>$null
if (-not $running) {
    & $adb -s $dev shell "su -c 'nohup /data/local/tmp/frida-server >/dev/null 2>&1 &'"
    Start-Sleep -Seconds 2
    Write-Host "   frida-server started" -ForegroundColor Green
} else {
    Write-Host "   frida-server already running" -ForegroundColor Green
}

Write-Host "3. forward port 27042..." -ForegroundColor Cyan
& $adb -s $dev forward tcp:27042 tcp:27042 | Out-Null

Write-Host "4. launch Hongguo app (signer)..." -ForegroundColor Cyan
$app = & $adb -s $dev shell "pidof com.phoenix.read" 2>$null
if (-not $app) {
    & $adb -s $dev shell "monkey -p com.phoenix.read -c android.intent.category.LAUNCHER 1" 2>$null | Out-Null
    Start-Sleep -Seconds 4
    Write-Host "   Hongguo launched" -ForegroundColor Green
} else {
    Write-Host "   Hongguo already running (pid=$app)" -ForegroundColor Green
}

Write-Host "`nOracle ready! Now run the downloader:" -ForegroundColor Yellow
Write-Host '  python hongguo.py search "name"' -ForegroundColor White
Write-Host '  python hongguo.py download <series_id> 1-10' -ForegroundColor White
