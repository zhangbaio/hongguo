package com.unionpay.utils;

import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j {
    private static int a;

    static {
        Covode.recordClassIndex(654940);
        a = Integer.MAX_VALUE;
    }

    private static int a(int i, String str, String str2) {
        if (str != null && str2 != null) {
            if (i == 2) {
                return Log.v(str, str2);
            }
            if (i == 3) {
                return Log.d(str, str2);
            }
            if (i == 4) {
                return Log.i(str, str2);
            }
            if (i == 5) {
                return Log.w(str, str2);
            }
            if (i == 6) {
                return Log.e(str, str2);
            }
        }
        return 0;
    }

    public static int b(String str, String str2) {
        if (a > 3) {
            return 0;
        }
        a(3, str, str2);
        return 0;
    }

    public static int c(String str, String str2) {
        if (a > 4) {
            return 0;
        }
        a(4, str, str2);
        return 0;
    }

    public static int d(String str, String str2) {
        if (a <= 6) {
            return a(6, str, str2);
        }
        return 0;
    }
}
