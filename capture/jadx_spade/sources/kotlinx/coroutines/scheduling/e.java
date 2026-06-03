package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e extends ExecutorCoroutineDispatcher {
    private final int a;
    private final int b;
    private final long c;
    private final String d;
    private CoroutineScheduler e = w();

    static {
        Covode.recordClassIndex(659328);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this.e;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e.close();
    }

    private final CoroutineScheduler w() {
        return new CoroutineScheduler(this.a, this.b, this.c, this.d);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.dispatch$default(this.e, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.dispatch$default(this.e, runnable, null, true, 2, null);
    }

    public final void x(Runnable runnable, h hVar, boolean z) {
        this.e.dispatch(runnable, hVar, z);
    }

    public e(int i, int i2, long j, String str) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = str;
    }
}
