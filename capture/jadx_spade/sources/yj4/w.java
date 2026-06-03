package yj4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.pager.e1;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.l0;
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
import com.bytedance.kmp.image.options.i;
import com.dragon.read.component.biz.impl.mine.o1;
import com.dragon.read.component.biz.impl.mine.w6;
import com.dragon.read.component.biz.impl.mine.x6;
import com.dragon.read.component.biz.impl.mine.y6;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListLayoutKt;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel;
import com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayoutKt;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.d1;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import w0.h;
import yj4.w;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    private static final float a;
    private static final float b;
    private static final float c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(CollapsibleListState collapsibleListState, int i, Composer composer, int i2) {
        A(collapsibleListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(WatchPreferenceViewModel watchPreferenceViewModel, float f, int i, Composer composer, int i2) {
        G(watchPreferenceViewModel, f, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(Modifier modifier, Pair pair, Function1 function1, int i, int i2, Composer composer, int i3) {
        I(modifier, pair, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(String str, CollapsibleListState collapsibleListState, int i, Composer composer, int i2) {
        L(str, collapsibleListState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(wj4.c cVar, wj4.a aVar, int i, Composer composer, int i2) {
        X(cVar, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int a0() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(int i, Composer composer, int i2) {
        Z(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(androidx.compose.foundation.layout.r rVar, int i, Composer composer, int i2) {
        v(rVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class a implements com.bytedance.kmp.image.options.i {
        final /* synthetic */ Function1<Float, Unit> a;

        public void onLoadStart() {
            i.a.b(this);
        }

        public void onFail(Throwable th) {
            i.a.a(this, th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Float, Unit> function1) {
            this.a = function1;
        }

        public void a(i.c successResult) {
            Intrinsics.checkNotNullParameter(successResult, "successResult");
            this.a.invoke(Float.valueOf(successResult.a / successResult.b));
        }
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ wj4.c a;
        final /* synthetic */ wj4.a b;

        b(wj4.c cVar, wj4.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        public static final class a implements DisposableEffectResult {
            final /* synthetic */ WatchPreferenceViewModel a;

            public void dispose() {
                this.a.S0();
            }

            public a(WatchPreferenceViewModel watchPreferenceViewModel) {
                this.a = watchPreferenceViewModel;
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
                    ComposerKt.traceEventStart(-1557805321, i, -1, "com.dragon.read.kmp.mine.preference.WatchPreferencePage.<anonymous> (WatchPreferencePage.kt:101)");
                }
                com.dragon.read.kmp.mine.preference.viewmodel.a aVar = new com.dragon.read.kmp.mine.preference.viewmodel.a(this.a, this.b);
                HasDefaultViewModelProviderFactory c = f2.b.a.c(composer, 6);
                if (c != null) {
                    if (c instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras = c.getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras = CreationExtras.b.a;
                    }
                    final WatchPreferenceViewModel watchPreferenceViewModel = (WatchPreferenceViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(WatchPreferenceViewModel.class), c, (String) null, aVar, creationExtras, composer, 0, 0);
                    Object rememberedValue = composer.rememberedValue();
                    Composer.Companion companion = Composer.Companion;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                    Unit unit = Unit.INSTANCE;
                    composer.startReplaceGroup(-1633490746);
                    boolean changedInstance = composer.changedInstance(watchPreferenceViewModel) | composer.changedInstance(coroutineScope);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: yj4.x
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                DisposableEffectResult c2;
                                c2 = w.b.c(WatchPreferenceViewModel.this, coroutineScope, (DisposableEffectScope) obj);
                                return c2;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, composer, 6);
                    pg4.p.f((pg4.i) null, yj4.a.a.a(), composer, 48, 1);
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
        public static final DisposableEffectResult c(WatchPreferenceViewModel watchPreferenceViewModel, CoroutineScope coroutineScope, DisposableEffectScope DisposableEffect) {
            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
            watchPreferenceViewModel.R0(coroutineScope);
            return new a(watchPreferenceViewModel);
        }
    }

    static {
        Covode.recordClassIndex(607717);
        a = x0.i.g(44);
        b = x0.i.g(b1.a.s());
        c = x0.i.g((int) (16 * r0.m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(float f) {
        return Unit.INSTANCE;
    }

    private static final Function0<Unit> N(MutableState<Function0<Unit>> mutableState) {
        return (Function0) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(MutableState mutableState) {
        W(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(WatchPreferenceViewModel watchPreferenceViewModel) {
        watchPreferenceViewModel.M0();
        return Unit.INSTANCE;
    }

    private static final float B(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(MutableState mutableState) {
        W(mutableState, false);
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    private static final boolean V(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(WatchPreferenceViewModel watchPreferenceViewModel) {
        WatchPreferenceViewModel.W0(watchPreferenceViewModel, false, 1, null);
        return Unit.INSTANCE;
    }

    private static final void C(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(MutableState mutableState, float f) {
        C(mutableState, f);
        return Unit.INSTANCE;
    }

    private static final void W(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CollapsibleListState a;

        c(CollapsibleListState collapsibleListState) {
            this.a = collapsibleListState;
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
                    ComposerKt.traceEventStart(-1843467553, i, -1, "com.dragon.read.kmp.mine.preference.WatchPreferencePageContent.<anonymous>.<anonymous>.<anonymous> (WatchPreferencePage.kt:146)");
                }
                WatchPreferencePinLayoutKt.c(this.a, composer, CollapsibleListState.q);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class d implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CollapsibleListState a;

        d(CollapsibleListState collapsibleListState) {
            this.a = collapsibleListState;
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
                    ComposerKt.traceEventStart(-27980064, i, -1, "com.dragon.read.kmp.mine.preference.WatchPreferencePageContent.<anonymous>.<anonymous>.<anonymous> (WatchPreferencePage.kt:149)");
                }
                com.dragon.read.kmp.mine.preference.widget.g.m(this.a, composer, CollapsibleListState.q);
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
    public static final Unit O(Ref$FloatRef ref$FloatRef, c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.c(ref$FloatRef.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(WatchPreferenceViewModel watchPreferenceViewModel, MutableState mutableState) {
        W(mutableState, false);
        watchPreferenceViewModel.V0(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(MutableState mutableState, c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.l(-((Number) mutableState.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(WatchPreferenceViewModel watchPreferenceViewModel, MutableState mutableState) {
        if (!watchPreferenceViewModel.P0()) {
            zm4.d.a.b();
        } else {
            W(mutableState, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(WatchPreferenceViewModel watchPreferenceViewModel, MutableState mutableState) {
        zj4.b.j(zj4.b.a, watchPreferenceViewModel.a.a, null, "quit", "quit", 2, null);
        N(mutableState).invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(WatchPreferenceViewModel watchPreferenceViewModel, c1 graphicsLayer) {
        float f;
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (watchPreferenceViewModel.P0()) {
            f = 1.0f;
        } else {
            f = 0.3f;
        }
        graphicsLayer.c(f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(-1963444625);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1963444625, i, -1, "com.dragon.read.kmp.mine.preference.WatchPreferencePageContent (WatchPreferencePage.kt:123)");
            }
            float g = x0.i.g(b + a);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: yj4.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int a0;
                        a0 = w.a0();
                        return Integer.valueOf(a0);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            CollapsibleListState u = CollapsibleListLayoutKt.u(g, e1.n(0, 0.0f, (Function0) rememberedValue, startRestartGroup, 390, 2), false, false, 0.0f, 0L, false, startRestartGroup, 6, 124);
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e o = aVar.o();
            Modifier.a aVar2 = Modifier.Companion;
            Modifier d2 = BackgroundKt.d(SizeKt.f(aVar2, 0.0f, 1, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).b(), (f2) null, 2, (Object) null);
            p0 i2 = androidx.compose.foundation.layout.m.i(o, false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, d2);
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
            int i3 = CollapsibleListState.q;
            A(u, startRestartGroup, i3);
            androidx.compose.ui.e o2 = aVar.o();
            Modifier f = SizeKt.f(aVar2, 0.0f, 1, (Object) null);
            p0 i4 = androidx.compose.foundation.layout.m.i(o2, false);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, f);
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
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, i4, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                b4.updateRememberedValue(Integer.valueOf(a4));
                b4.apply(Integer.valueOf(a4), b5);
            }
            g5.e(b4, e2, companion.d());
            CollapsibleListLayoutKt.g(androidx.compose.foundation.layout.f2.t(aVar2, c, 0.0f, 2, (Object) null), u, yj4.a.a.b(), androidx.compose.runtime.internal.t.e(-1843467553, true, new c(u), startRestartGroup, 54), androidx.compose.runtime.internal.t.e(-27980064, true, new d(u), startRestartGroup, 54), startRestartGroup, (i3 << 3) | 28038, 0);
            L(org.jetbrains.compose.resources.j.c(y6.z(x6.a), startRestartGroup, 0), u, startRestartGroup, i3 << 3);
            v(boxScopeInstance, startRestartGroup, 6);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: yj4.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit b0;
                    b0 = w.b0(i, (Composer) obj, ((Integer) obj2).intValue());
                    return b0;
                }
            });
        }
    }

    private static final void A(final CollapsibleListState collapsibleListState, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1472229880);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(collapsibleListState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsibleListState);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(1472229880, i2, -1, "com.dragon.read.kmp.mine.preference.HeaderBg (WatchPreferencePage.kt:324)");
            }
            final MutableState mutableState = collapsibleListState.a;
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.7f), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.a aVar = Modifier.Companion;
            Modifier b2 = AspectRatioKt.b(SizeKt.h(aVar, 0.0f, 1, (Object) null), B(mutableState2), false, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: yj4.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit D;
                        D = w.D(mutableState, (c1) obj);
                        return D;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier a2 = androidx.compose.ui.graphics.b1.a(b2, (Function1) rememberedValue2);
            p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, i4, companion2.c());
            g5.e(b3, currentCompositionLocalMap, companion2.e());
            Function2 b4 = companion2.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                b3.updateRememberedValue(Integer.valueOf(a3));
                b3.apply(Integer.valueOf(a3), b4);
            }
            g5.e(b3, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Pair pair = TuplesKt.to("img_689_preference_head_bg_2_light.png", "img_689_preference_head_bg_2_dark.png");
            startRestartGroup.startReplaceGroup(5004770);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: yj4.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit E;
                        E = w.E(mutableState2, ((Float) obj).floatValue());
                        return E;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            I(null, pair, (Function1) rememberedValue3, startRestartGroup, 432, 1);
            I(SizeKt.u(aVar, x0.i.g(334), x0.i.g(200)), TuplesKt.to("img_689_preference_head_fg_light.png", "img_689_preference_head_fg_dark.png"), null, startRestartGroup, 54, 4);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: yj4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit F;
                    F = w.F(collapsibleListState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return F;
                }
            });
        }
    }

    private static final void v(final androidx.compose.foundation.layout.r rVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        float f;
        List listOf;
        String c2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-536284014);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
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
                ComposerKt.traceEventStart(-536284014, i2, -1, "com.dragon.read.kmp.mine.preference.BottomBar (WatchPreferencePage.kt:247)");
            }
            HasDefaultViewModelProviderFactory c3 = f2.b.a.c(startRestartGroup, 6);
            if (c3 != null) {
                if (c3 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c3.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final WatchPreferenceViewModel watchPreferenceViewModel = (WatchPreferenceViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(WatchPreferenceViewModel.class), c3, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier i4 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(50));
                e.a aVar2 = androidx.compose.ui.e.a;
                Modifier b2 = rVar.b(i4, aVar2.b());
                og4.a aVar3 = og4.a.a;
                int i5 = og4.a.b;
                Modifier d2 = BackgroundKt.d(b2, aVar3.h(startRestartGroup, i5).l(), (f2) null, 2, (Object) null);
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, d2);
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
                g5.e(b3, i6, companion.c());
                g5.e(b3, currentCompositionLocalMap, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                    b3.updateRememberedValue(Integer.valueOf(a2));
                    b3.apply(Integer.valueOf(a2), b4);
                }
                g5.e(b3, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar3.h(startRestartGroup, i5).t(), (f2) null, 2, (Object) null), startRestartGroup, 0);
                Modifier s = androidx.compose.foundation.layout.f2.s(SizeKt.f(aVar, 0.0f, 1, (Object) null), c, x0.i.g(7));
                p0 b5 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar2.i(), startRestartGroup, 48);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
                g5.e(b6, b5, companion.c());
                g5.e(b6, currentCompositionLocalMap2, companion.e());
                Function2 b7 = companion.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a4))) {
                    b6.updateRememberedValue(Integer.valueOf(a4));
                    b6.apply(Integer.valueOf(a4), b7);
                }
                g5.e(b6, e2, companion.d());
                w2 w2Var = w2.b;
                if (watchPreferenceViewModel.N0() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Modifier d3 = SizeKt.d(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
                if (z2) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                Modifier a6 = androidx.compose.ui.draw.a.a(d3, f);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(watchPreferenceViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: yj4.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit w;
                            w = w.w(WatchPreferenceViewModel.this);
                            return w;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(a6, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                p0 i7 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, modifier);
                Function0 a8 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b8 = g5.b(startRestartGroup);
                g5.e(b8, i7, companion.c());
                g5.e(b8, currentCompositionLocalMap3, companion.e());
                Function2 b9 = companion.b();
                if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a7))) {
                    b8.updateRememberedValue(Integer.valueOf(a7));
                    b8.apply(Integer.valueOf(a7), b9);
                }
                g5.e(b8, e3, companion.d());
                x6 x6Var = x6.a;
                String c4 = org.jetbrains.compose.resources.j.c(y6.d(x6Var), startRestartGroup, 0);
                h.a aVar4 = w0.h.b;
                int a9 = aVar4.a();
                long h = x0.x.h(14);
                c0.a aVar5 = c0.b;
                a6.j(c4, (Modifier) null, aVar3.h(startRestartGroup, i5).k(), h, (y) null, aVar5.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a9), 0L, 0, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 3072, 122322);
                startRestartGroup.endNode();
                Modifier a10 = androidx.compose.ui.draw.e.a(SizeKt.d(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), k.g.c(x0.i.g(8)));
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance2 = startRestartGroup.changedInstance(watchPreferenceViewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: yj4.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit x;
                            x = w.x(WatchPreferenceViewModel.this, (c1) obj);
                            return x;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a11 = androidx.compose.ui.graphics.b1.a(a10, (Function1) rememberedValue2);
                c0.a aVar6 = androidx.compose.ui.graphics.c0.b;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(aVar3.h(startRestartGroup, i5).e()), l0.j(aVar3.h(startRestartGroup, i5).a())});
                Modifier b10 = BackgroundKt.b(a11, c0.a.d(aVar6, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (f2) null, 0.0f, 6, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance3 = startRestartGroup.changedInstance(watchPreferenceViewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: yj4.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit y;
                            y = w.y(WatchPreferenceViewModel.this);
                            return y;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(b10, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null);
                p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.e(), false);
                int a12 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(startRestartGroup, modifier2);
                Function0 a13 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a13);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b11 = g5.b(startRestartGroup);
                g5.e(b11, i8, companion.c());
                g5.e(b11, currentCompositionLocalMap4, companion.e());
                Function2 b12 = companion.b();
                if (b11.getInserting() || !Intrinsics.areEqual(b11.rememberedValue(), Integer.valueOf(a12))) {
                    b11.updateRememberedValue(Integer.valueOf(a12));
                    b11.apply(Integer.valueOf(a12), b12);
                }
                g5.e(b11, e4, companion.d());
                if (watchPreferenceViewModel.N0() > 0) {
                    startRestartGroup.startReplaceGroup(1997772418);
                    c2 = org.jetbrains.compose.resources.j.d(y6.s(x6Var), new Object[]{Integer.valueOf(watchPreferenceViewModel.N0())}, startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1997923760);
                    c2 = org.jetbrains.compose.resources.j.c(y6.r(x6Var), startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
                composer2 = startRestartGroup;
                a6.j(c2, (Modifier) null, aVar3.h(startRestartGroup, i5).r(), x0.x.h(14), (y) null, aVar5.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar4.a()), 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer2, 199680, 3072, 122322);
                composer2.endNode();
                composer2.endNode();
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
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: yj4.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit z3;
                    z3 = w.z(rVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return z3;
                }
            });
        }
    }

    private static final void G(final WatchPreferenceViewModel watchPreferenceViewModel, final float f, Composer composer, final int i) {
        int i2;
        boolean z;
        String str;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1867899345);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(watchPreferenceViewModel)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(f)) {
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
                ComposerKt.traceEventStart(1867899345, i2, -1, "com.dragon.read.kmp.mine.preference.HeaderFoldBgImage (WatchPreferencePage.kt:371)");
            }
            boolean d2 = d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
            wj4.a aVar = watchPreferenceViewModel.b;
            if (d2) {
                str = "img_689_preference_head_fold_bg_dark.png";
            } else {
                str = "img_689_preference_head_fold_bg_light.png";
            }
            String b2 = aVar.b(str);
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            nVar.a = androidx.compose.ui.layout.i.a.b();
            Unit unit = Unit.INSTANCE;
            LoadImageKt.g(b2, (String) null, nVar, androidx.compose.ui.draw.a.a(SizeKt.i(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), x0.i.g(b + a)), f), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: yj4.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit H;
                    H = w.H(WatchPreferenceViewModel.this, f, i, (Composer) obj, ((Integer) obj2).intValue());
                    return H;
                }
            });
        }
    }

    public static final void X(final wj4.c watchPreferencePageParams, final wj4.a iFunctionDepend, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(watchPreferencePageParams, "watchPreferencePageParams");
        Intrinsics.checkNotNullParameter(iFunctionDepend, "iFunctionDepend");
        Composer startRestartGroup = composer.startRestartGroup(-1814105918);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(watchPreferencePageParams)) {
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
                changedInstance = startRestartGroup.changed(iFunctionDepend);
            } else {
                changedInstance = startRestartGroup.changedInstance(iFunctionDepend);
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
                ComposerKt.traceEventStart(-1814105918, i2, -1, "com.dragon.read.kmp.mine.preference.WatchPreferencePage (WatchPreferencePage.kt:99)");
            }
            ym4.f.c("WatchPreferencePage", watchPreferencePageParams, androidx.compose.runtime.internal.t.e(-1557805321, true, new b(watchPreferencePageParams, iFunctionDepend), startRestartGroup, 54), startRestartGroup, ((i2 << 3) & 112) | 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: yj4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Y;
                    Y = w.Y(wj4.c.this, iFunctionDepend, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Y;
                }
            });
        }
    }

    private static final void L(final String str, final CollapsibleListState collapsibleListState, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        float coerceIn;
        final MutableState mutableState;
        boolean changedInstance;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-963632767);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
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
                changedInstance = startRestartGroup.changed(collapsibleListState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsibleListState);
            }
            if (changedInstance) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        int i5 = i2;
        if ((i5 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-963632767, i5, -1, "com.dragon.read.kmp.mine.preference.TopBar (WatchPreferencePage.kt:159)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final WatchPreferenceViewModel watchPreferenceViewModel = (WatchPreferenceViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(WatchPreferenceViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: yj4.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit M;
                            M = w.M(WatchPreferenceViewModel.this, mutableState2);
                            return M;
                        }
                    }, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState3 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                coerceIn = RangesKt___RangesKt.coerceIn(((Number) collapsibleListState.a.getValue()).floatValue() / pg4.j.d(x0.i.g(80), startRestartGroup, 6), 0.0f, 1.0f);
                ref$FloatRef.element = coerceIn;
                Modifier.a aVar = Modifier.Companion;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, h);
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
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, i6, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                float f = b;
                float f2 = a;
                Modifier a4 = androidx.compose.ui.graphics.b1.a(SizeKt.i(h2, x0.i.g(f + f2)), new Function1() { // from class: yj4.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit O;
                        O = w.O(Ref$FloatRef.this, (c1) obj);
                        return O;
                    }
                });
                og4.a aVar3 = og4.a.a;
                int i7 = og4.a.b;
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(a4, aVar3.h(startRestartGroup, i7).b(), (f2) null, 2, (Object) null), startRestartGroup, 0);
                G(watchPreferenceViewModel, ref$FloatRef.element, startRestartGroup, 0);
                Modifier h3 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                p0 a5 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
                int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, h3);
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
                Composer b4 = g5.b(startRestartGroup);
                g5.e(b4, a5, companion2.c());
                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                Function2 b5 = companion2.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                    b4.updateRememberedValue(Integer.valueOf(a6));
                    b4.apply(Integer.valueOf(a6), b5);
                }
                g5.e(b4, e2, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                startRestartGroup.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(aVar, f), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), f2), c, 0.0f, 2, (Object) null);
                p0 b6 = r2.b(eVar.h(), aVar2.i(), startRestartGroup, 48);
                int a8 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, t);
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
                Composer b7 = g5.b(startRestartGroup);
                g5.e(b7, b6, companion2.c());
                g5.e(b7, currentCompositionLocalMap3, companion2.e());
                Function2 b8 = companion2.b();
                if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a8))) {
                    b7.updateRememberedValue(Integer.valueOf(a8));
                    b7.apply(Integer.valueOf(a8), b8);
                }
                g5.e(b7, e3, companion2.d());
                w2 w2Var = w2.b;
                Modifier u = SizeKt.u(aVar, x0.i.g(12), x0.i.g(24));
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance2 = startRestartGroup.changedInstance(watchPreferenceViewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: yj4.s
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit P;
                            P = w.P(WatchPreferenceViewModel.this, mutableState3);
                            return P;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                z0.g(org.jetbrains.compose.resources.c.a(o1.h(w6.a), startRestartGroup, 0), "返回", ClickableKt.clickable-oSLSa3U$default(u, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar3.h(startRestartGroup, i7).k()), 0, startRestartGroup, 48, 184);
                a6.j(str, androidx.compose.ui.draw.a.a(SizeKt.F(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), aVar2.g(), false, 2, (Object) null), ref$FloatRef.element), aVar3.h(startRestartGroup, i7).k(), x0.x.h(18), (y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, (i5 & 14) | 199680, 3072, 122320);
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(1849434622);
                Object rememberedValue4 = composer2.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: yj4.t
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            boolean Q;
                            Q = w.Q();
                            return Boolean.valueOf(Q);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceGroup();
                ig4.e.e((Function0) rememberedValue4, N(mutableState3), composer2, 6);
                if (V(mutableState2)) {
                    x6 x6Var = x6.a;
                    String c3 = org.jetbrains.compose.resources.j.c(y6.o(x6Var), composer2, 0);
                    String c4 = org.jetbrains.compose.resources.j.c(y6.r(x6Var), composer2, 0);
                    String c5 = org.jetbrains.compose.resources.j.c(y6.p(x6Var), composer2, 0);
                    composer2.startReplaceGroup(-1633490746);
                    boolean changedInstance3 = composer2.changedInstance(watchPreferenceViewModel);
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (!changedInstance3 && rememberedValue5 != companion.getEmpty()) {
                        mutableState = mutableState2;
                    } else {
                        mutableState = mutableState2;
                        rememberedValue5 = new Function0() { // from class: yj4.u
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit R;
                                R = w.R(WatchPreferenceViewModel.this, mutableState);
                                return R;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    Function0 function0 = (Function0) rememberedValue5;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(5004770);
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: yj4.v
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit S;
                                S = w.S(mutableState);
                                return S;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    Function0 function02 = (Function0) rememberedValue6;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(5004770);
                    Object rememberedValue7 = composer2.rememberedValue();
                    if (rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: yj4.c
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit T;
                                T = w.T(mutableState);
                                return T;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue7);
                    }
                    composer2.endReplaceGroup();
                    hq4.f.f(c3, c4, c5, true, function0, function02, null, (Function0) rememberedValue7, null, composer2, 12782592, 320);
                }
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
            endRestartGroup.a(new Function2() { // from class: yj4.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit U;
                    U = w.U(str, collapsibleListState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return U;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void I(androidx.compose.ui.Modifier r16, final kotlin.Pair<java.lang.String, java.lang.String> r17, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yj4.w.I(androidx.compose.ui.Modifier, kotlin.Pair, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
