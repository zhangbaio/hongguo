package com.tencent.tinker.lib.utils;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.Looper;
import android.util.ArrayMap;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.tinker.lib.MuteLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ATUtils {
    private static Object sActivityThread;
    private static Class sClass;
    private static Class sClassForActivityThread;
    private static Object sDefaultCompatibilityInfo;

    static {
        Covode.recordClassIndex(653921);
    }

    private static Class clazz() {
        if (sClass == null) {
            try {
                sClass = Class.forName("android.content.res.CompatibilityInfo");
            } catch (ClassNotFoundException unused) {
            }
        }
        return sClass;
    }

    public static Object getAppBindData() {
        try {
            return FieldUtils.readField(currentActivityThread(), "mBoundApplication");
        } catch (Exception e) {
            MuteLog.e("Mute.AT", "getAppBindData failed. %s", e);
            return null;
        }
    }

    public static List<Application> getApplications() {
        try {
            return (List) FieldUtils.readField(currentActivityThread(), "mAllApplications");
        } catch (Throwable th) {
            MuteLog.e("Mute.AT", "getApplications failed. %s", th);
            return null;
        }
    }

    public static Object getDefaultCompatibilityInfo() {
        if (sDefaultCompatibilityInfo == null) {
            try {
                sDefaultCompatibilityInfo = FieldUtils.readStaticField(clazz(), "DEFAULT_COMPATIBILITY_INFO");
            } catch (IllegalAccessException unused) {
            }
        }
        return sDefaultCompatibilityInfo;
    }

    public static Instrumentation getInstrumentation() {
        try {
            return (Instrumentation) MethodUtils.invokeMethod(currentActivityThread(), "getInstrumentation", new Object[0]);
        } catch (Exception e) {
            MuteLog.e("Mute.AT", "getInstrumentation failed.", e);
            return null;
        }
    }

    public static List<ProviderInfo> getProviders() {
        try {
            Object appBindData = getAppBindData();
            if (appBindData != null) {
                return (List) FieldUtils.readField(appBindData, "providers");
            }
            return null;
        } catch (Exception e) {
            MuteLog.e("Mute.AT", "getProviders failed. %s", e);
            return null;
        }
    }

    public static List<Activity> getActivities() {
        Activity activity;
        ArrayList arrayList = new ArrayList();
        for (Object obj : getActivityRecords()) {
            try {
                activity = (Activity) FieldUtils.readField(obj, "activity");
            } catch (Exception e) {
                MuteLog.e("Mute.AT", "reflect activityRecord.activity failed, record = %s, %s", obj, e);
                activity = null;
            }
            if (activity != null) {
                arrayList.add(activity);
            }
        }
        return arrayList;
    }

    public static List<Object> getActivityRecords() {
        ArrayList arrayList = new ArrayList();
        try {
            Object readField = FieldUtils.readField(currentActivityThread(), "mActivities");
            if (readField instanceof HashMap) {
                arrayList.addAll(((HashMap) readField).values());
            } else if (OSUtil.isAndroidKHigher() && (readField instanceof ArrayMap)) {
                arrayList.addAll(((ArrayMap) readField).values());
            }
        } catch (Exception e) {
            MuteLog.e("Mute.AT", "getActivityRecords failed. %s", e);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map getCachedLoadedApkMap() {
        /*
            java.lang.Object r0 = currentActivityThread()
            r1 = 0
            if (r0 == 0) goto L1c
            java.lang.String r2 = "mPackages"
            java.lang.Object r0 = com.tencent.tinker.lib.utils.FieldUtils.readField(r0, r2)     // Catch: java.lang.IllegalAccessException -> Le
            goto L1d
        Le:
            r0 = move-exception
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r0
            java.lang.String r0 = "Mute.AT"
            java.lang.String r3 = "getCachedLoadedApkMap failed. %s"
            com.tencent.tinker.lib.MuteLog.e(r0, r3, r2)
        L1c:
            r0 = r1
        L1d:
            boolean r2 = r0 instanceof java.util.Map
            if (r2 == 0) goto L24
            java.util.Map r0 = (java.util.Map) r0
            return r0
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.utils.ATUtils.getCachedLoadedApkMap():java.util.Map");
    }

    public static final Object currentActivityThread() {
        if (sActivityThread == null) {
            try {
                synchronized (ATUtils.class) {
                    if (sActivityThread == null) {
                        if (sClassForActivityThread == null) {
                            sClassForActivityThread = Class.forName("android.app.ActivityThread");
                        }
                        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);
                    }
                    if (sActivityThread == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new HandlerDelegate(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.tinker.lib.utils.ATUtils.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        Object unused = ATUtils.sActivityThread = MethodUtils.invokeStaticMethod(ATUtils.sClassForActivityThread, "currentActivityThread", new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e) {
                                        MuteLog.e("Mute.AT", "main looper invoke currentActivityThread failed. %s", e);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (sActivityThread == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e) {
                                    MuteLog.e("Mute.AT", "currentActivityThread interruptedException failed. %s", e);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                MuteLog.e("Mute.AT", "currentActivityThread failed. %s", e2);
            }
        }
        return sActivityThread;
    }

    public static void removePluginLoadedApk(String str) {
        Map cachedLoadedApkMap = getCachedLoadedApkMap();
        if (cachedLoadedApkMap != null) {
            synchronized (cachedLoadedApkMap) {
                if (cachedLoadedApkMap.containsKey(str)) {
                    cachedLoadedApkMap.remove(str);
                }
            }
        }
    }

    public static Object getCachedLoadedApk(String str) {
        try {
            Map map = (Map) FieldUtils.readField(currentActivityThread(), "mPackages");
            WeakReference weakReference = (WeakReference) map.get(str);
            if (weakReference != null) {
                return weakReference.get();
            }
            return map.get(str);
        } catch (Exception e) {
            MuteLog.e("Mute.AT", "getCachedLoadedApk failed. %s", e);
            return null;
        }
    }

    public static Object createLoadedApk(ApplicationInfo applicationInfo) {
        Object obj = null;
        if (applicationInfo != null) {
            try {
                Object currentActivityThread = currentActivityThread();
                if (OSUtil.isAndroidHHigher()) {
                    obj = MethodUtils.invokeMethod(currentActivityThread, "getPackageInfoNoCheck", applicationInfo, getDefaultCompatibilityInfo());
                } else {
                    obj = MethodUtils.invokeMethod(currentActivityThread, "getPackageInfoNoCheck", applicationInfo);
                }
                MuteLog.i("Mute.AT", "createLoadedApk, " + applicationInfo + " >> " + obj, new Object[0]);
            } catch (Exception e) {
                MuteLog.e("Mute.AT", "createLoadedApk failed. %s", e);
            }
        }
        return obj;
    }

    public static void installContentProviders(Context context, List<ProviderInfo> list) {
        try {
            MethodUtils.invokeMethod(currentActivityThread(), "installContentProviders", context, list);
            MuteLog.w("Mute.AT", "installContentProviders, size = " + list.size(), new Object[0]);
        } catch (Exception e) {
            MuteLog.e("Mute.AT", "installContentProviders failed. %s", e);
        }
    }
}
