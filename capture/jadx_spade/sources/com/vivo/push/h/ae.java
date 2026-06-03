package com.vivo.push.h;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ae implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ ac e;

    static {
        Covode.recordClassIndex(655048);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ac acVar = this.e;
        PushMessageCallback pushMessageCallback = ((ab) acVar).b;
        context = ((com.vivo.push.s) acVar).a;
        pushMessageCallback.onSetAlias(context, this.a, this.b, this.c, this.d);
    }

    ae(ac acVar, int i, List list, List list2, String str) {
        this.e = acVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }
}
