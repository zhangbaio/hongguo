package com.vivo.push.sdk;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.ab;
import com.vivo.push.m;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b implements Runnable {
    final /* synthetic */ com.vivo.push.restructure.a.a a;
    final /* synthetic */ a b;

    static {
        Covode.recordClassIndex(655152);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        com.vivo.push.restructure.a a = com.vivo.push.restructure.a.a();
        context = ((ab) this.b).a;
        a.a(context);
        t.d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.a.j())));
        m a2 = m.a();
        context2 = ((ab) this.b).a;
        a2.a(context2);
        com.vivo.push.restructure.a.a().d().a(this.a);
    }

    b(a aVar, com.vivo.push.restructure.a.b bVar) {
        this.b = aVar;
        this.a = bVar;
    }
}
