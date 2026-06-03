package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ClosedRange<T extends Comparable<? super T>> {
    boolean contains(T t);

    T getEndInclusive();

    T getStart();

    boolean isEmpty();

    public static final class a {
        static {
            Covode.recordClassIndex(658625);
        }

        public static <T extends Comparable<? super T>> boolean b(ClosedRange<T> closedRange) {
            if (closedRange.getStart().compareTo(closedRange.getEndInclusive()) > 0) {
                return true;
            }
            return false;
        }

        public static <T extends Comparable<? super T>> boolean a(ClosedRange<T> closedRange, T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value.compareTo(closedRange.getStart()) >= 0 && value.compareTo(closedRange.getEndInclusive()) <= 0) {
                return true;
            }
            return false;
        }
    }
}
