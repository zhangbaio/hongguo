package com.dragon.read.kmp.rank;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.bookmall.l5;
import com.dragon.read.component.biz.impl.bookmall.r4;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.service.d1;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import pg4.t;
import w0.s;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    static {
        Covode.recordClassIndex(608228);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(fe4.n nVar, r rVar, int i, Composer composer, int i2) {
        y(nVar, rVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(r rVar, fe4.n nVar, int i, Composer composer, int i2) {
        l(rVar, nVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(int i, Composer composer, int i2) {
        n(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(fe4.n nVar, r rVar, int i, Composer composer, int i2) {
        p(nVar, rVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(fe4.a aVar, r rVar, int i, Composer composer, int i2) {
        r(aVar, rVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(fe4.n nVar, int i, Composer composer, int i2) {
        w(nVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(r rVar, Context context) {
        rVar.P0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(r rVar, Context context) {
        rVar.Q0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(r rVar, fe4.a aVar) {
        rVar.S0(aVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(r rVar, Context context) {
        rVar.Q0();
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ fe4.n a;
        final /* synthetic */ r b;

        a(fe4.n nVar, r rVar) {
            this.a = nVar;
            this.b = rVar;
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
                    ComposerKt.traceEventStart(1780606356, i, -1, "com.dragon.read.kmp.rank.CategoryRank2ColCard.<anonymous> (KmpRank2ColCard.kt:54)");
                }
                m.y(this.a, this.b, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final void n(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1956483084);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1956483084, i, -1, "com.dragon.read.kmp.rank.CategoryRank2ColCardBottomArea (KmpRank2ColCard.kt:223)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 8;
            Modifier a2 = androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), k.g.c(x0.i.g(f)));
            og4.a aVar2 = og4.a.a;
            int i2 = og4.a.b;
            Modifier d = BackgroundKt.d(a2, aVar2.h(startRestartGroup, i2).o(), (f2) null, 2, (Object) null);
            e.a aVar3 = androidx.compose.ui.e.a;
            p0 i3 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, d);
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
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i3, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                b.updateRememberedValue(Integer.valueOf(a3));
                b.apply(Integer.valueOf(a3), b2);
            }
            g5.e(b, e, companion.d());
            composer2 = startRestartGroup;
            a6.j("查看全部", androidx.compose.foundation.layout.f2.t(BoxScopeInstance.a.b(aVar, aVar3.e()), 0.0f, x0.i.g(f), 1, (Object) null), aVar2.h(startRestartGroup, i2).T2(), x.h(14), (y) null, c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199686, 3120, 120784);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.rank.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = m.o(i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(r rVar, fe4.a aVar, Context context) {
        rVar.R0(aVar, context);
        return Unit.INSTANCE;
    }

    public static final void w(final fe4.n viewState, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        org.jetbrains.compose.resources.b x;
        org.jetbrains.compose.resources.b z2;
        Modifier modifier;
        org.jetbrains.compose.resources.b B;
        int i3;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Composer startRestartGroup = composer.startRestartGroup(-1208769625);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(viewState)) {
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
                ComposerKt.traceEventStart(-1208769625, i2, -1, "com.dragon.read.kmp.rank.CategoryRank2ColCardTopArea (KmpRank2ColCard.kt:101)");
            }
            boolean d = d1.d((Theme) startRestartGroup.consume(rg4.e.l()));
            Modifier modifier2 = Modifier.Companion;
            float f = 16;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(modifier2, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(f), 7, (Object) null);
            e.e h = androidx.compose.foundation.layout.e.a.h();
            e.a aVar = androidx.compose.ui.e.a;
            p0 b = r2.b(h, aVar.l(), startRestartGroup, 0);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            l5 l5Var = l5.a;
            if (d) {
                x = r4.w(l5Var);
            } else {
                x = r4.x(l5Var);
            }
            float f2 = 2;
            z0.g(org.jetbrains.compose.resources.c.a(x, startRestartGroup, 0), "category rank card left curly braces", w2Var.b(androidx.compose.foundation.layout.f2.v(SizeKt.u(modifier2, x0.i.g(10), x0.i.g(f)), 0.0f, 0.0f, x0.i.g(f2), 0.0f, 11, (Object) null), aVar.i()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, startRestartGroup, 48, 248);
            Modifier v2 = androidx.compose.foundation.layout.f2.v(modifier2, 0.0f, 0.0f, x0.i.g(f2), 0.0f, 11, (Object) null);
            String str = viewState.a;
            og4.a aVar2 = og4.a.a;
            int i4 = og4.a.b;
            long T2 = aVar2.h(startRestartGroup, i4).T2();
            long h2 = x.h(14);
            c0.a aVar3 = c0.b;
            c0 a4 = aVar3.a();
            s.a aVar4 = s.b;
            a6.j(str, v2, T2, h2, (y) null, a4, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199728, 3120, 120784);
            l5 l5Var2 = l5.a;
            if (d) {
                z2 = r4.y(l5Var2);
            } else {
                z2 = r4.z(l5Var2);
            }
            float f3 = 4;
            z0.g(org.jetbrains.compose.resources.c.a(z2, startRestartGroup, 0), "category rank card right curly braces", w2Var.b(androidx.compose.foundation.layout.f2.v(SizeKt.u(modifier2, x0.i.g(12), x0.i.g(f)), 0.0f, 0.0f, x0.i.g(f3), 0.0f, 11, (Object) null), aVar.i()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, startRestartGroup, 48, 248);
            startRestartGroup.startReplaceGroup(-2142426748);
            if (!StringsKt__StringsKt.isBlank(viewState.b)) {
                if (d) {
                    B = r4.A(l5.a);
                } else {
                    B = r4.B(l5.a);
                }
                modifier = modifier2;
                z0.g(org.jetbrains.compose.resources.c.a(B, startRestartGroup, 0), "category rank card divider point", w2Var.b(androidx.compose.foundation.layout.f2.v(SizeKt.u(modifier, x0.i.g(6), x0.i.g(f2)), 0.0f, 0.0f, x0.i.g(f3), 0.0f, 11, (Object) null), aVar.i()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, startRestartGroup, 48, 248);
            } else {
                modifier = modifier2;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j(viewState.b, modifier, aVar2.h(startRestartGroup, i4).T2(), x.h(14), (y) null, aVar3.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199728, 3120, 120784);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.rank.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x2;
                    x2 = m.x(viewState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return x2;
                }
            });
        }
    }

    public static final void l(final r viewModel, final fe4.n cardState, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(cardState, "cardState");
        Composer startRestartGroup = composer.startRestartGroup(-1466301339);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(viewModel)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(cardState)) {
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
                ComposerKt.traceEventStart(-1466301339, i2, -1, "com.dragon.read.kmp.rank.CategoryRank2ColCard (KmpRank2ColCard.kt:52)");
            }
            pg4.p.e(new pg4.h((t) null, (t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(1780606356, true, new a(cardState, viewModel), startRestartGroup, 54), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.rank.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = m.m(r.this, cardState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }

    public static final void p(final fe4.n viewState, final r viewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(145801521);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(viewState)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(viewModel)) {
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
                ComposerKt.traceEventStart(145801521, i2, -1, "com.dragon.read.kmp.rank.CategoryRank2ColCardContentArea (KmpRank2ColCard.kt:149)");
            }
            Iterator it2 = viewState.f.iterator();
            while (it2.hasNext()) {
                r((fe4.a) it2.next(), viewModel, startRestartGroup, i2 & 112);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.rank.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = m.q(viewState, viewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }

    public static final void r(final fe4.a viewState, final r viewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        org.jetbrains.compose.resources.b L;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-1004679480);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(viewState)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(viewModel)) {
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
                ComposerKt.traceEventStart(-1004679480, i2, -1, "com.dragon.read.kmp.rank.CategoryRank2ColCardItem (KmpRank2ColCard.kt:158)");
            }
            boolean d = d1.d((Theme) startRestartGroup.consume(rg4.e.l()));
            Modifier.a aVar = Modifier.Companion;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(12), 7, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.rank.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit s;
                        s = m.s(r.this, (Context) obj);
                        return s;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(viewState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.rank.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit t;
                        t = m.t(r.this, viewState, (Context) obj);
                        return t;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier g = tc4.f.g(v, false, (String) null, (Role) null, (String) null, function1, (Function1) null, (Function1) rememberedValue2, startRestartGroup, 6, 47);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(viewState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.rank.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit u;
                        u = m.u(r.this, viewState);
                        return u;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Modifier b = hk4.c.b(g, viewState, (Function0) rememberedValue3);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.e h = eVar.h();
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 b2 = r2.b(h, aVar2.l(), startRestartGroup, 0);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, b);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e, companion.d());
            w2 w2Var = w2.b;
            if (d) {
                L = r4.K(l5.a);
            } else {
                L = r4.L(l5.a);
            }
            String str = viewState.d;
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            nVar.e = L;
            Unit unit = Unit.INSTANCE;
            float f = 6;
            LoadImageKt.g(str, "category rank card item cover", nVar, androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.x(aVar, x0.i.g(44)), x0.i.g(62)), k.g.c(x0.i.g(f))), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 48, 112);
            z0.g(org.jetbrains.compose.resources.c.a(viewState.e, startRestartGroup, 0), "category rank card item left curly braces", w2Var.b(androidx.compose.foundation.layout.f2.v(SizeKt.i(SizeKt.x(aVar, x0.i.g(20)), x0.i.g(18)), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null), aVar2.l()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, startRestartGroup, 48, 248);
            Modifier a4 = u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
            p0 a5 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, a4);
            Function0 a7 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, a5, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a6))) {
                b5.updateRememberedValue(Integer.valueOf(a6));
                b5.apply(Integer.valueOf(a6), b6);
            }
            g5.e(b5, e2, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier v2 = androidx.compose.foundation.layout.f2.v(aVar, 0.0f, 0.0f, 0.0f, x0.i.g(4), 7, (Object) null);
            String str2 = viewState.b;
            og4.a aVar3 = og4.a.a;
            int i5 = og4.a.b;
            long k = aVar3.h(startRestartGroup, i5).k();
            long h2 = x.h(14);
            c0.a aVar4 = c0.b;
            c0 e3 = aVar4.e();
            s.a aVar5 = s.b;
            a6.j(str2, v2, k, h2, (y) null, e3, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar5.b(), false, 2, 0, (Function1) null, (g3) null, startRestartGroup, 199728, 3120, 120784);
            composer2 = startRestartGroup;
            a6.j(viewState.c, aVar, aVar3.h(startRestartGroup, i5).X0(), x.h(12), (y) null, aVar4.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar5.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199728, 3120, 120784);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.rank.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v3;
                    v3 = m.v(viewState, viewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return v3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final fe4.n nVar, final r rVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Modifier modifier;
        Object obj;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1595634647);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(nVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(rVar)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        int i5 = i2;
        if ((i5 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1595634647, i5, -1, "com.dragon.read.kmp.rank.CategoryRank2ColCardUi (KmpRank2ColCard.kt:60)");
            }
            boolean d = d1.d((Theme) startRestartGroup.consume(rg4.e.l()));
            Modifier modifier2 = Modifier.Companion;
            Modifier d2 = BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.h(modifier2, 0.0f, 1, (Object) null), k.g.c(x0.i.g(nVar.e))), og4.a.a.h(startRestartGroup, og4.a.b).w(), (f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(rVar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.rank.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit z2;
                        z2 = m.z(r.this, (Context) obj2);
                        return z2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance2 = startRestartGroup.changedInstance(rVar);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.rank.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit A;
                        A = m.A(r.this, (Context) obj2);
                        return A;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier g = tc4.f.g(d2, false, (String) null, (Role) null, (String) null, function1, (Function1) null, (Function1) rememberedValue2, startRestartGroup, 0, 47);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i6 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, g);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i6, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            startRestartGroup.startReplaceGroup(1646880887);
            if (!d) {
                modifier = modifier2;
                obj = null;
                LoadImageKt.g(nVar.c, "category rank card bg", (com.dragon.read.kmp.compose.common.image.n) null, AspectRatioKt.b(SizeKt.h(modifier, 0.0f, 1, (Object) null), 1.4022347f, false, 2, (Object) null), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 3120, 116);
            } else {
                modifier = modifier2;
                obj = null;
            }
            startRestartGroup.endReplaceGroup();
            Modifier s = androidx.compose.foundation.layout.f2.s(SizeKt.h(modifier, 0.0f, 1, obj), x0.i.g(12), x0.i.g(16));
            p0 a4 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar.k(), startRestartGroup, 0);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, a4, companion.c());
            g5.e(b3, currentCompositionLocalMap2, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                b3.updateRememberedValue(Integer.valueOf(a5));
                b3.apply(Integer.valueOf(a5), b4);
            }
            g5.e(b3, e2, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            int i7 = i5 & 14;
            w(nVar, startRestartGroup, i7);
            p(nVar, rVar, startRestartGroup, i7 | (i5 & 112));
            n(startRestartGroup, 0);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.rank.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit B;
                    B = m.B(nVar, rVar, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return B;
                }
            });
        }
    }
}
