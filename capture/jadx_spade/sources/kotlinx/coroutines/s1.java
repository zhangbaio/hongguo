package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class s1<T> extends kotlinx.coroutines.internal.b0<T> {
    static {
        Covode.recordClassIndex(659028);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean z(Throwable th) {
        return false;
    }

    public s1(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }
}
