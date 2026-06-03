package com.vivo.push.h;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class g implements Runnable {
    final /* synthetic */ UPSNotificationMessage a;
    final /* synthetic */ e b;

    static {
        Covode.recordClassIndex(655060);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        e eVar = this.b;
        PushMessageCallback pushMessageCallback = ((ab) eVar).b;
        context = ((com.vivo.push.s) eVar).a;
        pushMessageCallback.onNotificationMessageClicked(context, this.a);
    }

    g(e eVar, UPSNotificationMessage uPSNotificationMessage) {
        this.b = eVar;
        this.a = uPSNotificationMessage;
    }
}
