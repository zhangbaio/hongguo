package com.vivo.push;

import com.bytedance.covode.number.Covode;
import com.vivo.push.listener.IPushQueryActionListener;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b implements Runnable {
    final /* synthetic */ IPushQueryActionListener a;
    final /* synthetic */ a b;

    static {
        Covode.recordClassIndex(654981);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String b = com.vivo.push.restructure.a.a().h().b();
        IPushQueryActionListener iPushQueryActionListener = this.a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(b);
        }
    }

    b(a aVar, IPushQueryActionListener iPushQueryActionListener) {
        this.b = aVar;
        this.a = iPushQueryActionListener;
    }
}
