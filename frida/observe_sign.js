// 观察 tryAddSecurityFactor 和 getReportRaw 的输入输出
Java.perform(function () {
    function mapToObj(m) {
        var o = {};
        try {
            var it = m.keySet().iterator();
            while (it.hasNext()) {
                var k = it.next();
                o[k.toString()] = m.get(k) ? m.get(k).toString() : null;
            }
        } catch (e) { return "<map err " + e + ">"; }
        return o;
    }

    try {
        var NP = Java.use("com.bytedance.frameworks.baselib.network.http.NetworkParams");
        NP.tryAddSecurityFactor.overload("java.lang.String", "java.util.Map").implementation = function (url, headers) {
            var ret = this.tryAddSecurityFactor(url, headers);
            send({ fn: "tryAddSecurityFactor", url: url.toString().substring(0, 160),
                   in_headers: mapToObj(headers), out: mapToObj(ret) });
            return ret;
        };
        send("hooked tryAddSecurityFactor");
    } catch (e) { send("hook tryAddSecurityFactor fail: " + e); }

    try {
        var MS = Java.use("com.bytedance.mobsec.metasec.ml.MSManager");
        MS.getReportRaw.overload("java.lang.String", "int", "java.util.Map").implementation = function (url, t, params) {
            var ret = this.getReportRaw(url, t, params);
            send({ fn: "getReportRaw", url: url.toString().substring(0, 160), actionType: t,
                   in_params: mapToObj(params), out: mapToObj(ret) });
            return ret;
        };
        send("hooked getReportRaw");
    } catch (e) { send("hook getReportRaw fail: " + e); }
});
