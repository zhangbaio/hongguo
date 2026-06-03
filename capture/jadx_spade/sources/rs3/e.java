package rs3;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public final int a;
    public final int b;

    static {
        Covode.recordClassIndex(599060);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "HotStartRefreshEvent(tabType=" + this.a + ", bottomTabType=" + this.b + ')';
    }

    public e(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
