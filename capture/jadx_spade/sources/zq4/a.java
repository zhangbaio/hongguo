package zq4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final long d;

    static {
        Covode.recordClassIndex(611406);
    }

    public a(String str, String str2, String version, long j) {
        Intrinsics.checkNotNullParameter(version, "version");
        this.a = str;
        this.b = str2;
        this.c = version;
        this.d = j;
    }
}
