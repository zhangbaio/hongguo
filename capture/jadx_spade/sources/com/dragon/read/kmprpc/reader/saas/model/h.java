package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmprpc.reader.saas.model.r3;
import com.dragon.read.kmprpc.reader.saas.model.s3;
import java.util.List;
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
public final class h {
    public static final b Companion;
    private static final KSerializer<Object>[] f;
    public Integer a;
    public r3 b;
    public String c;
    public List<Long> d;
    public s3 e;

    public h() {
        this((Integer) null, (r3) null, (String) null, (List) null, (s3) null, 31, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<h> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.AnnotationDescription", aVar, 5);
            g2Var.g("annotation_type", true);
            g2Var.g("pos_info_v1", true);
            g2Var.g("quote_content", true);
            g2Var.g("reference_book_ids", true);
            g2Var.g("pos_info_v2", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            return new KSerializer[]{en6.a.u(kotlinx.serialization.internal.v0.a), en6.a.u(r3.a.a), en6.a.u(kotlinx.serialization.internal.v2.a), en6.a.u(h.f[3]), en6.a.u(s3.a.a)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public h deserialize(Decoder decoder) {
            int i;
            Integer num;
            r3 r3Var;
            String str;
            List list;
            s3 s3Var;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            KSerializer[] kSerializerArr = h.f;
            Integer num2 = null;
            if (beginStructure.decodeSequentially()) {
                Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, null);
                r3 r3Var2 = (r3) beginStructure.decodeNullableSerializableElement(descriptor2, 1, r3.a.a, null);
                String str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.v2.a, null);
                list = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], null);
                num = num3;
                s3Var = (s3) beginStructure.decodeNullableSerializableElement(descriptor2, 4, s3.a.a, null);
                str = str2;
                r3Var = r3Var2;
                i = 31;
            } else {
                r3 r3Var3 = null;
                String str3 = null;
                List list2 = null;
                s3 s3Var2 = null;
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
                                            s3Var2 = (s3) beginStructure.decodeNullableSerializableElement(descriptor2, 4, s3.a.a, s3Var2);
                                            i2 |= 16;
                                        } else {
                                            throw new UnknownFieldException(decodeElementIndex);
                                        }
                                    } else {
                                        list2 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], list2);
                                        i2 |= 8;
                                    }
                                } else {
                                    str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.v2.a, str3);
                                    i2 |= 4;
                                }
                            } else {
                                r3Var3 = (r3) beginStructure.decodeNullableSerializableElement(descriptor2, 1, r3.a.a, r3Var3);
                                i2 |= 2;
                            }
                        } else {
                            num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, num2);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                num = num2;
                r3Var = r3Var3;
                str = str3;
                list = list2;
                s3Var = s3Var2;
            }
            beginStructure.endStructure(descriptor2);
            return new h(i, num, r3Var, str, list, s3Var, (kotlinx.serialization.internal.q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, h value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            h.b(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609746);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<h> serializer() {
            return a.a;
        }
    }

    static {
        Covode.recordClassIndex(609745);
        Companion = new b(null);
        f = new KSerializer[]{null, null, null, new kotlinx.serialization.internal.f(kotlinx.serialization.internal.g1.a), null};
    }

    public static final /* synthetic */ void b(h hVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        KSerializer<Object>[] kSerializerArr = f;
        boolean z5 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || hVar.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v0.a, hVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || hVar.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, r3.a.a, hVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || hVar.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kotlinx.serialization.internal.v2.a, hVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || hVar.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], hVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || hVar.e != null) {
            z5 = true;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, s3.a.a, hVar.e);
        }
    }

    public h(Integer num, r3 r3Var, String str, List<Long> list, s3 s3Var) {
        this.a = num;
        this.b = r3Var;
        this.c = str;
        this.d = list;
        this.e = s3Var;
    }

    public /* synthetic */ h(int i, @SerialName("annotation_type") Integer num, @SerialName("pos_info_v1") r3 r3Var, @SerialName("quote_content") String str, @SerialName("reference_book_ids") List list, @SerialName("pos_info_v2") s3 s3Var, kotlinx.serialization.internal.q2 q2Var) {
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
            this.b = r3Var;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = list;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = s3Var;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ h(java.lang.Integer r5, com.dragon.read.kmprpc.reader.saas.model.r3 r6, java.lang.String r7, java.util.List r8, com.dragon.read.kmprpc.reader.saas.model.s3 r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmprpc.reader.saas.model.h.<init>(java.lang.Integer, com.dragon.read.kmprpc.reader.saas.model.r3, java.lang.String, java.util.List, com.dragon.read.kmprpc.reader.saas.model.s3, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
