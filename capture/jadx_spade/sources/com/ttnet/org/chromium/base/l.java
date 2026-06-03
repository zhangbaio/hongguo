package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l {
    static {
        Covode.recordClassIndex(654239);
    }

    private static String b(Class<?> cls) {
        if (cls == null) {
            return "null";
        }
        if (cls.isArray()) {
            return cls.getCanonicalName();
        }
        if (cls.isPrimitive()) {
            return cls.getName();
        }
        return cls.getCanonicalName();
    }

    private static Class<?> d(Class<?> cls) {
        if (cls != null && cls.isPrimitive()) {
            String name = cls.getName();
            if (!name.equals("double")) {
                if (!name.equals("int")) {
                    if (!name.equals("byte")) {
                        if (!name.equals("char")) {
                            if (!name.equals("long")) {
                                if (!name.equals("void")) {
                                    if (!name.equals("boolean")) {
                                        if (!name.equals("float")) {
                                            if (!name.equals("short")) {
                                                return cls;
                                            }
                                            return Short.class;
                                        }
                                        return Float.class;
                                    }
                                    return Boolean.class;
                                }
                                return Void.class;
                            }
                            return Long.class;
                        }
                        return Character.class;
                    }
                    return Byte.class;
                }
                return Integer.class;
            }
            return Double.class;
        }
        return cls;
    }

    private static boolean c(Class<?> cls, Object obj) {
        if (obj == null) {
            return !cls.isPrimitive();
        }
        return d(cls).isAssignableFrom(d(obj.getClass()));
    }

    public static void a(Class<?>[] clsArr, Object... objArr) {
        String b;
        Objects.requireNonNull(clsArr, "parameterType should not be null");
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (clsArr.length == objArr.length) {
            for (int i = 0; i < clsArr.length; i++) {
                Class<?> cls = clsArr[i];
                Object obj = objArr[i];
                if (!c(cls, obj)) {
                    String b2 = b(cls);
                    if (obj == null) {
                        b = "null";
                    } else {
                        b = b(obj.getClass());
                    }
                    throw new IllegalArgumentException(String.format("The param %d type mismatch: expected %s, actual %s", Integer.valueOf(i + 1), b2, b));
                }
            }
            return;
        }
        throw new IllegalArgumentException(String.format("param count mismatch: expected %d, actual %d", Integer.valueOf(clsArr.length), Integer.valueOf(objArr.length)));
    }
}
