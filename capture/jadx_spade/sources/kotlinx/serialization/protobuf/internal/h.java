package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
class h extends p {
    protected final long g;
    protected final t h;
    protected final b i;

    static {
        Covode.recordClassIndex(660125);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void s(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        long j = this.g;
        if (j != 19500) {
            this.h.r(this.i, (int) (j & 2147483647L));
        } else {
            this.h.q(this.i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(hn6.a proto, long j, t parentWriter, b stream, SerialDescriptor descriptor) {
        super(proto, new t(stream), descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(parentWriter, "parentWriter");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.g = j;
        this.h = parentWriter;
        this.i = stream;
    }

    public /* synthetic */ h(hn6.a aVar, long j, t tVar, b bVar, SerialDescriptor serialDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, j, tVar, (i & 8) != 0 ? new b() : bVar, serialDescriptor);
    }
}
