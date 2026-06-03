package com.dragon.read.kmp.mine.profile;

import android.content.Context;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.a6;
import androidx.compose.material.n2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.u2;
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
import com.bytedance.kmp.reading.model.Gender;
import com.dragon.read.component.biz.impl.mine.w6;
import com.dragon.read.component.biz.impl.mine.x6;
import com.dragon.read.component.biz.impl.mine.y6;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MineChangeProfilePageKt {
    private static final String a;

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            Covode.recordClassIndex(607735);
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
            int[] iArr2 = new int[Gender.values().length];
            try {
                iArr2[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Gender.NOSET.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
            int[] iArr3 = new int[VerifyStatus.values().length];
            try {
                iArr3[VerifyStatus.REVIEWING.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[VerifyStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            c = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(a0 a0Var, n2 n2Var, int i, Composer composer, int i2) {
        z0(a0Var, n2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final boolean D1(char c2) {
        if ('a' <= c2 && c2 < '{') {
            return true;
        }
        if ('A' <= c2 && c2 < '[') {
            return true;
        }
        return ('0' <= c2 && c2 < ':') || c2 == '.' || c2 == '_';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(a0 a0Var, y yVar, z zVar, int i, int i2, Composer composer, int i3) {
        C0(a0Var, yVar, zVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(a0 a0Var, n2 n2Var, int i, Composer composer, int i2) {
        H0(a0Var, n2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(a0 a0Var, n2 n2Var, int i, Composer composer, int i2) {
        M0(a0Var, n2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(a0 a0Var, int i, Composer composer, int i2) {
        Z(a0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(int i, Composer composer, int i2) {
        c0(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(ChangeProfilePageViewModel changeProfilePageViewModel, a0 a0Var, int i, Composer composer, int i2) {
        f0(changeProfilePageViewModel, a0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(a0 a0Var, n2 n2Var, int i, Composer composer, int i2) {
        X0(a0Var, n2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(String str, MutableState mutableState, String str2, MutableState mutableState2, int i, Function1 function1, Modifier modifier, boolean z, boolean z2, int i2, int i3, Composer composer, int i4) {
        h1(str, mutableState, str2, mutableState2, i, function1, modifier, z, z2, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(String str, String str2, String str3, Modifier modifier, int i, MutableState mutableState, boolean z, int i2, int i3, Composer composer, int i4) {
        j1(str, str2, str3, modifier, i, mutableState, z, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(a0 a0Var, int i, Composer composer, int i2) {
        i0(a0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(a0 a0Var, int i, Composer composer, int i2) {
        m0(a0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(a0 a0Var, n2 n2Var, int i, Composer composer, int i2) {
        r0(a0Var, n2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(int i, Composer composer, int i2) {
        l1(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(a0 a0Var, n2 n2Var, int i, Composer composer, int i2) {
        v0(a0Var, n2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(607734);
        a = "ChangeProfilePageViewModel";
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ LifecycleOwner a;
        final /* synthetic */ LifecycleEventObserver b;
        final /* synthetic */ ChangeProfilePageViewModel c;

        public void dispose() {
            this.a.getLifecycle().removeObserver(this.b);
            this.c.f1();
            com.dragon.read.kmp.j.a.d(MineChangeProfilePageKt.a, "MineChangeProfilePage onDestroy");
        }

        public b(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver, ChangeProfilePageViewModel changeProfilePageViewModel) {
            this.a = lifecycleOwner;
            this.b = lifecycleEventObserver;
            this.c = changeProfilePageViewModel;
        }
    }

    private static final Gender N0(MutableState<Gender> mutableState) {
        return (Gender) mutableState.getValue();
    }

    private static final Function0<Unit> p1(MutableState<Function0<Unit>> mutableState) {
        return (Function0) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(u2 u2Var) {
        if (u2Var != null) {
            u2Var.hide();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(MutableState mutableState) {
        n1(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(MutableState mutableState) {
        n1(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(ChangeProfilePageViewModel changeProfilePageViewModel) {
        changeProfilePageViewModel.d1();
        changeProfilePageViewModel.o1("profile_decoration");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(ChangeProfilePageViewModel changeProfilePageViewModel) {
        if (changeProfilePageViewModel.S0()) {
            changeProfilePageViewModel.j1(false, ProfileItemType.GENDER);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(ChangeProfilePageViewModel changeProfilePageViewModel) {
        changeProfilePageViewModel.j1(false, ProfileItemType.GENDER);
        changeProfilePageViewModel.p.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(ChangeProfilePageViewModel changeProfilePageViewModel) {
        changeProfilePageViewModel.p.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(ChangeProfilePageViewModel changeProfilePageViewModel) {
        changeProfilePageViewModel.p.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private static final boolean Y0(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final boolean a1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(ChangeProfilePageViewModel changeProfilePageViewModel) {
        changeProfilePageViewModel.d1();
        changeProfilePageViewModel.o1("profile_decoration");
        return Unit.INSTANCE;
    }

    private static final boolean m1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(ChangeProfilePageViewModel changeProfilePageViewModel) {
        ChangeProfilePageViewModel.k1(changeProfilePageViewModel, false, null, 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(MutableState mutableState) {
        n1(mutableState, false);
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    private static final float u0(State<x0.i> state) {
        return ((x0.i) state.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(MutableState<Gender> mutableState, Gender gender) {
        mutableState.setValue(gender);
    }

    private static final void Z0(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void b1(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void n1(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ n2 a;
        final /* synthetic */ ChangeProfilePageViewModel b;
        final /* synthetic */ a0 c;

        a(n2 n2Var, ChangeProfilePageViewModel changeProfilePageViewModel, a0 a0Var) {
            this.a = n2Var;
            this.b = changeProfilePageViewModel;
            this.c = a0Var;
        }

        static final class b implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ a0 a;
            final /* synthetic */ n2 b;

            b(a0 a0Var, n2 n2Var) {
                this.a = a0Var;
                this.b = n2Var;
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
                        ComposerKt.traceEventStart(-426235746, i, -1, "com.dragon.read.kmp.mine.profile.MineChangeProfilePage.<anonymous>.<anonymous> (MineChangeProfilePage.kt:230)");
                    }
                    MineChangeProfilePageKt.r0(this.a, this.b, composer, n2.e << 3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
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
                    ComposerKt.traceEventStart(-473815177, i, -1, "com.dragon.read.kmp.mine.profile.MineChangeProfilePage.<anonymous> (MineChangeProfilePage.kt:219)");
                }
                long g = androidx.compose.ui.graphics.l0.b.g();
                androidx.compose.runtime.internal.a e = androidx.compose.runtime.internal.t.e(-187467099, true, new C0019a(this.b, this.c, this.a), composer, 54);
                n2 n2Var = this.a;
                ModalBottomSheetKt.p(e, (Modifier) null, n2Var, false, (f2) null, 0.0f, g, 0L, 0L, androidx.compose.runtime.internal.t.e(-426235746, true, new b(this.c, n2Var), composer, 54), composer, (n2.e << 6) | 806879238, 442);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* renamed from: com.dragon.read.kmp.mine.profile.MineChangeProfilePageKt$a$a, reason: collision with other inner class name */
        static final class C0019a implements Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit> {
            final /* synthetic */ ChangeProfilePageViewModel a;
            final /* synthetic */ a0 b;
            final /* synthetic */ n2 c;

            C0019a(ChangeProfilePageViewModel changeProfilePageViewModel, a0 a0Var, n2 n2Var) {
                this.a = changeProfilePageViewModel;
                this.b = a0Var;
                this.c = n2Var;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.b0 b0Var, Composer composer, Integer num) {
                a(b0Var, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void a(androidx.compose.foundation.layout.b0 ModalBottomSheetLayout, Composer composer, int i) {
                boolean z;
                Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
                if ((i & 17) != 16) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-187467099, i, -1, "com.dragon.read.kmp.mine.profile.MineChangeProfilePage.<anonymous>.<anonymous> (MineChangeProfilePage.kt:223)");
                    }
                    if (this.a.z1()) {
                        composer.startReplaceGroup(-1374800406);
                        MineChangeProfilePageKt.M0(this.b, this.c, composer, n2.e << 3);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-1374712211);
                        MineChangeProfilePageKt.v0(this.b, this.c, composer, n2.e << 3);
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
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
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
                    ComposerKt.traceEventStart(1922524626, i, -1, "com.dragon.read.kmp.mine.profile.ProfileLayout.<anonymous>.<anonymous>.<anonymous> (MineChangeProfilePage.kt:995)");
                }
                androidx.compose.ui.text.font.c0 h = androidx.compose.ui.text.font.c0.b.h();
                long h2 = x0.x.h(16);
                a6.j(this.a, (Modifier) null, og4.a.a.h(composer, og4.a.b).K(), h2, (androidx.compose.ui.text.font.y) null, h, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131026);
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
    public static final Unit s1(ChangeProfilePageViewModel changeProfilePageViewModel, MutableState mutableState) {
        ChangeProfilePageViewModel.k1(changeProfilePageViewModel, false, null, 3, null);
        n1(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F0(ChangeProfilePageViewModel changeProfilePageViewModel, ModalBottomSheetValue targetValue) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        if (changeProfilePageViewModel.o && targetValue == ModalBottomSheetValue.Hidden && changeProfilePageViewModel.s1()) {
            changeProfilePageViewModel.p.setValue(Boolean.TRUE);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(ChangeProfilePageViewModel changeProfilePageViewModel, MutableState mutableState) {
        if (changeProfilePageViewModel.Z0() && !changeProfilePageViewModel.z1()) {
            n1(mutableState, true);
        } else {
            zm4.d.a.b();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(ChangeProfilePageViewModel changeProfilePageViewModel, n2 n2Var) {
        kotlinx.coroutines.i.e(changeProfilePageViewModel.f, sh4.d.a(), null, new MineChangeProfilePageKt$GenderBottomDialog$1$2$1$1(n2Var, null), 2, null);
        return Unit.INSTANCE;
    }

    private static final String C1(Gender gender, boolean z) {
        int i = d.b[gender.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (z) {
                        return "暂不设置";
                    }
                    return "选择性别";
                }
                throw new NoWhenBranchMatchedException();
            }
            return "男";
        }
        return "女";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(ChangeProfilePageViewModel changeProfilePageViewModel, a0 a0Var) {
        changeProfilePageViewModel.c1();
        if (changeProfilePageViewModel.z1() && a0Var.c.getValue() == VerifyStatus.FAILED) {
            a0Var.c.setValue(VerifyStatus.NOT_VERIFY);
            changeProfilePageViewModel.n1(ProfileItemType.AVATAR, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(ChangeProfilePageViewModel changeProfilePageViewModel, androidx.compose.ui.layout.w layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        int intBitsToFloat = (int) Float.intBitsToFloat((int) (androidx.compose.ui.layout.x.g(layoutCoordinates) & 4294967295L));
        com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "onGloballyPositioned, height = " + ((int) (layoutCoordinates.a() & 4294967295L)) + ", y = " + intBitsToFloat);
        changeProfilePageViewModel.k = intBitsToFloat;
        changeProfilePageViewModel.l = (int) (layoutCoordinates.a() & 4294967295L);
        return Unit.INSTANCE;
    }

    public static final void c0(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        Composer startRestartGroup = composer.startRestartGroup(-403840568);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-403840568, i, -1, "com.dragon.read.kmp.mine.profile.AvatarPendantLayout (MineChangeProfilePage.kt:772)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Modifier.a aVar = Modifier.Companion;
                float f = 16;
                Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(f), 1, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.profile.r1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d0;
                            d0 = MineChangeProfilePageKt.d0(ChangeProfilePageViewModel.this);
                            return d0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                e.e h = androidx.compose.foundation.layout.e.a.h();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 b2 = r2.b(h, aVar2.l(), startRestartGroup, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
                g5.e(b3, b2, companion.c());
                g5.e(b3, currentCompositionLocalMap, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                    b3.updateRememberedValue(Integer.valueOf(a2));
                    b3.apply(Integer.valueOf(a2), b4);
                }
                g5.e(b3, e, companion.d());
                w2 w2Var = w2.b;
                Modifier D = SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null);
                androidx.compose.ui.text.font.c0 h2 = androidx.compose.ui.text.font.c0.b.h();
                long h3 = x0.x.h(16);
                og4.a aVar3 = og4.a.a;
                int i2 = og4.a.b;
                a6.j("头像挂件", D, aVar3.h(startRestartGroup, i2).h(), h3, (androidx.compose.ui.text.font.y) null, h2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199734, 0, 131024);
                Modifier h4 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                composer2 = startRestartGroup;
                int a4 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer2, h4);
                Function0 a5 = companion.a();
                if (!(composer2.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(a5);
                } else {
                    composer2.useNode();
                }
                Composer b5 = g5.b(composer2);
                g5.e(b5, i3, companion.c());
                g5.e(b5, currentCompositionLocalMap2, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                    b5.updateRememberedValue(Integer.valueOf(a4));
                    b5.apply(Integer.valueOf(a4), b6);
                }
                g5.e(b5, e2, companion.d());
                androidx.compose.foundation.z0.g(com.dragon.read.kmp.compose.common.image.e.a(d2.F(f2.a.a), composer2, 0), "global_next", BoxScopeInstance.a.b(SizeKt.u(aVar, x0.i.g(f), x0.i.g(f)), aVar2.f()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar3.h(composer2, i2).K(), 0, 2, (Object) null), 0, composer2, 48, 184);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.s1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e0;
                    e0 = MineChangeProfilePageKt.e0(i, (Composer) obj, ((Integer) obj2).intValue());
                    return e0;
                }
            });
        }
    }

    private static final void l1(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        Composer composer3;
        final MutableState mutableState;
        long h;
        Composer startRestartGroup = composer.startRestartGroup(-321382050);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-321382050, i, -1, "com.dragon.read.kmp.mine.profile.TitleBar (MineChangeProfilePage.kt:1063)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
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
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(new Function0() { // from class: com.dragon.read.kmp.mine.profile.q0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit o1;
                            o1 = MineChangeProfilePageKt.o1(ChangeProfilePageViewModel.this, mutableState2);
                            return o1;
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
                int i2 = og4.a.b;
                Modifier d2 = BackgroundKt.d(v, aVar2.h(startRestartGroup, i2).p3(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, d2);
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
                g5.e(b2, i3, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                androidx.compose.foundation.z0.g(com.dragon.read.kmp.compose.common.image.e.a(d2.N(f2.a.a), startRestartGroup, 0), "返回键", ClickableKt.clickable-oSLSa3U$default(boxScopeInstance.b(SizeKt.s(aVar, x0.i.g(24)), aVar3.h()), true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, p1(mutableState3), 14, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar2.h(startRestartGroup, i2).k(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
                Modifier b4 = boxScopeInstance.b(aVar, aVar3.e());
                c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
                a6.j("个人信息编辑", b4, aVar2.h(startRestartGroup, i2).C(), x0.x.h(18), (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131024);
                startRestartGroup.startReplaceGroup(-1023570988);
                if (!changeProfilePageViewModel.z1()) {
                    Modifier b5 = boxScopeInstance.b(aVar, aVar3.f());
                    startRestartGroup.startReplaceGroup(5004770);
                    boolean changedInstance = startRestartGroup.changedInstance(changeProfilePageViewModel);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.r0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit q1;
                                q1 = MineChangeProfilePageKt.q1(ChangeProfilePageViewModel.this);
                                return q1;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier = ClickableKt.clickable-oSLSa3U$default(b5, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 14, (Object) null);
                    androidx.compose.ui.text.font.c0 i4 = aVar4.i();
                    long h2 = x0.x.h(16);
                    if (((Boolean) changeProfilePageViewModel.e.getValue()).booleanValue()) {
                        startRestartGroup.startReplaceGroup(-1023558801);
                        h = aVar2.h(startRestartGroup, i2).f();
                    } else {
                        startRestartGroup.startReplaceGroup(-1023557590);
                        h = aVar2.h(startRestartGroup, i2).h();
                    }
                    startRestartGroup.endReplaceGroup();
                    composer3 = startRestartGroup;
                    a6.j("保存", modifier, h, h2, (androidx.compose.ui.text.font.y) null, i4, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer3, 199686, 0, 131024);
                } else {
                    composer3 = startRestartGroup;
                }
                composer3.endReplaceGroup();
                composer3.endNode();
                composer2 = composer3;
                composer2.startReplaceGroup(1849434622);
                Object rememberedValue4 = composer2.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.s0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            boolean r1;
                            r1 = MineChangeProfilePageKt.r1();
                            return Boolean.valueOf(r1);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceGroup();
                ig4.e.e((Function0) rememberedValue4, p1(mutableState3), composer2, 6);
                if (m1(mutableState2)) {
                    x6 x6Var = x6.a;
                    String c3 = org.jetbrains.compose.resources.j.c(y6.o(x6Var), composer2, 0);
                    String c4 = org.jetbrains.compose.resources.j.c(y6.r(x6Var), composer2, 0);
                    String c5 = org.jetbrains.compose.resources.j.c(y6.p(x6Var), composer2, 0);
                    composer2.startReplaceGroup(-1633490746);
                    boolean changedInstance2 = composer2.changedInstance(changeProfilePageViewModel);
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (!changedInstance2 && rememberedValue5 != companion.getEmpty()) {
                        mutableState = mutableState2;
                    } else {
                        mutableState = mutableState2;
                        rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.t0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit s1;
                                s1 = MineChangeProfilePageKt.s1(ChangeProfilePageViewModel.this, mutableState);
                                return s1;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    Function0 function0 = (Function0) rememberedValue5;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(5004770);
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.u0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit t1;
                                t1 = MineChangeProfilePageKt.t1(mutableState);
                                return t1;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    Function0 function02 = (Function0) rememberedValue6;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(5004770);
                    Object rememberedValue7 = composer2.rememberedValue();
                    if (rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.v0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit u1;
                                u1 = MineChangeProfilePageKt.u1(mutableState);
                                return u1;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue7);
                    }
                    Function0 function03 = (Function0) rememberedValue7;
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(5004770);
                    Object rememberedValue8 = composer2.rememberedValue();
                    if (rememberedValue8 == companion.getEmpty()) {
                        rememberedValue8 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.w0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit v1;
                                v1 = MineChangeProfilePageKt.v1(mutableState);
                                return v1;
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.y0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w1;
                    w1 = MineChangeProfilePageKt.w1(i, (Composer) obj, ((Integer) obj2).intValue());
                    return w1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(Gender gender, ChangeProfilePageViewModel changeProfilePageViewModel, MutableState mutableState) {
        O0(mutableState, gender);
        changeProfilePageViewModel.x1(N0(mutableState));
        changeProfilePageViewModel.g1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(u2 u2Var, ChangeProfilePageViewModel changeProfilePageViewModel, n2 n2Var) {
        if (u2Var != null) {
            u2Var.hide();
        }
        kotlinx.coroutines.i.e(changeProfilePageViewModel.f, sh4.d.a(), null, new MineChangeProfilePageKt$GenderLayout$1$1$1$1(n2Var, null), 2, null);
        changeProfilePageViewModel.o1("gender");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(u2 u2Var, ChangeProfilePageViewModel changeProfilePageViewModel, n2 n2Var) {
        if (u2Var != null) {
            u2Var.hide();
        }
        kotlinx.coroutines.i.e(changeProfilePageViewModel.f, sh4.d.a(), null, new MineChangeProfilePageKt$MoreInfoLayout$1$3$1$1(changeProfilePageViewModel, n2Var, null), 2, null);
        changeProfilePageViewModel.o1("gender");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(ChangeProfilePageViewModel changeProfilePageViewModel, MutableState mutableState, androidx.compose.ui.focus.c0 focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (!a1(mutableState) && focusState.isFocused()) {
            changeProfilePageViewModel.o1("character_sign");
        }
        b1(mutableState, focusState.isFocused());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(a0 a0Var, Context context, ChangeProfilePageViewModel changeProfilePageViewModel) {
        if (a0Var.h.getValue() == VerifyStatus.REVIEWING) {
            ig4.g.d(context, "审核中，请勿重复修改", (ToastDuration) null, 4, (Object) null);
        } else {
            ProfileItemType profileItemType = ProfileItemType.SIGNATURE;
            changeProfilePageViewModel.l1(profileItemType);
            if (a0Var.h.getValue() == VerifyStatus.FAILED) {
                a0Var.h.setValue(VerifyStatus.NOT_VERIFY);
                changeProfilePageViewModel.n1(profileItemType, false);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(a0 a0Var, Context context, ChangeProfilePageViewModel changeProfilePageViewModel) {
        if (a0Var.j.getValue() == VerifyStatus.REVIEWING) {
            ig4.g.d(context, "审核中，请勿重复修改", (ToastDuration) null, 4, (Object) null);
        } else {
            ProfileItemType profileItemType = ProfileItemType.ACCOUNTID;
            changeProfilePageViewModel.l1(profileItemType);
            if (a0Var.j.getValue() == VerifyStatus.FAILED) {
                a0Var.j.setValue(VerifyStatus.NOT_VERIFY);
                changeProfilePageViewModel.n1(profileItemType, false);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(ChangeProfilePageViewModel changeProfilePageViewModel, a0 a0Var, Context context) {
        if (changeProfilePageViewModel.z1() && a0Var.n.getValue() == VerifyStatus.REVIEWING) {
            ig4.g.d(context, "审核中，请勿重复修改", (ToastDuration) null, 4, (Object) null);
        } else {
            String str = (String) a0Var.l.getValue();
            if (str == null) {
                str = "";
            }
            changeProfilePageViewModel.R0(str);
            if (changeProfilePageViewModel.z1() && a0Var.n.getValue() == VerifyStatus.FAILED) {
                a0Var.n.setValue(VerifyStatus.NOT_VERIFY);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(a0 a0Var, Context context, ChangeProfilePageViewModel changeProfilePageViewModel) {
        String str;
        boolean z = false;
        if (((Boolean) a0Var.o.getValue()).booleanValue()) {
            if (((CharSequence) a0Var.p.getValue()).length() == 0) {
                z = true;
            }
            if (z) {
                str = "不支持修改昵称，若要修改请联系客服";
            } else {
                str = (String) a0Var.p.getValue();
            }
            ig4.g.d(context, str, (ToastDuration) null, 4, (Object) null);
        } else if (a0Var.e.getValue() == VerifyStatus.REVIEWING) {
            ig4.g.d(context, "审核中，请勿重复修改", (ToastDuration) null, 4, (Object) null);
        } else {
            ProfileItemType profileItemType = ProfileItemType.NICKNAME;
            changeProfilePageViewModel.l1(profileItemType);
            if (a0Var.e.getValue() == VerifyStatus.FAILED) {
                a0Var.e.setValue(VerifyStatus.NOT_VERIFY);
                changeProfilePageViewModel.n1(profileItemType, false);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x01b8, code lost:
    
        if (r11 == true) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void Z(final com.dragon.read.kmp.mine.profile.a0 r29, androidx.compose.runtime.Composer r30, final int r31) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.profile.MineChangeProfilePageKt.Z(com.dragon.read.kmp.mine.profile.a0, androidx.compose.runtime.Composer, int):void");
    }

    public static final void i0(final a0 userInfo, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        int i3;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Composer startRestartGroup = composer.startRestartGroup(-778546215);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(userInfo)) {
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
                ComposerKt.traceEventStart(-778546215, i2, -1, "com.dragon.read.kmp.mine.profile.BasicInfoArea (MineChangeProfilePage.kt:614)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final Context a2 = ig4.f.a(startRestartGroup, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier a3 = androidx.compose.ui.draw.e.a(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), k.g.c(x0.i.g(12)));
                og4.a aVar2 = og4.a.a;
                int i4 = og4.a.b;
                Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(a3, aVar2.h(startRestartGroup, i4).w(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, t);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a6 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a6);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, a4, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a5))) {
                    b2.updateRememberedValue(Integer.valueOf(a5));
                    b2.apply(Integer.valueOf(a5), b3);
                }
                g5.e(b2, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                String str = (String) userInfo.d.getValue();
                float f = 54;
                Modifier i5 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f));
                startRestartGroup.startReplaceGroup(-1746271574);
                int i6 = i2 & 14;
                if (i6 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changedInstance = z2 | startRestartGroup.changedInstance(a2) | startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.profile.e1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit j0;
                            j0 = MineChangeProfilePageKt.j0(a0.this, a2, changeProfilePageViewModel);
                            return j0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                j1("昵称", str, "", ClickableKt.clickable-oSLSa3U$default(i5, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), 0, userInfo.e, changeProfilePageViewModel.Q0(ProfileItemType.NICKNAME), startRestartGroup, 390, 16);
                a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar2.h(startRestartGroup, i4).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
                String str2 = (String) userInfo.i.getValue();
                Modifier i7 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f));
                startRestartGroup.startReplaceGroup(-1746271574);
                if (i6 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean changedInstance2 = startRestartGroup.changedInstance(a2) | z3 | startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.f1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit k0;
                            k0 = MineChangeProfilePageKt.k0(a0.this, a2, changeProfilePageViewModel);
                            return k0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                j1("红果号", str2, "", ClickableKt.clickable-oSLSa3U$default(i7, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), 0, userInfo.j, changeProfilePageViewModel.Q0(ProfileItemType.ACCOUNTID), startRestartGroup, 390, 16);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l0;
                    l0 = MineChangeProfilePageKt.l0(a0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l0;
                }
            });
        }
    }

    public static final void m0(final a0 userInfo, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        int i3;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Composer startRestartGroup = composer.startRestartGroup(-1232626666);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(userInfo)) {
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
                ComposerKt.traceEventStart(-1232626666, i2, -1, "com.dragon.read.kmp.mine.profile.BizUserIdArea (MineChangeProfilePage.kt:465)");
            }
            final Context a2 = ig4.f.a(startRestartGroup, 0);
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Modifier.a aVar = Modifier.Companion;
                float f = 12;
                Modifier a3 = androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), k.g.c(x0.i.g(f)));
                og4.a aVar2 = og4.a.a;
                int i4 = og4.a.b;
                Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(a3, aVar2.h(startRestartGroup, i4).w(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, t);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, i5, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a4))) {
                    b2.updateRememberedValue(Integer.valueOf(a4));
                    b2.apply(Integer.valueOf(a4), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                ek4.c cVar = ek4.c.b;
                String o5 = cVar.o5();
                MutableState<String> mutableState = userInfo.i;
                MutableState<VerifyStatus> mutableState2 = userInfo.j;
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance = startRestartGroup.changedInstance(a2);
                int i6 = i2 & 14;
                if (i6 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changedInstance2 = changedInstance | z2 | startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.mine.profile.h1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            String n0;
                            n0 = MineChangeProfilePageKt.n0(a2, userInfo, changeProfilePageViewModel, (String) obj);
                            return n0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function1 function1 = (Function1) rememberedValue;
                startRestartGroup.endReplaceGroup();
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance3 = startRestartGroup.changedInstance(changeProfilePageViewModel);
                if (i6 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean changedInstance4 = changedInstance3 | z3 | startRestartGroup.changedInstance(a2);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.j1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit o0;
                            o0 = MineChangeProfilePageKt.o0(ChangeProfilePageViewModel.this, userInfo, a2, (androidx.compose.ui.focus.c0) obj);
                            return o0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                h1(o5, mutableState, null, mutableState2, 1, function1, androidx.compose.ui.focus.c.a(h, (Function1) rememberedValue2), false, false, startRestartGroup, 24576, 388);
                startRestartGroup.endNode();
                a3.a(SizeKt.i(aVar, x0.i.g(f)), startRestartGroup, 6);
                Modifier t2 = androidx.compose.foundation.layout.f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
                androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, t2);
                Function0 a7 = companion.a();
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
                g5.e(b4, i7, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                    b4.updateRememberedValue(Integer.valueOf(a6));
                    b4.apply(Integer.valueOf(a6), b5);
                }
                g5.e(b4, e2, companion.d());
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance5 = startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.k1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit p0;
                            p0 = MineChangeProfilePageKt.p0(ChangeProfilePageViewModel.this, (androidx.compose.ui.layout.w) obj);
                            return p0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a8 = androidx.compose.ui.layout.d1.a(aVar, (Function1) rememberedValue3);
                androidx.compose.ui.text.font.c0 h2 = androidx.compose.ui.text.font.c0.b.h();
                composer2 = startRestartGroup;
                a6.j(cVar.o5() + "支持设置8-12个字符，包含数字、字母、下划线、点。一年只能修改一次。", a8, aVar2.h(startRestartGroup, i4).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, h2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199680, 0, 131024);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.l1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q0;
                    q0 = MineChangeProfilePageKt.q0(a0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return q0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(a0 a0Var, Gender gender, ChangeProfilePageViewModel changeProfilePageViewModel, n2 n2Var) {
        a0Var.f.setValue(gender);
        kotlinx.coroutines.i.e(changeProfilePageViewModel.f, sh4.d.a(), null, new MineChangeProfilePageKt$GenderBottomDialog$1$1$1$1$1(n2Var, null), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(androidx.compose.ui.focus.n nVar, ChangeProfilePageViewModel changeProfilePageViewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = d.a[event.ordinal()];
        if (i != 1) {
            if (i == 2) {
                changeProfilePageViewModel.h1();
            }
        } else {
            nVar.u(true);
            changeProfilePageViewModel.i1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(a0 a0Var, ChangeProfilePageViewModel changeProfilePageViewModel, MutableState mutableState, n2 n2Var) {
        if (N0(mutableState) != a0Var.f.getValue()) {
            changeProfilePageViewModel.p.setValue(Boolean.TRUE);
        } else {
            kotlinx.coroutines.i.e(changeProfilePageViewModel.f, sh4.d.a(), null, new MineChangeProfilePageKt$NewGenderBottomDialog$1$1$1$1$1(a0Var, changeProfilePageViewModel, n2Var, mutableState, null), 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(ChangeProfilePageViewModel changeProfilePageViewModel, a0 a0Var, n2 n2Var, MutableState mutableState) {
        changeProfilePageViewModel.p.setValue(Boolean.FALSE);
        kotlinx.coroutines.i.e(changeProfilePageViewModel.f, sh4.d.a(), null, new MineChangeProfilePageKt$NewGenderBottomDialog$3$1$1(a0Var, changeProfilePageViewModel, n2Var, mutableState, null), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c1(Context context, a0 a0Var, ChangeProfilePageViewModel changeProfilePageViewModel, String it2) {
        IntRange until;
        Object subSequence;
        Intrinsics.checkNotNullParameter(it2, "it");
        com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "onUserNameEditValueChange, it = " + it2);
        int length = it2.length();
        Object obj = it2;
        if (length > 10) {
            ig4.g.d(context, "最多输入10个字符", (ToastDuration) null, 4, (Object) null);
            until = RangesKt___RangesKt.until(0, 10);
            subSequence = StringsKt__StringsKt.subSequence(it2, until);
            obj = subSequence;
        }
        if (a0Var.e.getValue() == VerifyStatus.FAILED) {
            a0Var.e.setValue(VerifyStatus.NOT_VERIFY);
        }
        a0Var.d.setValue(obj.toString());
        changeProfilePageViewModel.g1();
        return obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e1(Context context, a0 a0Var, ChangeProfilePageViewModel changeProfilePageViewModel, String it2) {
        IntRange until;
        Object subSequence;
        Intrinsics.checkNotNullParameter(it2, "it");
        com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "onDescriptionEditValueChange, it = " + it2);
        int length = it2.length();
        Object obj = it2;
        if (length > 30) {
            ig4.g.d(context, "最多输入30个字", (ToastDuration) null, 4, (Object) null);
            until = RangesKt___RangesKt.until(0, 30);
            subSequence = StringsKt__StringsKt.subSequence(it2, until);
            obj = subSequence;
        }
        if (a0Var.h.getValue() == VerifyStatus.FAILED) {
            a0Var.h.setValue(VerifyStatus.NOT_VERIFY);
        }
        a0Var.g.setValue(obj.toString());
        changeProfilePageViewModel.g1();
        return obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String n0(Context context, a0 a0Var, ChangeProfilePageViewModel changeProfilePageViewModel, String it2) {
        boolean z;
        String str;
        IntRange until;
        Intrinsics.checkNotNullParameter(it2, "it");
        com.dragon.read.kmp.j.a.d("ChangeProfilePageViewModel", "onBizUserIdEditValueChange, it = " + it2);
        int i = 0;
        while (true) {
            if (i < it2.length()) {
                z = true;
                if (!D1(it2.charAt(i))) {
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
                if (D1(charAt)) {
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
        if (StringUtilsKt.a(str)) {
            ig4.g.d(context, str, (ToastDuration) null, 4, (Object) null);
        }
        a0Var.i.setValue(it2);
        if (a0Var.j.getValue() == VerifyStatus.FAILED) {
            a0Var.j.setValue(VerifyStatus.NOT_VERIFY);
        }
        changeProfilePageViewModel.g1();
        return it2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(ChangeProfilePageViewModel changeProfilePageViewModel, a0 a0Var, Context context, androidx.compose.ui.focus.c0 focusState) {
        boolean z;
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (changeProfilePageViewModel.i && !focusState.isFocused() && changeProfilePageViewModel.g) {
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
        if (!changeProfilePageViewModel.i && focusState.isFocused()) {
            changeProfilePageViewModel.o1("hongguo_id");
        }
        changeProfilePageViewModel.i = focusState.isFocused();
        return Unit.INSTANCE;
    }

    public static final void H0(final a0 userInfo, n2 sheetState, Composer composer, final int i) {
        int i2;
        boolean z;
        final n2 n2Var;
        CreationExtras creationExtras;
        boolean z2;
        final ChangeProfilePageViewModel changeProfilePageViewModel;
        boolean z3;
        boolean changedInstance;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Composer startRestartGroup = composer.startRestartGroup(-1481443977);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(userInfo)) {
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
                changedInstance = startRestartGroup.changed(sheetState);
            } else {
                changedInstance = startRestartGroup.changedInstance(sheetState);
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
                ComposerKt.traceEventStart(-1481443977, i5, -1, "com.dragon.read.kmp.mine.profile.MoreInfoLayout (MineChangeProfilePage.kt:672)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel2 = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final u2 u2Var = (u2) startRestartGroup.consume(CompositionLocalsKt.p());
                final Context a2 = ig4.f.a(startRestartGroup, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier a3 = androidx.compose.ui.draw.e.a(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), k.g.c(x0.i.g(12)));
                og4.a aVar2 = og4.a.a;
                int i6 = og4.a.b;
                Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(a3, aVar2.h(startRestartGroup, i6).w(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, t);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a6 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a6);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, a4, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a5))) {
                    b2.updateRememberedValue(Integer.valueOf(a5));
                    b2.apply(Integer.valueOf(a5), b3);
                }
                g5.e(b2, e, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                String str = (String) userInfo.g.getValue();
                float f = 54;
                Modifier k = SizeKt.k(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceGroup(-1746271574);
                if ((i5 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changedInstance2 = z2 | startRestartGroup.changedInstance(a2) | startRestartGroup.changedInstance(changeProfilePageViewModel2);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.profile.j0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit I0;
                            I0 = MineChangeProfilePageKt.I0(a0.this, a2, changeProfilePageViewModel2);
                            return I0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                j1("个人签名", str, "介绍一下自己", ClickableKt.clickable-oSLSa3U$default(k, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), 2, userInfo.h, changeProfilePageViewModel2.Q0(ProfileItemType.SIGNATURE), startRestartGroup, 24966, 0);
                a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar2.h(startRestartGroup, i6).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
                Modifier i7 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f));
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance3 = startRestartGroup.changedInstance(changeProfilePageViewModel2);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.k0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit J0;
                            J0 = MineChangeProfilePageKt.J0(ChangeProfilePageViewModel.this);
                            return J0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                j1("头像挂件", "", "", ClickableKt.clickable-oSLSa3U$default(i7, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), 0, null, false, startRestartGroup, 438, 112);
                a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar2.h(startRestartGroup, i6).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(300186770);
                if (changeProfilePageViewModel2.O0()) {
                    changeProfilePageViewModel = changeProfilePageViewModel2;
                    f0(changeProfilePageViewModel, userInfo, startRestartGroup, (i5 << 3) & 112);
                    z3 = false;
                    a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar2.h(startRestartGroup, i6).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
                } else {
                    changeProfilePageViewModel = changeProfilePageViewModel2;
                    z3 = false;
                }
                startRestartGroup.endReplaceGroup();
                String C1 = C1((Gender) userInfo.f.getValue(), z3);
                if (Intrinsics.areEqual(C1, "选择性别")) {
                    C1 = "";
                }
                boolean z4 = true;
                Modifier i8 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f));
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changed = startRestartGroup.changed(u2Var) | startRestartGroup.changedInstance(changeProfilePageViewModel);
                if ((i5 & 112) != 32) {
                    n2Var = sheetState;
                    if ((i5 & 64) == 0 || !startRestartGroup.changedInstance(n2Var)) {
                        z4 = false;
                    }
                } else {
                    n2Var = sheetState;
                }
                boolean z5 = changed | z4;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.l0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit K0;
                            K0 = MineChangeProfilePageKt.K0(u2Var, changeProfilePageViewModel, n2Var);
                            return K0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                j1("性别", C1, "选择性别", ClickableKt.clickable-oSLSa3U$default(i8, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null), 0, null, false, startRestartGroup, 390, 112);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            n2Var = sheetState;
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit L0;
                    L0 = MineChangeProfilePageKt.L0(a0.this, n2Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return L0;
                }
            });
        }
    }

    public static final void X0(final a0 userInfo, n2 n2Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean changedInstance;
        int i3;
        int i4;
        final n2 sheetState = n2Var;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Composer startRestartGroup = composer.startRestartGroup(586922386);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(userInfo)) {
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
                changedInstance = startRestartGroup.changed(sheetState);
            } else {
                changedInstance = startRestartGroup.changedInstance(sheetState);
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
                ComposerKt.traceEventStart(586922386, i5, -1, "com.dragon.read.kmp.mine.profile.ProfileInfoArea (MineChangeProfilePage.kt:538)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
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
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Modifier.a aVar = Modifier.Companion;
                float f = 12;
                Modifier a3 = androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), k.g.c(x0.i.g(f)));
                og4.a aVar2 = og4.a.a;
                int i6 = og4.a.b;
                Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(a3, aVar2.h(startRestartGroup, i6).w(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, t);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
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
                Composer b2 = g5.b(startRestartGroup);
                g5.e(b2, a4, companion2.c());
                g5.e(b2, currentCompositionLocalMap, companion2.e());
                Function2 b3 = companion2.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a5))) {
                    b2.updateRememberedValue(Integer.valueOf(a5));
                    b2.apply(Integer.valueOf(a5), b3);
                }
                g5.e(b2, e, companion2.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                MutableState<String> mutableState3 = userInfo.d;
                MutableState<VerifyStatus> mutableState4 = userInfo.e;
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance2 = startRestartGroup.changedInstance(a2);
                int i7 = i5 & 14;
                if (i7 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changedInstance3 = changedInstance2 | z2 | startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.z0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            String c1;
                            c1 = MineChangeProfilePageKt.c1(a2, userInfo, changeProfilePageViewModel, (String) obj);
                            return c1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                Function1 function1 = (Function1) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(-1224400529);
                if (i7 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean changedInstance4 = z3 | startRestartGroup.changedInstance(changeProfilePageViewModel) | startRestartGroup.changedInstance(a2);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.a1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit d1;
                            d1 = MineChangeProfilePageKt.d1(a0.this, changeProfilePageViewModel, a2, mutableState, (androidx.compose.ui.focus.c0) obj);
                            return d1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                h1("昵称", mutableState3, null, mutableState4, 1, function1, androidx.compose.ui.focus.c.a(h, (Function1) rememberedValue4), false, false, startRestartGroup, 24582, 388);
                a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar2.h(startRestartGroup, i6).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
                MutableState<String> mutableState5 = userInfo.g;
                MutableState<VerifyStatus> mutableState6 = userInfo.h;
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changedInstance5 = startRestartGroup.changedInstance(a2);
                if (i7 == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean changedInstance6 = changedInstance5 | z4 | startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance6 || rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.b1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            String e1;
                            e1 = MineChangeProfilePageKt.e1(a2, userInfo, changeProfilePageViewModel, (String) obj);
                            return e1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                Function1 function12 = (Function1) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(-1633490746);
                boolean changedInstance7 = startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (changedInstance7 || rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.c1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit f1;
                            f1 = MineChangeProfilePageKt.f1(ChangeProfilePageViewModel.this, mutableState2, (androidx.compose.ui.focus.c0) obj);
                            return f1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceGroup();
                h1("签名", mutableState5, "介绍一下自己吧", mutableState6, 3, function12, androidx.compose.ui.focus.c.a(h2, (Function1) rememberedValue6), false, false, startRestartGroup, 24966, 384);
                a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar2.h(startRestartGroup, i6).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
                composer2 = startRestartGroup;
                sheetState = n2Var;
                z0(userInfo, sheetState, composer2, i7 | (n2.e << 3) | (i5 & 112));
                composer2.startReplaceGroup(719702380);
                if (changeProfilePageViewModel.N0()) {
                    a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar2.h(composer2, i6).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer2, 0);
                    c0(composer2, 0);
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(719708985);
                if (changeProfilePageViewModel.O0()) {
                    a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(0.5f)), aVar2.h(composer2, i6).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer2, 0);
                    f0(changeProfilePageViewModel, userInfo, composer2, (i5 << 3) & 112);
                }
                composer2.endReplaceGroup();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g1;
                    g1 = MineChangeProfilePageKt.g1(a0.this, sheetState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    public static final void v0(final a0 a0Var, final n2 n2Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        List<Gender> listOf;
        boolean z2;
        boolean z3;
        boolean changedInstance;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-759128130);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(a0Var)) {
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
                changedInstance = startRestartGroup.changed(n2Var);
            } else {
                changedInstance = startRestartGroup.changedInstance(n2Var);
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
                ComposerKt.traceEventStart(-759128130, i5, -1, "com.dragon.read.kmp.mine.profile.GenderBottomDialog (MineChangeProfilePage.kt:423)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                ?? r14 = 1;
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                Modifier v = androidx.compose.foundation.layout.f2.v(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), k.g.c(x0.i.g(12))), og4.a.a.h(startRestartGroup, og4.a.b).D(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), 0.0f, 0.0f, 0.0f, x0.i.g(20), 7, (Object) null);
                androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.g(), startRestartGroup, 48);
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
                startRestartGroup.startReplaceGroup(1591657829);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Gender[]{Gender.MALE, Gender.FEMALE, Gender.NOSET});
                for (final Gender gender : listOf) {
                    String C1 = C1(gender, r14);
                    Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.h(Modifier.Companion, 0.0f, (int) r14, (Object) null), 0.0f, x0.i.g(19), (int) r14, (Object) null);
                    startRestartGroup.startReplaceGroup(-1224400529);
                    if ((i5 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean changed = z2 | startRestartGroup.changed(gender.ordinal()) | startRestartGroup.changedInstance(changeProfilePageViewModel);
                    if ((i5 & 112) != 32 && ((i5 & 64) == 0 || !startRestartGroup.changedInstance(n2Var))) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    boolean z4 = changed | z3;
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.profile.i1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit w0;
                                w0 = MineChangeProfilePageKt.w0(a0.this, gender, changeProfilePageViewModel, n2Var);
                                return w0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    Composer composer3 = startRestartGroup;
                    a6.j(C1, ClickableKt.clickable-oSLSa3U$default(t, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 14, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer3, 199680, 0, 130512);
                    startRestartGroup = composer3;
                    changeProfilePageViewModel = changeProfilePageViewModel;
                    r14 = 1;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel2 = changeProfilePageViewModel;
                Composer composer4 = startRestartGroup;
                boolean z5 = false;
                composer4.endReplaceGroup();
                Modifier t2 = androidx.compose.foundation.layout.f2.t(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, x0.i.g(19), 1, (Object) null);
                composer4.startReplaceGroup(-1633490746);
                boolean changedInstance2 = composer4.changedInstance(changeProfilePageViewModel2);
                if ((i5 & 112) == 32 || ((i5 & 64) != 0 && composer4.changedInstance(n2Var))) {
                    z5 = true;
                }
                boolean z6 = changedInstance2 | z5;
                Object rememberedValue2 = composer4.rememberedValue();
                if (z6 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.t1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit x0;
                            x0 = MineChangeProfilePageKt.x0(ChangeProfilePageViewModel.this, n2Var);
                            return x0;
                        }
                    };
                    composer4.updateRememberedValue(rememberedValue2);
                }
                composer4.endReplaceGroup();
                composer2 = composer4;
                a6.j("取消", ClickableKt.clickable-oSLSa3U$default(t2, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 14, (Object) null), og4.a.a.h(composer4, og4.a.b).k(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 130512);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.v1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit y0;
                    y0 = MineChangeProfilePageKt.y0(a0.this, n2Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return y0;
                }
            });
        }
    }

    public static final void z0(final a0 userInfo, final n2 sheetState, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        androidx.compose.ui.text.font.c0 i3;
        long k;
        boolean changedInstance;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Composer startRestartGroup = composer.startRestartGroup(-1116342763);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(userInfo)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(sheetState);
            } else {
                changedInstance = startRestartGroup.changedInstance(sheetState);
            }
            if (changedInstance) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        int i6 = i2;
        if ((i6 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1116342763, i6, -1, "com.dragon.read.kmp.mine.profile.GenderLayout (MineChangeProfilePage.kt:741)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final u2 u2Var = (u2) startRestartGroup.consume(CompositionLocalsKt.p());
                Modifier.a aVar = Modifier.Companion;
                float f = 16;
                Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(f), 1, (Object) null);
                e.e h = androidx.compose.foundation.layout.e.a.h();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 b2 = r2.b(h, aVar2.l(), startRestartGroup, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, t);
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
                g5.e(b3, b2, companion.c());
                g5.e(b3, currentCompositionLocalMap, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                    b3.updateRememberedValue(Integer.valueOf(a2));
                    b3.apply(Integer.valueOf(a2), b4);
                }
                g5.e(b3, e, companion.d());
                w2 w2Var = w2.b;
                Modifier x = SizeKt.x(aVar, x0.i.g(48));
                c0.a aVar3 = androidx.compose.ui.text.font.c0.b;
                androidx.compose.ui.text.font.c0 h2 = aVar3.h();
                long h3 = x0.x.h(16);
                og4.a aVar4 = og4.a.a;
                int i7 = og4.a.b;
                a6.j("性别", x, aVar4.h(startRestartGroup, i7).h(), h3, (androidx.compose.ui.text.font.y) null, h2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199734, 0, 131024);
                a3.a(SizeKt.x(aVar, x0.i.g(f)), startRestartGroup, 6);
                boolean z2 = true;
                Modifier h4 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changed = startRestartGroup.changed(u2Var) | startRestartGroup.changedInstance(changeProfilePageViewModel);
                if ((i6 & 112) != 32 && ((i6 & 64) == 0 || !startRestartGroup.changedInstance(sheetState))) {
                    z2 = false;
                }
                boolean z3 = changed | z2;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.profile.p1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit A0;
                            A0 = MineChangeProfilePageKt.A0(u2Var, changeProfilePageViewModel, sheetState);
                            return A0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(h4, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 14, (Object) null);
                androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier);
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
                Composer b5 = g5.b(startRestartGroup);
                g5.e(b5, i8, companion.c());
                g5.e(b5, currentCompositionLocalMap2, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                    b5.updateRememberedValue(Integer.valueOf(a4));
                    b5.apply(Integer.valueOf(a4), b6);
                }
                g5.e(b5, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String C1 = C1((Gender) userInfo.f.getValue(), false);
                Modifier b7 = boxScopeInstance.b(aVar, aVar2.h());
                long h5 = x0.x.h(16);
                Object value = userInfo.f.getValue();
                Gender gender = Gender.NOSET;
                if (value == gender) {
                    i3 = aVar3.h();
                } else {
                    i3 = aVar3.i();
                }
                if (userInfo.f.getValue() == gender) {
                    startRestartGroup.startReplaceGroup(-1425567247);
                    k = aVar4.h(startRestartGroup, i7).K();
                } else {
                    startRestartGroup.startReplaceGroup(-1425566192);
                    k = aVar4.h(startRestartGroup, i7).k();
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                a6.j(C1, b7, k, h5, (androidx.compose.ui.text.font.y) null, i3, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131024);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.q1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit B0;
                    B0 = MineChangeProfilePageKt.B0(a0.this, sheetState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return B0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [boolean, int] */
    public static final void M0(final a0 a0Var, final n2 n2Var, Composer composer, final int i) {
        int i2;
        boolean z;
        final a0 a0Var2;
        Composer composer2;
        CreationExtras creationExtras;
        boolean z2;
        boolean z3;
        long h;
        List<Gender> listOf;
        boolean z4;
        final a0 a0Var3;
        final MutableState mutableState;
        long C;
        boolean changedInstance;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1610675358);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(a0Var)) {
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
                changedInstance = startRestartGroup.changed(n2Var);
            } else {
                changedInstance = startRestartGroup.changedInstance(n2Var);
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
                ComposerKt.traceEventStart(-1610675358, i5, -1, "com.dragon.read.kmp.mine.profile.NewGenderBottomDialog (MineChangeProfilePage.kt:307)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default(a0Var.f.getValue(), (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                Modifier.a aVar = Modifier.Companion;
                float f = 16;
                float f2 = 0;
                Modifier a2 = androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), k.g.d(x0.i.g(f), x0.i.g(f), x0.i.g(f2), x0.i.g(f2)));
                og4.a aVar2 = og4.a.a;
                int i6 = og4.a.b;
                Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(a2, aVar2.h(startRestartGroup, i6).p3(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i7 = eVar.i();
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a3 = androidx.compose.foundation.layout.x.a(i7, aVar3.k(), startRestartGroup, 0);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, t);
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
                Modifier i8 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(48));
                androidx.compose.ui.layout.p0 i9 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, i8);
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
                g5.e(b4, i9, companion2.c());
                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                Function2 b5 = companion2.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                    b4.updateRememberedValue(Integer.valueOf(a6));
                    b4.apply(Integer.valueOf(a6), b5);
                }
                g5.e(b4, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                androidx.compose.ui.graphics.e1 a8 = com.dragon.read.kmp.compose.common.image.e.a(com.dragon.read.component.biz.impl.mine.o1.k(w6.a), startRestartGroup, 0);
                float f3 = 24;
                Modifier b6 = boxScopeInstance.b(SizeKt.u(aVar, x0.i.g(f3), x0.i.g(f3)), aVar3.h());
                startRestartGroup.startReplaceGroup(-1224400529);
                int i10 = i5 & 14;
                if (i10 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changedInstance2 = z2 | startRestartGroup.changedInstance(changeProfilePageViewModel);
                int i11 = i5 & 112;
                if (i11 != 32 && ((i5 & 64) == 0 || !startRestartGroup.changedInstance(n2Var))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                boolean z5 = changedInstance2 | z3;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z5 || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.d0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit P0;
                            P0 = MineChangeProfilePageKt.P0(a0.this, changeProfilePageViewModel, mutableState2, n2Var);
                            return P0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                MutableState mutableState3 = mutableState2;
                androidx.compose.foundation.z0.g(a8, "close_dialog", ClickableKt.clickable-oSLSa3U$default(b6, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar2.h(startRestartGroup, i6).C(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
                Modifier b7 = boxScopeInstance.b(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.e());
                long h2 = x0.x.h(16);
                c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
                a6.j("选择性别", b7, aVar2.h(startRestartGroup, i6).C(), h2, (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 130512);
                Modifier b8 = boxScopeInstance.b(aVar, aVar3.f());
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance3 = startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.e0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit Q0;
                            Q0 = MineChangeProfilePageKt.Q0(ChangeProfilePageViewModel.this);
                            return Q0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(b8, true, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 14, (Object) null);
                androidx.compose.ui.text.font.c0 i12 = aVar4.i();
                long h3 = x0.x.h(16);
                if (changeProfilePageViewModel.S0()) {
                    startRestartGroup.startReplaceGroup(-1089081270);
                    h = aVar2.h(startRestartGroup, i6).C();
                } else {
                    startRestartGroup.startReplaceGroup(-1089080028);
                    h = aVar2.h(startRestartGroup, i6).h();
                }
                startRestartGroup.endReplaceGroup();
                a6.j("保存", modifier, h, h3, (androidx.compose.ui.text.font.y) null, i12, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131024);
                startRestartGroup.endNode();
                Modifier i13 = SizeKt.i(aVar, x0.i.g(8));
                androidx.compose.ui.e eVar2 = null;
                ?? r9 = 1;
                float f4 = 0.0f;
                Composer composer3 = startRestartGroup;
                a3.a(SizeKt.h(i13, 0.0f, 1, (Object) null), composer3, 6);
                changeProfilePageViewModel.x1(N0(mutableState3));
                Modifier t2 = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), k.g.c(x0.i.g(f))), aVar2.h(composer3, i6).D(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), 0.0f, 2, (Object) null);
                androidx.compose.ui.layout.p0 a9 = androidx.compose.foundation.layout.x.a(eVar.i(), aVar3.k(), composer3, 0);
                int a10 = j.a(androidx.compose.runtime.i.b(composer3, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer3, t2);
                Function0 a11 = companion2.a();
                if (!(composer3.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(a11);
                } else {
                    composer3.useNode();
                }
                Composer b9 = g5.b(composer3);
                g5.e(b9, a9, companion2.c());
                g5.e(b9, currentCompositionLocalMap3, companion2.e());
                Function2 b10 = companion2.b();
                if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a10))) {
                    b9.updateRememberedValue(Integer.valueOf(a10));
                    b9.apply(Integer.valueOf(a10), b10);
                }
                g5.e(b9, e3, companion2.d());
                composer3.startReplaceGroup(-1237648914);
                int i14 = 3;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Gender[]{Gender.MALE, Gender.FEMALE, Gender.NOSET});
                for (final Gender gender : listOf) {
                    Modifier.a aVar5 = Modifier.Companion;
                    Modifier i15 = SizeKt.i(SizeKt.h(aVar5, f4, (int) r9, eVar2), x0.i.g(54));
                    composer3.startReplaceGroup(-1746271574);
                    boolean changed = composer3.changed(gender.ordinal()) | composer3.changedInstance(changeProfilePageViewModel);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (!changed && rememberedValue4 != Composer.Companion.getEmpty()) {
                        mutableState = mutableState3;
                    } else {
                        mutableState = mutableState3;
                        rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.f0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit R0;
                                R0 = MineChangeProfilePageKt.R0(gender, changeProfilePageViewModel, mutableState);
                                return R0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceGroup();
                    Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(i15, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null);
                    e.a aVar6 = androidx.compose.ui.e.a;
                    androidx.compose.ui.layout.p0 i16 = androidx.compose.foundation.layout.m.i(aVar6.o(), false);
                    int a12 = j.a(androidx.compose.runtime.i.b(composer3, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                    Modifier e4 = ComposedModifierKt.e(composer3, modifier2);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.o0;
                    Function0 a13 = companion3.a();
                    if (!(composer3.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(a13);
                    } else {
                        composer3.useNode();
                    }
                    Composer b11 = g5.b(composer3);
                    g5.e(b11, i16, companion3.c());
                    g5.e(b11, currentCompositionLocalMap4, companion3.e());
                    Function2 b12 = companion3.b();
                    if (b11.getInserting() || !Intrinsics.areEqual(b11.rememberedValue(), Integer.valueOf(a12))) {
                        b11.updateRememberedValue(Integer.valueOf(a12));
                        b11.apply(Integer.valueOf(a12), b12);
                    }
                    g5.e(b11, e4, companion3.d());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.a;
                    String C1 = C1(gender, r9);
                    Modifier b13 = boxScopeInstance2.b(SizeKt.D(aVar5, eVar2, false, i14, eVar2), aVar6.h());
                    long h4 = x0.x.h(14);
                    androidx.compose.ui.text.font.c0 i17 = androidx.compose.ui.text.font.c0.b.i();
                    if (N0(mutableState) == gender) {
                        composer3.startReplaceGroup(1634881011);
                        C = og4.a.a.h(composer3, og4.a.b).f();
                    } else {
                        composer3.startReplaceGroup(1634882228);
                        C = og4.a.a.h(composer3, og4.a.b).C();
                    }
                    composer3.endReplaceGroup();
                    mutableState3 = mutableState;
                    Composer composer4 = composer3;
                    a6.j(C1, b13, C, h4, (androidx.compose.ui.text.font.y) null, i17, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer4, 199680, 0, 130512);
                    composer4.startReplaceGroup(1634886169);
                    if (N0(mutableState3) == gender) {
                        float f5 = 20;
                        androidx.compose.foundation.z0.g(com.dragon.read.kmp.compose.common.image.e.a(com.dragon.read.component.biz.impl.mine.o1.l(w6.a), composer4, 0), "selected", boxScopeInstance2.b(SizeKt.u(aVar5, x0.i.g(f5), x0.i.g(f5)), aVar6.f()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, og4.a.a.h(composer4, og4.a.b).f(), 0, 2, (Object) null), 0, composer4, 48, 184);
                    }
                    composer4.endReplaceGroup();
                    composer4.endNode();
                    composer3 = composer4;
                    i14 = 3;
                    eVar2 = null;
                    r9 = 1;
                    f4 = 0.0f;
                }
                Composer composer5 = composer3;
                composer5.endReplaceGroup();
                composer5.endNode();
                a3.a(SizeKt.h(SizeKt.i(Modifier.Companion, x0.i.g(f)), 0.0f, 1, (Object) null), composer5, 6);
                composer5.endNode();
                if (((Boolean) changeProfilePageViewModel.p.getValue()).booleanValue()) {
                    x6 x6Var = x6.a;
                    boolean z6 = false;
                    String c3 = org.jetbrains.compose.resources.j.c(y6.o(x6Var), composer5, 0);
                    String c4 = org.jetbrains.compose.resources.j.c(y6.r(x6Var), composer5, 0);
                    String c5 = org.jetbrains.compose.resources.j.c(y6.p(x6Var), composer5, 0);
                    composer5.startReplaceGroup(5004770);
                    boolean changedInstance4 = composer5.changedInstance(changeProfilePageViewModel);
                    Object rememberedValue5 = composer5.rememberedValue();
                    if (changedInstance4 || rememberedValue5 == Composer.Companion.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.g0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit S0;
                                S0 = MineChangeProfilePageKt.S0(ChangeProfilePageViewModel.this);
                                return S0;
                            }
                        };
                        composer5.updateRememberedValue(rememberedValue5);
                    }
                    Function0 function0 = (Function0) rememberedValue5;
                    composer5.endReplaceGroup();
                    composer5.startReplaceGroup(-1224400529);
                    boolean changedInstance5 = composer5.changedInstance(changeProfilePageViewModel);
                    if (i10 == 4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z7 = changedInstance5 | z4;
                    if (i11 == 32 || ((i5 & 64) != 0 && composer5.changedInstance(n2Var))) {
                        z6 = true;
                    }
                    boolean z8 = z6 | z7;
                    Object rememberedValue6 = composer5.rememberedValue();
                    if (!z8 && rememberedValue6 != Composer.Companion.getEmpty()) {
                        a0Var3 = a0Var;
                    } else {
                        a0Var3 = a0Var;
                        final MutableState mutableState4 = mutableState3;
                        rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.h0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit T0;
                                T0 = MineChangeProfilePageKt.T0(ChangeProfilePageViewModel.this, a0Var3, n2Var, mutableState4);
                                return T0;
                            }
                        };
                        composer5.updateRememberedValue(rememberedValue6);
                    }
                    Function0 function02 = (Function0) rememberedValue6;
                    composer5.endReplaceGroup();
                    composer5.startReplaceGroup(5004770);
                    boolean changedInstance6 = composer5.changedInstance(changeProfilePageViewModel);
                    Object rememberedValue7 = composer5.rememberedValue();
                    if (changedInstance6 || rememberedValue7 == Composer.Companion.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.i0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit U0;
                                U0 = MineChangeProfilePageKt.U0(ChangeProfilePageViewModel.this);
                                return U0;
                            }
                        };
                        composer5.updateRememberedValue(rememberedValue7);
                    }
                    Function0 function03 = (Function0) rememberedValue7;
                    composer5.endReplaceGroup();
                    composer5.startReplaceGroup(5004770);
                    boolean changedInstance7 = composer5.changedInstance(changeProfilePageViewModel);
                    Object rememberedValue8 = composer5.rememberedValue();
                    if (changedInstance7 || rememberedValue8 == Composer.Companion.getEmpty()) {
                        rememberedValue8 = new Function0() { // from class: com.dragon.read.kmp.mine.profile.z1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit V0;
                                V0 = MineChangeProfilePageKt.V0(ChangeProfilePageViewModel.this);
                                return V0;
                            }
                        };
                        composer5.updateRememberedValue(rememberedValue8);
                    }
                    composer5.endReplaceGroup();
                    a0Var2 = a0Var3;
                    composer2 = composer5;
                    hq4.f.f(c3, c4, c5, false, function0, function02, function03, (Function0) rememberedValue8, null, composer5, 0, 264);
                } else {
                    a0Var2 = a0Var;
                    composer2 = composer5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            a0Var2 = a0Var;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit W0;
                    W0 = MineChangeProfilePageKt.W0(a0.this, n2Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return W0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0424  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f0(final com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel r39, final com.dragon.read.kmp.mine.profile.a0 r40, androidx.compose.runtime.Composer r41, final int r42) {
        /*
            Method dump skipped, instructions count: 1229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.profile.MineChangeProfilePageKt.f0(com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel, com.dragon.read.kmp.mine.profile.a0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(final a0 a0Var, final n2 n2Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        boolean changedInstance;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-2071068950);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(a0Var)) {
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
                changedInstance = startRestartGroup.changed(n2Var);
            } else {
                changedInstance = startRestartGroup.changedInstance(n2Var);
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
                ComposerKt.traceEventStart(-2071068950, i5, -1, "com.dragon.read.kmp.mine.profile.ChangeProfileContent (MineChangeProfilePage.kt:243)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                com.dragon.read.kmp.service.b1 b1Var = com.dragon.read.kmp.service.b1.a;
                float s = b1Var.s();
                final u2 u2Var = (u2) startRestartGroup.consume(CompositionLocalsKt.p());
                State d2 = AnimateAsStateKt.d(x0.i.g(b1Var.y(((Number) changeProfilePageViewModel.h.getValue()).intValue())), (androidx.compose.animation.core.i) null, (String) null, (Function1) null, startRestartGroup, 0, 14);
                Modifier.a aVar = Modifier.Companion;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), 0.0f, x0.i.g(s), 0.0f, 0.0f, 13, (Object) null);
                og4.a aVar2 = og4.a.a;
                int i6 = og4.a.b;
                Modifier d3 = BackgroundKt.d(v, aVar2.h(startRestartGroup, i6).p3(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(aVar3.m(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, d3);
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
                g5.e(b2, i7, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                float f = 16;
                Modifier v2 = androidx.compose.foundation.layout.f2.v(SizeKt.f(aVar, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(44), x0.i.g(f), 0.0f, 8, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changed = startRestartGroup.changed(u2Var);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.profile.w1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit s0;
                            s0 = MineChangeProfilePageKt.s0(u2Var);
                            return s0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier f2 = androidx.compose.foundation.layout.u1.f(ClickableKt.clickable-oSLSa3U$default(v2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), 0.0f, u0(d2), 1, (Object) null);
                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), aVar3.g(), startRestartGroup, 48);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, f2);
                Function0 a6 = companion.a();
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
                g5.e(b4, a4, companion.c());
                g5.e(b4, currentCompositionLocalMap2, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                    b4.updateRememberedValue(Integer.valueOf(a5));
                    b4.apply(Integer.valueOf(a5), b5);
                }
                g5.e(b4, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                a3.a(SizeKt.i(aVar, x0.i.g(27)), startRestartGroup, 6);
                if (changeProfilePageViewModel.a1()) {
                    startRestartGroup.startReplaceGroup(1606972115);
                    float f3 = 12;
                    Modifier t = androidx.compose.foundation.layout.f2.t(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.h(aVar, 0.0f, 1, (Object) null), k.g.c(x0.i.g(f3))), aVar2.h(startRestartGroup, i6).w(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f3), 0.0f, 2, (Object) null);
                    androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
                    int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(startRestartGroup, t);
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
                    Composer b6 = g5.b(startRestartGroup);
                    g5.e(b6, i8, companion.c());
                    g5.e(b6, currentCompositionLocalMap3, companion.e());
                    Function2 b7 = companion.b();
                    if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a7))) {
                        b6.updateRememberedValue(Integer.valueOf(a7));
                        b6.apply(Integer.valueOf(a7), b7);
                    }
                    g5.e(b6, e3, companion.d());
                    f0(changeProfilePageViewModel, a0Var, startRestartGroup, (i5 << 3) & 112);
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1607279201);
                    int i9 = i5 & 14;
                    Z(a0Var, startRestartGroup, i9);
                    a3.a(SizeKt.i(aVar, x0.i.g(36)), startRestartGroup, 6);
                    if (changeProfilePageViewModel.z1()) {
                        startRestartGroup.startReplaceGroup(1607436960);
                        i0(a0Var, startRestartGroup, i9);
                        a3.a(SizeKt.i(aVar, x0.i.g(12)), startRestartGroup, 6);
                        H0(a0Var, n2Var, startRestartGroup, i9 | (n2.e << 3) | (i5 & 112));
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(1607657401);
                        X0(a0Var, n2Var, startRestartGroup, (n2.e << 3) | i9 | (i5 & 112));
                        a3.a(SizeKt.i(aVar, x0.i.g(24)), startRestartGroup, 6);
                        if (StringUtilsKt.a(changeProfilePageViewModel.V0())) {
                            m0(a0Var, startRestartGroup, i9);
                        }
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endNode();
                l1(startRestartGroup, 0);
                a6.j("个人信息不用于个性化推荐，仅丰富主页内容", boxScopeInstance.b(SizeKt.D(aVar, (androidx.compose.ui.e) null, false, 3, (Object) null), aVar3.b()), aVar2.h(startRestartGroup, i6).K(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 131024);
                startRestartGroup.endNode();
                if (s > 0.0f) {
                    composer2 = startRestartGroup;
                    a3.a(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(s)), aVar2.h(composer2, i6).p3(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer2, 0);
                } else {
                    composer2 = startRestartGroup;
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.x1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t0;
                    t0 = MineChangeProfilePageKt.t0(a0.this, n2Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return t0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult D0(LifecycleOwner lifecycleOwner, final ChangeProfilePageViewModel changeProfilePageViewModel, CoroutineScope coroutineScope, final androidx.compose.ui.focus.n nVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.dragon.read.kmp.mine.profile.y1
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MineChangeProfilePageKt.E0(nVar, changeProfilePageViewModel, lifecycleOwner2, event);
            }
        };
        if (com.dragon.read.kmp.service.g0.a.c()) {
            ig4.g.b("kmp page", (ToastDuration) null, 2, (Object) null);
        }
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        changeProfilePageViewModel.e1(coroutineScope);
        com.dragon.read.kmp.j.a.d(a, "MineChangeProfilePage onCreate");
        return new b(lifecycleOwner, lifecycleEventObserver, changeProfilePageViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(a0 a0Var, ChangeProfilePageViewModel changeProfilePageViewModel, Context context, MutableState mutableState, androidx.compose.ui.focus.c0 focusState) {
        boolean z;
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (Y0(mutableState) && !focusState.isFocused()) {
            if (((CharSequence) a0Var.d.getValue()).length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && changeProfilePageViewModel.g) {
                ig4.g.d(context, "昵称不能为空", (ToastDuration) null, 4, (Object) null);
            }
        }
        if (!Y0(mutableState) && focusState.isFocused()) {
            changeProfilePageViewModel.o1("nickname");
        }
        Z0(mutableState, focusState.isFocused());
        return Unit.INSTANCE;
    }

    public static final void C0(final a0 userInfo, final y iDepend, z zVar, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean changedInstance;
        int i5;
        boolean changedInstance2;
        int i6;
        boolean z;
        CreationExtras creationExtras;
        z zVar2 = zVar;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        Composer startRestartGroup = composer.startRestartGroup(-569941688);
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
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if ((i & 64) == 0) {
                changedInstance = startRestartGroup.changed(iDepend);
            } else {
                changedInstance = startRestartGroup.changedInstance(iDepend);
            }
            if (changedInstance) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance2 = startRestartGroup.changed(zVar2);
            } else {
                changedInstance2 = startRestartGroup.changedInstance(zVar2);
            }
            if (changedInstance2) {
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
                zVar2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569941688, i3, -1, "com.dragon.read.kmp.mine.profile.MineChangeProfilePage (MineChangeProfilePage.kt:171)");
            }
            com.dragon.read.kmp.mine.model.e eVar = new com.dragon.read.kmp.mine.model.e(userInfo, iDepend, zVar2);
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final ChangeProfilePageViewModel changeProfilePageViewModel = (ChangeProfilePageViewModel) f2.d.c(Reflection.getOrCreateKotlinClass(ChangeProfilePageViewModel.class), c2, (String) null, eVar, creationExtras, startRestartGroup, 0, 0);
                changeProfilePageViewModel.t1(iDepend);
                changeProfilePageViewModel.c = zVar2;
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
                boolean changedInstance3 = startRestartGroup.changedInstance(nVar) | startRestartGroup.changedInstance(changeProfilePageViewModel) | startRestartGroup.changedInstance(lifecycleOwner) | startRestartGroup.changedInstance(coroutineScope);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.b0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DisposableEffectResult D0;
                            D0 = MineChangeProfilePageKt.D0(lifecycleOwner, changeProfilePageViewModel, coroutineScope, nVar, (DisposableEffectScope) obj);
                            return D0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, startRestartGroup, 6);
                ModalBottomSheetValue modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance4 = startRestartGroup.changedInstance(changeProfilePageViewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: com.dragon.read.kmp.mine.profile.m0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            boolean F0;
                            F0 = MineChangeProfilePageKt.F0(ChangeProfilePageViewModel.this, (ModalBottomSheetValue) obj);
                            return Boolean.valueOf(F0);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                n2 H = ModalBottomSheetKt.H(modalBottomSheetValue, (androidx.compose.animation.core.i) null, (Function1) rememberedValue3, true, startRestartGroup, 3078, 2);
                changeProfilePageViewModel.M0(H);
                pg4.p.f((pg4.i) null, androidx.compose.runtime.internal.t.e(-473815177, true, new a(H, changeProfilePageViewModel, userInfo), startRestartGroup, 54), startRestartGroup, 48, 1);
                if (!((Boolean) changeProfilePageViewModel.j.getValue()).booleanValue()) {
                    androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
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
        final z zVar3 = zVar2;
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.profile.x0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit G0;
                    G0 = MineChangeProfilePageKt.G0(a0.this, iDepend, zVar3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return G0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void j1(final java.lang.String r43, final java.lang.String r44, final java.lang.String r45, androidx.compose.ui.Modifier r46, int r47, androidx.compose.runtime.MutableState<com.dragon.read.kmp.mine.profile.VerifyStatus> r48, boolean r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 1167
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.profile.MineChangeProfilePageKt.j1(java.lang.String, java.lang.String, java.lang.String, androidx.compose.ui.Modifier, int, androidx.compose.runtime.MutableState, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h1(final java.lang.String r69, final androidx.compose.runtime.MutableState<java.lang.String> r70, java.lang.String r71, final androidx.compose.runtime.MutableState<com.dragon.read.kmp.mine.profile.VerifyStatus> r72, int r73, final kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> r74, androidx.compose.ui.Modifier r75, boolean r76, boolean r77, androidx.compose.runtime.Composer r78, final int r79, final int r80) {
        /*
            Method dump skipped, instructions count: 1093
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.profile.MineChangeProfilePageKt.h1(java.lang.String, androidx.compose.runtime.MutableState, java.lang.String, androidx.compose.runtime.MutableState, int, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
