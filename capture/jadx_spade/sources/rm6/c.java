package rm6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    static {
        Covode.recordClassIndex(658357);
    }

    private static final int e(int i, int i2) {
        int i3 = i % i2;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3;
    }

    private static final long f(long j, long j2) {
        long j3 = j % j2;
        if (j3 < 0) {
            return j3 + j2;
        }
        return j3;
    }

    private static final int a(int i, int i2, int i3) {
        return e(e(i, i3) - e(i2, i3), i3);
    }

    private static final long b(long j, long j2, long j3) {
        return f(f(j, j3) - f(j2, j3), j3);
    }

    public static final int c(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                return i2 - a(i2, i, i3);
            }
            return i2;
        }
        if (i3 < 0) {
            if (i > i2) {
                return i2 + a(i, i2, -i3);
            }
            return i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long d(long j, long j2, long j3) {
        if (j3 > 0) {
            if (j < j2) {
                return j2 - b(j2, j, j3);
            }
            return j2;
        }
        if (j3 < 0) {
            if (j > j2) {
                return j2 + b(j, j2, -j3);
            }
            return j2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
