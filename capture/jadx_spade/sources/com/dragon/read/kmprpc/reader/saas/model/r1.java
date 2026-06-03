package com.dragon.read.kmprpc.reader.saas.model;

import com.bytedance.covode.number.Covode;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.b;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r1 implements KSerializer<EcomSearchResultStyle> {
    public static final r1 b;
    private final /* synthetic */ KSerializer<EcomSearchResultStyle> a = new a();

    static {
        Covode.recordClassIndex(610092);
        b = new r1();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public EcomSearchResultStyle deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return this.a.deserialize(decoder);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, EcomSearchResultStyle value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a.serialize(encoder, value);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.a.getDescriptor();
    }

    public static final class a implements KSerializer<EcomSearchResultStyle> {
        public final EcomSearchResultStyle[] a = EcomSearchResultStyle.values();
        public final String b = Reflection.getOrCreateKotlinClass(EcomSearchResultStyle.class).getSimpleName();
        private final SerialDescriptor c = SerialDescriptorsKt.PrimitiveSerialDescriptor("EnumAsOrdinal", b.f.a);

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return this.c;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public EcomSearchResultStyle deserialize(Decoder decoder) {
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            int decodeInt = decoder.decodeInt();
            for (EcomSearchResultStyle ecomSearchResultStyle : this.a) {
                if (ecomSearchResultStyle.getValue() == decodeInt) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return ecomSearchResultStyle;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        @Override // kotlinx.serialization.SerializationStrategy
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, EcomSearchResultStyle value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.encodeInt(value.getValue());
        }
    }

    private r1() {
    }
}
