package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.Future;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class l0 implements DisposableHandle {
    private final Future<?> a;

    static {
        Covode.recordClassIndex(658964);
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.a + ']';
    }

    public l0(Future<?> future) {
        this.a = future;
    }
}
