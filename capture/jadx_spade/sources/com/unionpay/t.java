package com.unionpay;

import android.content.DialogInterface;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class t implements DialogInterface.OnClickListener {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654881);
    }

    t(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.j("cancel", null);
    }
}
