package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f3 implements e3 {
    public static final int b;
    private final e3 a;

    static {
        Covode.recordClassIndex(611753);
        b = 8;
    }

    @Override // nr4.e3
    public List<lr4.b1> a() {
        return this.a.a();
    }

    @Override // nr4.e3
    public lr4.b1 i() {
        return this.a.i();
    }

    public f3(e3 iRecentBookListenProgressDao) {
        Intrinsics.checkNotNullParameter(iRecentBookListenProgressDao, "iRecentBookListenProgressDao");
        this.a = iRecentBookListenProgressDao;
    }

    @Override // nr4.e3
    public lr4.b1 f(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return this.a.f(bookId);
    }

    @Override // nr4.e3
    public List<lr4.b1> g(List<String> bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        List<List<String>> a = com.dragon.read.local.db.e.a(bookIds);
        ArrayList arrayList = new ArrayList();
        for (List<String> list : a) {
            e3 e3Var = this.a;
            Intrinsics.checkNotNull(list);
            List<lr4.b1> g = e3Var.g(list);
            if (g != null) {
                arrayList.addAll(g);
            }
        }
        return arrayList;
    }

    @Override // nr4.j
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Long[] h(lr4.b1... bookProgresses) {
        Intrinsics.checkNotNullParameter(bookProgresses, "bookProgresses");
        List<List> b2 = com.dragon.read.local.db.e.b(Arrays.copyOf(bookProgresses, bookProgresses.length));
        ArrayList arrayList = new ArrayList();
        for (List list : b2) {
            e3 e3Var = this.a;
            Intrinsics.checkNotNull(list);
            lr4.b1[] b1VarArr = (lr4.b1[]) list.toArray(new lr4.b1[0]);
            Long[] h = e3Var.h(Arrays.copyOf(b1VarArr, b1VarArr.length));
            Collections.addAll(arrayList, Arrays.copyOf(h, h.length));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }
}
