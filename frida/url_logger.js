// 记录 app 发起的所有 API URL (hook tryAddSecurityFactor, 每个请求都会经过)
Java.perform(function () {
    var NP = Java.use("com.bytedance.frameworks.baselib.network.http.NetworkParams");
    NP.tryAddSecurityFactor.overload("java.lang.String", "java.util.Map").implementation = function (url, headers) {
        try {
            var u = url.toString();
            // 只关心业务接口
            if (u.indexOf("fqnovel.com") >= 0 || u.indexOf("snssdk.com") >= 0) {
                var path = u.split("?")[0].replace(/https?:\/\/[^/]+/, "");
                send("URL " + path + "  ||  " + u.substring(0, 400));
            }
        } catch (e) {}
        return this.tryAddSecurityFactor(url, headers);
    };
    send("URL logger ready");
});
