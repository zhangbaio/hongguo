package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.util.ah;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class aa implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ z b;

    static {
        Covode.recordClassIndex(654978);
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        Context b = com.vivo.push.restructure.a.a().b();
        if (b == null) {
            return;
        }
        if (m.a().f()) {
            j = 506;
        } else {
            j = 356;
        }
        if (!TextUtils.isEmpty(this.a) && ah.a(b, b.getPackageName(), this.a, j)) {
            com.vivo.push.restructure.a.a().e().e();
            this.b.d = "";
        }
    }

    aa(z zVar, String str) {
        this.b = zVar;
        this.a = str;
    }
}
