package com.unionpay;

import com.bytedance.covode.number.Covode;
import com.unionpay.utils.UPUtils;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class y implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654944);
    }

    y(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // com.unionpay.f
    public final void a(String str, g gVar) {
        String l;
        UPUtils.j(this.a, str);
        if (gVar != null) {
            l = UPPayWapActivity.l("0", "success", null);
            gVar.a(l);
        }
    }
}
