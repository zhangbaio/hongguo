package com.dragon.read.kmp.profile.guestprofile.view.subpage;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.y1;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt;
import com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.e0;
import com.dragon.read.kmp.utils.m0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<s> a;
    final /* synthetic */ e0 b;
    final /* synthetic */ CoroutineScope c;
    final /* synthetic */ PagerState d;

    ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1(List<s> list, e0 e0Var, CoroutineScope coroutineScope, PagerState pagerState) {
        this.a = list;
        this.b = e0Var;
        this.c = coroutineScope;
        this.d = pagerState;
    }

    static final class a implements Function0<Unit> {
        final /* synthetic */ e0 a;
        final /* synthetic */ s b;

        a(e0 e0Var, s sVar) {
            this.a = e0Var;
            this.b = sVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }

        public final void a() {
            Integer num;
            com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
            ProfileTab profileTab = this.a.a.d;
            if (profileTab != null) {
                num = Integer.valueOf(profileTab.getValue());
            } else {
                num = null;
            }
            rVar.B(num, this.b.a.b, m0.a());
        }
    }

    public static final class b implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public b(List list) {
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
    public static final int e(PagerState pagerState) {
        return pagerState.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        d(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void d(Composer composer, int i) {
        boolean z;
        if ((i & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (composer.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1644107820, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.subpage.TabRowSubPageHeader.<anonymous>.<anonymous> (ProfileSubPageHeaderV2.kt:122)");
            }
            composer.startReplaceGroup(1849434622);
            final PagerState pagerState = this.d;
            Object rememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int e;
                        e = ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1.e(pagerState);
                        return Integer.valueOf(e);
                    }
                });
                composer.updateRememberedValue(rememberedValue);
            }
            final State state = (State) rememberedValue;
            composer.endReplaceGroup();
            e.f p = androidx.compose.foundation.layout.e.a.p(x0.i.g(6));
            i2 h = f2.h(SeriesGuestProfilePageKt.j1(), 0.0f, 2, (Object) null);
            composer.startReplaceGroup(-1224400529);
            boolean changedInstance = composer.changedInstance(this.a) | composer.changed(this.b) | composer.changedInstance(this.c) | composer.changed(this.d);
            final List<s> list = this.a;
            final e0 e0Var = this.b;
            final CoroutineScope coroutineScope = this.c;
            final PagerState pagerState2 = this.d;
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit g;
                        g = ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1.g(list, e0Var, coroutineScope, pagerState2, state, (o0) obj);
                        return g;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            androidx.compose.foundation.lazy.d.e((Modifier) null, (LazyListState) null, h, false, p, (e.c) null, (l1) null, false, (y1) null, (Function1) rememberedValue2, composer, 24960, 491);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }

    public static final class c implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ e0 b;
        final /* synthetic */ CoroutineScope c;
        final /* synthetic */ PagerState d;
        final /* synthetic */ State e;

        public c(List list, e0 e0Var, CoroutineScope coroutineScope, PagerState pagerState, State state) {
            this.a = list;
            this.b = e0Var;
            this.c = coroutineScope;
            this.d = pagerState;
            this.e = state;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, final int i, Composer composer, int i2) {
            int i3;
            boolean z;
            boolean z2;
            long o;
            c0 e;
            long h;
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
            boolean z3 = true;
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
                s sVar = (s) this.a.get(i);
                composer.startReplaceGroup(-150595076);
                if (ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1.f(this.e) == i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier i7 = SizeKt.i(aVar, x0.i.g(32));
                if (z2) {
                    composer.startReplaceGroup(826431825);
                    o = og4.a.a.h(composer, og4.a.b).x();
                } else {
                    composer.startReplaceGroup(826433098);
                    o = og4.a.a.h(composer, og4.a.b).o();
                }
                composer.endReplaceGroup();
                Modifier t = f2.t(BackgroundKt.c(i7, o, k.g.c(x0.i.g(8))), x0.i.g(14), 0.0f, 2, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(this.b) | composer.changedInstance(sVar);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(this.b, sVar);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier i0 = GuestProfileOneTabContentKt.i0(t, sVar, (Function0) rememberedValue);
                composer.startReplaceGroup(-1746271574);
                boolean changedInstance = composer.changedInstance(this.c) | composer.changed(this.d);
                if ((((i6 & 112) ^ 48) <= 32 || !composer.changed(i)) && (i6 & 48) != 32) {
                    z3 = false;
                }
                boolean z4 = changedInstance | z3;
                Object rememberedValue2 = composer.rememberedValue();
                if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    final CoroutineScope coroutineScope = this.c;
                    final PagerState pagerState = this.d;
                    rememberedValue2 = new Function0<Unit>() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1$1$1$1$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            a();
                            return Unit.INSTANCE;
                        }

                        public final void a() {
                            kotlinx.coroutines.i.e(CoroutineScope.this, null, null, new AnonymousClass1(pagerState, i, null), 3, null);
                        }

                        @DebugMetadata(c = "com.dragon.read.kmp.profile.guestprofile.view.subpage.ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1$1$1$1$2$1$1", f = "ProfileSubPageHeaderV2.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.dragon.read.kmp.profile.guestprofile.view.subpage.ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1$1$1$1$2$1$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ int $index;
                            final /* synthetic */ PagerState $pagerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(PagerState pagerState, int i, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$pagerState = pagerState;
                                this.$index = i;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$pagerState, this.$index, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i != 0) {
                                    if (i == 1) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    PagerState pagerState = this.$pagerState;
                                    int i2 = this.$index;
                                    this.label = 1;
                                    if (PagerState.U(pagerState, i2, 0.0f, this, 2, (Object) null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(i0, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i8 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, modifier);
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
                g5.e(b, i8, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e2, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                String str = sVar.a.a;
                if (str == null) {
                    str = "";
                }
                long h2 = x.h(14);
                c0.a aVar3 = c0.b;
                if (z2) {
                    e = aVar3.d();
                } else {
                    e = aVar3.e();
                }
                c0 c0Var = e;
                if (z2) {
                    composer.startReplaceGroup(1936990453);
                    h = og4.a.a.h(composer, og4.a.b).f();
                } else {
                    composer.startReplaceGroup(1936991664);
                    h = og4.a.a.h(composer, og4.a.b).h();
                }
                composer.endReplaceGroup();
                a6.j(str, boxScopeInstance.b(aVar, aVar2.e()), h, h2, (y) null, c0Var, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131024);
                composer.endNode();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(List list, e0 e0Var, CoroutineScope coroutineScope, PagerState pagerState, State state, o0 LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyRow.f(list.size(), (Function1) null, new b(list), t.c(2039820996, true, new c(list, e0Var, coroutineScope, pagerState, state)));
        return Unit.INSTANCE;
    }
}
