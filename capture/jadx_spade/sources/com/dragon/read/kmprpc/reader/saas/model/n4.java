package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
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
public final class n4 {
    public static final b Companion;
    public Integer a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public Boolean j;
    public Boolean k;
    public Integer l;
    public Boolean m;
    public Boolean n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;

    static {
        Covode.recordClassIndex(610596);
        Companion = new b(null);
    }

    public n4() {
        this((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524287, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<n4> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.ReaderFontTypeData", aVar, 19);
            g2Var.g("reader_font_id", true);
            g2Var.g("font_title", true);
            g2Var.g("file_size", true);
            g2Var.g("file_url", true);
            g2Var.g("font_pic", true);
            g2Var.g("bold_name", true);
            g2Var.g("regular_name", true);
            g2Var.g("font_family", true);
            g2Var.g("regular_file_name", true);
            g2Var.g("download_onlaunch", true);
            g2Var.g("hidden_inreader", true);
            g2Var.g("font_vip_type", true);
            g2Var.g("is_new_font", true);
            g2Var.g("is_variable_font", true);
            g2Var.g("medium_file_name", true);
            g2Var.g("bold_file_name", true);
            g2Var.g("medium_name", true);
            g2Var.g("fanti_font_pic", true);
            g2Var.g("ui_key", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
            kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
            kotlinx.serialization.internal.i iVar = kotlinx.serialization.internal.i.a;
            return new KSerializer[]{en6.a.u(v0Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(iVar), en6.a.u(iVar), en6.a.u(v0Var), en6.a.u(iVar), en6.a.u(iVar), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public n4 deserialize(Decoder decoder) {
            String str;
            Boolean bool;
            String str2;
            String str3;
            String str4;
            String str5;
            Boolean bool2;
            String str6;
            int i;
            Integer num;
            Boolean bool3;
            String str7;
            String str8;
            String str9;
            String str10;
            Boolean bool4;
            String str11;
            String str12;
            String str13;
            Integer num2;
            String str14;
            String str15;
            String str16;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v0 v0Var = kotlinx.serialization.internal.v0.a;
                Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v0Var, null);
                kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
                String str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, v2Var, null);
                String str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, v2Var, null);
                String str19 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, v2Var, null);
                String str20 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, v2Var, null);
                String str21 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, v2Var, null);
                String str22 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, v2Var, null);
                String str23 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, v2Var, null);
                String str24 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, v2Var, null);
                kotlinx.serialization.internal.i iVar = kotlinx.serialization.internal.i.a;
                Boolean bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 9, iVar, null);
                Boolean bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 10, iVar, null);
                Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 11, v0Var, null);
                Boolean bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 12, iVar, null);
                num = num4;
                Boolean bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 13, iVar, null);
                String str25 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, v2Var, null);
                String str26 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, v2Var, null);
                String str27 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, v2Var, null);
                str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, v2Var, null);
                bool = bool7;
                str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 18, v2Var, null);
                str4 = str27;
                str5 = str26;
                bool4 = bool6;
                i = 524287;
                str7 = str24;
                str8 = str23;
                bool2 = bool8;
                str10 = str18;
                bool3 = bool5;
                str13 = str17;
                str9 = str25;
                num2 = num3;
                str6 = str22;
                str12 = str19;
                str = str21;
                str11 = str20;
            } else {
                String str28 = null;
                String str29 = null;
                Boolean bool9 = null;
                String str30 = null;
                String str31 = null;
                String str32 = null;
                String str33 = null;
                Integer num5 = null;
                Boolean bool10 = null;
                String str34 = null;
                String str35 = null;
                str = null;
                Boolean bool11 = null;
                Boolean bool12 = null;
                String str36 = null;
                String str37 = null;
                String str38 = null;
                String str39 = null;
                Integer num6 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    switch (decodeElementIndex) {
                        case -1:
                            str32 = str32;
                            str29 = str29;
                            str28 = str28;
                            z = false;
                        case 0:
                            str14 = str28;
                            num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, num6);
                            i2 |= 1;
                            str32 = str32;
                            str29 = str29;
                            str28 = str14;
                        case 1:
                            str14 = str28;
                            str33 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v2.a, str33);
                            i2 |= 2;
                            str32 = str32;
                            str28 = str14;
                        case 2:
                            str15 = str32;
                            str16 = str33;
                            str28 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.v2.a, str28);
                            i2 |= 4;
                            str32 = str15;
                            str33 = str16;
                        case 3:
                            str15 = str32;
                            str16 = str33;
                            str31 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kotlinx.serialization.internal.v2.a, str31);
                            i2 |= 8;
                            str32 = str15;
                            str33 = str16;
                        case 4:
                            str15 = str32;
                            str16 = str33;
                            str30 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kotlinx.serialization.internal.v2.a, str30);
                            i2 |= 16;
                            str32 = str15;
                            str33 = str16;
                        case 5:
                            str15 = str32;
                            str16 = str33;
                            str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kotlinx.serialization.internal.v2.a, str);
                            i2 |= 32;
                            str32 = str15;
                            str33 = str16;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            str15 = str32;
                            str16 = str33;
                            str29 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kotlinx.serialization.internal.v2.a, str29);
                            i2 |= 64;
                            str32 = str15;
                            str33 = str16;
                        case 7:
                            str15 = str32;
                            str16 = str33;
                            str35 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kotlinx.serialization.internal.v2.a, str35);
                            i2 |= 128;
                            str32 = str15;
                            str33 = str16;
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            str15 = str32;
                            str16 = str33;
                            str34 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kotlinx.serialization.internal.v2.a, str34);
                            i2 |= 256;
                            str32 = str15;
                            str33 = str16;
                        case 9:
                            str15 = str32;
                            str16 = str33;
                            bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 9, kotlinx.serialization.internal.i.a, bool10);
                            i2 |= MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
                            str32 = str15;
                            str33 = str16;
                        case 10:
                            str15 = str32;
                            str16 = str33;
                            bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 10, kotlinx.serialization.internal.i.a, bool9);
                            i2 |= 1024;
                            str32 = str15;
                            str33 = str16;
                        case 11:
                            str15 = str32;
                            str16 = str33;
                            num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 11, kotlinx.serialization.internal.v0.a, num5);
                            i2 |= 2048;
                            str32 = str15;
                            str33 = str16;
                        case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                            str16 = str33;
                            bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 12, kotlinx.serialization.internal.i.a, bool11);
                            i2 |= 4096;
                            str32 = str32;
                            bool12 = bool12;
                            str33 = str16;
                        case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                            str16 = str33;
                            bool12 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 13, kotlinx.serialization.internal.i.a, bool12);
                            i2 |= 8192;
                            str32 = str32;
                            str36 = str36;
                            str33 = str16;
                        case 14:
                            str16 = str33;
                            str36 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, kotlinx.serialization.internal.v2.a, str36);
                            i2 |= 16384;
                            str32 = str32;
                            str37 = str37;
                            str33 = str16;
                        case 15:
                            str16 = str33;
                            str37 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, kotlinx.serialization.internal.v2.a, str37);
                            i2 |= 32768;
                            str32 = str32;
                            str38 = str38;
                            str33 = str16;
                        case 16:
                            str16 = str33;
                            str38 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, kotlinx.serialization.internal.v2.a, str38);
                            i2 |= 65536;
                            str32 = str32;
                            str39 = str39;
                            str33 = str16;
                        case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                            str16 = str33;
                            str15 = str32;
                            str39 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, kotlinx.serialization.internal.v2.a, str39);
                            i2 |= 131072;
                            str32 = str15;
                            str33 = str16;
                        case 18:
                            str16 = str33;
                            str32 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 18, kotlinx.serialization.internal.v2.a, str32);
                            i2 |= 262144;
                            str33 = str16;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                bool = bool11;
                str2 = str32;
                str3 = str39;
                str4 = str38;
                str5 = str37;
                bool2 = bool12;
                str6 = str29;
                i = i2;
                num = num5;
                bool3 = bool10;
                str7 = str34;
                str8 = str35;
                str9 = str36;
                str10 = str28;
                bool4 = bool9;
                str11 = str30;
                str12 = str31;
                str13 = str33;
                num2 = num6;
            }
            beginStructure.endStructure(descriptor2);
            return new n4(i, num2, str13, str10, str12, str11, str, str6, str8, str7, bool3, bool4, num, bool, bool2, str9, str5, str4, str3, str2, (kotlinx.serialization.internal.q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, n4 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            n4.a(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610597);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<n4> serializer() {
            return a.a;
        }
    }

    public static final /* synthetic */ void a(n4 n4Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
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
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || n4Var.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v0.a, n4Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || n4Var.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v2.a, n4Var.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || n4Var.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kotlinx.serialization.internal.v2.a, n4Var.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || n4Var.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, kotlinx.serialization.internal.v2.a, n4Var.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || n4Var.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, kotlinx.serialization.internal.v2.a, n4Var.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || n4Var.f != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, kotlinx.serialization.internal.v2.a, n4Var.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || n4Var.g != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 6, kotlinx.serialization.internal.v2.a, n4Var.g);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 7) || n4Var.h != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 7, kotlinx.serialization.internal.v2.a, n4Var.h);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 8) || n4Var.i != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 8, kotlinx.serialization.internal.v2.a, n4Var.i);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 9) || n4Var.j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 9, kotlinx.serialization.internal.i.a, n4Var.j);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 10) || n4Var.k != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 10, kotlinx.serialization.internal.i.a, n4Var.k);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 11) || n4Var.l != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 11, kotlinx.serialization.internal.v0.a, n4Var.l);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 12) || n4Var.m != null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 12, kotlinx.serialization.internal.i.a, n4Var.m);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 13) || n4Var.n != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 13, kotlinx.serialization.internal.i.a, n4Var.n);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 14) || n4Var.o != null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 14, kotlinx.serialization.internal.v2.a, n4Var.o);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 15) || n4Var.p != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 15, kotlinx.serialization.internal.v2.a, n4Var.p);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 16) || n4Var.q != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 16, kotlinx.serialization.internal.v2.a, n4Var.q);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 17) || n4Var.r != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 17, kotlinx.serialization.internal.v2.a, n4Var.r);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 18) || n4Var.s != null) {
            z19 = true;
        }
        if (z19) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 18, kotlinx.serialization.internal.v2.a, n4Var.s);
        }
    }

    public n4(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, Boolean bool2, Integer num2, Boolean bool3, Boolean bool4, String str9, String str10, String str11, String str12, String str13) {
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = bool;
        this.k = bool2;
        this.l = num2;
        this.m = bool3;
        this.n = bool4;
        this.o = str9;
        this.p = str10;
        this.q = str11;
        this.r = str12;
        this.s = str13;
    }

    public /* synthetic */ n4(int i, @SerialName("reader_font_id") Integer num, @SerialName("font_title") String str, @SerialName("file_size") String str2, @SerialName("file_url") String str3, @SerialName("font_pic") String str4, @SerialName("bold_name") String str5, @SerialName("regular_name") String str6, @SerialName("font_family") String str7, @SerialName("regular_file_name") String str8, @SerialName("download_onlaunch") Boolean bool, @SerialName("hidden_inreader") Boolean bool2, @SerialName("font_vip_type") Integer num2, @SerialName("is_new_font") Boolean bool3, @SerialName("is_variable_font") Boolean bool4, @SerialName("medium_file_name") String str9, @SerialName("bold_file_name") String str10, @SerialName("medium_name") String str11, @SerialName("fanti_font_pic") String str12, @SerialName("ui_key") String str13, kotlinx.serialization.internal.q2 q2Var) {
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
            this.f = str5;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str6;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = str7;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = str8;
        }
        if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
            this.j = null;
        } else {
            this.j = bool;
        }
        if ((i & 1024) == 0) {
            this.k = null;
        } else {
            this.k = bool2;
        }
        if ((i & 2048) == 0) {
            this.l = null;
        } else {
            this.l = num2;
        }
        if ((i & 4096) == 0) {
            this.m = null;
        } else {
            this.m = bool3;
        }
        if ((i & 8192) == 0) {
            this.n = null;
        } else {
            this.n = bool4;
        }
        if ((i & 16384) == 0) {
            this.o = null;
        } else {
            this.o = str9;
        }
        if ((32768 & i) == 0) {
            this.p = null;
        } else {
            this.p = str10;
        }
        if ((65536 & i) == 0) {
            this.q = null;
        } else {
            this.q = str11;
        }
        if ((131072 & i) == 0) {
            this.r = null;
        } else {
            this.r = str12;
        }
        if ((i & 262144) == 0) {
            this.s = null;
        } else {
            this.s = str13;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ n4(java.lang.Integer r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.Boolean r30, java.lang.Boolean r31, java.lang.Integer r32, java.lang.Boolean r33, java.lang.Boolean r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmprpc.reader.saas.model.n4.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
