package com.ttnet.org.chromium.base;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(654134);
    }

    private static int b(Context context, String str, int i, int i2) {
        Result preInvoke = new HeliosApiHook().preInvoke(102607, "android/content/Context", "checkPermission", context, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}, "int", new ExtraInfo(false, "(Ljava/lang/String;II)I", "auto_cert_com_ttnet_org_chromium_base_ApiCompatibilityUtils_android_content_Context_checkPermission"));
        return preInvoke.isIntercept() ? ((Integer) preInvoke.getReturnValue()).intValue() : context.checkPermission(str, i, i2);
    }

    public static int a(Context context, String str, int i, int i2) {
        try {
            return b(context, str, i, i2);
        } catch (RuntimeException unused) {
            return -1;
        }
    }
}
