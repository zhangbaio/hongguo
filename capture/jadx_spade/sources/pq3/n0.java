package pq3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final o0 d;

    static {
        Covode.recordClassIndex(598297);
    }

    public n0() {
        this(false, false, false, null, 15, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.a == n0Var.a && this.b == n0Var.b && this.c == n0Var.c && Intrinsics.areEqual(this.d, n0Var.d);
    }

    public int hashCode() {
        int a = ((((androidx.compose.animation.m.a(this.a) * 31) + androidx.compose.animation.m.a(this.b)) * 31) + androidx.compose.animation.m.a(this.c)) * 31;
        o0 o0Var = this.d;
        return a + (o0Var == null ? 0 : o0Var.hashCode());
    }

    public String toString() {
        return "VideoSpeedLockConfig(enable=" + this.a + ", keepShowTips=" + this.b + ", cleanScreen=" + this.c + ", limitConfig=" + this.d + ')';
    }

    public n0(boolean z, boolean z2, boolean z3, o0 o0Var) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = o0Var;
    }

    public /* synthetic */ n0(boolean z, boolean z2, boolean z3, o0 o0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? null : o0Var);
    }
}
