package com.tencent.tinker.loader.utils;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class GUtils {
    public static final Class<?>[] EMPTY_CLASS_ARRAY;
    public static final Object[] EMPTY_OBJECT_ARRAY;

    private GUtils() {
    }

    static {
        Covode.recordClassIndex(653962);
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        if (clsArr != null && clsArr.length != 0) {
            return clsArr;
        }
        return EMPTY_CLASS_ARRAY;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            return objArr;
        }
        return EMPTY_OBJECT_ARRAY;
    }

    public static Class<?>[] toClass(Object... objArr) {
        Class<?> cls;
        if (objArr != null && objArr.length != 0) {
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj == null) {
                    cls = null;
                } else {
                    cls = obj.getClass();
                }
                clsArr[i] = cls;
            }
            return clsArr;
        }
        return EMPTY_CLASS_ARRAY;
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        if (objArr != null || objArr2 == null || objArr2.length <= 0) {
            if (objArr2 != null || objArr == null || objArr.length <= 0) {
                if (objArr != null && objArr2 != null && objArr.length != objArr2.length) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }
}
