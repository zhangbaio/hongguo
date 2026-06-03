package com.dragon.read.kmp.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;
    private static Function3<FootLoadingState, Composer, Integer, Unit> b;

    public final Function3<FootLoadingState, Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(609589);
        a = new d();
        b = androidx.compose.runtime.internal.t.c(535560532, false, a.a);
    }

    static final class a implements Function3<FootLoadingState, Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(FootLoadingState footLoadingState, Composer composer, Integer num) {
            a(footLoadingState, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(FootLoadingState state, Composer composer, int i) {
            boolean z;
            int i2;
            Intrinsics.checkNotNullParameter(state, "state");
            if ((i & 6) == 0) {
                if (composer.changed(state.ordinal())) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(535560532, i, -1, "com.dragon.read.kmp.view.ComposableSingletons$RelationSeriesPagingDialogViewKt.lambda$535560532.<anonymous> (RelationSeriesPagingDialogView.kt:196)");
                }
                RelationSeriesPagingDialogViewKt.o(state, composer, i & 14);
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
