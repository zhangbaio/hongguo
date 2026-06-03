package rm6;

import androidx.collection.w;
import com.bytedance.covode.number.Covode;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.j;
import zj5.l;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    static {
        Covode.recordClassIndex(658362);
    }

    private static final int a(int i, int i2, int i3) {
        int compare;
        int a = j.a(i, i3);
        int a2 = j.a(i2, i3);
        compare = Integer.compare(a ^ Integer.MIN_VALUE, a2 ^ Integer.MIN_VALUE);
        int m790constructorimpl = UInt.m790constructorimpl(a - a2);
        if (compare < 0) {
            return UInt.m790constructorimpl(m790constructorimpl + i3);
        }
        return m790constructorimpl;
    }

    private static final long b(long j, long j2, long j3) {
        long a = l.a(j, j3);
        long a2 = l.a(j2, j3);
        int a3 = w.a(a, a2);
        long m850constructorimpl = ULong.m850constructorimpl(a - a2);
        if (a3 < 0) {
            return ULong.m850constructorimpl(m850constructorimpl + j3);
        }
        return m850constructorimpl;
    }

    public static final long c(long j, long j2, long j3) {
        if (j3 > 0) {
            if (w.a(j, j2) < 0) {
                return ULong.m850constructorimpl(j2 - b(j2, j, ULong.m850constructorimpl(j3)));
            }
            return j2;
        }
        if (j3 < 0) {
            if (w.a(j, j2) > 0) {
                return ULong.m850constructorimpl(j2 + b(j, j2, ULong.m850constructorimpl(-j3)));
            }
            return j2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final int d(int i, int i2, int i3) {
        int compare;
        int compare2;
        if (i3 > 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return UInt.m790constructorimpl(i2 - a(i2, i, UInt.m790constructorimpl(i3)));
            }
            return i2;
        }
        if (i3 < 0) {
            compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return UInt.m790constructorimpl(i2 + a(i, i2, UInt.m790constructorimpl(-i3)));
            }
            return i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
