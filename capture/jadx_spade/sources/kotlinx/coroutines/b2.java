package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b2<U, T extends U> extends kotlinx.coroutines.internal.b0<T> implements Runnable {
    public final long e;

    static {
        Covode.recordClassIndex(659040);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport
    public String f0() {
        return super.f0() + "(timeMillis=" + this.e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        s(TimeoutKt.TimeoutCancellationException(this.e, DelayKt.getDelay(getContext()), this));
    }

    public b2(long j, Continuation<? super U> continuation) {
        super(continuation.getContext(), continuation);
        this.e = j;
    }
}
