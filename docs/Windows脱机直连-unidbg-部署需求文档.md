# 红果脱机直连 · Windows 本机部署需求文档(unidbg 签名 · 小白友好绿色包)

> 目标:在**一台 Windows 电脑**上,用 **unidbg** 做签名(不要 MuMu 模拟器、不要 Frida、不要 adb),
> 把红果「脱机直连」API 服务跑在本机,本机直接调用下载/串流接口。做成**解压即用、双击启动、无需装环境**的绿色包。
>
> 本文档给「在 Windows 上帮忙配置/测试的 AI」看。所有关键事实已在 macOS 源仓库核实,下面标注 ✅ 的是已验证结论。

---

## 0. 一句话结论(可行性)

- ✅ **unidbg 与操作系统无关**:它在 JVM 里用 Unicorn2 模拟 ARM 安卓、在内存里跑 `libmetasec_ml.so` 出签名。服务器(Linux)能跑,Windows 配个便携 JRE 就能一模一样地跑。
- ✅ **签名胖 jar 已是全平台**:`unidbg-sign-1.0-jar-with-dependencies.jar`(约 31MB)内已打包 `natives/windows_64/unicorn.dll`(Unicorn2)+ `unicorn_java.dll` + Windows 版 capstone/keystone/jnidispatch。**Windows x64 直接能加载,无需重新用 Maven 编译。**
- ✅ **所有签名素材本地都齐**:jar + 三个资源文件(见 §2)。不用连服务器、不用逆向。
- 结论:Windows 绿色包 = **便携 JRE + 胖 jar + 3 个资源文件 + 便携 Python + 几个 Python 包 +(可选)ffmpeg + 源码 + 一个 `启动.bat`**。

---

## 1. 运行架构(3 层,全在本机)

```
┌─────────────────────────────────────────────────────────────┐
│  Windows 本机(127.0.0.1)                                     │
│                                                              │
│  ① unidbg 签名服务(Java)                                    │
│     java -jar unidbg-sign.jar  →  HTTP  http://127.0.0.1:9099 │
│     只提供 POST /sign,吃 {url,headers} 出 {X-Argus,...}       │
│              ▲                                                │
│              │ SIGN_SERVER=http://127.0.0.1:9099             │
│              │                                                │
│  ② 红果 API 服务(Python / FastAPI)                          │
│     python server.py  →  HTTP  http://127.0.0.1:8000         │
│     /search /latest /browse /episodes /play /stream /download │
│     下载密文时直连红果 CDN,本机纯离线解密后串流/存盘          │
│              ▲                                                │
│              │ http://127.0.0.1:8000  (?api_key=...)         │
│  ③ 你的调用方(浏览器 /video 标签 / 脚本 / 其它程序)          │
└─────────────────────────────────────────────────────────────┘
```

**为什么本机跑更快**:视频下载的瓶颈是「从红果 CDN 拉密文字节」。服务器部署是 `CDN → 云服务器 → 你的电脑` 两跳,受云服务器公网出口带宽限制;本机跑是 `CDN → 本机` 一跳,吃你本地宽带,通常快很多。签名只影响「取直链」这一小步,不影响大流量下载。

---

## 2. 需要打进绿色包的**文件清单**(全部来自源仓库 `hongguo/`)

### 2.1 签名服务(Java 侧)——必需

| 打包后的位置 | 源文件 | 说明 |
|---|---|---|
| `sign/unidbg-sign.jar` | `unidbg-sign/target/unidbg-sign-1.0-jar-with-dependencies.jar`(31MB) | ✅ 全平台胖 jar |
| `capture/fq_oversea/libmetasec_ml.so` | 同路径(3.3MB) | 签名核心 so(被 unidbg 模拟执行) |
| `capture/fq_oversea/libc++_shared.so` | 同路径(891KB) | so 依赖 |
| `capture/fq_oversea/ms_16777218.bin` | 同路径(2KB) | 设备证书 |

> ⚠️ **路径关系是硬编码的**:`FqTrace.java` 里 `DIR = "../capture/fq_oversea/"`,是相对「jar 的工作目录」的上一级。
> 所以启动 java 时,**工作目录必须是 `sign/`,且 `capture/` 与 `sign/` 同级**(见 §6 目录结构)。否则会报找不到 so。

### 2.2 API 服务(Python 侧)——必需

