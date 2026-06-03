package nr4;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class z4 implements y4 {
    private final y4 a;

    static {
        Covode.recordClassIndex(611799);
    }

    @Override // nr4.y4
    public List<dv4.a> d() {
        return this.a.d();
    }

    @Override // nr4.y4
    public List<dv4.a> i() {
        return this.a.i();
    }

    public z4(y4 y4Var) {
        this.a = y4Var;
    }

    @Override // nr4.y4
    public void b(List<String> list) {
        this.a.b(list);
    }

    @Override // nr4.y4
    public dv4.a e(String str) {
        return this.a.e(str);
    }

    @Override // nr4.y4
    public void f(String str) {
        this.a.f(str);
    }

    @Override // nr4.y4
    public dv4.a h(long j) {
        return this.a.h(j);
    }

    @Override // nr4.y4
    public void k(dv4.a aVar) {
        this.a.k(aVar);
    }

    @Override // nr4.y4
    public void a(List<dv4.a> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.a((List) it2.next());
        }
    }

    @Override // nr4.y4
    public void c(List<dv4.a> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.c((List) it2.next());
        }
    }

    @Override // nr4.y4
    public void g(List<String> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.g((List) it2.next());
        }
    }

    @Override // nr4.y4
    public void j(dv4.a... aVarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(aVarArr).iterator();
        while (it2.hasNext()) {
            this.a.j((dv4.a[]) ((List) it2.next()).toArray(new dv4.a[0]));
        }
    }
}
