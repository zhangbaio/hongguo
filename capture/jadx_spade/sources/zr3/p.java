package zr3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public final String a;
    public final int b;
    public final int c;

    static {
        Covode.recordClassIndex(598870);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Intrinsics.areEqual(this.a, pVar.a) && this.b == pVar.b && this.c == pVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "ProgressNode(title=" + this.a + ", duration=" + this.b + ", totalDuration=" + this.c + ')';
    }

    public p(String title, int i, int i2) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.a = title;
        this.b = i;
        this.c = i2;
    }
}
