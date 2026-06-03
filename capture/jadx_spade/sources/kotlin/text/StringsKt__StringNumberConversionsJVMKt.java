package kotlin.text;

import com.bytedance.covode.number.Covode;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    static {
        Covode.recordClassIndex(658782);
    }

    private static final int asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt(char c) {
        return c | ' ';
    }

    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int i, int i2) {
        if (i2 == (i + 3) - 1) {
            return "NaN";
        }
        if (i2 == (i + 8) - 1) {
            return "Infinity";
        }
        return null;
    }

    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char c) {
        return ((c + 65488) & 65535) < 10;
    }

    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char c) {
        return (((c | ' ') + (-97)) & 65535) < 6;
    }

    private static final boolean toBoolean(String str) {
        return Boolean.parseBoolean(str);
    }

    private static final BigDecimal toBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigDecimal(str);
    }

    private static final BigInteger toBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str);
    }

    public static final BigInteger toBigIntegerOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toBigIntegerOrNull(str, 10);
    }

    private static final byte toByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str);
    }

    private static final double toDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Double.parseDouble(str);
    }

    private static final float toFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Float.parseFloat(str);
    }

    private static final int toInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str);
    }

    private static final long toLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str);
    }

    private static final short toShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str);
    }

    public static BigDecimal toBigDecimalOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return null;
            }
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float toFloatOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00c2 A[LOOP:6: B:151:0x009f->B:162:0x00c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00c7 A[EDGE_INSN: B:163:0x00c7->B:164:0x00c7 BREAK  A[LOOP:6: B:151:0x009f->B:162:0x00c2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088 A[LOOP:2: B:34:0x0064->B:46:0x0088, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d A[EDGE_INSN: B:47:0x008d->B:48:0x008d BREAK  A[LOOP:2: B:34:0x0064->B:46:0x0088], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt(java.lang.String):boolean");
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (!isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return null;
            }
            return function1.invoke(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static final String toString(byte b, int i) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        String num = Integer.toString(b, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    private static final BigInteger toBigInteger(String str, int i) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        return new BigInteger(str, checkRadix);
    }

    private static final byte toByte(String str, int i) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        return Byte.parseByte(str, checkRadix);
    }

    private static final int toInt(String str, int i) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        return Integer.parseInt(str, checkRadix);
    }

    private static final long toLong(String str, int i) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        return Long.parseLong(str, checkRadix);
    }

    private static final short toShort(String str, int i) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        return Short.parseShort(str, checkRadix);
    }

    private static final String toString(int i, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        String num = Integer.toString(i, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (!isValidFloat$StringsKt__StringNumberConversionsJVMKt(str)) {
                return null;
            }
            return new BigDecimal(str, mathContext);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static final String toString(long j, int i) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        String l = Long.toString(j, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        return l;
    }

    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        if (length != 1) {
            if (str.charAt(0) == '-') {
                i2 = 1;
            }
            while (i2 < length) {
                if (CharsKt__CharJVMKt.digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
                i2++;
            }
        } else if (CharsKt__CharJVMKt.digitOf(str.charAt(0), i) < 0) {
            return null;
        }
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        return new BigInteger(str, checkRadix);
    }

    private static final String toString(short s, int i) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        String num = Integer.toString(s, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return num;
    }

    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i <= i2 && function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, Function1<? super Character, Boolean> function1) {
        while (i2 > i && function1.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2--;
        }
        return i2;
    }

    private static final int advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt(String str, int i, int i2, boolean z, Function1<? super Character, Boolean> function1) {
        boolean z2;
        boolean z3;
        String str2;
        int i3 = i;
        while (i3 <= i2 && function1.invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        if (i != i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i3 > i2) {
            if (z) {
                return -1;
            }
            return i3;
        }
        if (str.charAt(i3) == '.') {
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 <= i2 && function1.invoke(Character.valueOf(str.charAt(i5))).booleanValue()) {
                i5++;
            }
            if (i4 != i5) {
                z3 = true;
            } else {
                z3 = false;
            }
            i3 = i5;
        } else {
            z3 = false;
        }
        if (!z2 && !z3) {
            if (z) {
                return -1;
            }
            if (i2 == (i3 + 3) - 1) {
                str2 = "NaN";
            } else if (i2 == (i3 + 8) - 1) {
                str2 = "Infinity";
            } else {
                str2 = null;
            }
            if (str2 == null || StringsKt__StringsKt.indexOf((CharSequence) str, str2, i3, false) != i3) {
                return -1;
            }
            return i2 + 1;
        }
        return i3;
    }
}
