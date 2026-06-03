package un4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public final int a;
    public final int b;

    static {
        Covode.recordClassIndex(608937);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a == gVar.a && this.b == gVar.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "ShareChannelIconRes(lightIconResId=" + this.a + ", darkIconResId=" + this.b + ')';
    }

    public g(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
