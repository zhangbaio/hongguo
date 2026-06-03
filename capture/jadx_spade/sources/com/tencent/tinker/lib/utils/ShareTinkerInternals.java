package com.tencent.tinker.lib.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ShareTinkerInternals {
    private static final boolean VM_IS_ART;
    private static Boolean isARKHotRunning;
    private static String tinkerID;
    private static String tinkerVersion;

    private static List com_tencent_tinker_lib_utils_ShareTinkerInternals_android_app_ActivityManager_getRunningAppProcesses(ActivityManager activityManager) {
        Result preInvoke = new HeliosApiHook().preInvoke(101303, "android/app/ActivityManager", "getRunningAppProcesses", activityManager, new Object[0], "java.util.List", new ExtraInfo(false, "()Ljava/util/List;"));
        return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : activityManager.getRunningAppProcesses();
    }

    public static boolean isVmArt() {
        return true;
    }

    static {
        Covode.recordClassIndex(653943);
        VM_IS_ART = isVmArt(System.getProperty("java.vm.version"));
        isARKHotRunning = null;
        tinkerID = null;
        tinkerVersion = null;
    }

    public static boolean isArkHotRuning() {
        Boolean bool = isARKHotRunning;
        if (bool != null) {
            return bool.booleanValue();
        }
        isARKHotRunning = Boolean.FALSE;
        try {
            Method declaredMethod = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.app.ArkApplicationInfo").getDeclaredMethod("isRunningInArk", new Class[0]);
            declaredMethod.setAccessible(true);
            isARKHotRunning = (Boolean) declaredMethod.invoke(null, new Object[0]);
        } catch (ClassNotFoundException unused) {
            MuteLog.i("Tinker.TinkerInternals", "class not found exception", new Object[0]);
        } catch (IllegalAccessException unused2) {
            MuteLog.i("Tinker.TinkerInternals", "illegal access exception", new Object[0]);
        } catch (IllegalArgumentException unused3) {
            MuteLog.i("Tinker.TinkerInternals", "illegal argument exception", new Object[0]);
        } catch (NoSuchMethodException unused4) {
            MuteLog.i("Tinker.TinkerInternals", "no such method exception", new Object[0]);
        } catch (SecurityException unused5) {
            MuteLog.i("Tinker.TinkerInternals", "security exception", new Object[0]);
        } catch (InvocationTargetException unused6) {
            MuteLog.i("Tinker.TinkerInternals", "invocation target exception", new Object[0]);
        }
        return isARKHotRunning.booleanValue();
    }

    public static boolean isNullOrNil(String str) {
        if (str != null && str.length() > 0) {
            return false;
        }
        return true;
    }

    public static void setTinkerDisableWithSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tinker_share_config", 4);
        sharedPreferences.edit().putBoolean(getTinkerSwitchSPKey(context), false).commit();
    }

    private static String getTinkerSwitchSPKey(Context context) {
        String manifestTinkerID = getManifestTinkerID(context);
        if (isNullOrNil(manifestTinkerID)) {
            manifestTinkerID = "@@";
        }
        return "tinker_enable_" + getManifestTinkerVersion(context) + "_" + manifestTinkerID;
    }

    private static boolean isVmArt(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt <= 2 && (parseInt != 2 || parseInt2 < 1)) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static void killAllOtherProcess(Context context) {
        List<ActivityManager.RunningAppProcessInfo> com_tencent_tinker_lib_utils_ShareTinkerInternals_android_app_ActivityManager_getRunningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (com_tencent_tinker_lib_utils_ShareTinkerInternals_android_app_ActivityManager_getRunningAppProcesses = com_tencent_tinker_lib_utils_ShareTinkerInternals_android_app_ActivityManager_getRunningAppProcesses(activityManager)) == null) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : com_tencent_tinker_lib_utils_ShareTinkerInternals_android_app_ActivityManager_getRunningAppProcesses) {
            if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public static void cleanPatch(Application application) {
        if (application != null) {
            File patchDirectory = FileUtils.getPatchDirectory(application);
            if (!patchDirectory.exists()) {
                MuteLog.printErrStackTrace("Tinker.TinkerInternals", new Throwable(), "try to clean patch while there're not any applied patches.", new Object[0]);
                return;
            }
            File patchInfoFile = FileUtils.getPatchInfoFile(patchDirectory.getAbsolutePath());
            if (!patchInfoFile.exists()) {
                MuteLog.printErrStackTrace("Tinker.TinkerInternals", new Throwable(), "try to clean patch while patch info file does not exist.", new Object[0]);
                return;
            }
            File patchInfoLockFile = FileUtils.getPatchInfoLockFile(patchDirectory.getAbsolutePath());
            SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
            if (readAndCheckPropertyWithLock != null) {
                readAndCheckPropertyWithLock.isRemoveNewVersion = true;
                SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, readAndCheckPropertyWithLock, patchInfoLockFile);
                return;
            }
            return;
        }
        throw new RuntimeException("app is null");
    }

    public static String getManifestTinkerID(Context context) {
        String str = tinkerID;
        if (str != null) {
            return str;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("TINKER_ID");
            if (obj != null) {
                tinkerID = String.valueOf(obj);
            } else {
                tinkerID = null;
            }
            return tinkerID;
        } catch (Exception e) {
            MuteLog.e("Tinker.TinkerInternals", "getManifestTinkerID exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String getManifestTinkerVersion(Context context) {
        String str = tinkerVersion;
        if (str != null) {
            return str;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("tinker_version");
            if (obj != null) {
                tinkerVersion = String.valueOf(obj);
            } else {
                tinkerVersion = null;
            }
            return tinkerVersion;
        } catch (Exception e) {
            MuteLog.e("Tinker.TinkerInternals", "getManifestTinkerVersion exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }
}