- 顶层脚本:`server.py`、`hongguo.py`、`offline_dl.py`、`apikeys.py`、`safeguards.py`、`downloader.py`、`devicepool.py`
- 解密模块目录:**整个 `frida/` 文件夹**照拷(解密链 `offline_decrypt.py → unwrap_spade.py / oracle.py / decutil.py / extract_keybox_pairs.py` 互相 import,拷全目录最省事;里面其它逆向脚本不会被加载,无害)
- 网页(可选,只为 `/ui`、`/admin` 页面):`web/` 文件夹
- 配置:`config.example.json` 复制成 `config.json`(如源码需要);`apikeys.json` 首次运行自动生成

> 说明:`hongguo.py` 顶部 `import frida` 已用 try/except 包住,**设了 `SIGN_SERVER` 走 HTTP 时不需要装 frida**。

---

## 3. 运行时依赖(要一起塞进绿色包,做到「免装环境」)

| 组件 | 版本/来源 | 打包方式 | 备注 |
|---|---|---|---|
| **JRE**(Java 运行时) | OpenJDK **17**(或 8/11/21 都行)Windows **x64** | 便携版解压到 `jre/`,用 `jre\bin\java.exe` | Adoptium Temurin 的 zip 版即可,免安装 |
| **Python** | Windows **embeddable** 3.11 x64 | 解压到 `python\`,用 `python\python.exe` | 官网 `python-3.11.x-embed-amd64.zip`,免安装 |
| Python 第三方包 | 见 §4 | `pip` 装进便携 python 的 site-packages | 用 `--target` 或改 `._pth` 启用 site |
| **ffmpeg**(可选) | ffmpeg **essentials** Windows build | `ffmpeg\bin\ffmpeg.exe`,加进 PATH 或与 exe 同目录 | 只用于把解出的裸流重封装成规范 mp4;**不带也能出可播文件**(宽松播放器可播),带上兼容性更好 |

> **JRE 必须 x64**(与 jar 里的 `windows_64` 原生库匹配)。别用 32 位。
> **Python embeddable 的坑**:默认禁用 `site`,需要把 `python311._pth` 里 `#import site` 的注释去掉,或把依赖用 `--target` 装到能被 import 的目录并在启动脚本里设 `PYTHONPATH`。这是配置这台绿色包时最容易翻车的点,务必在真机 import 测试通过。

---

## 4. Python 第三方依赖

### 4.1 下载/串流最小集(**推荐**,包最小)

```
requests
fastapi
uvicorn[standard]
pycryptodome        # 解密用 (from Crypto.Cipher import AES);Windows 有现成 wheel
```

- `urllib3` 随 `requests` 带上。
- **不需要**:`frida`、`mitmproxy`、`paramiko`(那些是逆向/部署阶段用的)。
- `pillow` + `pillow-heif` **可不装**:只影响 `/img` 封面代理里 HEIC→JPEG 转换,代码已用 try/except 降级(`_IMG_OK=False` 时直接透传原图)。下载/串流完全不受影响。

### 4.2 完整功能集(要 `/ui` 里看封面缩略图更顺)

在最小集基础上加:

```
pillow
pillow-heif
```

> `safeguards.py` 里 redis 是**可选**的(没装/没连到就自动退回内存缓存),本机单机部署**不用装 redis**。

---

## 5. 环境变量(启动脚本里设)

| 变量 | 作用 | 建议值(本机) |
|---|---|---|
| `SIGN_SERVER` | ✅ **关键**。Python 侧签名后端地址,指向本机 unidbg | `http://127.0.0.1:9099` |
| `ADMIN_TOKEN` | `/admin` 密钥管理口令(不设会随机生成并打印) | 自定义一串,如 `mytoken123` |
| `PORT` | API 服务端口 | `8000` |
| `BIND_HOST` | API 监听地址。本机自用填 `127.0.0.1`;想局域网其它设备访问填 `0.0.0.0` | `127.0.0.1` |
| `HG_SEARCH_MAX_ITEMS` | 搜索翻页上限,越小越快 | `20` |
| `RATE_PER_MIN` | 每个 api_key 每分钟限流 | `120` |
| `PYTHONUTF8` | 强制 UTF-8,避免中文乱码 | `1` |
| `BIND_HOST`(Java 侧) | unidbg 签名服务监听地址 | 默认 `127.0.0.1` 即可,不用改 |

> `IMPERSONATE`、`HONGGUO_PROXY`、`ADB`、`ADB_DEVICE`、`FRIDA_HOST` 这些**本方案用不到**(那是 MuMu+Frida 老方案的),保持默认/不设。

---

## 6. 建议的绿色包目录结构

