package com.dragon.read.kmp.mine.search.view;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.service.d1;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 {
    static {
        Covode.recordClassIndex(607777);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Modifier modifier, float f, int i, Composer composer, int i2) {
        e(modifier, f, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(int i, Composer composer, int i2) {
        g(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Modifier modifier, int i, Composer composer, int i2) {
        i(modifier, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Modifier modifier, int i, Composer composer, int i2) {
        k(modifier, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final void g(Composer composer, final int i) {
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(916179425);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(916179425, i, -1, "com.dragon.read.kmp.mine.search.view.SearchSkeletonLoading (MineSearchSkeleton.kt:25)");
            }
            Modifier.a aVar = Modifier.Companion;
            Modifier t = f2.t(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i2 = eVar.i();
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 a = androidx.compose.foundation.layout.x.a(i2, aVar2.k(), startRestartGroup, 0);
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
            Composer b = g5.b(startRestartGroup);
            g5.e(b, a, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            float g = x0.i.g(14);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
            p0 b3 = r2.b(eVar.h(), aVar2.l(), startRestartGroup, 0);
            int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, h);
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
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, b3, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                b4.updateRememberedValue(Integer.valueOf(a4));
                b4.apply(Integer.valueOf(a4), b5);
            }
            g5.e(b4, e2, companion.d());
            w2 w2Var = w2.b;
            startRestartGroup.startReplaceGroup(1661126886);
            for (int i3 = 0; i3 < 3; i3++) {
                Modifier.a aVar3 = Modifier.Companion;
                float f = 12;
                e(SizeKt.u(aVar3, x0.i.g(60), x0.i.g(f)), x0.i.g(4), startRestartGroup, 54);
                a3.a(SizeKt.x(aVar3, x0.i.g(f)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            float f2 = 20;
            float g2 = x0.i.g(f2);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(Modifier.Companion, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1495139670);
            for (int i4 = 0; i4 < 3; i4++) {
                Modifier.a aVar4 = Modifier.Companion;
                k(SizeKt.h(aVar4, 0.0f, 1, (Object) null), startRestartGroup, 6);
                float g3 = x0.i.g(f2);
                startRestartGroup.startReplaceGroup(-1814856593);
                a3.a(SizeKt.i(aVar4, g3), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.search.view.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h2;
                    h2 = a0.h(i, (Composer) obj, ((Integer) obj2).intValue());
                    return h2;
                }
            });
        }
    }

    public static final void i(final Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(90057661);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
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
                ComposerKt.traceEventStart(90057661, i2, -1, "com.dragon.read.kmp.mine.search.view.SearchSkeletonLoadingItem (MineSearchSkeleton.kt:60)");
            }
            int i4 = (i2 & 14) >> 3;
            p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), startRestartGroup, (i4 & 112) | (i4 & 14));
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
            g5.e(b, a, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                b.updateRememberedValue(Integer.valueOf(a2));
                b.apply(Integer.valueOf(a2), b2);
            }
            g5.e(b, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier.a aVar = Modifier.Companion;
            float f = 4;
            e(SizeKt.h(SizeKt.i(aVar, x0.i.g(159)), 0.0f, 1, (Object) null), x0.i.g(f), startRestartGroup, 54);
            float f2 = 10;
            float g = x0.i.g(f2);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            float f3 = 12;
            e(SizeKt.h(SizeKt.i(aVar, x0.i.g(f3)), 0.0f, 1, (Object) null), x0.i.g(f), startRestartGroup, 54);
            float g2 = x0.i.g(f2);
            startRestartGroup.startReplaceGroup(-1814856593);
            a3.a(SizeKt.i(aVar, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            e(SizeKt.g(SizeKt.i(aVar, x0.i.g(f3)), 0.5f), x0.i.g(f), startRestartGroup, 54);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.search.view.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = a0.j(modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }

    public static final void k(final Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-1666364942);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
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
                ComposerKt.traceEventStart(-1666364942, i2, -1, "com.dragon.read.kmp.mine.search.view.SearchSkeletonLoadingRow (MineSearchSkeleton.kt:46)");
            }
            int i4 = (i2 & 14) >> 3;
            p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.l(), startRestartGroup, (i4 & 112) | (i4 & 14));
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                b2.updateRememberedValue(Integer.valueOf(a));
                b2.apply(Integer.valueOf(a), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            Modifier.a aVar = Modifier.Companion;
            i(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            float f = 8;
            float g = x0.i.g(f);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar, g), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            i(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            float g2 = x0.i.g(f);
            startRestartGroup.startReplaceGroup(-344996060);
            a3.a(SizeKt.x(aVar, g2), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            i(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.search.view.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = a0.l(modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    private static final void e(final Modifier modifier, final float f, Composer composer, final int i) {
        int i2;
        boolean z;
        long w;
        List listOf;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(1234695777);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(f)) {
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
                ComposerKt.traceEventStart(1234695777, i2, -1, "com.dragon.read.kmp.mine.search.view.SearchSkeletonItem (MineSearchSkeleton.kt:71)");
            }
            androidx.compose.ui.graphics.l0[] l0VarArr = new androidx.compose.ui.graphics.l0[3];
            og4.a aVar = og4.a.a;
            int i5 = og4.a.b;
            l0VarArr[0] = androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar.h(startRestartGroup, i5).E(), 0.0f, 0.0f, 0.0f, 0.0f, 15, (Object) null));
            if (d1.d((Theme) startRestartGroup.consume(rg4.e.l()))) {
                startRestartGroup.startReplaceGroup(1131675335);
                w = aVar.h(startRestartGroup, i5).D();
            } else {
                startRestartGroup.startReplaceGroup(1131676679);
                w = aVar.h(startRestartGroup, i5).w();
            }
            long n = androidx.compose.ui.graphics.l0.n(w, 0.0f, 0.0f, 0.0f, 0.0f, 15, (Object) null);
            startRestartGroup.endReplaceGroup();
            l0VarArr[1] = androidx.compose.ui.graphics.l0.j(n);
            l0VarArr[2] = androidx.compose.ui.graphics.l0.j(androidx.compose.ui.graphics.l0.n(aVar.h(startRestartGroup, i5).E(), 0.0f, 0.0f, 0.0f, 0.0f, 15, (Object) null));
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) l0VarArr);
            ng4.b.b(modifier, f, listOf, startRestartGroup, (i2 & 14) | (i2 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.mine.search.view.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f2;
                    f2 = a0.f(modifier, f, i, (Composer) obj, ((Integer) obj2).intValue());
                    return f2;
                }
            });
        }
    }
}
