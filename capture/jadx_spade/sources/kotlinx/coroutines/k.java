package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.Future;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class k extends f1 {
    private final Future<?> e;

    static {
        Covode.recordClassIndex(658899);
    }

    public k(Future<?> future) {
        this.e = future;
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        if (th != null) {
            this.e.cancel(false);
        }
    }
}
