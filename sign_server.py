# -*- coding: utf-8 -*-
"""签名服务(独立进程,持有Frida预言机) —— 带看门狗+自动重连
和模拟器/redroid/手机部署在一起。API服务器通过 HTTP 调它。

健壮性:
  - 看门狗线程: 定期确保 frida-server 在跑、app 在跑、frida会话存活;
    任一挂掉自动恢复(重启frida-server / 重新拉起app / 重新attach)。
  - sign 失败检测会话死亡 → 自动重连并重试。
  - /grab: 捕获app自然请求,用于上层刷新登录态。

启动: python sign_server.py   (默认 127.0.0.1:8001)
接口: POST /sign {url,headers} -> 签名头 ; GET /grab -> {url,headers} ; GET / 健康
"""
import os, json, time, threading, subprocess
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer
import frida

ADB = os.environ.get("ADB", r"D:\Program Files\Netease\MuMu Player 12\shell\adb.exe")
DEV = os.environ.get("ADB_DEVICE", "127.0.0.1:16384")
FRIDA_HOST = os.environ.get("FRIDA_HOST", "127.0.0.1:27042")
FRIDA_BIN = os.environ.get("FRIDA_BIN", "/data/local/tmp/frida-server")
PKG = "com.phoenix.read"
PORT = int(os.environ.get("SIGN_PORT", "8001"))
ORACLE_JS = os.path.join(os.path.dirname(os.path.abspath(__file__)), "frida", "oracle.js")

_lock = threading.Lock()        # 串行化 frida 调用
_script = None
_session = None
_pid = None
_detached = threading.Event()   # 会话断开标志


def adb(*args, timeout=30):
    return subprocess.run([ADB, "-s", DEV] + list(args), capture_output=True, text=True, timeout=timeout)


def app_pid():
    try:
        out = adb("shell", "pidof", PKG).stdout.strip()
        return int(out.split()[0]) if out else None
    except Exception:
        return None


def frida_running():
    try:
        return bool(adb("shell", "pidof", "frida-server").stdout.strip())
    except Exception:
        return False


def ensure_frida_server():
    if frida_running():
        return
    print("[watchdog] frida-server 不在,重启...")
    # redroid/手机root用su,有的环境adb即root; 两种都试
    adb("shell", f"su -c 'nohup {FRIDA_BIN} >/dev/null 2>&1 &' || (nohup {FRIDA_BIN} >/dev/null 2>&1 &)")
    time.sleep(3)
    adb("forward", "tcp:27042", "tcp:27042")


def ensure_app():
    if app_pid():
        return
    print("[watchdog] app 不在,拉起...")
    adb("shell", "monkey", "-p", PKG, "-c", "android.intent.category.LAUNCHER", "1", timeout=30)
    time.sleep(6)


def connect():
    """(重新)建立 frida 会话并加载预言机"""
    global _script, _session, _pid
    ensure_frida_server()
    ensure_app()
    adb("forward", "tcp:27042", "tcp:27042")
    pid = app_pid()
    if not pid:
        raise RuntimeError("app 未运行,无法attach")
    dev = frida.get_device_manager().add_remote_device(FRIDA_HOST)
    session = dev.attach(pid)
    _detached.clear()
    session.on("detached", lambda *a: _detached.set())
    script = session.create_script(open(ORACLE_JS, encoding="utf-8").read())
    script.load()
    _script, _session, _pid = script, session, pid
    print(f"[sign_server] 已连接 (pid={pid})")


def reconnect():
    global _script
    _script = None
    for i in range(5):
        try:
            connect()
            return True
        except Exception as e:
            print(f"[reconnect] 第{i+1}次失败: {e}")
            time.sleep(3 + i * 2)
    return False


def watchdog():
    while True:
        time.sleep(15)
        try:
            cur = app_pid()
            if _detached.is_set() or _script is None or cur is None or cur != _pid:
                print(f"[watchdog] 需要重连 (detached={_detached.is_set()}, pid={_pid}->{cur})")
                with _lock:
                    reconnect()
        except Exception as e:
            print(f"[watchdog] 异常: {e}")


def do_sign(url, headers):
    with _lock:
        if _script is None:
            reconnect()
        try:
            return _script.exports_sync.sign(url, headers)
        except Exception as e:
            print(f"[sign] 调用失败,尝试重连: {e}")
            if reconnect():
                return _script.exports_sync.sign(url, headers)
            raise


def do_grab(timeout_ms=30000):
    with _lock:
        if _script is None:
            reconnect()
        # 触发app活动以产生自然请求
        adb("shell", "monkey", "-p", PKG, "-c", "android.intent.category.LAUNCHER", "1", timeout=20)
        return _script.exports_sync.grab(timeout_ms)


class Handler(BaseHTTPRequestHandler):
    def log_message(self, *a):
        pass

    def _send(self, code, obj):
        body = json.dumps(obj).encode()
        self.send_response(code)
        self.send_header("content-type", "application/json")
        self.send_header("content-length", str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def do_POST(self):
        if self.path != "/sign":
            self.send_error(404); return
        try:
            n = int(self.headers.get("content-length", 0))
            req = json.loads(self.rfile.read(n))
            self._send(200, do_sign(req["url"], req["headers"]))
        except Exception as e:
            self._send(500, {"error": str(e)})

    def do_GET(self):
        if self.path.startswith("/grab"):
            try:
                self._send(200, do_grab())
            except Exception as e:
                self._send(500, {"error": str(e)})
        else:
            self._send(200 if _script else 503, {"ready": _script is not None, "pid": _pid})


if __name__ == "__main__":
    connect()
    threading.Thread(target=watchdog, daemon=True).start()
    print(f"[sign_server] 监听 127.0.0.1:{PORT} (看门狗已启动)")
    ThreadingHTTPServer(("127.0.0.1", PORT), Handler).serve_forever()
