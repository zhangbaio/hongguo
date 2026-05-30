# 红果 API 服务容器(签名服务+API)。需配合 redroid(arm64) 容器使用。
# 构建上下文 = 项目根目录(D:\code\hongguo): docker build -f redroid/Dockerfile -t hongguo-api .
FROM python:3.11-slim

ARG FRIDA_VER=16.7.19
RUN apt-get update && apt-get install -y --no-install-recommends \
        android-tools-adb wget xz-utils curl ca-certificates \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# frida-server (android arm64, 推送进 redroid 用) + host frida(python, 版本须与server一致)
RUN wget -q "https://github.com/frida/frida/releases/download/${FRIDA_VER}/frida-server-${FRIDA_VER}-android-arm64.xz" \
    && unxz "frida-server-${FRIDA_VER}-android-arm64.xz" \
    && mv "frida-server-${FRIDA_VER}-android-arm64" frida-server-arm64 \
    && chmod 755 frida-server-arm64
RUN pip install --no-cache-dir "frida==${FRIDA_VER}" fastapi "uvicorn[standard]" requests

# 业务代码
COPY hongguo.py sign_server.py server.py safeguards.py ./
COPY frida/oracle.js ./frida/oracle.js
# 兜底 config(grab_config 会在容器内重新生成与设备匹配的版本)
COPY config.json ./config.json
# 红果 APK(用于安装进 redroid)
COPY base.apk ./base.apk
# 部署脚本
COPY redroid/entrypoint.sh redroid/provision.sh redroid/grab_config.py ./
RUN chmod +x entrypoint.sh provision.sh

EXPOSE 8000
CMD ["./entrypoint.sh"]
