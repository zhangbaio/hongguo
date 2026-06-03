package com.vivo.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class q implements Runnable {
    final /* synthetic */ com.vivo.push.b.b a;
    final /* synthetic */ String b;
    final /* synthetic */ m c;

    static {
        Covode.recordClassIndex(655101);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a);
        this.c.c(this.b);
    }

    q(m mVar, com.vivo.push.b.b bVar, String str) {
        this.c = mVar;
        this.a = bVar;
        this.b = str;
    }
}
