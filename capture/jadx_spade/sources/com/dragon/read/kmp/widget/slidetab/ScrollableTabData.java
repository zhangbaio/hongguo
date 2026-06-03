package com.dragon.read.kmp.widget.slidetab;

import androidx.compose.foundation.v2;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ScrollableTabData {
    private final v2 a;
    private final CoroutineScope b;
    private Integer c;

    static {
        Covode.recordClassIndex(609690);
    }

    public ScrollableTabData(v2 scrollState, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.a = scrollState;
        this.b = coroutineScope;
    }

    private final int b(f fVar, x0.e eVar, int i, List<f> list) {
        int coerceAtLeast;
        int coerceIn;
        int x0 = eVar.x0(((f) CollectionsKt___CollectionsKt.last((List) list)).a()) + i;
        int r = x0 - this.a.r();
        int x02 = eVar.x0(fVar.a) - ((r / 2) - (eVar.x0(fVar.b) / 2));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(x0 - r, 0);
        coerceIn = RangesKt___RangesKt.coerceIn(x02, 0, coerceAtLeast);
        return coerceIn;
    }

    public final void c(x0.e density, int i, List<f> tabPositions, int i2) {
        int b;
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
        Integer num = this.c;
        if (num == null || num.intValue() != i2) {
            this.c = Integer.valueOf(i2);
            f fVar = (f) CollectionsKt___CollectionsKt.getOrNull(tabPositions, i2);
            if (fVar == null || this.a.s() == (b = b(fVar, density, i, tabPositions))) {
                return;
            }
            i.e(this.b, null, null, new ScrollableTabData$onLaidOut$1$1(this, b, null), 3, null);
        }
    }
}
