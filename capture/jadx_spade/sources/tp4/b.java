package tp4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    private final String a;

    static {
        Covode.recordClassIndex(609373);
    }

    public b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.a = tag;
    }

    public final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a.a(this.a, message);
    }

    public final void d(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a.c(this.a, message);
    }

    public final void b(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a.b(this.a, message, th);
    }

    public final void e(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        a.a.d(this.a, message, th);
    }

    public static /* synthetic */ void c(b bVar, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        bVar.b(str, th);
    }

    public static /* synthetic */ void f(b bVar, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        bVar.e(str, th);
    }
}
