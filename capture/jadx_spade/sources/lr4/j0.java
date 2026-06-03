package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 {
    public static final int c;
    public final d0 a;
    public final g0 b;

    static {
        Covode.recordClassIndex(611589);
        c = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return Intrinsics.areEqual(this.a, j0Var.a) && Intrinsics.areEqual(this.b, j0Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "LocalBookWithSync(localBook=" + this.a + ", syncInfo=" + this.b + ')';
    }

    public j0(d0 localBook, g0 syncInfo) {
        Intrinsics.checkNotNullParameter(localBook, "localBook");
        Intrinsics.checkNotNullParameter(syncInfo, "syncInfo");
        this.a = localBook;
        this.b = syncInfo;
    }
}
