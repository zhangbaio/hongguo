package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class k0 implements Executor {
    public final CoroutineDispatcher a;

    static {
        Covode.recordClassIndex(658961);
    }

    public String toString() {
        return this.a.toString();
    }

    public k0(CoroutineDispatcher coroutineDispatcher) {
        this.a = coroutineDispatcher;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        CoroutineDispatcher coroutineDispatcher = this.a;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher.isDispatchNeeded(emptyCoroutineContext)) {
            this.a.dispatch(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }
}
