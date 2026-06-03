package com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.d0;
import androidx.compose.animation.core.s2;
import androidx.compose.animation.q;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.n0;
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
import com.dragon.read.kmp.compose.common.LottiePlayer;
import com.dragon.read.kmp.compose.common.a;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.l;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import w0.s;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    static {
        Covode.recordClassIndex(609231);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(int i, Composer composer, int i2) {
        f(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
        final /* synthetic */ KmpNextStoryBottomGuideHelper a;
        final /* synthetic */ State<String> b;

        a(KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper, State<String> state) {
            this.a = kmpNextStoryBottomGuideHelper;
            this.b = state;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper) {
            kmpNextStoryBottomGuideHelper.L();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
            b(eVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1014741085, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.StoryBottomContainer.<anonymous>.<anonymous>.<anonymous> (StoryBottomContainer.kt:95)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 16;
            Modifier d = BackgroundKt.d(androidx.compose.ui.draw.e.a(f2.t(SizeKt.i(SizeKt.F(aVar, (e.b) null, false, 3, (Object) null), x0.i.g(44)), x0.i.g(f), 0.0f, 2, (Object) null), k.g.c(x0.i.g(22))), n0.d(3424789026L), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            composer.startReplaceGroup(5004770);
            boolean changedInstance = composer.changedInstance(this.a);
            final KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper = this.a;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit c;
                        c = l.a.c(KmpNextStoryBottomGuideHelper.this);
                        return c;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            e.c i2 = androidx.compose.ui.e.a.i();
            State<String> state = this.b;
            p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), i2, composer, 48);
            int a = j.a(androidx.compose.runtime.i.b(composer, 0));
            e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(composer, modifier);
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
            Composer b2 = g5.b(composer);
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                b2.updateRememberedValue(Integer.valueOf(a));
                b2.apply(Integer.valueOf(a), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            a3.a(SizeKt.x(aVar, x0.i.g(f)), composer, 6);
            float f2 = 20;
            com.dragon.read.kmp.compose.common.b.v(new LottiePlayer(new a.c("bottom_scroll_guide_tips.json"), LottiePlayer.Status.Playing, LottiePlayer.a.a.a, (LottiePlayer.PlayMode) null, 0.0f, (String) null, (String) null, 120, (DefaultConstructorMarker) null), SizeKt.u(aVar, x0.i.g(f2), x0.i.g(f2)), (Theme) null, l0.j(n0.d(4294967295L)), composer, 3120, 4);
            float f3 = 4;
            a6.j(l.k(state), f2.v(f2.v(aVar, x0.i.g(f3), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, 0.0f, x0.i.g(f), 0.0f, 11, (Object) null), n0.d(4294967295L), x.h(14), (y) null, c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, s.b.b(), false, 1, 0, (Function1) null, (g3) null, composer, 200112, 3120, 120784);
            composer.endNode();
            a3.a(SizeKt.i(aVar, x0.i.g(f3)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String k(State<String> state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper) {
        return ((Boolean) kmpNextStoryBottomGuideHelper.b.getValue()).booleanValue();
    }

    private static final boolean i(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper) {
        return (String) kmpNextStoryBottomGuideHelper.c.getValue();
    }

    public static final void f(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(168862199);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(168862199, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.StoryBottomContainer (StoryBottomContainer.kt:45)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new KmpNextStoryBottomGuideHelper(kmpStoryFeedsVM);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper = (KmpNextStoryBottomGuideHelper) rememberedValue;
                startRestartGroup.endReplaceGroup();
                kmpNextStoryBottomGuideHelper.l(startRestartGroup, 0);
                kmpNextStoryBottomGuideHelper.e(startRestartGroup, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i2 = m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
                Composer b = g5.b(startRestartGroup);
                g5.e(b, i2, companion2.c());
                g5.e(b, currentCompositionLocalMap, companion2.e());
                Function2 b2 = companion2.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion2.d());
                Modifier b3 = BoxScopeInstance.a.b(SizeKt.h(aVar, 0.0f, 1, (Object) null), aVar2.b());
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                p0 a4 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, b3);
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
                g5.e(b4, e2, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                p0 a7 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.j(), startRestartGroup, 48);
                int a8 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, h);
                Function0 a9 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a9);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b6 = g5.b(startRestartGroup);
                g5.e(b6, a7, companion2.c());
                g5.e(b6, currentCompositionLocalMap3, companion2.e());
                Function2 b7 = companion2.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a8))) {
                    b6.updateRememberedValue(Integer.valueOf(a8));
                    b6.apply(Integer.valueOf(a8), b7);
                }
                g5.e(b6, e3, companion2.d());
                ContainerBoxViewWrapperKt.e(f2.v(c0Var.b(aVar, aVar2.j()), 0.0f, 0.0f, 0.0f, x0.i.g(20), 7, (Object) null), startRestartGroup, 0, 0);
                startRestartGroup.endNode();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            boolean h2;
                            h2 = l.h(KmpNextStoryBottomGuideHelper.this);
                            return Boolean.valueOf(h2);
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                State state = (State) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            String j;
                            j = l.j(KmpNextStoryBottomGuideHelper.this);
                            return j;
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                State state2 = (State) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                Modifier b8 = c0Var.b(SizeKt.h(aVar, 0.0f, 1, (Object) null), aVar2.g());
                boolean i3 = i(state);
                s2 n = androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int l;
                            l = l.l(((Integer) obj).intValue());
                            return Integer.valueOf(l);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                q c2 = EnterExitTransitionKt.D(n, (Function1) rememberedValue4).c(EnterExitTransitionKt.o(androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null)).c(EnterExitTransitionKt.m(androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null), (e.c) null, false, (Function1) null, 10, (Object) null));
                s2 n2 = androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int g;
                            g = l.g(((Integer) obj).intValue());
                            return Integer.valueOf(g);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                AnimatedVisibilityKt.g(c0Var, i3, b8, c2, EnterExitTransitionKt.H(n2, (Function1) rememberedValue5).c(EnterExitTransitionKt.q(androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null)).c(EnterExitTransitionKt.A(androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null), (e.c) null, false, (Function1) null, 10, (Object) null)), (String) null, t.e(-1014741085, true, new a(kmpNextStoryBottomGuideHelper, state2), startRestartGroup, 54), startRestartGroup, 1572870, 16);
                a3.a(SizeKt.i(aVar, x0.i.g(24)), startRestartGroup, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = l.m(i, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }
}
