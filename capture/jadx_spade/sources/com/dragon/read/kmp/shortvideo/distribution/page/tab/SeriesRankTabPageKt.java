package com.dragon.read.kmp.shortvideo.distribution.page.tab;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.bj0;
import com.bytedance.kmp.reading.model.q20;
import com.dragon.read.kmp.basenovel.ui.ui.FootLazyColumnKt;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabPageKt;
import com.dragon.read.kmp.shortvideo.distribution.page.tab.item.RecentSupportSectionKt;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRankTabPageKt {
    private static final String a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var, SeriesRankTabViewModel seriesRankTabViewModel, int i, int i2, Composer composer, int i3) {
        B(v0Var, seriesRankTabViewModel, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(androidx.compose.foundation.layout.r rVar, SeriesRankTabViewModel seriesRankTabViewModel, int i, Composer composer, int i2) {
        K(rVar, seriesRankTabViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(androidx.compose.foundation.layout.r rVar, SeriesRankTabViewModel seriesRankTabViewModel, int i, Composer composer, int i2) {
        K(rVar, seriesRankTabViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(SeriesRankTabViewModel seriesRankTabViewModel, int i, int i2, Composer composer, int i3) {
        O(seriesRankTabViewModel, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(int i, co4.a aVar, lo4.a aVar2, io4.b bVar, CollapsibleListState collapsibleListState, com.dragon.read.kmp.shortvideo.distribution.infinite.e eVar, int i2, int i3, Composer composer, int i4) {
        R(i, aVar, aVar2, bVar, collapsibleListState, eVar, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(LazyListState lazyListState, SeriesRankTabViewModel seriesRankTabViewModel, int i, Composer composer, int i2) {
        U(lazyListState, seriesRankTabViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(androidx.compose.foundation.layout.b0 b0Var, SeriesRankTabViewModel seriesRankTabViewModel, int i, Composer composer, int i2) {
        i0(b0Var, seriesRankTabViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(androidx.compose.foundation.layout.r rVar, SeriesRankTabViewModel seriesRankTabViewModel, int i, Composer composer, int i2) {
        l0(rVar, seriesRankTabViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(609076);
        a = "SeriesRankTabPage";
    }

    public static final class a implements DisposableEffectResult {
        final /* synthetic */ int a;
        final /* synthetic */ SeriesRankTabViewModel b;

        public void dispose() {
            com.dragon.read.kmp.j.a.d(SeriesRankTabPageKt.a, "onDestroy " + this.a + " tabModel: " + this.b.hashCode());
            this.b.Z();
        }

        public a(int i, SeriesRankTabViewModel seriesRankTabViewModel) {
            this.a = i;
            this.b = seriesRankTabViewModel;
        }
    }

    static final class b implements Function3<FootLoadingState, Composer, Integer, Unit> {
        final /* synthetic */ SeriesRankTabViewModel a;

        b(SeriesRankTabViewModel seriesRankTabViewModel) {
            this.a = seriesRankTabViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(SeriesRankTabViewModel seriesRankTabViewModel) {
            seriesRankTabViewModel.F(false);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(FootLoadingState footLoadingState, Composer composer, Integer num) {
            b(footLoadingState, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(FootLoadingState state, Composer composer, int i) {
            boolean z;
            int i2;
            Intrinsics.checkNotNullParameter(state, "state");
            if ((i & 6) == 0) {
                if (composer.changed(state.ordinal())) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(382041891, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.TagPageContent.<anonymous>.<anonymous>.<anonymous> (SeriesRankTabPage.kt:274)");
                }
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(this.a);
                final SeriesRankTabViewModel seriesRankTabViewModel = this.a;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.d0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = SeriesRankTabPageKt.b.c(SeriesRankTabViewModel.this);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                FootLazyColumnKt.e(state, (Function0) rememberedValue, (Modifier) null, (g3) null, composer, i & 14, 12);
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
    public static final boolean D(com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var) {
        return ((io4.g) v0Var).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var) {
        return ((io4.a) v0Var).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(SeriesRankTabViewModel seriesRankTabViewModel) {
        seriesRankTabViewModel.a0(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(SeriesRankTabViewModel seriesRankTabViewModel) {
        seriesRankTabViewModel.o0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(SeriesRankTabViewModel seriesRankTabViewModel) {
        seriesRankTabViewModel.p0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(SeriesRankTabViewModel seriesRankTabViewModel) {
        seriesRankTabViewModel.U();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(SeriesRankTabViewModel seriesRankTabViewModel) {
        seriesRankTabViewModel.a0(true);
        return Unit.INSTANCE;
    }

    private static final int X(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(SeriesRankTabViewModel seriesRankTabViewModel) {
        seriesRankTabViewModel.b0(com.dragon.read.kmp.shortvideo.distribution.infinite.h.f(seriesRankTabViewModel.y()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(SeriesRankTabViewModel seriesRankTabViewModel) {
        FilterType filterType;
        if (com.dragon.read.kmp.shortvideo.distribution.infinite.h.l(seriesRankTabViewModel.y())) {
            filterType = FilterType.PANEL;
        } else {
            filterType = FilterType.DEFAULT;
        }
        com.dragon.read.kmp.shortvideo.distribution.infinite.e eVar = seriesRankTabViewModel.C;
        if (eVar != null) {
            eVar.a(seriesRankTabViewModel.y(), filterType);
        }
        seriesRankTabViewModel.t.h("open_category_filter");
        return Unit.INSTANCE;
    }

    private static final void Y(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    static final class d implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ List<io4.f> a;
        final /* synthetic */ boolean b;
        final /* synthetic */ SeriesRankTabViewModel c;

        d(List<io4.f> list, boolean z, SeriesRankTabViewModel seriesRankTabViewModel) {
            this.a = list;
            this.b = z;
            this.c = seriesRankTabViewModel;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2142560527, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.TagPageContent.<anonymous>.<anonymous>.<anonymous> (SeriesRankTabPage.kt:248)");
                }
                List<io4.f> list = this.a;
                boolean z2 = this.b;
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(this.c);
                final SeriesRankTabViewModel seriesRankTabViewModel = this.c;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.e0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit d;
                            d = SeriesRankTabPageKt.d.d(SeriesRankTabViewModel.this, (io4.f) obj, ((Integer) obj2).intValue());
                            return d;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function2 function2 = (Function2) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                boolean changedInstance2 = composer.changedInstance(this.c);
                final SeriesRankTabViewModel seriesRankTabViewModel2 = this.c;
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.f0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit e;
                            e = SeriesRankTabPageKt.d.e(SeriesRankTabViewModel.this, (io4.f) obj, ((Integer) obj2).intValue());
                            return e;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                RecentSupportSectionKt.o(list, z2, function2, (Function2) rememberedValue2, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(SeriesRankTabViewModel seriesRankTabViewModel, io4.f item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            seriesRankTabViewModel.T(item, i);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(SeriesRankTabViewModel seriesRankTabViewModel, io4.f item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            seriesRankTabViewModel.n0(item, i);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(SeriesRankTabViewModel seriesRankTabViewModel, androidx.compose.ui.graphics.drawscope.c drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        seriesRankTabViewModel.e0();
        drawWithContent.E1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(SeriesRankTabViewModel seriesRankTabViewModel, androidx.compose.ui.graphics.drawscope.c drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        seriesRankTabViewModel.e0();
        drawWithContent.E1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(SeriesRankTabViewModel seriesRankTabViewModel, com.dragon.read.kmp.shortvideo.distribution.infinite.d it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        seriesRankTabViewModel.R(it2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(SeriesRankTabViewModel seriesRankTabViewModel, com.dragon.read.kmp.shortvideo.distribution.infinite.d it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        seriesRankTabViewModel.m0(it2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(MutableState mutableState, x0.t tVar) {
        Y(mutableState, (int) (tVar.j() & 4294967295L));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(SeriesRankViewModel seriesRankViewModel, String str) {
        boolean z;
        no4.a.h(seriesRankViewModel.f, "助力明细", null, 2, null);
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            zm4.d.d(zm4.d.a, str, null, com.dragon.read.kmp.utils.k0.a.b(), 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(SeriesRankTabViewModel seriesRankTabViewModel, com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var, String str) {
        seriesRankTabViewModel.t.u(true, (io4.a) v0Var, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var, SeriesRankTabViewModel seriesRankTabViewModel, int i) {
        io4.g gVar = (io4.g) v0Var;
        if (gVar.a()) {
            return Unit.INSTANCE;
        }
        gVar.h(true);
        if (gVar.g()) {
            no4.b.n(seriesRankTabViewModel.t, gVar, null, 2, null);
        } else {
            seriesRankTabViewModel.t.s(gVar, i);
            if (gVar.b()) {
                seriesRankTabViewModel.t.p(gVar, i);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult P(int i, SeriesRankTabViewModel seriesRankTabViewModel, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        com.dragon.read.kmp.j.a.d(a, "onCreate " + i + " tabModel: " + seriesRankTabViewModel.hashCode());
        return new a(i, seriesRankTabViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(SeriesRankTabViewModel seriesRankTabViewModel, com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var, int i, String str) {
        io4.a aVar = (io4.a) v0Var;
        seriesRankTabViewModel.u(aVar, i, str);
        seriesRankTabViewModel.t.u(false, aVar, str);
        return Unit.INSTANCE;
    }

    static final class c implements Function4<Integer, com.dragon.read.kmp.basenovel.ui.ui.v0, Composer, Integer, Unit> {
        final /* synthetic */ SeriesRankTabViewModel a;
        final /* synthetic */ float b;

        c(SeriesRankTabViewModel seriesRankTabViewModel, float f) {
            this.a = seriesRankTabViewModel;
            this.b = f;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var, Composer composer, Integer num2) {
            a(num.intValue(), v0Var, composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(int i, com.dragon.read.kmp.basenovel.ui.ui.v0 data, Composer composer, int i2) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(67661982, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.TagPageContent.<anonymous>.<anonymous>.<anonymous> (SeriesRankTabPage.kt:280)");
            }
            if (data instanceof io4.a) {
                composer.startReplaceGroup(1378524168);
                SeriesRankTabPageKt.B(data, this.a, i, composer, (i2 << 6) & 896);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1378686825);
                Modifier t = f2.t(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), this.b, 0.0f, 2, (Object) null);
                SeriesRankTabViewModel seriesRankTabViewModel = this.a;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, t);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a2);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i3, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                SeriesRankTabPageKt.B(data, seriesRankTabViewModel, i, composer, ((i2 << 6) & 896) | ((i2 >> 3) & 14));
                composer.endNode();
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    private static final void O(final SeriesRankTabViewModel seriesRankTabViewModel, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-2054557819);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(seriesRankTabViewModel)) {
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
                ComposerKt.traceEventStart(-2054557819, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.PageEffect (SeriesRankTabPage.kt:145)");
            }
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i3 & 112) == 32) {
                z2 = true;
            }
            boolean changedInstance = startRestartGroup.changedInstance(seriesRankTabViewModel) | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult P;
                        P = SeriesRankTabPageKt.P(i, seriesRankTabViewModel, (DisposableEffectScope) obj);
                        return P;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1) rememberedValue, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Q;
                    Q = SeriesRankTabPageKt.Q(SeriesRankTabViewModel.this, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return Q;
                }
            });
        }
    }

    private static final void K(final androidx.compose.foundation.layout.r rVar, final SeriesRankTabViewModel seriesRankTabViewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        final String str;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-551118303);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(seriesRankTabViewModel)) {
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
                ComposerKt.traceEventStart(-551118303, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.MyRankBottomAnchor (SeriesRankTabPage.kt:308)");
            }
            bj0 bj0Var = (bj0) seriesRankTabViewModel.l.getValue();
            if (bj0Var == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.g
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit L;
                            L = SeriesRankTabPageKt.L(rVar, seriesRankTabViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                            return L;
                        }
                    });
                    return;
                }
                return;
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                q20 q20Var = bj0Var.f;
                if (q20Var != null) {
                    str = q20Var.g;
                } else {
                    str = null;
                }
                Modifier.a aVar = Modifier.Companion;
                e.a aVar2 = androidx.compose.ui.e.a;
                Modifier h = SizeKt.h(rVar.b(aVar, aVar2.b()), 0.0f, 1, (Object) null);
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
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
                g5.e(b2, i5, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(seriesRankViewModel) | startRestartGroup.changed(str);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit M;
                            M = SeriesRankTabPageKt.M(SeriesRankViewModel.this, str);
                            return M;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                com.dragon.read.kmp.shortvideo.distribution.page.conent.n.p(null, bj0Var, (Function0) rememberedValue, startRestartGroup, 0, 1);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit N;
                    N = SeriesRankTabPageKt.N(rVar, seriesRankTabViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return N;
                }
            });
        }
    }

    public static final void i0(final androidx.compose.foundation.layout.b0 b0Var, final SeriesRankTabViewModel tabViewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(b0Var, "<this>");
        Intrinsics.checkNotNullParameter(tabViewModel, "tabViewModel");
        Composer startRestartGroup = composer.startRestartGroup(-1972527084);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(b0Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(tabViewModel)) {
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
                ComposerKt.traceEventStart(-1972527084, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.otherFilterButton (SeriesRankTabPage.kt:344)");
            }
            og4.a aVar = og4.a.a;
            int i5 = og4.a.b;
            long f = aVar.h(startRestartGroup, i5).f();
            Modifier.a aVar2 = Modifier.Companion;
            Modifier v = f2.v(aVar2, 0.0f, x0.i.g(20), 0.0f, 0.0f, 13, (Object) null);
            e.a aVar3 = androidx.compose.ui.e.a;
            float f2 = 8;
            Modifier c2 = BackgroundKt.c(b0Var.b(v, aVar3.g()), aVar.h(startRestartGroup, i5).x(), k.g.c(x0.i.g(f2)));
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(tabViewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit j0;
                        j0 = SeriesRankTabPageKt.j0(SeriesRankTabViewModel.this);
                        return j0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(c2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
            composer2 = startRestartGroup;
            a6.j("去看其他分类", f2.s(BoxScopeInstance.a.b(aVar2, aVar3.e()), x0.i.g(12), x0.i.g(f2)), f, x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 199686, 3120, 120784);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k0;
                    k0 = SeriesRankTabPageKt.k0(b0Var, tabViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k0;
                }
            });
        }
    }

    public static final void l0(final androidx.compose.foundation.layout.r rVar, final SeriesRankTabViewModel tabViewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(tabViewModel, "tabViewModel");
        Composer startRestartGroup = composer.startRestartGroup(224941244);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(tabViewModel)) {
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
                ComposerKt.traceEventStart(224941244, i5, -1, "com.dragon.read.kmp.shortvideo.distribution.page.tab.rankEmptyLayout (SeriesRankTabPage.kt:330)");
            }
            Modifier.a aVar = Modifier.Companion;
            e.a aVar2 = androidx.compose.ui.e.a;
            Modifier f = u1.f(rVar.b(aVar, aVar2.e()), 0.0f, x0.i.g(-30), 1, (Object) null);
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, f);
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
            com.dragon.read.kmp.compose.common.b.E("empty", startRestartGroup, 6);
            a6.j("暂无数据", c0Var.b(f2.v(aVar, 0.0f, x0.i.g(8), 0.0f, 0.0f, 13, (Object) null), aVar2.g()), og4.a.a.h(startRestartGroup, og4.a.b).h(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3078, 0, 131056);
            composer2 = startRestartGroup;
            i0(c0Var, tabViewModel, composer2, 6 | (i5 & 112));
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m0;
                    m0 = SeriesRankTabPageKt.m0(rVar, tabViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return m0;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x031b, code lost:
    
        if (r11 == r17.getEmpty()) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0775  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0504  */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void U(final androidx.compose.foundation.lazy.LazyListState r31, final com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel r32, androidx.compose.runtime.Composer r33, final int r34) {
        /*
            Method dump skipped, instructions count: 1936
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabPageKt.U(androidx.compose.foundation.lazy.LazyListState, com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void B(final com.dragon.read.kmp.basenovel.ui.ui.v0 r25, final com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel r26, final int r27, androidx.compose.runtime.Composer r28, int r29) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabPageKt.B(com.dragon.read.kmp.basenovel.ui.ui.v0, com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel, int, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void R(final int r28, final co4.a r29, final lo4.a r30, final io4.b r31, com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState r32, com.dragon.read.kmp.shortvideo.distribution.infinite.e r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 888
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabPageKt.R(int, co4.a, lo4.a, io4.b, com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState, com.dragon.read.kmp.shortvideo.distribution.infinite.e, androidx.compose.runtime.Composer, int, int):void");
    }
}
