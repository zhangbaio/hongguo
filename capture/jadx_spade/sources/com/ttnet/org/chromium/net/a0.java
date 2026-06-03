package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.TTSocketAccelerate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class a0 implements TTSocketAccelerate.a {
    public static final com.ttnet.org.chromium.base.g<TTSocketAccelerate.a> a;

    class a implements com.ttnet.org.chromium.base.g<TTSocketAccelerate.a> {
        a() {
        }
    }

    a0() {
    }

    static {
        Covode.recordClassIndex(654538);
        a = new a();
    }

    public static TTSocketAccelerate.a c() {
        com.ttnet.org.chromium.base.j.a(false);
        return new a0();
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.a
    public void b(long j, TTSocketAccelerate tTSocketAccelerate, int i) {
        wj6.a.O(j, tTSocketAccelerate, i);
    }

    @Override // com.ttnet.org.chromium.net.TTSocketAccelerate.a
    public void a(long j, TTSocketAccelerate tTSocketAccelerate, int i, int i2) {
        wj6.a.P(j, tTSocketAccelerate, i, i2);
    }
}
