package com.dragon.read.nuwa.ctrl;

import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EglBadAllocCtrl {
    static {
        Covode.recordClassIndex(612603);
    }

    public static boolean enable() {
        int i;
        String str = Build.MANUFACTURER;
        if (("xiaomi".equalsIgnoreCase(str) || "oppo".equalsIgnoreCase(str) || "vivo".equalsIgnoreCase(str)) && (i = Build.VERSION.SDK_INT) >= 28 && i <= 31) {
            return true;
        }
        return false;
    }
}
