package iq4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.l80;
import com.dragon.read.kmp.base.h;
import com.dragon.read.kmp.utils.v;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.internal.g2;
import kotlinx.serialization.internal.i;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import kotlinx.serialization.internal.v2;
import yn0.a;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final b Companion;
    public static final int i;
    public String a;
    public long b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;

    static {
        Covode.recordClassIndex(609685);
        Companion = new b(null);
        i = 8;
    }

    public d() {
        this((String) null, 0L, (String) null, (String) null, (String) null, false, false, false, 255, (DefaultConstructorMarker) null);
    }

    public final d a(String id, long j, String name, String value, String type, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        return new d(id, j, name, value, type, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.a, dVar.a) && this.b == dVar.b && Intrinsics.areEqual(this.c, dVar.c) && Intrinsics.areEqual(this.d, dVar.d) && Intrinsics.areEqual(this.e, dVar.e) && this.f == dVar.f && this.g == dVar.g && this.h == dVar.h;
    }

    public int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + j.a(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + m.a(this.f)) * 31) + m.a(this.g)) * 31) + m.a(this.h);
    }

    public String toString() {
        return "FilterItemKMP(id=" + this.a + ", cateId=" + this.b + ", name=" + this.c + ", value=" + this.d + ", type=" + this.e + ", chosen=" + this.f + ", isDefaultChosen=" + this.g + ", shown=" + this.h + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609686);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<d> serializer() {
            return a.a;
        }

        public final d a(String jsonString) {
            boolean z;
            Object m773constructorimpl;
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            v vVar = v.a;
            if (jsonString.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            Object obj = null;
            if (!z) {
                try {
                    Result.Companion companion = Result.Companion;
                    gn6.a c = h.c();
                    c.getSerializersModule();
                    m773constructorimpl = Result.m773constructorimpl(c.c(d.Companion.serializer(), jsonString));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
                if (m776exceptionOrNullimpl != null) {
                    a.a.b(yn0.b.b, "JSONUtils", "fromJson json error " + m776exceptionOrNullimpl.getMessage(), false, 4, (Object) null);
                }
                if (!Result.m779isFailureimpl(m773constructorimpl)) {
                    obj = m773constructorimpl;
                }
            }
            d dVar = (d) obj;
            if (dVar == null) {
                return new d((String) null, 0L, (String) null, (String) null, (String) null, false, false, false, 255, (DefaultConstructorMarker) null);
            }
            return dVar;
        }
    }

    public final String getType() {
        return this.e;
    }

    public /* synthetic */ class a implements m0<d> {
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
            i iVar = i.a;
            return new KSerializer[]{v2Var, g1.a, v2Var, v2Var, v2Var, iVar, iVar, iVar};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.widget.filter.FilterItemKMP", aVar, 8);
            g2Var.g("id", true);
            g2Var.g("cateId", true);
            g2Var.g("name", true);
            g2Var.g("value", true);
            g2Var.g("type", true);
            g2Var.g("chosen", true);
            g2Var.g("isDefaultChosen", true);
            g2Var.g("shown", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final d deserialize(Decoder decoder) {
            boolean z;
            boolean z2;
            String str;
            int i;
            boolean z3;
            String str2;
            String str3;
            String str4;
            long j;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 0;
            if (beginStructure.decodeSequentially()) {
                String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
                long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
                String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
                String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
                String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 4);
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
                i = 255;
                str = decodeStringElement;
                z = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                z2 = decodeBooleanElement2;
                z3 = decodeBooleanElement;
                str4 = decodeStringElement3;
                str2 = decodeStringElement4;
                str3 = decodeStringElement2;
                j = decodeLongElement;
            } else {
                String str5 = null;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                long j2 = 0;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = true;
                while (z7) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z7 = false;
                            break;
                        case 0:
                            i2 |= 1;
                            str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                            continue;
                        case 1:
                            j2 = beginStructure.decodeLongElement(serialDescriptor, 1);
                            i2 |= 2;
                            continue;
                        case 2:
                            str8 = beginStructure.decodeStringElement(serialDescriptor, 2);
                            i2 |= 4;
                            break;
                        case 3:
                            str6 = beginStructure.decodeStringElement(serialDescriptor, 3);
                            i2 |= 8;
                            break;
                        case 4:
                            str7 = beginStructure.decodeStringElement(serialDescriptor, 4);
                            i2 |= 16;
                            break;
                        case 5:
                            z6 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                            i2 |= 32;
                            break;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
                            i2 |= 64;
                            break;
                        case 7:
                            z4 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                            i2 |= 128;
                            break;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                z = z4;
                z2 = z5;
                str = str5;
                i = i2;
                long j3 = j2;
                z3 = z6;
                str2 = str7;
                str3 = str8;
                str4 = str6;
                j = j3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new d(i, str, j, str3, str4, str2, z3, z2, z, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, d value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            d.c(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String type, l80 l80Var) {
        this((String) null, 0L, (String) null, (String) null, (String) null, false, false, false, 255, (DefaultConstructorMarker) null);
        long j;
        boolean z;
        Boolean bool;
        Boolean bool2;
        String str;
        String str2;
        Long l;
        String str3;
        Intrinsics.checkNotNullParameter(type, "type");
        String str4 = "";
        this.a = (l80Var == null || (str3 = l80Var.b) == null) ? "" : str3;
        if (l80Var != null && (l = l80Var.e) != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        this.b = j;
        this.c = (l80Var == null || (str2 = l80Var.a) == null) ? "" : str2;
        if (l80Var != null && (str = l80Var.d) != null) {
            str4 = str;
        }
        this.d = str4;
        boolean z2 = false;
        if (l80Var != null && (bool2 = l80Var.c) != null) {
            z = bool2.booleanValue();
        } else {
            z = false;
        }
        this.f = z;
        if (l80Var != null && (bool = l80Var.c) != null) {
            z2 = bool.booleanValue();
        }
        this.g = z2;
        this.e = type;
    }

    public static final /* synthetic */ void c(d dVar, kotlinx.serialization.encoding.d dVar2, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(dVar.a, "")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar2.encodeStringElement(serialDescriptor, 0, dVar.a);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 1) || dVar.b != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar2.encodeLongElement(serialDescriptor, 1, dVar.b);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(dVar.c, "")) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar2.encodeStringElement(serialDescriptor, 2, dVar.c);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 3) || !Intrinsics.areEqual(dVar.d, "")) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar2.encodeStringElement(serialDescriptor, 3, dVar.d);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual(dVar.e, "")) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar2.encodeStringElement(serialDescriptor, 4, dVar.e);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 5) || dVar.f) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar2.encodeBooleanElement(serialDescriptor, 5, dVar.f);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 6) || dVar.g) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            dVar2.encodeBooleanElement(serialDescriptor, 6, dVar.g);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 7) || dVar.h) {
            z8 = true;
        }
        if (z8) {
            dVar2.encodeBooleanElement(serialDescriptor, 7, dVar.h);
        }
    }

    public d(String id, long j, String name, String value, String type, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = id;
        this.b = j;
        this.c = name;
        this.d = value;
        this.e = type;
        this.f = z;
        this.g = z2;
        this.h = z3;
    }

    public /* synthetic */ d(int i2, String str, long j, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, q2 q2Var) {
        if ((i2 & 0) != 0) {
            b2.b(i2, 0, a.a.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.a = "";
        } else {
            this.a = str;
        }
        if ((i2 & 2) == 0) {
            this.b = 0L;
        } else {
            this.b = j;
        }
        if ((i2 & 4) == 0) {
            this.c = "";
        } else {
            this.c = str2;
        }
        if ((i2 & 8) == 0) {
            this.d = "";
        } else {
            this.d = str3;
        }
        if ((i2 & 16) == 0) {
            this.e = "";
        } else {
            this.e = str4;
        }
        if ((i2 & 32) == 0) {
            this.f = false;
        } else {
            this.f = z;
        }
        if ((i2 & 64) == 0) {
            this.g = false;
        } else {
            this.g = z2;
        }
        if ((i2 & 128) == 0) {
            this.h = false;
        } else {
            this.h = z3;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ d(java.lang.String r11, long r12, java.lang.String r14, java.lang.String r15, java.lang.String r16, boolean r17, boolean r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto La
            r1 = r2
            goto Lb
        La:
            r1 = r11
        Lb:
            r3 = r0 & 2
            if (r3 == 0) goto L12
            r3 = 0
            goto L13
        L12:
            r3 = r12
        L13:
            r5 = r0 & 4
            if (r5 == 0) goto L19
            r5 = r2
            goto L1a
        L19:
            r5 = r14
        L1a:
            r6 = r0 & 8
            if (r6 == 0) goto L20
            r6 = r2
            goto L21
        L20:
            r6 = r15
        L21:
            r7 = r0 & 16
            if (r7 == 0) goto L26
            goto L28
        L26:
            r2 = r16
        L28:
            r7 = r0 & 32
            r8 = 0
            if (r7 == 0) goto L2f
            r7 = 0
            goto L31
        L2f:
            r7 = r17
        L31:
            r9 = r0 & 64
            if (r9 == 0) goto L37
            r9 = 0
            goto L39
        L37:
            r9 = r18
        L39:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L3e
            goto L40
        L3e:
            r8 = r19
        L40:
            r11 = r10
            r12 = r1
            r13 = r3
            r15 = r5
            r16 = r6
            r17 = r2
            r18 = r7
            r19 = r9
            r20 = r8
            r11.<init>(r12, r13, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: iq4.d.<init>(java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
