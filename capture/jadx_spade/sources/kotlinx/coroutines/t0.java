package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t0 {
    private static final kotlinx.coroutines.internal.f0 a;
    private static final kotlinx.coroutines.internal.f0 b;

    public static final long d(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }

    static {
        Covode.recordClassIndex(658977);
        a = new kotlinx.coroutines.internal.f0("REMOVED_TASK");
        b = new kotlinx.coroutines.internal.f0("CLOSED_EMPTY");
    }

    public static final long c(long j) {
        return j / 1000000;
    }
}
