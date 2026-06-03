package com.dragon.read.kmp.mine.account;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.g2;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.u2;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.e3;
import androidx.compose.ui.text.f3;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.input.r0;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.mine.o1;
import com.dragon.read.component.biz.impl.mine.w6;
import com.dragon.read.component.biz.impl.mine.x6;
import com.dragon.read.component.biz.impl.mine.y6;
import com.dragon.read.kmp.compose.ToastDuration;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.CoroutineScope;
import w0.h;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ChangePhonePageKt {
    private static final String a;

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(607675);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(com.dragon.read.kmp.mine.model.a aVar, int i, Composer composer, int i2) {
        x0(aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(com.dragon.read.kmp.mine.model.a aVar, int i, Composer composer, int i2) {
        I0(aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(String str, String str2, String str3, int i, int i2, int i3, Composer composer, int i4) {
        L(str, str2, str3, i, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(FocusRequester focusRequester, int i, Composer composer, int i2) {
        N(focusRequester, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(com.dragon.read.kmp.mine.model.a aVar, int i, Composer composer, int i2) {
        R(aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(com.dragon.read.kmp.mine.model.a aVar, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        V(aVar, function0, function02, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(int i, Composer composer, int i2) {
        a0(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(FocusRequester focusRequester, int i, Composer composer, int i2) {
        e0(focusRequester, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(int i, Composer composer, int i2) {
        o0(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(com.dragon.read.kmp.mine.model.a aVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        r0(aVar, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(String str, Function0 function0, int i, Composer composer, int i2) {
        u0(str, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x08cc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x05f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void x0(final com.dragon.read.kmp.mine.model.a r49, androidx.compose.runtime.Composer r50, final int r51) {
        /*
            Method dump skipped, instructions count: 2277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.account.ChangePhonePageKt.x0(com.dragon.read.kmp.mine.model.a, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set A0() {
        return new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0() {
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0() {
        zm4.d.a.b();
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(607674);
        a = "ChangePhonePage";
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ LifecycleOwner a;
        final /* synthetic */ LifecycleEventObserver b;
        final /* synthetic */ com.dragon.read.kmp.mine.model.a c;

        public void dispose() {
            this.a.getLifecycle().removeObserver(this.b);
            this.c.I0();
            com.dragon.read.kmp.j.a.d(ChangePhonePageKt.a, "ChangePhonePage onDestroy");
        }

        public b(LifecycleOwner lifecycleOwner, LifecycleEventObserver lifecycleEventObserver, com.dragon.read.kmp.mine.model.a aVar) {
            this.a = lifecycleOwner;
            this.b = lifecycleEventObserver;
            this.c = aVar;
        }
    }

    public static final void T0() {
        ym4.o oVar = ym4.o.a;
        ym4.a aVar = new ym4.a();
        aVar.g("tab_name", "mine");
        Unit unit = Unit.INSTANCE;
        oVar.d("switch_phone_number_popup_show", aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(com.dragon.read.kmp.mine.model.a aVar) {
        aVar.P0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(com.dragon.read.kmp.mine.model.a aVar) {
        aVar.Q0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(com.dragon.read.kmp.mine.model.a aVar) {
        aVar.R0();
        return Unit.INSTANCE;
    }

    private static final float B0(State<x0.i> state) {
        return ((x0.i) state.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function0 function0) {
        S0("switch");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Function0 function0) {
        S0("cancel");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function0 function0) {
        S0("cancel");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(com.dragon.read.kmp.mine.model.a aVar) {
        aVar.b.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f0(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set z0(ArrayList it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return CollectionsKt___CollectionsKt.toMutableSet(it2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(com.dragon.read.kmp.mine.model.a aVar) {
        aVar.F0("resend", ((String) aVar.c.getValue()) + ((r0) aVar.l.getValue()).i());
        return Unit.INSTANCE;
    }

    private static final String P0(String str) {
        String take;
        take = StringsKt___StringsKt.take(str, 11);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < take.length()) {
            int i3 = i2 + 1;
            sb.append(take.charAt(i));
            if ((i2 == 2 || i2 == 6) && i2 != StringsKt__StringsKt.getLastIndex(take)) {
                sb.append(' ');
            }
            i++;
            i2 = i3;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final void S0(String clickContent) {
        Intrinsics.checkNotNullParameter(clickContent, "clickContent");
        ym4.o oVar = ym4.o.a;
        ym4.a aVar = new ym4.a();
        aVar.g("tab_name", "mine");
        aVar.g("click_content", clickContent);
        Unit unit = Unit.INSTANCE;
        oVar.d("switch_phone_number_popup_click", aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(com.dragon.read.kmp.mine.model.a aVar) {
        if (((Number) aVar.p.getValue()).intValue() == 0) {
            if (((Boolean) aVar.f.getValue()).booleanValue()) {
                aVar.f.setValue(Boolean.FALSE);
                aVar.m.setValue("");
                aVar.i.setValue("");
            } else {
                zm4.d.a.b();
            }
        } else if (((Number) aVar.p.getValue()).intValue() == 1) {
            if (((Boolean) aVar.f.getValue()).booleanValue()) {
                aVar.f.setValue(Boolean.FALSE);
                aVar.m.setValue("");
                aVar.i.setValue("");
            } else if (((Boolean) aVar.h.getValue()).booleanValue()) {
                aVar.b.setValue(Boolean.TRUE);
            } else {
                zm4.d.a.b();
            }
        } else {
            zm4.d.a.b();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void h0(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.mine.model.a a;

        a(com.dragon.read.kmp.mine.model.a aVar) {
            this.a = aVar;
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
                    ComposerKt.traceEventStart(-528944004, i, -1, "com.dragon.read.kmp.mine.account.ChangePhonePage.<anonymous> (ChangePhonePage.kt:227)");
                }
                if (!((Boolean) this.a.g.getValue()).booleanValue()) {
                    composer.startReplaceGroup(464243956);
                    ChangePhonePageKt.x0(this.a, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(464299570);
                    ChangePhonePageKt.I0(this.a, composer, 0);
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

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ com.dragon.read.kmp.mine.model.a a;

        c(com.dragon.read.kmp.mine.model.a aVar) {
            this.a = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            String str;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-429306095, i, -1, "com.dragon.read.kmp.mine.account.PhoneInput.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChangePhonePage.kt:822)");
                }
                if (!StringsKt__StringsKt.isBlank(((r0) this.a.l.getValue()).i())) {
                    str = "";
                } else {
                    str = "请输入手机号";
                }
                a6.j(str, (Modifier) null, og4.a.a.h(composer, og4.a.b).K(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.h(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 199680, 0, 131026);
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
    public static final Unit C0(androidx.compose.ui.focus.n nVar, u2 u2Var) {
        androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
        if (u2Var != null) {
            u2Var.hide();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(com.dragon.read.kmp.mine.model.a aVar, String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        aVar.m.setValue(it2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(MutableState mutableState, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        mutableState.setValue(it2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(MutableState mutableState, androidx.compose.ui.focus.c0 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        h0(mutableState, it2.isFocused());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(com.dragon.read.kmp.mine.model.a aVar, r0 out) {
        Intrinsics.checkNotNullParameter(out, "out");
        if (!Intrinsics.areEqual(aVar.l.getValue(), out)) {
            aVar.l.setValue(out);
        }
        aVar.i.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList y0(y.z Saver, Set it2) {
        Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
        Intrinsics.checkNotNullParameter(it2, "it");
        return new ArrayList(it2);
    }

    private static final Integer O0(String str, String str2) {
        if (str.length() != str2.length() + 1) {
            return null;
        }
        int i = 0;
        while (i < str2.length() && str.charAt(i) == str2.charAt(i)) {
            i++;
        }
        if (!Intrinsics.areEqual(StringsKt__StringsKt.removeRange((CharSequence) str, i, i + 1).toString(), str2)) {
            return null;
        }
        return Integer.valueOf(i);
    }

    private static final n0 Q0(String str, String str2) {
        Character orNull;
        Integer O0 = O0(str, str2);
        if (O0 == null) {
            return null;
        }
        int intValue = O0.intValue();
        orNull = StringsKt___StringsKt.getOrNull(str, intValue);
        if (orNull == null || orNull.charValue() != ' ') {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        String substring = str.substring(0, intValue);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int i3 = 0;
        for (int i4 = 0; i4 < substring.length(); i4++) {
            if (Character.isDigit(substring.charAt(i4))) {
                i3++;
            }
        }
        boolean z = true;
        int i5 = i3 - 1;
        if (i5 < 0 || i5 >= sb2.length()) {
            z = false;
        }
        if (!z) {
            return new n0(sb2, 0);
        }
        StringBuilder sb3 = new StringBuilder();
        int i6 = 0;
        while (i < sb2.length()) {
            char charAt2 = sb2.charAt(i);
            int i7 = i6 + 1;
            if (i6 != i5) {
                sb3.append(charAt2);
            }
            i++;
            i6 = i7;
        }
        return new n0(sb3.toString(), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r0 l0(com.dragon.read.kmp.mine.model.a aVar, r0 input) {
        int i;
        String sb;
        String take;
        int i2;
        int coerceIn;
        int coerceIn2;
        Intrinsics.checkNotNullParameter(input, "input");
        r0 r0Var = (r0) aVar.l.getValue();
        com.dragon.read.kmp.mine.model.h hVar = (com.dragon.read.kmp.mine.model.h) aVar.d.getValue();
        if (hVar != null) {
            i = hVar.f;
        } else {
            i = 11;
        }
        String i3 = r0Var.i();
        int i4 = 0;
        for (int i5 = 0; i5 < i3.length(); i5++) {
            if (Character.isDigit(i3.charAt(i5))) {
                i4++;
            }
        }
        n0 Q0 = Q0(r0Var.i(), input.i());
        if (Q0 == null || (sb = Q0.a) == null) {
            String i6 = input.i();
            StringBuilder sb2 = new StringBuilder();
            int length = i6.length();
            for (int i7 = 0; i7 < length; i7++) {
                char charAt = i6.charAt(i7);
                if (Character.isDigit(charAt)) {
                    sb2.append(charAt);
                }
            }
            sb = sb2.toString();
        }
        int length2 = sb.length();
        if (i4 >= i && length2 > i4) {
            return r0Var;
        }
        take = StringsKt___StringsKt.take(sb, i);
        String P0 = P0(take);
        if (Q0 != null) {
            i2 = Q0.b;
        } else {
            i2 = 0;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(R0(input.i(), e3.n(input.b), take.length(), i2), 0, P0.length());
        coerceIn2 = RangesKt___RangesKt.coerceIn(R0(input.i(), e3.i(input.b), take.length(), i2), 0, P0.length());
        return new r0(P0, f3.b(coerceIn, coerceIn2), (e3) null, 4, (DefaultConstructorMarker) null);
    }

    public static final void a0(Composer composer, final int i) {
        boolean z;
        CreationExtras creationExtras;
        hq4.f0 f0Var;
        Composer startRestartGroup = composer.startRestartGroup(1940024398);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1940024398, i, -1, "com.dragon.read.kmp.mine.account.OpenDoubleCheckExitDialog (ChangePhonePage.kt:167)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final com.dragon.read.kmp.mine.model.a aVar = (com.dragon.read.kmp.mine.model.a) f2.d.c(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.mine.model.a.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(aVar);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.account.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit b0;
                            b0 = ChangePhonePageKt.b0(com.dragon.read.kmp.mine.model.a.this);
                            return b0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                startRestartGroup.endReplaceGroup();
                if (((Boolean) aVar.b.getValue()).booleanValue()) {
                    x6 x6Var = x6.a;
                    String c3 = org.jetbrains.compose.resources.j.c(y6.e(x6Var), startRestartGroup, 0);
                    String c4 = org.jetbrains.compose.resources.j.c(y6.f(x6Var), startRestartGroup, 0);
                    String c5 = org.jetbrains.compose.resources.j.c(y6.q(x6Var), startRestartGroup, 0);
                    if (aVar.s) {
                        f0Var = new hq4.f0(null, k.g.c(x0.i.g(16)), null, 5, null);
                    } else {
                        f0Var = new hq4.f0(null, k.g.c(x0.i.g(8)), d2.G(f2.a.a), 1, null);
                    }
                    hq4.f0 f0Var2 = f0Var;
                    startRestartGroup.startReplaceGroup(1849434622);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.account.g
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit c0;
                                c0 = ChangePhonePageKt.c0();
                                return c0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    hq4.f.f(c3, c4, c5, true, (Function0) rememberedValue2, function0, null, function0, f0Var2, startRestartGroup, (hq4.f0.d << 24) | 27648, 64);
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
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.account.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit d0;
                    d0 = ChangePhonePageKt.d0(i, (Composer) obj, ((Integer) obj2).intValue());
                    return d0;
                }
            });
        }
    }

    public static final void o0(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        int i2;
        org.jetbrains.compose.resources.b G;
        Object obj;
        String str;
        Composer startRestartGroup = composer.startRestartGroup(-552299916);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-552299916, i, -1, "com.dragon.read.kmp.mine.account.PhoneOptionLayout (ChangePhonePage.kt:682)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final com.dragon.read.kmp.mine.model.a aVar = (com.dragon.read.kmp.mine.model.a) f2.d.c(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.mine.model.a.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                if (StringsKt__StringsKt.isBlank((CharSequence) aVar.c.getValue())) {
                    Iterator<T> it2 = aVar.u.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            if (Intrinsics.areEqual('+' + ((com.dragon.read.kmp.mine.model.h) obj).a, aVar.t)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    com.dragon.read.kmp.mine.model.h hVar = (com.dragon.read.kmp.mine.model.h) obj;
                    aVar.d.setValue(hVar);
                    MutableState<String> mutableState = aVar.c;
                    StringBuilder sb = new StringBuilder();
                    sb.append('+');
                    if (hVar != null) {
                        str = hVar.a;
                    } else {
                        str = null;
                    }
                    sb.append(str);
                    mutableState.setValue(sb.toString());
                }
                e.c i3 = androidx.compose.ui.e.a.i();
                Modifier.a aVar2 = Modifier.Companion;
                Modifier F = SizeKt.F(aVar2, (e.b) null, false, 3, (Object) null);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(aVar);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.account.c0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit p0;
                            p0 = ChangePhonePageKt.p0(com.dragon.read.kmp.mine.model.a.this);
                            return p0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(F, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.h(), i3, startRestartGroup, 48);
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
                float f = 10;
                float g = x0.i.g(f);
                startRestartGroup.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(aVar2, g), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                String str2 = (String) aVar.c.getValue();
                og4.a aVar3 = og4.a.a;
                int i4 = og4.a.b;
                a6.j(str2, androidx.compose.foundation.layout.f2.v(aVar2, 0.0f, 0.0f, x0.i.g(2), 0.0f, 11, (Object) null), aVar3.h(startRestartGroup, i4).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199728, 0, 131024);
                if (aVar.s) {
                    composer2 = startRestartGroup;
                    composer2.startReplaceGroup(-668928603);
                    G = d2.H(f2.a.a);
                    i2 = 0;
                } else {
                    composer2 = startRestartGroup;
                    i2 = 0;
                    composer2.startReplaceGroup(-668926707);
                    G = d2.G(f2.a.a);
                }
                e1 a4 = org.jetbrains.compose.resources.c.a(G, composer2, i2);
                composer2.endReplaceGroup();
                z0.g(a4, "", SizeKt.s(androidx.compose.foundation.layout.f2.v(aVar2, 0.0f, x0.i.g(4), 0.0f, 0.0f, 13, (Object) null), x0.i.g(12)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar3.h(composer2, i4).j()), 0, composer2, 432, 184);
                float g2 = x0.i.g(f);
                composer2.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(aVar2, g2), composer2, i2);
                composer2.endReplaceGroup();
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.i(SizeKt.x(aVar2, x0.i.g(1)), x0.i.g(14)), androidx.compose.ui.graphics.l0.n(aVar3.h(composer2, i4).k(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer2, i2);
                float g3 = x0.i.g(f);
                composer2.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(aVar2, g3), composer2, i2);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.account.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit q0;
                    q0 = ChangePhonePageKt.q0(i, (Composer) obj2, ((Integer) obj3).intValue());
                    return q0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(com.dragon.read.kmp.mine.model.a aVar, androidx.compose.ui.focus.n nVar, MutableState mutableState) {
        aVar.l.setValue(new r0("", 0L, (e3) null, 6, (DefaultConstructorMarker) null));
        androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
        g0(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(boolean z, Function0 function0, com.dragon.read.kmp.mine.model.a aVar) {
        if (z) {
            function0.invoke();
        } else {
            aVar.i.setValue("请输入正确的手机号");
        }
        return Unit.INSTANCE;
    }

    public static final void R(final com.dragon.read.kmp.mine.model.a viewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(975318347);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(viewModel)) {
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
                ComposerKt.traceEventStart(975318347, i2, -1, "com.dragon.read.kmp.mine.account.ChangePhonePage (ChangePhonePage.kt:196)");
            }
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
            boolean changedInstance = startRestartGroup.changedInstance(nVar) | startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(lifecycleOwner) | startRestartGroup.changedInstance(coroutineScope);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.mine.account.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult S;
                        S = ChangePhonePageKt.S(lifecycleOwner, viewModel, coroutineScope, nVar, (DisposableEffectScope) obj);
                        return S;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, startRestartGroup, 6);
            pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(-528944004, true, new a(viewModel), startRestartGroup, 54), startRestartGroup, 48);
            if (!((Boolean) viewModel.e.getValue()).booleanValue()) {
                androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.account.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit U;
                    U = ChangePhonePageKt.U(com.dragon.read.kmp.mine.model.a.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return U;
                }
            });
        }
    }

    public static final void N(final FocusRequester focusRequester, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Composer startRestartGroup = composer.startRestartGroup(-2095408634);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(focusRequester)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
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
                ComposerKt.traceEventStart(-2095408634, i2, -1, "com.dragon.read.kmp.mine.account.CaptchaCodeInput (ChangePhonePage.kt:863)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final com.dragon.read.kmp.mine.model.a aVar = (com.dragon.read.kmp.mine.model.a) f2.d.c(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.mine.model.a.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                final u2 u2Var = (u2) startRestartGroup.consume(CompositionLocalsKt.p());
                final androidx.compose.ui.focus.n nVar = (androidx.compose.ui.focus.n) startRestartGroup.consume(CompositionLocalsKt.g());
                String str = (String) aVar.m.getValue();
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(aVar);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.mine.account.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit O;
                            O = ChangePhonePageKt.O(com.dragon.read.kmp.mine.model.a.this, (String) obj);
                            return O;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function1 function1 = (Function1) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changed = startRestartGroup.changed(u2Var) | startRestartGroup.changedInstance(nVar) | startRestartGroup.changedInstance(aVar);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.mine.account.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit P;
                            P = ChangePhonePageKt.P(u2Var, nVar, aVar, ((Boolean) obj).booleanValue());
                            return P;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function1 function12 = (Function1) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                if (aVar.s) {
                    i3 = 12;
                } else {
                    i3 = 32;
                }
                composer2 = startRestartGroup;
                CaptchaCodeViewKt.r(str, function1, (Modifier) null, 0, false, focusRequester, function12, 0.0f, 0L, 0L, k.g.c(x0.i.g(i3)), (g3) null, 0L, composer2, (i2 << 15) & 458752, 0, 7068);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.account.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Q;
                    Q = ChangePhonePageKt.Q(focusRequester, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Q;
                }
            });
        }
    }

    public static final void I0(final com.dragon.read.kmp.mine.model.a viewModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        org.jetbrains.compose.resources.b a2;
        List listOf;
        int i3;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-421935457);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(viewModel)) {
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
                ComposerKt.traceEventStart(-421935457, i2, -1, "com.dragon.read.kmp.mine.account.VerifySuccessPage (ChangePhonePage.kt:434)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier f = SizeKt.f(aVar, 0.0f, 1, (Object) null);
            og4.a aVar2 = og4.a.a;
            int i4 = og4.a.b;
            Modifier d2 = BackgroundKt.d(f, aVar2.h(startRestartGroup, i4).p3(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            e.a aVar3 = androidx.compose.ui.e.a;
            p0 i5 = androidx.compose.foundation.layout.m.i(aVar3.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, d2);
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
            g5.e(b2, i5, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.f(aVar, 0.0f, 1, (Object) null), x0.i.g(37), 0.0f, 2, (Object) null);
            e.b g = aVar3.g();
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            p0 a5 = androidx.compose.foundation.layout.x.a(eVar.i(), g, startRestartGroup, 48);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
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
            g5.e(b4, a5, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                b4.updateRememberedValue(Integer.valueOf(a6));
                b4.apply(Integer.valueOf(a6), b5);
            }
            g5.e(b4, e2, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            float f2 = 44;
            float g2 = x0.i.g(x0.i.g(f2) + x0.i.g(100));
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            if (viewModel.s) {
                startRestartGroup.startReplaceGroup(692090164);
                a2 = o1.b(w6.a);
            } else {
                startRestartGroup.startReplaceGroup(692091927);
                a2 = o1.a(w6.a);
            }
            e1 a8 = com.dragon.read.kmp.compose.common.image.e.a(a2, startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            int i6 = i2;
            z0.g(a8, "绑定成功图标", SizeKt.s(aVar, x0.i.g(80)), aVar3.e(), (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 3504, 240);
            float f3 = 20;
            float g3 = x0.i.g(f3);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g3), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
            androidx.compose.ui.text.font.c0 i7 = aVar4.i();
            long h = x0.x.h(20);
            long C = aVar2.h(startRestartGroup, i4).C();
            h.a aVar5 = w0.h.b;
            a6.j("绑定成功", (Modifier) null, C, h, (androidx.compose.ui.text.font.y) null, i7, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar5.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 130514);
            float g4 = x0.i.g(10);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g4), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            L("账号已绑定新手机号 ", "，后续可使用该手机号登录", ((String) viewModel.c.getValue()) + ' ' + ((r0) viewModel.l.getValue()).i(), 0, startRestartGroup, 54, 8);
            float g5 = x0.i.g(f3);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g5), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            e.c i8 = aVar3.i();
            e.f d3 = eVar.d();
            Modifier a9 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.x(aVar, x0.i.g(178)), x0.i.g(f2)), k.g.c(x0.i.g(12)));
            c0.a aVar6 = androidx.compose.ui.graphics.c0.b;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(aVar2.h(startRestartGroup, i4).a()), androidx.compose.ui.graphics.l0.j(aVar2.h(startRestartGroup, i4).e())});
            Modifier b6 = BackgroundKt.b(a9, c0.a.d(aVar6, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.account.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit J0;
                        J0 = ChangePhonePageKt.J0();
                        return J0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(b6, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
            p0 b7 = r2.b(d3, i8, startRestartGroup, 54);
            int a10 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, modifier);
            Function0 a11 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a11);
            } else {
                startRestartGroup.useNode();
            }
            Composer b8 = g5.b(startRestartGroup);
            g5.e(b8, b7, companion.c());
            g5.e(b8, currentCompositionLocalMap3, companion.e());
            Function2 b9 = companion.b();
            if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a10))) {
                b8.updateRememberedValue(Integer.valueOf(a10));
                b8.apply(Integer.valueOf(a10), b9);
            }
            g5.e(b8, e3, companion.d());
            w2 w2Var = w2.b;
            a6.j("完成", (Modifier) null, aVar2.h(startRestartGroup, i4).r(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, aVar4.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar5.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199686, 0, 130514);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            r0(viewModel, boxScopeInstance.b(aVar, aVar3.m()), composer2, i6 & 14, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.account.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit K0;
                    K0 = ChangePhonePageKt.K0(com.dragon.read.kmp.mine.model.a.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return K0;
                }
            });
        }
    }

    public static final void e0(final FocusRequester focusRequester, Composer composer, final int i) {
        int i2;
        boolean z;
        CreationExtras creationExtras;
        boolean z2;
        k.f c2;
        int i3;
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Composer startRestartGroup = composer.startRestartGroup(-52820435);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(focusRequester)) {
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
                ComposerKt.traceEventStart(-52820435, i2, -1, "com.dragon.read.kmp.mine.account.PhoneInput (ChangePhonePage.kt:730)");
            }
            HasDefaultViewModelProviderFactory c3 = f2.b.a.c(startRestartGroup, 6);
            if (c3 != null) {
                if (c3 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c3.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final com.dragon.read.kmp.mine.model.a aVar = (com.dragon.read.kmp.mine.model.a) f2.d.c(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.mine.model.a.class), c3, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                u2 u2Var = (u2) startRestartGroup.consume(CompositionLocalsKt.p());
                final androidx.compose.ui.focus.n nVar = (androidx.compose.ui.focus.n) startRestartGroup.consume(CompositionLocalsKt.g());
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1849434622);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                final MutableState mutableState3 = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                Boolean valueOf = Boolean.valueOf(f0(mutableState2));
                startRestartGroup.startReplaceGroup(-1746271574);
                if ((i2 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changed = z2 | startRestartGroup.changed(u2Var);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new ChangePhonePageKt$PhoneInput$1$1(focusRequester, u2Var, mutableState2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue4, startRestartGroup, 0);
                Modifier.a aVar2 = Modifier.Companion;
                Modifier i4 = SizeKt.i(aVar2, x0.i.g(54));
                startRestartGroup.startReplaceGroup(5004770);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.mine.account.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit i0;
                            i0 = ChangePhonePageKt.i0(mutableState, (androidx.compose.ui.layout.w) obj);
                            return i0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a2 = d1.a(i4, (Function1) rememberedValue5);
                if (aVar.s) {
                    c2 = k.g.c(x0.i.g(12));
                } else {
                    c2 = k.g.c(x0.i.g(28));
                }
                Modifier a3 = androidx.compose.ui.draw.e.a(a2, c2);
                og4.a aVar3 = og4.a.a;
                int i5 = og4.a.b;
                Modifier d2 = BackgroundKt.d(a3, aVar3.h(startRestartGroup, i5).w(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i6 = eVar.i();
                e.a aVar4 = androidx.compose.ui.e.a;
                p0 a4 = androidx.compose.foundation.layout.x.a(i6, aVar4.k(), startRestartGroup, 0);
                int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, d2);
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
                Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.h(aVar2, 0.0f, 1, (Object) null), 0.0f, x0.i.g(16), 1, (Object) null);
                p0 i7 = androidx.compose.foundation.layout.m.i(aVar4.o(), false);
                int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
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
                g5.e(b4, i7, companion2.c());
                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                Function2 b5 = companion2.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a7))) {
                    b4.updateRememberedValue(Integer.valueOf(a7));
                    b4.apply(Integer.valueOf(a7), b5);
                }
                g5.e(b4, e2, companion2.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier h = SizeKt.h(aVar2, 0.0f, 1, (Object) null);
                p0 b6 = r2.b(eVar.h(), aVar4.i(), startRestartGroup, 48);
                int a9 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(startRestartGroup, h);
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
                Composer b7 = g5.b(startRestartGroup);
                g5.e(b7, b6, companion2.c());
                g5.e(b7, currentCompositionLocalMap3, companion2.e());
                Function2 b8 = companion2.b();
                if (b7.getInserting() || !Intrinsics.areEqual(b7.rememberedValue(), Integer.valueOf(a9))) {
                    b7.updateRememberedValue(Integer.valueOf(a9));
                    b7.apply(Integer.valueOf(a9), b8);
                }
                g5.e(b7, e3, companion2.d());
                w2 w2Var = w2.b;
                o0(startRestartGroup, 0);
                Modifier a11 = androidx.compose.ui.focus.y.a(SizeKt.h(aVar2, 0.0f, 1, (Object) null), focusRequester);
                startRestartGroup.startReplaceGroup(5004770);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: com.dragon.read.kmp.mine.account.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit j0;
                            j0 = ChangePhonePageKt.j0(mutableState3, (androidx.compose.ui.focus.c0) obj);
                            return j0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceGroup();
                Modifier a12 = androidx.compose.ui.focus.c.a(a11, (Function1) rememberedValue6);
                g3 g3Var = new g3(aVar3.h(startRestartGroup, i5).k(), x0.x.h(16), androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777208, (DefaultConstructorMarker) null);
                r0 r0Var = (r0) aVar.l.getValue();
                g2 g2Var = new g2(androidx.compose.ui.graphics.n0.d(4294604549L), (DefaultConstructorMarker) null);
                androidx.compose.foundation.text.w2 w2Var2 = new androidx.compose.foundation.text.w2(0, (Boolean) null, androidx.compose.ui.text.input.y.b.e(), androidx.compose.ui.text.input.s.b.b(), (androidx.compose.ui.text.input.i0) null, (Boolean) null, (s0.f) null, 115, (DefaultConstructorMarker) null);
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance = startRestartGroup.changedInstance(aVar);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue7 == companion.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: com.dragon.read.kmp.mine.account.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit k0;
                            k0 = ChangePhonePageKt.k0(com.dragon.read.kmp.mine.model.a.this, (r0) obj);
                            return k0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                Function1 function1 = (Function1) rememberedValue7;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(5004770);
                boolean changedInstance2 = startRestartGroup.changedInstance(aVar);
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue8 == companion.getEmpty()) {
                    rememberedValue8 = new Function1() { // from class: com.dragon.read.kmp.mine.account.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            r0 l0;
                            l0 = ChangePhonePageKt.l0(com.dragon.read.kmp.mine.model.a.this, (r0) obj);
                            return l0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                startRestartGroup.endReplaceGroup();
                com.dragon.read.kmp.widget.j.d(r0Var, function1, (Function1) rememberedValue8, a12, 1, androidx.compose.runtime.internal.t.e(-429306095, true, new c(aVar), startRestartGroup, 54), g2Var, g3Var, w2Var2, startRestartGroup, 102457344, 0);
                startRestartGroup.endNode();
                startRestartGroup.startReplaceGroup(-1093572253);
                if (!StringsKt__StringsKt.isBlank(((r0) aVar.l.getValue()).i())) {
                    Modifier v = androidx.compose.foundation.layout.f2.v(boxScopeInstance.b(SizeKt.x(aVar2, x0.i.g(40)), aVar4.f()), 0.0f, 0.0f, x0.i.g(5), 0.0f, 11, (Object) null);
                    startRestartGroup.startReplaceGroup(-1746271574);
                    boolean changedInstance3 = startRestartGroup.changedInstance(aVar) | startRestartGroup.changedInstance(nVar);
                    Object rememberedValue9 = startRestartGroup.rememberedValue();
                    if (changedInstance3 || rememberedValue9 == companion.getEmpty()) {
                        rememberedValue9 = new Function0() { // from class: com.dragon.read.kmp.mine.account.r
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit m0;
                                m0 = ChangePhonePageKt.m0(com.dragon.read.kmp.mine.model.a.this, nVar, mutableState2);
                                return m0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue9);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier = ClickableKt.clickable-oSLSa3U$default(v, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue9, 15, (Object) null);
                    p0 i8 = androidx.compose.foundation.layout.m.i(aVar4.o(), false);
                    int a13 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier e4 = ComposedModifierKt.e(startRestartGroup, modifier);
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
                    g5.e(b9, i8, companion2.c());
                    g5.e(b9, currentCompositionLocalMap4, companion2.e());
                    Function2 b10 = companion2.b();
                    if (b9.getInserting() || !Intrinsics.areEqual(b9.rememberedValue(), Integer.valueOf(a13))) {
                        b9.updateRememberedValue(Integer.valueOf(a13));
                        b9.apply(Integer.valueOf(a13), b10);
                    }
                    g5.e(b9, e4, companion2.d());
                    z0.g(com.dragon.read.kmp.compose.common.image.e.a(o1.c(w6.a), startRestartGroup, 0), "清空输入框", boxScopeInstance.b(SizeKt.s(aVar2, x0.i.g(12)), aVar4.e()), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar3.h(startRestartGroup, i5).k(), 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
                    startRestartGroup.endNode();
                }
                startRestartGroup.endReplaceGroup();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.account.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n0;
                    n0 = ChangePhonePageKt.n0(focusRequester, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(u2 u2Var, androidx.compose.ui.focus.n nVar, com.dragon.read.kmp.mine.model.a aVar, boolean z) {
        if (z) {
            if (u2Var != null) {
                u2Var.hide();
            }
            androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
            aVar.G0(((String) aVar.c.getValue()) + ((r0) aVar.l.getValue()).i(), (String) aVar.m.getValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(androidx.compose.ui.focus.n nVar, com.dragon.read.kmp.mine.model.a aVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = d.a[event.ordinal()];
        if (i != 1) {
            if (i == 2) {
                aVar.J0();
            }
        } else {
            nVar.u(true);
            aVar.K0();
        }
    }

    private static final int R0(String str, int i, int i2, int i3) {
        int coerceIn;
        boolean z;
        int coerceIn2;
        int i4;
        coerceIn = RangesKt___RangesKt.coerceIn(i, 0, str.length());
        boolean z2 = true;
        if (coerceIn > 0 && str.charAt(coerceIn - 1) == ' ') {
            z = true;
        } else {
            z = false;
        }
        if (coerceIn >= str.length() || str.charAt(coerceIn) != ' ') {
            z2 = false;
        }
        String substring = str.substring(0, coerceIn);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int i5 = 0;
        for (int i6 = 0; i6 < substring.length(); i6++) {
            if (Character.isDigit(substring.charAt(i6))) {
                i5++;
            }
        }
        coerceIn2 = RangesKt___RangesKt.coerceIn(i5 + i3, 0, i2);
        if (coerceIn2 > 3) {
            i4 = coerceIn2 + 1;
        } else {
            i4 = coerceIn2;
        }
        if (coerceIn2 > 7) {
            i4++;
        }
        if (i2 > 3 && coerceIn2 == 3) {
            if (!z || z2) {
                return 3;
            }
            return 4;
        }
        if (i2 > 7 && coerceIn2 == 7) {
            if (z && !z2) {
                return 9;
            }
            return 8;
        }
        return i4;
    }

    public static final void u0(final String actionText, final Function0<Unit> onItemClick, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        CreationExtras creationExtras;
        int i3;
        int i4;
        final boolean z2;
        boolean z3;
        float f;
        List listOf;
        int i5;
        boolean z4;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Composer startRestartGroup = composer.startRestartGroup(-855368873);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(actionText)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i2 = i7 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onItemClick)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i2 |= i6;
        }
        int i8 = i2;
        if ((i8 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i8 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-855368873, i8, -1, "com.dragon.read.kmp.mine.account.VerifyButton (ChangePhonePage.kt:603)");
            }
            HasDefaultViewModelProviderFactory c2 = f2.b.a.c(startRestartGroup, 6);
            if (c2 != null) {
                if (c2 instanceof HasDefaultViewModelProviderFactory) {
                    creationExtras = c2.getDefaultViewModelCreationExtras();
                } else {
                    creationExtras = CreationExtras.b.a;
                }
                final com.dragon.read.kmp.mine.model.a aVar = (com.dragon.read.kmp.mine.model.a) f2.d.c(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.mine.model.a.class), c2, (String) null, (ViewModelProvider.Factory) null, creationExtras, startRestartGroup, 0, 0);
                ig4.f.a(startRestartGroup, 0);
                com.dragon.read.kmp.mine.model.h hVar = (com.dragon.read.kmp.mine.model.h) aVar.d.getValue();
                if (hVar != null) {
                    i3 = hVar.e;
                } else {
                    i3 = 1;
                }
                com.dragon.read.kmp.mine.model.h hVar2 = (com.dragon.read.kmp.mine.model.h) aVar.d.getValue();
                if (hVar2 != null) {
                    i4 = hVar2.f;
                } else {
                    i4 = Integer.MAX_VALUE;
                }
                String i9 = ((r0) aVar.l.getValue()).i();
                StringBuilder sb = new StringBuilder();
                int length = i9.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char charAt = i9.charAt(i10);
                    if (Character.isDigit(charAt)) {
                        sb.append(charAt);
                    }
                }
                int length2 = sb.toString().length();
                if (i3 <= length2 && length2 <= i4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (((String) aVar.m.getValue()).length() == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (((Boolean) aVar.f.getValue()).booleanValue()) {
                    z2 = z3;
                }
                if (z2) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                if (aVar.s) {
                    startRestartGroup.startReplaceGroup(-252350397);
                    og4.a aVar2 = og4.a.a;
                    int i11 = og4.a.b;
                    float f2 = f;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar2.h(startRestartGroup, i11).a(), f2, 0.0f, 0.0f, 0.0f, 14, (Object) null)), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar2.h(startRestartGroup, i11).e(), f2, 0.0f, 0.0f, 0.0f, 14, (Object) null))});
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-252169574);
                    og4.a aVar3 = og4.a.a;
                    int i12 = og4.a.b;
                    if (com.dragon.read.kmp.service.d1.d(aVar3.e(startRestartGroup, i12))) {
                        startRestartGroup.startReplaceGroup(-252132529);
                        float f3 = f;
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar3.h(startRestartGroup, i12).b3(), f3, 0.0f, 0.0f, 0.0f, 14, (Object) null)), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar3.h(startRestartGroup, i12).E1(), f3, 0.0f, 0.0f, 0.0f, 14, (Object) null))});
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-251940081);
                        float f4 = f;
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar3.h(startRestartGroup, i12).L1(), f4, 0.0f, 0.0f, 0.0f, 14, (Object) null)), androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar3.h(startRestartGroup, i12).L1(), f4, 0.0f, 0.0f, 0.0f, 14, (Object) null))});
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                }
                List list = listOf;
                e.c i13 = androidx.compose.ui.e.a.i();
                e.f d2 = androidx.compose.foundation.layout.e.a.d();
                Modifier.a aVar4 = Modifier.Companion;
                Modifier i14 = SizeKt.i(SizeKt.x(aVar4, x0.i.g(234)), x0.i.g(44));
                if (aVar.s) {
                    i5 = 12;
                } else {
                    i5 = 22;
                }
                Modifier b2 = BackgroundKt.b(androidx.compose.ui.draw.e.a(i14, k.g.c(x0.i.g(i5))), c0.a.d(androidx.compose.ui.graphics.c0.b, list, 0.0f, 0.0f, 0, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
                startRestartGroup.startReplaceGroup(-1746271574);
                boolean changed = startRestartGroup.changed(z2);
                if ((i8 & 112) == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean changedInstance = changed | z4 | startRestartGroup.changedInstance(aVar);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.account.v
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit v0;
                            v0 = ChangePhonePageKt.v0(z2, onItemClick, aVar);
                            return v0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(b2, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                p0 b3 = r2.b(d2, i13, startRestartGroup, 54);
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
                Composer b4 = g5.b(startRestartGroup);
                g5.e(b4, b3, companion.c());
                g5.e(b4, currentCompositionLocalMap, companion.e());
                Function2 b5 = companion.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a2))) {
                    b4.updateRememberedValue(Integer.valueOf(a2));
                    b4.apply(Integer.valueOf(a2), b5);
                }
                g5.e(b4, e, companion.d());
                w2 w2Var = w2.b;
                float g = x0.i.g(4);
                startRestartGroup.startReplaceGroup(-344996060);
                a3.a(SizeKt.x(aVar4, g), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
                if (((Boolean) aVar.k.getValue()).booleanValue()) {
                    startRestartGroup.startReplaceGroup(-591362497);
                    androidx.compose.material.a3.m(SizeKt.s(aVar4, x0.i.g(18)), og4.a.a.h(startRestartGroup, og4.a.b).r(), x0.i.g(2), 0L, 0, startRestartGroup, 390, 24);
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                } else {
                    startRestartGroup.startReplaceGroup(-591156440);
                    composer2 = startRestartGroup;
                    a6.j(actionText, (Modifier) null, og4.a.a.h(startRestartGroup, og4.a.b).r(), x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, (i8 & 14) | 199680, 0, 130514);
                    composer2.endReplaceGroup();
                }
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.account.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit w0;
                    w0 = ChangePhonePageKt.w0(actionText, onItemClick, i, (Composer) obj, ((Integer) obj2).intValue());
                    return w0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult S(LifecycleOwner lifecycleOwner, final com.dragon.read.kmp.mine.model.a aVar, CoroutineScope coroutineScope, final androidx.compose.ui.focus.n nVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.dragon.read.kmp.mine.account.e
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                ChangePhonePageKt.T(nVar, aVar, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        aVar.H0(coroutineScope);
        com.dragon.read.kmp.j.a.d(a, "ChangePhonePage onCreate");
        if (com.dragon.read.kmp.service.g0.a.c()) {
            ig4.g.b("kmp page", (ToastDuration) null, 2, (Object) null);
        }
        return new b(lifecycleOwner, lifecycleEventObserver, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(boolean z, com.dragon.read.kmp.mine.model.a aVar, Context context, androidx.compose.ui.focus.n nVar, u2 u2Var) {
        if (z) {
            aVar.G0(((String) aVar.c.getValue()) + ((r0) aVar.l.getValue()).i(), (String) aVar.m.getValue());
        } else if (((Boolean) aVar.k.getValue()).booleanValue()) {
            ig4.g.d(context, "手机号校验中，请稍等", (ToastDuration) null, 4, (Object) null);
        } else {
            androidx.compose.ui.focus.m.a(nVar, false, 1, (Object) null);
            if (u2Var != null) {
                u2Var.hide();
            }
            aVar.F0("user_click", ((String) aVar.c.getValue()) + ((r0) aVar.l.getValue()).i());
        }
        return Unit.INSTANCE;
    }

    public static final void V(final com.dragon.read.kmp.mine.model.a viewModel, final Function0<Unit> onDismissRequest, final Function0<Unit> onPositive, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(onPositive, "onPositive");
        Composer startRestartGroup = composer.startRestartGroup(-716220307);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(viewModel)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        int i6 = 16;
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(onDismissRequest)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(onPositive)) {
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
                ComposerKt.traceEventStart(-716220307, i2, -1, "com.dragon.read.kmp.mine.account.OpenBindingDialog (ChangePhonePage.kt:139)");
            }
            if (((Boolean) viewModel.a.getValue()).booleanValue()) {
                T0();
                x6 x6Var = x6.a;
                String c2 = org.jetbrains.compose.resources.j.c(y6.c(x6Var), startRestartGroup, 0);
                String c3 = org.jetbrains.compose.resources.j.c(y6.b(x6Var), startRestartGroup, 0);
                String c4 = org.jetbrains.compose.resources.j.c(y6.a(x6Var), startRestartGroup, 0);
                if (!viewModel.s) {
                    i6 = 8;
                }
                hq4.f0 f0Var = new hq4.f0(null, k.g.c(x0.i.g(i6)), null, 5, null);
                startRestartGroup.startReplaceGroup(5004770);
                if ((i2 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.mine.account.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit W;
                            W = ChangePhonePageKt.W(Function0.this);
                            return W;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(5004770);
                int i7 = i2 & 112;
                if (i7 == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.mine.account.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit X;
                            X = ChangePhonePageKt.X(Function0.this);
                            return X;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function0 function02 = (Function0) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(5004770);
                if (i7 == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.mine.account.a0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit Y;
                            Y = ChangePhonePageKt.Y(Function0.this);
                            return Y;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                hq4.f.f(c2, c3, c4, true, function0, function02, null, (Function0) rememberedValue3, f0Var, startRestartGroup, (hq4.f0.d << 24) | 3072, 64);
            } else {
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.account.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Z;
                    Z = ChangePhonePageKt.Z(com.dragon.read.kmp.mine.model.a.this, onDismissRequest, onPositive, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Z;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r0(final com.dragon.read.kmp.mine.model.a r33, androidx.compose.ui.Modifier r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.account.ChangePhonePageKt.r0(com.dragon.read.kmp.mine.model.a, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void L(java.lang.String r39, java.lang.String r40, final java.lang.String r41, int r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.account.ChangePhonePageKt.L(java.lang.String, java.lang.String, java.lang.String, int, androidx.compose.runtime.Composer, int, int):void");
    }
}
