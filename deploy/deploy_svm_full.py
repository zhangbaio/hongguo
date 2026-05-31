# -*- coding: utf-8 -*-
"""全量代码部署 short-vedio-manage 到 weixinshortdrama.momotools.top。
只更新代码, 保留数据: data/ 已在打包时排除; .env / hongguo_core/config.json
未跟踪不在包内, 解包不会覆盖。先备份服务器代码(可回滚)再覆盖, 然后重建容器。
环境: SSH_HOST/SSH_USER/SSH_PWD
本地需先生成: deploy/svm_code.tar.gz (git archive HEAD 排除 data/)
"""
import os, time, posixpath, paramiko

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]
REMOTE = "/www/wwwroot/weixinshortdrama.momotools.top/short-vedio-manage"
LOCAL_TAR = os.path.join(os.path.dirname(os.path.abspath(__file__)), "svm_code.tar.gz")
TS = time.strftime("%Y%m%d_%H%M%S")

c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
sftp = c.open_sftp()


def run(cmd, t=900):
    _, o, e = c.exec_command(cmd, timeout=t)
    out = o.read().decode(errors="ignore") + e.read().decode(errors="ignore")
    print(f"$ {cmd[:90]}\n{out.strip()[-2500:]}\n"); return out


print("== 1) 备份服务器当前代码(排除 data/, 可回滚) ==")
run(f"cd {REMOTE} && tar czf /tmp/svm_backup_{TS}.tar.gz --exclude=data --exclude=.git . && ls -la /tmp/svm_backup_{TS}.tar.gz")

print("== 2) 上传新代码包 ==")
sftp.put(LOCAL_TAR, "/tmp/svm_code.tar.gz")
print("  ↑ /tmp/svm_code.tar.gz", os.path.getsize(LOCAL_TAR), "bytes")

print("== 3) 解包覆盖代码(data/.env/config.json 不在包内, 自动保留) ==")
# 解包前确认 data/.env 存在; 解包(tar 不删除包外文件)
run(f"cd {REMOTE} && echo '解包前: ' && ls data/dramas.db .env hongguo_core/config.json 2>/dev/null; "
    f"tar xzf /tmp/svm_code.tar.gz -C {REMOTE} && echo '解包完成'")
print("== 校验保留项仍在 ==")
run(f"cd {REMOTE} && ls -la data/dramas.db .env hongguo_core/config.json 2>&1; "
    f"echo '--- compose 含签名配置? ---'; grep -E 'SIGN_SERVER|host-gateway' docker-compose.yml; "
    f"echo '--- .env SIGN_SERVER ---'; grep '^SIGN_SERVER=' .env")

print("== 4) 重建并重启(数据卷 ./data 保留) ==")
run(f"cd {REMOTE} && docker compose build 2>&1 | tail -6", t=1200)
run(f"cd {REMOTE} && docker compose up -d 2>&1 | tail -6")

print("== 5) 容器状态 + 启动日志 ==")
run("docker ps --format '{{.Names}} {{.Status}}' | grep -i weixin")
run("sleep 5; docker logs weixinshortdrama_prod-app-1 --tail 20 2>&1")

sftp.close(); c.close()
print(f"== done (回滚: 解包 /tmp/svm_backup_{TS}.tar.gz) ==")
