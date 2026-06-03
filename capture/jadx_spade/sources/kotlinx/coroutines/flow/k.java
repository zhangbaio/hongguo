package kotlinx.coroutines.flow;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class k<T> {
    public final Flow<T> a;
    public final int b;
    public final BufferOverflow c;
    public final CoroutineContext d;

    static {
        Covode.recordClassIndex(659167);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Flow<? extends T> flow, int i, BufferOverflow bufferOverflow, CoroutineContext coroutineContext) {
        this.a = flow;
        this.b = i;
        this.c = bufferOverflow;
        this.d = coroutineContext;
    }
}
