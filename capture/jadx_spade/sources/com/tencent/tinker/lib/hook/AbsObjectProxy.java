package com.tencent.tinker.lib.hook;

import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class AbsObjectProxy implements InvocationHandler {
    protected static HashMap<String, AbsMethodDelegate> sDelegateMethods;
    private static final Map<Class<?>, Class<?>> sPrimitiveTypes;
    private boolean mCalled;
    private Object mTarget;

    private static Object com_tencent_tinker_lib_hook_AbsObjectProxy_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    protected boolean isCatchInvokeThrowable(Method method) {
        return true;
    }

    protected Object getTarget() {
        return this.mTarget;
    }

    static {
        Covode.recordClassIndex(653744);
        sDelegateMethods = new HashMap<>();
        HashMap hashMap = new HashMap();
        sPrimitiveTypes = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        hashMap.put(Integer.class, Integer.TYPE);
        hashMap.put(Long.class, Long.TYPE);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(Float.class, Float.TYPE);
    }

    public void setTarget(Object obj) {
        this.mCalled = true;
        this.mTarget = obj;
    }

    protected AbsMethodDelegate findMethodDelegate(String str) {
        return sDelegateMethods.get(str);
    }

    private Object publishResult(Object obj, Method method) {
        if (obj != null) {
            return obj;
        }
        Class<?> returnType = method.getReturnType();
        if (!returnType.isPrimitive() && (returnType = sPrimitiveTypes.get(returnType)) == null) {
            return null;
        }
        if (returnType == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (returnType == Void.TYPE) {
            return new Object();
        }
        return 0;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        if (this.mCalled) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            AbsMethodDelegate findMethodDelegate = findMethodDelegate(method.getName());
            Object obj2 = null;
            if (findMethodDelegate != null) {
                try {
                    obj2 = findMethodDelegate.beforeInvoke(this.mTarget, method, objArr);
                } catch (Throwable th) {
                    MuteLog.e("Mute.AbsObjProxy", "<< %s  failed, %s", method.getName(), th);
                }
            }
            if (obj2 == null) {
                try {
                    obj2 = com_tencent_tinker_lib_hook_AbsObjectProxy_java_lang_reflect_Method_invoke(method, this.mTarget, objArr);
                } catch (Throwable th2) {
                    if (isCatchInvokeThrowable(method)) {
                        MuteLog.e("Mute.AbsObjProxy", "== %s  failed, %s", method.getName(), th2);
                    } else {
                        throw new RuntimeException(th2);
                    }
                }
            }
            if (findMethodDelegate != null) {
                try {
                    obj2 = findMethodDelegate.afterInvoke(this.mTarget, method, objArr, obj2);
                } catch (Throwable th3) {
                    MuteLog.e("Mute.AbsObjProxy", ">> %s  failed, %s", method.getName(), th3);
                }
            }
            return publishResult(obj2, method);
        }
        throw new IllegalStateException("setTarget must be invoked before this invoke");
    }
}
