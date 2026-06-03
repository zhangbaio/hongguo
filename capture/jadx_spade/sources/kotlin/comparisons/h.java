package kotlin.comparisons;

import com.bytedance.covode.number.Covode;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class h<T> implements Comparator<T> {
    public final Comparator<T> a;

    static {
        Covode.recordClassIndex(658264);
    }

    @Override // java.util.Comparator
    public final Comparator<T> reversed() {
        return this.a;
    }

    public h(Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.a = comparator;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.a.compare(t2, t);
    }
}
