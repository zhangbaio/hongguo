package com.dragon.read.kmp.profile.guestprofile.tabContent;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static Function3<androidx.compose.foundation.lazy.grid.w, Composer, Integer, Unit> b;
    private static Function3<androidx.compose.foundation.lazy.staggeredgrid.s, Composer, Integer, Unit> c;
    private static Function2<Composer, Integer, Unit> d;

    public final Function3<androidx.compose.foundation.lazy.grid.w, Composer, Integer, Unit> a() {
        return b;
    }

    public final Function2<Composer, Integer, Unit> b() {
        return d;
    }

    public final Function3<androidx.compose.foundation.lazy.staggeredgrid.s, Composer, Integer, Unit> c() {
        return c;
    }

    static {
        Covode.recordClassIndex(608144);
        a = new a();
        b = androidx.compose.runtime.internal.t.c(-1097275347, false, C0028a.a);
        c = androidx.compose.runtime.internal.t.c(287241539, false, c.a);
        d = androidx.compose.runtime.internal.t.c(-1597565337, false, b.a);
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
                    ComposerKt.traceEventStart(-1597565337, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.ComposableSingletons$GuestProfileOneTabContentKt.lambda$-1597565337.<anonymous> (GuestProfileOneTabContent.kt:482)");
                }
                Modifier v = f2.v(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, x0.i.g(180), 0.0f, 0.0f, 13, (Object) null);
                p0 i2 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.m(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, v);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a3 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a3);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                mg4.q.j(composer, 0);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* renamed from: com.dragon.read.kmp.profile.guestprofile.tabContent.a$a, reason: collision with other inner class name */
    static final class C0028a implements Function3<androidx.compose.foundation.lazy.grid.w, Composer, Integer, Unit> {
        public static final C0028a a = new C0028a();

        C0028a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Composer composer, Integer num) {
            a(wVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.grid.w item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1097275347, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.ComposableSingletons$GuestProfileOneTabContentKt.lambda$-1097275347.<anonymous> (GuestProfileOneTabContent.kt:210)");
                }
                androidx.compose.foundation.layout.m.b(SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(1)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class c implements Function3<androidx.compose.foundation.lazy.staggeredgrid.s, Composer, Integer, Unit> {
        public static final c a = new c();

        c() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.staggeredgrid.s sVar, Composer composer, Integer num) {
            a(sVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.staggeredgrid.s item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(287241539, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.ComposableSingletons$GuestProfileOneTabContentKt.lambda$287241539.<anonymous> (GuestProfileOneTabContent.kt:301)");
                }
                androidx.compose.foundation.layout.m.b(SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(1)), composer, 6);
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
