package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class u extends ProtobufDecoder {
    private int k;
    private final long l;

    static {
        Covode.recordClassIndex(660148);
    }

    private final int F() {
        long j = -this.l;
        int i = this.k + 1;
        this.k = i;
        if (i != j && !this.d.g()) {
            return i;
        }
        return -1;
    }

    private final int G() {
        int y;
        if (this.k == -1) {
            y = this.d.b;
        } else {
            y = this.d.y();
        }
        if (y == ((int) (this.l & 2147483647L))) {
            int i = this.k + 1;
            this.k = i;
            return i;
        }
        this.d.j();
        return -1;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.encoding.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.l > 0) {
            return G();
        }
        return F();
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.protobuf.internal.s
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        long j = this.l;
        if (j > 0) {
            return j;
        }
        return 19500L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(hn6.a proto, q decoder, long j, SerialDescriptor descriptor) {
        super(proto, decoder, descriptor);
        boolean z;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.k = -1;
        if (j == 19500) {
            int r = this.d.r();
            if (r >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                j = -r;
            } else {
                throw new IllegalArgumentException(("Expected positive length for " + descriptor + ", but got " + r).toString());
            }
        }
        this.l = j;
    }
}
