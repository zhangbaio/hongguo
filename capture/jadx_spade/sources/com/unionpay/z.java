package com.unionpay;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class z implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654945);
    }

    z(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // com.unionpay.f
    public final void a(String str, g gVar) {
        String l;
        UPPayWapActivity.i(this.a, Boolean.parseBoolean(str));
        if (gVar != null) {
            l = UPPayWapActivity.l("0", "success", null);
            gVar.a(l);
        }
    }
}
