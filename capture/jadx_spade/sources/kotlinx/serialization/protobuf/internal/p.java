package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.internal.k1;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class p extends ProtobufTaggedEncoder {
    protected final hn6.a d;
    private final t e;
    protected final SerialDescriptor f;

    static {
        Covode.recordClassIndex(660137);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public kotlinx.serialization.modules.c getSerializersModule() {
        return this.d.getSerializersModule();
    }

    private final void v(byte[] bArr) {
        long f = f();
        if (f == 19500) {
            this.e.g(bArr);
        } else {
            this.e.h(bArr, (int) (f & 2147483647L));
        }
    }

    public kotlinx.serialization.encoding.d beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlinx.serialization.descriptors.d kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, e.b.a)) {
            if (d.h(descriptor.getElementDescriptor(0)) && d.i(d())) {
                return new n(this.d, this.e, d(), descriptor, null, 16, null);
            }
            return new v(this.d, this.e, d(), descriptor);
        }
        if (!Intrinsics.areEqual(kind, e.a.a) && !Intrinsics.areEqual(kind, e.d.a) && !(kind instanceof kotlinx.serialization.descriptors.a)) {
            if (Intrinsics.areEqual(kind, e.c.a)) {
                return new f(this.d, d(), this.e, descriptor);
            }
            throw new SerializationException("This serial kind is not supported as structure: " + descriptor);
        }
        long d = d();
        if (d == 19500 && Intrinsics.areEqual(descriptor, this.f)) {
            return this;
        }
        if (d.g(d)) {
            return new k(this.d, this.e, descriptor);
        }
        return new h(this.d, d(), this.e, null, descriptor, 8, null);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void h(long j, boolean z) {
        o(j, z ? 1 : 0);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void i(long j, byte b) {
        o(j, b);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void j(long j, char c) {
        o(j, c);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void q(long j, short s) {
        o(j, s);
    }

    @Override // kotlinx.serialization.encoding.d
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.d.a;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return d.b(serialDescriptor, i);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void k(long j, double d) {
        if (j == 19500) {
            this.e.i(d);
        } else {
            this.e.j(d, (int) (j & 2147483647L));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void m(long j, float f) {
        if (j == 19500) {
            this.e.k(f);
        } else {
            this.e.l(f, (int) (j & 2147483647L));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void o(long j, int i) {
        if (j == 19500) {
            this.e.m(i);
        } else {
            this.e.n(i, (int) (2147483647L & j), d.f(j));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void p(long j, long j2) {
        if (j == 19500) {
            this.e.o(j2);
        } else {
            this.e.p(j2, (int) (2147483647L & j), d.f(j));
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void r(long j, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (j == 19500) {
            this.e.s(value);
        } else {
            this.e.t(value, (int) (j & 2147483647L));
        }
    }

    private final <T> void w(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNull(serializationStrategy, "null cannot be cast to non-null type kotlinx.serialization.internal.MapLikeSerializer<kotlin.Any?, kotlin.Any?, T of kotlinx.serialization.protobuf.internal.ProtobufEncoder.serializeMap, *>");
        k1 k1Var = (k1) serializationStrategy;
        KSerializer n = en6.a.n(en6.a.j(k1Var.a, k1Var.b));
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        n.serialize(this, ((Map) t).entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder, kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (serializer instanceof k1) {
            w(serializer, t);
        } else if (Intrinsics.areEqual(serializer.getDescriptor(), en6.a.c().getDescriptor())) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.ByteArray");
            v((byte[]) t);
        } else {
            serializer.serialize(this, t);
        }
    }

    public kotlinx.serialization.encoding.d beginCollection(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlinx.serialization.descriptors.d kind = descriptor.getKind();
        e.b bVar = e.b.a;
        if (Intrinsics.areEqual(kind, bVar)) {
            long d = d();
            if (d.i(d) && d.h(descriptor.getElementDescriptor(0))) {
                return new n(this.d, this.e, d(), descriptor, null, 16, null);
            }
            if (d == 19500) {
                this.e.m(i);
            }
            if (Intrinsics.areEqual(this.f.getKind(), bVar) && d != 19500 && !Intrinsics.areEqual(this.f, descriptor)) {
                return new g(this.d, this.e, d, descriptor, null, 16, null);
            }
            return new v(this.d, this.e, d, descriptor);
        }
        if (Intrinsics.areEqual(kind, e.c.a)) {
            return new f(this.d, c(), this.e, descriptor);
        }
        throw new SerializationException("This serial kind is not supported as collection: " + descriptor);
    }

    public p(hn6.a proto, t writer, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.d = proto;
        this.e = writer;
        this.f = descriptor;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufTaggedEncoder
    protected void l(long j, SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        int c = d.c(enumDescriptor, i, true);
        if (j == 19500) {
            this.e.m(c);
        } else {
            this.e.n(c, (int) (j & 2147483647L), ProtoIntegerType.DEFAULT);
        }
    }
}
