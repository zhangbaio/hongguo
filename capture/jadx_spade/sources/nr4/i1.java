package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i1 implements h1 {
    public static final int b;
    private final h1 a;

    static {
        Covode.recordClassIndex(611693);
        b = 8;
    }

    @Override // nr4.h1
    public List<vt4.b> b() {
        return this.a.b();
    }

    public i1(h1 dao) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.a = dao;
    }

    @Override // nr4.h1
    public void a(List<vt4.b> downloadBookInfos) {
        Intrinsics.checkNotNullParameter(downloadBookInfos, "downloadBookInfos");
        List<List<vt4.b>> a = com.dragon.read.local.db.e.a(downloadBookInfos);
        Intrinsics.checkNotNull(a);
        for (List<vt4.b> list : a) {
            h1 h1Var = this.a;
            Intrinsics.checkNotNull(list);
            h1Var.a(list);
        }
    }

    @Override // nr4.h1
    public void delete(List<vt4.b> downloadBookInfos) {
        Intrinsics.checkNotNullParameter(downloadBookInfos, "downloadBookInfos");
        List<List<vt4.b>> a = com.dragon.read.local.db.e.a(downloadBookInfos);
        Intrinsics.checkNotNull(a);
        for (List<vt4.b> list : a) {
            h1 h1Var = this.a;
            Intrinsics.checkNotNull(list);
            h1Var.delete(list);
        }
    }

    @Override // nr4.h1
    public vt4.b c(String bookId, BookType bookType) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(bookType, "bookType");
        return this.a.c(bookId, bookType);
    }
}
