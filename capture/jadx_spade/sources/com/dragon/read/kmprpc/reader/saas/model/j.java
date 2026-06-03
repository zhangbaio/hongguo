package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmprpc.reader.saas.model.c4;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.ITTVideoEngineInternal;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import kotlin.Unit;
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
public final class j {
    public static final b Companion;
    private static final KSerializer<Object>[] l0;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public List<String> L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public String a;
    public String a0;
    public String b;
    public String b0;
    public String c;
    public c4 c0;
    public String d;
    public String d0;
    public String e;
    public String e0;
    public String f;
    public String f0;
    public String g;
    public String g0;
    public String h;
    public String h0;
    public String i;
    public String i0;
    public String j;
    public String j0;
    public String k;
    public String k0;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public j() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (c4) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -1, Integer.MAX_VALUE, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<j> {
        public static final a a;
        private static final /* synthetic */ kotlinx.serialization.internal.g2 descriptor;

        private a() {
        }

        public SerialDescriptor getDescriptor() {
            return descriptor;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public j deserialize(Decoder decoder) {
            String str;
            int i;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            List list;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            String str25;
            String str26;
            String str27;
            String str28;
            String str29;
            String str30;
            String str31;
            int i2;
            String str32;
            String str33;
            String str34;
            String str35;
            String str36;
            String str37;
            String str38;
            String str39;
            String str40;
            String str41;
            String str42;
            String str43;
            String str44;
            String str45;
            String str46;
            String str47;
            String str48;
            String str49;
            String str50;
            String str51;
            String str52;
            String str53;
            String str54;
            String str55;
            String str56;
            String str57;
            c4 c4Var;
            String str58;
            String str59;
            String str60;
            String str61;
            String str62;
            String str63;
            String str64;
            String str65;
            String str66;
            String str67;
            String str68;
            String str69;
            String str70;
            String str71;
            String str72;
            String str73;
            String str74;
            String str75;
            String str76;
            String str77;
            String str78;
            String str79;
            String str80;
            String str81;
            String str82;
            String str83;
            String str84;
            String str85;
            List list2;
            String str86;
            String str87;
            String str88;
            String str89;
            String str90;
            String str91;
            String str92;
            String str93;
            String str94;
            int i3;
            String str95;
            String str96;
            String str97;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            KSerializer[] kSerializerArr = j.l0;
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
                String str98 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v2Var, null);
                String str99 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, v2Var, null);
                String str100 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, v2Var, null);
                String str101 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, v2Var, null);
                String str102 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, v2Var, null);
                String str103 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, v2Var, null);
                String str104 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, v2Var, null);
                str58 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, v2Var, null);
                String str105 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, v2Var, null);
                String str106 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, v2Var, null);
                String str107 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, v2Var, null);
                String str108 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, v2Var, null);
                String str109 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, v2Var, null);
                String str110 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, v2Var, null);
                String str111 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, v2Var, null);
                String str112 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, v2Var, null);
                String str113 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, v2Var, null);
                String str114 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, v2Var, null);
                String str115 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 18, v2Var, null);
                String str116 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 19, v2Var, null);
                String str117 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 20, v2Var, null);
                String str118 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 21, v2Var, null);
                String str119 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 22, v2Var, null);
                String str120 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 23, v2Var, null);
                String str121 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 24, v2Var, null);
                String str122 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 25, v2Var, null);
                String str123 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 26, v2Var, null);
                String str124 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 27, v2Var, null);
                String str125 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 28, v2Var, null);
                String str126 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 29, v2Var, null);
                String str127 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 30, v2Var, null);
                String str128 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 31, v2Var, null);
                String str129 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 32, v2Var, null);
                str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 33, v2Var, null);
                str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 34, v2Var, null);
                str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 35, v2Var, null);
                String str130 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 36, v2Var, null);
                List list3 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 37, kSerializerArr[37], null);
                String str131 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 38, v2Var, null);
                String str132 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 39, v2Var, null);
                String str133 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 40, v2Var, null);
                String str134 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 41, v2Var, null);
                String str135 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 42, v2Var, null);
                String str136 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 43, v2Var, null);
                String str137 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 44, v2Var, null);
                String str138 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 45, v2Var, null);
                String str139 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 46, v2Var, null);
                String str140 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 47, v2Var, null);
                String str141 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 48, v2Var, null);
                String str142 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 49, v2Var, null);
                String str143 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 50, v2Var, null);
                String str144 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 51, v2Var, null);
                String str145 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 52, v2Var, null);
                String str146 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 53, v2Var, null);
                c4 c4Var2 = (c4) beginStructure.decodeNullableSerializableElement(descriptor2, 54, c4.a.a, null);
                String str147 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 55, v2Var, null);
                String str148 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 56, v2Var, null);
                String str149 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 57, v2Var, null);
                String str150 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 58, v2Var, null);
                String str151 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 59, v2Var, null);
                String str152 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 60, v2Var, null);
                String str153 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 61, v2Var, null);
                str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 62, v2Var, null);
                str34 = str101;
                str11 = str116;
                str12 = str117;
                str37 = str118;
                str55 = str119;
                str38 = str120;
                str45 = str121;
                str59 = str122;
                str50 = str123;
                str46 = str124;
                str39 = str125;
                str13 = str126;
                str14 = str127;
                str15 = str128;
                str4 = str152;
                str3 = str153;
                str2 = str129;
                str7 = str109;
                str32 = str150;
                str30 = str151;
                str60 = str114;
                str48 = str148;
                str41 = str149;
                str51 = str147;
                str36 = str107;
                str35 = str103;
                c4Var = c4Var2;
                i = -1;
                str44 = str106;
                str43 = str104;
                str47 = str146;
                str49 = str105;
                str57 = str144;
                i2 = Integer.MAX_VALUE;
                str29 = str142;
                str28 = str140;
                str26 = str138;
                str24 = str136;
                str22 = str134;
                str20 = str132;
                list = list3;
                str19 = str130;
                str42 = str145;
                str40 = str143;
                str56 = str141;
                str27 = str139;
                str25 = str137;
                str23 = str135;
                str21 = str133;
                str5 = str131;
                str53 = str102;
                str31 = str98;
                str10 = str108;
                str33 = str115;
                str9 = str100;
                str8 = str99;
                str52 = str113;
                str61 = str110;
                str = str112;
                str54 = str111;
            } else {
                String str154 = null;
                String str155 = null;
                String str156 = null;
                String str157 = null;
                String str158 = null;
                String str159 = null;
                String str160 = null;
                String str161 = null;
                String str162 = null;
                String str163 = null;
                c4 c4Var3 = null;
                String str164 = null;
                String str165 = null;
                String str166 = null;
                String str167 = null;
                String str168 = null;
                String str169 = null;
                String str170 = null;
                String str171 = null;
                String str172 = null;
                String str173 = null;
                String str174 = null;
                String str175 = null;
                String str176 = null;
                String str177 = null;
                String str178 = null;
                String str179 = null;
                String str180 = null;
                String str181 = null;
                String str182 = null;
                String str183 = null;
                String str184 = null;
                String str185 = null;
                String str186 = null;
                String str187 = null;
                String str188 = null;
                String str189 = null;
                String str190 = null;
                String str191 = null;
                String str192 = null;
                String str193 = null;
                String str194 = null;
                String str195 = null;
                String str196 = null;
                String str197 = null;
                String str198 = null;
                String str199 = null;
                String str200 = null;
                String str201 = null;
                String str202 = null;
                List list4 = null;
                String str203 = null;
                String str204 = null;
                String str205 = null;
                String str206 = null;
                String str207 = null;
                String str208 = null;
                String str209 = null;
                String str210 = null;
                String str211 = null;
                String str212 = null;
                String str213 = null;
                String str214 = null;
                int i4 = 0;
                int i5 = 0;
                boolean z = true;
                while (true) {
                    String str215 = str154;
                    if (z) {
                        int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                        switch (decodeElementIndex) {
                            case -1:
                                str62 = str155;
                                str63 = str158;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                String str216 = str156;
                                str85 = str179;
                                list2 = list4;
                                Unit unit = Unit.INSTANCE;
                                str157 = str157;
                                str156 = str216;
                                str154 = str215;
                                z = false;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str217 = str81;
                                str183 = str80;
                                str89 = str217;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 0:
                                str62 = str155;
                                String str218 = str157;
                                str63 = str158;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                String str219 = str156;
                                str85 = str179;
                                list2 = list4;
                                str64 = str166;
                                String str220 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v2.a, str196);
                                Unit unit2 = Unit.INSTANCE;
                                i5 |= 1;
                                str196 = str220;
                                str157 = str218;
                                str156 = str219;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str2172 = str81;
                                str183 = str80;
                                str89 = str2172;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 1:
                                str62 = str155;
                                str63 = str158;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str65 = str167;
                                String str221 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v2.a, str166);
                                Unit unit3 = Unit.INSTANCE;
                                i5 |= 2;
                                str64 = str221;
                                str157 = str157;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str21722 = str81;
                                str183 = str80;
                                str89 = str21722;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 2:
                                str62 = str155;
                                String str222 = str157;
                                str63 = str158;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str66 = str168;
                                String str223 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kotlinx.serialization.internal.v2.a, str167);
                                Unit unit4 = Unit.INSTANCE;
                                i5 |= 4;
                                str65 = str223;
                                str157 = str222;
                                str64 = str166;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str217222 = str81;
                                str183 = str80;
                                str89 = str217222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 3:
                                str62 = str155;
                                str63 = str158;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str67 = str169;
                                String str224 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kotlinx.serialization.internal.v2.a, str168);
                                Unit unit5 = Unit.INSTANCE;
                                i5 |= 8;
                                str66 = str224;
                                str157 = str157;
                                str64 = str166;
                                str65 = str167;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str2172222 = str81;
                                str183 = str80;
                                str89 = str2172222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 4:
                                str62 = str155;
                                String str225 = str157;
                                str63 = str158;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str68 = str170;
                                String str226 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kotlinx.serialization.internal.v2.a, str169);
                                Unit unit6 = Unit.INSTANCE;
                                i5 |= 16;
                                str67 = str226;
                                str157 = str225;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str21722222 = str81;
                                str183 = str80;
                                str89 = str21722222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 5:
                                str62 = str155;
                                str63 = str158;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str69 = str171;
                                String str227 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kotlinx.serialization.internal.v2.a, str170);
                                Unit unit7 = Unit.INSTANCE;
                                i5 |= 32;
                                str68 = str227;
                                str157 = str157;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str217222222 = str81;
                                str183 = str80;
                                str89 = str217222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                                str62 = str155;
                                String str228 = str157;
                                str63 = str158;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str70 = str172;
                                String str229 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kotlinx.serialization.internal.v2.a, str171);
                                Unit unit8 = Unit.INSTANCE;
                                i5 |= 64;
                                str69 = str229;
                                str157 = str228;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str2172222222 = str81;
                                str183 = str80;
                                str89 = str2172222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 7:
                                str62 = str155;
                                str63 = str158;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str71 = str173;
                                String str230 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kotlinx.serialization.internal.v2.a, str172);
                                Unit unit9 = Unit.INSTANCE;
                                i5 |= 128;
                                str70 = str230;
                                str157 = str157;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str21722222222 = str81;
                                str183 = str80;
                                str89 = str21722222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                                str62 = str155;
                                String str231 = str157;
                                str63 = str158;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str72 = str174;
                                String str232 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kotlinx.serialization.internal.v2.a, str173);
                                Unit unit10 = Unit.INSTANCE;
                                i5 |= 256;
                                str71 = str232;
                                str157 = str231;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str217222222222 = str81;
                                str183 = str80;
                                str89 = str217222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 9:
                                str62 = str155;
                                str63 = str158;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str73 = str175;
                                String str233 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, kotlinx.serialization.internal.v2.a, str174);
                                int i6 = i5 | MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
                                Unit unit11 = Unit.INSTANCE;
                                i5 = i6;
                                str72 = str233;
                                str157 = str157;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str2172222222222 = str81;
                                str183 = str80;
                                str89 = str2172222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 10:
                                str62 = str155;
                                String str234 = str157;
                                str63 = str158;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str74 = str176;
                                String str235 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, kotlinx.serialization.internal.v2.a, str175);
                                Unit unit12 = Unit.INSTANCE;
                                i5 |= 1024;
                                str73 = str235;
                                str157 = str234;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str21722222222222 = str81;
                                str183 = str80;
                                str89 = str21722222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 11:
                                str62 = str155;
                                str63 = str158;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str75 = str177;
                                String str236 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, kotlinx.serialization.internal.v2.a, str176);
                                Unit unit13 = Unit.INSTANCE;
                                i5 |= 2048;
                                str74 = str236;
                                str157 = str157;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str217222222222222 = str81;
                                str183 = str80;
                                str89 = str217222222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                str62 = str155;
                                String str237 = str157;
                                str63 = str158;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                str85 = str179;
                                list2 = list4;
                                str76 = str178;
                                String str238 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, kotlinx.serialization.internal.v2.a, str177);
                                Unit unit14 = Unit.INSTANCE;
                                i5 |= 4096;
                                str75 = str238;
                                str157 = str237;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str2172222222222222 = str81;
                                str183 = str80;
                                str89 = str2172222222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                str62 = str155;
                                str63 = str158;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                list2 = list4;
                                str85 = str179;
                                String str239 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, kotlinx.serialization.internal.v2.a, str178);
                                Unit unit15 = Unit.INSTANCE;
                                i5 |= 8192;
                                str76 = str239;
                                str157 = str157;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str21722222222222222 = str81;
                                str183 = str80;
                                str89 = str21722222222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 14:
                                str62 = str155;
                                str63 = str158;
                                str78 = str181;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                list2 = list4;
                                str77 = str180;
                                String str240 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, kotlinx.serialization.internal.v2.a, str179);
                                Unit unit16 = Unit.INSTANCE;
                                str85 = str240;
                                i5 |= 16384;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str217222222222222222 = str81;
                                str183 = str80;
                                str89 = str217222222222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 15:
                                str62 = str155;
                                str63 = str158;
                                str79 = str182;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                list2 = list4;
                                str78 = str181;
                                String str241 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, kotlinx.serialization.internal.v2.a, str180);
                                Unit unit17 = Unit.INSTANCE;
                                str77 = str241;
                                i5 |= 32768;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str85 = str179;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str2172222222222222222 = str81;
                                str183 = str80;
                                str89 = str2172222222222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 16:
                                str62 = str155;
                                str63 = str158;
                                str80 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                list2 = list4;
                                str79 = str182;
                                String str242 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, kotlinx.serialization.internal.v2.a, str181);
                                Unit unit18 = Unit.INSTANCE;
                                str78 = str242;
                                i5 |= 65536;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str85 = str179;
                                str77 = str180;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str21722222222222222222 = str81;
                                str183 = str80;
                                str89 = str21722222222222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                str62 = str155;
                                str63 = str158;
                                String str243 = str183;
                                str81 = str184;
                                str82 = str198;
                                str83 = str199;
                                str84 = str203;
                                str86 = str156;
                                list2 = list4;
                                str80 = str243;
                                String str244 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, kotlinx.serialization.internal.v2.a, str182);
                                Unit unit19 = Unit.INSTANCE;
                                str79 = str244;
                                i5 |= 131072;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str85 = str179;
                                str77 = str180;
                                str78 = str181;
                                str156 = str86;
                                str154 = str215;
                                str199 = str83;
                                str87 = str84;
                                str88 = str82;
                                str158 = str63;
                                String str217222222222222222222 = str81;
                                str183 = str80;
                                str89 = str217222222222222222222;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 18:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                String str245 = str199;
                                str92 = str203;
                                String str246 = str156;
                                String str247 = str184;
                                list2 = list4;
                                String str248 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 18, kotlinx.serialization.internal.v2.a, str183);
                                Unit unit20 = Unit.INSTANCE;
                                i5 |= 262144;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str85 = str179;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str247;
                                str156 = str246;
                                str183 = str248;
                                str199 = str245;
                                str154 = str215;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                String str249 = str199;
                                str92 = str203;
                                String str250 = str156;
                                list2 = list4;
                                String str251 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 19, kotlinx.serialization.internal.v2.a, str184);
                                Unit unit21 = Unit.INSTANCE;
                                str89 = str251;
                                i5 |= 524288;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str85 = str179;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str156 = str250;
                                str154 = str215;
                                str199 = str249;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str252 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 20, kotlinx.serialization.internal.v2.a, str185);
                                i3 = i5 | 1048576;
                                Unit unit22 = Unit.INSTANCE;
                                str185 = str252;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str253 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 21, kotlinx.serialization.internal.v2.a, str186);
                                i3 = i5 | 2097152;
                                Unit unit23 = Unit.INSTANCE;
                                str186 = str253;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str254 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 22, kotlinx.serialization.internal.v2.a, str187);
                                i3 = i5 | 4194304;
                                Unit unit24 = Unit.INSTANCE;
                                str187 = str254;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str255 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 23, kotlinx.serialization.internal.v2.a, str188);
                                i3 = i5 | 8388608;
                                Unit unit25 = Unit.INSTANCE;
                                str188 = str255;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str256 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 24, kotlinx.serialization.internal.v2.a, str189);
                                i3 = i5 | 16777216;
                                Unit unit26 = Unit.INSTANCE;
                                str189 = str256;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str257 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 25, kotlinx.serialization.internal.v2.a, str190);
                                i3 = i5 | 33554432;
                                Unit unit27 = Unit.INSTANCE;
                                str190 = str257;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str258 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 26, kotlinx.serialization.internal.v2.a, str191);
                                i3 = i5 | 67108864;
                                Unit unit28 = Unit.INSTANCE;
                                str191 = str258;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str259 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 27, kotlinx.serialization.internal.v2.a, str192);
                                i3 = i5 | 134217728;
                                Unit unit29 = Unit.INSTANCE;
                                str192 = str259;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 28:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str260 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 28, kotlinx.serialization.internal.v2.a, str193);
                                i3 = i5 | 268435456;
                                Unit unit30 = Unit.INSTANCE;
                                str193 = str260;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str261 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 29, kotlinx.serialization.internal.v2.a, str194);
                                i3 = i5 | 536870912;
                                Unit unit31 = Unit.INSTANCE;
                                str194 = str261;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 30:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                str94 = str156;
                                list2 = list4;
                                String str262 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 30, kotlinx.serialization.internal.v2.a, str195);
                                i3 = i5 | 1073741824;
                                Unit unit32 = Unit.INSTANCE;
                                str195 = str262;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 31:
                                str62 = str155;
                                str90 = str158;
                                str91 = str198;
                                str93 = str199;
                                str92 = str203;
                                list2 = list4;
                                str94 = str156;
                                String str263 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 31, kotlinx.serialization.internal.v2.a, str197);
                                i3 = i5 | Integer.MIN_VALUE;
                                Unit unit33 = Unit.INSTANCE;
                                str197 = str263;
                                i5 = i3;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str156 = str94;
                                str154 = str215;
                                str199 = str93;
                                str85 = str179;
                                str87 = str92;
                                str88 = str91;
                                str158 = str90;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                str62 = str155;
                                String str264 = str158;
                                String str265 = str203;
                                list2 = list4;
                                String str266 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 32, kotlinx.serialization.internal.v2.a, str198);
                                i4 |= 1;
                                Unit unit34 = Unit.INSTANCE;
                                str199 = str199;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str158 = str264;
                                str87 = str265;
                                str85 = str179;
                                str88 = str266;
                                str154 = str215;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                                str62 = str155;
                                str95 = str158;
                                str96 = str203;
                                list2 = list4;
                                String str267 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 33, kotlinx.serialization.internal.v2.a, str199);
                                i4 |= 2;
                                Unit unit35 = Unit.INSTANCE;
                                str199 = str267;
                                str87 = str96;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str154 = str215;
                                str158 = str95;
                                str85 = str179;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                                str62 = str155;
                                str95 = str158;
                                str96 = str203;
                                list2 = list4;
                                String str268 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 34, kotlinx.serialization.internal.v2.a, str200);
                                i4 |= 4;
                                Unit unit36 = Unit.INSTANCE;
                                str200 = str268;
                                str87 = str96;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str154 = str215;
                                str158 = str95;
                                str85 = str179;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                                str62 = str155;
                                str95 = str158;
                                str96 = str203;
                                list2 = list4;
                                String str269 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 35, kotlinx.serialization.internal.v2.a, str201);
                                i4 |= 8;
                                Unit unit37 = Unit.INSTANCE;
                                str201 = str269;
                                str87 = str96;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str154 = str215;
                                str158 = str95;
                                str85 = str179;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                                str62 = str155;
                                str95 = str158;
                                str96 = str203;
                                list2 = list4;
                                String str270 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 36, kotlinx.serialization.internal.v2.a, str202);
                                i4 |= 16;
                                Unit unit38 = Unit.INSTANCE;
                                str202 = str270;
                                str87 = str96;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str154 = str215;
                                str158 = str95;
                                str85 = str179;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                                str62 = str155;
                                str95 = str158;
                                str96 = str203;
                                List list5 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 37, kSerializerArr[37], list4);
                                i4 |= 32;
                                Unit unit39 = Unit.INSTANCE;
                                list2 = list5;
                                str87 = str96;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str154 = str215;
                                str158 = str95;
                                str85 = str179;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                                str62 = str155;
                                str95 = str158;
                                String str271 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 38, kotlinx.serialization.internal.v2.a, str203);
                                i4 |= 64;
                                Unit unit40 = Unit.INSTANCE;
                                str87 = str271;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                list2 = list4;
                                str154 = str215;
                                str158 = str95;
                                str85 = str179;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                                str62 = str155;
                                str97 = str158;
                                String str272 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 39, kotlinx.serialization.internal.v2.a, str204);
                                i4 |= 128;
                                Unit unit41 = Unit.INSTANCE;
                                str204 = str272;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 40:
                                str62 = str155;
                                str97 = str158;
                                String str273 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 40, kotlinx.serialization.internal.v2.a, str205);
                                i4 |= 256;
                                Unit unit42 = Unit.INSTANCE;
                                str205 = str273;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                                str62 = str155;
                                str97 = str158;
                                String str274 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 41, kotlinx.serialization.internal.v2.a, str206);
                                i4 |= MediaPlayer.MEDIA_PLAYER_OPTION_APPID;
                                Unit unit43 = Unit.INSTANCE;
                                str206 = str274;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 42:
                                str62 = str155;
                                str97 = str158;
                                String str275 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 42, kotlinx.serialization.internal.v2.a, str207);
                                i4 |= 1024;
                                Unit unit44 = Unit.INSTANCE;
                                str207 = str275;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 43:
                                str62 = str155;
                                str97 = str158;
                                String str276 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 43, kotlinx.serialization.internal.v2.a, str208);
                                i4 |= 2048;
                                Unit unit45 = Unit.INSTANCE;
                                str208 = str276;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 44:
                                str62 = str155;
                                str97 = str158;
                                String str277 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 44, kotlinx.serialization.internal.v2.a, str209);
                                i4 |= 4096;
                                Unit unit46 = Unit.INSTANCE;
                                str209 = str277;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 45:
                                str62 = str155;
                                str97 = str158;
                                String str278 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 45, kotlinx.serialization.internal.v2.a, str210);
                                i4 |= 8192;
                                Unit unit47 = Unit.INSTANCE;
                                str210 = str278;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 46:
                                str62 = str155;
                                str97 = str158;
                                String str279 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 46, kotlinx.serialization.internal.v2.a, str211);
                                i4 |= 16384;
                                Unit unit48 = Unit.INSTANCE;
                                str211 = str279;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 47:
                                str62 = str155;
                                str97 = str158;
                                String str280 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 47, kotlinx.serialization.internal.v2.a, str212);
                                i4 |= 32768;
                                Unit unit49 = Unit.INSTANCE;
                                str212 = str280;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 48:
                                str62 = str155;
                                str97 = str158;
                                String str281 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 48, kotlinx.serialization.internal.v2.a, str213);
                                i4 |= 65536;
                                Unit unit50 = Unit.INSTANCE;
                                str213 = str281;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 49:
                                str62 = str155;
                                str97 = str158;
                                String str282 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 49, kotlinx.serialization.internal.v2.a, str214);
                                i4 |= 131072;
                                Unit unit51 = Unit.INSTANCE;
                                str214 = str282;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 50:
                                str62 = str155;
                                str97 = str158;
                                str154 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 50, kotlinx.serialization.internal.v2.a, str215);
                                i4 |= 262144;
                                Unit unit52 = Unit.INSTANCE;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                                str62 = str155;
                                String str283 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 51, kotlinx.serialization.internal.v2.a, str158);
                                i4 |= 524288;
                                Unit unit53 = Unit.INSTANCE;
                                str158 = str283;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE /* 52 */:
                                str97 = str158;
                                String str284 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 52, kotlinx.serialization.internal.v2.a, str165);
                                i4 |= 1048576;
                                Unit unit54 = Unit.INSTANCE;
                                str165 = str284;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case ITTVideoEngineInternal.PLAYER_OPTION_GET_WATCHED_DUTATION /* 53 */:
                                str97 = str158;
                                String str285 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 53, kotlinx.serialization.internal.v2.a, str164);
                                i4 |= 2097152;
                                Unit unit55 = Unit.INSTANCE;
                                str164 = str285;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 54:
                                str97 = str158;
                                c4 c4Var4 = (c4) beginStructure.decodeNullableSerializableElement(descriptor2, 54, c4.a.a, c4Var3);
                                i4 |= 4194304;
                                Unit unit56 = Unit.INSTANCE;
                                c4Var3 = c4Var4;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 55:
                                str97 = str158;
                                String str286 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 55, kotlinx.serialization.internal.v2.a, str161);
                                i4 |= 8388608;
                                Unit unit57 = Unit.INSTANCE;
                                str161 = str286;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 56:
                                str97 = str158;
                                String str287 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 56, kotlinx.serialization.internal.v2.a, str157);
                                i4 |= 16777216;
                                Unit unit58 = Unit.INSTANCE;
                                str157 = str287;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 57:
                                str97 = str158;
                                String str288 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 57, kotlinx.serialization.internal.v2.a, str163);
                                i4 |= 33554432;
                                Unit unit59 = Unit.INSTANCE;
                                str163 = str288;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 58:
                                str97 = str158;
                                String str289 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 58, kotlinx.serialization.internal.v2.a, str162);
                                i4 |= 67108864;
                                Unit unit60 = Unit.INSTANCE;
                                str162 = str289;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 59:
                                str97 = str158;
                                String str290 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 59, kotlinx.serialization.internal.v2.a, str155);
                                i4 |= 134217728;
                                Unit unit61 = Unit.INSTANCE;
                                str62 = str290;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 60:
                                str97 = str158;
                                String str291 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 60, kotlinx.serialization.internal.v2.a, str160);
                                i4 |= 268435456;
                                Unit unit62 = Unit.INSTANCE;
                                str160 = str291;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 61:
                                str97 = str158;
                                String str292 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 61, kotlinx.serialization.internal.v2.a, str159);
                                i4 |= 536870912;
                                Unit unit63 = Unit.INSTANCE;
                                str159 = str292;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            case 62:
                                str97 = str158;
                                String str293 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 62, kotlinx.serialization.internal.v2.a, str156);
                                i4 |= 1073741824;
                                Unit unit64 = Unit.INSTANCE;
                                str156 = str293;
                                str62 = str155;
                                str64 = str166;
                                str65 = str167;
                                str66 = str168;
                                str67 = str169;
                                str68 = str170;
                                str69 = str171;
                                str70 = str172;
                                str71 = str173;
                                str72 = str174;
                                str73 = str175;
                                str74 = str176;
                                str75 = str177;
                                str76 = str178;
                                str77 = str180;
                                str78 = str181;
                                str79 = str182;
                                str89 = str184;
                                str88 = str198;
                                str87 = str203;
                                str154 = str215;
                                str158 = str97;
                                str85 = str179;
                                list2 = list4;
                                str198 = str88;
                                str182 = str79;
                                str181 = str78;
                                str180 = str77;
                                str178 = str76;
                                str177 = str75;
                                str166 = str64;
                                str167 = str65;
                                str168 = str66;
                                str169 = str67;
                                str170 = str68;
                                str171 = str69;
                                str172 = str70;
                                str173 = str71;
                                str174 = str72;
                                str175 = str73;
                                str176 = str74;
                                str179 = str85;
                                list4 = list2;
                                str155 = str62;
                                str184 = str89;
                                str203 = str87;
                            default:
                                throw new UnknownFieldException(decodeElementIndex);
                        }
                    } else {
                        String str294 = str157;
                        String str295 = str158;
                        String str296 = str168;
                        String str297 = str169;
                        String str298 = str170;
                        String str299 = str171;
                        String str300 = str172;
                        String str301 = str173;
                        String str302 = str174;
                        String str303 = str175;
                        String str304 = str178;
                        str = str180;
                        String str305 = str181;
                        String str306 = str182;
                        String str307 = str183;
                        String str308 = str184;
                        String str309 = str196;
                        String str310 = str199;
                        String str311 = str156;
                        String str312 = str179;
                        i = i5;
                        str2 = str198;
                        str3 = str159;
                        str4 = str160;
                        str5 = str203;
                        str6 = str310;
                        str7 = str177;
                        str8 = str166;
                        str9 = str167;
                        str10 = str176;
                        str11 = str308;
                        str12 = str185;
                        str13 = str194;
                        str14 = str195;
                        str15 = str197;
                        str16 = str311;
                        str17 = str200;
                        str18 = str201;
                        str19 = str202;
                        list = list4;
                        str20 = str204;
                        str21 = str205;
                        str22 = str206;
                        str23 = str207;
                        str24 = str208;
                        str25 = str209;
                        str26 = str210;
                        str27 = str211;
                        str28 = str212;
                        str29 = str214;
                        str30 = str155;
                        str31 = str309;
                        i2 = i4;
                        str32 = str162;
                        str33 = str307;
                        str34 = str296;
                        str35 = str298;
                        str36 = str303;
                        str37 = str186;
                        str38 = str188;
                        str39 = str193;
                        str40 = str215;
                        str41 = str163;
                        str42 = str165;
                        str43 = str299;
                        str44 = str302;
                        str45 = str189;
                        str46 = str192;
                        str47 = str164;
                        str48 = str294;
                        str49 = str301;
                        str50 = str191;
                        str51 = str161;
                        str52 = str305;
                        str53 = str297;
                        str54 = str312;
                        str55 = str187;
                        str56 = str213;
                        str57 = str295;
                        String str313 = str190;
                        c4Var = c4Var3;
                        str58 = str300;
                        str59 = str313;
                        str60 = str306;
                        str61 = str304;
                    }
                }
            }
            beginStructure.endStructure(descriptor2);
            return new j(i, i2, str31, str8, str9, str34, str53, str35, str43, str58, str49, str44, str36, str10, str7, str61, str54, str, str52, str60, str33, str11, str12, str37, str55, str38, str45, str59, str50, str46, str39, str13, str14, str15, str2, str6, str17, str18, str19, list, str5, str20, str21, str22, str23, str24, str25, str26, str27, str28, str56, str29, str40, str57, str42, str47, c4Var, str51, str48, str41, str32, str30, str4, str3, str16, (kotlinx.serialization.internal.q2) null);
        }

        public KSerializer<?>[] a() {
            return m0.a.a(this);
        }

        static {
            a aVar = new a();
            a = aVar;
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.ApiItemInfo", aVar, 63);
            g2Var.g("abstract", true);
            g2Var.g("ad_free_show", true);
            g2Var.g("author", true);
            g2Var.g("ban_city", true);
            g2Var.g("book_id", true);
            g2Var.g("book_name", true);
            g2Var.g("category", true);
            g2Var.g("complete_category", true);
            g2Var.g("copyright_info", true);
            g2Var.g("create_time", true);
            g2Var.g("creation_status", true);
            g2Var.g("custom_total_price", true);
            g2Var.g("data_rate", true);
            g2Var.g("discount_custom_total_price", true);
            g2Var.g("free_status", true);
            g2Var.g("genre", true);
            g2Var.g("group_id", true);
            g2Var.g("item_id", true);
            g2Var.g("next_group_id", true);
            g2Var.g("next_item_id", true);
            g2Var.g("origin_chapter_title", true);
            g2Var.g("platform", true);
            g2Var.g("pre_group_id", true);
            g2Var.g("pre_item_id", true);
            g2Var.g("read_count", true);
            g2Var.g("sale_status", true);
            g2Var.g("serial_count", true);
            g2Var.g("source", true);
            g2Var.g("sub_abstract", true);
            g2Var.g("tags", true);
            g2Var.g("thumb_url", true);
            g2Var.g("title", true);
            g2Var.g("total_price", true);
            g2Var.g("vid", true);
            g2Var.g("word_number", true);
            g2Var.g("item_content", true);
            g2Var.g("content_picture", true);
            g2Var.g("recommend_pictures", true);
            g2Var.g("recommend_group_id", true);
            g2Var.g("recommend_info", true);
            g2Var.g("progress_rate", true);
            g2Var.g("read_timestamp", true);
            g2Var.g(Constants.VERSION, true);
            g2Var.g("real_chapter_order", true);
            g2Var.g("book_type", true);
            g2Var.g("read_timestamp_ms", true);
            g2Var.g("content_md5", true);
            g2Var.g("volume_name", true);
            g2Var.g("tomato_book_status", true);
            g2Var.g("page_progress_rate", true);
            g2Var.g("paragraph_id", true);
            g2Var.g("paragraph_offset", true);
            g2Var.g("genre_type", true);
            g2Var.g("item_status", true);
            g2Var.g("progress_pos_info_v2", true);
            g2Var.g("related_comic_info", true);
            g2Var.g("color_dominate", true);
            g2Var.g("order", true);
            g2Var.g("is_content", true);
            g2Var.g("item_progress_rate", true);
            g2Var.g("channel_id", true);
            g2Var.g("book_picture", true);
            g2Var.g("color_audio_dominate", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            KSerializer[] kSerializerArr = j.l0;
            kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(kSerializerArr[37]), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(c4.a.a), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var)};
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, j value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            j.b(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609755);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<j> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ j(int i, int i2, @SerialName("abstract") String str, @SerialName("ad_free_show") String str2, @SerialName("author") String str3, @SerialName("ban_city") String str4, @SerialName("book_id") String str5, @SerialName("book_name") String str6, @SerialName("category") String str7, @SerialName("complete_category") String str8, @SerialName("copyright_info") String str9, @SerialName("create_time") String str10, @SerialName("creation_status") String str11, @SerialName("custom_total_price") String str12, @SerialName("data_rate") String str13, @SerialName("discount_custom_total_price") String str14, @SerialName("free_status") String str15, @SerialName("genre") String str16, @SerialName("group_id") String str17, @SerialName("item_id") String str18, @SerialName("next_group_id") String str19, @SerialName("next_item_id") String str20, @SerialName("origin_chapter_title") String str21, @SerialName("platform") String str22, @SerialName("pre_group_id") String str23, @SerialName("pre_item_id") String str24, @SerialName("read_count") String str25, @SerialName("sale_status") String str26, @SerialName("serial_count") String str27, @SerialName("source") String str28, @SerialName("sub_abstract") String str29, @SerialName("tags") String str30, @SerialName("thumb_url") String str31, @SerialName("title") String str32, @SerialName("total_price") String str33, @SerialName("vid") String str34, @SerialName("word_number") String str35, @SerialName("item_content") String str36, @SerialName("content_picture") String str37, @SerialName("recommend_pictures") List list, @SerialName("recommend_group_id") String str38, @SerialName("recommend_info") String str39, @SerialName("progress_rate") String str40, @SerialName("read_timestamp") String str41, @SerialName("version") String str42, @SerialName("real_chapter_order") String str43, @SerialName("book_type") String str44, @SerialName("read_timestamp_ms") String str45, @SerialName("content_md5") String str46, @SerialName("volume_name") String str47, @SerialName("tomato_book_status") String str48, @SerialName("page_progress_rate") String str49, @SerialName("paragraph_id") String str50, @SerialName("paragraph_offset") String str51, @SerialName("genre_type") String str52, @SerialName("item_status") String str53, @SerialName("progress_pos_info_v2") c4 c4Var, @SerialName("related_comic_info") String str54, @SerialName("color_dominate") String str55, @SerialName("order") String str56, @SerialName("is_content") String str57, @SerialName("item_progress_rate") String str58, @SerialName("channel_id") String str59, @SerialName("book_picture") String str60, @SerialName("color_audio_dominate") String str61, kotlinx.serialization.internal.q2 q2Var) {
        if (((i & 0) != 0) | ((i2 & 0) != 0)) {
            kotlinx.serialization.internal.b2.a(new int[]{i, i2}, new int[]{0, 0}, a.a.getDescriptor());
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
            this.d = str4;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = str5;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = str6;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str7;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = str8;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = str9;
        }
        if ((i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
            this.j = null;
        } else {
            this.j = str10;
        }
        if ((i & 1024) == 0) {
            this.k = null;
        } else {
            this.k = str11;
        }
        if ((i & 2048) == 0) {
            this.l = null;
        } else {
            this.l = str12;
        }
        if ((i & 4096) == 0) {
            this.m = null;
        } else {
            this.m = str13;
        }
        if ((i & 8192) == 0) {
            this.n = null;
        } else {
            this.n = str14;
        }
        if ((i & 16384) == 0) {
            this.o = null;
        } else {
            this.o = str15;
        }
        if ((i & 32768) == 0) {
            this.p = null;
        } else {
            this.p = str16;
        }
        if ((i & 65536) == 0) {
            this.q = null;
        } else {
            this.q = str17;
        }
        if ((i & 131072) == 0) {
            this.r = null;
        } else {
            this.r = str18;
        }
        if ((i & 262144) == 0) {
            this.s = null;
        } else {
            this.s = str19;
        }
        if ((i & 524288) == 0) {
            this.t = null;
        } else {
            this.t = str20;
        }
        if ((1048576 & i) == 0) {
            this.u = null;
        } else {
            this.u = str21;
        }
        if ((2097152 & i) == 0) {
            this.v = null;
        } else {
            this.v = str22;
        }
        if ((4194304 & i) == 0) {
            this.w = null;
        } else {
            this.w = str23;
        }
        if ((8388608 & i) == 0) {
            this.x = null;
        } else {
            this.x = str24;
        }
        if ((16777216 & i) == 0) {
            this.y = null;
        } else {
            this.y = str25;
        }
        if ((33554432 & i) == 0) {
            this.z = null;
        } else {
            this.z = str26;
        }
        if ((67108864 & i) == 0) {
            this.A = null;
        } else {
            this.A = str27;
        }
        if ((134217728 & i) == 0) {
            this.B = null;
        } else {
            this.B = str28;
        }
        if ((268435456 & i) == 0) {
            this.C = null;
        } else {
            this.C = str29;
        }
        if ((536870912 & i) == 0) {
            this.D = null;
        } else {
            this.D = str30;
        }
        if ((1073741824 & i) == 0) {
            this.E = null;
        } else {
            this.E = str31;
        }
        if ((i & Integer.MIN_VALUE) == 0) {
            this.F = null;
        } else {
            this.F = str32;
        }
        if ((i2 & 1) == 0) {
            this.G = null;
        } else {
            this.G = str33;
        }
        if ((i2 & 2) == 0) {
            this.H = null;
        } else {
            this.H = str34;
        }
        if ((i2 & 4) == 0) {
            this.I = null;
        } else {
            this.I = str35;
        }
        if ((i2 & 8) == 0) {
            this.J = null;
        } else {
            this.J = str36;
        }
        if ((i2 & 16) == 0) {
            this.K = null;
        } else {
            this.K = str37;
        }
        if ((i2 & 32) == 0) {
            this.L = null;
        } else {
            this.L = list;
        }
        if ((i2 & 64) == 0) {
            this.M = null;
        } else {
            this.M = str38;
        }
        if ((i2 & 128) == 0) {
            this.N = null;
        } else {
            this.N = str39;
        }
        if ((i2 & 256) == 0) {
            this.O = null;
        } else {
            this.O = str40;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) == 0) {
            this.P = null;
        } else {
            this.P = str41;
        }
        if ((i2 & 1024) == 0) {
            this.Q = null;
        } else {
            this.Q = str42;
        }
        if ((i2 & 2048) == 0) {
            this.R = null;
        } else {
            this.R = str43;
        }
        if ((i2 & 4096) == 0) {
            this.S = null;
        } else {
            this.S = str44;
        }
        if ((i2 & 8192) == 0) {
            this.T = null;
        } else {
            this.T = str45;
        }
        if ((i2 & 16384) == 0) {
            this.U = null;
        } else {
            this.U = str46;
        }
        if ((i2 & 32768) == 0) {
            this.V = null;
        } else {
            this.V = str47;
        }
        if ((i2 & 65536) == 0) {
            this.W = null;
        } else {
            this.W = str48;
        }
        if ((i2 & 131072) == 0) {
            this.X = null;
        } else {
            this.X = str49;
        }
        if ((i2 & 262144) == 0) {
            this.Y = null;
        } else {
            this.Y = str50;
        }
        if ((i2 & 524288) == 0) {
            this.Z = null;
        } else {
            this.Z = str51;
        }
        if ((1048576 & i2) == 0) {
            this.a0 = null;
        } else {
            this.a0 = str52;
        }
        if ((2097152 & i2) == 0) {
            this.b0 = null;
        } else {
            this.b0 = str53;
        }
        if ((4194304 & i2) == 0) {
            this.c0 = null;
        } else {
            this.c0 = c4Var;
        }
        if ((8388608 & i2) == 0) {
            this.d0 = null;
        } else {
            this.d0 = str54;
        }
        if ((16777216 & i2) == 0) {
            this.e0 = null;
        } else {
            this.e0 = str55;
        }
        if ((33554432 & i2) == 0) {
            this.f0 = null;
        } else {
            this.f0 = str56;
        }
        if ((67108864 & i2) == 0) {
            this.g0 = null;
        } else {
            this.g0 = str57;
        }
        if ((134217728 & i2) == 0) {
            this.h0 = null;
        } else {
            this.h0 = str58;
        }
        if ((268435456 & i2) == 0) {
            this.i0 = null;
        } else {
            this.i0 = str59;
        }
        if ((536870912 & i2) == 0) {
            this.j0 = null;
        } else {
            this.j0 = str60;
        }
        if ((1073741824 & i2) == 0) {
            this.k0 = null;
        } else {
            this.k0 = str61;
        }
    }

    public /* synthetic */ j(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, List list, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, c4 c4Var, String str54, String str55, String str56, String str57, String str58, String str59, String str60, String str61, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : str17, (i & 131072) != 0 ? null : str18, (i & 262144) != 0 ? null : str19, (i & 524288) != 0 ? null : str20, (i & 1048576) != 0 ? null : str21, (i & 2097152) != 0 ? null : str22, (i & 4194304) != 0 ? null : str23, (i & 8388608) != 0 ? null : str24, (i & 16777216) != 0 ? null : str25, (i & 33554432) != 0 ? null : str26, (i & 67108864) != 0 ? null : str27, (i & 134217728) != 0 ? null : str28, (i & 268435456) != 0 ? null : str29, (i & 536870912) != 0 ? null : str30, (i & 1073741824) != 0 ? null : str31, (i & Integer.MIN_VALUE) != 0 ? null : str32, (i2 & 1) != 0 ? null : str33, (i2 & 2) != 0 ? null : str34, (i2 & 4) != 0 ? null : str35, (i2 & 8) != 0 ? null : str36, (i2 & 16) != 0 ? null : str37, (i2 & 32) != 0 ? null : list, (i2 & 64) != 0 ? null : str38, (i2 & 128) != 0 ? null : str39, (i2 & 256) != 0 ? null : str40, (i2 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? null : str41, (i2 & 1024) != 0 ? null : str42, (i2 & 2048) != 0 ? null : str43, (i2 & 4096) != 0 ? null : str44, (i2 & 8192) != 0 ? null : str45, (i2 & 16384) != 0 ? null : str46, (i2 & 32768) != 0 ? null : str47, (i2 & 65536) != 0 ? null : str48, (i2 & 131072) != 0 ? null : str49, (i2 & 262144) != 0 ? null : str50, (i2 & 524288) != 0 ? null : str51, (i2 & 1048576) != 0 ? null : str52, (i2 & 2097152) != 0 ? null : str53, (i2 & 4194304) != 0 ? null : c4Var, (i2 & 8388608) != 0 ? null : str54, (i2 & 16777216) != 0 ? null : str55, (i2 & 33554432) != 0 ? null : str56, (i2 & 67108864) != 0 ? null : str57, (i2 & 134217728) != 0 ? null : str58, (i2 & 268435456) != 0 ? null : str59, (i2 & 536870912) != 0 ? null : str60, (i2 & 1073741824) != 0 ? null : str61);
    }

    static {
        Covode.recordClassIndex(609754);
        Companion = new b(null);
        l0 = new KSerializer[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new kotlinx.serialization.internal.f(kotlinx.serialization.internal.v2.a), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    }

    public static final /* synthetic */ void b(j jVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
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
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        boolean z31;
        boolean z32;
        boolean z33;
        boolean z34;
        boolean z35;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z40;
        boolean z41;
        boolean z42;
        boolean z43;
        boolean z44;
        boolean z45;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z50;
        boolean z51;
        boolean z52;
        boolean z53;
        boolean z54;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        boolean z59;
        boolean z60;
        boolean z61;
        boolean z62;
        KSerializer<Object>[] kSerializerArr = l0;
        boolean z63 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || jVar.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v2.a, jVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || jVar.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v2.a, jVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || jVar.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kotlinx.serialization.internal.v2.a, jVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || jVar.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, kotlinx.serialization.internal.v2.a, jVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || jVar.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, kotlinx.serialization.internal.v2.a, jVar.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || jVar.f != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, kotlinx.serialization.internal.v2.a, jVar.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || jVar.g != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 6, kotlinx.serialization.internal.v2.a, jVar.g);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 7) || jVar.h != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 7, kotlinx.serialization.internal.v2.a, jVar.h);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 8) || jVar.i != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 8, kotlinx.serialization.internal.v2.a, jVar.i);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 9) || jVar.j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 9, kotlinx.serialization.internal.v2.a, jVar.j);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 10) || jVar.k != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 10, kotlinx.serialization.internal.v2.a, jVar.k);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 11) || jVar.l != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 11, kotlinx.serialization.internal.v2.a, jVar.l);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 12) || jVar.m != null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 12, kotlinx.serialization.internal.v2.a, jVar.m);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 13) || jVar.n != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 13, kotlinx.serialization.internal.v2.a, jVar.n);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 14) || jVar.o != null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 14, kotlinx.serialization.internal.v2.a, jVar.o);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 15) || jVar.p != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 15, kotlinx.serialization.internal.v2.a, jVar.p);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 16) || jVar.q != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 16, kotlinx.serialization.internal.v2.a, jVar.q);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 17) || jVar.r != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 17, kotlinx.serialization.internal.v2.a, jVar.r);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 18) || jVar.s != null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 18, kotlinx.serialization.internal.v2.a, jVar.s);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 19) || jVar.t != null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (z20) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 19, kotlinx.serialization.internal.v2.a, jVar.t);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 20) || jVar.u != null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z21) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 20, kotlinx.serialization.internal.v2.a, jVar.u);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 21) || jVar.v != null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (z22) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 21, kotlinx.serialization.internal.v2.a, jVar.v);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 22) || jVar.w != null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z23) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 22, kotlinx.serialization.internal.v2.a, jVar.w);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 23) || jVar.x != null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (z24) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 23, kotlinx.serialization.internal.v2.a, jVar.x);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 24) || jVar.y != null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z25) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 24, kotlinx.serialization.internal.v2.a, jVar.y);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 25) || jVar.z != null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 25, kotlinx.serialization.internal.v2.a, jVar.z);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 26) || jVar.A != null) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 26, kotlinx.serialization.internal.v2.a, jVar.A);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 27) || jVar.B != null) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z28) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 27, kotlinx.serialization.internal.v2.a, jVar.B);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 28) || jVar.C != null) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (z29) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 28, kotlinx.serialization.internal.v2.a, jVar.C);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 29) || jVar.D != null) {
            z30 = true;
        } else {
            z30 = false;
        }
        if (z30) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 29, kotlinx.serialization.internal.v2.a, jVar.D);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 30) || jVar.E != null) {
            z31 = true;
        } else {
            z31 = false;
        }
        if (z31) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 30, kotlinx.serialization.internal.v2.a, jVar.E);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 31) || jVar.F != null) {
            z32 = true;
        } else {
            z32 = false;
        }
        if (z32) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 31, kotlinx.serialization.internal.v2.a, jVar.F);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 32) || jVar.G != null) {
            z33 = true;
        } else {
            z33 = false;
        }
        if (z33) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 32, kotlinx.serialization.internal.v2.a, jVar.G);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 33) || jVar.H != null) {
            z34 = true;
        } else {
            z34 = false;
        }
        if (z34) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 33, kotlinx.serialization.internal.v2.a, jVar.H);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 34) || jVar.I != null) {
            z35 = true;
        } else {
            z35 = false;
        }
        if (z35) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 34, kotlinx.serialization.internal.v2.a, jVar.I);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 35) || jVar.J != null) {
            z36 = true;
        } else {
            z36 = false;
        }
        if (z36) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 35, kotlinx.serialization.internal.v2.a, jVar.J);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 36) || jVar.K != null) {
            z37 = true;
        } else {
            z37 = false;
        }
        if (z37) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 36, kotlinx.serialization.internal.v2.a, jVar.K);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 37) || jVar.L != null) {
            z38 = true;
        } else {
            z38 = false;
        }
        if (z38) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 37, kSerializerArr[37], jVar.L);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 38) || jVar.M != null) {
            z39 = true;
        } else {
            z39 = false;
        }
        if (z39) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 38, kotlinx.serialization.internal.v2.a, jVar.M);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 39) || jVar.N != null) {
            z40 = true;
        } else {
            z40 = false;
        }
        if (z40) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 39, kotlinx.serialization.internal.v2.a, jVar.N);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 40) || jVar.O != null) {
            z41 = true;
        } else {
            z41 = false;
        }
        if (z41) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 40, kotlinx.serialization.internal.v2.a, jVar.O);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 41) || jVar.P != null) {
            z42 = true;
        } else {
            z42 = false;
        }
        if (z42) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 41, kotlinx.serialization.internal.v2.a, jVar.P);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 42) || jVar.Q != null) {
            z43 = true;
        } else {
            z43 = false;
        }
        if (z43) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 42, kotlinx.serialization.internal.v2.a, jVar.Q);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 43) || jVar.R != null) {
            z44 = true;
        } else {
            z44 = false;
        }
        if (z44) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 43, kotlinx.serialization.internal.v2.a, jVar.R);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 44) || jVar.S != null) {
            z45 = true;
        } else {
            z45 = false;
        }
        if (z45) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 44, kotlinx.serialization.internal.v2.a, jVar.S);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 45) || jVar.T != null) {
            z46 = true;
        } else {
            z46 = false;
        }
        if (z46) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 45, kotlinx.serialization.internal.v2.a, jVar.T);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 46) || jVar.U != null) {
            z47 = true;
        } else {
            z47 = false;
        }
        if (z47) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 46, kotlinx.serialization.internal.v2.a, jVar.U);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 47) || jVar.V != null) {
            z48 = true;
        } else {
            z48 = false;
        }
        if (z48) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 47, kotlinx.serialization.internal.v2.a, jVar.V);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 48) || jVar.W != null) {
            z49 = true;
        } else {
            z49 = false;
        }
        if (z49) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 48, kotlinx.serialization.internal.v2.a, jVar.W);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 49) || jVar.X != null) {
            z50 = true;
        } else {
            z50 = false;
        }
        if (z50) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 49, kotlinx.serialization.internal.v2.a, jVar.X);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 50) || jVar.Y != null) {
            z51 = true;
        } else {
            z51 = false;
        }
        if (z51) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 50, kotlinx.serialization.internal.v2.a, jVar.Y);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 51) || jVar.Z != null) {
            z52 = true;
        } else {
            z52 = false;
        }
        if (z52) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 51, kotlinx.serialization.internal.v2.a, jVar.Z);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 52) || jVar.a0 != null) {
            z53 = true;
        } else {
            z53 = false;
        }
        if (z53) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 52, kotlinx.serialization.internal.v2.a, jVar.a0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 53) || jVar.b0 != null) {
            z54 = true;
        } else {
            z54 = false;
        }
        if (z54) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 53, kotlinx.serialization.internal.v2.a, jVar.b0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 54) || jVar.c0 != null) {
            z55 = true;
        } else {
            z55 = false;
        }
        if (z55) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 54, c4.a.a, jVar.c0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 55) || jVar.d0 != null) {
            z56 = true;
        } else {
            z56 = false;
        }
        if (z56) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 55, kotlinx.serialization.internal.v2.a, jVar.d0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 56) || jVar.e0 != null) {
            z57 = true;
        } else {
            z57 = false;
        }
        if (z57) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 56, kotlinx.serialization.internal.v2.a, jVar.e0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 57) || jVar.f0 != null) {
            z58 = true;
        } else {
            z58 = false;
        }
        if (z58) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 57, kotlinx.serialization.internal.v2.a, jVar.f0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 58) || jVar.g0 != null) {
            z59 = true;
        } else {
            z59 = false;
        }
        if (z59) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 58, kotlinx.serialization.internal.v2.a, jVar.g0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 59) || jVar.h0 != null) {
            z60 = true;
        } else {
            z60 = false;
        }
        if (z60) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 59, kotlinx.serialization.internal.v2.a, jVar.h0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 60) || jVar.i0 != null) {
            z61 = true;
        } else {
            z61 = false;
        }
        if (z61) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 60, kotlinx.serialization.internal.v2.a, jVar.i0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 61) || jVar.j0 != null) {
            z62 = true;
        } else {
            z62 = false;
        }
        if (z62) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 61, kotlinx.serialization.internal.v2.a, jVar.j0);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 62) || jVar.k0 != null) {
            z63 = true;
        }
        if (z63) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 62, kotlinx.serialization.internal.v2.a, jVar.k0);
        }
    }

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, List<String> list, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, c4 c4Var, String str54, String str55, String str56, String str57, String str58, String str59, String str60, String str61) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = str13;
        this.n = str14;
        this.o = str15;
        this.p = str16;
        this.q = str17;
        this.r = str18;
        this.s = str19;
        this.t = str20;
        this.u = str21;
        this.v = str22;
        this.w = str23;
        this.x = str24;
        this.y = str25;
        this.z = str26;
        this.A = str27;
        this.B = str28;
        this.C = str29;
        this.D = str30;
        this.E = str31;
        this.F = str32;
        this.G = str33;
        this.H = str34;
        this.I = str35;
        this.J = str36;
        this.K = str37;
        this.L = list;
        this.M = str38;
        this.N = str39;
        this.O = str40;
        this.P = str41;
        this.Q = str42;
        this.R = str43;
        this.S = str44;
        this.T = str45;
        this.U = str46;
        this.V = str47;
        this.W = str48;
        this.X = str49;
        this.Y = str50;
        this.Z = str51;
        this.a0 = str52;
        this.b0 = str53;
        this.c0 = c4Var;
        this.d0 = str54;
        this.e0 = str55;
        this.f0 = str56;
        this.g0 = str57;
        this.h0 = str58;
        this.i0 = str59;
        this.j0 = str60;
        this.k0 = str61;
    }
}
