// hook libart RegisterNatives,dump metasec 惰性注册的 native 方法 + 在 libmetasec_ml.so 的偏移
// 用法: frida -U -f com.phoenix.read -l hook_registernatives.js  (spawn,让 app 自然触发注册)
'use strict';
function attach() {
    // art::JNI::RegisterNatives(JNIEnv*, jclass, const JNINativeMethod*, jint)
    var sym = null;
    var arts = Process.findModuleByName("libart.so");
    if (arts) {
        var ex = arts.enumerateSymbols().filter(function (s) {
            return s.name.indexOf("RegisterNatives") >= 0 && s.name.indexOf("CheckJNI") < 0;
        });
        if (ex.length) sym = ex[0].address;
    }
    if (!sym) { console.log("[!] RegisterNatives 符号未找到"); return; }
    console.log("[*] hook RegisterNatives @ " + sym);

    Interceptor.attach(sym, {
        onEnter: function (args) {
            var klass = args[1];
            var methods = args[2];
            var count = args[3].toInt32();
            // 取类名:env->GetObjectClass/Class.getName 太重;直接用 jclass 的 mirror 读 art 类名较繁,
            // 改为:只要该批里有 fnPtr 落在 libmetasec_ml.so,就整批打印
            var meta = Process.findModuleByName("libmetasec_ml.so");
            if (!meta) return;
            var hit = false, lines = [];
            for (var i = 0; i < count; i++) {
                var p = methods.add(i * Process.pointerSize * 3); // {name*, sig*, fn*} arm64 每项24B
                var namePtr = p.readPointer();
                var sigPtr = p.add(Process.pointerSize).readPointer();
                var fnPtr = p.add(Process.pointerSize * 2).readPointer();
                var name = namePtr.isNull() ? "?" : namePtr.readCString();
                var sig = sigPtr.isNull() ? "?" : sigPtr.readCString();
                var off = "";
                if (!fnPtr.isNull() && fnPtr.compare(meta.base) >= 0 && fnPtr.compare(meta.base.add(meta.size)) < 0) {
                    off = "libmetasec_ml.so+0x" + fnPtr.sub(meta.base).toString(16);
                    hit = true;
                } else {
                    var m = Process.findModuleByAddress(fnPtr);
                    off = m ? (m.name + "+0x" + fnPtr.sub(m.base).toString(16)) : fnPtr.toString();
                }
                lines.push("    " + name + " " + sig + "  -> " + off);
            }
            if (hit) {
                console.log("=== RegisterNatives count=" + count + " (含 metasec native) ===");
                lines.forEach(function (l) { console.log(l); });
            }
        }
    });
}
setTimeout(attach, 0);
