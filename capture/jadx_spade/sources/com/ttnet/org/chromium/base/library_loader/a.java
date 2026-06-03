package com.ttnet.org.chromium.base.library_loader;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class a extends Linker {
    a() {
    }

    static {
        Covode.recordClassIndex(654353);
    }

    public static void a(long j) {
        com.ttnet.org.chromium.base.metrics.a.d("ChromiumAndroidLinker.ModernLinkerDlopenExtTime", j);
    }

    public static void b(long j) {
        com.ttnet.org.chromium.base.metrics.a.d("ChromiumAndroidLinker.ModernLinkerIteratePhdrTime", j);
    }
}
