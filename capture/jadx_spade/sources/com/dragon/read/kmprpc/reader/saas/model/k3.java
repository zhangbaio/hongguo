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
public final class k3 {
    public static final b Companion;
    public Integer a;
    public Integer b;

    static {
        Covode.recordClassIndex(610433);
        Companion = new b(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k3() {
        this((Integer) null, (Integer) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static final class a implements kotlinx.serialization.internal.m0<k3> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.OrderInfo", aVar, 2);
            g2Var.g("start_element_order", true);
            g2Var.g("end_element_order", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
            return new KSerializer[]{en6.a.u(v0Var), en6.a.u(v0Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public k3 deserialize(Decoder decoder) {
            Integer num;
            int i;
            Integer num2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            kotlinx.serialization.internal.q2 q2Var = null;
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
                num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v0Var, null);
                num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, v0Var, null);
                i = 3;
            } else {
                num = null;
                Integer num3 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex == 1) {
                                num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v0.a, num);
                                i2 |= 2;
                            } else {
                                throw new UnknownFieldException(decodeElementIndex);
                            }
                        } else {
                            num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, num3);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                num2 = num3;
            }
            beginStructure.endStructure(descriptor2);
            return new k3(i, num2, num, q2Var);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, k3 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            k3.a(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610434);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<k3> serializer() {
            return a.a;
        }
    }

    public k3(Integer num, Integer num2) {
        this.a = num;
        this.b = num2;
    }

    public static final /* synthetic */ void a(k3 k3Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || k3Var.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v0.a, k3Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || k3Var.b != null) {
            z2 = true;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v0.a, k3Var.b);
        }
    }

    public /* synthetic */ k3(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public /* synthetic */ k3(int i, @SerialName("start_element_order") Integer num, @SerialName("end_element_order") Integer num2, kotlinx.serialization.internal.q2 q2Var) {
        if ((i & 0) != 0) {
            kotlinx.serialization.internal.b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = num;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = num2;
        }
    }
}
