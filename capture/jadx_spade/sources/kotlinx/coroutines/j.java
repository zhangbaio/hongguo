package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.Future;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j implements l {
    private final Future<?> a;

    static {
        Covode.recordClassIndex(658898);
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }

    public j(Future<?> future) {
        this.a = future;
    }

    @Override // kotlinx.coroutines.l
    public void invoke(Throwable th) {
        if (th != null) {
            this.a.cancel(false);
        }
    }
}
