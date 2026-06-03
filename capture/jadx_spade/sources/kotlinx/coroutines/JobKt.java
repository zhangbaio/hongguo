package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class JobKt {
    static {
        Covode.recordClassIndex(659001);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        JobKt__JobKt.x(coroutineContext);
    }

    public static final CompletableJob Job(Job job) {
        return JobKt__JobKt.a(job);
    }

    public static final void ensureActive(Job job) {
        JobKt__JobKt.y(job);
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        return JobKt__JobKt.z(coroutineContext);
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        return JobKt__JobKt.C(coroutineContext);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        e1.a(cancellableContinuation, future);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.f(coroutineContext, cancellationException);
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        return JobKt__JobKt.l(job, continuation);
    }

    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        return e1.b(job, future);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.w(job, disposableHandle);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.o(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(Job job, CancellationException cancellationException) {
        JobKt__JobKt.r(job, cancellationException);
    }

    public static final void cancel(Job job, String str, Throwable th) {
        JobKt__JobKt.g(job, str, th);
    }

    public static final DisposableHandle invokeOnCompletion(Job job, boolean z, boolean z2, z0 z0Var) {
        return JobKt__JobKt.A(job, z, z2, z0Var);
    }
}
