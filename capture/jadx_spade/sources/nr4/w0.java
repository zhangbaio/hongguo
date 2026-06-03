package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w0 implements v0 {
    public static final a b;
    public static final int c;
    private static final LogHelper d;
    private final v0 a;

    public static final class a {
        static {
            Covode.recordClassIndex(611681);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611680);
        b = new a(null);
        c = 8;
        d = new LogHelper("ComicCore-IComicDataDaoImpl");
    }

    @Override // nr4.v0
    public List<lr4.v> b() {
        d.d("queryAllBook", new Object[0]);
        return this.a.b();
    }

    @Override // nr4.v0
    public List<lr4.s> z() {
        d.d("queryUnfinishedDownloadChapter", new Object[0]);
        return this.a.z();
    }

    public w0(v0 comicDao) {
        Intrinsics.checkNotNullParameter(comicDao, "comicDao");
        this.a = comicDao;
    }

    @Override // nr4.v0
    public List<lr4.s> x(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        d.d("queryBookChapterInfo", new Object[0]);
        return this.a.x(bookId);
    }

    @Override // nr4.v0
    public void a(List<String> bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        d.d("deleteBook bookId = " + bookId, new Object[0]);
        List<List<String>> a2 = com.dragon.read.local.db.e.a(bookId);
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.a(list);
            }
        }
    }

    @Override // nr4.v0
    public void g(List<String> lists) {
        Intrinsics.checkNotNullParameter(lists, "lists");
        d.d("deleteChapterByBooksId", new Object[0]);
        List<List<String>> a2 = com.dragon.read.local.db.e.a(lists);
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.g(list);
            }
        }
    }

    @Override // nr4.v0
    public List<lr4.z> j(List<String> chapterIds) {
        Intrinsics.checkNotNullParameter(chapterIds, "chapterIds");
        d.d("queryChapterListPic", new Object[0]);
        List<List<String>> a2 = com.dragon.read.local.db.e.a(chapterIds);
        ArrayList arrayList = new ArrayList();
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                List<lr4.z> j = v0Var.j(list);
                if (j != null) {
                    arrayList.addAll(j);
                }
            }
        }
        return arrayList;
    }

    @Override // nr4.v0
    public List<lr4.s> m(List<String> lists) {
        Intrinsics.checkNotNullParameter(lists, "lists");
        d.d("queryChapter", new Object[0]);
        List<List<String>> a2 = com.dragon.read.local.db.e.a(lists);
        ArrayList arrayList = new ArrayList();
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                List<lr4.s> m = v0Var.m(list);
                if (m != null) {
                    arrayList.addAll(m);
                }
            }
        }
        return arrayList;
    }

    @Override // nr4.v0
    public List<lr4.v> n(List<String> bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        d.d("queryBook", new Object[0]);
        ArrayList arrayList = new ArrayList();
        List<List<String>> a2 = com.dragon.read.local.db.e.a(bookIds);
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                List<lr4.v> n = v0Var.n(list);
                if (n != null) {
                    arrayList.addAll(n);
                }
            }
        }
        return arrayList;
    }

    @Override // nr4.v0
    public lr4.s p(String chapterId) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        d.d("queryChapter " + chapterId, new Object[0]);
        return this.a.p(chapterId);
    }

    @Override // nr4.v0
    public void r(lr4.v bookInfo) {
        Intrinsics.checkNotNullParameter(bookInfo, "bookInfo");
        d.d("insertOrReplaceBookInfo bookInfo = " + bookInfo.b, new Object[0]);
        this.a.r(bookInfo);
    }

    @Override // nr4.v0
    public lr4.v v(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        d.d("queryBook bookId = " + bookId, new Object[0]);
        return this.a.v(bookId);
    }

    @Override // nr4.v0
    public void w(List<String> chapterIds) {
        Intrinsics.checkNotNullParameter(chapterIds, "chapterIds");
        d.d("deleteChapterPicItems", new Object[0]);
        List<List<String>> a2 = com.dragon.read.local.db.e.a(chapterIds);
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.w(list);
            }
        }
    }

    @Override // nr4.v0
    public void y(List<String> bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        d.d("deleteBooksChapterPicItems", new Object[0]);
        List<List<String>> a2 = com.dragon.read.local.db.e.a(bookIds);
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.y(list);
            }
        }
    }

    @Override // nr4.v0
    public void i(List<lr4.z> itemInfoEntities) {
        Intrinsics.checkNotNullParameter(itemInfoEntities, "itemInfoEntities");
        d.d("insertOrReplace comic download ItemInfo " + itemInfoEntities.size(), new Object[0]);
        List<List<lr4.z>> a2 = com.dragon.read.local.db.e.a(itemInfoEntities);
        if (a2 != null) {
            for (List<lr4.z> list : a2) {
                Iterator<T> it2 = itemInfoEntities.iterator();
                while (it2.hasNext()) {
                    if (((lr4.z) it2.next()).g == 0) {
                        d.d("insertOrReplace comic ", new Object[0]);
                    }
                }
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.i(list);
            }
        }
    }

    @Override // nr4.v0
    public void o(List<lr4.s> chapterInfoEntities) {
        Intrinsics.checkNotNullParameter(chapterInfoEntities, "chapterInfoEntities");
        d.d("insertOrReplace comic download chapterInfo " + chapterInfoEntities.size(), new Object[0]);
        for (lr4.s sVar : chapterInfoEntities) {
            d.e("insertOrReplaceChapterInfo chapterInfo " + sVar.e + ", downloadStatus = " + sVar.p, new Object[0]);
        }
        List<List<lr4.s>> a2 = com.dragon.read.local.db.e.a(chapterInfoEntities);
        if (a2 != null) {
            for (List<lr4.s> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.o(list);
            }
        }
    }

    @Override // nr4.v0
    public List<lr4.s> s(List<String> lists) {
        Intrinsics.checkNotNullParameter(lists, "lists");
        d.d("queryChapterByBooksId ", new Object[0]);
        try {
            List<List<String>> a2 = com.dragon.read.local.db.e.a(lists);
            ArrayList arrayList = new ArrayList();
            if (a2 != null) {
                for (List<String> list : a2) {
                    v0 v0Var = this.a;
                    Intrinsics.checkNotNull(list);
                    List<lr4.s> s = v0Var.s(list);
                    if (s != null) {
                        arrayList.addAll(s);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            LogHelper logHelper = d;
            logHelper.d(th.getMessage(), new Object[0]);
            logHelper.d("queryChapterByBooksId " + lists.size(), new Object[0]);
            return new ArrayList();
        }
    }

    @Override // nr4.v0
    public List<String> h(List<String> bookIds, int i) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        d.d("queryChapterByDownloadStatus", new Object[0]);
        List<List<String>> a2 = com.dragon.read.local.db.e.a(bookIds);
        ArrayList arrayList = new ArrayList();
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                List<String> h = v0Var.h(list, i);
                if (h != null) {
                    arrayList.addAll(h);
                }
            }
        }
        return arrayList;
    }

    @Override // nr4.v0
    public void k(List<String> chapterIds, int i) {
        Intrinsics.checkNotNullParameter(chapterIds, "chapterIds");
        List<List<String>> a2 = com.dragon.read.local.db.e.a(chapterIds);
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.k(list, i);
            }
        }
    }

    @Override // nr4.v0
    public void l(List<String> chapterIds, int i) {
        Intrinsics.checkNotNullParameter(chapterIds, "chapterIds");
        List<List<String>> a2 = com.dragon.read.local.db.e.a(chapterIds);
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.l(list, i);
            }
        }
    }

    @Override // nr4.v0
    public void q(int i, List<String> chapterIds) {
        Intrinsics.checkNotNullParameter(chapterIds, "chapterIds");
        List<List<String>> a2 = com.dragon.read.local.db.e.a(chapterIds);
        if (a2 != null) {
            for (List<String> list : a2) {
                v0 v0Var = this.a;
                Intrinsics.checkNotNull(list);
                v0Var.q(i, list);
            }
        }
    }

    @Override // nr4.v0
    public void t(String lastDownloadSuccessTime, String bookId) {
        Intrinsics.checkNotNullParameter(lastDownloadSuccessTime, "lastDownloadSuccessTime");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        d.d("updateBookDownloadStatus bookId = " + bookId + ", updateTime = " + lastDownloadSuccessTime, new Object[0]);
        this.a.t(lastDownloadSuccessTime, bookId);
    }

    @Override // nr4.v0
    public void f(int i, String downloadTaskId, List<String> picInfoKey) {
        Intrinsics.checkNotNullParameter(downloadTaskId, "downloadTaskId");
        Intrinsics.checkNotNullParameter(picInfoKey, "picInfoKey");
        this.a.f(i, downloadTaskId, picInfoKey);
    }

    @Override // nr4.v0
    public void u(String chapterId, int i, int i2) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        this.a.u(chapterId, i, i2);
    }
}
