# -*- coding: utf-8 -*-
"""更新 short-vedio-manage 部署(weixinshortdrama.momotools.top): 仅传集成代码, 保数据, 重建。
环境: SSH_HOST/SSH_USER/SSH_PWD
"""
import os, posixpath, paramiko

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]
LOCAL = r"D:\code\short-vedio-manage"
REMOTE = "/www/wwwroot/weixinshortdrama.momotools.top/short-vedio-manage"

# 只传集成相关文件(相对路径); 绝不传 data/ 和 .env
FILES = [
    "app.py", "hongguo_bp.py", "requirements.txt",
    "hongguo_core/hongguo.py", "hongguo_core/safeguards.py",
    "hongguo_core/downloader.py", "hongguo_core/config.json",
    "templates/hongguo_browse.html", "templates/hongguo_keys.html",
    "templates/partials/sidebar.html",
]

c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
sftp = c.open_sftp()


def run(cmd, t=600):
    _, o, e = c.exec_command(cmd, timeout=t)
    out = o.read().decode(errors="ignore") + e.read().decode(errors="ignore")
    print(f"$ {cmd[:80]}\n{out.strip()[-2000:]}\n"); return out


def ensure_dir(remote_dir):
    parts = remote_dir.strip("/").split("/")
    cur = ""
    for p in parts:
        cur += "/" + p
        try: sftp.stat(cur)
        except IOError: sftp.mkdir(cur)


print("== 备份服务器 app.py(回滚用) ==")
run(f"cp {REMOTE}/app.py {REMOTE}/app.py.bak.$(date +%s)")

print("== 上传集成文件 ==")
for rel in FILES:
    lp = os.path.join(LOCAL, rel.replace("/", os.sep))
    rp = posixpath.join(REMOTE, rel)
    ensure_dir(posixpath.dirname(rp))
    sftp.put(lp, rp)
    print("  ↑", rel)

print("== 给 docker-compose.yml 注入 SIGN_SERVER 透传(若无) ==")
# 在 environment: 块加 SIGN_SERVER; 用 python 在服务器原地改, 幂等
patch = (
    "import re,io\n"
    f"p='{REMOTE}/docker-compose.yml'\n"
    "s=open(p,encoding='utf-8').read()\n"
    "if 'SIGN_SERVER' not in s:\n"
    "    s=s.replace('WX_MINIDRAMA_APPSECRET: ${WX_MINIDRAMA_APPSECRET:-}',"
    "'WX_MINIDRAMA_APPSECRET: ${WX_MINIDRAMA_APPSECRET:-}\\n      SIGN_SERVER: ${SIGN_SERVER:-}')\n"
    "    open(p,'w',encoding='utf-8').write(s); print('compose已注入SIGN_SERVER')\n"
    "else: print('compose已有SIGN_SERVER')\n"
)
sftp.open(REMOTE + "/_patch.py", "w").write(patch)
run(f"cd {REMOTE} && python3 _patch.py && rm _patch.py")

print("== .env 追加 SIGN_SERVER(若无) ==")
run(f"cd {REMOTE} && grep -q '^SIGN_SERVER=' .env || echo 'SIGN_SERVER=' >> .env; grep '^SIGN_SERVER=' .env")

print("== 重建并重启(数据卷 ./data 保留) ==")
run(f"cd {REMOTE} && docker compose build 2>&1 | tail -5", t=900)
run(f"cd {REMOTE} && docker compose up -d 2>&1 | tail -5")

print("== 容器状态 + 日志(看Blueprint是否加载) ==")
run("docker ps --format '{{.Names}} {{.Status}} {{.Ports}}' | grep weixinshortdrama")
run("sleep 4; docker logs weixinshortdrama_prod-app-1 --tail 15 2>&1")
sftp.close(); c.close()
print("== done ==")
