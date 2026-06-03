package com.dragon.read.kmp.story.impl.feeds;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function2<Composer, Integer, Unit> c;
    private static Function2<Composer, Integer, Unit> d;
    private static Function4<Integer, yo4.c, Composer, Integer, Unit> e;

    public final Function2<Composer, Integer, Unit> a() {
        return c;
    }

    public final Function2<Composer, Integer, Unit> b() {
        return b;
    }

    public final Function4<Integer, yo4.c, Composer, Integer, Unit> c() {
        return e;
    }

    public final Function2<Composer, Integer, Unit> d() {
        return d;
    }

    static {
        Covode.recordClassIndex(609225);
        a = new a();
        b = t.c(1188054834, false, b.a);
        c = t.c(1134464733, false, C0068a.a);
        d = t.c(1987660591, false, d.a);
        e = t.c(1555973070, false, c.a);
    }

    /* renamed from: com.dragon.read.kmp.story.impl.feeds.a$a, reason: collision with other inner class name */
    static final class C0068a implements Function2<Composer, Integer, Unit> {
        public static final C0068a a = new C0068a();

        C0068a() {
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
                    ComposerKt.traceEventStart(1134464733, i, -1, "com.dragon.read.kmp.story.impl.feeds.ComposableSingletons$KmpStoryFeedsPageKt.lambda$1134464733.<anonymous> (KmpStoryFeedsPage.kt:129)");
                }
                rp4.e.d(a.a.b(), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
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
                    ComposerKt.traceEventStart(1188054834, i, -1, "com.dragon.read.kmp.story.impl.feeds.ComposableSingletons$KmpStoryFeedsPageKt.lambda$1188054834.<anonymous> (KmpStoryFeedsPage.kt:130)");
                }
                KmpStoryFeedsPageKt.s(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class d implements Function2<Composer, Integer, Unit> {
        public static final d a = new d();

        d() {
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
                    ComposerKt.traceEventStart(1987660591, i, -1, "com.dragon.read.kmp.story.impl.feeds.ComposableSingletons$KmpStoryFeedsPageKt.lambda$1987660591.<anonymous> (KmpStoryFeedsPage.kt:154)");
                }
                KmpStoryFeedsPageKt.n(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class c implements Function4<Integer, yo4.c, Composer, Integer, Unit> {
        public static final c a = new c();

        c() {
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, yo4.c cVar, Composer composer, Integer num2) {
            a(num.intValue(), cVar, composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(int i, yo4.c data, Composer composer, int i2) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1555973070, i2, -1, "com.dragon.read.kmp.story.impl.feeds.ComposableSingletons$KmpStoryFeedsPageKt.lambda$1555973070.<anonymous> (KmpStoryFeedsPage.kt:232)");
            }
            KmpStoryFeedsPageKt.k(i, data, composer, (i2 & 112) | (i2 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
