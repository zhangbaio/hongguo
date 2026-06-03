package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
class u implements TraceEvent.e {
    public static final g<TraceEvent.e> a;

    class a implements g<TraceEvent.e> {
        a() {
        }
    }

    u() {
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public void d() {
        wj6.a.t();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public boolean b() {
        return wj6.a.w();
    }

    static {
        Covode.recordClassIndex(654283);
        a = new a();
    }

    public static TraceEvent.e j() {
        j.a(true);
        return new u();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public void a(String str) {
        wj6.a.s(str);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public void c(String str) {
        wj6.a.q(str);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public void e(String str, String str2) {
        wj6.a.p(str, str2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public void f(String str, String str2) {
        wj6.a.r(str, str2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public void h(String str, String str2) {
        wj6.a.u(str, str2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public long i(String str, long j) {
        return wj6.a.v(str, j);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.e
    public void g(int i, int i2, boolean z, boolean z2, String str, String str2, long j) {
        wj6.a.o(i, i2, z, z2, str, str2, j);
    }
}
