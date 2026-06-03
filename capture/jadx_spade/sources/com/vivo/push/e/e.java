package com.vivo.push.e;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ IPushRequestCallback b;
    final /* synthetic */ d c;

    static {
        Covode.recordClassIndex(655030);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b("add profileId");
        d.a(this.c, this.a, this.b, 1);
    }

    e(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.c = dVar;
        this.a = str;
        this.b = iPushRequestCallback;
    }
}
