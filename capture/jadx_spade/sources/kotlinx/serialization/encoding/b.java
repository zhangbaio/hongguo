package kotlinx.serialization.encoding;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.o1;

@ExperimentalSerializationApi
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class b implements Encoder, d {
    static {
        Covode.recordClassIndex(659834);
    }

    public boolean a(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public d beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.d
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @ExperimentalSerializationApi
    public void encodeNotNullMark() {
        Encoder.a.b(this);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        b(Boolean.valueOf(z));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        b(Byte.valueOf(b));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        b(Character.valueOf(c));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        b(Double.valueOf(d));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        b(Float.valueOf(f));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        b(Integer.valueOf(i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        b(Long.valueOf(j));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        b(Short.valueOf(s));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        b(value);
    }

    public void b(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(value.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Encoder.a.c(this, serializationStrategy, t);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Encoder.a.d(this, serializationStrategy, t);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public d beginCollection(SerialDescriptor serialDescriptor, int i) {
        return Encoder.a.a(this, serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.d
    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        return d.a.a(this, serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        b(Integer.valueOf(i));
    }

    @Override // kotlinx.serialization.encoding.d
    public final Encoder encodeInlineElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            return encodeInline(descriptor.getElementDescriptor(i));
        }
        return o1.a;
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeBooleanElement(SerialDescriptor descriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            encodeBoolean(z);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeByteElement(SerialDescriptor descriptor, int i, byte b) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            encodeByte(b);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeCharElement(SerialDescriptor descriptor, int i, char c) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            encodeChar(c);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeDoubleElement(SerialDescriptor descriptor, int i, double d) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            encodeDouble(d);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeFloatElement(SerialDescriptor descriptor, int i, float f) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            encodeFloat(f);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeIntElement(SerialDescriptor descriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            encodeInt(i2);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeLongElement(SerialDescriptor descriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            encodeLong(j);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeShortElement(SerialDescriptor descriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (a(descriptor, i)) {
            encodeShort(s);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeStringElement(SerialDescriptor descriptor, int i, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        if (a(descriptor, i)) {
            encodeString(value);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (a(descriptor, i)) {
            encodeNullableSerializableValue(serializer, t);
        }
    }

    @Override // kotlinx.serialization.encoding.d
    public <T> void encodeSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy<? super T> serializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (a(descriptor, i)) {
            encodeSerializableValue(serializer, t);
        }
    }
}
