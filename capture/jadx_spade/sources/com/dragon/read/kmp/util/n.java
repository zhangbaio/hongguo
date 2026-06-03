package com.dragon.read.kmp.util;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.a3;
import androidx.compose.ui.text.b3;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import w0.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final n a;
    public static final int b = 0;

    static {
        Covode.recordClassIndex(609492);
        a = new n();
    }

    private n() {
    }

    private static final int b(a3 a3Var, g3 g3Var, String str) {
        return (int) (a3.d(a3Var, new androidx.compose.ui.text.e(str, (List) null, 2, (DefaultConstructorMarker) null), g3Var, s.b.a(), false, 1, (List) null, x0.c.b(0, Integer.MAX_VALUE, 0, 0, 13, (Object) null), (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1960, (Object) null).c >> 32);
    }

    public final String a(String str, float f, g3 textStyle, boolean z, String str2, String str3, Composer composer, int i, int i2) {
        boolean z2;
        String str4;
        String str5;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean contains$default;
        boolean contains$default2;
        String text = str;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        composer.startReplaceGroup(719174537);
        if ((i2 & 8) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i2 & 16) != 0) {
            str4 = "《";
        } else {
            str4 = str2;
        }
        if ((i2 & 32) != 0) {
            str5 = "》";
        } else {
            str5 = str3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(719174537, i, -1, "com.dragon.read.kmp.util.UiStringUtils.rememberBookNameAutoEllipsis (UiStringUtils.kt:26)");
        }
        x0.e eVar = (x0.e) composer.consume(CompositionLocalsKt.f());
        a3 a2 = b3.a(0, composer, 0, 1);
        composer.startReplaceGroup(-1633490746);
        if ((((i & 112) ^ 48) > 32 && composer.changed(f)) || (i & 48) == 32) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean changed = z3 | composer.changed(eVar);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = Integer.valueOf(eVar.x0(f));
            composer.updateRememberedValue(rememberedValue);
        }
        int intValue = ((Number) rememberedValue).intValue();
        composer.endReplaceGroup();
        if (z2) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) str4, false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) str5, false, 2, (Object) null);
                if (!contains$default2) {
                    text = str4 + text + str5;
                }
            }
        }
        String str6 = text;
        if (str6.length() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && StringsKt__StringsJVMKt.startsWith$default(str6, str4, false, 2, null) && StringsKt__StringsJVMKt.endsWith$default(str6, str5, false, 2, null)) {
            if (intValue <= 0) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return str6;
            }
            String str7 = str5;
            String str8 = str4;
            if (!a3.d(a2, new androidx.compose.ui.text.e(str6, (List) null, 2, (DefaultConstructorMarker) null), textStyle, s.b.a(), false, 1, (List) null, x0.c.b(0, intValue, 0, 0, 13, (Object) null), (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1960, (Object) null).h()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return str6;
            }
            int b2 = (intValue - b(a2, textStyle, str8)) - b(a2, textStyle, str7);
            if (b2 <= 0) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return str6;
            }
            String substring = str6.substring(str8.length(), str6.length() - str7.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if (substring.length() == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return str6;
            }
            if (b(a2, textStyle, substring) <= b2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return str6;
            }
            if (b(a2, textStyle, "…") > b2) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return str6;
            }
            int length = substring.length();
            int i3 = 0;
            int i4 = 0;
            while (i4 <= length) {
                int i5 = (i4 + length) >>> 1;
                StringBuilder sb = new StringBuilder();
                String substring2 = substring.substring(0, i5);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                sb.append(substring2);
                sb.append("…");
                if (b(a2, textStyle, sb.toString()) <= b2) {
                    i4 = i5 + 1;
                    i3 = i5;
                } else {
                    length = i5 - 1;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            String substring3 = substring.substring(0, i3);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            sb2.append(substring3);
            sb2.append("…");
            String str9 = str8 + sb2.toString() + str7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return str9;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return str6;
    }
}
