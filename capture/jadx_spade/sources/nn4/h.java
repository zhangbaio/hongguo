package nn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public static final int d;
    public String a;
    public String b;
    public String c;

    static {
        Covode.recordClassIndex(608810);
        d = 8;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public h(String thumbUrl) {
        Intrinsics.checkNotNullParameter(thumbUrl, "thumbUrl");
        this.b = "";
        this.c = "";
        this.a = thumbUrl;
    }
}
