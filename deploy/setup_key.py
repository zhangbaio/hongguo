# -*- coding: utf-8 -*-
"""生成SSH密钥并装到云服务器,之后隧道免密码。环境: SSH_HOST/SSH_USER/SSH_PWD"""
import os, io, paramiko

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]
HERE = os.path.dirname(os.path.abspath(__file__))
KEY = os.path.join(HERE, "id_hongguo")

if not os.path.exists(KEY):
    k = paramiko.RSAKey.generate(2048)
    k.write_private_key_file(KEY)
    pub = f"{k.get_name()} {k.get_base64()} hongguo-tunnel"
    open(KEY + ".pub", "w").write(pub)
    print("[生成] 密钥", KEY)
else:
    pub = open(KEY + ".pub").read().strip()
    print("[已有] 密钥")

c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
# 追加公钥(去重)
cmd = (f'mkdir -p ~/.ssh && chmod 700 ~/.ssh && touch ~/.ssh/authorized_keys && '
       f'grep -qF "{pub.split()[1]}" ~/.ssh/authorized_keys || echo "{pub}" >> ~/.ssh/authorized_keys; '
       f'chmod 600 ~/.ssh/authorized_keys; echo done')
_, o, e = c.exec_command(cmd, timeout=30)
print(o.read().decode() + e.read().decode())
c.close()

# 测试密钥登录
c2 = paramiko.SSHClient(); c2.set_missing_host_key_policy(paramiko.AutoAddPolicy())
pkey = paramiko.RSAKey.from_private_key_file(KEY)
c2.connect(HOST, username=USER, pkey=pkey, timeout=20)
_, o, _ = c2.exec_command("whoami")
print("密钥登录测试:", o.read().decode().strip())
c2.close()
print("完成。隧道现在可免密码(用 id_hongguo)。")
