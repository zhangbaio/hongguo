package jk4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f1 {
    public static final int d;
    public final String a;
    public final List<t0> b;
    public final List<t0> c;

    static {
        Covode.recordClassIndex(607886);
        d = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ f1 b(f1 f1Var, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = f1Var.a;
        }
        if ((i & 2) != 0) {
            list = f1Var.b;
        }
        if ((i & 4) != 0) {
            list2 = f1Var.c;
        }
        return f1Var.a(str, list, list2);
    }

    public final f1 a(String title, List<t0> outerItems, List<t0> allItems) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(outerItems, "outerItems");
        Intrinsics.checkNotNullParameter(allItems, "allItems");
        return new f1(title, outerItems, allItems);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return Intrinsics.areEqual(this.a, f1Var.a) && Intrinsics.areEqual(this.b, f1Var.b) && Intrinsics.areEqual(this.c, f1Var.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SimilarNpsCardState(title=" + this.a + ", outerItems=" + this.b + ", allItems=" + this.c + ')';
    }

    public f1(String title, List<t0> outerItems, List<t0> allItems) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(outerItems, "outerItems");
        Intrinsics.checkNotNullParameter(allItems, "allItems");
        this.a = title;
        this.b = outerItems;
        this.c = allItems;
    }
}
