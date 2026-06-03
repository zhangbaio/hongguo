package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CoroutineScopeKt {
    static {
        Covode.recordClassIndex(658941);
    }

    public static /* synthetic */ void isActive$annotations(CoroutineScope coroutineScope) {
    }

    public static final CoroutineScope MainScope() {
        return new kotlinx.coroutines.internal.g(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    }

    public static final Object currentCoroutineContext(Continuation<? super CoroutineContext> continuation) {
        return continuation.getContext();
    }

    private static final Object currentCoroutineContext$$forInline(Continuation<? super CoroutineContext> continuation) {
        InlineMarker.mark(3);
        throw null;
    }

    public static final void ensureActive(CoroutineScope coroutineScope) {
        JobKt.ensureActive(coroutineScope.getCoroutineContext());
    }

    public static final CoroutineScope CoroutineScope(CoroutineContext coroutineContext) {
        CompletableJob c;
        if (coroutineContext.get(Job.Key) == null) {
            c = JobKt__JobKt.c(null, 1, null);
            coroutineContext = coroutineContext.plus(c);
        }
        return new kotlinx.coroutines.internal.g(coroutineContext);
    }

    public static final boolean isActive(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final CoroutineScope plus(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        return new kotlinx.coroutines.internal.g(coroutineScope.getCoroutineContext().plus(coroutineContext));
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        Object coroutine_suspended;
        kotlinx.coroutines.internal.b0 b0Var = new kotlinx.coroutines.internal.b0(continuation.getContext(), continuation);
        Object b = ym6.b.b(b0Var, b0Var, function2);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (b == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return b;
    }

    public static final void cancel(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static final void cancel(CoroutineScope coroutineScope, String str, Throwable th) {
        cancel(coroutineScope, u0.a(str, th));
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        cancel(coroutineScope, cancellationException);
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        cancel(coroutineScope, str, th);
    }
}
