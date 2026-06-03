package com.dragon.read.kmp.profile.guestprofile.view.subpage;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayoutKt;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.profile.guestprofile.tabContent.b0;
import com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt;
import com.dragon.read.kmp.profile.guestprofile.view.SeriesGuestProfilePageKt;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.e0;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.f0;
import com.dragon.read.kmp.u;
import com.dragon.read.kmp.widget.v0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileSubPageHeaderV2Kt {
    static {
        Covode.recordClassIndex(608178);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PagerState pagerState, int i, Composer composer, int i2) {
        g(pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(e0 e0Var, int i, Composer composer, int i2) {
        k(e0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(e0 e0Var, int i, Composer composer, int i2) {
        k(e0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(e0 e0Var, PagerState pagerState, int i, Composer composer, int i2) {
        o(e0Var, pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final List<c7> h(MutableState<List<c7>> mutableState) {
        return (List) mutableState.getValue();
    }

    private static final f0 l(State<f0> state) {
        return (f0) state.getValue();
    }

    private static final List<c7> q(MutableState<List<c7>> mutableState) {
        return (List) mutableState.getValue();
    }

    private static final f0 r(State<f0> state) {
        return (f0) state.getValue();
    }

    private static final boolean t(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(tl4.l lVar) {
        b0 b0Var;
        SnapshotStateList<Object> snapshotStateList;
        if (lVar != null && (b0Var = lVar.h) != null && (snapshotStateList = b0Var.a) != null) {
            return snapshotStateList.isEmpty();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(e0 e0Var, FilterOptionHeaderType preOption, FilterOptionHeaderType filterOption) {
        Intrinsics.checkNotNullParameter(preOption, "preOption");
        Intrinsics.checkNotNullParameter(filterOption, "filterOption");
        e0Var.f(preOption, filterOption);
        return Unit.INSTANCE;
    }

    public static final void g(final PagerState pagerState, Composer composer, final int i) {
        int i2;
        boolean z;
        List filterNotNull;
        int i3;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer startRestartGroup = composer.startRestartGroup(716236142);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(pagerState)) {
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
                ComposerKt.traceEventStart(716236142, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.subpage.ProfileSubPageHeaderV2 (ProfileSubPageHeaderV2.kt:60)");
            }
            final e0 e0Var = (e0) startRestartGroup.consume(ProfileTabPagerKt.F());
            rl4.c cVar = e0Var.a;
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(h(e0Var.d));
            if (filterNotNull.size() > 1) {
                startRestartGroup.startReplaceGroup(-6318605);
                o(e0Var, pagerState, startRestartGroup, (i2 << 3) & 112);
                startRestartGroup.endReplaceGroup();
            } else if (cVar.n && e0Var.e != null) {
                startRestartGroup.startReplaceGroup(-6167697);
                com.dragon.read.kmp.profile.album.g gVar = e0Var.e;
                Intrinsics.checkNotNull(gVar);
                boolean a = tl4.m.a(cVar.b);
                FilterOptionHeaderType filterOptionHeaderType = cVar.j;
                startRestartGroup.startReplaceGroup(5004770);
                boolean changed = startRestartGroup.changed(e0Var);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit i4;
                            i4 = ProfileSubPageHeaderV2Kt.i(e0.this, (FilterOptionHeaderType) obj, (FilterOptionHeaderType) obj2);
                            return i4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                ProfileAlbumHeaderLayoutKt.C(gVar, a, filterOptionHeaderType, (Function2) rememberedValue, startRestartGroup, 0, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-5817025);
                k(e0Var, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = ProfileSubPageHeaderV2Kt.j(pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }

    private static final void k(final e0 e0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean a;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1947526759);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(e0Var)) {
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
                ComposerKt.traceEventStart(1947526759, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.subpage.SimpleSubPageHeader (ProfileSubPageHeaderV2.kt:168)");
            }
            rl4.c cVar = e0Var.a;
            State collectAsState = SnapshotStateKt.collectAsState(e0Var.c.l, (CoroutineContext) null, startRestartGroup, 0, 1);
            if (e0Var.a.m && l(collectAsState).b.h()) {
                a = u.d();
            } else {
                a = tl4.m.a(e0Var.a.b);
            }
            boolean z2 = a;
            if (cVar.l > 0 && z2) {
                Modifier.a aVar = Modifier.Companion;
                Modifier s = f2.s(SizeKt.h(f2.v(aVar, 0.0f, 0.0f, 0.0f, x0.i.g(12), 7, (Object) null), 0.0f, 1, (Object) null), SeriesGuestProfilePageKt.j1(), x0.i.g(4));
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i4 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(startRestartGroup, s);
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
                Composer b = g5.b(startRestartGroup);
                g5.e(b, i4, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                StringBuilder sb = new StringBuilder();
                sb.append((char) 20849);
                sb.append(e0Var.a.l);
                sb.append((char) 20010);
                a6.j(sb.toString(), boxScopeInstance.b(aVar, aVar2.o()), og4.a.a.h(startRestartGroup, og4.a.b).h(), x.h(14), (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3072, 0, 131056);
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-2014460973);
                if (z2) {
                    e.h(boxScopeInstance.b(aVar, aVar2.f()), composer2, 0, 0);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit m;
                            m = ProfileSubPageHeaderV2Kt.m(e0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                            return m;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = ProfileSubPageHeaderV2Kt.n(e0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    public static final void o(final e0 subPageViewModel, final PagerState pagerState, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean a;
        List filterNotNull;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(subPageViewModel, "subPageViewModel");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer startRestartGroup = composer.startRestartGroup(-1236380880);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(subPageViewModel)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(pagerState)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1236380880, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.subpage.TabRowSubPageHeader (ProfileSubPageHeaderV2.kt:86)");
            }
            MutableState<List<c7>> mutableState = subPageViewModel.d;
            State collectAsState = SnapshotStateKt.collectAsState(subPageViewModel.c.l, (CoroutineContext) null, startRestartGroup, 0, 1);
            final tl4.l b = subPageViewModel.b();
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(b);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean s;
                        s = ProfileSubPageHeaderV2Kt.s(tl4.l.this);
                        return Boolean.valueOf(s);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            State state = (State) rememberedValue;
            startRestartGroup.endReplaceGroup();
            if (subPageViewModel.a.m && r(collectAsState).b.h()) {
                a = u.d();
            } else {
                ProfileTab profileTab = subPageViewModel.a.b;
                if (profileTab == ProfileTab.Video) {
                    a = tl4.m.b(profileTab, t(state));
                } else {
                    a = tl4.m.a(profileTab);
                }
            }
            boolean z2 = a;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(q(mutableState));
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(filterNotNull, 10));
            Iterator it2 = filterNotNull.iterator();
            while (it2.hasNext()) {
                arrayList.add(new s((c7) it2.next()));
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier t = f2.t(SizeKt.h(f2.v(aVar, 0.0f, 0.0f, 0.0f, x0.i.g(10), 7, (Object) null), 0.0f, 1, (Object) null), 0.0f, x0.i.g(4), 1, (Object) null);
            e.e h = androidx.compose.foundation.layout.e.a.h();
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 b2 = r2.b(h, aVar2.l(), startRestartGroup, 0);
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
            v0.b(SizeKt.B(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), (e.c) null, false, 3, (Object) null), x0.i.g(26), og4.a.a.h(startRestartGroup, og4.a.b).b(), false, false, t.e(1644107820, true, new ProfileSubPageHeaderV2Kt$TabRowSubPageHeader$1$1(arrayList, subPageViewModel, coroutineScope, pagerState), startRestartGroup, 54), startRestartGroup, 196656, 24);
            startRestartGroup.startReplaceGroup(-1900054823);
            if (z2) {
                e.h(w2Var.b(aVar, aVar2.i()), startRestartGroup, 0, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit p;
                    p = ProfileSubPageHeaderV2Kt.p(e0.this, pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return p;
                }
            });
        }
    }
}
