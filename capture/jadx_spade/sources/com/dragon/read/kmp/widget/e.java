package com.dragon.read.kmp.widget;

import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.a3;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    static {
        Covode.recordClassIndex(609627);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(String str, String str2, Modifier modifier, int i, String str3, g3 g3Var, long j, w0.h hVar, int i2, int i3, Composer composer, int i4) {
        b(str, str2, modifier, i, str3, g3Var, j, hVar, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ g3 a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ long f;
        final /* synthetic */ w0.h g;
        final /* synthetic */ a3 h;

        a(g3 g3Var, String str, String str2, String str3, int i, long j, w0.h hVar, a3 a3Var) {
            this.a = g3Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = i;
            this.f = j;
            this.g = hVar;
            this.h = a3Var;
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
                    ComposerKt.traceEventStart(1464961456, i2, -1, "com.dragon.read.kmp.widget.AutoEllipsizeTextKMP.<anonymous> (AutoEllipsizeTextKMP.kt:31)");
                }
                g3 G = ((g3) composer.consume(a6.q())).G(this.a);
                int l = x0.b.l(BoxWithConstraints.e());
                composer.startReplaceGroup(-1224400529);
                boolean changed = composer.changed(l) | composer.changed(this.b) | composer.changed(this.c) | composer.changed(this.d) | composer.changed(this.e) | composer.changed(G);
                String str = this.b;
                String str2 = this.c;
                String str3 = this.d;
                int i4 = this.e;
                a3 a3Var = this.h;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = e.e(str, str2, str3, i4, BoxWithConstraints.e(), G, a3Var);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                a6.j((String) rememberedValue, Modifier.Companion, this.f, 0L, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, this.g, 0L, w0.s.b.a(), false, this.e, 0, (Function1) null, G, composer, 48, 48, 54776);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    private static final float f(HashMap<Character, Float> hashMap, a3 a3Var, g3 g3Var, char c) {
        Character valueOf = Character.valueOf(c);
        Float f = hashMap.get(valueOf);
        if (f == null) {
            f = Float.valueOf((int) (a3.d(a3Var, new androidx.compose.ui.text.e(String.valueOf(c), (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32));
            hashMap.put(valueOf, f);
        }
        return f.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(String str, String str2, String str3, int i, long j, g3 g3Var, a3 a3Var) {
        boolean z;
        boolean z2;
        boolean contains$default;
        String str4;
        int indexOf$default;
        String replace$default;
        int coerceAtLeast;
        String replace$default2;
        int i2 = i;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (str2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
                if (contains$default && x0.b.h(j) && x0.b.l(j) > 0) {
                    if (i2 <= 0 || i2 == Integer.MAX_VALUE) {
                        i2 = 1;
                    }
                    float l = x0.b.l(j);
                    if (str.length() > 1) {
                        str4 = StringsKt___StringsKt.dropLast(str, 1);
                    } else {
                        str4 = str;
                    }
                    float f = (((int) (a3.d(a3Var, new androidx.compose.ui.text.e(str4, (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32)) + ((int) (a3.d(a3Var, new androidx.compose.ui.text.e(str3, (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32))) - (l * i2);
                    if (f <= 0.0f || (indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null)) <= 0) {
                        return str;
                    }
                    HashMap hashMap = new HashMap(64);
                    for (int i3 = indexOf$default - 1; -1 < i3; i3--) {
                        f -= f(hashMap, a3Var, g3Var, str.charAt(i3));
                        if (f <= 0.0f) {
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 - 1, 0);
                            String substring = str.substring(coerceAtLeast, indexOf$default);
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                            replace$default2 = StringsKt__StringsJVMKt.replace$default(str, substring, str3, false, 4, (Object) null);
                            return replace$default2;
                        }
                    }
                    String substring2 = str.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    replace$default = StringsKt__StringsJVMKt.replace$default(str, substring2, str3, false, 4, (Object) null);
                    return replace$default;
                }
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final java.lang.String r52, final java.lang.String r53, androidx.compose.ui.Modifier r54, int r55, java.lang.String r56, androidx.compose.ui.text.g3 r57, long r58, w0.h r60, androidx.compose.runtime.Composer r61, final int r62, final int r63) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.e.b(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, int, java.lang.String, androidx.compose.ui.text.g3, long, w0.h, androidx.compose.runtime.Composer, int, int):void");
    }
}
