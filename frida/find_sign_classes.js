// 枚举签名/安全相关的 Java 类
Java.perform(function () {
    var kw = ['metasec', 'argus', 'gorgon', 'ladon', 'NetworkParams', 'SecurityFactor',
              'CronetDepend', 'ttnet', 'security', 'Encryptor', 'sign'];
    var hits = [];
    Java.enumerateLoadedClasses({
        onMatch: function (name) {
            var l = name.toLowerCase();
            for (var i = 0; i < kw.length; i++) {
                if (l.indexOf(kw[i].toLowerCase()) >= 0) { hits.push(name); break; }
            }
        },
        onComplete: function () {
            send("=== 命中 " + hits.length + " 个类 ===");
            hits.forEach(function (h) { send("  " + h); });
        }
    });
});
