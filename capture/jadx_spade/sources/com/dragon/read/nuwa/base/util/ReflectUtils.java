package com.dragon.read.nuwa.base.util;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReflectUtils {
    private static HashMap<String, Method> sCacheMethod;
    private static Method sGetDeclaredMethod;

    private static Object com_dragon_read_nuwa_base_util_ReflectUtils_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    private ReflectUtils() {
    }

    static {
        Covode.recordClassIndex(612598);
        sCacheMethod = new HashMap<>();
        sGetDeclaredMethod = null;
    }

    public static Method getClassMethod(Class cls, String str) {
        return getClassMethod(cls, str, null);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str) {
        return invokeStaticMethod(cls, str, null, null);
    }

    public static Object invokeStaticMethod(String str, String str2) {
        try {
            return invokeStaticMethod((Class<?>) a.q(str), str2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getFiledValue(Object obj, Class<?> cls) {
        if (obj != null && cls != null) {
            try {
                Field[] declaredFields = obj.getClass().getDeclaredFields();
                for (int i = 0; i < declaredFields.length; i++) {
                    declaredFields[i].setAccessible(true);
                    if (declaredFields[i].getType().getName().equals(cls.getName())) {
                        return declaredFields[i].get(obj);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Object invokeMethod(Class<?> cls, String str, Object... objArr) {
        return invokeMethod(cls, str, (Class<?>[]) null, (Object[]) null, objArr);
    }

    public static Object invokeVoidMethod(Class<?> cls, String str, Object obj) {
        return invokeMethod(cls, str, (Class<?>[]) null, (Object[]) null, obj);
    }

    public static Method getClassMethod(Class cls, String str, Class<?>... clsArr) {
        if (cls != null && str != null) {
            String str2 = cls.getName() + "." + str;
            if (sCacheMethod.containsKey(str2)) {
                return sCacheMethod.get(str2);
            }
            Method method = null;
            while (cls != null && cls != Object.class) {
                try {
                    Method method2 = sGetDeclaredMethod;
                    if (method2 != null) {
                        method = (Method) com_dragon_read_nuwa_base_util_ReflectUtils_java_lang_reflect_Method_invoke(method2, cls, new Object[]{str, clsArr});
                    } else {
                        method = cls.getDeclaredMethod(str, clsArr);
                    }
                    method.setAccessible(true);
                } catch (Throwable unused) {
                }
                if (method != null) {
                    sCacheMethod.put(str2, method);
                    return method;
                }
                cls = cls.getSuperclass();
            }
            sCacheMethod.put(str2, null);
        }
        return null;
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Log.d("ReflectUtils", "thread id : " + Thread.currentThread().getName());
            return cls.getMethod(str, clsArr);
        } catch (Throwable th) {
            Log.e("ReflectUtils", "exception in getMethod, pkg : " + cls.getName() + ", function : " + str + ", " + th.toString());
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            if (clsArr == null) {
                clsArr = new Class[0];
            }
            if (objArr == null) {
                objArr = new Object[0];
            }
            try {
                Method classMethod = getClassMethod(cls, str, clsArr);
                if (classMethod == null) {
                    return null;
                }
                classMethod.setAccessible(true);
                return com_dragon_read_nuwa_base_util_ReflectUtils_java_lang_reflect_Method_invoke(classMethod, null, objArr);
            } catch (Throwable th) {
                Log.e("ReflectUtils", "exception in invokeMethod, pkg : " + cls.getName() + ", function : " + str + ", " + th.toString());
            }
        }
        return null;
    }

    public static Object invokeMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr, Object obj) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            if (clsArr == null) {
                clsArr = new Class[0];
            }
            if (objArr == null) {
                objArr = new Object[0];
            }
            try {
                Method classMethod = getClassMethod(cls, str, clsArr);
                if (classMethod == null) {
                    return null;
                }
                classMethod.setAccessible(true);
                return com_dragon_read_nuwa_base_util_ReflectUtils_java_lang_reflect_Method_invoke(classMethod, obj, objArr);
            } catch (Throwable th) {
                Log.e("ReflectUtils", "invokeMethod failed, class : " + cls.getName() + ", function : " + str + ", " + th.toString());
            }
        }
        return null;
    }

    public static Object invokeMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr, Object... objArr2) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            if (clsArr == null) {
                clsArr = new Class[0];
            }
            if (objArr == null) {
                objArr = new Object[0];
            }
            try {
                Method method = getMethod(cls, str, clsArr);
                if (method == null) {
                    return null;
                }
                method.setAccessible(true);
                if (objArr2 != null && objArr2.length > 0) {
                    return com_dragon_read_nuwa_base_util_ReflectUtils_java_lang_reflect_Method_invoke(method, objArr2[0], objArr);
                }
                return com_dragon_read_nuwa_base_util_ReflectUtils_java_lang_reflect_Method_invoke(method, null, objArr);
            } catch (Throwable th) {
                Log.e("ReflectUtils", "exception in invokeMethod, pkg : " + cls.getName() + ", function : " + str + ", " + th.toString());
            }
        }
        return null;
    }
}
