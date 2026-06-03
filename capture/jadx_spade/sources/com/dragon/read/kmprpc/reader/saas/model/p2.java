package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmprpc.reader.saas.model.h;
import com.dragon.read.kmprpc.reader.saas.model.j;
import com.dragon.read.kmprpc.reader.saas.model.r;
import com.ss.ttm.player.MediaPlayer;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import java.util.Map;
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
public final class p2 {
    public static final b Companion;
    private static final KSerializer<Object>[] q;
    public String a;
    public j b;
    public Short c;
    public Integer d;
    public String e;
    public Short f;
    public String g;
    public r h;
    public String i;
    public Integer j;
    public Integer k;
    public Short l;
    public Map<Integer, ? extends List<h>> m;
    public Short n;
    public Short o;
    public Integer p;

    public p2() {
        this((String) null, (j) null, (Short) null, (Integer) null, (String) null, (Short) null, (String) null, (r) null, (String) null, (Integer) null, (Integer) null, (Short) null, (Map) null, (Short) null, (Short) null, (Integer) null, 65535, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<p2> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.ItemContent", aVar, 16);
            g2Var.g("content", true);
            g2Var.g("novel_data", true);
            g2Var.g("crypt_status", true);
            g2Var.g("key_version", true);
            g2Var.g("title", true);
            g2Var.g("code", true);
            g2Var.g("author_speak", true);
            g2Var.g("block_data", true);
            g2Var.g("origin_content", true);
            g2Var.g("text_type", true);
            g2Var.g("parse_mode", true);
            g2Var.g("compress_status", true);
            g2Var.g("annotation_descriptions", true);
            g2Var.g("paragraphs_num", true);
            g2Var.g("free_para_nums", true);
            g2Var.g("code_i32", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            KSerializer[] kSerializerArr = p2.q;
            kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
            kotlinx.serialization.internal.u2 u2Var = kotlinx.serialization.internal.u2.a;
            kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(j.a.a), en6.a.u(u2Var), en6.a.u(v0Var), en6.a.u(v2Var), en6.a.u(u2Var), en6.a.u(v2Var), en6.a.u(r.a.a), en6.a.u(v2Var), en6.a.u(v0Var), en6.a.u(v0Var), en6.a.u(u2Var), en6.a.u(kSerializerArr[12]), en6.a.u(u2Var), en6.a.u(u2Var), en6.a.u(v0Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public p2 deserialize(Decoder decoder) {
            Integer num;
            Short sh;
            Short sh2;
            Integer num2;
            Integer num3;
            r rVar;
            String str;
            String str2;
            Short sh3;
            Map map;
            Integer num4;
            Short sh4;
            String str3;
            j jVar;
            String str4;
            int i;
            Short sh5;
            String str5;
            j jVar2;
            int i2;
            KSerializer[] kSerializerArr;
            int i3;
            j jVar3;
            KSerializer[] kSerializerArr2;
            Short sh6;
            Integer num5;
            int i4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            KSerializer[] kSerializerArr3 = p2.q;
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
                String str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v2Var, null);
                j jVar4 = (j) beginStructure.decodeNullableSerializableElement(descriptor2, 1, j.a.a, null);
                kotlinx.serialization.internal.u2 u2Var = kotlinx.serialization.internal.u2.a;
                Short sh7 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 2, u2Var, null);
                kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
                Integer num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, v0Var, null);
                str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, v2Var, null);
                Short sh8 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 5, u2Var, null);
                String str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, v2Var, null);
                r rVar2 = (r) beginStructure.decodeNullableSerializableElement(descriptor2, 7, r.a.a, null);
                String str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, v2Var, null);
                Integer num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, v0Var, null);
                Integer num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 10, v0Var, null);
                Short sh9 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 11, u2Var, null);
                Map map2 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 12, kSerializerArr3[12], null);
                Short sh10 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 13, u2Var, null);
                sh3 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 14, u2Var, null);
                sh2 = sh9;
                num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 15, v0Var, null);
                sh = sh10;
                sh5 = sh8;
                map = map2;
                str = str8;
                jVar = jVar4;
                str4 = str7;
                str3 = str6;
                num2 = num8;
                rVar = rVar2;
                num3 = num7;
                i = 65535;
                num = num6;
                sh4 = sh7;
            } else {
                j jVar5 = null;
                String str9 = null;
                String str10 = null;
                Short sh11 = null;
                Integer num9 = null;
                Short sh12 = null;
                Short sh13 = null;
                Integer num10 = null;
                Integer num11 = null;
                r rVar3 = null;
                num = null;
                String str11 = null;
                Map map3 = null;
                Short sh14 = null;
                Short sh15 = null;
                String str12 = null;
                int i5 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    switch (decodeElementIndex) {
                        case -1:
                            str5 = str9;
                            jVar2 = jVar5;
                            i2 = i5;
                            kSerializerArr3 = kSerializerArr3;
                            sh12 = sh12;
                            z = false;
                            i5 = i2;
                            jVar5 = jVar2;
                            str9 = str5;
                        case 0:
                            kSerializerArr = kSerializerArr3;
                            String str13 = str9;
                            j jVar6 = jVar5;
                            str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v2.a, str12);
                            i3 = i5 | 1;
                            jVar5 = jVar6;
                            str9 = str13;
                            num9 = num9;
                            sh12 = sh12;
                            i5 = i3;
                            kSerializerArr3 = kSerializerArr;
                        case 1:
                            str5 = str9;
                            j jVar7 = jVar5;
                            jVar2 = (j) beginStructure.decodeNullableSerializableElement(descriptor2, 1, j.a.a, jVar7);
                            i2 = i5 | 2;
                            kSerializerArr3 = kSerializerArr3;
                            num9 = num9;
                            sh12 = sh12;
                            i5 = i2;
                            jVar5 = jVar2;
                            str9 = str5;
                        case 2:
                            KSerializer[] kSerializerArr4 = kSerializerArr3;
                            jVar3 = jVar5;
                            int i6 = i5;
                            str9 = str9;
                            num9 = num9;
                            sh12 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.u2.a, sh12);
                            i5 = i6 | 4;
                            kSerializerArr3 = kSerializerArr4;
                            jVar5 = jVar3;
                        case 3:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i7 = i5;
                            num5 = num9;
                            num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kotlinx.serialization.internal.v0.a, num);
                            i4 = i7 | 8;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case 4:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i8 = i5;
                            num5 = num9;
                            str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kotlinx.serialization.internal.v2.a, str9);
                            i4 = i8 | 16;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case 5:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i9 = i5;
                            num5 = num9;
                            sh11 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kotlinx.serialization.internal.u2.a, sh11);
                            i4 = i9 | 32;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i10 = i5;
                            num5 = num9;
                            str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kotlinx.serialization.internal.v2.a, str10);
                            i4 = i10 | 64;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case 7:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i11 = i5;
                            num5 = num9;
                            rVar3 = (r) beginStructure.decodeNullableSerializableElement(descriptor2, 7, r.a.a, rVar3);
                            i4 = i11 | 128;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i12 = i5;
                            num5 = num9;
                            str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kotlinx.serialization.internal.v2.a, str11);
                            i4 = i12 | 256;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case 9:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i13 = i5;
                            num5 = num9;
                            num11 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, kotlinx.serialization.internal.v0.a, num11);
                            i4 = i13 | MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case 10:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i14 = i5;
                            num5 = num9;
                            num10 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 10, kotlinx.serialization.internal.v0.a, num10);
                            i4 = i14 | 1024;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case 11:
                            kSerializerArr2 = kSerializerArr3;
                            jVar3 = jVar5;
                            sh6 = sh12;
                            int i15 = i5;
                            num5 = num9;
                            sh13 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 11, kotlinx.serialization.internal.u2.a, sh13);
                            i4 = i15 | 2048;
                            sh12 = sh6;
                            kSerializerArr3 = kSerializerArr2;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                            j jVar8 = jVar5;
                            int i16 = i5;
                            kSerializerArr = kSerializerArr3;
                            map3 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 12, kSerializerArr3[12], map3);
                            i3 = i16 | 4096;
                            sh12 = sh12;
                            num9 = num9;
                            jVar5 = jVar8;
                            i5 = i3;
                            kSerializerArr3 = kSerializerArr;
                        case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                            jVar3 = jVar5;
                            int i17 = i5;
                            num5 = num9;
                            sh14 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 13, kotlinx.serialization.internal.u2.a, sh14);
                            i4 = i17 | 8192;
                            sh12 = sh12;
                            sh15 = sh15;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case 14:
                            jVar3 = jVar5;
                            int i18 = i5;
                            num5 = num9;
                            sh15 = (Short) beginStructure.decodeNullableSerializableElement(descriptor2, 14, kotlinx.serialization.internal.u2.a, sh15);
                            i4 = i18 | 16384;
                            sh12 = sh12;
                            num9 = num5;
                            i5 = i4;
                            jVar5 = jVar3;
                        case 15:
                            num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 15, kotlinx.serialization.internal.v0.a, num9);
                            i5 |= 32768;
                            jVar5 = jVar5;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                String str14 = str9;
                sh = sh14;
                sh2 = sh13;
                num2 = num10;
                num3 = num11;
                rVar = rVar3;
                str = str11;
                str2 = str14;
                sh3 = sh15;
                map = map3;
                num4 = num9;
                sh4 = sh12;
                str3 = str12;
                jVar = jVar5;
                str4 = str10;
                i = i5;
                sh5 = sh11;
            }
            beginStructure.endStructure(descriptor2);
            return new p2(i, str3, jVar, sh4, num, str2, sh5, str4, rVar, str, num3, num2, sh2, map, sh, sh3, num4, (kotlinx.serialization.internal.q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, p2 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            p2.b(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610281);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<p2> serializer() {
            return a.a;
        }
    }

    static {
        Covode.recordClassIndex(610280);
        Companion = new b(null);
        q = new KSerializer[]{null, null, null, null, null, null, null, null, null, null, null, null, new kotlinx.serialization.internal.a1(kotlinx.serialization.internal.v0.a, new kotlinx.serialization.internal.f(h.a.a)), null, null, null};
    }

    public static final /* synthetic */ void b(p2 p2Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
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
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        KSerializer<Object>[] kSerializerArr = q;
        boolean z16 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || p2Var.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v2.a, p2Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || p2Var.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, j.a.a, p2Var.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || p2Var.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kotlinx.serialization.internal.u2.a, p2Var.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || p2Var.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, kotlinx.serialization.internal.v0.a, p2Var.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || p2Var.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, kotlinx.serialization.internal.v2.a, p2Var.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || p2Var.f != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, kotlinx.serialization.internal.u2.a, p2Var.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || p2Var.g != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 6, kotlinx.serialization.internal.v2.a, p2Var.g);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 7) || p2Var.h != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 7, r.a.a, p2Var.h);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 8) || p2Var.i != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 8, kotlinx.serialization.internal.v2.a, p2Var.i);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 9) || p2Var.j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 9, kotlinx.serialization.internal.v0.a, p2Var.j);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 10) || p2Var.k != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 10, kotlinx.serialization.internal.v0.a, p2Var.k);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 11) || p2Var.l != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 11, kotlinx.serialization.internal.u2.a, p2Var.l);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 12) || p2Var.m != null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 12, kSerializerArr[12], p2Var.m);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 13) || p2Var.n != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 13, kotlinx.serialization.internal.u2.a, p2Var.n);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 14) || p2Var.o != null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 14, kotlinx.serialization.internal.u2.a, p2Var.o);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 15) || p2Var.p != null) {
            z16 = true;
        }
        if (z16) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 15, kotlinx.serialization.internal.v0.a, p2Var.p);
        }
    }

    public p2(String str, j jVar, Short sh, Integer num, String str2, Short sh2, String str3, r rVar, String str4, Integer num2, Integer num3, Short sh3, Map<Integer, ? extends List<h>> map, Short sh4, Short sh5, Integer num4) {
        this.a = str;
        this.b = jVar;
        this.c = sh;
        this.d = num;
        this.e = str2;
        this.f = sh2;
        this.g = str3;
        this.h = rVar;
        this.i = str4;
        this.j = num2;
        this.k = num3;
        this.l = sh3;
        this.m = map;
        this.n = sh4;
        this.o = sh5;
        this.p = num4;
    }

    public /* synthetic */ p2(int i, @SerialName("content") String str, @SerialName("novel_data") j jVar, @SerialName("crypt_status") Short sh, @SerialName("key_version") Integer num, @SerialName("title") String str2, @SerialName("code") Short sh2, @SerialName("author_speak") String str3, @SerialName("block_data") r rVar, @SerialName("origin_content") String str4, @SerialName("text_type") Integer num2, @SerialName("parse_mode") Integer num3, @SerialName("compress_status") Short sh3, @SerialName("annotation_descriptions") Map map, @SerialName("paragraphs_num") Short sh4, @SerialName("free_para_nums") Short sh5, @SerialName("code_i32") Integer num4, kotlinx.serialization.internal.q2 q2Var) {
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
            this.b = jVar;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = sh;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = num;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = str2;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = sh2;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str3;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = rVar;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = str4;
        }
        if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
            this.j = null;
        } else {
            this.j = num2;
        }
        if ((i & 1024) == 0) {
            this.k = null;
        } else {
            this.k = num3;
        }
        if ((i & 2048) == 0) {
            this.l = null;
        } else {
            this.l = sh3;
        }
        if ((i & 4096) == 0) {
            this.m = null;
        } else {
            this.m = map;
        }
        if ((i & 8192) == 0) {
            this.n = null;
        } else {
            this.n = sh4;
        }
        if ((i & 16384) == 0) {
            this.o = null;
        } else {
            this.o = sh5;
        }
        if ((i & 32768) == 0) {
            this.p = null;
        } else {
            this.p = num4;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ p2(java.lang.String r18, com.dragon.read.kmprpc.reader.saas.model.j r19, java.lang.Short r20, java.lang.Integer r21, java.lang.String r22, java.lang.Short r23, java.lang.String r24, com.dragon.read.kmprpc.reader.saas.model.r r25, java.lang.String r26, java.lang.Integer r27, java.lang.Integer r28, java.lang.Short r29, java.util.Map r30, java.lang.Short r31, java.lang.Short r32, java.lang.Integer r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            Method dump skipped, instructions count: 171
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmprpc.reader.saas.model.p2.<init>(java.lang.String, com.dragon.read.kmprpc.reader.saas.model.j, java.lang.Short, java.lang.Integer, java.lang.String, java.lang.Short, java.lang.String, com.dragon.read.kmprpc.reader.saas.model.r, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Short, java.util.Map, java.lang.Short, java.lang.Short, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
