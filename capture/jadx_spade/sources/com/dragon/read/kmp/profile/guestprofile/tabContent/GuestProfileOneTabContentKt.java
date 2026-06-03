package com.dragon.read.kmp.profile.guestprofile.tabContent;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.b;
import androidx.compose.foundation.lazy.grid.b1;
import androidx.compose.foundation.lazy.grid.v0;
import androidx.compose.foundation.lazy.grid.w0;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.lazy.staggeredgrid.i0;
import androidx.compose.foundation.lazy.staggeredgrid.j0;
import androidx.compose.foundation.lazy.staggeredgrid.w0;
import androidx.compose.foundation.lazy.staggeredgrid.x0;
import androidx.compose.foundation.y1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.basenovel.ui.ui.ImageLoadScrollConnectionKt;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.list.KmpListFling_androidKt;
import com.dragon.read.kmp.compose.common.list.ScrollableListState;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt;
import com.dragon.read.kmp.profile.guestprofile.tabContent.data.FootLoadingState;
import com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.kmp.profile.justsaw.JustSawViewKt;
import com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel;
import com.dragon.read.rpc.kmp.community.model.j6;
import com.ss.ttm.player.MediaPlayer;
import gk4.n0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class GuestProfileOneTabContentKt {
    static {
        Covode.recordClassIndex(608145);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(androidx.compose.foundation.layout.r rVar, GuestProfileViewModel guestProfileViewModel, ScrollableListState scrollableListState, CollapsibleListState collapsibleListState, tl4.l lVar, int i2, Composer composer, int i3) {
        B(rVar, guestProfileViewModel, scrollableListState, collapsibleListState, lVar, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(androidx.compose.foundation.layout.r rVar, GuestProfileViewModel guestProfileViewModel, ScrollableListState scrollableListState, CollapsibleListState collapsibleListState, tl4.l lVar, int i2, Composer composer, int i3) {
        B(rVar, guestProfileViewModel, scrollableListState, collapsibleListState, lVar, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(ScrollableListState scrollableListState, int i2, Composer composer, int i3) {
        I(scrollableListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(ScrollableListState scrollableListState, int i2, Composer composer, int i3) {
        K(scrollableListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(ql4.a aVar, CollapsibleListState collapsibleListState, int i2, Composer composer, int i3) {
        M(aVar, collapsibleListState, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(LazyGridState lazyGridState, rl4.a aVar, rl4.c cVar, androidx.compose.ui.input.nestedscroll.b bVar, Function0 function0, int i2, Composer composer, int i3) {
        O(lazyGridState, aVar, cVar, bVar, function0, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(LazyStaggeredGridState lazyStaggeredGridState, rl4.a aVar, rl4.c cVar, androidx.compose.ui.input.nestedscroll.b bVar, Function0 function0, int i2, Composer composer, int i3) {
        W(lazyStaggeredGridState, aVar, cVar, bVar, function0, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(GuestProfileViewModel guestProfileViewModel, rl4.c cVar, rl4.a aVar, CollapsibleListState collapsibleListState, Function0 function0, int i2, Composer composer, int i3) {
        v(guestProfileViewModel, cVar, aVar, collapsibleListState, function0, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final class b implements DisposableEffectResult {
        final /* synthetic */ tl4.l a;

        public void dispose() {
            this.a.H();
        }

        public b(tl4.l lVar) {
            this.a = lVar;
        }
    }

    static final class c implements Function3<androidx.compose.foundation.lazy.grid.w, Composer, Integer, Unit> {
        final /* synthetic */ Object a;
        final /* synthetic */ Function0<Unit> b;
        final /* synthetic */ tl4.l c;

        c(Object obj, Function0<Unit> function0, tl4.l lVar) {
            this.a = obj;
            this.b = function0;
            this.c = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(tl4.l lVar) {
            lVar.Q(true);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(Function0 function0, tl4.l lVar) {
            function0.invoke();
            lVar.Q(false);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Composer composer, Integer num) {
            c(wVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(androidx.compose.foundation.lazy.grid.w item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1492734985, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.VerticalGrid.<anonymous>.<anonymous>.<anonymous> (GuestProfileOneTabContent.kt:217)");
                }
                j6 j6Var = (j6) this.a;
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(this.b) | composer.changed(this.c);
                final Function0<Unit> function0 = this.b;
                final tl4.l lVar = this.c;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.x
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d;
                            d = GuestProfileOneTabContentKt.c.d(Function0.this, lVar);
                            return d;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function02 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                boolean changed2 = composer.changed(this.c);
                final tl4.l lVar2 = this.c;
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e;
                            e = GuestProfileOneTabContentKt.c.e(tl4.l.this);
                            return e;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                com.dragon.read.kmp.profile.component.j.f(j6Var, function02, (Function0) rememberedValue2, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class h implements Function3<androidx.compose.foundation.lazy.staggeredgrid.s, Composer, Integer, Unit> {
        final /* synthetic */ SnapshotStateList<Object> a;
        final /* synthetic */ Function0<Unit> b;

        h(SnapshotStateList<Object> snapshotStateList, Function0<Unit> function0) {
            this.a = snapshotStateList;
            this.b = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.staggeredgrid.s sVar, Composer composer, Integer num) {
            b(sVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(androidx.compose.foundation.lazy.staggeredgrid.s item, Composer composer, int i) {
            boolean z;
            j6 j6Var;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(47594271, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.VerticalStaggeredGrid.<anonymous>.<anonymous>.<anonymous> (GuestProfileOneTabContent.kt:310)");
                }
                Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.a);
                if (first instanceof j6) {
                    j6Var = (j6) first;
                } else {
                    j6Var = null;
                }
                j6 j6Var2 = j6Var;
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(this.b);
                final Function0<Unit> function0 = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = GuestProfileOneTabContentKt.h.c(Function0.this);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                com.dragon.read.kmp.profile.component.j.f(j6Var2, (Function0) rememberedValue, null, composer, 0, 4);
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
    public static final ql4.a C(MutableState<ql4.a> mutableState) {
        return (ql4.a) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(ProfileTabJustSawViewModel profileTabJustSawViewModel) {
        profileTabJustSawViewModel.n();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(ProfileTabJustSawViewModel profileTabJustSawViewModel) {
        profileTabJustSawViewModel.v(true);
        return Unit.INSTANCE;
    }

    private static final ql4.a P(MutableState<ql4.a> mutableState) {
        return (ql4.a) mutableState.getValue();
    }

    private static final ql4.a X(MutableState<ql4.a> mutableState) {
        return (ql4.a) mutableState.getValue();
    }

    private static final ql4.a w(MutableState<ql4.a> mutableState) {
        return (ql4.a) mutableState.getValue();
    }

    public static final class e implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public e(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }

        public final Object a(int i) {
            return this.a.invoke(Integer.valueOf(i), this.b.get(i));
        }
    }

    public static final class f implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public f(List list) {
            this.a = list;
        }

        public final Object a(int i) {
            return GuestProfileOneTabContentKt.g0(i, this.a.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    public static final class j implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public j(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }

        public final Object a(int i) {
            return this.a.invoke(Integer.valueOf(i), this.b.get(i));
        }
    }

    public static final class k implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public k(List list) {
            this.a = list;
        }

        public final Object a(int i) {
            return GuestProfileOneTabContentKt.g0(i, this.a.get(i));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MutableState mutableState) {
        Function0<Unit> function0 = w(mutableState).c.h;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.foundation.lazy.grid.c U(androidx.compose.foundation.lazy.grid.y item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return androidx.compose.foundation.lazy.grid.c.a(b1.a(item.a()));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ rl4.a a;
        final /* synthetic */ LazyGridState b;
        final /* synthetic */ LazyStaggeredGridState c;
        final /* synthetic */ rl4.c d;
        final /* synthetic */ Function0<Unit> e;

        a(rl4.a aVar, LazyGridState lazyGridState, LazyStaggeredGridState lazyStaggeredGridState, rl4.c cVar, Function0<Unit> function0) {
            this.a = aVar;
            this.b = lazyGridState;
            this.c = lazyStaggeredGridState;
            this.d = cVar;
            this.e = function0;
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
                    ComposerKt.traceEventStart(-572928560, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContent.<anonymous>.<anonymous>.<anonymous> (GuestProfileOneTabContent.kt:158)");
                }
                if (this.a.e) {
                    composer.startReplaceGroup(85356201);
                    GuestProfileOneTabContentKt.W(this.c, this.a, this.d, ImageLoadScrollConnectionKt.c(this.b, 0, 0, composer, 0, 6), this.e, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(85592979);
                    GuestProfileOneTabContentKt.O(this.b, this.a, this.d, ImageLoadScrollConnectionKt.c(this.c, 0, 0, composer, 0, 6), this.e, composer, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.foundation.lazy.grid.c R(int i2, androidx.compose.foundation.lazy.grid.y item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return androidx.compose.foundation.lazy.grid.c.a(b1.a(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.foundation.lazy.grid.c S(int i2, androidx.compose.foundation.lazy.grid.y item) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        return androidx.compose.foundation.lazy.grid.c.a(b1.a(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object T(int i2, Object model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return h0(i2, model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object Z(int i2, Object model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return h0(i2, model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object z(tl4.l lVar, int i2) {
        return CollectionsKt___CollectionsKt.getOrNull(lVar.h.a, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g0(int i2, Object obj) {
        if (obj instanceof ll4.f) {
            return "celebrity_video";
        }
        if (obj instanceof bl4.a) {
            return "video_item";
        }
        if (obj instanceof n0) {
            return "series_post";
        }
        return "unknown";
    }

    private static final String h0(int i2, Object obj) {
        if (obj instanceof bl4.a) {
            return "video_" + obj.hashCode();
        }
        if (obj instanceof n0) {
            return "post_" + ((n0) obj).a + '_' + obj.hashCode();
        }
        if (obj instanceof ll4.f) {
            return "celebrity_" + obj.hashCode();
        }
        return "item_" + obj.hashCode();
    }

    static final class d implements Function3<androidx.compose.foundation.lazy.grid.w, Composer, Integer, Unit> {
        final /* synthetic */ tl4.l a;

        d(tl4.l lVar) {
            this.a = lVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Composer composer, Integer num) {
            a(wVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.grid.w item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-808992956, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.VerticalGrid.<anonymous>.<anonymous>.<anonymous> (GuestProfileOneTabContent.kt:261)");
                }
                sl4.t.d((FootLoadingState) this.a.h.c.getValue(), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class i implements Function3<androidx.compose.foundation.lazy.staggeredgrid.s, Composer, Integer, Unit> {
        final /* synthetic */ tl4.l a;

        i(tl4.l lVar) {
            this.a = lVar;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.staggeredgrid.s sVar, Composer composer, Integer num) {
            a(sVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.staggeredgrid.s item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1214191910, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.VerticalStaggeredGrid.<anonymous>.<anonymous>.<anonymous> (GuestProfileOneTabContent.kt:332)");
                }
                sl4.t.d((FootLoadingState) this.a.h.c.getValue(), composer, 0);
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
    public static final DisposableEffectResult x(tl4.l lVar, CoroutineScope coroutineScope, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        lVar.G(coroutineScope);
        return new b(lVar);
    }

    public static final Modifier i0(Modifier modifier, final jd4.b model, final Function0<Unit> onFirstVisible) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(onFirstVisible, "onFirstVisible");
        if (!model.isShown()) {
            return d1.a(modifier, new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit j0;
                    j0 = GuestProfileOneTabContentKt.j0(model, onFirstVisible, (androidx.compose.ui.layout.w) obj);
                    return j0;
                }
            });
        }
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(jd4.b bVar, Function0 function0, androidx.compose.ui.layout.w coordinates) {
        a0.h hVar;
        boolean z;
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (bVar.isShown()) {
            return Unit.INSTANCE;
        }
        a0.h c2 = androidx.compose.ui.layout.x.c(coordinates);
        androidx.compose.ui.layout.w W = coordinates.W();
        if (W != null) {
            hVar = androidx.compose.ui.layout.x.c(W);
        } else {
            hVar = null;
        }
        if (hVar != null) {
            z = hVar.r(c2);
        } else {
            z = false;
        }
        if (z) {
            bVar.setShown(true);
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final void I(final ScrollableListState scrollableListState, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean changedInstance;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1805751210);
        if ((i2 & 6) == 0) {
            if ((i2 & 8) == 0) {
                changedInstance = startRestartGroup.changed(scrollableListState);
            } else {
                changedInstance = startRestartGroup.changedInstance(scrollableListState);
            }
            if (changedInstance) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i2;
        } else {
            i3 = i2;
        }
        boolean z2 = false;
        if ((i3 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1805751210, i3, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.LoadMoreHandler (GuestProfileOneTabContent.kt:446)");
            }
            tl4.l lVar = (tl4.l) startRestartGroup.consume(ProfileTabPagerKt.E());
            startRestartGroup.startReplaceGroup(-1633490746);
            int i5 = i3 & 14;
            if (i5 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(scrollableListState))) {
                z2 = true;
            }
            boolean changed = startRestartGroup.changed(lVar) | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new GuestProfileOneTabContentKt$LoadMoreHandler$1$1(scrollableListState, lVar, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(scrollableListState, (Function2) rememberedValue, startRestartGroup, ScrollableListState.d | i5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit J;
                    J = GuestProfileOneTabContentKt.J(scrollableListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return J;
                }
            });
        }
    }

    private static final void K(final ScrollableListState scrollableListState, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean changedInstance;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-864180712);
        if ((i2 & 6) == 0) {
            if ((i2 & 8) == 0) {
                changedInstance = startRestartGroup.changed(scrollableListState);
            } else {
                changedInstance = startRestartGroup.changedInstance(scrollableListState);
            }
            if (changedInstance) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i2;
        } else {
            i3 = i2;
        }
        boolean z2 = true;
        if ((i3 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-864180712, i3, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.ScrollEffectListen (GuestProfileOneTabContent.kt:382)");
            }
            tl4.l lVar = (tl4.l) startRestartGroup.consume(ProfileTabPagerKt.E());
            Boolean valueOf = Boolean.valueOf(scrollableListState.j());
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i3 & 14) != 4 && ((i3 & 8) == 0 || !startRestartGroup.changedInstance(scrollableListState))) {
                z2 = false;
            }
            boolean changed = startRestartGroup.changed(lVar) | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new GuestProfileOneTabContentKt$ScrollEffectListen$1$1(scrollableListState, lVar, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit L;
                    L = GuestProfileOneTabContentKt.L(scrollableListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return L;
                }
            });
        }
    }

    public static final class g implements Function4<androidx.compose.foundation.lazy.grid.w, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ rl4.a b;
        final /* synthetic */ Function0 c;
        final /* synthetic */ SnapshotStateList d;

        public g(List list, rl4.a aVar, Function0 function0, SnapshotStateList snapshotStateList) {
            this.a = list;
            this.b = aVar;
            this.c = function0;
            this.d = snapshotStateList;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.grid.w wVar, Integer num, Composer composer, Integer num2) {
            a(wVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.grid.w wVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(wVar)) {
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
                    ComposerKt.traceEventStart(-1942245546, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:576)");
                }
                Object obj = this.a.get(i);
                int i6 = (i3 & 112) | (i3 & 14);
                composer.startReplaceGroup(217455793);
                if (this.b.f) {
                    composer.startReplaceGroup(217482607);
                    Modifier.a aVar = Modifier.Companion;
                    Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                    p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
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
                    c0 c0Var = c0.b;
                    int i7 = i6 >> 3;
                    sl4.p.a.p(i, obj, this.c, composer, (i7 & 14) | 3072 | (i7 & 112), 0);
                    composer.startReplaceGroup(-1631259625);
                    if (i < CollectionsKt__CollectionsKt.getLastIndex(this.d)) {
                        float f = this.b.g;
                        androidx.compose.foundation.layout.m.b(BackgroundKt.d(SizeKt.i(SizeKt.h(f2.v(aVar, f, 0.0f, f, 0.0f, 10, (Object) null), 0.0f, 1, (Object) null), this.b.h), og4.a.a.h(composer, og4.a.b).t(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), composer, 0);
                    }
                    composer.endReplaceGroup();
                    composer.endNode();
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(218325497);
                    int i8 = i6 >> 3;
                    sl4.p.a.p(i, obj, this.c, composer, (i8 & 14) | 3072 | (i8 & 112), 0);
                    composer.endReplaceGroup();
                }
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

    public static final class l implements Function4<androidx.compose.foundation.lazy.staggeredgrid.s, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ Function0 b;

        public l(List list, Function0 function0) {
            this.a = list;
            this.b = function0;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.staggeredgrid.s sVar, Integer num, Composer composer, Integer num2) {
            a(sVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.staggeredgrid.s sVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(sVar)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i5 | i2;
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
                    ComposerKt.traceEventStart(-1466459515, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:436)");
                }
                Object obj = this.a.get(i);
                composer.startReplaceGroup(-870416260);
                int i6 = ((i3 & 112) | (i3 & 14)) >> 3;
                sl4.p.a.p(i, obj, this.b, composer, (i6 & 14) | 3072 | (i6 & 112), 0);
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

    private static final void M(final ql4.a aVar, final CollapsibleListState collapsibleListState, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        float f2;
        boolean changedInstance;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(520651461);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changedInstance(aVar)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i3 = i5 | i2;
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
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 |= i4;
        }
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(520651461, i3, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.TabLoadLayout (GuestProfileOneTabContent.kt:469)");
            }
            boolean d2 = com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
            Modifier.a aVar2 = Modifier.Companion;
            Modifier i6 = SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), ((x0.i) collapsibleListState.f.getValue()).m());
            e.a aVar3 = androidx.compose.ui.e.a;
            p0 i7 = androidx.compose.foundation.layout.m.i(aVar3.m(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, i6);
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
            g5.e(b2, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (mg4.c.c(aVar.a)) {
                startRestartGroup.startReplaceGroup(242669594);
                mg4.k.r(aVar.a, (mg4.b) null, l0.b.g(), SizeKt.D(boxScopeInstance.b(aVar2, aVar3.m()), (androidx.compose.ui.e) null, false, 3, (Object) null), com.dragon.read.kmp.profile.guestprofile.tabContent.a.a.b(), false, (Function3) null, (Function3) null, (Function2) null, startRestartGroup, 24960, 482);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                composer2 = startRestartGroup;
                LoadStatus loadStatus = aVar.a;
                if (loadStatus != LoadStatus.Error && loadStatus != LoadStatus.Empty) {
                    composer2.startReplaceGroup(243777751);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(243395273);
                    al4.a aVar4 = aVar.c;
                    if (d2) {
                        f2 = 0.8f;
                    } else {
                        f2 = 1.0f;
                    }
                    aVar4.f = f2;
                    Modifier v = f2.v(SizeKt.f(aVar2, 0.0f, 1, (Object) null), 0.0f, x0.i.g(aVar.c.c), 0.0f, 0.0f, 13, (Object) null);
                    p0 i8 = androidx.compose.foundation.layout.m.i(aVar3.m(), false);
                    int a4 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                    e0 currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier e3 = ComposedModifierKt.e(composer2, v);
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
                    Composer b4 = g5.b(composer2);
                    g5.e(b4, i8, companion.c());
                    g5.e(b4, currentCompositionLocalMap2, companion.e());
                    Function2 b5 = companion.b();
                    if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                        b4.updateRememberedValue(Integer.valueOf(a4));
                        b4.apply(Integer.valueOf(a4), b5);
                    }
                    g5.e(b4, e3, companion.d());
                    al4.e.d(aVar.c, composer2, 0);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
            }
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit N;
                    N = GuestProfileOneTabContentKt.N(ql4.a.this, collapsibleListState, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return N;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(SnapshotStateList snapshotStateList, MutableState mutableState, Function0 function0, tl4.l lVar, j0 LazyVerticalStaggeredGrid) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(LazyVerticalStaggeredGrid, "$this$LazyVerticalStaggeredGrid");
        if (!ql4.b.a(X(mutableState))) {
            i0.a(LazyVerticalStaggeredGrid, (Object) null, (Object) null, x0.b.a(), com.dragon.read.kmp.profile.guestprofile.tabContent.a.a.c(), 3, (Object) null);
        } else {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) snapshotStateList);
            if (firstOrNull instanceof j6) {
                i0.a(LazyVerticalStaggeredGrid, (Object) null, (Object) null, x0.b.a(), androidx.compose.runtime.internal.t.c(47594271, true, new h(snapshotStateList, function0)), 3, (Object) null);
            }
            LazyVerticalStaggeredGrid.c(snapshotStateList.size(), new j(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Object Z;
                    Z = GuestProfileOneTabContentKt.Z(((Integer) obj).intValue(), obj2);
                    return Z;
                }
            }, snapshotStateList), new k(snapshotStateList), (Function1) null, androidx.compose.runtime.internal.t.c(-1466459515, true, new l(snapshotStateList, function0)));
            i0.a(LazyVerticalStaggeredGrid, (Object) null, (Object) null, x0.b.a(), androidx.compose.runtime.internal.t.c(-1214191910, true, new i(lVar)), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(final LazyGridState lazyGridState, final rl4.a aVar, final rl4.c cVar, final androidx.compose.ui.input.nestedscroll.b bVar, final Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        final Object firstOrNull;
        List list;
        boolean z2;
        boolean z3;
        int i4;
        List drop;
        int i5;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-605223524);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(lazyGridState)) {
                i8 = 4;
            } else {
                i8 = 2;
            }
            i3 = i8 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(aVar)) {
                i7 = 32;
            } else {
                i7 = 16;
            }
            i3 |= i7;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changedInstance(bVar)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        int i9 = i3;
        if ((i9 & 9235) != 9234) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i9 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-605223524, i9, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.VerticalGrid (GuestProfileOneTabContent.kt:187)");
            }
            final int a2 = vg4.d.a(aVar.a, startRestartGroup, 0);
            final tl4.l lVar = (tl4.l) startRestartGroup.consume(ProfileTabPagerKt.E());
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = lVar.g;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            final List list2 = lVar.h.a;
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            final boolean z4 = firstOrNull instanceof j6;
            if (z4) {
                drop = CollectionsKt___CollectionsKt.drop(list2, 1);
                list = drop;
            } else {
                list = list2;
            }
            b.a aVar2 = new b.a(a2);
            Modifier b2 = androidx.compose.ui.input.nestedscroll.c.b(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), bVar, (NestedScrollDispatcher) null, 2, (Object) null);
            float f2 = aVar.d;
            i2 j2 = f2.j(f2, x0.i.g(2), f2, 0.0f, 8, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.f p = eVar.p(aVar.b);
            e.f p2 = eVar.p(aVar.c);
            l1 b3 = KmpListFling_androidKt.b(lVar.a.w, startRestartGroup, com.dragon.read.kmp.compose.common.list.k.f, 0);
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changed = startRestartGroup.changed(a2) | startRestartGroup.changed(z4) | startRestartGroup.changedInstance(firstOrNull);
            if ((57344 & i9) == 16384) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean changed2 = changed | z2 | startRestartGroup.changed(lVar);
            final List list3 = list;
            boolean changedInstance = changed2 | startRestartGroup.changedInstance(list3);
            if ((i9 & 112) == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean changed3 = changedInstance | z3 | startRestartGroup.changed(list2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed3 && rememberedValue2 != companion.getEmpty()) {
                i4 = i9;
            } else {
                i4 = i9;
                Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Q;
                        Q = GuestProfileOneTabContentKt.Q(z4, list3, mutableState, a2, firstOrNull, function0, lVar, aVar, list2, (w0) obj);
                        return Q;
                    }
                };
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue2 = function1;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            androidx.compose.foundation.lazy.grid.i.c(aVar2, b2, lazyGridState, j2, false, p2, p, b3, false, (y1) null, (Function1) rememberedValue2, composer2, (i4 << 6) & 896, 0, 784);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit V;
                    V = GuestProfileOneTabContentKt.V(lazyGridState, aVar, cVar, bVar, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return V;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final LazyStaggeredGridState lazyStaggeredGridState, final rl4.a aVar, final rl4.c cVar, final androidx.compose.ui.input.nestedscroll.b bVar, final Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1195352312);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(lazyStaggeredGridState)) {
                i7 = 4;
            } else {
                i7 = 2;
            }
            i3 = i7 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(aVar)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i3 |= i6;
        }
        if ((i2 & 3072) == 0) {
            if (startRestartGroup.changedInstance(bVar)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        if ((i3 & 9235) != 9234) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1195352312, i3, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.VerticalStaggeredGrid (GuestProfileOneTabContent.kt:277)");
            }
            int a2 = vg4.d.a(aVar.a, startRestartGroup, 0);
            final tl4.l lVar = (tl4.l) startRestartGroup.consume(ProfileTabPagerKt.E());
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = lVar.g;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            final SnapshotStateList<Object> snapshotStateList = lVar.h.a;
            w0.a aVar2 = new w0.a(a2);
            Modifier b2 = androidx.compose.ui.input.nestedscroll.c.b(SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null), bVar, (NestedScrollDispatcher) null, 2, (Object) null);
            float f2 = aVar.d;
            i2 j2 = f2.j(f2, x0.i.g(2), f2, 0.0f, 8, (Object) null);
            e.f p = androidx.compose.foundation.layout.e.a.p(aVar.b);
            float f3 = aVar.c;
            l1 b3 = KmpListFling_androidKt.b(lVar.a.w, startRestartGroup, com.dragon.read.kmp.compose.common.list.k.f, 0);
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changed = startRestartGroup.changed(snapshotStateList);
            if ((i3 & 57344) == 16384) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean changed2 = changed | z2 | startRestartGroup.changed(lVar);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Y;
                        Y = GuestProfileOneTabContentKt.Y(snapshotStateList, mutableState, function0, lVar, (j0) obj);
                        return Y;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            androidx.compose.foundation.lazy.staggeredgrid.g.c(aVar2, b2, lazyStaggeredGridState, j2, false, f3, p, b3, false, (y1) null, (Function1) rememberedValue2, startRestartGroup, (i3 << 6) & 896, 0, 784);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit a0;
                    a0 = GuestProfileOneTabContentKt.a0(lazyStaggeredGridState, aVar, cVar, bVar, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return a0;
                }
            });
        }
    }

    private static final void B(final androidx.compose.foundation.layout.r rVar, final GuestProfileViewModel guestProfileViewModel, final ScrollableListState scrollableListState, final CollapsibleListState collapsibleListState, final tl4.l lVar, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        ProfileTabJustSawViewModel profileTabJustSawViewModel;
        int i4;
        int i5;
        boolean changedInstance;
        int i6;
        boolean changedInstance2;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-598375530);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i3 = i9 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(guestProfileViewModel)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i3 |= i8;
        }
        if ((i2 & 384) == 0) {
            if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
                changedInstance2 = startRestartGroup.changed(scrollableListState);
            } else {
                changedInstance2 = startRestartGroup.changedInstance(scrollableListState);
            }
            if (changedInstance2) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        if ((i2 & 3072) == 0) {
            if ((i2 & 4096) == 0) {
                changedInstance = startRestartGroup.changed(collapsibleListState);
            } else {
                changedInstance = startRestartGroup.changedInstance(collapsibleListState);
            }
            if (changedInstance) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i2 & 24576) == 0) {
            if (startRestartGroup.changed(lVar)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        boolean z4 = true;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-598375530, i3, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.JustSawButton (GuestProfileOneTabContent.kt:405)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = lVar.g;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            ProfileTabJustSawViewModel profileTabJustSawViewModel2 = lVar.k;
            if (profileTabJustSawViewModel2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.v
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit D;
                            D = GuestProfileOneTabContentKt.D(rVar, guestProfileViewModel, scrollableListState, collapsibleListState, lVar, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return D;
                        }
                    });
                    return;
                }
                return;
            }
            MutableState<Boolean> mutableState2 = guestProfileViewModel.z;
            ql4.a C = C(mutableState);
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changedInstance3 = startRestartGroup.changedInstance(profileTabJustSawViewModel2);
            if ((i3 & 57344) == 16384) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z5 = z2 | changedInstance3;
            if ((i3 & 896) != 256 && ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0 || !startRestartGroup.changedInstance(scrollableListState))) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean z6 = z3 | z5;
            if ((i3 & 7168) != 2048 && ((i3 & 4096) == 0 || !startRestartGroup.changedInstance(collapsibleListState))) {
                z4 = false;
            }
            boolean z7 = z6 | z4;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z7 && rememberedValue2 != companion.getEmpty()) {
                profileTabJustSawViewModel = profileTabJustSawViewModel2;
                i4 = 16;
            } else {
                profileTabJustSawViewModel = profileTabJustSawViewModel2;
                i4 = 16;
                GuestProfileOneTabContentKt$JustSawButton$1$1 guestProfileOneTabContentKt$JustSawButton$1$1 = new GuestProfileOneTabContentKt$JustSawButton$1$1(profileTabJustSawViewModel2, lVar, scrollableListState, collapsibleListState, mutableState, null);
                startRestartGroup.updateRememberedValue(guestProfileOneTabContentKt$JustSawButton$1$1);
                rememberedValue2 = guestProfileOneTabContentKt$JustSawButton$1$1;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(C, (Function2) rememberedValue2, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = androidx.compose.animation.core.b.b(36.0f, 0.0f, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Animatable animatable = (Animatable) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Boolean valueOf = Boolean.valueOf(E(mutableState2));
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance4 = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(mutableState2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new GuestProfileOneTabContentKt$JustSawButton$2$1(animatable, mutableState2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue4, startRestartGroup, 0);
            final ProfileTabJustSawViewModel profileTabJustSawViewModel3 = profileTabJustSawViewModel;
            com.dragon.read.kmp.profile.justsaw.i iVar = profileTabJustSawViewModel3.e;
            Modifier v = f2.v(rVar.b(Modifier.Companion, androidx.compose.ui.e.a.c()), 0.0f, 0.0f, x0.i.g(i4), x0.i.g(((Number) animatable.k()).floatValue()), 3, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance5 = startRestartGroup.changedInstance(profileTabJustSawViewModel3);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit F;
                        F = GuestProfileOneTabContentKt.F(ProfileTabJustSawViewModel.this);
                        return F;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function0 = (Function0) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(5004770);
            boolean changedInstance6 = startRestartGroup.changedInstance(profileTabJustSawViewModel3);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit G;
                        G = GuestProfileOneTabContentKt.G(ProfileTabJustSawViewModel.this);
                        return G;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            JustSawViewKt.g(iVar, v, function0, (Function0) rememberedValue6, startRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit H;
                    H = GuestProfileOneTabContentKt.H(rVar, guestProfileViewModel, scrollableListState, collapsibleListState, lVar, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return H;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0151, code lost:
    
        if (r13 == r23.getEmpty()) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void v(final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r36, final rl4.c r37, final rl4.a r38, final com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState r39, final kotlin.jvm.functions.Function0<kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42) {
        /*
            Method dump skipped, instructions count: 880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.tabContent.GuestProfileOneTabContentKt.v(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, rl4.c, rl4.a, com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(boolean z, List list, MutableState mutableState, final int i2, Object obj, Function0 function0, tl4.l lVar, rl4.a aVar, SnapshotStateList snapshotStateList, androidx.compose.foundation.lazy.grid.w0 LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        if (!ql4.b.a(P(mutableState))) {
            v0.a(LazyVerticalGrid, (Object) null, new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    androidx.compose.foundation.lazy.grid.c R;
                    R = GuestProfileOneTabContentKt.R(i2, (androidx.compose.foundation.lazy.grid.y) obj2);
                    return R;
                }
            }, (Object) null, com.dragon.read.kmp.profile.guestprofile.tabContent.a.a.a(), 5, (Object) null);
        } else {
            if (z) {
                v0.a(LazyVerticalGrid, (Object) null, new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        androidx.compose.foundation.lazy.grid.c S;
                        S = GuestProfileOneTabContentKt.S(i2, (androidx.compose.foundation.lazy.grid.y) obj2);
                        return S;
                    }
                }, (Object) null, androidx.compose.runtime.internal.t.c(1492734985, true, new c(obj, function0, lVar)), 5, (Object) null);
            }
            LazyVerticalGrid.d(list.size(), new e(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Object T;
                    T = GuestProfileOneTabContentKt.T(((Integer) obj2).intValue(), obj3);
                    return T;
                }
            }, list), (Function2) null, new f(list), androidx.compose.runtime.internal.t.c(-1942245546, true, new g(list, aVar, function0, snapshotStateList)));
            v0.a(LazyVerticalGrid, (Object) null, new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.tabContent.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    androidx.compose.foundation.lazy.grid.c U;
                    U = GuestProfileOneTabContentKt.U((androidx.compose.foundation.lazy.grid.y) obj2);
                    return U;
                }
            }, (Object) null, androidx.compose.runtime.internal.t.c(-808992956, true, new d(lVar)), 5, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
