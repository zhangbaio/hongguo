package kotlin.ranges;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e implements ClosedFloatingPointRange<Float> {
    private final float a;
    private final float b;

    static {
        Covode.recordClassIndex(658621);
    }

    public boolean d(float f, float f2) {
        return f <= f2;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float getEndInclusive() {
        return Float.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange, kotlin.ranges.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.a);
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
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public String toString() {
        return this.a + ".." + this.b;
    }

    public boolean a(float f) {
        if (f >= this.a && f <= this.b) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).floatValue());
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof e)) {
            return false;
        }
        if (!isEmpty() || !((e) obj).isEmpty()) {
            e eVar = (e) obj;
            if (this.a == eVar.a) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b == eVar.b) {
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

    public e(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Float f, Float f2) {
        return d(f.floatValue(), f2.floatValue());
    }
}
