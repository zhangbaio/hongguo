package kotlin.comparisons;

import com.bytedance.covode.number.Covode;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class f implements Comparator<Comparable<? super Object>> {
    public static final f a;

    static {
        Covode.recordClassIndex(658262);
        a = new f();
    }

    private f() {
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return g.a;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<Object> a2, Comparable<Object> b) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return a2.compareTo(b);
    }
}
