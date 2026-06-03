package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class f extends h {
    static {
        Covode.recordClassIndex(660123);
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (i % 2 == 0) {
            return d.f(this.g).getSignature$kotlinx_serialization_protobuf() | 0 | 1;
        }
        return 2 | 0 | d.f(this.g).getSignature$kotlinx_serialization_protobuf();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(hn6.a proto, long j, t parentWriter, SerialDescriptor descriptor) {
        super(proto, j, parentWriter, null, descriptor, 8, null);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(parentWriter, "parentWriter");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }
}
