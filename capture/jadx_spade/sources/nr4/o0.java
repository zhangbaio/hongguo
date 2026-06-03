package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o0 implements n0 {
    public static final int b;
    private final n0 a;

    static {
        Covode.recordClassIndex(611672);
        b = 8;
    }

    @Override // nr4.n0
    public List<lr4.t> a() {
        return this.a.a();
    }

    @Override // nr4.n0
    public List<lr4.t> e() {
        return this.a.e();
    }

    public o0(n0 iChapterlistenProgressDao) {
        Intrinsics.checkNotNullParameter(iChapterlistenProgressDao, "iChapterlistenProgressDao");
        this.a = iChapterlistenProgressDao;
    }

    @Override // nr4.n0
    public List<lr4.t> b(List<String> bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        List<List<String>> a = com.dragon.read.local.db.e.a(bookIds);
        ArrayList arrayList = new ArrayList();
        for (List<String> list : a) {
            n0 n0Var = this.a;
            Intrinsics.checkNotNull(list);
            arrayList.addAll(n0Var.b(list));
        }
        return arrayList;
    }

    @Override // nr4.n0
    public List<lr4.t> d(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        List<List<String>> b2 = com.dragon.read.local.db.e.b(bookId);
        ArrayList arrayList = new ArrayList();
        for (List<String> list : b2) {
            try {
                n0 n0Var = this.a;
                Intrinsics.checkNotNull(list);
                arrayList.addAll(n0Var.b(list));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // nr4.j
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Long[] h(lr4.t... bookProgresses) {
        Intrinsics.checkNotNullParameter(bookProgresses, "bookProgresses");
        List<List> b2 = com.dragon.read.local.db.e.b(Arrays.copyOf(bookProgresses, bookProgresses.length));
        ArrayList arrayList = new ArrayList();
        for (List list : b2) {
            n0 n0Var = this.a;
            Intrinsics.checkNotNull(list);
            lr4.t[] tVarArr = (lr4.t[]) list.toArray(new lr4.t[0]);
            Long[] h = n0Var.h(Arrays.copyOf(tVarArr, tVarArr.length));
            Collections.addAll(arrayList, Arrays.copyOf(h, h.length));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.n0
    public lr4.t c(String bookId, String chapterId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        return this.a.c(bookId, chapterId);
    }
}
