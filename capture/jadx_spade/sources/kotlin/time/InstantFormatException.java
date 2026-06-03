package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class InstantFormatException extends IllegalArgumentException {
    static {
        Covode.recordClassIndex(658818);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstantFormatException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
