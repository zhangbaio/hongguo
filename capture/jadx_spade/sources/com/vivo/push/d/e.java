package com.vivo.push.d;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.vivo.push.IPushActionListener;
import com.vivo.push.util.v;
import com.vivo.push.util.w;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ IPushActionListener b;
    final /* synthetic */ long c;
    final /* synthetic */ b d;

    static {
        Covode.recordClassIndex(655016);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int a = b.a(this.a);
        if (a != 0) {
            this.b.onStateChanged(a);
            return;
        }
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new a(new g(this.c, v.a(), w.a(this.a))), new f(this), 3000L));
    }

    e(b bVar, Activity activity, IPushActionListener iPushActionListener, long j) {
        this.d = bVar;
        this.a = activity;
        this.b = iPushActionListener;
        this.c = j;
    }
}
