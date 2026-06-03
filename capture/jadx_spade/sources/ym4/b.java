package ym4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.v;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements KSerializer<a> {
    public static final b a;
    private static final SerialDescriptor b;
    public static final int c;

    private b() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return b;
    }

    static {
        Covode.recordClassIndex(608682);
        a = new b();
        b = JsonObject.Companion.serializer().getDescriptor();
        c = 8;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new a(v.a.e((JsonObject) decoder.decodeSerializableValue(JsonObject.Companion.serializer())));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, a value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeSerializableValue(JsonObject.Companion.serializer(), v.a.i(value.a));
    }
}
