package com.tencent.tinker.lib.am;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.TypedValue;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.tencent.tinker.lib.MuteLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ProcessRecord {
    private Context mContext;
    IBinder.DeathRecipient mDeathRecipient;
    boolean mIsMainProcess;
    int mPid;
    String mProcessName;
    String mProcessTag;
    TreeMap<String, ActivityInfo> mStubActivities = new TreeMap<>();
    TreeMap<String, ServiceInfo> mStubServices = new TreeMap<>();
    TreeMap<String, ActivityInfo> mStubReceivers = new TreeMap<>();
    TreeMap<String, ProviderInfo> mStubProviders = new TreeMap<>();
    HashMap<String, ActivityInfo> mRunningActivities = new HashMap<>();
    HashMap<String, ArrayList<ServiceInfo>> mRunningServices = new HashMap<>();
    HashMap<String, ArrayList<ActivityInfo>> mRunningReceivers = new HashMap<>();
    HashMap<String, ArrayList<ProviderInfo>> mRunningProviders = new HashMap<>();
    private Map<String, ServiceInfo> mUsedServices = new HashMap();

    static {
        Covode.recordClassIndex(653731);
    }

    private static List com_tencent_tinker_lib_am_ProcessRecord_android_content_pm_PackageManager_queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
        Result preInvoke = new HeliosApiHook().preInvoke(101311, "android/content/pm/PackageManager", "queryIntentActivities", packageManager, new Object[]{intent, Integer.valueOf(i)}, "java.util.List", new ExtraInfo(false, "(Landroid/content/Intent;I)Ljava/util/List;"));
        return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : packageManager.queryIntentActivities(intent, i);
    }

    synchronized void reset() {
        this.mPid = 0;
        this.mRunningActivities.clear();
        this.mRunningServices.clear();
        this.mRunningProviders.clear();
        this.mRunningReceivers.clear();
        this.mDeathRecipient = null;
    }

    synchronized boolean hasRunningActivity(ActivityInfo activityInfo) {
        if (this.mRunningActivities.size() == 0) {
            return false;
        }
        for (ActivityInfo activityInfo2 : this.mRunningActivities.values()) {
            if (activityInfo2 != null && TextUtils.equals(activityInfo2.packageName, activityInfo.packageName) && TextUtils.equals(activityInfo2.name, activityInfo.name)) {
                return true;
            }
        }
        return false;
    }

    synchronized boolean hasRunningService(ServiceInfo serviceInfo) {
        HashMap<String, ArrayList<ServiceInfo>> hashMap = this.mRunningServices;
        if (hashMap == null) {
            return false;
        }
        for (ArrayList<ServiceInfo> arrayList : hashMap.values()) {
            for (int i = 0; arrayList != null && i < arrayList.size(); i++) {
                ServiceInfo serviceInfo2 = arrayList.get(i);
                if (serviceInfo2 != null && TextUtils.equals(serviceInfo2.packageName, serviceInfo.packageName) && TextUtils.equals(serviceInfo2.name, serviceInfo.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    synchronized ProviderInfo selectStubProvider(ProviderInfo providerInfo) {
        if (providerInfo != null) {
            if (!TextUtils.isEmpty(providerInfo.packageName) && !TextUtils.isEmpty(providerInfo.name)) {
                ProviderInfo providerInfo2 = this.mStubProviders.get(providerInfo.name);
                if (providerInfo2 != null) {
                    addProvider(providerInfo2, providerInfo);
                    MuteLog.i("Mute.ProcessRecord", "selectStubProvider from self mStubProviders, " + providerInfo + " <<< " + providerInfo2, new Object[0]);
                    return providerInfo2;
                }
                for (ProviderInfo providerInfo3 : this.mStubProviders.values()) {
                    if (providerInfo3.name.matches("com.tencent.tinker.lib.stub.[_a-zA-Z0-9]+.StubContentProvider")) {
                        addProvider(providerInfo3, providerInfo);
                        MuteLog.i("Mute.ProcessRecord", "selectStubProvider from match mStubProviders, " + providerInfo + " <<< " + providerInfo3, new Object[0]);
                        return providerInfo3;
                    }
                }
                MuteLog.w("Mute.ProcessRecord", "selectStubProvider null", new Object[0]);
                return null;
            }
        }
        MuteLog.w("Mute.ProcessRecord", "selectStubProvider, targetInfo illegal, " + providerInfo, new Object[0]);
        return null;
    }

    synchronized ActivityInfo selectStubReceiver(ActivityInfo activityInfo) {
        if (activityInfo != null) {
            if (!TextUtils.isEmpty(activityInfo.packageName) && !TextUtils.isEmpty(activityInfo.name)) {
                ActivityInfo activityInfo2 = this.mStubReceivers.get(activityInfo.name);
                if (activityInfo2 != null) {
                    addReceiver(activityInfo2, activityInfo);
                    MuteLog.i("Mute.ProcessRecord", "selectStubReceiver from self mStubReceivers, " + activityInfo + " <<< " + activityInfo2, new Object[0]);
                    return activityInfo2;
                }
                for (ActivityInfo activityInfo3 : this.mStubReceivers.values()) {
                    if (activityInfo3.name.matches("com.tencent.tinker.lib.stub.[_a-zA-Z0-9]+.StubReceiver")) {
                        addReceiver(activityInfo3, activityInfo);
                        MuteLog.i("Mute.ProcessRecord", "selectStubReceiver from match mStubReceivers, " + activityInfo + " <<< " + activityInfo3, new Object[0]);
                        return activityInfo3;
                    }
                }
                MuteLog.w("Mute.ProcessRecord", "selectStubReceiver null", new Object[0]);
                return null;
            }
        }
        MuteLog.w("Mute.ProcessRecord", "selectStubReceiver, targetInfo illegal, " + activityInfo, new Object[0]);
        return null;
    }

    synchronized ServiceInfo selectStubService(ServiceInfo serviceInfo) {
        if (serviceInfo != null) {
            if (!TextUtils.isEmpty(serviceInfo.packageName) && !TextUtils.isEmpty(serviceInfo.name)) {
                if (this.mUsedServices.containsKey(serviceInfo.name)) {
                    MuteLog.i("Mute.ProcessRecord", "selectStubService from mUsedServices, " + serviceInfo + " <<< " + this.mUsedServices.get(serviceInfo.name), new Object[0]);
                    return this.mUsedServices.get(serviceInfo.name);
                }
                for (ServiceInfo serviceInfo2 : this.mStubServices.values()) {
                    if (!this.mRunningServices.containsKey(serviceInfo2.name)) {
                        addService(serviceInfo2, serviceInfo);
                        MuteLog.i("Mute.ProcessRecord", "selectStubService from match mStubReceivers, " + serviceInfo + " <<< " + serviceInfo2, new Object[0]);
                        return serviceInfo2;
                    }
                }
                MuteLog.w("Mute.ProcessRecord", "selectStubService null", new Object[0]);
                return null;
            }
        }
        MuteLog.w("Mute.ProcessRecord", "selectStubService, targetInfo illegal, " + serviceInfo, new Object[0]);
        return null;
    }

    synchronized ActivityInfo selectStubActivity(ActivityInfo activityInfo) {
        ActivityInfo activityInfo2;
        if (activityInfo != null) {
            if (!TextUtils.isEmpty(activityInfo.packageName) && !TextUtils.isEmpty(activityInfo.name)) {
                if (this.mStubActivities.size() == 0) {
                    MuteLog.w("Mute.ProcessRecord", "selectStubActivity reFill empty mStubActivities, process = " + this.mProcessName, new Object[0]);
                    reFillStubActivities(this.mStubActivities, this.mProcessName);
                }
                ActivityInfo activityInfo3 = this.mStubActivities.get(activityInfo.name);
                if (activityInfo3 != null) {
                    addActivity(activityInfo3, activityInfo);
                    MuteLog.i("Mute.ProcessRecord", "selectStubActivity from self mStubActivities, " + activityInfo + " <<< " + activityInfo3, new Object[0]);
                    return activityInfo3;
                }
                for (Map.Entry<String, ActivityInfo> entry : this.mRunningActivities.entrySet()) {
                    if (entry != null) {
                        ActivityInfo value = entry.getValue();
                        if (TextUtils.equals(value.packageName, activityInfo.packageName) && TextUtils.equals(value.name, activityInfo.name)) {
                            ActivityInfo activityInfo4 = this.mStubActivities.get(entry.getKey());
                            MuteLog.i("Mute.ProcessRecord", "selectStubActivity from mRunningActivities, " + activityInfo + " <<< " + activityInfo4, new Object[0]);
                            return activityInfo4;
                        }
                    }
                }
                if (isTranslucent(activityInfo, this.mContext.getApplicationContext()) && (activityInfo2 = this.mStubActivities.get(String.format("com.tencent.tinker.lib.stub.%s.StubTranslucentActivity", this.mProcessTag))) != null) {
                    addActivity(activityInfo2, activityInfo);
                    MuteLog.i("Mute.ProcessRecord", "selectStubActivity from translucent, " + activityInfo + " <<< " + activityInfo2, new Object[0]);
                    return activityInfo2;
                }
                for (ActivityInfo activityInfo5 : this.mStubActivities.values()) {
                    if (activityInfo5.name.matches("com.tencent.tinker.lib.stub.[_a-zA-Z0-9]+.Stub[a-zA-Z]+Activity[0-9]+") && activityInfo5.launchMode == activityInfo.launchMode && canUse(activityInfo5, activityInfo)) {
                        addActivity(activityInfo5, activityInfo);
                        MuteLog.i("Mute.ProcessRecord", "selectStubActivity from match mStubActivities, " + activityInfo + " <<< " + activityInfo5, new Object[0]);
                        return activityInfo5;
                    }
                }
                MuteLog.w("Mute.ProcessRecord", "selectStubActivity null", new Object[0]);
                return null;
            }
        }
        MuteLog.w("Mute.ProcessRecord", "selectStubActivity targetInfo illegal, %s", activityInfo);
        return null;
    }

    synchronized void addActivity(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        if (this.mRunningActivities.get(activityInfo.name) == null) {
            this.mRunningActivities.put(activityInfo.name, activityInfo2);
        }
    }

    synchronized void removeActivity(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        if (this.mRunningActivities.get(activityInfo.name) != null) {
            this.mRunningActivities.remove(activityInfo.name);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        if (android.text.TextUtils.equals(r3.name, r4.name) == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    synchronized boolean canUse(android.content.pm.ActivityInfo r3, android.content.pm.ActivityInfo r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.HashMap<java.lang.String, android.content.pm.ActivityInfo> r0 = r2.mRunningActivities     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = r3.name     // Catch: java.lang.Throwable -> L27
            java.lang.Object r3 = r0.get(r3)     // Catch: java.lang.Throwable -> L27
            android.content.pm.ActivityInfo r3 = (android.content.pm.ActivityInfo) r3     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto L24
            java.lang.String r0 = r3.packageName     // Catch: java.lang.Throwable -> L27
            java.lang.String r1 = r4.packageName     // Catch: java.lang.Throwable -> L27
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L21
            java.lang.String r3 = r3.name     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = r4.name     // Catch: java.lang.Throwable -> L27
            boolean r3 = android.text.TextUtils.equals(r3, r4)     // Catch: java.lang.Throwable -> L27
            if (r3 != 0) goto L24
        L21:
            monitor-exit(r2)
            r3 = 0
            return r3
        L24:
            monitor-exit(r2)
            r3 = 1
            return r3
        L27:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.am.ProcessRecord.canUse(android.content.pm.ActivityInfo, android.content.pm.ActivityInfo):boolean");
    }

    public static boolean isTranslucent(ActivityInfo activityInfo, Context context) {
        boolean z;
        Bundle bundle = activityInfo.metaData;
        if ((bundle == null || !bundle.getBoolean("isTranslucent", false)) && activityInfo.getThemeResource() != 16973839 && activityInfo.getThemeResource() != 16973840 && activityInfo.getThemeResource() != 16973841) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Resources resources = context.getResources();
            if (resources == null) {
                return false;
            }
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = resources.newTheme();
            newTheme.applyStyle(activityInfo.getThemeResource(), true);
            newTheme.resolveAttribute(R.attr.windowIsTranslucent, typedValue, true);
            TypedArray obtainStyledAttributes = newTheme.obtainStyledAttributes(typedValue.resourceId, new int[]{R.attr.windowIsTranslucent});
            boolean z2 = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            return z2;
        }
        return z;
    }

    private void reFillStubActivities(TreeMap<String, ActivityInfo> treeMap, String str) {
        Intent intent = new Intent();
        intent.setAction("com.intent.action.ACTION_STUB_PATCH");
        intent.addCategory("com.intent.category.PATCH_DEFAULT");
        Context applicationContext = this.mContext.getApplicationContext();
        intent.setPackage(applicationContext.getPackageName());
        List com_tencent_tinker_lib_am_ProcessRecord_android_content_pm_PackageManager_queryIntentActivities = com_tencent_tinker_lib_am_ProcessRecord_android_content_pm_PackageManager_queryIntentActivities(applicationContext.getPackageManager(), intent, 0);
        if (com_tencent_tinker_lib_am_ProcessRecord_android_content_pm_PackageManager_queryIntentActivities != null && com_tencent_tinker_lib_am_ProcessRecord_android_content_pm_PackageManager_queryIntentActivities.size() > 0) {
            Iterator it2 = com_tencent_tinker_lib_am_ProcessRecord_android_content_pm_PackageManager_queryIntentActivities.iterator();
            while (it2.hasNext()) {
                ActivityInfo activityInfo = ((ResolveInfo) it2.next()).activityInfo;
                if (activityInfo.processName.equals(str)) {
                    treeMap.put(activityInfo.name, activityInfo);
                }
            }
        }
    }

    synchronized void addProvider(ProviderInfo providerInfo, ProviderInfo providerInfo2) {
        boolean z;
        ArrayList<ProviderInfo> arrayList = this.mRunningProviders.get(providerInfo2.name);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mRunningProviders.put(providerInfo.name, arrayList);
        }
        Iterator<ProviderInfo> it2 = arrayList.iterator();
        while (true) {
            if (it2.hasNext()) {
                ProviderInfo next = it2.next();
                if (TextUtils.equals(next.packageName, providerInfo2.packageName) && TextUtils.equals(next.name, providerInfo2.name)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            arrayList.add(providerInfo2);
        }
    }

    synchronized void addReceiver(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        boolean z;
        ArrayList<ActivityInfo> arrayList = this.mRunningReceivers.get(activityInfo.name);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mRunningReceivers.put(activityInfo.name, arrayList);
        }
        Iterator<ActivityInfo> it2 = arrayList.iterator();
        while (true) {
            if (it2.hasNext()) {
                ActivityInfo next = it2.next();
                if (TextUtils.equals(next.packageName, activityInfo2.packageName) && TextUtils.equals(next.name, activityInfo2.name)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            arrayList.add(activityInfo2);
        }
    }

    synchronized void addService(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        boolean z;
        if (!this.mUsedServices.containsKey(serviceInfo2.name)) {
            this.mUsedServices.put(serviceInfo2.name, serviceInfo);
        }
        ArrayList<ServiceInfo> arrayList = this.mRunningServices.get(serviceInfo.name);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mRunningServices.put(serviceInfo.name, arrayList);
        }
        Iterator<ServiceInfo> it2 = arrayList.iterator();
        while (true) {
            if (it2.hasNext()) {
                ServiceInfo next = it2.next();
                if (TextUtils.equals(next.packageName, serviceInfo2.packageName) && TextUtils.equals(next.name, serviceInfo2.name)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            arrayList.add(serviceInfo2);
        }
    }

    synchronized void removeReceiver(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        ArrayList<ActivityInfo> arrayList = this.mRunningReceivers.get(activityInfo.name);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ActivityInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ActivityInfo next = it2.next();
                if (TextUtils.equals(next.packageName, activityInfo2.packageName) && TextUtils.equals(next.name, activityInfo2.name)) {
                    it2.remove();
                }
            }
        }
        if (arrayList != null && arrayList.size() == 0) {
            this.mRunningReceivers.remove(activityInfo.name);
        }
    }

    synchronized void removeService(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        ArrayList<ServiceInfo> arrayList = this.mRunningServices.get(serviceInfo.name);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ServiceInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ServiceInfo next = it2.next();
                if (TextUtils.equals(next.packageName, serviceInfo2.packageName) && TextUtils.equals(next.name, serviceInfo2.name)) {
                    it2.remove();
                }
            }
        }
        if (arrayList != null && arrayList.size() == 0) {
            this.mRunningServices.remove(serviceInfo.name);
        }
        if (this.mUsedServices.containsKey(serviceInfo2.name)) {
            this.mUsedServices.remove(serviceInfo2.name);
        }
    }

    ProcessRecord(String str, Context context) {
        this.mProcessName = str;
        this.mContext = context;
        this.mIsMainProcess = TextUtils.equals(str, context.getPackageName());
        if (this.mProcessName.matches(".+:stubp[0-9]+")) {
            StringBuilder sb = new StringBuilder();
            sb.append("p");
            String str2 = this.mProcessName;
            sb.append(str2.substring(str2.lastIndexOf(":stubp") + 6));
            this.mProcessTag = sb.toString();
            return;
        }
        this.mProcessTag = "p0";
    }
}
