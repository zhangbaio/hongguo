package kotlin.coroutines.jvm.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    static {
        Covode.recordClassIndex(658325);
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public RestrictedContinuationImpl(Continuation<Object> continuation) {
        super(continuation);
        boolean z;
        if (continuation != null) {
            if (continuation.getContext() == EmptyCoroutineContext.INSTANCE) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }
}
