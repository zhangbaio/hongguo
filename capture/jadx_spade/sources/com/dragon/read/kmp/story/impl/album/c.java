package com.dragon.read.kmp.story.impl.album;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.us;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
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
public final class c implements com.dragon.read.kmp.story.impl.album.base.a {
    public static final b Companion;
    public static final int h;
    private static final Lazy<KSerializer<Object>>[] i;
    public String a;
    public String b;
    public String c;
    public List<us> d;
    public String e;
    public Integer f;
    public String g;

    public c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer c() {
        return new kotlinx.serialization.internal.f(us.a.a);
    }

    @Override // com.dragon.read.kmp.story.impl.album.base.a
    public com.dragon.read.kmp.story.impl.album.base.a copy() {
        return this;
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609202);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<c> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<c> {
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
            g2 g2Var = new g2("com.dragon.read.kmp.story.impl.album.StoryAlbumDetail", aVar, 7);
            g2Var.g("abstract", true);
            g2Var.g("book_id", true);
            g2Var.g("book_name", true);
            g2Var.g("recommend_reason_list", true);
            g2Var.g("thumb_url", true);
            g2Var.g("genre_type", true);
            g2Var.g("genre", true);
            descriptor = g2Var;
        }

        public final KSerializer<?>[] b() {
            Lazy[] lazyArr = c.i;
            v2 v2Var = v2.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u((KSerializer) lazyArr[3].getValue()), en6.a.u(v2Var), en6.a.u(v0.a), en6.a.u(v2Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final c deserialize(Decoder decoder) {
            String str;
            int i;
            Integer num;
            String str2;
            String str3;
            String str4;
            List list;
            String str5;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            Lazy[] lazyArr = c.i;
            int i2 = 6;
            String str6 = null;
            if (beginStructure.decodeSequentially()) {
                v2 v2Var = v2.a;
                str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2Var, null);
                String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2Var, null);
                String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2Var, null);
                List list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
                String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, v2Var, null);
                Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, v0.a, null);
                list = list2;
                str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, v2Var, null);
                num = num2;
                str5 = str9;
                str4 = str8;
                str3 = str7;
                i = 127;
            } else {
                String str10 = null;
                Integer num3 = null;
                String str11 = null;
                String str12 = null;
                List list3 = null;
                String str13 = null;
                int i3 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            i2 = 6;
                            z = false;
                        case 0:
                            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2.a, str6);
                            i3 |= 1;
                            i2 = 6;
                        case 1:
                            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2.a, str11);
                            i3 |= 2;
                            i2 = 6;
                        case 2:
                            str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2.a, str12);
                            i3 |= 4;
                            i2 = 6;
                        case 3:
                            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list3);
                            i3 |= 8;
                        case 4:
                            str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, v2.a, str13);
                            i3 |= 16;
                        case 5:
                            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, v0.a, num3);
                            i3 |= 32;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, v2.a, str10);
                            i3 |= 64;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                str = str10;
                i = i3;
                String str14 = str13;
                num = num3;
                str2 = str6;
                str3 = str11;
                str4 = str12;
                list = list3;
                str5 = str14;
            }
            beginStructure.endStructure(serialDescriptor);
            return new c(i, str2, str3, str4, list, str5, num, str, null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, c value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            c.e(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    @Override // com.dragon.read.kmp.story.impl.album.base.a
    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append("album_");
        String str = this.b;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(609201);
        Companion = new b(null);
        h = 8;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.dragon.read.kmp.story.impl.album.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer c;
                c = c.c();
                return c;
            }
        });
        i = new Lazy[]{null, null, null, lazy, null, null, null};
    }

    public static final /* synthetic */ void e(c cVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Lazy<KSerializer<Object>>[] lazyArr = i;
        boolean z7 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || cVar.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, v2.a, cVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || cVar.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, v2.a, cVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || cVar.c != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, v2.a, cVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || cVar.d != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, lazyArr[3].getValue(), cVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || cVar.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, v2.a, cVar.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || cVar.f != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, v0.a, cVar.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || cVar.g != null) {
            z7 = true;
        }
        if (z7) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 6, v2.a, cVar.g);
        }
    }

    public /* synthetic */ c(int i2, String str, String str2, String str3, List list, String str4, Integer num, String str5, q2 q2Var) {
        if ((i2 & 0) != 0) {
            b2.b(i2, 0, a.a.getDescriptor());
        }
        if ((i2 & 1) == 0) {
            this.a = null;
        } else {
            this.a = str;
        }
        if ((i2 & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i2 & 4) == 0) {
            this.c = null;
        } else {
            this.c = str3;
        }
        if ((i2 & 8) == 0) {
            this.d = null;
        } else {
            this.d = list;
        }
        if ((i2 & 16) == 0) {
            this.e = null;
        } else {
            this.e = str4;
        }
        if ((i2 & 32) == 0) {
            this.f = null;
        } else {
            this.f = num;
        }
        if ((i2 & 64) == 0) {
            this.g = null;
        } else {
            this.g = str5;
        }
    }
}
