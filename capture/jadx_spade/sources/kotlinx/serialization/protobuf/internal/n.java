package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n extends g {
    static {
        Covode.recordClassIndex(660131);
    }

    @Override // kotlinx.serialization.protobuf.internal.g, kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return 19500L;
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.encoding.Encoder
    public kotlinx.serialization.encoding.d beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new SerializationException("Packing only supports primitive number types");
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.encoding.Encoder
    public kotlinx.serialization.encoding.d beginCollection(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new SerializationException("Packing only supports primitive number types");
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void r(long j, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Packing only supports primitive number types");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(hn6.a proto, t writer, long j, SerialDescriptor descriptor, b stream) {
        super(proto, writer, j, descriptor, stream);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(stream, "stream");
    }

    public /* synthetic */ n(hn6.a aVar, t tVar, long j, SerialDescriptor serialDescriptor, b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, tVar, j, serialDescriptor, (i & 16) != 0 ? new b() : bVar);
    }
}
