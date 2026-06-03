package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface l<T extends Comparable<? super T>> {
    boolean contains(T t);

    T getEndExclusive();

    T getStart();

    public static final class a {
        static {
            Covode.recordClassIndex(658641);
        }

        public static <T extends Comparable<? super T>> boolean b(l<T> lVar) {
            if (lVar.getStart().compareTo(lVar.getEndExclusive()) >= 0) {
                return true;
            }
            return false;
        }

        public static <T extends Comparable<? super T>> boolean a(l<T> lVar, T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value.compareTo(lVar.getStart()) >= 0 && value.compareTo(lVar.getEndExclusive()) < 0) {
                return true;
            }
            return false;
        }
    }
}
