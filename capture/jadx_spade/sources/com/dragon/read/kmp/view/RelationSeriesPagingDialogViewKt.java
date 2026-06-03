package com.dragon.read.kmp.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.basenovel.ui.ui.FootLazyColumnKt;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import com.dragon.read.kmp.viewmodel.RelationSeriesPagingViewModel;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RelationSeriesPagingDialogViewKt {

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Covode.recordClassIndex(609595);
            int[] iArr = new int[RelationSeriesPagingViewModel.FirstLoadState.values().length];
            try {
                iArr[RelationSeriesPagingViewModel.FirstLoadState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RelationSeriesPagingViewModel.FirstLoadState.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RelationSeriesPagingViewModel.FirstLoadState.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[FootLoadingState.values().length];
            try {
                iArr2[FootLoadingState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FootLoadingState.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FootLoadingState.NOT_MORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    static {
        Covode.recordClassIndex(609594);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(LazyListState lazyListState, int i, Composer composer, int i2) {
        y(lazyListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(gk4.e0 e0Var, xm4.a aVar, int i, Composer composer, int i2) {
        D(e0Var, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(gk4.e0 e0Var, xm4.a aVar, int i, Composer composer, int i2) {
        D(e0Var, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(RelationSeriesPagingViewModel relationSeriesPagingViewModel, int i, Composer composer, int i2) {
        G(relationSeriesPagingViewModel, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(FootLoadingState footLoadingState, int i, Composer composer, int i2) {
        o(footLoadingState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(FootLoadingState footLoadingState, int i, Composer composer, int i2) {
        o(footLoadingState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(int i, Composer composer, int i2) {
        s(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(int i, Composer composer, int i2) {
        u(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(LazyListState lazyListState, int i, Composer composer, int i2) {
        w(lazyListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(LazyListState lazyListState, int i, Composer composer, int i2) {
        y(lazyListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(RelationSeriesPagingViewModel relationSeriesPagingViewModel) {
        relationSeriesPagingViewModel.a.dismissDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(RelationSeriesPagingViewModel relationSeriesPagingViewModel, gk4.g0 g0Var) {
        relationSeriesPagingViewModel.i1(g0Var);
        return Unit.INSTANCE;
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ float b;
        final /* synthetic */ gk4.e0 c;
        final /* synthetic */ RelationSeriesPagingViewModel d;

        b(Modifier modifier, float f, gk4.e0 e0Var, RelationSeriesPagingViewModel relationSeriesPagingViewModel) {
            this.a = modifier;
            this.b = f;
            this.c = e0Var;
            this.d = relationSeriesPagingViewModel;
        }

        static final class a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ Modifier a;
            final /* synthetic */ float b;
            final /* synthetic */ gk4.e0 c;
            final /* synthetic */ RelationSeriesPagingViewModel d;

            a(Modifier modifier, float f, gk4.e0 e0Var, RelationSeriesPagingViewModel relationSeriesPagingViewModel) {
                this.a = modifier;
                this.b = f;
                this.c = e0Var;
                this.d = relationSeriesPagingViewModel;
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
                        ComposerKt.traceEventStart(-456448172, i, -1, "com.dragon.read.kmp.view.RelationSeriesPagingDialogView.<anonymous>.<anonymous> (RelationSeriesPagingDialogView.kt:76)");
                    }
                    Modifier modifier = this.a;
                    og4.a aVar = og4.a.a;
                    int i2 = og4.a.b;
                    Modifier d = BackgroundKt.d(modifier, aVar.h(composer, i2).D(), (f2) null, 2, (Object) null);
                    float f = this.b;
                    gk4.e0 e0Var = this.c;
                    RelationSeriesPagingViewModel relationSeriesPagingViewModel = this.d;
                    androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, d);
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
                    com.dragon.read.kmp.j.a.a("RelationSeriesPagingDialogView", "maxHeightDp = " + ((Object) x0.i.l(f)));
                    if (e0Var.b) {
                        composer.startReplaceGroup(-1996430224);
                        RelationSeriesPagingDialogViewKt.G(relationSeriesPagingViewModel, composer, 0);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-1996353406);
                        RelationSeriesPagingDialogViewKt.s(composer, 0);
                        composer.endReplaceGroup();
                    }
                    composer.startMovableGroup(1043982772, composer.joinKey(relationSeriesPagingViewModel.E0(), Long.valueOf(relationSeriesPagingViewModel.F0())));
                    float f2 = 16;
                    a6.j(relationSeriesPagingViewModel.G(), androidx.compose.foundation.layout.f2.v(Modifier.Companion, x0.i.g(f2), 0.0f, x0.i.g(f2), 0.0f, 10, (Object) null), aVar.h(composer, i2).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.a(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199728, 0, 131024);
                    composer.endMovableGroup();
                    RelationSeriesPagingDialogViewKt.u(composer, 0);
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
                    ComposerKt.traceEventStart(1252756645, i, -1, "com.dragon.read.kmp.view.RelationSeriesPagingDialogView.<anonymous> (RelationSeriesPagingDialogView.kt:75)");
                }
                pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-456448172, true, new a(this.a, this.b, this.c, this.d), composer, 54), composer, 48);
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
    public static final Unit q(FootLoadingState footLoadingState, RelationSeriesPagingViewModel relationSeriesPagingViewModel) {
        gk4.g0 E0;
        if (footLoadingState == FootLoadingState.ERROR && (E0 = relationSeriesPagingViewModel.E0()) != null) {
            relationSeriesPagingViewModel.c1(E0);
        }
        return Unit.INSTANCE;
    }

    public static final void u(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-105054472);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-105054472, i, -1, "com.dragon.read.kmp.view.PagingContentLayout (RelationSeriesPagingDialogView.kt:138)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                RelationSeriesPagingViewModel relationSeriesPagingViewModel = (RelationSeriesPagingViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesPagingViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                com.dragon.read.kmp.j.a.a("RelationSeriesPagingDialogView", "[PagingContentLayout] " + relationSeriesPagingViewModel.F0());
                startRestartGroup.startMovableGroup(2121873271, startRestartGroup.joinKey(relationSeriesPagingViewModel.E0(), Long.valueOf(relationSeriesPagingViewModel.F0())));
                y(androidx.compose.foundation.lazy.y0.c(0, 0, startRestartGroup, 6, 2), startRestartGroup, 0);
                startRestartGroup.endMovableGroup();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v;
                    v = RelationSeriesPagingDialogViewKt.v(i, (Composer) obj, ((Integer) obj2).intValue());
                    return v;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(-889933228);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-889933228, i, -1, "com.dragon.read.kmp.view.HeaderLayout (RelationSeriesPagingDialogView.kt:126)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier i2 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(20));
            androidx.compose.ui.layout.p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.d(), androidx.compose.ui.e.a.i(), startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, i2);
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
            androidx.compose.foundation.layout.m.b(BackgroundKt.d(ig4.i.c(SizeKt.i(SizeKt.x(aVar, x0.i.g(36)), x0.i.g(4)), x0.i.d(x0.i.g(2)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).o(), (f2) null, 2, (Object) null), startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.i1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t;
                    t = RelationSeriesPagingDialogViewKt.t(i, (Composer) obj, ((Integer) obj2).intValue());
                    return t;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(RelationSeriesPagingViewModel relationSeriesPagingViewModel, gk4.g0 g0Var, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        relationSeriesPagingViewModel.e = g0Var;
        relationSeriesPagingViewModel.L0(true);
        com.dragon.read.kmp.j.a.a("RelationSeriesPagingDialogView", "onGloballyPositioned");
        return Unit.INSTANCE;
    }

    private static final void w(final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2107350316);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        boolean z2 = true;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2107350316, i2, -1, "com.dragon.read.kmp.view.PanelScrollEffect (RelationSeriesPagingDialogView.kt:251)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                RelationSeriesPagingViewModel relationSeriesPagingViewModel = (RelationSeriesPagingViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesPagingViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(-1633490746);
                if ((i2 & 14) != 4) {
                    z2 = false;
                }
                boolean changedInstance = startRestartGroup.changedInstance(relationSeriesPagingViewModel) | z2;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new RelationSeriesPagingDialogViewKt$PanelScrollEffect$1$1(lazyListState, relationSeriesPagingViewModel, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue, startRestartGroup, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x;
                    x = RelationSeriesPagingDialogViewKt.x(lazyListState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return x;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(final RelationSeriesPagingViewModel relationSeriesPagingViewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-103309516);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(relationSeriesPagingViewModel)) {
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
                ComposerKt.traceEventStart(-103309516, i2, -1, "com.dragon.read.kmp.view.SplitModeHeaderLayout (RelationSeriesPagingDialogView.kt:102)");
            }
            float g = x0.i.g(24);
            startRestartGroup.startReplaceGroup(-1814856593);
            Modifier.a aVar = Modifier.Companion;
            a3.a(SizeKt.i(aVar, g), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(52)), x0.i.g(16), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.h(), false);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i4, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier s = SizeKt.s(aVar, x0.i.g(28));
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance = startRestartGroup.changedInstance(relationSeriesPagingViewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.view.g1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit H;
                        H = RelationSeriesPagingDialogViewKt.H(RelationSeriesPagingViewModel.this);
                        return H;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(b4.p(d4.a), startRestartGroup, 0), "返回icon", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(og4.a.a.h(startRestartGroup, og4.a.b).k()), 0, startRestartGroup, 48, 184);
            startRestartGroup.endNode();
            float g2 = x0.i.g(8);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.h1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit I;
                    I = RelationSeriesPagingDialogViewKt.I(RelationSeriesPagingViewModel.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return I;
                }
            });
        }
    }

    public static final void y(final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        int i3;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Composer startRestartGroup = composer.startRestartGroup(-490003170);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(lazyListState)) {
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
                ComposerKt.traceEventStart(-490003170, i2, -1, "com.dragon.read.kmp.view.RelationSeriesPagingCommonLayout (RelationSeriesPagingDialogView.kt:148)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final RelationSeriesPagingViewModel relationSeriesPagingViewModel = (RelationSeriesPagingViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesPagingViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final gk4.g0 E0 = relationSeriesPagingViewModel.E0();
                if (E0 == null) {
                    com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "RelationSeriesPagingDialogView", "[RelationSeriesPagingCommonLayout] params is null", (Throwable) null, 4, (Object) null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.x0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit z2;
                                z2 = RelationSeriesPagingDialogViewKt.z(lazyListState, i, (Composer) obj, ((Integer) obj2).intValue());
                                return z2;
                            }
                        });
                        return;
                    }
                    return;
                }
                com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
                jVar.a("RelationSeriesPagingDialogView", "[RelationSeriesPagingCommonLayout] firstLoadState=" + relationSeriesPagingViewModel.X0() + ", received lazyListState: " + lazyListState);
                com.dragon.read.kmp.viewmodel.o.K0(relationSeriesPagingViewModel, E0, null, null, 6, null);
                int i4 = c.a[relationSeriesPagingViewModel.X0().ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            startRestartGroup.startReplaceGroup(910624121);
                            jVar.a("RelationSeriesPagingDialogView", "[RelationSeriesPagingCommonLayout] using lazyListState: " + lazyListState);
                            int i5 = i2 & 14;
                            w(lazyListState, startRestartGroup, i5);
                            float f = (float) 16;
                            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(f), x0.i.g(f), 0.0f, 8, (Object) null);
                            startRestartGroup.startReplaceGroup(-1633490746);
                            boolean changedInstance = startRestartGroup.changedInstance(relationSeriesPagingViewModel) | startRestartGroup.changedInstance(E0);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.view.z0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit B;
                                        B = RelationSeriesPagingDialogViewKt.B(RelationSeriesPagingViewModel.this, E0, (androidx.compose.ui.layout.w) obj);
                                        return B;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            FootLazyColumnKt.h(lazyListState, androidx.compose.ui.layout.d1.a(v, (Function1) rememberedValue), relationSeriesPagingViewModel.n, 2, (l1) null, (i2) null, (Function2) null, d.a.a(), (Function2) null, androidx.compose.runtime.internal.t.e(604783183, true, new a(relationSeriesPagingViewModel), startRestartGroup, 54), startRestartGroup, 817892352 | i5 | (com.dragon.read.kmp.basenovel.ui.ui.a.g << 6), 368);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(1553373776);
                            startRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        startRestartGroup.startReplaceGroup(910250788);
                        Modifier f2 = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                        androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
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
                        g5.e(b2, i6, companion.c());
                        g5.e(b2, currentCompositionLocalMap, companion.e());
                        Function2 b3 = companion.b();
                        if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                            b2.updateRememberedValue(Integer.valueOf(a2));
                            b2.apply(Integer.valueOf(a2), b3);
                        }
                        g5.e(b2, e, companion.d());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                        startRestartGroup.startReplaceGroup(-1633490746);
                        boolean changedInstance2 = startRestartGroup.changedInstance(relationSeriesPagingViewModel) | startRestartGroup.changedInstance(E0);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.view.y0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit A;
                                    A = RelationSeriesPagingDialogViewKt.A(RelationSeriesPagingViewModel.this, E0);
                                    return A;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        mg4.k.k(new mg4.b((String) null, (Function0) rememberedValue2, (String) null, (Function0) null, (androidx.compose.ui.graphics.l0) null, 29, (DefaultConstructorMarker) null), true, startRestartGroup, 48, 0);
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceGroup();
                    }
                } else {
                    startRestartGroup.startReplaceGroup(909996774);
                    Modifier f3 = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                    androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
                    int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(startRestartGroup, f3);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
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
                    g5.e(b4, i7, companion2.c());
                    g5.e(b4, currentCompositionLocalMap2, companion2.e());
                    Function2 b5 = companion2.b();
                    if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                        b4.updateRememberedValue(Integer.valueOf(a4));
                        b4.apply(Integer.valueOf(a4), b5);
                    }
                    g5.e(b4, e2, companion2.d());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.a;
                    mg4.q.j(startRestartGroup, 0);
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceGroup();
                }
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
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.view.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit C;
                    C = RelationSeriesPagingDialogViewKt.C(lazyListState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return C;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final FootLoadingState footLoadingState, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        List listOf;
        CreationExtras creationExtras;
        String str;
        boolean z2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-164899248);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(footLoadingState.ordinal())) {
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
                ComposerKt.traceEventStart(-164899248, i2, -1, "com.dragon.read.kmp.view.ColumnFooterView (RelationSeriesPagingDialogView.kt:208)");
            }
            com.dragon.read.kmp.j.a.a("RelationSeriesPagingDialogView", "[ColumnFooterView] state=" + footLoadingState);
            FootLoadingState footLoadingState2 = FootLoadingState.NOT_MORE;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FootLoadingState[]{FootLoadingState.LOADING, FootLoadingState.ERROR, footLoadingState2});
            if (!listOf.contains(footLoadingState)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.w0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit p;
                            p = RelationSeriesPagingDialogViewKt.p(footLoadingState, i, (Composer) obj, ((Integer) obj2).intValue());
                            return p;
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
                final RelationSeriesPagingViewModel relationSeriesPagingViewModel = (RelationSeriesPagingViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesPagingViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(16), 7, (Object) null);
                e.f d = androidx.compose.foundation.layout.e.a.d();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 b2 = r2.b(d, aVar2.l(), startRestartGroup, 6);
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
                startRestartGroup.startReplaceGroup(1929923559);
                if (footLoadingState == footLoadingState2) {
                    Modifier b5 = w2Var.b(SizeKt.d(aVar, 0.0f, 1, (Object) null), aVar2.i());
                    androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                    int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(startRestartGroup, b5);
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
                    Composer b6 = g5.b(startRestartGroup);
                    g5.e(b6, i4, companion.c());
                    g5.e(b6, currentCompositionLocalMap2, companion.e());
                    Function2 b7 = companion.b();
                    if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a4))) {
                        b6.updateRememberedValue(Integer.valueOf(a4));
                        b6.apply(Integer.valueOf(a4), b7);
                    }
                    g5.e(b6, e2, companion.d());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                    androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.x(SizeKt.i(aVar, x0.i.g((float) 0.5d)), x0.i.g(12)), og4.a.a.h(startRestartGroup, og4.a.b).h(), (f2) null, 2, (Object) null), startRestartGroup, 0);
                    startRestartGroup.endNode();
                    a3.a(SizeKt.x(aVar, x0.i.g(8)), startRestartGroup, 6);
                }
                startRestartGroup.endReplaceGroup();
                int i5 = c.b[footLoadingState.ordinal()];
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            str = "";
                        } else {
                            str = "已显示全部内容";
                        }
                    } else {
                        str = "加载失败，请点击重试";
                    }
                } else {
                    str = "加载中...";
                }
                String str2 = str;
                startRestartGroup.startReplaceGroup(-1633490746);
                if ((i2 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changedInstance = z2 | startRestartGroup.changedInstance(relationSeriesPagingViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.view.b1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit q;
                            q = RelationSeriesPagingDialogViewKt.q(footLoadingState, relationSeriesPagingViewModel);
                            return q;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(aVar, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                og4.a aVar3 = og4.a.a;
                int i6 = og4.a.b;
                composer2 = startRestartGroup;
                a6.j(str2, modifier, 0L, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, new g3(aVar3.h(startRestartGroup, i6).h(), x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777212, (DefaultConstructorMarker) null), startRestartGroup, 0, 0, 65532);
                composer2.startReplaceGroup(1929952903);
                if (footLoadingState == footLoadingState2) {
                    a3.a(SizeKt.x(aVar, x0.i.g(8)), composer2, 6);
                    Modifier b8 = w2Var.b(SizeKt.d(aVar, 0.0f, 1, (Object) null), aVar2.i());
                    androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                    int a6 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(composer2, b8);
                    Function0 a7 = companion.a();
                    if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(a7);
                    } else {
                        composer2.useNode();
                    }
                    Composer b9 = g5.b(composer2);
                    g5.e(b9, i7, companion.c());
                    g5.e(b9, currentCompositionLocalMap3, companion.e());
                    Function2 b10 = companion.b();
                    if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a6))) {
                        b9.updateRememberedValue(Integer.valueOf(a6));
                        b9.apply(Integer.valueOf(a6), b10);
                    }
                    g5.e(b9, e3, companion.d());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.a;
                    androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.x(SizeKt.i(aVar, x0.i.g((float) 0.5d)), x0.i.g(12)), aVar3.h(composer2, i6).h(), (f2) null, 2, (Object) null), composer2, 0);
                    composer2.endNode();
                }
                composer2.endReplaceGroup();
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
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.view.c1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r;
                    r = RelationSeriesPagingDialogViewKt.r(footLoadingState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return r;
                }
            });
        }
    }

    static final class a implements Function4<Integer, com.dragon.read.kmp.basenovel.ui.ui.v0, Composer, Integer, Unit> {
        final /* synthetic */ RelationSeriesPagingViewModel a;

        a(RelationSeriesPagingViewModel relationSeriesPagingViewModel) {
            this.a = relationSeriesPagingViewModel;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var, Composer composer, Integer num2) {
            a(num.intValue(), v0Var, composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(int i, com.dragon.read.kmp.basenovel.ui.ui.v0 data, Composer composer, int i2) {
            gk4.h0 h0Var;
            Intrinsics.checkNotNullParameter(data, "data");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(604783183, i2, -1, "com.dragon.read.kmp.view.RelationSeriesPagingCommonLayout.<anonymous> (RelationSeriesPagingDialogView.kt:199)");
            }
            if (data instanceof gk4.h0) {
                h0Var = (gk4.h0) data;
            } else {
                h0Var = null;
            }
            if (h0Var != null) {
                c0.K(i, h0Var, this.a, composer, i2 & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final void D(final gk4.e0 data, final xm4.a depend, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        Modifier a2;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(depend, "depend");
        Composer startRestartGroup = composer.startRestartGroup(-1821558982);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(data)) {
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
                ComposerKt.traceEventStart(-1821558982, i2, -1, "com.dragon.read.kmp.view.RelationSeriesPagingDialogView (RelationSeriesPagingDialogView.kt:64)");
            }
            com.dragon.read.kmp.viewmodel.s sVar = new com.dragon.read.kmp.viewmodel.s(data, depend);
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                RelationSeriesPagingViewModel relationSeriesPagingViewModel = (RelationSeriesPagingViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(RelationSeriesPagingViewModel.class), c2, (String) null, sVar, creationExtras, startRestartGroup, 0, 0);
                com.dragon.read.kmp.j.a.a("RelationSeriesPagingDialogView", "data = " + data);
                gk4.g0 E0 = relationSeriesPagingViewModel.E0();
                if (E0 == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.view.e1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit E;
                                E = RelationSeriesPagingDialogViewKt.E(gk4.e0.this, depend, i, (Composer) obj, ((Integer) obj2).intValue());
                                return E;
                            }
                        });
                        return;
                    }
                    return;
                }
                float v1 = ((x0.e) startRestartGroup.consume(CompositionLocalsKt.f())).v1(data.c);
                if (data.b) {
                    float f = 12;
                    a2 = androidx.compose.ui.draw.e.a(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), k.g.e(x0.i.g(f), x0.i.g(f), 0.0f, x0.i.g(f), 4, (Object) null));
                } else {
                    float f2 = 12;
                    a2 = androidx.compose.ui.draw.e.a(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), k.g.e(x0.i.g(f2), x0.i.g(f2), 0.0f, 0.0f, 12, (Object) null));
                }
                ym4.f.c("RelationSeriesPagingDialogView", E0, androidx.compose.runtime.internal.t.e(1252756645, true, new b(a2, v1, data, relationSeriesPagingViewModel), startRestartGroup, 54), startRestartGroup, 390);
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
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.view.f1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit F;
                    F = RelationSeriesPagingDialogViewKt.F(gk4.e0.this, depend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return F;
                }
            });
        }
    }
}
