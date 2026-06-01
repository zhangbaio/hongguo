# -*- coding: utf-8 -*-
"""把 short-vedio-manage 部署域名切到 manjushortdrama.momotools.top:
新建 nginx vhost(反代 docker app 127.0.0.1:8001) -> 签发 Let's Encrypt 证书(acme webroot)
-> 启用 HTTPS+跳转 -> 停用旧域名 weixinshortdrama。环境: SSH_HOST/SSH_USER/SSH_PWD。
"""
import os, paramiko

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]
DOMAIN = "manjushortdrama.momotools.top"
OLD = "weixinshortdrama.momotools.top"
BACKEND = "http://127.0.0.1:8001"  # docker app(APP_PORT=8001 -> 容器8000)
ACME = "/root/.acme.sh/acme.sh"
WEBROOT = f"/www/wwwroot/{DOMAIN}"
CERTDIR = f"/www/server/panel/vhost/cert/{DOMAIN}"
VHOST = f"/www/server/panel/vhost/nginx/{DOMAIN}.conf"
OLD_VHOST = f"/www/server/panel/vhost/nginx/{OLD}.conf"
NGINX = "/www/server/nginx/sbin/nginx"

HTTP_ONLY = f"""server {{
    listen 80;
    server_name {DOMAIN};
    location /.well-known/acme-challenge/ {{ root {WEBROOT}; }}
    client_max_body_size 100m;
    location / {{
        proxy_pass {BACKEND};
        proxy_http_version 1.1;
        proxy_set_header Host $host; proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_read_timeout 600s; proxy_buffering off;
    }}
}}
"""
FINAL = f"""server {{
    listen 80;
    server_name {DOMAIN};
    location /.well-known/acme-challenge/ {{ root {WEBROOT}; }}
    location / {{ return 301 https://$host$request_uri; }}
}}
server {{
    listen 443 ssl;
    http2 on;
    server_name {DOMAIN};
    ssl_certificate     {CERTDIR}/fullchain.pem;
    ssl_certificate_key {CERTDIR}/privkey.pem;
    ssl_protocols TLSv1.2 TLSv1.3;
    ssl_ciphers EECDH+CHACHA20:EECDH+AES128:EECDH+AES256:!MD5;
    ssl_prefer_server_ciphers on;
    add_header Strict-Transport-Security "max-age=31536000";
    client_max_body_size 100m;
    location / {{
        proxy_pass {BACKEND};
        proxy_http_version 1.1;
        proxy_set_header Host $host; proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        proxy_read_timeout 600s; proxy_buffering off;
    }}
}}
"""

c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
sftp = c.open_sftp()


def run(cmd, t=240):
    _, o, e = c.exec_command(cmd, timeout=t)
    out = o.read().decode(errors="ignore") + e.read().decode(errors="ignore")
    print(f"$ {cmd[:72]}\n{out.strip()[-1500:]}\n"); return out


def put(path, content):
    with sftp.open(path, "w") as f:
        f.write(content)
    print("[写]", path)


print("== 1) HTTP vhost + 挑战目录 ==")
run(f"mkdir -p {WEBROOT} {CERTDIR}")
put(VHOST, HTTP_ONLY)
run(f"{NGINX} -t && {NGINX} -s reload")

print("== 2) 签发证书(webroot, EC-256, Let's Encrypt) ==")
run(f"{ACME} --set-default-ca --server letsencrypt")
run(f"{ACME} --issue -d {DOMAIN} --webroot {WEBROOT} --keylength ec-256 --server letsencrypt", t=300)

print("== 3) 安装证书 + 自动续期reload ==")
run(f"{ACME} --install-cert -d {DOMAIN} --ecc "
    f"--key-file {CERTDIR}/privkey.pem --fullchain-file {CERTDIR}/fullchain.pem "
    f"--reloadcmd '{NGINX} -s reload'")

print("== 4) 启用 HTTPS ==")
ok = run(f"test -f {CERTDIR}/fullchain.pem && echo CERT_OK || echo CERT_MISSING")
if "CERT_OK" in ok:
    put(VHOST, FINAL)
    run(f"{NGINX} -t && {NGINX} -s reload && echo HTTPS_ENABLED")
    print("== 5) 停用旧域名 weixinshortdrama ==")
    run(f"[ -f {OLD_VHOST} ] && mv {OLD_VHOST} {OLD_VHOST}.disabled && echo OLD_DISABLED || echo OLD_ALREADY_OFF")
    run(f"{NGINX} -t && {NGINX} -s reload && echo RELOADED")
else:
    print("证书未生成, 保持HTTP, 未停旧域名。检查上面签发日志。")
sftp.close(); c.close()
print("== done ==")
