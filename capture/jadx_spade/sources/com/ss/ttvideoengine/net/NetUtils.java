package com.ss.ttvideoengine.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;
import l3.a;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NetUtils {
    public static long netUpdateTimeMs;
    private static final BroadcastReceiver networkReceiver;
    public static boolean registerNetworkReceiver;

    static {
        Covode.recordClassIndex(652585);
        netUpdateTimeMs = -1L;
        registerNetworkReceiver = false;
        networkReceiver = new BroadcastReceiver() { // from class: com.ss.ttvideoengine.net.NetUtils.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (isInitialStickyBroadcast() || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    return;
                }
                NetUtils.netUpdateTimeMs = System.currentTimeMillis();
            }
        };
    }

    public static boolean isNetAvailable(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static String getNetExtraInfo(Context context) {
        try {
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (networkInfo != null && networkInfo.isAvailable()) {
                return a.t(networkInfo);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int getNetType(Context context) {
        try {
            NetworkInfo networkInfo = getNetworkInfo(context);
            if (networkInfo != null && networkInfo.isAvailable()) {
                return networkInfo.getType();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public static void release(Context context) {
        try {
            BroadcastReceiver broadcastReceiver = networkReceiver;
            synchronized (broadcastReceiver) {
                if (registerNetworkReceiver && context != null) {
                    registerNetworkReceiver = false;
                    INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(context.getApplicationContext(), broadcastReceiver);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!registerNetworkReceiver) {
                BroadcastReceiver broadcastReceiver = networkReceiver;
                synchronized (broadcastReceiver) {
                    if (!registerNetworkReceiver) {
                        registerNetworkReceiver = true;
                        INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_dragon_read_aop_BroadcastAop_registerReceiver(context.getApplicationContext(), broadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    }
                }
            }
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_dragon_read_aop_BroadcastAop_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
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
        return INVOKEVIRTUAL_com_ss_ttvideoengine_net_NetUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, filter);
    }
}
