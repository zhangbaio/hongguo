package com.dragon.read.kmp.shortvideo.distribution.page.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.x2;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.text.font.j;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.q20;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RankingNumberViewKt {
    private static final Map<String, j> a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(q20 q20Var, j jVar, int i, Composer composer, int i2) {
        c(q20Var, jVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(q20 q20Var, int i, float f, boolean z, int i2, int i3, Composer composer, int i4) {
        e(q20Var, i, f, z, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(609085);
        a = new LinkedHashMap();
    }

    private static final long h(int i, Composer composer, int i2) {
        long d;
        composer.startReplaceGroup(1178503831);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1178503831, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.view.getNumberColor (RankingNumberView.kt:154)");
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    d = og4.a.a.h(composer, og4.a.b).h();
                } else {
                    d = n0.d(4287138783L);
                }
            } else {
                d = n0.d(4292443229L);
            }
        } else {
            d = n0.d(4294604549L);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return d;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0277  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void c(final com.bytedance.kmp.reading.model.q20 r29, final androidx.compose.ui.text.font.j r30, androidx.compose.runtime.Composer r31, final int r32) {
        /*
            Method dump skipped, instructions count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt.c(com.bytedance.kmp.reading.model.q20, androidx.compose.ui.text.font.j, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ed, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final com.bytedance.kmp.reading.model.q20 r36, final int r37, final float r38, boolean r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt.e(com.bytedance.kmp.reading.model.q20, int, float, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
