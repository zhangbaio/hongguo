package com.dragon.read.kmp.profile.guestprofile.view.subpage;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.g5;
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
import com.dragon.read.kmp.profile.guestprofile.view.ProfileTabPagerKt;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.e0;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.f0;
import com.dragon.read.kmp.u;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    static {
        Covode.recordClassIndex(608177);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(int i, Composer composer, int i2) {
        e(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(int i, Composer composer, int i2) {
        e(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(PagerState pagerState, int i, Composer composer, int i2) {
        i(pagerState, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final f0 f(State<f0> state) {
        return (f0) state.getValue();
    }

    private static final Modifier l(Modifier modifier, boolean z) {
        if (z) {
            float f = 16;
            return f2.u(modifier, x0.i.g(f), x0.i.g(0), x0.i.g(f), x0.i.g(12));
        }
        float f2 = 16;
        return f2.u(modifier, x0.i.g(f2), x0.i.g(4), x0.i.g(f2), x0.i.g(f2));
    }

    public static final void e(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        boolean a;
        androidx.compose.foundation.layout.r rVar;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(1158747816);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1158747816, i, -1, "com.dragon.read.kmp.profile.guestprofile.view.subpage.ActorTabHeaderV1 (ProfileSubPageHeaderV1.kt:58)");
            }
            e0 e0Var = (e0) startRestartGroup.consume(ProfileTabPagerKt.F());
            boolean z2 = e0Var.a.m;
            State collectAsState = SnapshotStateKt.collectAsState(e0Var.c.l, (CoroutineContext) null, startRestartGroup, 0, 1);
            if (e0Var.a.m && f(collectAsState).b.h()) {
                a = u.d();
            } else {
                a = tl4.m.a(e0Var.a.b);
            }
            boolean z3 = a;
            if (!z3 && !z2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit g;
                            g = j.g(i, (Composer) obj, ((Integer) obj2).intValue());
                            return g;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier modifier2 = Modifier.Companion;
            Modifier l = l(SizeKt.h(modifier2, 0.0f, 1, (Object) null), z2);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i2 = androidx.compose.foundation.layout.m.i(aVar.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, l);
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
            g5.e(b, i2, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            androidx.compose.foundation.layout.r rVar2 = BoxScopeInstance.a;
            if (z2) {
                startRestartGroup.startReplaceGroup(634843426);
                Modifier b3 = rVar2.b(modifier2, aVar.h());
                p0 b4 = r2.b(androidx.compose.foundation.layout.e.a.h(), aVar.l(), startRestartGroup, 0);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, b3);
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
                g5.e(b5, b4, companion.c());
                g5.e(b5, currentCompositionLocalMap2, companion.e());
                Function2 b6 = companion.b();
                if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a4))) {
                    b5.updateRememberedValue(Integer.valueOf(a4));
                    b5.apply(Integer.valueOf(a4), b6);
                }
                g5.e(b5, e2, companion.d());
                w2 w2Var = w2.b;
                String str = e0Var.a.c;
                long h = x.h(16);
                c0 a6 = c0.b.a();
                og4.a aVar2 = og4.a.a;
                int i3 = og4.a.b;
                a6.j(str, (Modifier) null, aVar2.h(startRestartGroup, i3).k(), h, (y) null, a6, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 0, 131026);
                startRestartGroup.startReplaceGroup(-1889038786);
                int i4 = e0Var.a.l;
                if (i4 > 0) {
                    String valueOf = String.valueOf(i4);
                    long h2 = x.h(12);
                    composer2 = startRestartGroup;
                    a6.j(valueOf, (Modifier) null, aVar2.h(startRestartGroup, i3).j(), h2, (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131058);
                } else {
                    composer2 = startRestartGroup;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endReplaceGroup();
                rVar = rVar2;
                modifier = modifier2;
            } else if (e0Var.a.l > 0 && z3) {
                startRestartGroup.startReplaceGroup(635590185);
                StringBuilder sb = new StringBuilder();
                sb.append((char) 20849);
                sb.append(e0Var.a.l);
                sb.append((char) 20010);
                String sb2 = sb.toString();
                long h3 = x.h(14);
                long j = og4.a.a.h(startRestartGroup, og4.a.b).j();
                rVar = rVar2;
                modifier = modifier2;
                composer2 = startRestartGroup;
                a6.j(sb2, rVar2.b(modifier2, aVar.o()), j, h3, (y) null, (c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 0, 131056);
                composer2.endReplaceGroup();
            } else {
                composer2 = startRestartGroup;
                rVar = rVar2;
                modifier = modifier2;
                composer2.startReplaceGroup(635846772);
                composer2.endReplaceGroup();
            }
            composer2.startReplaceGroup(-118035724);
            if (z3) {
                e.h(rVar.b(modifier, aVar.f()), composer2, 0, 0);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h4;
                    h4 = j.h(i, (Composer) obj, ((Integer) obj2).intValue());
                    return h4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(e0 e0Var, FilterOptionHeaderType preOption, FilterOptionHeaderType filterOption) {
        Intrinsics.checkNotNullParameter(preOption, "preOption");
        Intrinsics.checkNotNullParameter(filterOption, "filterOption");
        e0Var.f(preOption, filterOption);
        return Unit.INSTANCE;
    }

    public static final void i(final PagerState pagerState, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer startRestartGroup = composer.startRestartGroup(-1119636496);
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
        boolean z2 = true;
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1119636496, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.subpage.ProfileSubPageHeaderV1 (ProfileSubPageHeaderV1.kt:32)");
            }
            final e0 e0Var = (e0) startRestartGroup.consume(ProfileTabPagerKt.F());
            rl4.c cVar = e0Var.a;
            if (cVar.m) {
                startRestartGroup.startReplaceGroup(-374586512);
                e(startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-374525287);
                if (((List) e0Var.d.getValue()).size() <= 1) {
                    z2 = false;
                }
                if (z2) {
                    startRestartGroup.startReplaceGroup(-374436503);
                    ProfileSubPageHeaderV2Kt.o(e0Var, pagerState, startRestartGroup, (i2 << 3) & 112);
                    startRestartGroup.endReplaceGroup();
                } else if (cVar.n && e0Var.e != null) {
                    startRestartGroup.startReplaceGroup(-374276791);
                    com.dragon.read.kmp.profile.album.g gVar = e0Var.e;
                    Intrinsics.checkNotNull(gVar);
                    boolean a = tl4.m.a(cVar.b);
                    FilterOptionHeaderType filterOptionHeaderType = cVar.j;
                    startRestartGroup.startReplaceGroup(5004770);
                    boolean changed = startRestartGroup.changed(e0Var);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.f
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit j;
                                j = j.j(e0.this, (FilterOptionHeaderType) obj, (FilterOptionHeaderType) obj2);
                                return j;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    ProfileAlbumHeaderLayoutKt.C(gVar, a, filterOptionHeaderType, (Function2) rememberedValue, startRestartGroup, 0, 0);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-373891213);
                    e(startRestartGroup, 0);
                    startRestartGroup.endReplaceGroup();
                }
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.subpage.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = j.k(pagerState, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }
}
