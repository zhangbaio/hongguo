package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.internal.c0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i<E> implements f2 {
    public final CancellableContinuationImpl<ChannelResult<? extends E>> a;

    static {
        Covode.recordClassIndex(659097);
    }

    @Override // kotlinx.coroutines.f2
    public void invokeOnCancellation(c0<?> c0Var, int i) {
        this.a.invokeOnCancellation(c0Var, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(CancellableContinuationImpl<? super ChannelResult<? extends E>> cancellableContinuationImpl) {
        this.a = cancellableContinuationImpl;
    }
}