```
红果脱机直连/
├─ 启动.bat                ← 双击这个
├─ jre/                    ← 便携 JDK/JRE (含 bin\java.exe)
├─ python/                 ← 便携 embeddable Python (含 python.exe + 依赖)
├─ ffmpeg/bin/ffmpeg.exe   ← 可选
├─ sign/
│   └─ unidbg-sign.jar     ← 胖 jar(工作目录必须在这)
├─ capture/
│   └─ fq_oversea/
│       ├─ libmetasec_ml.so
│       ├─ libc++_shared.so
│       └─ ms_16777218.bin
├─ server.py hongguo.py offline_dl.py apikeys.py safeguards.py
│  downloader.py devicepool.py
├─ frida/                  ← 整目录(解密模块)
├─ web/                    ← 可选(/ui /admin 页面)
├─ config.json            ← 由 config.example.json 复制
├─ downloads/             ← 运行时自动建(下载/串流缓存)
└─ apikeys.json           ← 首次运行自动建
```

> **同级关系要点**:`capture/` 与 `sign/` 必须同级,因为 java 从 `sign/` 目录启动、按 `../capture/fq_oversea/` 找 so。

---

## 7. 签名服务 HTTP 协议(✅ 已核实,给排错用)

- 启动:`java -jar unidbg-sign.jar serve 9099`(`serve <port>`,不给端口默认 9090)
- 接口:仅 **`POST /sign`**
  - 请求体:`{"url": "<完整红果API URL>", "headers": {"k1":"v1", ...}}`
  - 返回:`{"X-Argus":"...","X-Gorgon":"...","X-Ladon":"...", ...}`;出错返回 `{"error":"..."}`
- ⚠️ **没有 `/grab` 接口**(那是老 Frida 方案从真机 app 抓新鲜 token 用的)。unidbg 无真机,所以:
  - `hongguo.py` 里 `refresh_session()`(调 `/grab`)在本方案下**不可用**;
  - 也就是说**登录态/设备参数是 `hongguo.py` 里的静态配置**,必须是有效的(源仓库现用的那套)。若某天上游要求刷新 token,需要另想办法。日常搜索/榜单/下载不受影响。
- 单进程单模拟器**串行签名**(unidbg 同 JVM 多模拟器并发会出空签名)。要更高并发就起多个端口(9099、9100...)并把 `SIGN_SERVER` 写成逗号分隔,`hongguo.py` 会轮询。单机下载一般 **1 个实例就够**。

---

## 8. 启动步骤

### 8.1 手动分步(先跑通再做 bat)

```bat
:: 1) 起签名服务(新开一个窗口,工作目录必须在 sign\)
cd /d %~dp0sign
..\jre\bin\java.exe -Xmx512m -XX:+ExitOnOutOfMemoryError -jar unidbg-sign.jar serve 9099
:: 看到 "unidbg 离线签名服务已启动: 127.0.0.1:9099/sign" 即成功

:: 2) 自检签名(另开窗口)
curl -X POST http://127.0.0.1:9099/sign -H "Content-Type: application/json" ^
  -d "{\"url\":\"https://api5-normal-sinfonlinec.fqnovel.com/reading/bookapi/search/tab/v?aid=1967&query=test\",\"headers\":{\"content-type\":\"application/json\"}}"
:: 应返回含 X-Argus / X-Gorgon 的 JSON

:: 3) 起 API 服务(回到包根目录)
cd /d %~dp0
set SIGN_SERVER=http://127.0.0.1:9099
set ADMIN_TOKEN=mytoken123
set PORT=8000
set BIND_HOST=127.0.0.1
set PYTHONUTF8=1
python\python.exe server.py

:: 4) 自检 API:浏览器打开 http://127.0.0.1:8000/ui
::    先到 http://127.0.0.1:8000/admin?admin_token=mytoken123 生成一个 api_key
::    再测:http://127.0.0.1:8000/search?q=好剧名&api_key=<刚生成的key>
```

### 8.2 一键 `启动.bat`(示例,供参考完善)

```bat
@echo off
chcp 65001 >nul
cd /d %~dp0
set PYTHONUTF8=1
set SIGN_SERVER=http://127.0.0.1:9099
set ADMIN_TOKEN=mytoken123
set PORT=8000
set BIND_HOST=127.0.0.1
set HG_SEARCH_MAX_ITEMS=20

echo [1/2] 启动 unidbg 签名服务 :9099 ...
start "unidbg-sign" /min cmd /c "cd /d %~dp0sign && ..\jre\bin\java.exe -Xmx512m -XX:+ExitOnOutOfMemoryError -jar unidbg-sign.jar serve 9099"

echo     等待签名服务就绪(首次约 10-20 秒)...
:waitsign
timeout /t 2 >nul
curl -s -o nul -w "%%{http_code}" -X POST http://127.0.0.1:9099/sign -H "Content-Type: application/json" -d "{\"url\":\"x\",\"headers\":{}}" | findstr /r "200" >nul
if errorlevel 1 goto waitsign

echo [2/2] 启动红果 API 服务 :8000 ...
start "" http://127.0.0.1:8000/ui
python\python.exe server.py
```

