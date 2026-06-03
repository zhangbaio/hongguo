package com.dragon.read.nuwa.ctrl;

import android.graphics.ColorFilter;
import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.dragon.read.nuwa.base.util.ReflectUtils;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ColorFilterFixCtrl {
    static {
        Covode.recordClassIndex(612601);
    }

    public static boolean enable() {
        if (enableBrandAndOS() && enableMethodExit()) {
            return true;
        }
        return false;
    }

    private static boolean enableMethodExit() {
        if (ReflectUtils.getMethod(ColorFilter.class, "destroyFilter", new Class[]{Long.TYPE}) != null) {
            return true;
        }
        return false;
    }

    private static boolean enableBrandAndOS() {
        int i = Build.VERSION.SDK_INT;
        if (i == 24 || i == 25) {
            String str = Build.MANUFACTURER;
            if ("oppo".equalsIgnoreCase(str) || "vivo".equalsIgnoreCase(str) || "xiaomi".equalsIgnoreCase(str) || "huawei".equalsIgnoreCase(str) || "honor".equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
