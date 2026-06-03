package kotlin.ranges;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class RangesKt__RangesKt {
    static {
        Covode.recordClassIndex(658643);
    }

    public static final ClosedFloatingPointRange<Double> rangeTo(double d, double d2) {
        return new d(d, d2);
    }

    public static final l<Double> rangeUntil(double d, double d2) {
        return new j(d, d2);
    }

    public static ClosedFloatingPointRange<Float> rangeTo(float f, float f2) {
        return new e(f, f2);
    }

    public static final l<Float> rangeUntil(float f, float f2) {
        return new k(f, f2);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lkotlin/ranges/ClosedRange<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    private static final boolean contains(ClosedRange closedRange, Object obj) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        if (obj != null && closedRange.contains((Comparable) obj)) {
            return true;
        }
        return false;
    }

    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(T t, T that) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new g(t, that);
    }

    public static final <T extends Comparable<? super T>> l<T> rangeUntil(T t, T that) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        return new f(t, that);
    }

    public static final void checkStepIsPositive(boolean z, Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Lkotlin/ranges/l<TT;>;:Ljava/lang/Iterable<+TT;>;>(TR;TT;)Z */
    private static final boolean contains(l lVar, Object obj) {
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        if (obj != null && lVar.contains((Comparable) obj)) {
            return true;
        }
        return false;
    }
}
