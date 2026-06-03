package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i<T> implements s<T> {
    private final List<s<T>> a;

    static {
        Covode.recordClassIndex(659597);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(List<? extends s<? super T>> predicates) {
        Intrinsics.checkNotNullParameter(predicates, "predicates");
        this.a = predicates;
    }

    @Override // kotlinx.datetime.internal.format.s
    public boolean test(T t) {
        List<s<T>> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            if (!((s) it2.next()).test(t)) {
                return false;
            }
        }
        return true;
    }
}
