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
public final class c4 {
    public static final b Companion;
    public Integer a;
    public Integer b;
    public Integer c;

    static {
        Covode.recordClassIndex(610528);
        Companion = new b(null);
    }

    public c4() {
        this((Integer) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<c4> {
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

        public KSerializer<?>[] b() {
            kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
            return new KSerializer[]{en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(v0Var)};
        }

        static {
            a aVar = new a();
            a = aVar;
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.ProgressPosInfoV2", aVar, 3);
            g2Var.g("start_container_index", true);
            g2Var.g("start_element_index", true);
            g2Var.g("start_element_offset", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public c4 deserialize(Decoder decoder) {
            int i;
            Integer num;
            Integer num2;
            Integer num3;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            Integer num4 = null;
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
                Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v0Var, null);
                Integer num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, v0Var, null);
                num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, v0Var, null);
                num2 = num6;
                num = num5;
                i = 7;
            } else {
                Integer num7 = null;
                Integer num8 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex == 2) {
                                    num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.v0.a, num8);
                                    i2 |= 4;
                                } else {
                                    throw new UnknownFieldException(decodeElementIndex);
                                }
                            } else {
                                num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v0.a, num7);
                                i2 |= 2;
                            }
                        } else {
                            num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, num4);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                num = num4;
                num2 = num7;
                num3 = num8;
            }
            beginStructure.endStructure(descriptor2);
            return new c4(i, num, num2, num3, (kotlinx.serialization.internal.q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, c4 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            c4.a(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610529);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<c4> serializer() {
            return a.a;
        }
    }

    public c4(Integer num, Integer num2, Integer num3) {
        this.a = num;
        this.b = num2;
        this.c = num3;
    }

    public static final /* synthetic */ void a(c4 c4Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || c4Var.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v0.a, c4Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || c4Var.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v0.a, c4Var.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || c4Var.c != null) {
            z3 = true;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kotlinx.serialization.internal.v0.a, c4Var.c);
        }
    }

    public /* synthetic */ c4(int i, @SerialName("start_container_index") Integer num, @SerialName("start_element_index") Integer num2, @SerialName("start_element_offset") Integer num3, kotlinx.serialization.internal.q2 q2Var) {
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
    }

    public /* synthetic */ c4(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
    }
}
