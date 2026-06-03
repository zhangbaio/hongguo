package com.unionpay.utils;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(654936);
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
