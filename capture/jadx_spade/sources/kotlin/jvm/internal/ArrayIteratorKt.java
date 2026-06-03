package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ArrayIteratorKt {
    static {
        Covode.recordClassIndex(658493);
    }

    public static final <T> Iterator<T> iterator(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new g(array);
    }
}
