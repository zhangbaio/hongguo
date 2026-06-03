package nr4;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s3 implements r3 {
    public static final int b;
    private final r3 a;

    static {
        Covode.recordClassIndex(611766);
        b = 8;
    }

    public s3(r3 dao) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.a = dao;
    }

    @Override // nr4.r3
    public List<lr4.e1> b(List<String> bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        return this.a.b(bookIds);
    }

    @Override // nr4.r3
    public long c(lr4.e1 relative) {
        Intrinsics.checkNotNullParameter(relative, "relative");
        return this.a.c(relative);
    }

    @Override // nr4.r3
    public lr4.e1 d(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return this.a.d(bookId);
    }

    @Override // nr4.r3
    public List<lr4.e1> e(List<String> bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        return this.a.e(bookIds);
    }

    @Override // nr4.r3
    public List<lr4.e1> a(List<String> bookIds) {
        List distinct;
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        if (bookIds.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        distinct = CollectionsKt___CollectionsKt.distinct(bookIds);
        if (distinct.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<List<String>> a = com.dragon.read.local.db.e.a(distinct);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (List<String> list : a) {
            Intrinsics.checkNotNull(list);
            Iterator<T> it2 = b(list).iterator();
            while (it2.hasNext()) {
                t3.b(linkedHashMap, (lr4.e1) it2.next());
            }
            Iterator<T> it4 = e(list).iterator();
            while (it4.hasNext()) {
                t3.b(linkedHashMap, (lr4.e1) it4.next());
            }
        }
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt___CollectionsKt.toList(values);
    }
}
