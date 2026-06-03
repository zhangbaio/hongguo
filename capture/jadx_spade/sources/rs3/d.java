package rs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public final int a;
    public final int b;
    public final boolean c;

    static {
        Covode.recordClassIndex(599059);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + m.a(this.c);
    }

    public String toString() {
        return "FakeLoadingEvent(tabType=" + this.a + ", bottomTabType=" + this.b + ", show=" + this.c + ')';
    }

    public d(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }
}
