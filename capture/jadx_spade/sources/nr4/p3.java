package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class p3 implements o3 {
    private final o3 a;

    static {
        Covode.recordClassIndex(611763);
    }

    @Override // nr4.o3
    public List<lr4.d1> c() {
        return this.a.c();
    }

    public p3(o3 o3Var) {
        this.a = o3Var;
    }

    @Override // nr4.o3
    public List<pr4.c> d(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.d((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.o3
    public List<lr4.d1> e(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.e((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.o3
    public List<pr4.b> g(List<String> list) {
        List a = com.dragon.read.local.db.e.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(this.a.g((List) it2.next()));
        }
        return arrayList;
    }

    @Override // nr4.o3
    public Long[] h(lr4.d1... d1VarArr) {
        List b = com.dragon.read.local.db.e.b(d1VarArr);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = b.iterator();
        while (it2.hasNext()) {
            Collections.addAll(arrayList, this.a.h((lr4.d1[]) ((List) it2.next()).toArray(new lr4.d1[0])));
        }
        return (Long[]) arrayList.toArray(new Long[0]);
    }

    @Override // nr4.o3
    public String b(String str, BookType bookType) {
        return this.a.b(str, bookType);
    }

    @Override // nr4.o3
    public String f(String str, BookType bookType) {
        return this.a.f(str, bookType);
    }
}
