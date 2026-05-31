# -*- coding: utf-8 -*-
"""纯Python SSH反向隧道: 云服务器:39001 -> 本地 server.py:8000
公网访问 http://<云IP>:39001/ui 即转发到本地服务。带自动重连。
环境: SSH_HOST/SSH_USER/SSH_PWD  (可选 REMOTE_PORT/LOCAL_PORT)
"""
import os, sys, time, socket, threading, select, paramiko

HOST = os.environ.get("SSH_HOST", "<SERVER_IP>"); USER = os.environ.get("SSH_USER", "root")
PWD = os.environ.get("SSH_PWD")
HERE = os.path.dirname(os.path.abspath(__file__))
KEY = os.path.join(HERE, "id_hongguo")
# 端口优先级: 命令行参数 > 环境变量 > 默认(39001/8000)。
# 命令行用法: python tunnel.py [REMOTE_PORT] [LOCAL_PORT]  (便于多实例在进程列表中区分)
REMOTE_PORT = int(sys.argv[1]) if len(sys.argv) > 1 else int(os.environ.get("REMOTE_PORT", "39001"))
LOCAL_PORT = int(sys.argv[2]) if len(sys.argv) > 2 else int(os.environ.get("LOCAL_PORT", "8000"))
LOCAL_HOST = "127.0.0.1"


def handler(chan):
    try:
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.connect((LOCAL_HOST, LOCAL_PORT))
    except Exception as e:
        print("[tunnel] 连本地失败:", e); chan.close(); return
    try:
        while True:
            r, _, _ = select.select([sock, chan], [], [], 60)
            if sock in r:
                d = sock.recv(65536)
                if not d: break
                chan.sendall(d)
            if chan in r:
                d = chan.recv(65536)
                if not d: break
                sock.sendall(d)
    except Exception:
        pass
    finally:
        sock.close(); chan.close()


def serve():
    cli = paramiko.SSHClient()
    cli.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    kw = dict(timeout=20, banner_timeout=30, auth_timeout=30)
    if os.path.exists(KEY):
        kw["pkey"] = paramiko.RSAKey.from_private_key_file(KEY)
    else:
        kw["password"] = PWD
    cli.connect(HOST, username=USER, **kw)
    try:
        tr = cli.get_transport()
        tr.set_keepalive(30)
        tr.request_port_forward("0.0.0.0", REMOTE_PORT)
        print(f"[tunnel] 已建立: {HOST}:{REMOTE_PORT} -> 本地:{LOCAL_PORT}  公网 http://{HOST}:{REMOTE_PORT}/ui")
        while True:
            chan = tr.accept(1000)
            if chan is None:
                if not tr.is_active():
                    raise IOError("transport 断开")
                continue
            threading.Thread(target=handler, args=(chan,), daemon=True).start()
    finally:
        # 关闭连接, 让 sshd 立刻释放远端转发端口(避免重连时 request_port_forward 撞"端口占用")
        try:
            cli.close()
        except Exception:
            pass


def main():
    while True:
        try:
            serve()
        except Exception as e:
            print(f"[tunnel] 断开,5s后重连: {e}")
            time.sleep(5)


if __name__ == "__main__":
    main()
