// 记录 landpage 请求的 method+url+body —— hook Request 所有构造函数(可靠)
Java.perform(function () {
    var KW = "landpage";
    var Req = Java.use("com.bytedance.retrofit2.client.Request");
    var BAOS = Java.use("java.io.ByteArrayOutputStream");
    var JStr = Java.use("java.lang.String");

    function readBody(body) {
        if (!body) return null;
        try {
            var os = BAOS.$new();
            body.writeTo(os);
            return JStr.$new(os.toByteArray(), "UTF-8").toString();
        } catch (e) { return "<body err: " + e + ">"; }
    }

    var n = Req.$init.overloads.length;
    send("Request 构造函数重载数: " + n);
    for (var i = 0; i < n; i++) {
        Req.$init.overloads[i].implementation = function () {
            var r = this.$init.apply(this, arguments);
            try {
                var url = this.getUrl();
                if (url && url.indexOf(KW) >= 0) {
                    var method = "?";
                    try { method = this.getMethod(); } catch (e) {}
                    var body = null;
                    try { body = readBody(this.getBody()); } catch (e) {}
                    send("REQ " + method + " " + url + "\nBODY: " + body);
                }
            } catch (e) {}
            return r;
        };
    }
    send("body logger v2 ready");
});
