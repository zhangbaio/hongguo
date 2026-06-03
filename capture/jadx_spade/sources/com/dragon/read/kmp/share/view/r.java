package com.dragon.read.kmp.share.view;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.b1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.z0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.share.view.r;
import java.util.Map;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import x0.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    private static final float a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(vn4.a aVar, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        e(aVar, modifier, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(vn4.a aVar, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        e(aVar, modifier, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(vn4.a aVar, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        e(aVar, modifier, f, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ e1 c;
        final /* synthetic */ e1 d;
        final /* synthetic */ e1 e;
        final /* synthetic */ float f;

        a(float f, float f2, e1 e1Var, e1 e1Var2, e1 e1Var3, float f3) {
            this.a = f;
            this.b = f2;
            this.c = e1Var;
            this.d = e1Var2;
            this.e = e1Var3;
            this.f = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c() {
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            b(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            x0.i maxOf;
            int i3;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-837500174, i2, -1, "com.dragon.read.kmp.share.view.PostSharePosterPreview.<anonymous> (PostSharePosterPreview.kt:94)");
                }
                float g = BoxWithConstraints.g();
                composer.startReplaceGroup(-1224400529);
                boolean changed = composer.changed(g) | composer.changed(this.a) | composer.changed(this.b);
                float f = this.a;
                float f2 = this.b;
                float f3 = this.f;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = x0.i.d(r.p(BoxWithConstraints.g(), f, f2, f3));
                    composer.updateRememberedValue(rememberedValue);
                }
                float m = ((x0.i) rememberedValue).m();
                composer.endReplaceGroup();
                composer.startReplaceGroup(-1633490746);
                boolean changed2 = composer.changed(m) | composer.changed(this.c);
                e1 e1Var = this.c;
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = x0.i.d(r.o(m, e1Var));
                    composer.updateRememberedValue(rememberedValue2);
                }
                float m2 = ((x0.i) rememberedValue2).m();
                composer.endReplaceGroup();
                composer.startReplaceGroup(-1746271574);
                boolean changed3 = composer.changed(m) | composer.changed(this.d) | composer.changed(this.e);
                e1 e1Var2 = this.d;
                e1 e1Var3 = this.e;
                Object rememberedValue3 = composer.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    maxOf = ComparisonsKt___ComparisonsJvmKt.maxOf(x0.i.d(r.o(m, e1Var2)), x0.i.d(r.o(m, e1Var3)), x0.i.d(m2));
                    rememberedValue3 = x0.i.d(maxOf.m());
                    composer.updateRememberedValue(rememberedValue3);
                }
                float m3 = ((x0.i) rememberedValue3).m();
                composer.endReplaceGroup();
                Modifier.a aVar = Modifier.Companion;
                Modifier i4 = SizeKt.i(SizeKt.x(aVar, m), m3);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.e m4 = aVar2.m();
                e1 e1Var4 = this.c;
                p0 i5 = androidx.compose.foundation.layout.m.i(m4, false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, i4);
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
                Composer b = g5.b(composer);
                g5.e(b, i5, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                Modifier a3 = androidx.compose.ui.draw.e.a(SizeKt.i(SizeKt.x(aVar, m), m2), k.g.c(r.a));
                composer.startReplaceGroup(1849434622);
                Object rememberedValue4 = composer.rememberedValue();
                Composer.Companion companion2 = Composer.Companion;
                if (rememberedValue4 == companion2.getEmpty()) {
                    rememberedValue4 = androidx.compose.foundation.interaction.h.a();
                    composer.updateRememberedValue(rememberedValue4);
                }
                androidx.compose.foundation.interaction.i iVar = (androidx.compose.foundation.interaction.i) rememberedValue4;
                composer.endReplaceGroup();
                composer.startReplaceGroup(1849434622);
                Object rememberedValue5 = composer.rememberedValue();
                if (rememberedValue5 == companion2.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: com.dragon.read.kmp.share.view.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c;
                            c = r.a.c();
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue5);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-O2vRcR0$default(a3, iVar, (b1) null, false, (String) null, (Role) null, (Function0) rememberedValue5, 28, (Object) null);
                p0 i6 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, modifier);
                Function0 a5 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a5);
                } else {
                    composer.useNode();
                }
                Composer b3 = g5.b(composer);
                g5.e(b3, i6, companion.c());
                g5.e(b3, currentCompositionLocalMap2, companion.e());
                Function2 b4 = companion.b();
                if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                    b3.updateRememberedValue(Integer.valueOf(a4));
                    b3.apply(Integer.valueOf(a4), b4);
                }
                g5.e(b3, e2, companion.d());
                z0.g(e1Var4, "", boxScopeInstance.a(aVar), (androidx.compose.ui.e) null, androidx.compose.ui.layout.i.a.b(), 0.0f, (m0) null, 0, composer, 24624, 232);
                composer.endNode();
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

    static {
        Covode.recordClassIndex(608988);
        a = x0.i.g(12);
    }

    private static final e1 h(State<? extends e1> state) {
        return (e1) state.getValue();
    }

    private static final String n(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('#');
        sb.append(z);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float o(float f, e1 e1Var) {
        if (e1Var == null) {
            return x0.i.g(0);
        }
        if (e1Var.getWidth() != 0 && e1Var.getHeight() != 0) {
            if (x0.i.i(f, x0.i.g(e1Var.getWidth()))) {
                return x0.i.g(e1Var.getHeight());
            }
            return x0.i.g(f / (e1Var.getWidth() / e1Var.getHeight()));
        }
        return x0.i.g(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e1 g(vn4.a aVar, e1 e1Var, e1 e1Var2) {
        if (aVar.l()) {
            if (e1Var != null) {
                return e1Var;
            }
        } else if (e1Var2 == null) {
            return e1Var;
        }
        return e1Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float p(float f, float f2, float f3, float f4) {
        boolean z;
        float f5;
        Comparable coerceAtLeast;
        x0.i coerceAtMost;
        float m;
        x0.i coerceAtMost2;
        x0.i coerceAtMost3;
        x0.i coerceAtMost4;
        x0.i d = x0.i.d(f3);
        float m2 = d.m();
        i.a aVar = x0.i.b;
        boolean z2 = true;
        if (!x0.i.i(m2, aVar.c()) && x0.i.f(m2, x0.i.g(0)) > 0) {
            z = false;
        } else {
            z = true;
        }
        x0.i iVar = null;
        if (z) {
            d = null;
        }
        if (d != null) {
            f5 = d.m();
        } else {
            f5 = f;
        }
        x0.i d2 = x0.i.d(f4);
        float m3 = d2.m();
        if (!x0.i.i(m3, aVar.c()) && x0.i.f(m3, x0.i.g(0)) > 0) {
            z2 = false;
        }
        if (!z2) {
            iVar = d2;
        }
        if (iVar != null) {
            f5 = iVar.m();
        }
        if (x0.i.f(f5, x0.i.g(600)) >= 0) {
            m = x0.i.g(f5 / 2);
        } else {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(x0.i.d(x0.i.g(f5 - x0.i.g(90))), x0.i.d(x0.i.g(0)));
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((x0.i) coerceAtLeast, x0.i.d(x0.i.g(300)));
            m = coerceAtMost.m();
        }
        if (x0.i.f(f, x0.i.g(0)) <= 0) {
            coerceAtMost4 = RangesKt___RangesKt.coerceAtMost(x0.i.d(f2), x0.i.d(m));
            return coerceAtMost4.m();
        }
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(x0.i.d(f), x0.i.d(m));
        coerceAtMost3 = RangesKt___RangesKt.coerceAtMost(x0.i.d(f2), x0.i.d(coerceAtMost2.m()));
        return coerceAtMost3.m();
    }

    private static final un4.h q(int i, vn4.c cVar, boolean z, String str, Map<String, un4.h> map) {
        String n = n(i, z);
        if (!z) {
            un4.h hVar = map.get(n);
            if (hVar == null) {
                hVar = xn4.e0.a.a(cVar.b);
                map.put(n, hVar);
            }
            return hVar;
        }
        String str2 = cVar.b;
        String str3 = cVar.a;
        vn4.d dVar = cVar.c;
        if ((!StringsKt__StringsKt.isBlank(str3)) && (!StringsKt__StringsKt.isBlank(str))) {
            un4.h hVar2 = map.get(n);
            if (hVar2 == null) {
                xn4.e0 e0Var = xn4.e0.a;
                un4.h h = e0Var.h(str3, str, dVar);
                if (h == null) {
                    h = e0Var.a(str3);
                }
                hVar2 = h;
                map.put(n, hVar2);
            }
            return hVar2;
        }
        if (!(!StringsKt__StringsKt.isBlank(str3))) {
            str3 = null;
        }
        if (str3 != null) {
            str2 = str3;
        }
        un4.h hVar3 = map.get(n);
        if (hVar3 == null) {
            hVar3 = xn4.e0.a.a(str2);
            map.put(n, hVar3);
        }
        return hVar3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final vn4.a r22, androidx.compose.ui.Modifier r23, float r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.view.r.e(vn4.a, androidx.compose.ui.Modifier, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
