@echo off
chcp 65001 >nul
cd /d "%~dp0"
echo ============================================================
echo   一次性: 给便携 Python 装依赖
echo ============================================================

if not exist "%~dp0python\python.exe" (
  echo [X] 缺少 python\python.exe
  echo     请先把 python.org 的 python-3.11.x-embed-amd64.zip 解压到 python\ 目录
  goto :end
)

:: embeddable Python 默认禁用 site, 必须启用, 否则装的包 import 不到
echo [1/3] 启用 embeddable Python 的 site (改 ._pth) ...
for %%f in ("%~dp0python\python*._pth") do (
  powershell -NoProfile -Command "$p='%%~f'; $c=Get-Content -Raw $p; if($c -notmatch '(?m)^\s*import\s+site'){ $c=$c -replace '(?m)^\s*#\s*import\s+site','import site' }; if($c -notmatch '(?m)^\s*import\s+site'){ $c=$c.TrimEnd()+\"`r`nimport site`r`n\" }; Set-Content -NoNewline $p $c"
)

echo [2/3] 确保有 pip ...
"%~dp0python\python.exe" -m pip --version >nul 2>nul
if errorlevel 1 (
  echo      未检测到 pip, 正在用 get-pip 引导...
  powershell -NoProfile -Command "Invoke-WebRequest https://bootstrap.pypa.io/get-pip.py -OutFile '%TEMP%\get-pip.py'"
  "%~dp0python\python.exe" "%TEMP%\get-pip.py"
)

echo [3/3] 安装依赖 (requirements-windows.txt) ...
"%~dp0python\python.exe" -m pip install -r "%~dp0requirements-windows.txt"

echo.
echo 校验 import ...
"%~dp0python\python.exe" -c "import fastapi,uvicorn,requests,Crypto; print('OK: 依赖就绪')"
if errorlevel 1 (
  echo [X] import 失败: 多半是 site 没启用。请检查 python\python3xx._pth 里已有一行  import site
) else (
  echo 完成! 现在可以双击  启动.bat
)

:end
echo.
pause
