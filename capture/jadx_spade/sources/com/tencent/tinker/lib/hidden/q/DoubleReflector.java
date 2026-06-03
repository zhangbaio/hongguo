package com.tencent.tinker.lib.hidden.q;

import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.hidden.p.HackHelper;
import com.tencent.tinker.lib.utils.Preconditions;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DoubleReflector {
    private static Method mForNameMethod;
    private static Method mGetDeclaredConstructorMethod;
    private static Method mGetDeclaredFieldMethod;
    private static Method mGetDeclaredMethod;

    private static Object com_tencent_tinker_lib_hidden_q_DoubleReflector_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    static {
        Covode.recordClassIndex(653742);
        try {
            mGetDeclaredFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            mGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            mGetDeclaredConstructorMethod = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            mForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            MuteLog.e("Mute.DoubleReflector", "init failed!! %s", th);
        }
    }

    public static Class<?> getClass(String str) {
        Preconditions.checkNotNull(str, "The class name can not be null !!!");
        Method method = mForNameMethod;
        Class<?> cls = null;
        if (method != null) {
            try {
                cls = (Class) com_tencent_tinker_lib_hidden_q_DoubleReflector_java_lang_reflect_Method_invoke(method, null, new Object[]{str});
            } catch (Throwable unused) {
                MuteLog.w("Mute.DoubleReflector", "getClass %s failed !!!", str);
            }
        }
        if (cls == null) {
            return HackHelper.getClass(str);
        }
        return cls;
    }

    public static Field getFieldAll(Class<?> cls, String str) {
        Preconditions.checkNotNull(cls, "The class must not be null !!!");
        while (cls != null) {
            try {
                return (Field) com_tencent_tinker_lib_hidden_q_DoubleReflector_java_lang_reflect_Method_invoke(mGetDeclaredFieldMethod, cls, new Object[]{str});
            } catch (Throwable unused) {
                cls = cls.getSuperclass();
            }
        }
        return HackHelper.getField(cls, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Constructor getConstructor(java.lang.Class<?> r3, java.lang.Class<?>... r4) {
        /*
            java.lang.String r0 = "The class must not be null !!!"
            com.tencent.tinker.lib.utils.Preconditions.checkNotNull(r3, r0)
            java.lang.reflect.Method r0 = com.tencent.tinker.lib.hidden.q.DoubleReflector.mGetDeclaredConstructorMethod
            if (r0 == 0) goto L1f
            r1 = 1
            r2 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L16
            r1[r2] = r4     // Catch: java.lang.Throwable -> L16
            java.lang.Object r0 = com_tencent_tinker_lib_hidden_q_DoubleReflector_java_lang_reflect_Method_invoke(r0, r3, r1)     // Catch: java.lang.Throwable -> L16
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0     // Catch: java.lang.Throwable -> L16
            goto L20
        L16:
            java.lang.String r0 = "getConstructor %s<init>%s failed !!!"
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r2 = "Mute.DoubleReflector"
            com.tencent.tinker.lib.MuteLog.w(r2, r0, r1)
        L1f:
            r0 = 0
        L20:
            if (r0 == 0) goto L23
            goto L27
        L23:
            java.lang.reflect.Constructor r0 = com.tencent.tinker.lib.hidden.p.HackHelper.getConstructor(r3, r4)
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hidden.q.DoubleReflector.getConstructor(java.lang.Class, java.lang.Class[]):java.lang.reflect.Constructor");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Field getField(java.lang.Class<?> r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "The class must not be null !!!"
            com.tencent.tinker.lib.utils.Preconditions.checkNotNull(r4, r0)
            java.lang.reflect.Method r0 = com.tencent.tinker.lib.hidden.q.DoubleReflector.mGetDeclaredFieldMethod
            if (r0 == 0) goto L28
            r1 = 0
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L16
            r3[r1] = r5     // Catch: java.lang.Throwable -> L16
            java.lang.Object r0 = com_tencent_tinker_lib_hidden_q_DoubleReflector_java_lang_reflect_Method_invoke(r0, r4, r3)     // Catch: java.lang.Throwable -> L16
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch: java.lang.Throwable -> L16
            goto L29
        L16:
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = r4.getName()
            r0[r1] = r3
            r0[r2] = r5
            java.lang.String r1 = "Mute.DoubleReflector"
            java.lang.String r2 = "getField %s#%s failed !!!"
            com.tencent.tinker.lib.MuteLog.w(r1, r2, r0)
        L28:
            r0 = 0
        L29:
            if (r0 == 0) goto L2c
            goto L30
        L2c:
            java.lang.reflect.Field r0 = com.tencent.tinker.lib.hidden.p.HackHelper.getField(r4, r5)
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hidden.q.DoubleReflector.getField(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Method getMethod(java.lang.Class<?> r5, java.lang.String r6, java.lang.Class<?>... r7) {
        /*
            java.lang.String r0 = "The class must not be null !!!"
            com.tencent.tinker.lib.utils.Preconditions.checkNotNull(r5, r0)
            java.lang.reflect.Method r0 = com.tencent.tinker.lib.hidden.q.DoubleReflector.mGetDeclaredMethod
            if (r0 == 0) goto L2a
            r1 = 1
            r2 = 0
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L19
            r4[r2] = r6     // Catch: java.lang.Throwable -> L19
            r4[r1] = r7     // Catch: java.lang.Throwable -> L19
            java.lang.Object r0 = com_tencent_tinker_lib_hidden_q_DoubleReflector_java_lang_reflect_Method_invoke(r0, r5, r4)     // Catch: java.lang.Throwable -> L19
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: java.lang.Throwable -> L19
            goto L2b
        L19:
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r3 = r5.getName()
            r0[r2] = r3
            r0[r1] = r6
            java.lang.String r1 = "Mute.DoubleReflector"
            java.lang.String r2 = "getMethod %s#%s failed !!!"
            com.tencent.tinker.lib.MuteLog.w(r1, r2, r0)
        L2a:
            r0 = 0
        L2b:
            if (r0 == 0) goto L2e
            goto L32
        L2e:
            java.lang.reflect.Method r0 = com.tencent.tinker.lib.hidden.p.HackHelper.getMethod(r5, r6, r7)
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.hidden.q.DoubleReflector.getMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
