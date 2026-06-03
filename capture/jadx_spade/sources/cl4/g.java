package cl4;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.v2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.a3;
import androidx.compose.ui.text.g3;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ActorPickType;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    static {
        Covode.recordClassIndex(608051);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(gk4.w wVar, int i, Composer composer, int i2) {
        g(wVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(gk4.w wVar, int i, Composer composer, int i2) {
        g(wVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(gk4.w wVar, int i, Composer composer, int i2) {
        g(wVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, com.dragon.read.rpc.kmp.community.model.k kVar, int i, Composer composer, int i2) {
        k(str, kVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(String str, List list, com.dragon.read.rpc.kmp.community.model.k kVar, int i, Composer composer, int i2) {
        m(str, list, kVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(v2 v2Var, String str, com.dragon.read.rpc.kmp.community.model.k kVar, long j, long j2, float f, int i, int i2, Composer composer, int i3) {
        o(v2Var, str, kVar, j, j2, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ x0.e a;
        final /* synthetic */ String b;
        final /* synthetic */ g3 c;
        final /* synthetic */ a3 d;
        final /* synthetic */ String e;
        final /* synthetic */ float f;
        final /* synthetic */ String g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;

        a(x0.e eVar, String str, g3 g3Var, a3 a3Var, String str2, float f, String str3, long j, long j2) {
            this.a = eVar;
            this.b = str;
            this.c = g3Var;
            this.d = a3Var;
            this.e = str2;
            this.f = f;
            this.g = str3;
            this.h = j;
            this.i = j2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x019b, code lost:
        
            if (androidx.compose.ui.text.a3.b(r10, r11, r12, w0.s.b.b(), false, 1, x0.c.b(0, r14, 0, 0, 13, (java.lang.Object) null), (androidx.compose.ui.unit.LayoutDirection) null, (x0.e) null, (androidx.compose.ui.text.font.j.b) null, false, 968, (java.lang.Object) null).h() == false) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(androidx.compose.foundation.layout.v r36, androidx.compose.runtime.Composer r37, int r38) {
            /*
                Method dump skipped, instructions count: 767
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cl4.g.a.a(androidx.compose.foundation.layout.v, androidx.compose.runtime.Composer, int):void");
        }
    }

    public static final void g(final gk4.w itemModel, Composer composer, final int i) {
        int i2;
        boolean z;
        Object firstOrNull;
        boolean changedInstance;
        int i3;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer startRestartGroup = composer.startRestartGroup(-1821592292);
        if ((i & 6) == 0) {
            if ((i & 8) == 0) {
                changedInstance = startRestartGroup.changed(itemModel);
            } else {
                changedInstance = startRestartGroup.changedInstance(itemModel);
            }
            if (changedInstance) {
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
                ComposerKt.traceEventStart(-1821592292, i2, -1, "com.dragon.read.kmp.profile.container.double_column.ActorPickInfo (ActorPickInfo.kt:41)");
            }
            List<com.dragon.read.rpc.kmp.community.model.k> f = itemModel.f();
            if (f.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: cl4.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit h;
                            h = g.h(gk4.w.this, i, (Composer) obj, ((Integer) obj2).intValue());
                            return h;
                        }
                    });
                    return;
                }
                return;
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) f);
            com.dragon.read.rpc.kmp.community.model.k kVar = (com.dragon.read.rpc.kmp.community.model.k) firstOrNull;
            if (kVar == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.a(new Function2() { // from class: cl4.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit i4;
                            i4 = g.i(gk4.w.this, i, (Composer) obj, ((Integer) obj2).intValue());
                            return i4;
                        }
                    });
                    return;
                }
                return;
            }
            String b = itemModel.b();
            String str = kVar.c;
            if (Intrinsics.areEqual(str, "v1")) {
                startRestartGroup.startReplaceGroup(1796473760);
                k(b, kVar, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(str, "v2")) {
                startRestartGroup.startReplaceGroup(1796476103);
                m(b, f, kVar, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-143768378);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.a(new Function2() { // from class: cl4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit j;
                    j = g.j(gk4.w.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return j;
                }
            });
        }
    }

    private static final void k(final String str, final com.dragon.read.rpc.kmp.community.model.k kVar, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-246157701);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(kVar)) {
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
                ComposerKt.traceEventStart(-246157701, i2, -1, "com.dragon.read.kmp.profile.container.double_column.ActorPickStyleV1 (ActorPickInfo.kt:58)");
            }
            og4.a aVar = og4.a.a;
            int i5 = og4.a.b;
            long f = aVar.h(startRestartGroup, i5).f();
            float f2 = 10;
            float f3 = 4;
            float f4 = 2;
            Modifier s = f2.s(BackgroundKt.d(ig4.i.c(f2.u(Modifier.Companion, x0.i.g(f2), x0.i.g(f3), x0.i.g(f2), x0.i.g(f4)), x0.i.d(x0.i.g(f3)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), aVar.h(startRestartGroup, i5).x(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(6), x0.i.g(f4));
            androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 48);
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            int i6 = i2 << 3;
            o(w2.b, str, kVar, f, x0.x.h(12), x0.i.g(f4), startRestartGroup, (i6 & 112) | 221190 | (i6 & 896), 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: cl4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l;
                    l = g.l(str, kVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return l;
                }
            });
        }
    }

    private static final void m(final String str, final List<com.dragon.read.rpc.kmp.community.model.k> list, final com.dragon.read.rpc.kmp.community.model.k kVar, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        List distinct;
        org.jetbrains.compose.resources.b bVar;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-176662790);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(kVar)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-176662790, i2, -1, "com.dragon.read.kmp.profile.container.double_column.ActorPickStyleV2 (ActorPickInfo.kt:77)");
            }
            long f = og4.a.a.h(startRestartGroup, og4.a.b).f();
            startRestartGroup.startReplaceGroup(5004770);
            boolean changed = startRestartGroup.changed(list);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    Integer num = ((com.dragon.read.rpc.kmp.community.model.k) it2.next()).a;
                    if (num != null) {
                        arrayList.add(num);
                    }
                }
                distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
                rememberedValue = CollectionsKt___CollectionsKt.sorted(distinct);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            List list2 = (List) rememberedValue;
            startRestartGroup.endReplaceGroup();
            float f2 = 10;
            Modifier v = f2.v(Modifier.Companion, x0.i.g(f2), x0.i.g(f2), x0.i.g(f2), 0.0f, 8, (Object) null);
            androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, v);
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
            g5.e(b2, b, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            w2 w2Var = w2.b;
            startRestartGroup.startReplaceGroup(817046319);
            Iterator it4 = list2.iterator();
            while (it4.hasNext()) {
                int intValue = ((Number) it4.next()).intValue();
                if (intValue == ActorPickType.Digg.getValue()) {
                    bVar = b4.n(d4.a);
                } else if (intValue == ActorPickType.Collect.getValue()) {
                    bVar = b4.l(d4.a);
                } else if (intValue == ActorPickType.Comment.getValue()) {
                    bVar = b4.m(d4.a);
                } else {
                    bVar = null;
                }
                startRestartGroup.startReplaceGroup(817057469);
                if (bVar != null) {
                    androidx.compose.ui.graphics.e1 a4 = org.jetbrains.compose.resources.c.a(bVar, startRestartGroup, 0);
                    Modifier.a aVar = Modifier.Companion;
                    androidx.compose.foundation.z0.g(a4, (String) null, SizeKt.s(aVar, pg4.j.c(12, startRestartGroup, 6)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(androidx.compose.ui.graphics.m0.b, f, 0, 2, (Object) null), 0, startRestartGroup, 48, 184);
                    androidx.compose.foundation.layout.a3.a(SizeKt.x(aVar, x0.i.g(2)), startRestartGroup, 6);
                }
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            o(w2Var, str, kVar, f, x0.x.h(12), x0.i.g(2), startRestartGroup, ((i2 << 3) & 112) | 221190 | (i2 & 896), 0);
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
            endRestartGroup.a(new Function2() { // from class: cl4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = g.n(str, list, kVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0128, code lost:
    
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void o(final androidx.compose.foundation.layout.v2 r54, final java.lang.String r55, final com.dragon.read.rpc.kmp.community.model.k r56, final long r57, long r59, float r61, androidx.compose.runtime.Composer r62, final int r63, final int r64) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cl4.g.o(androidx.compose.foundation.layout.v2, java.lang.String, com.dragon.read.rpc.kmp.community.model.k, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
