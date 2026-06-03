package com.dragon.read.kmp.utils;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f0 {
    public static final f0 a;

    static {
        Covode.recordClassIndex(609551);
        a = new f0();
    }

    private f0() {
    }

    public final boolean a() {
        return b(l.a());
    }

    public final boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return NetworkUtils.isNetworkAvailable(context);
    }

    public final boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return NetworkUtils.isNetworkAvailableFast(context);
    }
}
