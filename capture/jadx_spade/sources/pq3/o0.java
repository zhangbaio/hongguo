package pq3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o0 {
    public final int a;
    public final long b;

    static {
        Covode.recordClassIndex(598298);
    }

    public o0() {
        this(0, 0L, 3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.a == o0Var.a && this.b == o0Var.b;
    }

    public int hashCode() {
        return (this.a * 31) + j.a(this.b);
    }

    public String toString() {
        return "VideoSpeedLockLimitConfig(tipsMaxTimes=" + this.a + ", limitMinsGap=" + this.b + ')';
    }

    public o0(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public /* synthetic */ o0(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 5 : i, (i2 & 2) != 0 ? 4320L : j);
    }
}
