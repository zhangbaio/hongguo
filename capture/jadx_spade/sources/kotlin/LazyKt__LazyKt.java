package kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class LazyKt__LazyKt extends LazyKt__LazyJVMKt {
    static {
        Covode.recordClassIndex(658069);
    }

    public static final <T> Lazy<T> lazyOf(T t) {
        return new InitializedLazyImpl(t);
    }

    private static final <T> T getValue(Lazy<? extends T> lazy, Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(lazy, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return lazy.getValue();
    }
}
