package rs3;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final int a;
    public final int b;

    static {
        Covode.recordClassIndex(599057);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "CancelRefreshEvent(tabType=" + this.a + ", bottomTabType=" + this.b + ')';
    }

    public b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
