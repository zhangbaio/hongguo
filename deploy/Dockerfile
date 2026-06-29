# 一个镜像同时具备 JDK(跑签名器)+ Python + ffmpeg(跑流水线)。
# 用 compose 起两个容器(sign / api)复用此镜像。
# 注意:fat jar、capture/fq_oversea/*.so、config.json 等是 gitignore 的密文/二进制,
#       不打进镜像,运行时用 volume 挂载(见 docker-compose.yml)。
# 构建上下文为仓库根,建议在根放 .dockerignore(内容见 deploy/README.md)避免密文入层。
FROM eclipse-temurin:17-jdk-jammy

RUN apt-get update && \
    apt-get install -y --no-install-recommends python3 python3-pip ffmpeg && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY . /app
RUN pip3 install --no-cache-dir -r deploy/requirements-server.txt

ENV PYTHONPATH=/app/frida:/app \
    JAVA_TOOL_OPTIONS=-Djava.awt.headless=true
EXPOSE 8000
# 默认跑 API;签名容器在 compose 里用 command 覆盖
CMD ["python3", "server.py"]
