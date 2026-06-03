package com.xiaomi.push;

import android.os.Looper;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class af {
    static {
        Covode.recordClassIndex(655336);
    }

    public static void a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        } else {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
