// 列出当前进程所有 native 模块,高亮签名/安全相关
function dump() {
    var mods = Process.enumerateModules();
    send("共 " + mods.length + " 个模块");
    var kw = ['sec', 'sign', 'argus', 'ladon', 'cms', 'crypt', 'cronet',
              'ttnet', 'mssdk', 'metasec', 'encrypt', 'sscronet', 'np', 'gorgon'];
    var hits = [];
    mods.forEach(function (m) {
        var n = m.name.toLowerCase();
        for (var i = 0; i < kw.length; i++) {
            if (n.indexOf(kw[i]) >= 0) { hits.push(m.name + "  @" + m.base + "  " + m.path); break; }
        }
    });
    send("=== 安全/签名相关模块 ===");
    hits.forEach(function (h) { send("  " + h); });
    send("=== 全部模块名 ===");
    send(mods.map(function (m) { return m.name; }).join(", "));
}
dump();
