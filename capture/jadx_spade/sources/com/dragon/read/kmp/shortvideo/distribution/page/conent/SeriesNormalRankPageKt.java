package com.dragon.read.kmp.shortvideo.distribution.page.conent;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.z2;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
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
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.kmp.reading.model.q90;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListLayoutKt;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabPageKt;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesNormalRankPageKt {
    private static final float a;
    private static final float b;
    private static final Lazy c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(int i, CollapsibleListState collapsibleListState, int i2, int i3, Composer composer, int i4) {
        C(i, collapsibleListState, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(int i, CollapsibleListState collapsibleListState, int i2, int i3, Composer composer, int i4) {
        C(i, collapsibleListState, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(androidx.compose.foundation.layout.r rVar, PagerState pagerState, int i, Composer composer, int i2) {
        I(rVar, pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(androidx.compose.foundation.layout.r rVar, PagerState pagerState, int i, Composer composer, int i2) {
        I(rVar, pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(PagerState pagerState, float f, CollapsibleListState collapsibleListState, int i, int i2, Composer composer, int i3) {
        M(pagerState, f, collapsibleListState, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        P(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        P(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        T(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        T(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(String str, float f, int i, int i2, Composer composer, int i3) {
        Z(str, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(String str, float f, int i, int i2, Composer composer, int i3) {
        Z(str, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(int i, Composer composer, int i2) {
        e0(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(PagerState pagerState, int i, Composer composer, int i2) {
        h0(pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(PagerState pagerState, CollapsibleListState collapsibleListState, int i, int i2, Composer composer, int i3) {
        j0(pagerState, collapsibleListState, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(PagerState pagerState, int i, Composer composer, int i2) {
        m0(pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(PagerState pagerState, int i, Composer composer, int i2) {
        o0(pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final float u0() {
        return ((x0.i) c.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.i x0() {
        return x0.i.d(x0.i.g(com.dragon.read.kmp.service.b1.a.s()));
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609062);
        a = x0.i.g(78);
        b = x0.i.g(106);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                x0.i x0;
                x0 = SeriesNormalRankPageKt.x0();
                return x0;
            }
        });
        c = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f0(SeriesRankViewModel seriesRankViewModel) {
        return seriesRankViewModel.e.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object k0(int i) {
        return Integer.valueOf(i);
    }

    private static final float D(MutableState<x0.i> mutableState) {
        return ((x0.i) mutableState.getValue()).m();
    }

    private static final float r0(boolean z) {
        return x0.i.g(s0(z) - a);
    }

    private static final float v0(boolean z) {
        if (z) {
            return x0.i.g(30);
        }
        return x0.i.g(40);
    }

    private static final float w0(boolean z) {
        if (z) {
            return x0.i.g(13);
        }
        return x0.i.g(0);
    }

    private static final float y0(boolean z) {
        if (z) {
            return x0.i.g(20);
        }
        return x0.i.g(40);
    }

    private static final float s0(boolean z) {
        return x0.i.g(x0.i.g(x0.i.g(x0.i.g(u0() + b) + v0(z)) + y0(z)) + w0(z));
    }

    private static final void E(MutableState<x0.i> mutableState, float f) {
        mutableState.setValue(x0.i.d(f));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ CollapsibleListState b;
        final /* synthetic */ PagerState c;

        a(boolean z, CollapsibleListState collapsibleListState, PagerState pagerState) {
            this.a = z;
            this.b = collapsibleListState;
            this.c = pagerState;
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
                    ComposerKt.traceEventStart(-443411096, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPage.<anonymous>.<anonymous> (SeriesNormalRankPage.kt:220)");
                }
                if (this.a) {
                    composer.startReplaceGroup(1659483288);
                    NewRankPageComponentsKt.C(this.b, this.c, composer, CollapsibleListState.q);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1659583666);
                    SeriesNormalRankPageKt.o0(this.c, composer, 0);
                    composer.endReplaceGroup();
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

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ PagerState a;
        final /* synthetic */ CollapsibleListState b;

        b(PagerState pagerState, CollapsibleListState collapsibleListState) {
            this.a = pagerState;
            this.b = collapsibleListState;
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
                    ComposerKt.traceEventStart(-516995674, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPage.<anonymous>.<anonymous> (SeriesNormalRankPage.kt:230)");
                }
                SeriesNormalRankPageKt.j0(this.a, this.b, composer, CollapsibleListState.q << 3, 0);
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
    public static final Unit F(MutableState mutableState, float f) {
        E(mutableState, x0.i.g((f - 1) * 170));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Ref$FloatRef ref$FloatRef, x0.t tVar) {
        ref$FloatRef.element = x0.i.g(com.dragon.read.kmp.service.d1.g((int) (tVar.j() >> 32)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Ref$FloatRef ref$FloatRef, x0.t tVar) {
        ref$FloatRef.element = x0.i.g(com.dragon.read.kmp.service.d1.g((int) (tVar.j() >> 32)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(ko4.b bVar, SeriesRankViewModel seriesRankViewModel) {
        bVar.e.setValue(Boolean.TRUE);
        no4.a.h(seriesRankViewModel.f, "榜单规则", null, 2, null);
        return Unit.INSTANCE;
    }

    public static final void e0(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        boolean z2;
        PagerState pagerState;
        CollapsibleListState u;
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1081859325);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1081859325, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPage (SeriesNormalRankPage.kt:165)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                int i3 = seriesRankViewModel.n;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(seriesRankViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.g1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            int f0;
                            f0 = SeriesNormalRankPageKt.f0(SeriesRankViewModel.this);
                            return Integer.valueOf(f0);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                PagerState n = androidx.compose.foundation.pager.e1.n(i3, 0.0f, (Function0) rememberedValue, startRestartGroup, 0, 2);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = Boolean.valueOf(((ko4.b) seriesRankViewModel.d.getValue()).b);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                boolean booleanValue = ((Boolean) rememberedValue2).booleanValue();
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = Boolean.valueOf(((ko4.b) seriesRankViewModel.d.getValue()).d());
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                boolean booleanValue2 = ((Boolean) rememberedValue3).booleanValue();
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = Boolean.valueOf(seriesRankViewModel.Q0());
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                boolean booleanValue3 = ((Boolean) rememberedValue4).booleanValue();
                startRestartGroup.endReplaceGroup();
                Integer valueOf = Integer.valueOf(n.u());
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(seriesRankViewModel) | startRestartGroup.changed(n);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new SeriesNormalRankPageKt$SeriesNormalRankPage$1$1(seriesRankViewModel, n, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue5, startRestartGroup, 0);
                Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, f);
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
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, i4, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                if (booleanValue2) {
                    startRestartGroup.startReplaceGroup(1895718519);
                    s sVar = s.a;
                    z2 = booleanValue2;
                    pagerState = n;
                    u = CollapsibleListLayoutKt.u(x0.i.g(x0.i.g(x0.i.g(sVar.g() + sVar.j(startRestartGroup, 0)) + sVar.i()) + sVar.h()), n, true, false, 0.0f, 0L, false, startRestartGroup, 384, 120);
                    startRestartGroup.endReplaceGroup();
                } else {
                    z2 = booleanValue2;
                    pagerState = n;
                    startRestartGroup.startReplaceGroup(1896072477);
                    u = CollapsibleListLayoutKt.u(r0(booleanValue), pagerState, false, false, 0.0f, 0L, false, startRestartGroup, 0, 124);
                    startRestartGroup.endReplaceGroup();
                }
                CollapsibleListState collapsibleListState = u;
                if (z2) {
                    startRestartGroup.startReplaceGroup(1896246449);
                    NewRankPageComponentsKt.w(pagerState.u(), collapsibleListState, startRestartGroup, CollapsibleListState.q << 3);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1896361428);
                    C(pagerState.u(), collapsibleListState, startRestartGroup, CollapsibleListState.q << 3, 0);
                    startRestartGroup.endReplaceGroup();
                }
                if (booleanValue) {
                    startRestartGroup.startReplaceGroup(1896520427);
                    T(pagerState.u(), collapsibleListState, startRestartGroup, CollapsibleListState.q << 3);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1896640862);
                    if (!z2) {
                        P(pagerState.u(), collapsibleListState, startRestartGroup, CollapsibleListState.q << 3);
                    }
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.startReplaceGroup(892471871);
                if (!z2) {
                    i2 = 6;
                    M(pagerState, x0.i.g(96), collapsibleListState, startRestartGroup, (CollapsibleListState.q << 6) | 48, 0);
                } else {
                    i2 = 6;
                }
                startRestartGroup.endReplaceGroup();
                PagerState pagerState2 = pagerState;
                CollapsibleListLayoutKt.g((Modifier) null, collapsibleListState, androidx.compose.runtime.internal.t.e(-443411096, true, new a(z2, collapsibleListState, pagerState2), startRestartGroup, 54), com.dragon.read.kmp.shortvideo.distribution.page.conent.c.a.b(), androidx.compose.runtime.internal.t.e(-516995674, true, new b(pagerState2, collapsibleListState), startRestartGroup, 54), startRestartGroup, (CollapsibleListState.q << 3) | 28032, 1);
                startRestartGroup.startReplaceGroup(892494232);
                if (z2 && !booleanValue && !booleanValue3) {
                    NewRankPageComponentsKt.V(startRestartGroup, 0);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(892498215);
                if (booleanValue3) {
                    NewRankPageComponentsKt.S(startRestartGroup, 0);
                }
                startRestartGroup.endReplaceGroup();
                I(boxScopeInstance, pagerState2, startRestartGroup, i2);
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
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.p1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g0;
                    g0 = SeriesNormalRankPageKt.g0(i, (Composer) obj, ((Integer) obj2).intValue());
                    return g0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(MutableState mutableState, float f, float f2) {
        mutableState.setValue(x0.i.d(x0.i.g(f - ((1 - f2) * 78))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(ko4.b bVar, SeriesRankViewModel seriesRankViewModel, boolean z) {
        bVar.e.setValue(Boolean.FALSE);
        if (z) {
            seriesRankViewModel.f.g("榜单规则", "ok");
        }
        return Unit.INSTANCE;
    }

    private static final void h0(final PagerState pagerState, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        float f;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1294122937);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(pagerState)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
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
                ComposerKt.traceEventStart(-1294122937, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SideTabTitleBar (SeriesNormalRankPage.kt:596)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final boolean z2 = ((ko4.b) seriesRankViewModel.d.getValue()).b;
                long t0 = t0(pagerState.u(), seriesRankViewModel, startRestartGroup, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier f2 = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, f2);
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
                if (z2) {
                    f = 6;
                } else {
                    f = 16;
                }
                float g = x0.i.g(f);
                Modifier f3 = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                if (z2) {
                    i3 = 20;
                } else {
                    i3 = 36;
                }
                com.dragon.read.kmp.widget.v0.b(androidx.compose.foundation.layout.f2.v(f3, 0.0f, 0.0f, x0.i.g(i3), 0.0f, 11, (Object) null), g, t0, false, false, androidx.compose.runtime.internal.t.e(-1427189919, true, new Function2<Composer, Integer, Unit>() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPageKt$SideTabTitleBar$1$1

                    /* renamed from: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPageKt$SideTabTitleBar$1$1$1, reason: invalid class name */
                    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ SeriesRankViewModel a;
                        final /* synthetic */ CoroutineScope b;
                        final /* synthetic */ PagerState c;
                        final /* synthetic */ boolean d;

                        AnonymousClass1(SeriesRankViewModel seriesRankViewModel, CoroutineScope coroutineScope, PagerState pagerState, boolean z) {
                            this.a = seriesRankViewModel;
                            this.b = coroutineScope;
                            this.c = pagerState;
                            this.d = z;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            c(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit e(SeriesRankViewModel seriesRankViewModel, io4.b bVar) {
                            no4.a.j(seriesRankViewModel.f, true, bVar.f(), bVar.k, null, 8, null);
                            return Unit.INSTANCE;
                        }

                        public final void c(Composer composer, int i) {
                            boolean z;
                            Function0 function0;
                            Modifier modifier;
                            long h;
                            androidx.compose.ui.e e;
                            float coerceIn;
                            float g;
                            float f;
                            CoroutineScope coroutineScope;
                            SeriesRankViewModel seriesRankViewModel;
                            float c;
                            String str;
                            float g2;
                            int i2;
                            int i3;
                            Composer composer2 = composer;
                            boolean z2 = false;
                            int i4 = 1;
                            if ((i & 3) != 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (composer2.shouldExecute(z, i & 1)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1417710433, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SideTabTitleBar.<anonymous>.<anonymous>.<anonymous> (SeriesNormalRankPage.kt:618)");
                                }
                                final SeriesRankViewModel seriesRankViewModel2 = this.a;
                                List<io4.b> list = seriesRankViewModel2.e;
                                CoroutineScope coroutineScope2 = this.b;
                                PagerState pagerState = this.c;
                                boolean z3 = this.d;
                                int i5 = 0;
                                for (Object obj : list) {
                                    int i6 = i5 + 1;
                                    if (i5 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final io4.b bVar = (io4.b) obj;
                                    composer2.startReplaceGroup(1849434622);
                                    Object rememberedValue = composer.rememberedValue();
                                    Composer.Companion companion = Composer.Companion;
                                    if (rememberedValue == companion.getEmpty()) {
                                        rememberedValue = androidx.compose.foundation.interaction.h.a();
                                        composer2.updateRememberedValue(rememberedValue);
                                    }
                                    androidx.compose.foundation.interaction.i iVar = (androidx.compose.foundation.interaction.i) rememberedValue;
                                    composer.endReplaceGroup();
                                    Modifier modifier2 = Modifier.Companion;
                                    Modifier d = SizeKt.d(SizeKt.F(modifier2, (e.b) null, z2, 3, (Object) null), 0.0f, i4, (Object) null);
                                    composer2.startReplaceGroup(-1224400529);
                                    boolean changedInstance = composer2.changedInstance(coroutineScope2) | composer2.changed(pagerState) | composer2.changed(i5) | composer2.changedInstance(seriesRankViewModel2) | composer2.changed(bVar);
                                    Object rememberedValue2 = composer.rememberedValue();
                                    if (!changedInstance && rememberedValue2 != companion.getEmpty()) {
                                        function0 = null;
                                        modifier = modifier2;
                                    } else {
                                        final CoroutineScope coroutineScope3 = coroutineScope2;
                                        final SeriesRankViewModel seriesRankViewModel3 = seriesRankViewModel2;
                                        function0 = null;
                                        final PagerState pagerState2 = pagerState;
                                        modifier = modifier2;
                                        final int i7 = i5;
                                        Function0 function02 = 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b9: CONSTRUCTOR (r7v0 'function02' kotlin.jvm.functions.Function0) = 
                                              (r6v6 'coroutineScope3' kotlinx.coroutines.CoroutineScope A[DONT_INLINE])
                                              (r7v1 'seriesRankViewModel3' com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel A[DONT_INLINE])
                                              (r2v7 'bVar' io4.b A[DONT_INLINE])
                                              (r9v1 'pagerState2' androidx.compose.foundation.pager.PagerState A[DONT_INLINE])
                                              (r10v1 'i7' int A[DONT_INLINE])
                                             A[DECLARE_VAR, MD:(kotlinx.coroutines.CoroutineScope, com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel, io4.b, androidx.compose.foundation.pager.PagerState, int):void (m)] (LINE:34078905) call: com.dragon.read.kmp.shortvideo.distribution.page.conent.x1.<init>(kotlinx.coroutines.CoroutineScope, com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel, io4.b, androidx.compose.foundation.pager.PagerState, int):void type: CONSTRUCTOR in method: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPageKt$SideTabTitleBar$1$1.1.c(androidx.compose.runtime.Composer, int):void, file: D:\code\hongguo\capture\classes6.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:207)
                                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.dragon.read.kmp.shortvideo.distribution.page.conent.x1, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:305)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 35 more
                                            */
                                        /*
                                            Method dump skipped, instructions count: 1016
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPageKt$SideTabTitleBar$1$1.AnonymousClass1.c(androidx.compose.runtime.Composer, int):void");
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final Unit d(CoroutineScope coroutineScope, SeriesRankViewModel seriesRankViewModel, io4.b bVar, PagerState pagerState, int i) {
                                        kotlinx.coroutines.i.e(coroutineScope, null, null, new SeriesNormalRankPageKt$SideTabTitleBar$1$1$1$1$1$1$1(pagerState, i, null), 3, null);
                                        no4.a.j(seriesRankViewModel.f, false, bVar.f(), bVar.k, null, 8, null);
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    a(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void a(Composer composer2, int i6) {
                                    boolean z3;
                                    int i7;
                                    if ((i6 & 3) != 2) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (composer2.shouldExecute(z3, i6 & 1)) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1427189919, i6, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.SideTabTitleBar.<anonymous>.<anonymous> (SeriesNormalRankPage.kt:611)");
                                        }
                                        int u = pagerState.u();
                                        Modifier f4 = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                                        if (z2) {
                                            i7 = 12;
                                        } else {
                                            i7 = 16;
                                        }
                                        float g2 = x0.i.g(i7);
                                        c cVar = c.a;
                                        com.dragon.read.kmp.widget.slidetab.e.b(u, f4, 0L, 0L, g2, cVar.a(), cVar.c(), androidx.compose.runtime.internal.t.e(-1417710433, true, new AnonymousClass1(seriesRankViewModel, coroutineScope, pagerState, z2), composer2, 54), composer2, 14352432, 12);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, startRestartGroup, 54), startRestartGroup, 196608, 24);
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
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.o1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit i0;
                                i0 = SeriesNormalRankPageKt.i0(pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return i0;
                            }
                        });
                    }
                }

                private static final void m0(final PagerState pagerState, Composer composer, final int i) {
                    int i2;
                    boolean z;
                    CreationExtras creationExtras;
                    int i3;
                    Composer startRestartGroup = composer.startRestartGroup(-883095977);
                    if ((i & 6) == 0) {
                        if (startRestartGroup.changed(pagerState)) {
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
                            ComposerKt.traceEventStart(-883095977, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.TabTitleLayout (SeriesNormalRankPage.kt:546)");
                        }
                        HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
                        if (c2 != null) {
                            if (c2 instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c2.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            ko4.b bVar = (ko4.b) seriesRankViewModel.d.getValue();
                            boolean z2 = bVar.b;
                            Modifier i4 = SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), v0(z2));
                            androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.n(), false);
                            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier e = ComposedModifierKt.e(startRestartGroup, i4);
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
                            if (seriesRankViewModel.R0()) {
                                startRestartGroup.startReplaceGroup(758167090);
                                h0(pagerState, startRestartGroup, i2 & 14);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(758222053);
                                SeriesTopicRankPageKt.i(pagerState, startRestartGroup, i2 & 14);
                                startRestartGroup.endReplaceGroup();
                            }
                            startRestartGroup.startReplaceGroup(1271387191);
                            if (!z2 && !bVar.d()) {
                                Z(bVar.d, 0.0f, startRestartGroup, 0, 2);
                            }
                            startRestartGroup.endReplaceGroup();
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
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.n1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit n0;
                                n0 = SeriesNormalRankPageKt.n0(pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return n0;
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void o0(final PagerState pagerState, Composer composer, final int i) {
                    int i2;
                    boolean z;
                    CreationExtras creationExtras;
                    int i3;
                    Composer startRestartGroup = composer.startRestartGroup(1535511712);
                    if ((i & 6) == 0) {
                        if (startRestartGroup.changed(pagerState)) {
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
                            ComposerKt.traceEventStart(1535511712, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.TopContent (SeriesNormalRankPage.kt:521)");
                        }
                        HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
                        if (c2 != null) {
                            if (c2 instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c2.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            startRestartGroup.startReplaceGroup(1849434622);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = Boolean.valueOf(((ko4.b) seriesRankViewModel.d.getValue()).b);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            boolean booleanValue = ((Boolean) rememberedValue).booleanValue();
                            startRestartGroup.endReplaceGroup();
                            Modifier.a aVar = Modifier.Companion;
                            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, u0(), 0.0f, 0.0f, 13, (Object) null);
                            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.g(), startRestartGroup, 54);
                            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                            float f = b;
                            startRestartGroup.startReplaceGroup(-1814856593);
                            a3.a(SizeKt.i(aVar, f), startRestartGroup, 0);
                            startRestartGroup.endReplaceGroup();
                            float y0 = y0(booleanValue);
                            startRestartGroup.startReplaceGroup(-1814856593);
                            a3.a(SizeKt.i(aVar, y0), startRestartGroup, 0);
                            startRestartGroup.endReplaceGroup();
                            m0(pagerState, startRestartGroup, i2 & 14);
                            float w0 = w0(booleanValue);
                            startRestartGroup.startReplaceGroup(-1814856593);
                            a3.a(SizeKt.i(aVar, w0), startRestartGroup, 0);
                            startRestartGroup.endReplaceGroup();
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
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.e1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit p0;
                                p0 = SeriesNormalRankPageKt.p0(pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return p0;
                            }
                        });
                    }
                }

                static final class c implements Function4<androidx.compose.foundation.pager.p0, Integer, Composer, Integer, Unit> {
                    final /* synthetic */ SeriesRankViewModel a;
                    final /* synthetic */ CollapsibleListState b;

                    c(SeriesRankViewModel seriesRankViewModel, CollapsibleListState collapsibleListState) {
                        this.a = seriesRankViewModel;
                        this.b = collapsibleListState;
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.pager.p0 p0Var, Integer num, Composer composer, Integer num2) {
                        a(p0Var, num.intValue(), composer, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void a(androidx.compose.foundation.pager.p0 HorizontalPager, int i, Composer composer, int i2) {
                        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-950178198, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.TabContent.<anonymous> (SeriesNormalRankPage.kt:495)");
                        }
                        io4.b bVar = this.a.e.get(i);
                        SeriesRankViewModel seriesRankViewModel = this.a;
                        SeriesRankTabPageKt.R(i, seriesRankViewModel.m, seriesRankViewModel.a.k, bVar, this.b, seriesRankViewModel.p, composer, ((i2 >> 3) & 14) | (CollapsibleListState.q << 12), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit J(q90 q90Var, SeriesRankViewModel seriesRankViewModel, String str, Context context) {
                    String str2 = q90Var.b;
                    if (str2 != null) {
                        seriesRankViewModel.f.a(true, str);
                        zm4.d.d(zm4.d.a, str2, null, com.dragon.read.kmp.utils.k0.a.b(), 2, null);
                    }
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit R(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, float f) {
                    float f2 = 1 - f;
                    mutableState.setValue(Float.valueOf((float) (1 - (f2 * 0.25d))));
                    mutableState2.setValue(x0.i.d(x0.i.g(41 - (f2 * 35))));
                    mutableState3.setValue(Float.valueOf(f));
                    return Unit.INSTANCE;
                }

                public static final long t0(int i, SeriesRankViewModel seriesRankViewModel, Composer composer, int i2) {
                    long j;
                    Intrinsics.checkNotNullParameter(seriesRankViewModel, "seriesRankViewModel");
                    composer.startReplaceGroup(680163079);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(680163079, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.getPageColor (SeriesNormalRankPage.kt:508)");
                    }
                    ko4.a c2 = ((ko4.b) seriesRankViewModel.d.getValue()).c(Integer.valueOf(i));
                    if (com.dragon.read.kmp.service.d1.d(og4.a.a.e(composer, og4.a.b))) {
                        j = c2.b;
                    } else {
                        j = c2.a;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return j;
                }

                private static final void I(final androidx.compose.foundation.layout.r rVar, final PagerState pagerState, Composer composer, final int i) {
                    int i2;
                    boolean z;
                    Composer composer2;
                    CreationExtras creationExtras;
                    q90 q90Var;
                    p90 p90Var;
                    String str;
                    long b2;
                    p90 p90Var2;
                    int i3;
                    int i4;
                    Composer startRestartGroup = composer.startRestartGroup(1520863855);
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
                        if (startRestartGroup.changed(pagerState)) {
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
                            ComposerKt.traceEventStart(1520863855, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.BottomActivityButton (SeriesNormalRankPage.kt:249)");
                        }
                        HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
                        if (c2 != null) {
                            if (c2 instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c2.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar = (com.dragon.read.kmp.shortvideo.distribution.infinite.d) seriesRankViewModel.j.getValue();
                            if (dVar != null && (p90Var2 = dVar.b) != null) {
                                q90Var = p90Var2.u;
                            } else {
                                q90Var = null;
                            }
                            if (q90Var == null) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.f1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit L;
                                            L = SeriesNormalRankPageKt.L(rVar, pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                            return L;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            io4.b bVar = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, pagerState.u());
                            if (bVar != null) {
                                p90Var = bVar.a;
                            } else {
                                p90Var = null;
                            }
                            if (p90Var != null) {
                                str = p90Var.w;
                            } else {
                                str = null;
                            }
                            Modifier.a aVar = Modifier.Companion;
                            e.a aVar2 = androidx.compose.ui.e.a;
                            Modifier u = SizeKt.u(androidx.compose.foundation.layout.f2.v(rVar.b(aVar, aVar2.b()), 0.0f, 0.0f, 0.0f, x0.i.g(24), 7, (Object) null), x0.i.g(150), x0.i.g(36));
                            androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
                            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier e = ComposedModifierKt.e(startRestartGroup, u);
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
                            g5.e(b3, i5, companion.c());
                            g5.e(b3, currentCompositionLocalMap, companion.e());
                            Function2 b4 = companion.b();
                            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                                b3.updateRememberedValue(Integer.valueOf(a2));
                                b3.apply(Integer.valueOf(a2), b4);
                            }
                            g5.e(b3, e, companion.d());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                            String str2 = q90Var.c;
                            Modifier a4 = androidx.compose.ui.draw.e.a(SizeKt.f(aVar, 0.0f, 1, (Object) null), k.g.c(x0.i.g(6)));
                            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                            nVar.a(com.bytedance.kmp.image.options.l.b.c());
                            final String str3 = str;
                            final q90 q90Var2 = q90Var;
                            LoadImageKt.g(str2, (String) null, nVar, a4, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 114);
                            String str4 = q90Var2.a;
                            if (str4 == null) {
                                str4 = "";
                            }
                            String str5 = str4;
                            String str6 = q90Var2.d;
                            if (str6 != null) {
                                b2 = com.dragon.read.kmp.utils.j.e(str6, androidx.compose.ui.graphics.n0.b(0));
                            } else {
                                b2 = androidx.compose.ui.graphics.n0.b(0);
                            }
                            long j = b2;
                            long h = x0.x.h(14);
                            androidx.compose.ui.text.font.c0 a5 = androidx.compose.ui.text.font.c0.b.a();
                            Modifier D = SizeKt.D(aVar, aVar2.e(), false, 2, (Object) null);
                            startRestartGroup.startReplaceGroup(-1746271574);
                            boolean changedInstance = startRestartGroup.changedInstance(q90Var2) | startRestartGroup.changedInstance(seriesRankViewModel) | startRestartGroup.changed(str3);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.h1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit J;
                                        J = SeriesNormalRankPageKt.J(q90Var2, seriesRankViewModel, str3, (Context) obj);
                                        return J;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            a6.j(str5, tc4.f.e(D, false, (String) null, (Role) null, (Function1) rememberedValue, startRestartGroup, 6, 7), j, h, (androidx.compose.ui.text.font.y) null, a5, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131024);
                            Unit unit = Unit.INSTANCE;
                            composer2 = startRestartGroup;
                            composer2.startReplaceGroup(-1633490746);
                            boolean changedInstance2 = composer2.changedInstance(seriesRankViewModel) | composer2.changed(str3);
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new SeriesNormalRankPageKt$BottomActivityButton$2$3$1(seriesRankViewModel, str3, null);
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceGroup();
                            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue2, composer2, 6);
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                    }
                    t3 endRestartGroup2 = composer2.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.i1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit K;
                                K = SeriesNormalRankPageKt.K(rVar, pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return K;
                            }
                        });
                    }
                }

                private static final void P(final int i, final CollapsibleListState collapsibleListState, Composer composer, final int i2) {
                    int i3;
                    boolean z;
                    Composer composer2;
                    CreationExtras creationExtras;
                    p90 p90Var;
                    String str;
                    long e;
                    boolean changedInstance;
                    int i4;
                    int i5;
                    Composer startRestartGroup = composer.startRestartGroup(1927385178);
                    if ((i2 & 6) == 0) {
                        if (startRestartGroup.changed(i)) {
                            i5 = 4;
                        } else {
                            i5 = 2;
                        }
                        i3 = i5 | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i2 & 64) == 0) {
                            changedInstance = startRestartGroup.changed(collapsibleListState);
                        } else {
                            changedInstance = startRestartGroup.changedInstance(collapsibleListState);
                        }
                        if (changedInstance) {
                            i4 = 32;
                        } else {
                            i4 = 16;
                        }
                        i3 |= i4;
                    }
                    int i6 = i3;
                    if ((i6 & 19) != 18) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (startRestartGroup.shouldExecute(z, i6 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1927385178, i6, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.RankPageTitleGroup (SeriesNormalRankPage.kt:328)");
                        }
                        HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
                        if (c2 != null) {
                            if (c2 instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c2.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            io4.b bVar = (io4.b) CollectionsKt___CollectionsKt.getOrNull(((SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0)).e, i);
                            if (bVar != null && (p90Var = bVar.a) != null) {
                                boolean d = com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
                                if (d) {
                                    str = p90Var.l;
                                } else {
                                    str = p90Var.k;
                                }
                                if (d) {
                                    e = com.dragon.read.kmp.utils.j.e(p90Var.n, androidx.compose.ui.graphics.n0.b(17985));
                                } else {
                                    e = com.dragon.read.kmp.utils.j.e(p90Var.m, androidx.compose.ui.graphics.n0.b(17985));
                                }
                                long j = e;
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                Composer.Companion companion = Composer.Companion;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final MutableState mutableState = (MutableState) rememberedValue;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(x0.i.d(x0.i.g(41)), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                final MutableState mutableState2 = (MutableState) rememberedValue2;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == companion.getEmpty()) {
                                    rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                final MutableState mutableState3 = (MutableState) rememberedValue3;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(-1746271574);
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 == companion.getEmpty()) {
                                    rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.x0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            Unit R;
                                            R = SeriesNormalRankPageKt.R(mutableState, mutableState2, mutableState3, ((Float) obj).floatValue());
                                            return R;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                startRestartGroup.endReplaceGroup();
                                CollapsibleListLayoutKt.n(collapsibleListState, (Function1) rememberedValue4, startRestartGroup, CollapsibleListState.q | 48 | ((i6 >> 3) & 14));
                                Modifier.a aVar = Modifier.Companion;
                                Modifier v = androidx.compose.foundation.layout.f2.v(androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, u0(), 0.0f, 0.0f, 13, (Object) null), 0.0f, ((x0.i) mutableState2.getValue()).m(), 0.0f, 0.0f, 13, (Object) null);
                                e.a aVar2 = androidx.compose.ui.e.a;
                                androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
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
                                Composer b2 = g5.b(startRestartGroup);
                                g5.e(b2, i7, companion2.c());
                                g5.e(b2, currentCompositionLocalMap, companion2.e());
                                Function2 b3 = companion2.b();
                                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                                    b2.updateRememberedValue(Integer.valueOf(a2));
                                    b2.apply(Integer.valueOf(a2), b3);
                                }
                                g5.e(b2, e2, companion2.d());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.g(), startRestartGroup, 48);
                                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e3 = ComposedModifierKt.e(startRestartGroup, h);
                                Function0 a6 = companion2.a();
                                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                                    androidx.compose.runtime.i.d();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(a6);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Composer b4 = g5.b(startRestartGroup);
                                g5.e(b4, a4, companion2.c());
                                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                                Function2 b5 = companion2.b();
                                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                                    b4.updateRememberedValue(Integer.valueOf(a5));
                                    b4.apply(Integer.valueOf(a5), b5);
                                }
                                g5.e(b4, e3, companion2.d());
                                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                                Modifier u = SizeKt.u(androidx.compose.ui.draw.o.a(aVar, ((Number) mutableState.getValue()).floatValue()), x0.i.g(170), x0.i.g(34));
                                androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                                int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e4 = ComposedModifierKt.e(startRestartGroup, u);
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
                                Composer b6 = g5.b(startRestartGroup);
                                g5.e(b6, i8, companion2.c());
                                g5.e(b6, currentCompositionLocalMap3, companion2.e());
                                Function2 b7 = companion2.b();
                                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a7))) {
                                    b6.updateRememberedValue(Integer.valueOf(a7));
                                    b6.apply(Integer.valueOf(a7), b7);
                                }
                                g5.e(b6, e4, companion2.d());
                                LoadImageKt.g(str, (String) null, new com.dragon.read.kmp.compose.common.image.n(), boxScopeInstance.a(aVar), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 114);
                                startRestartGroup.endNode();
                                a3.a(SizeKt.h(SizeKt.i(aVar, x0.i.g(11)), 0.0f, 1, (Object) null), startRestartGroup, 6);
                                String str2 = p90Var.j;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                float f = 16;
                                composer2 = startRestartGroup;
                                a6.j(str2, androidx.compose.foundation.layout.f2.v(androidx.compose.ui.draw.a.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), ((Number) mutableState3.getValue()).floatValue()), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null), j, x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3120, 120304);
                                composer2.endNode();
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.w0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit Q;
                                            Q = SeriesNormalRankPageKt.Q(i, collapsibleListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                                            return Q;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        } else {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                    }
                    t3 endRestartGroup2 = composer2.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.y0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit S;
                                S = SeriesNormalRankPageKt.S(i, collapsibleListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return S;
                            }
                        });
                    }
                }

                private static final void T(final int i, final CollapsibleListState collapsibleListState, Composer composer, final int i2) {
                    int i3;
                    boolean z;
                    final CollapsibleListState collapsibleListState2;
                    final int i4;
                    Composer composer2;
                    final int i5;
                    CreationExtras creationExtras;
                    p90 p90Var;
                    String str;
                    long e;
                    boolean changedInstance;
                    int i6;
                    int i7;
                    Composer startRestartGroup = composer.startRestartGroup(828828373);
                    if ((i2 & 6) == 0) {
                        if (startRestartGroup.changed(i)) {
                            i7 = 4;
                        } else {
                            i7 = 2;
                        }
                        i3 = i7 | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i2 & 64) == 0) {
                            changedInstance = startRestartGroup.changed(collapsibleListState);
                        } else {
                            changedInstance = startRestartGroup.changedInstance(collapsibleListState);
                        }
                        if (changedInstance) {
                            i6 = 32;
                        } else {
                            i6 = 16;
                        }
                        i3 |= i6;
                    }
                    int i8 = i3;
                    if ((i8 & 19) != 18) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (startRestartGroup.shouldExecute(z, i8 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(828828373, i8, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.RankPageTitleGroupRankStyle (SeriesNormalRankPage.kt:383)");
                        }
                        HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
                        if (c2 != null) {
                            if (c2 instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c2.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            io4.b bVar = (io4.b) CollectionsKt___CollectionsKt.getOrNull(((SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0)).e, i);
                            if (bVar != null && (p90Var = bVar.a) != null) {
                                boolean d = com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
                                if (d) {
                                    str = p90Var.l;
                                } else {
                                    str = p90Var.k;
                                }
                                if (d) {
                                    e = com.dragon.read.kmp.utils.j.e(p90Var.n, androidx.compose.ui.graphics.n0.b(17985));
                                } else {
                                    e = com.dragon.read.kmp.utils.j.e(p90Var.m, androidx.compose.ui.graphics.n0.b(17985));
                                }
                                long j = e;
                                final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                Composer.Companion companion = Composer.Companion;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = x0.i.d(x0.i.g(0));
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                float m = ((x0.i) rememberedValue).m();
                                startRestartGroup.endReplaceGroup();
                                ref$FloatRef.element = m;
                                final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = x0.i.d(x0.i.g(0));
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                float m2 = ((x0.i) rememberedValue2).m();
                                startRestartGroup.endReplaceGroup();
                                ref$FloatRef2.element = m2;
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == companion.getEmpty()) {
                                    rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                final MutableState mutableState = (MutableState) rememberedValue3;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 == companion.getEmpty()) {
                                    rememberedValue4 = SnapshotStateKt.mutableStateOf$default(x0.i.d(x0.i.g(56)), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                final MutableState mutableState2 = (MutableState) rememberedValue4;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (rememberedValue5 == companion.getEmpty()) {
                                    rememberedValue5 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                final MutableState mutableState3 = (MutableState) rememberedValue5;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (rememberedValue6 == companion.getEmpty()) {
                                    rememberedValue6 = SnapshotStateKt.mutableStateOf$default(x0.i.d(x0.i.g(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                final MutableState mutableState4 = (MutableState) rememberedValue6;
                                startRestartGroup.endReplaceGroup();
                                CollapsibleListLayoutKt.n(collapsibleListState, new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.r1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit V;
                                        V = SeriesNormalRankPageKt.V(mutableState, mutableState2, mutableState3, ref$FloatRef, ref$FloatRef2, mutableState4, ((Float) obj).floatValue());
                                        return V;
                                    }
                                }, startRestartGroup, CollapsibleListState.q | ((i8 >> 3) & 14));
                                Modifier.a aVar = Modifier.Companion;
                                Modifier a2 = androidx.compose.ui.layout.j1.a(androidx.compose.foundation.layout.f2.v(androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, u0(), 0.0f, 0.0f, 13, (Object) null), 0.0f, ((x0.i) mutableState2.getValue()).m(), 0.0f, 0.0f, 13, (Object) null), new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.s1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit W;
                                        W = SeriesNormalRankPageKt.W(Ref$FloatRef.this, (x0.t) obj);
                                        return W;
                                    }
                                });
                                e.a aVar2 = androidx.compose.ui.e.a;
                                androidx.compose.ui.layout.p0 i9 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e2 = ComposedModifierKt.e(startRestartGroup, a2);
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
                                g5.e(b2, i9, companion2.c());
                                g5.e(b2, currentCompositionLocalMap, companion2.e());
                                Function2 b3 = companion2.b();
                                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                                    b2.updateRememberedValue(Integer.valueOf(a3));
                                    b2.apply(Integer.valueOf(a3), b3);
                                }
                                g5.e(b2, e2, companion2.d());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                                androidx.compose.ui.layout.p0 a5 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar2.k(), startRestartGroup, 48);
                                int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e3 = ComposedModifierKt.e(startRestartGroup, h);
                                Function0 a7 = companion2.a();
                                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                                    androidx.compose.runtime.i.d();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(a7);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Composer b4 = g5.b(startRestartGroup);
                                g5.e(b4, a5, companion2.c());
                                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                                Function2 b5 = companion2.b();
                                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                                    b4.updateRememberedValue(Integer.valueOf(a6));
                                    b4.apply(Integer.valueOf(a6), b5);
                                }
                                g5.e(b4, e3, companion2.d());
                                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                                float f = 12;
                                Modifier a8 = androidx.compose.ui.layout.j1.a(SizeKt.u(androidx.compose.ui.draw.o.a(androidx.compose.foundation.layout.f2.v(androidx.compose.foundation.layout.u1.f(aVar, ((x0.i) mutableState4.getValue()).m(), 0.0f, 2, (Object) null), x0.i.g(f), 0.0f, 0.0f, 0.0f, 14, (Object) null), ((Number) mutableState.getValue()).floatValue()), x0.i.g(170), x0.i.g(34)), new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.t1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit X;
                                        X = SeriesNormalRankPageKt.X(Ref$FloatRef.this, (x0.t) obj);
                                        return X;
                                    }
                                });
                                androidx.compose.ui.layout.p0 i10 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                                int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e4 = ComposedModifierKt.e(startRestartGroup, a8);
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
                                Composer b6 = g5.b(startRestartGroup);
                                g5.e(b6, i10, companion2.c());
                                g5.e(b6, currentCompositionLocalMap3, companion2.e());
                                Function2 b7 = companion2.b();
                                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a9))) {
                                    b6.updateRememberedValue(Integer.valueOf(a9));
                                    b6.apply(Integer.valueOf(a9), b7);
                                }
                                g5.e(b6, e4, companion2.d());
                                LoadImageKt.g(str, (String) null, new com.dragon.read.kmp.compose.common.image.n(), boxScopeInstance.a(aVar), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 114);
                                startRestartGroup.endNode();
                                a3.a(SizeKt.h(SizeKt.i(aVar, x0.i.g(2)), 0.0f, 1, (Object) null), startRestartGroup, 6);
                                String str2 = p90Var.j;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                composer2 = startRestartGroup;
                                a6.j(str2, androidx.compose.foundation.layout.f2.v(androidx.compose.ui.draw.a.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), ((Number) mutableState3.getValue()).floatValue()), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null), j, x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3120, 120816);
                                composer2.endNode();
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                i5 = i;
                                collapsibleListState2 = collapsibleListState;
                                i4 = i2;
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.q1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit U;
                                            U = SeriesNormalRankPageKt.U(i, collapsibleListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                                            return U;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        } else {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                    } else {
                        collapsibleListState2 = collapsibleListState;
                        i4 = i2;
                        composer2 = startRestartGroup;
                        i5 = i;
                        composer2.skipToGroupEnd();
                    }
                    t3 endRestartGroup2 = composer2.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.u1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit Y;
                                Y = SeriesNormalRankPageKt.Y(i5, collapsibleListState2, i4, (Composer) obj, ((Integer) obj2).intValue());
                                return Y;
                            }
                        });
                    }
                }

                public static final void j0(final PagerState pagerState, CollapsibleListState collapsibleListState, Composer composer, final int i, final int i2) {
                    int i3;
                    int i4;
                    boolean changedInstance;
                    int i5;
                    boolean z;
                    Composer composer2;
                    CollapsibleListState collapsibleListState2;
                    CreationExtras creationExtras;
                    final CollapsibleListState collapsibleListState3 = collapsibleListState;
                    Intrinsics.checkNotNullParameter(pagerState, "pagerState");
                    Composer startRestartGroup = composer.startRestartGroup(-1151885811);
                    if ((i2 & 1) != 0) {
                        i3 = i | 6;
                    } else if ((i & 6) == 0) {
                        if (startRestartGroup.changed(pagerState)) {
                            i4 = 4;
                        } else {
                            i4 = 2;
                        }
                        i3 = i4 | i;
                    } else {
                        i3 = i;
                    }
                    int i6 = i2 & 2;
                    if (i6 != 0) {
                        i3 |= 48;
                    } else if ((i & 48) == 0) {
                        if ((i & 64) == 0) {
                            changedInstance = startRestartGroup.changed(collapsibleListState3);
                        } else {
                            changedInstance = startRestartGroup.changedInstance(collapsibleListState3);
                        }
                        if (changedInstance) {
                            i5 = 32;
                        } else {
                            i5 = 16;
                        }
                        i3 |= i5;
                    }
                    if ((i3 & 19) != 18) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (startRestartGroup.shouldExecute(z, i3 & 1)) {
                        if (i6 != 0) {
                            collapsibleListState2 = null;
                        } else {
                            collapsibleListState2 = collapsibleListState3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1151885811, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.TabContent (SeriesNormalRankPage.kt:484)");
                        }
                        HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
                        if (c2 != null) {
                            if (c2 instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c2.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            Modifier f = SizeKt.f(BackgroundKt.d(Modifier.Companion, t0(pagerState.u(), seriesRankViewModel, startRestartGroup, 0), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), 0.0f, 1, (Object) null);
                            startRestartGroup.startReplaceGroup(1849434622);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.v1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Object k0;
                                        k0 = SeriesNormalRankPageKt.k0(((Integer) obj).intValue());
                                        return k0;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            CollapsibleListState collapsibleListState4 = collapsibleListState2;
                            composer2 = startRestartGroup;
                            PagerKt.i(pagerState, f, (i2) null, (androidx.compose.foundation.pager.n) null, 1, 0.0f, (e.c) null, (z2) null, false, false, (Function1) rememberedValue, (androidx.compose.ui.input.nestedscroll.b) null, androidx.compose.runtime.internal.t.e(-950178198, true, new c(seriesRankViewModel, collapsibleListState2), startRestartGroup, 54), composer2, (i3 & 14) | 24576, 390, 3052);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            collapsibleListState3 = collapsibleListState4;
                        } else {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                    }
                    t3 endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.w1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit l0;
                                l0 = SeriesNormalRankPageKt.l0(pagerState, collapsibleListState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return l0;
                            }
                        });
                    }
                }

                public static final void C(final int i, CollapsibleListState collapsibleListState, Composer composer, final int i2, final int i3) {
                    int i4;
                    int i5;
                    boolean changedInstance;
                    int i6;
                    boolean z;
                    CreationExtras creationExtras;
                    Object obj;
                    p90 p90Var;
                    String str;
                    final CollapsibleListState collapsibleListState2 = collapsibleListState;
                    Composer startRestartGroup = composer.startRestartGroup(-168554872);
                    int currentMarker = startRestartGroup.getCurrentMarker();
                    if ((i3 & 1) != 0) {
                        i4 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (startRestartGroup.changed(i)) {
                            i5 = 4;
                        } else {
                            i5 = 2;
                        }
                        i4 = i5 | i2;
                    } else {
                        i4 = i2;
                    }
                    int i7 = i3 & 2;
                    if (i7 != 0) {
                        i4 |= 48;
                    } else if ((i2 & 48) == 0) {
                        if ((i2 & 64) == 0) {
                            changedInstance = startRestartGroup.changed(collapsibleListState2);
                        } else {
                            changedInstance = startRestartGroup.changedInstance(collapsibleListState2);
                        }
                        if (changedInstance) {
                            i6 = 32;
                        } else {
                            i6 = 16;
                        }
                        i4 |= i6;
                    }
                    int i8 = i4;
                    if ((i8 & 19) != 18) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (startRestartGroup.shouldExecute(z, i8 & 1)) {
                        if (i7 != 0) {
                            collapsibleListState2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-168554872, i8, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.BackgroundPicture (SeriesNormalRankPage.kt:453)");
                        }
                        HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
                        if (c2 != null) {
                            if (c2 instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c2.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            og4.a aVar = og4.a.a;
                            int i9 = og4.a.b;
                            boolean d = com.dragon.read.kmp.service.d1.d(aVar.e(startRestartGroup, i9));
                            startRestartGroup.startReplaceGroup(1849434622);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            Composer.Companion companion = Composer.Companion;
                            if (rememberedValue == companion.getEmpty()) {
                                obj = null;
                                rememberedValue = SnapshotStateKt.mutableStateOf$default(x0.i.d(x0.i.g(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                obj = null;
                            }
                            final MutableState mutableState = (MutableState) rememberedValue;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(1227534085);
                            if (collapsibleListState2 != null && ((ko4.b) seriesRankViewModel.d.getValue()).b) {
                                startRestartGroup.startReplaceGroup(5004770);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.z0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            Unit F;
                                            F = SeriesNormalRankPageKt.F(mutableState, ((Float) obj2).floatValue());
                                            return F;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceGroup();
                                CollapsibleListLayoutKt.n(collapsibleListState2, (Function1) rememberedValue2, startRestartGroup, CollapsibleListState.q | 48 | ((i8 >> 3) & 14));
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier.a aVar2 = Modifier.Companion;
                            Modifier d2 = BackgroundKt.d(SizeKt.i(SizeKt.h(androidx.compose.foundation.layout.u1.f(aVar2, 0.0f, D(mutableState), 1, obj), 0.0f, 1, obj), x0.i.g(340)), aVar.h(startRestartGroup, i9).b(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                            androidx.compose.ui.layout.p0 i10 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier e = ComposedModifierKt.e(startRestartGroup, d2);
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
                            Composer b2 = g5.b(startRestartGroup);
                            g5.e(b2, i10, companion2.c());
                            g5.e(b2, currentCompositionLocalMap, companion2.e());
                            Function2 b3 = companion2.b();
                            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                                b2.updateRememberedValue(Integer.valueOf(a2));
                                b2.apply(Integer.valueOf(a2), b3);
                            }
                            g5.e(b2, e, companion2.d());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                            startRestartGroup.startReplaceGroup(-1583343567);
                            io4.b bVar = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, i);
                            if (bVar != null && (p90Var = bVar.a) != null) {
                                if (d) {
                                    str = p90Var.p;
                                } else {
                                    str = p90Var.o;
                                }
                                com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                                nVar.a = androidx.compose.ui.layout.i.a.a();
                                Unit unit = Unit.INSTANCE;
                                LoadImageKt.g(str, (String) null, nVar, boxScopeInstance.a(aVar2), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 114);
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                startRestartGroup.endToMarker(currentMarker);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.a1
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj2, Object obj3) {
                                            Unit G;
                                            G = SeriesNormalRankPageKt.G(i, collapsibleListState2, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                                            return G;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        } else {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.b1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit H;
                                H = SeriesNormalRankPageKt.H(i, collapsibleListState2, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                                return H;
                            }
                        });
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
                /* JADX WARN: Removed duplicated region for block: B:61:0x024f  */
                /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:72:0x0244  */
                /* JADX WARN: Removed duplicated region for block: B:73:0x004c  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public static final void Z(final java.lang.String r31, float r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
                    /*
                        Method dump skipped, instructions count: 600
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPageKt.Z(java.lang.String, float, androidx.compose.runtime.Composer, int, int):void");
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x007e  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x027d  */
                /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:71:0x0272  */
                /* JADX WARN: Removed duplicated region for block: B:72:0x0075  */
                /* JADX WARN: Removed duplicated region for block: B:73:0x0051  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public static final void M(final androidx.compose.foundation.pager.PagerState r35, float r36, com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
                    /*
                        Method dump skipped, instructions count: 654
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.conent.SeriesNormalRankPageKt.M(androidx.compose.foundation.pager.PagerState, float, com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState, androidx.compose.runtime.Composer, int, int):void");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit V(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, MutableState mutableState4, float f) {
                    float f2 = 1 - f;
                    mutableState.setValue(Float.valueOf((float) (1 - (f2 * 0.25d))));
                    mutableState2.setValue(x0.i.d(x0.i.g(56 - (50 * f2))));
                    mutableState3.setValue(Float.valueOf(f));
                    mutableState4.setValue(x0.i.d(x0.i.g(x0.i.g(x0.i.g(x0.i.g(ref$FloatRef.element - ref$FloatRef2.element) - x0.i.g(12)) / 2.0f) * f2)));
                    return Unit.INSTANCE;
                }
            }
