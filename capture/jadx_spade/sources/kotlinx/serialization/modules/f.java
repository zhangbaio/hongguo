package kotlinx.serialization.modules;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.f;

@ExperimentalSerializationApi
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface f {
    <Base> void a(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1);

    <Base> void b(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1);

    <T> void c(KClass<T> kClass, KSerializer<T> kSerializer);

    <T> void d(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1);

    <Base, Sub extends Base> void e(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer);

    public static final class a {
        static {
            Covode.recordClassIndex(660101);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static KSerializer c(KSerializer kSerializer, List it2) {
            Intrinsics.checkNotNullParameter(it2, "it");
            return kSerializer;
        }

        public static <T> void b(f fVar, KClass<T> kClass, final KSerializer<T> serializer) {
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            fVar.d(kClass, new Function1() { // from class: kotlinx.serialization.modules.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    KSerializer c;
                    c = f.a.c(KSerializer.this, (List) obj);
                    return c;
                }
            });
        }
    }
}
