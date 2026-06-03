package com.dragon.read.kmp.shortvideo.distribution.page.conent;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function3<List<com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> c;
    private static Function2<Composer, Integer, Unit> d;

    public final Function3<List<com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> a() {
        return c;
    }

    public final Function2<Composer, Integer, Unit> b() {
        return b;
    }

    public final Function2<Composer, Integer, Unit> c() {
        return d;
    }

    static {
        Covode.recordClassIndex(609052);
        a = new c();
        b = androidx.compose.runtime.internal.t.c(1667280263, false, b.a);
        c = androidx.compose.runtime.internal.t.c(1591830175, false, a.a);
        d = androidx.compose.runtime.internal.t.c(1706048192, false, C0065c.a);
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
                    ComposerKt.traceEventStart(1667280263, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ComposableSingletons$SeriesNormalRankPageKt.lambda$1667280263.<anonymous> (SeriesNormalRankPage.kt:227)");
                }
                androidx.compose.foundation.layout.m.b(SizeKt.i(Modifier.Companion, x0.i.g(0)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* renamed from: com.dragon.read.kmp.shortvideo.distribution.page.conent.c$c, reason: collision with other inner class name */
    static final class C0065c implements Function2<Composer, Integer, Unit> {
        public static final C0065c a = new C0065c();

        C0065c() {
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
                    ComposerKt.traceEventStart(1706048192, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ComposableSingletons$SeriesNormalRankPageKt.lambda$1706048192.<anonymous> (SeriesNormalRankPage.kt:615)");
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
                ComposerKt.traceEventStart(1591830175, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ComposableSingletons$SeriesNormalRankPageKt.lambda$1591830175.<anonymous> (SeriesNormalRankPage.kt:616)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
