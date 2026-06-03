package com.dragon.read.leftslidepage;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.k2;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.v2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedTabLeftSlidePageKt {
    static {
        Covode.recordClassIndex(611275);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(s sVar, d dVar, SidebarDataManager sidebarDataManager, int i, int i2, Composer composer, int i3) {
        z0(sVar, dVar, sidebarDataManager, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(int i, Composer composer, int i2) {
        H(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(int i, Composer composer, int i2) {
        H(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(int i, Composer composer, int i2) {
        H(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(List list, String str, int i, int i2, Composer composer, int i3) {
        O(list, str, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(int i, Composer composer, int i2) {
        R(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(int i, Composer composer, int i2) {
        T(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(int i, Composer composer, int i2) {
        X(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(int i, Composer composer, int i2) {
        a0(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(SidebarDataManager sidebarDataManager, int i, Composer composer, int i2) {
        e0(sidebarDataManager, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(int i, Composer composer, int i2) {
        m0(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(g2 g2Var, ReportType reportType, boolean z, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        s0(g2Var, reportType, z, function0, function02, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0() {
        return Unit.INSTANCE;
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ e2 a;

        public void dispose() {
            this.a.X0();
        }

        public b(e2 e2Var) {
            this.a = e2Var;
        }
    }

    public static final class a implements DisposableEffectResult {
        final /* synthetic */ LifecycleOwner a;
        final /* synthetic */ LifecycleEventObserver b;

        public void dispose() {
            this.a.getLifecycle().removeObserver(this.b);
        }

        public a(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver) {
            this.a = lifecycleOwner;
            this.b = lifecycleEventObserver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final boolean j0(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final long l0(MutableState<Long> mutableState) {
        return ((Number) mutableState.getValue()).longValue();
    }

    private static final void f0(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    private static final void k0(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult A0(e2 e2Var, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        e2Var.W0();
        return new b(e2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(e2 e2Var, w wVar) {
        e2Var.f1(ReportType.Subscribe, wVar.a);
        String str = wVar.a;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = wVar.b;
        if (str3 != null) {
            str2 = str3;
        }
        e2Var.l1(true, str, 0, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(e2 e2Var, com.dragon.read.leftslidepage.b bVar) {
        e2Var.f1(ReportType.Follow, bVar.a);
        String str = bVar.a;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = bVar.b;
        if (str3 != null) {
            str2 = str3;
        }
        e2Var.l1(true, str, 0, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(194651986);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(194651986, i, -1, "com.dragon.read.leftslidepage.MainContent (VideoFeedTabLeftSlidePage.kt:91)");
            }
            s0.Q(startRestartGroup, 0);
            a3.a(SizeKt.i(Modifier.Companion, x0.i.g(16)), startRestartGroup, 6);
            m0(startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.u1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit S;
                    S = VideoFeedTabLeftSlidePageKt.S(i, (Composer) obj, ((Integer) obj2).intValue());
                    return S;
                }
            });
        }
    }

    private static final void X(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        long w;
        Composer startRestartGroup = composer.startRestartGroup(-569747738);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569747738, i, -1, "com.dragon.read.leftslidepage.NormalFuncArea (VideoFeedTabLeftSlidePage.kt:319)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                e2 e2Var = (e2) f2.d.c(Reflection.getOrCreateKotlinClass(e2.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                int N0 = e2Var.N0(ReportType.Func);
                MutableState<q> P0 = e2Var.P0();
                Modifier.a aVar = Modifier.Companion;
                Modifier D = SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null);
                if (com.dragon.read.kmp.service.d1.d((Theme) startRestartGroup.consume(rg4.e.l()))) {
                    startRestartGroup.startReplaceGroup(-2066718384);
                    w = og4.a.a.h(startRestartGroup, og4.a.b).D();
                } else {
                    startRestartGroup.startReplaceGroup(-2066717202);
                    w = og4.a.a.h(startRestartGroup, og4.a.b).w();
                }
                startRestartGroup.endReplaceGroup();
                Modifier c2 = BackgroundKt.c(D, w, k.g.c(x0.i.g(12)));
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 48);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, c2);
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
                a3.a(SizeKt.i(aVar, x0.i.g(16)), startRestartGroup, 6);
                String str = ((q) P0.getValue()).a.a;
                String str2 = ((q) P0.getValue()).a.b;
                boolean z2 = ((q) P0.getValue()).a.c;
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.leftslidepage.b1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit Y;
                            Y = VideoFeedTabLeftSlidePageKt.Y();
                            return Y;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                s0.u(str, str2, null, z2, (Function0) rememberedValue, startRestartGroup, 24576, 4);
                a3.a(SizeKt.i(aVar, x0.i.g(4)), startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(457985318);
                int i2 = 0;
                for (Object obj : ((q) P0.getValue()).b) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    s0.z(i2, (p) obj, N0, startRestartGroup, 0);
                    i2 = i3;
                }
                startRestartGroup.endReplaceGroup();
                a3.a(SizeKt.i(Modifier.Companion, x0.i.g(8)), startRestartGroup, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.c1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit Z;
                    Z = VideoFeedTabLeftSlidePageKt.Z(i, (Composer) obj2, ((Integer) obj3).intValue());
                    return Z;
                }
            });
        }
    }

    private static final void H(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        long w;
        Composer startRestartGroup = composer.startRestartGroup(-2131358515);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2131358515, i, -1, "com.dragon.read.leftslidepage.GameArea (VideoFeedTabLeftSlidePage.kt:272)");
            }
            if (mb2.e.a()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.v0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit I;
                            I = VideoFeedTabLeftSlidePageKt.I(i, (Composer) obj, ((Integer) obj2).intValue());
                            return I;
                        }
                    });
                    return;
                }
                return;
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final e2 e2Var = (e2) f2.d.c(Reflection.getOrCreateKotlinClass(e2.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final MutableState<i> Q0 = e2Var.Q0();
                List<r> list = ((i) Q0.getValue()).b;
                if (list.isEmpty()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        endRestartGroup2.a(new Function2() { // from class: com.dragon.read.leftslidepage.w0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit J;
                                J = VideoFeedTabLeftSlidePageKt.J(i, (Composer) obj, ((Integer) obj2).intValue());
                                return J;
                            }
                        });
                        return;
                    }
                    return;
                }
                final int N0 = e2Var.N0(ReportType.Game);
                e2Var.h1(false);
                Modifier.a aVar = Modifier.Companion;
                Modifier B = SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null);
                if (com.dragon.read.kmp.service.d1.d((Theme) startRestartGroup.consume(rg4.e.l()))) {
                    startRestartGroup.startReplaceGroup(463885559);
                    w = og4.a.a.h(startRestartGroup, og4.a.b).D();
                } else {
                    startRestartGroup.startReplaceGroup(463886741);
                    w = og4.a.a.h(startRestartGroup, og4.a.b).w();
                }
                startRestartGroup.endReplaceGroup();
                float f = 12;
                Modifier c2 = BackgroundKt.c(B, w, k.g.c(x0.i.g(f)));
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.leftslidepage.x0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit K;
                            K = VideoFeedTabLeftSlidePageKt.K((androidx.compose.ui.layout.w) obj);
                            return K;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a2 = androidx.compose.ui.layout.d1.a(c2, (Function1) rememberedValue);
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance = startRestartGroup.changedInstance(e2Var) | startRestartGroup.changed(Q0) | startRestartGroup.changed(N0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.leftslidepage.y0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit L;
                            L = VideoFeedTabLeftSlidePageKt.L(e2.this, Q0, N0);
                            return L;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(a2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i2 = eVar.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a3 = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), startRestartGroup, 0);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, a3, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                    b2.updateRememberedValue(Integer.valueOf(a4));
                    b2.apply(Integer.valueOf(a4), b3);
                }
                g5.e(b2, e, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                float f2 = 16;
                a3.a(SizeKt.i(aVar, x0.i.g(f2)), startRestartGroup, 6);
                String str = ((i) Q0.getValue()).a.a;
                String str2 = ((i) Q0.getValue()).a.b;
                boolean z2 = ((i) Q0.getValue()).a.c;
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance2 = startRestartGroup.changedInstance(e2Var) | startRestartGroup.changed(Q0) | startRestartGroup.changed(N0);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.leftslidepage.z0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit M;
                            M = VideoFeedTabLeftSlidePageKt.M(e2.this, Q0, N0);
                            return M;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                s0.u(str, str2, null, z2, (Function0) rememberedValue3, startRestartGroup, 0, 4);
                a3.a(SizeKt.i(aVar, x0.i.g(f)), startRestartGroup, 6);
                Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
                androidx.compose.ui.layout.p0 b4 = r2.b(eVar.f(), aVar2.l(), startRestartGroup, 6);
                int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
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
                Composer b5 = g5.b(startRestartGroup);
                g5.e(b5, b4, companion2.c());
                g5.e(b5, currentCompositionLocalMap2, companion2.e());
                Function2 b6 = companion2.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a6))) {
                    b5.updateRememberedValue(Integer.valueOf(a6));
                    b5.apply(Integer.valueOf(a6), b6);
                }
                g5.e(b5, e2, companion2.d());
                w2 w2Var = w2.b;
                startRestartGroup.startReplaceGroup(-1935948073);
                int i3 = 0;
                for (Object obj : list) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (i3 < 4) {
                        s0.D(i3, list.get(i3), ((i) Q0.getValue()).a.a, N0, startRestartGroup, 0);
                    }
                    i3 = i4;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                a3.a(SizeKt.i(Modifier.Companion, x0.i.g(f2)), startRestartGroup, 6);
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
        t3 endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.a(new Function2() { // from class: com.dragon.read.leftslidepage.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit N;
                    N = VideoFeedTabLeftSlidePageKt.N(i, (Composer) obj2, ((Integer) obj3).intValue());
                    return N;
                }
            });
        }
    }

    private static final void T(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        long w;
        Composer startRestartGroup = composer.startRestartGroup(1959763456);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1959763456, i, -1, "com.dragon.read.leftslidepage.MsgArea (VideoFeedTabLeftSlidePage.kt:198)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final e2 e2Var = (e2) f2.d.c(Reflection.getOrCreateKotlinClass(e2.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final int N0 = e2Var.N0(ReportType.Msg);
                final MutableState<j> R0 = e2Var.R0();
                Modifier.a aVar = Modifier.Companion;
                Modifier B = SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null);
                if (com.dragon.read.kmp.service.d1.d((Theme) startRestartGroup.consume(rg4.e.l()))) {
                    startRestartGroup.startReplaceGroup(2137017322);
                    w = og4.a.a.h(startRestartGroup, og4.a.b).D();
                } else {
                    startRestartGroup.startReplaceGroup(2137018504);
                    w = og4.a.a.h(startRestartGroup, og4.a.b).w();
                }
                startRestartGroup.endReplaceGroup();
                float f = 12;
                Modifier c2 = BackgroundKt.c(B, w, k.g.c(x0.i.g(f)));
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance = startRestartGroup.changedInstance(e2Var) | startRestartGroup.changed(R0) | startRestartGroup.changed(N0);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.leftslidepage.n1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit U;
                            U = VideoFeedTabLeftSlidePageKt.U(e2.this, R0, N0);
                            return U;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(c2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 48);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
                float f2 = 16;
                a3.a(SizeKt.i(aVar, x0.i.g(f2)), startRestartGroup, 6);
                String str = ((j) R0.getValue()).a.a;
                String str2 = ((j) R0.getValue()).a.b;
                boolean z2 = ((j) R0.getValue()).a.c;
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance2 = startRestartGroup.changedInstance(e2Var) | startRestartGroup.changed(R0) | startRestartGroup.changed(N0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.leftslidepage.o1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit V;
                            V = VideoFeedTabLeftSlidePageKt.V(e2.this, R0, N0);
                            return V;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                s0.u(str, str2, null, z2, (Function0) rememberedValue2, startRestartGroup, 0, 4);
                a3.a(SizeKt.i(aVar, x0.i.g(f)), startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-1276263486);
                int i2 = 0;
                for (Object obj : ((j) R0.getValue()).b) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    t tVar = (t) obj;
                    startRestartGroup.startReplaceGroup(-1276262225);
                    if (i2 != 0) {
                        a3.a(SizeKt.i(Modifier.Companion, x0.i.g(f)), startRestartGroup, 6);
                    }
                    startRestartGroup.endReplaceGroup();
                    s0.K(i2, tVar, startRestartGroup, 0);
                    i2 = i3;
                }
                startRestartGroup.endReplaceGroup();
                a3.a(SizeKt.i(Modifier.Companion, x0.i.g(f2)), startRestartGroup, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.q1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit W;
                    W = VideoFeedTabLeftSlidePageKt.W(i, (Composer) obj2, ((Integer) obj3).intValue());
                    return W;
                }
            });
        }
    }

    private static final void a0(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        long w;
        Composer startRestartGroup = composer.startRestartGroup(2052523635);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052523635, i, -1, "com.dragon.read.leftslidepage.RecentWatchArea (VideoFeedTabLeftSlidePage.kt:244)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                e2 e2Var = (e2) f2.d.c(Reflection.getOrCreateKotlinClass(e2.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                int N0 = e2Var.N0(ReportType.RecentWatch);
                MutableState<l> S0 = e2Var.S0();
                Modifier.a aVar = Modifier.Companion;
                Modifier B = SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null);
                if (com.dragon.read.kmp.service.d1.d((Theme) startRestartGroup.consume(rg4.e.l()))) {
                    startRestartGroup.startReplaceGroup(1085237149);
                    w = og4.a.a.h(startRestartGroup, og4.a.b).D();
                } else {
                    startRestartGroup.startReplaceGroup(1085238331);
                    w = og4.a.a.h(startRestartGroup, og4.a.b).w();
                }
                startRestartGroup.endReplaceGroup();
                float f = 12;
                Modifier c2 = BackgroundKt.c(B, w, k.g.c(x0.i.g(f)));
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.leftslidepage.d1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit b0;
                            b0 = VideoFeedTabLeftSlidePageKt.b0((androidx.compose.ui.layout.w) obj);
                            return b0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a2 = androidx.compose.ui.layout.d1.a(c2, (Function1) rememberedValue);
                androidx.compose.ui.layout.p0 a3 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 48);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, a2);
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
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, a3, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                    b2.updateRememberedValue(Integer.valueOf(a4));
                    b2.apply(Integer.valueOf(a4), b3);
                }
                g5.e(b2, e, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                float f2 = 16;
                a3.a(SizeKt.i(aVar, x0.i.g(f2)), startRestartGroup, 6);
                String str = ((l) S0.getValue()).a.a;
                boolean z2 = ((l) S0.getValue()).a.c;
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.leftslidepage.f1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c0;
                            c0 = VideoFeedTabLeftSlidePageKt.c0();
                            return c0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                s0.u(str, "", null, z2, (Function0) rememberedValue2, startRestartGroup, 24624, 4);
                a3.a(SizeKt.i(aVar, x0.i.g(f)), startRestartGroup, 6);
                if (((l) S0.getValue()).c) {
                    startRestartGroup.startReplaceGroup(-1132667673);
                    O(((l) S0.getValue()).b, ((l) S0.getValue()).a.a, N0, startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1132511433);
                    int i2 = 0;
                    for (Object obj : ((l) S0.getValue()).b) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        k kVar = (k) obj;
                        startRestartGroup.startReplaceGroup(2041680394);
                        if (i2 != 0) {
                            a3.a(SizeKt.i(Modifier.Companion, x0.i.g(f)), startRestartGroup, 6);
                        }
                        startRestartGroup.endReplaceGroup();
                        s0.N(i2, kVar, ((l) S0.getValue()).a.a, N0, startRestartGroup, 0);
                        i2 = i3;
                    }
                    startRestartGroup.endReplaceGroup();
                }
                a3.a(SizeKt.i(Modifier.Companion, x0.i.g(f2)), startRestartGroup, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit d0;
                    d0 = VideoFeedTabLeftSlidePageKt.d0(i, (Composer) obj2, ((Integer) obj3).intValue());
                    return d0;
                }
            });
        }
    }

    private static final void m0(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-699227928);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-699227928, i, -1, "com.dragon.read.leftslidepage.ScrollArea (VideoFeedTabLeftSlidePage.kt:122)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final e2 e2Var = (e2) f2.d.c(Reflection.getOrCreateKotlinClass(e2.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                v2 d = k2.d(0, startRestartGroup, 0, 1);
                Object value = e2Var.f.getValue();
                startRestartGroup.startReplaceGroup(5004770);
                boolean changed = startRestartGroup.changed(d);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new VideoFeedTabLeftSlidePageKt$ScrollArea$1$1(d, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(value, (Function2) rememberedValue, startRestartGroup, 0);
                Modifier.a aVar = Modifier.Companion;
                float f = 12;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(k2.i(aVar, d, false, (androidx.compose.foundation.gestures.l1) null, false, 14, (Object) null), 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
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
                e2Var.M0();
                startRestartGroup.startReplaceGroup(586265277);
                if (!((j) e2Var.R0().getValue()).b.isEmpty()) {
                    e2Var.L0(ReportType.Msg);
                    T(startRestartGroup, 0);
                    a3.a(SizeKt.i(aVar, x0.i.g(8)), startRestartGroup, 6);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(586272093);
                if (!((l) e2Var.S0().getValue()).b.isEmpty()) {
                    e2Var.L0(ReportType.RecentWatch);
                    a0(startRestartGroup, 0);
                    a3.a(SizeKt.i(aVar, x0.i.g(8)), startRestartGroup, 6);
                }
                startRestartGroup.endReplaceGroup();
                final w wVar = (w) e2Var.T0().getValue();
                startRestartGroup.startReplaceGroup(586282053);
                if (wVar == null) {
                    i2 = -1633490746;
                } else {
                    final k kVar = wVar.c;
                    startRestartGroup.startReplaceGroup(586283562);
                    if (wVar.e && kVar != null) {
                        String str = wVar.a;
                        if (str == null) {
                            str = "";
                        }
                        e2Var.o1(false, 0, kVar, str);
                        ReportType reportType = ReportType.Subscribe;
                        e2Var.L0(reportType);
                        startRestartGroup.startReplaceGroup(-1633490746);
                        boolean changedInstance = startRestartGroup.changedInstance(e2Var) | startRestartGroup.changedInstance(wVar);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: com.dragon.read.leftslidepage.w1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit n0;
                                    n0 = VideoFeedTabLeftSlidePageKt.n0(e2.this, wVar);
                                    return n0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        Function0 function0 = (Function0) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1746271574);
                        boolean changedInstance2 = startRestartGroup.changedInstance(e2Var) | startRestartGroup.changedInstance(wVar) | startRestartGroup.changed(kVar);
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new Function0() { // from class: com.dragon.read.leftslidepage.x1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit o0;
                                    o0 = VideoFeedTabLeftSlidePageKt.o0(e2.this, wVar, kVar);
                                    return o0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceGroup();
                        i2 = -1633490746;
                        s0(wVar, reportType, true, function0, (Function0) rememberedValue3, startRestartGroup, 432, 0);
                        a3.a(SizeKt.i(aVar, x0.i.g(8)), startRestartGroup, 6);
                    } else {
                        i2 = -1633490746;
                    }
                    startRestartGroup.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
                final com.dragon.read.leftslidepage.b bVar = (com.dragon.read.leftslidepage.b) e2Var.O0().getValue();
                startRestartGroup.startReplaceGroup(586316874);
                if (bVar != null) {
                    final k kVar2 = bVar.c;
                    startRestartGroup.startReplaceGroup(586318383);
                    if (bVar.e && kVar2 != null) {
                        String str2 = bVar.a;
                        if (str2 == null) {
                            str2 = "";
                        }
                        e2Var.o1(false, 0, kVar2, str2);
                        ReportType reportType2 = ReportType.Follow;
                        e2Var.L0(reportType2);
                        startRestartGroup.startReplaceGroup(i2);
                        boolean changedInstance3 = startRestartGroup.changedInstance(e2Var) | startRestartGroup.changedInstance(bVar);
                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                        if (changedInstance3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = new Function0() { // from class: com.dragon.read.leftslidepage.y1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit p0;
                                    p0 = VideoFeedTabLeftSlidePageKt.p0(e2.this, bVar);
                                    return p0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        Function0 function02 = (Function0) rememberedValue4;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1746271574);
                        boolean changedInstance4 = startRestartGroup.changedInstance(e2Var) | startRestartGroup.changedInstance(bVar) | startRestartGroup.changed(kVar2);
                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                        if (changedInstance4 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new Function0() { // from class: com.dragon.read.leftslidepage.z1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit q0;
                                    q0 = VideoFeedTabLeftSlidePageKt.q0(e2.this, bVar, kVar2);
                                    return q0;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                        }
                        startRestartGroup.endReplaceGroup();
                        s0(bVar, reportType2, true, function02, (Function0) rememberedValue5, startRestartGroup, 432, 0);
                        a3.a(SizeKt.i(aVar, x0.i.g(8)), startRestartGroup, 6);
                    }
                    startRestartGroup.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(586346881);
                if (!((i) e2Var.Q0().getValue()).b.isEmpty()) {
                    e2Var.L0(ReportType.Game);
                    H(startRestartGroup, 0);
                    a3.a(SizeKt.i(aVar, x0.i.g(8)), startRestartGroup, 6);
                }
                startRestartGroup.endReplaceGroup();
                e2Var.L0(ReportType.Func);
                X(startRestartGroup, 0);
                a3.a(SizeKt.i(aVar, x0.i.g(20)), startRestartGroup, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.u0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r0;
                    r0 = VideoFeedTabLeftSlidePageKt.r0(i, (Composer) obj, ((Integer) obj2).intValue());
                    return r0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(e2 e2Var, MutableState mutableState, int i) {
        e2.m1(e2Var, true, ((i) mutableState.getValue()).a.a, i, null, 8, null);
        e2Var.h1(true);
        e2Var.b1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(e2 e2Var, MutableState mutableState, int i) {
        e2.m1(e2Var, true, ((i) mutableState.getValue()).a.a, i, null, 8, null);
        e2Var.h1(true);
        e2Var.b1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(e2 e2Var, MutableState mutableState, int i) {
        e2.m1(e2Var, true, ((j) mutableState.getValue()).a.a, i, null, 8, null);
        e2Var.c1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(e2 e2Var, MutableState mutableState, int i) {
        e2.m1(e2Var, true, ((j) mutableState.getValue()).a.a, i, null, 8, null);
        e2Var.c1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(e2 e2Var, w wVar, k kVar) {
        String str = wVar.a;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = wVar.b;
        if (str3 == null) {
            str3 = "";
        }
        e2Var.l1(true, str, 0, str3);
        String str4 = wVar.a;
        if (str4 != null) {
            str2 = str4;
        }
        e2Var.o1(true, 0, kVar, str2);
        e2Var.e1(wVar, wVar.a, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(e2 e2Var, com.dragon.read.leftslidepage.b bVar, k kVar) {
        String str = bVar.a;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = bVar.b;
        if (str3 == null) {
            str3 = "";
        }
        e2Var.l1(true, str, 0, str3);
        String str4 = bVar.a;
        if (str4 != null) {
            str2 = str4;
        }
        e2Var.o1(true, 0, kVar, str2);
        e2Var.e1(bVar, bVar.a, 0);
        return Unit.INSTANCE;
    }

    private static final void e0(final SidebarDataManager sidebarDataManager, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-481186493);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(sidebarDataManager)) {
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
                ComposerKt.traceEventStart(-481186493, i2, -1, "com.dragon.read.leftslidepage.RefreshOnResumeEffect (VideoFeedTabLeftSlidePage.kt:100)");
            }
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(0L, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changedInstance = startRestartGroup.changedInstance(sidebarDataManager) | startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: com.dragon.read.leftslidepage.p1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult g0;
                        g0 = VideoFeedTabLeftSlidePageKt.g0(lifecycleOwner, sidebarDataManager, mutableState, mutableState2, (DisposableEffectScope) obj);
                        return g0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.t1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i0;
                    i0 = VideoFeedTabLeftSlidePageKt.i0(SidebarDataManager.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return i0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult g0(LifecycleOwner lifecycleOwner, final SidebarDataManager sidebarDataManager, final MutableState mutableState, final MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.dragon.read.leftslidepage.v1
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                VideoFeedTabLeftSlidePageKt.h0(SidebarDataManager.this, mutableState, mutableState2, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new a(lifecycleOwner, lifecycleEventObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(SidebarDataManager sidebarDataManager, MutableState mutableState, MutableState mutableState2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_RESUME) {
            return;
        }
        if (!j0(mutableState)) {
            k0(mutableState, true);
            return;
        }
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        if (epochMilliseconds - l0(mutableState2) < 300) {
            return;
        }
        f0(mutableState2, epochMilliseconds);
        sidebarDataManager.D(true, true);
    }

    private static final void O(final List<k> list, final String str, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        long w;
        e.f h;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1116966877);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        int i7 = i3;
        if ((i7 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i7 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1116966877, i7, -1, "com.dragon.read.leftslidepage.GridRecentWatchItemList (VideoFeedTabLeftSlidePage.kt:227)");
            }
            if (list.size() > 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            float f = 12;
            Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.B(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
            if (com.dragon.read.kmp.service.d1.d((Theme) startRestartGroup.consume(rg4.e.l()))) {
                startRestartGroup.startReplaceGroup(-336642809);
                w = og4.a.a.h(startRestartGroup, og4.a.b).D();
            } else {
                startRestartGroup.startReplaceGroup(-336641627);
                w = og4.a.a.h(startRestartGroup, og4.a.b).w();
            }
            startRestartGroup.endReplaceGroup();
            Modifier c = BackgroundKt.c(t, w, k.g.c(x0.i.g(f)));
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.leftslidepage.r1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit P;
                        P = VideoFeedTabLeftSlidePageKt.P((androidx.compose.ui.layout.w) obj);
                        return P;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a2 = androidx.compose.ui.layout.d1.a(c, (Function1) rememberedValue);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            if (z2) {
                h = eVar.f();
            } else {
                h = eVar.h();
            }
            androidx.compose.ui.layout.p0 b2 = r2.b(h, androidx.compose.ui.e.a.l(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a2);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                b3.updateRememberedValue(Integer.valueOf(a3));
                b3.apply(Integer.valueOf(a3), b4);
            }
            g5.e(b3, e, companion.d());
            w2 w2Var = w2.b;
            startRestartGroup.startReplaceGroup(-878374047);
            int i8 = 0;
            for (Object obj : list) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                k kVar = (k) obj;
                startRestartGroup.startReplaceGroup(-878372827);
                if (!z2 && i8 != 0) {
                    a3.a(SizeKt.x(Modifier.Companion, x0.i.g(f)), startRestartGroup, 6);
                }
                startRestartGroup.endReplaceGroup();
                int i10 = i7 << 3;
                s0.H(i8, kVar, str, i, startRestartGroup, (i10 & 896) | (i10 & 7168));
                i8 = i9;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.leftslidepage.s1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit Q;
                    Q = VideoFeedTabLeftSlidePageKt.Q(list, str, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    return Q;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void z0(final com.dragon.read.leftslidepage.s r16, final com.dragon.read.leftslidepage.d r17, com.dragon.read.leftslidepage.SidebarDataManager r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.VideoFeedTabLeftSlidePageKt.z0(com.dragon.read.leftslidepage.s, com.dragon.read.leftslidepage.d, com.dragon.read.leftslidepage.SidebarDataManager, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void s0(final com.dragon.read.leftslidepage.g2 r45, final com.dragon.read.leftslidepage.ReportType r46, final boolean r47, kotlin.jvm.functions.Function0<kotlin.Unit> r48, kotlin.jvm.functions.Function0<kotlin.Unit> r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 1640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.VideoFeedTabLeftSlidePageKt.s0(com.dragon.read.leftslidepage.g2, com.dragon.read.leftslidepage.ReportType, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
