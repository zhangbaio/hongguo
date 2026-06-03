package com.tencent.tinker.lib;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.bytedance.hotupgrade.api.IAppLike;
import com.tencent.tinker.lib.utils.IntentUtil;
import com.tencent.tinker.lib.utils.ProcessUtil;
import com.tencent.tinker.lib.utils.ShareReflectUtil;
import com.tencent.tinker.lib.utils.ShareTinkerInternals;
import com.tencent.tinker.lib.utils.Utils;
import java.lang.Thread;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteExpHandler implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler mUncaughtExpHandler = Thread.getDefaultUncaughtExceptionHandler();

    static {
        Covode.recordClassIndex(653700);
    }

    public static void cleanPatch(IAppLike iAppLike) {
        if (iAppLike != null && iAppLike.getHostApp() != null) {
            ShareTinkerInternals.cleanPatch(iAppLike.getHostApp());
            return;
        }
        throw new RuntimeException("MuteApplication is null");
    }

    public static String getCurrentVersion(IAppLike iAppLike) {
        if (iAppLike != null && iAppLike.getHostApp() != null) {
            Intent muteLoadResult = iAppLike.getMuteLoadResult();
            if (muteLoadResult == null) {
                return null;
            }
            String stringExtra = IntentUtil.getStringExtra(muteLoadResult, "intent_patch_old_version");
            String stringExtra2 = IntentUtil.getStringExtra(muteLoadResult, "intent_patch_new_version");
            boolean isMainProcess = ProcessUtil.isMainProcess(iAppLike.getHostApp());
            if (stringExtra == null || stringExtra2 == null) {
                return null;
            }
            if (isMainProcess) {
                return stringExtra2;
            }
            return stringExtra;
        }
        throw new RuntimeException("MuteApplication is null");
    }

    public static boolean isTinkerLoadSuccess(IAppLike iAppLike) {
        if (iAppLike != null && iAppLike.getHostApp() != null) {
            Intent muteLoadResult = iAppLike.getMuteLoadResult();
            if (muteLoadResult == null || muteLoadResult.getIntExtra("intent_return_code", -10000) != 0) {
                return false;
            }
            return true;
        }
        throw new RuntimeException("MuteApplication is null");
    }

    private void printAppPackageInfo(Application application) {
        try {
            Context context = (Context) ShareReflectUtil.findField(application.getClass(), "mBase").get(application);
            Object obj = ShareReflectUtil.findField(context.getClass(), "mPackageInfo").get(context);
            if (Build.VERSION.SDK_INT >= 24) {
                MuteLog.i("Mute.ExpHandler", "mBaseApplicationInfo=" + application.getApplicationInfo() + ",mBasePackageInfo=" + obj + ",mBaseDataDir=", new Object[0]);
            }
        } catch (Exception e) {
            MuteLog.printErrStackTrace("Mute.ExpHandler", e, "fix context data npe failed", new Object[0]);
        }
    }

    public static boolean tinkerFastCrashProtect(Throwable th) {
        IAppLike appLike = Muter.getAppLike();
        if (appLike != null && appLike.getHostApp() != null && isTinkerLoadSuccess(appLike) && SystemClock.elapsedRealtime() - appLike.getAppStartElapsed() < 10000) {
            String currentVersion = getCurrentVersion(appLike);
            if (ShareTinkerInternals.isNullOrNil(currentVersion)) {
                return false;
            }
            SharedPreferences sharedPreferences = appLike.getHostApp().getSharedPreferences("tinker_share_config", 4);
            int i = sharedPreferences.getInt(currentVersion, 0) + 1;
            if (i >= 3) {
                cleanPatch(appLike);
                MuteLog.e("Mute.ExpHandler", "tinker has fast crash more than %d, we just clean patch!", Integer.valueOf(i));
                return true;
            }
            sharedPreferences.edit().putInt(currentVersion, i).commit();
            MuteLog.e("Mute.ExpHandler", "tinker has fast crash %d times", Integer.valueOf(i));
        }
        return false;
    }

    private void tinkerPreVerifiedCrashHandler(Throwable th) {
        boolean z;
        IAppLike appLike = Muter.getAppLike();
        if (appLike != null && appLike.getHostApp() != null) {
            if (!isTinkerLoadSuccess(appLike)) {
                MuteLog.w("Mute.ExpHandler", "tinker is not loaded", new Object[0]);
                return;
            }
            boolean z2 = false;
            while (th != null) {
                if (!z2) {
                    z2 = Utils.isXposedExists(th);
                }
                if (z2) {
                    if ((th instanceof IllegalAccessError) && th.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        MuteLog.e("Mute.ExpHandler", "have xposed: just clean tinker", new Object[0]);
                        ShareTinkerInternals.killAllOtherProcess(appLike.getHostApp());
                        cleanPatch(appLike);
                        ShareTinkerInternals.setTinkerDisableWithSharedPreferences(appLike.getHostApp());
                        return;
                    }
                }
                th = th.getCause();
            }
            return;
        }
        MuteLog.w("Mute.ExpHandler", "applicationlike is null", new Object[0]);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String message = th.getMessage();
        Object[] objArr = new Object[1];
        if (message == null) {
            message = "null";
        }
        objArr[0] = message;
        MuteLog.e("Mute.ExpHandler", "uncaughtException: [%s]", objArr);
        if (Muter.getAppContext() instanceof Application) {
            printAppPackageInfo((Application) Muter.getAppContext());
        }
        tinkerFastCrashProtect(th);
        tinkerPreVerifiedCrashHandler(th);
        this.mUncaughtExpHandler.uncaughtException(thread, th);
    }
}
