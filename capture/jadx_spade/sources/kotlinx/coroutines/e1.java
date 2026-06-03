package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.Future;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class e1 {
    static {
        Covode.recordClassIndex(659002);
    }

    public static final void a(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        n.c(cancellableContinuation, new j(future));
    }

    public static final DisposableHandle b(Job job, Future<?> future) {
        return JobKt__JobKt.B(job, false, false, new k(future), 3, null);
    }
}
