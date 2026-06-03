package kotlinx.serialization.modules;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class c {
    static {
        Covode.recordClassIndex(660097);
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @ExperimentalSerializationApi
    public abstract void a(f fVar);

    @ExperimentalSerializationApi
    public abstract <T> KSerializer<T> b(KClass<T> kClass, List<? extends KSerializer<?>> list);

    public abstract boolean d();

    @ExperimentalSerializationApi
    public abstract <T> DeserializationStrategy<T> e(KClass<? super T> kClass, String str);

    @ExperimentalSerializationApi
    public abstract <T> SerializationStrategy<T> f(KClass<? super T> kClass, T t);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KSerializer c(c cVar, KClass kClass, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            return cVar.b(kClass, list);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
    }
}
