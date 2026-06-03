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
import lr4.e0;
import lr4.f0;
import lr4.s0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;

    static {
        Covode.recordClassIndex(611925);
        a = new e();
    }

    private e() {
    }

    private final void e() {
        c cVar = c.a;
        if (cVar.b("local_bookmark_migration", "0")) {
            p.f().d("本地书书签数据库已完成迁移，userId:0");
            return;
        }
        synchronized (this) {
            if (cVar.b("local_bookmark_migration", "0")) {
                p.f().d("本地书书签数据库已完成迁移，userId:0");
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<f0> f = DBManager.obtainLocalBookBookmarkDao().f();
            Intrinsics.checkNotNull(f);
            if (!f.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(f, 10));
                for (f0 f0Var : f) {
                    Intrinsics.checkNotNull(f0Var);
                    arrayList.add(new s0(f0Var));
                }
                ReaderDBManager.r().d(arrayList);
                c.a.c("local_bookmark_migration", "0");
                com.dragon.read.local.db.d.a.b("LocalBookmark", f.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                p.f().d("本地书书签数据库迁移完成，userId:0, size: " + f.size() + ", duration: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        DBManager.obtainLocalBookBookmarkDao().a(bookId);
        ReaderDBManager.r().a(bookId);
    }

    public final int a(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            e();
            com.dragon.read.local.db.d.a.a("LocalBookmark", "query", true);
            return ReaderDBManager.r().b(bookId);
        }
        com.dragon.read.local.db.d.a.a("LocalBookmark", "query", false);
        return DBManager.obtainLocalBookBookmarkDao().b(bookId);
    }

    public final void c(List<e0> bookmarks) {
        Intrinsics.checkNotNullParameter(bookmarks, "bookmarks");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookmarks, 10));
        Iterator<T> it2 = bookmarks.iterator();
        while (it2.hasNext()) {
            arrayList.add(new f0((e0) it2.next()));
        }
        DBManager.obtainLocalBookBookmarkDao().c(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookmarks, 10));
        Iterator<T> it4 = bookmarks.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new s0((e0) it4.next()));
        }
        ReaderDBManager.r().c(arrayList2);
    }

    public final List<Long> d(List<e0> bookMarks) {
        Intrinsics.checkNotNullParameter(bookMarks, "bookMarks");
        if (ReaderDatabase.a.b().enable) {
            e();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookMarks, 10));
        Iterator<T> it2 = bookMarks.iterator();
        while (it2.hasNext()) {
            arrayList.add(new f0((e0) it2.next()));
        }
        List<Long> d = DBManager.obtainLocalBookBookmarkDao().d(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(bookMarks, 10));
        Iterator<T> it4 = bookMarks.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new s0((e0) it4.next()));
        }
        List<Long> d2 = ReaderDBManager.r().d(arrayList2);
        if (ReaderDatabase.a.b().enable) {
            Intrinsics.checkNotNull(d2);
            return d2;
        }
        Intrinsics.checkNotNull(d);
        return d;
    }

    public final List<e0> f(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            e();
            com.dragon.read.local.db.d.a.a("LocalBookmark", "query", true);
            p.f().d("访问saas数据库表：LocalBookmark，action：queryBookMarkCacheData，bookId：" + bookId);
            List<s0> e = ReaderDBManager.r().e(bookId);
            Intrinsics.checkNotNull(e, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.LocalBookBookmark>");
            return TypeIntrinsics.asMutableList(e);
        }
        com.dragon.read.local.db.d.a.a("LocalBookmark", "query", false);
        p.f().d("访问业务数据库表：LocalBookmark，action：queryBookMarkCacheData，bookId：" + bookId);
        List<f0> e2 = DBManager.obtainLocalBookBookmarkDao().e(bookId);
        Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.LocalBookBookmark>");
        return TypeIntrinsics.asMutableList(e2);
    }
}
