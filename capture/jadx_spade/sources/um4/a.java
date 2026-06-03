package um4;

import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.k0;
import dm4.s;
import dm4.v;
import im4.d;
import kotlin.jvm.internal.Intrinsics;
import xf4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(608647);
        a = new a();
    }

    private a() {
    }

    private final boolean a() {
        d c;
        i a2 = e.p3.a().readerLifecycleService().O().a();
        if (a2 == null || (c = a2.a().c()) == null) {
            return false;
        }
        return c.c();
    }

    public final void b(boolean z, String bookId, String content, ym4.a aVar) {
        String str;
        boolean z2;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(content, "content");
        ym4.a aVar2 = new ym4.a();
        aVar2.g("clicked_content", content).g("book_id", bookId);
        if (aVar != null) {
            aVar2.j(aVar);
        }
        if (z) {
            aVar2.g("book_type", "upload");
        }
        if (a()) {
            aVar2.g("book_type", "cable_publish");
        }
        boolean c = e.p3.a().readerTtsSyncService().c(bookId);
        boolean isPlaying = v.b.isPlaying(bookId);
        if (c && isPlaying) {
            aVar2.g("status", "listen_and_read");
        } else {
            aVar2.g("status", "read");
        }
        Object l = k0.a.b().l("reader_listen_entrance");
        if (l instanceof String) {
            str = (String) l;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            aVar2.g("reader_listen_entrance", str);
        }
        s.b.a("click_reader", aVar2);
    }
}
