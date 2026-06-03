package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class CollectionsKt__IteratorsKt extends CollectionsKt__IteratorsJVMKt {
    static {
        Covode.recordClassIndex(658184);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Iterator<T> iterator(Iterator<? extends T> it2) {
        Intrinsics.checkNotNullParameter(it2, "<this>");
        return it2;
    }

    public static <T> Iterator<IndexedValue<T>> withIndex(Iterator<? extends T> it2) {
        Intrinsics.checkNotNullParameter(it2, "<this>");
        return new c0(it2);
    }

    public static final <T> void forEach(Iterator<? extends T> it2, Function1<? super T, Unit> operation) {
        Intrinsics.checkNotNullParameter(it2, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        while (it2.hasNext()) {
            operation.invoke(it2.next());
        }
    }
}
