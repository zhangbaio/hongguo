package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ListUtils;
import com.dragon.read.base.util.LogHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class z0 implements y0 {
    private LogHelper a = new LogHelper("IComicReadProgressRecordDaoImpl");
    private final y0 b;

    static {
        Covode.recordClassIndex(611684);
    }

    @Override // nr4.y0
    public List<lr4.w> c(List<String> list) {
        return this.b.c(list);
    }

    public z0(y0 y0Var) {
        this.b = y0Var;
    }

    @Override // nr4.y0
    public void a(List<lr4.w> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            try {
                this.b.a((List) it2.next());
            } catch (Throwable th) {
                this.a.e(th.getMessage(), new Object[0]);
            }
        }
    }

    @Override // nr4.y0
    public List<lr4.w> b(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(a)) {
            return arrayList;
        }
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            List<lr4.w> b = this.b.b((List) it2.next());
            if (!ListUtils.isEmpty(b)) {
                arrayList.addAll(b);
            }
        }
        return arrayList;
    }
}
