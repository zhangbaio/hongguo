package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class UndeliveredElementException extends RuntimeException {
    static {
        Covode.recordClassIndex(659277);
    }

    public UndeliveredElementException(String str, Throwable th) {
        super(str, th);
    }
}
