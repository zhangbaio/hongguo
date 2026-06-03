package tp4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609372);
        a = new a();
    }

    private a() {
    }

    public final void a(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        j.a.a("Story-" + tag, message);
    }

    public final void c(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        j.a.d("Story-" + tag, message);
    }

    public final void b(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        j.a.b("Story-" + tag, message, th);
    }

    public final void d(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        j.a.e("Story-" + tag, message, th);
    }
}
