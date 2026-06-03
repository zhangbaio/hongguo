package kotlin.comparisons;

import com.bytedance.covode.number.Covode;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    static {
        Covode.recordClassIndex(658261);
    }

    public static final <T> T maxOf(T t, T t2, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (comparator.compare(t, t2) < 0) {
            return t2;
        }
        return t;
    }

    public static final <T> T minOf(T t, T t2, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (comparator.compare(t, t2) > 0) {
            return t2;
        }
        return t;
    }

    public static final <T> T maxOf(T t, T[] other, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        for (T t2 : other) {
            if (comparator.compare(t, t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    public static final <T> T minOf(T t, T[] other, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        for (T t2 : other) {
            if (comparator.compare(t, t2) > 0) {
                t = t2;
            }
        }
        return t;
    }

    public static final <T> T maxOf(T t, T t2, T t3, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) maxOf(t, maxOf(t2, t3, comparator), comparator);
    }

    public static final <T> T minOf(T t, T t2, T t3, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) minOf(t, minOf(t2, t3, comparator), comparator);
    }
}
