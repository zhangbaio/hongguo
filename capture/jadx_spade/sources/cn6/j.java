package cn6;

import com.bytedance.covode.number.Covode;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.a;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.v0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j implements KSerializer<a.c> {
    public static final j a;
    private static final Lazy b;

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor e() {
        return SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.DayBased", new SerialDescriptor[0], new Function1() { // from class: cn6.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = j.f((fn6.a) obj);
                return f;
            }
        });
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) b.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(659673);
        a = new j();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: cn6.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SerialDescriptor e;
                e = j.e();
                return e;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(fn6.a buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        buildClassSerialDescriptor.a("days", v0.a.getDescriptor(), CollectionsKt__CollectionsKt.emptyList(), false);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a.c deserialize(Decoder decoder) {
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(descriptor);
        boolean z = true;
        if (beginStructure.decodeSequentially()) {
            i = beginStructure.decodeIntElement(a.getDescriptor(), 0);
        } else {
            i = 0;
            boolean z2 = false;
            while (true) {
                j jVar = a;
                int decodeElementIndex = beginStructure.decodeElementIndex(jVar.getDescriptor());
                if (decodeElementIndex != -1) {
                    if (decodeElementIndex == 0) {
                        i = beginStructure.decodeIntElement(jVar.getDescriptor(), 0);
                        z2 = true;
                    } else {
                        g.a(decodeElementIndex);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    z = z2;
                    break;
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        beginStructure.endStructure(descriptor);
        if (z) {
            return new a.c(i);
        }
        throw new MissingFieldException("days", getDescriptor().getSerialName());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, a.c value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor = getDescriptor();
        kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(descriptor);
        beginStructure.encodeIntElement(a.getDescriptor(), 0, value.m);
        beginStructure.endStructure(descriptor);
    }
}
