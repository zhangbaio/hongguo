package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Utils {
    private static Object sGson;
    private static boolean sGsonNotFound;

    static {
        Covode.recordClassIndex(652767);
    }

    private Utils() {
    }

    public static String toString(Object obj) {
        String json = toJson(obj);
        if (!TextUtils.isEmpty(json)) {
            return json;
        }
        return String.valueOf(obj);
    }

    public static String toJson(Object obj) {
        if (obj == null || sGsonNotFound) {
            return null;
        }
        if (sGson == null) {
            try {
                sGson = l3.a.q("com.google.gson.Gson").newInstance();
                sGsonNotFound = false;
            } catch (Throwable unused) {
                sGsonNotFound = true;
            }
        }
        Object obj2 = sGson;
        if (obj2 != null) {
            try {
                Object invoke = obj2.getClass().getDeclaredMethod("toJson", Object.class).invoke(sGson, obj);
                if (invoke instanceof String) {
                    return String.valueOf(invoke);
                }
            } catch (Throwable unused2) {
            }
        }
        return null;
    }
}
