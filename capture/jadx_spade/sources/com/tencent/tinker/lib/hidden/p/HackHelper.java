package com.tencent.tinker.lib.hidden.p;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class HackHelper {
    private static Map<String, Class> sClassCache;
    private static Map<String, Constructor> sConstructorCache;
    private static Map<String, Field> sFieldCache;
    private static Map<String, Method> sMethodCache;

    static {
        Covode.recordClassIndex(653740);
        sFieldCache = new HashMap();
        sMethodCache = new HashMap();
        sConstructorCache = new HashMap();
        sClassCache = new HashMap();
        try {
            FieldUtils.writeField(HackHelperImpl.class, "classLoader", (Object) null);
            MuteLog.w("Mute.HackHelper", "HackHelperImpl use BootClassLoader", new Object[0]);
        } catch (Exception e) {
            MuteLog.e("Mute.HackHelper", "init failed!! %s", e);
        }
    }

    public static Class<?> getClass(String str) {
        Class<?> cls;
        Preconditions.checkNotNull(str, "The class name can not be null !!!");
        synchronized (sClassCache) {
            cls = sClassCache.get(str);
        }
        if (cls != null) {
            return cls;
        }
        try {
            Class<?> cls2 = HackHelperImpl.getClass(str);
            if (cls2 != null) {
                synchronized (sClassCache) {
                    sClassCache.put(str, cls2);
                }
            }
            return cls2;
        } catch (Throwable unused) {
            MuteLog.w("Mute.HackHelper", "getClass %s failed !!!", str);
            return null;
        }
    }

    private static String getFieldKey(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    public static Constructor getConstructor(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        Preconditions.checkNotNull(cls, "The class must not be null !!!");
        String methodKey = getMethodKey(cls, "clinit", clsArr);
        synchronized (sConstructorCache) {
            constructor = sConstructorCache.get(methodKey);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructor2 = HackHelperImpl.getConstructor(cls, clsArr);
            if (constructor2 != null) {
                synchronized (sConstructorCache) {
                    sConstructorCache.put(methodKey, constructor2);
                }
            }
            return constructor2;
        } catch (Throwable unused) {
            MuteLog.w("Mute.HackHelper", "getConstructor %s failed !!!", cls.getName());
            return null;
        }
    }

    public static Field getField(Class<?> cls, String str) {
        Field field;
        Preconditions.checkNotNull(cls, "The class must not be null !!!");
        Preconditions.checkTrue(!TextUtils.isEmpty(str), "The field name must not be blank !!!");
        String fieldKey = getFieldKey(cls, str);
        synchronized (sFieldCache) {
            field = sFieldCache.get(fieldKey);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field field2 = HackHelperImpl.getField(cls, str);
            if (field2 != null) {
                synchronized (sFieldCache) {
                    sFieldCache.put(fieldKey, field2);
                }
            }
            return field2;
        } catch (Throwable unused) {
            MuteLog.w("Mute.HackHelper", "getField %s#%s failed !!!", cls.getName(), str);
            return null;
        }
    }

    private static String getMethodKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        } else {
            sb.append(Void.class.getName());
        }
        return sb.toString();
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Preconditions.checkNotNull(cls, "The class must not be null !!!");
        Preconditions.checkTrue(!TextUtils.isEmpty(str), "The method name must not be blank !!!");
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
        try {
            Method method2 = HackHelperImpl.getMethod(cls, str, clsArr);
            if (method2 != null) {
                synchronized (sMethodCache) {
                    sMethodCache.put(methodKey, method2);
                }
            }
            return method2;
        } catch (Throwable unused) {
            MuteLog.w("Mute.HackHelper", "getMethod %s#%s failed !!!", cls.getName(), str);
            return null;
        }
    }
}
