package com.vivo.push.util;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class w {
    static {
        Covode.recordClassIndex(655208);
    }

    private static Object com_vivo_push_util_w_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    public static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i > 34) {
            if (!activity.isInMultiWindowMode() && !b(activity)) {
                return false;
            }
            return true;
        }
        if (i < 24) {
            return false;
        }
        return activity.isInMultiWindowMode();
    }

    private static boolean b(Activity activity) {
        Window window = activity.getWindow();
        try {
            Class<?> cls = window.getClass();
            Method method = null;
            if (cls.getSuperclass() != null) {
                for (Method method2 : cls.getSuperclass().getDeclaredMethods()) {
                    if (method2 != null && "getWindowControllerCallback".equals(method2.getName())) {
                        method = method2;
                    }
                }
            }
            if (method != null) {
                Object com_vivo_push_util_w_java_lang_reflect_Method_invoke = com_vivo_push_util_w_java_lang_reflect_Method_invoke(method, window, new Object[0]);
                if (com_vivo_push_util_w_java_lang_reflect_Method_invoke == null) {
                    return false;
                }
                for (Method method3 : com_vivo_push_util_w_java_lang_reflect_Method_invoke.getClass().getDeclaredMethods()) {
                    if (method3 != null && "isInVivoFreeformMode".equals(method3.getName())) {
                        method = method3;
                    }
                }
                return ((Boolean) com_vivo_push_util_w_java_lang_reflect_Method_invoke(method, com_vivo_push_util_w_java_lang_reflect_Method_invoke, new Object[0])).booleanValue();
            }
            t.a("MultiWindowUtils", "<isWindowModeFreeForm> registerActivityObserver not implement in IActivityManager");
            return false;
        } catch (Exception e) {
            t.a("MultiWindowUtils", "<isWindowModeFreeForm> registerActivityObserver-e = ", e);
            return false;
        }
    }
}
