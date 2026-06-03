package com.ss.ttvideoengine.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Debug;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DeviceMonitorUtils {
    private static Class<?> sCpuInfoClz;
    private static Class<?> sCpuManagerClz;
    private static Method sGetCpuRateMethod;
    private static Method sGetCpuSpeedMethod;
    private static Method sGetCurrentCpuInfoMethod;
    private static Method sGetGalvanicNowMethod;
    private static Method sGetInstanceMethod;
    private static Class<?> sThorClz;

    public static int getUsingMemory() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        return memoryInfo.getTotalPss() / 1024;
    }

    static {
        Covode.recordClassIndex(652461);
        sCpuManagerClz = null;
        sCpuInfoClz = null;
        sGetInstanceMethod = null;
        sGetCurrentCpuInfoMethod = null;
        sGetCpuRateMethod = null;
        sGetCpuSpeedMethod = null;
        sThorClz = null;
        sGetGalvanicNowMethod = null;
    }

    public static class CPUInfo {
        public double cpuAppRate = -1.0d;
        public double cpuAppSpeed = -1.0d;

        static {
            Covode.recordClassIndex(652462);
        }

        public String toString() {
            return "CpuInfo{cpuAppRate=" + this.cpuAppRate + ", cpuAppSpeed=" + this.cpuAppSpeed + '}';
        }
    }

    public static double getCPURate() {
        Object invoke;
        Double valueOf;
        try {
            if (sCpuManagerClz == null) {
                sCpuManagerClz = l3.a.q("com.bytedance.apm6.cpu.ApmCpuManager");
            }
            if (sGetInstanceMethod == null) {
                sGetInstanceMethod = sCpuManagerClz.getMethod("getInstance", new Class[0]);
            }
            if (sGetCpuRateMethod == null) {
                sGetCpuRateMethod = sCpuManagerClz.getMethod("getCpuRate", new Class[0]);
            }
            Object invoke2 = sGetInstanceMethod.invoke(null, new Object[0]);
            if (invoke2 == null || (invoke = sGetCpuRateMethod.invoke(invoke2, new Object[0])) == null || (valueOf = Double.valueOf(Double.parseDouble(invoke.toString()))) == null) {
                return -1.0d;
            }
            return valueOf.doubleValue();
        } catch (Exception e) {
            TTVideoEngineLog.d("DeviceMonitorUtils", "getCPURate:" + e);
            return -1.0d;
        }
    }

    public static double getCPUSpeed() {
        Object invoke;
        Double valueOf;
        try {
            if (sCpuManagerClz == null) {
                sCpuManagerClz = l3.a.q("com.bytedance.apm6.cpu.ApmCpuManager");
            }
            if (sGetInstanceMethod == null) {
                sGetInstanceMethod = sCpuManagerClz.getMethod("getInstance", new Class[0]);
            }
            if (sGetCpuSpeedMethod == null) {
                sGetCpuSpeedMethod = sCpuManagerClz.getMethod("getCpuSpeed", new Class[0]);
            }
            Object invoke2 = sGetInstanceMethod.invoke(null, new Object[0]);
            if (invoke2 == null || (invoke = sGetCpuSpeedMethod.invoke(invoke2, new Object[0])) == null || (valueOf = Double.valueOf(Double.parseDouble(invoke.toString()))) == null) {
                return -1.0d;
            }
            return valueOf.doubleValue();
        } catch (Exception e) {
            TTVideoEngineLog.d("DeviceMonitorUtils", "getCPUSpeed:" + e);
            return -1.0d;
        }
    }

    public static CPUInfo getCurrentCPUInfo() {
        CPUInfo cPUInfo = new CPUInfo();
        try {
            if (sCpuManagerClz == null) {
                sCpuManagerClz = l3.a.q("com.bytedance.apm6.cpu.ApmCpuManager");
            }
            if (sGetInstanceMethod == null) {
                sGetInstanceMethod = sCpuManagerClz.getMethod("getInstance", new Class[0]);
            }
            if (sGetCurrentCpuInfoMethod == null) {
                sGetCurrentCpuInfoMethod = sCpuManagerClz.getMethod("getCurrentCpuRate", new Class[0]);
            }
            if (sCpuInfoClz == null) {
                sCpuInfoClz = l3.a.q("com.bytedance.apm.perf.entity.CpuInfo");
            }
            Object invoke = sGetInstanceMethod.invoke(null, new Object[0]);
            if (invoke != null) {
                Object invoke2 = sGetCurrentCpuInfoMethod.invoke(invoke, new Object[0]);
                if (invoke2 != null && sCpuInfoClz.isInstance(invoke2)) {
                    Field declaredField = sCpuInfoClz.getDeclaredField("cpuAppRate");
                    if (declaredField != null) {
                        cPUInfo.cpuAppRate = declaredField.getDouble(invoke2);
                    }
                    Field declaredField2 = sCpuInfoClz.getDeclaredField("cpuAppSpeed");
                    if (declaredField2 != null) {
                        cPUInfo.cpuAppSpeed = declaredField2.getDouble(invoke2);
                    }
                } else {
                    TTVideoEngineLog.i("DeviceMonitorUtils", "is not instance");
                }
            }
        } catch (Exception e) {
            TTVideoEngineLog.d("DeviceMonitorUtils", "getCurrentCPUInfo:" + e);
        }
        return cPUInfo;
    }

    public static int getPowerCapacity(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
            if (batteryManager == null) {
                return 0;
            }
            return batteryManager.getIntProperty(4);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static int isPowerSaveMode(Context context) {
        if (context != null) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    return powerManager.isPowerSaveMode() ? 1 : 0;
                }
                return -1;
            } catch (Exception e) {
                TTVideoEngineLog.d("DeviceMonitorUtils", "isPowerSaveMode:" + e);
                return -1;
            }
        }
        return -1;
    }

    public static HashMap<String, Object> getChargingState(Context context) {
        Intent INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_dragon_read_aop_BroadcastAop_registerReceiver;
        int i;
        if (context == null || (INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_dragon_read_aop_BroadcastAop_registerReceiver = INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_dragon_read_aop_BroadcastAop_registerReceiver(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return null;
        }
        int intExtra = INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_dragon_read_aop_BroadcastAop_registerReceiver.getIntExtra("status", -1);
        if (intExtra != 2 && intExtra != 5) {
            i = 0;
        } else {
            i = 1;
        }
        int intExtra2 = INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_dragon_read_aop_BroadcastAop_registerReceiver.getIntExtra("plugged", -1);
        int intExtra3 = (INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_dragon_read_aop_BroadcastAop_registerReceiver.getIntExtra("level", -1) * 100) / INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_dragon_read_aop_BroadcastAop_registerReceiver.getIntExtra("scale", -1);
        HashMap<String, Object> hashMap = new HashMap<>(3);
        hashMap.put("isCharging", Integer.valueOf(i));
        hashMap.put("chargePlug", Integer.valueOf(intExtra2));
        hashMap.put("power", Integer.valueOf(intExtra3));
        return hashMap;
    }

    public static float getGalvanicNow(Context context) {
        if (context == null) {
            return -1.0f;
        }
        try {
            if (sThorClz == null) {
                sThorClz = l3.a.q("com.ss.thor.ThorUtils");
            }
            if (sGetGalvanicNowMethod == null) {
                sGetGalvanicNowMethod = sThorClz.getMethod("getGalvanicNow", Context.class);
            }
            return ((Float) sGetGalvanicNowMethod.invoke(null, context)).floatValue();
        } catch (Exception e) {
            TTVideoEngineLog.d("DeviceMonitorUtils", "startThorMonitor failed:" + e);
            return -1.0f;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_dragon_read_aop_BroadcastAop_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
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
        return INVOKEVIRTUAL_com_ss_ttvideoengine_log_DeviceMonitorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, filter);
    }
}
