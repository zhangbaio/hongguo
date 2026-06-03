package com.tt.android.qualitystat;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.config.StatConfig;
import sj6.c;
import tj6.f;
import tj6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    public static final a a;

    private a() {
    }

    static {
        Covode.recordClassIndex(654021);
        a = new a();
    }

    public static final void d(sj6.a aVar) {
        UserStatAgent.g.j(c.i(aVar));
    }

    public static final void e(sj6.a aVar) {
        UserStatAgent.g.k(c.i(aVar));
    }

    public static final void c(StatConfig statConfig, Context context) {
        UserStatAgent.g.i(statConfig, context);
    }

    public static final void f(sj6.a aVar, f fVar) {
        UserStatAgent.g.l(c.i(aVar), new g(fVar));
    }

    public static final void b(sj6.a aVar, f fVar) {
        UserStatAgent.b(UserStatAgent.g, c.i(aVar), new g(fVar).F(), 0, 4, null);
    }

    public static final void a(sj6.a aVar, boolean z, f fVar) {
        UserStatAgent.b(UserStatAgent.g, c.i(aVar), new g(fVar).t(z), 0, 4, null);
    }
}
