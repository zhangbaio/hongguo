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
public final class l6 implements KSerializer<SquarePicStyle> {
    public static final l6 b;
    private final /* synthetic */ KSerializer<SquarePicStyle> a = new a();

    static {
        Covode.recordClassIndex(610845);
        b = new l6();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SquarePicStyle deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return this.a.deserialize(decoder);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, SquarePicStyle value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a.serialize(encoder, value);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.a.getDescriptor();
    }

    public static final class a implements KSerializer<SquarePicStyle> {
        public final SquarePicStyle[] a = SquarePicStyle.values();
        public final String b = Reflection.getOrCreateKotlinClass(SquarePicStyle.class).getSimpleName();
        private final SerialDescriptor c = SerialDescriptorsKt.PrimitiveSerialDescriptor("EnumAsOrdinal", b.f.a);

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public SerialDescriptor getDescriptor() {
            return this.c;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SquarePicStyle deserialize(Decoder decoder) {
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            int decodeInt = decoder.decodeInt();
            for (SquarePicStyle squarePicStyle : this.a) {
                if (squarePicStyle.getValue() == decodeInt) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return squarePicStyle;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        @Override // kotlinx.serialization.SerializationStrategy
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void serialize(Encoder encoder, SquarePicStyle value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.encodeInt(value.getValue());
        }
    }

    private l6() {
    }
}
