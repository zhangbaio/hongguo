package com.dragon.read.kmp.story.impl.feeds.actionbar;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.d0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sk5.p;
import w0.s;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryTopTitleBarKt {
    static {
        Covode.recordClassIndex(609229);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(int i, Composer composer, int i2) {
        e(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b f() {
        return new tp4.b("StoryTopTitleBar");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    private static final Function0<Unit> h(MutableState<Function0<Unit>> mutableState) {
        return (Function0) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b k(Lazy<tp4.b> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp4.b l(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    private static final boolean i(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(State state) {
        kp4.b l = l(state);
        if (l == null || !l.m() || l.e.f()) {
            return false;
        }
        return true;
    }

    public static final void e(Composer composer, final int i) {
        boolean z;
        Lazy lazy;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-55867809);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-55867809, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopTitleBar (StoryTopTitleBar.kt:43)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        tp4.b f;
                        f = StoryTopTitleBarKt.f();
                        return f;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            lazy = LazyKt__LazyJVMKt.lazy((Function0) rememberedValue);
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final State collectAsState = SnapshotStateKt.collectAsState(kmpStoryFeedsVM.l, (CoroutineContext) null, startRestartGroup, 0, 1);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            boolean m;
                            m = StoryTopTitleBarKt.m(collectAsState);
                            return Boolean.valueOf(m);
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                State state = (State) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Boolean valueOf = Boolean.valueOf(n(state));
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(lazy);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new StoryTopTitleBarKt$StoryTopTitleBar$1$1(lazy, state, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue3, startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit g;
                            g = StoryTopTitleBarKt.g();
                            return g;
                        }
                    }, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                MutableState mutableState = (MutableState) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator = kmpStoryFeedsVM.z;
                com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
                int a2 = cVar.a(startRestartGroup, 6);
                Integer valueOf2 = Integer.valueOf(a2);
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(kmpStoryPolarisTaskCoordinator) | startRestartGroup.changed(a2);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new StoryTopTitleBarKt$StoryTopTitleBar$2$1(kmpStoryPolarisTaskCoordinator, a2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf2, (Function2) rememberedValue5, startRestartGroup, 0);
                Modifier.a aVar = Modifier.Companion;
                float f = 16;
                Modifier v = f2.v(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(42)), cVar.b(startRestartGroup, 6).z(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                g5.e(b2, i2, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                    b2.updateRememberedValue(Integer.valueOf(a3));
                    b2.apply(Integer.valueOf(a3), b3);
                }
                g5.e(b2, e, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier b4 = boxScopeInstance.b(SizeKt.h(aVar, 0.0f, 1, (Object) null), aVar2.h());
                p0 b5 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, b4);
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
                Composer b6 = g5.b(startRestartGroup);
                g5.e(b6, b5, companion2.c());
                g5.e(b6, currentCompositionLocalMap2, companion2.e());
                Function2 b7 = companion2.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a5))) {
                    b6.updateRememberedValue(Integer.valueOf(a5));
                    b6.apply(Integer.valueOf(a5), b7);
                }
                g5.e(b6, e2, companion2.d());
                w2 w2Var = w2.b;
                z0.g(org.jetbrains.compose.resources.c.a(sk5.n.c(p.a), startRestartGroup, 0), "返回", ClickableKt.clickable-oSLSa3U$default(SizeKt.s(aVar, x0.i.g(f)), true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, h(mutableState), 14, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, cVar.b(startRestartGroup, 6).h(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
                AnimatedVisibilityKt.i(w2Var, n(state), u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), EnterExitTransitionKt.o(androidx.compose.animation.core.j.n(200, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.q(androidx.compose.animation.core.j.n(200, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, t.e(-1806597539, true, new a(collectAsState), startRestartGroup, 54), startRestartGroup, 1600518, 16);
                startRestartGroup.endNode();
                startRestartGroup.startReplaceGroup(1753686395);
                if (com.dragon.read.kmp.story.impl.feeds.polaris.a.a.a()) {
                    AnimatedVisibilityKt.j(i(SnapshotStateKt.collectAsState(kmpStoryPolarisTaskCoordinator.l(), (CoroutineContext) null, startRestartGroup, 0, 1)), boxScopeInstance.b(aVar, aVar2.f()), EnterExitTransitionKt.o(androidx.compose.animation.core.j.n(200, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.q(androidx.compose.animation.core.j.n(200, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, t.e(-88137338, true, new b(kmpStoryPolarisTaskCoordinator), startRestartGroup, 54), startRestartGroup, 200064, 16);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = StoryTopTitleBarKt.j(i, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }

    static final class a implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
        final /* synthetic */ State<kp4.b> a;

        a(State<kp4.b> state) {
            this.a = state;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
            a(eVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
            String str;
            com.dragon.read.kmp.story.impl.feeds.data.e d;
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1806597539, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopTitleBar.<anonymous>.<anonymous>.<anonymous> (StoryTopTitleBar.kt:100)");
            }
            kp4.b l = StoryTopTitleBarKt.l(this.a);
            if (l == null || (d = l.d()) == null || (str = d.d) == null) {
                str = "";
            }
            a6.j(str, SizeKt.h(f2.v(Modifier.Companion, x0.i.g(2), 0.0f, x0.i.g(80), 0.0f, 10, (Object) null), 0.0f, 1, (Object) null), com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(composer, 6).h(), x.h(14), (y) null, c0.b.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer, 199728, 3120, 120784);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    static final class b implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
        final /* synthetic */ KmpStoryPolarisTaskCoordinator a;

        b(KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator) {
            this.a = kmpStoryPolarisTaskCoordinator;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
            a(eVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-88137338, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopTitleBar.<anonymous>.<anonymous> (StoryTopTitleBar.kt:122)");
            }
            vh1.p pVar = this.a.d;
            if (pVar != null) {
                pVar.e((Function0) null, (Function0) null, composer, vh1.p.d << 6, 3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
