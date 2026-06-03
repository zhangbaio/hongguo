package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class h4 implements w3<lr4.k1> {
    private final g4 a;

    static {
        Covode.recordClassIndex(611781);
    }

    @Override // nr4.v3
    public void a() {
        this.a.a();
    }

    @Override // nr4.v3
    public void b() {
        this.a.b();
    }

    @Override // nr4.v3
    public List<lr4.k1> c() {
        return this.a.c();
    }

    @Override // nr4.v3
    public int d() {
        return this.a.d();
    }

    public h4(g4 g4Var) {
        this.a = g4Var;
    }

    @Override // nr4.v3
    public void e(int i) {
        this.a.e(i);
    }

    @Override // nr4.w3
    public void f(lr4.g1... g1VarArr) {
        p(s(g1VarArr));
    }

    @Override // nr4.w3
    public void m(lr4.g1... g1VarArr) {
        i(s(g1VarArr));
    }

    public int i(lr4.k1... k1VarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(k1VarArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.i((lr4.k1[]) ((List) it2.next()).toArray(new lr4.k1[0]));
        }
        return i;
    }

    public Long[] p(lr4.k1... k1VarArr) {
        List b = com.dragon.read.local.db.e.b(k1VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.p((lr4.k1[]) ((List) it2.next()).toArray(new lr4.k1[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    public lr4.k1[] s(lr4.g1... g1VarArr) {
        ArrayList arrayList = new ArrayList();
        for (lr4.g1 g1Var : g1VarArr) {
            arrayList.add(new lr4.k1(g1Var.a, g1Var.b));
        }
        return (lr4.k1[]) arrayList.toArray(new lr4.k1[0]);
    }
}
