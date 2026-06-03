package kotlin;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TuplesKt {
    static {
        Covode.recordClassIndex(658110);
    }

    public static final <T> List<T> toList(Pair<? extends T, ? extends T> pair) {
        List<T> listOf;
        Intrinsics.checkNotNullParameter(pair, "<this>");
        listOf = CollectionsKt__CollectionsKt.listOf(pair.getFirst(), pair.getSecond());
        return listOf;
    }

    public static final <T> List<T> toList(Triple<? extends T, ? extends T, ? extends T> triple) {
        List<T> listOf;
        Intrinsics.checkNotNullParameter(triple, "<this>");
        listOf = CollectionsKt__CollectionsKt.listOf(triple.getFirst(), triple.getSecond(), triple.getThird());
        return listOf;
    }

    public static final <A, B> Pair<A, B> to(A a, B b) {
        return new Pair<>(a, b);
    }
}
