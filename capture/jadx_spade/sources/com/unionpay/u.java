package com.unionpay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class u implements DialogInterface.OnClickListener {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654882);
    }

    u(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.c;
        alertDialog.dismiss();
    }
}
