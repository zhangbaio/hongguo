package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.m0;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b2 {
    public static final b Companion;
    public String a;
    public Boolean b;

    static {
        Covode.recordClassIndex(610194);
        Companion = new b(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b2() {
        this((String) null, (Boolean) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static final class a implements kotlinx.serialization.internal.m0<b2> {
        public static final a a;
        private static final /* synthetic */ kotlinx.serialization.internal.g2 descriptor;

        private a() {
        }

        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        public KSerializer<?>[] a() {
            return m0.a.a(this);
        }

        static {
            a aVar = new a();
            a = aVar;
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.GetReaderFontTypesRequest", aVar, 2);
            g2Var.g("font_order_key", true);
            g2Var.g("require_variable_fonts", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            return new KSerializer[]{en6.a.u(kotlinx.serialization.internal.v2.a), en6.a.u(kotlinx.serialization.internal.i.a)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b2 deserialize(Decoder decoder) {
            String str;
            Boolean bool;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            kotlinx.serialization.internal.q2 q2Var = null;
            if (beginStructure.decodeSequentially()) {
                str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v2.a, null);
                bool = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.i.a, null);
                i = 3;
            } else {
                str = null;
                Boolean bool2 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex == 1) {
                                bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.i.a, bool2);
                                i2 |= 2;
                            } else {
                                throw new UnknownFieldException(decodeElementIndex);
                            }
                        } else {
                            str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v2.a, str);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                bool = bool2;
                i = i2;
            }
            beginStructure.endStructure(descriptor2);
            return new b2(i, str, bool, q2Var);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, b2 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            b2.a(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610195);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<b2> serializer() {
            return a.a;
        }
    }

    public b2(String str, Boolean bool) {
        this.a = str;
        this.b = bool;
    }

    public static final /* synthetic */ void a(b2 b2Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || b2Var.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v2.a, b2Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || b2Var.b != null) {
            z2 = true;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.i.a, b2Var.b);
        }
    }

    public /* synthetic */ b2(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool);
    }

    public /* synthetic */ b2(int i, @SerialName("font_order_key") String str, @SerialName("require_variable_fonts") Boolean bool, kotlinx.serialization.internal.q2 q2Var) {
        if ((i & 0) != 0) {
            kotlinx.serialization.internal.b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = bool;
        }
    }
}
