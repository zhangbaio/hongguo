package kotlinx.serialization;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class UnknownFieldException extends SerializationException {
    static {
        Covode.recordClassIndex(659798);
    }

    public UnknownFieldException(String str) {
        super(str);
    }

    public UnknownFieldException(int i) {
        this("An unknown field for index " + i);
    }
}
