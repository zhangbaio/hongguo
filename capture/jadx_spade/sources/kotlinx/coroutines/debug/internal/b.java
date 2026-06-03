package kotlinx.coroutines.debug.internal;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private final CoroutineContext a;
    public final CoroutineStackFrame b;
    public final long c;
    public final List<StackTraceElement> d;
    public final String e;
    public final Thread f;
    public final CoroutineStackFrame g;
    public final List<StackTraceElement> h;

    static {
        Covode.recordClassIndex(659114);
    }

    public final CoroutineContext getContext() {
        return this.a;
    }

    public b(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        this.a = coroutineContext;
        debugCoroutineInfoImpl.getClass();
        this.b = null;
        this.c = debugCoroutineInfoImpl.a;
        this.d = debugCoroutineInfoImpl.c();
        this.e = debugCoroutineInfoImpl._state;
        this.f = debugCoroutineInfoImpl.lastObservedThread;
        this.g = debugCoroutineInfoImpl.d();
        this.h = debugCoroutineInfoImpl.e();
    }
}
