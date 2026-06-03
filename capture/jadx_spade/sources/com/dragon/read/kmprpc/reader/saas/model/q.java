package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmprpc.reader.saas.model.p2;
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
public final class q {
    public static final b Companion;
    private static final KSerializer<Object>[] d;
    public Integer a;
    public String b;
    public Map<String, p2> c;

    public q() {
        this((Integer) null, (String) null, (Map) null, 7, (DefaultConstructorMarker) null);
    }

    public static final class a implements kotlinx.serialization.internal.m0<q> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.BatchFullResponse", aVar, 3);
            g2Var.g("code", true);
            g2Var.g("message", true);
            g2Var.g("data", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            return new KSerializer[]{en6.a.u(kotlinx.serialization.internal.v0.a), en6.a.u(kotlinx.serialization.internal.v2.a), en6.a.u(q.d[2])};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public q deserialize(Decoder decoder) {
            int i;
            Integer num;
            String str;
            Map map;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            KSerializer[] kSerializerArr = q.d;
            Integer num2 = null;
            if (beginStructure.decodeSequentially()) {
                Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, null);
                String str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v2.a, null);
                map = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], null);
                num = num3;
                str = str2;
                i = 7;
            } else {
                String str3 = null;
                Map map2 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex == 2) {
                                    map2 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], map2);
                                    i2 |= 4;
                                } else {
                                    throw new UnknownFieldException(decodeElementIndex);
                                }
                            } else {
                                str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kotlinx.serialization.internal.v2.a, str3);
                                i2 |= 2;
                            }
                        } else {
                            num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kotlinx.serialization.internal.v0.a, num2);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                num = num2;
                str = str3;
                map = map2;
            }
            beginStructure.endStructure(descriptor2);
            return new q(i, num, str, map, (kotlinx.serialization.internal.q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, q value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            q.b(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609784);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<q> serializer() {
            return a.a;
        }
    }

    static {
        Covode.recordClassIndex(609783);
        Companion = new b(null);
        d = new KSerializer[]{null, null, new kotlinx.serialization.internal.a1(kotlinx.serialization.internal.v2.a, p2.a.a)};
    }

    public q(Integer num, String str, Map<String, p2> map) {
        this.a = num;
        this.b = str;
        this.c = map;
    }

    public static final /* synthetic */ void b(q qVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        KSerializer<Object>[] kSerializerArr = d;
        boolean z3 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || qVar.a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kotlinx.serialization.internal.v0.a, qVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || qVar.b != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 1, kotlinx.serialization.internal.v2.a, qVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || qVar.c != null) {
            z3 = true;
        }
        if (z3) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 2, kSerializerArr[2], qVar.c);
        }
    }

    public /* synthetic */ q(int i, @SerialName("code") Integer num, @SerialName("message") String str, @SerialName("data") Map map, kotlinx.serialization.internal.q2 q2Var) {
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
            this.c = map;
        }
    }

    public /* synthetic */ q(Integer num, String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : map);
    }
}
