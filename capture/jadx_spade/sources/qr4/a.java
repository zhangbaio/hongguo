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
import lr4.l;
import lr4.m;
import lr4.o0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(611921);
        a = new a();
    }

    private a() {
    }

    public final List<? extends l> f(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            e(userId);
            com.dragon.read.local.db.d.a.a("BookmarkLocal", "query", true);
            p.f().d("访问saas数据库：BookmarkLocal, method: queryAllBookMarkCacheData");
            List<o0> f = ReaderDBManager.o(userId).f();
            Intrinsics.checkNotNullExpressionValue(f, "queryAllBookMarkCacheData(...)");
            return f;
        }
        com.dragon.read.local.db.d.a.a("BookmarkLocal", "query", false);
        p.f().d("访问业务数据库：BookmarkLocal, method: queryAllBookMarkCacheData");
        List<m> f2 = DBManager.obtainBookMarkCacheDao(userId).f();
        Intrinsics.checkNotNullExpressionValue(f2, "queryAllBookMarkCacheData(...)");
        return f2;
    }

    private final void e(String str) {
        c cVar = c.a;
        if (cVar.b("bookmark_local_migration", str)) {
            p.f().d("线上书本地书签数据库已完成迁移，userId: " + str);
            return;
        }
        synchronized (this) {
            if (cVar.b("bookmark_local_migration", str)) {
                p.f().d("线上书本地书签数据库已完成迁移，userId: " + str);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<m> f = DBManager.obtainBookMarkCacheDao(str).f();
            Intrinsics.checkNotNull(f);
            if (!f.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(f, 10));
                for (m mVar : f) {
                    o0 o0Var = new o0();
                    Intrinsics.checkNotNull(mVar);
                    arrayList.add(o0Var.b(mVar));
                }
                ReaderDBManager.o(str).d(arrayList);
                c.a.c("bookmark_local_migration", str);
                com.dragon.read.local.db.d.a.b("BookmarkLocal", f.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                p.f().d("线上书本地书签数据库迁移完成，userId: " + str + ", size: " + f.size() + ", duration: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        ReaderDBManager.o(userId).a(str);
        DBManager.obtainBookMarkCacheDao(userId).a(str);
    }

    public final int a(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            e(userId);
            com.dragon.read.local.db.d.a.a("BookmarkLocal", "query", true);
            return ReaderDBManager.o(userId).b(str);
        }
        com.dragon.read.local.db.d.a.a("BookmarkLocal", "query", false);
        return DBManager.obtainBookMarkCacheDao(userId).b(str);
    }

    public final void c(String userId, List<l> bookmarks) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookmarks, "bookmarks");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookmarks, 10));
        Iterator<T> it2 = bookmarks.iterator();
        while (it2.hasNext()) {
            arrayList.add(new o0().b((l) it2.next()));
        }
        ReaderDBManager.o(userId).c(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookmarks, 10));
        Iterator<T> it4 = bookmarks.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new m().b((l) it4.next()));
        }
        DBManager.obtainBookMarkCacheDao(userId).c(arrayList2);
    }

    public final List<l> g(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            e(userId);
            com.dragon.read.local.db.d.a.a("BookmarkLocal", "query", true);
            p.f().d("访问saas数据库表：BookmarkLocal，method: queryBookMarkCacheData, bookId:" + str);
            List<o0> e = ReaderDBManager.o(userId).e(str);
            Intrinsics.checkNotNull(e, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.BookmarkLocal>");
            return TypeIntrinsics.asMutableList(e);
        }
        p.f().d("访问业务数据库：BookmarkLocal，method: queryBookMarkCacheData, bookId:" + str);
        com.dragon.read.local.db.d.a.a("BookmarkLocal", "query", false);
        List<m> e2 = DBManager.obtainBookMarkCacheDao(userId).e(str);
        Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.BookmarkLocal>");
        return TypeIntrinsics.asMutableList(e2);
    }

    public final List<Long> d(String userId, List<l> bookMarks) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookMarks, "bookMarks");
        if (ReaderDatabase.a.b().enable) {
            e(userId);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookMarks, 10));
        Iterator<T> it2 = bookMarks.iterator();
        while (it2.hasNext()) {
            arrayList.add(new o0().b((l) it2.next()));
        }
        List<Long> d = ReaderDBManager.o(userId).d(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookMarks, 10));
        Iterator<T> it4 = bookMarks.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new m().b((l) it4.next()));
        }
        List<Long> d2 = DBManager.obtainBookMarkCacheDao(userId).d(arrayList2);
        if (ReaderDatabase.a.b().enable) {
            Intrinsics.checkNotNull(d);
            return d;
        }
        Intrinsics.checkNotNull(d2);
        return d2;
    }
}
