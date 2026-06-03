package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class GlobalScope implements CoroutineScope {
    public static final GlobalScope INSTANCE;

    static {
        Covode.recordClassIndex(658985);
        INSTANCE = new GlobalScope();
    }

    private GlobalScope() {
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
