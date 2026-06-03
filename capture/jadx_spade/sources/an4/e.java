package an4;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
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
import kotlinx.serialization.internal.i;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import kotlinx.serialization.internal.v0;
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final b Companion;
    public final String a;
    public final String b;
    public final String c;
    public final Boolean d;
    public final Boolean e;
    public final Integer f;
    public final Boolean g;
    public final Integer h;
    public final Boolean i;
    public final Integer j;
    public final Boolean k;

    static {
        Covode.recordClassIndex(608719);
        Companion = new b(null);
    }

    public e() {
        this((String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, 2047, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608720);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<e> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<e> {
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
            g2 g2Var = new g2("com.dragon.read.kmp.rpc.VipInfo", aVar, 11);
            g2Var.g("is_vip", true);
            g2Var.g("expire_time", true);
            g2Var.g("left_time", true);
            g2Var.g("continue_month_buy", true);
            g2Var.g("continue_month", true);
            g2Var.g("renew_type", true);
            g2Var.g("is_union_vip", true);
            g2Var.g("union_source", true);
            g2Var.g("is_ad_vip", true);
            g2Var.g("sub_type", true);
            g2Var.g("auto_renew", true);
            descriptor = g2Var;
        }

        public final KSerializer<?>[] b() {
            v2 v2Var = v2.a;
            i iVar = i.a;
            v0 v0Var = v0.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(iVar), en6.a.u(iVar), en6.a.u(v0Var), en6.a.u(iVar), en6.a.u(v0Var), en6.a.u(iVar), en6.a.u(v0Var), en6.a.u(iVar)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final e deserialize(Decoder decoder) {
            Boolean bool;
            Integer num;
            Boolean bool2;
            String str;
            Boolean bool3;
            Boolean bool4;
            Integer num2;
            String str2;
            Boolean bool5;
            int i;
            Integer num3;
            String str3;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 10;
            String str4 = null;
            if (beginStructure.decodeSequentially()) {
                v2 v2Var = v2.a;
                String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2Var, null);
                String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2Var, null);
                String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2Var, null);
                i iVar = i.a;
                Boolean bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, iVar, null);
                Boolean bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, iVar, null);
                v0 v0Var = v0.a;
                Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, v0Var, null);
                Boolean bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, iVar, null);
                Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, v0Var, null);
                Boolean bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, iVar, null);
                Integer num6 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, v0Var, null);
                bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, iVar, null);
                num = num6;
                num3 = num5;
                bool5 = bool9;
                bool = bool7;
                str = str7;
                bool4 = bool6;
                str2 = str6;
                num2 = num4;
                str3 = str5;
                bool3 = bool8;
                i = 2047;
            } else {
                Integer num7 = null;
                Boolean bool10 = null;
                Integer num8 = null;
                Integer num9 = null;
                Boolean bool11 = null;
                Boolean bool12 = null;
                bool = null;
                Boolean bool13 = null;
                String str8 = null;
                String str9 = null;
                int i3 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            i2 = 10;
                            z = false;
                        case 0:
                            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2.a, str4);
                            i3 |= 1;
                            i2 = 10;
                        case 1:
                            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2.a, str9);
                            i3 |= 2;
                            i2 = 10;
                        case 2:
                            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2.a, str8);
                            i3 |= 4;
                            i2 = 10;
                        case 3:
                            bool13 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, i.a, bool13);
                            i3 |= 8;
                            i2 = 10;
                        case 4:
                            bool = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, i.a, bool);
                            i3 |= 16;
                            i2 = 10;
                        case 5:
                            num9 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, v0.a, num9);
                            i3 |= 32;
                            i2 = 10;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            bool12 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, i.a, bool12);
                            i3 |= 64;
                            i2 = 10;
                        case 7:
                            num8 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, v0.a, num8);
                            i3 |= 128;
                            i2 = 10;
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, i.a, bool10);
                            i3 |= 256;
                            i2 = 10;
                        case 9:
                            num7 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, v0.a, num7);
                            i3 |= MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
                            i2 = 10;
                        case 10:
                            bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, i.a, bool11);
                            i3 |= 1024;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                num = num7;
                bool2 = bool11;
                str = str8;
                bool3 = bool12;
                bool4 = bool13;
                num2 = num9;
                str2 = str9;
                bool5 = bool10;
                i = i3;
                String str10 = str4;
                num3 = num8;
                str3 = str10;
            }
            beginStructure.endStructure(serialDescriptor);
            return new e(i, str3, str2, str, bool4, bool, num2, bool3, num3, bool5, num, bool2, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, e value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            e.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final /* synthetic */ void a(e eVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || eVar.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, v2.a, eVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || eVar.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, v2.a, eVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || eVar.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, v2.a, eVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || eVar.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, i.a, eVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || eVar.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, i.a, eVar.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || eVar.f != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, v0.a, eVar.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || eVar.g != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 6, i.a, eVar.g);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 7) || eVar.h != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 7, v0.a, eVar.h);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 8) || eVar.i != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 8, i.a, eVar.i);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 9) || eVar.j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 9, v0.a, eVar.j);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 10) || eVar.k != null) {
            z11 = true;
        }
        if (z11) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 10, i.a, eVar.k);
        }
    }

    public e(String str, String str2, String str3, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Integer num3, Boolean bool5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = bool;
        this.e = bool2;
        this.f = num;
        this.g = bool3;
        this.h = num2;
        this.i = bool4;
        this.j = num3;
        this.k = bool5;
    }

    public /* synthetic */ e(int i, String str, String str2, String str3, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Integer num3, Boolean bool5, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
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
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = bool;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = bool2;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = num;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = bool3;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = num2;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = bool4;
        }
        if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
            this.j = null;
        } else {
            this.j = num3;
        }
        if ((i & 1024) == 0) {
            this.k = null;
        } else {
            this.k = bool5;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ e(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Boolean r16, java.lang.Boolean r17, java.lang.Integer r18, java.lang.Boolean r19, java.lang.Integer r20, java.lang.Boolean r21, java.lang.Integer r22, java.lang.Boolean r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = r2
            goto La
        L9:
            r1 = r13
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = r2
            goto L11
        L10:
            r3 = r14
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = r2
            goto L18
        L17:
            r4 = r15
        L18:
            r5 = r0 & 8
            if (r5 == 0) goto L1e
            r5 = r2
            goto L20
        L1e:
            r5 = r16
        L20:
            r6 = r0 & 16
            if (r6 == 0) goto L26
            r6 = r2
            goto L28
        L26:
            r6 = r17
        L28:
            r7 = r0 & 32
            if (r7 == 0) goto L2e
            r7 = r2
            goto L30
        L2e:
            r7 = r18
        L30:
            r8 = r0 & 64
            if (r8 == 0) goto L36
            r8 = r2
            goto L38
        L36:
            r8 = r19
        L38:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L3e
            r9 = r2
            goto L40
        L3e:
            r9 = r20
        L40:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L46
            r10 = r2
            goto L48
        L46:
            r10 = r21
        L48:
            r11 = r0 & 512(0x200, float:7.17E-43)
            if (r11 == 0) goto L4e
            r11 = r2
            goto L50
        L4e:
            r11 = r22
        L50:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L55
            goto L57
        L55:
            r2 = r23
        L57:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: an4.e.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
