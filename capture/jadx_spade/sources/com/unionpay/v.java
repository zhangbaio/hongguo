package com.unionpay;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class v implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654883);
    }

    v(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // com.unionpay.f
    public final void a(String str, g gVar) {
        String l;
        String c = a.c(this.a);
        if (gVar != null) {
            l = UPPayWapActivity.l("0", "success", c);
            gVar.a(l);
        }
    }
}
