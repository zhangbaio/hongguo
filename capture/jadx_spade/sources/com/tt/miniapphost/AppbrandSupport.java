package com.tt.miniapphost;

import android.os.Bundle;
import com.bytedance.bdp.bdpbase.core.AbsBdpAppStatusListener;
import com.bytedance.bdp.bdpbase.core.BdpAppStatusListener;
import com.bytedance.bdp.bdpbase.core.BdpStartUpParam;
import com.bytedance.bdp.bdpbase.helper.BdpClassLoadHelper;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class AppbrandSupport {
    private static volatile AppbrandSupport instance;
    private volatile boolean isInit = false;

    private static Object com_tt_miniapphost_AppbrandSupport_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    public void setIsInit() {
        this.isInit = true;
    }

    public boolean isInit() {
        return this.isInit;
    }

    private AppbrandSupport() {
    }

    static {
        Covode.recordClassIndex(654118);
        instance = null;
    }

    public static AppbrandSupport inst() {
        if (instance == null) {
            synchronized (AppbrandSupport.class) {
                if (instance == null) {
                    instance = new AppbrandSupport();
                }
            }
        }
        return instance;
    }

    public boolean openAppbrand(String str) {
        return openAppbrand(str, null);
    }

    class a extends AbsBdpAppStatusListener {
        final /* synthetic */ boolean[] a;

        a(boolean[] zArr) {
            this.a = zArr;
        }

        public void onLaunchFinish(int i, String str, Bundle bundle) {
            if (i != 0) {
                this.a[0] = true;
            }
        }
    }

    public boolean openAppbrand(String str, Bundle bundle) {
        return reflectBdpOpen(str, bundle);
    }

    private boolean reflectBdpOpen(String str, Bundle bundle) {
        try {
            BdpStartUpParam bdpStartUpParam = new BdpStartUpParam();
            bdpStartUpParam.setExtras(bundle);
            Class loadClass = BdpClassLoadHelper.INSTANCE.loadClass("bdp_platform", "com.bytedance.bdp.bdpplatform.Bdp");
            com_tt_miniapphost_AppbrandSupport_java_lang_reflect_Method_invoke(loadClass.getMethod("open", String.class, BdpStartUpParam.class, BdpAppStatusListener.class), loadClass.getMethod("getInst", new Class[0]).invoke(null, new Object[0]), new Object[]{str, bdpStartUpParam, new a(new boolean[]{false})});
            return !r3[0];
        } catch (Exception e) {
            boolean z = e instanceof InvocationTargetException;
            return false;
        }
    }
}
