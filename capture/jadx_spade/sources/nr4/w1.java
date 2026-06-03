package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lr4.d0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class w1 implements v1 {
    private final v1 a;

    static {
        Covode.recordClassIndex(611708);
    }

    @Override // nr4.v1
    public List<lr4.d0> a() {
        return this.a.a();
    }

    @Override // nr4.v1
    public int e() {
        return this.a.e();
    }

    public w1(v1 v1Var) {
        this.a = v1Var;
    }

    @Override // nr4.v1
    public int b(d0.a aVar) {
        return this.a.b(aVar);
    }

    @Override // nr4.v1
    public List<lr4.d0> c(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.c((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.v1
    public Long[] d(lr4.d0... d0VarArr) {
        List b = com.dragon.read.local.db.e.b(d0VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.d((lr4.d0[]) ((List) it2.next()).toArray(new lr4.d0[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.v1
    public int delete(lr4.d0... d0VarArr) {
        Iterator it2 = com.dragon.read.local.db.e.b(d0VarArr).iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += this.a.delete((lr4.d0[]) ((List) it2.next()).toArray(new lr4.d0[0]));
        }
        return i;
    }

    @Override // nr4.v1
    public lr4.d0 f(String str, BookType bookType) {
        return this.a.f(str, bookType);
    }
}
