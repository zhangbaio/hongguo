package com.dragon.read.kmp.profile.guestprofile.view.subpage;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
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
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.e0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {

    public static final class a implements DisposableEffectResult {
        public void dispose() {
        }
    }

    static {
        Covode.recordClassIndex(608176);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(MutableState mutableState, FilterOptionHeaderType filterOptionHeaderType, int i, Composer composer, int i2) {
        e(mutableState, filterOptionHeaderType, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Modifier modifier, int i, int i2, Composer composer, int i3) {
        h(modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(e0 e0Var, MutableState mutableState, FilterOptionHeaderType filterOptionHeaderType) {
        e0Var.f((FilterOptionHeaderType) mutableState.getValue(), filterOptionHeaderType);
        mutableState.setValue(filterOptionHeaderType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult i(e0 e0Var, Ref$ObjectRef ref$ObjectRef, rl4.c cVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        String c = e0Var.c();
        String b = FilterOptionHeaderType.Companion.b((FilterOptionHeaderType) ((MutableState) ref$ObjectRef.element).getValue());
        if (b == null) {
            b = "";
        }
        rVar.A(c, b, cVar.l);
        return new a();
    }

    public static final void e(final MutableState<FilterOptionHeaderType> filterOptionType, final FilterOptionHeaderType buttonFilterOption, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        c0 e;
        long j;
        boolean z2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(filterOptionType, "filterOptionType");
        Intrinsics.checkNotNullParameter(buttonFilterOption, "buttonFilterOption");
        Composer startRestartGroup = composer.startRestartGroup(550935450);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(filterOptionType)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(buttonFilterOption.ordinal())) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z3 = false;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(550935450, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.subpage.FilterOptionButton (ProfileFilterOption.kt:69)");
            }
            final e0 e0Var = (e0) startRestartGroup.consume(ProfileTabPagerKt.F());
            String a2 = el4.a.a(buttonFilterOption);
            long h = x.h(14);
            if (buttonFilterOption == filterOptionType.getValue()) {
                e = c0.b.d();
            } else {
                e = c0.b.e();
            }
            c0 c0Var = e;
            if (buttonFilterOption == filterOptionType.getValue()) {
                startRestartGroup.startReplaceGroup(1168005893);
                j = og4.a.a.h(startRestartGroup, og4.a.b).f();
            } else {
                startRestartGroup.startReplaceGroup(1168007104);
                j = og4.a.a.h(startRestartGroup, og4.a.b).j();
            }
            startRestartGroup.endReplaceGroup();
            long j2 = j;
            Modifier v = f2.v(Modifier.Companion, 0.0f, 0.0f, x0.i.g(12), 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed = startRestartGroup.changed(e0Var);
            if ((i2 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = z2 | changed;
            if ((i2 & 112) == 32) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit f;
                        f = e.f(e0.this, filterOptionType, buttonFilterOption);
                        return f;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j(a2, ClickableKt.clickable-oSLSa3U$default(v, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), j2, h, (y) null, c0Var, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = e.g(filterOptionType, buttonFilterOption, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r11v4, types: [T, androidx.compose.runtime.MutableState] */
    public static final void h(Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        boolean z;
        final Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(-229827459);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i3 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-229827459, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.subpage.ProfileFilterOption (ProfileFilterOption.kt:35)");
            }
            final e0 e0Var = (e0) startRestartGroup.consume(ProfileTabPagerKt.F());
            final rl4.c cVar = e0Var.a;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(cVar.j, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ref$ObjectRef.element = (MutableState) rememberedValue;
            int i6 = ((i3 & 14) | 384) >> 3;
            p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, (i6 & 112) | (i6 & 14));
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier3);
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
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            e((MutableState) ref$ObjectRef.element, FilterOptionHeaderType.LATEST_TYPE, startRestartGroup, 48);
            float f = 12;
            androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.x(SizeKt.i(f2.v(Modifier.Companion, 0.0f, 0.0f, x0.i.g(f), 0.0f, 11, (Object) null), x0.i.g(f)), x0.i.g(1)), og4.a.a.h(startRestartGroup, og4.a.b).i(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), startRestartGroup, 0);
            e((MutableState) ref$ObjectRef.element, FilterOptionHeaderType.HOTTEST_TYPE, startRestartGroup, 48);
            startRestartGroup.endNode();
            EffectsKt.DisposableEffect(Unit.INSTANCE, new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DisposableEffectResult i7;
                    i7 = e.i(e0.this, ref$ObjectRef, cVar, (DisposableEffectScope) obj);
                    return i7;
                }
            }, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = e.j(modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }
}
