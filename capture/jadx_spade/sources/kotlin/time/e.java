package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    static {
        Covode.recordClassIndex(658808);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n(long j) {
        return j * 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j) {
        return c.i(j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o(long j) {
        return j / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j) {
        return c.i((j << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k(long j) {
        long coerceIn;
        boolean z = false;
        if (-4611686018426L <= j && j < 4611686018427L) {
            z = true;
        }
        if (z) {
            return l(n(j));
        }
        coerceIn = RangesKt___RangesKt.coerceIn(j, -4611686018427387903L, 4611686018427387903L);
        return j(coerceIn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j) {
        boolean z = false;
        if (-4611686018426999999L <= j && j < 4611686018427000000L) {
            z = true;
        }
        if (z) {
            return l(j);
        }
        return j(o(j));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long q(java.lang.String r12) {
        /*
            int r0 = r12.length()
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 <= 0) goto L18
            java.lang.String r5 = "+-"
            char r6 = r12.charAt(r4)
            boolean r5 = kotlin.text.StringsKt.contains$default(r5, r6, r4, r2, r1)
            if (r5 == 0) goto L18
            r5 = 1
            goto L19
        L18:
            r5 = 0
        L19:
            int r6 = r0 - r5
            r7 = 58
            r8 = 48
            r9 = 16
            if (r6 <= r9) goto L54
            r6 = r5
        L24:
            if (r5 >= r0) goto L3f
            char r10 = r12.charAt(r5)
            if (r10 != r8) goto L31
            if (r6 != r5) goto L3c
            int r6 = r6 + 1
            goto L3c
        L31:
            r11 = 49
            if (r11 > r10) goto L39
            if (r10 >= r7) goto L39
            r10 = 1
            goto L3a
        L39:
            r10 = 0
        L3a:
            if (r10 == 0) goto L54
        L3c:
            int r5 = r5 + 1
            goto L24
        L3f:
            int r5 = r0 - r6
            if (r5 <= r9) goto L54
            char r12 = r12.charAt(r4)
            r0 = 45
            if (r12 != r0) goto L4e
            r0 = -9223372036854775808
            goto L53
        L4e:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L53:
            return r0
        L54:
            java.lang.String r5 = "+"
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r12, r5, r4, r2, r1)
            if (r1 == 0) goto L6d
            if (r0 <= r3) goto L6d
            char r0 = r12.charAt(r3)
            if (r8 > r0) goto L67
            if (r0 >= r7) goto L67
            r4 = 1
        L67:
            if (r4 == 0) goto L6d
            java.lang.String r12 = kotlin.text.StringsKt.drop(r12, r3)
        L6d:
            long r0 = java.lang.Long.parseLong(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.e.q(java.lang.String):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j, int i) {
        return c.i((j << 1) + i);
    }

    public static final long s(int i, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return l(g.c(i, unit, DurationUnit.NANOSECONDS));
        }
        return t(i, unit);
    }

    public static final long t(long j, DurationUnit unit) {
        long coerceIn;
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long c = g.c(4611686018426999999L, durationUnit, unit);
        boolean z = false;
        if ((-c) <= j && j <= c) {
            z = true;
        }
        if (z) {
            return l(g.c(j, unit, durationUnit));
        }
        coerceIn = RangesKt___RangesKt.coerceIn(g.b(j, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L);
        return j(coerceIn);
    }

    public static final long r(double d, DurationUnit unit) {
        long roundToLong;
        long roundToLong2;
        Intrinsics.checkNotNullParameter(unit, "unit");
        double a = g.a(d, unit, DurationUnit.NANOSECONDS);
        boolean z = true;
        if (!Double.isNaN(a)) {
            roundToLong = MathKt__MathJVMKt.roundToLong(a);
            if (-4611686018426999999L > roundToLong || roundToLong >= 4611686018427000000L) {
                z = false;
            }
            if (z) {
                return l(roundToLong);
            }
            roundToLong2 = MathKt__MathJVMKt.roundToLong(g.a(d, unit, DurationUnit.MILLISECONDS));
            return k(roundToLong2);
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091 A[LOOP:1: B:26:0x006b->B:37:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b A[EDGE_INSN: B:38:0x009b->B:39:0x009b BREAK  A[LOOP:1: B:26:0x006b->B:37:0x0091], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long p(java.lang.String r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.e.p(java.lang.String, boolean):long");
    }
}
