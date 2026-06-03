package kotlin.text;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class b extends CharsKt__CharJVMKt {
    static {
        Covode.recordClassIndex(658744);
    }

    public static final boolean isSurrogate(char c) {
        return 55296 <= c && c < 57344;
    }

    public static final String titlecase(char c) {
        return e0.a(c);
    }

    public static Integer digitToIntOrNull(char c) {
        boolean z;
        Integer valueOf = Integer.valueOf(CharsKt__CharJVMKt.digitOf(c, 10));
        if (valueOf.intValue() >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return null;
        }
        return valueOf;
    }

    public static final char digitToChar(int i) {
        boolean z = false;
        if (i >= 0 && i < 10) {
            z = true;
        }
        if (z) {
            return (char) (i + 48);
        }
        throw new IllegalArgumentException("Int " + i + " is not a decimal digit");
    }

    public static int digitToInt(char c) {
        int digitOf = CharsKt__CharJVMKt.digitOf(c, 10);
        if (digitOf >= 0) {
            return digitOf;
        }
        throw new IllegalArgumentException("Char " + c + " is not a decimal digit");
    }

    private static final String plus(char c, String other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return c + other;
    }

    public static final Integer digitToIntOrNull(char c, int i) {
        boolean z;
        CharsKt__CharJVMKt.checkRadix(i);
        Integer valueOf = Integer.valueOf(CharsKt__CharJVMKt.digitOf(c, i));
        if (valueOf.intValue() >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return null;
        }
        return valueOf;
    }

    public static final char digitToChar(int i, int i2) {
        int i3;
        boolean z = false;
        if (2 <= i2 && i2 < 37) {
            z = true;
        }
        if (z) {
            if (i >= 0 && i < i2) {
                if (i < 10) {
                    i3 = i + 48;
                } else {
                    i3 = ((char) (i + 65)) - '\n';
                }
                return (char) i3;
            }
            throw new IllegalArgumentException("Digit " + i + " does not represent a valid digit in radix " + i2);
        }
        throw new IllegalArgumentException("Invalid radix: " + i2 + ". Valid radix values are in range 2..36");
    }

    public static final int digitToInt(char c, int i) {
        Integer digitToIntOrNull = digitToIntOrNull(c, i);
        if (digitToIntOrNull != null) {
            return digitToIntOrNull.intValue();
        }
        throw new IllegalArgumentException("Char " + c + " is not a digit in the given radix=" + i);
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean equals$default(char c, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return equals(c, c2, z);
    }
}
