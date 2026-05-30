# -*- coding: utf-8 -*-
"""为 hongguo.momotools.top 签发并安装 Let's Encrypt 证书(acme.sh webroot)。"""
import os, paramiko, time

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]
DOMAIN = os.environ.get("HG_DOMAIN", "hongguo.momotools.top")
ACME = "/root/.acme.sh/acme.sh"
WEBROOT = "/www/wwwroot/hongguo_acme"
CERTDIR = f"/www/server/panel/vhost/cert/{DOMAIN}"
VHOST = f"/www/server/panel/vhost/nginx/{DOMAIN}.conf"
NGINX = "/www/server/nginx/sbin/nginx"

# 阶段1: 仅HTTP + acme挑战目录
HTTP_ONLY = f"""server {{
    listen 80;
    server_name {DOMAIN};
    location /.well-known/acme-challenge/ {{ root {WEBROOT}; }}
    location / {{
        proxy_pass http://127.0.0.1:39001;
        proxy_set_header Host $host; proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_http_version 1.1; proxy_read_timeout 600s; proxy_buffering off;
    }}
}}
"""
# 阶段2: HTTP跳转HTTPS + HTTPS反代
FINAL = f"""server {{
    listen 80;
    server_name {DOMAIN};
    location /.well-known/acme-challenge/ {{ root {WEBROOT}; }}
    location / {{ return 301 https://$host$request_uri; }}
}}
server {{
    listen 443 ssl;
    server_name {DOMAIN};
    ssl_certificate     {CERTDIR}/fullchain.pem;
    ssl_certificate_key {CERTDIR}/privkey.pem;
    ssl_protocols TLSv1.2 TLSv1.3;
    location / {{
        proxy_pass http://127.0.0.1:39001;
        proxy_set_header Host $host; proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_http_version 1.1; proxy_read_timeout 600s; proxy_buffering off;
    }}
}}
"""

c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
sftp = c.open_sftp()


def run(cmd, t=180):
    _, o, e = c.exec_command(cmd, timeout=t)
    out = o.read().decode(errors="ignore") + e.read().decode(errors="ignore")
    print(f"$ {cmd[:70]}\n{out.strip()[-1500:]}\n"); return out


def put(path, content):
    with sftp.open(path, "w") as f:
        f.write(content)
    print("[写]", path)


print("== 阶段1: HTTP + 挑战目录 ==")
run(f"mkdir -p {WEBROOT} {CERTDIR}")
put(VHOST, HTTP_ONLY)
run(f"{NGINX} -t && {NGINX} -s reload")

print("== 设默认CA为Let's Encrypt ==")
run(f"{ACME} --set-default-ca --server letsencrypt")

print("== 签发证书(webroot) ==")
run(f"{ACME} --issue -d {DOMAIN} --webroot {WEBROOT} --keylength ec-256 --server letsencrypt", t=240)

print("== 安装证书 + 配置自动续期reload ==")
run(f"{ACME} --install-cert -d {DOMAIN} --ecc "
    f"--key-file {CERTDIR}/privkey.pem "
    f"--fullchain-file {CERTDIR}/fullchain.pem "
    f"--reloadcmd '{NGINX} -s reload'")

print("== 阶段2: 启用HTTPS ==")
ok = run(f"test -f {CERTDIR}/fullchain.pem && echo CERT_OK || echo CERT_MISSING")
if "CERT_OK" in ok:
    put(VHOST, FINAL)
    run(f"{NGINX} -t && {NGINX} -s reload && echo HTTPS_ENABLED")
else:
    print("证书未生成,保持HTTP。检查上面签发日志。")
sftp.close(); c.close()
