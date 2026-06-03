package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<List<c7>> a;
    final /* synthetic */ GuestProfileViewModel b;
    final /* synthetic */ PagerState c;
    final /* synthetic */ State<Integer> d;
    final /* synthetic */ boolean e;
    final /* synthetic */ boolean f;

    ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2(MutableState<List<c7>> mutableState, GuestProfileViewModel guestProfileViewModel, PagerState pagerState, State<Integer> state, boolean z, boolean z2) {
        this.a = mutableState;
        this.b = guestProfileViewModel;
        this.c = pagerState;
        this.d = state;
        this.e = z;
        this.f = z2;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ c7 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ Animatable<androidx.compose.ui.graphics.l0, androidx.compose.animation.core.p> c;
        final /* synthetic */ boolean d;
        final /* synthetic */ PagerState e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;

        a(c7 c7Var, boolean z, Animatable<androidx.compose.ui.graphics.l0, androidx.compose.animation.core.p> animatable, boolean z2, PagerState pagerState, int i, boolean z3) {
            this.a = c7Var;
            this.b = z;
            this.c = animatable;
            this.d = z2;
            this.e = pagerState;
            this.f = i;
            this.g = z3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            boolean z2;
            androidx.compose.ui.text.font.c0 e;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1935669477, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderV1.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProfileTabPageHeader.kt:201)");
                }
                Integer num = this.a.b;
                int value = ProfileTab.Select.getValue();
                if (num != null && num.intValue() == value) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c7 c7Var = this.a;
                boolean z3 = this.b;
                Animatable<androidx.compose.ui.graphics.l0, androidx.compose.animation.core.p> animatable = this.c;
                boolean z4 = this.d;
                PagerState pagerState = this.e;
                int i2 = this.f;
                boolean z5 = this.g;
                Modifier.a aVar = Modifier.Companion;
                androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, aVar);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a2);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i3, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String str = c7Var.a;
                if (str == null) {
                    str = "";
                }
                String str2 = str;
                Modifier B = SizeKt.B(aVar, (e.c) null, false, 3, (Object) null);
                if (z3) {
                    e = androidx.compose.ui.text.font.c0.b.a();
                } else {
                    e = androidx.compose.ui.text.font.c0.b.e();
                }
                long h = x0.x.h(14);
                a6.j(str2, B, ((androidx.compose.ui.graphics.l0) animatable.k()).x(), h, (androidx.compose.ui.text.font.y) null, e, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 3120, 0, 131024);
                composer.startReplaceGroup(-101993416);
                if (z2 && z4) {
                    ProfileTabPageHeaderKt.v(pagerState, i2, z5, composer, 0);
                }
                composer.endReplaceGroup();
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

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        b(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void b(Composer composer, int i) {
        boolean z;
        List p;
        boolean z2;
        if ((i & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (composer.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-584729771, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderV1.<anonymous>.<anonymous> (ProfileTabPageHeader.kt:181)");
            }
            p = ProfileTabPageHeaderKt.p(this.a);
            final GuestProfileViewModel guestProfileViewModel = this.b;
            final PagerState pagerState = this.c;
            State<Integer> state = this.d;
            boolean z3 = this.e;
            boolean z4 = this.f;
            final int i2 = 0;
            for (Object obj : p) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                c7 c7Var = (c7) obj;
                if (ProfileTabPageHeaderKt.n(state) == i2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                og4.a aVar = og4.a.a;
                int i4 = og4.a.b;
                long k = aVar.h(composer, i4).k();
                long h = aVar.h(composer, i4).h();
                composer.startReplaceGroup(1849434622);
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = androidx.compose.animation.h0.a(k);
                    composer.updateRememberedValue(rememberedValue);
                }
                Animatable animatable = (Animatable) rememberedValue;
                composer.endReplaceGroup();
                Boolean valueOf = Boolean.valueOf(z2);
                boolean z5 = z4;
                composer.startReplaceGroup(-1224400529);
                boolean changedInstance = composer.changedInstance(animatable) | composer.changed(z2) | composer.changed(k) | composer.changed(h);
                State<Integer> state2 = state;
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2$1$1$1(animatable, z2, k, h, null);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, composer, 0);
                Modifier a2 = androidx.compose.ui.o.a(Modifier.Companion, 2.0f);
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(guestProfileViewModel) | composer.changed(pagerState) | composer.changed(i2);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2.c(GuestProfileViewModel.this, pagerState, i2);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                androidx.compose.material.g5.e(z2, (Function0) rememberedValue3, a2, false, androidx.compose.runtime.internal.t.e(-1935669477, true, new a(c7Var, z2, animatable, z3, pagerState, i2, z5), composer, 54), (Function2) null, (androidx.compose.foundation.interaction.i) null, 0L, 0L, composer, 24960, 488);
                i2 = i3;
                pagerState = pagerState;
                z4 = z5;
                z3 = z3;
                state = state2;
                guestProfileViewModel = guestProfileViewModel;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(GuestProfileViewModel guestProfileViewModel, PagerState pagerState, int i) {
        kotlinx.coroutines.i.e(guestProfileViewModel.e, null, null, new ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2$1$2$1$1(pagerState, i, null), 3, null);
        return Unit.INSTANCE;
    }
}
