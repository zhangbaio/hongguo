package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class e extends ProtobufDecoder {
    public final long k;

    static {
        Covode.recordClassIndex(660122);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.protobuf.internal.s
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (i % 2 == 0) {
            return d.f(this.k).getSignature$kotlinx_serialization_protobuf() | 0 | 1;
        }
        return 2 | 0 | d.f(this.k).getSignature$kotlinx_serialization_protobuf();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(hn6.a proto, q decoder, long j, SerialDescriptor descriptor) {
        super(proto, decoder, descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.k = j;
    }
}
