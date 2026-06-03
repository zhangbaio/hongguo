package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.a6;
import androidx.compose.material.g5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileTabPageHeaderKt$ProfileTabPageHeaderV2$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<List<c7>> a;
    final /* synthetic */ GuestProfileViewModel b;
    final /* synthetic */ PagerState c;
    final /* synthetic */ State<Integer> d;
    final /* synthetic */ boolean e;

    ProfileTabPageHeaderKt$ProfileTabPageHeaderV2$1$1(MutableState<List<c7>> mutableState, GuestProfileViewModel guestProfileViewModel, PagerState pagerState, State<Integer> state, boolean z) {
        this.a = mutableState;
        this.b = guestProfileViewModel;
        this.c = pagerState;
        this.d = state;
        this.e = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        b(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void b(Composer composer, int i) {
        boolean z;
        List r;
        boolean z2;
        boolean z3;
        List r2;
        int t;
        boolean z4;
        boolean z5 = false;
        if ((i & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (composer.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1571087010, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderV2.<anonymous>.<anonymous> (ProfileTabPageHeader.kt:102)");
            }
            r = ProfileTabPageHeaderKt.r(this.a);
            if (!(r instanceof Collection) || !r.isEmpty()) {
                Iterator it2 = r.iterator();
                while (it2.hasNext()) {
                    Integer num = ((c7) it2.next()).b;
                    int value = ProfileTab.Select.getValue();
                    if (num != null && num.intValue() == value) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            r2 = ProfileTabPageHeaderKt.r(this.a);
            final GuestProfileViewModel guestProfileViewModel = this.b;
            final PagerState pagerState = this.c;
            State<Integer> state = this.d;
            boolean z6 = this.e;
            final int i2 = 0;
            for (Object obj : r2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                c7 c7Var = (c7) obj;
                t = ProfileTabPageHeaderKt.t(state);
                if (t == i2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Modifier F = SizeKt.F(Modifier.Companion, (e.b) null, z5, 3, (Object) null);
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(guestProfileViewModel) | composer.changed(pagerState) | composer.changed(i2);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.a0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = ProfileTabPageHeaderKt$ProfileTabPageHeaderV2$1$1.c(GuestProfileViewModel.this, pagerState, i2);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                g5.f(z4, (Function0) rememberedValue, F, false, (androidx.compose.foundation.interaction.i) null, 0L, 0L, androidx.compose.runtime.internal.t.e(1396657649, true, new a(pagerState, i2, c7Var, z3, z6), composer, 54), composer, 12583296, 120);
                i2 = i3;
                z6 = z6;
                state = state;
                pagerState = pagerState;
                guestProfileViewModel = guestProfileViewModel;
                z5 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    static final class a implements Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit> {
        final /* synthetic */ PagerState a;
        final /* synthetic */ int b;
        final /* synthetic */ c7 c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;

        a(PagerState pagerState, int i, c7 c7Var, boolean z, boolean z2) {
            this.a = pagerState;
            this.b = i;
            this.c = c7Var;
            this.d = z;
            this.e = z2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.b0 b0Var, Composer composer, Integer num) {
            a(b0Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.b0 Tab, Composer composer, int i) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(Tab, "$this$Tab");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1396657649, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderV2.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProfileTabPageHeader.kt:112)");
                }
                float d = com.dragon.read.kmp.utils.d.d(this.a, this.b);
                og4.a aVar = og4.a.a;
                int i2 = og4.a.b;
                long c = com.dragon.read.kmp.utils.d.c(aVar.h(composer, i2).h(), aVar.h(composer, i2).k(), d, composer, 0);
                Integer num = this.c.b;
                int value = ProfileTab.Select.getValue();
                if (num != null && num.intValue() == value) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c7 c7Var = this.c;
                boolean z3 = this.d;
                PagerState pagerState = this.a;
                int i3 = this.b;
                boolean z4 = this.e;
                Modifier.a aVar2 = Modifier.Companion;
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, aVar2);
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
                Composer b = androidx.compose.runtime.g5.b(composer);
                androidx.compose.runtime.g5.e(b, i4, companion.c());
                androidx.compose.runtime.g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                androidx.compose.runtime.g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String str = c7Var.a;
                if (str == null) {
                    str = "";
                }
                float f = 12;
                a6.j(str, SizeKt.B(androidx.compose.foundation.layout.f2.v(aVar2, x0.i.g(f), 0.0f, x0.i.g(f), x0.i.g(f), 2, (Object) null), (e.c) null, false, 3, (Object) null), c, x0.x.h(16), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199728, 0, 130512);
                composer.startReplaceGroup(-1938882778);
                if (z2 && z3) {
                    ProfileTabPageHeaderKt.v(pagerState, i3, z4, composer, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(GuestProfileViewModel guestProfileViewModel, PagerState pagerState, int i) {
        kotlinx.coroutines.i.e(guestProfileViewModel.e, null, null, new ProfileTabPageHeaderKt$ProfileTabPageHeaderV2$1$1$1$1$1$1(pagerState, i, null), 3, null);
        return Unit.INSTANCE;
    }
}
