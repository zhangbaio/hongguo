package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class ProtobufTaggedEncoder extends r implements Encoder, kotlinx.serialization.encoding.d {
    private NullableMode c = NullableMode.NOT_NULL;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(660145);
            int[] iArr = new int[NullableMode.values().length];
            try {
                iArr[NullableMode.OPTIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NullableMode.COLLECTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NullableMode.NOT_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(660143);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t);

    protected abstract void h(long j, boolean z);

    protected abstract void i(long j, byte b);

    protected abstract void j(long j, char c);

    protected abstract void k(long j, double d);

    protected abstract void l(long j, SerialDescriptor serialDescriptor, int i);

    protected abstract void m(long j, float f);

    protected abstract void o(long j, int i);

    protected abstract void p(long j, long j2);

    protected abstract void q(long j, short s);

    protected abstract void r(long j, String str);

    protected void s(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    protected abstract long t(SerialDescriptor serialDescriptor, int i);

    @Override // kotlinx.serialization.encoding.Encoder
    @ExperimentalSerializationApi
    public void encodeNotNullMark() {
        Encoder.a.b(this);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class NullableMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NullableMode[] $VALUES;
        public static final NullableMode ACCEPTABLE;
        public static final NullableMode COLLECTION;
        public static final NullableMode NOT_NULL;
        public static final NullableMode OPTIONAL;

        private static final /* synthetic */ NullableMode[] $values() {
            return new NullableMode[]{ACCEPTABLE, OPTIONAL, COLLECTION, NOT_NULL};
        }

        public static EnumEntries<NullableMode> getEntries() {
            return $ENTRIES;
        }

        public static NullableMode[] values() {
            return (NullableMode[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(660144);
            ACCEPTABLE = new NullableMode("ACCEPTABLE", 0);
            OPTIONAL = new NullableMode("OPTIONAL", 1);
            COLLECTION = new NullableMode("COLLECTION", 2);
            NOT_NULL = new NullableMode("NOT_NULL", 3);
            NullableMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static NullableMode valueOf(String str) {
            return (NullableMode) Enum.valueOf(NullableMode.class, str);
        }

        private NullableMode(String str, int i) {
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeNull() {
        String str;
        NullableMode nullableMode = this.c;
        if (nullableMode != NullableMode.ACCEPTABLE) {
            int i = a.a[nullableMode.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        str = "'null' is not supported in ProtoBuf";
                    } else {
                        str = "'null' is not allowed for not-null properties";
                    }
                } else {
                    str = "'null' is not supported for collection types in ProtoBuf";
                }
            } else {
                str = "'null' is not supported for optional properties in ProtoBuf";
            }
            throw new SerializationException(str);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
        h(f(), z);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
        i(f(), b);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
        j(f(), c);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double d) {
        k(f(), d);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
        m(f(), f);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int i) {
        o(f(), i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long j) {
        p(f(), j);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short s) {
        q(f(), s);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return n(e(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        r(f(), value);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.b >= 0) {
            e();
        }
        s(descriptor);
    }

    private final boolean u(kotlinx.serialization.descriptors.d dVar) {
        if (!Intrinsics.areEqual(dVar, e.c.a) && !Intrinsics.areEqual(dVar, e.b.a)) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Encoder.a.c(this, serializationStrategy, t);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        l(f(), enumDescriptor, i);
    }

    protected Encoder n(long j, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        g(j);
        return this;
    }

    @Override // kotlinx.serialization.encoding.d
    public Encoder encodeInlineElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return n(t(descriptor, i), descriptor.getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeBooleanElement(SerialDescriptor descriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        h(t(descriptor, i), z);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeByteElement(SerialDescriptor descriptor, int i, byte b) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        i(t(descriptor, i), b);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeCharElement(SerialDescriptor descriptor, int i, char c) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        j(t(descriptor, i), c);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeDoubleElement(SerialDescriptor descriptor, int i, double d) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        k(t(descriptor, i), d);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeFloatElement(SerialDescriptor descriptor, int i, float f) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        m(t(descriptor, i), f);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeIntElement(SerialDescriptor descriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        o(t(descriptor, i), i2);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeLongElement(SerialDescriptor descriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        p(t(descriptor, i), j);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeShortElement(SerialDescriptor descriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        q(t(descriptor, i), s);
    }

    @Override // kotlinx.serialization.encoding.d
    public final void encodeStringElement(SerialDescriptor descriptor, int i, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        r(t(descriptor, i), value);
    }

    @Override // kotlinx.serialization.encoding.d
    public final <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy<? super T> serializer, T t) {
        NullableMode nullableMode;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (descriptor.isElementOptional(i)) {
            nullableMode = NullableMode.OPTIONAL;
        } else if (u(descriptor.getElementDescriptor(i).getKind())) {
            nullableMode = NullableMode.COLLECTION;
        } else {
            nullableMode = NullableMode.ACCEPTABLE;
        }
        this.c = nullableMode;
        g(t(descriptor, i));
        encodeNullableSerializableValue(serializer, t);
    }

    @Override // kotlinx.serialization.encoding.d
    public final <T> void encodeSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy<? super T> serializer, T t) {
        NullableMode nullableMode;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (descriptor.isElementOptional(i)) {
            nullableMode = NullableMode.OPTIONAL;
        } else {
            SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(i);
            if (u(elementDescriptor.getKind())) {
                nullableMode = NullableMode.COLLECTION;
            } else if (!u(descriptor.getKind()) && elementDescriptor.isNullable()) {
                nullableMode = NullableMode.ACCEPTABLE;
            } else {
                nullableMode = NullableMode.NOT_NULL;
            }
        }
        this.c = nullableMode;
        g(t(descriptor, i));
        encodeSerializableValue(serializer, t);
    }
}
