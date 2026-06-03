package com.tencent.tinker.lib.hook;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class HookManager {
    private static volatile HookManager sInstance;
    private ArrayList<Class> mClasses = new ArrayList<>();

    static {
        Covode.recordClassIndex(653759);
    }

    private HookManager() {
    }

    public static HookManager getInstance() {
        if (sInstance == null) {
            synchronized (HookManager.class) {
                if (sInstance == null) {
                    sInstance = new HookManager();
                }
            }
        }
        return sInstance;
    }

    public void installAMHook() {
        try {
            installSync(new ActivityClientControllerProxy());
            installSync(new ActivityTaskManagerProxy());
            installSync(new ActivityManagerProxySmall());
        } catch (Throwable th) {
            MuteLog.e("Mute.HookMgr", "Mute.HookMgr installNeedHook failed.", th);
        }
    }

    public void installNeedHook() {
        try {
            installSync(new MuteInstrumentation());
            installSync(new PackageManagerProxy());
            installSync(new ActivityManagerProxy());
            installSync(new ActivityTaskManagerProxy());
            installSync(new ActivityClientControllerProxy());
            installSync(new MuteHandlerCallback());
        } catch (Throwable th) {
            MuteLog.e("Mute.HookMgr", "installNeedHook failed. %s", th);
        }
    }

    public void installSync(OnHookInstall onHookInstall) {
        synchronized (this.mClasses) {
            if (!this.mClasses.contains(onHookInstall.getClass())) {
                onHookInstall.onHookInstall();
                this.mClasses.add(onHookInstall.getClass());
            }
        }
    }
}
