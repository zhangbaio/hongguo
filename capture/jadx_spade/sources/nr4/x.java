package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class x implements w {
    private final w a;

    static {
        Covode.recordClassIndex(611654);
    }

    @Override // nr4.w
    public List<lr4.h> a() {
        return this.a.a();
    }

    public x(w wVar) {
        this.a = wVar;
    }

    @Override // nr4.w
    public List<lr4.h> b(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.b((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.w
    public Long[] c(lr4.h... hVarArr) {
        List b = com.dragon.read.local.db.e.b(hVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.c((lr4.h[]) ((List) it2.next()).toArray(new lr4.h[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }
}
