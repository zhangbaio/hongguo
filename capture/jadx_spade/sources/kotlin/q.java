package kotlin;

import androidx.collection.w;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class q {
    static {
        Covode.recordClassIndex(658143);
    }

    public static final double e(int i) {
        return (Integer.MAX_VALUE & i) + (((i >>> 31) << 30) * 2);
    }

    public static final double i(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    public static final int a(double d) {
        if (Double.isNaN(d) || d <= e(0)) {
            return 0;
        }
        if (d >= e(-1)) {
            return -1;
        }
        if (d <= 2.147483647E9d) {
            return UInt.m790constructorimpl((int) d);
        }
        return UInt.m790constructorimpl(UInt.m790constructorimpl((int) (d - Integer.MAX_VALUE)) + UInt.m790constructorimpl(Integer.MAX_VALUE));
    }

    public static final int b(int i, int i2) {
        return Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    public static final int c(int i, int i2) {
        return UInt.m790constructorimpl((int) ((i & 4294967295L) / (i2 & 4294967295L)));
    }

    public static final int d(int i, int i2) {
        return UInt.m790constructorimpl((int) ((i & 4294967295L) % (i2 & 4294967295L)));
    }

    public static final int f(long j, long j2) {
        return Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static final long h(long j, long j2) {
        if (j2 < 0) {
            if (w.a(j, j2) >= 0) {
                return ULong.m850constructorimpl(j - j2);
            }
            return j;
        }
        if (j >= 0) {
            return ULong.m850constructorimpl(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (w.a(ULong.m850constructorimpl(j3), ULong.m850constructorimpl(j2)) < 0) {
            j2 = 0;
        }
        return ULong.m850constructorimpl(j3 - j2);
    }

    public static final long g(long j, long j2) {
        if (j2 < 0) {
            if (w.a(j, j2) < 0) {
                return ULong.m850constructorimpl(0L);
            }
            return ULong.m850constructorimpl(1L);
        }
        if (j >= 0) {
            return ULong.m850constructorimpl(j / j2);
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (w.a(ULong.m850constructorimpl(j - (j3 * j2)), ULong.m850constructorimpl(j2)) < 0) {
            i = 0;
        }
        return ULong.m850constructorimpl(j3 + i);
    }

    public static final String j(long j, int i) {
        int checkRadix;
        int checkRadix2;
        int checkRadix3;
        if (j >= 0) {
            checkRadix3 = CharsKt__CharJVMKt.checkRadix(i);
            String l = Long.toString(j, checkRadix3);
            Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        checkRadix = CharsKt__CharJVMKt.checkRadix(i);
        String l2 = Long.toString(j3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l2, "toString(...)");
        sb.append(l2);
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(i);
        String l3 = Long.toString(j4, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(...)");
        sb.append(l3);
        return sb.toString();
    }
}
