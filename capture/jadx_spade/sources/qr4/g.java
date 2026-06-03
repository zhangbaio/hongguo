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
import lr4.k0;
import lr4.l0;
import lr4.u0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final g a;

    static {
        Covode.recordClassIndex(611927);
        a = new g();
    }

    private g() {
    }

    public final List<k0> b(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            a(userId);
            com.dragon.read.local.db.d.a.a("NoteBookData", "query", true);
            p.i().d("访问saas数据库表：NoteBookData，action:queryAllLocalDesc");
            List<u0> b = ReaderDBManager.u(userId).b();
            Intrinsics.checkNotNull(b, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.NoteBookData>");
            return TypeIntrinsics.asMutableList(b);
        }
        com.dragon.read.local.db.d.a.a("NoteBookData", "query", false);
        p.i().d("访问业务数据库表：NoteBookData，action:queryAllLocalDesc");
        List<l0> b2 = DBManager.obtainNoteBookDataDao(userId).b();
        Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.NoteBookData>");
        return TypeIntrinsics.asMutableList(b2);
    }

    public final List<k0> c(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            a(userId);
            com.dragon.read.local.db.d.a.a("NoteBookData", "query", true);
            p.i().d("访问saas数据库表：NoteBookData，action:queryAllRemoteDesc");
            List<u0> a2 = ReaderDBManager.u(userId).a();
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.NoteBookData>");
            return TypeIntrinsics.asMutableList(a2);
        }
        com.dragon.read.local.db.d.a.a("NoteBookData", "query", false);
        p.i().d("访问业务数据库表：NoteBookData，action:queryAllRemoteDesc");
        List<l0> a3 = DBManager.obtainNoteBookDataDao(userId).a();
        Intrinsics.checkNotNull(a3, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.NoteBookData>");
        return TypeIntrinsics.asMutableList(a3);
    }

    private final void a(String str) {
        c cVar = c.a;
        if (cVar.b("note_book_data_migration", str)) {
            p.i().d("笔记中心数据库已完成迁移，userId:" + str);
            return;
        }
        synchronized (this) {
            if (cVar.b("note_book_data_migration", str)) {
                p.i().d("笔记中心数据库已完成迁移，userId:" + str);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<l0> c = DBManager.obtainNoteBookDataDao(str).c();
            Intrinsics.checkNotNull(c);
            if (!c.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(c, 10));
                for (l0 l0Var : c) {
                    Intrinsics.checkNotNull(l0Var);
                    arrayList.add(new u0(l0Var));
                }
                ReaderDBManager.u(str).insert(arrayList);
                c.a.c("note_book_data_migration", str);
                com.dragon.read.local.db.d.a.b("NoteBookData", c.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                p.i().d("笔记中心数据库迁移完成，userId:" + str + ", size: " + c.size() + ", duration: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void delete(String userId, String bookId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        ReaderDBManager.u(userId).delete(bookId);
        DBManager.obtainNoteBookDataDao(userId).delete(bookId);
    }

    public final void delete(String userId, List<k0> noteBookData) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(noteBookData, "noteBookData");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(noteBookData, 10));
        Iterator<T> it2 = noteBookData.iterator();
        while (it2.hasNext()) {
            arrayList.add(new u0((k0) it2.next()));
        }
        ReaderDBManager.u(userId).delete(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(noteBookData, 10));
        Iterator<T> it4 = noteBookData.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new l0((k0) it4.next()));
        }
        DBManager.obtainNoteBookDataDao(userId).delete(arrayList2);
    }

    public final void insert(String userId, List<k0> noteBookData) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(noteBookData, "noteBookData");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(noteBookData, 10));
        Iterator<T> it2 = noteBookData.iterator();
        while (it2.hasNext()) {
            arrayList.add(new u0((k0) it2.next()));
        }
        ReaderDBManager.u(userId).insert(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(noteBookData, 10));
        Iterator<T> it4 = noteBookData.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new l0((k0) it4.next()));
        }
        DBManager.obtainNoteBookDataDao(userId).insert(arrayList2);
    }

    public final k0 query(String userId, String bookId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            a(userId);
            com.dragon.read.local.db.d.a.a("NoteBookData", "query", true);
            p.i().d("访问saas数据库表：NoteBookData，action:query, bookId:" + bookId);
            return ReaderDBManager.u(userId).query(bookId);
        }
        com.dragon.read.local.db.d.a.a("NoteBookData", "query", false);
        p.i().d("访问业务数据库表：NoteBookData，action:query, bookId:" + bookId);
        return DBManager.obtainNoteBookDataDao(userId).query(bookId);
    }
}
