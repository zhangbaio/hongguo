package wm4;

import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final int i;
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final boolean e;
    public final List<u> f;
    public final l0 g;
    public final l0 h;

    static {
        Covode.recordClassIndex(608670);
        i = 8;
    }

    public /* synthetic */ o(String str, int i2, String str2, int i3, boolean z, List list, l0 l0Var, l0 l0Var2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i2, str2, i3, z, list, l0Var, l0Var2);
    }

    public final o a(String cardTitle, int i2, String cardBgUrl, int i3, boolean z, List<u> relatedWorkList, l0 l0Var, l0 l0Var2) {
        Intrinsics.checkNotNullParameter(cardTitle, "cardTitle");
        Intrinsics.checkNotNullParameter(cardBgUrl, "cardBgUrl");
        Intrinsics.checkNotNullParameter(relatedWorkList, "relatedWorkList");
        return new o(cardTitle, i2, cardBgUrl, i3, z, relatedWorkList, l0Var, l0Var2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return Intrinsics.areEqual(this.a, oVar.a) && this.b == oVar.b && Intrinsics.areEqual(this.c, oVar.c) && this.d == oVar.d && this.e == oVar.e && Intrinsics.areEqual(this.f, oVar.f) && Intrinsics.areEqual(this.g, oVar.g) && Intrinsics.areEqual(this.h, oVar.h);
    }

    public int hashCode() {
        int hashCode = ((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + androidx.compose.animation.m.a(this.e)) * 31) + this.f.hashCode()) * 31;
        l0 l0Var = this.g;
        int v = (hashCode + (l0Var == null ? 0 : l0.v(l0Var.x()))) * 31;
        l0 l0Var2 = this.h;
        return v + (l0Var2 != null ? l0.v(l0Var2.x()) : 0);
    }

    public String toString() {
        return "RelatedWork2ColCardState(cardTitle=" + this.a + ", cardRadius=" + this.b + ", cardBgUrl=" + this.c + ", bgImageHeight=" + this.d + ", moreAreaShow=" + this.e + ", relatedWorkList=" + this.f + ", cardBgColor=" + this.g + ", mainTitleColor=" + this.h + ')';
    }

    private o(String cardTitle, int i2, String cardBgUrl, int i3, boolean z, List<u> relatedWorkList, l0 l0Var, l0 l0Var2) {
        Intrinsics.checkNotNullParameter(cardTitle, "cardTitle");
        Intrinsics.checkNotNullParameter(cardBgUrl, "cardBgUrl");
        Intrinsics.checkNotNullParameter(relatedWorkList, "relatedWorkList");
        this.a = cardTitle;
        this.b = i2;
        this.c = cardBgUrl;
        this.d = i3;
        this.e = z;
        this.f = relatedWorkList;
        this.g = l0Var;
        this.h = l0Var2;
    }
}
