// hook JNIEnv 函数表里的 RegisterNatives(索引215/偏移0x6B8),最可靠(不管 CheckJNI)
// 用法: frida -U -f com.phoenix.read -l hook_registernatives.js
'use strict';
Java.perform(function () {
    var env = Java.vm.getEnv();
    var table = env.handle.readPointer();          // JNINativeInterface*
    var reg = table.add(215 * Process.pointerSize).readPointer(); // RegisterNatives
    console.log("[*] hook JNIEnv->RegisterNatives @ " + reg);
    var total = 0;
    Interceptor.attach(reg, {
        onEnter: function (args) {
            total++;
            var methods = args[2], count = args[3].toInt32();
            var meta = Process.findModuleByName("libmetasec_ml.so");
            var fn0 = methods.add(Process.pointerSize * 2).readPointer();
            var m0 = Process.findModuleByAddress(fn0);
            var isMeta = meta && !fn0.isNull() && fn0.compare(meta.base) >= 0 && fn0.compare(meta.base.add(meta.size)) < 0;
            if (isMeta) {
                console.log("=== [METASEC] RegisterNatives count=" + count + " ===");
                for (var i = 0; i < count; i++) {
                    var p = methods.add(i * Process.pointerSize * 3);
                    var nm = p.readPointer().readCString();
                    var sg = p.add(Process.pointerSize).readPointer().readCString();
                    var fn = p.add(Process.pointerSize * 2).readPointer();
                    console.log("    " + nm + " " + sg + "  -> libmetasec_ml.so+0x" + fn.sub(meta.base).toString(16));
                }
            } else {
                console.log("[regn #" + total + "] count=" + count + " lib=" + (m0 ? m0.name : fn0));
            }
        }
    });
});
