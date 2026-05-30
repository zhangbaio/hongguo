# -*- coding: utf-8 -*-
"""只读体检远程服务器是否适合跑 redroid"""
import paramiko, sys

import os
HOST = os.environ.get("SSH_HOST", "")
USER = os.environ.get("SSH_USER", "root")
PWD = os.environ.get("SSH_PWD", "")

cmds = [
    ("架构", "uname -m"),
    ("内核", "uname -r"),
    ("系统", "cat /etc/os-release 2>/dev/null | grep PRETTY_NAME"),
    ("CPU核数", "nproc"),
    ("内存", "free -h | grep Mem"),
    ("磁盘", "df -h / | tail -1"),
    ("binder设备", "ls -la /dev/binder* /dev/binderfs 2>/dev/null || echo '无 /dev/binder*'"),
    ("binderfs挂载", "cat /proc/filesystems 2>/dev/null | grep binder || echo '无binderfs文件系统'"),
    ("binder模块", "modinfo binder_linux 2>/dev/null | head -2 || echo '无binder_linux模块(可能内置或不支持)'"),
    ("ashmem", "ls /dev/ashmem 2>/dev/null || echo '无ashmem(新内核用memfd)'"),
    ("docker", "docker --version 2>/dev/null || echo '未装docker'"),
    ("docker-compose", "docker compose version 2>/dev/null || docker-compose --version 2>/dev/null || echo '无compose'"),
    ("是否容器/虚拟化", "systemd-detect-virt 2>/dev/null || echo '?'"),
]

try:
    c = paramiko.SSHClient()
    c.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    c.connect(HOST, username=USER, password=PWD, timeout=15)
except Exception as e:
    print("SSH连接失败:", e); sys.exit(1)

for name, cmd in cmds:
    _, out, err = c.exec_command(cmd, timeout=20)
    o = (out.read().decode(errors="ignore") + err.read().decode(errors="ignore")).strip()
    print(f"[{name}] {o}")
c.close()
