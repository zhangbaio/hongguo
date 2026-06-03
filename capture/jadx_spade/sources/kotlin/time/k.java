package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k {
    static {
        Covode.recordClassIndex(658823);
    }

    private static final long b(long j) {
        c.a aVar = c.b;
        if (j < 0) {
            return aVar.b();
        }
        return aVar.a();
    }

    private static final long a(long j, long j2, long j3) {
        if (c.H(j2) && (j ^ j3) < 0) {
            throw new IllegalArgumentException("Summing infinities of different signs");
        }
        return j;
    }

    private static final long d(long j, DurationUnit durationUnit, long j2) {
        boolean z;
        long k = c.k(j2, 2);
        long T = c.T(k, durationUnit);
        if ((1 | (T - 1)) == Long.MAX_VALUE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return T;
        }
        return c(c(j, durationUnit, k), durationUnit, c.P(j2, k));
    }

    public static final long e(long j, long j2, DurationUnit unit) {
        boolean z;
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return c.V(b(j2));
        }
        return f(j, j2, unit);
    }

    public static final long c(long j, DurationUnit unit, long j2) {
        boolean z;
        Intrinsics.checkNotNullParameter(unit, "unit");
        long T = c.T(j2, unit);
        boolean z2 = true;
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return a(j, j2, T);
        }
        if ((1 | (T - 1)) != Long.MAX_VALUE) {
            z2 = false;
        }
        if (z2) {
            return d(j, unit, j2);
        }
        long j3 = j + T;
        if (((j ^ j3) & (T ^ j3)) < 0) {
            if (j >= 0) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
        return j3;
    }

    private static final long f(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
            if (durationUnit.compareTo(durationUnit2) < 0) {
                long b = g.b(1L, durationUnit2, durationUnit);
                long j4 = (j / b) - (j2 / b);
                long j5 = (j % b) - (j2 % b);
                c.a aVar = c.b;
                return c.Q(e.t(j4, durationUnit2), e.t(j5, durationUnit));
            }
            return c.V(b(j3));
        }
        return e.t(j3, durationUnit);
    }

    public static final long g(long j, long j2, DurationUnit unit) {
        boolean z;
        Intrinsics.checkNotNullParameter(unit, "unit");
        boolean z2 = true;
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (j == j2) {
                return c.b.c();
            }
            return c.V(b(j2));
        }
        if ((1 | (j - 1)) != Long.MAX_VALUE) {
            z2 = false;
        }
        if (z2) {
            return b(j);
        }
        return f(j, j2, unit);
    }
}
