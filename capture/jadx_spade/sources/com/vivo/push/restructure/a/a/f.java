package com.vivo.push.restructure.a.a;

import com.bytedance.covode.number.Covode;
import com.vivo.push.PushClient;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ e c;

    static {
        Covode.recordClassIndex(655111);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        if (i == 3) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).unBindAlias(this.b, null);
        } else if (i == 4) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).delTopic(this.b, null);
        }
    }

    f(e eVar, int i, String str) {
        this.c = eVar;
        this.a = i;
        this.b = str;
    }
}
