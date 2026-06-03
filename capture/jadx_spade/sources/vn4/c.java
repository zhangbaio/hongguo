package vn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public final String a;
    public final String b;
    public final d c;

    static {
        Covode.recordClassIndex(608943);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SharePosterImage(qrPosterImageString=" + this.a + ", posterImageString=" + this.b + ", qrStyle=" + this.c + ')';
    }

    public c(String qrPosterImageString, String posterImageString, d qrStyle) {
        Intrinsics.checkNotNullParameter(qrPosterImageString, "qrPosterImageString");
        Intrinsics.checkNotNullParameter(posterImageString, "posterImageString");
        Intrinsics.checkNotNullParameter(qrStyle, "qrStyle");
        this.a = qrPosterImageString;
        this.b = posterImageString;
        this.c = qrStyle;
    }
}
