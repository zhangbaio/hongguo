package com.dragon.read.kmp.profile.playletcomment;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.dragon.community.base.sdk.widget.expandableText.m;
import com.dragon.read.kmp.compose.common.image.LoadImageKt;
import com.dragon.read.kmp.compose.common.image.n;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.kmp.utils.StringUtilsKt;
import com.dragon.read.kmp.utils.h0;
import com.dragon.read.kmp.widget.StarScoreCardKt;
import com.dragon.read.kmp.widget.y1;
import gk4.d0;
import gk4.w;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import w0.s;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayletCommentItem2ColumnKt {
    static {
        Covode.recordClassIndex(608209);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(d0 d0Var, boolean z, int i, Composer composer, int i2) {
        j(d0Var, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(String str, m mVar) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(mVar, "<unused var>");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(d0 d0Var, int i, ym4.a aVar, String str, String str2, int i2, int i3, Composer composer, int i4) {
        l(d0Var, i, aVar, str, str2, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(d0 d0Var, Modifier modifier, int i, Composer composer, int i2) {
        s(d0Var, modifier, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    public static final class a implements DisposableEffectResult {
        final /* synthetic */ l a;

        public void dispose() {
            this.a.i();
        }

        public a(l lVar) {
            this.a = lVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(int i) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(d0 d0Var) {
        return d0Var.isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(l lVar) {
        if (!((Boolean) lVar.f.getValue()).booleanValue()) {
            lVar.h();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult p(l lVar, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        lVar.g();
        return new a(lVar);
    }

    private static final Triple<y1, y1, y1> v(Composer composer, int i) {
        xe4.b bVar;
        Pair pair;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(176143412, i, -1, "com.dragon.read.kmp.profile.playletcomment.getStarIcons (PlayletCommentItem2Column.kt:265)");
        }
        xe4.a a2 = eo0.c.a.a(Reflection.getOrCreateKotlinClass(xe4.a.class));
        if (a2 != null) {
            bVar = a2.getPlayletCommentService();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            d4 d4Var = d4.a;
            pair = new Pair(b4.i0(d4Var), b4.j0(d4Var));
        } else {
            pair = new Pair(bVar.R2(), bVar.o9());
        }
        org.jetbrains.compose.resources.b bVar2 = (org.jetbrains.compose.resources.b) pair.component1();
        org.jetbrains.compose.resources.b bVar3 = (org.jetbrains.compose.resources.b) pair.component2();
        m0.a aVar = m0.b;
        og4.a aVar2 = og4.a.a;
        int i2 = og4.a.b;
        Triple<y1, y1, y1> triple = new Triple<>(new y1(bVar2, m0.a.c(aVar, aVar2.h(composer, i2).Y2(), 0, 2, (Object) null)), new y1(bVar3, null, 2, null), new y1(bVar2, m0.a.c(aVar, aVar2.h(composer, i2).R(), 0, 2, (Object) null)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return triple;
    }

    private static final void s(final d0 d0Var, final Modifier modifier, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-385603013);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(d0Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(modifier)) {
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
                ComposerKt.traceEventStart(-385603013, i2, -1, "com.dragon.read.kmp.profile.playletcomment.StarView (PlayletCommentItem2Column.kt:247)");
            }
            Triple<y1, y1, y1> v = v(startRestartGroup, 0);
            y1 component1 = v.component1();
            y1 component2 = v.component2();
            y1 component3 = v.component3();
            int i5 = h0.i(d0Var.g, 0);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.profile.playletcomment.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit t;
                        t = PlayletCommentItem2ColumnKt.t(((Integer) obj).intValue());
                        return t;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            float g = x0.i.g(12);
            float g2 = x0.i.g(2);
            int i6 = y1.c;
            composer2 = startRestartGroup;
            StarScoreCardKt.g(i5, 5, component1, component2, component3, (Function1) rememberedValue, null, null, null, false, false, false, g, g2, null, modifier, composer2, (i6 << 6) | 196656 | (i6 << 9) | (i6 << 12), ((i2 << 12) & 458752) | 3504, 18368);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.playletcomment.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u;
                    u = PlayletCommentItem2ColumnKt.u(d0.this, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                    return u;
                }
            });
        }
    }

    private static final void j(final d0 d0Var, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        Modifier modifier;
        org.jetbrains.compose.resources.b V;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-1276631111);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(d0Var)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        int i5 = i2;
        if ((i5 & 19) != 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1276631111, i5, -1, "com.dragon.read.kmp.profile.playletcomment.ItemHeader (PlayletCommentItem2Column.kt:189)");
            }
            og4.a aVar = og4.a.a;
            int i6 = og4.a.b;
            boolean d = d1.d(aVar.e(startRestartGroup, i6));
            Modifier modifier2 = Modifier.Companion;
            Modifier h = SizeKt.h(modifier2, 0.0f, 1, (Object) null);
            float f = 10;
            float g = x0.i.g(f);
            float g2 = x0.i.g(f);
            if (!z) {
                f = 12;
            }
            Modifier v = f2.v(h, g, x0.i.g(f), g2, 0.0f, 8, (Object) null);
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            e.e h2 = eVar.h();
            e.a aVar2 = androidx.compose.ui.e.a;
            p0 b = r2.b(h2, aVar2.l(), startRestartGroup, 0);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
            Modifier a4 = u2.a(w2.b, modifier2, 1.0f, false, 2, (Object) null);
            p0 a5 = x.a(eVar.i(), aVar2.k(), startRestartGroup, 0);
            int a6 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e2 = ComposedModifierKt.e(startRestartGroup, a4);
            Function0 a7 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a7);
            } else {
                startRestartGroup.useNode();
            }
            Composer b4 = g5.b(startRestartGroup);
            g5.e(b4, a5, companion.c());
            g5.e(b4, currentCompositionLocalMap2, companion.e());
            Function2 b5 = companion.b();
            if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a6))) {
                b4.updateRememberedValue(Integer.valueOf(a6));
                b4.apply(Integer.valueOf(a6), b5);
            }
            g5.e(b4, e2, companion.d());
            c0 c0Var = c0.b;
            String str = d0Var.e;
            long h3 = x0.x.h(14);
            c0.a aVar3 = androidx.compose.ui.text.font.c0.b;
            androidx.compose.ui.text.font.c0 i7 = aVar3.i();
            long h4 = x0.x.h(22);
            int b6 = s.b.b();
            long R = aVar.h(startRestartGroup, i6).R();
            float f2 = 8;
            a6.j(str, f2.v(SizeKt.h(modifier2, 0.0f, 1, (Object) null), 0.0f, 0.0f, x0.i.g(f2), 0.0f, 11, (Object) null), R, h3, (y) null, i7, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, h4, b6, false, 2, 0, (Function1) null, (g3) null, startRestartGroup, 199728, 3126, 119760);
            a3.a(SizeKt.i(modifier2, x0.i.g(f2)), startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1321075704);
            if (StringUtilsKt.a(d0Var.m)) {
                String str2 = d0Var.m;
                long h5 = x0.x.h(12);
                androidx.compose.ui.text.font.c0 h6 = aVar3.h();
                long h7 = x0.x.h(16);
                long G = aVar.h(startRestartGroup, i6).G();
                composer2 = startRestartGroup;
                a6.j(str2, SizeKt.h(modifier2, 0.0f, 1, (Object) null), G, h5, (y) null, h6, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, h7, 0, false, 0, 0, (Function1) null, (g3) null, composer2, 199728, 6, 130000);
                modifier = modifier2;
                a3.a(SizeKt.i(modifier, x0.i.g(4)), composer2, 6);
            } else {
                composer2 = startRestartGroup;
                modifier = modifier2;
            }
            composer2.endReplaceGroup();
            s(d0Var, modifier, composer2, (i5 & 14) | 48);
            composer2.endNode();
            String str3 = d0Var.f;
            n nVar = new n();
            if (d) {
                V = d2.U(f2.a.a);
            } else {
                V = d2.V(f2.a.a);
            }
            nVar.e = V;
            nVar.a(com.bytedance.kmp.image.options.l.b.c());
            Unit unit = Unit.INSTANCE;
            LoadImageKt.g(str3, (String) null, nVar, ig4.i.a(SizeKt.i(SizeKt.x(modifier, x0.i.g(36)), x0.i.g(50)), 5), (com.bytedance.kmp.image.options.i) null, (kg4.b) null, (kg4.a) null, composer2, 0, 114);
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
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.playletcomment.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = PlayletCommentItem2ColumnKt.k(d0.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(l lVar, w item, Function2 onStart, Function2 onSuccess, Function3 onError) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        lVar.d(item, onStart, onSuccess, onError);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void l(final gk4.d0 r83, final int r84, final ym4.a r85, java.lang.String r86, java.lang.String r87, androidx.compose.runtime.Composer r88, final int r89, final int r90) {
        /*
            Method dump skipped, instructions count: 1632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.playletcomment.PlayletCommentItem2ColumnKt.l(gk4.d0, int, ym4.a, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }
}
