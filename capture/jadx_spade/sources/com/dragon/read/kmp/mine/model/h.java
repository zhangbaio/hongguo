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
public final class h {
    public static final b Companion;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;

    static {
        Covode.recordClassIndex(607701);
        Companion = new b(null);
    }

    public h() {
        this((String) null, (String) null, (String) null, (String) null, 0, 0, 63, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.a, hVar.a) && Intrinsics.areEqual(this.b, hVar.b) && Intrinsics.areEqual(this.c, hVar.c) && Intrinsics.areEqual(this.d, hVar.d) && this.e == hVar.e && this.f == hVar.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
    }

    public String toString() {
        return "LoginPhoneCodeInfo(phoneCode=" + this.a + ", countryName=" + this.b + ", starChar=" + this.c + ", countryCode=" + this.d + ", minPhoneNumCount=" + this.e + ", maxPhoneNumCount=" + this.f + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(607702);
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

    public /* synthetic */ class a implements m0<h> {
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
            v0 v0Var = v0.a;
            return new KSerializer[]{v2Var, v2Var, v2Var, v2Var, v0Var, v0Var};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.mine.model.LoginPhoneCodeInfo", aVar, 6);
            g2Var.g("phone_code", true);
            g2Var.g("country_name", true);
            g2Var.g("start_char", true);
            g2Var.g("country_code_iso3", true);
            g2Var.g("min_phone_number_count", true);
            g2Var.g("max_phone_number_count", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final h deserialize(Decoder decoder) {
            int i;
            int i2;
            String str;
            String str2;
            int i3;
            String str3;
            String str4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
                String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
                String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
                String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
                int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 4);
                str = decodeStringElement;
                i = beginStructure.decodeIntElement(serialDescriptor, 5);
                str2 = decodeStringElement4;
                i2 = decodeIntElement;
                str3 = decodeStringElement3;
                str4 = decodeStringElement2;
                i3 = 63;
            } else {
                String str5 = null;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z = false;
                            continue;
                        case 0:
                            str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                            i6 |= 1;
                            continue;
                        case 1:
                            str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                            i6 |= 2;
                            break;
                        case 2:
                            str7 = beginStructure.decodeStringElement(serialDescriptor, 2);
                            i6 |= 4;
                            break;
                        case 3:
                            str6 = beginStructure.decodeStringElement(serialDescriptor, 3);
                            i6 |= 8;
                            break;
                        case 4:
                            i5 = beginStructure.decodeIntElement(serialDescriptor, 4);
                            i6 |= 16;
                            break;
                        case 5:
                            i4 = beginStructure.decodeIntElement(serialDescriptor, 5);
                            i6 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                i = i4;
                i2 = i5;
                str = str5;
                int i7 = i6;
                str2 = str6;
                i3 = i7;
                String str9 = str8;
                str3 = str7;
                str4 = str9;
            }
            beginStructure.endStructure(serialDescriptor);
            return new h(i3, str, str4, str3, str2, i2, i, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, h value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            h.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final /* synthetic */ void a(h hVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(hVar.a, "")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeStringElement(serialDescriptor, 0, hVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(hVar.b, "")) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeStringElement(serialDescriptor, 1, hVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(hVar.c, "")) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeStringElement(serialDescriptor, 2, hVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || !Intrinsics.areEqual(hVar.d, "")) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeStringElement(serialDescriptor, 3, hVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || hVar.e != 11) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeIntElement(serialDescriptor, 4, hVar.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || hVar.f != 11) {
            z6 = true;
        }
        if (z6) {
            dVar.encodeIntElement(serialDescriptor, 5, hVar.f);
        }
    }

    public h(String phoneCode, String countryName, String starChar, String countryCode, int i, int i2) {
        Intrinsics.checkNotNullParameter(phoneCode, "phoneCode");
        Intrinsics.checkNotNullParameter(countryName, "countryName");
        Intrinsics.checkNotNullParameter(starChar, "starChar");
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        this.a = phoneCode;
        this.b = countryName;
        this.c = starChar;
        this.d = countryCode;
        this.e = i;
        this.f = i2;
    }

    public /* synthetic */ h(int i, String str, String str2, String str3, String str4, int i2, int i3, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = "";
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = "";
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = "";
        } else {
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = "";
        } else {
            this.d = str4;
        }
        if ((i & 16) == 0) {
            this.e = 11;
        } else {
            this.e = i2;
        }
        if ((i & 32) == 0) {
            this.f = 11;
        } else {
            this.f = i3;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ h(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, int r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            java.lang.String r0 = ""
            if (r12 == 0) goto L8
            r12 = r0
            goto L9
        L8:
            r12 = r5
        L9:
            r5 = r11 & 2
            if (r5 == 0) goto Lf
            r1 = r0
            goto L10
        Lf:
            r1 = r6
        L10:
            r5 = r11 & 4
            if (r5 == 0) goto L16
            r2 = r0
            goto L17
        L16:
            r2 = r7
        L17:
            r5 = r11 & 8
            if (r5 == 0) goto L1c
            goto L1d
        L1c:
            r0 = r8
        L1d:
            r5 = r11 & 16
            r6 = 11
            if (r5 == 0) goto L26
            r3 = 11
            goto L27
        L26:
            r3 = r9
        L27:
            r5 = r11 & 32
            if (r5 == 0) goto L2e
            r11 = 11
            goto L2f
        L2e:
            r11 = r10
        L2f:
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r0
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.mine.model.h.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
