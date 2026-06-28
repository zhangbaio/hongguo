# Start Douyin signature oracle env (fork of start_oracle.ps1)
# Ensures: MuMu running + frida-server + port forward + Douyin app launched
# Then attach: frida -U -n com.ss.android.ugc.aweme -l frida\oracle_dy.js
$adb = "D:\Program Files\Netease\MuMu Player 12\shell\adb.exe"
$dev = "127.0.0.1:16384"
$pkg = "com.ss.android.ugc.aweme"

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

Write-Host "4. launch Douyin app (signer)..." -ForegroundColor Cyan
$app = & $adb -s $dev shell "pidof $pkg" 2>$null
if (-not $app) {
    & $adb -s $dev shell "monkey -p $pkg -c android.intent.category.LAUNCHER 1" 2>$null | Out-Null
    Start-Sleep -Seconds 5
    Write-Host "   Douyin launched" -ForegroundColor Green
} else {
    Write-Host "   Douyin already running (pid=$app)" -ForegroundColor Green
}

Write-Host "`nDouyin oracle ready! Attach frida with:" -ForegroundColor Yellow
Write-Host "  frida -U -n $pkg -l frida\oracle_dy.js" -ForegroundColor White
Write-Host "(use -n to attach to the running process; the oracle exposes rpc.sign(url, headers) / rpc.grab(ms))" -ForegroundColor DarkGray
