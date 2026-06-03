package com.dragon.read.nuwa.ctrl;

import android.os.Build;
import com.bytedance.covode.number.Covode;
import com.dragon.read.nuwa.base.util.ReflectUtils;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class WeakRefOverFlowFixCtrl {
    static {
        Covode.recordClassIndex(612614);
    }

    public static boolean enable() {
        if (enableBrandAndOS() && enableMethodExists()) {
            return true;
        }
        return false;
    }

    private static boolean enableMethodExists() {
        Class cls;
        try {
            cls = a.q("android.view.RenderNode");
        } catch (Throwable th) {
            th.printStackTrace();
            cls = null;
        }
        if (ReflectUtils.getMethod(cls, "nCreate", new Class[]{String.class}) != null) {
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
