package com.vivo.push.e;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ IPushRequestCallback b;
    final /* synthetic */ d c;

    static {
        Covode.recordClassIndex(655031);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b("delete profileId");
        d.a(this.c, this.a, this.b, 2);
    }

    f(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.c = dVar;
        this.a = str;
        this.b = iPushRequestCallback;
    }
}
