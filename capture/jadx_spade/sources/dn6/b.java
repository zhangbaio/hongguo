package dn6;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.a2;

@ExperimentalSerializationApi
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b<T> implements KSerializer<T> {
    private final KClass<T> a;
    private final KSerializer<T> b;
    private final List<KSerializer<?>> c;
    private final SerialDescriptor d;

    static {
        Covode.recordClassIndex(659768);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.d;
    }

    private final KSerializer<T> e(kotlinx.serialization.modules.c cVar) {
        KSerializer<T> b = cVar.b(this.a, this.c);
        if (b == null && (b = this.b) == null) {
            a2.f(this.a);
            throw new KotlinNothingValueException();
        }
        return b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return (T) decoder.decodeSerializableValue(e(decoder.getSerializersModule()));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeSerializableValue(e(encoder.getSerializersModule()), value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(b bVar, fn6.a buildSerialDescriptor) {
        List<Annotation> list;
        SerialDescriptor descriptor;
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        KSerializer<T> kSerializer = bVar.b;
        if (kSerializer != null && (descriptor = kSerializer.getDescriptor()) != null) {
            list = descriptor.getAnnotations();
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        buildSerialDescriptor.c(list);
        return Unit.INSTANCE;
    }

    public b(KClass<T> serializableClass, KSerializer<T> kSerializer, KSerializer<?>[] typeArgumentsSerializers) {
        Intrinsics.checkNotNullParameter(serializableClass, "serializableClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        this.a = serializableClass;
        this.b = kSerializer;
        this.c = ArraysKt___ArraysJvmKt.asList(typeArgumentsSerializers);
        this.d = fn6.b.d(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.ContextualSerializer", d.a.a, new SerialDescriptor[0], new Function1() { // from class: dn6.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d;
                d = b.d(b.this, (fn6.a) obj);
                return d;
            }
        }), serializableClass);
    }
}
