package com.dragon.read.kmp.search.searchlinkpage;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.n0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.e90;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> b;
    private static Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> c;
    private static Function2<Composer, Integer, Unit> d;
    private static Function3<e90, Composer, Integer, Unit> e;
    private static Function2<Composer, Integer, Unit> f;
    private static Function3<e90, Composer, Integer, Unit> g;
    private static Function3<androidx.compose.animation.e, Composer, Integer, Unit> h;

    public final Function3<e90, Composer, Integer, Unit> a() {
        return g;
    }

    public final Function3<androidx.compose.animation.e, Composer, Integer, Unit> b() {
        return h;
    }

    public final Function2<Composer, Integer, Unit> c() {
        return d;
    }

    public final Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> d() {
        return c;
    }

    public final Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> e() {
        return b;
    }

    public final Function2<Composer, Integer, Unit> f() {
        return f;
    }

    public final Function3<e90, Composer, Integer, Unit> g() {
        return e;
    }

    static {
        Covode.recordClassIndex(608787);
        a = new b();
        b = androidx.compose.runtime.internal.t.c(-1896546617, false, e.a);
        c = androidx.compose.runtime.internal.t.c(-1804688386, false, d.a);
        d = androidx.compose.runtime.internal.t.c(-1689929823, false, c.a);
        e = androidx.compose.runtime.internal.t.c(676808140, false, g.a);
        f = androidx.compose.runtime.internal.t.c(1789488685, false, f.a);
        g = androidx.compose.runtime.internal.t.c(-107995752, false, a.a);
        h = androidx.compose.runtime.internal.t.c(-1292116196, false, C0058b.a);
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
                    ComposerKt.traceEventStart(-1689929823, i, -1, "com.dragon.read.kmp.search.searchlinkpage.ComposableSingletons$SearchLinkDialogViewKmpKt.lambda$-1689929823.<anonymous> (SearchLinkDialogViewKmp.kt:297)");
                }
                Modifier.a aVar = Modifier.Companion;
                float f = 2;
                Modifier x = SizeKt.x(SizeKt.i(aVar, x0.i.g(f)), x0.i.g(10));
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, x);
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
                a3.a(BackgroundKt.c(BoxScopeInstance.a.b(SizeKt.s(aVar, x0.i.g(f)), aVar2.e()), zl4.s.a.b(composer, zl4.s.b).q(), k.g.a(50)), composer, 0);
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

    static final class f implements Function2<Composer, Integer, Unit> {
        public static final f a = new f();

        f() {
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
                    ComposerKt.traceEventStart(1789488685, i, -1, "com.dragon.read.kmp.search.searchlinkpage.ComposableSingletons$SearchLinkDialogViewKmpKt.lambda$1789488685.<anonymous> (SearchLinkDialogViewKmp.kt:455)");
                }
                Modifier.a aVar = Modifier.Companion;
                float f = 2;
                Modifier x = SizeKt.x(SizeKt.i(aVar, x0.i.g(f)), x0.i.g(10));
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, x);
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
                a3.a(BackgroundKt.c(BoxScopeInstance.a.b(SizeKt.s(aVar, x0.i.g(f)), aVar2.e()), zl4.s.a.b(composer, zl4.s.b).q(), k.g.a(50)), composer, 0);
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

    static final class a implements Function3<e90, Composer, Integer, Unit> {
        public static final a a = new a();

        a() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(e90 e90Var, Composer composer, Integer num) {
            a(e90Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(e90 content, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-107995752, i, -1, "com.dragon.read.kmp.search.searchlinkpage.ComposableSingletons$SearchLinkDialogViewKmpKt.lambda$-107995752.<anonymous> (SearchLinkDialogViewKmp.kt:452)");
            }
            SearchLinkDialogViewKmpKt.Y(content, composer, i & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* renamed from: com.dragon.read.kmp.search.searchlinkpage.b$b, reason: collision with other inner class name */
    static final class C0058b implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
        public static final C0058b a = new C0058b();

        C0058b() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
            a(eVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
            List listOf;
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1292116196, i, -1, "com.dragon.read.kmp.search.searchlinkpage.ComposableSingletons$SearchLinkDialogViewKmpKt.lambda$-1292116196.<anonymous> (SearchLinkDialogViewKmp.kt:709)");
            }
            long d = n0.d(2147483648L);
            long g = l0.b.g();
            float f = 20;
            Modifier v = f2.v(SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(f)), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
            c0.a aVar = androidx.compose.ui.graphics.c0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(d), l0.j(g)});
            androidx.compose.foundation.layout.m.b(BackgroundKt.b(v, c0.a.p(aVar, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    static final class d implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
        public static final d a = new d();

        d() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
            a(fVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1804688386, i, -1, "com.dragon.read.kmp.search.searchlinkpage.ComposableSingletons$SearchLinkDialogViewKmpKt.lambda$-1804688386.<anonymous> (SearchLinkDialogViewKmp.kt:192)");
                }
                a3.a(SizeKt.i(Modifier.Companion, x0.i.g(136)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class e implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
        public static final e a = new e();

        e() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
            a(fVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1896546617, i, -1, "com.dragon.read.kmp.search.searchlinkpage.ComposableSingletons$SearchLinkDialogViewKmpKt.lambda$-1896546617.<anonymous> (SearchLinkDialogViewKmp.kt:174)");
                }
                a3.a(SizeKt.i(Modifier.Companion, x0.i.g(30)), composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class g implements Function3<e90, Composer, Integer, Unit> {
        public static final g a = new g();

        g() {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(e90 e90Var, Composer composer, Integer num) {
            a(e90Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(e90 content, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(676808140, i, -1, "com.dragon.read.kmp.search.searchlinkpage.ComposableSingletons$SearchLinkDialogViewKmpKt.lambda$676808140.<anonymous> (SearchLinkDialogViewKmp.kt:294)");
            }
            SearchLinkDialogViewKmpKt.Y(content, composer, i & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
