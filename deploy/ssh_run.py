# -*- coding: utf-8 -*-
"""在远程服务器执行命令(逐条打印)。凭证走环境变量。
用法: python ssh_run.py "cmd1" "cmd2" ...  (或不传则跑内置体检)
环境: SSH_HOST/SSH_USER/SSH_PWD
"""
import os, sys, paramiko

HOST = os.environ["SSH_HOST"]; USER = os.environ.get("SSH_USER", "root"); PWD = os.environ["SSH_PWD"]

recon = [
    "uname -m; echo '---'",
    "which ufw && ufw status 2>/dev/null | head -8 || echo 'no ufw'",
    "iptables -L INPUT -n 2>/dev/null | head -6 || echo 'no iptables view'",
    "ss -tlnp 2>/dev/null | grep -E ':7000|:8000' || echo '7000/8000 空闲'",
    "docker ps --format '{{.Names}} {{.Image}} {{.Ports}}' 2>/dev/null || echo 'no docker ps'",
    "curl -s -m5 ifconfig.me || echo '?'; echo ' (公网IP)'",
]
cmds = sys.argv[1:] or recon

c = paramiko.SSHClient(); c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
c.connect(HOST, username=USER, password=PWD, timeout=20)
for cmd in cmds:
    _, out, err = c.exec_command(cmd, timeout=120)
    o = out.read().decode(errors="ignore") + err.read().decode(errors="ignore")
    print(f"$ {cmd}\n{o.strip()}\n")
c.close()
