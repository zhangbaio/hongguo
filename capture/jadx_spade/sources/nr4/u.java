package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class u implements t {
    private final t a;

    static {
        Covode.recordClassIndex(611651);
    }

    @Override // nr4.t
    public List<lr4.g> f() {
        return this.a.f();
    }

    @Override // nr4.t
    public int getBookGroupCount() {
        return this.a.getBookGroupCount();
    }

    public u(t tVar) {
        this.a = tVar;
    }

    @Override // nr4.t
    public long d(lr4.g gVar) {
        return this.a.d(gVar);
    }

    @Override // nr4.t
    public lr4.g e(String str) {
        return this.a.e(str);
    }

    @Override // nr4.t
    public List<lr4.g> a(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.a((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.t
    public List<Long> b(lr4.g... gVarArr) {
        List b = com.dragon.read.local.db.e.b(gVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.b((lr4.g[]) ((List) it2.next()).toArray(new lr4.g[0])));
        }
        return arrayList;
    }

    @Override // nr4.t
    public int c(lr4.g... gVarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(gVarArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.c((lr4.g[]) ((List) it2.next()).toArray(new lr4.g[0]));
        }
        return i;
    }
}
