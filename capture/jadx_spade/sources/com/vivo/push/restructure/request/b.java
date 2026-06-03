package com.vivo.push.restructure.request;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {
    private a<I, O> a;
    private c<O> b;
    private long c;

    static {
        Covode.recordClassIndex(655141);
    }

    public final a a() {
        return this.a;
    }

    public final c b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    private b(a<I, O> aVar) {
        this.c = 5000L;
        this.a = aVar;
        if (aVar == null) {
            t.a(8100, "Command object is null, please construct command first");
        }
    }

    private b(a<I, O> aVar, c<O> cVar) {
        this(aVar);
        this.b = cVar;
    }

    public b(a<I, O> aVar, c<O> cVar, long j) {
        this(aVar, cVar);
        this.c = j;
    }
}
