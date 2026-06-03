package ip4;

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
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final b Companion;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    static {
        Covode.recordClassIndex(609276);
        Companion = new b(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.a, eVar.a) && Intrinsics.areEqual(this.b, eVar.b) && Intrinsics.areEqual(this.c, eVar.c) && Intrinsics.areEqual(this.d, eVar.d);
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "RecommendExtra(postId=" + this.a + ", postIdFirst=" + this.b + ", bookId=" + this.c + ", bookIdFirst=" + this.d + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609277);
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
            g2 g2Var = new g2("com.dragon.read.kmp.story.impl.feeds.data.idl.RecommendExtra", aVar, 4);
            g2Var.g("post_id", false);
            g2Var.g("post_id_first", false);
            g2Var.g("book_id", false);
            g2Var.g("book_id_first", false);
            descriptor = g2Var;
        }

        public final KSerializer<?>[] b() {
            v2 v2Var = v2.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var), en6.a.u(v2Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final e deserialize(Decoder decoder) {
            int i;
            String str;
            String str2;
            String str3;
            String str4;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            String str5 = null;
            if (beginStructure.decodeSequentially()) {
                v2 v2Var = v2.a;
                String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2Var, null);
                String str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2Var, null);
                String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2Var, null);
                str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, v2Var, null);
                str3 = str8;
                str2 = str7;
                str = str6;
                i = 15;
            } else {
                String str9 = null;
                String str10 = null;
                String str11 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex != 2) {
                                    if (decodeElementIndex == 3) {
                                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, v2.a, str11);
                                        i2 |= 8;
                                    } else {
                                        throw new UnknownFieldException(decodeElementIndex);
                                    }
                                } else {
                                    str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, v2.a, str10);
                                    i2 |= 4;
                                }
                            } else {
                                str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, v2.a, str9);
                                i2 |= 2;
                            }
                        } else {
                            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, v2.a, str5);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                str = str5;
                str2 = str9;
                str3 = str10;
                str4 = str11;
            }
            beginStructure.endStructure(serialDescriptor);
            return new e(i, str, str2, str3, str4, null);
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
        v2 v2Var = v2.a;
        dVar.encodeNullableSerializableElement(serialDescriptor, 0, v2Var, eVar.a);
        dVar.encodeNullableSerializableElement(serialDescriptor, 1, v2Var, eVar.b);
        dVar.encodeNullableSerializableElement(serialDescriptor, 2, v2Var, eVar.c);
        dVar.encodeNullableSerializableElement(serialDescriptor, 3, v2Var, eVar.d);
    }

    public e(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public /* synthetic */ e(int i, String str, String str2, String str3, String str4, q2 q2Var) {
        if (15 != (i & 15)) {
            b2.b(i, 15, a.a.getDescriptor());
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }
}
