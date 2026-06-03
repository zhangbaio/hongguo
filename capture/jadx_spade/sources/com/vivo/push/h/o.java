package com.vivo.push.h;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o extends ab {
    static {
        Covode.recordClassIndex(655068);
    }

    o(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.l lVar = (com.vivo.push.b.l) vVar;
        int e = lVar.e();
        int f = lVar.f();
        com.vivo.push.util.ad.c().a("key_dispatch_environment", e);
        com.vivo.push.util.ad.c().a("key_dispatch_area", f);
        com.vivo.push.util.t.d("OnDispatcherReceiveTask", "environment  and area=" + e + "  ; " + f);
    }
}
