package com.dragon.read.kmp.shortvideo.distribution.page.conent;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.bj0;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.ok0;
import com.bytedance.kmp.reading.model.q20;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    private static final float a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(cj0 cj0Var, int i, Composer composer, int i2) {
        j(cj0Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(cj0 cj0Var, Modifier modifier, int i, int i2, Composer composer, int i3) {
        l(cj0Var, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(int i, Composer composer, int i2) {
        n(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Modifier modifier, bj0 bj0Var, Function0 function0, int i, int i2, Composer composer, int i3) {
        p(modifier, bj0Var, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(q20 q20Var, int i, Composer composer, int i2) {
        r(q20Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(q20 q20Var, int i, Composer composer, int i2) {
        t(q20Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(String str, Function0 function0, int i, Composer composer, int i2) {
        v(str, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(String str, Function2 function2, int i, Composer composer, int i2) {
        y(str, function2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final float B() {
        return a;
    }

    static {
        Covode.recordClassIndex(609054);
        a = x0.i.g(60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final boolean C(cj0 cj0Var) {
        long j;
        String str;
        Long l;
        ok0 ok0Var = cj0Var.b;
        if (ok0Var != null && (l = ok0Var.l) != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        com.dragon.read.kmp.utils.i0 i0Var = com.dragon.read.kmp.utils.i0.a;
        Map map = cj0Var.f;
        if (map == null || (str = (String) map.get("brand_id")) == null) {
            str = "0";
        }
        long f = i0Var.f(str, 0L);
        if (j <= 0 && f <= 0) {
            return false;
        }
        return true;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ q20 b;

        a(String str, q20 q20Var) {
            this.a = str;
            this.b = q20Var;
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
                    ComposerKt.traceEventStart(-176726382, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.RankStatsSection.<anonymous>.<anonymous> (MyRankAnchor.kt:170)");
                }
                e.c i2 = androidx.compose.ui.e.a.i();
                e.f p = androidx.compose.foundation.layout.e.a.p(x0.i.g(1));
                String str = this.a;
                q20 q20Var = this.b;
                Modifier.a aVar = Modifier.Companion;
                androidx.compose.ui.layout.p0 b = r2.b(p, i2, composer, 54);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, aVar);
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
                w2 w2Var = w2.b;
                a6.j(str, (Modifier) null, og4.a.a.h(composer, og4.a.b).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer, 199680, 3072, 122834);
                composer.startReplaceGroup(1617280861);
                if (q20Var != null && !Intrinsics.areEqual(StringsKt__StringsKt.trim((CharSequence) str).toString(), "999+")) {
                    n.r(q20Var, composer, 0);
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

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ q20 a;

        b(q20 q20Var) {
            this.a = q20Var;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            String str;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1233564937, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.RankStatsSection.<anonymous>.<anonymous> (MyRankAnchor.kt:187)");
                }
                q20 q20Var = this.a;
                if (q20Var != null) {
                    str = q20Var.d;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                a6.j(str, (Modifier) null, og4.a.a.h(composer, og4.a.b).k(), x0.x.h(14), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, composer, 199680, 3072, 122834);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    private static final void n(Composer composer, final int i) {
        boolean z;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(152925500);
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(152925500, i, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.MeTag (MyRankAnchor.kt:143)");
            }
            float f = 4;
            Modifier a2 = androidx.compose.ui.draw.e.a(Modifier.Companion, k.g.c(x0.i.g(f)));
            og4.a aVar = og4.a.a;
            int i2 = og4.a.b;
            Modifier s = androidx.compose.foundation.layout.f2.s(BackgroundKt.d(a2, aVar.h(startRestartGroup, i2).E(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(f), x0.i.g(2));
            androidx.compose.ui.layout.p0 i3 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i3, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            composer2 = startRestartGroup;
            a6.j("我", (Modifier) null, aVar.h(startRestartGroup, i2).j(), x0.x.h(9), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199686, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = n.o(i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    private static final void j(final cj0 cj0Var, Composer composer, final int i) {
        int i2;
        boolean z;
        String str;
        org.jetbrains.compose.resources.b P;
        ok0 ok0Var;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1557137994);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(cj0Var)) {
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
                ComposerKt.traceEventStart(1557137994, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.ActorAvatar (MyRankAnchor.kt:118)");
            }
            boolean d = com.dragon.read.kmp.service.d1.d(og4.a.a.e(startRestartGroup, og4.a.b));
            Modifier.a aVar = Modifier.Companion;
            float f = 32;
            Modifier s = SizeKt.s(aVar, x0.i.g(f));
            androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.c(), false);
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
            g5.e(b2, i4, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            if (cj0Var != null && (ok0Var = cj0Var.b) != null) {
                str = ok0Var.c;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Modifier s2 = SizeKt.s(ig4.i.c(aVar, x0.i.d(x0.i.g(16)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), x0.i.g(f));
            com.dragon.read.kmp.compose.common.image.n nVar = new com.dragon.read.kmp.compose.common.image.n();
            if (d) {
                P = yo2.d2.O(f2.a.a);
            } else {
                P = yo2.d2.P(f2.a.a);
            }
            nVar.e = P;
            LoadImageKt.g(str2, (String) null, nVar, s2, (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, startRestartGroup, 0, 114);
            startRestartGroup.startReplaceGroup(-823557774);
            if (cj0Var == null || !C(cj0Var)) {
                z2 = false;
            }
            if (z2) {
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(yo2.d2.o(f2.a.a), startRestartGroup, 0), "auth_actor", SizeKt.s(aVar, x0.i.g(12)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 432, 248);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = n.k(cj0Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    private static final void t(final q20 q20Var, Composer composer, final int i) {
        int i2;
        boolean z;
        String str;
        String str2;
        String str3;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1292371158);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(q20Var)) {
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
                ComposerKt.traceEventStart(1292371158, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.RankStatsSection (MyRankAnchor.kt:163)");
            }
            if (q20Var != null) {
                str = q20Var.c;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            e.c i4 = androidx.compose.ui.e.a.i();
            e.f p = androidx.compose.foundation.layout.e.a.p(x0.i.g(8));
            Modifier.a aVar = Modifier.Companion;
            androidx.compose.ui.layout.p0 b2 = r2.b(p, i4, startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, aVar);
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
            if (q20Var == null || (str2 = q20Var.e) == null) {
                str2 = "昨日排名";
            }
            y(str2, androidx.compose.runtime.internal.t.e(-176726382, true, new a(str, q20Var), startRestartGroup, 54), startRestartGroup, 48);
            if (q20Var == null || (str3 = q20Var.f) == null) {
                str3 = "昨日星光";
            }
            y(str3, androidx.compose.runtime.internal.t.e(1233564937, true, new b(q20Var), startRestartGroup, 54), startRestartGroup, 48);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = n.u(q20Var, i, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r(final com.bytedance.kmp.reading.model.q20 r31, androidx.compose.runtime.Composer r32, final int r33) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.conent.n.r(com.bytedance.kmp.reading.model.q20, androidx.compose.runtime.Composer, int):void");
    }

    private static final void v(final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(727667313);
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
            if (startRestartGroup.changedInstance(function0)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        int i5 = i2;
        boolean z2 = true;
        if ((i5 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(727667313, i5, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.RuleButton (MyRankAnchor.kt:262)");
            }
            float f = 6;
            Modifier a2 = androidx.compose.ui.draw.e.a(Modifier.Companion, k.g.c(x0.i.g(f)));
            og4.a aVar = og4.a.a;
            int i6 = og4.a.b;
            Modifier d = BackgroundKt.d(a2, aVar.h(startRestartGroup, i6).b(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i5 & 112) != 32) {
                z2 = false;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit w;
                        w = n.w(Function0.this);
                        return w;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier s = androidx.compose.foundation.layout.f2.s(ClickableKt.clickable-oSLSa3U$default(d, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), x0.i.g(10), x0.i.g(f));
            androidx.compose.ui.layout.p0 i7 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, s);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, i7, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            composer2 = startRestartGroup;
            a6.j(str, (Modifier) null, aVar.h(startRestartGroup, i6).k(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.d(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer2, (i5 & 14) | 199680, 0, 131026);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit x;
                    x = n.x(str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return x;
                }
            });
        }
    }

    private static final void y(final String str, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1338026904);
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
            if (startRestartGroup.changedInstance(function2)) {
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
                ComposerKt.traceEventStart(-1338026904, i5, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.StatColumn (MyRankAnchor.kt:202)");
            }
            e.b k = androidx.compose.ui.e.a.k();
            e.f p = androidx.compose.foundation.layout.e.a.p(x0.i.g(4));
            Modifier.a aVar = Modifier.Companion;
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(p, k, startRestartGroup, 54);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, aVar);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, a2, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            a6.j(str, (Modifier) null, og4.a.a.h(startRestartGroup, og4.a.b).h(), x0.x.h(12), (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 1, 0, (Function1) null, (g3) null, startRestartGroup, (i5 & 14) | 199680, 3072, 122834);
            function22 = function2;
            composer2 = startRestartGroup;
            function22.invoke(composer2, Integer.valueOf((i5 >> 3) & 14));
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            function22 = function2;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit z2;
                    z2 = n.z(str, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                    return z2;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void l(final com.bytedance.kmp.reading.model.cj0 r30, androidx.compose.ui.Modifier r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.conent.n.l(com.bytedance.kmp.reading.model.cj0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void p(Modifier modifier, final bj0 ugcUserData, final Function0<Unit> onRuleClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        Modifier modifier3;
        String str;
        Intrinsics.checkNotNullParameter(ugcUserData, "ugcUserData");
        Intrinsics.checkNotNullParameter(onRuleClick, "onRuleClick");
        Composer startRestartGroup = composer.startRestartGroup(-2037669742);
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(ugcUserData)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(onRuleClick)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i7 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2037669742, i3, -1, "com.dragon.read.kmp.shortvideo.distribution.page.conent.MyRankAnchor (MyRankAnchor.kt:61)");
            }
            cj0 cj0Var = ugcUserData.a;
            q20 q20Var = ugcUserData.f;
            Modifier h = SizeKt.h(modifier3, 0.0f, 1, (Object) null);
            float f = a;
            Modifier d = BackgroundKt.d(SizeKt.i(h, f), og4.a.a.h(startRestartGroup, og4.a.b).o(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.m i8 = eVar.i();
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.layout.p0 a2 = androidx.compose.foundation.layout.x.a(i8, aVar.k(), startRestartGroup, 0);
            int a3 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, d);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
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
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, a2, companion.c());
            g5.e(b2, currentCompositionLocalMap, companion.e());
            Function2 b3 = companion.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a3))) {
                b2.updateRememberedValue(Integer.valueOf(a3));
                b2.apply(Integer.valueOf(a3), b3);
            }
            g5.e(b2, e, companion.d());
            androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
            Modifier.a aVar2 = Modifier.Companion;
            Modifier t = androidx.compose.foundation.layout.f2.t(SizeKt.i(SizeKt.h(aVar2, 0.0f, 1, (Object) null), f), x0.i.g(16), 0.0f, 2, (Object) null);
            androidx.compose.ui.layout.p0 b4 = r2.b(eVar.f(), aVar.i(), startRestartGroup, 54);
            int a5 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, t);
            Function0 a6 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a6);
            } else {
                startRestartGroup.useNode();
            }
            Composer b5 = g5.b(startRestartGroup);
            g5.e(b5, b4, companion.c());
            g5.e(b5, currentCompositionLocalMap2, companion.e());
            Function2 b6 = companion.b();
            if (b5.getInserting() || !Intrinsics.areEqual(b5.rememberedValue(), Integer.valueOf(a5))) {
                b5.updateRememberedValue(Integer.valueOf(a5));
                b5.apply(Integer.valueOf(a5), b6);
            }
            g5.e(b5, e2, companion.d());
            l(cj0Var, w2.b.a(aVar2, 1.0f, false), startRestartGroup, 0, 0);
            t(q20Var, startRestartGroup, 0);
            if (q20Var == null || (str = q20Var.h) == null) {
                str = "查看明细";
            }
            v(str, onRuleClick, startRestartGroup, (i3 >> 3) & 112);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.conent.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit q;
                    q = n.q(modifier4, ugcUserData, onRuleClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return q;
                }
            });
        }
    }
}
