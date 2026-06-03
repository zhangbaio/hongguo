package com.dragon.read.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.ActivityRecordHelper;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ProcessUtils;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.network.NetworkStatusManager;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NetworkStatusManager implements NetworkUtils.NetworkTypeInterceptor {
    private static final NetworkStatusManager instance;
    private boolean hasInit = false;
    private volatile c networkStatus = new c();
    private final List<WeakReference<com.dragon.read.network.a>> mListener = new ArrayList();
    private final Object listenerLock = new Object();
    private String preNetWordStatusStr = "";

    public static NetworkStatusManager getInstance() {
        return instance;
    }

    public static class c {
        public NetworkUtils.NetworkType a;
        public boolean b;
        public int c;

        static {
            Covode.recordClassIndex(612446);
        }

        public boolean b() {
            return this.a.isAvailable();
        }

        public c() {
            this.a = NetworkUtils.NetworkType.UNKNOWN;
            this.b = false;
            this.c = 0;
        }

        public String toString() {
            return "NetworkStatus{" + this.a.name() + ", " + this.b + "}";
        }

        public c(NetworkUtils.NetworkType networkType, boolean z, int i) {
            NetworkUtils.NetworkType networkType2 = NetworkUtils.NetworkType.UNKNOWN;
            this.a = networkType;
            this.b = z;
            this.c = i;
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ Context a;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            NetworkStatusManager.this.updateNetworkStatus(AppUtils.context());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            LogWrapper.info("NetworkStatusManager", "callback onLost", new Object[0]);
            NetworkStatusManager.this.updateNetworkStatus(AppUtils.context());
        }

        b(Context context) {
            this.a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities.hasCapability(16)) {
                if (networkCapabilities.hasTransport(1)) {
                    LogWrapper.info("NetworkStatusManager", "callback WIFI", new Object[0]);
                    NetworkStatusManager.this.setNetworkStatus(new c(NetworkUtils.NetworkType.WIFI, true, networkCapabilities.getLinkDownstreamBandwidthKbps()));
                } else {
                    LogWrapper.info("NetworkStatusManager", "callback MOBILE", new Object[0]);
                    NetworkStatusManager.this.setNetworkStatus(new c(NetworkStatusManager.this.parseMobileType(l3.a.p((TelephonyManager) this.a.getSystemService("phone"))), true, networkCapabilities.getLinkDownstreamBandwidthKbps()));
                }
            }
            ThreadUtils.postInBackground(new Runnable() { // from class: com.dragon.read.network.b
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkStatusManager.b.this.b();
                }
            });
        }
    }

    static {
        Covode.recordClassIndex(612445);
        instance = new NetworkStatusManager();
    }

    public static boolean isNetworkConnected() {
        return getInstance().getNetworkStatus(AppUtils.context()).b;
    }

    public int getNetworkDownSpeed() {
        return getInstance().getNetworkStatus(AppUtils.context()).c;
    }

    public NetworkUtils.NetworkType getNetworkType() {
        return getNetworkStatus(AppUtils.context()).a;
    }

    private NetworkStatusManager() {
    }

    public static void interceptNetworkUtils() {
        NetworkUtils.setNetworkTypeInterceptor(getInstance());
        NetworkUtils.setUseCheckNetworkFast(true);
        LogWrapper.info("NetworkStatusManager", "interceptNetworkUtils open", new Object[0]);
    }

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction()) || "android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                LogWrapper.info("NetworkStatusManager", "broadcast " + intent.getAction(), new Object[0]);
                NetworkStatusManager.this.updateNetworkStatus(AppUtils.context());
            }
        }
    }

    public c updateNetworkStatus(Context context) {
        c actualNetworkStatus = getActualNetworkStatus(context);
        setNetworkStatus(actualNetworkStatus);
        return actualNetworkStatus;
    }

    public void addListener(com.dragon.read.network.a aVar) {
        synchronized (this.listenerLock) {
            addListenerInner(aVar);
        }
    }

    public void removeListener(com.dragon.read.network.a aVar) {
        synchronized (this.listenerLock) {
            removeListenerInner(aVar);
        }
    }

    private void checkInit(Context context) {
        if (!this.hasInit) {
            updateNetworkStatus(context);
            registerNetworkChange(context);
            registerCallback(context);
            LogWrapper.info("NetworkStatusManager", "init successfully!", new Object[0]);
            this.hasInit = true;
        }
    }

    private c getCachedNetworkStatus(Context context) {
        if (!this.networkStatus.b() || !this.networkStatus.b) {
            updateNetworkStatus(context);
        }
        return this.networkStatus;
    }

    private void removeListenerInner(com.dragon.read.network.a aVar) {
        WeakReference<com.dragon.read.network.a> weakReference;
        Iterator<WeakReference<com.dragon.read.network.a>> it2 = this.mListener.iterator();
        while (true) {
            if (it2.hasNext()) {
                weakReference = it2.next();
                if (weakReference.get() == aVar) {
                    break;
                }
            } else {
                weakReference = null;
                break;
            }
        }
        this.mListener.remove(weakReference);
    }

    private void addListenerInner(com.dragon.read.network.a aVar) {
        Iterator<WeakReference<com.dragon.read.network.a>> it2 = this.mListener.iterator();
        while (it2.hasNext()) {
            if (it2.next().get() == aVar) {
                return;
            }
        }
        this.mListener.add(new WeakReference<>(aVar));
    }

    private void callBackNetWorkStatus(c cVar) {
        com.dragon.read.network.a aVar;
        for (int i = 0; i < this.mListener.size(); i++) {
            WeakReference<com.dragon.read.network.a> weakReference = this.mListener.get(i);
            if (weakReference != null && (aVar = weakReference.get()) != null) {
                aVar.a(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NetworkUtils.NetworkType parseMobileType(int i) {
        if (i != 3) {
            if (i != 20) {
                if (i != 5 && i != 6) {
                    switch (i) {
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        case 9:
                        case 10:
                            break;
                        default:
                            switch (i) {
                                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                case 14:
                                case 15:
                                    break;
                                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                    return NetworkUtils.NetworkType.MOBILE_4G;
                                default:
                                    return NetworkUtils.NetworkType.MOBILE;
                            }
                    }
                }
            } else {
                return NetworkUtils.NetworkType.MOBILE_5G;
            }
        }
        return NetworkUtils.NetworkType.MOBILE_3G;
    }

    private void registerCallback(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            b bVar = new b(context);
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerDefaultNetworkCallback(bVar);
                }
            } catch (Exception e) {
                LogWrapper.warn("NetworkStatusManager", e.toString(), new Object[0]);
                e.printStackTrace();
            }
        }
    }

    private void registerNetworkChange(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        INVOKEVIRTUAL_com_dragon_read_network_NetworkStatusManager_com_dragon_read_aop_BroadcastAop_registerReceiver(context.getApplicationContext(), new a(), intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNetworkStatus(c cVar) {
        this.networkStatus = cVar;
        synchronized (this.listenerLock) {
            callBackNetWorkStatus(cVar);
        }
        String cVar2 = cVar.toString();
        if (!this.preNetWordStatusStr.equals(cVar2)) {
            this.preNetWordStatusStr = cVar2;
            LogWrapper.info("NetworkStatusManager", "update networkStatus ->" + cVar.toString(), new Object[0]);
        }
    }

    public c getNetworkStatus(Context context) {
        if (!ProcessUtils.isMainProcess(context)) {
            return getActualNetworkStatus(context);
        }
        if (!ThreadUtils.isMainThread()) {
            return updateNetworkStatus(context);
        }
        if (!ActivityRecordHelper.isForeground()) {
            return updateNetworkStatus(context);
        }
        checkInit(context);
        return getCachedNetworkStatus(context);
    }

    private c getActualNetworkStatus(Context context) {
        Network network;
        int i;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (Build.VERSION.SDK_INT >= 23) {
                network = connectivityManager.getActiveNetwork();
            } else {
                network = null;
            }
            if (network != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) != null) {
                i = networkCapabilities.getLinkDownstreamBandwidthKbps();
            } else {
                i = 0;
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return new c(NetworkUtils.NetworkType.WIFI, activeNetworkInfo.isConnected(), i);
                }
                if (type == 0) {
                    return new c(parseMobileType(l3.a.p((TelephonyManager) context.getSystemService("phone"))), activeNetworkInfo.isConnected(), i);
                }
                return new c(NetworkUtils.NetworkType.MOBILE, activeNetworkInfo.isConnected(), i);
            }
            return new c(NetworkUtils.NetworkType.NONE, false, i);
        } catch (Throwable unused) {
            LogWrapper.info("NetworkStatusManager", "getNetworkTypeIntern failed!", new Object[0]);
            return new c(NetworkUtils.NetworkType.MOBILE, false, 0);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_dragon_read_network_NetworkStatusManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
            throw e;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static Intent INVOKEVIRTUAL_com_dragon_read_network_NetworkStatusManager_com_dragon_read_aop_BroadcastAop_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34) {
            if (!(context instanceof Context)) {
                context = null;
            }
            if (context == null) {
                return null;
            }
            LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
            return ContextCompat.registerReceiver(context, broadcastReceiver, filter, 2);
        }
        return INVOKEVIRTUAL_com_dragon_read_network_NetworkStatusManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, filter);
    }
}
