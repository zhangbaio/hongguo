package kotlin.text;

import com.bytedance.covode.number.Covode;
import kotlin.KotlinNothingValueException;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    private static final int[] a;
    private static final int[] b;
    private static final int[] c;
    private static final long[] d;

    public static final int[] e() {
        return a;
    }

    static {
        Covode.recordClassIndex(658749);
        int[] iArr = new int[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = "0123456789abcdef".charAt(i2 & 15) | ("0123456789abcdef".charAt(i2 >> 4) << '\b');
        }
        a = iArr;
        int[] iArr2 = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr2[i3] = "0123456789ABCDEF".charAt(i3 & 15) | ("0123456789ABCDEF".charAt(i3 >> 4) << '\b');
        }
        b = iArr2;
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr3[i4] = -1;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i5)] = i6;
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i7)] = i8;
            i7++;
            i8++;
        }
        c = iArr3;
        long[] jArr = new long[256];
        for (int i9 = 0; i9 < 256; i9++) {
            jArr[i9] = -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i10)] = i11;
            i10++;
            i11++;
        }
        int i12 = 0;
        while (i < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i)] = i12;
            i++;
            i12++;
        }
        d = jArr;
    }

    private static final int a(long j) {
        boolean z = false;
        if (0 <= j && j <= 2147483647L) {
            z = true;
        }
        if (z) {
            return (int) j;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m896toStringimpl(ULong.m850constructorimpl(j))));
    }

    private static final Void j(String str, int i) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i + ", but was " + str.charAt(i));
    }

    public static final String o(int i, f format) {
        String str;
        String concatToString;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(format, "format");
        if (format.a) {
            str = "0123456789ABCDEF";
        } else {
            str = "0123456789abcdef";
        }
        f.c cVar = format.c;
        if (cVar.f) {
            char[] cArr = {str.charAt((i >> 28) & 15), str.charAt((i >> 24) & 15), str.charAt((i >> 20) & 15), str.charAt((i >> 16) & 15), str.charAt((i >> 12) & 15), str.charAt((i >> 8) & 15), str.charAt((i >> 4) & 15), str.charAt(i & 15)};
            if (cVar.c) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(i) >> 2, 7);
                return StringsKt__StringsJVMKt.concatToString$default(cArr, coerceAtMost, 0, 2, null);
            }
            concatToString = StringsKt__StringsJVMKt.concatToString(cArr);
            return concatToString;
        }
        return q(i, cVar, str, 32);
    }

    private static final void d(String str, int i, int i2) {
        while (i < i2) {
            if (str.charAt(i) == '0') {
                i++;
            } else {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + i + ", but was '" + str.charAt(i) + "'.\nThe result won't fit the type being parsed.");
            }
        }
    }

    private static final long i(String str, int i, int i2) {
        long j = 0;
        while (i < i2) {
            long j2 = j << 4;
            char charAt = str.charAt(i);
            if ((charAt >>> '\b') == 0) {
                long j3 = d[charAt];
                if (j3 >= 0) {
                    j = j2 | j3;
                    i++;
                }
            }
            j(str, i);
            throw new KotlinNothingValueException();
        }
        return j;
    }

    private static final int n(String str, char[] cArr, int i) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                int length2 = str.length();
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                str.getChars(0, length2, cArr, i);
            } else {
                cArr[i] = str.charAt(0);
            }
        }
        return i + str.length();
    }

    public static /* synthetic */ String p(int i, f fVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fVar = f.d.a();
        }
        return o(i, fVar);
    }

    private static final void b(String str, int i, int i2, int i3) {
        int i4 = i2 - i;
        if (i4 < 1) {
            k(str, i, i2, "at least", 1);
        } else if (i4 > i3) {
            d(str, i, (i4 + i) - i3);
        }
    }

    public static final long f(String str, int i, int i2, f format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return h(str, i, i2, format, 16);
    }

    private static final String q(long j, f.c cVar, String str, int i) {
        boolean z;
        int coerceAtLeast;
        String concatToString;
        if ((i & 3) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int i2 = i >> 2;
            int i3 = cVar.d;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 - i2, 0);
            String str2 = cVar.a;
            String str3 = cVar.b;
            boolean z2 = cVar.c;
            int a2 = a(str2.length() + coerceAtLeast + i2 + str3.length());
            char[] cArr = new char[a2];
            int n = n(str2, cArr, 0);
            if (coerceAtLeast > 0) {
                int i4 = coerceAtLeast + n;
                ArraysKt___ArraysJvmKt.fill(cArr, str.charAt(0), n, i4);
                n = i4;
            }
            boolean z3 = z2;
            int i5 = i;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 -= 4;
                int i7 = (int) ((j >> i5) & 15);
                if (z3 && i7 == 0 && (i5 >> 2) >= i3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    cArr[n] = str.charAt(i7);
                    n++;
                }
            }
            int n2 = n(str3, cArr, n);
            if (n2 == a2) {
                concatToString = StringsKt__StringsJVMKt.concatToString(cArr);
                return concatToString;
            }
            return StringsKt__StringsJVMKt.concatToString$default(cArr, 0, n2, 1, null);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final long h(String str, int i, int i2, f fVar, int i3) {
        AbstractList.Companion.a(i, i2, str.length());
        f.c cVar = fVar.c;
        if (cVar.e) {
            b(str, i, i2, i3);
            return i(str, i, i2);
        }
        String str2 = cVar.a;
        String str3 = cVar.b;
        c(str, i, i2, str2, str3, cVar.g, i3);
        return i(str, i + str2.length(), i2 - str3.length());
    }

    private static final void l(String str, int i, int i2, String str2, String str3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + substring);
    }

    private static final void k(String str, int i, int i2, String str2, int i3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i3 + " hexadecimal digits at index " + i + ", but was \"" + substring + "\" of length " + (i2 - i));
    }

    private static final void m(String str, int i, int i2, String str2, String str3) {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(str2.length() + i, i2);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, coerceAtMost);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i + ", but was " + substring);
    }

    public static /* synthetic */ long g(String str, int i, int i2, f fVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            fVar = f.d.a();
        }
        return f(str, i, i2, fVar);
    }

    private static final void c(String str, int i, int i2, String str2, String str3, boolean z, int i3) {
        boolean z2;
        if ((i2 - i) - str2.length() <= str3.length()) {
            l(str, i, i2, str2, str3);
        }
        boolean z3 = true;
        if (str2.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            int length = str2.length();
            for (int i4 = 0; i4 < length; i4++) {
                if (!b.equals(str2.charAt(i4), str.charAt(i + i4), z)) {
                    m(str, i, i2, str2, "prefix");
                }
            }
            i += str2.length();
        }
        int length2 = i2 - str3.length();
        if (str3.length() != 0) {
            z3 = false;
        }
        if (!z3) {
            int length3 = str3.length();
            for (int i5 = 0; i5 < length3; i5++) {
                if (!b.equals(str3.charAt(i5), str.charAt(length2 + i5), z)) {
                    m(str, length2, i2, str3, "suffix");
                }
            }
        }
        b(str, i, length2, i3);
    }
}
