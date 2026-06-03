package dn4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.GradientOrientation;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.service.d1;
import dn4.h0;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import w0.s;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h0 {
    static {
        Covode.recordClassIndex(608752);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(j0 j0Var, k0 k0Var, int i, Composer composer, int i2) {
        f(j0Var, k0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(j0 j0Var, int i, Composer composer, int i2) {
        h(j0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(MutableState mutableState, k0 k0Var, int i, Composer composer, int i2) {
        j(mutableState, k0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(j0 j0Var, k0 k0Var, int i, Composer composer, int i2) {
        l(j0Var, k0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ k0 a;
        final /* synthetic */ j0 b;

        b(k0 k0Var, j0 j0Var) {
            this.a = k0Var;
            this.b = j0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(k0 k0Var, j0 j0Var) {
            k0Var.a(j0Var.a);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1114473384, i, -1, "com.dragon.read.kmp.search.card.IpSubscribeVideoCard.<anonymous> (IpSubscribeVideoCard.kt:70)");
                }
                Modifier D = SizeKt.D(Modifier.Companion, (androidx.compose.ui.e) null, false, 3, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changedInstance = composer.changedInstance(this.a) | composer.changedInstance(this.b);
                final k0 k0Var = this.a;
                final j0 j0Var = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dn4.i0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = h0.b.c(k0.this, j0Var);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(D, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                j0 j0Var2 = this.b;
                k0 k0Var2 = this.a;
                p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
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
                g5.e(b, a, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                h0.f(j0Var2, k0Var2, composer, 0);
                h0.h(j0Var2, composer, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(k0 k0Var, j0 j0Var) {
        k0Var.b(j0Var.a);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ j0 a;
        final /* synthetic */ k0 b;

        a(j0 j0Var, k0 k0Var) {
            this.a = j0Var;
            this.b = k0Var;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            boolean z;
            org.jetbrains.compose.resources.b R;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1572334455, i, -1, "com.dragon.read.kmp.search.card.HeaderArea.<anonymous> (IpSubscribeVideoCard.kt:88)");
                }
                Modifier a = androidx.compose.ui.draw.e.a(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), k.g.c(x0.i.g(4)));
                String str = this.a.b;
                composer.startReplaceGroup(815082815);
                com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                if (d1.d(og4.a.a.e(composer, og4.a.b))) {
                    R = d2.Q(f2.a.a);
                } else {
                    R = d2.R(f2.a.a);
                }
                nVar.e = R;
                composer.endReplaceGroup();
                LoadImageKt.g(str, (String) null, nVar, a, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer, 0, 114);
                j0 j0Var = this.a;
                i.b(j0Var.c, j0Var.d, composer, 0);
                h0.l(this.a, this.b, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final j0 j0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(600101638);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(j0Var)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(600101638, i2, -1, "com.dragon.read.kmp.search.card.InfoArea (IpSubscribeVideoCard.kt:107)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier B = SizeKt.B(SizeKt.x(aVar, pg4.j.c(84, startRestartGroup, 6)), (e.c) null, false, 3, (Object) null);
            p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, B);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a4 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a4);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, a2, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier D = SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null);
            androidx.compose.ui.text.e a5 = uc4.a.a(j0Var.e + '\n', j0Var.f, startRestartGroup, 0);
            s.a aVar2 = w0.s.b;
            int b4 = aVar2.b();
            long h = x0.x.h(14);
            og4.a aVar3 = og4.a.a;
            int i4 = og4.a.b;
            a6.k(a5, D, aVar3.h(startRestartGroup, i4).k(), h, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b4, false, 2, 0, (Map) null, (Function1) null, (g3) null, startRestartGroup, 3120, 3120, 251888);
            a3.a(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(4)), startRestartGroup, 6);
            Modifier D2 = SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null);
            composer2 = startRestartGroup;
            a6.j(j0Var.g, D2, aVar3.h(startRestartGroup, i4).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar2.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3120, 3120, 120816);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i5;
                    i5 = h0.i(j0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final j0 j0Var, final k0 k0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-974721485);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(j0Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(k0Var);
            } else {
                changedInstance = startRestartGroup.changedInstance(k0Var);
            }
            if (changedInstance) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-974721485, i2, -1, "com.dragon.read.kmp.search.card.HeaderArea (IpSubscribeVideoCard.kt:84)");
            }
            androidx.compose.foundation.layout.u.c(androidx.compose.foundation.layout.f2.v(SizeKt.i(SizeKt.x(Modifier.Companion, pg4.j.c(84, startRestartGroup, 6)), pg4.j.c(126, startRestartGroup, 6)), 0.0f, 0.0f, 0.0f, x0.i.g(8), 7, (Object) null), (androidx.compose.ui.e) null, false, androidx.compose.runtime.internal.t.e(-1572334455, true, new a(j0Var, k0Var), startRestartGroup, 54), startRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = h0.g(j0.this, k0Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    public static final void j(final MutableState<j0> state, final k0 depend, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(depend, "depend");
        Composer startRestartGroup = composer.startRestartGroup(-755417353);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(state)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(depend);
            } else {
                changedInstance = startRestartGroup.changedInstance(depend);
            }
            if (changedInstance) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-755417353, i2, -1, "com.dragon.read.kmp.search.card.IpSubscribeVideoCard (IpSubscribeVideoCard.kt:67)");
            }
            pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(1114473384, true, new b(depend, (j0) state.getValue()), startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = h0.k(state, depend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final j0 j0Var, final k0 k0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        List listOf;
        boolean z2;
        boolean changedInstance;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1762919251);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(j0Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(k0Var);
            } else {
                changedInstance = startRestartGroup.changedInstance(k0Var);
            }
            if (changedInstance) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1762919251, i2, -1, "com.dragon.read.kmp.search.card.SubscribeButton (IpSubscribeVideoCard.kt:134)");
            }
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier.a aVar = Modifier.Companion;
            Modifier i5 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(40));
            e.a aVar2 = androidx.compose.ui.e.a;
            Modifier b2 = boxScopeInstance.b(i5, aVar2.b());
            p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, b2);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a4 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a4);
            } else {
                startRestartGroup.useNode();
            }
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, a2, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                b3.updateRememberedValue(Integer.valueOf(a3));
                b3.apply(Integer.valueOf(a3), b4);
            }
            g5.e(b3, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.Companion;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = uc4.a.b(Integer.valueOf(GradientOrientation.TOP_BOTTOM.getValue()));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Pair pair = (Pair) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier i6 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(10));
            c0.a aVar3 = androidx.compose.ui.graphics.c0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.b(j0Var.j & 16777215)), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.n0.b(j0Var.j))});
            androidx.compose.foundation.layout.m.b(BackgroundKt.b(i6, c0.a.h(aVar3, listOf, ((a0.f) pair.getFirst()).t(), ((a0.f) pair.getSecond()).t(), 0, 8, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), startRestartGroup, 0);
            float f = 0;
            float f2 = 4;
            Modifier d = BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.f(aVar, 0.0f, 1, (Object) null), k.g.d(x0.i.g(f), x0.i.g(f), x0.i.g(f2), x0.i.g(f2))), androidx.compose.ui.graphics.n0.b(j0Var.j), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, d);
            Function0 a6 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a6);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, i7, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                b5.updateRememberedValue(Integer.valueOf(a5));
                b5.apply(Integer.valueOf(a5), b6);
            }
            g5.e(b5, e2, companion.d());
            Modifier d2 = BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.h(androidx.compose.foundation.layout.f2.t(aVar, x0.i.g(6), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null), x0.i.g(24)), k.g.c(x0.i.g(20))), og4.a.a.h(startRestartGroup, og4.a.b).I(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 112) != 32 && ((i2 & 64) == 0 || !startRestartGroup.changedInstance(k0Var))) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean changedInstance2 = startRestartGroup.changedInstance(j0Var) | z2;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: dn4.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit n;
                        n = h0.n(k0.this, j0Var);
                        return n;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
            p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, modifier);
            Function0 a8 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a8);
            } else {
                startRestartGroup.useNode();
            }
            Composer b7 = g5.b(startRestartGroup);
            g5.e(b7, i8, companion.c());
            g5.e(b7, currentCompositionLocalMap3, companion.e());
            Function2 b8 = companion.b();
            if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a7))) {
                b7.updateRememberedValue(Integer.valueOf(a7));
                b7.apply(Integer.valueOf(a7), b8);
            }
            g5.e(b7, e3, companion.d());
            composer2 = startRestartGroup;
            a6.j(j0Var.h, boxScopeInstance.b(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar2.e()), androidx.compose.ui.graphics.n0.b(j0Var.i), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131024);
            composer2.endNode();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = h0.m(j0.this, k0Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }
}
