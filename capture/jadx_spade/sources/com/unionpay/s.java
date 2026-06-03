package com.unionpay;

import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class s implements View.OnClickListener {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654880);
    }

    s(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ClickAgent.onClick(view);
        UPPayWapActivity.q(this.a);
    }
}
