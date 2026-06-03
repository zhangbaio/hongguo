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
public final class b {
    public static final b a;
    private static Function3<List<com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> b;
    private static Function2<Composer, Integer, Unit> c;

    public final Function2<Composer, Integer, Unit> a() {
        return c;
    }

    public final Function3<List<com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> b() {
        return b;
    }

    static {
        Covode.recordClassIndex(609051);
        a = new b();
        b = androidx.compose.runtime.internal.t.c(13977124, false, C0064b.a);
        c = androidx.compose.runtime.internal.t.c(-207215355, false, a.a);
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
                    ComposerKt.traceEventStart(-207215355, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ComposableSingletons$NewRankPageComponentsKt.lambda$-207215355.<anonymous> (NewRankPageComponents.kt:374)");
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

    /* renamed from: com.dragon.read.kmp.shortvideo.distribution.page.conent.b$b, reason: collision with other inner class name */
    static final class C0064b implements Function3<List<? extends com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> {
        public static final C0064b a = new C0064b();

        C0064b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.dragon.read.kmp.widget.slidetab.f> list, Composer composer, Integer num) {
            a(list, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(List<com.dragon.read.kmp.widget.slidetab.f> it2, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(it2, "it");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(13977124, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ComposableSingletons$NewRankPageComponentsKt.lambda$13977124.<anonymous> (NewRankPageComponents.kt:375)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
