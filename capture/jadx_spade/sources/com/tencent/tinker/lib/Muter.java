package com.tencent.tinker.lib;

import android.app.Application;
import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.bytedance.hotupgrade.api.IAppLike;
import com.bytedance.hotupgrade.api.ILogger;
import com.bytedance.hotupgrade.api.IReporter;
import com.tencent.tinker.lib.hook.HookManager;
import com.tencent.tinker.lib.utils.MethodUtils;
import com.tencent.tinker.lib.utils.Utils;
import java.lang.reflect.Proxy;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Muter {
    private static Application sApp;
    private static IAppLike sAppLike;
    private static volatile boolean sInited;
    private static IReporter sReporter;
    private static cf0.a sSettings;

    public static IAppLike getAppLike() {
        return sAppLike;
    }

    public static IReporter getReporter() {
        return sReporter;
    }

    public static cf0.a getSettings() {
        return sSettings;
    }

    public static boolean isInited() {
        return sInited;
    }

    public static Context getAppContext() {
        Application application = sApp;
        if (application == null) {
            return MuteMaxLoader.sBaseCtx;
        }
        return application;
    }

    public static String getMuteDesc() {
        return MuteMaxLoader.getMuteDesc();
    }

    public static void installNeedHook() {
        HookManager.getInstance().installAMHook();
    }

    public static boolean isInstallReady() {
        return MuteInstaller.isInstallReady();
    }

    public static boolean isPatchEnv() {
        return MuteMaxLoader.isPatchEnv();
    }

    static {
        Covode.recordClassIndex(653713);
        sInited = false;
    }

    public static int getHostUpVerCode() {
        int i = MuteMaxLoader.sHostVerCode;
        if (i <= 0) {
            return Utils.getUpdateVersionCode(getAppContext());
        }
        return i;
    }

    public static void setHookAnim(boolean z) {
        MuteSP.setHookAnim(z);
    }

    public static void init(Application application, IAppLike iAppLike, IReporter iReporter, ILogger iLogger, cf0.a aVar) {
        if (sInited) {
            MuteLog.w("Mute.Init", "already inited", new Object[0]);
            return;
        }
        if (aVar != null) {
            sApp = application;
            sAppLike = iAppLike;
            sReporter = iReporter;
            sSettings = aVar;
            Thread.setDefaultUncaughtExceptionHandler(new MuteExpHandler());
            MuteLog.setImp(iLogger);
            try {
                Class<?> cls = Class.forName("com.tencent.tinker.loader.utils.ShareTinkerLog", false, MuteMaxLoader.getOriginCL());
                MethodUtils.invokeStaticMethod(cls, "setTinkerLogImp", Proxy.newProxyInstance(MuteMaxLoader.getOriginCL(), MethodUtils.invokeStaticMethod(cls, "getDefaultImpl", new Object[0]).getClass().getInterfaces(), new MuteLogProxy(iLogger)));
            } catch (Exception e) {
                MuteLog.e("Mute.Init", "setLogIml failed", e);
            }
            MuteLog.i("Mute.Init", "init success[^_^]", new Object[0]);
            sInited = true;
            return;
        }
        MuteLog.e("Mute.Init", "mute settings can not null", new Object[0]);
        throw new RuntimeException("mute settings can not null");
    }
}
