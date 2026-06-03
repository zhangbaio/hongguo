package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g extends p {
    public final t g;
    public final long h;
    public final b i;

    static {
        Covode.recordClassIndex(660124);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void s(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.g.r(this.i, (int) (this.h & 2147483647L));
    }

    @Override // kotlinx.serialization.protobuf.internal.p, kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return ProtoIntegerType.DEFAULT.getSignature$kotlinx_serialization_protobuf() | 0 | 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(hn6.a proto, t writer, long j, SerialDescriptor descriptor, b stream) {
        super(proto, new t(stream), descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.g = writer;
        this.h = j;
        this.i = stream;
    }

    public /* synthetic */ g(hn6.a aVar, t tVar, long j, SerialDescriptor serialDescriptor, b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, tVar, j, serialDescriptor, (i & 16) != 0 ? new b() : bVar);
    }
}
