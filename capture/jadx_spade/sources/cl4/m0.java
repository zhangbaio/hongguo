package cl4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class m0 {
    public final String a;
    public final boolean b;

    static {
        Covode.recordClassIndex(608065);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return Intrinsics.areEqual(this.a, m0Var.a) && this.b == m0Var.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.animation.m.a(this.b);
    }

    public String toString() {
        return "RecommendTagLayoutData(displayTitle=" + this.a + ", showSubTitle=" + this.b + ')';
    }

    public m0(String displayTitle, boolean z) {
        Intrinsics.checkNotNullParameter(displayTitle, "displayTitle");
        this.a = displayTitle;
        this.b = z;
    }
}
