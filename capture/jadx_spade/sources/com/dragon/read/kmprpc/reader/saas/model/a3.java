package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
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
public final class a3 {
    public static final b Companion;
    public String a;
    public String b;

    static {
        Covode.recordClassIndex(610363);
        Companion = new b(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a3() {
        this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static final class a implements kotlinx.serialization.internal.m0<a3> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.MultiFullImageRequest", aVar, 2);
            g2Var.g("book_id", true);
            g2Var.g("item_id_list", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
            return new KSerializer[]{en6.a.u(v2Var), en6.a.u(v2Var)};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a3 deserialize(Decoder decoder) {
            String str;
            int i;
            String str2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            kotlinx.serialization.internal.q2 q2Var = null;
            if (beginStructure.decodeSequentially()) {
                kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
                str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, v2Var, null);
                str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, v2Var, null);
                i = 3;
            } else {
                str = null;
                String str3 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex == 1) {
                                str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v2.a, str);
                                i2 |= 2;
                            } else {
                                throw new UnknownFieldException(decodeElementIndex);
                            }
                        } else {
                            str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v2.a, str3);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                str2 = str3;
            }
            beginStructure.endStructure(descriptor2);
            return new a3(i, str2, str, q2Var);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, a3 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            a3.a(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610364);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<a3> serializer() {
            return a.a;
        }
    }

    public a3(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static final /* synthetic */ void a(a3 a3Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || a3Var.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v2.a, a3Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || a3Var.b != null) {
            z2 = true;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v2.a, a3Var.b);
        }
    }

    public /* synthetic */ a3(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public /* synthetic */ a3(int i, @SerialName("book_id") String str, @SerialName("item_id_list") String str2, kotlinx.serialization.internal.q2 q2Var) {
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
            this.b = str2;
        }
    }
}
