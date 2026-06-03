package com.dragon.read.kmp.share.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.n0;
import androidx.compose.ui.layout.o0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.layout.r0;
import androidx.compose.ui.layout.s0;
import androidx.compose.ui.layout.t0;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.g3;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.a0;
import androidx.constraintlayout.compose.c0;
import androidx.constraintlayout.compose.t0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import xn4.e0;
import xn4.f0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesSharePostViewKt {
    static {
        Covode.recordClassIndex(608989);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(com.dragon.read.kmp.share.business.series.o oVar, int i2, Composer composer, int i3) {
        b(oVar, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final class b implements Function0<Unit> {
        final /* synthetic */ MutableState a;
        final /* synthetic */ ConstraintSetForInlineDsl b;

        public b(MutableState mutableState, ConstraintSetForInlineDsl constraintSetForInlineDsl) {
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

    public static final class a implements p0 {
        final /* synthetic */ MutableState c;
        final /* synthetic */ c0 d;
        final /* synthetic */ ConstraintSetForInlineDsl e;
        final /* synthetic */ int f;
        final /* synthetic */ MutableState g;

        public a(MutableState mutableState, c0 c0Var, ConstraintSetForInlineDsl constraintSetForInlineDsl, int i, MutableState mutableState2) {
            this.c = mutableState;
            this.d = c0Var;
            this.e = constraintSetForInlineDsl;
            this.f = i;
            this.g = mutableState2;
        }

        public /* synthetic */ int b(androidx.compose.ui.layout.s sVar, List list, int i) {
            return o0.c(this, sVar, list, i);
        }

        public /* synthetic */ int c(androidx.compose.ui.layout.s sVar, List list, int i) {
            return o0.d(this, sVar, list, i);
        }

        public /* synthetic */ int d(androidx.compose.ui.layout.s sVar, List list, int i) {
            return o0.a(this, sVar, list, i);
        }

        public /* synthetic */ int f(androidx.compose.ui.layout.s sVar, List list, int i) {
            return o0.b(this, sVar, list, i);
        }

        /* renamed from: com.dragon.read.kmp.share.view.SeriesSharePostViewKt$a$a, reason: collision with other inner class name */
        public static final class C0061a implements Function1<p1.a, Unit> {
            final /* synthetic */ c0 a;
            final /* synthetic */ List b;

            public C0061a(c0 c0Var, List list) {
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

        public final r0 a(t0 MeasurePolicy, List<? extends n0> measurables, long j) {
            Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            this.c.getValue();
            long h = this.d.h(j, MeasurePolicy.getLayoutDirection(), this.e, measurables, this.f);
            this.g.getValue();
            return s0.b(MeasurePolicy, x0.t.g(h), x0.t.f(h), (Map) null, new C0061a(this.d, measurables), 4, (Object) null);
        }
    }

    public static final class c implements Function1<androidx.compose.ui.semantics.x, Unit> {
        final /* synthetic */ c0 a;

        public c(c0 c0Var) {
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

    static final class e implements Function1<androidx.constraintlayout.compose.h, Unit> {
        public static final e a = new e();

        e() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            t0.a.a(constrainAs.d, constrainAs.c.d, 0.0f, 0.0f, 6, (Object) null);
            a0.a.a(constrainAs.f, constrainAs.c.f, 0.0f, 0.0f, 6, (Object) null);
        }
    }

    static final class f implements Function1<androidx.constraintlayout.compose.h, Unit> {
        public static final f a = new f();

        f() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            a0.a.a(constrainAs.f, constrainAs.c.f, x0.i.g(32), 0.0f, 4, (Object) null);
            t0.a.a(constrainAs.d, constrainAs.c.d, x0.i.g(24), 0.0f, 4, (Object) null);
        }
    }

    static final class g implements Function1<androidx.constraintlayout.compose.h, Unit> {
        final /* synthetic */ androidx.constraintlayout.compose.i a;

        g(androidx.constraintlayout.compose.i iVar) {
            this.a = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            t0.a.a(constrainAs.d, this.a.d, x0.i.g(24), 0.0f, 4, (Object) null);
            a0.a.a(constrainAs.f, this.a.f, x0.i.g(48), 0.0f, 4, (Object) null);
        }
    }

    static final class h implements Function1<androidx.constraintlayout.compose.h, Unit> {
        final /* synthetic */ androidx.constraintlayout.compose.i a;

        h(androidx.constraintlayout.compose.i iVar) {
            this.a = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            t0.a.a(constrainAs.d, this.a.d, 0.0f, 0.0f, 6, (Object) null);
            a0.a.a(constrainAs.f, this.a.i, x0.i.g(8), 0.0f, 4, (Object) null);
        }
    }

    static final class i implements Function1<androidx.constraintlayout.compose.h, Unit> {
        final /* synthetic */ androidx.constraintlayout.compose.i a;

        i(androidx.constraintlayout.compose.i iVar) {
            this.a = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            t0.a.a(constrainAs.d, this.a.d, 0.0f, 0.0f, 6, (Object) null);
            a0.a.a(constrainAs.f, constrainAs.c.f, x0.i.g(121), 0.0f, 4, (Object) null);
        }
    }

    static final class j implements Function1<androidx.constraintlayout.compose.h, Unit> {
        public static final j a = new j();

        j() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            t0.a.a(constrainAs.d, constrainAs.c.d, x0.i.g(24), 0.0f, 4, (Object) null);
            a0.a.a(constrainAs.i, constrainAs.c.i, x0.i.g(44), 0.0f, 4, (Object) null);
        }
    }

    static final class k implements Function1<androidx.constraintlayout.compose.h, Unit> {
        final /* synthetic */ androidx.constraintlayout.compose.i a;

        k(androidx.constraintlayout.compose.i iVar) {
            this.a = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            float f = 24;
            t0.a.a(constrainAs.d, this.a.d, x0.i.g(f), 0.0f, 4, (Object) null);
            a0.a.a(constrainAs.i, this.a.i, x0.i.g(f), 0.0f, 4, (Object) null);
        }
    }

    static final class l implements Function1<androidx.constraintlayout.compose.h, Unit> {
        final /* synthetic */ androidx.constraintlayout.compose.i a;

        l(androidx.constraintlayout.compose.i iVar) {
            this.a = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(androidx.constraintlayout.compose.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }

        public final void a(androidx.constraintlayout.compose.h constrainAs) {
            Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
            float f = 24;
            t0.a.a(constrainAs.g, this.a.g, x0.i.g(f), 0.0f, 4, (Object) null);
            a0.a.a(constrainAs.i, this.a.i, x0.i.g(f), 0.0f, 4, (Object) null);
        }
    }

    public static final class d implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MutableState a;
        final /* synthetic */ ConstraintLayoutScope b;
        final /* synthetic */ Function0 c;
        final /* synthetic */ com.dragon.read.kmp.share.business.series.o d;

        public d(MutableState mutableState, ConstraintLayoutScope constraintLayoutScope, Function0 function0, com.dragon.read.kmp.share.business.series.o oVar) {
            this.a = mutableState;
            this.b = constraintLayoutScope;
            this.c = function0;
            this.d = oVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            int i2;
            int i3;
            androidx.constraintlayout.compose.i iVar;
            androidx.constraintlayout.compose.i iVar2;
            androidx.constraintlayout.compose.i iVar3;
            androidx.constraintlayout.compose.i iVar4;
            androidx.constraintlayout.compose.i iVar5;
            androidx.constraintlayout.compose.i iVar6;
            androidx.constraintlayout.compose.i iVar7;
            Modifier modifier;
            int i4;
            ConstraintLayoutScope constraintLayoutScope;
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1759682870, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:458)");
            }
            this.a.setValue(Unit.INSTANCE);
            ConstraintLayoutScope constraintLayoutScope2 = this.b;
            int i5 = ((androidx.constraintlayout.compose.l) constraintLayoutScope2).c;
            constraintLayoutScope2.e();
            ConstraintLayoutScope constraintLayoutScope3 = this.b;
            composer.startReplaceGroup(1271431891);
            ConstraintLayoutScope.a i6 = constraintLayoutScope3.i();
            androidx.constraintlayout.compose.i a = i6.a();
            androidx.constraintlayout.compose.i b = i6.b();
            androidx.constraintlayout.compose.i c = i6.c();
            androidx.constraintlayout.compose.i d = i6.d();
            androidx.constraintlayout.compose.i e = i6.e();
            androidx.constraintlayout.compose.i f = i6.f();
            androidx.constraintlayout.compose.i g = i6.g();
            androidx.constraintlayout.compose.i h = i6.h();
            e1 a2 = un4.i.a(this.d.q);
            composer.startReplaceGroup(179563607);
            if (a2 == null) {
                iVar = h;
                iVar2 = g;
                iVar3 = f;
                iVar4 = e;
                iVar5 = d;
                iVar6 = c;
                iVar7 = b;
                i2 = i5;
                i3 = 1849434622;
            } else {
                Modifier u = SizeKt.u(Modifier.Companion, x0.i.g(300), x0.i.g(481));
                composer.startReplaceGroup(1849434622);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = e.a;
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                i2 = i5;
                i3 = 1849434622;
                iVar = h;
                iVar2 = g;
                iVar3 = f;
                iVar4 = e;
                iVar5 = d;
                iVar6 = c;
                iVar7 = b;
                z0.g(a2, (String) null, BackgroundKt.d(androidx.compose.ui.draw.e.a(constraintLayoutScope3.g(u, a, (Function1) rememberedValue), k.g.c(x0.i.g(16))), l0.b.g(), (f2) null, 2, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 48, 248);
            }
            composer.endReplaceGroup();
            long d2 = androidx.compose.ui.graphics.n0.d(4294600485L);
            float g2 = x0.i.g(1);
            Modifier modifier2 = Modifier.Companion;
            Modifier x = SizeKt.x(modifier2, x0.i.g(33));
            composer.startReplaceGroup(i3);
            Object rememberedValue2 = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = f.a;
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            androidx.compose.material.p0.b(constraintLayoutScope3.g(x, iVar7, (Function1) rememberedValue2), d2, g2, 0.0f, composer, 432, 8);
            String str = this.d.u;
            if (str == null) {
                str = "";
            }
            long h2 = x0.x.h(19);
            l0.a aVar = l0.b;
            long a3 = aVar.a();
            androidx.compose.ui.text.font.c0 a4 = androidx.compose.ui.text.font.c0.b.a();
            int b2 = w0.s.b.b();
            Modifier z = SizeKt.z(modifier2, 0.0f, x0.i.g(252), 1, (Object) null);
            composer.startReplaceGroup(5004770);
            boolean changed = composer.changed(a);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new g(a);
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            androidx.constraintlayout.compose.i iVar8 = iVar6;
            int i7 = i2;
            a6.j(str, constraintLayoutScope3.g(z, iVar8, (Function1) rememberedValue3), a3, h2, (androidx.compose.ui.text.font.y) null, a4, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, b2, false, 1, 0, (Function1) null, (g3) null, composer, 200064, 3120, 120784);
            String str2 = this.d.v;
            if (str2 == null) {
                str2 = "";
            }
            long h3 = x0.x.h(12);
            long n = l0.n(aVar.a(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            composer.startReplaceGroup(5004770);
            boolean changed2 = composer.changed(iVar8);
            Object rememberedValue4 = composer.rememberedValue();
            if (changed2 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new h(iVar8);
                composer.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceGroup();
            androidx.constraintlayout.compose.i iVar9 = iVar5;
            a6.j(str2, constraintLayoutScope3.g(modifier2, iVar9, (Function1) rememberedValue4), n, h3, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3456, 0, 131056);
            e1 a5 = un4.i.a(this.d.p);
            composer.startReplaceGroup(179626820);
            if (a5 == null) {
                modifier = modifier2;
                constraintLayoutScope = constraintLayoutScope3;
                i4 = 5004770;
            } else {
                modifier = modifier2;
                Modifier u2 = SizeKt.u(modifier, x0.i.g(193), x0.i.g(274));
                i4 = 5004770;
                composer.startReplaceGroup(5004770);
                boolean changed3 = composer.changed(iVar9);
                Object rememberedValue5 = composer.rememberedValue();
                if (changed3 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new i(iVar9);
                    composer.updateRememberedValue(rememberedValue5);
                }
                composer.endReplaceGroup();
                constraintLayoutScope = constraintLayoutScope3;
                z0.g(a5, (String) null, BackgroundKt.d(constraintLayoutScope.g(u2, iVar4, (Function1) rememberedValue5), aVar.g(), (f2) null, 2, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 48, 248);
            }
            composer.endReplaceGroup();
            e1 d3 = f0.a.d();
            composer.startReplaceGroup(179643486);
            if (d3 != null) {
                Modifier u3 = SizeKt.u(modifier, x0.i.g(94), x0.i.g(16));
                composer.startReplaceGroup(1849434622);
                Object rememberedValue6 = composer.rememberedValue();
                if (rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = j.a;
                    composer.updateRememberedValue(rememberedValue6);
                }
                composer.endReplaceGroup();
                z0.g(d3, "App Logo", constraintLayoutScope.g(u3, iVar3, (Function1) rememberedValue6), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 48, 248);
            }
            composer.endReplaceGroup();
            String str3 = this.d.t;
            if (str3 == null) {
                str3 = "";
            }
            long h4 = x0.x.h(10);
            long n2 = l0.n(aVar.a(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            composer.startReplaceGroup(i4);
            boolean changed4 = composer.changed(a);
            Object rememberedValue7 = composer.rememberedValue();
            if (changed4 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new k(a);
                composer.updateRememberedValue(rememberedValue7);
            }
            composer.endReplaceGroup();
            ConstraintLayoutScope constraintLayoutScope4 = constraintLayoutScope;
            Modifier modifier3 = modifier;
            a6.j(str3, constraintLayoutScope.g(modifier, iVar2, (Function1) rememberedValue7), n2, h4, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3456, 0, 131056);
            composer.startReplaceGroup(179673732);
            com.dragon.read.kmp.share.business.series.o oVar = this.d;
            if (oVar.s) {
                e1 b3 = e0.a.b((String) FlowExtKt.b(oVar.j, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7).getValue(), 40);
                if (b3 != null) {
                    composer.startReplaceGroup(5004770);
                    boolean changedInstance = composer.changedInstance(this.d);
                    Object rememberedValue8 = composer.rememberedValue();
                    if (changedInstance || rememberedValue8 == companion.getEmpty()) {
                        rememberedValue8 = new SeriesSharePostViewKt$ShortSeriesPostCard$1$8$1$1(this.d, null);
                        composer.updateRememberedValue(rememberedValue8);
                    }
                    composer.endReplaceGroup();
                    EffectsKt.LaunchedEffect(b3, (Function2) rememberedValue8, composer, 0);
                    Modifier s = SizeKt.s(modifier3, x0.i.g(40));
                    composer.startReplaceGroup(5004770);
                    boolean changed5 = composer.changed(a);
                    Object rememberedValue9 = composer.rememberedValue();
                    if (changed5 || rememberedValue9 == companion.getEmpty()) {
                        rememberedValue9 = new l(a);
                        composer.updateRememberedValue(rememberedValue9);
                    }
                    composer.endReplaceGroup();
                    z0.g(b3, "", constraintLayoutScope4.g(s, iVar, (Function1) rememberedValue9), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 48, 248);
                }
            }
            composer.endReplaceGroup();
            composer.endReplaceGroup();
            if (((androidx.constraintlayout.compose.l) this.b).c != i7) {
                EffectsKt.SideEffect(this.c, composer, 6);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final void b(final com.dragon.read.kmp.share.business.series.o videoPlayerPost, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        MutableState mutableState;
        ConstraintSetForInlineDsl constraintSetForInlineDsl;
        int i4;
        Intrinsics.checkNotNullParameter(videoPlayerPost, "videoPlayerPost");
        Composer startRestartGroup = composer.startRestartGroup(-888586199);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(videoPlayerPost)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-888586199, i3, -1, "com.dragon.read.kmp.share.view.ShortSeriesPostCard (SeriesSharePostView.kt:35)");
            }
            Modifier D = SizeKt.D(Modifier.Companion, (androidx.compose.ui.e) null, false, 3, (Object) null);
            startRestartGroup.startReplaceableGroup(-1066585843);
            startRestartGroup.startReplaceableGroup(212083254);
            startRestartGroup.endReplaceableGroup();
            x0.e eVar = (x0.e) startRestartGroup.consume(CompositionLocalsKt.f());
            startRestartGroup.startReplaceableGroup(212164099);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new c0(eVar);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            c0 c0Var = (c0) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(212165609);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new ConstraintLayoutScope();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(212167879);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(212169778);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ConstraintSetForInlineDsl constraintSetForInlineDsl2 = (ConstraintSetForInlineDsl) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(212172058);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState3 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(212175186);
            boolean changedInstance = startRestartGroup.changedInstance(c0Var);
            if (!startRestartGroup.changed(257)) {
                z2 = false;
            } else {
                z2 = true;
            }
            boolean z3 = changedInstance | z2;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (!z3 && rememberedValue6 != companion.getEmpty()) {
                mutableState = mutableState3;
                constraintSetForInlineDsl = constraintSetForInlineDsl2;
            } else {
                mutableState = mutableState3;
                constraintSetForInlineDsl = constraintSetForInlineDsl2;
                a aVar = new a(mutableState3, c0Var, constraintSetForInlineDsl2, 257, mutableState2);
                startRestartGroup.updateRememberedValue(aVar);
                rememberedValue6 = aVar;
            }
            p0 p0Var = (p0) rememberedValue6;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(212196645);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new b(mutableState2, constraintSetForInlineDsl);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            Function0 function0 = (Function0) rememberedValue7;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(212208582);
            boolean changedInstance2 = startRestartGroup.changedInstance(c0Var);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new c(c0Var);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceableGroup();
            LayoutKt.a(androidx.compose.ui.semantics.s.d(D, false, (Function1) rememberedValue8, 1, (Object) null), androidx.compose.runtime.internal.t.b(startRestartGroup, -1759682870, true, new d(mutableState, constraintLayoutScope, function0, videoPlayerPost)), p0Var, startRestartGroup, 48, 0);
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.share.view.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c2;
                    c2 = SeriesSharePostViewKt.c(com.dragon.read.kmp.share.business.series.o.this, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return c2;
                }
            });
        }
    }
}
