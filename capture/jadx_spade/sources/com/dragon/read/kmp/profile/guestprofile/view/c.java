package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    private static Function2<Composer, Integer, Unit> b;
    private static Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> c;

    public final Function2<Composer, Integer, Unit> a() {
        return b;
    }

    public final Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> b() {
        return c;
    }

    static {
        Covode.recordClassIndex(608165);
        a = new c();
        b = androidx.compose.runtime.internal.t.c(1594146231, false, a.a);
        c = androidx.compose.runtime.internal.t.c(528494027, false, b.a);
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
                    ComposerKt.traceEventStart(1594146231, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ComposableSingletons$SeriesGuestProfilePageKt.lambda$1594146231.<anonymous> (SeriesGuestProfilePage.kt:208)");
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

    static final class b implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        public static final b a = new b();

        b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r BubbleLayout, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(BubbleLayout, "$this$BubbleLayout");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(528494027, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ComposableSingletons$SeriesGuestProfilePageKt.lambda$528494027.<anonymous> (SeriesGuestProfilePage.kt:893)");
                }
                float f = 16;
                a6.j("为TA守护登上星光榜", androidx.compose.foundation.layout.f2.u(Modifier.Companion, x0.i.g(f), x0.i.g(15), x0.i.g(f), x0.i.g(10)), androidx.compose.ui.graphics.l0.b.i(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(20), 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 3510, 6, 130032);
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
