package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.JavaHandlerThread;
import com.ttnet.org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
class f implements JavaHandlerThread.d {
    public static final g<JavaHandlerThread.d> a;

    class a implements g<JavaHandlerThread.d> {
        a() {
        }
    }

    f() {
    }

    static {
        Covode.recordClassIndex(654219);
        a = new a();
    }

    public static JavaHandlerThread.d c() {
        j.a(true);
        return new f();
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.d
    public void a(long j) {
        wj6.a.i(j);
    }

    @Override // com.ttnet.org.chromium.base.JavaHandlerThread.d
    public void b(long j, long j2) {
        wj6.a.h(j, j2);
    }
}
