package kotlin.ranges;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class k implements l<Float> {
    private final float a;
    private final float b;

    static {
        Covode.recordClassIndex(658639);
    }

    @Override // kotlin.ranges.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float getEndExclusive() {
        return Float.valueOf(this.b);
    }

    @Override // kotlin.ranges.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float getStart() {
        return Float.valueOf(this.a);
    }

    public boolean d() {
        if (this.a >= this.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (d()) {
            return -1;
        }
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public String toString() {
        return this.a + "..<" + this.b;
    }

    public boolean a(float f) {
        if (f >= this.a && f < this.b) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.l
    public /* bridge */ /* synthetic */ boolean contains(Float f) {
        return a(f.floatValue());
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof k)) {
            return false;
        }
        if (!d() || !((k) obj).d()) {
            k kVar = (k) obj;
            if (this.a == kVar.a) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b == kVar.b) {
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

    public k(float f, float f2) {
        this.a = f;
        this.b = f2;
    }
}
