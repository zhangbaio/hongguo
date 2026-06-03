package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class t<T> extends JobSupport implements CompletableDeferred<T> {
    static {
        Covode.recordClassIndex(658916);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean O() {
        return true;
    }

    @Override // kotlinx.coroutines.Deferred
    public T getCompleted() {
        return (T) F();
    }

    @Override // kotlinx.coroutines.Deferred
    public SelectClause1<T> getOnAwait() {
        SelectClause1<T> selectClause1 = (SelectClause1<T>) N();
        Intrinsics.checkNotNull(selectClause1, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return selectClause1;
    }

    public t(Job job) {
        super(true);
        W(job);
    }

    @Override // kotlinx.coroutines.Deferred
    public Object await(Continuation<? super T> continuation) {
        Object q = q(continuation);
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return q;
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean complete(T t) {
        return c0(t);
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public boolean completeExceptionally(Throwable th) {
        return c0(new v(th, false, 2, null));
    }
}
