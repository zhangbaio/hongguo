// 签名预言机 + 配置抓取
//   rpc.exports.sign(url, headersObj)  -> 安全头(X-Argus/X-Gorgon/...)
//   rpc.exports.grab(timeoutMs)        -> 捕获app自然请求的 {url, headers}(用于刷新登录态)
var NP = null;
function ensureNP() {
    if (!NP) NP = Java.use("com.bytedance.frameworks.baselib.network.http.NetworkParams");
    return NP;
}

function mapToObj(m) {
    var o = {};
    var it = m.keySet().iterator();
    while (it.hasNext()) {
        var k = it.next();
        var v = m.get(k);
        var sv = v ? v.toString() : null;
        if (sv && sv.charAt(0) === '[' && sv.charAt(sv.length - 1) === ']')
            sv = sv.substring(1, sv.length - 1);
        o[k.toString()] = sv;
    }
    return o;
}

rpc.exports = {
    sign: function (url, headersObj) {
        return new Promise(function (resolve, reject) {
            Java.perform(function () {
                try {
                    var HashMap = Java.use("java.util.HashMap");
                    var ArrayList = Java.use("java.util.ArrayList");
                    var m = HashMap.$new();
                    Object.keys(headersObj).forEach(function (k) {
                        var lst = ArrayList.$new();
                        lst.add(headersObj[k]);
                        m.put(k, lst);
                    });
                    resolve(mapToObj(ensureNP().tryAddSecurityFactor(url, m)));
                } catch (e) {
                    reject("" + (e && e.message ? e.message : e));
                }
            });
        });
    },

    // 一次性观察 app 自然请求(含x-ss-req-ticket,排除我们自己的sign调用),取新鲜token/设备参数
    grab: function (timeoutMs) {
        return new Promise(function (resolve, reject) {
            Java.perform(function () {
                var NPc = ensureNP();
                var ov = NPc.tryAddSecurityFactor.overload("java.lang.String", "java.util.Map");
                var done = false;
                ov.implementation = function (url, h) {
                    var ret = ov.call(this, url, h);
                    try {
                        if (!done) {
                            var u = url.toString();
                            var hasTicket = h.containsKey("x-ss-req-ticket") || h.containsKey("X-SS-REQ-TICKET");
                            if (u.indexOf("fqnovel.com") >= 0 && u.indexOf("device_id=") >= 0 && hasTicket) {
                                done = true;
                                var obj = { url: u, headers: mapToObj(h) };
                                ov.implementation = null;  // 复原,不再观察
                                resolve(obj);
                            }
                        }
                    } catch (e) {}
                    return ret;
                };
                setTimeout(function () {
                    if (!done) { ov.implementation = null; reject("grab timeout"); }
                }, timeoutMs || 30000);
            });
        });
    }
};
