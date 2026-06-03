package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import lr4.y0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c3 implements b3 {
    private final b3 a;

    static {
        Covode.recordClassIndex(611750);
    }

    public c3(b3 b3Var) {
        this.a = b3Var;
    }

    @Override // nr4.b3
    public y0.a d(Date date) {
        return this.a.d(date);
    }

    @Override // nr4.b3
    public void e(Date date) {
        this.a.e(date);
    }

    @Override // nr4.b3
    public Long[] c(lr4.y0... y0VarArr) {
        List b = com.dragon.read.local.db.e.b(y0VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.c((lr4.y0[]) ((List) it2.next()).toArray(new lr4.y0[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.b3
    public lr4.y0 a(Date date, String str) {
        return this.a.a(date, str);
    }

    @Override // nr4.b3
    public List<y0.a> b(Date date, Date date2) {
        return this.a.b(date, date2);
    }
}
