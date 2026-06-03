package com.ss.videoarch.strategy.utils;

import android.util.Log;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static boolean a;

    static {
        Covode.recordClassIndex(653229);
        a = false;
    }

    public static boolean a() {
        boolean z;
        synchronized (b.class) {
            z = a;
        }
        if (!z) {
            Log.e("VeLSUtils", "Load so failed");
        }
        return z;
    }

    public static void b(boolean z) {
        synchronized (b.class) {
            a = z;
        }
    }
}
