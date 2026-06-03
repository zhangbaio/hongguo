package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g implements CoroutineScope {
    private final CoroutineContext a;

    static {
        Covode.recordClassIndex(659220);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }

    public g(CoroutineContext coroutineContext) {
        this.a = coroutineContext;
    }
}
