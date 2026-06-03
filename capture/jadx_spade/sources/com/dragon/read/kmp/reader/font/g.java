package com.dragon.read.kmp.reader.font;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final g a;
    private static Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> b;

    public final Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(608426);
        a = new g();
        b = androidx.compose.runtime.internal.t.c(-20654596, false, a.a);
    }

    static final class a implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r RatioProgressBar, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(RatioProgressBar, "$this$RatioProgressBar");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-20654596, i, -1, "com.dragon.read.kmp.reader.font.ComposableSingletons$FontItemMultiTypeKt.lambda$-20654596.<anonymous> (FontItemMultiType.kt:166)");
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
