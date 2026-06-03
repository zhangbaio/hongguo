package com.vivo.push.e;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class h implements Runnable {
    final /* synthetic */ IPushRequestCallback a;
    final /* synthetic */ d b;

    static {
        Covode.recordClassIndex(655033);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b("query all profileIds");
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            t.b("core not support sync profileInfo");
            IPushRequestCallback iPushRequestCallback = this.a;
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context b = com.vivo.push.restructure.a.a().b();
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.e.a.a(new com.vivo.push.e.a.b(b.getPackageName(), new ArrayList(), 4)), new i(this), 20000L));
    }

    h(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.b = dVar;
        this.a = iPushRequestCallback;
    }
}
