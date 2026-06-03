package kotlin.random;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class Random {
    public static final Default Default;
    private static final Random defaultRandom;

    public static final class Default extends Random implements Serializable {
        static {
            Covode.recordClassIndex(658608);
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static final class Serialized implements Serializable {
            public static final Serialized INSTANCE;
            private static final long serialVersionUID = 0;

            static {
                Covode.recordClassIndex(658609);
                INSTANCE = new Serialized();
            }

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public int nextBits(int i) {
            return Random.defaultRandom.nextBits(i);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int i) {
            return Random.defaultRandom.nextBytes(i);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d) {
            return Random.defaultRandom.nextDouble(d);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i) {
            return Random.defaultRandom.nextInt(i);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j) {
            return Random.defaultRandom.nextLong(j);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d, double d2) {
            return Random.defaultRandom.nextDouble(d, d2);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i, int i2) {
            return Random.defaultRandom.nextInt(i, i2);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j, long j2) {
            return Random.defaultRandom.nextLong(j, j2);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array, int i, int i2) {
            Intrinsics.checkNotNullParameter(array, "array");
            return Random.defaultRandom.nextBytes(array, i, i2);
        }
    }

    public abstract int nextBits(int i);

    public int nextInt() {
        return nextBits(32);
    }

    public boolean nextBoolean() {
        if (nextBits(1) != 0) {
            return true;
        }
        return false;
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    static {
        Covode.recordClassIndex(658607);
        Default = new Default(null);
        defaultRandom = rm6.b.a.b();
    }

    public double nextDouble() {
        return c.b(nextBits(26), nextBits(27));
    }

    public byte[] nextBytes(int i) {
        return nextBytes(new byte[i]);
    }

    public double nextDouble(double d) {
        return nextDouble(0.0d, d);
    }

    public long nextLong(long j) {
        return nextLong(0L, j);
    }

    public byte[] nextBytes(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public int nextInt(int i) {
        return nextInt(0, i);
    }

    public int nextInt(int i, int i2) {
        int nextInt;
        int i3;
        int i4;
        int nextInt2;
        boolean z;
        RandomKt.checkRangeBounds(i, i2);
        int i5 = i2 - i;
        if (i5 <= 0 && i5 != Integer.MIN_VALUE) {
            do {
                nextInt2 = nextInt();
                z = false;
                if (i <= nextInt2 && nextInt2 < i2) {
                    z = true;
                }
            } while (!z);
            return nextInt2;
        }
        if (((-i5) & i5) == i5) {
            i4 = nextBits(RandomKt.fastLog2(i5));
        } else {
            do {
                nextInt = nextInt() >>> 1;
                i3 = nextInt % i5;
            } while ((nextInt - i3) + (i5 - 1) < 0);
            i4 = i3;
        }
        return i + i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double nextDouble(double r10, double r12) {
        /*
            r9 = this;
            kotlin.random.RandomKt.checkRangeBounds(r10, r12)
            double r0 = r12 - r10
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L3b
            double r2 = java.lang.Math.abs(r10)
            r4 = 1
            r5 = 0
            r6 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 > 0) goto L1c
            r2 = 1
            goto L1d
        L1c:
            r2 = 0
        L1d:
            if (r2 == 0) goto L3b
            double r2 = java.lang.Math.abs(r12)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 > 0) goto L28
            goto L29
        L28:
            r4 = 0
        L29:
            if (r4 == 0) goto L3b
            double r0 = r9.nextDouble()
            r2 = 2
            double r2 = (double) r2
            double r4 = r12 / r2
            double r2 = r10 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r10 = r10 + r0
            double r10 = r10 + r0
            goto L42
        L3b:
            double r2 = r9.nextDouble()
            double r2 = r2 * r0
            double r10 = r10 + r2
        L42:
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 < 0) goto L4c
            r10 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r10 = java.lang.Math.nextAfter(r12, r10)
        L4c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextDouble(double, double):double");
    }

    public long nextLong(long j, long j2) {
        long nextLong;
        boolean z;
        long nextLong2;
        long j3;
        long j4;
        int nextInt;
        RandomKt.checkRangeBounds(j, j2);
        long j5 = j2 - j;
        if (j5 > 0) {
            if (((-j5) & j5) == j5) {
                int i = (int) j5;
                int i2 = (int) (j5 >>> 32);
                if (i != 0) {
                    nextInt = nextBits(RandomKt.fastLog2(i));
                } else if (i2 == 1) {
                    nextInt = nextInt();
                } else {
                    j4 = (nextBits(RandomKt.fastLog2(i2)) << 32) + (nextInt() & 4294967295L);
                }
                j4 = nextInt & 4294967295L;
            } else {
                do {
                    nextLong2 = nextLong() >>> 1;
                    j3 = nextLong2 % j5;
                } while ((nextLong2 - j3) + (j5 - 1) < 0);
                j4 = j3;
            }
            return j + j4;
        }
        do {
            nextLong = nextLong();
            z = false;
            if (j <= nextLong && nextLong < j2) {
                z = true;
            }
        } while (!z);
        return nextLong;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] nextBytes(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            r1 = 0
            if (r8 < 0) goto Le
            int r2 = r7.length
            if (r8 > r2) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 == 0) goto L1d
            if (r9 < 0) goto L18
            int r2 = r7.length
            if (r9 > r2) goto L18
            r2 = 1
            goto L19
        L18:
            r2 = 0
        L19:
            if (r2 == 0) goto L1d
            r2 = 1
            goto L1e
        L1d:
            r2 = 0
        L1e:
            java.lang.String r3 = "fromIndex ("
            if (r2 == 0) goto L8c
            if (r8 > r9) goto L25
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 == 0) goto L66
            int r0 = r9 - r8
            int r0 = r0 / 4
            r2 = 0
        L2d:
            if (r2 >= r0) goto L50
            int r3 = r6.nextInt()
            byte r4 = (byte) r3
            r7[r8] = r4
            int r4 = r8 + 1
            int r5 = r3 >>> 8
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 2
            int r5 = r3 >>> 16
            byte r5 = (byte) r5
            r7[r4] = r5
            int r4 = r8 + 3
            int r3 = r3 >>> 24
            byte r3 = (byte) r3
            r7[r4] = r3
            int r8 = r8 + 4
            int r2 = r2 + 1
            goto L2d
        L50:
            int r9 = r9 - r8
            int r0 = r9 * 8
            int r0 = r6.nextBits(r0)
        L57:
            if (r1 >= r9) goto L65
            int r2 = r8 + r1
            int r3 = r1 * 8
            int r3 = r0 >>> r3
            byte r3 = (byte) r3
            r7[r2] = r3
            int r1 = r1 + 1
            goto L57
        L65:
            return r7
        L66:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r8)
            java.lang.String r8 = ") must be not greater than toIndex ("
            r7.append(r8)
            r7.append(r9)
            java.lang.String r8 = ")."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L8c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r8)
            java.lang.String r8 = ") or toIndex ("
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = ") are out of range: 0.."
            r0.append(r8)
            int r7 = r7.length
            r0.append(r7)
            r7 = 46
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextBytes(byte[], int, int):byte[]");
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return random.nextBytes(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }
}
