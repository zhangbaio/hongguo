package ps3;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final int d;

    static {
        Covode.recordClassIndex(599022);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(this.a, aVar.a) == 0 && Float.compare(this.b, aVar.b) == 0 && Float.compare(this.c, aVar.c) == 0 && this.d == aVar.d;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d;
    }

    public String toString() {
        return "ShadowConfig(radius=" + this.a + ", dx=" + this.b + ", dy=" + this.c + ", color=" + this.d + ')';
    }

    public a(float f, float f2, float f3, int i) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = i;
    }
}
