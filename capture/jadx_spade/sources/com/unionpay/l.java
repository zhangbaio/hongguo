package com.unionpay;

import android.view.View;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class l implements View.OnClickListener {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654873);
    }

    l(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ClickAgent.onClick(view);
        this.a.finish();
    }
}
