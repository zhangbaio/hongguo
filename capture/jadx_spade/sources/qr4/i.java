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
import lr4.p1;
import lr4.q1;
import lr4.w0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final i a;

    static {
        Covode.recordClassIndex(611929);
        a = new i();
    }

    private i() {
    }

    public final List<p1> h(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            f(userId);
            com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", true);
            p.k().d("访问saas数据库表:UnderlineRemote, method:queryAllDeletedUnderlines");
            List<w0> j = ReaderDBManager.w(userId).j();
            Intrinsics.checkNotNull(j, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineRemote>");
            return TypeIntrinsics.asMutableList(j);
        }
        com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", false);
        p.k().d("访问业务数据库表:UnderlineRemote, method:queryAllDeletedUnderlines");
        List<q1> j2 = DBManager.obtainUnderlineDao(userId).j();
        Intrinsics.checkNotNull(j2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineRemote>");
        return TypeIntrinsics.asMutableList(j2);
    }

    private final void f(String str) {
        c cVar = c.a;
        if (cVar.b("underline_remote_migration", str)) {
            p.k().d("线上书划线数据库已完成迁移，userId:" + str);
            return;
        }
        synchronized (this) {
            if (cVar.b("underline_remote_migration", str)) {
                p.k().d("线上书划线数据库已完成迁移，userId:" + str);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<q1> k = DBManager.obtainUnderlineDao(str).k();
            Intrinsics.checkNotNull(k);
            if (!k.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(k, 10));
                for (q1 q1Var : k) {
                    Intrinsics.checkNotNull(q1Var);
                    arrayList.add(new w0(q1Var));
                }
                ReaderDBManager.w(str).e(arrayList);
                c.a.c("underline_remote_migration", str);
                com.dragon.read.local.db.d.a.b("UnderlineRemote", k.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                p.k().d("线上书划线数据库迁移完成，userId:" + str + ", size: " + k.size() + ", duration: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        DBManager.obtainUnderlineDao(userId).a(str);
        ReaderDBManager.w(userId).a(str);
    }

    public final void c(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (str == null) {
            return;
        }
        DBManager.obtainUnderlineDao(userId).g(str);
        ReaderDBManager.w(userId).g(str);
    }

    public final int g(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            f(userId);
            com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", true);
            return ReaderDBManager.w(userId).b(str);
        }
        com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", false);
        return DBManager.obtainUnderlineDao(userId).b(str);
    }

    public final int k(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            f(userId);
            com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", true);
            return ReaderDBManager.w(userId).d(str);
        }
        com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", false);
        return DBManager.obtainUnderlineDao(userId).d(str);
    }

    public final void b(String userId, List<p1> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(new q1((p1) it2.next()));
        }
        DBManager.obtainUnderlineDao(userId).c(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it4 = list.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new w0((p1) it4.next()));
        }
        ReaderDBManager.w(userId).c(arrayList2);
    }

    public final void e(String userId, List<p1> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        if (ReaderDatabase.a.b().enable) {
            f(userId);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(new q1((p1) it2.next()));
        }
        DBManager.obtainUnderlineDao(userId).f(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it4 = list.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new w0((p1) it4.next()));
        }
        ReaderDBManager.w(userId).f(arrayList2);
    }

    public final List<p1> i(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            f(userId);
            com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", true);
            p.k().d("访问saas数据库表:UnderlineRemote, method:queryDeletedUnderlines, bookId:" + str);
            List<w0> h = ReaderDBManager.w(userId).h(str);
            Intrinsics.checkNotNull(h, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineRemote>");
            return TypeIntrinsics.asMutableList(h);
        }
        com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", false);
        p.k().d("访问业务数据库表:UnderlineRemote, method:queryDeletedUnderlines, bookId:" + str);
        List<q1> h2 = DBManager.obtainUnderlineDao(userId).h(str);
        Intrinsics.checkNotNull(h2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineRemote>");
        return TypeIntrinsics.asMutableList(h2);
    }

    public final List<p1> j(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            f(userId);
            com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", true);
            p.k().d("访问saas数据库表:UnderlineRemote, method:queryUnderlines, bookId:" + str);
            List<w0> i = ReaderDBManager.w(userId).i(str);
            Intrinsics.checkNotNull(i, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineRemote>");
            return TypeIntrinsics.asMutableList(i);
        }
        com.dragon.read.local.db.d.a.a("UnderlineRemote", "query", false);
        p.k().d("访问业务数据库表:UnderlineRemote, method:queryUnderlines, bookId:" + str);
        List<q1> i2 = DBManager.obtainUnderlineDao(userId).i(str);
        Intrinsics.checkNotNull(i2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineRemote>");
        return TypeIntrinsics.asMutableList(i2);
    }

    public final List<Long> d(String userId, List<p1> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return new ArrayList();
        }
        if (ReaderDatabase.a.b().enable) {
            f(userId);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(new q1((p1) it2.next()));
        }
        List<Long> e = DBManager.obtainUnderlineDao(userId).e(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it4 = list.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new w0((p1) it4.next()));
        }
        List<Long> e2 = ReaderDBManager.w(userId).e(arrayList2);
        if (ReaderDatabase.a.b().enable) {
            Intrinsics.checkNotNull(e2);
            return e2;
        }
        Intrinsics.checkNotNull(e);
        return e;
    }
}
