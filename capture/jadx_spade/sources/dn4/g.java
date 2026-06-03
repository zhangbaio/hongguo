package dn4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final int f;
    public final List<String> a;
    public final String b;
    public final List<String> c;
    public final String d;
    public final int e;

    static {
        Covode.recordClassIndex(608745);
        f = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d) && this.e == gVar.e;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e;
    }

    public String toString() {
        return "IpCardTagBg(bgColor=" + this.a + ", textColor=" + this.b + ", darkBgColor=" + this.c + ", darkTextColor=" + this.d + ", bgColorOrientation=" + this.e + ')';
    }

    public g(List<String> bgColor, String textColor, List<String> darkBgColor, String darkTextColor, int i) {
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(darkBgColor, "darkBgColor");
        Intrinsics.checkNotNullParameter(darkTextColor, "darkTextColor");
        this.a = bgColor;
        this.b = textColor;
        this.c = darkBgColor;
        this.d = darkTextColor;
        this.e = i;
    }
}
