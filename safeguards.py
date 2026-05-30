# -*- coding: utf-8 -*-
"""风控防护层: 缓存 + 节流 + 风控识别。被 hongguo.py 使用。"""
import time, threading, hashlib, json, random

# ---------------- TTL 缓存 (REDIS_URL 设置则用Redis多实例共享,否则进程内内存) ----------------
import os, pickle
_cache = {}
_cache_lock = threading.Lock()
_redis = None
_REDIS_URL = os.environ.get("REDIS_URL")
if _REDIS_URL:
    try:
        import redis as _redislib
        _redis = _redislib.from_url(_REDIS_URL)
        _redis.ping()
        print("[cache] 使用 Redis:", _REDIS_URL)
    except Exception as e:
        print("[cache] Redis 不可用,回退内存:", e)
        _redis = None


def cache_get(key):
    if _redis is not None:
        try:
            v = _redis.get("hg:" + key)
            return pickle.loads(v) if v else None
        except Exception:
            return None
    with _cache_lock:
        v = _cache.get(key)
        if v and v[0] > time.time():
            return v[1]
        if v:
            _cache.pop(key, None)
    return None


def cache_set(key, val, ttl):
    if _redis is not None:
        try:
            _redis.setex("hg:" + key, int(ttl), pickle.dumps(val))
        except Exception:
            pass
        return
    with _cache_lock:
        _cache[key] = (time.time() + ttl, val)


def cache_key(*parts):
    return hashlib.md5(json.dumps(parts, ensure_ascii=False, sort_keys=True).encode()).hexdigest()


# ---------------- 节流(令牌桶 + 最小间隔 + 抖动) ----------------
class Throttle:
    def __init__(self, min_interval=0.6, jitter=0.4, burst=3, refill_per_sec=1.5):
        self.min_interval = min_interval
        self.jitter = jitter
        self.lock = threading.Lock()
        self.last = 0.0
        self.tokens = burst
        self.burst = burst
        self.refill = refill_per_sec
        self.token_ts = time.time()

    def wait(self):
        with self.lock:
            now = time.time()
            # 令牌桶补充
            self.tokens = min(self.burst, self.tokens + (now - self.token_ts) * self.refill)
            self.token_ts = now
            # 最小间隔
            gap = now - self.last
            need = self.min_interval + random.uniform(0, self.jitter)
            sleep = 0.0
            if gap < need:
                sleep = need - gap
            if self.tokens < 1:
                sleep = max(sleep, (1 - self.tokens) / self.refill)
            if sleep > 0:
                time.sleep(sleep)
            self.tokens = max(0, self.tokens - 1)
            self.last = time.time()


throttle = Throttle()


# ---------------- 风控识别 ----------------
class RiskControlError(Exception):
    pass


class AuthExpiredError(Exception):
    """登录态(token/cookie)过期"""
    pass


# 登录过期相关码/关键词
AUTH_CODES = {401, 403, 8, 1001}
AUTH_KEYWORDS = ("token", "登录", "login", "未登录", "not login", "unauthor",
                 "登陆", "session", "expire", "凭证", "重新登录")


# 已知风控/异常码(字节系常见; code=0 才是正常)
RISK_CODES = {
    110001,           # 未知异常(我们见过,通常签名/校验问题)
    100001, 100002,   # 限流/频控类(经验值)
    8,                # 部分接口的验证码挑战
}
RISK_KEYWORDS = ("verify", "captcha", "risk", "频繁", "稍后", "验证", "rate limit", "too many")


def check_response(j):
    """检查响应。正常返回; 登录过期抛 AuthExpiredError; 风控/异常抛 RiskControlError。"""
    if not isinstance(j, dict):
        return
    code = j.get("code")
    msg = (j.get("message") or "") + (j.get("BaseResp", {}).get("StatusMessage", "") if isinstance(j.get("BaseResp"), dict) else "")
    ml = msg.lower()
    if code in (0, None):
        if any(k in ml for k in RISK_KEYWORDS):
            raise RiskControlError(f"疑似风控: {msg}")
        return
    if code in AUTH_CODES or any(k in ml for k in AUTH_KEYWORDS):
        raise AuthExpiredError(f"登录态失效 code={code} msg={msg}")
    if code in RISK_CODES or any(k in ml for k in RISK_KEYWORDS):
        raise RiskControlError(f"风控触发 code={code} msg={msg}")
    raise RiskControlError(f"接口返回异常 code={code} msg={msg}")
