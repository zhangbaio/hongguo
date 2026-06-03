package com.vivo.push.restructure.a.a;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class g extends a<com.vivo.push.restructure.a.a> {
    private long b;

    static {
        Covode.recordClassIndex(655112);
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final synchronized String b() {
        a(this.b);
        return super.b();
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return 0;
    }

    public g(com.vivo.push.restructure.a.a aVar, j jVar) {
        super("IPCNode", aVar, jVar);
        this.b = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long d = aVar.d();
        if (d > 0 && elapsedRealtime > d) {
            this.b = elapsedRealtime - d;
        }
    }
}
