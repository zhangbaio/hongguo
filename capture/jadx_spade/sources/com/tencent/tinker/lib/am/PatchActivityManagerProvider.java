package com.tencent.tinker.lib.am;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.tinker.lib.MuteBoostExecutor;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.am.IPluginActivityManager;
import com.tencent.tinker.lib.pm.PatchPackageManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PatchActivityManagerProvider extends BinderProvider {
    private static volatile boolean sOncreated;
    final TreeMap<String, ProcessRecord> mSpareProcesses = new TreeMap<>();
    final TreeMap<String, ProcessRecord> mBusyProcesses = new TreeMap<>();
    final Map<String, String> mTargetStubProcessMap = new HashMap();
    final Object mWaitLock = new Object();
    AtomicBoolean mInited = new AtomicBoolean(false);
    Handler mHandler = new HandlerDelegate() { // from class: com.tencent.tinker.lib.am.PatchActivityManagerProvider.1
        public void handleMessage(Message message) {
            int i;
            int i2 = message.what;
            if ((i2 >>> 24) == 1 && (i = i2 & (-16777217)) > 0) {
                try {
                    if (!Build.BRAND.toLowerCase().equals("oppo")) {
                        Process.killProcess(i);
                    }
                } catch (Exception unused) {
                }
            }
        }
    };

    private static List com_tencent_tinker_lib_am_PatchActivityManagerProvider_android_content_pm_PackageManager_queryIntentActivities(PackageManager packageManager, Intent intent, int i) {
        Result preInvoke = new HeliosApiHook().preInvoke(101311, "android/content/pm/PackageManager", "queryIntentActivities", packageManager, new Object[]{intent, Integer.valueOf(i)}, "java.util.List", new ExtraInfo(false, "(Landroid/content/Intent;I)Ljava/util/List;"));
        return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : packageManager.queryIntentActivities(intent, i);
    }

    @Override // com.tencent.tinker.lib.am.BinderProvider
    protected IBinder onBind() {
        return new PluginAMBinder();
    }

    static {
        Covode.recordClassIndex(653728);
        sOncreated = false;
    }

    @Override // com.tencent.tinker.lib.am.BinderProvider, android.content.ContentProvider
    public boolean onCreate() {
        if (!sOncreated) {
            MuteLog.i("Mute.AMP", "onCreate", new Object[0]);
            MuteBoostExecutor.boostSerial(new Runnable() { // from class: com.tencent.tinker.lib.am.PatchActivityManagerProvider.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PatchActivityManagerProvider.this.init();
                    } catch (Throwable th) {
                        MuteLog.e("Mute.AMP", "onCreate init failed !! %s", th);
                    }
                }
            });
            sOncreated = true;
        }
        return super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitFor() {
        if (!this.mInited.get()) {
            synchronized (this.mWaitLock) {
                try {
                    this.mWaitLock.wait();
                } catch (InterruptedException e) {
                    MuteLog.e("Mute.AMP", "waitFor failed. %s", e);
                }
            }
        }
    }

    private class PluginAMBinder extends IPluginActivityManager.Stub {
        static {
            Covode.recordClassIndex(653729);
        }

        private static List com_tencent_tinker_lib_am_PatchActivityManagerProvider$PluginAMBinder_android_app_ActivityManager_getRunningAppProcesses(ActivityManager activityManager) {
            Result preInvoke = new HeliosApiHook().preInvoke(101303, "android/app/ActivityManager", "getRunningAppProcesses", activityManager, new Object[0], "java.util.List", new ExtraInfo(false, "()Ljava/util/List;"));
            return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : activityManager.getRunningAppProcesses();
        }

        private final class AppDeathRecipient implements IBinder.DeathRecipient {
            private IApplicationThread mAppThread;
            private int mPid;
            private String mProcessName;

            static {
                Covode.recordClassIndex(653730);
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                synchronized (PatchActivityManagerProvider.this) {
                    Iterator<Map.Entry<String, ProcessRecord>> it2 = PatchActivityManagerProvider.this.mBusyProcesses.entrySet().iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        Map.Entry<String, ProcessRecord> next = it2.next();
                        ProcessRecord value = next.getValue();
                        if (value.mPid != this.mPid && !TextUtils.equals(value.mProcessName, this.mProcessName)) {
                            i += value.mRunningActivities.size();
                        }
                        MuteLog.w("Mute.AMP", "process has died, pid = " + this.mPid, new Object[0]);
                        value.reset();
                        it2.remove();
                        PatchActivityManagerProvider.this.mSpareProcesses.put(next.getKey(), value);
                    }
                    if (i == 0 && Build.VERSION.SDK_INT < 29) {
                        KeepAlive.stop();
                    }
                }
            }

            public AppDeathRecipient(IApplicationThread iApplicationThread, String str, int i) {
                this.mAppThread = iApplicationThread;
                this.mProcessName = str;
                this.mPid = i;
            }
        }

        private void scheduleGc() {
            ActivityManager activityManager = (ActivityManager) PatchActivityManagerProvider.this.getContext().getSystemService("activity");
            if (activityManager == null) {
                return;
            }
            List<ActivityManager.RunningAppProcessInfo> com_tencent_tinker_lib_am_PatchActivityManagerProvider$PluginAMBinder_android_app_ActivityManager_getRunningAppProcesses = com_tencent_tinker_lib_am_PatchActivityManagerProvider$PluginAMBinder_android_app_ActivityManager_getRunningAppProcesses(activityManager);
            Iterator it2 = com_tencent_tinker_lib_am_PatchActivityManagerProvider$PluginAMBinder_android_app_ActivityManager_getRunningAppProcesses.iterator();
            while (it2.hasNext()) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) it2.next();
                Set<String> keySet = PatchActivityManagerProvider.this.mBusyProcesses.keySet();
                if (runningAppProcessInfo.uid != Process.myUid() || !keySet.contains(runningAppProcessInfo.processName) || runningAppProcessInfo.pid == Process.myPid()) {
                    it2.remove();
                }
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : com_tencent_tinker_lib_am_PatchActivityManagerProvider$PluginAMBinder_android_app_ActivityManager_getRunningAppProcesses) {
                int i = runningAppProcessInfo2.importance;
                if (i == 1000 || i == 500 || i == 400 || i == 300) {
                    doGc(runningAppProcessInfo2);
                }
            }
        }

        private void ensureStubProcessAlive() {
            ActivityManager activityManager;
            if (PatchActivityManagerProvider.this.mBusyProcesses.isEmpty() || (activityManager = (ActivityManager) PatchActivityManagerProvider.this.getContext().getSystemService("activity")) == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            Iterator it2 = com_tencent_tinker_lib_am_PatchActivityManagerProvider$PluginAMBinder_android_app_ActivityManager_getRunningAppProcesses(activityManager).iterator();
            while (it2.hasNext()) {
                hashSet.add(((ActivityManager.RunningAppProcessInfo) it2.next()).processName);
            }
            Iterator<Map.Entry<String, ProcessRecord>> it4 = PatchActivityManagerProvider.this.mBusyProcesses.entrySet().iterator();
            while (it4.hasNext()) {
                Map.Entry<String, ProcessRecord> next = it4.next();
                if (!hashSet.contains(next.getKey())) {
                    ProcessRecord value = next.getValue();
                    value.reset();
                    it4.remove();
                    PatchActivityManagerProvider.this.mSpareProcesses.put(next.getKey(), value);
                    if (PatchActivityManagerProvider.this.mBusyProcesses.size() == 0 && Build.VERSION.SDK_INT < 29) {
                        KeepAlive.stop();
                    }
                }
            }
        }

        private PluginAMBinder() {
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public String getStubProcessName(String str) throws RemoteException {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (PatchActivityManagerProvider.this.mTargetStubProcessMap.containsKey(str)) {
                return PatchActivityManagerProvider.this.mTargetStubProcessMap.get(str);
            }
            MuteLog.d("Mute.AMP", "getStubProcessName fail, target:" + str, new Object[0]);
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public String getTargetProcessName(String str) throws RemoteException {
            if (!TextUtils.isEmpty(str) && PatchActivityManagerProvider.this.mTargetStubProcessMap.containsValue(str)) {
                for (String str2 : PatchActivityManagerProvider.this.mTargetStubProcessMap.keySet()) {
                    if (str.equals(PatchActivityManagerProvider.this.mTargetStubProcessMap.get(str2))) {
                        return str2;
                    }
                }
            }
            return null;
        }

        private void ensureStubProcessDied(ProcessRecord processRecord) {
            MuteLog.d("Mute.AMP", "ensureStubProcessDied", new Object[0]);
            ActivityManager activityManager = (ActivityManager) PatchActivityManagerProvider.this.getContext().getSystemService("activity");
            if (activityManager != null && !processRecord.mIsMainProcess) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : com_tencent_tinker_lib_am_PatchActivityManagerProvider$PluginAMBinder_android_app_ActivityManager_getRunningAppProcesses(activityManager)) {
                    if (TextUtils.equals(runningAppProcessInfo.processName, processRecord.mProcessName)) {
                        try {
                            if (!Build.BRAND.toLowerCase().equals("oppo")) {
                                Process.killProcess(runningAppProcessInfo.pid);
                                ThreadMonitor.sleepMonitor(50L);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized ServiceInfo getTargetService(ServiceInfo serviceInfo) {
            ArrayList<ServiceInfo> arrayList;
            ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(serviceInfo.processName);
            if (processRecord != null && processRecord.mRunningServices.containsKey(serviceInfo.name) && (arrayList = processRecord.mRunningServices.get(serviceInfo.name)) != null && arrayList.size() > 0) {
                MuteLog.i("Mute.AMP", "getTargetService, " + serviceInfo + " >>> " + arrayList.get(0), new Object[0]);
                return arrayList.get(0);
            }
            MuteLog.i("Mute.AMP", "getTargetService, " + serviceInfo + " >>> null", new Object[0]);
            return null;
        }

        private void doGc(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
            ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(runningAppProcessInfo.processName);
            if (processRecord != null) {
                Iterator it2 = new HashSet(processRecord.mRunningServices.entrySet()).iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (entry != null && ((ArrayList) entry.getValue()).size() == 0) {
                        it2.remove();
                        for (ServiceInfo serviceInfo : processRecord.mStubServices.values()) {
                            if (TextUtils.equals(serviceInfo.name, (CharSequence) entry.getKey())) {
                                Intent intent = new Intent();
                                intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                                PatchActivityManagerProvider.this.getContext().stopService(intent);
                            }
                        }
                    }
                }
                if (processRecord.mRunningActivities.size() == 0 && processRecord.mRunningServices.size() == 0 && processRecord.mRunningReceivers.size() == 0 && processRecord.mRunningProviders.size() == 0) {
                    Message obtain = Message.obtain();
                    int i = processRecord.mPid;
                    if (i == 0) {
                        i = runningAppProcessInfo.pid;
                    }
                    obtain.what = 16777216 | i;
                    PatchActivityManagerProvider.this.mHandler.sendMessageDelayed(obtain, 30000L);
                }
            }
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized boolean isStubActivity(ActivityInfo activityInfo) {
            Iterator<ProcessRecord> it2 = PatchActivityManagerProvider.this.mBusyProcesses.values().iterator();
            while (it2.hasNext()) {
                if (it2.next().mStubActivities.get(activityInfo.name) != null) {
                    MuteLog.d("Mute.AMP", "isStubActivity, " + activityInfo.name + "=true", new Object[0]);
                    return true;
                }
            }
            Iterator<ProcessRecord> it4 = PatchActivityManagerProvider.this.mSpareProcesses.values().iterator();
            while (it4.hasNext()) {
                if (it4.next().mStubActivities.get(activityInfo.name) != null) {
                    MuteLog.d("Mute.AMP", "isStubActivity, " + activityInfo.name + "=true", new Object[0]);
                    return true;
                }
            }
            MuteLog.d("Mute.AMP", "isStubActivity, " + activityInfo.name + "=false", new Object[0]);
            return false;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized boolean isStubProvider(ProviderInfo providerInfo) {
            Iterator<ProcessRecord> it2 = PatchActivityManagerProvider.this.mBusyProcesses.values().iterator();
            while (it2.hasNext()) {
                if (it2.next().mStubProviders.get(providerInfo.name) != null) {
                    MuteLog.d("Mute.AMP", "isStubProvider, " + providerInfo.name + "=true", new Object[0]);
                    return true;
                }
            }
            Iterator<ProcessRecord> it4 = PatchActivityManagerProvider.this.mSpareProcesses.values().iterator();
            while (it4.hasNext()) {
                if (it4.next().mStubProviders.get(providerInfo.name) != null) {
                    MuteLog.d("Mute.AMP", "isStubProvider, " + providerInfo.name + "=true", new Object[0]);
                    return true;
                }
            }
            MuteLog.d("Mute.AMP", "isStubProvider, " + providerInfo.name + "=false", new Object[0]);
            return false;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized boolean isStubReceiver(ActivityInfo activityInfo) {
            Iterator<ProcessRecord> it2 = PatchActivityManagerProvider.this.mBusyProcesses.values().iterator();
            while (it2.hasNext()) {
                if (it2.next().mStubReceivers.get(activityInfo.name) != null) {
                    MuteLog.d("Mute.AMP", "isStubReceiver, " + activityInfo.name + "=true", new Object[0]);
                    return true;
                }
            }
            Iterator<ProcessRecord> it4 = PatchActivityManagerProvider.this.mSpareProcesses.values().iterator();
            while (it4.hasNext()) {
                if (it4.next().mStubReceivers.get(activityInfo.name) != null) {
                    MuteLog.d("Mute.AMP", "isStubReceiver, " + activityInfo.name + "=true", new Object[0]);
                    return true;
                }
            }
            MuteLog.d("Mute.AMP", "isStubReceiver, " + activityInfo.name + "=false", new Object[0]);
            return false;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized boolean isStubService(ServiceInfo serviceInfo) {
            Iterator<ProcessRecord> it2 = PatchActivityManagerProvider.this.mBusyProcesses.values().iterator();
            while (it2.hasNext()) {
                if (it2.next().mStubServices.get(serviceInfo.name) != null) {
                    MuteLog.d("Mute.AMP", "isStubService, " + serviceInfo.name + "=true", new Object[0]);
                    return true;
                }
            }
            Iterator<ProcessRecord> it4 = PatchActivityManagerProvider.this.mSpareProcesses.values().iterator();
            while (it4.hasNext()) {
                if (it4.next().mStubServices.get(serviceInfo.name) != null) {
                    MuteLog.d("Mute.AMP", "isStubService, " + serviceInfo.name + "=true", new Object[0]);
                    return true;
                }
            }
            MuteLog.d("Mute.AMP", "isStubService, " + serviceInfo.name + "=false", new Object[0]);
            return false;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized ActivityInfo selectStubActivity(ActivityInfo activityInfo) {
            ActivityInfo selectStubActivity;
            PatchActivityManagerProvider.this.waitFor();
            scheduleGc();
            ensureStubProcessAlive();
            String matchStubProcess = PatchActivityManagerProvider.this.getMatchStubProcess(activityInfo.processName);
            if (!TextUtils.isEmpty(matchStubProcess)) {
                ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(matchStubProcess);
                if (processRecord != null && (selectStubActivity = processRecord.selectStubActivity(activityInfo)) != null) {
                    PatchActivityManagerProvider.this.mHandler.removeMessages(processRecord.mPid | 16777216);
                    MuteLog.d("Mute.AMP", "selectStubActivity from mBusyProcesses, " + activityInfo + " <<< " + selectStubActivity, new Object[0]);
                    return selectStubActivity;
                }
                ProcessRecord processRecord2 = PatchActivityManagerProvider.this.mSpareProcesses.get(matchStubProcess);
                if (processRecord2 != null) {
                    ActivityInfo selectStubActivity2 = processRecord2.selectStubActivity(activityInfo);
                    ensureStubProcessDied(processRecord2);
                    PatchActivityManagerProvider.this.mSpareProcesses.remove(processRecord2.mProcessName);
                    PatchActivityManagerProvider.this.mBusyProcesses.put(processRecord2.mProcessName, processRecord2);
                    MuteLog.d("Mute.AMP", "selectStubActivity from mSpareProcesses, " + activityInfo + " <<< " + selectStubActivity2, new Object[0]);
                    return selectStubActivity2;
                }
            }
            MuteLog.d("Mute.AMP", "selectStubActivity null, " + activityInfo, new Object[0]);
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized ProviderInfo selectStubProvider(ProviderInfo providerInfo) {
            ProviderInfo selectStubProvider;
            PatchActivityManagerProvider.this.waitFor();
            scheduleGc();
            ensureStubProcessAlive();
            String matchStubProcess = PatchActivityManagerProvider.this.getMatchStubProcess(providerInfo.processName);
            if (!TextUtils.isEmpty(matchStubProcess)) {
                ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(matchStubProcess);
                if (processRecord != null && (selectStubProvider = processRecord.selectStubProvider(providerInfo)) != null) {
                    PatchActivityManagerProvider.this.mHandler.removeMessages(processRecord.mPid | 16777216);
                    MuteLog.d("Mute.AMP", "selectStubProvider from mBusyProcesses, " + providerInfo + " <<< " + selectStubProvider, new Object[0]);
                    return selectStubProvider;
                }
                ProcessRecord processRecord2 = PatchActivityManagerProvider.this.mSpareProcesses.get(matchStubProcess);
                if (processRecord2 != null) {
                    ProviderInfo selectStubProvider2 = processRecord2.selectStubProvider(providerInfo);
                    ensureStubProcessDied(processRecord2);
                    PatchActivityManagerProvider.this.mSpareProcesses.remove(processRecord2.mProcessName);
                    PatchActivityManagerProvider.this.mBusyProcesses.put(processRecord2.mProcessName, processRecord2);
                    MuteLog.d("Mute.AMP", "selectStubProvider from mSpareProcesses, " + providerInfo + " <<< " + selectStubProvider2, new Object[0]);
                    return selectStubProvider2;
                }
            }
            MuteLog.d("Mute.AMP", "selectStubProvider null, " + providerInfo, new Object[0]);
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized ActivityInfo selectStubReceiver(ActivityInfo activityInfo) {
            ActivityInfo selectStubReceiver;
            PatchActivityManagerProvider.this.waitFor();
            scheduleGc();
            ensureStubProcessAlive();
            String matchStubProcess = PatchActivityManagerProvider.this.getMatchStubProcess(activityInfo.processName);
            if (!TextUtils.isEmpty(matchStubProcess)) {
                ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(matchStubProcess);
                if (processRecord != null && (selectStubReceiver = processRecord.selectStubReceiver(activityInfo)) != null) {
                    PatchActivityManagerProvider.this.mHandler.removeMessages(processRecord.mPid | 16777216);
                    MuteLog.d("Mute.AMP", "selectStubReceiver from mBusyStubProcesses, " + activityInfo + " <<< " + selectStubReceiver, new Object[0]);
                    return selectStubReceiver;
                }
                ProcessRecord processRecord2 = PatchActivityManagerProvider.this.mSpareProcesses.get(matchStubProcess);
                if (processRecord2 != null) {
                    ActivityInfo selectStubReceiver2 = processRecord2.selectStubReceiver(activityInfo);
                    ensureStubProcessDied(processRecord2);
                    PatchActivityManagerProvider.this.mSpareProcesses.remove(processRecord2.mProcessName);
                    PatchActivityManagerProvider.this.mBusyProcesses.put(processRecord2.mProcessName, processRecord2);
                    MuteLog.d("Mute.AMP", "selectStubReceiver from mSpareProcesses, " + activityInfo + " <<< " + selectStubReceiver2, new Object[0]);
                    return selectStubReceiver2;
                }
            }
            MuteLog.d("Mute.AMP", "selectStubReceiver null, " + activityInfo, new Object[0]);
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized ServiceInfo selectStubService(ServiceInfo serviceInfo) {
            ServiceInfo selectStubService;
            PatchActivityManagerProvider.this.waitFor();
            scheduleGc();
            ensureStubProcessAlive();
            String matchStubProcess = PatchActivityManagerProvider.this.getMatchStubProcess(serviceInfo.processName);
            if (!TextUtils.isEmpty(matchStubProcess)) {
                ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(matchStubProcess);
                if (processRecord != null && (selectStubService = processRecord.selectStubService(serviceInfo)) != null) {
                    PatchActivityManagerProvider.this.mHandler.removeMessages(processRecord.mPid | 16777216);
                    MuteLog.d("Mute.AMP", "selectStubService from mBusyProcesses, " + serviceInfo + " <<< " + selectStubService, new Object[0]);
                    return selectStubService;
                }
                ProcessRecord processRecord2 = PatchActivityManagerProvider.this.mSpareProcesses.get(matchStubProcess);
                if (processRecord2 != null) {
                    ServiceInfo selectStubService2 = processRecord2.selectStubService(serviceInfo);
                    ensureStubProcessDied(processRecord2);
                    PatchActivityManagerProvider.this.mSpareProcesses.remove(processRecord2.mProcessName);
                    PatchActivityManagerProvider.this.mBusyProcesses.put(processRecord2.mProcessName, processRecord2);
                    MuteLog.d("Mute.AMP", "selectStubService from mSpareProcesses, " + serviceInfo + " <<< " + selectStubService2, new Object[0]);
                    return selectStubService2;
                }
            }
            MuteLog.d("Mute.AMP", "selectStubService null, " + serviceInfo, new Object[0]);
            return null;
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized void receiverFinished(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
            MuteLog.d("Mute.AMP", "receiverFinished, " + activityInfo2 + " <<< " + activityInfo, new Object[0]);
            ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(activityInfo.processName);
            if (processRecord != null) {
                processRecord.removeReceiver(activityInfo, activityInfo2);
            }
            scheduleGc();
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized void serviceCreated(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
            MuteLog.d("Mute.AMP", "serviceCreated, " + serviceInfo2 + " <<< " + serviceInfo, new Object[0]);
            ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(serviceInfo.processName);
            if (processRecord != null && !processRecord.hasRunningService(serviceInfo2)) {
                processRecord.addService(serviceInfo, serviceInfo2);
            }
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized void serviceDestroy(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
            MuteLog.d("Mute.AMP", "serviceDestroy, " + serviceInfo2 + " <<< " + serviceInfo, new Object[0]);
            ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(serviceInfo.processName);
            if (processRecord != null) {
                processRecord.removeService(serviceInfo, serviceInfo2);
            }
            scheduleGc();
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized void activityCreated(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
            MuteLog.d("Mute.AMP", "activityCreated, " + activityInfo2 + " <<< " + activityInfo, new Object[0]);
            ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(activityInfo.processName);
            if (processRecord != null && !processRecord.hasRunningActivity(activityInfo2)) {
                processRecord.addActivity(activityInfo, activityInfo2);
            }
            if (processRecord != null && !processRecord.mIsMainProcess && Build.VERSION.SDK_INT < 29) {
                KeepAlive.start();
            }
        }

        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        public synchronized void activityDestroy(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
            int i = 0;
            MuteLog.d("Mute.AMP", "activityDestroy, " + activityInfo2 + " <<< " + activityInfo, new Object[0]);
            ProcessRecord processRecord = PatchActivityManagerProvider.this.mBusyProcesses.get(activityInfo.processName);
            if (processRecord != null) {
                processRecord.removeActivity(activityInfo, activityInfo2);
            }
            for (ProcessRecord processRecord2 : PatchActivityManagerProvider.this.mBusyProcesses.values()) {
                if (!processRecord2.mIsMainProcess) {
                    i += processRecord2.mRunningActivities.size();
                }
            }
            if (i == 0 && Build.VERSION.SDK_INT < 29) {
                KeepAlive.stop();
            }
            scheduleGc();
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0083, code lost:
        
            r1.mPid = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0085, code lost:
        
            if (r11 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x008b, code lost:
        
            if (r10 == android.os.Process.myPid()) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x008f, code lost:
        
            if (r1.mDeathRecipient != null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
        
            r0 = new com.tencent.tinker.lib.am.PatchActivityManagerProvider.PluginAMBinder.AppDeathRecipient(r7, r11, r9, r10);
            r11.asBinder().linkToDeath(r0, 0);
            r1.mDeathRecipient = r0;
            com.tencent.tinker.lib.MuteLog.i("Mute.AMP", "applicationCreated, linkToDeath from busyProcess, pid = " + r10 + ", " + r8.packageName, new java.lang.Object[0]);
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00c2, code lost:
        
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00c3, code lost:
        
            com.tencent.tinker.lib.MuteLog.e("Mute.AMP", "applicationCreated linkToDeath failed, processRecord = %s, %s", r1, r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d2, code lost:
        
            r0 = r7.this$0.mSpareProcesses.get(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00dc, code lost:
        
            if (r0 == null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00de, code lost:
        
            r0.mPid = r10;
            r7.this$0.mSpareProcesses.remove(r9);
            r7.this$0.mBusyProcesses.put(r0.mProcessName, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00f0, code lost:
        
            if (r11 == null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00f6, code lost:
        
            if (r10 == android.os.Process.myPid()) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00fa, code lost:
        
            if (r0.mDeathRecipient != null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00fc, code lost:
        
            r1 = new com.tencent.tinker.lib.am.PatchActivityManagerProvider.PluginAMBinder.AppDeathRecipient(r7, r11, r9, r10);
            r11.asBinder().linkToDeath(r1, 0);
            r0.mDeathRecipient = r1;
            com.tencent.tinker.lib.MuteLog.i("Mute.AMP", "applicationCreated, linkToDeath from stubProcess, pid = " + r10 + ", " + r8.packageName, new java.lang.Object[0]);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x012d, code lost:
        
            r8 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x012e, code lost:
        
            com.tencent.tinker.lib.MuteLog.e("Mute.AMP", "applicationCreated from mSpareProcesses linkToDeath failed, processRecord = %s, %s", r0, r8);
         */
        @Override // com.tencent.tinker.lib.am.IPluginActivityManager
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized void applicationCreated(android.content.pm.ApplicationInfo r8, java.lang.String r9, int r10, com.tencent.tinker.lib.am.IApplicationThread r11) {
            /*
                Method dump skipped, instructions count: 320
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.am.PatchActivityManagerProvider.PluginAMBinder.applicationCreated(android.content.pm.ApplicationInfo, java.lang.String, int, com.tencent.tinker.lib.am.IApplicationThread):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        String str;
        Intent intent = new Intent();
        intent.setAction("com.intent.action.ACTION_STUB_PATCH");
        intent.addCategory("com.intent.category.PATCH_DEFAULT");
        intent.setPackage(getContext().getPackageName());
        List com_tencent_tinker_lib_am_PatchActivityManagerProvider_android_content_pm_PackageManager_queryIntentActivities = com_tencent_tinker_lib_am_PatchActivityManagerProvider_android_content_pm_PackageManager_queryIntentActivities(getContext().getPackageManager(), intent, 0);
        if (com_tencent_tinker_lib_am_PatchActivityManagerProvider_android_content_pm_PackageManager_queryIntentActivities != null && com_tencent_tinker_lib_am_PatchActivityManagerProvider_android_content_pm_PackageManager_queryIntentActivities.size() > 0) {
            Iterator it2 = com_tencent_tinker_lib_am_PatchActivityManagerProvider_android_content_pm_PackageManager_queryIntentActivities.iterator();
            while (it2.hasNext()) {
                ActivityInfo activityInfo = ((ResolveInfo) it2.next()).activityInfo;
                if (activityInfo.name.matches("\\bcom.tencent.tinker.lib.stub.p[0-9].Stub\\S+Activity[0-9]*\\b")) {
                    ProcessRecord processRecord = this.mSpareProcesses.get(activityInfo.processName);
                    if (processRecord == null) {
                        processRecord = new ProcessRecord(activityInfo.processName, getContext());
                        this.mSpareProcesses.put(activityInfo.processName, processRecord);
                    }
                    if (!processRecord.mStubActivities.containsKey(activityInfo.name)) {
                        processRecord.mStubActivities.put(activityInfo.name, activityInfo);
                    }
                }
            }
        }
        List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            Iterator<ResolveInfo> it4 = queryIntentServices.iterator();
            while (it4.hasNext()) {
                ServiceInfo serviceInfo = it4.next().serviceInfo;
                if (serviceInfo.name.matches("\\bcom.tencent.tinker.lib.stub.p[0-9]+.StubService[0-9]+\\b")) {
                    ProcessRecord processRecord2 = this.mSpareProcesses.get(serviceInfo.processName);
                    if (processRecord2 == null) {
                        processRecord2 = new ProcessRecord(serviceInfo.processName, getContext());
                        this.mSpareProcesses.put(serviceInfo.processName, processRecord2);
                    }
                    if (!processRecord2.mStubServices.containsKey(serviceInfo.name)) {
                        processRecord2.mStubServices.put(serviceInfo.name, serviceInfo);
                    }
                }
            }
        }
        try {
            ActivityInfo[] activityInfoArr = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 2).receivers;
            if (activityInfoArr != null && activityInfoArr.length > 0) {
                for (ActivityInfo activityInfo2 : activityInfoArr) {
                    String str2 = activityInfo2.name;
                    if (str2 != null && str2.matches("\\bcom.tencent.tinker.lib.stub.[_a-zA-Z0-9]+.StubReceiver+\\b")) {
                        ProcessRecord processRecord3 = this.mSpareProcesses.get(activityInfo2.processName);
                        if (processRecord3 == null) {
                            processRecord3 = new ProcessRecord(activityInfo2.processName, getContext());
                            this.mSpareProcesses.put(activityInfo2.processName, processRecord3);
                        }
                        if (!processRecord3.mStubReceivers.containsKey(activityInfo2.name)) {
                            processRecord3.mStubReceivers.put(activityInfo2.name, activityInfo2);
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            MuteLog.e("Mute.AMP", "init StubProvider failed. %s", e);
        }
        try {
            ProviderInfo[] providerInfoArr = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 8).providers;
            if (providerInfoArr != null && providerInfoArr.length > 0) {
                String str3 = getContext().getPackageName() + ".stub.[_a-zA-Z0-9]+.STUB_AUTHORITY";
                for (ProviderInfo providerInfo : providerInfoArr) {
                    String str4 = providerInfo.authority;
                    if ((str4 != null && str4.matches(str3)) || ((str = providerInfo.name) != null && str.matches("\\bcom.tencent.tinker.lib.stub.[_a-zA-Z0-9]+.StubContentProvider+\\b"))) {
                        ProcessRecord processRecord4 = this.mSpareProcesses.get(providerInfo.processName);
                        if (processRecord4 == null) {
                            processRecord4 = new ProcessRecord(providerInfo.processName, getContext());
                            this.mSpareProcesses.put(providerInfo.processName, processRecord4);
                        }
                        if (!processRecord4.mStubProviders.containsKey(providerInfo.name)) {
                            processRecord4.mStubProviders.put(providerInfo.name, providerInfo);
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            MuteLog.e("Mute.AMP", "init StubProvider failed. %s", e2);
        }
        this.mTargetStubProcessMap.put(getContext().getPackageName(), getContext().getPackageName());
        try {
            Set<String> incProcessSet = PatchPackageManager.getIncProcessSet();
            if (incProcessSet != null && incProcessSet.size() > 0) {
                Iterator<ProcessRecord> it5 = this.mSpareProcesses.values().iterator();
                for (String str5 : incProcessSet) {
                    while (true) {
                        if (it5.hasNext()) {
                            ProcessRecord next = it5.next();
                            if (next.mIsMainProcess) {
                                Map<String, String> map = this.mTargetStubProcessMap;
                                String str6 = next.mProcessName;
                                map.put(str6, str6);
                            } else {
                                this.mTargetStubProcessMap.put(str5, next.mProcessName);
                                break;
                            }
                        }
                    }
                }
            }
            this.mInited.set(true);
            MuteLog.i("Mute.AMP", "init mSpareProcesses : " + this.mSpareProcesses.size(), new Object[0]);
            synchronized (this.mWaitLock) {
                this.mWaitLock.notifyAll();
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMatchStubProcess(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getContext().getPackageName();
        } else if (str.startsWith(":")) {
            str = getContext().getPackageName() + str;
        }
        return this.mTargetStubProcessMap.get(str);
    }
}
