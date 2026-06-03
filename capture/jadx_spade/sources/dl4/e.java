package dl4;

import com.bytedance.covode.number.Covode;
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
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final b Companion;
    public static final int g;
    private static final Lazy<KSerializer<Object>>[] h;
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final List<String> e;
    public final String f;

    public e() {
        this((String) null, (String) null, (String) null, (List) null, (List) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer c() {
        return new kotlinx.serialization.internal.f(v2.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer d() {
        return new kotlinx.serialization.internal.f(v2.a);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608076);
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
            g2 g2Var = new g2("com.dragon.read.kmp.profile.data.RankLabel", aVar, 6);
            g2Var.g("title_text", true);
            g2Var.g("title_default_color", true);
            g2Var.g("title_dark_color", true);
            g2Var.g("bg_default_color_list", true);
            g2Var.g("bg_dark_color_list", true);
            g2Var.g("jump_schema", true);
            descriptor = g2Var;
        }

        public final KSerializer<?>[] b() {
            Lazy[] lazyArr = e.h;
            v2 v2Var = v2.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u((KSerializer) lazyArr[3].getValue()), en6.a.u((KSerializer) lazyArr[4].getValue()), en6.a.u(v2Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final e deserialize(Decoder decoder) {
            List list;
            String str;
            String str2;
            List list2;
            String str3;
            String str4;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            Lazy[] lazyArr = e.h;
            int i2 = 5;
            String str5 = null;
            if (beginStructure.decodeSequentially()) {
                v2 v2Var = v2.a;
                String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2Var, null);
                String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2Var, null);
                String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2Var, null);
                List list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
                list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
                str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, v2Var, null);
                str2 = str8;
                list2 = list3;
                str4 = str7;
                str3 = str6;
                i = 63;
            } else {
                String str9 = null;
                String str10 = null;
                List list4 = null;
                List list5 = null;
                String str11 = null;
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
                            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2.a, str5);
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
                            list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list4);
                            i3 |= 8;
                            break;
                        case 4:
                            list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list5);
                            i3 |= 16;
                            break;
                        case 5:
                            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, v2.a, str11);
                            i3 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                list = list5;
                str = str11;
                str2 = str10;
                list2 = list4;
                str3 = str5;
                str4 = str9;
                i = i3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new e(i, str3, str4, str2, list2, list, str, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, e value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            e.f(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Lazy<KSerializer<Object>> lazy2;
        Covode.recordClassIndex(608075);
        Companion = new b(null);
        g = 8;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: dl4.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer c;
                c = e.c();
                return c;
            }
        });
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: dl4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer d;
                d = e.d();
                return d;
            }
        });
        h = new Lazy[]{null, null, null, lazy, lazy2, null};
    }

    public static final /* synthetic */ void f(e eVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Lazy<KSerializer<Object>>[] lazyArr = h;
        boolean z6 = false;
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
            dVar.encodeNullableSerializableElement(serialDescriptor, 3, lazyArr[3].getValue(), eVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || eVar.e != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, lazyArr[4].getValue(), eVar.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || eVar.f != null) {
            z6 = true;
        }
        if (z6) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 5, v2.a, eVar.f);
        }
    }

    public e(String str, String str2, String str3, List<String> list, List<String> list2, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = list2;
        this.f = str4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ e(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.util.List r9, java.util.List r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: dl4.e.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public /* synthetic */ e(int i, String str, String str2, String str3, List list, List list2, String str4, q2 q2Var) {
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
            this.d = list;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = list2;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = str4;
        }
    }
}
