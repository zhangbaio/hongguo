package com.dragon.read.kmp.shortvideo.distribution.page.conent;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;
    private static Function3<List<com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> b;
    private static Function2<Composer, Integer, Unit> c;

    public final Function3<List<com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> a() {
        return b;
    }

    public final Function2<Composer, Integer, Unit> b() {
        return c;
    }

    static {
        Covode.recordClassIndex(609053);
        a = new d();
        b = androidx.compose.runtime.internal.t.c(-1482886374, false, a.a);
        c = androidx.compose.runtime.internal.t.c(699506107, false, b.a);
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
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
                    ComposerKt.traceEventStart(699506107, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ComposableSingletons$SeriesTopicRankPageKt.lambda$699506107.<anonymous> (SeriesTopicRankPage.kt:129)");
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

    static final class a implements Function3<List<? extends com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.dragon.read.kmp.widget.slidetab.f> list, Composer composer, Integer num) {
            a(list, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(List<com.dragon.read.kmp.widget.slidetab.f> it2, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(it2, "it");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1482886374, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ComposableSingletons$SeriesTopicRankPageKt.lambda$-1482886374.<anonymous> (SeriesTopicRankPage.kt:130)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
