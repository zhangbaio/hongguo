package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.CancellationException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u0 {
    static {
        Covode.recordClassIndex(658978);
    }

    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
