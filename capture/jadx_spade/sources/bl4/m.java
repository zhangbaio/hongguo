package bl4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.x30;
import com.dragon.read.kmp.utils.s0;
import gk4.n0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    static {
        Covode.recordClassIndex(608046);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(androidx.compose.foundation.layout.r rVar, a aVar, int i, Composer composer, int i2) {
        j(rVar, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(androidx.compose.foundation.layout.r rVar, a aVar, int i, Composer composer, int i2) {
        j(rVar, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(androidx.compose.foundation.layout.r rVar, long j, int i, int i2, Composer composer, int i3) {
        m(rVar, j, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(androidx.compose.foundation.layout.r rVar, String str, org.jetbrains.compose.resources.b bVar, boolean z, int i, int i2, Composer composer, int i3) {
        o(rVar, str, bVar, z, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(androidx.compose.foundation.layout.r rVar, String str, org.jetbrains.compose.resources.b bVar, boolean z, int i, int i2, Composer composer, int i3) {
        o(rVar, str, bVar, z, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(androidx.compose.foundation.layout.r rVar, String str, boolean z, int i, int i2, Composer composer, int i3) {
        r(rVar, str, z, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(androidx.compose.foundation.layout.r rVar, String str, boolean z, int i, int i2, Composer composer, int i3) {
        r(rVar, str, z, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(androidx.compose.foundation.layout.r rVar, n0 n0Var, int i, Composer composer, int i2) {
        u(rVar, n0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(androidx.compose.foundation.layout.r rVar, a aVar, int i, Composer composer, int i2) {
        w(rVar, aVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final Modifier y(Modifier modifier, boolean z) {
        long g;
        long b;
        List listOf;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (z) {
            g = androidx.compose.ui.graphics.n0.b(1291845632);
        } else {
            g = androidx.compose.ui.graphics.l0.b.g();
        }
        if (z) {
            b = androidx.compose.ui.graphics.l0.b.g();
        } else {
            b = androidx.compose.ui.graphics.n0.b(1291845632);
        }
        c0.a aVar = androidx.compose.ui.graphics.c0.b;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(g), androidx.compose.ui.graphics.l0.j(b)});
        return BackgroundKt.b(modifier, c0.a.p(aVar, listOf, 0.0f, 0.0f, 0, 14, (Object) null), (f2) null, 0.0f, 6, (Object) null);
    }

    public static final void u(final androidx.compose.foundation.layout.r rVar, final n0 itemModel, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(-790902719);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
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
                ComposerKt.traceEventStart(-790902719, i2, -1, "com.dragon.read.kmp.profile.container.SeriesPostExtendView (GuestProfileItemExtend.kt:97)");
            }
            Modifier a = rVar.a(Modifier.Companion);
            p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a);
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
            r(BoxScopeInstance.a, "", true, startRestartGroup, 438, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bl4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v;
                    v = m.v(rVar, itemModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return v;
                }
            });
        }
    }

    public static final void w(final androidx.compose.foundation.layout.r rVar, final a itemModel, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(115168722);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(rVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(itemModel)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        int i5 = i2;
        if ((i5 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(115168722, i5, -1, "com.dragon.read.kmp.profile.container.VideoExtendView (GuestProfileItemExtend.kt:88)");
            }
            Modifier a = rVar.a(Modifier.Companion);
            p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, a);
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
            g5.e(b, i6, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            o(boxScopeInstance, itemModel.F(), itemModel.E(), false, startRestartGroup, 6, 4);
            r(boxScopeInstance, itemModel.L(), false, startRestartGroup, 6, 2);
            j(boxScopeInstance, itemModel, startRestartGroup, (i5 & 112) | 6);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bl4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x;
                    x = m.x(rVar, itemModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return x;
                }
            });
        }
    }

    public static final void j(final androidx.compose.foundation.layout.r rVar, final a itemModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        int i3;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(-1890629940);
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(itemModel)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 17) != 16) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1890629940, i2, -1, "com.dragon.read.kmp.profile.container.ContentTagView (GuestProfileItemExtend.kt:55)");
            }
            String x = itemModel.x();
            if (x.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: bl4.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit k;
                            k = m.k(rVar, itemModel, i, (Composer) obj, ((Integer) obj2).intValue());
                            return k;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier modifier = Modifier.Companion;
            float f = 6;
            Modifier v = androidx.compose.foundation.layout.f2.v(SizeKt.f(modifier, 0.0f, 1, (Object) null), 0.0f, x0.i.g(f), x0.i.g(f), 0.0f, 9, (Object) null);
            e.a aVar = androidx.compose.ui.e.a;
            p0 i4 = androidx.compose.foundation.layout.m.i(aVar.n(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i4, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            s0 s0Var = s0.a;
            x30 N = itemModel.N();
            og4.a aVar2 = og4.a.a;
            int i5 = og4.a.b;
            Modifier d = s0Var.d(modifier, N, aVar2.e(startRestartGroup, i5), x0.i.g(2), aVar2.h(startRestartGroup, i5).i3());
            float f2 = 4;
            Modifier s = androidx.compose.foundation.layout.f2.s(androidx.compose.ui.draw.e.a(d, k.g.c(x0.i.g(f2))), x0.i.g(f2), x0.i.g(1));
            p0 i6 = androidx.compose.foundation.layout.m.i(aVar.e(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, s);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, i6, companion.c());
            g5.e(b3, currentCompositionLocalMap2, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a3))) {
                b3.updateRememberedValue(Integer.valueOf(a3));
                b3.apply(Integer.valueOf(a3), b4);
            }
            g5.e(b3, e2, companion.d());
            composer2 = startRestartGroup;
            a6.j(x, (Modifier) null, aVar2.h(startRestartGroup, i5).r(), x0.x.h(10), (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, x0.x.h(10), 0, false, 0, 0, (Function1) null, (g3) null, composer2, 3072, 6, 130034);
            composer2.endNode();
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
            endRestartGroup2.a(new Function2() { // from class: bl4.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = m.l(rVar, itemModel, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    public static final void m(final androidx.compose.foundation.layout.r JustWatchMask, long j, Composer composer, final int i, final int i2) {
        long j2;
        int i3;
        int i4;
        boolean z;
        Composer composer2;
        final long j3;
        long j4;
        Intrinsics.checkNotNullParameter(JustWatchMask, "$this$JustWatchMask");
        Composer startRestartGroup = composer.startRestartGroup(-920204823);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 48;
            j2 = j;
        } else if ((i & 48) == 0) {
            j2 = j;
            if (startRestartGroup.changed(j2)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i3 = i | i4;
        } else {
            j2 = j;
            i3 = i;
        }
        if ((i3 & 17) != 16) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i5 != 0) {
                j4 = x0.x.h(14);
            } else {
                j4 = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-920204823, i3, -1, "com.dragon.read.kmp.profile.container.JustWatchMask (GuestProfileItemExtend.kt:40)");
            }
            Modifier f = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
            qg4.l lVar = qg4.l.a;
            Modifier d = BackgroundKt.d(f, lVar.j(), (f2) null, 2, (Object) null);
            p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, d);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a2 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i6, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            composer2 = startRestartGroup;
            a6.j("刚刚看过", (Modifier) null, lVar.r(), j4, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, ((i3 << 6) & 7168) | 6, 0, 131058);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j4;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            j3 = j2;
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: bl4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = m.n(JustWatchMask, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r(final androidx.compose.foundation.layout.r r31, final java.lang.String r32, boolean r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bl4.m.r(androidx.compose.foundation.layout.r, java.lang.String, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final androidx.compose.foundation.layout.r r32, final java.lang.String r33, final org.jetbrains.compose.resources.b r34, boolean r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bl4.m.o(androidx.compose.foundation.layout.r, java.lang.String, org.jetbrains.compose.resources.b, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
