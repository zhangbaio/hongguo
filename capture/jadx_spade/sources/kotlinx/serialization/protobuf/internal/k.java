package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class k extends p {
    private final t g;

    static {
        Covode.recordClassIndex(660128);
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.encoding.Encoder
    public kotlinx.serialization.encoding.d beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(descriptor, this.f)) {
            return this;
        }
        return new i(this.d, this.g, descriptor);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return n(d.j(e(), (int) (d.b(descriptor, 0) & 2147483647L)), descriptor);
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void r(long j, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (j != 19501) {
            super.r(j, value);
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (i != 0) {
            if (i == 1) {
                return d.b(serialDescriptor, i);
            }
            throw new SerializationException("Unsupported index: " + i + " in a oneOf type " + serialDescriptor.getSerialName() + ", which should be using generic polymorphic serializer");
        }
        return 19501L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(hn6.a proto, t parentWriter, SerialDescriptor descriptor) {
        super(proto, parentWriter, descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(parentWriter, "parentWriter");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.g = parentWriter;
        if (descriptor.getKind() instanceof kotlinx.serialization.descriptors.a) {
            return;
        }
        throw new IllegalArgumentException(("The serializer of one of type " + descriptor.getSerialName() + " should be using generic polymorphic serializer, but got " + descriptor.getKind() + '.').toString());
    }
}
