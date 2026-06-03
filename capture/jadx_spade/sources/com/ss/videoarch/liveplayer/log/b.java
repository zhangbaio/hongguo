package com.ss.videoarch.liveplayer.log;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.log.VeLivePlayerLogConfig;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static int a;
    private static long b;

    public static void a(String str, String str2) {
    }

    public static void b(String str, String str2) {
    }

    public static long c() {
        return -1L;
    }

    public static void d(String str, String str2) {
    }

    public static boolean f() {
        return false;
    }

    public static long h(VeLivePlayerLogConfig.VeLivePlayerLogLevel veLivePlayerLogLevel) {
        return -1L;
    }

    public static void i(String str, String str2) {
    }

    private static void e() {
        Log.e("VeLivePlayerLog", "mConfig is null");
    }

    static {
        Covode.recordClassIndex(653049);
        a = -1;
        b = -1;
    }

    public static void g(VeLivePlayerLogConfig veLivePlayerLogConfig) {
        int i = (b > a ? 1 : (b == a ? 0 : -1));
        e();
        a.c("VeLivePlayerLog", "setLogConfig:config=" + veLivePlayerLogConfig);
    }
}
