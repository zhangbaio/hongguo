package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class s extends r implements Decoder, kotlinx.serialization.encoding.c {
    static {
        Covode.recordClassIndex(660142);
    }

    public abstract boolean decodeNotNullMark();

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void decodeNull() {
        return null;
    }

    protected abstract <T> T h(DeserializationStrategy<? extends T> deserializationStrategy, T t);

    protected abstract boolean i(long j);

    protected abstract byte j(long j);

    protected abstract char k(long j);

    protected abstract double l(long j);

    protected abstract int m(long j, SerialDescriptor serialDescriptor);

    protected abstract float n(long j);

    protected abstract int p(long j);

    protected abstract long q(long j);

    protected abstract short r(long j);

    protected abstract String s(long j);

    protected abstract long t(SerialDescriptor serialDescriptor, int i);

    @Override // kotlinx.serialization.encoding.c
    @ExperimentalSerializationApi
    public boolean decodeSequentially() {
        return c.a.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return i(f());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return j(f());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return k(f());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return l(f());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return n(f());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return p(f());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return q(f());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return r(f());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return s(f());
    }

    @Override // kotlinx.serialization.encoding.c
    public int decodeCollectionSize(SerialDescriptor serialDescriptor) {
        return c.a.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    @ExperimentalSerializationApi
    public <T> T decodeNullableSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy) {
        return (T) Decoder.a.a(this, deserializationStrategy);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return m(f(), enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return o(e(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.c
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return i(t(descriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final byte decodeByteElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return j(t(descriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final char decodeCharElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return k(t(descriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final double decodeDoubleElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return l(t(descriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final float decodeFloatElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return n(t(descriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final int decodeIntElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return p(t(descriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final long decodeLongElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return q(t(descriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final short decodeShortElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return r(t(descriptor, i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final String decodeStringElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return s(t(descriptor, i));
    }

    protected Decoder o(long j, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        g(j);
        return this;
    }

    @Override // kotlinx.serialization.encoding.c
    public Decoder decodeInlineElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return o(t(descriptor, i), descriptor.getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.c
    public final <T> T decodeSerializableElement(SerialDescriptor descriptor, int i, DeserializationStrategy<? extends T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        g(t(descriptor, i));
        return (T) h(deserializer, t);
    }

    @Override // kotlinx.serialization.encoding.c
    public final <T> T decodeNullableSerializableElement(SerialDescriptor descriptor, int i, DeserializationStrategy<? extends T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        g(t(descriptor, i));
        if (decodeNotNullMark()) {
            return (T) h(deserializer, t);
        }
        return (T) decodeNull();
    }
}
