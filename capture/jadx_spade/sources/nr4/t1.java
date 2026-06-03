package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class t1 implements s1 {
    private final s1 a;

    static {
        Covode.recordClassIndex(611705);
    }

    @Override // nr4.s1
    public List<lr4.f0> f() {
        return this.a.f();
    }

    public t1(s1 s1Var) {
        this.a = s1Var;
    }

    @Override // nr4.s1
    public void a(String str) {
        this.a.a(str);
    }

    @Override // nr4.s1
    public int b(String str) {
        return this.a.b(str);
    }

    @Override // nr4.s1
    public List<lr4.f0> e(String str) {
        return this.a.e(str);
    }

    @Override // nr4.s1
    public void c(List<lr4.f0> list) {
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.c((List) it2.next());
        }
    }

    @Override // nr4.s1
    public List<Long> d(List<lr4.f0> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.d((List) it2.next()));
        }
        return arrayList;
    }
}
