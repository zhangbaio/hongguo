package com.dragon.read.kmp.mine.profile;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.v2;
import androidx.compose.foundation.layout.w2;
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
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.mine.w6;
import com.dragon.read.component.biz.impl.mine.x6;
import com.dragon.read.component.biz.impl.mine.y6;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.mine.model.ChangeProfileItemPageViewModel;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ChangeProfileItemPageKt {

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(607727);
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
        Covode.recordClassIndex(607726);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(int i, Composer composer, int i2) {
        w(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(int i, Composer composer, int i2) {
        D(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(a0 a0Var, ProfileItemType profileItemType, x xVar, int i, int i2, Composer composer, int i3) {
        M(a0Var, profileItemType, xVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(int i, Composer composer, int i2) {
        Q(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(String str, int i, Composer composer, int i2) {
        Y(str, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final boolean o0(char c2) {
        if ('a' <= c2 && c2 < '{') {
            return true;
        }
        if ('A' <= c2 && c2 < '[') {
            return true;
        }
        return ('0' <= c2 && c2 < ':') || c2 == '.' || c2 == '_';
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ LifecycleOwner a;
        final /* synthetic */ LifecycleEventObserver b;
        final /* synthetic */ ChangeProfileItemPageViewModel c;

        public void dispose() {
            this.a.getLifecycle().removeObserver(this.b);
            this.c.S0();
        }

        public b(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver, ChangeProfileItemPageViewModel changeProfileItemPageViewModel) {
            this.a = lifecycleOwner;
            this.b = lifecycleEventObserver;
            this.c = changeProfileItemPageViewModel;
        }
    }

    private static final Function0<Unit> c0(MutableState<Function0<Unit>> mutableState) {
        return (Function0) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(ChangeProfileItemPageViewModel changeProfileItemPageViewModel) {
        changeProfileItemPageViewModel.W0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(MutableState mutableState) {
        a0(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(MutableState mutableState) {
        a0(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final int B(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    private static final boolean E(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final int G(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    private static final boolean R(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final int T(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    private static final boolean Z(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(MutableState mutableState) {
        a0(mutableState, false);
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    private static final void C(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final void F(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void H(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final void S(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void U(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final void a0(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ ChangeProfileItemPageViewModel a;
        final /* synthetic */ ProfileItemType b;

        /* renamed from: com.dragon.read.kmp.mine.profile.ChangeProfileItemPageKt$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0018a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ProfileItemType.values().length];
                try {
                    iArr[ProfileItemType.NICKNAME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ProfileItemType.SIGNATURE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ProfileItemType.ACCOUNTID.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        a(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, ProfileItemType profileItemType) {
            this.a = changeProfileItemPageViewModel;
            this.b = profileItemType;
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
                    ComposerKt.traceEventStart(1729615939, i, -1, "com.dragon.read.kmp.mine.profile.ChangeProfileItemPage.<anonymous> (ChangeProfileItemPage.kt:109)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
                ChangeProfileItemPageViewModel changeProfileItemPageViewModel = this.a;
                ProfileItemType profileItemType = this.b;
                e.m i2 = androidx.compose.foundation.layout.e.a.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, f);
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
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                Modifier i3 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(com.dragon.read.kmp.service.b1.a.s()));
                og4.a aVar3 = og4.a.a;
                int i4 = og4.a.b;
                a3.a(BackgroundKt.d(i3, aVar3.h(composer, i4).p3(), (f2) null, 2, (Object) null), composer, 0);
                Modifier d = BackgroundKt.d(SizeKt.f(aVar, 0.0f, 1, (Object) null), aVar3.h(composer, i4).p3(), (f2) null, 2, (Object) null);
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.m(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, d);
                Function0 a5 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a5);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, i5, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                ChangeProfileItemPageKt.Y(changeProfileItemPageViewModel.M0(), composer, 0);
                composer.startReplaceGroup(2124156399);
                if (profileItemType != null) {
                    int i6 = C0018a.a[profileItemType.ordinal()];
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                composer.startReplaceGroup(-1181787856);
                                composer.endReplaceGroup();
                            } else {
                                composer.startReplaceGroup(-1146502617);
                                ChangeProfileItemPageKt.w(composer, 0);
                                composer.endReplaceGroup();
                            }
                        } else {
                            composer.startReplaceGroup(-1146505081);
                            ChangeProfileItemPageKt.Q(composer, 0);
                            composer.endReplaceGroup();
                        }
                    } else {
                        composer.startReplaceGroup(-1146507390);
                        ChangeProfileItemPageKt.D(composer, 0);
                        composer.endReplaceGroup();
                    }
                }
                composer.endReplaceGroup();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, MutableState mutableState) {
        changeProfileItemPageViewModel.W0();
        a0(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, MutableState mutableState) {
        if (!changeProfileItemPageViewModel.Q0()) {
            zm4.d.a.b();
        } else {
            a0(mutableState, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, androidx.compose.runtime.MutableState<java.lang.String>] */
    public static final void D(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        final MutableState mutableState;
        v2 v2Var;
        MutableState mutableState2;
        int i2;
        og4.a aVar;
        Composer startRestartGroup = composer.startRestartGroup(-164065074);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-164065074, i, -1, "com.dragon.read.kmp.mine.profile.ChangeNameLayout (ChangeProfileItemPage.kt:316)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfileItemPageViewModel changeProfileItemPageViewModel = (ChangeProfileItemPageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfileItemPageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final a0 a0Var = changeProfileItemPageViewModel.a;
                final Context a2 = ig4.f.a(startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState3 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                final androidx.compose.ui.focus.n nVar = (androidx.compose.ui.focus.n) startRestartGroup.consume(CompositionLocalsKt.g());
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new FocusRequester();
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                FocusRequester focusRequester = (FocusRequester) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                String M0 = changeProfileItemPageViewModel.M0();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Integer.valueOf(((String) a0Var.d.getValue()).length()), (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                MutableState mutableState4 = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = a0Var.d;
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(5004770);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new ChangeProfileItemPageKt$ChangeNameLayout$1$1(focusRequester, null);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue4, startRestartGroup, 6);
                Modifier.a aVar2 = Modifier.Companion;
                float f = 16;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(aVar2, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(60), x0.i.g(f), 0.0f, 8, (Object) null);
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i3 = eVar.i();
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a3 = androidx.compose.foundation.layout.x.a(i3, aVar3.k(), startRestartGroup, 0);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                float f2 = 12;
                Modifier a6 = androidx.compose.ui.draw.e.a(SizeKt.B(SizeKt.h(aVar2, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), k.g.c(x0.i.g(f2)));
                og4.a aVar4 = og4.a.a;
                int i4 = og4.a.b;
                Modifier d = BackgroundKt.d(a6, aVar4.h(startRestartGroup, i4).w(), (f2) null, 2, (Object) null);
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, d);
                Function0 a8 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b4 = g5.b(startRestartGroup);
                g5.e(b4, i5, companion2.c());
                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                Function2 b5 = companion2.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a7))) {
                    b4.updateRememberedValue(Integer.valueOf(a7));
                    b4.apply(Integer.valueOf(a7), b5);
                }
                g5.e(b4, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier v2 = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, x0.i.g(105), 0.0f, 10, (Object) null);
                androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, v2);
                Function0 a10 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a10);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b6 = g5.b(startRestartGroup);
                g5.e(b6, i6, companion2.c());
                g5.e(b6, currentCompositionLocalMap3, companion2.e());
                Function2 b7 = companion2.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a9))) {
                    b6.updateRememberedValue(Integer.valueOf(a9));
                    b6.apply(Integer.valueOf(a9), b7);
                }
                g5.e(b6, e3, companion2.d());
                MutableState mutableState5 = (MutableState) ref$ObjectRef.element;
                MutableState<VerifyStatus> mutableState6 = a0Var.e;
                Modifier a11 = androidx.compose.ui.focus.y.a(SizeKt.h(aVar2, 0.0f, 1, (Object) null), focusRequester);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changed = startRestartGroup.changed(a0Var) | startRestartGroup.changedInstance(changeProfileItemPageViewModel) | startRestartGroup.changedInstance(a2);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit I;
                            I = ChangeProfileItemPageKt.I(a0.this, changeProfileItemPageViewModel, a2, mutableState3, (androidx.compose.ui.focus.c0) obj);
                            return I;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a12 = androidx.compose.ui.focus.c.a(a11, (Function1) rememberedValue5);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance = startRestartGroup.changedInstance(a2) | startRestartGroup.changed(a0Var) | startRestartGroup.changedInstance(changeProfileItemPageViewModel);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changedInstance && rememberedValue6 != companion.getEmpty()) {
                    mutableState = mutableState4;
                } else {
                    mutableState = mutableState4;
                    rememberedValue6 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            String J;
                            J = ChangeProfileItemPageKt.J(a2, a0Var, changeProfileItemPageViewModel, mutableState, (String) obj);
                            return J;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceGroup();
                final MutableState mutableState7 = mutableState;
                MineChangeProfilePageKt.h1(M0, mutableState5, null, mutableState6, 1, (Function1) rememberedValue6, a12, true, true, startRestartGroup, 113270784, 4);
                startRestartGroup.endNode();
                Modifier v3 = androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(SizeKt.D(aVar2, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.f()), 0.0f, 0.0f, x0.i.g(f), 0.0f, 11, (Object) null);
                androidx.compose.ui.layout.p0 b8 = r2.b(eVar.h(), aVar3.l(), startRestartGroup, 0);
                int a13 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(startRestartGroup, v3);
                Function0 a14 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a14);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b9 = g5.b(startRestartGroup);
                g5.e(b9, b8, companion2.c());
                g5.e(b9, currentCompositionLocalMap4, companion2.e());
                Function2 b10 = companion2.b();
                if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a13))) {
                    b9.updateRememberedValue(Integer.valueOf(a13));
                    b9.apply(Integer.valueOf(a13), b10);
                }
                g5.e(b9, e4, companion2.d());
                v2 v2Var2 = w2.b;
                startRestartGroup.startReplaceGroup(-1729990299);
                if (G(mutableState7) > 0) {
                    i2 = i4;
                    aVar = aVar4;
                    mutableState2 = mutableState7;
                    v2Var = v2Var2;
                    androidx.compose.foundation.z0.g(com.dragon.read.kmp.compose.common.image.e.a(com.dragon.read.component.biz.impl.mine.o1.m(w6.a), startRestartGroup, 0), "清除输入", ClickableKt.clickable-oSLSa3U$default(v2Var2.b(SizeKt.s(aVar2, x0.i.g(f)), aVar3.i()), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, new Function0() { // from class: com.dragon.read.kmp.mine.profile.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit K;
                            K = ChangeProfileItemPageKt.K(nVar, ref$ObjectRef, mutableState7);
                            return K;
                        }
                    }, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar4.h(startRestartGroup, i4).h(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
                    a3.a(v2Var.b(SizeKt.x(aVar2, x0.i.g(f)), aVar3.i()), startRestartGroup, 0);
                } else {
                    v2Var = v2Var2;
                    mutableState2 = mutableState7;
                    i2 = i4;
                    aVar = aVar4;
                }
                startRestartGroup.endReplaceGroup();
                String str = G(mutableState2) + "/10";
                Modifier b11 = v2Var.b(SizeKt.D(aVar2, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.i());
                c0.a aVar5 = androidx.compose.ui.text.font.c0.b;
                int i7 = i2;
                og4.a aVar6 = aVar;
                a6.j(str, b11, aVar6.h(startRestartGroup, i7).K(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar5.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131024);
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                a3.a(SizeKt.h(SizeKt.i(aVar2, x0.i.g(f2)), 0.0f, 1, (Object) null), startRestartGroup, 6);
                composer2 = startRestartGroup;
                a6.j("昵称请填写1-10个字符", androidx.compose.foundation.layout.f2.v(c0Var.b(SizeKt.D(aVar2, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.k()), x0.i.g(f), 0.0f, 0.0f, 0.0f, 14, (Object) null), aVar6.h(startRestartGroup, i7).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar5.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 131024);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit L;
                    L = ChangeProfileItemPageKt.L(i, (Composer) obj, ((Integer) obj2).intValue());
                    return L;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-795781699);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-795781699, i, -1, "com.dragon.read.kmp.mine.profile.ChangeSignatureLayout (ChangeProfileItemPage.kt:243)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfileItemPageViewModel changeProfileItemPageViewModel = (ChangeProfileItemPageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfileItemPageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final a0 a0Var = changeProfileItemPageViewModel.a;
                final Context a2 = ig4.f.a(startRestartGroup, 0);
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
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Integer.valueOf(((String) a0Var.g.getValue()).length()), (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new FocusRequester();
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                FocusRequester focusRequester = (FocusRequester) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(5004770);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new ChangeProfileItemPageKt$ChangeSignatureLayout$1$1(focusRequester, null);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue4, startRestartGroup, 6);
                Modifier.a aVar = Modifier.Companion;
                float f = 16;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(60), x0.i.g(f), 0.0f, 8, (Object) null);
                e.m i3 = androidx.compose.foundation.layout.e.a.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a3 = androidx.compose.foundation.layout.x.a(i3, aVar2.k(), startRestartGroup, 0);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                float f2 = 12;
                Modifier a6 = androidx.compose.ui.draw.e.a(SizeKt.k(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(142), 0.0f, 2, (Object) null), k.g.c(x0.i.g(f2)));
                og4.a aVar3 = og4.a.a;
                int i4 = og4.a.b;
                Modifier d = BackgroundKt.d(a6, aVar3.h(startRestartGroup, i4).w(), (f2) null, 2, (Object) null);
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, d);
                Function0 a8 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b4 = g5.b(startRestartGroup);
                g5.e(b4, i5, companion2.c());
                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                Function2 b5 = companion2.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a7))) {
                    b4.updateRememberedValue(Integer.valueOf(a7));
                    b4.apply(Integer.valueOf(a7), b5);
                }
                g5.e(b4, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier v2 = androidx.compose.foundation.layout.f2.v(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
                androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, v2);
                Function0 a10 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a10);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b6 = g5.b(startRestartGroup);
                g5.e(b6, i6, companion2.c());
                g5.e(b6, currentCompositionLocalMap3, companion2.e());
                Function2 b7 = companion2.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a9))) {
                    b6.updateRememberedValue(Integer.valueOf(a9));
                    b6.apply(Integer.valueOf(a9), b7);
                }
                g5.e(b6, e3, companion2.d());
                MutableState<String> mutableState3 = a0Var.g;
                MutableState<VerifyStatus> mutableState4 = a0Var.h;
                Modifier a11 = androidx.compose.ui.focus.y.a(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), focusRequester);
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance = startRestartGroup.changedInstance(changeProfileItemPageViewModel);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit V;
                            V = ChangeProfileItemPageKt.V(ChangeProfileItemPageViewModel.this, mutableState, (androidx.compose.ui.focus.c0) obj);
                            return V;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a12 = androidx.compose.ui.focus.c.a(a11, (Function1) rememberedValue5);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance2 = startRestartGroup.changedInstance(a2) | startRestartGroup.changed(a0Var) | startRestartGroup.changedInstance(changeProfileItemPageViewModel);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changedInstance2 && rememberedValue6 != companion.getEmpty()) {
                    i2 = 16;
                } else {
                    final int i7 = 100;
                    i2 = 16;
                    Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            String W;
                            W = ChangeProfileItemPageKt.W(i7, a2, a0Var, changeProfileItemPageViewModel, mutableState2, (String) obj);
                            return W;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function1);
                    rememberedValue6 = function1;
                }
                startRestartGroup.endReplaceGroup();
                MineChangeProfilePageKt.h1("签名", mutableState3, "介绍一下自己吧", mutableState4, 6, (Function1) rememberedValue6, a12, true, true, startRestartGroup, 113271174, 0);
                startRestartGroup.endNode();
                StringBuilder sb = new StringBuilder();
                sb.append(T(mutableState2));
                sb.append('/');
                sb.append(100);
                String sb2 = sb.toString();
                Modifier v3 = androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar2.c()), 0.0f, 0.0f, x0.i.g(f), x0.i.g(f), 3, (Object) null);
                c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
                a6.j(sb2, v3, aVar3.h(startRestartGroup, i4).K(), x0.x.h(i2), (androidx.compose.ui.text.font.y) null, aVar4.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131024);
                startRestartGroup.endNode();
                a3.a(SizeKt.h(SizeKt.i(aVar, x0.i.g(f2)), 0.0f, 1, (Object) null), startRestartGroup, 6);
                Modifier v4 = androidx.compose.foundation.layout.f2.v(c0Var.b(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar2.k()), x0.i.g(f), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                androidx.compose.ui.text.font.c0 h = aVar4.h();
                composer2 = startRestartGroup;
                a6.j("个人签名最多支持100个字符", v4, aVar3.h(startRestartGroup, i4).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, h, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131024);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit X;
                    X = ChangeProfileItemPageKt.X(i, (Composer) obj, ((Integer) obj2).intValue());
                    return X;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, androidx.compose.runtime.MutableState<java.lang.String>] */
    public static final void w(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        v2 v2Var;
        androidx.compose.ui.e eVar;
        MutableState mutableState;
        og4.a aVar;
        Composer startRestartGroup = composer.startRestartGroup(-1554029491);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1554029491, i, -1, "com.dragon.read.kmp.mine.profile.ChangeAccountIdLayout (ChangeProfileItemPage.kt:134)");
            }
            final Context a2 = ig4.f.a(startRestartGroup, 0);
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfileItemPageViewModel changeProfileItemPageViewModel = (ChangeProfileItemPageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfileItemPageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final a0 a0Var = changeProfileItemPageViewModel.a;
                final androidx.compose.ui.focus.n nVar = (androidx.compose.ui.focus.n) startRestartGroup.consume(CompositionLocalsKt.g());
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(Integer.valueOf(((String) a0Var.i.getValue()).length()), (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = a0Var.i;
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new FocusRequester();
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                FocusRequester focusRequester = (FocusRequester) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(5004770);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new ChangeProfileItemPageKt$ChangeAccountIdLayout$1$1(focusRequester, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue3, startRestartGroup, 6);
                Modifier.a aVar2 = Modifier.Companion;
                float f = 16;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(aVar2, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(60), x0.i.g(f), 0.0f, 8, (Object) null);
                androidx.compose.foundation.layout.e eVar2 = androidx.compose.foundation.layout.e.a;
                e.m i2 = eVar2.i();
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a3 = androidx.compose.foundation.layout.x.a(i2, aVar3.k(), startRestartGroup, 0);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
                float f2 = 12;
                Modifier a6 = androidx.compose.ui.draw.e.a(SizeKt.h(aVar2, 0.0f, 1, (Object) null), k.g.c(x0.i.g(f2)));
                og4.a aVar4 = og4.a.a;
                int i3 = og4.a.b;
                Modifier d = BackgroundKt.d(a6, aVar4.h(startRestartGroup, i3).w(), (f2) null, 2, (Object) null);
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, d);
                Function0 a8 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b4 = g5.b(startRestartGroup);
                g5.e(b4, i4, companion2.c());
                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                Function2 b5 = companion2.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a7))) {
                    b4.updateRememberedValue(Integer.valueOf(a7));
                    b4.apply(Integer.valueOf(a7), b5);
                }
                g5.e(b4, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier v2 = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar2, 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, x0.i.g(105), 0.0f, 10, (Object) null);
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, v2);
                Function0 a10 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a10);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b6 = g5.b(startRestartGroup);
                g5.e(b6, i5, companion2.c());
                g5.e(b6, currentCompositionLocalMap3, companion2.e());
                Function2 b7 = companion2.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a9))) {
                    b6.updateRememberedValue(Integer.valueOf(a9));
                    b6.apply(Integer.valueOf(a9), b7);
                }
                g5.e(b6, e3, companion2.d());
                String o5 = ek4.c.b.o5();
                MutableState<String> mutableState3 = a0Var.i;
                MutableState<VerifyStatus> mutableState4 = a0Var.j;
                Modifier a11 = androidx.compose.ui.focus.y.a(SizeKt.h(aVar2, 0.0f, 1, (Object) null), focusRequester);
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance = startRestartGroup.changedInstance(changeProfileItemPageViewModel) | startRestartGroup.changed(a0Var) | startRestartGroup.changedInstance(a2);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit x;
                            x = ChangeProfileItemPageKt.x(ChangeProfileItemPageViewModel.this, a0Var, a2, (androidx.compose.ui.focus.c0) obj);
                            return x;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a12 = androidx.compose.ui.focus.c.a(a11, (Function1) rememberedValue4);
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance2 = startRestartGroup.changedInstance(a2) | startRestartGroup.changed(a0Var) | startRestartGroup.changedInstance(changeProfileItemPageViewModel);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            String y;
                            y = ChangeProfileItemPageKt.y(a2, a0Var, changeProfileItemPageViewModel, mutableState2, (String) obj);
                            return y;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                int i6 = i3;
                MineChangeProfilePageKt.h1(o5, mutableState3, null, mutableState4, 1, (Function1) rememberedValue5, a12, true, true, startRestartGroup, 113270784, 4);
                startRestartGroup.endNode();
                Modifier v3 = androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(SizeKt.D(aVar2, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.f()), 0.0f, 0.0f, x0.i.g(f), 0.0f, 11, (Object) null);
                androidx.compose.ui.layout.p0 b8 = r2.b(eVar2.h(), aVar3.l(), startRestartGroup, 0);
                int a13 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(startRestartGroup, v3);
                Function0 a14 = companion2.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a14);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b9 = g5.b(startRestartGroup);
                g5.e(b9, b8, companion2.c());
                g5.e(b9, currentCompositionLocalMap4, companion2.e());
                Function2 b10 = companion2.b();
                if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a13))) {
                    b9.updateRememberedValue(Integer.valueOf(a13));
                    b9.apply(Integer.valueOf(a13), b10);
                }
                g5.e(b9, e4, companion2.d());
                v2 v2Var2 = w2.b;
                startRestartGroup.startReplaceGroup(740294500);
                if (B(mutableState2) > 0) {
                    androidx.compose.ui.graphics.e1 a15 = com.dragon.read.kmp.compose.common.image.e.a(com.dragon.read.component.biz.impl.mine.o1.m(w6.a), startRestartGroup, 0);
                    Modifier modifier = ClickableKt.clickable-oSLSa3U$default(v2Var2.b(SizeKt.s(aVar2, x0.i.g(f)), aVar3.i()), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, new Function0() { // from class: com.dragon.read.kmp.mine.profile.r
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit z2;
                            z2 = ChangeProfileItemPageKt.z(nVar, ref$ObjectRef, mutableState2);
                            return z2;
                        }
                    }, 15, (Object) null);
                    aVar = aVar4;
                    androidx.compose.ui.graphics.m0 c3 = m0.a.c(androidx.compose.ui.graphics.m0.b, aVar.h(startRestartGroup, i6).h(), 0, 2, (Object) null);
                    mutableState = mutableState2;
                    v2Var = v2Var2;
                    i6 = i6;
                    eVar = null;
                    androidx.compose.foundation.z0.g(a15, "清除输入", modifier, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, c3, 0, startRestartGroup, 48, 184);
                    a3.a(v2Var.b(SizeKt.x(aVar2, x0.i.g(f)), aVar3.i()), startRestartGroup, 0);
                } else {
                    v2Var = v2Var2;
                    eVar = null;
                    mutableState = mutableState2;
                    aVar = aVar4;
                }
                startRestartGroup.endReplaceGroup();
                String str = B(mutableState) + "/12";
                Modifier b11 = v2Var.b(SizeKt.D(aVar2, eVar, false, 3, eVar), aVar3.i());
                c0.a aVar5 = androidx.compose.ui.text.font.c0.b;
                int i7 = i6;
                a6.j(str, b11, aVar.h(startRestartGroup, i7).K(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar5.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131024);
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                a3.a(SizeKt.i(aVar2, x0.i.g(f2)), startRestartGroup, 6);
                composer2 = startRestartGroup;
                a6.j(qg4.k.b.w5(), androidx.compose.foundation.layout.f2.v(c0Var.b(SizeKt.D(aVar2, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.k()), x0.i.g(f), 0.0f, 0.0f, 0.0f, 14, (Object) null), aVar.h(startRestartGroup, i7).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, aVar5.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131024);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit A;
                    A = ChangeProfileItemPageKt.A(i, (Composer) obj, ((Integer) obj2).intValue());
                    return A;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(androidx.compose.ui.focus.n nVar, Ref$ObjectRef ref$ObjectRef, MutableState mutableState) {
        androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
        ((MutableState) ref$ObjectRef.element).setValue("");
        H(mutableState, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, MutableState mutableState, androidx.compose.ui.focus.c0 focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (!R(mutableState) && focusState.isFocused()) {
            changeProfileItemPageViewModel.Y0("character_sign");
        }
        S(mutableState, focusState.isFocused());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(androidx.compose.ui.focus.n nVar, Ref$ObjectRef ref$ObjectRef, MutableState mutableState) {
        androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
        ((MutableState) ref$ObjectRef.element).setValue("");
        C(mutableState, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(final String str, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        long h;
        final MutableState mutableState;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1461717431);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
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
                ComposerKt.traceEventStart(-1461717431, i2, -1, "com.dragon.read.kmp.mine.profile.TitleBar (ChangeProfileItemPage.kt:411)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfileItemPageViewModel changeProfileItemPageViewModel = (ChangeProfileItemPageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfileItemPageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
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
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: com.dragon.read.kmp.mine.profile.t
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit b0;
                            b0 = ChangeProfileItemPageKt.b0(ChangeProfileItemPageViewModel.this, mutableState2);
                            return b0;
                        }
                    }, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                MutableState mutableState3 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Modifier.a aVar = Modifier.Companion;
                float f = 16;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(44)), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
                og4.a aVar2 = og4.a.a;
                int i4 = og4.a.b;
                int i5 = i2;
                Modifier d = BackgroundKt.d(v, aVar2.h(startRestartGroup, i4).p3(), (f2) null, 2, (Object) null);
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, d);
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
                androidx.compose.foundation.z0.g(com.dragon.read.kmp.compose.common.image.e.a(d2.N(f2.a.a), startRestartGroup, 0), "返回键", ClickableKt.clickable-oSLSa3U$default(boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(24)), aVar3.h()), true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, c0(mutableState3), 14, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar2.h(startRestartGroup, i4).C(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
                Modifier b4 = boxScopeInstance.b(aVar, aVar3.e());
                c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
                a6.j(str, b4, aVar2.h(startRestartGroup, i4).C(), x0.x.h(18), (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, (i5 & 14) | 199680, 0, 131024);
                Modifier b5 = boxScopeInstance.b(aVar, aVar3.f());
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(5004770);
                boolean changedInstance = composer2.changedInstance(changeProfileItemPageViewModel);
                Object rememberedValue3 = composer2.rememberedValue();
                if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.u
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d0;
                            d0 = ChangeProfileItemPageKt.d0(ChangeProfileItemPageViewModel.this);
                            return d0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(b5, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 14, (Object) null);
                androidx.compose.ui.text.font.c0 i7 = aVar4.i();
                long h2 = x0.x.h(16);
                if (((Boolean) changeProfileItemPageViewModel.e.getValue()).booleanValue()) {
                    composer2.startReplaceGroup(1172865915);
                    h = aVar2.h(composer2, i4).C();
                } else {
                    composer2.startReplaceGroup(1172867157);
                    h = aVar2.h(composer2, i4).h();
                }
                composer2.endReplaceGroup();
                a6.j("保存", modifier, h, h2, (androidx.compose.ui.text.font.y) null, i7, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 131024);
                composer2.endNode();
                composer2.startReplaceGroup(1849434622);
                Object rememberedValue4 = composer2.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.v
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            boolean e0;
                            e0 = ChangeProfileItemPageKt.e0();
                            return Boolean.valueOf(e0);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceGroup();
                ig4.e.e((Function0) rememberedValue4, c0(mutableState3), composer2, 6);
                if (Z(mutableState2)) {
                    x6 x6Var = x6.a;
                    String c3 = org.jetbrains.compose.resources.j.c(y6.o(x6Var), composer2, 0);
                    String c4 = org.jetbrains.compose.resources.j.c(y6.r(x6Var), composer2, 0);
                    String c5 = org.jetbrains.compose.resources.j.c(y6.p(x6Var), composer2, 0);
                    composer2.startReplaceGroup(-1633490746);
                    boolean changedInstance2 = composer2.changedInstance(changeProfileItemPageViewModel);
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (!changedInstance2 && rememberedValue5 != companion.getEmpty()) {
                        mutableState = mutableState2;
                    } else {
                        mutableState = mutableState2;
                        rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.b
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit f0;
                                f0 = ChangeProfileItemPageKt.f0(ChangeProfileItemPageViewModel.this, mutableState);
                                return f0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    Function0 function0 = (Function0) rememberedValue5;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(5004770);
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.c
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit g0;
                                g0 = ChangeProfileItemPageKt.g0(mutableState);
                                return g0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    Function0 function02 = (Function0) rememberedValue6;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(5004770);
                    Object rememberedValue7 = composer2.rememberedValue();
                    if (rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.d
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit h0;
                                h0 = ChangeProfileItemPageKt.h0(mutableState);
                                return h0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue7);
                    }
                    Function0 function03 = (Function0) rememberedValue7;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(5004770);
                    Object rememberedValue8 = composer2.rememberedValue();
                    if (rememberedValue8 == companion.getEmpty()) {
                        rememberedValue8 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.e
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit i0;
                                i0 = ChangeProfileItemPageKt.i0(mutableState);
                                return i0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue8);
                    }
                    composer2.endReplaceGroup();
                    hq4.f.f(c3, c4, c5, false, function0, function02, function03, (Function0) rememberedValue8, null, composer2, 14352384, 264);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j0;
                    j0 = ChangeProfileItemPageKt.j0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                    return j0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(androidx.compose.ui.focus.n nVar, ChangeProfileItemPageViewModel changeProfileItemPageViewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = c.a[event.ordinal()];
        if (i != 1) {
            if (i == 2) {
                changeProfileItemPageViewModel.U0();
            }
        } else {
            nVar.u(true);
            changeProfileItemPageViewModel.V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, a0 a0Var, Context context, androidx.compose.ui.focus.c0 focusState) {
        boolean z;
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (changeProfileItemPageViewModel.k && !focusState.isFocused() && changeProfileItemPageViewModel.f) {
            if (((CharSequence) a0Var.i.getValue()).length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ig4.g.d(context, ek4.c.b.o5() + "不能为空", (ToastDuration) null, 4, (Object) null);
            } else if (((String) a0Var.i.getValue()).length() < 8) {
                ig4.g.d(context, ek4.c.b.o5() + "未满8字符", (ToastDuration) null, 4, (Object) null);
            }
        }
        if (!changeProfileItemPageViewModel.k && focusState.isFocused()) {
            changeProfileItemPageViewModel.Y0("hongguo_id");
        }
        changeProfileItemPageViewModel.k = focusState.isFocused();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult N(LifecycleOwner lifecycleOwner, final ChangeProfileItemPageViewModel changeProfileItemPageViewModel, CoroutineScope coroutineScope, final androidx.compose.ui.focus.n nVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.dragon.read.kmp.mine.profile.o
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                ChangeProfileItemPageKt.O(nVar, changeProfileItemPageViewModel, lifecycleOwner2, event);
            }
        };
        if (com.dragon.read.kmp.service.g0.a.c()) {
            ig4.g.b("kmp page", (ToastDuration) null, 2, (Object) null);
        }
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        changeProfileItemPageViewModel.R0(coroutineScope);
        return new b(lifecycleOwner, lifecycleEventObserver, changeProfileItemPageViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(a0 a0Var, ChangeProfileItemPageViewModel changeProfileItemPageViewModel, Context context, MutableState mutableState, androidx.compose.ui.focus.c0 focusState) {
        boolean z;
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (E(mutableState) && !focusState.isFocused()) {
            if (((CharSequence) a0Var.d.getValue()).length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && changeProfileItemPageViewModel.f) {
                ig4.g.d(context, "昵称不能为空", (ToastDuration) null, 4, (Object) null);
            }
        }
        if (!E(mutableState) && focusState.isFocused()) {
            changeProfileItemPageViewModel.Y0("nickname");
        }
        F(mutableState, focusState.isFocused());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.CharSequence] */
    public static final String J(Context context, a0 a0Var, ChangeProfileItemPageViewModel changeProfileItemPageViewModel, MutableState mutableState, String it2) {
        String str;
        IntRange until;
        ?? subSequence;
        Intrinsics.checkNotNullParameter(it2, "it");
        com.dragon.read.kmp.j.a.d("ChangeProfileItemPage", "onUserNameEditValueChange, it = " + it2);
        if (it2.length() > 10) {
            ig4.g.d(context, "最多输入10个字符", (ToastDuration) null, 4, (Object) null);
            until = RangesKt___RangesKt.until(0, 10);
            subSequence = StringsKt__StringsKt.subSequence(it2, until);
            str = subSequence;
        } else {
            boolean startsWith$default = StringsKt__StringsJVMKt.startsWith$default(it2, " ", false, 2, null);
            str = it2;
            if (startsWith$default) {
                str = StringsKt__StringsKt.trimStart((CharSequence) it2).toString();
            }
        }
        if (G(mutableState) != str.length()) {
            H(mutableState, str.length());
        }
        a0Var.d.setValue(str.toString());
        changeProfileItemPageViewModel.T0();
        return str.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y(Context context, a0 a0Var, ChangeProfileItemPageViewModel changeProfileItemPageViewModel, MutableState mutableState, String it2) {
        boolean z;
        String str;
        IntRange until;
        Intrinsics.checkNotNullParameter(it2, "it");
        com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "onBizUserIdEditValueChange, it = " + it2);
        int i = 0;
        while (true) {
            if (i < it2.length()) {
                z = true;
                if (!o0(it2.charAt(i))) {
                    break;
                }
                i++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            int length = it2.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = it2.charAt(i2);
                if (o0(charAt)) {
                    sb.append(charAt);
                }
            }
            it2 = sb.toString();
            str = "暂不支持特殊字符";
        } else {
            str = "";
        }
        if (it2.length() > 12) {
            if (!StringUtilsKt.a(str)) {
                str = "最多输入12个字符";
            }
            until = RangesKt___RangesKt.until(0, 12);
            it2 = StringsKt__StringsKt.substring(it2, until);
        }
        if (B(mutableState) != it2.length()) {
            C(mutableState, it2.length());
        }
        if (StringUtilsKt.a(str)) {
            ig4.g.d(context, str, (ToastDuration) null, 4, (Object) null);
        }
        a0Var.i.setValue(it2);
        if (a0Var.j.getValue() == VerifyStatus.FAILED) {
            a0Var.j.setValue(VerifyStatus.NOT_VERIFY);
        }
        changeProfileItemPageViewModel.T0();
        return it2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.CharSequence] */
    public static final String W(int i, Context context, a0 a0Var, ChangeProfileItemPageViewModel changeProfileItemPageViewModel, MutableState mutableState, String it2) {
        IntRange until;
        ?? subSequence;
        Intrinsics.checkNotNullParameter(it2, "it");
        com.dragon.read.kmp.j.a.d("ChangeProfileItemPageViewModel", "onDescriptionEditValueChange, it = " + it2);
        int length = it2.length();
        String str = it2;
        if (length > i) {
            ig4.g.d(context, "最多输入" + i + "个字", (ToastDuration) null, 4, (Object) null);
            until = RangesKt___RangesKt.until(0, i);
            subSequence = StringsKt__StringsKt.subSequence(it2, until);
            str = subSequence;
        }
        if (T(mutableState) != str.length()) {
            U(mutableState, str.length());
        }
        if (a0Var.h.getValue() == VerifyStatus.FAILED) {
            a0Var.h.setValue(VerifyStatus.NOT_VERIFY);
        }
        a0Var.g.setValue(str.toString());
        changeProfileItemPageViewModel.T0();
        return str.toString();
    }

    public static final void M(final a0 userInfo, ProfileItemType profileItemType, final x itemPagePageDepend, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int ordinal;
        int i5;
        boolean changedInstance;
        int i6;
        boolean z;
        ProfileItemType profileItemType2;
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(itemPagePageDepend, "itemPagePageDepend");
        Composer startRestartGroup = composer.startRestartGroup(-893881580);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(userInfo)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (profileItemType == null) {
                ordinal = -1;
            } else {
                ordinal = profileItemType.ordinal();
            }
            if (startRestartGroup.changed(ordinal)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance = startRestartGroup.changed(itemPagePageDepend);
            } else {
                changedInstance = startRestartGroup.changedInstance(itemPagePageDepend);
            }
            if (changedInstance) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i7 != 0) {
                profileItemType2 = null;
            } else {
                profileItemType2 = profileItemType;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-893881580, i3, -1, "com.dragon.read.kmp.mine.profile.ChangeProfileItemPage (ChangeProfileItemPage.kt:80)");
            }
            com.dragon.read.kmp.mine.model.c cVar = new com.dragon.read.kmp.mine.model.c(userInfo, profileItemType2, itemPagePageDepend);
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfileItemPageViewModel changeProfileItemPageViewModel = (ChangeProfileItemPageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfileItemPageViewModel.class), c2, (String) null, cVar, creationExtras, startRestartGroup, 0, 0);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                final LifecycleOwner lifecycleOwner = (LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                final androidx.compose.ui.focus.n nVar = (androidx.compose.ui.focus.n) startRestartGroup.consume(CompositionLocalsKt.g());
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(-1224400529);
                boolean changedInstance2 = startRestartGroup.changedInstance(nVar) | startRestartGroup.changedInstance(changeProfileItemPageViewModel) | startRestartGroup.changedInstance(lifecycleOwner) | startRestartGroup.changedInstance(coroutineScope);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DisposableEffectResult N;
                            N = ChangeProfileItemPageKt.N(lifecycleOwner, changeProfileItemPageViewModel, coroutineScope, nVar, (DisposableEffectScope) obj);
                            return N;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, startRestartGroup, 6);
                pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(1729615939, true, new a(changeProfileItemPageViewModel, profileItemType2), startRestartGroup, 54), startRestartGroup, 48, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            profileItemType2 = profileItemType;
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final ProfileItemType profileItemType3 = profileItemType2;
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit P;
                    P = ChangeProfileItemPageKt.P(a0.this, profileItemType3, itemPagePageDepend, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return P;
                }
            });
        }
    }
}
