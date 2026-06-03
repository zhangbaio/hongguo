package cn6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.b;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c implements KSerializer<zm6.b> {
    public static final c a;
    private static final SerialDescriptor b;

    private c() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return b;
    }

    static {
        Covode.recordClassIndex(659668);
        a = new c();
        b = SerialDescriptorsKt.PrimitiveSerialDescriptor("kotlinx.datetime.DatePeriod", b.i.a);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public zm6.b deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        zm6.c a2 = zm6.c.Companion.a(decoder.decodeString());
        if (a2 instanceof zm6.b) {
            return (zm6.b) a2;
        }
        throw new SerializationException(a2 + " is not a date-based period");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, zm6.b value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeString(value.toString());
    }
}
