package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.q0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c0 extends q0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final c0 g;
    private static final long h;

    private c0() {
    }

    private final void j0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.q0, kotlinx.coroutines.p0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    private final boolean g0() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    private final boolean h0() {
        int i = debugStatus;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.r0
    protected Thread K() {
        Thread thread = _thread;
        if (thread == null) {
            return f0();
        }
        return thread;
    }

    private final synchronized void e0() {
        if (!h0()) {
            return;
        }
        debugStatus = 3;
        Y();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
    }

    private final synchronized boolean i0() {
        if (h0()) {
            return false;
        }
        debugStatus = 1;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    static {
        Long l;
        Covode.recordClassIndex(658947);
        c0 c0Var = new c0();
        g = c0Var;
        p0.D(c0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        h = timeUnit.toNanos(l.longValue());
    }

    private final synchronized Thread f0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(c0.class.getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean W;
        v1.a.d(this);
        c.a();
        try {
            if (!i0()) {
                if (!W) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long G = G();
                if (G == Long.MAX_VALUE) {
                    c.a();
                    long nanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = h + nanoTime;
                    }
                    long j2 = j - nanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        e0();
                        c.a();
                        if (!W()) {
                            K();
                            return;
                        }
                        return;
                    }
                    G = RangesKt___RangesKt.coerceAtMost(G, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (G > 0) {
                    if (h0()) {
                        _thread = null;
                        e0();
                        c.a();
                        if (!W()) {
                            K();
                            return;
                        }
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, G);
                }
            }
        } finally {
            _thread = null;
            e0();
            c.a();
            if (!W()) {
                K();
            }
        }
    }

    @Override // kotlinx.coroutines.q0
    public void R(Runnable runnable) {
        if (g0()) {
            j0();
        }
        super.R(runnable);
    }

    @Override // kotlinx.coroutines.r0
    protected void L(long j, q0.c cVar) {
        j0();
    }

    @Override // kotlinx.coroutines.q0, kotlinx.coroutines.f0
    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return b0(j, runnable);
    }
}
