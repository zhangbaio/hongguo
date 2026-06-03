package tm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import dm4.u;
import gj4.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static final String b;
    private static final String c;

    private a() {
    }

    static {
        Covode.recordClassIndex(608639);
        a = new a();
        b = "reader_download_button_update";
        c = "reader_menu_download_button_tips_controller_key";
    }

    public final boolean a(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        boolean z = e.a.a(c + '_' + u.b.b()).getBoolean(bookId, true);
        j.a.d(b, "isTipsAllowShow[" + bookId + "]:" + z);
        return z;
    }

    public final void b(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        j.a.d(b, "update tips reset:" + bookId);
        e.a.a(c + '_' + u.b.b()).edit().remove(bookId).apply();
    }

    public final void c(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        j.a.d(b, "update tips clicked:" + bookId);
        e.a.a(c + '_' + u.b.b()).edit().putBoolean(bookId, false).apply();
    }
}
