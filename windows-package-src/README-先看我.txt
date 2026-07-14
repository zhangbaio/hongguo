红果脱机直连 · Windows 绿色包「素材包」
==========================================

这个文件夹已经把【源仓库这边要用到的所有文件】按目标结构摆好了。
你把它整个拷到 Windows 电脑,再补 3 个运行时(JRE / Python / ffmpeg)就能跑。

【已包含】(来自 macOS 源仓库,无需再找)
  sign/unidbg-sign.jar              签名胖jar(31MB,已含 Windows x64 原生库,直接能跑)
  capture/fq_oversea/*.so, *.bin    签名资源(so 与 jar 的相对路径写死,别改目录层级)
  server.py hongguo.py offline_dl.py
  apikeys.py safeguards.py downloader.py devicepool.py   API 服务源码
  frida/                            解密模块(整目录)
  web/                              /ui 与 /admin 网页
  config.example.json               配置模板(按需复制成 config.json)
  requirements-windows.txt          Python 依赖清单

【还需在 Windows 补齐】(见完整文档 §3)
  jre/            便携 OpenJDK 17 x64(Adoptium Temurin 的 zip 版,解压即用)
  python/         Windows embeddable Python 3.11 x64(官网 zip,解压即用;记得启用 site)
  ffmpeg/bin/ffmpeg.exe   可选(不带也能出可播文件)
  启动.bat        一键启动脚本(文档 §8.2 有示例)

【完整步骤 / 协议 / 排错 / 验收清单】
  见源仓库:docs/Windows脱机直连-unidbg-部署需求文档.md
  (强烈建议把那份 md 一起带到 Windows,让配置的 AI 照着做)

【最关键的 3 个坑】
  1. JRE 和 Python 都必须 64 位。
  2. embeddable Python 默认禁用 site,必须启用,否则 import fastapi 失败。
  3. 签名 java 必须从 sign\ 目录启动,capture\ 要和 sign\ 同级(so 按 ../capture/... 找)。
