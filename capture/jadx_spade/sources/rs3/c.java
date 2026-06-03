package rs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public final int a;
    public final int b;
    public final boolean c;

    static {
        Covode.recordClassIndex(599058);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + m.a(this.c);
    }

    public String toString() {
        return "ClickToRefreshEvent(tabType=" + this.a + ", bottomTabType=" + this.b + ", doAppBarAnimation=" + this.c + ')';
    }

    public c(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }
}
