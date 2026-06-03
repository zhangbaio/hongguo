package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class o<T> implements Continuation<T>, CoroutineStackFrame {
    private final Continuation<T> a;
    private final CoroutineContext b;

    static {
        Covode.recordClassIndex(659207);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.b;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.a.resumeWith(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Continuation<? super T> continuation, CoroutineContext coroutineContext) {
        this.a = continuation;
        this.b = coroutineContext;
    }
}
