package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class l0 implements k0 {
    private final k0 a;

    static {
        Covode.recordClassIndex(611669);
    }

    public l0(k0 k0Var) {
        this.a = k0Var;
    }

    @Override // nr4.k0
    public void a(String str) {
        this.a.a(str);
    }

    @Override // nr4.k0
    public long b(String str) {
        return this.a.b(str);
    }

    @Override // nr4.k0
    public lr4.r e(String str) {
        return this.a.e(str);
    }

    @Override // nr4.k0
    public List<lr4.r> g(String str) {
        return this.a.g(str);
    }

    @Override // nr4.k0
    public List<lr4.r> c(String... strArr) {
        List b = com.dragon.read.local.db.e.b(strArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.c((String[]) ((List) it2.next()).toArray(new String[0])));
        }
        return arrayList;
    }

    @Override // nr4.k0
    public Long[] d(lr4.r... rVarArr) {
        List b = com.dragon.read.local.db.e.b(rVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.d((lr4.r[]) ((List) it2.next()).toArray(new lr4.r[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.k0
    public int f(lr4.r... rVarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(rVarArr).iterator();
        while (it2.hasNext()) {
            this.a.f((lr4.r[]) ((List) it2.next()).toArray(new lr4.r[0]));
        }
        return 0;
    }
}
