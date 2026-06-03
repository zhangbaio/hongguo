package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c implements Comparable<c> {
    public static final a b;
    private static final long c;
    private static final long d;
    private static final long e;
    private final long a;

    public static int A(long j) {
        return j.a(j);
    }

    private static final boolean C(long j) {
        return (((int) j) & 1) == 1;
    }

    private static final boolean G(long j) {
        return (((int) j) & 1) == 0;
    }

    public static final boolean J(long j) {
        return j < 0;
    }

    public static final boolean M(long j) {
        return j > 0;
    }

    public static final /* synthetic */ c f(long j) {
        return new c(j);
    }

    public static boolean l(long j, Object obj) {
        return (obj instanceof c) && j == ((c) obj).W();
    }

    public static final boolean m(long j, long j2) {
        return j == j2;
    }

    private static final long z(long j) {
        return j >> 1;
    }

    public final /* synthetic */ long W() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return l(this.a, obj);
    }

    public int hashCode() {
        return A(this.a);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(658806);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return c.d;
        }

        public final long b() {
            return c.e;
        }

        public final long c() {
            return c.c;
        }

        public final long d(String value) {
            long p;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                p = e.p(value, true);
                return p;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }
    }

    public String toString() {
        return U(this.a);
    }

    static {
        long j;
        long j2;
        Covode.recordClassIndex(658805);
        b = new a(null);
        c = i(0L);
        j = e.j(4611686018427387903L);
        d = j;
        j2 = e.j(-4611686018427387903L);
        e = j2;
    }

    private /* synthetic */ c(long j) {
        this.a = j;
    }

    public static final boolean B(long j) {
        return !H(j);
    }

    public static final long p(long j) {
        return T(j, DurationUnit.DAYS);
    }

    public static final long q(long j) {
        return T(j, DurationUnit.HOURS);
    }

    public static final long s(long j) {
        return T(j, DurationUnit.MINUTES);
    }

    public static final long u(long j) {
        return T(j, DurationUnit.SECONDS);
    }

    public int g(long j) {
        return h(this.a, j);
    }

    public static final long V(long j) {
        long i;
        i = e.i(-z(j), ((int) j) & 1);
        return i;
    }

    public static final long n(long j) {
        if (J(j)) {
            return V(j);
        }
        return j;
    }

    private static final DurationUnit y(long j) {
        if (G(j)) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(c cVar) {
        return g(cVar.W());
    }

    public static final boolean H(long j) {
        if (j != d && j != e) {
            return false;
        }
        return true;
    }

    public static final int o(long j) {
        if (H(j)) {
            return 0;
        }
        return (int) (q(j) % 24);
    }

    public static final long r(long j) {
        if (C(j) && B(j)) {
            return z(j);
        }
        return T(j, DurationUnit.MILLISECONDS);
    }

    public static final int v(long j) {
        if (H(j)) {
            return 0;
        }
        return (int) (s(j) % 60);
    }

    public static final int x(long j) {
        if (H(j)) {
            return 0;
        }
        return (int) (u(j) % 60);
    }

    public static final long t(long j) {
        long n;
        long z = z(j);
        if (!G(j)) {
            if (z > 9223372036854L) {
                return Long.MAX_VALUE;
            }
            if (z >= -9223372036854L) {
                n = e.n(z);
                return n;
            }
            return Long.MIN_VALUE;
        }
        return z;
    }

    public static final int w(long j) {
        long z;
        if (H(j)) {
            return 0;
        }
        if (C(j)) {
            z = e.n(z(j) % 1000);
        } else {
            z = z(j) % 1000000000;
        }
        return (int) z;
    }

    public static final String S(long j) {
        boolean z;
        boolean z2;
        StringBuilder sb = new StringBuilder();
        if (J(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long n = n(j);
        long q = q(n);
        int v = v(n);
        int x = x(n);
        int w = w(n);
        if (H(j)) {
            q = 9999999999999L;
        }
        boolean z3 = true;
        if (q != 0) {
            z = true;
        } else {
            z = false;
        }
        if (x == 0 && w == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (v == 0 && (!z2 || !z)) {
            z3 = false;
        }
        if (z) {
            sb.append(q);
            sb.append('H');
        }
        if (z3) {
            sb.append(v);
            sb.append('M');
        }
        if (z2 || (!z && !z3)) {
            e(j, sb, x, w, 9, "S", true);
        }
        return sb.toString();
    }

    public static long i(long j) {
        boolean z;
        if (d.a()) {
            boolean z2 = true;
            if (G(j)) {
                long z3 = z(j);
                if (-4611686018426999999L > z3 || z3 >= 4611686018427000000L) {
                    z2 = false;
                }
                if (!z2) {
                    throw new AssertionError(z(j) + " ns is out of nanoseconds range");
                }
            } else {
                long z4 = z(j);
                if (-4611686018427387903L <= z4 && z4 < 4611686018427387904L) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    long z5 = z(j);
                    if (-4611686018426L > z5 || z5 >= 4611686018427L) {
                        z2 = false;
                    }
                    if (z2) {
                        throw new AssertionError(z(j) + " ms is denormalized");
                    }
                } else {
                    throw new AssertionError(z(j) + " ms is out of milliseconds range");
                }
            }
        }
        return j;
    }

    public static String U(long j) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (j == 0) {
            return "0s";
        }
        if (j == d) {
            return "Infinity";
        }
        if (j == e) {
            return "-Infinity";
        }
        boolean J = J(j);
        StringBuilder sb = new StringBuilder();
        if (J) {
            sb.append('-');
        }
        long n = n(j);
        long p = p(n);
        int o = o(n);
        int v = v(n);
        int x = x(n);
        int w = w(n);
        int i = 0;
        if (p != 0) {
            z = true;
        } else {
            z = false;
        }
        if (o != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (v != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (x == 0 && w == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z) {
            sb.append(p);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(o);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(v);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (x == 0 && !z && !z2 && !z3) {
                if (w >= 1000000) {
                    e(j, sb, w / 1000000, w % 1000000, 6, "ms", false);
                } else if (w >= 1000) {
                    e(j, sb, w / 1000, w % 1000, 3, "us", false);
                } else {
                    sb.append(w);
                    sb.append("ns");
                }
            } else {
                e(j, sb, x, w, 9, "s", false);
            }
            i = i4;
        }
        if (J && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static final long P(long j, long j2) {
        return Q(j, V(j2));
    }

    public static final long T(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == d) {
            return Long.MAX_VALUE;
        }
        if (j == e) {
            return Long.MIN_VALUE;
        }
        return g.b(z(j), y(j), unit);
    }

    public static int h(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 >= 0 && (((int) j3) & 1) != 0) {
            int i = (((int) j) & 1) - (((int) j2) & 1);
            if (J(j)) {
                return -i;
            }
            return i;
        }
        return Intrinsics.compare(j, j2);
    }

    public static final long Q(long j, long j2) {
        long k;
        long m;
        if (H(j)) {
            if (!B(j2) && (j2 ^ j) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j;
        }
        if (H(j2)) {
            return j2;
        }
        if ((((int) j) & 1) == (((int) j2) & 1)) {
            long z = z(j) + z(j2);
            if (G(j)) {
                m = e.m(z);
                return m;
            }
            k = e.k(z);
            return k;
        }
        if (C(j)) {
            return d(j, z(j), z(j2));
        }
        return d(j, z(j2), z(j));
    }

    public static final long k(long j, int i) {
        long j2;
        long n;
        long n2;
        long l;
        int sign;
        long l2;
        if (i == 0) {
            if (M(j)) {
                return d;
            }
            if (J(j)) {
                return e;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (G(j)) {
            l2 = e.l(z(j) / i);
            return l2;
        }
        if (H(j)) {
            sign = MathKt__MathJVMKt.getSign(i);
            return R(j, sign);
        }
        long j3 = i;
        long z = z(j) / j3;
        boolean z2 = false;
        if (-4611686018426L <= z && z < 4611686018427L) {
            z2 = true;
        }
        if (z2) {
            n = e.n(z(j) - (z * j3));
            n2 = e.n(z);
            l = e.l(n2 + (n / j3));
            return l;
        }
        j2 = e.j(z);
        return j2;
    }

    public static final long R(long j, int i) {
        int sign;
        int sign2;
        long coerceIn;
        long j2;
        long o;
        long n;
        long o2;
        int sign3;
        int sign4;
        long coerceIn2;
        long j3;
        long m;
        long l;
        if (H(j)) {
            if (i != 0) {
                if (i <= 0) {
                    return V(j);
                }
                return j;
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return c;
        }
        long z = z(j);
        long j4 = i;
        long j5 = z * j4;
        if (G(j)) {
            boolean z2 = false;
            if (-2147483647L <= z && z < 2147483648L) {
                z2 = true;
            }
            if (z2) {
                l = e.l(j5);
                return l;
            }
            if (j5 / j4 == z) {
                m = e.m(j5);
                return m;
            }
            o = e.o(z);
            n = e.n(o);
            long j6 = o * j4;
            o2 = e.o((z - n) * j4);
            long j7 = o2 + j6;
            if (j6 / j4 == o && (j7 ^ j6) >= 0) {
                coerceIn2 = RangesKt___RangesKt.coerceIn(j7, (ClosedRange<Long>) new LongRange(-4611686018427387903L, 4611686018427387903L));
                j3 = e.j(coerceIn2);
                return j3;
            }
            sign3 = MathKt__MathJVMKt.getSign(z);
            sign4 = MathKt__MathJVMKt.getSign(i);
            if (sign3 * sign4 > 0) {
                return d;
            }
            return e;
        }
        if (j5 / j4 == z) {
            coerceIn = RangesKt___RangesKt.coerceIn(j5, (ClosedRange<Long>) new LongRange(-4611686018427387903L, 4611686018427387903L));
            j2 = e.j(coerceIn);
            return j2;
        }
        sign = MathKt__MathJVMKt.getSign(z);
        sign2 = MathKt__MathJVMKt.getSign(i);
        if (sign * sign2 > 0) {
            return d;
        }
        return e;
    }

    private static final long d(long j, long j2, long j3) {
        long o;
        long coerceIn;
        long j4;
        long n;
        long n2;
        long l;
        o = e.o(j3);
        long j5 = j2 + o;
        boolean z = false;
        if (-4611686018426L <= j5 && j5 < 4611686018427L) {
            z = true;
        }
        if (z) {
            n = e.n(o);
            long j6 = j3 - n;
            n2 = e.n(j5);
            l = e.l(n2 + j6);
            return l;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(j5, -4611686018427387903L, 4611686018427387903L);
        j4 = e.j(coerceIn);
        return j4;
    }

    private static final void e(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        boolean z2;
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String padStart = StringsKt__StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) padStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) padStart, 0, ((i6 + 2) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }
}
