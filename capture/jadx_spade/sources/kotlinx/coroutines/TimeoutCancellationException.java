package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TimeoutCancellationException extends CancellationException {
    public final transient Job coroutine;

    static {
        Covode.recordClassIndex(659039);
    }

    public TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }

    public TimeoutCancellationException(String str) {
        this(str, null);
    }

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.coroutine = job;
    }
}
