# -*- coding: utf-8 -*-
"""在云服务器安装并启动 frps(systemd自启)。本地上传frp,避免服务器墙。
环境: SSH_HOST/SSH_USER/SSH_PWD/FRP_TOKEN
端口: 39000(控制) 39001(公网API转发) —— 在ufw已开放的39000-40000范围内
"""
import os, io, urllib.request, paramiko

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]
TOKEN = os.environ["FRP_TOKEN"]
FRP_URL = "https://github.com/fatedier/frp/releases/download/v0.61.1/frp_0.61.1_linux_amd64.tar.gz"

FRPS_TOML = f"""bindPort = 39000
auth.method = "token"
auth.token = "{TOKEN}"
# 仅控制端口对外; 公网API由frpc请求的 remotePort 39001 暴露
log.to = "/var/log/frps.log"
log.level = "info"
"""

SYSTEMD = """[Unit]
Description=frp server
After=network.target

[Service]
Type=simple
ExecStart=/usr/local/bin/frps -c /etc/frp/frps.toml
Restart=always
RestartSec=5

[Install]
WantedBy=multi-user.target
"""

c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
sftp = c.open_sftp()


def run(cmd):
    _, out, err = c.exec_command(cmd, timeout=120)
    o = out.read().decode(errors="ignore") + err.read().decode(errors="ignore")
    print(f"$ {cmd}\n{o.strip()}\n")
    return o


def put_text(path, content):
    with sftp.open(path, "w") as f:
        f.write(content)
    print(f"[写] {path}")


print("== 下载 frp 到内存(本机连github) ==")
buf = io.BytesIO(urllib.request.urlopen(FRP_URL, timeout=120).read())
print(f"  {buf.getbuffer().nbytes} bytes")
print("== 流式上传到服务器 ==")
buf.seek(0)
sftp.putfo(buf, "/tmp/frp_linux_amd64.tar.gz")
run("cd /tmp && tar xzf frp_linux_amd64.tar.gz && cp frp_*/frps /usr/local/bin/frps && chmod 755 /usr/local/bin/frps && /usr/local/bin/frps --version")

print("== 写配置 ==")
run("mkdir -p /etc/frp")
put_text("/etc/frp/frps.toml", FRPS_TOML)
put_text("/etc/systemd/system/frps.service", SYSTEMD)

print("== 启动服务 ==")
run("systemctl daemon-reload && systemctl enable frps && systemctl restart frps && sleep 2 && systemctl is-active frps")
run("ss -tln | grep 39000 || echo '39000未监听!'")
sftp.close(); c.close()
print("== frps 部署完成 ==")
