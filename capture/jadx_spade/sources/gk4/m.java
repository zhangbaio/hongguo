package gk4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public final boolean a;
    public final int b;

    static {
        Covode.recordClassIndex(607797);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.a == mVar.a && this.b == mVar.b;
    }

    public int hashCode() {
        return (androidx.compose.animation.m.a(this.a) * 31) + this.b;
    }

    public String toString() {
        return "BsSelectInfo(isSelectedAll=" + this.a + ", selectedSize=" + this.b + ')';
    }

    public m(boolean z, int i) {
        this.a = z;
        this.b = i;
    }
}
