package com.ttnet.org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JNIUtils {
    private static Boolean a;
    private static ClassLoader b;

    static {
        Covode.recordClassIndex(654213);
    }

    private static ClassLoader a() {
        ClassLoader classLoader = b;
        if (classLoader == null) {
            return JNIUtils.class.getClassLoader();
        }
        return classLoader;
    }

    public static boolean isSelectiveJniRegistrationEnabled() {
        if (a == null) {
            a = Boolean.FALSE;
        }
        return a.booleanValue();
    }

    public static ClassLoader getSplitClassLoader(String str) {
        Context f = c.f();
        if (!TextUtils.isEmpty(str) && BundleUtils.c(f, str)) {
            return BundleUtils.a(f, str).getClassLoader();
        }
        return a();
    }
}
