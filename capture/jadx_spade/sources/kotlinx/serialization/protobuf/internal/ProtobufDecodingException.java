package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProtobufDecodingException extends SerializationException {
    static {
        Covode.recordClassIndex(660135);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProtobufDecodingException(String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ ProtobufDecodingException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }
}
