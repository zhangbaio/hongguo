package dn6;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class s {
    static {
        Covode.recordClassIndex(659793);
    }

    public static final KSerializer<Object> c(KType kType) {
        return u.g(kType);
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> e(KClass<T> kClass) {
        return u.k(kClass);
    }

    public static final KSerializer<?> a(kotlinx.serialization.modules.c cVar, KClass<?> kClass) {
        return u.d(cVar, kClass);
    }

    public static final KSerializer<Object> d(kotlinx.serialization.modules.c cVar, KType kType) {
        return u.h(cVar, kType);
    }

    public static final KSerializer<Object> f(kotlinx.serialization.modules.c cVar, KType kType) {
        return u.l(cVar, kType);
    }

    public static final KSerializer<? extends Object> b(KClass<Object> kClass, List<? extends KSerializer<Object>> list, Function0<? extends KClassifier> function0) {
        return u.f(kClass, list, function0);
    }

    public static final List<KSerializer<Object>> g(kotlinx.serialization.modules.c cVar, List<? extends KType> list, boolean z) {
        return u.m(cVar, list, z);
    }
}
