package com.dragon.read.kmp.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 {
    public static final j0 a;
    private static Function2<Composer, Integer, Unit> b;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(609647);
        a = new j0();
        b = androidx.compose.runtime.internal.t.c(1494366679, false, a.a);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1494366679, i, -1, "com.dragon.read.kmp.widget.ComposableSingletons$StarScoreCardKt.lambda$1494366679.<anonymous> (StarScoreCard.kt:76)");
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }
}
