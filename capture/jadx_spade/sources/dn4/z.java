package dn4;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.z0;
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
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.service.d1;
import dn4.z;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import sh3.i1;
import sh3.k1;
import w0.s;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z {
    static {
        Covode.recordClassIndex(608750);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(b0 b0Var, int i, Composer composer, int i2) {
        d(b0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(b0 b0Var, int i, Composer composer, int i2) {
        f(b0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(MutableState mutableState, Function1 function1, int i, Composer composer, int i2) {
        h(mutableState, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function1<Integer, Unit> a;
        final /* synthetic */ b0 b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Integer, Unit> function1, b0 b0Var) {
            this.a = function1;
            this.b = b0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function1 function1, b0 b0Var) {
            function1.invoke(Integer.valueOf(b0Var.a));
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
                    ComposerKt.traceEventStart(-43437647, i, -1, "com.dragon.read.kmp.search.card.IpNormalCard.<anonymous> (IpNormalCard.kt:65)");
                }
                Modifier D = SizeKt.D(Modifier.Companion, (androidx.compose.ui.e) null, false, 3, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(this.a) | composer.changedInstance(this.b);
                final Function1<Integer, Unit> function1 = this.a;
                final b0 b0Var = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dn4.a0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = z.b.c(Function1.this, b0Var);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(D, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                b0 b0Var2 = this.b;
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
                z.d(b0Var2, composer, 0);
                z.f(b0Var2, composer, 0);
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

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ b0 a;

        a(b0 b0Var) {
            this.a = b0Var;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            org.jetbrains.compose.resources.b R;
            int i3;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
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
                    ComposerKt.traceEventStart(-707807325, i2, -1, "com.dragon.read.kmp.search.card.HeaderArea.<anonymous> (IpNormalCard.kt:83)");
                }
                Modifier.a aVar = Modifier.Companion;
                boolean z2 = this.a.i;
                float g = x0.i.g((float) 0.5d);
                og4.a aVar2 = og4.a.a;
                int i4 = og4.a.b;
                float f = 4;
                Modifier a = androidx.compose.ui.draw.e.a(SizeKt.f(z.j(aVar, z2, g, aVar2.h(composer, i4).E(), x0.i.g(f)), 0.0f, 1, (Object) null), k.g.c(x0.i.g(f)));
                String str = this.a.b;
                composer.startReplaceGroup(-1597992935);
                com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                if (d1.d(aVar2.e(composer, i4))) {
                    R = d2.Q(f2.a.a);
                } else {
                    R = d2.R(f2.a.a);
                }
                nVar.e = R;
                composer.endReplaceGroup();
                LoadImageKt.g(str, (String) null, nVar, a, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer, 0, 114);
                b0 b0Var = this.a;
                i.b(b0Var.c, b0Var.d, composer, 0);
                if (this.a.h) {
                    z0.g(org.jetbrains.compose.resources.c.a(i1.g(k1.a), composer, 0), (String) null, BoxWithConstraints.b(SizeKt.s(aVar, pg4.j.c(16, composer, 6)), androidx.compose.ui.e.a.e()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, composer, 48, 248);
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

    public static final void d(final b0 data, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-1722818247);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(data)) {
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
                ComposerKt.traceEventStart(-1722818247, i2, -1, "com.dragon.read.kmp.search.card.HeaderArea (IpNormalCard.kt:79)");
            }
            androidx.compose.foundation.layout.u.c(androidx.compose.foundation.layout.f2.v(SizeKt.i(SizeKt.x(Modifier.Companion, pg4.j.c(84, startRestartGroup, 6)), pg4.j.c(126, startRestartGroup, 6)), 0.0f, 0.0f, 0.0f, x0.i.g(8), 7, (Object) null), (androidx.compose.ui.e) null, false, androidx.compose.runtime.internal.t.e(-707807325, true, new a(data), startRestartGroup, 54), startRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = z.e(b0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }

    public static final void f(final b0 data, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(684848218);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(data)) {
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
                ComposerKt.traceEventStart(684848218, i2, -1, "com.dragon.read.kmp.search.card.InfoArea (IpNormalCard.kt:114)");
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
            androidx.compose.ui.text.e a5 = uc4.a.a(data.e + '\n', data.f, startRestartGroup, 0);
            s.a aVar2 = w0.s.b;
            int b4 = aVar2.b();
            long h = x0.x.h(14);
            og4.a aVar3 = og4.a.a;
            int i4 = og4.a.b;
            a6.k(a5, D, aVar3.h(startRestartGroup, i4).k(), h, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b4, false, 2, 0, (Map) null, (Function1) null, (g3) null, startRestartGroup, 3120, 3120, 251888);
            a3.a(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(4)), startRestartGroup, 6);
            Modifier D2 = SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null);
            composer2 = startRestartGroup;
            a6.j(data.g, D2, aVar3.h(startRestartGroup, i4).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar2.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3120, 3120, 120816);
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
            endRestartGroup.a(new Function2() { // from class: dn4.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = z.g(b0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    public static final void h(final MutableState<b0> state, final Function1<? super Integer, Unit> click, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(click, "click");
        Composer startRestartGroup = composer.startRestartGroup(-458685438);
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
            if (startRestartGroup.changedInstance(click)) {
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
                ComposerKt.traceEventStart(-458685438, i2, -1, "com.dragon.read.kmp.search.card.IpNormalCard (IpNormalCard.kt:62)");
            }
            pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(-43437647, true, new b(click, (b0) state.getValue()), startRestartGroup, 54), startRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: dn4.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i5;
                    i5 = z.i(state, click, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i5;
                }
            });
        }
    }

    public static final Modifier j(Modifier conditionalBorder, boolean z, float f, long j, float f2) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter(conditionalBorder, "$this$conditionalBorder");
        if (z) {
            modifier = androidx.compose.foundation.o.h(Modifier.Companion, f, j, k.g.c(f2));
        } else {
            modifier = Modifier.Companion;
        }
        return conditionalBorder.then(modifier);
    }
}
