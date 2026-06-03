package com.vivo.push.e;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class g implements Runnable {
    final /* synthetic */ IPushRequestCallback a;
    final /* synthetic */ d b;

    static {
        Covode.recordClassIndex(655032);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b("delete all profileIds");
        d.a(this.b, "", this.a, 3);
    }

    g(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.b = dVar;
        this.a = iPushRequestCallback;
    }
}
