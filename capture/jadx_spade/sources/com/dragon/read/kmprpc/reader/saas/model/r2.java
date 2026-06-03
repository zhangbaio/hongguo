package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
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
public final class r2 {
    public static final b Companion;
    private static final KSerializer<Object>[] b;
    public Map<String, ? extends List<String>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public r2() {
        this((Map) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static final class a implements kotlinx.serialization.internal.m0<r2> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.kmprpc.reader.saas.model.ItemImage", aVar, 1);
            g2Var.g("image_url_data", true);
            descriptor = g2Var;
        }

        public KSerializer<?>[] b() {
            return new KSerializer[]{en6.a.u(r2.b[0])};
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public r2 deserialize(Decoder decoder) {
            Map map;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor2);
            KSerializer[] kSerializerArr = r2.b;
            int i = 1;
            kotlinx.serialization.internal.q2 q2Var = null;
            if (beginStructure.decodeSequentially()) {
                map = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            } else {
                Map map2 = null;
                int i2 = 0;
                while (i != 0) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex == 0) {
                            map2 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kSerializerArr[0], map2);
                            i2 |= 1;
                        } else {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                    } else {
                        i = 0;
                    }
                }
                map = map2;
                i = i2;
            }
            beginStructure.endStructure(descriptor2);
            return new r2(i, map, q2Var);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, r2 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor descriptor2 = getDescriptor();
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor2);
            r2.b(value, beginStructure, descriptor2);
            beginStructure.endStructure(descriptor2);
        }
    }

    public static final class b {
        static {
            Covode.recordClassIndex(610286);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<r2> serializer() {
            return a.a;
        }
    }

    static {
        Covode.recordClassIndex(610285);
        Companion = new b(null);
        kotlinx.serialization.internal.v2 v2Var = kotlinx.serialization.internal.v2.a;
        b = new KSerializer[]{new kotlinx.serialization.internal.a1(v2Var, new kotlinx.serialization.internal.f(v2Var))};
    }

    public r2(Map<String, ? extends List<String>> map) {
        this.a = map;
    }

    public /* synthetic */ r2(int i, @SerialName("image_url_data") Map map, kotlinx.serialization.internal.q2 q2Var) {
        if ((i & 0) != 0) {
            kotlinx.serialization.internal.b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = map;
        }
    }

    public static final /* synthetic */ void b(r2 r2Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = b;
        boolean z = true;
        if (!dVar.shouldEncodeElementDefault(serialDescriptor, 0) && r2Var.a == null) {
            z = false;
        }
        if (z) {
            dVar.encodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], r2Var.a);
        }
    }

    public /* synthetic */ r2(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }
}
