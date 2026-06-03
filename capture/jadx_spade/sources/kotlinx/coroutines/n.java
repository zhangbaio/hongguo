package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class n {
    static {
        Covode.recordClassIndex(658906);
    }

    public static final <T> CancellableContinuationImpl<T> b(Continuation<? super T> continuation) {
        if (!(continuation instanceof kotlinx.coroutines.internal.j)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        CancellableContinuationImpl<T> b = ((kotlinx.coroutines.internal.j) continuation).b();
        if (b != null) {
            if (!b.resetStateReusable()) {
                b = null;
            }
            if (b != null) {
                return b;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }

    public static final void a(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        c(cancellableContinuation, new m0(disposableHandle));
    }

    public static final <T> void c(CancellableContinuation<? super T> cancellableContinuation, l lVar) {
        if (cancellableContinuation instanceof CancellableContinuationImpl) {
            ((CancellableContinuationImpl) cancellableContinuation).invokeOnCancellationInternal$kotlinx_coroutines_core(lVar);
            return;
        }
        throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
    }
}
