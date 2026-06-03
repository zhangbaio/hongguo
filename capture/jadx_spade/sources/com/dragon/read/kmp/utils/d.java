package com.dragon.read.kmp.utils;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    private static final Function2<Integer, Integer, Integer> a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(int i, int i2) {
        return i + i2;
    }

    static {
        Covode.recordClassIndex(609522);
        a = new Function2() { // from class: com.dragon.read.kmp.utils.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                int e;
                e = d.e(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return Integer.valueOf(e);
            }
        };
    }

    public static final float d(PagerState pagerState, int i) {
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        return (pagerState.u() - i) + pagerState.v();
    }

    public static final long b(float f, float f2, float f3) {
        float coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(f3, -1.0f, 1.0f);
        return x0.x.g((float) (((float) Math.rint(z0.c.b(f, f2, 1.0f - Math.abs(coerceIn)) * 1000)) / 1000.0d));
    }

    private static final long f(long j, long j2, float f) {
        float coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f);
        return androidx.compose.ui.graphics.n0.e(androidx.compose.ui.graphics.l0.u(j) + ((androidx.compose.ui.graphics.l0.u(j2) - androidx.compose.ui.graphics.l0.u(j)) * coerceIn), androidx.compose.ui.graphics.l0.t(j) + ((androidx.compose.ui.graphics.l0.t(j2) - androidx.compose.ui.graphics.l0.t(j)) * coerceIn), androidx.compose.ui.graphics.l0.r(j) + ((androidx.compose.ui.graphics.l0.r(j2) - androidx.compose.ui.graphics.l0.r(j)) * coerceIn), androidx.compose.ui.graphics.l0.q(j) + ((androidx.compose.ui.graphics.l0.q(j2) - androidx.compose.ui.graphics.l0.q(j)) * coerceIn), (androidx.compose.ui.graphics.colorspace.c) null, 16, (Object) null);
    }

    public static final long c(long j, long j2, float f, Composer composer, int i) {
        float coerceIn;
        composer.startReplaceGroup(1551913358);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1551913358, i, -1, "com.dragon.read.kmp.utils.calculateColorOffset (CalcUtils.kt:32)");
        }
        coerceIn = RangesKt___RangesKt.coerceIn(f, -1.0f, 1.0f);
        long f2 = f(j, j2, 1.0f - Math.abs(coerceIn));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return f2;
    }
}