---

## 9. 验收自检清单(在 Windows 上必须逐条过)

1. `jre\bin\java.exe -version` → 是 **64 位**。
2. 签名服务启动日志出现 `签名工作线程就绪` + `离线签名服务已启动`,且**无** `UnsatisfiedLinkError` / 找不到 `libmetasec_ml.so`。
3. `POST /sign` 返回含 `X-Argus`、`X-Gorgon`、`X-Ladon` 的 JSON(不是 `{"error":...}`,也不是全空)。
4. `python\python.exe -c "import fastapi,uvicorn,requests,Crypto"` 全部 import 成功(便携 Python 接线正确)。
5. `GET /search?q=...&api_key=...` 返回结果(证明 Python→签名→红果 全链路通)。
6. `GET /stream?series_id=...&ep=1&api_key=...`(或 `?vid=...`)能下载密文→解密→返回可播 mp4;浏览器 `<video>` 能播放并可拖动进度(Range)。
7. (若装了 ffmpeg)日志**没有** `未找到 ffmpeg` 提示;没装则会提示并降级,仍应能出文件。

---

## 10. 已知限制 / 常见坑(重点)

- **JRE/Python 必须 x64**;JRE 32 位或 Python 32 位都会导致原生库加载失败。
- **embeddable Python 启用 site**:必装步骤,否则 `import fastapi` 失败(见 §3)。
- **工作目录**:签名 java 必须从 `sign/` 启动,且 `capture/` 与其同级(§6),否则找不到 so。
- **首次签名慢**:unidbg 初始化 + JNI_OnLoad 需要约 10-20 秒,期间 `/sign` 可能超时,启动脚本要等就绪(§8.2 的 waitsign)。
- **内存**:单签名实例约 300-500MB;`-Xmx512m` 足够。多实例线性叠加。
- **杀毒软件**:可能对 `unicorn.dll`/内存执行行为误报,必要时加信任目录。
- **没有 `/grab`**:登录态靠 `hongguo.py` 静态配置,失效需人工更新(§7)。
- **端口占用**:9099 / 8000 被占时改端口并同步改 `SIGN_SERVER`/`PORT`。
- **不测试就打包风险高**:embeddable Python 接线、ffmpeg 路径这些必须在真 Windows 机上跑通 §9 全部再分发。

---

## 11. 给「配置这台绿色包的 AI」的任务清单(TODO)

1. 从源仓库 `hongguo/` 按 §2 收集全部文件,按 §6 目录结构摆好。
2. 下 Adoptium Temurin JDK17 Windows x64 **zip 版** → 解压到 `jre/`。
3. 下 `python-3.11.x-embed-amd64.zip` → 解压到 `python/`;**启用 site**;`pip` 按 §4.1(或 4.2)把依赖装进去;跑 §9 第 4 条确认 import 全过。
4. (可选)下 ffmpeg essentials(gyan.dev / BtbN)→ `ffmpeg/bin/ffmpeg.exe`;把它加进 `启动.bat` 的 PATH。
5. 写 `启动.bat`(参考 §8.2),把签名服务和 API 服务串起来,含就绪等待与自检。
6. 在真 Windows 机上按 §9 逐条验收,把不过的项修好。
7. 全过后,整个文件夹压成 zip,即「解压双击即用」的绿色包。

---

## 附:版本/端口/口令速查

| 项 | 值 |
|---|---|
| 签名服务 | `http://127.0.0.1:9099`,`POST /sign` |
| API 服务 | `http://127.0.0.1:8000`,UI `/ui`,管理 `/admin?admin_token=...` |
| 胖 jar | `unidbg-sign-1.0-jar-with-dependencies.jar`(31MB,已含 win64 原生库) |
| 签名 so | `libmetasec_ml.so` 3.3MB / `libc++_shared.so` 891KB / `ms_16777218.bin` 2KB |
| JRE | OpenJDK 17 x64(便携 zip) |
| Python | 3.11 embeddable x64 |
| 最小 Python 包 | requests / fastapi / uvicorn[standard] / pycryptodome |
