package com.tencent.tinker.lib.am;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.apm.agent.instrumentation.ThreadMonitor;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.Muter;
import com.tencent.tinker.lib.am.IPluginActivityManager;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class PatchActivityManager {
    private static String CONTENT_URI;
    private static IPluginActivityManager sInstance;
    private static volatile boolean sIsConnected;
    private static final Object sLockObject;

    static {
        Covode.recordClassIndex(653727);
        sIsConnected = false;
        sInstance = null;
        sLockObject = new Object();
    }

    private static IPluginActivityManager generatePluginActivityManager() {
        Context appContext = Muter.getAppContext();
        if (TextUtils.isEmpty(CONTENT_URI)) {
            CONTENT_URI = String.format("content://%s.mute.am.PAMP/call", appContext.getPackageName());
        }
        IBinder queryBinder = BinderProvider.queryBinder(appContext, Uri.parse(CONTENT_URI));
        if (queryBinder != null && queryBinder.isBinderAlive()) {
            try {
                queryBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.tencent.tinker.lib.am.PatchActivityManager.1
                    @Override // android.os.IBinder.DeathRecipient
                    public void binderDied() {
                        boolean unused = PatchActivityManager.sIsConnected = false;
                        MuteLog.w("Mute.AM", "generatePluginActivityManager binderDied.", new Object[0]);
                    }
                }, 0);
                sIsConnected = true;
                MuteLog.i("Mute.AM", "generatePluginActivityManager success.", new Object[0]);
                return IPluginActivityManager.Stub.asInterface(queryBinder);
            } catch (RemoteException e) {
                MuteLog.e("Mute.AM", "generatePluginPackageManager failed. %s", e);
                return null;
            }
        }
        return null;
    }

    private static IPluginActivityManager getInstance() {
        if (!sIsConnected) {
            sInstance = null;
        }
        if (sInstance == null) {
            synchronized (sLockObject) {
                int i = 0;
                while (true) {
                    if (sInstance != null) {
                        break;
                    }
                    if (i > 0) {
                        if (i > 3) {
                            MuteLog.w("Mute.AM", "connect host process failed.", new Object[0]);
                            break;
                        }
                        try {
                            ThreadMonitor.sleepMonitor(200L);
                        } catch (InterruptedException e) {
                            MuteLog.e("Mute.AM", "connect host InterruptedException.", e);
                        }
                        MuteLog.i("Mute.AM", "retry connect host process: " + i, new Object[0]);
                    }
                    sInstance = generatePluginActivityManager();
                    i++;
                }
            }
        }
        return sInstance;
    }

    public static String getStubProcessName(String str) {
        try {
            return getInstance().getStubProcessName(str);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "getStubProcessName failed. %s", e);
            return null;
        }
    }

    public static String getTargetProcessName(String str) {
        try {
            return getInstance().getTargetProcessName(str);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "getTargetProcessName failed. %s", e);
            return null;
        }
    }

    public static ServiceInfo getTargetService(ServiceInfo serviceInfo) {
        try {
            return getInstance().getTargetService(serviceInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "getTargetService failed. %s", e);
            return null;
        }
    }

    public static boolean isStubActivity(ActivityInfo activityInfo) {
        try {
            return getInstance().isStubActivity(activityInfo);
        } catch (Exception e) {
            MuteLog.w("Mute.AM", "isStubActivity failed. %s", e);
            return false;
        }
    }

    public static boolean isStubProvider(ProviderInfo providerInfo) {
        try {
            return getInstance().isStubProvider(providerInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "isStubProvider failed. %s", e);
            return false;
        }
    }

    public static boolean isStubReceiver(ActivityInfo activityInfo) {
        try {
            return getInstance().isStubReceiver(activityInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "isStubReceiver failed. %s", e);
            return false;
        }
    }

    public static boolean isStubService(ServiceInfo serviceInfo) {
        try {
            return getInstance().isStubService(serviceInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "isStubService failed. %s", e);
            return false;
        }
    }

    public static ActivityInfo selectStubActivity(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            MuteLog.e("Mute.AM", "selectStubActivity failed, empty targetActivityInfo.", new Object[0]);
            return null;
        }
        try {
            return getInstance().selectStubActivity(activityInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", " selectStubActivity failed. %s", e);
            return null;
        }
    }

    public static ProviderInfo selectStubProvider(ProviderInfo providerInfo) {
        if (providerInfo == null) {
            MuteLog.e("Mute.AM", "selectStubProvider failed, empty targetProviderInfo.", new Object[0]);
            return null;
        }
        try {
            return getInstance().selectStubProvider(providerInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "selectStubProvider failed. %s", e);
            return null;
        }
    }

    public static ActivityInfo selectStubReceiver(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            MuteLog.e("Mute.AM", "selectStubReceiver failed, empty targetReceiverInfo.", new Object[0]);
            return null;
        }
        try {
            return getInstance().selectStubReceiver(activityInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "selectStubReceiver failed. %s", e);
            return null;
        }
    }

    public static ServiceInfo selectStubService(ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            MuteLog.e("Mute.AM", "selectStubService failed, empty targetServiceInfo.", new Object[0]);
            return null;
        }
        try {
            return getInstance().selectStubService(serviceInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "selectStubService failed. %s", e);
            return null;
        }
    }

    public static void activityCreated(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        try {
            getInstance().activityCreated(activityInfo, activityInfo2);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "activityCreated failed. %s", e);
        }
    }

    public static void activityDestroy(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        try {
            getInstance().activityDestroy(activityInfo, activityInfo2);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "activityDestroy failed. %s", e);
        }
    }

    public static void receiverFinished(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        try {
            getInstance().receiverFinished(activityInfo, activityInfo2);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "receiverFinished failed. %s", e);
        }
    }

    public static void serviceCreated(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        try {
            getInstance().serviceCreated(serviceInfo, serviceInfo2);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "serviceCreated failed. %s", e);
        }
    }

    public static void serviceDestroy(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        try {
            getInstance().serviceDestroy(serviceInfo, serviceInfo2);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "serviceDestroy failed. %s", e);
        }
    }

    public static void applicationCreated(ApplicationInfo applicationInfo, String str, int i, IApplicationThread iApplicationThread) {
        try {
            getInstance().applicationCreated(applicationInfo, str, i, iApplicationThread);
        } catch (Exception e) {
            MuteLog.e("Mute.AM", "applicationCreated failed. %s", e);
        }
    }
}
