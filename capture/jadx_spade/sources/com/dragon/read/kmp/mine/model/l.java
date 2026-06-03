package com.dragon.read.kmp.mine.model;

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
import kotlinx.serialization.internal.v0;
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public static final b Companion;
    public final Integer a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Boolean f;

    static {
        Covode.recordClassIndex(607707);
        Companion = new b(null);
    }

    public l() {
        this((Integer) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 63, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.areEqual(this.a, lVar.a) && Intrinsics.areEqual(this.b, lVar.b) && Intrinsics.areEqual(this.c, lVar.c) && Intrinsics.areEqual(this.d, lVar.d) && Intrinsics.areEqual(this.e, lVar.e) && Intrinsics.areEqual(this.f, lVar.f);
    }

    public int hashCode() {
        Integer num = this.a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.f;
        return hashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "SidebarFunctionItemModel(cellType=" + this.a + ", cellName=" + this.b + ", jumpUrl=" + this.c + ", icon=" + this.d + ", darkIcon=" + this.e + ", showRedDot=" + this.f + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(607708);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<l> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<l> {
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

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.mine.model.SidebarFunctionItemModel", aVar, 6);
            g2Var.g("cell_type", true);
            g2Var.g("cell_name", true);
            g2Var.g("jump_url", true);
            g2Var.g("icon", true);
            g2Var.g("dark_icon", true);
            g2Var.g("red_dot_id", true);
            descriptor = g2Var;
        }

        public final KSerializer<?>[] b() {
            v2 v2Var = v2.a;
            return new KSerializer[]{en6.a.u(v0.a), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(kotlinx.serialization.internal.i.a)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final l deserialize(Decoder decoder) {
            String str;
            Boolean bool;
            String str2;
            String str3;
            Integer num;
            String str4;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 5;
            Integer num2 = null;
            if (beginStructure.decodeSequentially()) {
                Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v0.a, null);
                v2 v2Var = v2.a;
                String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2Var, null);
                String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2Var, null);
                String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, v2Var, null);
                String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, v2Var, null);
                num = num3;
                bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, kotlinx.serialization.internal.i.a, null);
                str3 = str7;
                str = str8;
                str2 = str6;
                str4 = str5;
                i = 63;
            } else {
                String str9 = null;
                String str10 = null;
                String str11 = null;
                String str12 = null;
                Boolean bool2 = null;
                int i3 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            i2 = 5;
                            z = false;
                            continue;
                        case 0:
                            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v0.a, num2);
                            i3 |= 1;
                            i2 = 5;
                            break;
                        case 1:
                            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2.a, str9);
                            i3 |= 2;
                            break;
                        case 2:
                            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2.a, str10);
                            i3 |= 4;
                            break;
                        case 3:
                            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, v2.a, str11);
                            i3 |= 8;
                            break;
                        case 4:
                            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, v2.a, str12);
                            i3 |= 16;
                            break;
                        case 5:
                            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, kotlinx.serialization.internal.i.a, bool2);
                            i3 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                str = str12;
                bool = bool2;
                str2 = str10;
                str3 = str11;
                num = num2;
                str4 = str9;
                i = i3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new l(i, num, str4, str2, str3, str, bool, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, l value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            l.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final /* synthetic */ void a(l lVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || lVar.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, v0.a, lVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || lVar.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, v2.a, lVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || lVar.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, v2.a, lVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || lVar.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, v2.a, lVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || lVar.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, v2.a, lVar.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || lVar.f != null) {
            z6 = true;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, kotlinx.serialization.internal.i.a, lVar.f);
        }
    }

    public l(Integer num, String str, String str2, String str3, String str4, Boolean bool) {
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = bool;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ l(java.lang.Integer r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L7
            r13 = r0
            goto L8
        L7:
            r13 = r6
        L8:
            r6 = r12 & 2
            if (r6 == 0) goto Le
            r1 = r0
            goto Lf
        Le:
            r1 = r7
        Lf:
            r6 = r12 & 4
            if (r6 == 0) goto L15
            r2 = r0
            goto L16
        L15:
            r2 = r8
        L16:
            r6 = r12 & 8
            if (r6 == 0) goto L1c
            r3 = r0
            goto L1d
        L1c:
            r3 = r9
        L1d:
            r6 = r12 & 16
            if (r6 == 0) goto L23
            r4 = r0
            goto L24
        L23:
            r4 = r10
        L24:
            r6 = r12 & 32
            if (r6 == 0) goto L2a
            r12 = r0
            goto L2b
        L2a:
            r12 = r11
        L2b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.model.l.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public /* synthetic */ l(int i, Integer num, String str, String str2, String str3, String str4, Boolean bool, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = num;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str2;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str3;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = str4;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = bool;
        }
    }
}
