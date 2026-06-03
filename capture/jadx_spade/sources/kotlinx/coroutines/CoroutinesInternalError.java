package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CoroutinesInternalError extends Error {
    static {
        Covode.recordClassIndex(658944);
    }

    public CoroutinesInternalError(String str, Throwable th) {
        super(str, th);
    }
}
