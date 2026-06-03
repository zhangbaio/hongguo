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
public final class v1 implements KSerializer<ExcerptType> {
    public static final v1 b;
    private final /* synthetic */ KSerializer<ExcerptType> a = new a();

    static {
        Covode.recordClassIndex(610114);
        b = new v1();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ExcerptType deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return this.a.deserialize(decoder);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, ExcerptType value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a.serialize(encoder, value);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.a.getDescriptor();
    }

    public static final class a implements KSerializer<ExcerptType> {
        public final ExcerptType[] a = ExcerptType.values();
        public final String b = Reflection.getOrCreateKotlinClass(ExcerptType.class).getSimpleName();
        private final SerialDescriptor c = SerialDescriptorsKt.PrimitiveSerialDescriptor("EnumAsOrdinal", b.f.a);

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return this.c;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ExcerptType deserialize(Decoder decoder) {
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            int decodeInt = decoder.decodeInt();
            for (ExcerptType excerptType : this.a) {
                if (excerptType.getValue() == decodeInt) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return excerptType;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        @Override // kotlinx.serialization.SerializationStrategy
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, ExcerptType value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.encodeInt(value.getValue());
        }
    }

    private v1() {
    }
}
