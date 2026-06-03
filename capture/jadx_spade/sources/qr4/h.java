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
import lr4.n1;
import lr4.o1;
import lr4.v0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public static final h a;

    static {
        Covode.recordClassIndex(611928);
        a = new h();
    }

    private h() {
    }

    public final List<n1> f(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            d(userId);
            com.dragon.read.local.db.d.a.a("UnderlineLocal", "query", true);
            p.k().d("访问saas数据库表：UnderlineLocal， method：queryAllUnderlineCacheData");
            List<v0> g = ReaderDBManager.v(userId).g();
            Intrinsics.checkNotNull(g, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineLocal>");
            return TypeIntrinsics.asMutableList(g);
        }
        com.dragon.read.local.db.d.a.a("UnderlineLocal", "query", false);
        p.k().d("访问业务数据库表：UnderlineLocal， method：queryAllUnderlineCacheData");
        List<o1> g2 = DBManager.obtainUnderlineCacheDao(userId).g();
        Intrinsics.checkNotNull(g2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineLocal>");
        return TypeIntrinsics.asMutableList(g2);
    }

    private final void d(String str) {
        c cVar = c.a;
        if (cVar.b("underline_local_migration", str)) {
            p.k().d("线上书本地划线数据库已完成迁移，userId:" + str);
            return;
        }
        synchronized (this) {
            if (cVar.b("underline_local_migration", str)) {
                p.k().d("线上书本地划线数据库已完成迁移，userId:" + str);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<o1> g = DBManager.obtainUnderlineCacheDao(str).g();
            Intrinsics.checkNotNull(g);
            if (!g.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(g, 10));
                for (o1 o1Var : g) {
                    Intrinsics.checkNotNull(o1Var);
                    arrayList.add(new v0(o1Var));
                }
                ReaderDBManager.v(str).f(arrayList);
                c.a.c("underline_local_migration", str);
                com.dragon.read.local.db.d.a.b("UnderlineLocal", g.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                p.k().d("线上书本地划线数据库迁移完成，userId:" + str + ", size: " + g.size() + ", duration: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        ReaderDBManager.v(userId).a(str);
        DBManager.obtainUnderlineCacheDao(userId).a(str);
    }

    public final int e(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            d(userId);
            com.dragon.read.local.db.d.a.a("UnderlineLocal", "query", true);
            return ReaderDBManager.v(userId).b(str);
        }
        com.dragon.read.local.db.d.a.a("UnderlineLocal", "query", false);
        return DBManager.obtainUnderlineCacheDao(userId).b(str);
    }

    public final int h(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            d(userId);
            com.dragon.read.local.db.d.a.a("UnderlineLocal", "query", true);
            return ReaderDBManager.v(userId).d(str);
        }
        com.dragon.read.local.db.d.a.a("UnderlineLocal", "query", false);
        return DBManager.obtainUnderlineCacheDao(userId).d(str);
    }

    public final void b(String userId, List<n1> list) {
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
            arrayList.add(new o1((n1) it2.next()));
        }
        DBManager.obtainUnderlineCacheDao(userId).c(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it4 = list.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new v0((n1) it4.next()));
        }
        ReaderDBManager.v(userId).c(arrayList2);
    }

    public final List<n1> g(String userId, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (ReaderDatabase.a.b().enable) {
            d(userId);
            com.dragon.read.local.db.d.a.a("UnderlineLocal", "query", true);
            p.k().d("访问saas数据库表：UnderlineLocal， method：queryUnderlineCacheData， bookId：" + str);
            List<v0> e = ReaderDBManager.v(userId).e(str);
            Intrinsics.checkNotNull(e, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineLocal>");
            return TypeIntrinsics.asMutableList(e);
        }
        com.dragon.read.local.db.d.a.a("UnderlineLocal", "query", false);
        p.k().d("访问业务数据库表：UnderlineLocal， method：queryUnderlineCacheData， bookId：" + str);
        List<o1> e2 = DBManager.obtainUnderlineCacheDao(userId).e(str);
        Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.UnderlineLocal>");
        return TypeIntrinsics.asMutableList(e2);
    }

    public final List<Long> c(String userId, List<n1> list) {
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
            d(userId);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(new o1((n1) it2.next()));
        }
        List<Long> f = DBManager.obtainUnderlineCacheDao(userId).f(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it4 = list.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new v0((n1) it4.next()));
        }
        List<Long> f2 = ReaderDBManager.v(userId).f(arrayList2);
        if (ReaderDatabase.a.b().enable) {
            Intrinsics.checkNotNull(f2);
            return f2;
        }
        Intrinsics.checkNotNull(f);
        return f;
    }
}
