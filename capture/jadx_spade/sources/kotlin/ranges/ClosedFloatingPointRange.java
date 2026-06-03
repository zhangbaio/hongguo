package kotlin.ranges;

import java.lang.Comparable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {
    @Override // kotlin.ranges.ClosedRange
    boolean contains(T t);

    @Override // kotlin.ranges.ClosedRange
    boolean isEmpty();

    boolean lessThanOrEquals(T t, T t2);
}
