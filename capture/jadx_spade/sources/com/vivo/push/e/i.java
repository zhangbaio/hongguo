package com.vivo.push.e;

import com.bytedance.covode.number.Covode;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i implements com.vivo.push.restructure.request.c<com.vivo.push.e.a.b> {
    final /* synthetic */ h a;

    static {
        Covode.recordClassIndex(655034);
    }

    i(h hVar) {
        this.a = hVar;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i) {
        if (this.a.a != null) {
            t.b("query err : ".concat(String.valueOf(i)));
            this.a.a.onError(i);
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.e.a.b bVar) {
        com.vivo.push.e.a.b bVar2 = bVar;
        if (this.a.a != null) {
            t.b("query success");
            this.a.a.onSuccess(bVar2.a());
        }
    }
}
