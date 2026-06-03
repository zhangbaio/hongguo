package com.tencent.tinker.lib.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.tencent.tinker.lib.MuteLog;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ProcessUtil {
    private static String sProcName;

    static {
        Covode.recordClassIndex(653932);
    }

    private static List com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses(ActivityManager activityManager) {
        Result preInvoke = new HeliosApiHook().preInvoke(101303, "android/app/ActivityManager", "getRunningAppProcesses", activityManager, new Object[0], "java.util.List", new ExtraInfo(false, "()Ljava/util/List;"));
        return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : activityManager.getRunningAppProcesses();
    }

    private static String getCurtProcNameByApp() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Exception e) {
                MuteLog.e("Mute.Utils", "getCurtProcNameByApp err, %s", e);
                return null;
            }
        }
        return null;
    }

    private static String getCurProcNameByAT() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Throwable th) {
            MuteLog.e("Mute.Utils", "getCurProcNameByAT err, %s", th);
            return null;
        }
    }

    private static String getCurProcNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader((InputStream) new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                try {
                    MuteLog.e("Mute.Utils", "getCurProcNameFromProc err, %s", th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public static String getProcName(Context context) {
        String str = sProcName;
        if (str != null) {
            return str;
        }
        String processName = getProcessName(context);
        sProcName = processName;
        return processName;
    }

    public static boolean isPluginProcess(Context context) {
        String procName = getProcName(context);
        if (procName == null) {
            return false;
        }
        return procName.matches(".+:stubp[0-9]+");
    }

    private static String getCurProcNameByAM(Context context) {
        List<ActivityManager.RunningAppProcessInfo> com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses;
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses = com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses(activityManager)) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    private static String getProcessName(Context context) {
        int myPid = Process.myPid();
        if (context != null && myPid > 0) {
            String curtProcNameByApp = getCurtProcNameByApp();
            if (!TextUtils.isEmpty(curtProcNameByApp)) {
                return curtProcNameByApp;
            }
            String curProcNameByAT = getCurProcNameByAT();
            if (!TextUtils.isEmpty(curProcNameByAT)) {
                return curProcNameByAT;
            }
            String curProcNameFromProc = getCurProcNameFromProc();
            if (!TextUtils.isEmpty(curProcNameFromProc)) {
                return curProcNameFromProc;
            }
            String curProcNameByAM = getCurProcNameByAM(context);
            if (!TextUtils.isEmpty(curProcNameByAM)) {
                return curProcNameByAM;
            }
        }
        return "";
    }

    public static boolean isMainProcess(Context context) {
        String str;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str = applicationInfo.processName;
        } else {
            str = null;
        }
        if (Preconditions.isNullOrNil(str)) {
            str = context.getPackageName();
        }
        String processName = getProcessName(context);
        if (processName == null || processName.length() == 0) {
            processName = "";
        }
        return str.equals(processName);
    }

    public static void killOtherProc(Context context) {
        List<ActivityManager.RunningAppProcessInfo> com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses = com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses(activityManager)) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses) {
                if (runningAppProcessInfo.uid == Process.myUid() && !runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    Process.killProcess(runningAppProcessInfo.pid);
                    MuteLog.w("Mute.Utils", "killOtherProc pid[%d] processName[%s]", Integer.valueOf(runningAppProcessInfo.pid), runningAppProcessInfo.processName);
                }
            }
        }
    }

    public static void killProcBySuffix(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses = com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses(activityManager)) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : com_tencent_tinker_lib_utils_ProcessUtil_android_app_ActivityManager_getRunningAppProcesses) {
                if (runningAppProcessInfo.processName.endsWith(str)) {
                    MuteLog.w("Mute.Utils", "killProcByName pid[%d] processName[%s]", Integer.valueOf(runningAppProcessInfo.pid), runningAppProcessInfo.processName);
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
    }
}
