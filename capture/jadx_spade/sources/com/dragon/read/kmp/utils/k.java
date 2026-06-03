package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    public static final k a;

    static {
        Covode.recordClassIndex(609529);
        a = new k();
    }

    private k() {
    }

    public final long f(String str, String str2) {
        return j.a(str, str2);
    }

    public final long h(String str, long j) {
        return j.e(str, j);
    }

    public final long d(String str, long j) {
        Object m773constructorimpl;
        long j2;
        try {
            Result.Companion companion = Result.Companion;
            androidx.compose.ui.graphics.l0 d = j.d(str);
            if (d != null) {
                j2 = d.x();
            } else {
                j2 = j;
            }
            m773constructorimpl = Result.m773constructorimpl(androidx.compose.ui.graphics.l0.j(j2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m776exceptionOrNullimpl(m773constructorimpl) != null) {
            m773constructorimpl = androidx.compose.ui.graphics.l0.j(j);
        }
        return ((androidx.compose.ui.graphics.l0) m773constructorimpl).x();
    }

    public final void a(long j, float[] hsl) {
        boolean z;
        boolean z2;
        float u;
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        if (hsl.length < 3) {
            return;
        }
        float max = Math.max(androidx.compose.ui.graphics.l0.u(j), Math.max(androidx.compose.ui.graphics.l0.t(j), androidx.compose.ui.graphics.l0.r(j)));
        float min = Math.min(androidx.compose.ui.graphics.l0.u(j), Math.min(androidx.compose.ui.graphics.l0.t(j), androidx.compose.ui.graphics.l0.r(j)));
        float f = max - min;
        float f2 = max + min;
        float f3 = f2 / 2.0f;
        hsl[2] = f3;
        boolean z3 = true;
        if (f == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            hsl[0] = 0.0f;
            hsl[1] = 0.0f;
            return;
        }
        if (f3 > 0.5f) {
            f2 = (2.0f - max) - min;
        }
        hsl[1] = f / f2;
        if (max == androidx.compose.ui.graphics.l0.u(j)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            u = ((androidx.compose.ui.graphics.l0.t(j) - androidx.compose.ui.graphics.l0.r(j)) / f) % 6.0f;
        } else {
            if (max != androidx.compose.ui.graphics.l0.t(j)) {
                z3 = false;
            }
            if (z3) {
                u = ((androidx.compose.ui.graphics.l0.r(j) - androidx.compose.ui.graphics.l0.u(j)) / f) + 2.0f;
            } else {
                u = ((androidx.compose.ui.graphics.l0.u(j) - androidx.compose.ui.graphics.l0.t(j)) / f) + 4.0f;
            }
        }
        float f4 = u * 60.0f;
        hsl[0] = f4;
        if (f4 < 0.0f) {
            hsl[0] = f4 + 360.0f;
        }
    }

    public final long b(float[] hsl, float f) {
        float coerceIn;
        float coerceIn2;
        Triple triple;
        float coerceIn3;
        float coerceIn4;
        float coerceIn5;
        float coerceIn6;
        Intrinsics.checkNotNullParameter(hsl, "hsl");
        if (hsl.length < 3) {
            return androidx.compose.ui.graphics.l0.b.g();
        }
        float f2 = hsl[0] % 360.0f;
        coerceIn = RangesKt___RangesKt.coerceIn(hsl[1], 0.0f, 1.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(hsl[2], 0.0f, 1.0f);
        float abs = (1.0f - Math.abs((coerceIn2 * 2.0f) - 1.0f)) * coerceIn;
        float abs2 = (1.0f - Math.abs(((f2 / 60.0f) % 2.0f) - 1.0f)) * abs;
        float f3 = coerceIn2 - (abs / 2.0f);
        if (f2 < 60.0f) {
            triple = new Triple(Float.valueOf(abs), Float.valueOf(abs2), Float.valueOf(0.0f));
        } else if (f2 < 120.0f) {
            triple = new Triple(Float.valueOf(abs2), Float.valueOf(abs), Float.valueOf(0.0f));
        } else if (f2 < 180.0f) {
            triple = new Triple(Float.valueOf(0.0f), Float.valueOf(abs), Float.valueOf(abs2));
        } else if (f2 < 240.0f) {
            triple = new Triple(Float.valueOf(0.0f), Float.valueOf(abs2), Float.valueOf(abs));
        } else if (f2 < 300.0f) {
            triple = new Triple(Float.valueOf(abs2), Float.valueOf(0.0f), Float.valueOf(abs));
        } else {
            triple = new Triple(Float.valueOf(abs), Float.valueOf(0.0f), Float.valueOf(abs2));
        }
        float floatValue = ((Number) triple.component1()).floatValue();
        float floatValue2 = ((Number) triple.component2()).floatValue();
        float floatValue3 = ((Number) triple.component3()).floatValue();
        coerceIn3 = RangesKt___RangesKt.coerceIn(floatValue + f3, 0.0f, 1.0f);
        coerceIn4 = RangesKt___RangesKt.coerceIn(floatValue2 + f3, 0.0f, 1.0f);
        coerceIn5 = RangesKt___RangesKt.coerceIn(floatValue3 + f3, 0.0f, 1.0f);
        coerceIn6 = RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f);
        return androidx.compose.ui.graphics.n0.e(coerceIn3, coerceIn4, coerceIn5, coerceIn6, (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null);
    }

    public static /* synthetic */ long c(k kVar, float[] fArr, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        return kVar.b(fArr, f);
    }

    public static /* synthetic */ long e(k kVar, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = androidx.compose.ui.graphics.l0.b.g();
        }
        return kVar.d(str, j);
    }

    public static /* synthetic */ long g(k kVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return kVar.f(str, str2);
    }

    public static /* synthetic */ long i(k kVar, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = androidx.compose.ui.graphics.l0.b.g();
        }
        return kVar.h(str, j);
    }
}
