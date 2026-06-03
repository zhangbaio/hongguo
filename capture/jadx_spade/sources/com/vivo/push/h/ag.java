package com.vivo.push.h;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ag implements Runnable {
    final /* synthetic */ com.vivo.push.b.i a;
    final /* synthetic */ af b;

    static {
        Covode.recordClassIndex(655050);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).b;
        context = ((com.vivo.push.s) afVar).a;
        pushMessageCallback.onUnBind(context, this.a.j(), this.a.e());
    }

    ag(af afVar, com.vivo.push.b.i iVar) {
        this.b = afVar;
        this.a = iVar;
    }
}
