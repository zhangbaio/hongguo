package com.dragon.read.kmp.shortvideo.distribution.page.conent;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.v2;
import androidx.compose.foundation.layout.w2;
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
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.kmp.reading.model.x7;
import com.bytedance.kmp.reading.model.y7;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListLayoutKt;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import com.dragon.read.kmp.utils.ListUtils;
import com.dragon.read.kmp.utils.StringUtilsKt;
import io4.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NewRankPageComponentsKt {
    static {
        Covode.recordClassIndex(609057);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(PagerState pagerState, int i, Composer composer, int i2) {
        A(pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(CollapsibleListState collapsibleListState, PagerState pagerState, int i, Composer composer, int i2) {
        C(collapsibleListState, pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        E(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        E(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        J(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        J(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(int i, Composer composer, int i2) {
        N(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(int i, Composer composer, int i2) {
        N(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(int i, Composer composer, int i2) {
        S(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(int i, Composer composer, int i2) {
        V(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(int i, Composer composer, int i2) {
        V(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        w(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(int i, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        w(i, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(SeriesRankViewModel seriesRankViewModel) {
        io4.b bVar;
        lo4.a aVar = seriesRankViewModel.a.k;
        if (aVar != null && (bVar = (io4.b) ListUtils.INSTANCE.getItem(seriesRankViewModel.e, seriesRankViewModel.n)) != null) {
            if (io4.c.b(bVar)) {
                aVar.k(bVar);
            } else {
                List<x7> list = bVar.d;
                y7 y7Var = bVar.g;
                b.a aVar2 = bVar.b;
                aVar.f(list, y7Var, aVar2.c, aVar2.d, aVar2.i);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(MutableState mutableState, float f) {
        float coerceAtLeast;
        float f2 = 1;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f2 - ((f2 - f) * 1.5f), 0.0f);
        mutableState.setValue(Float.valueOf(coerceAtLeast));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(MutableState mutableState, float f) {
        float coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((1 - f) * 1.5f, 1.0f);
        mutableState.setValue(Float.valueOf(coerceAtMost));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(ko4.b bVar, SeriesRankViewModel seriesRankViewModel) {
        bVar.e.setValue(Boolean.TRUE);
        no4.a.h(seriesRankViewModel.f, "榜单规则", null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(ko4.b bVar, SeriesRankViewModel seriesRankViewModel) {
        bVar.e.setValue(Boolean.TRUE);
        no4.a.h(seriesRankViewModel.f, "榜单规则", null, 2, null);
        return Unit.INSTANCE;
    }

    public static final void N(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        org.jetbrains.compose.resources.b e;
        Composer startRestartGroup = composer.startRestartGroup(1375303959);
        boolean z2 = true;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1375303959, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.RuleTipsIconV2 (NewRankPageComponents.kt:205)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                String str = ((ko4.b) seriesRankViewModel.d.getValue()).d;
                boolean d = com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
                if (str != null && str.length() != 0) {
                    z2 = false;
                }
                if (z2) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.c0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit O;
                                O = NewRankPageComponentsKt.O(i, (Composer) obj, ((Integer) obj2).intValue());
                                return O;
                            }
                        });
                        return;
                    }
                    return;
                }
                final ko4.b bVar = (ko4.b) seriesRankViewModel.d.getValue();
                if (d) {
                    e = u75.r.f(u75.t.a);
                } else {
                    e = u75.r.e(u75.t.a);
                }
                androidx.compose.ui.graphics.e1 a = org.jetbrains.compose.resources.c.a(e, startRestartGroup, 0);
                Modifier s = SizeKt.s(Modifier.Companion, x0.i.g(16));
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changed = startRestartGroup.changed(bVar) | startRestartGroup.changedInstance(seriesRankViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.d0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit P;
                            P = NewRankPageComponentsKt.P(ko4.b.this, seriesRankViewModel);
                            return P;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                androidx.compose.foundation.z0.g(a, "top_rule_icon", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 48, 248);
                boolean booleanValue = ((Boolean) bVar.e.getValue()).booleanValue();
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changed2 = startRestartGroup.changed(bVar) | startRestartGroup.changedInstance(seriesRankViewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.f0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit Q;
                            Q = NewRankPageComponentsKt.Q(ko4.b.this, seriesRankViewModel, ((Boolean) obj).booleanValue());
                            return Q;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                jo4.h.n(booleanValue, str, (Function1) rememberedValue2, startRestartGroup, 0, 0);
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
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit R;
                    R = NewRankPageComponentsKt.R(i, (Composer) obj, ((Integer) obj2).intValue());
                    return R;
                }
            });
        }
    }

    public static final void S(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        org.jetbrains.compose.resources.b l;
        Composer startRestartGroup = composer.startRestartGroup(-618066560);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-618066560, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ShareEntranceIcon (NewRankPageComponents.kt:512)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                og4.a aVar = og4.a.a;
                int i2 = og4.a.b;
                boolean d = com.dragon.read.kmp.service.d1.d(aVar.e(startRestartGroup, i2));
                Modifier.a aVar2 = Modifier.Companion;
                Modifier i3 = SizeKt.i(androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar2, 0.0f, 1, (Object) null), 0.0f, SeriesNormalRankPageKt.u0(), 0.0f, 0.0f, 13, (Object) null), po4.b.d());
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar3.f(), false);
                int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, i3);
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
                g5.e(b, i4, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.x(SizeKt.d(aVar2, 0.0f, 1, (Object) null), x0.i.g(60)), 0.0f, 0.0f, x0.i.g(16), 0.0f, 11, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(seriesRankViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.n0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit T;
                            T = NewRankPageComponentsKt.T(SeriesRankViewModel.this);
                            return T;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier e2 = com.dragon.read.kmp.utils.g.e(v, false, 0L, null, null, (Function0) rememberedValue, startRestartGroup, 6, 15);
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar3.f(), false);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, e2);
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
                g5.e(b3, i5, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                    b3.updateRememberedValue(Integer.valueOf(a3));
                    b3.apply(Integer.valueOf(a3), b4);
                }
                g5.e(b3, e3, companion.d());
                u75.t tVar = u75.t.a;
                if (d) {
                    l = u75.r.m(tVar);
                } else {
                    l = u75.r.l(tVar);
                }
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(l, startRestartGroup, 0), "top_rule_icon", boxScopeInstance.b(SizeKt.s(aVar2, x0.i.g(24)), aVar3.f()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar.h(startRestartGroup, i2).k()), 0, startRestartGroup, 48, 184);
                startRestartGroup.endNode();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit U;
                    U = NewRankPageComponentsKt.U(i, (Composer) obj, ((Integer) obj2).intValue());
                    return U;
                }
            });
        }
    }

    public static final void V(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(909222164);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(909222164, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.TopRuleTipsIcon (NewRankPageComponents.kt:479)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                String str = ((ko4.b) seriesRankViewModel.d.getValue()).d;
                if (str != null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.j0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit W;
                                W = NewRankPageComponentsKt.W(i, (Composer) obj, ((Integer) obj2).intValue());
                                return W;
                            }
                        });
                        return;
                    }
                    return;
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier i2 = SizeKt.i(androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, SeriesNormalRankPageKt.u0(), 0.0f, 0.0f, 13, (Object) null), po4.b.d());
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.f(), false);
                int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, i2);
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
                g5.e(b, i3, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                final ko4.b bVar = (ko4.b) seriesRankViewModel.d.getValue();
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.x(SizeKt.d(aVar, 0.0f, 1, (Object) null), x0.i.g(60)), 0.0f, 0.0f, x0.i.g(16), 0.0f, 11, (Object) null);
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changed = startRestartGroup.changed(bVar) | startRestartGroup.changedInstance(seriesRankViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.k0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit X;
                            X = NewRankPageComponentsKt.X(ko4.b.this, seriesRankViewModel);
                            return X;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(v, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.f(), false);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier);
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
                g5.e(b3, i4, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                    b3.updateRememberedValue(Integer.valueOf(a3));
                    b3.apply(Integer.valueOf(a3), b4);
                }
                g5.e(b3, e2, companion.d());
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(u75.r.k(u75.t.a), startRestartGroup, 0), "top_rule_icon", boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(24)), aVar2.f()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(og4.a.a.h(startRestartGroup, og4.a.b).k()), 0, startRestartGroup, 48, 184);
                startRestartGroup.endNode();
                boolean booleanValue = ((Boolean) bVar.e.getValue()).booleanValue();
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changed2 = startRestartGroup.changed(bVar) | startRestartGroup.changedInstance(seriesRankViewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.l0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit Y;
                            Y = NewRankPageComponentsKt.Y(ko4.b.this, seriesRankViewModel, ((Boolean) obj).booleanValue());
                            return Y;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                jo4.h.n(booleanValue, str, (Function1) rememberedValue2, startRestartGroup, 0, 0);
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
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Z;
                    Z = NewRankPageComponentsKt.Z(i, (Composer) obj, ((Integer) obj2).intValue());
                    return Z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(ko4.b bVar, SeriesRankViewModel seriesRankViewModel, boolean z) {
        bVar.e.setValue(Boolean.FALSE);
        if (z) {
            seriesRankViewModel.f.g("榜单规则", "ok");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(ko4.b bVar, SeriesRankViewModel seriesRankViewModel, boolean z) {
        bVar.e.setValue(Boolean.FALSE);
        if (z) {
            seriesRankViewModel.f.g("榜单规则", "ok");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(MutableState mutableState, MutableState mutableState2, float f) {
        mutableState.setValue(x0.i.d(x0.i.g((f - 1) * 20)));
        mutableState2.setValue(Float.valueOf(f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, SeriesRankViewModel seriesRankViewModel, io4.b bVar) {
        com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar2;
        List<com.dragon.read.kmp.shortvideo.distribution.infinite.c> list;
        if (gVar != null) {
            com.dragon.read.kmp.shortvideo.distribution.infinite.d g = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar);
            if (g != null && (gVar2 = g.f) != null && (list = gVar2.c) != null) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    ((com.dragon.read.kmp.shortvideo.distribution.infinite.c) it2.next()).d = 9;
                }
            }
            seriesRankViewModel.p.a(gVar, FilterType.BACKGROUND);
            seriesRankViewModel.f.d(bVar, "open_zhenguo_month_filter");
        }
        return Unit.INSTANCE;
    }

    private static final void A(final PagerState pagerState, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1756048844);
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
                ComposerKt.traceEventStart(1756048844, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.NewHeaderSideTabTitleBar (NewRankPageComponents.kt:350)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                long t0 = SeriesNormalRankPageKt.t0(pagerState.u(), seriesRankViewModel, startRestartGroup, 0);
                float f = 24;
                Modifier h = SizeKt.h(BackgroundKt.d(androidx.compose.ui.draw.e.a(Modifier.Companion, k.g.e(x0.i.g(f), x0.i.g(f), 0.0f, 0.0f, 12, (Object) null)), t0, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), 0.0f, 1, (Object) null);
                s sVar = s.a;
                Modifier i4 = SizeKt.i(androidx.compose.foundation.layout.f2.v(h, 0.0f, sVar.i(), 0.0f, sVar.h(), 5, (Object) null), sVar.j(startRestartGroup, 0));
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, i4);
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
                com.dragon.read.kmp.widget.v0.b(null, x0.i.g(16), t0, false, false, androidx.compose.runtime.internal.t.e(512762982, true, new Function2<Composer, Integer, Unit>() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.NewRankPageComponentsKt$NewHeaderSideTabTitleBar$1$1

                    /* renamed from: com.dragon.read.kmp.shortvideo.distribution.page.conent.NewRankPageComponentsKt$NewHeaderSideTabTitleBar$1$1$1, reason: invalid class name */
                    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ SeriesRankViewModel a;
                        final /* synthetic */ CoroutineScope b;
                        final /* synthetic */ PagerState c;

                        AnonymousClass1(SeriesRankViewModel seriesRankViewModel, CoroutineScope coroutineScope, PagerState pagerState) {
                            this.a = seriesRankViewModel;
                            this.b = coroutineScope;
                            this.c = pagerState;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            c(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit e(SeriesRankViewModel seriesRankViewModel, io4.b bVar) {
                            seriesRankViewModel.f.i(true, bVar.f(), bVar.k, bVar.c());
                            return Unit.INSTANCE;
                        }

                        public final void c(Composer composer, int i) {
                            boolean z;
                            androidx.compose.ui.text.font.c0 c0Var;
                            Function0 function0;
                            PagerState pagerState;
                            androidx.compose.ui.text.font.c0 c0Var2;
                            float g;
                            CoroutineScope coroutineScope;
                            SeriesRankViewModel seriesRankViewModel;
                            float coerceIn;
                            String str;
                            float g2;
                            int i2;
                            Composer composer2 = composer;
                            int i3 = 1;
                            boolean z2 = false;
                            if ((i & 3) != 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (composer2.shouldExecute(z, i & 1)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(565826596, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.NewHeaderSideTabTitleBar.<anonymous>.<anonymous>.<anonymous> (NewRankPageComponents.kt:377)");
                                }
                                androidx.compose.ui.text.font.c0 a = androidx.compose.ui.text.font.c0.b.a();
                                Iterator<T> it2 = this.a.e.iterator();
                                loop0: while (true) {
                                    c0Var = a;
                                    while (it2.hasNext()) {
                                        if (com.dragon.read.kmp.shortvideo.distribution.infinite.h.j(((io4.b) it2.next()).p)) {
                                            break;
                                        }
                                    }
                                    a = androidx.compose.ui.text.font.c0.b.e();
                                }
                                final SeriesRankViewModel seriesRankViewModel2 = this.a;
                                List<io4.b> list = seriesRankViewModel2.e;
                                CoroutineScope coroutineScope2 = this.b;
                                PagerState pagerState2 = this.c;
                                int i4 = 0;
                                for (Object obj : list) {
                                    int i5 = i4 + 1;
                                    if (i4 < 0) {
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
                                    Modifier.a aVar = Modifier.Companion;
                                    Modifier d = SizeKt.d(SizeKt.F(aVar, (e.b) null, z2, 3, (Object) null), 0.0f, i3, (Object) null);
                                    composer2.startReplaceGroup(-1224400529);
                                    boolean changedInstance = composer2.changedInstance(coroutineScope2) | composer2.changed(pagerState2) | composer2.changed(i4) | composer2.changedInstance(seriesRankViewModel2) | composer2.changed(bVar);
                                    Object rememberedValue2 = composer.rememberedValue();
                                    if (!changedInstance && rememberedValue2 != companion.getEmpty()) {
                                        function0 = null;
                                    } else {
                                        final CoroutineScope coroutineScope3 = coroutineScope2;
                                        final SeriesRankViewModel seriesRankViewModel3 = seriesRankViewModel2;
                                        final PagerState pagerState3 = pagerState2;
                                        function0 = null;
                                        final int i6 = i4;
                                        Function0 function02 = 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00de: CONSTRUCTOR (r6v0 'function02' kotlin.jvm.functions.Function0) = 
                                              (r4v5 'coroutineScope3' kotlinx.coroutines.CoroutineScope A[DONT_INLINE])
                                              (r5v0 'seriesRankViewModel3' com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel A[DONT_INLINE])
                                              (r1v8 'bVar' io4.b A[DONT_INLINE])
                                              (r7v1 'pagerState3' androidx.compose.foundation.pager.PagerState A[DONT_INLINE])
                                              (r8v1 'i6' int A[DONT_INLINE])
                                             A[DECLARE_VAR, MD:(kotlinx.coroutines.CoroutineScope, com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel, io4.b, androidx.compose.foundation.pager.PagerState, int):void (m)] (LINE:34078942) call: com.dragon.read.kmp.shortvideo.distribution.page.conent.p0.<init>(kotlinx.coroutines.CoroutineScope, com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel, io4.b, androidx.compose.foundation.pager.PagerState, int):void type: CONSTRUCTOR in method: com.dragon.read.kmp.shortvideo.distribution.page.conent.NewRankPageComponentsKt$NewHeaderSideTabTitleBar$1$1.1.c(androidx.compose.runtime.Composer, int):void, file: D:\code\hongguo\capture\classes6.dex
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
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.dragon.read.kmp.shortvideo.distribution.page.conent.p0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:305)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 35 more
                                            */
                                        /*
                                            Method dump skipped, instructions count: 956
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.conent.NewRankPageComponentsKt$NewHeaderSideTabTitleBar$1$1.AnonymousClass1.c(androidx.compose.runtime.Composer, int):void");
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final Unit d(CoroutineScope coroutineScope, SeriesRankViewModel seriesRankViewModel, io4.b bVar, PagerState pagerState, int i) {
                                        kotlinx.coroutines.i.e(coroutineScope, null, null, new NewRankPageComponentsKt$NewHeaderSideTabTitleBar$1$1$1$2$1$1$1(pagerState, i, null), 3, null);
                                        seriesRankViewModel.f.i(false, bVar.f(), bVar.k, bVar.c());
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    a(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void a(Composer composer2, int i6) {
                                    boolean z2;
                                    if ((i6 & 3) != 2) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (composer2.shouldExecute(z2, i6 & 1)) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(512762982, i6, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.NewHeaderSideTabTitleBar.<anonymous>.<anonymous> (NewRankPageComponents.kt:370)");
                                        }
                                        int u = pagerState.u();
                                        Modifier f2 = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                                        float g = x0.i.g(16);
                                        b bVar = b.a;
                                        com.dragon.read.kmp.widget.slidetab.e.b(u, f2, 0L, 0L, g, bVar.b(), bVar.a(), androidx.compose.runtime.internal.t.e(565826596, true, new AnonymousClass1(seriesRankViewModel, coroutineScope, pagerState), composer2, 54), composer2, 14377008, 12);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, startRestartGroup, 54), startRestartGroup, 196656, 25);
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
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.b0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit B;
                                B = NewRankPageComponentsKt.B(pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return B;
                            }
                        });
                    }
                }

                public static final void C(final CollapsibleListState collapsingState, final PagerState pagerState, Composer composer, final int i) {
                    int i2;
                    boolean z;
                    int i3;
                    boolean changedInstance;
                    int i4;
                    Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
                    Intrinsics.checkNotNullParameter(pagerState, "pagerState");
                    Composer startRestartGroup = composer.startRestartGroup(1904303836);
                    if ((i & 6) == 0) {
                        if ((i & 8) == 0) {
                            changedInstance = startRestartGroup.changed(collapsingState);
                        } else {
                            changedInstance = startRestartGroup.changedInstance(collapsingState);
                        }
                        if (changedInstance) {
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
                            ComposerKt.traceEventStart(1904303836, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.NewHeaderTopContent (NewRankPageComponents.kt:292)");
                        }
                        Modifier.a aVar = Modifier.Companion;
                        Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, SeriesNormalRankPageKt.u0(), 0.0f, 0.0f, 13, (Object) null);
                        e.m i5 = androidx.compose.foundation.layout.e.a.i();
                        e.a aVar2 = androidx.compose.ui.e.a;
                        androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(i5, aVar2.g(), startRestartGroup, 54);
                        int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
                        Composer b = g5.b(startRestartGroup);
                        g5.e(b, a, companion.c());
                        g5.e(b, currentCompositionLocalMap, companion.e());
                        Function2 b2 = companion.b();
                        if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                            b.updateRememberedValue(Integer.valueOf(a2));
                            b.apply(Integer.valueOf(a2), b2);
                        }
                        g5.e(b, e, companion.d());
                        androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                        float d = po4.b.d();
                        startRestartGroup.startReplaceGroup(-1814856593);
                        a3.a(SizeKt.i(aVar, d), startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                        float g = x0.i.g(8);
                        startRestartGroup.startReplaceGroup(-1814856593);
                        a3.a(SizeKt.i(aVar, g), startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                        Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                        androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.b(), false);
                        int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                        androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier e2 = ComposedModifierKt.e(startRestartGroup, h);
                        Function0 a5 = companion.a();
                        if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                            androidx.compose.runtime.i.d();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(a5);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer b3 = g5.b(startRestartGroup);
                        g5.e(b3, i6, companion.c());
                        g5.e(b3, currentCompositionLocalMap2, companion.e());
                        Function2 b4 = companion.b();
                        if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                            b3.updateRememberedValue(Integer.valueOf(a4));
                            b3.apply(Integer.valueOf(a4), b4);
                        }
                        g5.e(b3, e2, companion.d());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                        int u = pagerState.u();
                        int i7 = CollapsibleListState.q;
                        int i8 = (i2 << 3) & 112;
                        E(u, collapsingState, startRestartGroup, (i7 << 3) | i8);
                        J(pagerState.u(), collapsingState, startRestartGroup, (i7 << 3) | i8);
                        startRestartGroup.endNode();
                        A(pagerState, startRestartGroup, (i2 >> 3) & 14);
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.t
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit D;
                                D = NewRankPageComponentsKt.D(collapsingState, pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return D;
                            }
                        });
                    }
                }

                public static final void J(final int i, final CollapsibleListState collapsingState, Composer composer, final int i2) {
                    int i3;
                    boolean z;
                    CreationExtras creationExtras;
                    p90 p90Var;
                    p90 p90Var2;
                    String str;
                    boolean z2;
                    String str2;
                    com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar;
                    com.dragon.read.kmp.shortvideo.distribution.infinite.d g;
                    boolean changedInstance;
                    int i4;
                    int i5;
                    Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
                    Composer startRestartGroup = composer.startRestartGroup(304209462);
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
                            changedInstance = startRestartGroup.changed(collapsingState);
                        } else {
                            changedInstance = startRestartGroup.changedInstance(collapsingState);
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
                            ComposerKt.traceEventStart(304209462, i6, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.RankTitleFoldStateLayout (NewRankPageComponents.kt:315)");
                        }
                        HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
                        if (c != null) {
                            if (c instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            io4.b bVar = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, i);
                            if (bVar != null && (p90Var = bVar.a) != null) {
                                io4.b bVar2 = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, i);
                                if (bVar2 != null && (gVar = bVar2.p) != null && (g = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar)) != null) {
                                    p90Var2 = g.b;
                                } else {
                                    p90Var2 = null;
                                }
                                if (p90Var2 != null) {
                                    str = p90Var2.k;
                                } else {
                                    str = null;
                                }
                                if (str != null && str.length() != 0) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    p90Var = p90Var2;
                                }
                                if (com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b))) {
                                    str2 = p90Var.l;
                                } else {
                                    str2 = p90Var.k;
                                }
                                String str3 = str2;
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                Composer.Companion companion = Composer.Companion;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final MutableState mutableState = (MutableState) rememberedValue;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(5004770);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.z
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            Unit L;
                                            L = NewRankPageComponentsKt.L(mutableState, ((Float) obj).floatValue());
                                            return L;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceGroup();
                                CollapsibleListLayoutKt.n(collapsingState, (Function1) rememberedValue2, startRestartGroup, CollapsibleListState.q | 48 | ((i6 >> 3) & 14));
                                Modifier.a aVar = Modifier.Companion;
                                Modifier u = SizeKt.u(androidx.compose.foundation.layout.f2.v(androidx.compose.ui.draw.a.a(aVar, ((Number) mutableState.getValue()).floatValue()), 0.0f, 0.0f, 0.0f, x0.i.g(13), 7, (Object) null), x0.i.g(118), x0.i.g(24));
                                androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                                int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e = ComposedModifierKt.e(startRestartGroup, u);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                                Function0 a2 = companion2.a();
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
                                g5.e(b, i7, companion2.c());
                                g5.e(b, currentCompositionLocalMap, companion2.e());
                                Function2 b2 = companion2.b();
                                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                                    b.updateRememberedValue(Integer.valueOf(a));
                                    b.apply(Integer.valueOf(a), b2);
                                }
                                g5.e(b, e, companion2.d());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                Object obj = rememberedValue3;
                                if (rememberedValue3 == companion.getEmpty()) {
                                    com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                                    nVar.a(com.bytedance.kmp.image.options.l.b.f());
                                    startRestartGroup.updateRememberedValue(nVar);
                                    obj = nVar;
                                }
                                startRestartGroup.endReplaceGroup();
                                LoadImageKt.g(str3, (String) null, (com.dragon.read.kmp.compose.common.image.n) obj, boxScopeInstance.a(aVar), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 384, 114);
                                startRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.y
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj2, Object obj3) {
                                            Unit K;
                                            K = NewRankPageComponentsKt.K(i, collapsingState, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                            return K;
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
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.a0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit M;
                                M = NewRankPageComponentsKt.M(i, collapsingState, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                return M;
                            }
                        });
                    }
                }

                public static final void w(final int i, final CollapsibleListState collapsingState, Composer composer, final int i2) {
                    int i3;
                    boolean z;
                    final int i4;
                    final CollapsibleListState collapsibleListState;
                    CreationExtras creationExtras;
                    p90 p90Var;
                    p90 p90Var2;
                    String str;
                    boolean z2;
                    p90 p90Var3;
                    String str2;
                    List<androidx.compose.ui.graphics.l0> b;
                    com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar;
                    com.dragon.read.kmp.shortvideo.distribution.infinite.d g;
                    boolean changedInstance;
                    int i5;
                    int i6;
                    Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
                    Composer startRestartGroup = composer.startRestartGroup(610154552);
                    int currentMarker = startRestartGroup.getCurrentMarker();
                    if ((i2 & 6) == 0) {
                        if (startRestartGroup.changed(i)) {
                            i6 = 4;
                        } else {
                            i6 = 2;
                        }
                        i3 = i6 | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i2 & 64) == 0) {
                            changedInstance = startRestartGroup.changed(collapsingState);
                        } else {
                            changedInstance = startRestartGroup.changedInstance(collapsingState);
                        }
                        if (changedInstance) {
                            i5 = 32;
                        } else {
                            i5 = 16;
                        }
                        i3 |= i5;
                    }
                    int i7 = i3;
                    if ((i7 & 19) != 18) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (startRestartGroup.shouldExecute(z, i7 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(610154552, i7, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.NewBackgroundPicture (NewRankPageComponents.kt:233)");
                        }
                        HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
                        if (c != null) {
                            if (c instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            og4.a aVar = og4.a.a;
                            int i8 = og4.a.b;
                            boolean d = com.dragon.read.kmp.service.d1.d(aVar.e(startRestartGroup, i8));
                            startRestartGroup.startReplaceGroup(1849434622);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            Composer.Companion companion = Composer.Companion;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt.mutableStateOf$default(x0.i.d(x0.i.g(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final MutableState mutableState = (MutableState) rememberedValue;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(1849434622);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            final MutableState mutableState2 = (MutableState) rememberedValue2;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1633490746);
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.e0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit x;
                                        x = NewRankPageComponentsKt.x(mutableState, mutableState2, ((Float) obj).floatValue());
                                        return x;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceGroup();
                            CollapsibleListLayoutKt.n(collapsingState, (Function1) rememberedValue3, startRestartGroup, ((i7 >> 3) & 14) | CollapsibleListState.q | 48);
                            Modifier.a aVar2 = Modifier.Companion;
                            Modifier d2 = BackgroundKt.d(SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(340)), aVar.h(startRestartGroup, i8).b(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                            e.a aVar3 = androidx.compose.ui.e.a;
                            androidx.compose.ui.layout.p0 i9 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier e = ComposedModifierKt.e(startRestartGroup, d2);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                            Function0 a2 = companion2.a();
                            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                                androidx.compose.runtime.i.d();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(a2);
                            } else {
                                startRestartGroup.useNode();
                            }
                            Composer b2 = g5.b(startRestartGroup);
                            g5.e(b2, i9, companion2.c());
                            g5.e(b2, currentCompositionLocalMap, companion2.e());
                            Function2 b3 = companion2.b();
                            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                                b2.updateRememberedValue(Integer.valueOf(a));
                                b2.apply(Integer.valueOf(a), b3);
                            }
                            g5.e(b2, e, companion2.d());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                            startRestartGroup.startReplaceGroup(-628349136);
                            io4.b bVar = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, i);
                            if (bVar != null && (p90Var = bVar.a) != null) {
                                io4.b bVar2 = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, i);
                                if (bVar2 != null && (gVar = bVar2.p) != null && (g = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar)) != null) {
                                    p90Var2 = g.b;
                                } else {
                                    p90Var2 = null;
                                }
                                if (p90Var2 != null) {
                                    str = p90Var2.k;
                                } else {
                                    str = null;
                                }
                                if (str != null && str.length() != 0) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    p90Var3 = p90Var;
                                } else {
                                    p90Var3 = p90Var2;
                                }
                                Modifier a3 = androidx.compose.ui.draw.a.a(androidx.compose.foundation.layout.u1.f(boxScopeInstance.a(aVar2), 0.0f, ((x0.i) mutableState.getValue()).m(), 1, (Object) null), ((Number) mutableState2.getValue()).floatValue());
                                androidx.compose.ui.layout.p0 i10 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e2 = ComposedModifierKt.e(startRestartGroup, a3);
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
                                Composer b4 = g5.b(startRestartGroup);
                                g5.e(b4, i10, companion2.c());
                                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                                Function2 b5 = companion2.b();
                                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                                    b4.updateRememberedValue(Integer.valueOf(a4));
                                    b4.apply(Integer.valueOf(a4), b5);
                                }
                                g5.e(b4, e2, companion2.d());
                                if (d) {
                                    str2 = p90Var3.p;
                                } else {
                                    str2 = p90Var3.o;
                                }
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                Object obj = rememberedValue4;
                                if (rememberedValue4 == companion.getEmpty()) {
                                    com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                                    nVar.a(com.bytedance.kmp.image.options.l.b.c());
                                    nVar.c = 200;
                                    startRestartGroup.updateRememberedValue(nVar);
                                    obj = nVar;
                                }
                                startRestartGroup.endReplaceGroup();
                                p90 p90Var4 = p90Var3;
                                LoadImageKt.g(str2, (String) null, (com.dragon.read.kmp.compose.common.image.n) obj, boxScopeInstance.a(aVar2), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 384, 114);
                                startRestartGroup.endNode();
                                if (d) {
                                    b = po4.b.a(p90Var4);
                                } else {
                                    b = po4.b.b(p90Var4);
                                }
                                List<androidx.compose.ui.graphics.l0> list = b;
                                startRestartGroup.startReplaceGroup(-2098446821);
                                if (list.size() >= 2) {
                                    androidx.compose.foundation.layout.m.b(BackgroundKt.b(androidx.compose.ui.draw.a.a(SizeKt.f(aVar2, 0.0f, 1, (Object) null), 1 - ((Number) mutableState2.getValue()).floatValue()), c0.a.h(androidx.compose.ui.graphics.c0.b, list, a0.f.e((Float.floatToRawIntBits(Float.POSITIVE_INFINITY) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), a0.f.e((Float.floatToRawIntBits(Float.POSITIVE_INFINITY) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32)), 0, 8, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null), startRestartGroup, 0);
                                }
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                i4 = i;
                                collapsibleListState = collapsingState;
                            } else {
                                startRestartGroup.endToMarker(currentMarker);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.h0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj2, Object obj3) {
                                            Unit y;
                                            y = NewRankPageComponentsKt.y(i, collapsingState, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                            return y;
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
                        i4 = i;
                        collapsibleListState = collapsingState;
                        startRestartGroup.skipToGroupEnd();
                    }
                    t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.i0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit z3;
                                z3 = NewRankPageComponentsKt.z(i4, collapsibleListState, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                return z3;
                            }
                        });
                    }
                }

                public static final void E(final int i, final CollapsibleListState collapsingState, Composer composer, final int i2) {
                    int i3;
                    boolean z;
                    final int i4;
                    final CollapsibleListState collapsibleListState;
                    Composer composer2;
                    CreationExtras creationExtras;
                    p90 p90Var;
                    com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar;
                    p90 p90Var2;
                    String str;
                    boolean z2;
                    p90 p90Var3;
                    String str2;
                    String str3;
                    long e;
                    MutableState<String> mutableState;
                    String str4;
                    long e2;
                    Modifier modifier;
                    String str5;
                    v2 v2Var;
                    int i5;
                    String str6;
                    String str7;
                    String str8;
                    com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar2;
                    com.dragon.read.kmp.shortvideo.distribution.infinite.d g;
                    boolean changedInstance;
                    int i6;
                    int i7;
                    Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
                    Composer startRestartGroup = composer.startRestartGroup(-956592530);
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
                            changedInstance = startRestartGroup.changed(collapsingState);
                        } else {
                            changedInstance = startRestartGroup.changedInstance(collapsingState);
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
                            ComposerKt.traceEventStart(-956592530, i8, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.NewRankPageTitleGroup (NewRankPageComponents.kt:89)");
                        }
                        HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
                        if (c != null) {
                            if (c instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                            final io4.b bVar = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, i);
                            io4.b bVar2 = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, i);
                            if (bVar2 != null && (p90Var = bVar2.a) != null) {
                                io4.b bVar3 = (io4.b) CollectionsKt___CollectionsKt.getOrNull(seriesRankViewModel.e, i);
                                if (bVar3 != null) {
                                    gVar = bVar3.p;
                                } else {
                                    gVar = null;
                                }
                                if (gVar != null && (g = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar)) != null) {
                                    p90Var2 = g.b;
                                } else {
                                    p90Var2 = null;
                                }
                                if (p90Var2 != null) {
                                    str = p90Var2.k;
                                } else {
                                    str = null;
                                }
                                if (str != null && str.length() != 0) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    p90Var3 = p90Var;
                                } else {
                                    p90Var3 = p90Var2;
                                }
                                boolean d = com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
                                if (d) {
                                    str2 = p90Var3.l;
                                } else {
                                    str2 = p90Var3.k;
                                }
                                if (d) {
                                    str3 = str2;
                                    e = com.dragon.read.kmp.utils.j.e(p90Var3.n, androidx.compose.ui.graphics.n0.b(17985));
                                } else {
                                    str3 = str2;
                                    e = com.dragon.read.kmp.utils.j.e(p90Var3.m, androidx.compose.ui.graphics.n0.b(17985));
                                }
                                long j = e;
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                Composer.Companion companion = Composer.Companion;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final MutableState mutableState2 = (MutableState) rememberedValue;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(5004770);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.v
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            Unit I;
                                            I = NewRankPageComponentsKt.I(mutableState2, ((Float) obj).floatValue());
                                            return I;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceGroup();
                                final com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar3 = gVar;
                                CollapsibleListLayoutKt.n(collapsingState, (Function1) rememberedValue2, startRestartGroup, CollapsibleListState.q | 48 | ((i8 >> 3) & 14));
                                Modifier modifier2 = Modifier.Companion;
                                float f = 16;
                                Modifier a = androidx.compose.ui.draw.a.a(androidx.compose.foundation.layout.f2.v(SizeKt.h(modifier2, 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, 0.0f, 0.0f, 14, (Object) null), ((Number) mutableState2.getValue()).floatValue());
                                e.a aVar = androidx.compose.ui.e.a;
                                e.b k = aVar.k();
                                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(eVar.i(), k, startRestartGroup, 48);
                                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e3 = ComposedModifierKt.e(startRestartGroup, a);
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
                                g5.e(b, a2, companion2.c());
                                g5.e(b, currentCompositionLocalMap, companion2.e());
                                Function2 b2 = companion2.b();
                                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                                    b.updateRememberedValue(Integer.valueOf(a3));
                                    b.apply(Integer.valueOf(a3), b2);
                                }
                                g5.e(b, e3, companion2.d());
                                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                                startRestartGroup.startReplaceGroup(1849434622);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                Object obj = rememberedValue3;
                                if (rememberedValue3 == companion.getEmpty()) {
                                    com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                                    nVar.a(com.bytedance.kmp.image.options.l.b.c());
                                    startRestartGroup.updateRememberedValue(nVar);
                                    obj = nVar;
                                }
                                com.dragon.read.kmp.compose.common.image.n nVar2 = (com.dragon.read.kmp.compose.common.image.n) obj;
                                startRestartGroup.endReplaceGroup();
                                Modifier u = SizeKt.u(modifier2, x0.i.g(139), x0.i.g(31));
                                androidx.compose.ui.layout.p0 i9 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
                                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier e4 = ComposedModifierKt.e(startRestartGroup, u);
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
                                Composer b3 = g5.b(startRestartGroup);
                                g5.e(b3, i9, companion2.c());
                                g5.e(b3, currentCompositionLocalMap2, companion2.e());
                                Function2 b4 = companion2.b();
                                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                                    b3.updateRememberedValue(Integer.valueOf(a5));
                                    b3.apply(Integer.valueOf(a5), b4);
                                }
                                g5.e(b3, e4, companion2.d());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                                p90 p90Var4 = p90Var3;
                                com.dragon.read.kmp.compose.common.image.g.b(str3, (String) null, nVar2, SizeKt.d(modifier2, 0.0f, 1, (Object) null), (com.bytedance.kmp.image.options.i) null, 0.0f, (kg4.b) null, startRestartGroup, 3456, 114);
                                startRestartGroup.endNode();
                                com.dragon.read.kmp.shortvideo.distribution.infinite.d g2 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar3);
                                if (g2 != null && (gVar2 = g2.f) != null) {
                                    mutableState = gVar2.h;
                                } else {
                                    mutableState = null;
                                }
                                if (d) {
                                    y7 y7Var = p90Var4.x;
                                    if (y7Var != null) {
                                        str8 = y7Var.q;
                                    } else {
                                        str8 = null;
                                    }
                                    e2 = com.dragon.read.kmp.utils.j.e(str8, androidx.compose.ui.graphics.n0.b(17985));
                                } else {
                                    y7 y7Var2 = p90Var4.x;
                                    if (y7Var2 != null) {
                                        str4 = y7Var2.p;
                                    } else {
                                        str4 = null;
                                    }
                                    e2 = com.dragon.read.kmp.utils.j.e(str4, androidx.compose.ui.graphics.n0.b(17985));
                                }
                                long j2 = e2;
                                float f2 = 6;
                                a3.a(SizeKt.h(SizeKt.i(modifier2, x0.i.g(f2)), 0.0f, 1, (Object) null), startRestartGroup, 6);
                                String str9 = "";
                                if (seriesRankViewModel.Q0()) {
                                    startRestartGroup.startReplaceGroup(-495303123);
                                    Modifier h = SizeKt.h(modifier2, 0.0f, 1, (Object) null);
                                    androidx.compose.ui.layout.p0 b5 = r2.b(eVar.h(), aVar.i(), startRestartGroup, 48);
                                    int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                    androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier e5 = ComposedModifierKt.e(startRestartGroup, h);
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
                                    g5.e(b6, b5, companion2.c());
                                    g5.e(b6, currentCompositionLocalMap3, companion2.e());
                                    Function2 b7 = companion2.b();
                                    if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a7))) {
                                        b6.updateRememberedValue(Integer.valueOf(a7));
                                        b6.apply(Integer.valueOf(a7), b7);
                                    }
                                    g5.e(b6, e5, companion2.d());
                                    v2 v2Var2 = w2.b;
                                    startRestartGroup.startReplaceGroup(-1839607113);
                                    if (mutableState != null) {
                                        str5 = (String) mutableState.getValue();
                                    } else {
                                        str5 = null;
                                    }
                                    if (StringUtilsKt.a(str5)) {
                                        Modifier F = SizeKt.F(modifier2, (e.b) null, false, 3, (Object) null);
                                        startRestartGroup.startReplaceGroup(-1746271574);
                                        boolean changed = startRestartGroup.changed(gVar3) | startRestartGroup.changedInstance(seriesRankViewModel) | startRestartGroup.changed(bVar);
                                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (changed || rememberedValue4 == companion.getEmpty()) {
                                            rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.w
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    Unit G;
                                                    G = NewRankPageComponentsKt.G(com.dragon.read.kmp.shortvideo.distribution.infinite.g.this, seriesRankViewModel, bVar);
                                                    return G;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(F, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null);
                                        androidx.compose.ui.layout.p0 b8 = r2.b(eVar.h(), aVar.i(), startRestartGroup, 48);
                                        int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                                        androidx.compose.runtime.e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier e6 = ComposedModifierKt.e(startRestartGroup, modifier3);
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
                                        Composer b9 = g5.b(startRestartGroup);
                                        g5.e(b9, b8, companion2.c());
                                        g5.e(b9, currentCompositionLocalMap4, companion2.e());
                                        Function2 b10 = companion2.b();
                                        if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a9))) {
                                            b9.updateRememberedValue(Integer.valueOf(a9));
                                            b9.apply(Integer.valueOf(a9), b10);
                                        }
                                        g5.e(b9, e6, companion2.d());
                                        if (mutableState == null || (str7 = (String) mutableState.getValue()) == null) {
                                            str7 = "";
                                        }
                                        i5 = 12;
                                        v2Var = v2Var2;
                                        a6.j(str7, SizeKt.F(modifier2, (e.b) null, false, 3, (Object) null), j2, x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.f()), x0.x.h(12), w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 3120, 3126, 119280);
                                        startRestartGroup = startRestartGroup;
                                        modifier = modifier2;
                                        androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(yo2.d2.H(f2.a.a), startRestartGroup, 0), "background_filter_down", SizeKt.s(modifier2, x0.i.g(8)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(j2), 0, startRestartGroup, 432, 184);
                                        startRestartGroup.endNode();
                                        float g3 = x0.i.g(f2);
                                        startRestartGroup.startReplaceGroup(-344996060);
                                        a3.a(SizeKt.x(modifier, g3), startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                        a3.a(BackgroundKt.d(SizeKt.i(SizeKt.x(modifier, x0.i.g(1)), x0.i.g(20)), androidx.compose.ui.graphics.n0.b(167772160), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 6);
                                        float g4 = x0.i.g(f2);
                                        startRestartGroup.startReplaceGroup(-344996060);
                                        a3.a(SizeKt.x(modifier, g4), startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        v2Var = v2Var2;
                                        modifier = modifier2;
                                        i5 = 12;
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    String str10 = p90Var4.j;
                                    if (str10 == null) {
                                        str6 = "";
                                    } else {
                                        str6 = str10;
                                    }
                                    long h2 = x0.x.h(i5);
                                    int f3 = w0.h.b.f();
                                    long h3 = x0.x.h(i5);
                                    int b11 = w0.s.b.b();
                                    Modifier a11 = v2Var.a(androidx.compose.foundation.layout.f2.v(SizeKt.F(modifier, (e.b) null, false, 3, (Object) null), 0.0f, 0.0f, x0.i.g(2), 0.0f, 11, (Object) null), 1.0f, false);
                                    w0.h h4 = w0.h.h(f3);
                                    composer2 = startRestartGroup;
                                    a6.j(str6, a11, j, h2, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, h4, h3, b11, false, 1, 0, (Function1) null, (g3) null, composer2, 3072, 3126, 119280);
                                    N(composer2, 0);
                                    a3.a(SizeKt.x(modifier, x0.i.g(12)), composer2, 6);
                                    composer2.endNode();
                                    composer2.endReplaceGroup();
                                } else {
                                    modifier = modifier2;
                                    composer2 = startRestartGroup;
                                    composer2.startReplaceGroup(-492714902);
                                    String str11 = p90Var4.j;
                                    if (str11 != null) {
                                        str9 = str11;
                                    }
                                    a6.j(str9, androidx.compose.foundation.layout.f2.v(SizeKt.h(modifier, 0.0f, 1, (Object) null), 0.0f, 0.0f, x0.i.g(f), 0.0f, 11, (Object) null), j, x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.f()), x0.x.h(16), w0.s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer2, 3120, 3126, 119280);
                                    composer2.endReplaceGroup();
                                }
                                float g5 = x0.i.g(f);
                                composer2.startReplaceGroup(-1814856593);
                                a3.a(SizeKt.i(modifier, g5), composer2, 0);
                                composer2.endReplaceGroup();
                                composer2.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                i4 = i;
                                collapsibleListState = collapsingState;
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.u
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj2, Object obj3) {
                                            Unit F2;
                                            F2 = NewRankPageComponentsKt.F(i, collapsingState, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                            return F2;
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
                        i4 = i;
                        collapsibleListState = collapsingState;
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                    }
                    t3 endRestartGroup2 = composer2.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.x
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit H;
                                H = NewRankPageComponentsKt.H(i4, collapsibleListState, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                return H;
                            }
                        });
                    }
                }
            }
