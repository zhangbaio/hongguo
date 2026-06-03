package pq3;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {
    public final boolean a;
    public final int b;

    static {
        Covode.recordClassIndex(598272);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.a == c0Var.a && this.b == c0Var.b;
    }

    public int hashCode() {
        return (androidx.compose.animation.m.a(this.a) * 31) + this.b;
    }

    public String toString() {
        return "SingleTabPreloadConfig(enable=" + this.a + ", index=" + this.b + ')';
    }

    public c0(boolean z, int i) {
        this.a = z;
        this.b = i;
    }
}
