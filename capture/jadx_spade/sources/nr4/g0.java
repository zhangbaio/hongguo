package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g0 implements f0 {
    private final f0 a;

    static {
        Covode.recordClassIndex(611663);
    }

    @Override // nr4.f0
    public List<lr4.o> i() {
        return this.a.i();
    }

    @Override // nr4.f0
    public List<lr4.o> j() {
        return this.a.j();
    }

    public g0(f0 f0Var) {
        this.a = f0Var;
    }

    @Override // nr4.f0
    public void a(String str) {
        this.a.a(str);
    }

    @Override // nr4.f0
    public int b(String str) {
        return this.a.b(str);
    }

    @Override // nr4.f0
    public void d(String str) {
        this.a.d(str);
    }

    @Override // nr4.f0
    public List<lr4.o> e(String str) {
        return this.a.e(str);
    }

    @Override // nr4.f0
    public List<lr4.o> f(String str) {
        return this.a.f(str);
    }

    @Override // nr4.f0
    public void c(List<lr4.o> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.c((List) it2.next());
        }
    }

    @Override // nr4.f0
    public void h(List<lr4.o> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.h((List) it2.next());
        }
    }

    @Override // nr4.f0
    public List<Long> g(List<lr4.o> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.g((List) it2.next()));
        }
        return arrayList;
    }
}
