package com.dragon.read.kmp.story.impl.feeds;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.r;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.y0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.story.impl.feeds.KmpStoryFeedsPageKt;
import com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuBarKt;
import com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopTitleBarKt;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.dragon.read.kmp.story.impl.feeds.container.q;
import com.dragon.read.kmp.story.impl.feeds.container.s;
import com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt;
import com.dragon.read.kmp.story.impl.feeds.observer.StoryFlingLimiterObserverKt;
import com.dragon.read.kmp.story.impl.feeds.observer.StoryPageChangeObserverKt;
import com.dragon.read.kmp.story.impl.feeds.observer.StoryReadProgressObserverKt;
import com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt;
import com.dragon.read.kmp.story.impl.feeds.observer.StoryTitleBarStateObserverKt;
import com.dragon.read.kmp.story.impl.feeds.page.view.ContentEndAuthorPageViewKt;
import com.dragon.read.kmp.story.impl.feeds.page.view.w;
import com.dragon.read.kmp.story.impl.feeds.trace.StoryFeedsFpsTrackerKt;
import com.dragon.read.kmp.story.impl.feeds.trace.StoryFeedsRenderTrackerKt;
import com.dragon.read.kmp.story.impl.widget.LazyColumnScrollbarKt;
import ec4.m0;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import pg4.p;
import pg4.t;
import sp4.a;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryFeedsPageKt {
    static {
        Covode.recordClassIndex(609226);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(yo4.d dVar, int i, Composer composer, int i2) {
        i(dVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(int i, yo4.c cVar, int i2, Composer composer, int i3) {
        k(i, cVar, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(int i, yo4.c cVar, int i2, Composer composer, int i3) {
        k(i, cVar, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(int i, Composer composer, int i2) {
        n(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(int i, Composer composer, int i2) {
        s(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ yo4.d a;

        /* renamed from: com.dragon.read.kmp.story.impl.feeds.KmpStoryFeedsPageKt$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0067a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        a(yo4.d dVar) {
            this.a = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean j() {
            return true;
        }

        public static final class b implements DisposableEffectResult {
            final /* synthetic */ LifecycleOwner a;
            final /* synthetic */ LifecycleEventObserver b;
            final /* synthetic */ KmpStoryFeedsVM c;

            public void dispose() {
                this.a.getLifecycle().removeObserver(this.b);
                this.c.z1();
            }

            public b(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver, KmpStoryFeedsVM kmpStoryFeedsVM) {
                this.a = lifecycleOwner;
                this.b = lifecycleEventObserver;
                this.c = kmpStoryFeedsVM;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(KmpStoryFeedsVM kmpStoryFeedsVM) {
            kmpStoryFeedsVM.x1();
            return Unit.INSTANCE;
        }

        private static final Function0<Unit> i(MutableState<Function0<Unit>> mutableState) {
            return (Function0) mutableState.getValue();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            e(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void e(Composer composer, int i) {
            boolean z;
            CreationExtras creationExtras;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1489032786, i, -1, "com.dragon.read.kmp.story.impl.feeds.KmpStoryFeedsPage.<anonymous> (KmpStoryFeedsPage.kt:84)");
                }
                LazyListState c = y0.c(0, 0, composer, 0, 3);
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                    composer.updateRememberedValue(rememberedValue);
                }
                com.dragon.read.kmp.story.impl.feeds.container.h hVar = new com.dragon.read.kmp.story.impl.feeds.container.h(this.a, c, ((x0.e) composer.consume(CompositionLocalsKt.f())).getDensity(), (CoroutineScope) rememberedValue);
                HasDefaultViewModelProviderFactory c2 = f2.b.a.c(composer, 6);
                if (c2 != null) {
                    if (c2 instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = c2.getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.b.a;
                    }
                    final KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c2, (String) null, hVar, creationExtras, composer, 0, 0);
                    final LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                    Unit unit = Unit.INSTANCE;
                    composer.startReplaceGroup(-1633490746);
                    boolean changedInstance = composer.changedInstance(kmpStoryFeedsVM) | composer.changedInstance(lifecycleOwner);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                DisposableEffectResult f;
                                f = KmpStoryFeedsPageKt.a.f(KmpStoryFeedsVM.this, lifecycleOwner, (DisposableEffectScope) obj);
                                return f;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, composer, 6);
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.k
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit h;
                                h = KmpStoryFeedsPageKt.a.h(KmpStoryFeedsVM.this);
                                return h;
                            }
                        }, (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    MutableState mutableState = (MutableState) rememberedValue3;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue4 = composer.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                boolean j;
                                j = KmpStoryFeedsPageKt.a.j();
                                return Boolean.valueOf(j);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue4);
                    }
                    composer.endReplaceGroup();
                    ig4.e.e((Function0) rememberedValue4, i(mutableState), composer, 6);
                    p.e(new pg4.h((t) null, (t) null, (List) null, 7, (DefaultConstructorMarker) null), com.dragon.read.kmp.story.impl.feeds.a.a.a(), composer, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DisposableEffectResult f(final KmpStoryFeedsVM kmpStoryFeedsVM, LifecycleOwner lifecycleOwner, DisposableEffectScope DisposableEffect) {
            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.dragon.read.kmp.story.impl.feeds.m
                public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                    KmpStoryFeedsPageKt.a.g(KmpStoryFeedsVM.this, lifecycleOwner2, event);
                }
            };
            kmpStoryFeedsVM.y1();
            lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
            return new b(lifecycleOwner, lifecycleEventObserver, kmpStoryFeedsVM);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(KmpStoryFeedsVM kmpStoryFeedsVM, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
            Intrinsics.checkNotNullParameter(event, "event");
            int i = C0067a.a[event.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    kmpStoryFeedsVM.C1();
                    return;
                }
                return;
            }
            kmpStoryFeedsVM.E1();
        }
    }

    static final class b implements Function3<FootLoadingState, Composer, Integer, Unit> {
        final /* synthetic */ KmpStoryFeedsVM a;

        b(KmpStoryFeedsVM kmpStoryFeedsVM) {
            this.a = kmpStoryFeedsVM;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(KmpStoryFeedsVM kmpStoryFeedsVM) {
            kmpStoryFeedsVM.w1();
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
                    ComposerKt.traceEventStart(663537914, i, -1, "com.dragon.read.kmp.story.impl.feeds.StoryFeeds.<anonymous>.<anonymous> (KmpStoryFeedsPage.kt:226)");
                }
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(this.a);
                final KmpStoryFeedsVM kmpStoryFeedsVM = this.a;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.n
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = KmpStoryFeedsPageKt.b.c(KmpStoryFeedsVM.this);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                StoryLazyColumnKt.e(state, (Function0) rememberedValue, null, null, composer, i & 14, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    private static final s q(State<s> state) {
        return (s) state.getValue();
    }

    private static final kp4.b r(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    private static final com.dragon.read.kmp.story.impl.feeds.container.n t(State<com.dragon.read.kmp.story.impl.feeds.container.n> state) {
        return (com.dragon.read.kmp.story.impl.feeds.container.n) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(KmpStoryFeedsVM kmpStoryFeedsVM) {
        kmpStoryFeedsVM.x1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(KmpStoryFeedsVM kmpStoryFeedsVM, String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        kmpStoryFeedsVM.r1(a.b.a);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(KmpStoryFeedsVM kmpStoryFeedsVM, String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        kmpStoryFeedsVM.r1(a.C0266a.a);
        return Unit.INSTANCE;
    }

    public static final void s(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-1117869492);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1117869492, i, -1, "com.dragon.read.kmp.story.impl.feeds.StoryFeedsWrapper (KmpStoryFeedsPage.kt:137)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                State collectAsState = SnapshotStateKt.collectAsState(kmpStoryFeedsVM.j, (CoroutineContext) null, startRestartGroup, 0, 1);
                Modifier d = BackgroundKt.d(Modifier.Companion, com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(startRestartGroup, 6).z(), (f2) null, 2, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit u;
                            u = KmpStoryFeedsPageKt.u(KmpStoryFeedsVM.this, (String) obj);
                            return u;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier h = StoryFeedsRenderTrackerKt.h(d, "kmp_story_feeds_page", (Function1) rememberedValue, startRestartGroup, 48);
                p0 i2 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
                g5.e(b2, i2, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                LoadStatus loadStatus = t(collectAsState).a;
                mg4.b bVar = t(collectAsState).c;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance2 = startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit v;
                            v = KmpStoryFeedsPageKt.v(KmpStoryFeedsVM.this);
                            return v;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                q.b(loadStatus, bVar, (Function0) rememberedValue2, com.dragon.read.kmp.story.impl.feeds.a.a.d(), startRestartGroup, 3072, 0);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w;
                    w = KmpStoryFeedsPageKt.w(i, (Composer) obj, ((Integer) obj2).intValue());
                    return w;
                }
            });
        }
    }

    public static final void n(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        androidx.compose.ui.input.nestedscroll.b bVar;
        r rVar;
        Composer composer3;
        Modifier modifier;
        float f;
        kp4.d dVar;
        Composer startRestartGroup = composer.startRestartGroup(-2137831037);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2137831037, i, -1, "com.dragon.read.kmp.story.impl.feeds.StoryFeeds (KmpStoryFeedsPage.kt:161)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                LazyListState lazyListState = kmpStoryFeedsVM.b;
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                State collectAsState = SnapshotStateKt.collectAsState(kmpStoryFeedsVM.n, (CoroutineContext) null, startRestartGroup, 0, 1);
                State collectAsState2 = SnapshotStateKt.collectAsState(kmpStoryFeedsVM.l, (CoroutineContext) null, startRestartGroup, 0, 1);
                boolean z2 = m0.Companion.a().a;
                startRestartGroup.startReplaceGroup(-1461246653);
                if (z2) {
                    bVar = StoryFlingLimiterObserverKt.j(lazyListState, kmpStoryFeedsVM.k, startRestartGroup, 0);
                } else {
                    bVar = null;
                }
                startRestartGroup.endReplaceGroup();
                tp4.b bVar2 = new tp4.b("KmpStoryFeedsPage");
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changed = startRestartGroup.changed(bVar2);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new KmpStoryFeedsPageKt$StoryFeeds$1$1(bVar2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue2, startRestartGroup, 6);
                StoryPageChangeObserverKt.e(lazyListState, kmpStoryFeedsVM.k, startRestartGroup, 0);
                StoryPageChangeObserverKt.k(lazyListState, kmpStoryFeedsVM.z, startRestartGroup, 0);
                StoryReadProgressObserverKt.b(lazyListState, kmpStoryFeedsVM.k, startRestartGroup, 0);
                StoryReadStatusObserverKt.b(lazyListState, kmpStoryFeedsVM.k, startRestartGroup, 0);
                StoryTitleBarStateObserverKt.c(lazyListState, kmpStoryFeedsVM.k, startRestartGroup, 0);
                StoryFeedsFpsTrackerKt.b(lazyListState, startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(kmpStoryFeedsVM);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit o;
                            o = KmpStoryFeedsPageKt.o(KmpStoryFeedsVM.this, (String) obj);
                            return o;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                StoryFeedsRenderTrackerKt.e("kmp_story_feeds_page", (Function1) rememberedValue3, startRestartGroup, 6);
                Modifier modifier2 = Modifier.Companion;
                Modifier a2 = WindowInsetsPadding_androidKt.a(SizeKt.f(modifier2, 0.0f, 1, (Object) null));
                e.a aVar = androidx.compose.ui.e.a;
                p0 i2 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
                int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, a2);
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
                r rVar2 = BoxScopeInstance.a;
                float g = x0.i.g(42);
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(modifier2, 0.0f, 1, (Object) null), 0.0f, g, 0.0f, 0.0f, 13, (Object) null);
                if (bVar != null) {
                    v = androidx.compose.ui.input.nestedscroll.c.b(v, bVar, (NestedScrollDispatcher) null, 2, (Object) null);
                }
                StoryLazyColumnKt.h(lazyListState, v, kmpStoryFeedsVM.k.e, 1, null, null, androidx.compose.runtime.internal.t.e(663537914, true, new b(kmpStoryFeedsVM), startRestartGroup, 54), com.dragon.read.kmp.story.impl.feeds.a.a.c(), startRestartGroup, 14158848, 48);
                StoryTopTitleBarKt.e(startRestartGroup, 0);
                StoryTopMenuBarKt.q(startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(2068171937);
                if (com.dragon.read.kmp.story.impl.feeds.config.b.a.b()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(q(collectAsState).c);
                    sb.append(" - ");
                    sb.append(q(collectAsState).b);
                    sb.append(" - ");
                    kp4.b r = r(collectAsState2);
                    if (r != null && (dVar = r.c) != null) {
                        f = dVar.c;
                    } else {
                        f = 0.0f;
                    }
                    sb.append(f);
                    modifier = modifier2;
                    rVar = rVar2;
                    composer3 = startRestartGroup;
                    a6.j(sb.toString(), androidx.compose.foundation.layout.f2.v(rVar2.b(modifier2, aVar.n()), 0.0f, x0.i.g(58), x0.i.g(16), 0.0f, 9, (Object) null), com.dragon.read.kmp.story.impl.feeds.uicontext.c.a.b(startRestartGroup, 6).f(), x.h(20), (y) null, c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer3, 199680, 0, 131024);
                } else {
                    rVar = rVar2;
                    composer3 = startRestartGroup;
                    modifier = modifier2;
                }
                composer3.endReplaceGroup();
                composer2 = composer3;
                com.dragon.read.kmp.story.impl.feeds.actionbar.bottomContainer.l.f(composer2, 0);
                LazyColumnScrollbarKt.i(lazyListState, androidx.compose.foundation.layout.f2.v(rVar.b(modifier, aVar.f()), 0.0f, g, x0.i.g(3), x0.i.g(24), 1, (Object) null), 0.0f, 0.0f, 0.0f, composer2, 0, 28);
                composer2.endNode();
                com.dragon.read.kmp.story.impl.feeds.guide.c.b(kmpStoryFeedsVM.y, composer2, 0);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p;
                    p = KmpStoryFeedsPageKt.p(i, (Composer) obj, ((Integer) obj2).intValue());
                    return p;
                }
            });
        }
    }

    public static final void i(final yo4.d launchParam, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        Composer startRestartGroup = composer.startRestartGroup(-1115037757);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(launchParam)) {
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
                ComposerKt.traceEventStart(-1115037757, i2, -1, "com.dragon.read.kmp.story.impl.feeds.KmpStoryFeedsPage (KmpStoryFeedsPage.kt:81)");
            }
            ym4.f.c("KmpStoryPage", launchParam, androidx.compose.runtime.internal.t.e(-1489032786, true, new a(launchParam), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = KmpStoryFeedsPageKt.j(yo4.d.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final int i, final yo4.c cVar, Composer composer, final int i2) {
        int i3;
        boolean z;
        CreationExtras creationExtras;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1743748185);
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
            if (startRestartGroup.changedInstance(cVar)) {
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
                ComposerKt.traceEventStart(-1743748185, i6, -1, "com.dragon.read.kmp.story.impl.feeds.PageView (KmpStoryFeedsPage.kt:266)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                KmpStoryFeedsVM kmpStoryFeedsVM = (KmpStoryFeedsVM) f2.d.c(Reflection.getOrCreateKotlinClass(KmpStoryFeedsVM.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                kp4.b n = kmpStoryFeedsVM.k.n(cVar.c());
                if (n == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    t3 endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.c
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit l;
                                l = KmpStoryFeedsPageKt.l(i, cVar, i2, (Composer) obj, ((Integer) obj2).intValue());
                                return l;
                            }
                        });
                        return;
                    }
                    return;
                }
                if (cVar instanceof np4.c) {
                    startRestartGroup.startReplaceGroup(-372471426);
                    com.dragon.read.kmp.story.impl.feeds.page.view.r.b((np4.c) cVar, n, startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                } else if (cVar instanceof np4.e) {
                    startRestartGroup.startReplaceGroup(-372379976);
                    com.dragon.read.kmp.story.impl.feeds.page.view.c0.e((np4.e) cVar, n, i, startRestartGroup, nn0.b.b | bp4.a.c | ((i6 << 6) & 896));
                    startRestartGroup.endReplaceGroup();
                } else if (cVar instanceof np4.a) {
                    startRestartGroup.startReplaceGroup(-372279815);
                    ContentEndAuthorPageViewKt.p((np4.a) cVar, n, kmpStoryFeedsVM.a.d(), startRestartGroup, 0, 0);
                    startRestartGroup.endReplaceGroup();
                } else if (cVar instanceof np4.b) {
                    startRestartGroup.startReplaceGroup(-372150297);
                    com.dragon.read.kmp.story.impl.feeds.page.view.h.b((np4.b) cVar, startRestartGroup, bp4.a.c);
                    startRestartGroup.endReplaceGroup();
                } else if (cVar instanceof np4.d) {
                    startRestartGroup.startReplaceGroup(-372067713);
                    w.f((np4.d) cVar, n, startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-372004101);
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
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = KmpStoryFeedsPageKt.m(i, cVar, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }
}
