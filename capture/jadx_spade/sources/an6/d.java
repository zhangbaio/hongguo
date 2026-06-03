package an6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static final int[] a;

    public static final int a(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static final int[] b() {
        return a;
    }

    static {
        Covode.recordClassIndex(659585);
        a = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    }

    public static final long e(long j, long j2) {
        if (j2 == -1) {
            if (j == Long.MIN_VALUE) {
                return 0L;
            }
            return -j;
        }
        if (j2 == 1) {
            return j;
        }
        long j3 = j * j2;
        if (j3 / j2 != j) {
            return 0L;
        }
        return j3;
    }

    public static final long c(long j, long j2, long j3) {
        if (j > 0 && j3 < 0) {
            j--;
            j3 += j2;
        } else if (j < 0 && j3 > 0) {
            j++;
            j3 -= j2;
        }
        return c.a(c.c(j, j2), j3);
    }

    public static final b d(long j, long j2, long j3) {
        long j4;
        int i;
        long j5;
        if (j != 0 && j2 != 0) {
            long e = e(j, j2);
            if (e != 0) {
                return new b(e / j3, e % j3);
            }
            if (j2 == j3) {
                return new b(j, 0L);
            }
            if (j == j3) {
                return new b(j2, 0L);
            }
            long j6 = -1;
            if (j >= 0) {
                j4 = 0;
            } else {
                j4 = -1;
            }
            if (j2 >= 0) {
                j6 = 0;
            }
            long j7 = j & 4294967295L;
            long j8 = (j >> 32) & 4294967295L;
            long j9 = j2 & 4294967295L;
            long j10 = (j2 >> 32) & 4294967295L;
            long j11 = (j4 * j10) + (j8 * j6);
            long j12 = (j4 * j9) + (j8 * j10) + (j6 * j7);
            long j13 = j8 * j9;
            long j14 = j10 * j7;
            long j15 = j7 * j9;
            long j16 = j15 & 4294967295L;
            long j17 = (j13 & 4294967295L) + (j14 & 4294967295L) + ((j15 >> 32) & 4294967295L);
            long j18 = j17 & 4294967295L;
            long j19 = ((j17 >> 32) & 4294967295L) + (j12 & 4294967295L) + ((j13 >> 32) & 4294967295L) + ((j14 >> 32) & 4294967295L);
            long j20 = (j18 << 32) | j16;
            long j21 = (j19 & 4294967295L) | (((((j19 >> 32) & 4294967295L) + ((j12 >> 32) & 4294967295L)) + (j11 & 4294967295L)) << 32);
            if (((j21 >> 63) & 1) == 1) {
                i = -1;
            } else {
                i = 1;
            }
            if (i == -1) {
                j20 = (~j20) + 1;
                j21 = ~j21;
                if (j20 == 0) {
                    j21++;
                }
            }
            int i2 = 127;
            long j22 = 0;
            long j23 = 0;
            for (int i3 = -1; i3 < i2; i3 = -1) {
                if (i2 < 64) {
                    j5 = j20 >> i2;
                } else {
                    j5 = j21 >> (i2 - 64);
                }
                j23 = (j23 << 1) | (j5 & 1);
                if (j23 >= j3 || j23 < 0) {
                    j23 -= j3;
                    if (i2 < 63) {
                        j22 |= 1 << i2;
                    } else {
                        throw new ArithmeticException("The result of a multiplication followed by division overflows a long");
                    }
                }
                i2--;
            }
            long j24 = i;
            return new b(j22 * j24, j24 * j23);
        }
        return new b(0L, 0L);
    }
}
