package com.ss.videoarch.strategy.network;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.utils.JNINamespace;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VeLSNetworkManager {
    static String b;
    private final e a = new e();

    private native String nativeGetAbrAutoSettings();

    private native void nativeGetLSSettings();

    private native String nativeGetLSStrategySDKSettings();

    private native String nativeGetLivePlayerSettings();

    private native String nativeGetQuicSettings();

    private native String nativeGetRTMPlayer();

    private native String nativeGetStrategyConfig();

    private native String nativeGetStrategyConfigByName(String str, String str2);

    private native void nativeStartPeriodicRequest();

    public String a() {
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            return "";
        }
        return nativeGetLivePlayerSettings();
    }

    public String b() {
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            return "";
        }
        return nativeGetRTMPlayer();
    }

    static {
        Covode.recordClassIndex(653159);
        b = "VeLSSettingsManager";
        if (!com.ss.videoarch.strategy.utils.b.a()) {
            com.ss.videoarch.strategy.utils.b.b(c("livestrategy"));
        }
    }

    private static boolean c(String str) {
        try {
            com.ss.videoarch.strategy.utils.a.a(str);
            Log.d(b, "load library: " + str + ".so success");
            return true;
        } catch (Throwable th) {
            Log.e(b, "load library: " + str + ".so fail! " + th.getMessage());
            return false;
        }
    }
}
