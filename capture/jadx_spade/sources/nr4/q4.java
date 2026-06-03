package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ListUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class q4 implements p4 {
    private final p4 a;

    static {
        Covode.recordClassIndex(611790);
    }

    @Override // nr4.p4
    public int c() {
        return this.a.c();
    }

    @Override // nr4.p4
    public List<lr4.m1> h() {
        return this.a.h();
    }

    public q4(p4 p4Var) {
        this.a = p4Var;
    }

    @Override // nr4.p4
    public lr4.m1 e(String str) {
        return this.a.e(str);
    }

    @Override // nr4.p4
    public int f(String str) {
        return this.a.f(str);
    }

    @Override // nr4.p4
    public List<lr4.a1> g(String str) {
        List<lr4.a1> g = this.a.g(str);
        if (!ListUtils.isEmpty(g)) {
            Collections.sort(g);
        }
        return g;
    }

    @Override // nr4.p4
    public Long[] a(lr4.l1... l1VarArr) {
        List b = com.dragon.read.local.db.e.b(l1VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.a((lr4.l1[]) ((List) it2.next()).toArray(new lr4.l1[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.p4
    public List<lr4.m1> b(String... strArr) {
        List b = com.dragon.read.local.db.e.b(strArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.b((String[]) ((List) it2.next()).toArray(new String[0])));
        }
        return arrayList;
    }

    @Override // nr4.p4
    public Long[] d(lr4.m1... m1VarArr) {
        List b = com.dragon.read.local.db.e.b(m1VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.d((lr4.m1[]) ((List) it2.next()).toArray(new lr4.m1[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.p4
    public int i(lr4.m1... m1VarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(m1VarArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.i((lr4.m1[]) ((List) it2.next()).toArray(new lr4.m1[0]));
        }
        return i;
    }
}
