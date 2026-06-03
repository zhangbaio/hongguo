package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j implements Continuation<Object> {
    public static final j a;
    private static final CoroutineContext b;

    private j() {
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return b;
    }

    static {
        Covode.recordClassIndex(659200);
        a = new j();
        b = EmptyCoroutineContext.INSTANCE;
    }
}
