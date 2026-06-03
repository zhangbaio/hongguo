package com.dragon.read.nuwa.ctrl;

import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class GetPortFormatCtrl {
    static {
        Covode.recordClassIndex(612607);
    }

    public static boolean enable() {
        int i = Build.VERSION.SDK_INT;
        if (i > 23 && i < 29) {
            String str = Build.MANUFACTURER;
            if ("honor".equalsIgnoreCase(str) || "huawei".equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
