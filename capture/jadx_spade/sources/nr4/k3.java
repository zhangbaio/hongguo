package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k3 implements j3 {
    public static final int b;
    private final j3 a;

    static {
        Covode.recordClassIndex(611758);
        b = 8;
    }

    @Override // nr4.j3
    public List<lr4.c1> a() {
        return this.a.a();
    }

    public k3(j3 iRecentBookReadProgressDao) {
        Intrinsics.checkNotNullParameter(iRecentBookReadProgressDao, "iRecentBookReadProgressDao");
        this.a = iRecentBookReadProgressDao;
    }

    @Override // nr4.j3
    public lr4.c1 f(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return this.a.f(bookId);
    }

    @Override // nr4.j3
    public List<lr4.c1> g(List<String> bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        List<List<String>> a = com.dragon.read.local.db.e.a(bookIds);
        ArrayList arrayList = new ArrayList();
        for (List<String> list : a) {
            j3 j3Var = this.a;
            Intrinsics.checkNotNull(list);
            List<lr4.c1> g = j3Var.g(list);
            if (g != null) {
                arrayList.addAll(g);
            }
        }
        return arrayList;
    }

    @Override // nr4.j
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Long[] h(lr4.c1... bookProgresses) {
        Intrinsics.checkNotNullParameter(bookProgresses, "bookProgresses");
        List<List> b2 = com.dragon.read.local.db.e.b(Arrays.copyOf(bookProgresses, bookProgresses.length));
        ArrayList arrayList = new ArrayList();
        for (List list : b2) {
            j3 j3Var = this.a;
            Intrinsics.checkNotNull(list);
            lr4.c1[] c1VarArr = (lr4.c1[]) list.toArray(new lr4.c1[0]);
            Long[] h = j3Var.h(Arrays.copyOf(c1VarArr, c1VarArr.length));
            Collections.addAll(arrayList, Arrays.copyOf(h, h.length));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }
}
