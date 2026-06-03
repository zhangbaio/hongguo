package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.b0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class g<T> extends b0<T> {
    static {
        Covode.recordClassIndex(659195);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean z(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return t(th);
    }

    public g(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }
}
