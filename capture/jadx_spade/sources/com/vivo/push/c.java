package com.vivo.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c implements Runnable {
    final /* synthetic */ IPushActionListener a;
    final /* synthetic */ a b;

    static {
        Covode.recordClassIndex(655008);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int a = com.vivo.push.restructure.a.a().h().a();
        IPushActionListener iPushActionListener = this.a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(a);
        }
    }

    c(a aVar, IPushActionListener iPushActionListener) {
        this.b = aVar;
        this.a = iPushActionListener;
    }
}
