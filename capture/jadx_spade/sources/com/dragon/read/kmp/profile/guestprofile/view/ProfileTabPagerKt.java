package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.eo;
import com.bytedance.kmp.reading.model.l10;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListLayoutKt;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.rpc.kmp.community.model.c7;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileTabPagerKt {
    private static final ProvidableCompositionLocal<tl4.l> a;
    private static final ProvidableCompositionLocal<com.dragon.read.kmp.profile.guestprofile.viewmodel.e0> b;

    public static final class c implements androidx.compose.ui.input.nestedscroll.b {
        c() {
        }

        public /* synthetic */ long Y(long j, long j2, int i) {
            return androidx.compose.ui.input.nestedscroll.a.b(this, j, j2, i);
        }

        public /* synthetic */ long Y1(long j, int i) {
            return androidx.compose.ui.input.nestedscroll.a.d(this, j, i);
        }

        public /* synthetic */ Object a1(long j, long j2, Continuation continuation) {
            return androidx.compose.ui.input.nestedscroll.a.a(this, j, j2, continuation);
        }

        public /* synthetic */ Object k0(long j, Continuation continuation) {
            return androidx.compose.ui.input.nestedscroll.a.c(this, j, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(PagerState pagerState, com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 e0Var, int i, Composer composer, int i2) {
        G(pagerState, e0Var, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(CollapsibleListState collapsibleListState, boolean z, int i, Composer composer, int i2) {
        l(collapsibleListState, z, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(GuestProfileViewModel guestProfileViewModel, PagerState pagerState, CollapsibleListState collapsibleListState, int i, Composer composer, int i2) {
        o(guestProfileViewModel, pagerState, collapsibleListState, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(GuestProfileViewModel guestProfileViewModel, CollapsibleListState collapsibleListState, PagerState pagerState, int i, Composer composer, int i2) {
        v(guestProfileViewModel, collapsibleListState, pagerState, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal<tl4.l> E() {
        return a;
    }

    public static final ProvidableCompositionLocal<com.dragon.read.kmp.profile.guestprofile.viewmodel.e0> F() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tl4.l j() {
        throw new IllegalStateException("No BaseGuestProfileOneTabViewModel provided".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 k() {
        throw new IllegalStateException("No BaseGuestProfileOneTabViewModel provided".toString());
    }

    static {
        Covode.recordClassIndex(608171);
        a = androidx.compose.runtime.d0.j(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tl4.l j;
                j = ProfileTabPagerKt.j();
                return j;
            }
        });
        b = androidx.compose.runtime.d0.j(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 k;
                k = ProfileTabPagerKt.k();
                return k;
            }
        });
    }

    private static final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 p(State<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> state) {
        return (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<c7> q(MutableState<List<c7>> mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<c7> w(MutableState<List<c7>> mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final boolean r(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int x(MutableState mutableState) {
        return w(mutableState).size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void s(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class b implements Function4<androidx.compose.foundation.pager.p0, Integer, Composer, Integer, Unit> {
        final /* synthetic */ GuestProfileViewModel a;
        final /* synthetic */ MutableState<List<c7>> b;
        final /* synthetic */ CollapsibleListState c;
        final /* synthetic */ PagerState d;

        b(GuestProfileViewModel guestProfileViewModel, MutableState<List<c7>> mutableState, CollapsibleListState collapsibleListState, PagerState pagerState) {
            this.a = guestProfileViewModel;
            this.b = mutableState;
            this.c = collapsibleListState;
            this.d = pagerState;
        }

        static final class a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ GuestProfileViewModel a;
            final /* synthetic */ CollapsibleListState b;
            final /* synthetic */ PagerState c;

            a(GuestProfileViewModel guestProfileViewModel, CollapsibleListState collapsibleListState, PagerState pagerState) {
                this.a = guestProfileViewModel;
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
                        ComposerKt.traceEventStart(-1657370586, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPager.<anonymous>.<anonymous>.<anonymous> (ProfileTabPager.kt:126)");
                    }
                    ProfileTabPagerKt.v(this.a, this.b, this.c, composer, CollapsibleListState.q << 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.pager.p0 p0Var, Integer num, Composer composer, Integer num2) {
            a(p0Var, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.pager.p0 HorizontalPager, int i, Composer composer, int i2) {
            boolean z;
            Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1158575334, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPager.<anonymous>.<anonymous> (ProfileTabPager.kt:118)");
            }
            c7 c7Var = (c7) ProfileTabPagerKt.q(this.b).get(i);
            composer.startReplaceGroup(-1746271574);
            boolean changed = composer.changed(this.a);
            if ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32) {
                z = true;
            } else {
                z = false;
            }
            boolean changed2 = z | changed | composer.changed(c7Var);
            GuestProfileViewModel guestProfileViewModel = this.a;
            Object rememberedValue = composer.rememberedValue();
            if (changed2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = ProfileTabPagerKt.D(guestProfileViewModel, i, c7Var);
                composer.updateRememberedValue(rememberedValue);
            }
            rl4.c cVar = (rl4.c) rememberedValue;
            composer.endReplaceGroup();
            composer.startReplaceGroup(5004770);
            boolean changed3 = composer.changed(cVar);
            GuestProfileViewModel guestProfileViewModel2 = this.a;
            Object rememberedValue2 = composer.rememberedValue();
            if (changed3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new com.dragon.read.kmp.profile.guestprofile.viewmodel.e0(cVar, c7Var, guestProfileViewModel2);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            androidx.compose.runtime.d0.c(ProfileTabPagerKt.F().provides((com.dragon.read.kmp.profile.guestprofile.viewmodel.e0) rememberedValue2), androidx.compose.runtime.internal.t.e(-1657370586, true, new a(this.a, this.c, this.d), composer, 54), composer, androidx.compose.runtime.t2.i | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    static final class a implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
        final /* synthetic */ CollapsibleListState a;
        final /* synthetic */ boolean b;

        a(CollapsibleListState collapsibleListState, boolean z) {
            this.a = collapsibleListState;
            this.b = z;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
            a(fVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1781201820, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.PlaceHolderContent.<anonymous>.<anonymous>.<anonymous> (ProfileTabPager.kt:307)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier i2 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), ((x0.i) this.a.f.getValue()).m());
                boolean z2 = this.b;
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, i2);
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
                composer.startReplaceGroup(-1289751342);
                if (z2) {
                    a6.j("该用户已注销", androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(aVar, aVar2.m()), 0.0f, x0.i.g(125), 0.0f, 0.0f, 13, (Object) null), og4.a.a.h(composer, og4.a.b).h(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 3078, 0, 131056);
                }
                composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(CollapsibleListState collapsibleListState, boolean z, androidx.compose.foundation.lazy.o0 LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        androidx.compose.foundation.lazy.n0.a(LazyColumn, (Object) null, (Object) null, androidx.compose.runtime.internal.t.c(-1781201820, true, new a(collapsibleListState, z)), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(CollapsibleListState collapsibleListState, MutableState mutableState, float f) {
        boolean z;
        if (collapsibleListState.m() == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        s(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final rl4.c D(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r34, int r35, com.dragon.read.rpc.kmp.community.model.c7 r36) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt.D(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, int, com.dragon.read.rpc.kmp.community.model.c7):rl4.c");
    }

    private static final void G(final PagerState pagerState, final com.dragon.read.kmp.profile.guestprofile.viewmodel.e0 e0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(167302215);
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
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(e0Var)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z3 = false;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(167302215, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.oneTabPageEffect (ProfileTabPager.kt:238)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1746271574);
            int i5 = i2 & 14;
            if (i5 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i2 & 112) == 32) {
                z3 = true;
            }
            boolean z4 = z2 | z3;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new ProfileTabPagerKt$oneTabPageEffect$1$1(pagerState, e0Var, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(pagerState, (Function2) rememberedValue2, startRestartGroup, i5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit J;
                    J = ProfileTabPagerKt.J(pagerState, e0Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return J;
                }
            });
        }
    }

    public static final void l(final CollapsibleListState collapsingState, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        boolean z3;
        int i3;
        boolean changedInstance;
        int i4;
        Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
        Composer startRestartGroup = composer.startRestartGroup(1472065561);
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
            if (startRestartGroup.changed(z)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        int i5 = i2;
        boolean z4 = true;
        if ((i5 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1472065561, i5, -1, "com.dragon.read.kmp.profile.guestprofile.view.PlaceHolderContent (ProfileTabPager.kt:297)");
            }
            LazyListState c2 = androidx.compose.foundation.lazy.y0.c(0, 0, startRestartGroup, 0, 3);
            CollapsibleListState.r(collapsingState, new int[]{0}, c2, (LazyGridState) null, (LazyStaggeredGridState) null, 12, (Object) null);
            Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i5 & 14) != 4 && ((i5 & 8) == 0 || !startRestartGroup.changedInstance(collapsingState))) {
                z3 = false;
            } else {
                z3 = true;
            }
            if ((i5 & 112) != 32) {
                z4 = false;
            }
            boolean z5 = z3 | z4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit m;
                        m = ProfileTabPagerKt.m(collapsingState, z, (androidx.compose.foundation.lazy.o0) obj);
                        return m;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            androidx.compose.foundation.lazy.d.c(f, c2, (androidx.compose.foundation.layout.i2) null, false, (e.m) null, (e.b) null, (androidx.compose.foundation.gestures.l1) null, false, (androidx.compose.foundation.y1) null, (Function1) rememberedValue, composer2, 6, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = ProfileTabPagerKt.n(collapsingState, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    public static final void o(final GuestProfileViewModel viewModel, PagerState pagerState, final CollapsibleListState collapsingState, Composer composer, int i) {
        int i2;
        boolean z;
        final PagerState pagerState2;
        Composer composer2;
        final int i3;
        final CollapsibleListState collapsibleListState;
        boolean z2;
        boolean z3;
        boolean z4;
        l10 l10Var;
        boolean z5;
        boolean z6;
        boolean changedInstance;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
        Composer startRestartGroup = composer.startRestartGroup(-1285789981);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(viewModel)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(pagerState)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(collapsingState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsingState);
            }
            if (changedInstance) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        int i7 = i2;
        if ((i7 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i7 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1285789981, i7, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPager (ProfileTabPager.kt:82)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 24;
            Modifier c2 = ig4.i.c(SizeKt.f(aVar, 0.0f, 1, (Object) null), (x0.i) null, x0.i.g(f), x0.i.g(f), 0.0f, 0.0f, 25, (Object) null);
            og4.a aVar2 = og4.a.a;
            int i8 = og4.a.b;
            Modifier v = androidx.compose.foundation.layout.f2.v(BackgroundKt.d(c2, aVar2.h(startRestartGroup, i8).b(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), 0.0f, SeriesGuestProfilePageKt.k1(), 0.0f, 0.0f, 13, (Object) null);
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.g(), startRestartGroup, 48);
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
            State collectAsState = SnapshotStateKt.collectAsState(viewModel.l, (CoroutineContext) null, startRestartGroup, 0, 1);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.Companion;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = viewModel.k;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            int i9 = i7 & 896;
            if (i9 != 256 && ((i7 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changed(collapsingState))) {
                z2 = false;
            } else {
                z2 = true;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == companion2.getEmpty()) {
                if (collapsingState.m() == 1.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changed = startRestartGroup.changed(mutableState2);
            if (i9 != 256 && ((i7 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(collapsingState))) {
                z4 = false;
            } else {
                z4 = true;
            }
            boolean z7 = z4 | changed;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == companion2.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit t;
                        t = ProfileTabPagerKt.t(collapsingState, mutableState2, ((Float) obj).floatValue());
                        return t;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            int i10 = CollapsibleListState.q;
            int i11 = (i7 >> 6) & 14;
            CollapsibleListLayoutKt.n(collapsingState, (Function1) rememberedValue3, startRestartGroup, i10 | i11);
            eo eoVar = p(collectAsState).a;
            if (eoVar != null) {
                l10Var = eoVar.i;
            } else {
                l10Var = null;
            }
            if (l10Var != null && r(mutableState2) && !((Boolean) viewModel.R.getValue()).booleanValue() && !qo4.b.a.c()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!((Boolean) viewModel.S.getValue()).booleanValue() && !z5) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (!p(collectAsState).d && !q(mutableState).isEmpty()) {
                startRestartGroup.startReplaceGroup(-1676768353);
                ProfileTabPageHeaderKt.j(viewModel, q(mutableState), pagerState, z6, startRestartGroup, (i7 & 14) | ((i7 << 3) & 896), 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion2.getEmpty()) {
                    rememberedValue4 = new c();
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                Modifier b4 = androidx.compose.ui.input.nestedscroll.c.b(BackgroundKt.d(SizeKt.f(aVar, 0.0f, 1, (Object) null), aVar2.h(startRestartGroup, i8).b(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), (c) rememberedValue4, (NestedScrollDispatcher) null, 2, (Object) null);
                composer2 = startRestartGroup;
                i3 = i;
                collapsibleListState = collapsingState;
                pagerState2 = pagerState;
                PagerKt.i(pagerState, b4, (androidx.compose.foundation.layout.i2) null, (androidx.compose.foundation.pager.n) null, 3, 0.0f, (e.c) null, (androidx.compose.foundation.gestures.z2) null, false, false, (Function1) null, (androidx.compose.ui.input.nestedscroll.b) null, androidx.compose.runtime.internal.t.e(1158575334, true, new b(viewModel, mutableState, collapsibleListState, pagerState), composer2, 54), composer2, ((i7 >> 3) & 14) | 24576, 384, 4076);
                composer2.endReplaceGroup();
            } else {
                pagerState2 = pagerState;
                composer2 = startRestartGroup;
                i3 = i;
                collapsibleListState = collapsingState;
                composer2.startReplaceGroup(-1676896352);
                l(collapsibleListState, p(collectAsState).d, composer2, i10 | i11);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            pagerState2 = pagerState;
            composer2 = startRestartGroup;
            i3 = i;
            collapsibleListState = collapsingState;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = ProfileTabPagerKt.u(GuestProfileViewModel.this, pagerState2, collapsibleListState, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0125 A[LOOP:1: B:52:0x00fe->B:62:0x0125, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0122 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void v(final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r37, final com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState r38, final androidx.compose.foundation.pager.PagerState r39, androidx.compose.runtime.Composer r40, final int r41) {
        /*
            Method dump skipped, instructions count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt.v(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState, androidx.compose.foundation.pager.PagerState, androidx.compose.runtime.Composer, int):void");
    }
}
