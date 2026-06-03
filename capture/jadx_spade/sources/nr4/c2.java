package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c2 implements b2 {
    public static final int b;
    private final b2 a;

    static {
        Covode.recordClassIndex(611714);
        b = 8;
    }

    public c2(b2 iReadChapterProgressUploadRecordDao) {
        Intrinsics.checkNotNullParameter(iReadChapterProgressUploadRecordDao, "iReadChapterProgressUploadRecordDao");
        this.a = iReadChapterProgressUploadRecordDao;
    }

    @Override // nr4.b2
    public Long[] a(lr4.m0... record) {
        Intrinsics.checkNotNullParameter(record, "record");
        List<List> b2 = com.dragon.read.local.db.e.b(Arrays.copyOf(record, record.length));
        ArrayList arrayList = new ArrayList();
        for (List list : b2) {
            b2 b2Var = this.a;
            Intrinsics.checkNotNull(list);
            lr4.m0[] m0VarArr = (lr4.m0[]) list.toArray(new lr4.m0[0]);
            Long[] a = b2Var.a((lr4.m0[]) Arrays.copyOf(m0VarArr, m0VarArr.length));
            Collections.addAll(arrayList, Arrays.copyOf(a, a.length));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }
}
