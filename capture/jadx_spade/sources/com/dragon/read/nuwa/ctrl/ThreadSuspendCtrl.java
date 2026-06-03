package com.dragon.read.nuwa.ctrl;

import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ThreadSuspendCtrl {
    static {
        Covode.recordClassIndex(612612);
    }

    public static boolean enable() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 && i <= 34) {
            return true;
        }
        return false;
    }
}
