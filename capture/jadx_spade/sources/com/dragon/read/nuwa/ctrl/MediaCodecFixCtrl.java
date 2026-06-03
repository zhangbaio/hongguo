package com.dragon.read.nuwa.ctrl;

import android.os.Build;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MediaCodecFixCtrl {
    static {
        Covode.recordClassIndex(612608);
    }

    public static boolean enable() {
        if (Build.VERSION.SDK_INT == 29) {
            String str = Build.MANUFACTURER;
            if ("honor".equalsIgnoreCase(str) || "huawei".equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
