package com.dragon.read.kmp.profile.guestprofile.view;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.pager.PagerState;
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
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.Gender;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.eo;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.ug0;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListLayoutKt;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.compose.ui.BubbleGravity;
import com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.kmp.service.KmpDialogServiceKt;
import com.dragon.read.kmp.service.h;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import w0.h;
import w0.s;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesGuestProfilePageKt {
    private static final float a;
    private static final float b;
    private static final float c;
    private static final float d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        A0(guestProfileViewModel, f0Var, collapsibleListState, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, CollapsibleListState collapsibleListState, Modifier modifier, int i2, Composer composer, int i3) {
        M(guestProfileViewModel, f0Var, collapsibleListState, modifier, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        N0(guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        Q0(guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(GuestProfileViewModel guestProfileViewModel, CollapsibleListState collapsibleListState, float f2, Modifier modifier, int i2, Composer composer, int i3) {
        S(guestProfileViewModel, collapsibleListState, f2, modifier, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(String str, String str2, boolean z, Function0 function0, int i2, Composer composer, int i3) {
        W(str, str2, z, function0, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(String str, String str2, boolean z, Function0 function0, Function0 function02, int i2, int i3, Composer composer, int i4) {
        Y(str, str2, z, function0, function02, composer, androidx.compose.runtime.x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(PagerState pagerState, CollapsibleListState collapsibleListState, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        h1(pagerState, collapsibleListState, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(String str, String str2, Function0 function0, Function0 function02, int i2, Composer composer, int i3) {
        i0(str, str2, function0, function02, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(String str, String str2, Function0 function0, int i2, Composer composer, int i3) {
        k0(str, str2, function0, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(PagerState pagerState, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        l1(pagerState, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(androidx.compose.foundation.layout.r rVar, GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        m0(rVar, guestProfileViewModel, f0Var, collapsibleListState, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(PagerState pagerState, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        l1(pagerState, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(androidx.compose.foundation.layout.r rVar, GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        m0(rVar, guestProfileViewModel, f0Var, collapsibleListState, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(CollapsibleListState collapsibleListState, GuestProfileViewModel guestProfileViewModel, int i2, Composer composer, int i3) {
        o1(collapsibleListState, guestProfileViewModel, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        q0(guestProfileViewModel, f0Var, collapsibleListState, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z() {
        return Unit.INSTANCE;
    }

    public static final float j1() {
        return a;
    }

    public static final float k1() {
        return c;
    }

    public static final class h implements DisposableEffectResult {
        final /* synthetic */ GuestProfileViewModel a;

        public void dispose() {
            this.a.I0();
        }

        public h(GuestProfileViewModel guestProfileViewModel) {
            this.a = guestProfileViewModel;
        }
    }

    static final class k implements com.dragon.read.kmp.service.h {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ String b;
        final /* synthetic */ ym4.k c;

        k(boolean[] zArr, String str, ym4.k kVar) {
            this.a = zArr;
            this.b = str;
            this.c = kVar;
        }

        @Override // com.dragon.read.kmp.service.h
        public boolean a() {
            return h.a.a(this);
        }

        @Override // com.dragon.read.kmp.service.h
        public final void onDismiss() {
            boolean[] zArr = this.a;
            if (!zArr[0]) {
                zArr[0] = true;
                com.dragon.read.kmp.r.a.D(this.b, "暂不关注", this.c);
            }
        }
    }

    static {
        Covode.recordClassIndex(608173);
        a = x0.i.g(16);
        b = x0.i.g(44);
        c = x0.i.g(20);
        d = x0.i.g(com.dragon.read.kmp.service.b1.a.s());
    }

    static final class b implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
        final /* synthetic */ MutableState<List<fl4.j>> a;
        final /* synthetic */ GuestProfileViewModel b;
        final /* synthetic */ boolean c;

        b(MutableState<List<fl4.j>> mutableState, GuestProfileViewModel guestProfileViewModel, boolean z) {
            this.a = mutableState;
            this.b = guestProfileViewModel;
            this.c = z;
        }

        public static final class a implements Function1<Integer, Object> {
            final /* synthetic */ List a;

            public a(List list) {
                this.a = list;
            }

            public final Object a(int i) {
                this.a.get(i);
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return a(num.intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(GuestProfileViewModel guestProfileViewModel) {
            guestProfileViewModel.X();
            guestProfileViewModel.f1("close");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
            c(eVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(MutableState mutableState, GuestProfileViewModel guestProfileViewModel, androidx.compose.foundation.lazy.o0 LazyRow) {
            Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
            List T = SeriesGuestProfilePageKt.T(mutableState);
            LazyRow.f(T.size(), (Function1) null, new a(T), androidx.compose.runtime.internal.t.c(2039820996, true, new C0030b(T, guestProfileViewModel, mutableState)));
            return Unit.INSTANCE;
        }

        public final void c(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
            long k;
            long k2;
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-188482357, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.FollowedRecommendList.<anonymous> (SeriesGuestProfilePage.kt:998)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            final MutableState<List<fl4.j>> mutableState = this.a;
            final GuestProfileViewModel guestProfileViewModel = this.b;
            boolean z = this.c;
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i2 = eVar.i();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), composer, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(composer, h);
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
            float g = x0.i.g(24);
            composer.startReplaceGroup(-1814856593);
            androidx.compose.foundation.layout.a3.a(SizeKt.i(aVar, g), composer, 0);
            composer.endReplaceGroup();
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), SeriesGuestProfilePageKt.j1(), 0.0f, SeriesGuestProfilePageKt.j1(), 0.0f, 10, (Object) null);
            androidx.compose.ui.layout.p0 b3 = androidx.compose.foundation.layout.r2.b(eVar.h(), aVar2.i(), composer, 48);
            int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(composer, v);
            Function0 a6 = companion.a();
            if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(a6);
            } else {
                composer.useNode();
            }
            Composer b4 = g5.b(composer);
            g5.e(b4, b3, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a5))) {
                b4.updateRememberedValue(Integer.valueOf(a5));
                b4.apply(Integer.valueOf(a5), b5);
            }
            g5.e(b4, e2, companion.d());
            androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
            long h2 = x0.x.h(14);
            androidx.compose.ui.text.font.c0 d = androidx.compose.ui.text.font.c0.b.d();
            if (z) {
                composer.startReplaceGroup(1554358483);
                k = og4.a.a.h(composer, og4.a.b).R();
            } else {
                composer.startReplaceGroup(1554359786);
                k = og4.a.a.h(composer, og4.a.b).k();
            }
            composer.endReplaceGroup();
            a6.j("你可能感兴趣的人", androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), k, h2, (androidx.compose.ui.text.font.y) null, d, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199686, 0, 131024);
            androidx.compose.ui.graphics.e1 a7 = org.jetbrains.compose.resources.c.a(yo2.d2.q(f2.a.a), composer, 0);
            if (z) {
                composer.startReplaceGroup(1554370129);
                k2 = og4.a.a.h(composer, og4.a.b).N0();
            } else {
                composer.startReplaceGroup(1554371569);
                k2 = og4.a.a.h(composer, og4.a.b).k();
            }
            androidx.compose.ui.graphics.m0 d2 = ig4.i.d(k2);
            composer.endReplaceGroup();
            Modifier s = SizeKt.s(aVar, x0.i.g(16));
            composer.startReplaceGroup(5004770);
            boolean changed = composer.changed(guestProfileViewModel);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.b3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d3;
                        d3 = SeriesGuestProfilePageKt.b.d(GuestProfileViewModel.this);
                        return d3;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            androidx.compose.foundation.z0.g(a7, "更多", ClickableKt.clickable-oSLSa3U$default(s, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, d2, 0, composer, 48, 184);
            composer.endNode();
            float g2 = x0.i.g(12);
            composer.startReplaceGroup(-1814856593);
            androidx.compose.foundation.layout.a3.a(SizeKt.i(aVar, g2), composer, 0);
            composer.endReplaceGroup();
            Modifier h3 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            composer.startReplaceGroup(-1633490746);
            boolean changed2 = composer.changed(mutableState) | composer.changed(guestProfileViewModel);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.c3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e3;
                        e3 = SeriesGuestProfilePageKt.b.e(mutableState, guestProfileViewModel, (androidx.compose.foundation.lazy.o0) obj);
                        return e3;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            androidx.compose.foundation.lazy.d.e(h3, (LazyListState) null, (androidx.compose.foundation.layout.i2) null, false, (e.e) null, (e.c) null, (androidx.compose.foundation.gestures.l1) null, false, (androidx.compose.foundation.y1) null, (Function1) rememberedValue2, composer, 6, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* renamed from: com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt$b$b, reason: collision with other inner class name */
        public static final class C0030b implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
            final /* synthetic */ List a;
            final /* synthetic */ GuestProfileViewModel b;
            final /* synthetic */ MutableState c;

            public C0030b(List list, GuestProfileViewModel guestProfileViewModel, MutableState mutableState) {
                this.a = list;
                this.b = guestProfileViewModel;
                this.c = mutableState;
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
                a(fVar, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
                int i3;
                boolean z;
                float g;
                float g2;
                int i4;
                int i5;
                if ((i2 & 6) == 0) {
                    if (composer.changed(fVar)) {
                        i5 = 4;
                    } else {
                        i5 = 2;
                    }
                    i3 = i2 | i5;
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
                        ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    int i6 = (i3 & 112) | (i3 & 14);
                    fl4.j jVar = (fl4.j) this.a.get(i);
                    composer.startReplaceGroup(-690853472);
                    GuestProfileViewModel guestProfileViewModel = this.b;
                    Modifier.a aVar = Modifier.Companion;
                    if (i == 0) {
                        g = SeriesGuestProfilePageKt.j1();
                    } else {
                        g = x0.i.g(8);
                    }
                    if (i == SeriesGuestProfilePageKt.T(this.c).size() - 1) {
                        g2 = SeriesGuestProfilePageKt.j1();
                    } else {
                        g2 = x0.i.g(0);
                    }
                    fl4.g.e(jVar, guestProfileViewModel, androidx.compose.foundation.layout.f2.v(aVar, g, 0.0f, g2, 0.0f, 10, (Object) null), composer, (i6 >> 6) & 14, 0);
                    composer.endReplaceGroup();
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

    static final class d implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Function0<Unit> c;
        final /* synthetic */ Function0<Unit> d;

        d(String str, String str2, Function0<Unit> function0, Function0<Unit> function02) {
            this.a = str;
            this.b = str2;
            this.c = function0;
            this.d = function02;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1645571015, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.GuardFollowConfirmDialog.<anonymous> (SeriesGuestProfilePage.kt:678)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                String str = this.a;
                String str2 = this.b;
                final Function0<Unit> function0 = this.c;
                final Function0<Unit> function02 = this.d;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i2 = eVar.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, h);
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
                float f = 32;
                Modifier u = androidx.compose.foundation.layout.f2.u(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(f), x0.i.g(f), x0.i.g(20));
                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(eVar.p(x0.i.g(12)), aVar2.k(), composer, 6);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, u);
                Function0 a6 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a6);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, a4, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                og4.a aVar3 = og4.a.a;
                int i3 = og4.a.b;
                long k = aVar3.h(composer, i3).k();
                long h2 = x0.x.h(18);
                c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
                androidx.compose.ui.text.font.c0 d = aVar4.d();
                h.a aVar5 = w0.h.b;
                a6.j(str, SizeKt.h(aVar, 0.0f, 1, (Object) null), k, h2, (androidx.compose.ui.text.font.y) null, d, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar5.a()), 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199728, 0, 130512);
                a6.j(str2, SizeKt.h(aVar, 0.0f, 1, (Object) null), androidx.compose.ui.graphics.l0.n(aVar3.h(composer, i3).k(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar5.a()), x0.x.h(22), 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 3120, 6, 129520);
                composer.endNode();
                float f2 = (float) 0.5d;
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f2)), androidx.compose.ui.graphics.l0.n(aVar3.h(composer, i3).k(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                Modifier h3 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                androidx.compose.ui.layout.p0 b5 = androidx.compose.foundation.layout.r2.b(eVar.h(), aVar2.i(), composer, 48);
                int a7 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, h3);
                Function0 a8 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a8);
                } else {
                    composer.useNode();
                }
                Composer b6 = g5.b(composer);
                g5.e(b6, b5, companion.c());
                g5.e(b6, currentCompositionLocalMap3, companion.e());
                Function2 b7 = companion.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a7))) {
                    b6.updateRememberedValue(Integer.valueOf(a7));
                    b6.apply(Integer.valueOf(a7), b7);
                }
                g5.e(b6, e3, companion.d());
                androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
                long k2 = aVar3.h(composer, i3).k();
                long h4 = x0.x.h(16);
                int a9 = aVar5.a();
                Modifier a10 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(function0);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.d3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d2;
                            d2 = SeriesGuestProfilePageKt.d.d(Function0.this);
                            return d2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                float f3 = 16;
                a6.j("暂不关注", androidx.compose.foundation.layout.f2.t(ClickableKt.clickable-oSLSa3U$default(a10, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), 0.0f, x0.i.g(f3), 1, (Object) null), k2, h4, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a9), 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 3078, 0, 130544);
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.i(SizeKt.x(aVar, x0.i.g(f2)), x0.i.g(f3)), androidx.compose.ui.graphics.l0.n(aVar3.h(composer, i3).k(), 0.06f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                long f4 = aVar3.h(composer, i3).f();
                long h5 = x0.x.h(16);
                androidx.compose.ui.text.font.c0 d2 = aVar4.d();
                int a11 = aVar5.a();
                Modifier a12 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changed2 = composer.changed(function02);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.e3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e4;
                            e4 = SeriesGuestProfilePageKt.d.e(Function0.this);
                            return e4;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                a6.j("立即关注", androidx.compose.foundation.layout.f2.t(ClickableKt.clickable-oSLSa3U$default(a12, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), 0.0f, x0.i.g(f3), 1, (Object) null), f4, h5, (androidx.compose.ui.text.font.y) null, d2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a11), 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199686, 0, 130512);
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

    static final class e implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function0<Unit> a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        e(Function0<Unit> function0, String str, String str2) {
            this.a = function0;
            this.b = str;
            this.c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-208266756, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.GuardUnavailableDialog.<anonymous> (SeriesGuestProfilePage.kt:755)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                final Function0<Unit> function0 = this.a;
                String str = this.b;
                String str2 = this.c;
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.m i2 = eVar.i();
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, h);
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
                float f = 32;
                Modifier u = androidx.compose.foundation.layout.f2.u(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(f), x0.i.g(f), x0.i.g(20));
                androidx.compose.ui.layout.p0 a4 = androidx.compose.foundation.layout.x.a(eVar.p(x0.i.g(12)), aVar2.k(), composer, 6);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, u);
                Function0 a6 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a6);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, a4, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a5))) {
                    b3.updateRememberedValue(Integer.valueOf(a5));
                    b3.apply(Integer.valueOf(a5), b4);
                }
                g5.e(b3, e2, companion.d());
                og4.a aVar3 = og4.a.a;
                int i3 = og4.a.b;
                long k = aVar3.h(composer, i3).k();
                long h2 = x0.x.h(18);
                c0.a aVar4 = androidx.compose.ui.text.font.c0.b;
                androidx.compose.ui.text.font.c0 d = aVar4.d();
                h.a aVar5 = w0.h.b;
                a6.j(str, SizeKt.h(aVar, 0.0f, 1, (Object) null), k, h2, (androidx.compose.ui.text.font.y) null, d, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar5.a()), 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199728, 0, 130512);
                a6.j(str2, SizeKt.h(aVar, 0.0f, 1, (Object) null), androidx.compose.ui.graphics.l0.n(aVar3.h(composer, i3).k(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), x0.x.h(14), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(aVar5.a()), x0.x.h(22), 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 3120, 6, 129520);
                composer.endNode();
                androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g((float) 0.5d)), androidx.compose.ui.graphics.l0.n(aVar3.h(composer, i3).k(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                long f2 = aVar3.h(composer, i3).f();
                long h3 = x0.x.h(16);
                androidx.compose.ui.text.font.c0 d2 = aVar4.d();
                int a7 = aVar5.a();
                Modifier h4 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(function0);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.f3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = SeriesGuestProfilePageKt.e.c(Function0.this);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                a6.j("我知道了", androidx.compose.foundation.layout.f2.t(ClickableKt.clickable-oSLSa3U$default(h4, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), 0.0f, x0.i.g(16), 1, (Object) null), f2, h3, (androidx.compose.ui.text.font.y) null, d2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(a7), 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199686, 0, 130512);
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

    static final class m implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        m(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(com.dragon.read.kmp.service.g gVar) {
            gVar.a();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.service.g gVar, Composer composer, Integer num) {
            b(gVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(final com.dragon.read.kmp.service.g controller, Composer composer, int i) {
            boolean z;
            boolean changedInstance;
            int i2;
            Intrinsics.checkNotNullParameter(controller, "controller");
            if ((i & 6) == 0) {
                if ((i & 8) == 0) {
                    changedInstance = composer.changed(controller);
                } else {
                    changedInstance = composer.changedInstance(controller);
                }
                if (changedInstance) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            boolean z2 = true;
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(815451786, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.showGuardUnavailableDialog.<anonymous> (SeriesGuestProfilePage.kt:656)");
                }
                String str = this.a;
                String str2 = this.b;
                composer.startReplaceGroup(5004770);
                if ((i & 14) != 4 && ((i & 8) == 0 || !composer.changedInstance(controller))) {
                    z2 = false;
                }
                Object rememberedValue = composer.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.l3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = SeriesGuestProfilePageKt.m.c(com.dragon.read.kmp.service.g.this);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                SeriesGuestProfilePageKt.k0(str, str2, (Function0) rememberedValue, composer, 0);
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
    public static final Unit E0(GuestProfileViewModel guestProfileViewModel) {
        guestProfileViewModel.z0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(GuestProfileViewModel guestProfileViewModel) {
        guestProfileViewModel.E0();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(GuestProfileViewModel guestProfileViewModel) {
        guestProfileViewModel.W();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Boolean, Integer> N(MutableState<Pair<Boolean, Integer>> mutableState) {
        return (Pair) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 R(MutableState<com.dragon.read.kmp.profile.guestprofile.viewmodel.g0> mutableState) {
        return (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 R0(State<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> state) {
        return (com.dragon.read.kmp.profile.guestprofile.viewmodel.f0) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int S0(GuestProfileViewModel guestProfileViewModel) {
        return guestProfileViewModel.q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<fl4.j> T(MutableState<List<fl4.j>> mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(MutableState mutableState) {
        b0(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final boolean B0(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(GuestProfileViewModel guestProfileViewModel) {
        guestProfileViewModel.S.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(final GuestProfileViewModel guestProfileViewModel) {
        guestProfileViewModel.C0(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.e2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit H0;
                H0 = SeriesGuestProfilePageKt.H0(GuestProfileViewModel.this, (String) obj, (String) obj2);
                return H0;
            }
        }, new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.f2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit J0;
                J0 = SeriesGuestProfilePageKt.J0((String) obj, (String) obj2);
                return J0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(GuestProfileViewModel guestProfileViewModel) {
        com.dragon.read.kmp.profile.params.a aVar = guestProfileViewModel.f;
        if (aVar != null) {
            aVar.b(guestProfileViewModel.r0());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final boolean U(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a0(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float c0(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final float r0(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ MutableState<Boolean> b;
        final /* synthetic */ com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 c;
        final /* synthetic */ GuestProfileViewModel d;
        final /* synthetic */ MutableState<Pair<Boolean, Integer>> e;

        a(Modifier modifier, MutableState<Boolean> mutableState, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, GuestProfileViewModel guestProfileViewModel, MutableState<Pair<Boolean, Integer>> mutableState2) {
            this.a = modifier;
            this.b = mutableState;
            this.c = f0Var;
            this.d = guestProfileViewModel;
            this.e = mutableState2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int d(int i) {
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int e(int i) {
            return i;
        }

        /* renamed from: com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt$a$a, reason: collision with other inner class name */
        static final class C0029a implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
            final /* synthetic */ com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 a;
            final /* synthetic */ GuestProfileViewModel b;
            final /* synthetic */ MutableState<Pair<Boolean, Integer>> c;

            C0029a(com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, GuestProfileViewModel guestProfileViewModel, MutableState<Pair<Boolean, Integer>> mutableState) {
                this.a = f0Var;
                this.b = guestProfileViewModel;
                this.c = mutableState;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c(GuestProfileViewModel guestProfileViewModel) {
                Integer num;
                com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 g0Var = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) guestProfileViewModel.j.getValue();
                if (g0Var != null) {
                    num = g0Var.d;
                } else {
                    num = null;
                }
                guestProfileViewModel.N0(num, "follow_guide_popup");
                guestProfileViewModel.b1();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
                b(eVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void b(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
                Integer num;
                Modifier v;
                ok0 ok0Var;
                Integer num2;
                String str;
                String str2;
                Composer composer2;
                Integer num3;
                boolean z;
                Modifier d;
                List listOf;
                cj0 cj0Var;
                ok0 ok0Var2;
                cj0 cj0Var2;
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(486065827, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.FollowGuideBottomTips.<anonymous>.<anonymous>.<anonymous> (SeriesGuestProfilePage.kt:1100)");
                }
                xs4.f b = sg4.a.b(false, 1, (Object) null);
                if (b != null) {
                    num = Integer.valueOf(b.i);
                } else {
                    num = null;
                }
                Modifier.a aVar = Modifier.Companion;
                if (num != null) {
                    v = SizeKt.x(aVar, x0.i.g(num.intValue()));
                } else {
                    v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), SeriesGuestProfilePageKt.j1(), 0.0f, SeriesGuestProfilePageKt.j1(), SeriesGuestProfilePageKt.j1(), 2, (Object) null);
                }
                float f = 4;
                float f2 = 10;
                Modifier b2 = androidx.compose.ui.draw.q.b(aVar.then(v), x0.i.g(f), k.g.c(x0.i.g(f2)), false, 0L, 0L, 24, (Object) null);
                com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var = this.a;
                final GuestProfileViewModel guestProfileViewModel = this.b;
                MutableState<Pair<Boolean, Integer>> mutableState = this.c;
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, b2);
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
                Composer b3 = g5.b(composer);
                g5.e(b3, i2, companion.c());
                g5.e(b3, currentCompositionLocalMap, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a))) {
                    b3.updateRememberedValue(Integer.valueOf(a));
                    b3.apply(Integer.valueOf(a), b4);
                }
                g5.e(b3, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                og4.a aVar3 = og4.a.a;
                int i3 = og4.a.b;
                float f3 = 15;
                Modifier u = androidx.compose.foundation.layout.f2.u(androidx.compose.ui.draw.e.a(BackgroundKt.c(h, aVar3.h(composer, i3).b(), k.g.c(x0.i.g(f2))), k.g.c(x0.i.g(f2))), SeriesGuestProfilePageKt.j1(), x0.i.g(f3), SeriesGuestProfilePageKt.j1(), x0.i.g(f3));
                e.c i4 = aVar2.i();
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                androidx.compose.ui.layout.p0 b5 = androidx.compose.foundation.layout.r2.b(eVar.f(), i4, composer, 54);
                int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, u);
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
                Composer b6 = g5.b(composer);
                g5.e(b6, b5, companion.c());
                g5.e(b6, currentCompositionLocalMap2, companion.e());
                Function2 b7 = companion.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a3))) {
                    b6.updateRememberedValue(Integer.valueOf(a3));
                    b6.apply(Integer.valueOf(a3), b7);
                }
                g5.e(b6, e2, companion.d());
                androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
                Modifier s = SizeKt.s(aVar, x0.i.g(40));
                androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a5 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier e3 = ComposedModifierKt.e(composer, s);
                Function0 a6 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a6);
                } else {
                    composer.useNode();
                }
                Composer b8 = g5.b(composer);
                g5.e(b8, i5, companion.c());
                g5.e(b8, currentCompositionLocalMap3, companion.e());
                Function2 b9 = companion.b();
                if (b8.getInserting() || !Intrinsics.areEqual(b8.rememberedValue(), Integer.valueOf(a5))) {
                    b8.updateRememberedValue(Integer.valueOf(a5));
                    b8.apply(Integer.valueOf(a5), b9);
                }
                g5.e(b8, e3, companion.d());
                eo eoVar = f0Var.a;
                if (eoVar != null && (cj0Var2 = eoVar.a) != null) {
                    ok0Var = cj0Var2.b;
                } else {
                    ok0Var = null;
                }
                ProfileUserHeaderKt.B(guestProfileViewModel, f0Var, ok0Var, composer, 0);
                composer.endNode();
                float g = x0.i.g(f2);
                composer.startReplaceGroup(-344996060);
                androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar, g), composer, 0);
                composer.endReplaceGroup();
                eo eoVar2 = f0Var.a;
                if (eoVar2 != null && (cj0Var = eoVar2.a) != null && (ok0Var2 = cj0Var.b) != null) {
                    num2 = ok0Var2.e;
                } else {
                    num2 = null;
                }
                int value = Gender.MALE.getValue();
                if (num2 != null && num2.intValue() == value) {
                    str = "他";
                } else {
                    int value2 = Gender.FEMALE.getValue();
                    if (num2 != null && num2.intValue() == value2) {
                        str = "她";
                    } else {
                        str = "TA";
                    }
                }
                if (((Number) SeriesGuestProfilePageKt.N(mutableState).getSecond()).intValue() == 2) {
                    str2 = "已看" + str + "很久了，加个关注吧";
                } else {
                    str2 = "已看过" + str + "多次，加个关注吧";
                }
                String str3 = str2;
                Modifier a7 = androidx.compose.foundation.layout.u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                androidx.compose.ui.layout.p0 a8 = androidx.compose.foundation.layout.x.a(eVar.d(), aVar2.k(), composer, 6);
                int a9 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier e4 = ComposedModifierKt.e(composer, a7);
                Function0 a10 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a10);
                } else {
                    composer.useNode();
                }
                Composer b10 = g5.b(composer);
                g5.e(b10, a8, companion.c());
                g5.e(b10, currentCompositionLocalMap4, companion.e());
                Function2 b11 = companion.b();
                if (b10.getInserting() || !Intrinsics.areEqual(b10.rememberedValue(), Integer.valueOf(a9))) {
                    b10.updateRememberedValue(Integer.valueOf(a9));
                    b10.apply(Integer.valueOf(a9), b11);
                }
                g5.e(b10, e4, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                long h2 = x0.x.h(14);
                androidx.compose.ui.text.font.c0 d2 = androidx.compose.ui.text.font.c0.b.d();
                long k = aVar3.h(composer, i3).k();
                s.a aVar4 = w0.s.b;
                a6.j(str3, (Modifier) null, k, h2, (androidx.compose.ui.text.font.y) null, d2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 199680, 3120, 120786);
                float g2 = x0.i.g(f);
                composer.startReplaceGroup(-1814856593);
                androidx.compose.foundation.layout.a3.a(SizeKt.i(aVar, g2), composer, 0);
                composer.endReplaceGroup();
                a6.j("关注后将收到" + str + "的作品上架通知", (Modifier) null, aVar3.h(composer, i3).X0(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar4.b(), false, 1, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer, 3072, 3120, 120818);
                composer.endNode();
                com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 g0Var = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) guestProfileViewModel.j.getValue();
                if (g0Var != null) {
                    num3 = g0Var.d;
                    composer2 = composer;
                } else {
                    composer2 = composer;
                    num3 = null;
                }
                Theme e5 = aVar3.e(composer2, i3);
                long a11 = aVar3.h(composer2, i3).a();
                long e6 = aVar3.h(composer2, i3).e();
                composer2.startReplaceGroup(1849434622);
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion2 = Composer.Companion;
                if (rememberedValue == companion2.getEmpty()) {
                    c0.a aVar5 = androidx.compose.ui.graphics.c0.b;
                    z = true;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(a11), androidx.compose.ui.graphics.l0.j(e6)});
                    rememberedValue = c0.a.d(aVar5, listOf, 0.0f, 0.0f, 0, 14, (Object) null);
                    composer2.updateRememberedValue(rememberedValue);
                } else {
                    z = true;
                }
                androidx.compose.ui.graphics.c0 c0Var2 = (androidx.compose.ui.graphics.c0) rememberedValue;
                composer.endReplaceGroup();
                composer2.startReplaceGroup(-1633490746);
                boolean changed = composer2.changed(num3) | composer2.changed(e5.ordinal());
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == companion2.getEmpty()) {
                    rememberedValue2 = p.z(num3, e5, c0Var2, z);
                    composer2.updateRememberedValue(rememberedValue2);
                }
                p3 p3Var = (p3) rememberedValue2;
                composer.endReplaceGroup();
                e.f d3 = eVar.d();
                e.c i6 = aVar2.i();
                Modifier i7 = SizeKt.i(ig4.i.c(aVar, x0.i.d(x0.i.g(8)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), x0.i.g(30));
                if (p3Var.e != null) {
                    composer2.startReplaceGroup(-906585167);
                    d = BackgroundKt.d(aVar, aVar3.h(composer2, i3).f1(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                    composer.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-906580473);
                    d = BackgroundKt.d(aVar, aVar3.h(composer2, i3).j3(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                    composer.endReplaceGroup();
                }
                Modifier then = i7.then(d);
                composer2.startReplaceGroup(5004770);
                boolean changed2 = composer2.changed(guestProfileViewModel);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed2 || rememberedValue3 == companion2.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.a3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = SeriesGuestProfilePageKt.a.C0029a.c(GuestProfileViewModel.this);
                            return c;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                float f4 = 12;
                Modifier v2 = androidx.compose.foundation.layout.f2.v(ClickableKt.clickable-oSLSa3U$default(then, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null), x0.i.g(f4), 0.0f, x0.i.g(f4), 0.0f, 10, (Object) null);
                androidx.compose.ui.layout.p0 b12 = androidx.compose.foundation.layout.r2.b(d3, i6, composer2, 54);
                int a12 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                Modifier e7 = ComposedModifierKt.e(composer2, v2);
                Function0 a13 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer2.createNode(a13);
                } else {
                    composer.useNode();
                }
                Composer b13 = g5.b(composer);
                g5.e(b13, b12, companion.c());
                g5.e(b13, currentCompositionLocalMap5, companion.e());
                Function2 b14 = companion.b();
                if (b13.getInserting() || !Intrinsics.areEqual(b13.rememberedValue(), Integer.valueOf(a12))) {
                    b13.updateRememberedValue(Integer.valueOf(a12));
                    b13.apply(Integer.valueOf(a12), b14);
                }
                g5.e(b13, e7, companion.d());
                SeriesGuestProfilePage_androidKt.g(p3Var, composer2, 0);
                composer.endNode();
                composer.endNode();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1064864961, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.FollowGuideBottomTips.<anonymous> (SeriesGuestProfilePage.kt:1086)");
                }
                Modifier f = SizeKt.f(this.a, 0.0f, 1, (Object) null);
                MutableState<Boolean> mutableState = this.b;
                com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var = this.c;
                GuestProfileViewModel guestProfileViewModel = this.d;
                MutableState<Pair<Boolean, Integer>> mutableState2 = this.e;
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 i2 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, f);
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
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                boolean P = SeriesGuestProfilePageKt.P(mutableState);
                androidx.compose.animation.core.s2 n = androidx.compose.animation.core.j.n(200, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null);
                composer.startReplaceGroup(1849434622);
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion2 = Composer.Companion;
                if (rememberedValue == companion2.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.y2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int d;
                            d = SeriesGuestProfilePageKt.a.d(((Integer) obj).intValue());
                            return Integer.valueOf(d);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                androidx.compose.animation.q D = EnterExitTransitionKt.D(n, (Function1) rememberedValue);
                androidx.compose.animation.core.s2 n2 = androidx.compose.animation.core.j.n(200, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null);
                composer.startReplaceGroup(1849434622);
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == companion2.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.z2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            int e2;
                            e2 = SeriesGuestProfilePageKt.a.e(((Integer) obj).intValue());
                            return Integer.valueOf(e2);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                AnimatedVisibilityKt.j(P, boxScopeInstance.b(Modifier.Companion, aVar.b()), D, EnterExitTransitionKt.H(n2, (Function1) rememberedValue2), (String) null, androidx.compose.runtime.internal.t.e(486065827, true, new C0029a(f0Var, guestProfileViewModel, mutableState2), composer, 54), composer, 196608, 16);
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

    static final class f implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ GuestProfileViewModel a;
        final /* synthetic */ com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 b;
        final /* synthetic */ androidx.compose.ui.graphics.c0 c;

        f(GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, androidx.compose.ui.graphics.c0 c0Var) {
            this.a = guestProfileViewModel;
            this.b = f0Var;
            this.c = c0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(GuestProfileViewModel guestProfileViewModel) {
            Integer num;
            com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 g0Var = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) guestProfileViewModel.j.getValue();
            if (g0Var != null) {
                num = g0Var.d;
            } else {
                num = null;
            }
            GuestProfileViewModel.O0(guestProfileViewModel, num, null, 2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            Integer num;
            boolean z2;
            Modifier modifier;
            Modifier d;
            Modifier modifier2;
            long r;
            boolean z3 = true;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1367219337, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.HeaderLayout.<anonymous>.<anonymous>.<anonymous> (SeriesGuestProfilePage.kt:365)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), SeriesGuestProfilePageKt.j1(), 0.0f, SeriesGuestProfilePageKt.j1(), 0.0f, 10, (Object) null);
                androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
                e.f f = eVar.f();
                e.a aVar2 = androidx.compose.ui.e.a;
                e.c i2 = aVar2.i();
                final GuestProfileViewModel guestProfileViewModel = this.a;
                com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var = this.b;
                androidx.compose.ui.graphics.c0 c0Var = this.c;
                androidx.compose.ui.layout.p0 b = androidx.compose.foundation.layout.r2.b(f, i2, composer, 54);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, v);
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
                Composer b2 = g5.b(composer);
                g5.e(b2, b, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                    b2.updateRememberedValue(Integer.valueOf(a));
                    b2.apply(Integer.valueOf(a), b3);
                }
                g5.e(b2, e, companion.d());
                androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
                p.j(guestProfileViewModel, aVar, f0Var.a, composer, 48, 0);
                composer.startReplaceGroup(-223575489);
                if (!guestProfileViewModel.l.getValue().d) {
                    com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 g0Var = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) guestProfileViewModel.j.getValue();
                    if (g0Var != null) {
                        num = g0Var.d;
                    } else {
                        num = null;
                    }
                    og4.a aVar3 = og4.a.a;
                    int i3 = og4.a.b;
                    Theme e2 = aVar3.e(composer, i3);
                    composer.startReplaceGroup(-1633490746);
                    boolean changed = composer.changed(num) | composer.changed(e2.ordinal());
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = p.A(num, e2, c0Var, false, 8, null);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    p3 p3Var = (p3) rememberedValue;
                    composer.endReplaceGroup();
                    composer.startReplaceGroup(-223560283);
                    eo eoVar = f0Var.a;
                    if (eoVar != null && com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.e(eoVar)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        p3Var = p3.b(p3Var, null, aVar3.h(composer, i3).r(), null, m0.a.c(androidx.compose.ui.graphics.m0.b, aVar3.i(e2).R(), 0, 2, (Object) null), null, 21, null);
                    }
                    p3 p3Var2 = p3Var;
                    composer.endReplaceGroup();
                    x0.i.g(7);
                    e.f d2 = eVar.d();
                    e.c i4 = aVar2.i();
                    Modifier i5 = SizeKt.i(ig4.i.c(aVar, x0.i.d(x0.i.g(8)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), x0.i.g(30));
                    if (com.dragon.read.kmp.u.o()) {
                        composer.startReplaceGroup(1660498611);
                        androidx.compose.ui.graphics.c0 c0Var2 = p3Var2.e;
                        if (c0Var2 != null) {
                            d = BackgroundKt.b(aVar, c0Var2, (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
                            modifier2 = i5;
                        } else {
                            eo eoVar2 = f0Var.a;
                            if (eoVar2 == null || !com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.e(eoVar2)) {
                                z3 = false;
                            }
                            if (z3) {
                                composer.startReplaceGroup(1660777859);
                                modifier2 = i5;
                                d = BackgroundKt.d(aVar, aVar3.h(composer, i3).I(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                                composer.endReplaceGroup();
                            } else {
                                modifier2 = i5;
                                composer.startReplaceGroup(1660938191);
                                if (com.dragon.read.kmp.service.d1.d(e2)) {
                                    composer.startReplaceGroup(-223512651);
                                    r = aVar3.h(composer, i3).I();
                                } else {
                                    composer.startReplaceGroup(-223511286);
                                    r = aVar3.h(composer, i3).r();
                                }
                                composer.endReplaceGroup();
                                d = BackgroundKt.d(aVar, r, (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                                composer.endReplaceGroup();
                            }
                        }
                        composer.endReplaceGroup();
                        modifier = modifier2;
                    } else {
                        modifier = i5;
                        composer.startReplaceGroup(1661234861);
                        eo eoVar3 = f0Var.a;
                        if (eoVar3 == null || !com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.e(eoVar3)) {
                            z3 = false;
                        }
                        if (z3) {
                            composer.startReplaceGroup(1661332139);
                            d = BackgroundKt.d(aVar, aVar3.h(composer, i3).I(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                            composer.endReplaceGroup();
                        } else {
                            composer.startReplaceGroup(1661482582);
                            d = BackgroundKt.d(aVar, aVar3.h(composer, i3).r(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                            composer.endReplaceGroup();
                        }
                        composer.endReplaceGroup();
                    }
                    Modifier then = modifier.then(d);
                    composer.startReplaceGroup(5004770);
                    boolean changed2 = composer.changed(guestProfileViewModel);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.g3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit c;
                                c = SeriesGuestProfilePageKt.f.c(GuestProfileViewModel.this);
                                return c;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    float f2 = 12;
                    Modifier v2 = androidx.compose.foundation.layout.f2.v(ClickableKt.clickable-oSLSa3U$default(then, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), x0.i.g(f2), 0.0f, x0.i.g(f2), 0.0f, 10, (Object) null);
                    androidx.compose.ui.layout.p0 b4 = androidx.compose.foundation.layout.r2.b(d2, i4, composer, 54);
                    int a3 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(composer, v2);
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
                    Composer b5 = g5.b(composer);
                    g5.e(b5, b4, companion.c());
                    g5.e(b5, currentCompositionLocalMap2, companion.e());
                    Function2 b6 = companion.b();
                    if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a3))) {
                        b5.updateRememberedValue(Integer.valueOf(a3));
                        b5.apply(Integer.valueOf(a3), b6);
                    }
                    g5.e(b5, e3, companion.d());
                    SeriesGuestProfilePage_androidKt.g(p3Var2, composer, 0);
                    composer.endNode();
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

    private static final void C0(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void d0(MutableState<Float> mutableState, float f2) {
        mutableState.setValue(Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(MutableState mutableState, float f2) {
        d0(mutableState, f2);
        return Unit.INSTANCE;
    }

    private static final void s0(MutableState<Float> mutableState, float f2) {
        mutableState.setValue(Float.valueOf(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(MutableState mutableState, float f2) {
        s0(mutableState, f2);
        return Unit.INSTANCE;
    }

    static final class g implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ GuestProfileViewModel a;

        g(GuestProfileViewModel guestProfileViewModel) {
            this.a = guestProfileViewModel;
        }

        static final class a implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ GuestProfileViewModel a;

            a(GuestProfileViewModel guestProfileViewModel) {
                this.a = guestProfileViewModel;
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
                        ComposerKt.traceEventStart(2102119114, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePage.<anonymous>.<anonymous> (SeriesGuestProfilePage.kt:175)");
                    }
                    SeriesGuestProfilePageKt.Q0(this.a, composer, 0);
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
                    ComposerKt.traceEventStart(723170799, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePage.<anonymous> (SeriesGuestProfilePage.kt:174)");
                }
                LoadStatus loadStatus = (LoadStatus) this.a.r.getValue();
                GuestProfileViewModel guestProfileViewModel = this.a;
                mg4.k.r(loadStatus, guestProfileViewModel.s, 0L, (Modifier) null, (Function2) null, false, (Function3) null, (Function3) null, androidx.compose.runtime.internal.t.e(2102119114, true, new a(guestProfileViewModel), composer, 54), composer, 100663296, 252);
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
        final /* synthetic */ MutableState<Float> a;

        c(MutableState<Float> mutableState) {
            this.a = mutableState;
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
                    ComposerKt.traceEventStart(1790028076, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.GuardButtonWithTips.<anonymous>.<anonymous> (SeriesGuestProfilePage.kt:885)");
                }
                wg4.k.b((Modifier) null, androidx.compose.ui.graphics.n0.d(4283256141L), x0.i.g(8), x0.i.g(11), x0.i.g(5), BubbleGravity.TOP, SeriesGuestProfilePageKt.c0(this.a), com.dragon.read.kmp.profile.guestprofile.view.c.a.b(), composer, 12807600, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class i implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ GuestProfileViewModel a;
        final /* synthetic */ CollapsibleListState b;
        final /* synthetic */ State<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> c;

        i(GuestProfileViewModel guestProfileViewModel, CollapsibleListState collapsibleListState, State<com.dragon.read.kmp.profile.guestprofile.viewmodel.f0> state) {
            this.a = guestProfileViewModel;
            this.b = collapsibleListState;
            this.c = state;
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
                    ComposerKt.traceEventStart(-524904744, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageContent.<anonymous>.<anonymous> (SeriesGuestProfilePage.kt:205)");
                }
                SeriesGuestProfilePageKt.q0(this.a, SeriesGuestProfilePageKt.R0(this.c), this.b, composer, CollapsibleListState.q << 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class j implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ GuestProfileViewModel a;
        final /* synthetic */ PagerState b;
        final /* synthetic */ CollapsibleListState c;

        j(GuestProfileViewModel guestProfileViewModel, PagerState pagerState, CollapsibleListState collapsibleListState) {
            this.a = guestProfileViewModel;
            this.b = pagerState;
            this.c = collapsibleListState;
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
                    ComposerKt.traceEventStart(-581770090, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageContent.<anonymous>.<anonymous> (SeriesGuestProfilePage.kt:211)");
                }
                ProfileTabPagerKt.o(this.a, this.b, this.c, composer, CollapsibleListState.q << 6);
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
    public static final Unit e0(Function0 function0, MutableState mutableState) {
        b0(mutableState, false);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(String title, String message) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        r1(title, message);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(MutableState mutableState, androidx.compose.ui.graphics.c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.l(-((Number) mutableState.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(GuestProfileViewModel guestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var) {
        String str;
        ug0 ug0Var;
        com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
        String r0 = guestProfileViewModel.r0();
        eo eoVar = f0Var.a;
        if (eoVar == null || (ug0Var = eoVar.e) == null || (str = ug0Var.u) == null) {
            str = "";
        }
        rVar.w(r0, str, com.dragon.read.kmp.utils.m0.a());
        return Unit.INSTANCE;
    }

    private static final void r1(String str, String str2) {
        com.dragon.read.kmp.service.g1 g1Var = new com.dragon.read.kmp.service.g1(false, false, null, false, 4, null);
        g1Var.l = 16.0f;
        KmpDialogServiceKt.l(g1Var, androidx.compose.runtime.internal.t.c(815451786, true, new m(str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, GuestProfileViewModel guestProfileViewModel) {
        String str;
        ug0 ug0Var;
        eo eoVar = f0Var.a;
        if (eoVar != null && (ug0Var = eoVar.e) != null) {
            str = ug0Var.c;
        } else {
            str = null;
        }
        String str2 = str;
        if (StringUtilsKt.a(str2)) {
            ym4.k a2 = com.dragon.read.kmp.utils.m0.a();
            a2.c("is_content_related", 1);
            a2.d("content_type", "actor");
            a2.d("profile_user_id", guestProfileViewModel.r0());
            zm4.d dVar = zm4.d.a;
            Intrinsics.checkNotNull(str2);
            zm4.d.d(dVar, str2, null, a2, 2, null);
        }
        return Unit.INSTANCE;
    }

    static final class l implements Function3<com.dragon.read.kmp.service.g, Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean[] c;
        final /* synthetic */ String d;
        final /* synthetic */ ym4.k e;
        final /* synthetic */ Function0<Unit> f;

        l(String str, String str2, boolean[] zArr, String str3, ym4.k kVar, Function0<Unit> function0) {
            this.a = str;
            this.b = str2;
            this.c = zArr;
            this.d = str3;
            this.e = kVar;
            this.f = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.dragon.read.kmp.service.g gVar, Composer composer, Integer num) {
            c(gVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v4 ??, still in use, count: 1, list:
              (r15v4 ?? I:java.lang.Object) from 0x00dc: INVOKE (r14v0 ?? I:androidx.compose.runtime.Composer), (r15v4 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:50725084)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
            */
        public final void c(
        /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v4 ??, still in use, count: 1, list:
              (r15v4 ?? I:java.lang.Object) from 0x00dc: INVOKE (r14v0 ?? I:androidx.compose.runtime.Composer), (r15v4 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:50725084)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
            	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
            */
        /*  JADX ERROR: Method generation error
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r13v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
            	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(boolean[] zArr, String str, ym4.k kVar, com.dragon.read.kmp.service.g gVar) {
            zArr[0] = true;
            com.dragon.read.kmp.r.a.D(str, "暂不关注", kVar);
            gVar.a();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(boolean[] zArr, String str, ym4.k kVar, com.dragon.read.kmp.service.g gVar, Function0 function0) {
            zArr[0] = true;
            com.dragon.read.kmp.r.a.D(str, "立即关注", kVar);
            gVar.a();
            function0.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(GuestProfileViewModel guestProfileViewModel, jv5.c honor, int i2) {
        Intrinsics.checkNotNullParameter(honor, "honor");
        guestProfileViewModel.d1(honor, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(CollapsibleListState collapsibleListState, MutableState mutableState, float f2) {
        boolean z;
        if (collapsibleListState.m() == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        C0(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(final GuestProfileViewModel guestProfileViewModel, String title, String message) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        q1(title, message, guestProfileViewModel.r0(), new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.n2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit I0;
                I0 = SeriesGuestProfilePageKt.I0(GuestProfileViewModel.this);
                return I0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, MutableState mutableState, androidx.compose.ui.graphics.c1 graphicsLayer) {
        float r0;
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (f0Var.a == null) {
            r0 = 0.0f;
        } else {
            r0 = r0(mutableState);
        }
        graphicsLayer.c(r0);
        return Unit.INSTANCE;
    }

    public static final void N0(final GuestProfileViewModel viewModel, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        List mutableListOf;
        int i4;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-844484162);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(viewModel)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-844484162, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePage (SeriesGuestProfilePage.kt:164)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            final Context a2 = ig4.f.a(startRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1746271574);
            if ((i3 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean changedInstance = z2 | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(a2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.m1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult O0;
                        O0 = SeriesGuestProfilePageKt.O0(GuestProfileViewModel.this, coroutineScope, a2, (DisposableEffectScope) obj);
                        return O0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1) rememberedValue2, startRestartGroup, 6);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new sg4.d(false, 1, (DefaultConstructorMarker) null));
            pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, mutableListOf, 3, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(723170799, true, new g(viewModel), startRestartGroup, 54), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.x1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit P0;
                    P0 = SeriesGuestProfilePageKt.P0(GuestProfileViewModel.this, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return P0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(final GuestProfileViewModel guestProfileViewModel, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        boolean z2;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-203468627);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-203468627, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageContent (SeriesGuestProfilePage.kt:182)");
            }
            State collectAsState = SnapshotStateKt.collectAsState(guestProfileViewModel.l, (CoroutineContext) null, startRestartGroup, 0, 1);
            startRestartGroup.startReplaceGroup(5004770);
            int i5 = i3 & 14;
            if (i5 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.i2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int S0;
                        S0 = SeriesGuestProfilePageKt.S0(GuestProfileViewModel.this);
                        return Integer.valueOf(S0);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            PagerState n = androidx.compose.foundation.pager.e1.n(0, 0.0f, (Function0) rememberedValue, startRestartGroup, 6, 2);
            CollapsibleListState u = CollapsibleListLayoutKt.u(x0.i.g(b + d), n, false, false, 0.0f, 0L, false, startRestartGroup, 6, 124);
            int i6 = (i3 << 3) & 112;
            l1(n, guestProfileViewModel, startRestartGroup, i6);
            int i7 = CollapsibleListState.q;
            o1(u, guestProfileViewModel, startRestartGroup, i7 | i6);
            h1(n, u, guestProfileViewModel, startRestartGroup, ((i3 << 6) & 896) | (i7 << 3));
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e o = aVar.o();
            Modifier.a aVar2 = Modifier.Companion;
            Modifier d2 = BackgroundKt.d(SizeKt.f(aVar2, 0.0f, 1, (Object) null), og4.a.a.h(startRestartGroup, og4.a.b).b(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            androidx.compose.ui.layout.p0 i8 = androidx.compose.foundation.layout.m.i(o, false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, d2);
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
            g5.e(b2, i8, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            composer2 = startRestartGroup;
            m0(boxScopeInstance, guestProfileViewModel, R0(collectAsState), u, startRestartGroup, (i7 << 9) | 6 | i6);
            CollapsibleListLayoutKt.g((Modifier) null, u, androidx.compose.runtime.internal.t.e(-524904744, true, new i(guestProfileViewModel, u, collectAsState), composer2, 54), com.dragon.read.kmp.profile.guestprofile.view.c.a.a(), androidx.compose.runtime.internal.t.e(-581770090, true, new j(guestProfileViewModel, n, u), composer2, 54), composer2, (i7 << 3) | 28032, 1);
            A0(guestProfileViewModel, R0(collectAsState), u, composer2, i5 | (i7 << 6));
            M(guestProfileViewModel, R0(collectAsState), u, boxScopeInstance.b(SizeKt.h(aVar2, 0.0f, 1, (Object) null), aVar.b()), composer2, i5 | (i7 << 6));
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.r2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit T0;
                    T0 = SeriesGuestProfilePageKt.T0(GuestProfileViewModel.this, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return T0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult O0(GuestProfileViewModel guestProfileViewModel, CoroutineScope coroutineScope, Context context, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        guestProfileViewModel.H0(coroutineScope, context);
        return new h(guestProfileViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(GuestProfileViewModel guestProfileViewModel, jv5.c honorData, String str, int i2) {
        Intrinsics.checkNotNullParameter(honorData, "honorData");
        guestProfileViewModel.t0(honorData, i2, str);
        return Unit.INSTANCE;
    }

    private static final void q1(String str, String str2, String str3, Function0<Unit> function0) {
        boolean[] zArr = {false};
        ym4.k a2 = com.dragon.read.kmp.utils.m0.a();
        com.dragon.read.kmp.r.a.E(str3, a2);
        com.dragon.read.kmp.service.g1 g1Var = new com.dragon.read.kmp.service.g1(false, false, new k(zArr, str3, a2), false);
        g1Var.l = 16.0f;
        KmpDialogServiceKt.l(g1Var, androidx.compose.runtime.internal.t.c(2067813788, true, new l(str, str2, zArr, str3, a2, function0)));
    }

    private static final void l1(final PagerState pagerState, final GuestProfileViewModel guestProfileViewModel, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(323812637);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(pagerState)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i3 = i5 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        boolean z4 = false;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(323812637, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.pageEffect (SeriesGuestProfilePage.kt:227)");
            }
            Integer num = (Integer) guestProfileViewModel.u.getValue();
            if (num != null) {
                num.intValue();
                startRestartGroup.startReplaceGroup(-1633490746);
                int i6 = i3 & 14;
                if (i6 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean changed = z2 | startRestartGroup.changed(num);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new SeriesGuestProfilePageKt$pageEffect$2$1(pagerState, num, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(pagerState, num, (Function2) rememberedValue, startRestartGroup, i6);
                startRestartGroup.startReplaceGroup(-1633490746);
                if (i6 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((i3 & 112) == 32) {
                    z4 = true;
                }
                boolean z5 = z3 | z4;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z5 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new SeriesGuestProfilePageKt$pageEffect$3$1(pagerState, guestProfileViewModel, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(pagerState, (Function2) rememberedValue2, startRestartGroup, i6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.s2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit m1;
                            m1 = SeriesGuestProfilePageKt.m1(pagerState, guestProfileViewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return m1;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.t2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n1;
                    n1 = SeriesGuestProfilePageKt.n1(pagerState, guestProfileViewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return n1;
                }
            });
        }
    }

    private static final void o1(final CollapsibleListState collapsibleListState, final GuestProfileViewModel guestProfileViewModel, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        int i4;
        boolean changedInstance;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1576025468);
        if ((i2 & 6) == 0) {
            if ((i2 & 8) == 0) {
                changedInstance = startRestartGroup.changed(collapsibleListState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsibleListState);
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
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        boolean z3 = false;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1576025468, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.pageScroll (SeriesGuestProfilePage.kt:251)");
            }
            startRestartGroup.startReplaceGroup(-1633490746);
            int i6 = i3 & 14;
            if (i6 != 4 && ((i3 & 8) == 0 || !startRestartGroup.changedInstance(collapsibleListState))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if ((i3 & 112) == 32) {
                z3 = true;
            }
            boolean z4 = z2 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SeriesGuestProfilePageKt$pageScroll$1$1(collapsibleListState, guestProfileViewModel, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(collapsibleListState, (Function2) rememberedValue, startRestartGroup, i6 | CollapsibleListState.q);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.r1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p1;
                    p1 = SeriesGuestProfilePageKt.p1(collapsibleListState, guestProfileViewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return p1;
                }
            });
        }
    }

    private static final void h1(final PagerState pagerState, final CollapsibleListState collapsibleListState, final GuestProfileViewModel guestProfileViewModel, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        int i4;
        boolean changedInstance;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-642179824);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(pagerState)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i2 & 64) == 0) {
                changedInstance = startRestartGroup.changed(collapsibleListState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsibleListState);
            }
            if (changedInstance) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        boolean z3 = false;
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-642179824, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.focusTabEffect (SeriesGuestProfilePage.kt:270)");
            }
            startRestartGroup.startReplaceGroup(-1633490746);
            int i7 = i3 & 896;
            if (i7 == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i8 = i3 & 14;
            if (i8 == 4) {
                z3 = true;
            }
            boolean z4 = z2 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SeriesGuestProfilePageKt$focusTabEffect$1$1(guestProfileViewModel, pagerState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(pagerState, collapsibleListState, guestProfileViewModel, (Function2) rememberedValue, startRestartGroup, (i3 & 112) | (CollapsibleListState.q << 3) | i8 | i7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.v1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i1;
                    i1 = SeriesGuestProfilePageKt.i1(pagerState, collapsibleListState, guestProfileViewModel, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return i1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(final String str, final String str2, final Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(747677631);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str2)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(747677631, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.GuardUnavailableDialog (SeriesGuestProfilePage.kt:749)");
            }
            composer2 = startRestartGroup;
            androidx.compose.material.w.a(SizeKt.x(Modifier.Companion, x0.i.g(TTVideoEngineInterface.PLAYER_OPTION_PREFER_NEARESTSAMPLE)), k.g.c(x0.i.g(16)), og4.a.a.h(startRestartGroup, og4.a.b).D(), 0L, (androidx.compose.foundation.w) null, 0.0f, androidx.compose.runtime.internal.t.e(-208266756, true, new e(function0, str, str2), startRestartGroup, 54), startRestartGroup, 1572870, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.p2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l0;
                    l0 = SeriesGuestProfilePageKt.l0(str, str2, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return l0;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x055e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void A0(final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r44, final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r45, final com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState r46, androidx.compose.runtime.Composer r47, final int r48) {
        /*
            Method dump skipped, instructions count: 1410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt.A0(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0, com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void q0(final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r43, final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 r44, final com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState r45, androidx.compose.runtime.Composer r46, final int r47) {
        /*
            Method dump skipped, instructions count: 1602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt.q0(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, com.dragon.read.kmp.profile.guestprofile.viewmodel.f0, com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState, androidx.compose.runtime.Composer, int):void");
    }

    public static final /* synthetic */ void c1(String str, String str2, Function0 function0, Function0 function02, Composer composer, int i2) {
        i0(str, str2, function0, function02, composer, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(final String str, final String str2, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-864916214);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str2)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-864916214, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.GuardFollowConfirmDialog (SeriesGuestProfilePage.kt:672)");
            }
            composer2 = startRestartGroup;
            androidx.compose.material.w.a(SizeKt.x(Modifier.Companion, x0.i.g(TTVideoEngineInterface.PLAYER_OPTION_PREFER_NEARESTSAMPLE)), k.g.c(x0.i.g(16)), og4.a.a.h(startRestartGroup, og4.a.b).D(), 0L, (androidx.compose.foundation.w) null, 0.0f, androidx.compose.runtime.internal.t.e(1645571015, true, new d(str, str2, function0, function02), startRestartGroup, 54), startRestartGroup, 1572870, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.q2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j0;
                    j0 = SeriesGuestProfilePageKt.j0(str, str2, function0, function02, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return j0;
                }
            });
        }
    }

    public static final void M(final GuestProfileViewModel viewModel, final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 profileState, final CollapsibleListState collapsingState, final Modifier modifier, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(profileState, "profileState");
        Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(1844295248);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(viewModel)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(profileState)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i3 & 1043) != 1042) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1844295248, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.FollowGuideBottomTips (SeriesGuestProfilePage.kt:1057)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            MutableState<com.dragon.read.kmp.profile.guestprofile.viewmodel.g0> mutableState2 = viewModel.j;
            MutableState<Pair<Boolean, Integer>> mutableState3 = viewModel.y;
            Pair<Boolean, Integer> N = N(mutableState3);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed = startRestartGroup.changed(mutableState3);
            int i7 = i3 & 14;
            if (i7 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = changed | z2;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new SeriesGuestProfilePageKt$FollowGuideBottomTips$1$1(viewModel, mutableState3, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(N, (Function2) rememberedValue2, startRestartGroup, 0);
            com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 R = R(mutableState2);
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changed2 = startRestartGroup.changed(mutableState2);
            if (i7 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z5 = z3 | changed2;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new SeriesGuestProfilePageKt$FollowGuideBottomTips$2$1(viewModel, mutableState2, mutableState, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(R, (Function2) rememberedValue3, startRestartGroup, 0);
            pg4.p.e(new pg4.h((pg4.t) null, (pg4.t) null, (List) null, 7, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.t.e(1064864961, true, new a(modifier, mutableState, profileState, viewModel, mutableState3), startRestartGroup, 54), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.q1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit O;
                    O = SeriesGuestProfilePageKt.O(GuestProfileViewModel.this, profileState, collapsingState, modifier, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return O;
                }
            });
        }
    }

    public static final void S(final GuestProfileViewModel viewModel, final CollapsibleListState collapsingState, final float f2, final Modifier modifier, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean changedInstance;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(collapsingState, "collapsingState");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-65630221);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(viewModel)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i2 & 64) == 0) {
                changedInstance = startRestartGroup.changed(collapsingState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsingState);
            }
            if (changedInstance) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(f2)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-65630221, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.FollowedRecommendList (SeriesGuestProfilePage.kt:973)");
            }
            MutableState<List<fl4.j>> mutableState = viewModel.O;
            MutableState<Boolean> mutableState2 = viewModel.P;
            List<fl4.j> T = T(mutableState);
            boolean U = U(mutableState2);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changed = startRestartGroup.changed(T) | startRestartGroup.changed(U);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                if ((!T(mutableState).isEmpty()) && !U(mutableState2) && !collapsingState.p()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                rememberedValue = Boolean.valueOf(z2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            boolean booleanValue = ((Boolean) rememberedValue).booleanValue();
            startRestartGroup.endReplaceGroup();
            eo eoVar = viewModel.l.getValue().a;
            if (eoVar != null && com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.e(eoVar)) {
                z3 = true;
            } else {
                z3 = false;
            }
            e.a aVar = androidx.compose.ui.e.a;
            AnimatedVisibilityKt.j(booleanValue, modifier, EnterExitTransitionKt.k(androidx.compose.animation.core.j.n(200, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null), aVar.m(), false, (Function1) null, 12, (Object) null).c(EnterExitTransitionKt.n(androidx.compose.animation.core.j.n(200, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null), f2)), EnterExitTransitionKt.y(androidx.compose.animation.core.j.n(200, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null), aVar.m(), false, (Function1) null, 12, (Object) null).c(EnterExitTransitionKt.p(androidx.compose.animation.core.j.n(200, 0, (androidx.compose.animation.core.d0) null, 6, (Object) null), f2)), (String) null, androidx.compose.runtime.internal.t.e(-188482357, true, new b(mutableState, viewModel, z3), startRestartGroup, 54), startRestartGroup, ((i3 >> 6) & 112) | 196608, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.m2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit V;
                    V = SeriesGuestProfilePageKt.V(GuestProfileViewModel.this, collapsingState, f2, modifier, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return V;
                }
            });
        }
    }

    private static final void m0(final androidx.compose.foundation.layout.r rVar, final GuestProfileViewModel guestProfileViewModel, final com.dragon.read.kmp.profile.guestprofile.viewmodel.f0 f0Var, final CollapsibleListState collapsibleListState, Composer composer, final int i2) {
        int i3;
        boolean z;
        String str;
        List list;
        com.dragon.read.kmp.profile.guestprofile.view.f fVar;
        boolean z2;
        String str2;
        com.bytedance.kmp.image.options.l e2;
        boolean changedInstance;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1877026232);
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(f0Var)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i2 & 3072) == 0) {
            if ((i2 & 4096) == 0) {
                changedInstance = startRestartGroup.changed(collapsibleListState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsibleListState);
            }
            if (changedInstance) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        boolean z3 = false;
        if ((i3 & 1169) != 1168) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1877026232, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.HeaderBg (SeriesGuestProfilePage.kt:911)");
            }
            final MutableState mutableState = collapsibleListState.a;
            boolean d2 = com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(f0Var);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                eo eoVar = f0Var.a;
                if (eoVar != null) {
                    str = eoVar.h;
                } else {
                    str = null;
                }
                if (eoVar != null) {
                    list = eoVar.b;
                } else {
                    list = null;
                }
                String str3 = "";
                if (StringUtilsKt.a(str)) {
                    eo eoVar2 = f0Var.a;
                    if (eoVar2 != null && com.dragon.read.kmp.profile.guestprofile.viewmodel.c0.e(eoVar2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (str == null) {
                            str = "";
                        }
                        eo eoVar3 = f0Var.a;
                        if (eoVar3 != null && (str2 = eoVar3.g) != null) {
                            str3 = str2;
                        }
                        fVar = new com.dragon.read.kmp.profile.guestprofile.view.f(false, str, str3);
                        rememberedValue = fVar;
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                }
                if (list != null && list.size() >= 2) {
                    if (d2) {
                        fVar = new com.dragon.read.kmp.profile.guestprofile.view.f(true, (String) list.get(1), "");
                    } else {
                        fVar = new com.dragon.read.kmp.profile.guestprofile.view.f(true, (String) list.get(0), "");
                    }
                } else {
                    fVar = new com.dragon.read.kmp.profile.guestprofile.view.f(true, "", "");
                }
                rememberedValue = fVar;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            com.dragon.read.kmp.profile.guestprofile.view.f fVar2 = (com.dragon.read.kmp.profile.guestprofile.view.f) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (fVar2.b.length() == 0) {
                z3 = true;
            }
            if (z3) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.s1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit n0;
                            n0 = SeriesGuestProfilePageKt.n0(rVar, guestProfileViewModel, f0Var, collapsibleListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return n0;
                        }
                    });
                    return;
                }
                return;
            }
            guestProfileViewModel.e1();
            String str4 = fVar2.b;
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            if (fVar2.a) {
                e2 = com.bytedance.kmp.image.options.l.b.c();
            } else {
                e2 = com.bytedance.kmp.image.options.l.b.e();
            }
            nVar.a(e2);
            Unit unit = Unit.INSTANCE;
            Modifier.a aVar = Modifier.Companion;
            Modifier h2 = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed2 = startRestartGroup.changed(mutableState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.t1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit o0;
                        o0 = SeriesGuestProfilePageKt.o0(mutableState, (androidx.compose.ui.graphics.c1) obj);
                        return o0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            com.dragon.read.kmp.compose.common.image.g.b(str4, (String) null, nVar, androidx.compose.ui.graphics.b1.a(h2, (Function1) rememberedValue2), (com.bytedance.kmp.image.options.i) null, 0.0f, (kg4.b) null, startRestartGroup, 0, 114);
            if (!fVar2.a && StringUtilsKt.a(fVar2.c)) {
                com.dragon.read.kmp.basenovel.ui.ui.r.c(com.dragon.read.kmp.profile.guestprofile.view.a.a.d(com.dragon.read.kmp.utils.k.e(com.dragon.read.kmp.utils.k.a, fVar2.c, 0L, 2, null)), SizeKt.f(aVar, 0.0f, 1, (Object) null), startRestartGroup, 48, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.u1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p0;
                    p0 = SeriesGuestProfilePageKt.p0(rVar, guestProfileViewModel, f0Var, collapsibleListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return p0;
                }
            });
        }
    }

    private static final void W(final String str, final String str2, final boolean z, final Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        boolean z2;
        Composer composer2;
        long k2;
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1528056797);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i8 = 4;
            } else {
                i8 = 2;
            }
            i3 = i8 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(str2)) {
                i7 = 32;
            } else {
                i7 = 16;
            }
            i3 |= i7;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        int i9 = i3;
        if ((i9 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i9 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1528056797, i9, -1, "com.dragon.read.kmp.profile.guestprofile.view.GuardButton (SeriesGuestProfilePage.kt:806)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(18526892);
                k2 = og4.a.a.h(startRestartGroup, og4.a.b).R();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(18583157);
                k2 = og4.a.a.h(startRestartGroup, og4.a.b).k();
                startRestartGroup.endReplaceGroup();
            }
            long j2 = k2;
            Modifier.a aVar = Modifier.Companion;
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(aVar, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function0, 15, (Object) null);
            androidx.compose.ui.layout.p0 b2 = androidx.compose.foundation.layout.r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier);
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
            g5.e(b3, e2, companion.d());
            androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
            startRestartGroup.startReplaceGroup(2140287868);
            if (str2 != null && str2.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
                com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
                nVar.d = Integer.valueOf(androidx.compose.ui.graphics.n0.k(j2));
                Unit unit = Unit.INSTANCE;
                i4 = i9;
                LoadImageKt.g(str2, "守护图标", nVar, SizeKt.s(aVar, x0.i.g(24)), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, ((i9 >> 3) & 14) | 3120, 112);
                float g2 = x0.i.g(2);
                startRestartGroup.startReplaceGroup(-344996060);
                androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar, g2), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                i4 = i9;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            a6.j(str, (Modifier) null, j2, x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, w0.s.b.b(), false, 1, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer2, (i4 & 14) | 199680, 3120, 120786);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.o2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit X;
                    X = SeriesGuestProfilePageKt.X(str, str2, z, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return X;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fc, code lost:
    
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void Y(final java.lang.String r20, final java.lang.String r21, final boolean r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, final kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 748
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt.Y(java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
