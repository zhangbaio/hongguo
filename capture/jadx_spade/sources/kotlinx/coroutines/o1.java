package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class o1<T> extends f1 {
    private final CancellableContinuationImpl<T> e;

    static {
        Covode.recordClassIndex(659022);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o1(CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.e = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.z0
    public void invoke(Throwable th) {
        Object R = t().R();
        if (R instanceof v) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.e;
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m773constructorimpl(ResultKt.createFailure(((v) R).a)));
        } else {
            CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.e;
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl2.resumeWith(Result.m773constructorimpl(g1.h(R)));
        }
    }
}
