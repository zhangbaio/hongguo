package iq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.widget.filter.FilterSelectionKMP;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import iq4.d;
import java.util.ArrayList;
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
import kotlinx.serialization.internal.f;
import kotlinx.serialization.internal.g2;
import kotlinx.serialization.internal.i0;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import kotlinx.serialization.internal.v0;
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final b Companion;
    public static final int h;
    private static final Lazy<KSerializer<Object>>[] i;
    public String a;
    public String b;
    public FilterSelectionKMP c;
    public int d;
    public String e;
    public int f;
    public List<d> g;

    public c() {
        this((String) null, (String) null, (FilterSelectionKMP) null, 0, (String) null, 0, (List) null, 127, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer c() {
        return i0.b("com.dragon.read.kmp.widget.filter.FilterSelectionKMP", FilterSelectionKMP.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer d() {
        return new f(d.a.a);
    }

    public static /* synthetic */ c g(c cVar, String str, String str2, FilterSelectionKMP filterSelectionKMP, int i2, String str3, int i3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = cVar.a;
        }
        if ((i4 & 2) != 0) {
            str2 = cVar.b;
        }
        String str4 = str2;
        if ((i4 & 4) != 0) {
            filterSelectionKMP = cVar.c;
        }
        FilterSelectionKMP filterSelectionKMP2 = filterSelectionKMP;
        if ((i4 & 8) != 0) {
            i2 = cVar.d;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            str3 = cVar.e;
        }
        String str5 = str3;
        if ((i4 & 32) != 0) {
            i3 = cVar.f;
        }
        int i6 = i3;
        if ((i4 & 64) != 0) {
            list = cVar.g;
        }
        return cVar.f(str, str4, filterSelectionKMP2, i5, str5, i6, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b) && this.c == cVar.c && this.d == cVar.d && Intrinsics.areEqual(this.e, cVar.e) && this.f == cVar.f && Intrinsics.areEqual(this.g, cVar.g);
    }

    public final c f(String str, String str2, FilterSelectionKMP filterSelectionKMP, int i2, String str3, int i3, List<d> filterItemList) {
        Intrinsics.checkNotNullParameter(filterItemList, "filterItemList");
        return new c(str, str2, filterSelectionKMP, i2, str3, i3, filterItemList);
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        FilterSelectionKMP filterSelectionKMP = this.c;
        int hashCode3 = (((hashCode2 + (filterSelectionKMP == null ? 0 : filterSelectionKMP.hashCode())) * 31) + this.d) * 31;
        String str3 = this.e;
        return ((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "FilterDimensionKMP(name=" + this.a + ", type=" + this.b + ", filterSelection=" + this.c + ", maxAlternativeCount=" + this.d + ", alternativeTipName=" + this.e + ", currentCount=" + this.f + ", filterItemList=" + this.g + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609684);
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

    public final String getType() {
        return this.b;
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
            g2 g2Var = new g2("com.dragon.read.kmp.widget.filter.FilterDimensionKMP", aVar, 7);
            g2Var.g("name", true);
            g2Var.g("type", true);
            g2Var.g("filterSelection", true);
            g2Var.g("maxAlternativeCount", true);
            g2Var.g("alternativeTipName", true);
            g2Var.g("currentCount", true);
            g2Var.g("filterItemList", true);
            descriptor = g2Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final KSerializer<?>[] b() {
            Lazy[] lazyArr = c.i;
            v2 v2Var = v2.a;
            v0 v0Var = v0.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u((KSerializer) lazyArr[2].getValue()), v0Var, en6.a.u(v2Var), v0Var, lazyArr[6].getValue()};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final c deserialize(Decoder decoder) {
            int i;
            List list;
            String str;
            int i2;
            String str2;
            int i3;
            String str3;
            FilterSelectionKMP filterSelectionKMP;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            Lazy[] lazyArr = c.i;
            int i4 = 5;
            int i5 = 3;
            if (beginStructure.decodeSequentially()) {
                v2 v2Var = v2.a;
                String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2Var, null);
                String str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2Var, null);
                FilterSelectionKMP filterSelectionKMP2 = (FilterSelectionKMP) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
                int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
                String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, v2Var, null);
                int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 5);
                list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
                str = str6;
                i = decodeIntElement2;
                i3 = decodeIntElement;
                filterSelectionKMP = filterSelectionKMP2;
                str2 = str5;
                str3 = str4;
                i2 = 127;
            } else {
                List list2 = null;
                String str7 = null;
                String str8 = null;
                String str9 = null;
                FilterSelectionKMP filterSelectionKMP3 = null;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            i5 = 3;
                            z = false;
                        case 0:
                            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2.a, str8);
                            i8 |= 1;
                            i4 = 5;
                            i5 = 3;
                        case 1:
                            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2.a, str9);
                            i8 |= 2;
                            i4 = 5;
                            i5 = 3;
                        case 2:
                            filterSelectionKMP3 = (FilterSelectionKMP) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), filterSelectionKMP3);
                            i8 |= 4;
                            i4 = 5;
                        case 3:
                            i7 = beginStructure.decodeIntElement(serialDescriptor, i5);
                            i8 |= 8;
                        case 4:
                            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, v2.a, str7);
                            i8 |= 16;
                        case 5:
                            i6 = beginStructure.decodeIntElement(serialDescriptor, i4);
                            i8 |= 32;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list2);
                            i8 |= 64;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                i = i6;
                list = list2;
                FilterSelectionKMP filterSelectionKMP4 = filterSelectionKMP3;
                str = str7;
                i2 = i8;
                str2 = str9;
                i3 = i7;
                str3 = str8;
                filterSelectionKMP = filterSelectionKMP4;
            }
            beginStructure.endStructure(serialDescriptor);
            return new c(i2, str3, str2, filterSelectionKMP, i3, str, i, list, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, c value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            c.i(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Lazy<KSerializer<Object>> lazy2;
        Covode.recordClassIndex(609683);
        Companion = new b(null);
        h = 8;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: iq4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer c;
                c = c.c();
                return c;
            }
        });
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: iq4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer d;
                d = c.d();
                return d;
            }
        });
        i = new Lazy[]{null, null, lazy, null, null, null, lazy2};
    }

    public final void h(List<d> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.g = list;
    }

    public static final /* synthetic */ void i(c cVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
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
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, lazyArr[2].getValue(), cVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || cVar.d != 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeIntElement(serialDescriptor, 3, cVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual(cVar.e, "标签")) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 4, v2.a, cVar.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || cVar.f != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeIntElement(serialDescriptor, 5, cVar.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || !Intrinsics.areEqual(cVar.g, new ArrayList())) {
            z7 = true;
        }
        if (z7) {
            dVar.encodeSerializableElement(serialDescriptor, 6, lazyArr[6].getValue(), cVar.g);
        }
    }

    public c(String str, String str2, FilterSelectionKMP filterSelectionKMP, int i2, String str3, int i3, List<d> filterItemList) {
        Intrinsics.checkNotNullParameter(filterItemList, "filterItemList");
        this.a = str;
        this.b = str2;
        this.c = filterSelectionKMP;
        this.d = i2;
        this.e = str3;
        this.f = i3;
        this.g = filterItemList;
    }

    public /* synthetic */ c(int i2, String str, String str2, FilterSelectionKMP filterSelectionKMP, int i3, String str3, int i4, List list, q2 q2Var) {
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
            this.c = filterSelectionKMP;
        }
        if ((i2 & 8) == 0) {
            this.d = 1;
        } else {
            this.d = i3;
        }
        if ((i2 & 16) == 0) {
            this.e = "标签";
        } else {
            this.e = str3;
        }
        if ((i2 & 32) == 0) {
            this.f = 0;
        } else {
            this.f = i4;
        }
        if ((i2 & 64) == 0) {
            this.g = new ArrayList();
        } else {
            this.g = list;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(java.lang.String r6, java.lang.String r7, com.dragon.read.kmp.widget.filter.FilterSelectionKMP r8, int r9, java.lang.String r10, int r11, java.util.List r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L7
            r14 = r0
            goto L8
        L7:
            r14 = r6
        L8:
            r6 = r13 & 2
            if (r6 == 0) goto Le
            r1 = r0
            goto Lf
        Le:
            r1 = r7
        Lf:
            r6 = r13 & 4
            if (r6 == 0) goto L14
            goto L15
        L14:
            r0 = r8
        L15:
            r6 = r13 & 8
            if (r6 == 0) goto L1c
            r9 = 1
            r2 = 1
            goto L1d
        L1c:
            r2 = r9
        L1d:
            r6 = r13 & 16
            if (r6 == 0) goto L24
            java.lang.String r10 = "标签"
        L24:
            r3 = r10
            r6 = r13 & 32
            if (r6 == 0) goto L2c
            r11 = 0
            r4 = 0
            goto L2d
        L2c:
            r4 = r11
        L2d:
            r6 = r13 & 64
            if (r6 == 0) goto L36
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
        L36:
            r13 = r12
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r0
            r10 = r2
            r11 = r3
            r12 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: iq4.c.<init>(java.lang.String, java.lang.String, com.dragon.read.kmp.widget.filter.FilterSelectionKMP, int, java.lang.String, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
