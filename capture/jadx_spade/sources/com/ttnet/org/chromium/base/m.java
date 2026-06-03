package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.PowerMonitor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class m implements PowerMonitor.c {
    public static final g<PowerMonitor.c> a;

    class a implements g<PowerMonitor.c> {
        a() {
        }
    }

    m() {
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.c
    public void a() {
        wj6.a.l();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.c
    public void b() {
        wj6.a.j();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.c
    public void c() {
        wj6.a.k();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.c
    public void d() {
        wj6.a.n();
    }

    @Override // com.ttnet.org.chromium.base.PowerMonitor.c
    public void onResume() {
        wj6.a.m();
    }

    static {
        Covode.recordClassIndex(654249);
        a = new a();
    }

    public static PowerMonitor.c e() {
        j.a(false);
        return new m();
    }
}
