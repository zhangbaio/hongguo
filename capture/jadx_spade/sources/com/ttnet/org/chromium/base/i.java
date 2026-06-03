package com.ttnet.org.chromium.base;

import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class i {
    static int a;

    static {
        Covode.recordClassIndex(654228);
        a = 4;
    }

    public static boolean b() {
        if (a <= 3) {
            return true;
        }
        return false;
    }

    public static void c(int i) {
        a = i;
    }

    public static void a(String str, String str2) {
        if (str2 != null && a <= 3) {
            Log.d(str, str2);
        }
    }
}
