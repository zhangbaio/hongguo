package hn6;

import com.bytedance.covode.number.Covode;
import dn6.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.c;
import kotlinx.serialization.modules.d;
import kotlinx.serialization.protobuf.internal.ProtobufDecoder;
import kotlinx.serialization.protobuf.internal.b;
import kotlinx.serialization.protobuf.internal.p;
import kotlinx.serialization.protobuf.internal.q;
import kotlinx.serialization.protobuf.internal.t;

@ExperimentalSerializationApi
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a implements k {
    public static final C0168a c;
    public final boolean a;
    private final c b;

    static {
        Covode.recordClassIndex(660103);
        c = new C0168a(null);
    }

    public /* synthetic */ a(boolean z, c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, cVar);
    }

    @Override // dn6.k
    public c getSerializersModule() {
        return this.b;
    }

    /* renamed from: hn6.a$a, reason: collision with other inner class name */
    public static final class C0168a extends a {
        static {
            Covode.recordClassIndex(660104);
        }

        public /* synthetic */ C0168a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private C0168a() {
            super(false, d.a(), null);
        }
    }

    private a(boolean z, c cVar) {
        this.a = z;
        this.b = cVar;
    }

    public <T> byte[] c(SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        b bVar = new b();
        new p(this, new t(bVar), serializer.getDescriptor()).encodeSerializableValue(serializer, t);
        return bVar.e();
    }

    public <T> T b(DeserializationStrategy<? extends T> deserializer, byte[] bytes) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return (T) new ProtobufDecoder(this, new q(new kotlinx.serialization.protobuf.internal.a(bytes, 0, 2, null)), deserializer.getDescriptor()).decodeSerializableValue(deserializer);
    }
}
