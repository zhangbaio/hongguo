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
public final class r3 {
    public static final b Companion;
    public Integer a;
    public Integer b;
    public Integer c;
    public Integer d;

    static {
        Covode.recordClassIndex(610473);
        Companion = new b(null);
    }

    public r3() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, 15, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<r3> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.PositionInfoV1", aVar, 4);
            g2Var.g("start_para_index", true);
            g2Var.g("end_para_index", true);
            g2Var.g("start_word_pos", true);
            g2Var.g("end_word_pos", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
            return new KSerializer[]{en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(v0Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public r3 deserialize(Decoder decoder) {
            int i;
            Integer num;
            Integer num2;
            Integer num3;
            Integer num4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            Integer num5 = null;
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
                Integer num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v0Var, null);
                Integer num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, v0Var, null);
                Integer num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, v0Var, null);
                num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, v0Var, null);
                num3 = num8;
                num2 = num7;
                num = num6;
                i = 15;
            } else {
                Integer num9 = null;
                Integer num10 = null;
                Integer num11 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex != 2) {
                                    if (decodeElementIndex == 3) {
                                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kotlinx.serialization.internal.v0.a, num11);
                                        i2 |= 8;
                                    } else {
                                        throw new UnknownFieldException(decodeElementIndex);
                                    }
                                } else {
                                    num10 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.v0.a, num10);
                                    i2 |= 4;
                                }
                            } else {
                                num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v0.a, num9);
                                i2 |= 2;
                            }
                        } else {
                            num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, num5);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                num = num5;
                num2 = num9;
                num3 = num10;
                num4 = num11;
            }
            beginStructure.endStructure(descriptor2);
            return new r3(i, num, num2, num3, num4, (kotlinx.serialization.internal.q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, r3 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            r3.a(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610474);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<r3> serializer() {
            return a.a;
        }
    }

    public static final /* synthetic */ void a(r3 r3Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || r3Var.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v0.a, r3Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || r3Var.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v0.a, r3Var.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || r3Var.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kotlinx.serialization.internal.v0.a, r3Var.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || r3Var.d != null) {
            z4 = true;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, kotlinx.serialization.internal.v0.a, r3Var.d);
        }
    }

    public r3(Integer num, Integer num2, Integer num3, Integer num4) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
    }

    public /* synthetic */ r3(int i, @SerialName("start_para_index") Integer num, @SerialName("end_para_index") Integer num2, @SerialName("start_word_pos") Integer num3, @SerialName("end_word_pos") Integer num4, kotlinx.serialization.internal.q2 q2Var) {
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
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = num3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = num4;
        }
    }

    public /* synthetic */ r3(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }
}
