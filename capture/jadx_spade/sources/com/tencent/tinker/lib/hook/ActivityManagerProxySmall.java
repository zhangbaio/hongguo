package com.tencent.tinker.lib.hook;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.utils.FieldUtils;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.OSUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ActivityManagerProxySmall extends AbsObjectProxy implements OnHookInstall {
    static {
        Covode.recordClassIndex(653754);
    }

    @Override // com.tencent.tinker.lib.hook.OnHookInstall
    public void onHookInstall() {
        Object readStaticField;
        if (!OSUtil.isAndroidPLow()) {
            MuteLog.w("Mute.ActMgrProxy", "onHookInstall no need hook!!", new Object[0]);
            return;
        }
        try {
            if (OSUtil.isAndroidNOHigher()) {
                readStaticField = FieldUtils.readStaticField(Class.forName("android.app.ActivityManager"), "IActivityManagerSingleton");
            } else {
                readStaticField = FieldUtils.readStaticField(Class.forName("android.app.ActivityManagerNative"), "gDefault");
            }
            if (Class.forName("android.util.Singleton").isInstance(readStaticField)) {
                Object readField = FieldUtils.readField(readStaticField, "mInstance");
                if (readField == null) {
                    readField = MethodUtils.invokeMethod(readStaticField, "get", new Object[0]);
                }
                if (readField != null) {
                    setTarget(readField);
                    FieldUtils.writeField(readStaticField, "mInstance", ProxyHelper.createProxy(readField, this));
                    AbsObjectProxy.sDelegateMethods.put("finishActivity", new FinishActivity());
                    MuteLog.w("Mute.ActMgrProxy", "onHookInstall hook success!!", new Object[0]);
                    return;
                }
                MuteLog.w("Mute.ActMgrProxy", "onHookInstall hook failed!!", new Object[0]);
            }
        } catch (Exception e) {
            MuteLog.e("Mute.ActMgrProxy", "onHookInstall hook failed!!", e);
        }
    }

    @Override // com.tencent.tinker.lib.hook.AbsObjectProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        return super.invoke(obj, method, objArr);
    }
}
