package com.tt.android.qualitystat.duration;

import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.base.d;
import com.tt.android.qualitystat.constants.SystemScene;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.StringsKt__StringsKt;
import tj6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static final AtomicInteger a;
    public static final a b;

    private a() {
    }

    private final long e() {
        return System.currentTimeMillis();
    }

    static {
        Covode.recordClassIndex(654085);
        b = new a();
        a = new AtomicInteger(1);
    }

    public final void c(sj6.b bVar) {
        b(this, EventType.CONTINUE, bVar, 0L, null, 0, 28, null);
    }

    public final void g(sj6.b bVar) {
        b(this, EventType.PAUSE, bVar, 0L, null, 0, 28, null);
    }

    public final void f(sj6.b bVar, g gVar) {
        b(this, EventType.PARAM, bVar, gVar.k, gVar, 0, 16, null);
    }

    public final void h(sj6.b bVar, g gVar) {
        b(this, EventType.PAUSE, sj6.c.i(SystemScene.Event), gVar.k, null, 0, 24, null);
        b(this, EventType.START, bVar, gVar.k, gVar, 0, 16, null);
    }

    public final void d(sj6.b bVar, g gVar, int i) {
        d.c.g(null);
        a(EventType.END, bVar, gVar.k, gVar, i);
        b(this, EventType.CONTINUE, sj6.c.i(SystemScene.Event), gVar.k, null, 0, 24, null);
    }

    private final void a(EventType eventType, sj6.b bVar, long j, g gVar, int i) {
        String str;
        boolean z;
        if (eventType != EventType.PARAM) {
            if (gVar != null) {
                str = gVar.q;
            } else {
                str = null;
            }
            if (str != null && !StringsKt__StringsKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z && gVar != null) {
                gVar.E(eventType.name());
            }
        }
        TimeEventManager.b.j(new c(eventType, bVar, gVar, a.getAndIncrement(), EventStatus.Init, j, i));
    }

    static /* synthetic */ void b(a aVar, EventType eventType, sj6.b bVar, long j, g gVar, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = aVar.e();
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            gVar = null;
        }
        g gVar2 = gVar;
        if ((i2 & 16) != 0) {
            i = com.tt.android.qualitystat.config.c.b.b(bVar).z();
        }
        aVar.a(eventType, bVar, j2, gVar2, i);
    }
}
