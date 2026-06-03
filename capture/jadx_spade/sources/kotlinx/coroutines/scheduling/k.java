package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.i0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class k {
    public static final String a;
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static f f;
    public static final h g;
    public static final h h;

    static {
        long f2;
        int coerceAtLeast;
        int e2;
        int e3;
        long f3;
        Covode.recordClassIndex(659334);
        a = g0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
        f2 = i0.f("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        b = f2;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(g0.a(), 2);
        e2 = i0.e("kotlinx.coroutines.scheduler.core.pool.size", coerceAtLeast, 1, 0, 8, null);
        c = e2;
        e3 = i0.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        d = e3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f3 = i0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        e = timeUnit.toNanos(f3);
        f = d.a;
        g = new i(0);
        h = new i(1);
    }
}
