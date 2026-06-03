package dl4;

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
import kotlinx.serialization.internal.g2;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final b Companion;
    public final Boolean a;

    static {
        Covode.recordClassIndex(608070);
        Companion = new b(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this((Boolean) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608071);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<a> serializer() {
            return C0140a.a;
        }
    }

    /* renamed from: dl4.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0140a implements m0<a> {
        public static final C0140a a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        private C0140a() {
        }

        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        public KSerializer<?>[] a() {
            return m0.a.a(this);
        }

        public final KSerializer<?>[] b() {
            return new KSerializer[]{en6.a.u(kotlinx.serialization.internal.i.a)};
        }

        static {
            C0140a c0140a = new C0140a();
            a = c0140a;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.profile.data.Extra", c0140a, 1);
            g2Var.g("useLabel", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final a deserialize(Decoder decoder) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            int i = 1;
            q2 q2Var = null;
            if (beginStructure.decodeSequentially()) {
                bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.i.a, null);
            } else {
                bool = null;
                int i2 = 0;
                while (i != 0) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex == 0) {
                            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.i.a, bool);
                            i2 |= 1;
                        } else {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                    } else {
                        i = 0;
                    }
                }
                i = i2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new a(i, bool, q2Var);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, a value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            a.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public a(Boolean bool) {
        this.a = bool;
    }

    public /* synthetic */ a(int i, Boolean bool, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, C0140a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = bool;
        }
    }

    public static final /* synthetic */ void a(a aVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z = true;
        if (!dVar.shouldEncodeElementDefault(serialDescriptor, 0) && aVar.a == null) {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.i.a, aVar.a);
        }
    }

    public /* synthetic */ a(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }
}
