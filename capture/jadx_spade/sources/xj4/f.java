package xj4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.n10;
import com.dragon.read.kmp.api.PrefSelectionMode;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import w0.h;
import w0.s;
import x0.i;
import x0.x;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(607713);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Modifier modifier, List list, PrefSelectionMode prefSelectionMode, int i, long j, long j2, long j3, long j4, Function1 function1, int i2, int i3, Composer composer, int i4) {
        f(modifier, list, prefSelectionMode, i, j, j2, j3, j4, function1, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Modifier modifier, List list, PrefSelectionMode prefSelectionMode, int i, long j, long j2, long j3, long j4, Function1 function1, int i2, int i3, Composer composer, int i4) {
        f(modifier, list, prefSelectionMode, i, j, j2, j3, j4, function1, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(n10 n10Var, boolean z, long j, long j2, long j3, long j4, Function0 function0, int i, Composer composer, int i2) {
        k(n10Var, z, j, j2, j3, j4, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(List list, PrefSelectionMode prefSelectionMode, Modifier modifier, int i, long j, long j2, long j3, long j4, String str, String str2, Function1 function1, int i2, int i3, int i4, Composer composer, int i5) {
        j(list, prefSelectionMode, modifier, i, j, j2, j3, j4, str, str2, function1, composer, x2.a(i2 | 1), x2.a(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(List list, Integer num, PrefSelectionMode prefSelectionMode, Function1 function1) {
        function1.invoke(g.a(list, num.intValue(), prefSelectionMode));
        return Unit.INSTANCE;
    }

    private static final void k(final n10 n10Var, final boolean z, final long j, final long j2, final long j3, final long j4, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        long j5;
        long j6;
        boolean z2;
        long j7;
        long j8;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1523133649);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(n10Var)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i2 = i9 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i8 = 32;
            } else {
                i8 = 16;
            }
            i2 |= i8;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changed(j)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i2 |= i7;
        }
        if ((i & 3072) == 0) {
            j5 = j2;
            if (startRestartGroup.changed(j5)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i2 |= i6;
        } else {
            j5 = j2;
        }
        if ((i & 24576) == 0) {
            j6 = j3;
            if (startRestartGroup.changed(j6)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i2 |= i5;
        } else {
            j6 = j3;
        }
        if ((196608 & i) == 0) {
            if (startRestartGroup.changed(j4)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i2 |= i4;
        }
        if ((1572864 & i) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i3 = 1048576;
            } else {
                i3 = 524288;
            }
            i2 |= i3;
        }
        if ((599187 & i2) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1523133649, i2, -1, "com.dragon.read.kmp.mine.pref.ProfilePreferenceGridItem (ProfilePreferenceGridComposable.kt:163)");
            }
            if (z) {
                j7 = j;
            } else {
                j7 = j6;
            }
            if (z) {
                j8 = j5;
            } else {
                j8 = j4;
            }
            c0 e = c0.b.e();
            float f = 6;
            Modifier u = f2.u(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.d(androidx.compose.ui.draw.e.a(SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null), k.g.c(i.g(f))), j7, (androidx.compose.ui.graphics.f2) null, 2, (Object) null), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function0, 15, (Object) null), i.g(f), i.g(7.5f), i.g(f), i.g(8.5f));
            p0 i10 = m.i(androidx.compose.ui.e.a.e(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, u);
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
            g5.e(b, i10, companion.c());
            g5.e(b, currentCompositionLocalMap, companion.e());
            Function2 b2 = companion.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e2, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            String str = n10Var.b;
            if (str == null) {
                str = "";
            }
            a6.j(str, (Modifier) null, j8, x.h(14), (y) null, e, (j) null, 0L, (w0.i) null, (h) null, 0L, s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, 199680, 3120, 120786);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: xj4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = f.l(n10Var, z, j, j2, j3, j4, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    private static final void f(Modifier modifier, final List<n10> list, final PrefSelectionMode prefSelectionMode, final int i, final long j, final long j2, final long j3, final long j4, final Function1<? super List<n10>, Unit> function1, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z;
        Modifier modifier3;
        IntRange indices;
        List chunked;
        List list2;
        boolean z2;
        boolean z3;
        int i14 = i;
        Composer startRestartGroup = composer.startRestartGroup(530167414);
        int i15 = i3 & 1;
        if (i15 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i4 = i5 | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i4 |= i6;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(prefSelectionMode.ordinal())) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i4 |= i7;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(i14)) {
                i8 = 2048;
            } else {
                i8 = 1024;
            }
            i4 |= i8;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            if (startRestartGroup.changed(j)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i4 |= i9;
        }
        if ((i3 & 32) != 0) {
            i4 |= 196608;
        } else if ((i2 & 196608) == 0) {
            if (startRestartGroup.changed(j2)) {
                i10 = 131072;
            } else {
                i10 = 65536;
            }
            i4 |= i10;
        }
        if ((i3 & 64) != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (startRestartGroup.changed(j3)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i4 |= i11;
        }
        if ((i3 & 128) != 0) {
            i4 |= 12582912;
        } else if ((i2 & 12582912) == 0) {
            if (startRestartGroup.changed(j4)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i4 |= i12;
        }
        if ((i3 & 256) != 0) {
            i4 |= 100663296;
        } else if ((i2 & 100663296) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i4 |= i13;
        }
        if ((38347923 & i4) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i4 & 1)) {
            if (i15 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(530167414, i4, -1, "com.dragon.read.kmp.mine.pref.EqualWidthGrid (ProfilePreferenceGridComposable.kt:104)");
            }
            if (i14 <= 0) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.a(new Function2() { // from class: xj4.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit h;
                            h = f.h(modifier4, list, prefSelectionMode, i, j, j2, j3, j4, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            return h;
                        }
                    });
                    return;
                }
                return;
            }
            int i16 = ((i4 & 14) | 48) >> 3;
            p0 a = androidx.compose.foundation.layout.x.a(androidx.compose.foundation.layout.e.a.p(i.g(12)), androidx.compose.ui.e.a.k(), startRestartGroup, (i16 & 14) | (i16 & 112));
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier3);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Modifier modifier5 = modifier3;
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
            indices = CollectionsKt__CollectionsKt.getIndices(list);
            chunked = CollectionsKt___CollectionsKt.chunked(CollectionsKt___CollectionsKt.toList(indices), i14);
            startRestartGroup.startReplaceGroup(-337170006);
            Iterator it2 = chunked.iterator();
            while (it2.hasNext()) {
                List list3 = (List) it2.next();
                Modifier h = SizeKt.h(Modifier.Companion, 0.0f, 1, (Object) null);
                p0 b3 = r2.b(androidx.compose.foundation.layout.e.a.p(i.g(14)), androidx.compose.ui.e.a.l(), startRestartGroup, 6);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, h);
                ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                Function0 a5 = companion2.a();
                Iterator it4 = it2;
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
                g5.e(b4, b3, companion2.c());
                g5.e(b4, currentCompositionLocalMap2, companion2.e());
                Function2 b5 = companion2.b();
                if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                    b4.updateRememberedValue(Integer.valueOf(a4));
                    b4.apply(Integer.valueOf(a4), b5);
                }
                g5.e(b4, e2, companion2.d());
                w2 w2Var = w2.b;
                startRestartGroup.startReplaceGroup(99056034);
                int i17 = 0;
                while (i17 < i14) {
                    final Integer num = (Integer) CollectionsKt___CollectionsKt.getOrNull(list3, i17);
                    if (num != null) {
                        startRestartGroup.startReplaceGroup(-1224085966);
                        Modifier a6 = u2.a(w2Var, Modifier.Companion, 1.0f, false, 2, (Object) null);
                        p0 i18 = m.i(androidx.compose.ui.e.a.o(), false);
                        int a7 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                        list2 = list3;
                        e0 currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier e3 = ComposedModifierKt.e(startRestartGroup, a6);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.o0;
                        Function0 a8 = companion3.a();
                        if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                            androidx.compose.runtime.i.d();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.createNode(a8);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Composer b6 = g5.b(startRestartGroup);
                        g5.e(b6, i18, companion3.c());
                        g5.e(b6, currentCompositionLocalMap3, companion3.e());
                        Function2 b7 = companion3.b();
                        if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a7))) {
                            b6.updateRememberedValue(Integer.valueOf(a7));
                            b6.apply(Integer.valueOf(a7), b7);
                        }
                        g5.e(b6, e3, companion3.d());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                        n10 n10Var = list.get(num.intValue());
                        boolean areEqual = Intrinsics.areEqual(n10Var.c, Boolean.TRUE);
                        startRestartGroup.startReplaceGroup(-1224400529);
                        boolean changedInstance = startRestartGroup.changedInstance(list) | startRestartGroup.changed(num);
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        boolean z4 = changedInstance | z2;
                        if ((234881024 & i4) == 67108864) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        boolean z5 = z4 | z3;
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: xj4.c
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit i19;
                                    i19 = f.i(list, num, prefSelectionMode, function1);
                                    return i19;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        int i19 = i4 >> 6;
                        k(n10Var, areEqual, j, j2, j3, j4, (Function0) rememberedValue, startRestartGroup, (i19 & 896) | (i19 & 7168) | (57344 & i19) | (i19 & 458752));
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceGroup();
                    } else {
                        list2 = list3;
                        startRestartGroup.startReplaceGroup(-1223172737);
                        a3.a(u2.a(w2Var, Modifier.Companion, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                    }
                    i17++;
                    i14 = i;
                    list3 = list2;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                i14 = i;
                it2 = it4;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier2;
            endRestartGroup2.a(new Function2() { // from class: xj4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = f.g(modifier6, list, prefSelectionMode, i, j, j2, j3, j4, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final java.util.List<com.bytedance.kmp.reading.model.n10> r45, final com.dragon.read.kmp.api.PrefSelectionMode r46, androidx.compose.ui.Modifier r47, int r48, final long r49, final long r51, final long r53, final long r55, final java.lang.String r57, final java.lang.String r58, final kotlin.jvm.functions.Function1<? super java.util.List<com.bytedance.kmp.reading.model.n10>, kotlin.Unit> r59, androidx.compose.runtime.Composer r60, final int r61, final int r62, final int r63) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xj4.f.j(java.util.List, com.dragon.read.kmp.api.PrefSelectionMode, androidx.compose.ui.Modifier, int, long, long, long, long, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
