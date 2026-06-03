package rs3;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public final float a;
    public final int b;
    public final int c;

    static {
        Covode.recordClassIndex(599064);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Float.compare(this.a, iVar.a) == 0 && this.b == iVar.b && this.c == iVar.c;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "SwipeLeftToSingleActionUpEvent(percent=" + this.a + ", tabType=" + this.b + ", bottomTabType=" + this.c + ')';
    }

    public i(float f, int i, int i2) {
        this.a = f;
        this.b = i;
        this.c = i2;
    }
}
