package com.zhihu.matisse.internal.entity;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.internal.ui.widget.IncapableDialog;
import fm6.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class IncapableCause {
    private int a = 0;
    private String b;
    private String c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Form {
    }

    static {
        Covode.recordClassIndex(656119);
    }

    public IncapableCause(String str) {
        this.c = str;
    }

    public static void a(Context context, IncapableCause incapableCause, d dVar) {
        if (incapableCause == null) {
            return;
        }
        int i = incapableCause.a;
        if (i != 1) {
            if (i != 2) {
                if (dVar != null) {
                    dVar.b(incapableCause.c);
                    return;
                } else {
                    l3.a.B(context, incapableCause.c, 0).show();
                    return;
                }
            }
            return;
        }
        IncapableDialog.wf(incapableCause.b, incapableCause.c).show(((FragmentActivity) context).getSupportFragmentManager(), IncapableDialog.class.getName());
    }
}
