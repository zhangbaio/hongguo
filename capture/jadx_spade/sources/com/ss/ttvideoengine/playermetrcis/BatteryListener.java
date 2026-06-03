package com.ss.ttvideoengine.playermetrcis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BatteryListener {
    private BatteryStateListener mBatteryStateListener;
    private Context mContext;
    private boolean mInitialState;
    private BatteryBroadcastReceiver receiver = new BatteryBroadcastReceiver();

    public interface BatteryStateListener {
        void onStatePowerConnected();

        void onStatePowerDisconnected();
    }

    static {
        Covode.recordClassIndex(652591);
    }

    public boolean getInitialCharging() {
        return this.mInitialState;
    }

    public void unregister() {
        BatteryBroadcastReceiver batteryBroadcastReceiver = this.receiver;
        if (batteryBroadcastReceiver != null) {
            INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, batteryBroadcastReceiver);
        }
    }

    private class BatteryBroadcastReceiver extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(652592);
        }

        private BatteryBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                action.hashCode();
                if (!action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED") && BatteryListener.this.mBatteryStateListener != null) {
                        BatteryListener.this.mBatteryStateListener.onStatePowerConnected();
                        return;
                    }
                    return;
                }
                if (BatteryListener.this.mBatteryStateListener != null) {
                    BatteryListener.this.mBatteryStateListener.onStatePowerDisconnected();
                }
            }
        }
    }

    public BatteryListener(Context context) {
        this.mContext = context;
    }

    public void register(BatteryStateListener batteryStateListener) {
        boolean z;
        this.mBatteryStateListener = batteryStateListener;
        if (this.mContext != null && this.receiver != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            Intent INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_dragon_read_aop_BroadcastAop_registerReceiver = INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_dragon_read_aop_BroadcastAop_registerReceiver(this.mContext, this.receiver, intentFilter);
            if (INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_dragon_read_aop_BroadcastAop_registerReceiver != null) {
                int intExtra = INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_dragon_read_aop_BroadcastAop_registerReceiver.getIntExtra("plugged", -1);
                TTVideoEngineLog.i("BatteryListener", "BatteryListener state: " + intExtra);
                if (intExtra == 2) {
                    z = true;
                } else {
                    z = false;
                }
                this.mInitialState = z;
            }
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_dragon_read_aop_BroadcastAop_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
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
        return INVOKEVIRTUAL_com_ss_ttvideoengine_playermetrcis_BatteryListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, filter);
    }
}
