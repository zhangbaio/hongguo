package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.EarlyTraceEvent;
import com.ttnet.org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
class d implements EarlyTraceEvent.c {
    public static final g<EarlyTraceEvent.c> a;

    class a implements g<EarlyTraceEvent.c> {
        a() {
        }
    }

    d() {
    }

    static {
        Covode.recordClassIndex(654191);
        a = new a();
    }

    public static EarlyTraceEvent.c g() {
        j.a(true);
        return new d();
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void c(String str, long j, long j2) {
        wj6.a.b(str, j, j2);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void e(String str, long j, long j2) {
        wj6.a.a(str, j, j2);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void a(String str, long j, int i, long j2) {
        wj6.a.c(str, j, i, j2);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void b(String str, long j, int i, long j2) {
        wj6.a.d(str, j, i, j2);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void d(String str, long j, int i, long j2) {
        wj6.a.f(str, j, i, j2);
    }

    @Override // com.ttnet.org.chromium.base.EarlyTraceEvent.c
    public void f(String str, long j, int i, long j2) {
        wj6.a.e(str, j, i, j2);
    }
}
