package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmprpc.reader.saas.model.k3;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
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
public final class s3 {
    public static final b Companion;
    public Integer a;
    public Integer b;
    public Integer c;
    public Integer d;
    public Integer e;
    public Integer f;
    public k3 g;

    static {
        Covode.recordClassIndex(610475);
        Companion = new b(null);
    }

    public s3() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (k3) null, 127, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<s3> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.PositionInfoV2", aVar, 7);
            g2Var.g("start_container_index", true);
            g2Var.g("start_element_index", true);
            g2Var.g("start_element_offset", true);
            g2Var.g("end_container_index", true);
            g2Var.g("end_element_index", true);
            g2Var.g("end_element_offset", true);
            g2Var.g("order_info_v2", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
            return new KSerializer[]{en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(k3.a.a)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public s3 deserialize(Decoder decoder) {
            k3 k3Var;
            Integer num;
            Integer num2;
            Integer num3;
            Integer num4;
            Integer num5;
            Integer num6;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            int i2 = 6;
            Integer num7 = null;
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
                Integer num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v0Var, null);
                Integer num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, v0Var, null);
                Integer num10 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, v0Var, null);
                Integer num11 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, v0Var, null);
                Integer num12 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, v0Var, null);
                num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, v0Var, null);
                k3Var = (k3) beginStructure.decodeNullableSerializableElement(descriptor2, 6, k3.a.a, null);
                num3 = num11;
                num2 = num12;
                num4 = num10;
                num5 = num9;
                num6 = num8;
                i = 127;
            } else {
                k3 k3Var2 = null;
                Integer num13 = null;
                Integer num14 = null;
                Integer num15 = null;
                Integer num16 = null;
                Integer num17 = null;
                int i3 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    switch (decodeElementIndex) {
                        case -1:
                            i2 = 6;
                            z = false;
                        case 0:
                            num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, num7);
                            i3 |= 1;
                            i2 = 6;
                        case 1:
                            num13 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v0.a, num13);
                            i3 |= 2;
                            i2 = 6;
                        case 2:
                            num14 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.v0.a, num14);
                            i3 |= 4;
                        case 3:
                            num15 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kotlinx.serialization.internal.v0.a, num15);
                            i3 |= 8;
                        case 4:
                            num16 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kotlinx.serialization.internal.v0.a, num16);
                            i3 |= 16;
                        case 5:
                            num17 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kotlinx.serialization.internal.v0.a, num17);
                            i3 |= 32;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            k3Var2 = (k3) beginStructure.decodeNullableSerializableElement(descriptor2, i2, k3.a.a, k3Var2);
                            i3 |= 64;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                k3Var = k3Var2;
                num = num17;
                num2 = num16;
                num3 = num15;
                num4 = num14;
                num5 = num13;
                num6 = num7;
                i = i3;
            }
            beginStructure.endStructure(descriptor2);
            return new s3(i, num6, num5, num4, num3, num2, num, k3Var, (kotlinx.serialization.internal.q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, s3 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            s3.a(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610476);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<s3> serializer() {
            return a.a;
        }
    }

    public static final /* synthetic */ void a(s3 s3Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || s3Var.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v0.a, s3Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || s3Var.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v0.a, s3Var.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || s3Var.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kotlinx.serialization.internal.v0.a, s3Var.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || s3Var.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, kotlinx.serialization.internal.v0.a, s3Var.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || s3Var.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, kotlinx.serialization.internal.v0.a, s3Var.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || s3Var.f != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, kotlinx.serialization.internal.v0.a, s3Var.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || s3Var.g != null) {
            z7 = true;
        }
        if (z7) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 6, k3.a.a, s3Var.g);
        }
    }

    public s3(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, k3 k3Var) {
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = num5;
        this.f = num6;
        this.g = k3Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ s3(java.lang.Integer r7, java.lang.Integer r8, java.lang.Integer r9, java.lang.Integer r10, java.lang.Integer r11, java.lang.Integer r12, com.dragon.read.kmprpc.reader.saas.model.k3 r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L7
            r15 = r0
            goto L8
        L7:
            r15 = r7
        L8:
            r7 = r14 & 2
            if (r7 == 0) goto Le
            r1 = r0
            goto Lf
        Le:
            r1 = r8
        Lf:
            r7 = r14 & 4
            if (r7 == 0) goto L15
            r2 = r0
            goto L16
        L15:
            r2 = r9
        L16:
            r7 = r14 & 8
            if (r7 == 0) goto L1c
            r3 = r0
            goto L1d
        L1c:
            r3 = r10
        L1d:
            r7 = r14 & 16
            if (r7 == 0) goto L23
            r4 = r0
            goto L24
        L23:
            r4 = r11
        L24:
            r7 = r14 & 32
            if (r7 == 0) goto L2a
            r5 = r0
            goto L2b
        L2a:
            r5 = r12
        L2b:
            r7 = r14 & 64
            if (r7 == 0) goto L31
            r14 = r0
            goto L32
        L31:
            r14 = r13
        L32:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmprpc.reader.saas.model.s3.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, com.dragon.read.kmprpc.reader.saas.model.k3, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public /* synthetic */ s3(int i, @SerialName("start_container_index") Integer num, @SerialName("start_element_index") Integer num2, @SerialName("start_element_offset") Integer num3, @SerialName("end_container_index") Integer num4, @SerialName("end_element_index") Integer num5, @SerialName("end_element_offset") Integer num6, @SerialName("order_info_v2") k3 k3Var, kotlinx.serialization.internal.q2 q2Var) {
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
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = num5;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = num6;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = k3Var;
        }
    }
}
