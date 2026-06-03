package com.vivo.push;

import com.bytedance.covode.number.Covode;
import com.vivo.push.m;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class r implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ m b;

    static {
        Covode.recordClassIndex(655102);
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a b;
        b = this.b.b(this.a);
        if (b != null) {
            b.a(1003, new Object[0]);
        }
    }

    r(m mVar, String str) {
        this.b = mVar;
        this.a = str;
    }
}
