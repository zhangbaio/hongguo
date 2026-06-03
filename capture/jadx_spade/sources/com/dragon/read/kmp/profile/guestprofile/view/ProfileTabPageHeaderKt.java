package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.TabRowDefaults;
import androidx.compose.material.i5;
import androidx.compose.material.o5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.ui.BubbleGravity;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import com.ss.ttm.player.MediaPlayer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileTabPageHeaderKt {
    static {
        Covode.recordClassIndex(608170);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(PagerState pagerState, int i, boolean z, int i2, Composer composer, int i3) {
        v(pagerState, i, z, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(GuestProfileViewModel guestProfileViewModel, List list, PagerState pagerState, boolean z, int i, int i2, Composer composer, int i3) {
        j(guestProfileViewModel, list, pagerState, z, composer, androidx.compose.runtime.x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(GuestProfileViewModel guestProfileViewModel, PagerState pagerState, boolean z, int i, Composer composer, int i2) {
        l(guestProfileViewModel, pagerState, z, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(GuestProfileViewModel guestProfileViewModel, PagerState pagerState, boolean z, int i, Composer composer, int i2) {
        q(guestProfileViewModel, pagerState, z, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(PagerState pagerState, int i, boolean z, int i2, Composer composer, int i3) {
        v(pagerState, i, z, composer, androidx.compose.runtime.x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(MutableState mutableState) {
        x(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(PagerState pagerState) {
        return pagerState.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<c7> p(MutableState<List<c7>> mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<c7> r(MutableState<List<c7>> mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(PagerState pagerState) {
        return pagerState.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    private static final boolean w(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float z(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final void A(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(MutableState mutableState, float f) {
        A(mutableState, f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MutableState<Float> a;

        b(MutableState<Float> mutableState) {
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
                    ComposerKt.traceEventStart(849796371, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.SelectTabGuideBubble.<anonymous> (ProfileTabPageHeader.kt:268)");
                }
                wg4.k.b((Modifier) null, og4.a.a.h(composer, og4.a.b).x2(), x0.i.g(8), x0.i.g(11), x0.i.g(5), BubbleGravity.TOP, ProfileTabPageHeaderKt.z(this.a), com.dragon.read.kmp.profile.guestprofile.view.b.a.d(), composer, 12807552, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class a implements Function3<List<? extends i5>, Composer, Integer, Unit> {
        final /* synthetic */ PagerState a;
        final /* synthetic */ State<Integer> b;

        a(PagerState pagerState, State<Integer> state) {
            this.a = pagerState;
            this.b = state;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends i5> list, Composer composer, Integer num) {
            a(list, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(List<i5> tabs, Composer composer, int i) {
            IntRange indices;
            int coerceIn;
            int coerceAtMost;
            Intrinsics.checkNotNullParameter(tabs, "tabs");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(383682901, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderV1.<anonymous>.<anonymous> (ProfileTabPageHeader.kt:162)");
            }
            int n = ProfileTabPageHeaderKt.n(this.b);
            indices = CollectionsKt__CollectionsKt.getIndices(tabs);
            coerceIn = RangesKt___RangesKt.coerceIn(n, (ClosedRange<Integer>) indices);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceIn + 1, CollectionsKt__CollectionsKt.getLastIndex(tabs));
            float v = this.a.v();
            float b = x0.j.b(tabs.get(coerceIn).a, tabs.get(coerceAtMost).a, v);
            float b2 = x0.j.b(tabs.get(coerceIn).a(), tabs.get(coerceAtMost).a(), v);
            float f = 4;
            TabRowDefaults.a.e(ig4.i.a(androidx.compose.foundation.layout.f2.s(SizeKt.x(androidx.compose.foundation.layout.u1.f(SizeKt.F(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), androidx.compose.ui.e.a.k(), false, 2, (Object) null), b, 0.0f, 2, (Object) null), x0.i.g(b2 - b)), x0.i.g(f), x0.i.g(f)), 8), 0.0f, com.dragon.read.kmp.utils.b.a(composer, 0).a(), composer, TabRowDefaults.e << 9, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final void q(final GuestProfileViewModel viewModel, final PagerState pagerState, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer startRestartGroup = composer.startRestartGroup(1777301206);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(viewModel)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(pagerState)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1777301206, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderV2 (ProfileTabPageHeader.kt:84)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = viewModel.k;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int s;
                        s = ProfileTabPageHeaderKt.s(pagerState);
                        return Integer.valueOf(s);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            State state = (State) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            Modifier.a aVar = Modifier.Companion;
            float f = 8;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
            int t = t(state);
            Modifier b4 = boxScopeInstance.b(SizeKt.B(SizeKt.h(aVar, 0.0f, 1, (Object) null), (e.c) null, false, 3, (Object) null), aVar2.o());
            float g = x0.i.g(0);
            com.dragon.read.kmp.profile.guestprofile.view.b bVar = com.dragon.read.kmp.profile.guestprofile.view.b.a;
            composer2 = startRestartGroup;
            com.dragon.read.kmp.widget.slidetab.e.b(t, b4, 0L, 0L, g, bVar.a(), bVar.c(), androidx.compose.runtime.internal.t.e(-1571087010, true, new ProfileTabPageHeaderKt$ProfileTabPageHeaderV2$1$1(mutableState, viewModel, pagerState, state, z), startRestartGroup, 54), composer2, 14376960, 12);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = ProfileTabPageHeaderKt.u(GuestProfileViewModel.this, pagerState, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007f, code lost:
    
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void v(final androidx.compose.foundation.pager.PagerState r17, final int r18, final boolean r19, androidx.compose.runtime.Composer r20, final int r21) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderKt.v(androidx.compose.foundation.pager.PagerState, int, boolean, androidx.compose.runtime.Composer, int):void");
    }

    public static final void l(final GuestProfileViewModel viewModel, final PagerState pagerState, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer startRestartGroup = composer.startRestartGroup(1992130359);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(viewModel)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(pagerState)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1992130359, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeaderV1 (ProfileTabPageHeader.kt:141)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = viewModel.k;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int m;
                        m = ProfileTabPageHeaderKt.m(pagerState);
                        return Integer.valueOf(m);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            State state = (State) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), SeriesGuestProfilePageKt.j1(), 0.0f, SeriesGuestProfilePageKt.j1(), x0.i.g(8), 2, (Object) null);
            androidx.compose.ui.layout.p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
            List<c7> p = p(mutableState);
            if (!(p instanceof Collection) || !p.isEmpty()) {
                Iterator<T> it2 = p.iterator();
                while (it2.hasNext()) {
                    Integer num = ((c7) it2.next()).b;
                    int value = ProfileTab.Select.getValue();
                    if (num != null && num.intValue() == value) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        z4 = true;
                        break;
                    }
                }
            }
            z4 = false;
            int n = n(state);
            long o = og4.a.a.h(startRestartGroup, og4.a.b).o();
            Modifier c = ig4.i.c(SizeKt.i(Modifier.Companion, x0.i.g(38)), x0.i.d(x0.i.g(12)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
            androidx.compose.runtime.internal.a e2 = androidx.compose.runtime.internal.t.e(383682901, true, new a(pagerState, state), startRestartGroup, 54);
            Function2<Composer, Integer, Unit> b4 = com.dragon.read.kmp.profile.guestprofile.view.b.a.b();
            androidx.compose.runtime.internal.a e3 = androidx.compose.runtime.internal.t.e(-584729771, true, new ProfileTabPageHeaderKt$ProfileTabPageHeaderV1$1$2(mutableState, viewModel, pagerState, state, z4, z), startRestartGroup, 54);
            composer2 = startRestartGroup;
            o5.e(n, c, o, 0L, e2, b4, e3, composer2, 1794048, 8);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o2;
                    o2 = ProfileTabPageHeaderKt.o(GuestProfileViewModel.this, pagerState, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o2;
                }
            });
        }
    }

    public static final void j(final GuestProfileViewModel viewModel, final List<c7> mainProfileTabList, final PagerState pagerState, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(mainProfileTabList, "mainProfileTabList");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer startRestartGroup = composer.startRestartGroup(-1220410902);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(viewModel)) {
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
            if (startRestartGroup.changedInstance(mainProfileTabList)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changed(pagerState)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (startRestartGroup.changed(z)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        boolean z3 = false;
        if ((i3 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i3 & 1)) {
            if (i8 != 0) {
                z = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1220410902, i3, -1, "com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPageHeader (ProfileTabPageHeader.kt:68)");
            }
            com.dragon.read.kmp.profile.params.a aVar = viewModel.f;
            if (aVar != null && aVar.enableMultiRoles()) {
                z3 = true;
            }
            if (z3) {
                startRestartGroup.startReplaceGroup(-362715552);
                int i9 = i3 & 14;
                int i10 = i3 >> 3;
                q(viewModel, pagerState, z, startRestartGroup, i9 | (i10 & 112) | (i10 & 896));
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-362620537);
                if (mainProfileTabList.size() > 1) {
                    int i11 = i3 & 14;
                    int i12 = i3 >> 3;
                    l(viewModel, pagerState, z, startRestartGroup, i11 | (i12 & 112) | (i12 & 896));
                }
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final boolean z4 = z;
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = ProfileTabPageHeaderKt.k(GuestProfileViewModel.this, mainProfileTabList, pagerState, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }
}
