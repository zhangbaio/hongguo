package com.dragon.read.kmp.reader.ui;

import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.n0;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d0 {
    static {
        Covode.recordClassIndex(608597);
    }

    public static final i2 f(androidx.compose.material.q qVar) {
        Intrinsics.checkNotNullParameter(qVar, "<this>");
        float f = 0;
        return f2.i(x0.i.g(f), x0.i.g(f), x0.i.g(f), x0.i.g(f));
    }

    public static final long a(int i, double d) {
        return b(i, (float) d);
    }

    public static final long c(long j, double d) {
        return a(n0.k(j), d);
    }

    public static final long d(long j, float f) {
        return b(n0.k(j), f);
    }

    public static final long b(int i, float f) {
        return n0.c((16711680 & i) >> 16, (65280 & i) >> 8, i & 255, (int) Math.ceil(f * 255));
    }

    public static final androidx.compose.material.s e(androidx.compose.material.q qVar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(qVar, "<this>");
        composer.startReplaceGroup(-843886421);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-843886421, i, -1, "com.dragon.read.kmp.reader.ui.elevationNone (UI.kt:31)");
        }
        float f = 0;
        androidx.compose.material.s b = androidx.compose.material.q.a.b(x0.i.g(f), x0.i.g(f), 0.0f, x0.i.g(f), x0.i.g(f), composer, (androidx.compose.material.q.l << 15) | 27702, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return b;
    }
}
