package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b0<T> extends kotlinx.coroutines.a<T> implements CoroutineStackFrame {
    public final Continuation<T> d;

    static {
        Covode.recordClassIndex(659260);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected final boolean Y() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlinx.coroutines.a
    protected void F0(Object obj) {
        Continuation<T> continuation = this.d;
        continuation.resumeWith(kotlinx.coroutines.x.a(obj, continuation));
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void p(Object obj) {
        Continuation intercepted;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.d);
        k.c(intercepted, kotlinx.coroutines.x.a(obj, this.d), null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.d = continuation;
    }
}
