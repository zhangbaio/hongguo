package com.dragon.read.kmp.shortvideo.distribution.page.tab.item;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.layout.r0;
import androidx.compose.ui.layout.s0;
import androidx.compose.ui.layout.t0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.y2;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.a0;
import androidx.constraintlayout.compose.t0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SubscribeOpType;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.e50;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.fx;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.q20;
import com.bytedance.kmp.reading.model.qn0;
import com.dragon.read.kmp.shortvideo.distribution.page.conent.u0;
import com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel;
import com.dragon.read.kmp.shortvideo.distribution.page.tab.item.o0;
import com.dragon.read.kmp.shortvideo.distribution.page.view.RankingNumberViewKt;
import com.ss.ttm.player.MediaPlayer;
import gk4.q0;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o0 {
    static {
        Covode.recordClassIndex(609083);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(String str, int i2, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        A(str, i2, modifier, composer, x2.a(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(io4.g gVar, u0 u0Var, int i2, Composer composer, int i3) {
        D(gVar, u0Var, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(io4.g gVar, SeriesRankTabViewModel seriesRankTabViewModel, u0 u0Var, int i2, Composer composer, int i3) {
        F(gVar, seriesRankTabViewModel, u0Var, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(io4.g gVar, SeriesRankTabViewModel seriesRankTabViewModel, u0 u0Var, int i2, Composer composer, int i3) {
        F(gVar, seriesRankTabViewModel, u0Var, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(Modifier modifier, String str, u0 u0Var, int i2, int i3, Composer composer, int i4) {
        J(modifier, str, u0Var, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Modifier modifier, SeriesRankTabViewModel seriesRankTabViewModel, int i2, io4.g gVar, boolean z, int i3, int i4, Composer composer, int i5) {
        L(modifier, seriesRankTabViewModel, i2, gVar, z, composer, x2.a(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(om0 om0Var, u0 u0Var, boolean z, int i2, Composer composer, int i3) {
        q(om0Var, u0Var, z, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(om0 om0Var, u0 u0Var, boolean z, int i2, Composer composer, int i3) {
        q(om0Var, u0Var, z, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(om0 om0Var, u0 u0Var, boolean z, int i2, Composer composer, int i3) {
        q(om0Var, u0Var, z, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(io4.g gVar, u0 u0Var, int i2, Composer composer, int i3) {
        u(gVar, u0Var, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(io4.g gVar, u0 u0Var, int i2, Composer composer, int i3) {
        u(gVar, u0Var, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(io4.g gVar, u0 u0Var, int i2, Composer composer, int i3) {
        u(gVar, u0Var, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(int i2, io4.g gVar, boolean z, int i3, Composer composer, int i4) {
        y(i2, gVar, z, composer, x2.a(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H() {
        return Unit.INSTANCE;
    }

    static final class g implements Function3<e90, Composer, Integer, Unit> {
        final /* synthetic */ SeriesRankTabViewModel a;
        final /* synthetic */ io4.g b;

        g(SeriesRankTabViewModel seriesRankTabViewModel, io4.g gVar) {
            this.a = seriesRankTabViewModel;
            this.b = gVar;
        }

        static final class a implements Function0<Unit> {
            final /* synthetic */ e90 a;
            final /* synthetic */ SeriesRankTabViewModel b;
            final /* synthetic */ io4.g c;

            a(e90 e90Var, SeriesRankTabViewModel seriesRankTabViewModel, io4.g gVar) {
                this.a = e90Var;
                this.b = seriesRankTabViewModel;
                this.c = gVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }

            public final void a() {
                boolean z;
                String str = this.a.f;
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    SeriesRankTabViewModel seriesRankTabViewModel = this.b;
                    io4.g gVar = this.c;
                    String str2 = this.a.f;
                    if (str2 == null) {
                        return;
                    }
                    seriesRankTabViewModel.E(gVar, str2);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(e90 e90Var, Composer composer, Integer num) {
            a(e90Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(e90 content, Composer composer, int i) {
            long h;
            Intrinsics.checkNotNullParameter(content, "content");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1749607161, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.SubscribeLayout.<anonymous>.<anonymous> (VideoRankingListCard.kt:418)");
            }
            String str = content.a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Modifier.a aVar = Modifier.Companion;
            Boolean bool = content.b;
            Boolean bool2 = Boolean.TRUE;
            boolean areEqual = Intrinsics.areEqual(bool, bool2);
            composer.startReplaceGroup(-1746271574);
            boolean changedInstance = composer.changedInstance(content) | composer.changedInstance(this.a) | composer.changedInstance(this.b);
            SeriesRankTabViewModel seriesRankTabViewModel = this.a;
            io4.g gVar = this.b;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new a(content, seriesRankTabViewModel, gVar);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(aVar, areEqual, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 14, (Object) null);
            int b = w0.s.b.b();
            if (Intrinsics.areEqual(content.c, bool2)) {
                composer.startReplaceGroup(-2040249998);
                h = og4.a.a.h(composer, og4.a.b).Y();
            } else {
                composer.startReplaceGroup(-2040248787);
                h = og4.a.a.h(composer, og4.a.b).h();
            }
            composer.endReplaceGroup();
            a6.j(str2, modifier, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b, false, 1, 0, (Function1) null, new g3(h, x0.x.h(11), androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777208, (DefaultConstructorMarker) null), composer, 0, 3120, 55292);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final class c implements Function0<Unit> {
        final /* synthetic */ MutableState a;
        final /* synthetic */ ConstraintSetForInlineDsl b;

        public c(MutableState mutableState, ConstraintSetForInlineDsl constraintSetForInlineDsl) {
            this.a = mutableState;
            this.b = constraintSetForInlineDsl;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            this.a.setValue(Boolean.valueOf(!((Boolean) r0.getValue()).booleanValue()));
            this.b.d = true;
        }
    }

    static final class i implements Function0<Unit> {
        final /* synthetic */ om0 a;
        final /* synthetic */ io4.g b;
        final /* synthetic */ SeriesRankTabViewModel c;

        i(om0 om0Var, io4.g gVar, SeriesRankTabViewModel seriesRankTabViewModel) {
            this.a = om0Var;
            this.b = gVar;
            this.c = seriesRankTabViewModel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            String str;
            long j;
            SubscribeOpType subscribeOpType;
            tb4.k a2 = eo0.c.a.a(Reflection.getOrCreateKotlinClass(tb4.k.class));
            if (a2 != null) {
                String str2 = this.a.p;
                if (str2 != null) {
                    j = Long.parseLong(str2);
                } else {
                    j = 0;
                }
                if (((Boolean) this.b.e.getValue()).booleanValue()) {
                    subscribeOpType = SubscribeOpType.CancelSubscribe;
                } else {
                    subscribeOpType = SubscribeOpType.Subscribe;
                }
                a2.y3(j, 1, subscribeOpType, "预约失败，请重试", "取消预约失败，请重试", new a(this.b));
            }
            no4.b bVar = this.c.t;
            io4.g gVar = this.b;
            if (((Boolean) gVar.e.getValue()).booleanValue()) {
                str = "reserve_cancel";
            } else {
                str = "reserve";
            }
            bVar.m(gVar, str);
        }

        static final class a implements Function2<SubscribeOpType, Boolean, Unit> {
            final /* synthetic */ io4.g a;

            a(io4.g gVar) {
                this.a = gVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(SubscribeOpType subscribeOpType, Boolean bool) {
                a(subscribeOpType, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void a(SubscribeOpType opType, boolean z) {
                boolean z2;
                Intrinsics.checkNotNullParameter(opType, "opType");
                if (z) {
                    MutableState<Boolean> mutableState = this.a.e;
                    if (opType != SubscribeOpType.CancelSubscribe) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    mutableState.setValue(Boolean.valueOf(z2));
                }
            }
        }
    }

    public static final class b implements p0 {
        final /* synthetic */ MutableState c;
        final /* synthetic */ androidx.constraintlayout.compose.c0 d;
        final /* synthetic */ ConstraintSetForInlineDsl e;
        final /* synthetic */ int f;
        final /* synthetic */ MutableState g;

        public b(MutableState mutableState, androidx.constraintlayout.compose.c0 c0Var, ConstraintSetForInlineDsl constraintSetForInlineDsl, int i, MutableState mutableState2) {
            this.c = mutableState;
            this.d = c0Var;
            this.e = constraintSetForInlineDsl;
            this.f = i;
            this.g = mutableState2;
        }

        public /* synthetic */ int b(androidx.compose.ui.layout.s sVar, List list, int i) {
            return androidx.compose.ui.layout.o0.c(this, sVar, list, i);
        }

        public /* synthetic */ int c(androidx.compose.ui.layout.s sVar, List list, int i) {
            return androidx.compose.ui.layout.o0.d(this, sVar, list, i);
        }

        public /* synthetic */ int d(androidx.compose.ui.layout.s sVar, List list, int i) {
            return androidx.compose.ui.layout.o0.a(this, sVar, list, i);
        }

        public /* synthetic */ int f(androidx.compose.ui.layout.s sVar, List list, int i) {
            return androidx.compose.ui.layout.o0.b(this, sVar, list, i);
        }

        public static final class a implements Function1<p1.a, Unit> {
            final /* synthetic */ androidx.constraintlayout.compose.c0 a;
            final /* synthetic */ List b;

            public a(androidx.constraintlayout.compose.c0 c0Var, List list) {
                this.a = c0Var;
                this.b = list;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(p1.a aVar) {
                a(aVar);
                return Unit.INSTANCE;
            }

            public final void a(p1.a layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                this.a.g(layout, this.b);
            }
        }

        public final r0 a(t0 MeasurePolicy, List<? extends androidx.compose.ui.layout.n0> measurables, long j) {
            Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            this.c.getValue();
            long h = this.d.h(j, MeasurePolicy.getLayoutDirection(), this.e, measurables, this.f);
            this.g.getValue();
            return s0.b(MeasurePolicy, x0.t.g(h), x0.t.f(h), (Map) null, new a(this.d, measurables), 4, (Object) null);
        }
    }

    public static final class d implements Function1<androidx.compose.ui.semantics.x, Unit> {
        final /* synthetic */ androidx.constraintlayout.compose.c0 a;

        public d(androidx.constraintlayout.compose.c0 c0Var) {
            this.a = c0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.semantics.x xVar) {
            a(xVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.ui.semantics.x semantics) {
            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
            androidx.constraintlayout.compose.r0.a(semantics, this.a);
        }
    }

    static final class f implements Function1<androidx.constraintlayout.compose.h, Unit> {
        final /* synthetic */ androidx.constraintlayout.compose.i a;

        f(androidx.constraintlayout.compose.i iVar) {
            this.a = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            t0.a.a(constrainAs.d, constrainAs.c.d, 0.0f, 0.0f, 6, (Object) null);
            float f = 6;
            a0.a.a(constrainAs.f, constrainAs.c.f, x0.i.g(f), 0.0f, 4, (Object) null);
            a0.a.a(constrainAs.i, constrainAs.c.i, x0.i.g(f), 0.0f, 4, (Object) null);
            t0.a.a(constrainAs.g, this.a.d, x0.i.g(12), 0.0f, 4, (Object) null);
            constrainAs.h(androidx.constraintlayout.compose.x.a.a());
        }
    }

    static final class h implements Function1<androidx.constraintlayout.compose.h, Unit> {
        public static final h a = new h();

        h() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            float f = 5;
            a0.a.a(constrainAs.f, constrainAs.c.f, x0.i.g(f), 0.0f, 4, (Object) null);
            a0.a.a(constrainAs.i, constrainAs.c.i, x0.i.g(f), 0.0f, 4, (Object) null);
            t0.a.a(constrainAs.g, constrainAs.c.g, 0.0f, 0.0f, 6, (Object) null);
        }
    }

    public static final class e implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MutableState a;
        final /* synthetic */ ConstraintLayoutScope b;
        final /* synthetic */ Function0 c;
        final /* synthetic */ om0 d;
        final /* synthetic */ io4.g e;
        final /* synthetic */ SeriesRankTabViewModel f;

        public e(MutableState mutableState, ConstraintLayoutScope constraintLayoutScope, Function0 function0, om0 om0Var, io4.g gVar, SeriesRankTabViewModel seriesRankTabViewModel) {
            this.a = mutableState;
            this.b = constraintLayoutScope;
            this.c = function0;
            this.d = om0Var;
            this.e = gVar;
            this.f = seriesRankTabViewModel;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            org.jetbrains.compose.resources.i b;
            long Y;
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1759682870, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:458)");
            }
            this.a.setValue(Unit.INSTANCE);
            ConstraintLayoutScope constraintLayoutScope = this.b;
            int i2 = ((androidx.constraintlayout.compose.l) constraintLayoutScope).c;
            constraintLayoutScope.e();
            ConstraintLayoutScope constraintLayoutScope2 = this.b;
            composer.startReplaceGroup(703558875);
            ConstraintLayoutScope.a i3 = constraintLayoutScope2.i();
            androidx.constraintlayout.compose.i a = i3.a();
            androidx.constraintlayout.compose.i b2 = i3.b();
            Modifier.a aVar = Modifier.Companion;
            composer.startReplaceGroup(5004770);
            boolean changed = composer.changed(b2);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new f(b2);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier g = constraintLayoutScope2.g(aVar, a, (Function1) rememberedValue);
            List list = this.d.s0;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            com.dragon.read.kmp.basenovel.ui.widget.s.b(g, list, 0, 0.0f, n.a.a(), androidx.compose.runtime.internal.t.e(-1749607161, true, new g(this.f, this.e), composer, 54), composer, 221184, 12);
            if (((Boolean) this.e.e.getValue()).booleanValue()) {
                composer.startReplaceGroup(576933328);
                b = u75.v.a(u75.u.a);
            } else {
                composer.startReplaceGroup(576934827);
                b = u75.v.b(u75.u.a);
            }
            String c = org.jetbrains.compose.resources.j.c(b, composer, 0);
            composer.endReplaceGroup();
            composer.startReplaceGroup(1849434622);
            Object rememberedValue2 = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = h.a;
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            Modifier g2 = constraintLayoutScope2.g(aVar, b2, (Function1) rememberedValue2);
            composer.startReplaceGroup(-1746271574);
            boolean changedInstance = composer.changedInstance(this.d) | composer.changedInstance(this.e) | composer.changedInstance(this.f);
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new i(this.d, this.e, this.f);
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(g2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null);
            if (((Boolean) this.e.e.getValue()).booleanValue()) {
                composer.startReplaceGroup(576969357);
                Y = og4.a.a.h(composer, og4.a.b).d();
            } else {
                composer.startReplaceGroup(576970418);
                Y = og4.a.a.h(composer, og4.a.b).Y();
            }
            composer.endReplaceGroup();
            a6.j(c, modifier, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, new g3(Y, x0.x.h(12), androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777208, (DefaultConstructorMarker) null), composer, 0, 0, 65532);
            composer.endReplaceGroup();
            if (((androidx.constraintlayout.compose.l) this.b).c != i2) {
                EffectsKt.SideEffect(this.c, composer, 6);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final g3 P(Composer composer, int i2) {
        composer.startReplaceGroup(-1769344815);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1769344815, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.subTitleTextStyle (VideoRankingListCard.kt:318)");
        }
        g3 g3Var = new g3(og4.a.a.h(composer, og4.a.b).h(), x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, x0.x.h(16), (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return g3Var;
    }

    static final class a implements p0 {
        final /* synthetic */ Ref$FloatRef c;
        final /* synthetic */ Ref$FloatRef d;

        a(Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2) {
            this.c = ref$FloatRef;
            this.d = ref$FloatRef2;
        }

        public /* synthetic */ int b(androidx.compose.ui.layout.s sVar, List list, int i) {
            return androidx.compose.ui.layout.o0.c(this, sVar, list, i);
        }

        public /* synthetic */ int c(androidx.compose.ui.layout.s sVar, List list, int i) {
            return androidx.compose.ui.layout.o0.d(this, sVar, list, i);
        }

        public /* synthetic */ int d(androidx.compose.ui.layout.s sVar, List list, int i) {
            return androidx.compose.ui.layout.o0.a(this, sVar, list, i);
        }

        public /* synthetic */ int f(androidx.compose.ui.layout.s sVar, List list, int i) {
            return androidx.compose.ui.layout.o0.b(this, sVar, list, i);
        }

        public final r0 a(androidx.compose.ui.layout.t0 Layout, List<? extends androidx.compose.ui.layout.n0> measurables, long j) {
            int coerceAtLeast;
            Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            int l = x0.b.l(j);
            final p1 L = measurables.get(0).L(x0.c.b(0, l, 0, 0, 12, (Object) null));
            final p1 L2 = measurables.get(2).L(x0.c.b(0, l, 0, 0, 12, (Object) null));
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((l - L.a) - L2.a, 0);
            final p1 L3 = measurables.get(1).L(x0.c.b(0, coerceAtLeast, 0, 0, 12, (Object) null));
            int i = L3.b;
            final Ref$FloatRef ref$FloatRef = this.c;
            final Ref$FloatRef ref$FloatRef2 = this.d;
            return s0.b(Layout, l, i, (Map) null, new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.n0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit g;
                    g = o0.a.g(L, L3, L2, ref$FloatRef, ref$FloatRef2, (p1.a) obj);
                    return g;
                }
            }, 4, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(p1 p1Var, p1 p1Var2, p1 p1Var3, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, p1.a layout) {
            Intrinsics.checkNotNullParameter(layout, "$this$layout");
            p1.a.N(layout, p1Var, 0, 0, 0.0f, 4, (Object) null);
            p1.a.N(layout, p1Var2, p1Var.a, 0, 0.0f, 4, (Object) null);
            p1.a.N(layout, p1Var3, ((int) ref$FloatRef.element) + p1Var.a, (int) ref$FloatRef2.element, 0.0f, 4, (Object) null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, y2 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        int k = it2.k();
        int i2 = k - 1;
        ref$FloatRef.element = it2.s(i2);
        ref$FloatRef2.element = it2.q(i2);
        com.dragon.read.kmp.j.a.a("HotCommentText", "hotCommentText lineCount:" + k + " yPosition:" + ref$FloatRef.element + " xPosition:" + ref$FloatRef2.element);
        return Unit.INSTANCE;
    }

    private static final Modifier O(Modifier modifier, boolean z, Composer composer, int i2) {
        composer.startReplaceGroup(1434736854);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1434736854, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.setHeight (VideoRankingListCard.kt:390)");
        }
        if (!z) {
            Modifier i3 = SizeKt.i(modifier, x0.i.g(102));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return i3;
        }
        Modifier i4 = SizeKt.i(modifier, x0.i.g(94));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return i4;
    }

    private static final void D(final io4.g gVar, final u0 u0Var, Composer composer, final int i2) {
        int i3;
        boolean z;
        Integer num;
        qn0 qn0Var;
        List list;
        List list2;
        String str;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1865409739);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(gVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i3 = i5 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(u0Var)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1865409739, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.RecommendTagContainer (VideoRankingListCard.kt:158)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h2 = SizeKt.h(f2.v(aVar, 0.0f, u0Var.g(), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
            p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, h2);
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
            g5.e(b3, e2, companion.d());
            w2 w2Var = w2.b;
            om0 videoData = gVar.getVideoData();
            if (videoData != null) {
                num = videoData.y;
            } else {
                num = null;
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new xc4.j(0, 0, 16, u0Var.h(), (androidx.compose.ui.text.font.c0) null, 0, (xc4.n) null, 115, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            xc4.j jVar = (xc4.j) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (gVar.d()) {
                startRestartGroup.startReplaceGroup(1483522348);
                int value = VideoContentType.Movie.getValue();
                if (num != null && num.intValue() == value) {
                    str = "电影";
                } else {
                    str = "电视剧";
                }
                xc4.m.g(str, jVar, startRestartGroup, 48);
                float g2 = x0.i.g(4);
                startRestartGroup.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(aVar, g2), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
                list = null;
            } else {
                startRestartGroup.startReplaceGroup(1483726390);
                om0 videoData2 = gVar.getVideoData();
                if (videoData2 != null) {
                    qn0Var = videoData2.y0;
                } else {
                    qn0Var = null;
                }
                list = null;
                if (xc4.m.i(jVar, qn0Var, 0L, 0L, 0L, startRestartGroup, 6, 28)) {
                    float g3 = x0.i.g(4);
                    startRestartGroup.startReplaceGroup(-344996060);
                    a3.a(SizeKt.x(aVar, g3), startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endReplaceGroup();
            }
            om0 videoData3 = gVar.getVideoData();
            if (videoData3 != null) {
                list2 = videoData3.s0;
            } else {
                list2 = list;
            }
            com.dragon.read.kmp.shortvideo.distribution.page.view.i.e(list2, u0Var.h(), u0Var.g(), startRestartGroup, 0, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit E;
                    E = o0.E(io4.g.this, u0Var, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return E;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x00bf, code lost:
    
        r5 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r5, new java.lang.String[]{"·"}, false, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void u(final io4.g r34, final com.dragon.read.kmp.shortvideo.distribution.page.conent.u0 r35, androidx.compose.runtime.Composer r36, final int r37) {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.o0.u(io4.g, com.dragon.read.kmp.shortvideo.distribution.page.conent.u0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit M(io4.g gVar, SeriesRankTabViewModel seriesRankTabViewModel, int i2, Ref$ObjectRef ref$ObjectRef, Context context) {
        if (gVar.g()) {
            seriesRankTabViewModel.q0(gVar);
            return Unit.INSTANCE;
        }
        seriesRankTabViewModel.t.i(gVar, i2);
        if (gVar.b()) {
            seriesRankTabViewModel.t.g(gVar, i2);
        }
        seriesRankTabViewModel.S(gVar, i2, (View) ((q0) ref$ObjectRef.element).a, context);
        return Unit.INSTANCE;
    }

    private static final void q(final om0 om0Var, final u0 u0Var, final boolean z, Composer composer, final int i2) {
        int i3;
        boolean z2;
        Composer composer2;
        int i4;
        String str;
        boolean z3;
        boolean z4;
        fx fxVar;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-652142154);
        int currentMarker = startRestartGroup.getCurrentMarker();
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(om0Var)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(u0Var)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652142154, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.BuildDesText (VideoRankingListCard.kt:186)");
            }
            if (om0Var == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.x
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit r;
                            r = o0.r(om0Var, u0Var, z, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return r;
                        }
                    });
                    return;
                }
                return;
            }
            if (z) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            List list = om0Var.c1;
            if (list != null && (fxVar = (fx) CollectionsKt___CollectionsKt.getOrNull(list, 0)) != null) {
                str = fxVar.e;
            } else {
                str = null;
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h2 = SizeKt.h(SizeKt.k(f2.v(aVar, 0.0f, u0Var.c(), 0.0f, 0.0f, 13, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
            p0 i8 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, h2);
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
            g5.e(b2, i8, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            startRestartGroup.startReplaceGroup(577643286);
            if (str != null && str.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                startRestartGroup.startReplaceGroup(577675091);
                String str2 = om0Var.j;
                if (str2 != null && str2.length() != 0) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    startRestartGroup.endToMarker(currentMarker);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.e0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit s;
                                s = o0.s(om0Var, u0Var, z, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return s;
                            }
                        });
                        return;
                    }
                    return;
                }
                a6.j(str2, SizeKt.h(aVar, 0.0f, 1, (Object) null), 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, i4, 0, (Function1) null, P(startRestartGroup, 0), startRestartGroup, 48, 48, 55292);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(578020958);
                A(str, i4, aVar, composer2, 384, 0);
                composer2.endReplaceGroup();
            }
            composer2.endReplaceGroup();
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
            endRestartGroup3.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t;
                    t = o0.t(om0Var, u0Var, z, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return t;
                }
            });
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v6 ??, still in use, count: 1, list:
          (r5v6 ?? I:java.lang.Object) from 0x01d9: INVOKE (r11v0 ?? I:androidx.compose.runtime.Composer), (r5v6 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:84410841)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private static final void F(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v6 ??, still in use, count: 1, list:
          (r5v6 ?? I:java.lang.Object) from 0x01d9: INVOKE (r11v0 ?? I:androidx.compose.runtime.Composer), (r5v6 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:84410841)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r22v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
    
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void y(final int r28, final io4.g r29, final boolean r30, androidx.compose.runtime.Composer r31, final int r32) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.o0.y(int, io4.g, boolean, androidx.compose.runtime.Composer, int):void");
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
    private static final void J(androidx.compose.ui.Modifier r30, final java.lang.String r31, final com.dragon.read.kmp.shortvideo.distribution.page.conent.u0 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.o0.J(androidx.compose.ui.Modifier, java.lang.String, com.dragon.read.kmp.shortvideo.distribution.page.conent.u0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0136, code lost:
    
        if (r0 == null) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0054  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Object, java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void A(final java.lang.String r39, int r40, final androidx.compose.ui.Modifier r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.o0.A(java.lang.String, int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [T, gk4.q0] */
    public static final void L(Modifier modifier, final SeriesRankTabViewModel tabViewModel, final int i2, final io4.g data, final boolean z, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        Modifier modifier3;
        boolean z3;
        Object u0Var;
        q20 q20Var;
        int i11;
        int i12;
        Modifier modifier4;
        String str;
        e50 e50Var;
        boolean z4;
        float j;
        Intrinsics.checkNotNullParameter(tabViewModel, "tabViewModel");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(587415570);
        int i13 = i4 & 1;
        if (i13 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i5 = i6 | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            if (startRestartGroup.changedInstance(tabViewModel)) {
                i7 = 32;
            } else {
                i7 = 16;
            }
            i5 |= i7;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            if (startRestartGroup.changed(i2)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i5 |= i8;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            if (startRestartGroup.changedInstance(data)) {
                i9 = 2048;
            } else {
                i9 = 1024;
            }
            i5 |= i9;
        }
        if ((i4 & 16) != 0) {
            i5 |= 24576;
        } else if ((i3 & 24576) == 0) {
            if (startRestartGroup.changed(z)) {
                i10 = 16384;
            } else {
                i10 = 8192;
            }
            i5 |= i10;
        }
        int i14 = i5;
        if ((i14 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i14 & 1)) {
            if (i13 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(587415570, i14, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.item.VideoRankingListCard (VideoRankingListCard.kt:93)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = Boolean.valueOf(po4.b.i());
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            boolean booleanValue = ((Boolean) rememberedValue).booleanValue();
            startRestartGroup.endReplaceGroup();
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new q0(null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            ref$ObjectRef.element = (q0) rememberedValue2;
            startRestartGroup.startReplaceGroup(5004770);
            if ((57344 & i14) == 16384) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == companion.getEmpty()) {
                if (z) {
                    if (booleanValue) {
                        u0Var = new com.dragon.read.kmp.shortvideo.distribution.page.conent.t0();
                    } else {
                        u0Var = new com.dragon.read.kmp.shortvideo.distribution.page.conent.s0();
                    }
                } else {
                    u0Var = new u0();
                }
                rememberedValue3 = u0Var;
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            u0 u0Var2 = (u0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Modifier modifier5 = modifier3;
            Modifier v = f2.v(tc4.f.e(SizeKt.h(modifier3, 0.0f, 1, (Object) null), false, (String) null, (Role) null, new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit M;
                    M = o0.M(io4.g.this, tabViewModel, i2, ref$ObjectRef, (Context) obj);
                    return M;
                }
            }, startRestartGroup, 0, 7), u0Var2.i(), 0.0f, u0Var2.d(), u0Var2.a(), 2, (Object) null);
            e.a aVar = androidx.compose.ui.e.a;
            e.c i15 = aVar.i();
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            p0 b2 = r2.b(eVar.h(), i15, startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, v);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a3 = companion2.a();
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
            g5.e(b3, b2, companion2.c());
            g5.e(b3, currentCompositionLocalMap, companion2.e());
            Function2 b4 = companion2.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e2, companion2.d());
            w2 w2Var = w2.b;
            int i16 = i14 >> 6;
            y(i2, data, z, startRestartGroup, (i16 & 896) | (i16 & 14) | (i16 & 112));
            om0 videoData = data.getVideoData();
            if (videoData != null) {
                q20Var = videoData.b1;
            } else {
                q20Var = null;
            }
            Modifier modifier6 = Modifier.Companion;
            Modifier h2 = SizeKt.h(modifier6, 0.0f, 1, (Object) null);
            p0 b5 = r2.b(eVar.h(), aVar.l(), startRestartGroup, 54);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, h2);
            Function0 a5 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a5);
            } else {
                startRestartGroup.useNode();
            }
            Composer b6 = g5.b(startRestartGroup);
            g5.e(b6, b5, companion2.c());
            g5.e(b6, currentCompositionLocalMap2, companion2.e());
            Function2 b7 = companion2.b();
            if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a4))) {
                b6.updateRememberedValue(Integer.valueOf(a4));
                b6.apply(Integer.valueOf(a4), b7);
            }
            g5.e(b6, e3, companion2.d());
            if (z) {
                startRestartGroup.startReplaceGroup(502595069);
                float b8 = u0Var2.b();
                startRestartGroup.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(modifier6, b8), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                int i17 = i2 + 1;
                if (booleanValue) {
                    j = x0.i.g((float) 2.5d);
                } else {
                    j = u0Var2.j();
                }
                i11 = i14;
                modifier4 = modifier6;
                RankingNumberViewKt.e(q20Var, i17, j, false, startRestartGroup, 0, 8);
                float f2 = u0Var2.f();
                startRestartGroup.startReplaceGroup(-344996060);
                Modifier x = SizeKt.x(modifier4, f2);
                i12 = 0;
                a3.a(x, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
            } else {
                i11 = i14;
                i12 = 0;
                modifier4 = modifier6;
                startRestartGroup.startReplaceGroup(502841798);
                float g2 = x0.i.g(12);
                startRestartGroup.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(modifier4, g2), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
            }
            Modifier h3 = SizeKt.h(modifier4, 0.0f, 1, (Object) null);
            p0 a6 = androidx.compose.foundation.layout.x.a(eVar.d(), aVar.k(), startRestartGroup, 54);
            int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, i12));
            androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e4 = ComposedModifierKt.e(startRestartGroup, h3);
            Function0 a8 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a8);
            } else {
                startRestartGroup.useNode();
            }
            Composer b9 = g5.b(startRestartGroup);
            g5.e(b9, a6, companion2.c());
            g5.e(b9, currentCompositionLocalMap3, companion2.e());
            Function2 b10 = companion2.b();
            if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a7))) {
                b9.updateRememberedValue(Integer.valueOf(a7));
                b9.apply(Integer.valueOf(a7), b10);
            }
            g5.e(b9, e4, companion2.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier h4 = SizeKt.h(modifier4, 0.0f, 1, (Object) null);
            p0 b11 = r2.b(eVar.h(), aVar.i(), startRestartGroup, 54);
            int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e5 = ComposedModifierKt.e(startRestartGroup, h4);
            Function0 a10 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a10);
            } else {
                startRestartGroup.useNode();
            }
            Composer b12 = g5.b(startRestartGroup);
            g5.e(b12, b11, companion2.c());
            g5.e(b12, currentCompositionLocalMap4, companion2.e());
            Function2 b13 = companion2.b();
            if (b12.getInserting() || !Intrinsics.areEqual(b12.rememberedValue(), Integer.valueOf(a9))) {
                b12.updateRememberedValue(Integer.valueOf(a9));
                b12.apply(Integer.valueOf(a9), b13);
            }
            g5.e(b12, e5, companion2.d());
            Modifier a11 = u2.a(w2Var, modifier4, 1.0f, false, 2, (Object) null);
            om0 videoData2 = data.getVideoData();
            if (videoData2 == null || (str = videoData2.e) == null) {
                str = "";
            }
            J(a11, str, u0Var2, startRestartGroup, 0, 0);
            Modifier v2 = f2.v(modifier4, x0.i.g(8), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            om0 videoData3 = data.getVideoData();
            if (videoData3 != null) {
                e50Var = videoData3.N0;
            } else {
                e50Var = null;
            }
            int i18 = i11;
            xc4.c.c(v2, e50Var, u0Var2.e(), 0L, startRestartGroup, 6, 8);
            startRestartGroup.endNode();
            int i19 = (i18 >> 9) & 14;
            u(data, u0Var2, startRestartGroup, i19);
            boolean g3 = data.g();
            if (!data.e() && !data.d() && !data.f()) {
                z4 = false;
            } else {
                z4 = true;
            }
            q(data.getVideoData(), u0Var2, z4, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-1752972039);
            if (z4 && !g3) {
                D(data, u0Var2, startRestartGroup, i19);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1752967255);
            if (g3) {
                F(data, tabViewModel, u0Var2, startRestartGroup, (i18 & 112) | i19);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.item.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit N;
                    N = o0.N(modifier7, tabViewModel, i2, data, z, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    return N;
                }
            });
        }
    }
}
