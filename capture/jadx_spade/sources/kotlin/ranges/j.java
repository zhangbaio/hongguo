package kotlin.ranges;

import androidx.compose.ui.graphics.colorspace.f0;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class j implements l<Double> {
    private final double a;
    private final double b;

    static {
        Covode.recordClassIndex(658638);
    }

    @Override // kotlin.ranges.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Double getEndExclusive() {
        return Double.valueOf(this.b);
    }

    @Override // kotlin.ranges.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Double getStart() {
        return Double.valueOf(this.a);
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
        return (f0.a(this.a) * 31) + f0.a(this.b);
    }

    public String toString() {
        return this.a + "..<" + this.b;
    }

    public boolean a(double d) {
        if (d >= this.a && d < this.b) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.l
    public /* bridge */ /* synthetic */ boolean contains(Double d) {
        return a(d.doubleValue());
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof j)) {
            return false;
        }
        if (!d() || !((j) obj).d()) {
            j jVar = (j) obj;
            if (this.a == jVar.a) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this.b == jVar.b) {
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

    public j(double d, double d2) {
        this.a = d;
        this.b = d2;
    }
}
