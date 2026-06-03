package rs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public final float a;
    public final int b;
    public final int c;
    public final boolean d;

    static {
        Covode.recordClassIndex(599062);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Float.compare(this.a, gVar.a) == 0 && this.b == gVar.b && this.c == gVar.c && this.d == gVar.d;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.a) * 31) + this.b) * 31) + this.c) * 31) + m.a(this.d);
    }

    public String toString() {
        return "PullToRefreshActionUpEvent(percent=" + this.a + ", tabType=" + this.b + ", bottomTabType=" + this.c + ", isRefresh=" + this.d + ')';
    }

    public g(float f, int i, int i2, boolean z) {
        this.a = f;
        this.b = i;
        this.c = i2;
        this.d = z;
    }
}
