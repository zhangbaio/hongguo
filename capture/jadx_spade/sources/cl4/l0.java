package cl4;

import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.a3;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import w0.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l0 {
    static {
        Covode.recordClassIndex(608064);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(gk4.w wVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        d(wVar, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(gk4.w wVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        d(wVar, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(gk4.w wVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        d(wVar, modifier, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final String j(String str, boolean z) {
        if (z) {
            return (char) 12298 + str + (char) 12299;
        }
        return str;
    }

    private static final boolean m(String str, boolean z) {
        if (z) {
            if (!Intrinsics.areEqual(str, "《…》") && str.length() > 4) {
                return false;
            }
        } else if (!Intrinsics.areEqual(str, "…") && str.length() > 2) {
            return false;
        }
        return true;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ x0.e a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;
        final /* synthetic */ g3 f;
        final /* synthetic */ a3 g;
        final /* synthetic */ long h;

        a(x0.e eVar, String str, String str2, boolean z, boolean z2, g3 g3Var, a3 a3Var, long j) {
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = z;
            this.e = z2;
            this.f = g3Var;
            this.g = a3Var;
            this.h = j;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i4 = 4;
                } else {
                    i4 = 2;
                }
                i2 = i | i4;
            } else {
                i2 = i;
            }
            boolean z2 = true;
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1750103675, i2, -1, "com.dragon.read.kmp.profile.container.double_column.RecommendTagInfo.<anonymous> (RecommendTagInfo.kt:61)");
                }
                float f = 4;
                int x0 = this.a.x0(x0.i.g(f));
                int x02 = this.a.x0(x0.i.g(2));
                if (x0.b.h(BoxWithConstraints.e())) {
                    i3 = RangesKt___RangesKt.coerceAtLeast(x0.b.l(BoxWithConstraints.e()), 0);
                } else {
                    i3 = Integer.MAX_VALUE;
                }
                composer.startReplaceGroup(-1224400529);
                boolean changed = composer.changed(this.b) | composer.changed(this.c) | composer.changed(this.d) | composer.changed(this.e) | composer.changed(i3) | composer.changed(x0) | composer.changed(x02) | composer.changed(this.f) | composer.changed(this.a);
                String str = this.b;
                String str2 = this.c;
                boolean z3 = this.d;
                boolean z4 = this.e;
                g3 g3Var = this.f;
                a3 a3Var = this.g;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = l0.k(str, str2, z3, z4, i3, x0, x02, g3Var, a3Var);
                    composer.updateRememberedValue(rememberedValue);
                }
                m0 m0Var = (m0) rememberedValue;
                composer.endReplaceGroup();
                e.c i5 = androidx.compose.ui.e.a.i();
                long j = this.h;
                g3 g3Var2 = this.f;
                String str3 = this.c;
                boolean z5 = this.e;
                Modifier.a aVar = Modifier.Companion;
                androidx.compose.ui.layout.p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), i5, composer, 48);
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
                String str4 = m0Var.a;
                s.a aVar2 = w0.s.b;
                a6.j(str4, (Modifier) null, j, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar2.a(), false, 1, 0, (Function1) null, g3Var2, composer, 0, 3120, 55290);
                composer.startReplaceGroup(1596267062);
                if (m0Var.b) {
                    if (str3 != null && str3.length() != 0) {
                        z2 = false;
                    }
                    if (!z2) {
                        composer.startReplaceGroup(1596269156);
                        if (z5) {
                            p0.c(j, f2.v(aVar, 0.0f, 0.0f, x0.i.g(f), 0.0f, 11, (Object) null), 0.0f, composer, 48, 4);
                        }
                        composer.endReplaceGroup();
                        a6.j(str3, (Modifier) null, j, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, aVar2.a(), false, 1, 0, (Function1) null, g3Var2, composer, 0, 3120, 55290);
                    }
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

    private static final int n(String str, g3 g3Var, a3 a3Var) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return 0;
        }
        return (int) (a3.b(a3Var, str, g3Var, 0, false, 1, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1004, (Object) null).c >> 32);
    }

    private static final String l(String str, int i, g3 g3Var, a3 a3Var) {
        boolean z;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || i <= 0) {
            return "";
        }
        if (n(str, g3Var, a3Var) <= i) {
            return str;
        }
        String str2 = "…";
        if (n("…", g3Var, a3Var) > i) {
            return "";
        }
        int length = str.length();
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (i2 + length) / 2;
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
            sb.append((char) 8230);
            String sb2 = sb.toString();
            if (n(sb2, g3Var, a3Var) <= i) {
                i2 = i3 + 1;
                str2 = sb2;
            } else {
                length = i3 - 1;
            }
        }
        return str2;
    }

    private static final String i(String str, boolean z, int i, g3 g3Var, a3 a3Var) {
        boolean z2;
        boolean z3 = true;
        if (str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || i <= 0) {
            return "";
        }
        String j = j(str, z);
        if (n(j, g3Var, a3Var) <= i) {
            return j;
        }
        if (!z) {
            return l(str, i, g3Var, a3Var);
        }
        String l = l(str, i - n("《》", g3Var, a3Var), g3Var, a3Var);
        if (l.length() != 0) {
            z3 = false;
        }
        if (z3) {
            return "";
        }
        return (char) 12298 + l + (char) 12299;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(final gk4.w r56, androidx.compose.ui.Modifier r57, androidx.compose.runtime.Composer r58, final int r59, final int r60) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cl4.l0.d(gk4.w, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m0 k(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, g3 g3Var, a3 a3Var) {
        boolean z3;
        int i4;
        boolean z4 = false;
        if (i == Integer.MAX_VALUE) {
            String j = j(str, z);
            if (str2 == null || str2.length() == 0) {
                z4 = true;
            }
            return new m0(j, !z4);
        }
        if (str2 != null && str2.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            return new m0(i(str, z, i, g3Var, a3Var), false);
        }
        int n = n(str2, g3Var, a3Var);
        if (z2) {
            i4 = i3 + i2;
        } else {
            i4 = 0;
        }
        int i5 = i - (n + i4);
        if (i5 <= 0) {
            return new m0(i(str, z, i, g3Var, a3Var), false);
        }
        String i6 = i(str, z, i5, g3Var, a3Var);
        if (m(i6, z)) {
            return new m0(i(str, z, i, g3Var, a3Var), false);
        }
        return new m0(i6, true);
    }
}
