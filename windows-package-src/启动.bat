@echo off
chcp 65001 >nul
setlocal enabledelayedexpansion
cd /d "%~dp0"

echo ============================================================
echo   红果脱机直连 · 本机启动
echo ============================================================

:: ---------- 可按需修改的配置 ----------
set "SIGN_PORT=9099"
set "API_PORT=8000"
set "ADMIN_TOKEN=mytoken123"
set "BIND_HOST=127.0.0.1"
set "HG_SEARCH_MAX_ITEMS=20"
set "PYTHONUTF8=1"
set "SIGN_SERVER=http://127.0.0.1:%SIGN_PORT%"
:: 若装了 ffmpeg, 把它加进 PATH(不带也能出可播文件)
if exist "%~dp0ffmpeg\bin\ffmpeg.exe" set "PATH=%~dp0ffmpeg\bin;%PATH%"

:: ---------- 运行时自检 ----------
if not exist "%~dp0jre\bin\java.exe" (
  echo [X] 缺少 jre\bin\java.exe  请把便携 OpenJDK 17 x64 解压到 jre\ 目录
  echo     下载: Adoptium Temurin JDK17 Windows x64 (zip 版)
  goto :fail
)
if not exist "%~dp0python\python.exe" (
  echo [X] 缺少 python\python.exe  请把 embeddable Python 3.11 x64 解压到 python\ 目录
  echo     下载: python.org 的 python-3.11.x-embed-amd64.zip  然后运行 安装依赖.bat
  goto :fail
)
if not exist "%~dp0sign\unidbg-sign.jar" (
  echo [X] 缺少 sign\unidbg-sign.jar
  goto :fail
)
if not exist "%~dp0capture\fq_oversea\libmetasec_ml.so" (
  echo [X] 缺少 capture\fq_oversea\libmetasec_ml.so  (capture 必须与 sign 同级)
  goto :fail
)
"%~dp0python\python.exe" -c "import fastapi,uvicorn,requests,Crypto" 2>nul
if errorlevel 1 (
  echo [X] Python 依赖未装好(import 失败)  请先运行  安装依赖.bat
  goto :fail
)

:: ---------- 1) 启动 unidbg 签名服务(工作目录必须在 sign\) ----------
echo.
echo [1/2] 启动 unidbg 签名服务 :%SIGN_PORT% ... (首次初始化约 10-20 秒)
start "unidbg-sign :%SIGN_PORT%" /min cmd /c "cd /d "%~dp0sign" && "%~dp0jre\bin\java.exe" -Xmx512m -XX:+ExitOnOutOfMemoryError -jar unidbg-sign.jar serve %SIGN_PORT%"

echo      等待签名服务就绪(会做一次真实试签)...
set /a _tries=0
:waitsign
timeout /t 3 >nul
set /a _tries+=1
curl -s -m 45 -X POST http://127.0.0.1:%SIGN_PORT%/sign -H "Content-Type: application/json" -d "{\"url\":\"https://api5-normal-sinfonlinec.fqnovel.com/reading/bookapi/search/tab/v?aid=1967&query=test\",\"headers\":{\"content-type\":\"application/json\"}}" > "%TEMP%\hg_sign_test.txt" 2>nul
findstr /c:"X-Gorgon" "%TEMP%\hg_sign_test.txt" >nul 2>nul
if not errorlevel 1 goto signok
if %_tries% geq 20 (
  echo [X] 签名服务 45s*20 仍未就绪, 请看 "unidbg-sign" 窗口的报错(常见: JRE 非64位 / 找不到 so / 端口被占)
  goto :fail
)
echo      ...第 %_tries% 次未就绪, 继续等
goto waitsign

:signok
del "%TEMP%\hg_sign_test.txt" >nul 2>nul
echo      签名服务就绪 (X-Gorgon 已返回)

:: ---------- 2) 启动红果 API 服务 ----------
echo.
echo [2/2] 启动红果 API 服务 :%API_PORT% ...
echo      UI:    http://127.0.0.1:%API_PORT%/ui
echo      管理:  http://127.0.0.1:%API_PORT%/admin?admin_token=%ADMIN_TOKEN%  (在这里生成 api_key)
echo.
start "" "http://127.0.0.1:%API_PORT%/admin?admin_token=%ADMIN_TOKEN%"
"%~dp0python\python.exe" server.py

echo.
echo (API 服务已退出)
goto :end

:fail
echo.
echo 启动失败, 请按上面提示处理。详见  docs\Windows脱机直连-unidbg-部署需求文档.md
:end
echo.
pause
endlocal
