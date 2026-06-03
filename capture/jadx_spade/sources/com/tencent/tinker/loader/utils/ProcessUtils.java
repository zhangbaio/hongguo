package com.tencent.tinker.loader.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ProcessUtils {
    private static boolean isMainProcess;
    private static String sProcessName;

    static {
        Covode.recordClassIndex(653966);
    }

    private static String getProcessNameByApp() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Exception e) {
                ShareTinkerLog.e("Mute.Utils", "getProcessNameByApp err, %s", e);
                return null;
            }
        }
        return null;
    }

    private static String getProcessNameByAT() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable th) {
            ShareTinkerLog.e("Mute.Utils", "getProcessNameByAT err, %s", th);
        }
        return null;
    }

    private static String getProcessNameByCMD() {
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
                    ShareTinkerLog.e("Mute.Utils", "getCurProcNameFromProc err, %s", th);
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

    private static String getProcessName(Context context) {
        String processNameByApp = getProcessNameByApp();
        if (!TextUtils.isEmpty(processNameByApp)) {
            return processNameByApp;
        }
        String processNameByAT = getProcessNameByAT();
        if (!TextUtils.isEmpty(processNameByAT)) {
            return processNameByAT;
        }
        String processNameByCMD = getProcessNameByCMD();
        if (!TextUtils.isEmpty(processNameByCMD)) {
            return processNameByCMD;
        }
        String processNameByAM = getProcessNameByAM(context);
        if (!TextUtils.isEmpty(processNameByAM)) {
            return processNameByAM;
        }
        return null;
    }

    private static String getProcessNameByAM(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return null;
    }

    public static boolean isMainProcess(Context context) {
        if (sProcessName == null) {
            sProcessName = getProcessName(context);
            String str = context.getApplicationInfo().packageName;
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            boolean equals = str.equals(sProcessName);
            isMainProcess = equals;
            return equals;
        }
        return isMainProcess;
    }

    public static void killSubsProcess(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myUid = Process.myUid();
        String str = context.getApplicationInfo().packageName;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.uid == myUid && !str.equals(runningAppProcessInfo.processName)) {
                    Process.killProcess(runningAppProcessInfo.pid);
                    ShareTinkerLog.w("Mute.Utils", "killOtherProc pid[%d] processName[%s]", Integer.valueOf(runningAppProcessInfo.pid), runningAppProcessInfo.processName);
                }
            }
        }
    }
}
