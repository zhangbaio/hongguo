package com.dragon.read.kmp.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SubscribeOpType;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.q40;
import com.bytedance.kmp.reading.model.qn0;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {
    static {
        Covode.recordClassIndex(609591);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(gk4.h0 h0Var, d0 d0Var, boolean z, Function1 function1, int i, Composer composer, int i2) {
        A(h0Var, d0Var, z, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(List list, d0 d0Var, int i, Composer composer, int i2) {
        E(list, d0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(int i, gk4.h0 h0Var, d0 d0Var, int i2, Composer composer, int i3) {
        G(i, h0Var, d0Var, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(gk4.h0 h0Var, d0 d0Var, int i, Composer composer, int i2) {
        I(h0Var, d0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(int i, gk4.h0 h0Var, com.dragon.read.kmp.viewmodel.o oVar, int i2, Composer composer, int i3) {
        K(i, h0Var, oVar, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(String str, long j, int i, Composer composer, int i2) {
        R(str, j, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Modifier modifier, String str, d0 d0Var, int i, int i2, Composer composer, int i3) {
        T(modifier, str, d0Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(gk4.h0 h0Var, d0 d0Var, boolean z, Function1 function1, int i, Composer composer, int i2) {
        t(h0Var, d0Var, z, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(String str, d0 d0Var, int i, int i2, int i3, Composer composer, int i4) {
        x(str, d0Var, i, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(String str, d0 d0Var, int i, int i2, int i3, Composer composer, int i4) {
        x(str, d0Var, i, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function1 function1, gk4.h0 h0Var) {
        function1.invoke(h0Var);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1, gk4.h0 h0Var) {
        function1.invoke(h0Var);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<e90, Composer, Integer, Unit> {
        final /* synthetic */ d0 a;

        a(d0 d0Var) {
            this.a = d0Var;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(e90 e90Var, Composer composer, Integer num) {
            a(e90Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(e90 info, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880693091, i, -1, "com.dragon.read.kmp.view.RecommendTagContainer.<anonymous>.<anonymous> (RelationSeriesDialogItem.kt:308)");
            }
            String str = info.a;
            if (str == null) {
                str = "";
            }
            c0.R(str, this.a.e(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(gk4.h0 h0Var, SubscribeOpType opType, boolean z) {
        Intrinsics.checkNotNullParameter(opType, "opType");
        com.dragon.read.kmp.j.a.a("RelationSeriesDialogItem", "RelationSeriesDialogItem BuildSubscribeBtn requestSubscribe, item=" + h0Var + ", opType=" + opType + ", result=" + z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(gk4.h0 h0Var, com.dragon.read.kmp.viewmodel.o oVar, int i) {
        Boolean bool;
        om0 om0Var = h0Var.c.b;
        ym4.s sVar = null;
        if (om0Var != null) {
            bool = Boolean.valueOf(com.dragon.read.kmp.util.j.d(om0Var));
        } else {
            bool = null;
        }
        if (com.dragon.read.kmp.utils.g0.a(bool)) {
            ym4.m mVar = ym4.m.a;
            om0 om0Var2 = h0Var.c.b;
            gk4.g0 E0 = oVar.E0();
            if (E0 != null) {
                sVar = E0.e;
            }
            ym4.m.j(mVar, true, om0Var2, sVar, null, 8, null);
        } else {
            ym4.m mVar2 = ym4.m.a;
            om0 om0Var3 = h0Var.c.b;
            gk4.g0 E02 = oVar.E0();
            if (E02 != null) {
                sVar = E02.e;
            }
            mVar2.k(true, om0Var3, sVar, i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(com.dragon.read.kmp.viewmodel.o oVar, gk4.h0 h0Var, gk4.h0 it2) {
        Integer num;
        Intrinsics.checkNotNullParameter(it2, "it");
        gk4.g0 E0 = oVar.E0();
        if (E0 != null) {
            num = Integer.valueOf(E0.a);
        } else {
            num = null;
        }
        int d = q40.d();
        String str = "video_relation_series_panel";
        if (num == null || num.intValue() != d) {
            int b = q40.b();
            if (num != null && num.intValue() == b) {
                str = "actor_related_series_panel";
            } else {
                int c = q40.c();
                if (num != null && num.intValue() == c) {
                    str = "brand_related_series_panel";
                }
            }
        }
        om0 om0Var = h0Var.c.b;
        if (om0Var == null) {
            return Unit.INSTANCE;
        }
        kd4.c.a(om0Var, str, true);
        com.dragon.read.kmp.j.a.a("RelationSeriesDialogItem", "RelationSeriesDialogItem BuildCollectBtn click, item=" + h0Var);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit Q(gk4.h0 r12, com.dragon.read.kmp.viewmodel.o r13, int r14) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.view.c0.Q(gk4.h0, com.dragon.read.kmp.viewmodel.o, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(final gk4.h0 h0Var, boolean z, com.dragon.read.kmp.viewmodel.o oVar, gk4.h0 it2) {
        SubscribeOpType subscribeOpType;
        long j;
        String str;
        Intrinsics.checkNotNullParameter(it2, "it");
        com.dragon.read.kmp.j.a.a("RelationSeriesDialogItem", "RelationSeriesDialogItem BuildSubscribeBtn click, item=" + h0Var);
        if (!z) {
            subscribeOpType = SubscribeOpType.Subscribe;
        } else {
            subscribeOpType = SubscribeOpType.CancelSubscribe;
        }
        SubscribeOpType subscribeOpType2 = subscribeOpType;
        String str2 = h0Var.d;
        ym4.s sVar = null;
        if (!(!StringsKt__StringsKt.isBlank(str2))) {
            str2 = null;
        }
        if (str2 != null) {
            j = Long.parseLong(str2);
        } else {
            j = 0;
        }
        com.dragon.read.kmp.subscribe.t.f(com.dragon.read.kmp.subscribe.t.a, j, 1, subscribeOpType2, null, null, new Function2() { // from class: com.dragon.read.kmp.view.l
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit N;
                N = c0.N(gk4.h0.this, (SubscribeOpType) obj, ((Boolean) obj2).booleanValue());
                return N;
            }
        }, 24, null);
        if (z) {
            str = "reserve_cancel";
        } else {
            str = "reserve";
        }
        ym4.m mVar = ym4.m.a;
        om0 om0Var = h0Var.c.b;
        gk4.g0 E0 = oVar.E0();
        if (E0 != null) {
            sVar = E0.e;
        }
        mVar.i(false, om0Var, sVar, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final String str, final long j, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        float g;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(337892928);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(j)) {
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
                ComposerKt.traceEventStart(337892928, i5, -1, "com.dragon.read.kmp.view.TagView (RelationSeriesDialogItem.kt:317)");
            }
            long h = x0.x.h(16);
            og4.a aVar = og4.a.a;
            long p = aVar.d().p();
            int b = w0.s.b.b();
            Modifier.a aVar2 = Modifier.Companion;
            wc4.a c = wc4.c.c();
            if (c != null) {
                g = c.t4();
            } else {
                g = x0.i.g(4);
            }
            composer2 = startRestartGroup;
            a6.j(str, f2.s(BackgroundKt.d(ig4.i.c(aVar2, x0.i.d(g), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), aVar.d().t0(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(4), x0.i.g(1)), p, j, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, h, b, false, 1, 0, (Function1) null, (g3) null, composer2, (i5 & 14) | ((i5 << 6) & 7168), 3126, 119792);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit S;
                    S = c0.S(str, j, i, (Composer) obj, ((Integer) obj2).intValue());
                    return S;
                }
            });
        }
    }

    private static final void E(final List<e90> list, final d0 d0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(240721936);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(d0Var)) {
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
                ComposerKt.traceEventStart(240721936, i2, -1, "com.dragon.read.kmp.view.BuildTagLayout (RelationSeriesDialogItem.kt:191)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(f2.v(aVar, 0.0f, d0Var.g(), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
            androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, h);
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
            g5.e(b, i5, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            b bVar = b.a;
            com.dragon.read.kmp.basenovel.ui.widget.s.b(h2, list, 0, 0.0f, bVar.a(), bVar.b(), startRestartGroup, ((i2 << 3) & 112) | 221190, 12);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit F;
                    F = c0.F(list, d0Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return F;
                }
            });
        }
    }

    private static final void I(final gk4.h0 h0Var, final d0 d0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1595424039);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(h0Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(d0Var)) {
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
                ComposerKt.traceEventStart(-1595424039, i2, -1, "com.dragon.read.kmp.view.RecommendTagContainer (RelationSeriesDialogItem.kt:289)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(f2.v(aVar, 0.0f, d0Var.d(), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
            androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, h);
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
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new xc4.j(0, 1, 16, d0Var.e(), (androidx.compose.ui.text.font.c0) null, 0, (xc4.n) null, 113, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            qn0 e2 = h0Var.e();
            og4.a aVar2 = og4.a.a;
            int i5 = og4.a.b;
            boolean i6 = xc4.m.i((xc4.j) rememberedValue, e2, aVar2.h(startRestartGroup, i5).r(), aVar2.h(startRestartGroup, i5).r(), 0L, startRestartGroup, 6, 16);
            startRestartGroup.startReplaceGroup(-42455531);
            if (i6) {
                float g = x0.i.g(4);
                startRestartGroup.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(aVar, g), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endReplaceGroup();
            com.dragon.read.kmp.basenovel.ui.widget.s.b(aVar, h0Var.d(), 0, 0.0f, b.a.c(), androidx.compose.runtime.internal.t.e(-880693091, true, new a(d0Var), startRestartGroup, 54), startRestartGroup, 221190, 12);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit J;
                    J = c0.J(gk4.h0.this, d0Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return J;
                }
            });
        }
    }

    private static final void G(final int i, final gk4.h0 h0Var, final d0 d0Var, Composer composer, final int i2) {
        int i3;
        boolean z;
        String str;
        org.jetbrains.compose.resources.b V;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1025569766);
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(h0Var)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 = i5 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(d0Var)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & 145) != 144) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1025569766, i3, -1, "com.dragon.read.kmp.view.CoverLayout (RelationSeriesDialogItem.kt:385)");
            }
            boolean d = com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
            float g = x0.i.g(6);
            Modifier.a aVar = Modifier.Companion;
            Modifier b = AspectRatioKt.b(SizeKt.i(ig4.i.c(aVar, x0.i.d(g), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), d0Var.c()), 0.7058824f, false, 2, (Object) null);
            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i6, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            om0 om0Var = h0Var.c.b;
            if (om0Var == null || (str = om0Var.b) == null) {
                str = "";
            }
            Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            if (d) {
                V = d2.U(f2.a.a);
            } else {
                V = d2.V(f2.a.a);
            }
            nVar.e = V;
            LoadImageKt.g(str, (String) null, nVar, f, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 3072, 114);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit H;
                    H = c0.H(i, h0Var, d0Var, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return H;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0423, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x048b, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03c0, code lost:
    
        if (r15 != false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00eb, code lost:
    
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void K(final int r35, final gk4.h0 r36, final com.dragon.read.kmp.viewmodel.o r37, androidx.compose.runtime.Composer r38, final int r39) {
        /*
            Method dump skipped, instructions count: 1225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.view.c0.K(int, gk4.h0, com.dragon.read.kmp.viewmodel.o, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void T(androidx.compose.ui.Modifier r30, final java.lang.String r31, final com.dragon.read.kmp.view.d0 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.view.c0.T(androidx.compose.ui.Modifier, java.lang.String, com.dragon.read.kmp.view.d0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void x(final java.lang.String r58, final com.dragon.read.kmp.view.d0 r59, int r60, androidx.compose.runtime.Composer r61, final int r62, final int r63) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.view.c0.x(java.lang.String, com.dragon.read.kmp.view.d0, int, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void A(final gk4.h0 h0Var, final d0 d0Var, final boolean z, final Function1<? super gk4.h0, Unit> function1, Composer composer, final int i) {
        int i2;
        boolean z2;
        float f;
        String str;
        long Z;
        Modifier b;
        int i3;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-495735123);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(h0Var)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(d0Var)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        if ((i2 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-495735123, i2, -1, "com.dragon.read.kmp.view.BuildSubscribeBtn (RelationSeriesDialogItem.kt:255)");
            }
            Modifier.a aVar = Modifier.Companion;
            if (z) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            Modifier a2 = androidx.compose.ui.draw.a.a(aVar, f);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.view.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit B;
                        B = c0.B();
                        return B;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(a2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a4 = companion2.a();
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
            g5.e(b2, i7, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (z) {
                str = "已预约";
            } else {
                str = "预约";
            }
            String str2 = str;
            if (z) {
                startRestartGroup.startReplaceGroup(-508709165);
                Z = og4.a.a.h(startRestartGroup, og4.a.b).N();
            } else {
                startRestartGroup.startReplaceGroup(-508707275);
                Z = og4.a.a.h(startRestartGroup, og4.a.b).Z();
            }
            startRestartGroup.endReplaceGroup();
            Modifier c = ig4.i.c(SizeKt.x(aVar, x0.i.g(60)), x0.i.d(d0Var.f()), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
            g3 g3Var = new g3(Z, x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, x0.x.h(16), (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null);
            androidx.compose.ui.text.font.c0 a5 = androidx.compose.ui.text.font.c0.b.a();
            int b4 = w0.s.b.b();
            if (z) {
                startRestartGroup.startReplaceGroup(1410399175);
                b = BackgroundKt.d(c, og4.a.a.h(startRestartGroup, og4.a.b).c0(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1410509783);
                b = BackgroundKt.b(c, c0.a.d(androidx.compose.ui.graphics.c0.b, og4.a.a.h(startRestartGroup, og4.a.b).B(), 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
                startRestartGroup.endReplaceGroup();
            }
            boolean z3 = true;
            Modifier t = androidx.compose.foundation.layout.f2.t(b, 0.0f, x0.i.g(6), 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 7168) != 2048) {
                z3 = false;
            }
            boolean changedInstance = startRestartGroup.changedInstance(h0Var) | z3;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.view.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit C;
                        C = c0.C(Function1.this, h0Var);
                        return C;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            a6.j(str2, ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), 0L, 0L, (androidx.compose.ui.text.font.y) null, a5, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, b4, false, 1, 0, (Function1) null, g3Var, startRestartGroup, 196608, 3120, 54748);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit D;
                    D = c0.D(gk4.h0.this, d0Var, z, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return D;
                }
            });
        }
    }

    private static final void t(final gk4.h0 h0Var, final d0 d0Var, final boolean z, final Function1<? super gk4.h0, Unit> function1, Composer composer, final int i) {
        int i2;
        boolean z2;
        float f;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1604757197);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(h0Var)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(d0Var)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        if ((i2 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1604757197, i2, -1, "com.dragon.read.kmp.view.BuildCollectBtn (RelationSeriesDialogItem.kt:222)");
            }
            com.dragon.read.kmp.j.a.a("RelationSeriesDialogItem", "BuildCollectBtn " + h0Var.d + " isCollected=" + z);
            Modifier.a aVar = Modifier.Companion;
            if (z) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            Modifier a2 = androidx.compose.ui.draw.a.a(aVar, f);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.view.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit u;
                        u = c0.u();
                        return u;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(a2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a4 = companion2.a();
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
            g5.e(b, i7, companion2.c());
            g5.e(b, currentCompositionLocalMap, companion2.e());
            Function2 b2 = companion2.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                b.updateRememberedValue(Integer.valueOf(a3));
                b.apply(Integer.valueOf(a3), b2);
            }
            g5.e(b, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (z) {
                str = "已收藏";
            } else {
                str = "收藏";
            }
            String str2 = str;
            long h = x0.x.h(12);
            long h2 = x0.x.h(16);
            og4.a aVar2 = og4.a.a;
            int i8 = og4.a.b;
            g3 g3Var = new g3(aVar2.h(startRestartGroup, i8).T2(), h, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, h2, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null);
            androidx.compose.ui.text.font.c0 a5 = androidx.compose.ui.text.font.c0.b.a();
            int b3 = w0.s.b.b();
            boolean z3 = true;
            Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(ig4.i.c(SizeKt.x(aVar, x0.i.g(60)), x0.i.d(d0Var.f()), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), aVar2.h(startRestartGroup, i8).o(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), 0.0f, x0.i.g(6), 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 7168) != 2048) {
                z3 = false;
            }
            boolean changedInstance = startRestartGroup.changedInstance(h0Var) | z3;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.view.a0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit v;
                        v = c0.v(Function1.this, h0Var);
                        return v;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            a6.j(str2, ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), 0L, 0L, (androidx.compose.ui.text.font.y) null, a5, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, b3, false, 1, 0, (Function1) null, g3Var, startRestartGroup, 196608, 3120, 54748);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w;
                    w = c0.w(gk4.h0.this, d0Var, z, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return w;
                }
            });
        }
    }
}
