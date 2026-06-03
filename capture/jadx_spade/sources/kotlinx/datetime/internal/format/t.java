package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t {
    static {
        Covode.recordClassIndex(659615);
    }

    public static final <T> s<T> a(List<? extends s<? super T>> predicates) {
        Intrinsics.checkNotNullParameter(predicates, "predicates");
        if (predicates.isEmpty()) {
            return w.a;
        }
        if (predicates.size() == 1) {
            return (s) CollectionsKt___CollectionsKt.single((List) predicates);
        }
        return new i(predicates);
    }
}
