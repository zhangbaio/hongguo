package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ExecutorsKt {
    static {
        Covode.recordClassIndex(658982);
    }

    public static /* synthetic */ void CloseableCoroutineDispatcher$annotations() {
    }

    public static final ExecutorCoroutineDispatcher from(ExecutorService executorService) {
        return new v0(executorService);
    }

    public static final Executor asExecutor(CoroutineDispatcher coroutineDispatcher) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcher;
        Executor executor;
        if (coroutineDispatcher instanceof ExecutorCoroutineDispatcher) {
            executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) coroutineDispatcher;
        } else {
            executorCoroutineDispatcher = null;
        }
        if (executorCoroutineDispatcher == null || (executor = executorCoroutineDispatcher.getExecutor()) == null) {
            return new k0(coroutineDispatcher);
        }
        return executor;
    }

    public static final CoroutineDispatcher from(Executor executor) {
        k0 k0Var;
        CoroutineDispatcher coroutineDispatcher;
        if (executor instanceof k0) {
            k0Var = (k0) executor;
        } else {
            k0Var = null;
        }
        if (k0Var == null || (coroutineDispatcher = k0Var.a) == null) {
            return new v0(executor);
        }
        return coroutineDispatcher;
    }
}
