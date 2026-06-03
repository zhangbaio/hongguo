package com.ss.ttm.utils;

import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.Method;
import l3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InitConfig {
    static ConfigFactory gFactory;
    private static volatile boolean mHasTriedGetMethod;
    static Method sMethodCreate;
    private boolean committed = false;
    private ConfigAPI mNative;

    private static Object com_ss_ttm_utils_InitConfig_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    void commit() {
        this.committed = true;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    static {
        Covode.recordClassIndex(652234);
        sMethodCreate = null;
        gFactory = null;
        mHasTriedGetMethod = false;
    }

    public long nativeHandle() {
        ConfigAPI configAPI = this.mNative;
        if (configAPI == null) {
            return 0L;
        }
        return configAPI.nativeHandle();
    }

    public void release() {
        ConfigAPI configAPI = this.mNative;
        this.mNative = null;
        if (configAPI != null) {
            configAPI.release();
        }
    }

    public static void setFactory(ConfigFactory configFactory) {
        gFactory = configFactory;
    }

    public int getIntValue(int i, int i2) {
        ConfigAPI configAPI = this.mNative;
        if (configAPI != null) {
            return configAPI.getIntValue(i, i2);
        }
        return i2;
    }

    public void setIntValue(int i, int i2) {
        ConfigAPI configAPI = this.mNative;
        if (configAPI != null && !this.committed) {
            configAPI.setIntValue(i, i2);
        }
    }

    InitConfig(long j, int i) {
        this.mNative = null;
        ConfigFactory configFactory = gFactory;
        if (configFactory != null) {
            this.mNative = configFactory.createConfig(j, i);
            return;
        }
        if (!mHasTriedGetMethod) {
            synchronized (InitConfig.class) {
                if (!mHasTriedGetMethod) {
                    mHasTriedGetMethod = true;
                    try {
                        sMethodCreate = a.q("com.ss.ttm.utils.ConfigImpl").getDeclaredMethod("create", Long.TYPE, Integer.TYPE);
                    } catch (Exception unused) {
                        sMethodCreate = null;
                    }
                }
            }
        }
        Method method = sMethodCreate;
        if (method == null) {
            return;
        }
        try {
            method.setAccessible(true);
            this.mNative = (ConfigAPI) com_ss_ttm_utils_InitConfig_java_lang_reflect_Method_invoke(sMethodCreate, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        } catch (Exception unused2) {
        }
    }
}
