package com.dragon.read.nuwa.base.util;

import android.os.Build;
import com.bytedance.covode.number.Covode;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DoubleReflectHelper {
    static {
        Covode.recordClassIndex(612595);
    }

    private DoubleReflectHelper() {
    }

    public static boolean isAndroidPHigher() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28 && (i != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
            return false;
        }
        return true;
    }

    public static Field getField(Class<?> cls, String str) {
        if (isAndroidPHigher()) {
            try {
                return getFieldInner(cls, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return FieldUtils.getField(cls, str);
    }

    public static Object readField(Object obj, String str) {
        try {
            return getField(obj.getClass(), str).get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field getFieldInner(Class<?> cls, String str) {
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(cls, str);
            field.setAccessible(true);
            return field;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Method getMethodInner(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(cls, str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
