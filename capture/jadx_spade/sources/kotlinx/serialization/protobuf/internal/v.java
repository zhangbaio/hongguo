package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class v extends p {
    public final long g;

    static {
        Covode.recordClassIndex(660149);
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return this.g;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(hn6.a proto, t writer, long j, SerialDescriptor descriptor) {
        super(proto, writer, descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.g = j;
    }
}
