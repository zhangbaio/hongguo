package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static Function3<List<com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> b;
    private static Function2<Composer, Integer, Unit> c;
    private static Function2<Composer, Integer, Unit> d;
    private static Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> e;

    public final Function3<List<com.dragon.read.kmp.widget.slidetab.f>, Composer, Integer, Unit> a() {
        return b;
    }

    public final Function2<Composer, Integer, Unit> b() {
        return d;
    }

    public final Function2<Composer, Integer, Unit> c() {
        return c;
    }

    public final Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> d() {
        return e;
    }

    static {
        Covode.recordClassIndex(608164);
        a = new b();
        b = androidx.compose.runtime.internal.t.c(-1251611810, false, a.a);
        c = androidx.compose.runtime.internal.t.c(1505600669, false, c.a);
        d = androidx.compose.runtime.internal.t.c(1497821588, false, C0031b.a);
        e = androidx.compose.runtime.internal.t.c(830509106, false, d.a);
    }

    /* renamed from: com.dragon.read.kmp.profile.guestprofile.view.b$b, reason: collision with other inner class name */
    static final class C0031b implements Function2<Composer, Integer, Unit> {
        public static final C0031b a = new C0031b();

        C0031b() {
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
                    ComposerKt.traceEventStart(1497821588, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ComposableSingletons$ProfileTabPageHeaderKt.lambda$1497821588.<anonymous> (ProfileTabPageHeader.kt:160)");
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

    static final class c implements Function2<Composer, Integer, Unit> {
        public static final c a = new c();

        c() {
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
                    ComposerKt.traceEventStart(1505600669, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ComposableSingletons$ProfileTabPageHeaderKt.lambda$1505600669.<anonymous> (ProfileTabPageHeader.kt:99)");
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
                ComposerKt.traceEventStart(-1251611810, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ComposableSingletons$ProfileTabPageHeaderKt.lambda$-1251611810.<anonymous> (ProfileTabPageHeader.kt:100)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    static final class d implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        public static final d a = new d();

        d() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r BubbleLayout, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(BubbleLayout, "$this$BubbleLayout");
            if ((i & 6) == 0) {
                if (composer.changed(BubbleLayout)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(830509106, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.ComposableSingletons$ProfileTabPageHeaderKt.lambda$830509106.<anonymous> (ProfileTabPageHeader.kt:276)");
                }
                float f = 16;
                a6.j("演员相关讨论在这里查看", androidx.compose.foundation.layout.f2.u(BubbleLayout.b(Modifier.Companion, androidx.compose.ui.e.a.e()), x0.i.g(f), x0.i.g(15), x0.i.g(f), x0.i.g(10)), androidx.compose.ui.graphics.l0.b.i(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 3462, 0, 130544);
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
