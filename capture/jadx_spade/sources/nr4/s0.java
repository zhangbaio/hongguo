package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s0 implements r0 {
    public static final int b;
    private final r0 a;

    static {
        Covode.recordClassIndex(611676);
        b = 8;
    }

    @Override // nr4.r0
    public List<lr4.u> a() {
        return this.a.a();
    }

    @Override // nr4.r0
    public List<lr4.u> e() {
        return this.a.e();
    }

    public s0(r0 iChapterReadProgressDao) {
        Intrinsics.checkNotNullParameter(iChapterReadProgressDao, "iChapterReadProgressDao");
        this.a = iChapterReadProgressDao;
    }

    @Override // nr4.r0
    public List<lr4.u> b(List<String> bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        List<List<String>> a = com.dragon.read.local.db.e.a(bookIds);
        ArrayList arrayList = new ArrayList();
        for (List<String> list : a) {
            r0 r0Var = this.a;
            Intrinsics.checkNotNull(list);
            arrayList.addAll(r0Var.b(list));
        }
        return arrayList;
    }

    @Override // nr4.r0
    public List<lr4.u> d(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        List<List<String>> b2 = com.dragon.read.local.db.e.b(bookId);
        ArrayList arrayList = new ArrayList();
        for (List<String> list : b2) {
            try {
                r0 r0Var = this.a;
                Intrinsics.checkNotNull(list);
                arrayList.addAll(r0Var.b(list));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // nr4.j
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Long[] h(lr4.u... bookProgresses) {
        Intrinsics.checkNotNullParameter(bookProgresses, "bookProgresses");
        List<List> b2 = com.dragon.read.local.db.e.b(Arrays.copyOf(bookProgresses, bookProgresses.length));
        ArrayList arrayList = new ArrayList();
        for (List list : b2) {
            r0 r0Var = this.a;
            Intrinsics.checkNotNull(list);
            lr4.u[] uVarArr = (lr4.u[]) list.toArray(new lr4.u[0]);
            Long[] h = r0Var.h(Arrays.copyOf(uVarArr, uVarArr.length));
            Collections.addAll(arrayList, Arrays.copyOf(h, h.length));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.r0
    public lr4.u c(String bookId, String chapterId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        return this.a.c(bookId, chapterId);
    }
}
