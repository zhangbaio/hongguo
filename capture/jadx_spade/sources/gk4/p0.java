package gk4;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
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
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p0 {
    public static final b Companion;
    public static final int i = 0;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    static {
        Covode.recordClassIndex(607846);
        Companion = new b(null);
    }

    public p0() {
        this(false, false, false, false, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return this.a == p0Var.a && this.b == p0Var.b && this.c == p0Var.c && this.d == p0Var.d && Intrinsics.areEqual(this.e, p0Var.e) && Intrinsics.areEqual(this.f, p0Var.f) && Intrinsics.areEqual(this.g, p0Var.g) && Intrinsics.areEqual(this.h, p0Var.h);
    }

    public int hashCode() {
        int a2 = ((((((androidx.compose.animation.m.a(this.a) * 31) + androidx.compose.animation.m.a(this.b)) * 31) + androidx.compose.animation.m.a(this.c)) * 31) + androidx.compose.animation.m.a(this.d)) * 31;
        String str = this.e;
        int hashCode = (a2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.h;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "UpdateDialogInfo(autoUpdate=" + this.a + ", canUseMarketUpdate=" + this.b + ", downloaded=" + this.c + ", isForceUpdate=" + this.d + ", whatsNew=" + this.e + ", alreadyDownloadedTips=" + this.f + ", title=" + this.g + ", imageUrl=" + this.h + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(607847);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<p0> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements kotlinx.serialization.internal.m0<p0> {
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
            g2 g2Var = new g2("com.dragon.read.kmp.model.UpdateDialogInfo", aVar, 8);
            g2Var.g("autoUpdate", true);
            g2Var.g("canUseMarketUpdate", true);
            g2Var.g("downloaded", true);
            g2Var.g("isForceUpdate", true);
            g2Var.g("whatsNew", true);
            g2Var.g("alreadyDownloadedTips", true);
            g2Var.g("title", true);
            g2Var.g("imageUrl", true);
            descriptor = g2Var;
        }

        public final KSerializer<?>[] b() {
            kotlinx.serialization.internal.i iVar = kotlinx.serialization.internal.i.a;
            v2 v2Var = v2.a;
            return new KSerializer[]{iVar, iVar, iVar, iVar, en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final p0 deserialize(Decoder decoder) {
            String str;
            int i;
            String str2;
            boolean z;
            String str3;
            String str4;
            boolean z2;
            boolean z3;
            boolean z4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                boolean decodeBooleanElement4 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                v2 v2Var = v2.a;
                String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, v2Var, null);
                String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, v2Var, null);
                String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, v2Var, null);
                str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, v2Var, null);
                str4 = str7;
                str2 = str6;
                z3 = decodeBooleanElement4;
                str3 = str5;
                z4 = decodeBooleanElement3;
                z = decodeBooleanElement2;
                i = 255;
                z2 = decodeBooleanElement;
            } else {
                String str8 = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                int i2 = 0;
                boolean z9 = true;
                while (z9) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z9 = false;
                            break;
                        case 0:
                            i2 |= 1;
                            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                            continue;
                        case 1:
                            i2 |= 2;
                            z8 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                            continue;
                        case 2:
                            i2 |= 4;
                            z7 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                            continue;
                        case 3:
                            z6 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                            i2 |= 8;
                            continue;
                        case 4:
                            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, v2.a, str11);
                            i2 |= 16;
                            break;
                        case 5:
                            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, v2.a, str10);
                            i2 |= 32;
                            break;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, v2.a, str9);
                            i2 |= 64;
                            break;
                        case 7:
                            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, v2.a, str8);
                            i2 |= 128;
                            break;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                str = str8;
                i = i2;
                str2 = str10;
                z = z8;
                str3 = str11;
                str4 = str9;
                z2 = z5;
                boolean z10 = z7;
                z3 = z6;
                z4 = z10;
            }
            beginStructure.endStructure(serialDescriptor);
            return new p0(i, z2, z, z4, z3, str3, str2, str4, str, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, p0 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            p0.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final /* synthetic */ void a(p0 p0Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || p0Var.a) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeBooleanElement(serialDescriptor, 0, p0Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || p0Var.b) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeBooleanElement(serialDescriptor, 1, p0Var.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || p0Var.c) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeBooleanElement(serialDescriptor, 2, p0Var.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || p0Var.d) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeBooleanElement(serialDescriptor, 3, p0Var.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || p0Var.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, v2.a, p0Var.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || p0Var.f != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, v2.a, p0Var.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || p0Var.g != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 6, v2.a, p0Var.g);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 7) || p0Var.h != null) {
            z8 = true;
        }
        if (z8) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 7, v2.a, p0Var.h);
        }
    }

    public p0(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, String str3, String str4) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
    }

    public /* synthetic */ p0(int i2, boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, String str3, String str4, q2 q2Var) {
        if ((i2 & 0) != 0) {
            b2.b(i2, 0, a.a.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.a = false;
        } else {
            this.a = z;
        }
        if ((i2 & 2) == 0) {
            this.b = false;
        } else {
            this.b = z2;
        }
        if ((i2 & 4) == 0) {
            this.c = false;
        } else {
            this.c = z3;
        }
        if ((i2 & 8) == 0) {
            this.d = false;
        } else {
            this.d = z4;
        }
        if ((i2 & 16) == 0) {
            this.e = null;
        } else {
            this.e = str;
        }
        if ((i2 & 32) == 0) {
            this.f = null;
        } else {
            this.f = str2;
        }
        if ((i2 & 64) == 0) {
            this.g = null;
        } else {
            this.g = str3;
        }
        if ((i2 & 128) == 0) {
            this.h = null;
        } else {
            this.h = str4;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ p0(boolean r10, boolean r11, boolean r12, boolean r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r10
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 0
            goto L11
        L10:
            r3 = r11
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = 0
            goto L18
        L17:
            r4 = r12
        L18:
            r5 = r0 & 8
            if (r5 == 0) goto L1d
            goto L1e
        L1d:
            r2 = r13
        L1e:
            r5 = r0 & 16
            r6 = 0
            if (r5 == 0) goto L25
            r5 = r6
            goto L26
        L25:
            r5 = r14
        L26:
            r7 = r0 & 32
            if (r7 == 0) goto L2c
            r7 = r6
            goto L2d
        L2c:
            r7 = r15
        L2d:
            r8 = r0 & 64
            if (r8 == 0) goto L33
            r8 = r6
            goto L35
        L33:
            r8 = r16
        L35:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L3a
            goto L3c
        L3a:
            r6 = r17
        L3c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r2
            r15 = r5
            r16 = r7
            r17 = r8
            r18 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gk4.p0.<init>(boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
