package com.ttnet.org.chromium.base.metrics;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(654371);
    }

    private static int a(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static void b(String str, boolean z) {
        c.a().c(str, z);
    }

    public static void d(String str, long j) {
        c(str, j, 1L, 10000L, 50);
    }

    private static void c(String str, long j, long j2, long j3, int i) {
        c.a().d(str, a(j), a(j2), a(j3), i);
    }
}
