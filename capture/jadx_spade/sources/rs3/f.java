package rs3;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final float a;
    public final float b;
    public final float c;
    public final int d;
    public final int e;

    static {
        Covode.recordClassIndex(599061);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Float.compare(this.a, fVar.a) == 0 && Float.compare(this.b, fVar.b) == 0 && Float.compare(this.c, fVar.c) == 0 && this.d == fVar.d && this.e == fVar.e;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return "PullToRefreshActionMoveEvent(distance=" + this.a + ", maxDistance=" + this.b + ", percent=" + this.c + ", tabType=" + this.d + ", bottomTabType=" + this.e + ')';
    }

    public f(float f, float f2, float f3, int i, int i2) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = i;
        this.e = i2;
    }
}
