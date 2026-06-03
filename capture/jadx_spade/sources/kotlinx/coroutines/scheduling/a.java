package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.i0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a extends ExecutorCoroutineDispatcher implements Executor {
    public static final a a;
    private static final CoroutineDispatcher b;

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor getExecutor() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.IO";
    }

    private a() {
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    static {
        int coerceAtLeast;
        int e;
        Covode.recordClassIndex(659322);
        a = new a();
        l lVar = l.a;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(64, g0.a());
        e = i0.e("kotlinx.coroutines.io.parallelism", coerceAtLeast, 0, 0, 12, null);
        b = lVar.limitedParallelism(e);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int i) {
        return l.a.limitedParallelism(i);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        b.dispatchYield(coroutineContext, runnable);
    }
}
