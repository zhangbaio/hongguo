package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class AbortFlowException extends CancellationException {
    public final transient Object owner;

    static {
        Covode.recordClassIndex(659181);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public AbortFlowException(Object obj) {
        super("Flow was aborted, no more elements needed");
        this.owner = obj;
    }
}
