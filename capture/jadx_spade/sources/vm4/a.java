package vm4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int d;
    public final String a;
    public final List<String> b;
    public final String c;

    static {
        Covode.recordClassIndex(608666);
        d = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ShortSeriesParaCoverModel(thumbUrl=" + this.a + ", legendText=" + this.b + ", playBtnName=" + this.c + ')';
    }

    public a(String thumbUrl, List<String> legendText, String playBtnName) {
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        Intrinsics.checkNotNullParameter(legendText, "legendText");
        Intrinsics.checkNotNullParameter(playBtnName, "playBtnName");
        this.a = thumbUrl;
        this.b = legendText;
        this.c = playBtnName;
    }
}
