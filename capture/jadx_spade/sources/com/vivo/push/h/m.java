package com.vivo.push.h;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class m implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ String d;
    final /* synthetic */ l e;

    static {
        Covode.recordClassIndex(655066);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.e;
        PushMessageCallback pushMessageCallback = ((ab) lVar).b;
        context = ((com.vivo.push.s) lVar).a;
        pushMessageCallback.onDelTags(context, this.a, this.b, this.c, this.d);
    }

    m(l lVar, int i, List list, List list2, String str) {
        this.e = lVar;
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = str;
    }
}
