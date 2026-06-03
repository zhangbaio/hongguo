package com.vivo.push.e;

import com.bytedance.covode.number.Covode;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j implements com.vivo.push.restructure.request.c<com.vivo.push.e.a.b> {
    final /* synthetic */ IPushRequestCallback a;
    final /* synthetic */ int b;
    final /* synthetic */ d c;

    static {
        Covode.recordClassIndex(655035);
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i) {
        if (this.a != null) {
            t.b(this.b + " sync err : " + i);
            this.a.onError(i);
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.e.a.b bVar) {
        if (this.a != null) {
            t.b(this.b + " sync success");
            this.a.onSuccess(0);
        }
    }

    j(d dVar, IPushRequestCallback iPushRequestCallback, int i) {
        this.c = dVar;
        this.a = iPushRequestCallback;
        this.b = i;
    }
}
