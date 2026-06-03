package nr4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e implements d {
    private final d a;

    static {
        Covode.recordClassIndex(611635);
    }

    @Override // nr4.d
    public List<lr4.b> b() {
        return this.a.b();
    }

    public e(d dVar) {
        this.a = dVar;
    }

    @Override // nr4.d
    public void deleteBook(String str) {
        this.a.deleteBook(str);
    }

    @Override // nr4.d
    public List<lr4.b> v(String str) {
        return this.a.v(str);
    }

    @Override // nr4.d
    public void delete(lr4.b... bVarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(bVarArr).iterator();
        while (it2.hasNext()) {
            this.a.delete((lr4.b[]) ((List) it2.next()).toArray(new lr4.b[0]));
        }
    }

    @Override // nr4.d
    public Long[] f(lr4.b... bVarArr) {
        List b = com.dragon.read.local.db.e.b(bVarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.f((lr4.b[]) ((List) it2.next()).toArray(new lr4.b[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.d
    public void c(String str, long j) {
        this.a.c(str, j);
    }

    @Override // nr4.d
    public void d(String str, long j) {
        this.a.d(str, j);
    }

    @Override // nr4.d
    public lr4.b e(String str, long j) {
        return this.a.e(str, j);
    }

    @Override // nr4.d
    public List<lr4.b> queryBookTone(String str, long j) {
        return this.a.queryBookTone(str, j);
    }
}
