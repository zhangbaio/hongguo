package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e1 {
    public final String a;
    public final String b;

    static {
        Covode.recordClassIndex(611614);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return Intrinsics.areEqual(this.a, e1Var.a) && Intrinsics.areEqual(this.b, e1Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "RelativePdfEpubModel(pdfBookId=" + this.a + ", epubBookId=" + this.b + ')';
    }

    public e1(String pdfBookId, String epubBookId) {
        Intrinsics.checkNotNullParameter(pdfBookId, "pdfBookId");
        Intrinsics.checkNotNullParameter(epubBookId, "epubBookId");
        this.a = pdfBookId;
        this.b = epubBookId;
    }
}
