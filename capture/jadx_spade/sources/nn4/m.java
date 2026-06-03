package nn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final int e;
    public String a;
    public String b;
    public String c;
    public String d;

    static {
        Covode.recordClassIndex(608815);
        e = 8;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public m(String seriesId, String cover) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(cover, "cover");
        this.c = "";
        this.d = "";
        this.a = seriesId;
        this.b = cover;
    }
}
