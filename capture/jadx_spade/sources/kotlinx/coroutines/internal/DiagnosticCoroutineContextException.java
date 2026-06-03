package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DiagnosticCoroutineContextException extends RuntimeException {
    private final transient CoroutineContext context;

    static {
        Covode.recordClassIndex(659224);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.context.toString();
    }

    public DiagnosticCoroutineContextException(CoroutineContext coroutineContext) {
        this.context = coroutineContext;
    }
}
