package nr4;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class z1 implements y1 {
    private y1 a;

    static {
        Covode.recordClassIndex(611711);
    }

    @Override // nr4.y1
    public List<lr4.l0> a() {
        return this.a.a();
    }

    @Override // nr4.y1
    public List<lr4.l0> b() {
        return this.a.b();
    }

    @Override // nr4.y1
    public List<lr4.l0> c() {
        return this.a.c();
    }

    public z1(y1 y1Var) {
        this.a = y1Var;
    }

    @Override // nr4.y1
    public void delete(String str) {
        this.a.delete(str);
    }

    @Override // nr4.y1
    public lr4.l0 query(String str) {
        return this.a.query(str);
    }

    @Override // nr4.y1
    public void delete(List<lr4.l0> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.delete((List<lr4.l0>) it2.next());
        }
    }

    @Override // nr4.y1
    public void insert(List<lr4.l0> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.insert((List) it2.next());
        }
    }
}
