package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class z2 implements y2 {
    private final y2 a;

    static {
        Covode.recordClassIndex(611747);
    }

    public z2(y2 y2Var) {
        this.a = y2Var;
    }

    @Override // nr4.y2
    public lr4.x0 b(String str) {
        return this.a.b(str);
    }

    @Override // nr4.y2
    public Long[] a(lr4.x0... x0VarArr) {
        List b = com.dragon.read.local.db.e.b(x0VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.a((lr4.x0[]) ((List) it2.next()).toArray(new lr4.x0[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }
}
