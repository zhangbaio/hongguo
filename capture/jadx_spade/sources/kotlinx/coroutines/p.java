package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p extends c1 {
    public final CancellableContinuationImpl<?> e;

    static {
        Covode.recordClassIndex(658908);
    }

    public p(CancellableContinuationImpl<?> cancellableContinuationImpl) {
        this.e = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.e;
        cancellableContinuationImpl.parentCancelled$kotlinx_coroutines_core(cancellableContinuationImpl.getContinuationCancellationCause(t()));
    }
}
