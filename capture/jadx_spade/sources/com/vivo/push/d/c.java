package com.vivo.push.d;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.vivo.push.IPushActionListener;
import com.vivo.push.util.v;
import com.vivo.push.util.w;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ IPushActionListener b;
    final /* synthetic */ b c;

    static {
        Covode.recordClassIndex(655014);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int a = b.a(this.a);
        if (a != 0) {
            this.b.onStateChanged(a);
            return;
        }
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new a(new g(v.a(), w.a(this.a))), new d(this), 3000L));
    }

    c(b bVar, Activity activity, IPushActionListener iPushActionListener) {
        this.c = bVar;
        this.a = activity;
        this.b = iPushActionListener;
    }
}
