package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class w4 implements v4 {
    private final v4 a;

    static {
        Covode.recordClassIndex(611796);
    }

    public w4(v4 v4Var) {
        this.a = v4Var;
    }

    @Override // nr4.v4
    public lr4.r1 a(String str) {
        return this.a.a(str);
    }

    @Override // nr4.v4
    public List<Long> b(lr4.r1... r1VarArr) {
        List b = com.dragon.read.local.db.e.b(r1VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.b((lr4.r1[]) ((List) it2.next()).toArray(new lr4.r1[0])));
        }
        return arrayList;
    }
}
