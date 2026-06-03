package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ExceptionSuccessfullyProcessed extends Exception {
    public static final ExceptionSuccessfullyProcessed INSTANCE;

    static {
        Covode.recordClassIndex(659227);
        INSTANCE = new ExceptionSuccessfullyProcessed();
    }

    private ExceptionSuccessfullyProcessed() {
    }
}
