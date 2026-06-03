package com.tencent.tinker.lib.hook;

import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.hidden.q.DoubleReflector;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ActivityTaskManagerProxy extends AbsObjectProxy implements OnHookInstall {
    static {
        Covode.recordClassIndex(653755);
    }

    private static Object com_tencent_tinker_lib_hook_ActivityTaskManagerProxy_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    @Override // com.tencent.tinker.lib.hook.OnHookInstall
    public void onHookInstall() {
        if (!OSUtil.isAndroidQR()) {
            MuteLog.w("Mute.ActTaskMgrProxy", "onHookInstall no need hook!!", new Object[0]);
            return;
        }
        try {
            Object readStaticField = FieldUtils.readStaticField(DoubleReflector.getClass("android.app.ActivityTaskManager"), "IActivityTaskManagerSingleton");
            if (Class.forName("android.util.Singleton").isInstance(readStaticField)) {
                Object readField = FieldUtils.readField(readStaticField, "mInstance");
                if (readField == null) {
                    readField = com_tencent_tinker_lib_hook_ActivityTaskManagerProxy_java_lang_reflect_Method_invoke(MethodUtils.getAccessibleMethod(readStaticField.getClass(), "get", new Class[0]), readStaticField, new Object[0]);
                }
                if (readField != null) {
                    setTarget(readField);
                    FieldUtils.writeField(readStaticField, "mInstance", ProxyHelper.createProxy(readField, this));
                    AbsObjectProxy.sDelegateMethods.put("finishActivity", new FinishActivity());
                    AbsObjectProxy.sDelegateMethods.put("overridePendingTransition", new OverridePendingTransition("Mute.ActTaskMgrProxy"));
                    MuteLog.w("Mute.ActTaskMgrProxy", "onHookInstall hook success!!", new Object[0]);
                    return;
                }
                MuteLog.w("Mute.ActTaskMgrProxy", "onHookInstall hook failed!!", new Object[0]);
            }
        } catch (Throwable th) {
            MuteLog.e("Mute.ActTaskMgrProxy", "onHookInstall hook failed!!", th);
        }
    }

    @Override // com.tencent.tinker.lib.hook.AbsObjectProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        return super.invoke(obj, method, objArr);
    }
}
