package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.time.TimeSource$Monotonic;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class l {
    public static final l a;
    private static final long b;

    private l() {
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    private final long e() {
        return System.nanoTime() - b;
    }

    public long d() {
        return TimeSource$Monotonic.ValueTimeMark.m1042constructorimpl(e());
    }

    static {
        Covode.recordClassIndex(658826);
        a = new l();
        b = System.nanoTime();
    }

    public final long c(long j) {
        return k.e(e(), j, DurationUnit.NANOSECONDS);
    }

    public final long b(long j, long j2) {
        return k.g(j, j2, DurationUnit.NANOSECONDS);
    }

    public final long a(long j, long j2) {
        return TimeSource$Monotonic.ValueTimeMark.m1042constructorimpl(k.c(j, DurationUnit.NANOSECONDS, j2));
    }
}
