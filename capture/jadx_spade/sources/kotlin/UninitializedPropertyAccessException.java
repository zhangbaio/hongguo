package kotlin;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class UninitializedPropertyAccessException extends RuntimeException {
    static {
        Covode.recordClassIndex(658139);
    }

    public UninitializedPropertyAccessException() {
    }

    public UninitializedPropertyAccessException(String str) {
        super(str);
    }

    public UninitializedPropertyAccessException(Throwable th) {
        super(th);
    }

    public UninitializedPropertyAccessException(String str, Throwable th) {
        super(str, th);
    }
}
