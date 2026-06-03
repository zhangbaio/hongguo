package com.vivo.push.h;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ com.vivo.push.b.i b;
    final /* synthetic */ h c;

    static {
        Covode.recordClassIndex(655062);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.a)) {
            h hVar = this.c;
            PushMessageCallback pushMessageCallback = ((ab) hVar).b;
            context2 = ((com.vivo.push.s) hVar).a;
            pushMessageCallback.onReceiveRegId(context2, this.a);
        }
        h hVar2 = this.c;
        PushMessageCallback pushMessageCallback2 = ((ab) hVar2).b;
        context = ((com.vivo.push.s) hVar2).a;
        pushMessageCallback2.onBind(context, this.b.j(), this.b.e());
    }

    i(h hVar, String str, com.vivo.push.b.i iVar) {
        this.c = hVar;
        this.a = str;
        this.b = iVar;
    }
}
