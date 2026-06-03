package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class h implements g {
    private final g a;

    static {
        Covode.recordClassIndex(611638);
    }

    @Override // nr4.g
    public List<lr4.c> b() {
        return this.a.b();
    }

    public h(g gVar) {
        this.a = gVar;
    }

    @Override // nr4.g
    public void deleteBook(String str) {
        this.a.deleteBook(str);
    }

    @Override // nr4.g
    public List<lr4.c> v(String str) {
        return this.a.v(str);
    }

    @Override // nr4.g
    public Long[] a(lr4.c... cVarArr) {
        List b = com.dragon.read.local.db.e.b(cVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.a((lr4.c[]) ((List) it2.next()).toArray(new lr4.c[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.g
    public void delete(lr4.c... cVarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(cVarArr).iterator();
        while (it2.hasNext()) {
            this.a.delete((lr4.c[]) ((List) it2.next()).toArray(new lr4.c[0]));
        }
    }

    @Override // nr4.g
    public void c(String str, long j) {
        this.a.c(str, j);
    }

    @Override // nr4.g
    public void d(String str, long j) {
        this.a.d(str, j);
    }

    @Override // nr4.g
    public lr4.c e(String str, long j) {
        return this.a.e(str, j);
    }

    @Override // nr4.g
    public List<lr4.c> queryBookTone(String str, long j) {
        return this.a.queryBookTone(str, j);
    }
}
