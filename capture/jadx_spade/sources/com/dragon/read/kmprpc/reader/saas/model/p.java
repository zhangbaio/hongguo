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
public final class p {
    public static final b Companion;
    public String a;
    public String b;
    public Integer c;
    public Integer d;
    public Integer e;

    static {
        Covode.recordClassIndex(609781);
        Companion = new b(null);
    }

    public p() {
        this((String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<p> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.BatchFullRequest", aVar, 5);
            g2Var.g("item_ids", true);
            g2Var.g("book_id", true);
            g2Var.g("req_type", true);
            g2Var.g("novel_text_type", true);
            g2Var.g("key_register_ts", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
            kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(v0Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public p deserialize(Decoder decoder) {
            int i;
            String str;
            String str2;
            Integer num;
            Integer num2;
            Integer num3;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            String str3 = null;
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
                String str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v2Var, null);
                String str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, v2Var, null);
                kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
                Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, v0Var, null);
                str2 = str5;
                num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, v0Var, null);
                num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, v0Var, null);
                num = num4;
                str = str4;
                i = 31;
            } else {
                String str6 = null;
                Integer num5 = null;
                Integer num6 = null;
                Integer num7 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex != 2) {
                                    if (decodeElementIndex != 3) {
                                        if (decodeElementIndex == 4) {
                                            num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kotlinx.serialization.internal.v0.a, num7);
                                            i2 |= 16;
                                        } else {
                                            throw new UnknownFieldException(decodeElementIndex);
                                        }
                                    } else {
                                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kotlinx.serialization.internal.v0.a, num6);
                                        i2 |= 8;
                                    }
                                } else {
                                    num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.v0.a, num5);
                                    i2 |= 4;
                                }
                            } else {
                                str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v2.a, str6);
                                i2 |= 2;
                            }
                        } else {
                            str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v2.a, str3);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                str = str3;
                str2 = str6;
                num = num5;
                num2 = num6;
                num3 = num7;
            }
            beginStructure.endStructure(descriptor2);
            return new p(i, str, str2, num, num2, num3, (kotlinx.serialization.internal.q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, p value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            p.a(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609782);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<p> serializer() {
            return a.a;
        }
    }

    public static final /* synthetic */ void a(p pVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || pVar.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v2.a, pVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || pVar.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v2.a, pVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || pVar.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kotlinx.serialization.internal.v0.a, pVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || pVar.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, kotlinx.serialization.internal.v0.a, pVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || pVar.e != null) {
            z5 = true;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, kotlinx.serialization.internal.v0.a, pVar.e);
        }
    }

    public p(String str, String str2, Integer num, Integer num2, Integer num3) {
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = num2;
        this.e = num3;
    }

    public /* synthetic */ p(int i, @SerialName("item_ids") String str, @SerialName("book_id") String str2, @SerialName("req_type") Integer num, @SerialName("novel_text_type") Integer num2, @SerialName("key_register_ts") Integer num3, kotlinx.serialization.internal.q2 q2Var) {
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
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = num;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = num2;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = num3;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ p(java.lang.String r5, java.lang.String r6, java.lang.Integer r7, java.lang.Integer r8, java.lang.Integer r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L7
            r11 = r0
            goto L8
        L7:
            r11 = r5
        L8:
            r5 = r10 & 2
            if (r5 == 0) goto Le
            r1 = r0
            goto Lf
        Le:
            r1 = r6
        Lf:
            r5 = r10 & 4
            if (r5 == 0) goto L15
            r2 = r0
            goto L16
        L15:
            r2 = r7
        L16:
            r5 = r10 & 8
            if (r5 == 0) goto L1c
            r3 = r0
            goto L1d
        L1c:
            r3 = r8
        L1d:
            r5 = r10 & 16
            if (r5 == 0) goto L23
            r10 = r0
            goto L24
        L23:
            r10 = r9
        L24:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmprpc.reader.saas.model.p.<init>(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
