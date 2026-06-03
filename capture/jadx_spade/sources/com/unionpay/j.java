package com.unionpay;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j implements Runnable {
    static {
        Covode.recordClassIndex(654869);
    }

    j() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        zj6.d dVar;
        Context G;
        try {
            dVar = a.V;
            G = a.G();
            new zj6.c(dVar, com.unionpay.utils.b.d(G)).b();
        } catch (Exception unused) {
        }
    }
}
