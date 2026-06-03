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
public final class f extends kotlinx.serialization.internal.b<kotlinx.datetime.a> {
    public static final f a;
    private static final Lazy b;

    public KClass<kotlinx.datetime.a> g() {
        return Reflection.getOrCreateKotlinClass(kotlinx.datetime.a.class);
    }

    private f() {
    }

    private final dn6.j<kotlinx.datetime.a> j() {
        return (dn6.j) b.getValue();
    }

    public SerialDescriptor getDescriptor() {
        return j().getDescriptor();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(659671);
        a = new f();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: cn6.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                dn6.j k;
                k = f.k();
                return k;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final dn6.j k() {
        return new dn6.j("kotlinx.datetime.DateTimeUnit", Reflection.getOrCreateKotlinClass(kotlinx.datetime.a.class), new KClass[]{Reflection.getOrCreateKotlinClass(a.c.class), Reflection.getOrCreateKotlinClass(a.d.class), Reflection.getOrCreateKotlinClass(a.e.class)}, new KSerializer[]{j.a, r.a, u.a});
    }

    @InternalSerializationApi
    public DeserializationStrategy<kotlinx.datetime.a> e(kotlinx.serialization.encoding.c decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return j().e(decoder, str);
    }

    @InternalSerializationApi
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public SerializationStrategy<kotlinx.datetime.a> f(Encoder encoder, kotlinx.datetime.a value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return j().f(encoder, value);
    }
}
