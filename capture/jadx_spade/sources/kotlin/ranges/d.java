package kotlin.ranges;

import androidx.compose.ui.graphics.colorspace.f0;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d implements ClosedFloatingPointRange<Double> {
    private final double a;
    private final double b;

    static {
        Covode.recordClassIndex(658620);
    }

    public boolean d(double d, double d2) {
        return d <= d2;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Double getEndInclusive() {
        return Double.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Double getStart() {
        return Double.valueOf(this.a);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (this.a > this.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (f0.a(this.a) * 31) + f0.a(this.b);
    }

    public String toString() {
        return this.a + ".." + this.b;
    }

    public boolean a(double d) {
        if (d >= this.a && d <= this.b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).doubleValue());
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof d)) {
            return false;
        }
        if (!isEmpty() || !((d) obj).isEmpty()) {
            d dVar = (d) obj;
            if (this.a == dVar.a) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b == dVar.b) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    public d(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Double d, Double d2) {
        return d(d.doubleValue(), d2.doubleValue());
    }
}
