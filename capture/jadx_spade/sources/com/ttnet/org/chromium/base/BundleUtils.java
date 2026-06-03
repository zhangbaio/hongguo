package com.ttnet.org.chromium.base;

import android.content.Context;
import android.os.Build;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BundleUtils {
    private static Boolean a;
    private static final Object b;
    private static final SimpleArrayMap<String, ClassLoader> c;
    private static final Map<String, ClassLoader> d;

    public static Context a(Context context, String str) {
        return context;
    }

    public static String getNativeLibraryPath(String str, String str2) {
        return "";
    }

    public static boolean isBundleForNative() {
        return b();
    }

    public static boolean b() {
        if (!xj6.a.d) {
            return false;
        }
        return a.booleanValue();
    }

    static {
        Covode.recordClassIndex(654158);
        b = new Object();
        c = new SimpleArrayMap<>();
        d = Collections.synchronizedMap(new ArrayMap());
    }

    public static boolean c(Context context, String str) {
        String[] b2;
        if (Build.VERSION.SDK_INT < 26 || (b2 = vj6.c.b(context.getApplicationInfo())) == null || !Arrays.asList(b2).contains(str)) {
            return false;
        }
        return true;
    }
}
