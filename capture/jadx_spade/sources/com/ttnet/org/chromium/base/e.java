package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.JavaExceptionReporter;
import com.ttnet.org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
class e implements JavaExceptionReporter.a {
    public static final g<JavaExceptionReporter.a> a;

    class a implements g<JavaExceptionReporter.a> {
        a() {
        }
    }

    e() {
    }

    static {
        Covode.recordClassIndex(654216);
        a = new a();
    }

    public static JavaExceptionReporter.a b() {
        j.a(true);
        return new e();
    }

    @Override // com.ttnet.org.chromium.base.JavaExceptionReporter.a
    public void a(boolean z, Throwable th) {
        wj6.a.g(z, th);
    }
}
