package com.vivo.push;

import com.bytedance.covode.number.Covode;
import com.vivo.push.m;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class n implements IPushActionListener {
    final /* synthetic */ m.a a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ m d;

    static {
        Covode.recordClassIndex(655098);
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        if (i == 0) {
            Object[] b = this.a.b();
            if (b != null && b.length != 0) {
                com.vivo.push.restructure.a.a().h().a((String) this.a.b()[0], this.b, this.c);
                return;
            } else {
                com.vivo.push.util.t.a("PushClientManager", "bind app result is null");
                return;
            }
        }
        com.vivo.push.restructure.a.a().h().a("");
    }

    n(m mVar, m.a aVar, String str, String str2) {
        this.d = mVar;
        this.a = aVar;
        this.b = str;
        this.c = str2;
    }
}
