// 找 metasec 签名生成方法
Java.perform(function () {
    var targets = [];
    Java.enumerateLoadedClasses({
        onMatch: function (name) {
            var l = name.toLowerCase();
            if (l.indexOf("metasec") >= 0 || l.indexOf("mssdk") >= 0 ||
                name.indexOf("com.bytedance.frameworks.baselib.network.http.NetworkParams") >= 0) {
                // 只要顶层类(不含$内部类太多),或明确的Manager
                if (name.indexOf("$") < 0 || name.indexOf("Manager") >= 0)
                    targets.push(name);
            }
        },
        onComplete: function () {
            send("=== metasec/NetworkParams 类: " + targets.length + " ===");
            targets.forEach(function (cn) {
                try {
                    var C = Java.use(cn);
                    var methods = C.class.getDeclaredMethods();
                    var sigs = [];
                    for (var i = 0; i < methods.length; i++) {
                        var m = methods[i];
                        var ps = m.getParameterTypes();
                        var pn = [];
                        for (var j = 0; j < ps.length; j++) pn.push(ps[j].getName());
                        sigs.push("    " + m.getReturnType().getName() + " " + m.getName() + "(" + pn.join(", ") + ")");
                    }
                    // 只打印有返回Map/String[]/含url参数的方法(可能是签名生成)
                    var interesting = sigs.filter(function (s) {
                        return /Map|String\[\]|byte\[\]|getReport|getRequest|Header|sign|Sign|encrypt/.test(s);
                    });
                    if (interesting.length) {
                        send("【" + cn + "】");
                        interesting.forEach(function (s) { send(s); });
                    }
                } catch (e) {}
            });
            send("=== done ===");
        }
    });
});
