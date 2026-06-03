package uk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int e;
    public String a = "";
    public String b = "";
    public c c = new a();
    public final rk6.a d = new rk6.a(this.a, this.b, d.b(this.c));

    static {
        Covode.recordClassIndex(608002);
        e = 8;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }
}
