package com.vivo.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class p implements IPushActionListener {
    final /* synthetic */ m a;

    static {
        Covode.recordClassIndex(655100);
    }

    p(m mVar) {
        this.a = mVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        if (i == 0) {
            com.vivo.push.restructure.a.a().h().b("");
        } else {
            com.vivo.push.restructure.a.a().h().c("");
        }
    }
}
