package kotlinx.coroutines.flow.internal;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ChildCancelledException extends CancellationException {
    static {
        Covode.recordClassIndex(659192);
    }

    public ChildCancelledException() {
        super("Child of the scoped flow was cancelled");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
