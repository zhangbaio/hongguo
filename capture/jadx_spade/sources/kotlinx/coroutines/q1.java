package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class q1 implements Runnable {
    private final CoroutineDispatcher a;
    private final CancellableContinuation<Unit> b;

    static {
        Covode.recordClassIndex(659024);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.resumeUndispatched(this.a, Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q1(CoroutineDispatcher coroutineDispatcher, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.a = coroutineDispatcher;
        this.b = cancellableContinuation;
    }
}
