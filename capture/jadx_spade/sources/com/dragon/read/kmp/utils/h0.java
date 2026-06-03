package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0 {
    static {
        Covode.recordClassIndex(609554);
    }

    public static final double e(String str, double d) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return i0.a.d(str, d);
    }

    public static final float g(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return i0.a.e(str, f);
    }

    public static final int i(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return i0.a.g(str, i);
    }

    public static final long k(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return i0.a.f(str, j);
    }

    public static final long a(Long l, long j) {
        if (l == null) {
            return 0L;
        }
        if (l.longValue() >= 0) {
            return l.longValue();
        }
        return j;
    }

    public static final long c(Long l, long j) {
        if (l != null && l.longValue() > 0) {
            return l.longValue();
        }
        return j;
    }

    public static /* synthetic */ long b(Long l, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return a(l, j);
    }

    public static /* synthetic */ long d(Long l, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return c(l, j);
    }

    public static /* synthetic */ double f(String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = 0.0d;
        }
        return e(str, d);
    }

    public static /* synthetic */ float h(String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        return g(str, f);
    }

    public static /* synthetic */ int j(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return i(str, i);
    }

    public static /* synthetic */ long l(String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return k(str, j);
    }
}
