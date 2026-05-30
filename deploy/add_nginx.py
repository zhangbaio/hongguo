# -*- coding: utf-8 -*-
"""在云服务器(宝塔nginx)加 hongguo.momotools.top 反向代理 -> 127.0.0.1:39001(隧道)"""
import os, paramiko

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]
DOMAIN = os.environ.get("HG_DOMAIN", "hongguo.momotools.top")

CONF = f"""server {{
    listen 80;
    server_name {DOMAIN};
    location / {{
        proxy_pass http://127.0.0.1:39001;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_http_version 1.1;
        proxy_read_timeout 600s;
        proxy_buffering off;
    }}
}}
"""

c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
sftp = c.open_sftp()
path = f"/www/server/panel/vhost/nginx/{DOMAIN}.conf"
with sftp.open(path, "w") as f:
    f.write(CONF)
print("[写]", path)


def run(cmd):
    _, o, e = c.exec_command(cmd, timeout=60)
    print(o.read().decode(errors="ignore") + e.read().decode(errors="ignore"))


run("/www/server/nginx/sbin/nginx -t 2>&1")
run("/www/server/nginx/sbin/nginx -s reload 2>&1 && echo nginx已reload")
sftp.close(); c.close()
print(f"完成。DNS 解析 {DOMAIN} -> {HOST} 后即可 http://{DOMAIN}/ui")
