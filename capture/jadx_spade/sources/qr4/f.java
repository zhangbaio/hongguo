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
import lr4.h0;
import lr4.i0;
import lr4.t0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final f a;

    static {
        Covode.recordClassIndex(611926);
        a = new f();
    }

    private f() {
    }

    private final void d() {
        c cVar = c.a;
        if (cVar.b("local_underline_migration", "0")) {
            p.k().d("本地书划线数据库已完成迁移，userId:0");
            return;
        }
        synchronized (this) {
            if (cVar.b("local_underline_migration", "0")) {
                p.k().d("本地书划线数据库已完成迁移，userId:0");
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            List<i0> g = DBManager.obtainLocalBookUnderlineDao().g();
            Intrinsics.checkNotNull(g);
            if (!g.isEmpty()) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(g, 10));
                for (i0 i0Var : g) {
                    Intrinsics.checkNotNull(i0Var);
                    arrayList.add(new t0(i0Var));
                }
                ReaderDBManager.s().f(arrayList);
                c.a.c("local_underline_migration", "0");
                com.dragon.read.local.db.d.a.b("LocalUnderline", g.size(), SystemClock.elapsedRealtime() - elapsedRealtime);
                p.k().d("本地书划线数据库迁移完成，userId:0, size: " + g.size() + ", duration: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        ReaderDBManager.s().a(bookId);
        DBManager.obtainLocalBookUnderlineDao().a(bookId);
    }

    public final int e(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            d();
            com.dragon.read.local.db.d.a.a("LocalUnderline", "query", true);
            return ReaderDBManager.s().b(bookId);
        }
        com.dragon.read.local.db.d.a.a("LocalUnderline", "query", false);
        return DBManager.obtainLocalBookUnderlineDao().b(bookId);
    }

    public final int g(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            d();
            com.dragon.read.local.db.d.a.a("LocalUnderline", "query", true);
            return ReaderDBManager.s().d(bookId);
        }
        com.dragon.read.local.db.d.a.a("LocalUnderline", "query", false);
        return DBManager.obtainLocalBookUnderlineDao().d(bookId);
    }

    public final void b(List<h0> underlines) {
        Intrinsics.checkNotNullParameter(underlines, "underlines");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(underlines, 10));
        Iterator<T> it2 = underlines.iterator();
        while (it2.hasNext()) {
            arrayList.add(new i0((h0) it2.next()));
        }
        DBManager.obtainLocalBookUnderlineDao().c(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(underlines, 10));
        Iterator<T> it4 = underlines.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new t0((h0) it4.next()));
        }
        ReaderDBManager.s().c(arrayList2);
    }

    public final List<Long> c(List<h0> underlines) {
        Intrinsics.checkNotNullParameter(underlines, "underlines");
        if (ReaderDatabase.a.b().enable) {
            d();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(underlines, 10));
        Iterator<T> it2 = underlines.iterator();
        while (it2.hasNext()) {
            arrayList.add(new i0((h0) it2.next()));
        }
        List<Long> f = DBManager.obtainLocalBookUnderlineDao().f(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(underlines, 10));
        Iterator<T> it4 = underlines.iterator();
        while (it4.hasNext()) {
            arrayList2.add(new t0((h0) it4.next()));
        }
        List<Long> f2 = ReaderDBManager.s().f(arrayList2);
        if (ReaderDatabase.a.b().enable) {
            Intrinsics.checkNotNull(f2);
            return f2;
        }
        Intrinsics.checkNotNull(f);
        return f;
    }

    public final List<h0> f(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (ReaderDatabase.a.b().enable) {
            d();
            com.dragon.read.local.db.d.a.a("LocalUnderline", "queryCache", true);
            p.k().d("访问saas数据库表：LocalUnderline, action:queryUnderlineCacheData");
            List<t0> e = ReaderDBManager.s().e(bookId);
            Intrinsics.checkNotNull(e, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.LocalBookUnderline>");
            return TypeIntrinsics.asMutableList(e);
        }
        com.dragon.read.local.db.d.a.a("LocalUnderline", "queryCache", false);
        p.k().d("访问业务数据库表：LocalBookUnderline, action:queryUnderlineCacheData");
        List<i0> e2 = DBManager.obtainLocalBookUnderlineDao().e(bookId);
        Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.dragon.read.local.db.entity.LocalBookUnderline>");
        return TypeIntrinsics.asMutableList(e2);
    }
}
