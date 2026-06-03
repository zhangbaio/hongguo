package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e4 implements w3<lr4.i1> {
    private final d4 a;

    static {
        Covode.recordClassIndex(611778);
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
    public List<lr4.i1> c() {
        return this.a.c();
    }

    @Override // nr4.v3
    public int d() {
        return this.a.d();
    }

    public e4(d4 d4Var) {
        this.a = d4Var;
    }

    @Override // nr4.v3
    public void e(int i) {
        this.a.e(i);
    }

    @Override // nr4.w3
    public void f(lr4.g1... g1VarArr) {
        k(s(g1VarArr));
    }

    @Override // nr4.w3
    public void m(lr4.g1... g1VarArr) {
        l(s(g1VarArr));
    }

    public Long[] k(lr4.i1... i1VarArr) {
        List b = com.dragon.read.local.db.e.b(i1VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.k((lr4.i1[]) ((List) it2.next()).toArray(new lr4.i1[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    public int l(lr4.i1... i1VarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(i1VarArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.l((lr4.i1[]) ((List) it2.next()).toArray(new lr4.i1[0]));
        }
        return i;
    }

    public lr4.i1[] s(lr4.g1... g1VarArr) {
        ArrayList arrayList = new ArrayList();
        for (lr4.g1 g1Var : g1VarArr) {
            arrayList.add(new lr4.i1(g1Var.a, g1Var.b));
        }
        return (lr4.i1[]) arrayList.toArray(new lr4.i1[0]);
    }
}
