package qr4;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.ReaderDatabase;
import com.dragon.read.kmp.reader.utils.p;
import com.dragon.read.local.db.DBManager;
import com.dragon.read.local.db.ReaderDBManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import lr4.n;
import lr4.o;
import lr4.p0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    static {
        Covode.recordClassIndex(611922);
        a = new b();
    }

    private b() {
    }

    public final List<n> h(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            g(userId);
            com.dragon.read.local.db.d.a.a("BookmarkRemote", "query", true);
            p.f().d("访问saas数据库表：BookmarkRemote, method: queryAllDeletedBookmarks");
            List<p0> i = ReaderDBManager.m(userId).i();
            Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.BookmarkRemote>");
            return TypeIntrinsics.asMutableList(i);
        }
        com.dragon.read.local.db.d.a.a("BookmarkRemote", "query", false);
        p.f().d("访问业务数据库：BookmarkRemote, method: queryAllDeletedBookmarks");
        List<o> i2 = DBManager.obtainBookMarkDao(userId).i();
        Intrinsics.checkNotNull(i2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.BookmarkRemote>");
        return TypeIntrinsics.asMutableList(i2);
    }

    private final void g(String str) {
        c cVar = c.a;
        if (cVar.b("bookmark_remote_migration", str)) {
            p.f().d("线上书书签数据库已完成迁移，userId: " + str);
            return;
        }
        synchronized (this) {
            if (cVar.b("bookmark_remote_migration", str)) {
                p.f().d("线上书书签数据库已完成迁移，userId: " + str);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<o> j = DBManager.obtainBookMarkDao(str).j();
            Intrinsics.checkNotNull(j);
            if (!j.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(j, 10));
                for (o oVar : j) {
                    p0 p0Var = new p0();
                    Intrinsics.checkNotNull(oVar);
                    arrayList.add(p0Var.c(oVar));
                }
                ReaderDBManager.m(str).g(arrayList);
                c.a.c("bookmark_remote_migration", str);
                com.dragon.read.local.db.d.a.b("BookmarkRemote", j.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                p.f().d("线上书书签数据库迁移完成，userId: " + str + ", size: " + j.size() + ", duration: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(String userId, String bookId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        ReaderDBManager.m(userId).a(bookId);
        DBManager.obtainBookMarkDao(userId).a(bookId);
    }

    public final void d(String userId, String bookId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        ReaderDBManager.m(userId).d(bookId);
        DBManager.obtainBookMarkDao(userId).d(bookId);
    }

    public final int a(String userId, String bookId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            g(userId);
            com.dragon.read.local.db.d.a.a("BookmarkRemote", "query", true);
            return ReaderDBManager.m(userId).b(bookId);
        }
        com.dragon.read.local.db.d.a.a("BookmarkRemote", "query", false);
        return DBManager.obtainBookMarkDao(userId).b(bookId);
    }

    public final void c(String userId, List<n> bookmarks) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookmarks, "bookmarks");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookmarks, 10));
        Iterator<T> it2 = bookmarks.iterator();
        while (it2.hasNext()) {
            arrayList.add(new p0().c((n) it2.next()));
        }
        ReaderDBManager.m(userId).c(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookmarks, 10));
        Iterator<T> it4 = bookmarks.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new o().c((n) it4.next()));
        }
        DBManager.obtainBookMarkDao(userId).c(arrayList2);
    }

    public final void f(String userId, List<? extends n> bookmarks) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookmarks, "bookmarks");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookmarks, 10));
        Iterator<T> it2 = bookmarks.iterator();
        while (it2.hasNext()) {
            arrayList.add(new p0().c((n) it2.next()));
        }
        ReaderDBManager.m(userId).h(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookmarks, 10));
        Iterator<T> it4 = bookmarks.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new o().c((n) it4.next()));
        }
        DBManager.obtainBookMarkDao(userId).h(arrayList2);
    }

    public final List<n> i(String userId, String bookId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            g(userId);
            com.dragon.read.local.db.d.a.a("BookmarkRemote", "query", true);
            p.f().d("访问saas数据库表：BookmarkRemote, method: queryBookMarks，bookId:" + bookId);
            List<p0> e = ReaderDBManager.m(userId).e(bookId);
            Intrinsics.checkNotNull(e, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.BookmarkRemote>");
            return TypeIntrinsics.asMutableList(e);
        }
        com.dragon.read.local.db.d.a.a("BookmarkRemote", "query", false);
        p.f().d("访问业务数据库：BookmarkRemote, method: queryBookMarks，bookId:" + bookId);
        List<o> e2 = DBManager.obtainBookMarkDao(userId).e(bookId);
        Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.BookmarkRemote>");
        return TypeIntrinsics.asMutableList(e2);
    }

    public final List<n> j(String userId, String bookId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            g(userId);
            com.dragon.read.local.db.d.a.a("BookmarkRemote", "query", true);
            p.f().d("访问saas数据库表：BookmarkRemote, method: queryDeletedBookmarks，bookId:" + bookId);
            List<p0> f = ReaderDBManager.m(userId).f(bookId);
            Intrinsics.checkNotNull(f, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.BookmarkRemote>");
            return TypeIntrinsics.asMutableList(f);
        }
        com.dragon.read.local.db.d.a.a("BookmarkRemote", "query", false);
        p.f().d("访问业务数据库：BookmarkRemote, method: queryDeletedBookmarks，bookId:" + bookId);
        List<o> f2 = DBManager.obtainBookMarkDao(userId).f(bookId);
        Intrinsics.checkNotNull(f2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.BookmarkRemote>");
        return TypeIntrinsics.asMutableList(f2);
    }

    public final List<Long> e(String userId, List<n> bookMarks) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookMarks, "bookMarks");
        if (ReaderDatabase.a.b().enable) {
            g(userId);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookMarks, 10));
        Iterator<T> it2 = bookMarks.iterator();
        while (it2.hasNext()) {
            arrayList.add(new p0().c((n) it2.next()));
        }
        List<Long> g = ReaderDBManager.m(userId).g(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookMarks, 10));
        Iterator<T> it4 = bookMarks.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new o().c((n) it4.next()));
        }
        List<Long> g2 = DBManager.obtainBookMarkDao(userId).g(arrayList2);
        if (ReaderDatabase.a.b().enable) {
            Intrinsics.checkNotNull(g);
            return g;
        }
        Intrinsics.checkNotNull(g2);
        return g2;
    }
}
