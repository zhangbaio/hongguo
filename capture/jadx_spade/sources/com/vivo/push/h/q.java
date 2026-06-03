package com.vivo.push.h;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class q implements Runnable {
    final /* synthetic */ com.vivo.push.b.m a;
    final /* synthetic */ p b;

    static {
        Covode.recordClassIndex(655070);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.b;
        PushMessageCallback pushMessageCallback = ((ab) pVar).b;
        context = ((com.vivo.push.s) pVar).a;
        pushMessageCallback.onListTags(context, this.a.j(), this.a.e(), this.a.i());
    }

    q(p pVar, com.vivo.push.b.m mVar) {
        this.b = pVar;
        this.a = mVar;
    }
}
