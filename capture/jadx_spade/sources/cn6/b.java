package cn6;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.datetime.a;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends kotlinx.serialization.internal.b<a.b> {
    public static final b a;
    private static final Lazy b;

    public KClass<a.b> g() {
        return Reflection.getOrCreateKotlinClass(a.b.class);
    }

    private b() {
    }

    private final dn6.j<a.b> j() {
        return (dn6.j) b.getValue();
    }

    public SerialDescriptor getDescriptor() {
        return j().getDescriptor();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(659666);
        a = new b();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: cn6.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                dn6.j k;
                k = b.k();
                return k;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final dn6.j k() {
        return new dn6.j("kotlinx.datetime.DateTimeUnit.DateBased", Reflection.getOrCreateKotlinClass(a.b.class), new KClass[]{Reflection.getOrCreateKotlinClass(a.c.class), Reflection.getOrCreateKotlinClass(a.d.class)}, new KSerializer[]{j.a, r.a});
    }

    @InternalSerializationApi
    public DeserializationStrategy<a.b> e(kotlinx.serialization.encoding.c decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return j().e(decoder, str);
    }

    @InternalSerializationApi
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public SerializationStrategy<a.b> f(Encoder encoder, a.b value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return j().f(encoder, value);
    }
}
