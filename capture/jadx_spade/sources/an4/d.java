package an4;

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
import kotlinx.serialization.internal.i;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final b Companion;
    public final String a;
    public final String b;
    public final boolean c;

    static {
        Covode.recordClassIndex(608717);
        Companion = new b(null);
    }

    public d() {
        this((String) null, (String) null, false, 7, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608718);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<d> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<d> {
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
            v2 v2Var = v2.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var), i.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.rpc.InnerPushSwitchConf", aVar, 3);
            g2Var.g("key", true);
            g2Var.g("name", true);
            g2Var.g("switch_off", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final d deserialize(Decoder decoder) {
            boolean z;
            int i;
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                v2 v2Var = v2.a;
                String str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2Var, null);
                str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2Var, null);
                z = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                str = str3;
                i = 7;
            } else {
                String str4 = null;
                String str5 = null;
                boolean z2 = false;
                int i2 = 0;
                boolean z3 = true;
                while (z3) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex == 2) {
                                    z2 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                                    i2 |= 4;
                                } else {
                                    throw new UnknownFieldException(decodeElementIndex);
                                }
                            } else {
                                str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2.a, str5);
                                i2 |= 2;
                            }
                        } else {
                            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2.a, str4);
                            i2 |= 1;
                        }
                    } else {
                        z3 = false;
                    }
                }
                z = z2;
                i = i2;
                str = str4;
                str2 = str5;
            }
            beginStructure.endStructure(serialDescriptor);
            return new d(i, str, str2, z, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, d value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            d.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public d(String str, String str2, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public static final /* synthetic */ void a(d dVar, kotlinx.serialization.encoding.d dVar2, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 0) || dVar.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar2.encodeNullableSerializableElement(serialDescriptor, 0, v2.a, dVar.a);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 1) || dVar.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar2.encodeNullableSerializableElement(serialDescriptor, 1, v2.a, dVar.b);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 2) || dVar.c) {
            z3 = true;
        }
        if (z3) {
            dVar2.encodeBooleanElement(serialDescriptor, 2, dVar.c);
        }
    }

    public /* synthetic */ d(int i, String str, String str2, boolean z, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = false;
        } else {
            this.c = z;
        }
    }

    public /* synthetic */ d(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
    }
}
