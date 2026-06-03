package com.dragon.read.kmp.shortvideo.distribution.page;

import androidx.compose.foundation.layout.b0;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.n2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.shortvideo.distribution.infinite.BottomSheetContentKt;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRankLandingPageKt {

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609048);
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

    static {
        Covode.recordClassIndex(609047);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(int i, Composer composer, int i2) {
        e(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(lo4.b bVar, int i, Composer composer, int i2) {
        i(bVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class a implements DisposableEffectResult {
        final /* synthetic */ LifecycleOwner a;
        final /* synthetic */ LifecycleEventObserver b;
        final /* synthetic */ SeriesRankViewModel c;

        public void dispose() {
            this.a.getLifecycle().removeObserver(this.b);
            this.c.W0();
        }

        public a(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver, SeriesRankViewModel seriesRankViewModel) {
            this.a = lifecycleOwner;
            this.b = lifecycleEventObserver;
            this.c = seriesRankViewModel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-1353885993);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1353885993, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.PageLifecycleEffect (SeriesRankLandingPage.kt:64)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final LifecycleOwner lifecycleOwner = (LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(seriesRankViewModel) | startRestartGroup.changedInstance(lifecycleOwner);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DisposableEffectResult f;
                            f = SeriesRankLandingPageKt.f(lifecycleOwner, seriesRankViewModel, (DisposableEffectScope) obj);
                            return f;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(unit, (Function1) rememberedValue, startRestartGroup, 6);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h;
                    h = SeriesRankLandingPageKt.h(i, (Composer) obj, ((Integer) obj2).intValue());
                    return h;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult f(LifecycleOwner lifecycleOwner, final SeriesRankViewModel seriesRankViewModel, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.i
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                SeriesRankLandingPageKt.g(SeriesRankViewModel.this, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        seriesRankViewModel.V0();
        return new a(lifecycleOwner, lifecycleEventObserver, seriesRankViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SeriesRankViewModel seriesRankViewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = b.a[event.ordinal()];
        if (i != 1) {
            if (i == 2) {
                seriesRankViewModel.Z0();
                return;
            }
            return;
        }
        seriesRankViewModel.a1();
    }

    public static final void i(final lo4.b params, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Composer startRestartGroup = composer.startRestartGroup(273710456);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(params)) {
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
                ComposerKt.traceEventStart(273710456, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankLandingPage (SeriesRankLandingPage.kt:24)");
            }
            ym4.f.c("series_rank_page", params, t.e(1488266349, true, new Function2<Composer, Integer, Unit>() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankLandingPageKt$SeriesRankLandingPage$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    a(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void a(Composer composer2, int i4) {
                    boolean z2;
                    CreationExtras creationExtras;
                    if ((i4 & 3) != 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composer2.shouldExecute(z2, i4 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1488266349, i4, -1, "com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankLandingPage.<anonymous> (SeriesRankLandingPage.kt:26)");
                        }
                        com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.f fVar = new com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.f(lo4.b.this);
                        HasDefaultViewModelProviderFactory c = f2.b.a.c(composer2, 6);
                        if (c != null) {
                            if (c instanceof HasDefaultViewModelProviderFactory) {
                                creationExtras = c.getDefaultViewModelCreationExtras();
                            } else {
                                creationExtras = CreationExtras.b.a;
                            }
                            final SeriesRankViewModel seriesRankViewModel = (SeriesRankViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(SeriesRankViewModel.class), c, (String) null, fVar, creationExtras, composer2, 0, 0);
                            final n2 H = ModalBottomSheetKt.H(ModalBottomSheetValue.Hidden, (androidx.compose.animation.core.i) null, (Function1) null, true, composer2, 3078, 6);
                            seriesRankViewModel.l = H;
                            Object rememberedValue = composer2.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            seriesRankViewModel.o = (CoroutineScope) rememberedValue;
                            pg4.p.f((pg4.i) null, t.e(-219929954, true, new Function2<Composer, Integer, Unit>() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankLandingPageKt$SeriesRankLandingPage$1.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    a(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void a(Composer composer3, int i5) {
                                    boolean z3;
                                    if ((i5 & 3) != 2) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (composer3.shouldExecute(z3, i5 & 1)) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-219929954, i5, -1, "com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankLandingPage.<anonymous>.<anonymous> (SeriesRankLandingPage.kt:42)");
                                        }
                                        float g = x0.i.g(0);
                                        long g2 = l0.b.g();
                                        final SeriesRankViewModel seriesRankViewModel2 = seriesRankViewModel;
                                        ModalBottomSheetKt.p(t.e(1672210992, true, new Function3<b0, Composer, Integer, Unit>() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankLandingPageKt.SeriesRankLandingPage.1.1.1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(b0 b0Var, Composer composer4, Integer num) {
                                                a(b0Var, composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void a(b0 ModalBottomSheetLayout, Composer composer4, int i6) {
                                                boolean z4;
                                                Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
                                                if ((i6 & 17) != 16) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (composer4.shouldExecute(z4, i6 & 1)) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1672210992, i6, -1, "com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankLandingPage.<anonymous>.<anonymous>.<anonymous> (SeriesRankLandingPage.kt:47)");
                                                    }
                                                    com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar = (com.dragon.read.kmp.shortvideo.distribution.infinite.g) SeriesRankViewModel.this.g.getValue();
                                                    FilterType filterType = (FilterType) SeriesRankViewModel.this.h.getValue();
                                                    composer4.startReplaceGroup(5004770);
                                                    boolean changedInstance = composer4.changedInstance(SeriesRankViewModel.this);
                                                    SeriesRankViewModel seriesRankViewModel3 = SeriesRankViewModel.this;
                                                    Object rememberedValue2 = composer4.rememberedValue();
                                                    if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                                                        rememberedValue2 = new SeriesRankLandingPageKt$SeriesRankLandingPage$1$1$1$1$1(seriesRankViewModel3, null);
                                                        composer4.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer4.endReplaceGroup();
                                                    BottomSheetContentKt.c(gVar, filterType, (Function2) rememberedValue2, composer4, 0, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }, composer3, 54), (Modifier) null, H, false, (f2) null, g, g2, 0L, 0L, b.a.a(), composer3, (n2.e << 6) | 807075846, 410);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54), composer2, 48, 1);
                            SeriesRankLandingPageKt.e(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    composer2.skipToGroupEnd();
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = SeriesRankLandingPageKt.j(lo4.b.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }
}
