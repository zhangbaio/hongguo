package un4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final int a;
    public final int b;

    static {
        Covode.recordClassIndex(608936);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && this.b == fVar.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "SeriesGradientColors(startColor=" + this.a + ", endColor=" + this.b + ')';
    }

    public f(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
