package com.dragon.read.kmp.story.impl.album;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.u1;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.community.base.sdk.load.KmpCSSLoadStatus;
import com.dragon.read.kmp.compose.common.image.LoadImage_androidKt;
import com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt;
import com.dragon.read.kmp.story.impl.album.view.StoryCardViewKt;
import com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryAlbumPanelKt {
    private static boolean a;

    static {
        Covode.recordClassIndex(609203);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(ep4.a aVar, com.dragon.read.kmp.story.impl.album.a aVar2, dp4.a aVar3, float f, int i, int i2, Composer composer, int i3) {
        z(aVar, aVar2, aVar3, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(com.dragon.read.kmp.story.impl.album.a aVar, ep4.a aVar2, float f, int i, Composer composer, int i2) {
        l(aVar, aVar2, f, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(LazyListState lazyListState, StoryAlbumViewModel storyAlbumViewModel, com.dragon.read.kmp.story.impl.album.a aVar, int i, Composer composer, int i2) {
        p(lazyListState, storyAlbumViewModel, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(LazyListState lazyListState, com.dragon.read.kmp.story.impl.album.viewmodel.a aVar, com.dragon.read.kmp.story.impl.album.a aVar2, ep4.a aVar3, float f, int i, Composer composer, int i2) {
        u(lazyListState, aVar, aVar2, aVar3, f, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ StoryAlbumViewModel a;

        public void dispose() {
            this.a.V0();
        }

        public b(StoryAlbumViewModel storyAlbumViewModel) {
            this.a = storyAlbumViewModel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.story.impl.album.viewmodel.a A(State<com.dragon.read.kmp.story.impl.album.viewmodel.a> state) {
        return (com.dragon.read.kmp.story.impl.album.viewmodel.a) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.story.impl.album.viewmodel.a m(State<com.dragon.read.kmp.story.impl.album.viewmodel.a> state) {
        return (com.dragon.read.kmp.story.impl.album.viewmodel.a) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(StoryAlbumViewModel storyAlbumViewModel) {
        storyAlbumViewModel.a1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(StoryAlbumViewModel storyAlbumViewModel) {
        storyAlbumViewModel.W0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(StoryAlbumViewModel storyAlbumViewModel) {
        storyAlbumViewModel.N0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(StoryAlbumViewModel storyAlbumViewModel) {
        storyAlbumViewModel.Q0();
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ StoryAlbumViewModel a;
        final /* synthetic */ com.dragon.read.kmp.story.impl.album.a b;
        final /* synthetic */ ep4.a c;
        final /* synthetic */ float d;
        final /* synthetic */ State<com.dragon.read.kmp.story.impl.album.viewmodel.a> e;

        a(StoryAlbumViewModel storyAlbumViewModel, com.dragon.read.kmp.story.impl.album.a aVar, ep4.a aVar2, float f, State<com.dragon.read.kmp.story.impl.album.viewmodel.a> state) {
            this.a = storyAlbumViewModel;
            this.b = aVar;
            this.c = aVar2;
            this.d = f;
            this.e = state;
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
                    ComposerKt.traceEventStart(2121189799, i, -1, "com.dragon.read.kmp.story.impl.album.StoryAlbumContainer.<anonymous> (StoryAlbumPanel.kt:108)");
                }
                StoryAlbumPanelKt.u(this.a.b, StoryAlbumPanelKt.m(this.e), this.b, this.c, this.d, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class e implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ pp4.d a;
        final /* synthetic */ com.dragon.read.kmp.story.impl.album.a b;
        final /* synthetic */ ep4.a c;
        final /* synthetic */ float d;
        final /* synthetic */ State<com.dragon.read.kmp.story.impl.album.viewmodel.a> e;

        e(pp4.d dVar, com.dragon.read.kmp.story.impl.album.a aVar, ep4.a aVar2, float f, State<com.dragon.read.kmp.story.impl.album.viewmodel.a> state) {
            this.a = dVar;
            this.b = aVar;
            this.c = aVar2;
            this.d = f;
            this.e = state;
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
                    ComposerKt.traceEventStart(-1977922793, i, -1, "com.dragon.read.kmp.story.impl.album.StoryAlbumPanel.<anonymous> (StoryAlbumPanel.kt:76)");
                }
                Modifier d = BackgroundKt.d(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), this.a.R(), (f2) null, 2, (Object) null);
                com.dragon.read.kmp.story.impl.album.a aVar = this.b;
                ep4.a aVar2 = this.c;
                float f = this.d;
                State<com.dragon.read.kmp.story.impl.album.viewmodel.a> state = this.e;
                p0 a = x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
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
                c0 c0Var = c0.b;
                com.dragon.read.kmp.story.impl.album.view.e.b(aVar, StoryAlbumPanelKt.A(state).h, composer, 0);
                StoryAlbumPanelKt.l(aVar, aVar2, f, composer, 0);
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
    public static final Object x(int i, com.dragon.read.kmp.story.impl.album.base.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.b();
    }

    static final class c implements Function4<LazyListState, Integer, Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ com.dragon.read.kmp.compose.common.image.n b;

        c(String str, com.dragon.read.kmp.compose.common.image.n nVar) {
            this.a = str;
            this.b = nVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x0.p c(androidx.compose.foundation.lazy.o oVar, x0.e offset) {
            Intrinsics.checkNotNullParameter(offset, "$this$offset");
            return x0.p.c(x0.p.f((oVar.getOffset() & 4294967295L) | (0 << 32)));
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyListState lazyListState, Integer num, Composer composer, Integer num2) {
            b(lazyListState, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void b(LazyListState state, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            Object obj;
            String str;
            boolean z2;
            int i4;
            int i5;
            Intrinsics.checkNotNullParameter(state, "state");
            if ((i2 & 6) == 0) {
                if (composer.changed(state)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i5 | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 |= i4;
            }
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-100453918, i3, -1, "com.dragon.read.kmp.story.impl.album.StoryAlbumListView.<anonymous> (StoryAlbumPanel.kt:233)");
                }
                Iterator it2 = state.x().h().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        if (((androidx.compose.foundation.lazy.o) obj).getIndex() == i) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                final androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) obj;
                if (oVar != null && (str = this.a) != null) {
                    com.dragon.read.kmp.compose.common.image.n nVar = this.b;
                    Modifier i6 = SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(180));
                    composer.startReplaceGroup(5004770);
                    boolean changedInstance = composer.changedInstance(oVar);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function1() { // from class: com.dragon.read.kmp.story.impl.album.q
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                x0.p c;
                                c = StoryAlbumPanelKt.c.c(oVar, (x0.e) obj2);
                                return c;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    LoadImage_androidKt.j(str, (String) null, (androidx.compose.ui.e) null, nVar, u1.c(i6, (Function1) rememberedValue), composer, 3072, 6);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult t(StoryAlbumViewModel storyAlbumViewModel, CoroutineScope coroutineScope, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        storyAlbumViewModel.U0(coroutineScope);
        return new b(storyAlbumViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(StoryAlbumViewModel storyAlbumViewModel, com.dragon.read.kmp.story.impl.album.a aVar, LazyListState lazyListState) {
        boolean z;
        storyAlbumViewModel.Z0();
        boolean z2 = true;
        if (storyAlbumViewModel.g.getValue().a != KmpCSSLoadStatus.Content) {
            if (aVar != null) {
                aVar.b(true);
            }
        } else {
            com.dragon.read.kmp.story.impl.album.viewmodel.a value = storyAlbumViewModel.g.getValue();
            int v = lazyListState.v();
            if (lazyListState.u() == 0 && v <= 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z || value.e || value.c != KmpCSSLoadStatus.Init) {
                z2 = false;
            }
            if (aVar != null) {
                aVar.b(z2);
            }
        }
        return Unit.INSTANCE;
    }

    static final class d implements Function4<com.dragon.read.kmp.story.impl.album.base.a, Integer, Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.story.impl.album.a a;
        final /* synthetic */ com.dragon.read.kmp.story.impl.album.viewmodel.a b;
        final /* synthetic */ ep4.a c;

        d(com.dragon.read.kmp.story.impl.album.a aVar, com.dragon.read.kmp.story.impl.album.viewmodel.a aVar2, ep4.a aVar3) {
            this.a = aVar;
            this.b = aVar2;
            this.c = aVar3;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.story.impl.album.base.a aVar, Integer num, Composer composer, Integer num2) {
            a(aVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(com.dragon.read.kmp.story.impl.album.base.a item, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            boolean changedInstance;
            int i5;
            Intrinsics.checkNotNullParameter(item, "item");
            if ((i2 & 6) == 0) {
                if ((i2 & 8) == 0) {
                    changedInstance = composer.changed(item);
                } else {
                    changedInstance = composer.changedInstance(item);
                }
                if (changedInstance) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i5 | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 |= i4;
            }
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-814511254, i3, -1, "com.dragon.read.kmp.story.impl.album.StoryAlbumListView.<anonymous> (StoryAlbumPanel.kt:246)");
                }
                if (item instanceof com.dragon.read.kmp.story.impl.album.c) {
                    composer.startReplaceGroup(1460530438);
                    com.dragon.read.kmp.story.impl.album.view.c.b((com.dragon.read.kmp.story.impl.album.c) item, this.a, this.b, composer, 0);
                    composer.endReplaceGroup();
                } else if (item instanceof ep4.b) {
                    composer.startReplaceGroup(1460648982);
                    StoryCardViewKt.g((ep4.b) item, i, this.a, this.c, this.b, composer, i3 & 112);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1460753080);
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

    public static final void l(final com.dragon.read.kmp.story.impl.album.a depend, final ep4.a storyAlbumParam, final float f, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        int i3;
        int i4;
        boolean changedInstance;
        int i5;
        Intrinsics.checkNotNullParameter(depend, "depend");
        Intrinsics.checkNotNullParameter(storyAlbumParam, "storyAlbumParam");
        Composer startRestartGroup = composer.startRestartGroup(40266285);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(depend);
            } else {
                changedInstance = startRestartGroup.changedInstance(depend);
            }
            if (changedInstance) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(storyAlbumParam)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(f)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(40266285, i2, -1, "com.dragon.read.kmp.story.impl.album.StoryAlbumContainer (StoryAlbumPanel.kt:91)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final StoryAlbumViewModel storyAlbumViewModel = (StoryAlbumViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(StoryAlbumViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                State collectAsState = SnapshotStateKt.collectAsState(storyAlbumViewModel.g, (CoroutineContext) null, startRestartGroup, 0, 1);
                pp4.d a2 = pp4.e.a(m(collectAsState).h);
                p(storyAlbumViewModel.b, storyAlbumViewModel, depend, startRestartGroup, (i2 << 6) & 896);
                KmpCSSLoadStatus kmpCSSLoadStatus = m(collectAsState).a;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance2 = startRestartGroup.changedInstance(storyAlbumViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.story.impl.album.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit n;
                            n = StoryAlbumPanelKt.n(StoryAlbumViewModel.this);
                            return n;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                gx1.m.r(kmpCSSLoadStatus, new gx1.b((String) null, (Function0) rememberedValue, "网络出错，请点击重试", (Function0) null, 9, (DefaultConstructorMarker) null), a2.R(), (Function2) null, true, (Function3) null, (Function3) null, false, t.e(2121189799, true, new a(storyAlbumViewModel, depend, storyAlbumParam, f, collectAsState), composer2, 54), composer2, 100687872, 232);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.album.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = StoryAlbumPanelKt.o(a.this, storyAlbumParam, f, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    public static final void p(final LazyListState listState, final StoryAlbumViewModel viewModel, final com.dragon.read.kmp.story.impl.album.a aVar, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean changedInstance;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(listState, "listState");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(1808701029);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(listState)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(viewModel)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(aVar);
            } else {
                changedInstance = startRestartGroup.changedInstance(aVar);
            }
            if (changedInstance) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808701029, i2, -1, "com.dragon.read.kmp.story.impl.album.StoryAlbumListEffect (StoryAlbumPanel.kt:121)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(coroutineScope);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.story.impl.album.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult t;
                        t = StoryAlbumPanelKt.t(StoryAlbumViewModel.this, coroutineScope, (DisposableEffectScope) obj);
                        return t;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1746271574);
            int i6 = i2 & 896;
            if (i6 != 256 && ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(aVar))) {
                z2 = false;
            } else {
                z2 = true;
            }
            int i7 = i2 & 14;
            if (i7 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean changedInstance3 = z2 | z3 | startRestartGroup.changedInstance(viewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new StoryAlbumPanelKt$StoryAlbumListEffect$2$1(aVar, viewModel, listState, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(listState, aVar, (Function2) rememberedValue3, startRestartGroup, ((i2 >> 3) & 112) | i7);
            Boolean valueOf = Boolean.valueOf(listState.b());
            startRestartGroup.startReplaceGroup(5004770);
            if (i7 == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new StoryAlbumPanelKt$StoryAlbumListEffect$3$1(listState, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue4, startRestartGroup, 0);
            Lifecycle.Event event = Lifecycle.Event.ON_START;
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            if (i6 != 256 && ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(aVar))) {
                z5 = false;
            } else {
                z5 = true;
            }
            boolean z7 = changedInstance4 | z5;
            if (i7 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z8 = z7 | z6;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.story.impl.album.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit q;
                        q = StoryAlbumPanelKt.q(StoryAlbumViewModel.this, aVar, listState);
                        return q;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            androidx.lifecycle.compose.d.d(event, (LifecycleOwner) null, (Function0) rememberedValue5, startRestartGroup, 6, 2);
            Lifecycle.Event event2 = Lifecycle.Event.ON_STOP;
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.story.impl.album.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit r;
                        r = StoryAlbumPanelKt.r(StoryAlbumViewModel.this);
                        return r;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            androidx.lifecycle.compose.d.d(event2, (LifecycleOwner) null, (Function0) rememberedValue6, startRestartGroup, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.album.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit s;
                    s = StoryAlbumPanelKt.s(listState, viewModel, aVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return s;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void z(final ep4.a r19, final com.dragon.read.kmp.story.impl.album.a r20, final dp4.a r21, float r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt.z(ep4.a, com.dragon.read.kmp.story.impl.album.a, dp4.a, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fd, code lost:
    
        if ((!kotlin.text.StringsKt__StringsKt.isBlank(r3)) != false) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void u(final androidx.compose.foundation.lazy.LazyListState r27, final com.dragon.read.kmp.story.impl.album.viewmodel.a r28, final com.dragon.read.kmp.story.impl.album.a r29, final ep4.a r30, final float r31, androidx.compose.runtime.Composer r32, final int r33) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.album.StoryAlbumPanelKt.u(androidx.compose.foundation.lazy.LazyListState, com.dragon.read.kmp.story.impl.album.viewmodel.a, com.dragon.read.kmp.story.impl.album.a, ep4.a, float, androidx.compose.runtime.Composer, int):void");
    }
}
