package ws3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final int d;
    public String a = "";
    public String b = "";
    public String c = "";

    static {
        Covode.recordClassIndex(599165);
        d = 8;
    }

    public final void a(String ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.a = ids;
    }

    public final void b(String bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        this.c = bookIds;
    }

    public final void c(String gids) {
        Intrinsics.checkNotNullParameter(gids, "gids");
        this.b = gids;
    }
}
