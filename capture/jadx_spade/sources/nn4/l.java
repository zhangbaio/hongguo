package nn4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public static final int f;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    static {
        Covode.recordClassIndex(608814);
        f = 8;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public l(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.a = text;
    }
}
