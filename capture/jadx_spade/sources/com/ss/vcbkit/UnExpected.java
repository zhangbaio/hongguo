package com.ss.vcbkit;

import com.bytedance.covode.number.Covode;
import com.bytedance.crash.Ensure;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class UnExpected {
    private static boolean a;

    static {
        Covode.recordClassIndex(652850);
        a = false;
    }

    static void a() {
        if (a) {
            return;
        }
        try {
            Ensure.getInstance();
            a = true;
        } catch (Throwable unused) {
            a = false;
        }
    }

    public static void b(Throwable th, String str) {
        if (a) {
            Ensure.ensureNotReachHere(th, str);
        }
    }

    private static void notReachHereNative(String str, String str2, Map<String, String> map) {
        if (a) {
            Ensure.ensureNativeStack(str, "", Thread.currentThread().getName(), str2, map);
        }
    }
}
