package com.dragon.read.kmp.shortvideo.distribution.page.tab.item;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final n a;
    private static Function2<Composer, Integer, Unit> b;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    static {
        Covode.recordClassIndex(609081);
        a = new n();
        b = androidx.compose.runtime.internal.t.c(-304566574, false, a.a);
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
                    ComposerKt.traceEventStart(-304566574, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.ComposableSingletons$VideoRankingListCardKt.lambda$-304566574.<anonymous> (VideoRankingListCard.kt:435)");
                }
                float f = 4;
                a3.a(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.s(f2.v(Modifier.Companion, x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null), x0.i.g(2)), k.g.f()), og4.a.a.h(composer, og4.a.b).h(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
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
