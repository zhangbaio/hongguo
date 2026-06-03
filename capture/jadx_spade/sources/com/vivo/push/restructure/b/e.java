package com.vivo.push.restructure.b;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ah;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ PushConfig b;
    final /* synthetic */ d c;

    static {
        Covode.recordClassIndex(655126);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.a;
        ah.a(context, context.getPackageName(), this.b.isAgreePrivacyStatement());
    }

    e(d dVar, Context context, PushConfig pushConfig) {
        this.c = dVar;
        this.a = context;
        this.b = pushConfig;
    }
}
