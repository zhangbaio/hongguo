package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d0 implements c0 {
    private final c0 a;

    static {
        Covode.recordClassIndex(611660);
    }

    @Override // nr4.c0
    public List<lr4.m> f() {
        return this.a.f();
    }

    public d0(c0 c0Var) {
        this.a = c0Var;
    }

    @Override // nr4.c0
    public void a(String str) {
        this.a.a(str);
    }

    @Override // nr4.c0
    public int b(String str) {
        return this.a.b(str);
    }

    @Override // nr4.c0
    public List<lr4.m> e(String str) {
        return this.a.e(str);
    }

    @Override // nr4.c0
    public void c(List<lr4.m> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.c((List) it2.next());
        }
    }

    @Override // nr4.c0
    public List<Long> d(List<lr4.m> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.d((List) it2.next()));
        }
        return arrayList;
    }
}
