package kotlinx.coroutines.scheduling;

import com.bytedance.covode.number.Covode;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.p;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends e {
    public static final b f;

    static {
        Covode.recordClassIndex(659323);
        f = new b();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }

    public final void z() {
        super.close();
    }

    @Override // kotlinx.coroutines.scheduling.e, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    private b() {
        super(k.c, k.d, k.e, k.a);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int i) {
        p.a(i);
        if (i >= k.c) {
            return this;
        }
        return super.limitedParallelism(i);
    }
}
