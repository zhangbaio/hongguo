package com.dragon.read.kmp.mine.search.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.z2;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.e1;
import androidx.compose.material.a6;
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
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.u2;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SearchSource;
import com.dragon.read.kmp.mine.search.view.MineSearchPageKt;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MineSearchPageKt {
    static {
        Covode.recordClassIndex(607772);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(q qVar, int i, Composer composer, int i2) {
        f(qVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(int i, Composer composer, int i2) {
        h(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(int i, MineSearchPageViewModel mineSearchPageViewModel, int i2, Composer composer, int i3) {
        l(i, mineSearchPageViewModel, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ q a;

        a(q qVar) {
            this.a = qVar;
        }

        public static final class b implements DisposableEffectResult {
            final /* synthetic */ MineSearchPageViewModel a;

            public void dispose() {
                this.a.N0();
            }

            public b(MineSearchPageViewModel mineSearchPageViewModel) {
                this.a = mineSearchPageViewModel;
            }
        }

        /* renamed from: com.dragon.read.kmp.mine.search.view.MineSearchPageKt$a$a, reason: collision with other inner class name */
        static final class C0020a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ MineSearchPageViewModel a;
            final /* synthetic */ androidx.compose.ui.focus.n b;
            final /* synthetic */ u2 c;

            /* renamed from: com.dragon.read.kmp.mine.search.view.MineSearchPageKt$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0021a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[UiState.values().length];
                    try {
                        iArr[UiState.Init.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[UiState.Loading.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[UiState.Success.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[UiState.Error.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[UiState.Empty.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    a = iArr;
                }
            }

            C0020a(MineSearchPageViewModel mineSearchPageViewModel, androidx.compose.ui.focus.n nVar, u2 u2Var) {
                this.a = mineSearchPageViewModel;
                this.b = nVar;
                this.c = u2Var;
            }

            private static final String i(MutableState<String> mutableState) {
                return (String) mutableState.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit o(MineSearchPageViewModel mineSearchPageViewModel) {
                mineSearchPageViewModel.K0();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit j(MineSearchPageViewModel mineSearchPageViewModel) {
                mineSearchPageViewModel.g.setValue(UiState.Init);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit k(MineSearchPageViewModel mineSearchPageViewModel) {
                mineSearchPageViewModel.g.setValue(UiState.Init);
                return Unit.INSTANCE;
            }

            private static final void n(MutableState<String> mutableState, String str) {
                mutableState.setValue(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit l(androidx.compose.ui.focus.n nVar, u2 u2Var) {
                androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
                if (u2Var != null) {
                    u2Var.hide();
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit m(MineSearchPageViewModel mineSearchPageViewModel, MutableState mutableState) {
                mineSearchPageViewModel.Q0(i(mutableState));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit p(MutableState mutableState, String it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                n(mutableState, it2);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                h(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void h(Composer composer, int i) {
                boolean z;
                if ((i & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1986000820, i, -1, "com.dragon.read.kmp.mine.search.view.MineSearchPage.<anonymous>.<anonymous> (MineSearchPage.kt:74)");
                    }
                    Modifier.a aVar = Modifier.Companion;
                    float f = 24;
                    Modifier a = androidx.compose.ui.draw.e.a(SizeKt.f(aVar, 0.0f, 1, (Object) null), k.g.e(x0.i.g(f), x0.i.g(f), 0.0f, 0.0f, 12, (Object) null));
                    og4.a aVar2 = og4.a.a;
                    int i2 = og4.a.b;
                    Modifier d = BackgroundKt.d(a, aVar2.h(composer, i2).w(), (f2) null, 2, (Object) null);
                    final MineSearchPageViewModel mineSearchPageViewModel = this.a;
                    final androidx.compose.ui.focus.n nVar = this.b;
                    final u2 u2Var = this.c;
                    androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                    e.m i3 = eVar.i();
                    e.a aVar3 = androidx.compose.ui.e.a;
                    p0 a2 = androidx.compose.foundation.layout.x.a(i3, aVar3.k(), composer, 0);
                    int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, d);
                    ComposeUiNode.Companion companion = ComposeUiNode.o0;
                    Function0 a4 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a4);
                    } else {
                        composer.useNode();
                    }
                    Composer b = g5.b(composer);
                    g5.e(b, a2, companion.c());
                    g5.e(b, currentCompositionLocalMap, companion.e());
                    Function2 b2 = companion.b();
                    if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a3))) {
                        b.updateRememberedValue(Integer.valueOf(a3));
                        b.apply(Integer.valueOf(a3), b2);
                    }
                    g5.e(b, e, companion.d());
                    androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue = composer.rememberedValue();
                    Composer.Companion companion2 = Composer.Companion;
                    if (rememberedValue == companion2.getEmpty()) {
                        rememberedValue = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    final MutableState mutableState = (MutableState) rememberedValue;
                    composer.endReplaceGroup();
                    float g = x0.i.g(16);
                    composer.startReplaceGroup(-1814856593);
                    a3.a(SizeKt.i(aVar, g), composer, 0);
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(5004770);
                    boolean changedInstance = composer.changedInstance(mineSearchPageViewModel);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance || rememberedValue2 == companion2.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.search.view.i
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit o;
                                o = MineSearchPageKt.a.C0020a.o(MineSearchPageViewModel.this);
                                return o;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    Function0 function0 = (Function0) rememberedValue2;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(5004770);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (rememberedValue3 == companion2.getEmpty()) {
                        rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.mine.search.view.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit p;
                                p = MineSearchPageKt.a.C0020a.p(mutableState, (String) obj);
                                return p;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    Function1 function1 = (Function1) rememberedValue3;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(-1633490746);
                    boolean changedInstance2 = composer.changedInstance(nVar) | composer.changedInstance(mineSearchPageViewModel);
                    Object rememberedValue4 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == companion2.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.mine.search.view.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit q;
                                q = MineSearchPageKt.a.C0020a.q(nVar, mineSearchPageViewModel, (String) obj);
                                return q;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue4);
                    }
                    Function1 function12 = (Function1) rememberedValue4;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(5004770);
                    boolean changedInstance3 = composer.changedInstance(mineSearchPageViewModel);
                    Object rememberedValue5 = composer.rememberedValue();
                    if (changedInstance3 || rememberedValue5 == companion2.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.mine.search.view.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit j;
                                j = MineSearchPageKt.a.C0020a.j(MineSearchPageViewModel.this);
                                return j;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue5);
                    }
                    Function0 function02 = (Function0) rememberedValue5;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(5004770);
                    boolean changedInstance4 = composer.changedInstance(mineSearchPageViewModel);
                    Object rememberedValue6 = composer.rememberedValue();
                    if (changedInstance4 || rememberedValue6 == companion2.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.mine.search.view.m
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit k;
                                k = MineSearchPageKt.a.C0020a.k(MineSearchPageViewModel.this);
                                return k;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue6);
                    }
                    composer.endReplaceGroup();
                    SearchTopBarKt.k(function0, function1, function12, function02, (Function0) rememberedValue6, null, composer, 48, 32);
                    Modifier f2 = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                    composer.startReplaceGroup(-1633490746);
                    boolean changedInstance5 = composer.changedInstance(nVar) | composer.changed(u2Var);
                    Object rememberedValue7 = composer.rememberedValue();
                    if (changedInstance5 || rememberedValue7 == companion2.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: com.dragon.read.kmp.mine.search.view.n
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit l;
                                l = MineSearchPageKt.a.C0020a.l(nVar, u2Var);
                                return l;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue7);
                    }
                    composer.endReplaceGroup();
                    Modifier modifier = ClickableKt.clickable-oSLSa3U$default(f2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue7, 15, (Object) null);
                    p0 a5 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar3.k(), composer, 0);
                    int a6 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer, modifier);
                    Function0 a7 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a7);
                    } else {
                        composer.useNode();
                    }
                    Composer b3 = g5.b(composer);
                    g5.e(b3, a5, companion.c());
                    g5.e(b3, currentCompositionLocalMap2, companion.e());
                    Function2 b4 = companion.b();
                    if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a6))) {
                        b3.updateRememberedValue(Integer.valueOf(a6));
                        b3.apply(Integer.valueOf(a6), b4);
                    }
                    g5.e(b3, e2, companion.d());
                    int i4 = C0021a.a[((UiState) mineSearchPageViewModel.g.getValue()).ordinal()];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 != 4) {
                                    if (i4 == 5) {
                                        composer.startReplaceGroup(-521256904);
                                        float g2 = x0.i.g(157);
                                        composer.startReplaceGroup(-1814856593);
                                        a3.a(SizeKt.i(aVar, g2), composer, 0);
                                        composer.endReplaceGroup();
                                        a6.j((String) mineSearchPageViewModel.h.getValue(), SizeKt.h(aVar, 0.0f, 1, (Object) null), aVar2.h(composer, i2).X0(), 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 48, 0, 130552);
                                        composer.endReplaceGroup();
                                        Unit unit = Unit.INSTANCE;
                                    } else {
                                        composer.startReplaceGroup(952979625);
                                        composer.endReplaceGroup();
                                        throw new NoWhenBranchMatchedException();
                                    }
                                } else {
                                    composer.startReplaceGroup(-521578746);
                                    composer.startReplaceGroup(-1633490746);
                                    boolean changedInstance6 = composer.changedInstance(mineSearchPageViewModel);
                                    Object rememberedValue8 = composer.rememberedValue();
                                    if (changedInstance6 || rememberedValue8 == companion2.getEmpty()) {
                                        rememberedValue8 = new Function0() { // from class: com.dragon.read.kmp.mine.search.view.o
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Unit m;
                                                m = MineSearchPageKt.a.C0020a.m(MineSearchPageViewModel.this, mutableState);
                                                return m;
                                            }
                                        };
                                        composer.updateRememberedValue(rememberedValue8);
                                    }
                                    composer.endReplaceGroup();
                                    mg4.k.k(new mg4.b("加载失败，点击重试", (Function0) rememberedValue8, (String) null, (Function0) null, (androidx.compose.ui.graphics.l0) null, 28, (DefaultConstructorMarker) null), true, composer, 48, 0);
                                    composer.endReplaceGroup();
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            } else {
                                composer.startReplaceGroup(-521734676);
                                MineSearchPageKt.h(composer, 0);
                                composer.endReplaceGroup();
                                Unit unit3 = Unit.INSTANCE;
                            }
                        } else {
                            composer.startReplaceGroup(-521894171);
                            a0.g(composer, 0);
                            composer.endReplaceGroup();
                            Unit unit4 = Unit.INSTANCE;
                        }
                    } else {
                        composer.startReplaceGroup(-522369091);
                        float g3 = x0.i.g(157);
                        composer.startReplaceGroup(-1814856593);
                        a3.a(SizeKt.i(aVar, g3), composer, 0);
                        composer.endReplaceGroup();
                        a6.j((String) mineSearchPageViewModel.h.getValue(), SizeKt.h(aVar, 0.0f, 1, (Object) null), aVar2.h(composer, i2).X0(), 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 48, 0, 130552);
                        composer.endReplaceGroup();
                        Unit unit5 = Unit.INSTANCE;
                    }
                    composer.endNode();
                    composer.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit q(androidx.compose.ui.focus.n nVar, MineSearchPageViewModel mineSearchPageViewModel, String it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                qf3.a.g.f(Integer.valueOf(SearchSource.HgMyTab.getValue()));
                androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
                mineSearchPageViewModel.Q0(it2);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            CreationExtras creationExtras;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(107748931, i, -1, "com.dragon.read.kmp.mine.search.view.MineSearchPage.<anonymous> (MineSearchPage.kt:59)");
                }
                v vVar = new v(this.a);
                HasDefaultViewModelProviderFactory c = f2.b.a.c(composer, 6);
                if (c != null) {
                    if (c instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = c.getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.b.a;
                    }
                    final MineSearchPageViewModel mineSearchPageViewModel = (MineSearchPageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(MineSearchPageViewModel.class), c, (String) null, vVar, creationExtras, composer, 0, 0);
                    Object rememberedValue = composer.rememberedValue();
                    Composer.Companion companion = Composer.Companion;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                    u2 u2Var = (u2) composer.consume(CompositionLocalsKt.p());
                    androidx.compose.ui.focus.n nVar = (androidx.compose.ui.focus.n) composer.consume(CompositionLocalsKt.g());
                    Unit unit = Unit.INSTANCE;
                    composer.startReplaceGroup(-1633490746);
                    boolean changedInstance = composer.changedInstance(mineSearchPageViewModel) | composer.changedInstance(coroutineScope);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.mine.search.view.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                DisposableEffectResult c2;
                                c2 = MineSearchPageKt.a.c(MineSearchPageViewModel.this, coroutineScope, (DisposableEffectScope) obj);
                                return c2;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, composer, 6);
                    pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(1986000820, true, new C0020a(mineSearchPageViewModel, nVar, u2Var), composer, 54), composer, 48);
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
        public static final DisposableEffectResult c(MineSearchPageViewModel mineSearchPageViewModel, CoroutineScope coroutineScope, DisposableEffectScope DisposableEffect) {
            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
            mineSearchPageViewModel.M0(coroutineScope);
            return new b(mineSearchPageViewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(MineSearchPageViewModel mineSearchPageViewModel) {
        return mineSearchPageViewModel.d.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object j(int i) {
        return Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-1598151712);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1598151712, i, -1, "com.dragon.read.kmp.mine.search.view.MineSearchPager (MineSearchPage.kt:156)");
            }
            HasDefaultViewModelProviderFactory c = f2.b.a.c(startRestartGroup, 6);
            if (c != null) {
                if (c instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final MineSearchPageViewModel mineSearchPageViewModel = (MineSearchPageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(MineSearchPageViewModel.class), c, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                int i2 = mineSearchPageViewModel.f;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(mineSearchPageViewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.search.view.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            int i3;
                            i3 = MineSearchPageKt.i(MineSearchPageViewModel.this);
                            return Integer.valueOf(i3);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                PagerState n = e1.n(i2, 0.0f, (Function0) rememberedValue2, startRestartGroup, 0, 2);
                Integer valueOf = Integer.valueOf(n.u());
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(mineSearchPageViewModel) | startRestartGroup.changed(n);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new MineSearchPageKt$MineSearchPager$1$1(mineSearchPageViewModel, n, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue3, startRestartGroup, 0);
                float g = x0.i.g(8);
                startRestartGroup.startReplaceGroup(-1814856593);
                Modifier.a aVar = Modifier.Companion;
                a3.a(SizeKt.i(aVar, g), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                int u = n.u();
                Modifier i3 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(46));
                float g2 = x0.i.g(16);
                com.dragon.read.kmp.mine.search.view.a aVar2 = com.dragon.read.kmp.mine.search.view.a.a;
                com.dragon.read.kmp.widget.slidetab.e.b(u, i3, 0L, 0L, g2, aVar2.a(), aVar2.b(), androidx.compose.runtime.internal.t.e(171376354, true, new MineSearchPageKt$MineSearchPager$2(mineSearchPageViewModel, n, coroutineScope), startRestartGroup, 54), startRestartGroup, 14377008, 12);
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.mine.search.view.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Object j;
                            j = MineSearchPageKt.j(((Integer) obj).intValue());
                            return j;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                PagerKt.i(n, f, (i2) null, (androidx.compose.foundation.pager.n) null, 3, 0.0f, (e.c) null, (z2) null, false, false, (Function1) rememberedValue4, (androidx.compose.ui.input.nestedscroll.b) null, androidx.compose.runtime.internal.t.e(1083452067, true, new b(mineSearchPageViewModel), startRestartGroup, 54), startRestartGroup, 24624, 390, 3052);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.search.view.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = MineSearchPageKt.k(i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    public static final void f(final q params, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        Composer startRestartGroup = composer.startRestartGroup(1148399374);
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
                ComposerKt.traceEventStart(1148399374, i2, -1, "com.dragon.read.kmp.mine.search.view.MineSearchPage (MineSearchPage.kt:57)");
            }
            ym4.f.c("mine_search_page", params, androidx.compose.runtime.internal.t.e(107748931, true, new a(params), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.search.view.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = MineSearchPageKt.g(q.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    static final class b implements Function4<androidx.compose.foundation.pager.p0, Integer, Composer, Integer, Unit> {
        final /* synthetic */ MineSearchPageViewModel a;

        b(MineSearchPageViewModel mineSearchPageViewModel) {
            this.a = mineSearchPageViewModel;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.pager.p0 p0Var, Integer num, Composer composer, Integer num2) {
            a(p0Var, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.pager.p0 HorizontalPager, int i, Composer composer, int i2) {
            Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1083452067, i2, -1, "com.dragon.read.kmp.mine.search.view.MineSearchPager.<anonymous> (MineSearchPage.kt:223)");
            }
            MineSearchPageKt.l(i, this.a, composer, (i2 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final int i, final MineSearchPageViewModel mineSearchPageViewModel, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        hn4.e S5;
        hn4.e eVar;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1858426569);
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
            if (startRestartGroup.changedInstance(mineSearchPageViewModel)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        boolean z3 = true;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1858426569, i3, -1, "com.dragon.read.kmp.mine.search.view.SearchResultTab (MineSearchPage.kt:231)");
            }
            if (i >= 0 && i < mineSearchPageViewModel.d.size()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                startRestartGroup.startReplaceGroup(758469276);
                if (mineSearchPageViewModel.e.keySet().contains(Integer.valueOf(i))) {
                    eVar = mineSearchPageViewModel.e.get(Integer.valueOf(i));
                } else {
                    b0 b0Var = mineSearchPageViewModel.d.get(i);
                    startRestartGroup.startReplaceGroup(-1633490746);
                    if ((i3 & 14) != 4) {
                        z3 = false;
                    }
                    boolean changed = startRestartGroup.changed(b0Var) | z3;
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        hn4.d dVar = b0Var.b;
                        rememberedValue = new ak4.k(i, dVar.a, dVar.b, mineSearchPageViewModel);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ak4.k kVar = (ak4.k) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    fn4.a aVar = (fn4.a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(fn4.a.class));
                    if (aVar == null) {
                        S5 = null;
                    } else {
                        S5 = aVar.S5(kVar, b0Var.b, startRestartGroup, 0);
                    }
                    if (S5 != null) {
                        mineSearchPageViewModel.e.put(Integer.valueOf(i), S5);
                        S5.a.z0(b0Var.c);
                        eVar = S5;
                    } else {
                        eVar = null;
                    }
                }
                startRestartGroup.endReplaceGroup();
                if (eVar != null) {
                    fn4.a aVar2 = (fn4.a) eo0.c.a.a(Reflection.getOrCreateKotlinClass(fn4.a.class));
                    startRestartGroup.startReplaceGroup(758496436);
                    if (aVar2 != null) {
                        aVar2.D2(eVar, startRestartGroup, hn4.e.b);
                        Unit unit = Unit.INSTANCE;
                    }
                    startRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.search.view.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit m;
                    m = MineSearchPageKt.m(i, mineSearchPageViewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return m;
                }
            });
        }
    }
}
