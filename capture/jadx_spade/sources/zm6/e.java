package zm6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    static {
        Covode.recordClassIndex(659385);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(int i, int i2) {
        long j = (i * 12) + i2;
        boolean z = false;
        if (-2147483648L <= j && j <= 2147483647L) {
            z = true;
        }
        if (z) {
            return (int) j;
        }
        throw new IllegalArgumentException("The total number of months in " + i + " years and " + i2 + " months overflows an Int");
    }

    public static final c c(int i, int i2, long j) {
        if (j != 0) {
            return new d(i, i2, j);
        }
        return new b(i, i2);
    }

    private static final long e(int i, int i2, int i3, long j) {
        long j2 = 60;
        long j3 = ((i * j2) + i2) * j2;
        long j4 = 1000000000;
        try {
            return an6.d.c(j3 + (j / j4) + i3, 1000000000L, j % j4);
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("The total number of nanoseconds in " + i + " hours, " + i2 + " minutes, " + i3 + " seconds, and " + j + " nanoseconds overflows a Long");
        }
    }

    public static final c a(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        return c(d(i, i2), i3, e(i4, i5, i6, j));
    }
}
