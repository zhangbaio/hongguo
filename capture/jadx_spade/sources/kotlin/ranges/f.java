package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.l;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class f<T extends Comparable<? super T>> implements l<T> {
    private final T a;
    private final T b;

    static {
        Covode.recordClassIndex(658626);
    }

    @Override // kotlin.ranges.l
    public T getEndExclusive() {
        return this.b;
    }

    @Override // kotlin.ranges.l
    public T getStart() {
        return this.a;
    }

    public boolean a() {
        return l.a.b(this);
    }

    public int hashCode() {
        if (a()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndExclusive().hashCode();
    }

    public String toString() {
        return getStart() + "..<" + getEndExclusive();
    }

    @Override // kotlin.ranges.l
    public boolean contains(T t) {
        return l.a.a(this, t);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!a() || !((f) obj).a()) {
                f fVar = (f) obj;
                if (!Intrinsics.areEqual(getStart(), fVar.getStart()) || !Intrinsics.areEqual(getEndExclusive(), fVar.getEndExclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    public f(T start, T endExclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endExclusive, "endExclusive");
        this.a = start;
        this.b = endExclusive;
    }
}
