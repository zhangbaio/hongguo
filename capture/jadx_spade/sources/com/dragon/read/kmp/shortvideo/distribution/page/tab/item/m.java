package com.dragon.read.kmp.shortvideo.distribution.page.tab.item;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.e;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.m2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserRelationType;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.ok0;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.service.d1;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    static {
        Covode.recordClassIndex(609080);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(cj0 cj0Var, UserRelationType userRelationType, int i, Composer composer, int i2) {
        y(cj0Var, userRelationType, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(cj0 cj0Var, UserRelationType userRelationType, int i, Composer composer, int i2) {
        y(cj0Var, userRelationType, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(String str, int i, Composer composer, int i2) {
        C(str, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(String str, int i, Composer composer, int i2) {
        C(str, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(cj0 cj0Var, com.dragon.read.kmp.shortvideo.distribution.page.conent.a aVar, int i, Composer composer, int i2) {
        m(cj0Var, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(cj0 cj0Var, com.dragon.read.kmp.shortvideo.distribution.page.conent.a aVar, int i, Composer composer, int i2) {
        m(cj0Var, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Modifier modifier, String str, com.dragon.read.kmp.shortvideo.distribution.page.conent.a aVar, List list, int i, int i2, Composer composer, int i3) {
        p(modifier, str, aVar, list, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Modifier modifier, int i, io4.a aVar, boolean z, boolean z2, List list, boolean z3, boolean z4, x0.i iVar, float f, Function0 function0, int i2, int i3, int i4, Composer composer, int i5) {
        r(modifier, i, aVar, z, z2, list, z3, z4, iVar, f, function0, composer, x2.a(i2 | 1), x2.a(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(io4.a aVar, int i, int i2, Composer composer, int i3) {
        w(aVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(cj0 cj0Var, UserRelationType userRelationType, int i, Composer composer, int i2) {
        y(cj0Var, userRelationType, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final long t(State<androidx.compose.ui.graphics.l0> state) {
        return ((androidx.compose.ui.graphics.l0) state.getValue()).x();
    }

    private static final boolean G(cj0 cj0Var) {
        long j;
        Long l;
        ok0 ok0Var = cj0Var.b;
        if (ok0Var != null && (l = ok0Var.l) != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        if (j > 0) {
            return true;
        }
        return false;
    }

    private static final boolean H(cj0 cj0Var) {
        String str;
        Map map = cj0Var.f;
        if (map == null || (str = (String) map.get("brand_id")) == null) {
            str = "0";
        }
        if (com.dragon.read.kmp.utils.i0.a.f(str, 0L) > 0) {
            return true;
        }
        return false;
    }

    private static final void C(final String str, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-60531773);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
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
                ComposerKt.traceEventStart(-60531773, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.BuildIntroText (ActorRankingListCard.kt:189)");
            }
            if (str == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit D;
                            D = m.D(str, i, (Composer) obj, ((Integer) obj2).intValue());
                            return D;
                        }
                    });
                    return;
                }
                return;
            }
            composer2 = startRestartGroup;
            com.dragon.read.kmp.shortvideo.distribution.page.view.b.b(str, SizeKt.h(f2.v(Modifier.Companion, 0.0f, x0.i.g(6), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), 0L, 0L, null, null, null, 0L, null, null, x0.x.h(16), o0.P(startRestartGroup, 0), composer2, (i2 & 14) | 48, 6, 1020);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit E;
                    E = m.E(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    return E;
                }
            });
        }
    }

    private static final androidx.compose.ui.text.e F(String str, List<? extends List<Integer>> list, long j) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return new androidx.compose.ui.text.e(str, (List) null, 2, (DefaultConstructorMarker) null);
        }
        e.b bVar = new e.b(str);
        for (List<Integer> list2 : list) {
            if (list2.size() >= 2) {
                int intValue = list2.get(0).intValue();
                int intValue2 = list2.get(1).intValue();
                long j2 = intValue + intValue2;
                if (intValue >= 0 && intValue2 > 0 && j2 <= str.length()) {
                    bVar.b(new m2(j, 0L, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.text.k0) null, (androidx.compose.ui.graphics.drawscope.g) null, 65534, (DefaultConstructorMarker) null), intValue, (int) j2);
                }
            }
        }
        return bVar.q();
    }

    private static final Modifier J(Modifier modifier, boolean z, Composer composer, int i) {
        composer.startReplaceGroup(-822188859);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-822188859, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.setActorPadding (ActorRankingListCard.kt:168)");
        }
        if (z) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifier;
        }
        float f = 16;
        Modifier v = f2.v(modifier, x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(boolean z, float f, State state, androidx.compose.ui.graphics.drawscope.f drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        if (z && androidx.compose.ui.graphics.l0.q(t(state)) > 0.0f) {
            float M0 = drawBehind.M0(f) / 2.0f;
            DrawScope.-CC.p(drawBehind, t(state), a0.f.e((Float.floatToRawIntBits(-M0) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32)), drawBehind.e(), 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (androidx.compose.ui.graphics.m0) null, 0, 120, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final void w(final io4.a aVar, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-115321839);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(aVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i3 = i5 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(i)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        boolean z2 = false;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-115321839, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.ActorRankingTag (ActorRankingListCard.kt:321)");
            }
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changed = startRestartGroup.changed(aVar);
            if ((i3 & 112) == 32) {
                z2 = true;
            }
            boolean z3 = changed | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                u75.t tVar = u75.t.a;
                rememberedValue = new xc4.r(aVar.b(), i + 1, 22, 22, 12, u75.r.b(tVar), u75.r.a(tVar));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            xc4.u.c((xc4.r) rememberedValue, u1.f(Modifier.Companion, x0.i.g(-x0.i.g(1)), 0.0f, 2, (Object) null), startRestartGroup, xc4.r.h | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x;
                    x = m.x(io4.a.this, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return x;
                }
            });
        }
    }

    private static final void m(final cj0 cj0Var, final com.dragon.read.kmp.shortvideo.distribution.page.conent.a aVar, Composer composer, final int i) {
        int i2;
        boolean z;
        String str;
        org.jetbrains.compose.resources.b P;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1906727039);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(cj0Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(aVar)) {
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
                ComposerKt.traceEventStart(1906727039, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.ActorCoverLayout (ActorRankingListCard.kt:284)");
            }
            if (cj0Var == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit n;
                            n = m.n(cj0Var, aVar, i, (Composer) obj, ((Integer) obj2).intValue());
                            return n;
                        }
                    });
                    return;
                }
                return;
            }
            boolean d = d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
            Modifier.a aVar2 = Modifier.Companion;
            Modifier s = SizeKt.s(aVar2, aVar.c());
            p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.c(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i5, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            ok0 ok0Var = cj0Var.b;
            if (ok0Var == null || (str = ok0Var.c) == null) {
                str = "";
            }
            Modifier f = SizeKt.f(ig4.i.c(aVar2, x0.i.d(x0.i.g(aVar.c() / 2)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), 0.0f, 1, (Object) null);
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            if (d) {
                P = d2.O(f2.a.a);
            } else {
                P = d2.P(f2.a.a);
            }
            nVar.e = P;
            LoadImageKt.g(str, (String) null, nVar, f, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 114);
            startRestartGroup.startReplaceGroup(1279348779);
            if (G(cj0Var) || H(cj0Var)) {
                z0.g(org.jetbrains.compose.resources.c.a(d2.o(f2.a.a), startRestartGroup, 0), "auth_actor", SizeKt.s(aVar2, x0.i.g(16)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 432, 248);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = m.o(cj0Var, aVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    private static final void y(final cj0 cj0Var, final UserRelationType userRelationType, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        String str;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1816830167);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(cj0Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(userRelationType.ordinal())) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z2 = true;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1816830167, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.ActorRelationTag (ActorRankingListCard.kt:232)");
            }
            if (cj0Var == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.f
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit z3;
                            z3 = m.z(cj0Var, userRelationType, i, (Composer) obj, ((Integer) obj2).intValue());
                            return z3;
                        }
                    });
                    return;
                }
                return;
            }
            String str2 = cj0Var.a;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            }
            if (!z2 && com.dragon.read.kmp.service.c0.a.isSelf(str2)) {
                str = "我";
            } else if (userRelationType != UserRelationType.Follow && userRelationType != UserRelationType.MutualFollow) {
                str = null;
            } else {
                str = "你的关注";
            }
            if (str == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit A;
                            A = m.A(cj0Var, userRelationType, i, (Composer) obj, ((Integer) obj2).intValue());
                            return A;
                        }
                    });
                    return;
                }
                return;
            }
            float f = 4;
            Modifier a = androidx.compose.ui.draw.e.a(Modifier.Companion, k.g.c(x0.i.g(f)));
            og4.a aVar = og4.a.a;
            int i5 = og4.a.b;
            Modifier s = androidx.compose.foundation.layout.f2.s(BackgroundKt.d(a, aVar.h(startRestartGroup, i5).E(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), x0.i.g(2));
            p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s);
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
            composer2 = startRestartGroup;
            a6.j(str, (Modifier) null, aVar.h(startRestartGroup, i5).j(), x0.x.h(9), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131026);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup3 = composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit B;
                    B = m.B(cj0Var, userRelationType, i, (Composer) obj, ((Integer) obj2).intValue());
                    return B;
                }
            });
        }
    }

    private static final Modifier I(Modifier modifier, boolean z, long j, Composer composer, int i, int i2) {
        long j2;
        composer.startReplaceGroup(401757770);
        if ((i2 & 2) != 0) {
            j2 = androidx.compose.ui.graphics.l0.b.g();
        } else {
            j2 = j;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(401757770, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.setActorCardModifier (ActorRankingListCard.kt:176)");
        }
        if (z) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifier;
        }
        Modifier i3 = SizeKt.i(BackgroundKt.d(BackgroundKt.d(androidx.compose.ui.draw.e.a(modifier, k.g.c(x0.i.g(8))), og4.a.a.h(composer, og4.a.b).w(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), j2, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(88));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d4, code lost:
    
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void p(androidx.compose.ui.Modifier r32, final java.lang.String r33, final com.dragon.read.kmp.shortvideo.distribution.page.conent.a r34, java.util.List<? extends java.util.List<java.lang.Integer>> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.m.p(androidx.compose.ui.Modifier, java.lang.String, com.dragon.read.kmp.shortvideo.distribution.page.conent.a, java.util.List, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:177:0x07d1  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07bb  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r(androidx.compose.ui.Modifier r42, final int r43, final io4.a r44, final boolean r45, boolean r46, java.util.List<? extends java.util.List<java.lang.Integer>> r47, boolean r48, boolean r49, x0.i r50, float r51, final kotlin.jvm.functions.Function0<kotlin.Unit> r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 2031
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.m.r(androidx.compose.ui.Modifier, int, io4.a, boolean, boolean, java.util.List, boolean, boolean, x0.i, float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
