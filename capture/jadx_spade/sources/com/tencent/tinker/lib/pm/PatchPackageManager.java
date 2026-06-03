package com.tencent.tinker.lib.pm;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageParser;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.ComponentDiff;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.Muter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PatchPackageManager {
    private static PatchComponentResolver sInstance;

    static {
        Covode.recordClassIndex(653778);
    }

    private static PatchComponentResolver getInstance() {
        if (sInstance == null) {
            sInstance = PatchComponentResolver.getInstance();
        }
        return sInstance;
    }

    public static List<String> getDeleteProviderNameList() {
        try {
            return getInstance().getDeleteProviderNameList();
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getDeleteProviderNameList failed. %s", e);
            return null;
        }
    }

    public static Set<String> getIncProcessSet() {
        try {
            return getInstance().getIncProcessSet();
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getIncProcessSet failed. %s", e);
            return null;
        }
    }

    public static boolean isActivityModify(String str) {
        try {
            return getInstance().isActivityModify(str);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "isActivityModify failed. %s", e);
            return false;
        }
    }

    public static ActivityInfo getActivityInfo(String str, int i) {
        try {
            return getInstance().getActivityInfo(str, i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getActivityInfo failed. %s", e);
            return null;
        }
    }

    public static List<ProviderInfo> getProviders(String str, int i) {
        try {
            return getInstance().getProviders(str, i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getProviders failed. %s", e);
            return null;
        }
    }

    public static List<ReceiverInfo> getReceivers(String str, int i) {
        try {
            return getInstance().getReceivers(str, i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getReceivers failed. %s", e);
            return Collections.emptyList();
        }
    }

    public static ProviderInfo resolveContentProvider(String str, int i) {
        try {
            return getInstance().resolveContentProvider(str, i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "resolveContentProvider failed. %s", e);
            return null;
        }
    }

    public static boolean resolvePatchPackage(PackageParser.Package r2, ComponentDiff componentDiff) {
        try {
            return getInstance().resolvePatchPackage(r2, componentDiff);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "resolvePatchPackage failed. %s", e);
            return false;
        }
    }

    public static ActivityInfo getActivityInfo(ComponentName componentName, int i) {
        ActivityInfo activityInfo;
        try {
            activityInfo = getInstance().getActivityInfo(componentName, i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getActivityInfo failed. %s", e);
            activityInfo = null;
        }
        if (activityInfo == null) {
            ActivityInfo activityInfo2 = new ActivityInfo();
            activityInfo2.packageName = componentName.getPackageName();
            return activityInfo2;
        }
        return activityInfo;
    }

    public static ProviderInfo getProviderInfo(ComponentName componentName, int i) {
        ProviderInfo providerInfo;
        try {
            providerInfo = getInstance().getProviderInfo(componentName, i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getProviderInfo failed. %s", e);
            providerInfo = null;
        }
        if (providerInfo == null) {
            ProviderInfo providerInfo2 = new ProviderInfo();
            providerInfo2.packageName = componentName.getPackageName();
            return providerInfo2;
        }
        return providerInfo;
    }

    public static ActivityInfo getReceiverInfo(ComponentName componentName, int i) {
        ActivityInfo activityInfo;
        try {
            activityInfo = getInstance().getReceiverInfo(componentName, i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getReceiverInfo failed. %s", e);
            activityInfo = null;
        }
        if (activityInfo == null) {
            ActivityInfo activityInfo2 = new ActivityInfo();
            activityInfo2.packageName = componentName.getPackageName();
            return activityInfo2;
        }
        return activityInfo;
    }

    public static ServiceInfo getServiceInfo(ComponentName componentName, int i) {
        ServiceInfo serviceInfo;
        try {
            serviceInfo = getInstance().getServiceInfo(componentName, i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "getServiceInfo failed. %s", e);
            serviceInfo = null;
        }
        if (serviceInfo == null) {
            ServiceInfo serviceInfo2 = new ServiceInfo();
            serviceInfo2.packageName = componentName.getPackageName();
            return serviceInfo2;
        }
        return serviceInfo;
    }

    public static List<ResolveInfo> queryBroadcastReceivers(Intent intent, int i) {
        try {
            return getInstance().queryBroadcastReceivers(intent, intent.resolveTypeIfNeeded(Muter.getAppContext().getContentResolver()), i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "queryBroadcastReceivers failed. %s", e);
            return null;
        }
    }

    public static List<ResolveInfo> queryIntentActivities(Intent intent, int i) {
        try {
            return getInstance().queryIntentActivities(intent, intent.resolveTypeIfNeeded(Muter.getAppContext().getContentResolver()), i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "queryIntentActivities failed. %s", e);
            return null;
        }
    }

    public static List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        try {
            return getInstance().queryIntentServices(intent, intent.resolveTypeIfNeeded(Muter.getAppContext().getContentResolver()), i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "queryIntentServices failed. %s", e);
            return null;
        }
    }

    public static ResolveInfo resolveIntent(Intent intent, int i) {
        try {
            return getInstance().resolveIntent(intent, intent.resolveTypeIfNeeded(Muter.getAppContext().getContentResolver()), i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "resolveIntent failed. %s", e);
            return null;
        }
    }

    public static ResolveInfo resolveService(Intent intent, int i) {
        try {
            return getInstance().resolveService(intent, intent.resolveTypeIfNeeded(Muter.getAppContext().getContentResolver()), i);
        } catch (Exception e) {
            MuteLog.e("Mute.PM", "resolveService failed. %s", e);
            return null;
        }
    }
}
