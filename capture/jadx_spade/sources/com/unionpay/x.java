package com.unionpay;

import com.bytedance.covode.number.Covode;
import com.unionpay.utils.UPUtils;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class x implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654929);
    }

    x(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // com.unionpay.f
    public final void a(String str, g gVar) {
        String l;
        String c = UPUtils.c(this.a, str);
        if (gVar != null) {
            l = UPPayWapActivity.l("0", "success", c);
            gVar.a(l);
        }
    }
}
