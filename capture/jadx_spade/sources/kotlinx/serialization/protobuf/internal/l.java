package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class l extends ProtobufDecoder {
    private final long k;
    private boolean l;
    private boolean m;

    static {
        Covode.recordClassIndex(660129);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.encoding.Decoder
    public kotlinx.serialization.encoding.c beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(descriptor, this.e)) {
            return this;
        }
        return new j(this.c, this.d, descriptor);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.encoding.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!this.l) {
            this.l = true;
            return 0;
        }
        if (!this.m) {
            this.m = true;
            return 1;
        }
        return -1;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.protobuf.internal.s
    protected String s(long j) {
        String serialName;
        if (j == 19501) {
            SerialDescriptor d = d.d(this.e, getSerializersModule(), (int) (this.k & 2147483647L));
            if (d == null || (serialName = d.getSerialName()) == null) {
                throw new SerializationException("Cannot find a subclass of " + this.e.getSerialName() + " annotated with @ProtoNumber(" + ((int) (this.k & 2147483647L)) + ").");
            }
            return serialName;
        }
        return super.s(j);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.protobuf.internal.s
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (i == 0) {
            return 19501L;
        }
        return d.b(serialDescriptor, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(hn6.a proto, q decoder, long j, SerialDescriptor descriptor) {
        super(proto, decoder, descriptor);
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.k = j;
    }
}
