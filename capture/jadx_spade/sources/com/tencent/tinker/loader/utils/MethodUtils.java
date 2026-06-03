package com.tencent.tinker.loader.utils;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MethodUtils {
    private static Map<String, Method> sMethodCache;
    private static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap;

    static {
        Covode.recordClassIndex(653964);
        sMethodCache = new HashMap();
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        sPrimitiveToWrapperMap = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Void.TYPE, Void.class);
    }

    public static int getParameterTypeIndex(Method method, Class<?> cls) {
        Class<?>[] parameterTypes;
        if (method != null && cls != null && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length > 0) {
            for (int i = 0; i < parameterTypes.length; i++) {
                if (TextUtils.equals(cls.getName(), parameterTypes[i].getName())) {
                    return i;
                }
            }
            return -1;
        }
        return -1;
    }

    private static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = sPrimitiveToWrapperMap.get(cls2);
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = sPrimitiveToWrapperMap.get(cls);
        }
        return cls2.isAssignableFrom(cls);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = GUtils.nullToEmpty(objArr);
        return invokeMethod(obj, str, nullToEmpty, GUtils.toClass(nullToEmpty));
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = GUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, GUtils.nullToEmpty(GUtils.toClass(nullToEmpty)));
        if (accessibleMethod == null) {
            return null;
        }
        return accessibleMethod.invoke(null, nullToEmpty);
    }

    private static String getMethodKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString());
                sb.append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method[] declaredMethods;
        Preconditions.checkNotNull(cls, "The class must not be null");
        Preconditions.checkTrue(!TextUtils.isEmpty(str), "The method name must not be blank");
        String methodKey = getMethodKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(methodKey);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method == null && (declaredMethods = cls.getDeclaredMethods()) != null) {
                for (Method method2 : declaredMethods) {
                    if (method2 != null && TextUtils.equals(method2.getName(), str)) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                            boolean z = true;
                            for (int i = 0; i < clsArr.length; i++) {
                                if (!isAssignableFrom(clsArr[i], parameterTypes[i])) {
                                    z = false;
                                }
                            }
                            if (z) {
                                method = method2;
                            }
                        }
                    }
                }
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(methodKey, method);
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] nullToEmpty = GUtils.nullToEmpty(clsArr);
        Object[] nullToEmpty2 = GUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, nullToEmpty);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, nullToEmpty2);
        }
        return null;
    }
}
