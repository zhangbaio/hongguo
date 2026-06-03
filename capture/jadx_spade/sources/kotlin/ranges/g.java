package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class g<T extends Comparable<? super T>> implements ClosedRange<T> {
    private final T a;
    private final T b;

    static {
        Covode.recordClassIndex(658627);
    }

    @Override // kotlin.ranges.ClosedRange
    public T getEndInclusive() {
        return this.b;
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.l
    public T getStart() {
        return this.a;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return ClosedRange.a.b(this);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean contains(T t) {
        return ClosedRange.a.a(this, t);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            if (!isEmpty() || !((g) obj).isEmpty()) {
                g gVar = (g) obj;
                if (!Intrinsics.areEqual(getStart(), gVar.getStart()) || !Intrinsics.areEqual(getEndInclusive(), gVar.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    public g(T start, T endInclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endInclusive, "endInclusive");
        this.a = start;
        this.b = endInclusive;
    }
}
