package kotlin.text;

import com.bytedance.covode.number.Covode;
import kotlin.KotlinNothingValueException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d0 {
    static {
        Covode.recordClassIndex(658792);
    }

    public static final kotlin.g d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return e(str, 10);
    }

    public static final UInt g(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return h(str, 10);
    }

    public static final ULong k(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return l(str, 10);
    }

    public static final kotlin.o n(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return o(str, 10);
    }

    public static final byte c(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.g d = d(str);
        if (d != null) {
            return d.f();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final int f(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt g = g(str);
        if (g != null) {
            return g.m842unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final long i(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong k = k(str);
        if (k != null) {
            return k.m902unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final short m(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.o n = n(str);
        if (n != null) {
            return n.f();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final String a(long j, int i) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        return kotlin.q.j(j, checkRadix);
    }

    public static final String b(int i, int i2) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i2);
        return kotlin.q.j(i & 4294967295L, checkRadix);
    }

    public static final long j(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong l = l(str, i);
        if (l != null) {
            return l.m902unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final kotlin.g e(String str, int i) {
        int compare;
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt h = h(str, i);
        if (h == null) {
            return null;
        }
        int m842unboximpl = h.m842unboximpl();
        compare = Integer.compare(m842unboximpl ^ Integer.MIN_VALUE, UInt.m790constructorimpl(255) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return kotlin.g.a(kotlin.g.b((byte) m842unboximpl));
    }

    public static final kotlin.o o(String str, int i) {
        int compare;
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt h = h(str, i);
        if (h == null) {
            return null;
        }
        int m842unboximpl = h.m842unboximpl();
        compare = Integer.compare(m842unboximpl ^ Integer.MIN_VALUE, UInt.m790constructorimpl(65535) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return kotlin.o.a(kotlin.o.b((short) m842unboximpl));
    }

    public static final UInt h(String str, int i) {
        int i2;
        int compare;
        int compare2;
        int compare3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int m790constructorimpl = UInt.m790constructorimpl(i);
        int i4 = 119304647;
        while (i2 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (digitOf < 0) {
                return null;
            }
            compare = Integer.compare(i3 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                if (i4 == 119304647) {
                    i4 = kotlin.i.a(-1, m790constructorimpl);
                    compare3 = Integer.compare(i3 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            int m790constructorimpl2 = UInt.m790constructorimpl(i3 * m790constructorimpl);
            int m790constructorimpl3 = UInt.m790constructorimpl(UInt.m790constructorimpl(digitOf) + m790constructorimpl2);
            compare2 = Integer.compare(m790constructorimpl3 ^ Integer.MIN_VALUE, m790constructorimpl2 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i2++;
            i3 = m790constructorimpl3;
        }
        return UInt.m784boximpl(i3);
    }

    public static final ULong l(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long m850constructorimpl = ULong.m850constructorimpl(i);
        long j = 0;
        long j2 = 512409557603043100L;
        while (i2 < length) {
            if (CharsKt__CharJVMKt.digitOf(str.charAt(i2), i) < 0) {
                return null;
            }
            if (androidx.collection.w.a(j, j2) > 0) {
                if (j2 == 512409557603043100L) {
                    j2 = zj5.k.a(-1L, m850constructorimpl);
                    if (androidx.collection.w.a(j, j2) > 0) {
                    }
                }
                return null;
            }
            long m850constructorimpl2 = ULong.m850constructorimpl(j * m850constructorimpl);
            long m850constructorimpl3 = ULong.m850constructorimpl(ULong.m850constructorimpl(UInt.m790constructorimpl(r13) & 4294967295L) + m850constructorimpl2);
            if (androidx.collection.w.a(m850constructorimpl3, m850constructorimpl2) < 0) {
                return null;
            }
            i2++;
            j = m850constructorimpl3;
        }
        return ULong.m844boximpl(j);
    }
}
