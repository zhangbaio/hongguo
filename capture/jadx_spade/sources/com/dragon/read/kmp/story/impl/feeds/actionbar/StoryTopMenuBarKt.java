package com.dragon.read.kmp.story.impl.feeds.actionbar;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.d0;
import androidx.compose.animation.core.m0;
import androidx.compose.animation.core.s2;
import androidx.compose.animation.q;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.v2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.LazyListState;
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
import androidx.compose.ui.graphics.e1;
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
import com.dragon.read.kmp.utils.v0;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import x0.x;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryTopMenuBarKt {
    static {
        Covode.recordClassIndex(609228);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(kp4.b bVar, int i, Composer composer, int i2) {
        z(bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(v2 v2Var, int i, Composer composer, int i2) {
        k(v2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(int i) {
        return -i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(int i) {
        return -i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(int i, Composer composer, int i2) {
        q(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A() {
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b r() {
        return new tp4.b("StoryTopMenuBar");
    }

    private static final Function0<Unit> B(MutableState<Function0<Unit>> mutableState) {
        return (Function0) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp4.b l(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    private static final com.dragon.read.kmp.story.impl.feeds.container.n v(State<com.dragon.read.kmp.story.impl.feeds.container.n> state) {
        return (com.dragon.read.kmp.story.impl.feeds.container.n) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp4.b w(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(LazyListState lazyListState) {
        return lazyListState.b();
    }

    private static final boolean m(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(kp4.b bVar, KmpStoryFeedsVM kmpStoryFeedsVM) {
        lp4.a aVar = bVar.f.b;
        if (aVar != null) {
            aVar.a(kmpStoryFeedsVM);
        }
        return Unit.INSTANCE;
    }

    public static final void q(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        com.dragon.read.kmp.story.impl.feeds.data.d dVar;
        Composer startRestartGroup = composer.startRestartGroup(1961540579);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1961540579, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuBar (StoryTopMenuBar.kt:57)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        tp4.b r;
                        r = StoryTopMenuBarKt.r();
                        return r;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LazyKt__LazyJVMKt.lazy((Function0) rememberedValue);
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final LazyListState lazyListState = kmpStoryFeedsVM.b;
                State collectAsState = SnapshotStateKt.collectAsState(kmpStoryFeedsVM.j, (CoroutineContext) null, startRestartGroup, 0, 1);
                State collectAsState2 = SnapshotStateKt.collectAsState(kmpStoryFeedsVM.l, (CoroutineContext) null, startRestartGroup, 0, 1);
                kp4.b w = w(collectAsState2);
                if (w != null && (dVar = w.e) != null && dVar.c()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z4 = v(collectAsState).g;
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            boolean x;
                            x = StoryTopMenuBarKt.x(lazyListState);
                            return Boolean.valueOf(x);
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                State state = (State) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Boolean valueOf = Boolean.valueOf(y(state));
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changed = startRestartGroup.changed(z2) | startRestartGroup.changed(z4) | startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed && rememberedValue3 != companion.getEmpty()) {
                    z3 = z4;
                } else {
                    z3 = z4;
                    StoryTopMenuBarKt$StoryTopMenuBar$1$1 storyTopMenuBarKt$StoryTopMenuBar$1$1 = new StoryTopMenuBarKt$StoryTopMenuBar$1$1(z2, z4, kmpStoryFeedsVM, state, null);
                    startRestartGroup.updateRememberedValue(storyTopMenuBarKt$StoryTopMenuBar$1$1);
                    rememberedValue3 = storyTopMenuBarKt$StoryTopMenuBar$1$1;
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue3, startRestartGroup, 0);
                s2 n = androidx.compose.animation.core.j.n(300, 0, m0.c(), 2, (Object) null);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int s;
                            s = StoryTopMenuBarKt.s(((Integer) obj).intValue());
                            return Integer.valueOf(s);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                q c2 = EnterExitTransitionKt.D(n, (Function1) rememberedValue4).c(EnterExitTransitionKt.o(androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null));
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int t;
                            t = StoryTopMenuBarKt.t(((Integer) obj).intValue());
                            return Integer.valueOf(t);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                AnimatedVisibilityKt.j(z3, (Modifier) null, c2, EnterExitTransitionKt.H(n, (Function1) rememberedValue5).c(EnterExitTransitionKt.q(androidx.compose.animation.core.j.n(300, 0, (d0) null, 6, (Object) null), 0.0f, 2, (Object) null)), (String) null, t.e(34072587, true, new a(collectAsState2), startRestartGroup, 54), startRestartGroup, 196608, 18);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = StoryTopMenuBarKt.u(i, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
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
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(34072587, i, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuBar.<anonymous> (StoryTopMenuBar.kt:88)");
            }
            kp4.b w = StoryTopMenuBarKt.w(this.a);
            if (w != null) {
                StoryTopMenuBarKt.z(w, composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(CoroutineScope coroutineScope, MutableState mutableState, State state) {
        String str;
        com.dragon.read.kmp.story.impl.feeds.data.e d;
        if (m(mutableState)) {
            return Unit.INSTANCE;
        }
        kp4.b l = l(state);
        v0 v0Var = v0.a;
        if (l != null && (d = l.d()) != null) {
            str = d.getBookId();
        } else {
            str = null;
        }
        if (v0Var.a(str)) {
            return Unit.INSTANCE;
        }
        kotlinx.coroutines.i.e(coroutineScope, Dispatchers.getIO(), null, new StoryTopMenuBarKt$AddBookshelfButton$2$1$1(l, mutableState, null), 2, null);
        return Unit.INSTANCE;
    }

    private static final void k(final v2 v2Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        String str;
        float f;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1564369775);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(v2Var)) {
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
                ComposerKt.traceEventStart(-1564369775, i2, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.AddBookshelfButton (StoryTopMenuBar.kt:140)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
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
                final State collectAsState = SnapshotStateKt.collectAsState(((KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0)).k.g, (CoroutineContext) null, startRestartGroup, 0, 1);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                kp4.b l = l(collectAsState);
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changed = startRestartGroup.changed(collectAsState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new StoryTopMenuBarKt$AddBookshelfButton$1$1(collectAsState, mutableState, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(l, (Function2) rememberedValue3, startRestartGroup, 0);
                if (m(mutableState)) {
                    str = "已加书架";
                } else {
                    str = "加入书架";
                }
                long k = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(startRestartGroup, 6).k();
                long h = x.h(14);
                Modifier b = v2Var.b(Modifier.Companion, androidx.compose.ui.e.a.i());
                if (m(mutableState)) {
                    f = 0.5f;
                } else {
                    f = 1.0f;
                }
                Modifier a2 = androidx.compose.ui.draw.a.a(b, f);
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changed2 = startRestartGroup.changed(collectAsState) | startRestartGroup.changedInstance(coroutineScope);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit o;
                            o = StoryTopMenuBarKt.o(CoroutineScope.this, mutableState, collectAsState);
                            return o;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                a6.j(str, f2.t(ClickableKt.clickable-oSLSa3U$default(a2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null), k, h, (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131056);
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
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p;
                    p = StoryTopMenuBarKt.p(v2Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return p;
                }
            });
        }
    }

    public static final void z(final kp4.b currentStory, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        int i3;
        Intrinsics.checkNotNullParameter(currentStory, "currentStory");
        Composer startRestartGroup = composer.startRestartGroup(1646130622);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(currentStory)) {
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
                ComposerKt.traceEventStart(1646130622, i2, -1, "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuView (StoryTopMenuBar.kt:94)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit A;
                            A = StoryTopMenuBarKt.A();
                            return A;
                        }
                    }, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                Modifier.a aVar = Modifier.Companion;
                Modifier i4 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(54));
                com.dragon.read.kmp.story.impl.feeds.uicontext.c cVar = com.dragon.read.kmp.story.impl.feeds.uicontext.c.a;
                float f = 16;
                Modifier v = f2.v(BackgroundKt.d(i4, cVar.b(startRestartGroup, 6).z(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                g5.e(b, i5, companion2.c());
                g5.e(b, currentCompositionLocalMap, companion2.e());
                Function2 b2 = companion2.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                f2.a aVar3 = f2.a.a;
                e1 a4 = org.jetbrains.compose.resources.c.a(d2.N(aVar3), startRestartGroup, 0);
                float f2 = 24;
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(f2)), aVar2.h()), true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, B(mutableState), 14, (Object) null);
                m0.a aVar4 = androidx.compose.ui.graphics.m0.b;
                z0.g(a4, "返回", modifier, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar4, cVar.b(startRestartGroup, 6).k(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
                Modifier b3 = boxScopeInstance.b(aVar, aVar2.f());
                p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
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
                Composer b5 = g5.b(startRestartGroup);
                g5.e(b5, b4, companion2.c());
                g5.e(b5, currentCompositionLocalMap2, companion2.e());
                Function2 b6 = companion2.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                    b5.updateRememberedValue(Integer.valueOf(a5));
                    b5.apply(Integer.valueOf(a5), b6);
                }
                g5.e(b5, e2, companion2.d());
                k(w2.b, startRestartGroup, 6);
                e1 a7 = org.jetbrains.compose.resources.c.a(d2.i(aVar3), startRestartGroup, 0);
                Modifier s = SizeKt.s(aVar, x0.i.g(f2));
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(currentStory) | startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit C;
                            C = StoryTopMenuBarKt.C(kp4.b.this, kmpStoryFeedsVM);
                            return C;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                z0.g(a7, "菜单", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(aVar4, cVar.b(startRestartGroup, 6).k(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.actionbar.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit D;
                    D = StoryTopMenuBarKt.D(kp4.b.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return D;
                }
            });
        }
    }
}
