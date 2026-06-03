package fl4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.internal.g2;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class s {
    public static final b Companion;
    public final long a;

    static {
        Covode.recordClassIndex(608099);
        Companion = new b(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && this.a == ((s) obj).a;
    }

    public int hashCode() {
        return j.a(this.a);
    }

    public String toString() {
        return "WatchRecord(time=" + this.a + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608100);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<s> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<s> {
        public static final a a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        private a() {
        }

        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        public KSerializer<?>[] a() {
            return m0.a.a(this);
        }

        public final KSerializer<?>[] b() {
            return new KSerializer[]{g1.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.profile.follow.WatchRecord", aVar, 1);
            g2Var.g("time", false);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final s deserialize(Decoder decoder) {
            long j;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            int i = 1;
            if (beginStructure.decodeSequentially()) {
                j = beginStructure.decodeLongElement(serialDescriptor, 0);
            } else {
                long j2 = 0;
                int i2 = 0;
                while (i != 0) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex == 0) {
                            j2 = beginStructure.decodeLongElement(serialDescriptor, 0);
                            i2 |= 1;
                        } else {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                    } else {
                        i = 0;
                    }
                }
                i = i2;
                j = j2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new s(i, j, null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, s value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            s.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public s(long j) {
        this.a = j;
    }

    public static final /* synthetic */ void a(s sVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        dVar.encodeLongElement(serialDescriptor, 0, sVar.a);
    }

    public /* synthetic */ s(int i, long j, q2 q2Var) {
        if (1 != (i & 1)) {
            b2.b(i, 1, a.a.getDescriptor());
        }
        this.a = j;
    }
}
