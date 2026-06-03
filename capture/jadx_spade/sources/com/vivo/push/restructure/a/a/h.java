package com.vivo.push.restructure.a.a;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class h extends a<com.vivo.push.restructure.a.a> {
    static {
        Covode.recordClassIndex(655113);
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        Context b = com.vivo.push.restructure.a.a().b();
        com.vivo.push.m.a().a(b);
        t.d("InitNode", "PushMessageReceiver " + b.getPackageName() + " ; requestId = " + aVar.c());
        return 0;
    }

    public h(com.vivo.push.restructure.a.a aVar, j jVar) {
        super("InitNode", aVar, jVar);
    }
}
