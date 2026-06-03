package com.vivo.push.restructure.request;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ e b;

    static {
        Covode.recordClassIndex(655146);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.a;
        if (bVar != null && bVar.b() != null) {
            this.a.b().a(1003);
        }
    }

    f(e eVar, b bVar) {
        this.b = eVar;
        this.a = bVar;
    }
}
